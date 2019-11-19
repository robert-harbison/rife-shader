package com.robertharbison.rifeshader.builder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.robertharbison.rifeshader.Shader;
import com.robertharbison.rifeshader.utils.ShaderUtils;

public class ShaderBuilder {

	private BuiltShaderData shaderData;

	public ShaderBuilder() {
		shaderData = new BuiltShaderData();
	}
	
	public void build(File file) {
		build(file, false);
	}

	/*
	 * Build shader.
	 */
	public void build(File file, boolean isInclude) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			processFile(reader, isInclude);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Process the file.
	 */
	// TODO: Add exception for when shader is not built due to error
	private void processFile(BufferedReader reader, boolean isInclude) throws IOException {
		StringBuilder shaderSource = new StringBuilder();

		String line;
		boolean inFile = false;
		int shaderType = -1;
		while ((line = reader.readLine()) != null) {
			// Get shader type.
			if (line.startsWith(ProcessorReference.TYPE_COMMAND)) {
				if (inFile == true) {
					shaderData.addShader(new Shader(shaderType, new StringBuilder(shaderSource)));
					inFile = false;
					shaderSource = new StringBuilder();
				}

				if (inFile == false) {
					inFile = true;
					shaderType = processType(line);
				}
				continue;
			}

			if (inFile) {
				// Include file.
				if (line.startsWith(ProcessorReference.REQUIRE_COMMAND)) {
					ShaderBuilder builder = new ShaderBuilder();
					String newPath = processRequire(line);
					if (newPath != null) {
						File newFile = new File(newPath);
						if (newFile.exists()) {
							builder.build(newFile);
							shaderSource.append(builder.getBuiltShaderData().getIncludeFile().getShaderSource());
						} else {
							// TODO: File does not exist shader exception
						}
					} else {
						break;
					}
					continue;
				} else {
					shaderSource.append(line).append("//\n");
				}
			}
		}

		// Deals with the end of file save
		if (inFile == true) {
			shaderData.addShader(new Shader(shaderType, new StringBuilder(shaderSource)));
			inFile = false;
			shaderSource = new StringBuilder();
		}
	}

	/*
	 * Process type line and return the shader type.
	 */
	private int processType(String line) {
		Pattern pattern = Pattern.compile("\"(.*?)\"");
		Matcher matcher = pattern.matcher(line);

		if (matcher.find()) {
			return ShaderUtils.getShaderTypeFromString(matcher.group(1));
		} else {
			// TODO: Add exception for invalid type.
			return -1;
		}
	}
	
	private String processRequire(String line) {
		Pattern pattern = Pattern.compile("\"(.*?)\"");
		Matcher matcher = pattern.matcher(line);

		if (matcher.find()) {
			return matcher.group(1);
		} else {
			// TODO: Add exception for invalid include.
			return null;
		}
	}

	/*
	 * @return BuiltShaderData Get the built shader data.
	 */
	public BuiltShaderData getBuiltShaderData() {
		return shaderData;
	}
}

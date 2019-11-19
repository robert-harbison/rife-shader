package com.robertharbison.rifeshader.builder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.robertharbison.rifeshader.ShaderFile;
import com.robertharbison.rifeshader.utils.ShaderBuildException;
import com.robertharbison.rifeshader.utils.ShaderBuilderUtils;

public class ShaderBuilder {

	private BuiltShaderData shaderData;

	public ShaderBuilder() {
		shaderData = new BuiltShaderData();
	}

	public void build(File file) throws IOException, ShaderBuildException {
		build(file, false);
	}

	/*
	 * Build shader.
	 */
	public void build(File file, boolean isInclude) throws IOException, ShaderBuildException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		processFile(file, reader, isInclude);
		reader.close();
	}

	/*
	 * Process the file.
	 */
	private void processFile(File origFile, BufferedReader reader, boolean isInclude)
			throws IOException, ShaderBuildException {
		StringBuilder shaderSource = new StringBuilder();

		String line;
		boolean inFile = false;
		int shaderType = -1;
		int lineNumber = 0;
		while ((line = reader.readLine()) != null) {
			lineNumber++;

			// Get shader type.
			if (line.startsWith(ProcessorReference.TYPE_COMMAND)) {
				if (inFile == true) {
					shaderData.addShader(new ShaderFile(shaderType, new StringBuilder(shaderSource)));
					inFile = false;
					shaderSource = new StringBuilder();
				}

				if (inFile == false) {
					inFile = true;
					shaderType = processType(line, origFile.getName(), lineNumber);
				}
				continue;
			}

			if (inFile) {
				// Require file.
				if (line.startsWith(ProcessorReference.REQUIRE_COMMAND)) {
					ShaderBuilder builder = new ShaderBuilder();
					String newPath = processRequire(line, origFile.getName(), lineNumber);
					if (newPath != null) {
						File newFile = new File(newPath);
						if (newFile.exists()) {
							builder.build(newFile);
							shaderSource.append(builder.getBuiltShaderData().getIncludeFile().getShaderSource());
						} else {
							throw new ShaderBuildException(origFile.getName(), lineNumber, "Required file not found.");
						}
					}
					continue;
				} else {
//					shaderSource.append(line).append("//\n");
					shaderSource.append(line).append("\n");
				}
			}
		}

		// Deals with the end of file save
		if (inFile == true) {
			shaderData.addShader(new ShaderFile(shaderType, new StringBuilder(shaderSource)));
			inFile = false;
			shaderSource = new StringBuilder();
		} else {
			throw new ShaderBuildException(origFile.getName(), "Type not set.");
		}
	}

	private int processType(String line, String fileName, int lineNumber) throws ShaderBuildException {
		Pattern pattern = Pattern.compile("\"(.*?)\"");
		Matcher matcher = pattern.matcher(line);

		if (matcher.find()) {
			int type = ShaderBuilderUtils.getShaderFileType(matcher.group(1));
			if (type == -1) {
				throw new ShaderBuildException(fileName, lineNumber, "Invalid type."); 
			}
			
			return type;
		} else {
			throw new ShaderBuildException(fileName, lineNumber, "Invalid type syntax.");
		}
	}

	private String processRequire(String line, String fileName, int lineNumber) throws ShaderBuildException {
		Pattern pattern = Pattern.compile("\"(.*?)\"");
		Matcher matcher = pattern.matcher(line);

		if (matcher.find()) {
			String path = matcher.group(1);
			if (path == null || path == "") {
				throw new ShaderBuildException(fileName, lineNumber, "Invalid require path."); 
			}
			return path;
		} else {
			throw new ShaderBuildException(fileName, lineNumber, "Invalid require syntax.");
		}
	}

	/*
	 * @return BuiltShaderData Get the built shader data.
	 */
	public BuiltShaderData getBuiltShaderData() {
		return shaderData;
	}
}

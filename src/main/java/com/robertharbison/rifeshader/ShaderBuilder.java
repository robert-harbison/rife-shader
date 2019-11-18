package com.robertharbison.rifeshader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.robertharbison.rifeshader.utils.ShaderUtils;

public class ShaderBuilder {

	/*
	 * Build shader.
	 */
	protected static void build(RifeShader shaderBuilder, File file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			processFile(shaderBuilder, reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Process the file.
	 */
	private static void processFile(RifeShader shaderBuilder, BufferedReader reader) throws IOException {
		StringBuilder shaderSource = new StringBuilder();

		String line;
		boolean inFile = false;
		int shaderType = -1;
		while ((line = reader.readLine()) != null) {
			if (line.startsWith(ProcessorReference.TYPE_COMMAND)) {
				if (inFile == true) {
					shaderBuilder.addShader(new Shader(shaderType, new StringBuilder(shaderSource)));
					inFile = false;
					shaderSource = new StringBuilder();
				}

				if (inFile == false) {
					inFile = true;
					shaderType = processType(line);
				}
			} else {
				if (inFile) {
					shaderSource.append(line).append("//\n");
				}
			}
		}
		
		// Deals with the end of file save
		if (inFile == true) {
			shaderBuilder.addShader(new Shader(shaderType, new StringBuilder(shaderSource)));
			inFile = false;
			shaderSource = new StringBuilder();
		}
	}

	/*
	 * Process type line and return the shader type.
	 */
	private static int processType(String line) {
		Pattern pattern = Pattern.compile("\"(.*?)\"");
		Matcher matcher = pattern.matcher(line);

		if (matcher.find()) {
			return ShaderUtils.getShaderTypeFromString(matcher.group(1));
		} else {
			return -1;
		}
	}
}

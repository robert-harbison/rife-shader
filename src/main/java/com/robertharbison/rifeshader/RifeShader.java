package com.robertharbison.rifeshader;

import java.io.File;

import com.robertharbison.rifeshader.builder.BuiltShaderData;
import com.robertharbison.rifeshader.builder.ShaderBuilder;

public class RifeShader {
	
	private File multipleShaderFile;
	private File vertexFile;
	private File geometryFile;
	private File fragmentFile;
	
	private ShaderBuilder shaderBuilder;
	
	// If the files are seprate or one large file.
	private boolean seperateFileShader;
	
	/*
	 * Compile a file with multiple shaders.
	 * 
	 * @param shaderFile The shader file.
	 */
	public RifeShader(File shaderFile) {
		this.multipleShaderFile = shaderFile;
		this.seperateFileShader = false;
		this.shaderBuilder = new ShaderBuilder();
	}
	
	/*
	 * Compile the shaders from seperate files. A shader can be null.
	 * 
	 * @param vertexFile The vertex shader file.
	 * @param geometryFile The geometry shader file.
	 * @param fragmentFile The fragment shader file.
	 */
	public RifeShader(File vertexFile, File geometryFile, File fragmentFile) {
		this.vertexFile = vertexFile;
		this.geometryFile = geometryFile;
		this.fragmentFile = fragmentFile;
		this.seperateFileShader = true;
		this.shaderBuilder = new ShaderBuilder();
	}
	
	/*
	 * Build the shaders.
	 */
	public void build() {
		if (seperateFileShader) {
			if (vertexFile != null) shaderBuilder.build(vertexFile);
			if (geometryFile != null) shaderBuilder.build(geometryFile);
			if (fragmentFile != null) shaderBuilder.build(fragmentFile);
		}  else {
			if (multipleShaderFile != null) shaderBuilder.build(multipleShaderFile);
		}
	}

	/*
	 * @return BuiltShaderData Get the built shader data.
	 */
	public BuiltShaderData getBuiltShaderData() {
		return shaderBuilder.getBuiltShaderData();
	}
}

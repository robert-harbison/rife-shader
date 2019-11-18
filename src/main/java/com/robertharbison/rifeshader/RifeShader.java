package com.robertharbison.rifeshader;

import java.io.File;

import com.robertharbison.rifeshader.utils.ShaderUtils;

public class RifeShader {
		
	private Shader vertexShader;
	private Shader geometryShader;
	private Shader fragmentShader;
	
	private File multipleShaderFile;
	private File vertexFile;
	private File geometryFile;
	private File fragmentFile;
	
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
	}
	
	/*
	 * Build the shaders.
	 */
	public void build() {
		if (seperateFileShader) {
			if (vertexFile != null) ShaderBuilder.build(this, vertexFile);
			if (geometryFile != null) ShaderBuilder.build(this, geometryFile);
			if (fragmentFile != null) ShaderBuilder.build(this, fragmentFile);
		}  else {
			if (multipleShaderFile != null) ShaderBuilder.build(this, multipleShaderFile);
		}
	}
	
	/*
	 * @return Shader The vertex shader. (Returns null if shader has not been built yet.)
	 */
	public Shader getVertexShader() {
		if (vertexShader == null) {
			System.out.println("Can not get vertex shader source. Has not been built.");
		}
		
		return vertexShader;
	}
	
	/*
	 * @return Shader The geometry shader. (Returns null if shader has not been built yet.)
	 */
	public Shader getGeometryShader() {
		if (geometryShader == null) {
			System.out.println("Can not get geometry shader source. Has not been built.");
		}
		
		return geometryShader;
	}
	
	/*
	 * @return Shader The fragment shader. (Returns null if shader has not been built yet.)
	 */
	public Shader getFragmentShader() {
		if (fragmentShader == null) {
			System.out.println("Can not get fragment shader source. Has not been built.");
		}
		
		return fragmentShader;
	}

	protected void addShader(Shader shader) {
		switch(shader.getType()) {
			case ShaderUtils.VERTEX_SHADER_TYPE: this.vertexShader = shader;
			case ShaderUtils.GEOMETRY_SHADER_TYPE: this.geometryShader = shader;
			case ShaderUtils.FRAGMENT_SHADER_TYPE: this.fragmentShader = shader;
		}
	}
}

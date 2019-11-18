package com.robertharbison.rifeshader.builder;

import java.io.File;

import com.robertharbison.rifeshader.Shader;
import com.robertharbison.rifeshader.utils.ShaderUtils;

public class RifeShaderBuilder {
	
	// TODO: A callback that can allow people to log errors
	
	private Shader vertexShader;
	private Shader geometryShader;
	private Shader fragmentShader;
	
	private File multipleShaderFile;
	private File vertexFile;
	private File geometryFile;
	private File fragmentFile;
	
	// If the files are seprate or one large file.
	private boolean seperateFileShader;
	
	// Compiles all the shaders from one file
	public RifeShaderBuilder(File shaderFile) {
		this.multipleShaderFile = shaderFile;
		this.seperateFileShader = false;
	}
	
	// Compile the shaders from different files. A shader can be null.
	public RifeShaderBuilder(File vertexFile, File geometryFile, File fragmentFile) {
		this.vertexFile = vertexFile;
		this.geometryFile = geometryFile;
		this.fragmentFile = fragmentFile;
		this.seperateFileShader = true;
	}
	
	public void build() {
		if (seperateFileShader) {
			ShaderBuilder.build(this, vertexFile);
			ShaderBuilder.build(this, geometryFile);
			ShaderBuilder.build(this, fragmentFile);
		}  else {
			ShaderBuilder.build(this, multipleShaderFile);
		}
	}
	
	public void compile() {
		
	}
	
	public Shader getVertexShader() {
		if (vertexShader == null) {
			System.out.println("Can not get shader source. Has not been built.");
		}
		
		return vertexShader;
	}
	
	public Shader getGeometryShader() {
		if (geometryShader == null) {
			System.out.println("Can not get shader source. Has not been built.");
		}
		
		return geometryShader;
	}
	
	public Shader getFragmentShader() {
		if (fragmentShader == null) {
			System.out.println("Can not get shader source. Has not been built.");
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

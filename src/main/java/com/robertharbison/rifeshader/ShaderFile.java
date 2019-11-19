package com.robertharbison.rifeshader;

/*
 * Holds data about a shader file. This is used for both include files and normal shaders.
 */
public class ShaderFile {

	private int type;
	private StringBuilder shaderSource;
	
	/*
	 * Create a new shader.
	 * 
	 * @param type The OpenGL shader type.
	 * @param shaderSource The shader source code.
	 */
	public ShaderFile(int type, StringBuilder shaderSource) {
		this.type = type;
		this.shaderSource = shaderSource;
	}

	/*
	 * @return int The shader file type.
	 */
	public int getType() {
		return type;
	}

	/*
	 * @return StringBuilder The shader source.
	 */
	public StringBuilder getShaderSource() {
		return shaderSource;
	}
}

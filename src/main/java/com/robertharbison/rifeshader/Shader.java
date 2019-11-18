package com.robertharbison.rifeshader;

/*
 * Holds data about a built shader.
 */
public class Shader {

	private int type;
	private StringBuilder shaderSource;
	
	/*
	 * Create a new shader.
	 * 
	 * @param type The OpenGL shader type.
	 * @param shaderSource The shader source code.
	 */
	public Shader(int type, StringBuilder shaderSource) {
		this.type = type;
		this.shaderSource = shaderSource;
	}

	/*
	 * @return int The OpenGL shader type.
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

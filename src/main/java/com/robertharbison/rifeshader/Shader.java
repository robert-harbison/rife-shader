package com.robertharbison.rifeshader;

public class Shader {

	private int type;
	private StringBuilder shaderSource;
	
	public Shader(int type, StringBuilder shaderSource) {
		this.type = type;
		this.shaderSource = shaderSource;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public StringBuilder getShaderSource() {
		return shaderSource;
	}

	public void setShaderSource(StringBuilder shaderSource) {
		this.shaderSource = shaderSource;
	}
}

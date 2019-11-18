package com.robertharbison.rifeshader;

import org.lwjgl.opengl.GL20;

public class Shader {

	private int type;
	private StringBuilder shaderSource;
	private int id;
	
	public Shader(int type, StringBuilder shaderSource) {
		this.type = type;
		this.shaderSource = shaderSource;
		this.id = -1;
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
	
	public void compile() {
		id = GL20.glCreateShader(type);
		GL20.glShaderSource(id, shaderSource);
		GL20.glCompileShader(id);

		// Checks the compile status and logs errors
		if (GL20.glGetShaderi(id, GL20.GL_COMPILE_STATUS) == GL20.GL_FALSE) {
			RuntimeException e = new RuntimeException(GL20.glGetShaderInfoLog(id, GL20.GL_INFO_LOG_LENGTH));
			e.printStackTrace();
		}
	}
	
	public int getId() {
		return id;
	}
	
	public void delete() {
		if (id != -1) {
			GL20.glDeleteShader(id);
		}
	}
}

package com.robertharbison.rifeshader.utils;

public class ShaderBuildException extends Exception {
	private static final long serialVersionUID = -3202816445589333626L;

	public ShaderBuildException(String message) {
		super(message);
	}
	
	public ShaderBuildException(String fileName, String message) {
		this("(In " + fileName + ") " + message);
	}
	
	public ShaderBuildException(String fileName, int lineNumber, String message) {
		this("(In " + fileName + " line " + lineNumber + ") " + message);
	}
}

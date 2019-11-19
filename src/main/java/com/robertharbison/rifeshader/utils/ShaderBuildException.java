package com.robertharbison.rifeshader.utils;

/*
 * Represents a exception in the shader files being built.
 */
public class ShaderBuildException extends Exception {
	private static final long serialVersionUID = -3202816445589333626L;

	private ShaderBuildException(String message) {
		super(message);
	}
	
	/*
	 * @param fileName The fileName of the shader this exception is in.
	 * @param message The message describing the error.
	 */
	public ShaderBuildException(String fileName, String message) {
		this("(In " + fileName + ") " + message);
	}
	
	/*
	 * @param fileName The fileName of the shader this exception is in.
	 * @param lineNumber The lineNumber that the error is on.
	 * @param message The message describing the error.
	 */
	public ShaderBuildException(String fileName, int lineNumber, String message) {
		this("(In " + fileName + " line " + lineNumber + ") " + message);
	}
}

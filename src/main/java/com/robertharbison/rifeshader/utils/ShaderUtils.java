package com.robertharbison.rifeshader.utils;

import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL32;

/*
 * Internal utilities.
 */
public class ShaderUtils {

	public static final int VERTEX_SHADER_TYPE = GL20.GL_VERTEX_SHADER;
	public static final int FRAGMENT_SHADER_TYPE = GL20.GL_FRAGMENT_SHADER;
	public static final int GEOMETRY_SHADER_TYPE = GL32.GL_GEOMETRY_SHADER;

	public static final String VERTEX_SHADER_NAME = "vertex";
	public static final String FRAGMENT_SHADER_NAME = "fragment";
	public static final String GEOMETRY_SHADER_NAME = "geometry";
	
	/*
	 * Get the OpenGL shader type from a shader name. Returns -1 if the name is a
	 * invalid shader type.
	 * 
	 * @param shaderName Shader name to convert to OpenGL type.
	 * @return int The OpenGL shader type.
	 */
	public static int getShaderTypeFromString(String shaderName) {
		switch (shaderName) {
		case VERTEX_SHADER_NAME:
			return VERTEX_SHADER_TYPE;
		case FRAGMENT_SHADER_NAME:
			return FRAGMENT_SHADER_TYPE;
		case GEOMETRY_SHADER_NAME:
			return GEOMETRY_SHADER_TYPE;
		default:
			return -1;
		}
	}

	/*
	 * Get the shader name from a OpenGL shader type. Returns null if the type is a
	 * invalid shader type.
	 * 
	 * @param shaderType OpenGL shader type to get the shader name from.
	 * @return String The shader name.
	 */
	public static String getShaderTypeFromOpenGL(int shaderType) {
		switch (shaderType) {
		case VERTEX_SHADER_TYPE:
			return VERTEX_SHADER_NAME;
		case FRAGMENT_SHADER_TYPE:
			return FRAGMENT_SHADER_NAME;
		case GEOMETRY_SHADER_TYPE:
			return GEOMETRY_SHADER_NAME;
		default:
			return null;
		}
	}
}

package com.robertharbison.rifeshader.utils;

import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL32;

/*
 * Internal utilities.
 */
public class ShaderBuilderUtils {

	public static final int VERTEX_SHADER_TYPE = GL20.GL_VERTEX_SHADER;
	public static final int FRAGMENT_SHADER_TYPE = GL20.GL_FRAGMENT_SHADER;
	public static final int GEOMETRY_SHADER_TYPE = GL32.GL_GEOMETRY_SHADER;
	public static final int INCLUDE_FILE_TYPE = -2;

	public static final String VERTEX_SHADER_NAME = "vertex";
	public static final String FRAGMENT_SHADER_NAME = "fragment";
	public static final String GEOMETRY_SHADER_NAME = "geometry";
	public static final String INCLUDE_FILE_NAME = "include";
	
	public static int getShaderFileType(String shaderName) {
		switch (shaderName) {
		case VERTEX_SHADER_NAME:
			return VERTEX_SHADER_TYPE;
		case FRAGMENT_SHADER_NAME:
			return FRAGMENT_SHADER_TYPE;
		case GEOMETRY_SHADER_NAME:
			return GEOMETRY_SHADER_TYPE;
		case INCLUDE_FILE_NAME:
			return INCLUDE_FILE_TYPE;
		default:
			return -1;
		}
	}

	public static String getShaderFileName(int shaderType) {
		switch (shaderType) {
		case VERTEX_SHADER_TYPE:
			return VERTEX_SHADER_NAME;
		case FRAGMENT_SHADER_TYPE:
			return FRAGMENT_SHADER_NAME;
		case GEOMETRY_SHADER_TYPE:
			return GEOMETRY_SHADER_NAME;
		case INCLUDE_FILE_TYPE:
			return INCLUDE_FILE_NAME;
		default:
			return null;
		}
	}
}

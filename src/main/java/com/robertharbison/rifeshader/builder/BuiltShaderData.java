package com.robertharbison.rifeshader.builder;

import com.robertharbison.rifeshader.Shader;
import com.robertharbison.rifeshader.utils.ShaderBuilderUtils;

public class BuiltShaderData {

	private Shader vertexShader;
	private Shader geometryShader;
	private Shader fragmentShader;
	private Shader includeFile;

	protected void addShader(Shader shader) {
		switch (shader.getType()) {
		case ShaderBuilderUtils.VERTEX_SHADER_TYPE:
			this.vertexShader = shader;
		case ShaderBuilderUtils.GEOMETRY_SHADER_TYPE:
			this.geometryShader = shader;
		case ShaderBuilderUtils.FRAGMENT_SHADER_TYPE:
			this.fragmentShader = shader;
		case ShaderBuilderUtils.INCLUDE_FILE_TYPE:
			this.includeFile = shader;
		}
	}

	/*
	 * @return Shader The vertex shader. (Returns null if shader has not been built
	 * yet.)
	 */
	public Shader getVertexShader() {
		return vertexShader;
	}

	/*
	 * @return Shader The geometry shader. (Returns null if shader has not been
	 * built yet.)
	 */
	public Shader getGeometryShader() {
		return geometryShader;
	}

	/*
	 * @return Shader The fragment shader. (Returns null if shader has not been
	 * built yet.)
	 */
	public Shader getFragmentShader() {
		return fragmentShader;
	}
	
	public Shader getIncludeFile() {
		return includeFile;
	}
}

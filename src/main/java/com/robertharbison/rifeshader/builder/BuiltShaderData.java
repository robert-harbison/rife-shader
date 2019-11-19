package com.robertharbison.rifeshader.builder;

import com.robertharbison.rifeshader.Shader;
import com.robertharbison.rifeshader.utils.ShaderUtils;

public class BuiltShaderData {

	private Shader vertexShader;
	private Shader geometryShader;
	private Shader fragmentShader;

	protected void addShader(Shader shader) {
		switch (shader.getType()) {
		case ShaderUtils.VERTEX_SHADER_TYPE:
			this.vertexShader = shader;
		case ShaderUtils.GEOMETRY_SHADER_TYPE:
			this.geometryShader = shader;
		case ShaderUtils.FRAGMENT_SHADER_TYPE:
			this.fragmentShader = shader;
		}
	}

	/*
	 * @return Shader The vertex shader. (Returns null if shader has not been built
	 * yet.)
	 */
	public Shader getVertexShader() {
		if (vertexShader == null) {
			System.out.println("Can not get vertex shader source. Has not been built.");
		}

		return vertexShader;
	}

	/*
	 * @return Shader The geometry shader. (Returns null if shader has not been
	 * built yet.)
	 */
	public Shader getGeometryShader() {
		if (geometryShader == null) {
			System.out.println("Can not get geometry shader source. Has not been built.");
		}

		return geometryShader;
	}

	/*
	 * @return Shader The fragment shader. (Returns null if shader has not been
	 * built yet.)
	 */
	public Shader getFragmentShader() {
		if (fragmentShader == null) {
			System.out.println("Can not get fragment shader source. Has not been built.");
		}

		return fragmentShader;
	}
}

package com.robertharbison.rifeshader.builder;

import java.util.HashMap;
import java.util.Map;

import com.robertharbison.rifeshader.ShaderFile;
import com.robertharbison.rifeshader.utils.ShaderBuilderUtils;

public class BuiltShaderData {

	private ShaderFile vertexShader;
	private ShaderFile geometryShader;
	private ShaderFile fragmentShader;
	private ShaderFile includeFile;
	private Map<String, String> macroMap;
	
	protected BuiltShaderData() {
		this.macroMap = new HashMap<String, String>();
	}
	
	// Macros should always be all uppercase
	public void addMacro(String name, String value) {
		this.macroMap.put(name.toUpperCase(), value);
	}

	protected void addShader(ShaderFile shader) {
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
	
	public boolean hasVertexShader() {
		return vertexShader != null;
	}
	
	public boolean hasGeometryShader() {
		return geometryShader != null;
	}
	
	public boolean hasFragmentShader() {
		return fragmentShader != null;
	}

	/*
	 * @return Shader The vertex shader. (Returns null if shader has not been built
	 * yet.)
	 */
	public ShaderFile getVertexShader() {
		return vertexShader;
	}

	/*
	 * @return Shader The geometry shader. (Returns null if shader has not been
	 * built yet.)
	 */
	public ShaderFile getGeometryShader() {
		return geometryShader;
	}

	/*
	 * @return Shader The fragment shader. (Returns null if shader has not been
	 * built yet.)
	 */
	public ShaderFile getFragmentShader() {
		return fragmentShader;
	}
	
	protected ShaderFile getIncludeFile() {
		return includeFile;
	}
	
	public Map<String, String> getMacros() {
		return macroMap;
	}
}

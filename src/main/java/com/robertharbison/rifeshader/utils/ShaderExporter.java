package com.robertharbison.rifeshader.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.robertharbison.rifeshader.builder.BuiltShaderData;

public class ShaderExporter {

	/*
	 * Exports shader to files.
	 * 
	 * @param exportPath The folder where you want export the files to.
	 * @param exportName The base name of the file to export.
	 * @param shaderData The built shader data for the shaders.
	 */
	public static void exportBuiltShaderToFiles(String exportPath, String exportName, BuiltShaderData shaderData) throws IOException {
		BufferedWriter bufferedReader;
		
		if (!exportPath.endsWith("/")) {
			exportPath += "/";
		}
		
		File directory = new File(exportPath);
	    if (! directory.exists()){
	        directory.mkdirs();
	    }
		
		if (shaderData.hasVertexShader()) {
			bufferedReader = new BufferedWriter(new FileWriter(new File(exportPath +  exportName + "Vertex.glsl")));
			bufferedReader.write(shaderData.getVertexShader().getShaderSource().toString());
			bufferedReader.flush();
			bufferedReader.close();
		}
		
		if (shaderData.hasGeometryShader()) {
			bufferedReader = new BufferedWriter(new FileWriter(new File(exportPath +  exportName + "Geometry.glsl")));
			bufferedReader.write(shaderData.getGeometryShader().getShaderSource().toString());
			bufferedReader.flush();
			bufferedReader.close();
		}
		
		if (shaderData.hasFragmentShader()) {
			bufferedReader = new BufferedWriter(new FileWriter(new File(exportPath +  exportName + "Fragment.glsl")));
			bufferedReader.write(shaderData.getFragmentShader().getShaderSource().toString());
			bufferedReader.flush();
			bufferedReader.close();
		}
	}
}

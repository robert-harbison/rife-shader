Rife Shader is a GLSL preprocessor built in Java.

**Warning: This library is in very early development and is not suited for production.**

## Features
- Write GLSL shaders in the same file.
- Supports Vertex, Geometry and Fragment shaders.
- Macros
	- Set macros from Java as well as GLSL.

## Coming Features
- Requiring files (In Progress).
- Command line tool to generate shader files.
- Support for compute shaders.

## How To Use
Writing Shaders In Single File:
GLSL:
```
// Use type to specify the type of shader. (Every shader requires this.)
#type "vertex"
#version 330

void main() {

}

#type "geometry"
#version 330

void main() {

}

#type "fragment"
#version 330

void main() {

}
```

Java:
```
// Build the shader.
RifeShader builder = new RifeShader(new File("res/testShader.glsl"));
builder.build();
	
// Get the built source of a shader type. Will return null if the shader file doesn't contain a type for that shader.
builder.getBuiltShaderData().getVertexShader().getShaderSource();
builder.getBuiltShaderData().getGeometryShader().getShaderSource();
builder.getBuiltShaderData().getFragmentShader().getShaderSource();
```

Writing Shaders In Seperate Files:
GLSL:
```
// Use type to specify the type of shader. (Every shader requires this.)
#type "vertex"
#version 330

void main() {

}
```

Java:
```
// Build the shader. If you don't have a type of shader the file can be null.
RifeShader builder = new RifeShader(new File("res/vertexShader.glsl"), null, new File("res/fragmentShader.glsl"));
builder.build();

builder.getBuiltShaderData().getVertexShader().getShaderSource();
builder.getBuiltShaderData().getFragmentShader().getShaderSource();
```

## Macros
You can create macros which will be replaced with code which can be defined in both Java or GLSL. Macro names should always be uppercase.

Defining Macros:

Create Macro In Java (This macro will replace SHADER_LOC with src):
```
// This should be called after creating your builder but before building your shader.
builder.getBuiltShaderData().addMacro("SHADER_LOC", "src");
```

Create a Macro in GLSL (Macros will be available anytime there used after defining them even between shaders):
```
#define SHADER_LOC "src"
```

Using a Macro (We are using the SHADER_LOC macro to require a file in that location):
```
// SHADER_LOC will be replaced with src so this will output like src/include2.glsl
#require "SHADER_LOC/include2.glsl"
```

## Exporting Files
You can export the built shader to files using the exportBuiltShaderToFiles method in the ShaderExporter class.

This method takes 3 parameters:
- The folder path to export the files to.
- The base name for the exported files. (If it's testShader then testShaderVertex.glsl, testShaderGeometry.glsl and testShaderFragment.glsl will be exported)
- The built shader data from the builder.

```
RifeShader builder = new RifeShader(new File("res/testShader.glsl"));
builder.build();
		
ShaderExporter.exportBuiltShaderToFiles("build/shaders", "testShader", builder.getBuiltShaderData());
```

## Exceptions
- ShaderBuildException - Thrown when there is a error in the shader that you are building.
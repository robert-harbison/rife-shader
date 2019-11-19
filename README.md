Rife Shader is a GLSL preprocessor for Java that I am building for a LWJGL3 game engine.

**Warning: This library is in very early development and is not suited for production.**

## Features
- Write GLSL shaders in the same file.
- Supports Vertex, Geometry and Fragment shaders.

## Coming Features
- Requiring files (In Progress).
- Macros
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

## Exceptions
- ShaderBuildException - Thrown when there is a error in the shader that you are building.
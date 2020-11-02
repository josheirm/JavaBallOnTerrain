#version 330

layout (location=0) in vec3 position;
layout (location=1) in vec2 texCoord;

out vec2 outTexCoord;

uniform mat4 modelViewMatrix;
uniform mat4 projectionMatrix;

void main()
{
    gl_Position = projectionMatrix * modelViewMatrix * vec4(position, 1.0);
    
    outTexCoord = texCoord * 40.0;
}
//
//
//layout (location=0) in vec3 position;
//layout (location=1) in vec2 texCoord;

//out vec2 outTexCoord;
//out vec4 vertexColor;

//uniform mat4 modelViewMatrix;
//uniform mat4 projectionMatrix;

//void main()
//{
//	vertexColor = vec4(0.5, 0.0,0.0, 1.0);
//    gl_Position = projectionMatrix * modelViewMatrix * vec4(position, 1.0);
//    outTexCoord = texCoord;
//}

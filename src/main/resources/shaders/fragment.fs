#version 330

//in  vec2 outTexCoord;
//out vec4 fragColor;

//uniform sampler2D texture_sampler;

//void main()
//{
//    fragColor = texture(texture_sampler, outTexCoord);
//}


in  vec2 outTexCoord;
in vec4 vertexColor;
out vec4 fragColor;

uniform sampler2D texture_sampler;

void main()
{
    fragColor = texture(texture_sampler, outTexCoord);
    fragColor = vertexColor;
}
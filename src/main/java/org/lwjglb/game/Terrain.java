package org.lwjglb.game;


import java.awt.image.BufferedImage;
import org.joml.Vector3f;
import org.joml.Vector2f;
import  org.joml.Math;
import java.awt.Point;
import java.awt.geom.Point2D;

public class Terrain {

	private static final float MAX_HEIGHT = 40;
	private static final float MAX_PIXEL_COLOUR = 256 * 256 * 256;
	
	public float findYValue(float angle)
	{
		float angleX = Math.toRadians(angle);
		float cos = Math.cos(angleX);
		return (cos);
	}
	
	public float findXValue(float angle)
	{
		float angleZ = Math.toRadians(angle);
		float sin = Math.sin(angleZ);
		return(sin);
	}
	
	
	/////////////Part of terrain class
	public float getHeight(int x, int z, BufferedImage image)
	{
		//image is 256 x 256, 32 bit png
		float height = image.getRGB(x, z);
		
		//MAX_PIXEL_COLOUR = 256 * 256 * 256
		//MAX_HEIGHT = 40
		height  += MAX_PIXEL_COLOUR/2f;
		height /= MAX_PIXEL_COLOUR/2f;
		height *= MAX_HEIGHT;
		
		
		//if(height > .5)
		//{
		//	height = .5F;
		//}
		//else if (height < -20)
		//{
		//	height = -20;
		//}
		//height = height / 2f;
		//return 20;
		
		return height;
		//return(0);
		}
	
	public static float barryCentric(Vector3f p1, Vector3f p2, Vector3f p3, Vector2f pos) {
		float det = (p2.z - p3.z) * (p1.x - p3.x) + (p3.x - p2.x) * (p1.z - p3.z);
		float l1 = ((p2.z - p3.z) * (pos.x - p3.x) + (p3.x - p2.x) * (pos.y - p3.z)) / det;
		float l2 = ((p3.z - p1.z) * (pos.x - p3.x) + (p1.x - p3.x) * (pos.y - p3.z)) / det;
		float l3 = 1.0f - l1 - l2;
		return l1 * p1.y + l2 * p2.y + l3 * p3.y;
	}


	
	
	
	
	public float getTheHeight(float worldX, float worldZ, float xOfGrid, float zOfGrid , float [][]theHeights)
	{
		float answer = 0;
		//world coordinates not used yet
		float terrainX = worldX - xOfGrid;
		float terrainZ = worldZ - zOfGrid;
		//gridsquaresize = grid size / vertex - 1
		//180 / 79 = 2.278f
		//float gridSquareSize = .5504f;  
		
		float gridSquareSize = 6.299f;  
		
		int gridX = (int) Math.floor(terrainX/gridSquareSize);
		int gridZ = (int) Math.floor(terrainZ/gridSquareSize);
		
		
		if(gridX == 4 && gridZ == 6)
		{
			
			int test = 0;
			
		}
		float xCoord = (terrainX % gridSquareSize)/gridSquareSize;
		float zCoord = (terrainZ % gridSquareSize)/gridSquareSize;
		
		if (xCoord <= (1-zCoord))
		{
			
			//theHeights[gridX ][gridZ] = 0;
			//theHeights[gridX + 1][gridZ]= 0;
			//theHeights[gridX][gridZ+1];
			
			answer = barryCentric(new Vector3f(0, theHeights[gridX][gridZ], 0), new Vector3f(1,
					theHeights[gridX + 1][gridZ], 0), new Vector3f(0,
					theHeights[gridX][gridZ + 1], 1), new Vector2f(xCoord, zCoord));
		}else
		{
			answer = barryCentric(new Vector3f(1, theHeights[gridX + 1][gridZ], 0), new Vector3f(1,
					theHeights[gridX + 1][gridZ + 1], 1), new Vector3f(0,
					theHeights[gridX][gridZ + 1], 1), new Vector2f(xCoord, zCoord));
		}
		
    	
		return(answer);
	}
	/////////////
	
}

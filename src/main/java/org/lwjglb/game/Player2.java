package org.lwjglb.game;

import org.joml.Vector3f;


public class Player2{
	
	public float theta;
	public float angleAroundPlayer;
    
	public  Vector3f position = new Vector3f(0,0,0);
    
    public Vector3f rotation = new Vector3f(0,0,0);
    

    public Player2()
    {
    	theta = 20;
    	angleAroundPlayer = 0;
    	rotation.x = 0;
    	rotation.y = 10;
    	rotation.z = 0;
    	
    }
	public Vector3f getPosition() {
        return position;
    }
	
	public Vector3f getRotation() {
		
        return rotation;
    }
	
	
	
	public void setRotation(float x, float y, float z) {
        rotation.x = x;
        rotation.y = y;
        rotation.z = z;
    }
	public void setPosition(float x, float y, float z) {
        position.x = x;
        position.y = y;
        position.z = z;
    }
    
	
	
}



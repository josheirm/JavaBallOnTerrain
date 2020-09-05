package org.lwjglb.engine.graph;

import org.joml.Vector2f;
import org.joml.Vector3f;
import org.lwjglb.game.Player2;
import org.lwjglb.engine.MouseInput;

public class Camera {

	
	float verticalAngle = 0;
	float horizontalAngle = 0;
	float distance = 2;
	
	
	Player2 player;
    public  Vector3f position;
    public Vector3f rotation;
    int pitch;
    public int distanceFromPlayer;
    Vector3f position3  = new Vector3f();
    Vector3f position2  = new Vector3f();
    Vector3f position1  = new Vector3f();
    //float theta;
    //float angleAroundPlayer;
    
    public Camera(Player2 player) {
    	this.player = player;
        position = new Vector3f();
        //position.z = 60;
        rotation = new Vector3f();
        pitch = 20;
        distanceFromPlayer = 0;
        //setPosition(10,10, -100);
        
    }
    
    public Camera(Vector3f position, Vector3f rotation) {
        this.position = position;
        this.rotation = rotation;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(float x, float y, float z) {
        position.x = x;
        position.y = y;
        position.z = z;
    }
    
    public void movePosition(float offsetX, float offsetY, float offsetZ) {
        if ( offsetZ != 0 ) {
            position.x += (float)Math.sin(Math.toRadians(rotation.y)) * -1.0f * offsetZ;
            position.z += (float)Math.cos(Math.toRadians(rotation.y)) * offsetZ;
        }
        if ( offsetX != 0) {
            position.x += (float)Math.sin(Math.toRadians(rotation.y - 90)) * -1.0f * offsetX;
            position.z += (float)Math.cos(Math.toRadians(rotation.y - 90)) * offsetX;
        }
        position.y += offsetY;
    }

    public Vector3f getRotation() {
        return rotation;
    }
    
    public void setRotation(float x, float y, float z) {
        rotation.x = x;
        rotation.y = y;
        rotation.z = z;
    }

    public void setRotationZ()
	{
		rotation.z = 180 - player.getRotation().y + player.angleAroundPlayer;
	}
	
    
    public void moveRotation(float offsetX, double d, double e) {
        rotation.x += offsetX;
        rotation.y += d;
        rotation.z += e;
    }
    

    public void update(Vector3f object, MouseInput mouseInput) {
    	
    	
    	
//		newMouseX = Input.getMouseX();
//		newMouseY = Input.getMouseY();
//
//		float dx = (float) (newMouseX - oldMouseX);
//		float dy = (float) (newMouseY - oldMouseY);
//
//		if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_LEFT)) {
//			verticalAngle -= dy * mouseSensitivity;
//			horizontalAngle += dx * mouseSensitivity;
//		}
//		if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_RIGHT)) {
//			if (distance > 0) {
//				distance += dy * mouseSensitivity / 4;
//			} else {
//				distance = 0.1f;
//			}
//		}

    	
    	//verticalAngle -= .03;// * mouseSensitivity;
		//horizontalAngle += .03;// * mouseSensitivity;
    	
		
		
		//zoom
		//if(distance > 0)
		//{
		//	distance += .03;
		//}
		//else
			
    	
    	
    	if (mouseInput.isRightButtonPressed()) {
            Vector2f rotVec = mouseInput.getDisplVec();
            //camera.moveRotation(rotVec.x * MOUSE_SENSITIVITY, rotVec.y * MOUSE_SENSITIVITY, 0);
        
          if(distance > 0)
    		{
    			distance += rotVec.y * 0.3;
    		}
    		else
    		{
    			distance = 0.1f;
    		}
    	
    	}
    	else if (mouseInput.isLeftButtonPressed()) {
            Vector2f rotVec = mouseInput.getDisplVec();
            //camera.moveRotation(rotVec.x * MOUSE_SENSITIVITY, rotVec.y * MOUSE_SENSITIVITY, 0);
            verticalAngle -= rotVec.x * 1;//.05 / 4;
            horizontalAngle += rotVec.y;// * .05 / 4;
            if (verticalAngle <  0)
            {
            	verticalAngle = 360;
            }
            if (horizontalAngle > 360)
            {
            	horizontalAngle = 0;
            }
    	
    	}
    	
		
		//vertical angle is x value of rotation
		//verticalAngle = 20;
		float horizontalDistance = (float) (distance * Math.cos(Math.toRadians(verticalAngle)));
		float verticalDistance = (float) (distance * Math.sin(Math.toRadians(verticalAngle)));

		float xOffset = (float) (horizontalDistance * Math.sin(Math.toRadians(-horizontalAngle)));
		float zOffset = (float) (horizontalDistance * Math.cos(Math.toRadians(-horizontalAngle)));

		//position.set(object.getPosition().getX() + xOffset, object.getPosition().getY() - verticalDistance, object.getPosition().getZ() + zOffset);
		
		position.set(object.x + xOffset, object.y - verticalDistance, object.z + zOffset);

		rotation.set(verticalAngle, -horizontalAngle, 0);

		
		
		
		//oldMouseX = newMouseX;
		//oldMouseY = newMouseY;
	}
}
    
    
//    public Vector3f calculateCameraPosition(){
//    	
//    	
//    	float positionXcopy = position.x;
//    	float positionYcopy = position.y;
//    	float positionZcopy = position.z;
//    	
//    	float horizDistance = calculateHorizontalPosition();
//    	float verticalDistance = calculateVerticalPosition();
//    	
//    	//Vector3f vectorY = null;
//    	//vectorY.x = 0;
//    	//vectorY.y = 0;
//    	//vectorY.z = 0;
//    	
//    	position1 = player.getRotation();
//    	float offsetY = position1.y;
//    	
//    	player.theta = offsetY + player.angleAroundPlayer;
//    	float offsetX = (float) (horizDistance * Math.sin(Math.toRadians(player.theta)));
//    	float offsetZ = (float) (horizDistance * Math.cos(Math.toRadians(player.theta)));
//    	
//    	//cameras position
//    	position.x = player.getPosition().x - offsetX;
//    	position.z = player.getPosition().z - offsetZ;
//    	position.y = player.getPosition().y + verticalDistance;
//    	
//    	//Vector3f position2 = null;
//    	
//    	
//    	
//    	float positionChangeX = 0;
//    	float positionChangeY = 0;
//    	float positionChangeZ = 0;
//    	positionChangeX = positionXcopy  - position.x;
//    	positionChangeY = positionYcopy  - position.y;
//    	positionChangeZ = positionZcopy  + position.z;
//    	
//    	position3.x = 1.1f;//positionChangeX;
//    	position3.y = 0;//positionChangeY;
//    	position3.z = 0;//positionChangeZ;
//    	
//    	return(position);
//    }
//    
//    public float calculateHorizontalPosition()
//    {
//    	return (float) (distanceFromPlayer * Math.cos(Math.toRadians(pitch)));
//    }
//    public float calculateVerticalPosition()
//    {
//    	return (float) (distanceFromPlayer * Math.sin(Math.toRadians(pitch)));
//    }
//    
//    
//    
//    //.03
//    public void changeAngleAroundPlayer(double d)
//    {
//    	
//    		double angleChange = d;
//    		player.angleAroundPlayer -= angleChange;
//    	}
//    }
//    
    
    
   
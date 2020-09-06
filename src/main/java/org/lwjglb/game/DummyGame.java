package org.lwjglb.game;

import  org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL32;

//import static org.lwjgl.opengl.GL20.*;

import org.joml.Vector3f;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import org.lwjglb.engine.GameItem;
import org.lwjglb.engine.IGameLogic;
import org.lwjglb.engine.MouseInput;
import org.lwjglb.engine.Window;
import org.lwjglb.engine.graph.Camera;
import org.lwjglb.engine.graph.Mesh;
import org.lwjglb.engine.graph.Texture;



public class DummyGame implements IGameLogic {

	//glMatrixMode(GL_MODELVIEW);
	
	private static final float SIZE = 800;
	private static final int VERTEX_COUNT = 128;
	
	private float x;
	private float z;
	
	
	float gZ = 0;
	float gZForAdvance = 0;
	float gRot = 0;
	
    private static final float MOUSE_SENSITIVITY = 0.2f;

    //GameItem gameItem5 = new GameItem(mesh);
    
    
    //josh, this was final..
    public Vector3f cameraInc;

    public Player2 player;
    private final Renderer renderer;

    public Camera camera;

    private GameItem[] gameItems;

    private static final float CAMERA_POS_STEP = 0.05f;

    public DummyGame() {
    	player = new Player2();
        renderer = new Renderer();
        camera = new Camera(player);
        cameraInc = new Vector3f();
    }

    @Override
    public void init(Window window) throws Exception {
        renderer.init(window);
        
        System.out.println("OpenGL version: " + GL11.glGetString(GL11.GL_VERSION));

//        GL.createCapabilities();
        
        //gameItem5
        
        
        //generateTerrain(Loader loader){
    		
           camera.setPosition(0, 1,0);
    		
    		//////////////////
        
        // Create the Mesh
        float[] positions = new float[]{
            // V0
            -0.5f, 0.5f, 0.5f,
            // V1
            -0.5f, -0.5f, 0.5f,
            // V2
            0.5f, -0.5f, 0.5f,
            // V3
            0.5f, 0.5f, 0.5f,
            // V4
            -0.5f, 0.5f, -0.5f,
            // V5
            0.5f, 0.5f, -0.5f,
            // V6
            -0.5f, -0.5f, -0.5f,
            // V7
            0.5f, -0.5f, -0.5f,
            // For text coords in top face
            // V8: V4 repeated
            -0.5f, 0.5f, -0.5f,
            // V9: V5 repeated
            0.5f, 0.5f, -0.5f,
            // V10: V0 repeated
            -0.5f, 0.5f, 0.5f,
            // V11: V3 repeated
            0.5f, 0.5f, 0.5f,
            // For text coords in right face
            // V12: V3 repeated
            0.5f, 0.5f, 0.5f,
            // V13: V2 repeated
            0.5f, -0.5f, 0.5f,
            // For text coords in left face
            // V14: V0 repeated
            -0.5f, 0.5f, 0.5f,
            // V15: V1 repeated
            -0.5f, -0.5f, 0.5f,
            // For text coords in bottom face
            // V16: V6 repeated
            -0.5f, -0.5f, -0.5f,
            // V17: V7 repeated
            0.5f, -0.5f, -0.5f,
            // V18: V1 repeated
            -0.5f, -0.5f, 0.5f,
            // V19: V2 repeated
            0.5f, -0.5f, 0.5f,};
        float[] textCoords = new float[]{
            0.0f, 0.0f,
            0.0f, 0.5f,
            0.5f, 0.5f,
            0.5f, 0.0f,
            0.0f, 0.0f,
            0.5f, 0.0f,
            0.0f, 0.5f,
            0.5f, 0.5f,
            // For text coords in top face
            0.0f, 0.5f,
            0.5f, 0.5f,
            0.0f, 1.0f,
            0.5f, 1.0f,
            // For text coords in right face
            0.0f, 0.0f,
            0.0f, 0.5f,
            // For text coords in left face
            0.5f, 0.0f,
            0.5f, 0.5f,
            // For text coords in bottom face
            0.5f, 0.0f,
            1.0f, 0.0f,
            0.5f, 0.5f,
            1.0f, 0.5f,};
        int[] indices = new int[]{
            // Front face
            0, 1, 3, 3, 1, 2,
            // Top Face
            8, 10, 11, 9, 8, 11,
            // Right face
            12, 13, 7, 5, 12, 7,
            // Left face
            14, 15, 6, 4, 14, 6,
            // Bottom face
            16, 18, 19, 17, 16, 19,
            // Back face
            4, 6, 7, 5, 4, 7,};
        
        
        
        
        Texture texture = new Texture("textures/grassblock.png");
        Mesh mesh = new Mesh(positions, textCoords, indices, texture);
        
        //ball
        GameItem gameItem1 = new GameItem(mesh);
        
        
//        gameItem1.setScale(0.5f);
//        gameItem1.setPosition(0.5f, 0.5f, -5);
//        GameItem gameItem2 = new GameItem(mesh);
//        gameItem2.setScale(0.5f);
//        gameItem2.setPosition(0.5f, 0.5f, -5);
//       
//        //glPushMatrix();
//        
//        GameItem gameItem3 = new GameItem(mesh);
//        gameItem3.setScale(0.5f);
//        gameItem3.setPosition(0, 0, -5);
//        GameItem gameItem4 = new GameItem(mesh);
//        gameItem4.setScale(0.5f);
//        gameItem4.setPosition(0.5f, 0, -5);
//        
//        GameItem gameItem5 = new GameItem(mesh);
//        gameItem5.setScale(0.5f);
//        gameItem5.setPosition(0, 0, -10);
//      
        //ball
        gameItem1.setScale(0.5f);
        gameItem1.setPosition(0, 0, -5);
        
        
        GameItem gameItem2 = new GameItem(mesh);
        gameItem2.setScale(0.5f);
        gameItem2.setPosition(0.0f, 0.25f, -10);
       
        //glPushMatrix();
        
        GameItem gameItem3 = new GameItem(mesh);
        gameItem3.setScale(0.5f);
        gameItem3.setPosition(5, 0.25f, -10);
        GameItem gameItem4 = new GameItem(mesh);
        gameItem4.setScale(0.5f);
        gameItem4.setPosition(-5f, 0.25f, -10);
        
        //GameItem gameItem5 = new GameItem(mesh);
        //gameItem5.setScale(0.5f);
        //gameItem5.setPosition(0, 0, -10);
        
     //ball
//     gameItems[0].setRotation(0, 0, 0);
//     gameItems[0].setPosition(0, 0, -5);
//      	 
//     gameItems[1].setRotation(0, 0, 0);
//   	 gameItems[1].setPosition(0, 0, -10);
//   	 
//   	 gameItems[2].setRotation(0, 0, 0);
//   	 gameItems[2].setPosition(5f, 0, -10);
//   	 
//   	 gameItems[3].setRotation(0, 0, 0);
//   	 gameItems[3].setPosition(-5f, 0, -10);
//   	 
   	 
        ////////////
        int count = VERTEX_COUNT * VERTEX_COUNT;
		float[] vertices = new float[count * 3];
		//float[] normals = new float[count * 3];
		float[] textureCoords = new float[count*2];
		int[] indices2 = new int[6*(VERTEX_COUNT-1)*(VERTEX_COUNT-1)];
		int vertexPointer = 0;
		for(int i=0;i<VERTEX_COUNT;i++){
			for(int j=0;j<VERTEX_COUNT;j++){
				vertices[vertexPointer*3] = (float)j/((float)VERTEX_COUNT - 1) * SIZE;
				vertices[vertexPointer*3+1] = 0;
				vertices[vertexPointer*3+2] = (float)i/((float)VERTEX_COUNT - 1) * SIZE;
				//normals[vertexPointer*3] = 0;
				//normals[vertexPointer*3+1] = 1;
				//normals[vertexPointer*3+2] = 0;
				textureCoords[vertexPointer*2] = (float)j/((float)VERTEX_COUNT - 1);
				textureCoords[vertexPointer*2+1] = (float)i/((float)VERTEX_COUNT - 1);
				vertexPointer++;
			}
		}
		int pointer = 0;
		for(int gz=0;gz<VERTEX_COUNT-1;gz++){
			for(int gx=0;gx<VERTEX_COUNT-1;gx++){
				int topLeft = (gz*VERTEX_COUNT)+gx;
				int topRight = topLeft + 1;
				int bottomLeft = ((gz+1)*VERTEX_COUNT)+gx;
				int bottomRight = bottomLeft + 1;
				indices2[pointer++] = topLeft;
				indices2[pointer++] = bottomLeft;
				indices2[pointer++] = topRight;
				indices2[pointer++] = topRight;
				indices2[pointer++] = bottomLeft;
				indices2[pointer++] = bottomRight;
			}
		}
    
		Texture texture2 = new Texture("textures/grassblock.png");
        // Mesh mesh = new Mesh(positions, textCoords, indices, texture);
		Mesh mesh2 = new Mesh(vertices, textureCoords, indices2, texture2);
        
       
        GameItem gameItem5 = new GameItem(mesh2);
        gameItem5.setScale(0.005f);
        gameItem5.setPosition(-2.56f + .5f,0,-10);
		
        ////////////
        
        
        gameItems = new GameItem[]{gameItem1,gameItem2, gameItem3, gameItem4, gameItem5};
    }

    @Override
    public void input(Window window, MouseInput mouseInput) {
      
    	double sizeOfTerrain = 1024 * .005;
    	//camera.setPosition(0, 1, 10);
    	cameraInc.set(0, -0, 0);
    	//camera.setPosition(0, -10, 0);	
    	//GL32.glGetUniformLocation(1, "a");
    	//forward
    	
    	
    	if (window.isKeyPressed(GLFW_KEY_V)) {
    		
    		gRot += .1;
    		cameraInc.set(-5, 0 + gRot, -10);
    		gameItems[4].getPosition();//0, -10, 0);
    			   		
    		}
    	
    	if (window.isKeyPressed(GLFW_KEY_B)) {
    		gRot -= .1;
    		cameraInc.set(-5, -5 - gRot, 0);
    	}
    	
    	 if (window.isKeyPressed(GLFW_KEY_U)) {
	    	 gZ += .3;
	    	 //camera.setPosition(0, 0, -5);	
	    	 camera.setRotation(0, gZ, 0);
	    	 camera.setPosition(0, 0, -1);	 
	    	 gameItems[1].setPosition(0, 0, -10);
	    	 gameItems[0].setPosition(0, 0, -10);
	    	 
    	 //camera.setRotation(0, -gZ, 0);
    	 //uugameItems[4].setPosition(0, 0, -2.5f);
    	 
    	 
    	 
    	 //camera.update(gameItems[4].getPosition(), mouseInput);
    	 
    	 
    	 //gameItems[4].setRotation(0, -gZ, 0);
    	 //camera.setRotation(0, -gZ, 0);
    	 
    	 }
    	 if (window.isKeyPressed(GLFW_KEY_X)) {
    		 gZForAdvance += .3;
         	
         	camera.setPosition(0, 1, gZForAdvance);
         	
        	 }
    	 
    	 
        if (window.isKeyPressed(GLFW_KEY_W)) {
        	gZForAdvance -= .3;
        	
        	camera.setPosition(0, 1, gZForAdvance);
        	
        	
        	
            
        } if (window.isKeyPressed(GLFW_KEY_S)) {
            //cameraInc.z =+ 1;
            gZ -= .3;
	    	 //camera.setPosition(0, 0, -5);	
	    	 camera.setRotation(0, gZ, 0);
	    	 
	    	 
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
            //cameraInc.x =- 1;
        	gZ += .3;
	    	 //camera.setPosition(0, 0, -5);	
	    	 camera.setRotation(0, gZ, 0);
//	    	 gameItems[0].setRotation(0, 0, 0);
//	    	 gameItems[0].setPosition(0, 0, -10);
//	    	 
//	    	 gameItems[2].setRotation(0, 0, 0);
//	    	 gameItems[2].setPosition(5f, 0, -10);
//	    	 
//	    	 gameItems[3].setRotation(0, 0, 0);
//	    	 gameItems[3].setPosition(-5f, 0, -10);
//	    	 
//	    	 gameItems[1].setRotation(0, 0, 0);
//	    	 gameItems[1].setPosition(0, 0, -5);
	    	 
            
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
            //cameraInc.x = 1;
            float yrotrad;
            yrotrad = (player.rotation.y / 180 * 3.141592654f);
            camera.position.x += cos(yrotrad * 0.3);
            camera.position.z += sin(yrotrad) * 0.3;
        }
        
         
        
        if (window.isKeyPressed(GLFW_KEY_Z)) {
            cameraInc.y = -1;
        } 
        //zoom
        if (window.isKeyPressed(GLFW_KEY_O)) {
        	//cameraInc.x = 1;
        	
        	 //camera.setRotationZ();
        	 //camera.changeAngleAroundPlayer(30);
        	 //cameraInc = camera.calculateCameraPosition();
        	 System.out.println("X: ");
        	 System.out.println(cameraInc.x);
        	 System.out.println(" ");
        	 System.out.println(cameraInc.y);
        	 System.out.println(" ");
        	 System.out.println(cameraInc.z);
        	 System.out.println(" ");
        	 
        	 //cameraInc.x = 1;
        	 //cameraInc.y = 0;
        	 //cameraInc.z = -5;
        	 
        	 //camera.setPosition(0.5f, 0, 2);
        	 //camera.moveRotation(0, 1, 0);
        	 camera.movePosition(cameraInc.x * CAMERA_POS_STEP, cameraInc.y * CAMERA_POS_STEP, cameraInc.z * CAMERA_POS_STEP);
        	 
        	//cameraInc = camera.calculateCameraPosition();
        	//camera.movePosition(cameraInc.x * CAMERA_POS_STEP, cameraInc.y * CAMERA_POS_STEP, cameraInc.z * CAMERA_POS_STEP);
       	 
        }
        
        else if (window.isKeyPressed(GLFW_KEY_M)) {
        	//cameraInc.x = 1;
        	
        	 //camera.setRotationZ();
        	 //camera.changeAngleAroundPlayer(30);
        	 //cameraInc = camera.calculateCameraPosition();
        	
        	 //cameraInc = camera.calculateCameraPosition();
        	 System.out.println("X: ");
        	 System.out.println(cameraInc.x);
        	 System.out.println(" ");
        	 System.out.println(cameraInc.y);
        	 System.out.println(" ");
        	 System.out.println(cameraInc.z);
        	 System.out.println(" ");
        	 //camera.setPosition(0.5f, 0, 2);
        	 //camera.moveRotation(0, -1, 0);
        	 
        	 //camera.movePosition(cameraInc.x * CAMERA_POS_STEP, cameraInc.y * CAMERA_POS_STEP, cameraInc.z * CAMERA_POS_STEP);
        	 
        	
        	//cameraInc.x = 1;
        	//cameraInc.y = 0;
        	//cameraInc.z = 0;
        	//camera.movePosition(cameraInc.x * CAMERA_POS_STEP, cameraInc.y * CAMERA_POS_STEP, cameraInc.z * CAMERA_POS_STEP);
       	
        	
        
        }
   
    if (window.isKeyPressed(GLFW_KEY_H)) 
    {
    	//camera.distanceFromPlayer = camera.distanceFromPlayer - 10;
    
    
    }
    	
    }
    private double sin(float yrotrad) {
		// TODO Auto-generated method stub
		return 0;
	}

	private double cos(double d) {
		// TODO Auto-generated method stub
		return 0;
	}

	//private float cos(float yRotationRadius) {
	//	// TODO Auto-generated method stub
	//	return 0;
	//}

	//private float sin(float yRotationRadius) {
	//	// TODO Auto-generated method stub
	//	return 0;
	//}

	//private double (float)sin(float yRotationRadius) {
	//	// TODO Auto-generated method stub
	//	return 0;
	//}

	@Override
    public void update(float interval, MouseInput mouseInput) {
        // Update camera position
        
		
		gRot += 1;
		gameItems[0].setRotation(0, gRot, 0);
		
		camera.movePosition(cameraInc.x * CAMERA_POS_STEP, cameraInc.y * CAMERA_POS_STEP, cameraInc.z * CAMERA_POS_STEP);

		//if(gZ < 10)
		//{
		//	gZ = gZ + .1f;
		//	gameItems[4].setPosition(0, 0, -gZ);
		//}
		
		
      //  System.out.println("Hello");
        // Update camera based on mouse            
     //   if (mouseInput.isRightButtonPressed()) {
     //       Vector2f rotVec = mouseInput.getDisplVec();
     //       camera.moveRotation(rotVec.x * MOUSE_SENSITIVITY, rotVec.y * MOUSE_SENSITIVITY, 0);
     //   }
    }

    @Override
    public void render(Window window) {
        renderer.render(window, camera, gameItems);
    }

    @Override
    public void cleanup() {
        renderer.cleanup();
        for (GameItem gameItem : gameItems) {
            gameItem.getMesh().cleanUp();
        }
    }

}

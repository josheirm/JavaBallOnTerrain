

package org.lwjglb.game;





import  org.lwjgl.opengl.GL11;
import java.lang.*;

import org.lwjgl.opengl.GL32;

//import static org.lwjgl.opengl.GL20.*;

import org.joml.Vector3f;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;

import java.io.IOException;

import javax.imageio.ImageIO;

import org.lwjglb.engine.GameItem;
import org.lwjglb.engine.IGameLogic;
import org.lwjglb.engine.MouseInput;
import org.lwjglb.engine.Window;
import org.lwjglb.engine.graph.Camera;
import org.lwjglb.engine.graph.Mesh;
import org.lwjglb.engine.graph.Texture;
import org.lwjglb.game.Terrain;

import  org.joml.Math;
import org.joml.Vector2f;

import java.awt.image.BufferedImage;
import java.io.File;



//test

public class DummyGame implements IGameLogic {

	

	float gRotateY = 0;
	 boolean gDoneRotating  = false;
	 float gRotationHeight = 0; 
	 float gRotationWidth = 0; 
	float theAnswer = 0;
	// M
	float yReducer = 0;
	float changeM = 0;
	float flag2 = 0;
	float answer2 = 0;
	
	float tempHeight = 0;
	int heightIndexX = 0;
	int heightIndexZ = 0;
	float height = .9f;
	float gBallPositionX= 0;
	
	
	
	private  float SIZE = 800f;
	private  int VERTEX_COUNT = 128;
	
	
	
	float wCounter = 0;
	float xBallDirectionFinal = 0;
	float zBallDirectionFinal = 0;
	
	float xBallDistance  = 0;
	float zBallDistance  = 0;
	
	float angleForBall = 0;
	
	
	float[][] theHeight = new float[VERTEX_COUNT][VERTEX_COUNT];
	
	
	int Z = 0;
	float ballsX = 0;
	float ballsZ = 0;
	float angleOfBall = 30;
	
	
	
	private int x;
	private int z;
	
	float worldX = 34.5f;
	float worldZ = (179f - 3.5f);
	float accumulatedX = 0;//30f * .05f;
	float accumulatedZ = -3.5f * .05f;
	float containingX = 0f;
	float containingZ = 0f; 
	
	
	
	float gX = 0;
    float gY = 0f;
	float gY1 = 0;
	float gZ = 0;
	float gZForAdvance = 0;
	float gRot = 0;
	float angleOfRotation = 0;
	float newX = 0;
	float newZ = 0;
	float oldX = 0;
	float oldZ = -3.5f;
	float angle = 0;
	
	private static final float MAX_HEIGHT = 40;
	private static final float MAX_PIXEL_COLOUR = 256 * 256 * 256;
	
	
    private static final float MOUSE_SENSITIVITY = 0.2f;

    
    
    //josh, this was final..
    public Vector3f cameraInc;

    public Player2 player;
    private final Renderer renderer;

    public Camera camera;
    
    public Terrain terrain;

    private GameItem[] gameItems;
    public GameItem[] terrainItems;
    GameItem terrainObj[] = new GameItem[50];
    
    private static final float CAMERA_POS_STEP = 0.05f;

    public DummyGame() {
    	player = new Player2();
        renderer = new Renderer();
        camera = new Camera(player);
        cameraInc = new Vector3f();
        terrain = new Terrain();
    }

    @Override
    public void init(Window window) throws Exception {        renderer.init(window);
        
        
    
        float ga = 0.0f;
        
        
        
    		
        	camera.setPosition(0, 1,-3);
        
        
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
        
        	
        float y = 0;
        
  
        gameItem1.setScale(0.20f);
        
        GameItem gameItem2 = new GameItem(mesh);
        gameItem2.setScale(0.4f);
        gameItem2.setPosition(0.0f, 0.25f * .05f, -10);
       
        //glPushMatrix();
        
        GameItem gameItem3 = new GameItem(mesh);
        gameItem3.setScale(0.5f);
        gameItem3.setPosition(5, 0.25f, -10);
        GameItem gameItem4 = new GameItem(mesh);
        gameItem4.setScale(0.5f);
        gameItem4.setPosition(-5f, 0.25f, -10);
        
        
        
        BufferedImage image = null;
        
        try {
        	image = ImageIO.read(new File("textures/" + "heightmap" + ".png"));
            }
        catch (IOException e) {
        
        	e.printStackTrace();
        }
        
        
        
        
        float a = 0;
        
        
        
        VERTEX_COUNT = 128;
        SIZE = 800;
        
        int count = VERTEX_COUNT * VERTEX_COUNT;
		float[] vertices = new float[count * 3];
		float[] normals = new float[count * 3];
		float[] textureCoords = new float[count*2];
		int[] indices2 = new int[6*(VERTEX_COUNT-1)*(VERTEX_COUNT-1)];
		int vertexPointer = 0;
		
		
				
				for(int i=-64;i<VERTEX_COUNT/2;i++){
					for(int j=-64;j<(VERTEX_COUNT/2);j++){
						
				vertices[vertexPointer*3] = (float)j/((float)VERTEX_COUNT - 1) * SIZE;
				
				
				tempHeight = -1*terrain.getHeight(j+64, i+64, image);
				vertices[vertexPointer*3+1] =  tempHeight;
				theHeight[j+64][i+64] = tempHeight;
				
				if(tempHeight != 0 && tempHeight != -1.9999999f)
				{
					float tester = 0;
				}
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
		for(int gz=-0;gz<(VERTEX_COUNT-1);gz++){
			for(int gx =-0;gx<(VERTEX_COUNT-1);gx++){
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
		
		
		
		
		
		
		
		
		//vertices[0*3+1] = .4f;//  tempHeight;
		//theHeight[0][0] = .4f;//tempHeight;
		
		//////////
		//float a1 = theHeight[0][0];
		//float a2 = theHeight[0][1];
		//float a3 = theHeight[1][0];
		//float a4 = theHeight[1][1];
		
		//theHeight[0][0] = .30F;
		//theHeight[0][1] = .30F;
		//theHeight[1][0] = 0;
		//theHeight[1][1] = 0;W
		
		//vertices[0*3+1] =  .30f;//tempHeight;
		//vertices[1*3+1] =  .30F;//tempHeight;
		
		//vertices[2*3+1] =  0f;//tempHeight;
		//vertices[3*3+1] =  0f;//tempHeight;
		
		Vector3f v3 = new Vector3f(); 
		v3.x = 0f;
		v3.y = 4f;
		v3.z = 0f;
		
		Vector3f v2 = new Vector3f();  
		v2.x = 1f;
		v2.y = 0f;
		v2.z = 0f;
		
		Vector3f v1 = new Vector3f(); 
		v1.x = 0f;
		v1.y = 0f;
		v1.z = 1f;
		
		Vector2f pos = new Vector2f();
		pos.x = .5f;
		pos.y = .5f;		
		float yyy = terrain.barryCentric(v1, v2, v3, pos);
		
		
		
		Texture texture2 = new Texture("textures/grass.png");
        Mesh mesh2 = new Mesh(vertices, textureCoords, indices2, texture2);
        
       
		
        GameItem gameItem5 = new GameItem(mesh2);
        
        gameItem5.setPosition(-2.50f + .5f,0,-4);
		
        
        
    	
    	
    	terrainObj[0] = new GameItem(mesh2);
    	
    	
        int i = 0;
        	
        	
        	
        	
        	terrainObj[0].setPosition(0f ,0f, (0)  );
        	
        	
        	
        	
    		
        
        gameItems = new GameItem[]{gameItem1,gameItem2, gameItem3, gameItem4, gameItem5};
        terrainItems = new GameItem[]{gameItem1,gameItem2, gameItem3, gameItem4, gameItem5};
        
        gameItems[0].setPosition(0f,1.5f+ 1f *  -.8f - .5f + .13f,    (-1 -.05f));
        
         camera.setPosition(0, 1f,1 - gZ);
        
        
    }
    
    
  

	//@Override
    public int input(Window window, MouseInput mouseInput)  {
      
     	double sizeOfTerrain = 1024 * .005;
    	
    	cameraInc.set(0, -0, 0);
    	
    
    	if (window.isKeyPressed(GLFW_KEY_M)) {
    		
    		
    		
    		changeM = changeM - .1f;
    		gameItems[0].setPosition(0.f     ,-.12f +changeM ,     -3.6f-gZ ); 
    		
    		
    		 
   		 
   		 System.out.println("--beg M pressed--answer--");
   		 System.out.println(-.12f +changeM);
   		 System.out.println("--end----");
   		 try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	
    	
    
    	if (window.isKeyPressed(GLFW_KEY_C)) {
    		
    		 tempHeight = tempHeight - .01f;
    		 gameItems[0].setPosition(0f,     tempHeight,     -3.6f-gZ ); 
    		 
    		 System.out.println("--beg C pressed--temp height--");
    		 System.out.println(tempHeight);
    		 System.out.println("--end----");
    		 try {
 				Thread.sleep(500);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
         	
    		
    	}
    	
    	if (window.isKeyPressed(GLFW_KEY_V)) {
    		
    		tempHeight = tempHeight - .001f;
   		 gameItems[0].setPosition(0f,     tempHeight,     -3.6f-gZ ); 
   		 
   		 System.out.println("--beg X pressed--temp height--");
   		 System.out.println(tempHeight);
   		 System.out.println("--end----");
   		 try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	
    	if (window.isKeyPressed(GLFW_KEY_B)) {
    		
    		tempHeight = tempHeight - .001f;
      		 gameItems[0].setPosition(0f,     tempHeight,     -3.6f-gZ ); 
      		 
      		 System.out.println("--beg X pressed--temp height--");
      		 System.out.println(tempHeight);
      		 System.out.println("--end----");
      		 try {
   				Thread.sleep(500);
   			} catch (InterruptedException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
       		
       	}
    		
    
    	
    	
    	if (window.isKeyPressed(GLFW_KEY_N)) {
    		
    		gX = gX + 1;
    		gameItems[0].setPosition(gX, gY, gZ);
    		camera.setPosition(gX, gY, gZ);
    		
    	}
    	 
    	 if (window.isKeyPressed(GLFW_KEY_X)) {
    		 float radius = 1f;
    		 
    		 
    		 
         	
    		
    		 gZ -= .05;
    		 gameItems[0].setPosition(0f,     tempHeight - .1f ,     -3.6f-gZ ); 
        	 
        	 
       	  gameItems[0].setScale(.25f);
         	
       	try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	
       	
    	camera.setPosition(0, 1,-1 - gZ);
       	
    	
        	 }
    	 
    
		if (window.isKeyPressed(GLFW_KEY_Z)) {
	 
	 
	 	gameItems[0].setPosition(-0.0f,  theAnswer + 1.5f -.1f  ,  gZ  );
	 	try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 
		}

    	 
    	
    	 if (window.isKeyPressed(GLFW_KEY_Y)) {
    		 
    		 gRotationHeight = terrain.findXValue(gY1);
    		 gRotationWidth = terrain.findYValue(gY1);
    		 
    		 gDoneRotating = true;
		 
    	 }
    	
    	 if (window.isKeyPressed(GLFW_KEY_T)) {
    		 
    		
    		 if (gY1 == 0 )
    		 {
    			 gY1 = 1;
    			 //return(1);
    		 }
    		 else if (gY1 == 90 )
    		 {
    			 gY1 = 91;
    		 }
    		 else if (gY1 == 180 )
    		 {
    			 gY1 = 181;
    		 }
    		 else if (gY1 == 270 )
    		 {
    			 gY1 = 271;
    		 }
    		 else if (gY1 == 360 )
    		 {
    			 gY1 = 1;
    		 }
    		 
    		 
    		 
    		 if(gY1 > 0 && gY1 < 90 )
    		 {
    			 //sin
    			 gRotationHeight = terrain.findXValue(-gY1);
        		 
    			 gRotationWidth = terrain.findYValue(gY1);
    			 
    			 gRotationHeight = (float) Math.toDegrees(gRotationHeight);
    			 gRotationWidth = (float) Math.toDegrees(gRotationWidth);
    		 }
    		 else if (gY1 > 90 && gY1 < 180)
    		 {   //sin
    			 gRotationHeight = terrain.findXValue(gY1);
        		 gRotationWidth = terrain.findYValue(gY1);
    			
    		 }
    		 else if (gY1 > 180  && gY1 < 270 )
    		 {
    			 //sin
    			 gRotationHeight = terrain.findXValue(gY1);
        		 gRotationWidth = terrain.findYValue(-gY1);
    			 
    		 }
    		 else if (gY1 > 270 && gY1 < 360)
    		 {
    			 //sin
    			 gRotationHeight = terrain.findXValue(-gY1);
        		 gRotationWidth = terrain.findYValue(-gY1);
    			 
    		 }
    		 else if (gY1 > 360 || gY1 < 0)
				{
	
						int test = 0;
					}
    		 
    		 
    		
    		 
    		 //float hypot = Math.sqrt((height*height) + Math.sqrt(width*width));
    		 gDoneRotating = true;
    		 
    		 gRotationHeight =  gRotationHeight * .5f;
    		 gRotationHeight =  gRotationHeight * .5f;
    		 
    		 try {
 				Thread.sleep(500);
 			} catch (InterruptedException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
    		 
    		 //theAnswer = terrain.getTheHeight(gRotationwidth,gRotationheight 	,0f,0f,theHeight);
    		 
        	 }
    	 
    	 
    	 
    	 if (window.isKeyPressed(GLFW_KEY_R)) {
    	 
    		 gY1 = gY1 + 1;
    		 if(gY1 == 361)
    		 {
    			 gY1 = 1;
    		 }
    		 terrainObj[0].setRotation(0,gY1,0  );
    	 }
    	 
    	 //counter clockwise
    	 if (window.isKeyPressed(GLFW_KEY_U)) {
        	 
    		 gY1 = gY1 - 1;
    		 if (gY1 == -1)
    		 {
    			 gY1 = 359;
    		 }
    		 terrainObj[0].setRotation(0,gY1,0  );
    	 }
    	 
    	 
    	 
    	 //rotate
    	 if (window.isKeyPressed(GLFW_KEY_O)) {
    		 
    		
    		 
    		 
    	 }

    	 //rotate
    	 if (window.isKeyPressed(GLFW_KEY_P)) {
    		 
    		 terrainObj[0].setRotation(0,gRotateY,0  );
    		 //gameItems[0].setRotation(0,gRotateY,0);w
    		 gRotateY = gRotateY + 1;
    		 
    	 }
    	 
    	 
    	 
    	 
    	 if (window.isKeyPressed(GLFW_KEY_E)) {
         	
        	 
        	 float zTerrain = (63.5f *6.299f + (gZ));
        	
        	 if (gDoneRotating == true)
           	 {
           		theAnswer = terrain.getTheHeight(gRotationHeight, gRotationWidth 	,0f,0f,theHeight);
        		 
           	 gDoneRotating = false;
           	 }
        	 
        	 
        	 else
        	 {
        	 theAnswer = terrain.getTheHeight(63.5f*6.299f , zTerrain 	,0f,0f,theHeight);
        	 }
          	 
        	 
        	 
        	 
        	 gameItems[0].setScale(3f);
        	
        	 //really should be .5f times three.  This is set to dig in a bit!
          	 gameItems[0].setPosition(0,  theAnswer +1.5f  ,  gZ  );
          	 
          	 
          	System.out.println(theAnswer);
          	System.out.println();
          	 
          	
          	//for other heightmap
          	//camera.setPosition(0, 10,100+gZ);
          	camera.setPosition(0, 10,40+gZ);
          	
        	
          	gZ = gZ + 2;
          	 
        	
             try {
    				Thread.sleep(0);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    	 }
    	 
    	 
    	 
        ////////////////////
        
        if (window.isKeyPressed(GLFW_KEY_W)) {
        	
        	 //change in z
        	
        	
        	
        	
        	 // 30 should be center
        	 float zTerrain = (64f *6.299f + (gZ));
        	
        	 if (gDoneRotating == true)
           	 {
           		theAnswer = terrain.getTheHeight(gRotationHeight, gRotationWidth 	,0f,0f,theHeight);
           	 gRotationHeight =  gRotationHeight +  gRotationHeight;
           	 gRotationWidth = gRotationWidth + gRotationWidth;
           	 

            	
           		
           	 //gDoneRotating = false;
           	 }
    		 
        	 else
        	 {

        		 
        	 
        	 theAnswer = terrain.getTheHeight(65f*6.299f , zTerrain 	,0f,0f,theHeight); 
        	 }
        	 
        	 
        	 
          	 gameItems[0].setScale(3f);
        	 
          	
          	
   		 
   		 
   		 
          	gameItems[0].setPosition(0,  theAnswer+.5f*3    ,  gZ  );
      
        	 
          	 
          	 
          	 
          	camera.setPosition(0, 10,40+gZ);
          	
          	gZ = gZ - 2f;
       	 
          	
        	
             try {
    				Thread.sleep(0);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        
        	
        	
    	}
        	
            
         if (window.isKeyPressed(GLFW_KEY_A)) {
        	//degrees
         	gY1 -= 1.5;
 	    	 
            if(gY1 <= -90)
            {
            	gY1 = gY1 + 2.5f;
            	return(1);
            }
            	
         	
         	/////interesting revolve effect
         	
         	//ballsZ = Math.cos(radAngle);
         	//ballsX = Math.sin(ryadAngle);
            //gameItems[0].setPosition(ballsX , 1f *  -.8f - .5f + .13f ,  -3.6f + ballsZ);
            //angleForBall = angleForBall + zRadians;
         	
         	//////
         	
         	//changed to radians in transformation class
         	terrainObj[0].setRotation(0,gY1,0  );
         	
         	
         	//direction determined by hypotenuse is one
         	xBallDistance = terrain.findXValue(gY1);
         	
         	//direction was really .05
         	//xBallDistance = xBallDistance  *.05f;
         	zBallDistance = terrain.findYValue(gY1);
         	//zBallDistance = zBallDistance  *.05f;
         	
         	
         	System.out.println(gY1);
         	System.out.println(xBallDistance);
         	System.out.println(zBallDistance);
         	System.out.println("");
	    	 
        }
        if (window.isKeyPressed(GLFW_KEY_S)) {
        	
        	          
            //degrees
        	gY1 += 1.5;
        	if(gY1 > 180)
        	{   gY1 = gY1 - 2.5f;
        		return(0);
        	}
	    	 
        	float zRadians = Math.toRadians(gY1);
        	
        	terrainObj[0].setRotation(0,gY1,0  );
        	
        	
        	//direction determined by hypotenuse is one
        	xBallDistance  = terrain.findXValue(gY1);
        	
        	//
        	//direction was really .05
        	//xBallDistance  = xBallDistance  *.05f;
        	zBallDistance  = terrain.findYValue(gY1);
        	//zBallDistance  = zBallDistance  *.05f;
        	
        	System.out.println(gY1);
        	System.out.println(xBallDistance);
         	System.out.println(zBallDistance);
         	System.out.println("");
	    	 
        	
   	 
            
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	camera.setPosition(0, 0, -5);
        }
        
         
        
       
        
        
   
    if (window.isKeyPressed(GLFW_KEY_H)) 
    {
    	//camera.distanceFromPlayer = camera.distanceFromPlayer - 10;
    
    
    }
    
    return(1);
    	
    }
    private double sin(float yrotrad) {
		// TODO Auto-generated method stub
		return 0;
	}

	private double cos(double d) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
    public void update(float interval, MouseInput mouseInput) {
        // Update camera position
        
		
		gRot += 1;
		//gameItems[0].setRotation(0, gRot, 0);
		 GL11.glClear(GL11.GL_COLOR_BUFFER_BIT); 
		camera.movePosition(cameraInc.x * CAMERA_POS_STEP, cameraInc.y * CAMERA_POS_STEP, cameraInc.z * CAMERA_POS_STEP);
		
		
		

		
    }

    @Override
    public void render(Window window) {
        renderer.render(window, camera, gameItems, terrainObj);
    }

    @Override
    public void cleanup() {
        renderer.cleanup();
        for (GameItem gameItem : gameItems) {
            gameItem.getMesh().cleanUp();
        }
    }

}

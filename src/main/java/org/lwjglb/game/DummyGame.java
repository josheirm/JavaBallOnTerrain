

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
import java.awt.image.BufferedImage;
import java.io.File;

public class DummyGame implements IGameLogic {

	//glMatrixMode(GL_MODELVIEW);
	
	//static final
	private  float SIZE = 180f;
	private  int VERTEX_COUNT = 80;
	
	
	//private  float SIZE = 800f;
	//private  int VERTEX_COUNT = 10;
	
	float[][] theHeight = new float[VERTEX_COUNT+80][VERTEX_COUNT+80];
	
	
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
	
	float gZ1 = 0;
	float gZ = 0;
	float gZForAdvance = 0;
	float gRot = 0;
	float angleOfRotation = 0;
	float newX = 0;
	float newZ = 0;
	float oldX = 0;
	float oldZ = -3.5f;
	float angle = 0;
	//private static final float SIZE = 800;
	private static final float MAX_HEIGHT = 40;
	private static final float MAX_PIXEL_COLOUR = 256 * 256 * 256;
	
	
    private static final float MOUSE_SENSITIVITY = 0.2f;

    //GameItem gameItem5 = newx GameItem(mesh);
    
    
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
        
        //System.out.println("OpenGL version: " + GL11.glGetString(GL11.GL_VERSION));

//        GL.createCapabilities();
        
        //gameItem5
        
        
        float ga = 0.0f;
        ga = 77f * .08f;
        
        //generateTerrain(Loader loader){
    		
        	camera.setPosition(0, 1,-3);
           
        	//check line up of cube
        //camera.setRotation(5f, 1, 4);
           //camera.setRotation(0, 1, 4);
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
        
        	
        	 // -20/20  -.5 = -1.5
        	 //
     	//gameItem1.setPosition(0, -1f + .5f , -3.5f);
        
        //the hundreths place does not affect any change of ball on terrain
        //gameItem1.setScale(.5f);
        //put a value here as half the real value 
        //gameItem1.setPosition(0f, -2.f + .25f + .25f, -3.5f);
        float y = 0;
        
       
        
        
        
        ///////////height : 20 * .5 = 10
        
        // 0 : terrains positioning
        //gameItem1.setPosition(0f, -.5f+.125f, -3.5f );
        
        //-1 : terrains positioning
        //0,1.375,-4.3  
        
        //-height is : height + .5 + height * - .125
        //gameItem1.setPosition(0f, -1.5f+.13f  , -3.6f - .50f);     
        //1.6 *.5 = .8
        
        
        
        //gameItem1.setPosition(0f, 1f *  -.8f - .5f + .13f  , -3.6f - .50f);      
             
        //gameItems[0].setPosition(0f,1.5f+ 1f *  -.8f - .5f + .13f, -1  );
        //gameItem1.setPosition(0f, 1f *  -.8f - .5f + .13f , -1f + .05f); 
        //gameItems[0].setScale(.25f);
  	  
  	
        
        
        //////////height10 * .5 = 5
        
        //0
        //gameItem1.setPosition(0, (-.5f +.125f)/2 , -3.5f );
        
        
        //-1
        //gameItem1.setPosition(0, (-1.5f +.250f)/2 , -3.5f );
        
        
        
        
        ////////height16 *.5 = 8w
        //-1
       //? 
       // gameItem1.setPosition(0f, (-1.5f +.125f)/(10f/8f), -10.8f);//3.5f  );
       
       
        
        
        //gameItem1.setPosition(0f, .4f, -3.5f );
        
        
        
        gameItem1.setScale(0.25f);
//        gameItem1.setPosition(0.5f, 0.5f, -5);
//        GameItem gameItem2 = new GameItem(mesh);
//        gameItem2.setScale(0.5f);
//        gameItem2.setPwosition(0.5f, 0.5f, -5);
//       
//        //glPushMatrix();
//        ww
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
       
        //ball is 1 unit, so flat area is at :  -.7f  
        
        //0 + 1    :  1 x X = 1.60
       
        //camera position = 0,1,0
        
       //3.5f/7.2f*80f;
        
        //gameItem1.setPosition(0f, terrain.getTheHeight(400f, 400 , 0, 0f ,  theHeight), camera.position.z-3.5f );
        
        //gameItem1.setPosition(0f, 	.5f*terrain.getTheHeight(40f*2.25f, 80f*2.25f - (accumulatedZ) , 	0, 0f ,  theHeight), camera.position.z-3.5f );
        
        
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
        	image = ImageIO.read(new File("textures/" + "heightMap1" + ".bmp"));
            }
        catch (IOException e) {
        
        	e.printStackTrace();
        }
        
        ////////////
        //2
        //80
        // each vertex is 40 pixels
        
        
        //get y value and apply y in these coordinates and displays smaller
        //VERTEX_COUNT = 80;
        //SIZE = 180f; // total size, each vertex is 60 pixels
        
        
        //100/80
        
        //40/128 = 4 pixels
        
        
        
        
       // 200 / 60
        
        //6 pixels
        
        
        //VERTEX_COUNT = 4;
        //SIZE = 160;
        
        //VERTEX_COUNT = 2;
        //SIZE = 800;xx
        
        //size = 640;
        
        //       16
        
        //each vertex is size 4 = 8
        //eacwxxxh move is 1
        
        // 80 / 100 = .8
        // 80 / 80 = 1
        
        
        //private  float SIZE = 180f;
    	//private  int VERTEX_COUNT = 80;
        float a = 0;
        a = 81%40;// * 80 * 80; 
        a = 0%40;
        //////

        /*int count = VERTEX_COUNT * VERTEX_COUNT;
		float[] vertices = new float[count * 3];
		//float[] normals = new float[count * 3];
		float[] textureCoords = new float[count*2];
		int[] indices2 = new int[6*(VERTEX_COUNT-1)*(VERTEX_COUNT-1)];
		int vertexPointer = 0;
		for(int i=0;i<VERTEX_COUNT;i++){
			for(int j=0;j<VERTEX_COUNT;j++){
				vertices[vertexPointer*3] = (float)j/((float)VERTEX_COUNT - 1) * SIZE;
				//base is at : 2.9019595   //  -40
				float height =.5f* terrain.getHeight(j, i, image);
				vertices[vertexPointer*3+1] =  height;
				theHeight[j][i] = height;
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
		*/
        //////
        VERTEX_COUNT = 80;
        SIZE = 180;
        int count = VERTEX_COUNT * VERTEX_COUNT;
		float[] vertices = new float[count * 3];
		float[] normals = new float[count * 3];
		float[] textureCoords = new float[count*2];
		int[] indices2 = new int[6*(VERTEX_COUNT-1)*(VERTEX_COUNT-1)];
		int vertexPointer = 0;
		
		
		for(int i=-40;i<(VERTEX_COUNT/2);i++){
			for(int j=-40;j<(VERTEX_COUNT/2);j++){
				vertices[vertexPointer*3] = (float)j/((float)VERTEX_COUNT - 1) * SIZE;
				//base is at : 2.9019595   //  -40
				float height =.5f;//* terrain.getHeight(j, i, image);
				vertices[vertexPointer*3+1] =  height;
				//theHeight[j][i] = height;
				vertices[vertexPointer*3+2] = (float)i/((float)VERTEX_COUNT - 1) * SIZE;
				
					
					
					
				
				
				normals[vertexPointer*3] = 0;
				normals[vertexPointer*3+1] = 1;
				normals[vertexPointer*3+2] = 0;
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
    
		 
		
		Texture texture2 = new Texture("textures/grass.png");
        // Mesh mesh = new Mesh(positions, textCoords, indices, texture);
		Mesh mesh2 = new Mesh(vertices, textureCoords, indices2, texture2);
        
       //int a = (int) (800 * .007);
		
        GameItem gameItem5 = new GameItem(mesh2);
        //gameItem5.setScale(0.007f);
        gameItem5.setPosition(-2.50f + .5f,0,-4);
		
        
        
    	
    	for(int i = 0; i < 50; i++)
    	{
    	terrainObj[i] = new GameItem(mesh2);
    	}
    	
    	
        int i = 0;
        	
        	for(int terrainZ = 0; terrainZ < 4 ; terrainZ++)
        	{
        	for (int terrainX = 0; terrainX < 4 ; terrainX++)
        	{
        	
        		
        		
        	}
        		
        	}
        	i--;
        	
        	
        	
    		
        	float k = 1;
        	for(int j = 0; j < 7 ; j++)
        	{
        	
        		//terrainObj[j].setPosition(-7.2f ,-1f,  + (k*-7.2f)  );
        		terrainObj[j].setPosition(0 ,0f,  + (k*-5f)  );
        		terrainObj[j].setScale(.04f);
            	
        		k++;
        		
        	}
        	k=1;
        	for(int j = 7; j < 14 ; j++)
        	{
        	
        		terrainObj[j].setPosition(-14.4f ,0,  + (k*-7.2f)  );
            	terrainObj[j].setScale(.04f);
            	
        		k++;
        		
        	}
        	k=1;
        	for(int j = 14; j < 21 ; j++)
        	{
        	
        		terrainObj[j].setPosition(-21.6f,0,  + (k*-7.2f)  );
            	terrainObj[j].setScale(.04f);
            	
        		k++;
        		
        	}
        	k=1;
        	for(int j = 21; j < 28 ; j++)
        	{
        	
        		terrainObj[j].setPosition(0 ,0,  + (k*-7.2f)  );
            	terrainObj[j].setScale(.04f);
            	
        		k++;
        		
        	}
            	
        	k=1;
        	for(int j = 28; j < 35 ; j++)
        	{
        	
        		terrainObj[j].setPosition(7.2f,0,  + (k*-7.2f)  );
            	terrainObj[j].setScale(.04f);
            	
        		k++;
        		
        	}
            	
        	k=1;
        	for(int j = 35; j < 41 ; j++)
        	{
        	
        		terrainObj[j].setPosition(14.4f,0,  + (k*-7.2f)  );
            	terrainObj[j].setScale(.04f);
            	
        		k++;
        		
        	}
            	
        	
        	
    		
        
        gameItems = new GameItem[]{gameItem1,gameItem2, gameItem3, gameItem4, gameItem5};
        terrainItems = new GameItem[]{gameItem1,gameItem2, gameItem3, gameItem4, gameItem5};
        
        gameItems[0].setPosition(0f,1.5f+ 1f *  -.8f - .5f + .13f,    (-1 -.05f));
        //gameItems[0].setPosition(0f,1.5f+ 1f *  -.8f - .5f + .13f, (-1 -.05f) - 7.6f/2 + .25f );
        camera.setPosition(0, 1,1 - gZ);
        
    }

    //@Override
    public void input(Window window, MouseInput mouseInput)  {
      
    	double sizeOfTerrain = 1024 * .005;
    	//camera.setPosition(0, 1, 10);
    	cameraInc.set(0, -0, 0);
    	
    	
    	if (window.isKeyPressed(GLFW_KEY_V)) {
    		
    		gRot += .1;
    		cameraInc.set(-5, 0 + gRot, -10);
    		gameItems[4].getPosition();//0, -10, 0);
    		terrainItems[4].getPosition();//0, -10, 0);
    			   		
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
	    
    	 
    	 }
    	 if (window.isKeyPressed(GLFW_KEY_X)) {
    		 float radius = 1f;
    		 
    		 
    		 
         	
         	
         	float theta = camera.getRotation().y;//)m_rotationY;
         	
         	float phi = camera.getRotation().x;

         	//These equations are from the wikipedia page, linked above
         	float xMove = radius*Math.sin(phi)*Math.cos(theta);
         	float yMove = radius*Math.sin(phi)*Math.sin(theta);
         	float zMove = radius*Math.cos(phi);

         	accumulatedZ =+ zMove;
         	
         	//gameItems[0].setPosition(0f, 	terrain.getTheHeight(45f*2.25f + (accumulatedX), 79f*2.25f + (accumulatedZ) , 	0, 0f ,  theHeight), camera.position.z-3.5f );
         	//gameItems[0].setPosition(0f, 	terrain.getTheHeight((accumulatedX), (accumulatedZ) , containingX, containingZ ,  theHeight), camera.position.z-3.5f );
            
    		
         	/*if (accumulatedZ > (-7.2f * 1))
         	{
         		
         		containingZ = 1 * -7.2f;
         	}
         	
         	if (accumulatedZ > (-7.2f * 2))
         	{
         		
         		containingZ = 2 * -7.2f;
         	}
         	if (accumulatedZ > (-7.2f * 3))
         	{
         		
         		containingZ = 3 * -7.2f;
         	}
         	if (accumulatedZ > (-7.2f * 4))
         	{
         		
         		containingZ = 4 * -7.2f;
         	}
         	if (accumulatedZ > (-7.2f * 5))
         	{
         		
         		containingZ = 5 * -7.2f;
         	}
         	if (accumulatedZ > (-7.2f * 6))
         	{
         		
         		containingZ = 6 * -7.2f;
         	}
         	if (accumulatedZ > (-7.2f * 7))
         	{
         		
         		containingZ = 7 * -7.2f;
         	}
         	
         	*/
         	cameraInc.set(xMove, yMove, zMove);
    		 
    		 
    		 
    		 
         	
         	
        	 }
    	 
    	 
        if (window.isKeyPressed(GLFW_KEY_W)) {
        	//gZForAdvance -= .3;
        	//camera.setPosition(0, 1, gZForAdvance);
        	
        	 gZ += .05;// * 144; 
        	
        	 
        	 //7.6
        	  gameItems[0].setScale(.25f);
        	  //(-1 -.05f) - 7.6f/2 + .25f
        	  
        	  //gameItems[0].setPosition(0f,1.5f+ 1f *  -.8f - .5f + .13f,    (-1 -.05f));// - 7.6f/2 + .25f );
        	  //gameItems[0].setPosition(0f,1.5f+ 1f *  -.8f - .5f + .13f, -1 -gZ - (+ 7.6f/2f ) );
        
        	  gameItems[0].setPosition(0f,1.5f+ 1f *  -.8f - .5f + .13f, -1 -2.5f-gZ );// - (+ 7.6f/2f ) );
              
        	  
        	  Vector3f test = terrainObj[0].getRotation();
          	float aa = test.x;
          	
        	 
        	
        	camera.setPosition(0, 1,-1 - gZ);
        	// 144 x .05 = 72;
        	float radius = -1f ;
        	
        	
        	try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        	float theta = camera.getRotation().y;//)m_rotationY;
        	
        	float phi = camera.getRotation().x;

        	//Thease equations are from the wikipedia page, linked above
        	float xMove = radius*Math.sin(phi)*Math.cos(theta);
        	float yMove = radius*Math.sin(phi)*Math.sin(theta);
        	float zMove = radius*Math.cos(phi);

        	//gameItems[4].setPosition();
        	int a = 0;
        	
        	
        	
        	Z++;
        	//on scaled terrain
        	accumulatedX = accumulatedX  + xMove / 20f ;
        	accumulatedZ = accumulatedZ  + zMove / 20f ;	
        		
        	System.out.println(xMove);
        	System.out.println(zMove);
        	System.out.println(Z +" .05's");
        	System.out.println("");
        	worldX = worldX + xMove ;
        	worldZ = worldZ + zMove;
        	
        		/*
        		if (accumulatedX > 3.95 * 3)
            	{
            		containingX = 3.95f * 3;
            		
            	}
        		if (accumulatedX > 3.95 * 2)
            	{
            		containingX = 3.95f * 2;
            		
            	}
        		if (accumulatedX > 3.95 )
            	{
            		containingX = 3.95f;
            		
            	}
        		//3.95 = 80 steps at .05 a step
        		
        		
        		if (accumulatedX < -3.95 * 4 )
            	{
            		containingX = -3.95f * 4;
            		
            	}
        		
        		if (accumulatedX < -3.95 * 3)
            	{
            		containingX = -3.95f * 3;
            		
            	}
        		if (accumulatedX < -3.95 * 2)
            	{
            		containingX = -3.95f * 2;
            		
            	}
        		if (accumulatedX < 0)
            	{
            		containingX = -3.95f;
            		
            	}
        		
        		
        		//going towards user
        		if (accumulatedZ > 3.95 * 3)
            	{
            		containingZ = 3.95f * 3;
            		
            	}
        		if (accumulatedZ > 3.95 * 2)
            	{
            		containingZ = 3.95f * 2;
            		
            	}
        		if (accumulatedZ > 3.95 )
            	{
            		containingZ = 3.95f;
            		
            	}
        		//3.95 = 80 steps at .05 a step
        		
        		
        		//going into screen
        		if (accumulatedZ < -3.95 * 3 )
            	{
            		containingZ = -3.95f * 3;
            		
            	}
        		
        		if (accumulatedZ < -3.95 * 2)
            	{
            		containingZ = -3.95f * 2;
            		
            	}
        		if (accumulatedZ < -3.95 * 1)
            	{
            		containingZ = -3.95f;
            		
            	}
        		
        		*/
        	
        	
        	//////
        	
        	
        	
        		
        		//float answer = terrain.getTheHeight(worldX, worldZ , 	containingX, containingZ ,  theHeight); 
        		
        	
        	
        	
        	//cameraInc.set(xMove, yMove, zMove);
    	}
        	//m_positionX += xMove;
        	//m_positionY += yMove;
        	//m_positionZ += zMove;
        	
        
        	//newx = oldx + (cos(angle)*speed);
        	//newz = oldz + (sin(angle)*speed);
        	//Your angle has to be in radians (divide by 180 and multiply by pi if it is in degrees) if you use sin() and cos() in math.h
        	
        	
        	//angleOfRotation = angleOfRotation + 90;
        	
        	//angle = 3.14f*(angleOfRotation/180);
        	
        	//newX = oldX + (Math.cos(angle)*.1f);
        	//newZ = oldZ + (Math.sin(angle)*.1f);
        	//oldX = newX;
        	///oldZ = newZ;
        	
        	//camera.setPosition(newX, 1, newZ);
        	//gamxeItems[0].setPosition(newX, 1, newZ);
        	//angleOfRotation = angleOfRotation - 90;
        	
            
         if (window.isKeyPressed(GLFW_KEY_S)) {
            //cameraInc.z =+ 1;
            gZ += .3;
	    	 //camera.setPosition(0, 0, -5);
             //angleOfRotation = gZ;
	    	 camera.setRotation(0, gZ, 0);
	    	 
	    	 
        }
        if (window.isKeyPressed(GLFW_KEY_A)) {
        	
        	
        	
        	          
            
        	gZ1 -= 2.5;
	    	 
        	
        	//angleOfBall = angleOfBall + 1;
        	//float radAngle = (float) Math.toRadians(angleOfBall);
        	
        	//ballsZ = Math.cos(radAngle);
        	//ballsX = Math.sin(radAngle);
        	
        	//gameItems[0].setPosition(ballsX , 1f *  -.8f - .5f + .13f ,  -3.6f + ballsZ);
        	
        	terrainObj[0].setRotation(0,gZ1,0  );
        	
        	Vector3f test = terrainObj[0].getRotation();
        	float a = test.x;
        	
   	 
            
        } else if (window.isKeyPressed(GLFW_KEY_D)) {
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	camera.setPosition(0, 0, -5);
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
		//gameItems[0].setRotation(0, gRot, 0);
		 GL11.glClear(GL11.GL_COLOR_BUFFER_BIT); 
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

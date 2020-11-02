

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





public class DummyGame implements IGameLogic {

	//glMatrixMode(GL_MODELVIEW);
	
	//static final
	
	//for setposition

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
	//private  float SIZE = 800f;
	//private  int VERTEX_COUNT = 10;
	
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
	
	
	//?
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
        
        
    /////////
    
    
    //////////
    
    
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
        a = 81%40;// * 80 * 80; 
        a = 0%40;
        //////

        
        //////////Make terrain
        //VERTEX_COUNT = 4;
        //SIZE = 2;
        /*
        int count = VERTEX_COUNT * VERTEX_COUNT;
		float[] vertices = new float[count * 3];
		float[] normals = new float[count * 3];
		float[] textureCoords = new float[count*2];
		int[] indices2 = new int[6*(VERTEX_COUNT-1)*(VERTEX_COUNT-1)];
		int vertexPointer = 0;
		
		
		for(int i=-0;i<(VERTEX_COUNT);i++){
			for(int j=-0;j<(VERTEX_COUNT);j++){
				vertices[vertexPointer*3] = (float)j/((float)VERTEX_COUNT - 1) * SIZE;
				
				
				tempHeight = terrain.getHeight(j+0, i+0, image);
				vertices[vertexPointer*3+1] =  tempHeight;
				theHeight[j + 0][i + 0] = tempHeight;
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
		*/
        
        //VERTEX_COUNT = 110;
        //SIZE = 60;
        
        VERTEX_COUNT = 128;
        SIZE = 800;
        
        int count = VERTEX_COUNT * VERTEX_COUNT;
		float[] vertices = new float[count * 3];
		float[] normals = new float[count * 3];
		float[] textureCoords = new float[count*2];
		int[] indices2 = new int[6*(VERTEX_COUNT-1)*(VERTEX_COUNT-1)];
		int vertexPointer = 0;
		
		//loops number of vertexes
		//for(int i=-5;i<(VERTEX_COUNT-1);i++){
		//	for(int j=-5;j<(VERTEX_COUNT-1);j++){
				
				
		
		/*
		 * 
		 * //loops number of vertexes
				for(int i=-110/2;i<55;i++){
					for(int j=-110/2;j<(55);j++){
						
				vertices[vertexPointer*3] = (float)j/((float)VERTEX_COUNT - 1) * SIZE;
				
				
				tempHeight =-.05f * terrain.getHeight(j+(110/2), i+(110/2), image);
				vertices[vertexPointer*3+1] =  tempHeight;
				theHeight[j + (110/2)][i + (110/2)] = tempHeight;
				
				
				vertices[vertexPointer*3+2] = (float)i/((float)VERTEX_COUNT - 1) * SIZE;
				//normals[vertexPointer*3] = 0;
				//normals[vertexPointer*3+1] = 1;
				//normals[vertexPointer*3+2] = 0;
				textureCoords[vertexPointer*2] = (float)j/((float)VERTEX_COUNT - 1);
				textureCoords[vertexPointer*2+1] = (float)i/((float)VERTEX_COUNT - 1);
				vertexPointer++;
			}
		}
		 */ 
		 
		
		
		
		
		//JOSH CHECK THIS!
				//loops number of vertexes
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
		
		
		
		
		for (int k=0;k<=10;k++)
		{
			for(int l = 0; l <= 10; l++)
			{
			if (theHeight[l][k] == -1.0901959)	
			{
				System.out.println(l);
				System.out.println(k);
				System.out.println();
			}
			
		}
		}
		
		System.out.println(theHeight[4][6]);
		
		//vertices[5*3+1] =  .4f;//tempHeight;
		//theHeight[1][1] =  .4f;//tempHeight;
		
		///////
		vertices[0*3+1] = .4f;//  tempHeight;
		theHeight[0][0] = .4f;//tempHeight;
		///////////////
		
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
		
		int testtest = 0;
		
		
		//float ans = terrain.getTheHeight(.5f,.25f,0,0, theHeight);
		
		Texture texture2 = new Texture("textures/grass.png");
        // Mesh mesh = new Mesh(positions, textCoords, indices, texture);
		Mesh mesh2 = new Mesh(vertices, textureCoords, indices2, texture2);
        
       //int a = (int) (800 * .007);
		
        GameItem gameItem5 = new GameItem(mesh2);
        //gameItem5.setScale(0.007f);
        gameItem5.setPosition(-2.50f + .5f,0,-4);
		
        
        
    	
    	for(int i = 0; i < 1; i++)
    	{
    	terrainObj[i] = new GameItem(mesh2);
    	}
    	
    	
        int i = 0;
        	
        	
        	
        	
        	//terrainObj[0].setPosition(-.5f ,0f,  + (-7f+0)  );
        	terrainObj[0].setPosition(0f ,0f, (0)  );
        	//terrainObj[1].setPosition(0f ,0f,  + (-7f+0)  );
        	//terrainObj[2].setPosition(-.5f ,0f,  + (-6f+0)  );
        	//terrainObj[3].setPosition(-0f ,0f,  + (-6f+0)  );
        	
        	//terrainObj[4].setPosition(-.5f ,0f,  + (-7f+0)  );
        	//terrainObj[5].setPosition(0f ,0f,  + (-7f+0)  );
        	//terrainObj[6].setPosition(-.5f ,0f,  + (-6f+0)  );
        	//terrainObj[7].setPosition(-0f ,0f,  + (-6f+0)  );
        	
        	
        	
        	
        	/*
        	float k = 1;
        	for(int j = 0; j < 0 ; j++)
        	{
        	
        		//terrainObj[j].setPosition(-7.2f ,-1f,  + (k*-7.2f)  );
        		terrainObj[j].setPosition(-.5f ,0f,  + (-7f+k)  );
        		
        		
        		
        		
        		
        		//terrainObj[j].setScale(.04f);
            	
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
            	
        	*/
        	
    		
        
        gameItems = new GameItem[]{gameItem1,gameItem2, gameItem3, gameItem4, gameItem5};
        terrainItems = new GameItem[]{gameItem1,gameItem2, gameItem3, gameItem4, gameItem5};
        
        gameItems[0].setPosition(0f,1.5f+ 1f *  -.8f - .5f + .13f,    (-1 -.05f));
        //gameItems[0].setPosition(0f,1.5f+ 1f *  -.8f - .5f + .13f, (-1 -.05f) - 7.6f/2 + .25f );
        
         camera.setPosition(0, 1f,1 - gZ);
        //camera.setPosition(0, .8f,.18f - gZ);
         //tempHeight = 3; 
        
    }
    
    
    
    
    

    

	//@Override
    public int input(Window window, MouseInput mouseInput)  {
      
     	double sizeOfTerrain = 1024 * .005;
    	//camera.setPosition(0, 1, 10);
    	cameraInc.set(0, -0, 0);
    	
    	//deeper
    	
    	/*if (window.isKeyPressed(GLFW_KEY_Z)) {
    		 System.out.println("---Z pressed--- .2f");
    		 
    		
    		 flag2 = 0;
    		//float answer = terrain.getTheHeight(40*2, 40*2, 0 , 0 , theHeight); 
    		
    		 float zTerrain = (3.6f + gZ) * 25f;
        	 
        	 int gridZ = (int) Math.floor(zTerrain/2.278f);
        	 
        	 
        	 //these two work with set position below
        	 float answ = theHeight[40][gridZ];
        	 //float answer = terrain.getTheHeight(40f*2.278f, 40*2.278f	 	,0f,0f,theHeight);
        	 //float answer = terrain.getTheHeight(90f*2.278f, zTerrain	 	,0f,0f,theHeight);
        	 float answer = terrain.getTheHeight(79f * .5f * 2.278f, zTerrain 	,0f,0f,theHeight);
           	
    		 
        	 gameItems[0].setScale(.125f);
        	 
        	 
     		
        	 
        	 
        	 //gameItems[0].setPosition(0.f,     tempHeight * 0.05f + .25f ,    -3.6f-gZ );
        	 gameItems[0].setPosition(0f,     answer * 0.04f + .0625f + yReducer ,    -3.6f-gZ  );
        	 yReducer = yReducer - .01f;
        	 
        	 
        	 
        	 
    		 
    		//answer = answer * .14f + .125f * .25f;
    		//answer = answer * .14f + .125f * .25f;
    		
    		//gameItems[0].setPosition(0,    -.75f ,     -3.6f-gZ ); 
    		//camera.setPosition(0,1,-1 - gZ);
    		
        	 camera.setPosition(0, 1,-2.2f - gZ );
        	 //camera.setPosition(0,1,-2.2f);
    		
    		 System.out.println("--beg Z pressed--answer, Z--");
       		 System.out.println(zTerrain);
       		 System.out.println(answer);
        	 //System.out.println(theHeight[0][(int) gZ]); 
        	 System.out.println(yReducer);
       		 System.out.println("--end----");
       		 
       		try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
    		
    		
    	}
    	
    	
    	
    	
    	
    	*/
    	
    	//NO
    	if (window.isKeyPressed(GLFW_KEY_M)) {
    		
    		//tempHeight = tempHeight - .1f;
    		
    		changeM = changeM - .1f;
    		gameItems[0].setPosition(0.f     ,-.12f +changeM ,     -3.6f-gZ ); 
    		
    		
    		//if (flag2 == 0)
    	//	{
    	//		float answer = terrain.getTheHeight(35*2, 35*2, 0 , 0 , theHeight); 
        //		
    	//	//answer2 = theHeight[35*2][35*2]; 
    	//	answer2 = answer2 * .14f + .125f;
    	//	flag2 = 1;
    	//	}
    		
    		
    	//	answer2 = answer2 - .1f;
    		
   	//	 gameItems[0].setPosition(-5f,     answer2,     -3.6f-gZ ); 
   		 
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
    	
    	
    	//no
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
    	//.197
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
    		
    		
    	
    	//if (window.isKeyPressed(GLFW_KEY_V)) {
    	//	
    	//	gRot += .1;
    	//	cameraInc.set(-5, 0 + gRot, -10);
    	//	gameItems[4].getPosition();//0, -10, 0);
    	//	terrainItems[4].getPosition();//0, -10, 0);
    	//		   		
    	//	}
    	
    	
    	
    	
    	
    	//
    	//if (window.isKeyPressed(GLFW_KEY_B)) {
    	//	gRot -= .1;
    	//	cameraInc.set(-5, -5 - gRot, 0);
    	//}
    	
  //  	 if (window.isKeyPressed(GLFW_KEY_U)) {
//	    	 gZ += .3;
//	    	 //camera.setPosition(0, 0, -5);	
//	    	 camera.setRotation(0, gZ, 0);
//	    	 camera.setPosition(0, 0, -1);	 
//	    	 gameItems[1].setPosition(0, 0, -10);
//	    	 gameItems[0].setPosition(0, 0, -10);
//	    
 //   	 
  //  	 }
    	 
    	 /*if (window.isKeyPressed(GLFW_KEY_E)) {
    		 float radius = 1f;
    		 
    		 
    		 
         	
    		
    		 gZ -= .05;// * 144; 
    		 //.9
    		 gameItems[0].setPosition(0f,.43f/.5f*.8f * 2/height / 10 + .1f, -1 -2.5f+gZ );// - (+ 7.6f/2f ) );
             
        	 
        	 
       	  //gameItems[0].setScale(.25f);
       	  
       	  
    	 }
    	 */
    	
    	
    	if (window.isKeyPressed(GLFW_KEY_N)) {
    		
    		gX = gX + 1;
    		gameItems[0].setPosition(gX, gY, gZ);
    		camera.setPosition(gX, gY, gZ);
    		
    	}
    	 
    	 if (window.isKeyPressed(GLFW_KEY_X)) {
    		 float radius = 1f;
    		 
    		 
    		 
         	
    		
    		 gZ -= .05;// * 144; 
    		 //.9
    		 //gameItems[0].setPosition(0f,.43f/.5f*.8f * 2/height / 10 + .1f, -1 -2.5f+gZ );// - (+ 7.6f/2f ) );
    		 gameItems[0].setPosition(0f,     tempHeight - .1f ,     -3.6f-gZ ); 
        	 
        	 
       	  gameItems[0].setScale(.25f);
         	
       	try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       	
       	
    	camera.setPosition(0, 1,-1 - gZ);
       	
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
         	//cameraInc.set(xMove, yMove, zMove);
    		 
    		 
    		 
    		 
         	
         	
        	 }
    	 
    	 
    	 //strafe right
    	 
    	 /*
    	 if (window.isKeyPressed(GLFW_KEY_T)) {
          	
    		 cameraInc.x = 1;
    		 //gameItems[0].setPosition(0f,     .43f/.5f*.8f * 2/.4f / 10 + .1f,      -3.5f-gZ ); 
    		 
    		 //for set positiion
    		 //gBallPositionX = gBallPositionX + .05f;
    		 //xBallDirectionFinal =  xBallDirectionFinal + .05f;
    		 
    		 camera.setPosition(0f, .9f, -2f);
    		 //cameraInc.set(.05, 0, 0);
    		//.4  OK OK
    		//.9f at make terrain
          	//gameItems[0].setPosition(gBallPositionX,      .43f/.5f*.8f * 2/height / 10 + .1f,      -3.5f-gZ ); 
    		 
    	 }
    	 */
    	 /*//strafe left
    	 if (window.isKeyPressed(GLFW_KEY_R)) {
         	//for set position
    		 gBallPositionX = gBallPositionX - .05f;
    		 //for height map of terrain
    		 xBallDirectionFinal =  xBallDirectionFinal - .05f;
    		 
    		 camera.setPosition(-.05f, 1,-1 - gZ);
    		 //cameraInc.set(-.05, 0, 0);
    		//.4  OK OK
          	gameItems[0].setPosition(gBallPositionX,    .43f/.5f*.8f * 2/height / 10 + .1f,      -3.5f-gZ ); 
    		 
    	 }
    	 */
    	 
    /*	 if (window.isKeyPressed(GLFW_KEY_Y)) {
    		 
    		 gZ += .05f;
    		 gameItems[0].setPosition(0f,     answer2 ,     -3.6f-gZ ); 
    		 camera.setPosition(0,1,-1 - gZ);
    		 
    	 }
    	 
    	*/ 
    	 
    	 if (window.isKeyPressed(GLFW_KEY_Z)) {
    		 
    		 
    		 gameItems[0].setPosition(-0.0f,  theAnswer-.0001f  ,  -5.5f-gZ  );
    		 
    	 }

		if (window.isKeyPressed(GLFW_KEY_Z)) {
	 
	 
	 	gameItems[0].setPosition(-0.0f,  theAnswer-.0001f  ,  -5.5f-gZ  );
	 
		}


    	 if (window.isKeyPressed(GLFW_KEY_Z)) {
    		 
    		 
    		 gameItems[0].setPosition(-0.0f,  theAnswer-.0001f  ,  -5.5f-gZ  );
    		 
    	 }
    	 
    	 
    	 
    	 //clockwise 
    	 if (window.isKeyPressed(GLFW_KEY_Y)) {
    		 
    		 gRotationHeight = terrain.findXValue(gY1);
    		 gRotationWidth = terrain.findYValue(gY1);
    		 
    		 //float hypot = Math.sqrt((height*height) + Math.sqrt(width*width));
    		 gDoneRotating = true;
    		 
    		 
    		 
    		 
    	 }
    	 
    	 
    	 
    	 
    	 
    	 /////////////////////////////////////////////////////////////////
    	 //counter clockwise, set new point to check height
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
    	 
    	 
    	 //////
    	 //clockwise - use this to setup straight part of mesh
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
    		 
    		 //terrainObj[0].setRotation(0,gRotateY,0  );
    		 //gameItems[0].setRotation(0,gRotateY,0);
    		 //gRotateY = gRotateY - 1;
    		 
    		 
    		 
    	 }

    	 //rotate
    	 if (window.isKeyPressed(GLFW_KEY_P)) {
    		 
    		 terrainObj[0].setRotation(0,gRotateY,0  );
    		 //gameItems[0].setRotation(0,gRotateY,0);w
    		 gRotateY = gRotateY + 1;
    		 
    	 }
    	 
    	 
    	 
    	 
    	 if (window.isKeyPressed(GLFW_KEY_E)) {
         	
        	 //change in z   .5
        	 gZ = gZ + 2;
        	
        	 
        	//move upe
        	 float zTerrain = (64f *6.299f + (gZ));
        	 //float zTerrain = 6;//(8f * .6f + gZ);
        	 


        	 
        	 if (gDoneRotating == true)
           	 {
           		theAnswer = terrain.getTheHeight(gRotationHeight, gRotationWidth 	,0f,0f,theHeight);
        		 
           	 gDoneRotating = false;
           	 }
        	 
        	 
        	 else
        	 {
        	 theAnswer = terrain.getTheHeight(64f*6.299f , zTerrain 	,0f,0f,theHeight);
        	 }
          	 
        	 
        	 
        	 
        	 gameItems[0].setScale(3f);
        	
          	 gameItems[0].setPosition(0,  theAnswer +.5f*3  ,  -7+gZ  );
          	 
          	
          	 
          	camera.setPosition(0, 10,20+gZ);
        	
          	 
        	
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
        	
        	
        	gZ = gZ - 2f;
        	 
        	
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
        	 
          	
          	
   		 
   		 
   		 
          	gameItems[0].setPosition(0,  theAnswer+.5f*3    ,  -7.f+gZ  );
      
        	 
          	 
          	 
          	 
          	camera.setPosition(0, 10,20+gZ);
        	
             try {
    				Thread.sleep(0);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        ////////////////////
           	
          	
           	
           
        	
        	/////ww////////
        	
        	
        	       		
        		
        		
        	
        	
        	//////
        	
        	
        	
        		
        		
        	
        	
        	
        	
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
        
         
        
        if (window.isKeyPressed(GLFW_KEY_Z)) {
            cameraInc.y = -1;
        } 
        //zoom
        /*if (window.isKeyPressed(GLFW_KEY_O)) {
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
        */
        
        /*else if (window.isKeyPressed(GLFW_KEY_M)) {
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
       	
        	
        
        }*/
   
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

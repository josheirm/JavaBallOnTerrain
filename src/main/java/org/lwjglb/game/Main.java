package org.lwjglb.game;
//package org.lwjglb.opengl.*;
import org.lwjglb.engine.GameEngine;
import org.joml.Vector3f;
//import org.lwjgl.opengl.GL33;
import org.joml.Matrix4f;
import org.lwjgl.opengl.*;
//import org.joml.*;


import org.lwjglb.engine.IGameLogic;



public class Main{
 
    public static void main(String[] args) {
    	
    	   	
    	//double x = 2.5;
    	//Math.toRadians(x);
    	
    	
        try {
        	
        	
        	//GL33.glGetUniformLocation(1, "name");
        	
        	int a = 72852804 ^ 51;
        	int b = 72852855 & 0xfff;
        	String Str = new String();
        	
        	//Str.hashCode();
        	System.out.println(b);
        	int key = ("LWJGL".hashCode() ^ "3".hashCode()) & 0xFFF; // Type the value of key:
        	//System.out.println("(\"LWJGL\".hashCode() ^ \"3\".hashCode()) & 0xFFF; ");
        	//Math.cos(Math.toRaddians);
        	
            boolean vSync = true;
            IGameLogic gameLogic = new DummyGame();
            GameEngine gameEng = new GameEngine("GAME", 600, 480, vSync, gameLogic);
            gameEng.run();
        } catch (Exception excp) {
            excp.printStackTrace();
            System.exit(-1);
        }
    }
    
}
   
   
    
    
    
    

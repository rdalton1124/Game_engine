package pong_elements; 

import default_elements.*; 

import java.awt.*; 
import java.io.*; 
import javax.sound.sampled.*; 

public class Pong_Ball extends Test_Sprite_Junior{
    
    
    public Pong_Ball(Test_Scene scene) {
        super(scene);
        xBoundAction = RESPAWN; 
        yBoundAction = BOUNCE; 
    }
    public Pong_Ball(Test_Scene scene, Color color, int width, int height, int x, int y) {
        super(scene, color, width, height, x, y); 
        xBoundAction = RESPAWN; 
        yBoundAction = BOUNCE; 
    }
    
    //these things are pre-set so don't allow people to change them 
    public void setBoundAction(int ba){}
    public void setXBoundAction(int xa){}
    public void setYBoundAction(int ya){}
    
    public void bounce() {
        dx = (int) Math.ceil(dx * -1.1); //speed up
    }
}

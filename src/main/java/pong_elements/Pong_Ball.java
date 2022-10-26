package pong_elements; 

import default_elements.*; 

import java.awt.*; 
import java.io.*; 
import javax.sound.sampled.*; 

public class Pong_Ball extends Sprite_Junior{
    
    
    public Pong_Ball(Scene scene) {
        super(scene);
        xBoundAction = RESPAWN; 
        yBoundAction = BOUNCE; 
    }
    public Pong_Ball(Scene scene, Color color, int width, int height, int x, int y) {
        super(scene, color, width, height, x, y); 
        xBoundAction = RESPAWN; 
        yBoundAction = BOUNCE; 
    }
    
    //these things are pre-set so don't allow people to change them 
    public void setBoundAction(int ba){}
    public void setXBoundAction(int xa){}
    public void setYBoundAction(int ya){}
    
    public void bounce() {
        dx *= -1.1; //speed up
        dy += rand.nextInt(4) - 1; 
    }
    public boolean collidesWith(Pong_Player_Sprite sprt) {
        if(x + dx > sprt.getX() + sprt.getWidth() || //my left side is to your right
                x + width < sprt.getX()) //my right side is to your left
            return false; 
        else if (y > sprt.getY() + sprt.getHeight() || //my top side is below your bottom
                y + height < sprt.getY())  //my bottom side is above your top
            return false;
        else
            return true; 
        
    }
}

package pong_elements;

import default_elements.*; 
import java.awt.Color;

public class Pong_Player_Sprite extends Player_Sprite{
    
    public Pong_Player_Sprite (Scene scene) { 
        super(scene); 
    }
    public Pong_Player_Sprite(Scene scene, Color color, int width, int height, int x, int y) {
        super(scene, color, width, height, x, y); 
    }
    
    @Override
    public void update() { 
        if(keysDown.contains(up)) {
            dy -= 5; 
            if(dy < -maxDY) 
                dy = -maxDY;
        }
        if(keysDown.contains(down)) { 
            dy += 5; 
            if (dy > maxDY)
                dy = maxDY;
        } 
        checkBoundaries(); 
        dy += ddy; 
        y += dy;
    }
    @Override 
    public void checkBoundaries(){ 
        if(isTopColliding() && dy < 0){
            dy = 0; 
            stop.loop(1); 
        }
        if(isBottomColliding() && dy > 0){
            dy = 0; 
            stop.loop(1); 
        }
    }
    
    public int getX() {
        return x;
    }
    public int getY() {
        return y; 
    }
    
}

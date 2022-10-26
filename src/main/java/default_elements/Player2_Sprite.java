/**************************************
DO NOT USE THIS. IT'S ARCHIAC AND YOU CAN JUST
* SET A PLAYER_SPRITE TO IJKL. 
**************************************/
package default_elements;

import java.awt.*; 
import java.awt.event.*; 

public class Player2_Sprite extends Player_Sprite{
    
    public Player2_Sprite(Scene scene){
        super(scene); 
    }
    public Player2_Sprite(Scene scene, Color color, int width, int height, int x, int y){
        super(scene, color, width, height, x, y); 
    }
    public Player2_Sprite(Scene scene, String imgPath, int width, int height) {
        super(scene, imgPath, width, height); 
    }
    @Override
    public void update() { 
        if(keysDown.contains(KeyEvent.VK_I)) {
            
        }
        if(keysDown.contains(KeyEvent.VK_J)) {
            
        }
        if(keysDown.contains(KeyEvent.VK_K)) {
            
        }
        if(keysDown.contains(KeyEvent.VK_L)) {
            
        }
       
        checkBoundaries();  
        dx += ddx; 
        dy += ddy; 
        x += dx; 
        y += dy; 
    }
}

import java.awt.event.*; 
import java.awt.*; 

public class Player_Sprite extends Test_Sprite implements KeyListener{
    final int maxDX = 15, maxDY = 15; 
    public Player_Sprite(Test_Scene scene) {
        super(scene);
    }
    public Player_Sprite(Test_Scene scene, Color color, int width, int height, int x, int y) {
        super(scene, color, width, height, x, y); 
        dx = 0; 
        dy = 0; 
        ddx = 0; 
        ddy = 0; 
    }
    public Player_Sprite(Test_Scene scene, String imgPath, int width, int height) {
        super(scene, imgPath, width, height);
        
        x = (sceneWidth / 2) - (width / 2); 
        y = (sceneHeight / 2) - (height / 2); 
    }
    
    @Override
    public void keyPressed(KeyEvent e) { 
        if(e.getKeyCode() == KeyEvent.VK_W) {
            dy -= 5;
            if(dy < -maxDY) 
                dy = -maxDY;
            System.out.println("W pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_A) {
            dx -= 5;
            if(dx < -maxDX)
                dx = -maxDX; 
            System.out.println("A pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_S) {
            dy += 5; 
            if(dy > maxDY)
                dy = maxDY; 
            System.out.println("S pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_D) {
            dx += 5; 
            if(dx > maxDX) 
                dx = maxDX;
            System.out.println("D pressed");
        }
    }
    @Override 
    public void keyTyped(KeyEvent e) {
        //do nothing lmao
    }
    @Override
    public void keyReleased(KeyEvent e) { 
        if(e.getKeyCode() == KeyEvent.VK_W) {
            
        }
        if(e.getKeyCode() == KeyEvent.VK_A) {
            
        }
        if(e.getKeyCode() == KeyEvent.VK_S) {
            
        }
        if(e.getKeyCode() == KeyEvent.VK_D) {
            
        }
    }
}
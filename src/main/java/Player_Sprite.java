import java.awt.event.*; 
import java.awt.*; 

public class Player_Sprite extends Test_Sprite implements KeyListener{
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
    @Override
    public void keyPressed(KeyEvent e) { 
        if(e.getKeyCode() == KeyEvent.VK_W) {
            dy -= 1; 
            System.out.println("W pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_A) {
            dx -= 1; 
            System.out.println("A pressed"); 
        }
        if(e.getKeyCode() == KeyEvent.VK_S) {
            dy += 1; 
            System.out.println("S pressed");
        }
        if(e.getKeyCode() == KeyEvent.VK_D) {
            dx += 1; 
            System.out.println("D pressed"); 
        }
    }
    @Override 
    public void keyTyped(KeyEvent e) {
        //do nothing lmao
    }
    public void keyReleased(KeyEvent e) { 
        //do nothing for now 
    }
}
import java.awt.*; 
import java.awt.event.*; 

public class Tst implements KeyListener{
    static boolean keepGoing;
    public static void main(String [] args) {
        keepGoing = true; 
        Test_Scene scn = new Test_Scene(640, 480, Color.WHITE);
        scn.start(); 
        Test_Sprite sprite = new Test_Sprite(scn);
        sprite.setBoundAction(Test_Sprite.BOUNCE);
        sprite.setSpeedRTheta(20, -45);
        scn.addSprite(sprite); 
        while (keepGoing) {
            scn.update(); 
            
        }
        scn.end(); 
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Q) { 
            keepGoing = false; 
        }
        
        if(e.getKeyCode() == KeyEvent.VK_W) {
            
        }
        if(e.getKeyCode() == KeyEvent.VK_A) {
            
        }
        if(e.getKeyCode() == KeyEvent.VK_S) {
            
        }
        if(e.getKeyCode() == KeyEvent.VK_D) {
            
        }
    }
    
    @Override 
    public void keyTyped(KeyEvent e) {
        
    }
    @Override
    public void keyReleased(KeyEvent e) { 
        
    }
}

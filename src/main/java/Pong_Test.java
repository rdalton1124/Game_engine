import default_elements.*; 
import pong_elements.*; 
import java.awt.*; 
import java.util.*; 

public class Pong_Test {
    public static void main(String args[]) {
        Test_Scene scn = new Test_Scene(640, 480, Color.GREEN); 
        
        Pong_Player_Sprite plyr1 = new Pong_Player_Sprite(scn, Color.WHITE, 20, 75, 40, 215); 
        Pong_Player_Sprite plyr2 = new Pong_Player_Sprite(scn, Color.WHITE, 20, 75, 580, 215); 
        
        plyr1.setBoundAction(Test_Sprite.STOP);
        plyr2.setBoundAction(Test_Sprite.STOP); 
        
        plyr1.setControls(Player_Sprite.WASD);
        plyr2.setControls(Player_Sprite.IJKL);
        
        scn.setName("Pong"); 
        scn.addSprite(plyr1);
        scn.addSprite(plyr2); 
        scn.addKeyListener(plyr1);
        scn.addKeyListener(plyr2); 
        
        scn.start(); 
        
        new Timer().schedule(new TimerTask() {
           @Override
            public void run() {
               scn.update(); 
           } 
        }, 0, 30);
        
    }
}

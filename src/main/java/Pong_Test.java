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
        
        plyr1.setSound("sounds/click.wav", Test_Sprite.STOP);
        plyr2.setSound("sounds/click.wav", Test_Sprite.STOP);
        
        Pong_Ball balls = new Pong_Ball(scn, Color.WHITE, 20, 20, 300, 220); 
        balls.setSound("sounds/harsh_bump1.wav", Test_Sprite.BOUNCE); 
        balls.setSound("sounds/respawn.wav", Test_Sprite.RESPAWN); 
        
        if(Math.random() < .5) 
            balls.setSpeedRTheta(10, 0);
        else
            balls.setSpeedRTheta(10, 180);
        
        scn.setName("Pong"); 
        scn.addSprite(plyr1);
        scn.addSprite(plyr2); 
        scn.addKeyListener(plyr1);
        scn.addKeyListener(plyr2); 
        
        scn.addSprite(balls); 
        
        scn.start(); 
        
        new Timer().schedule(new TimerTask() {
           @Override
            public void run() {
               scn.update(); 
               if(balls.collidesWith(plyr1) || balls.collidesWith(plyr2)) {
                   balls.bounce();
                   scn.setBgColor(Color.RED); 
               }
               else
                   scn.setBgColor(Color.GREEN); 
           } 
        }, 0, 30);
        
    }
}

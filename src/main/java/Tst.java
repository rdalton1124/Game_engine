import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 

public class Tst {
    public static void main(String [] args) {
        Test_Scene scn = new Test_Scene(640, 480, Color.GRAY);
        
        Test_Sprite test_img = new Test_Sprite(scn, "img/futbol.png", 50, 50); 
        test_img.setBoundAction(Test_Sprite.BOUNCE);
        test_img.setSpeedRTheta(10, -45); 
        
        Player_Sprite plyr = new Player_Sprite(scn, "img/baseball.png", 50, 50); 
        plyr.setBoundAction(Test_Sprite.WRAP);
        
        scn.addSprite(plyr); 
        scn.addSprite(test_img);
        scn.addKeyListener(plyr);
        scn.start(); 
        
        new Timer().schedule(new TimerTask() {
           public void run() {
               scn.update(); 
               if(test_img.collidesWith(plyr))
                   scn.setBgColor(Color.RED);
               else
                   scn.setBgColor(Color.GRAY); 
           } 
        }, 0, 30);
    }
}

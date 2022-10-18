import default_elements.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 

public class Tst {
    public static void main(String [] args) {
        Test_Scene scn = new Test_Scene(640, 480, Color.GRAY);
        
        Test_Sprite_Junior test_img = new Test_Sprite_Junior(scn, "img/futbol.png", 50, 50); 
        test_img.setXBoundAction(Test_Sprite.WRAP);
        test_img.setYBoundAction(Test_Sprite.BOUNCE);
        test_img.setSpeedRTheta(10, -45); 
        
        Player_Sprite plyr = new Player_Sprite(scn, "img/baseball.png", 50, 50); 
        plyr.setBoundAction(Test_Sprite.WRAP);
        
        Test_Sprite boring = new Test_Sprite(scn); 
        Test_Sprite sk8 = new Test_Sprite(scn, "img/sk9.png", 68, 17); 
        scn.setName("Test Game"); 
        scn.addSprite(plyr); 
        scn.addSprite(test_img);
        scn.addSprite(boring); 
        scn.addSprite(sk8); 
        scn.addKeyListener(plyr);
        scn.start(); 
        
        new Timer().schedule(new TimerTask() {
           public void run() {
               scn.update(); 
               if(sk8.collidesWith(plyr))
                   scn.setBgColor(Color.RED);
               else
                   scn.setBgColor(Color.GRAY); 
           } 
        }, 0, 30);
    }
}

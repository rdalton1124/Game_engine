import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 

public class Tst {
    static boolean keepGoing;
    public static void main(String [] args) {
        keepGoing = true; 
        Test_Scene scn = new Test_Scene(640, 480, Color.WHITE);
      /*
        Test_Sprite sprite = new Test_Sprite(scn);
        8sprite.setBoundAction(Test_Sprite.BOUNCE);
        sprite.setSpeedRTheta(15, -45);
        scn.addSprite(sprite);
        
        Test_Sprite blu = new Test_Sprite(scn, Color.BLUE, 25, 40, 400, 300);
        blu.setBoundAction(Test_Sprite.WRAP);
        blu.setSpeedRTheta(10, 30); 
        scn.addSprite(blu);
*/
      
        Test_Sprite test_img = new Test_Sprite(scn, "src/main/java/soccer.png", 50, 50); 
        test_img.setBoundAction(Test_Sprite.BOUNCE);
        test_img.setSpeedRTheta(10, -45); 
        Player_Sprite plyr = new Player_Sprite(scn); 
        scn.addSprite(plyr); 
        scn.addSprite(test_img);
        scn.start(); 
        new Timer().schedule(new TimerTask() {
           public void run() {
               scn.update(); 
           } 
        }, 0, 30);
    }
}

import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 

public class Tst {
    static boolean keepGoing;
    public static void main(String [] args) {
        keepGoing = true; 
        Test_Scene scn = new Test_Scene(640, 480, Color.GRAY);
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
      
        Test_Sprite test_img = new Test_Sprite(scn, "src/main/java/futbol.png", 50, 50); 
        test_img.setBoundAction(Test_Sprite.BOUNCE);
        test_img.setSpeedRTheta(10, -45); 
        Player_Sprite plyr = new Player_Sprite(scn, "src/main/java/baseball.png", 50, 50); 
        scn.addSprite(plyr); 
        scn.addSprite(test_img);
        scn.start(); 
        new Timer().schedule(new TimerTask() {
           public void run() {
               scn.update(); 
               if(test_img.collidesWith(plyr))  {
                   scn.setBgColor(Color.RED); 
                   System.out.println("Collision"); 
               }
               else {
                   scn.setBgColor(Color.GRAY);
               }
           } 
        }, 0, 30);
    }
}

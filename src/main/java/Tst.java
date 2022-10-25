import default_elements.*; 
import java.awt.*; 
import java.util.*; 

public class Tst {
    public static void main(String [] args) {
        Scene scn = new Scene(640, 480, Color.GRAY);
        
        Sprite_Junior test_img = new Sprite_Junior(scn, "img/futbol.png", 50, 50);
        test_img.setXBoundAction(Sprite.WRAP);
        test_img.setYBoundAction(Sprite.BOUNCE);
        test_img.setSpeedRTheta(10, -45); 
        
        Player_Sprite plyr = new Player_Sprite(scn, "img/baseball.png", 50, 50); 
        plyr.setBoundAction(Sprite.WRAP);
        plyr.setSound("sounds/bump.wav", Sprite.BOUNCE); 
        plyr.setSound("sounds/wrap.wav", Sprite.WRAP);
        plyr.setControls(Player_Sprite.WASD);
        
        Player_Sprite plyr2 = new Player_Sprite(scn, "img/baseball2.png", 50, 50); 
        plyr2.setBoundAction(Sprite.WRAP);
        plyr2.setSound("sounds/bump.wav", Sprite.BOUNCE);
        plyr2.setSound("sounds/wrap.wav", Sprite.WRAP); 
        plyr2.setControls(Player_Sprite.IJKL);
       
        test_img.setSound("sounds/bump.wav", Sprite.BOUNCE);
        test_img.setSound("sounds/wrap.wav", Sprite.WRAP); 
        
     
        scn.setName("Test Game"); 
        scn.addSprite(plyr);
        scn.addSprite(plyr2);
        scn.addSprite(test_img);
        scn.addKeyListener(plyr);
        scn.addKeyListener(plyr2); 
        
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

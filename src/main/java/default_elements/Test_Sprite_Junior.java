package default_elements;

import java.awt.*; 
import java.io.*;
import javax.sound.sampled.*; 
import javax.sound.sampled.spi.*; 

/*
    The proud prince of the Test_Sprite dynasty, Test_Sprite_Junior includes
    all of Test_Sprite's features and MORE!
    Now included is the ability to play sounds on collision,
    the ability to have different bound actions for different walls, 
    the ability to do some third thing I haven't come up with yet, and much, much more!

    Next time you're in the market for a Test_Sprite, consider picking up a Test_Sprite_Junior
*/

public class Test_Sprite_Junior extends Test_Sprite {
    protected int xBoundAction, yBoundAction; 
    protected Clip bounce, wrap, die; 
    protected AudioInputStream ais; 
    
    public Test_Sprite_Junior(Test_Scene scene) {
        super(scene);
    }
    public Test_Sprite_Junior(Test_Scene scene, Color color, int width, int height, int x, int y) {
        super(scene, color, width, height, x, y); 
    }
    public Test_Sprite_Junior(Test_Scene scene, String imgPath, int width, int height) {
        super(scene, imgPath, width, height); 
    }
    
    public void setSound(String sndPath, int snd) {
        try {
            ais = AudioSystem.getAudioInputStream(new File(sndPath)); 
            if(snd == BOUNCE) {
                bounce = AudioSystem.getClip(); 
                bounce.open(ais);
            }
            else if(snd == WRAP) {
                wrap = AudioSystem.getClip(); 
                wrap.open(ais);
            }
            else if(snd == DIE) {
                die = AudioSystem.getClip(); 
                die.open(ais); 
            } 
            
        }
        catch(Exception e) {
            System.out.println("Exception occurred"); 
            System.out.println(e.getLocalizedMessage()); 
        }
    }
    
    @Override
    public void setBoundAction(int ba) {
        xBoundAction = ba; 
        yBoundAction = ba; 
    }
    public void setXBoundAction(int xba) {
        xBoundAction = xba; 
    }
    public void setYBoundAction(int yba) {
        yBoundAction = yba;
    }
    
    @Override 
    public void checkBoundaries() { 
        if(isLeftColliding() || isRightColliding()) {
            switch(xBoundAction) {
                case BOUNCE -> {
                    dx *= -1; 
                    bounce.loop(1);
                }
                case WRAP -> {
                    wrap.loop(1);
                    if(isLeftColliding()) 
                        x = sceneWidth - width;
                    else
                        x = 1;
                }
                case DIE -> {
                }
                case SLIDE -> dy = 0;
                case STOP -> {
                    dx = 0;
                    dy = 0;
                    ddx = 0;
                    ddy = 0;
                }
                case RESPAWN -> {
                    x = rand.nextInt(sceneWidth - width); 
                    y = rand.nextInt(sceneHeight - height); 
                    setSpeedRTheta(10, rand.nextInt(360)); 
                }
                default -> {
                } 
            }
        }
        if(isTopColliding() || isBottomColliding()) {
            switch(yBoundAction) {
                case BOUNCE -> {
                    dy *= - 1;
                    bounce.loop(1); 
                }
                case WRAP -> {
                    wrap.loop(1);
                    if(isTopColliding())
                        y = sceneHeight - height - 26;
                    else
                        y = 1;
                }
                case DIE -> {
                }
                case SLIDE -> dx = 0;
                case STOP -> {
                    dx = 0; 
                    dy = 0;
                    ddx = 0;
                    ddy = 0;
                }
                case RESPAWN -> {
                    x = rand.nextInt(sceneWidth - width); 
                    y = rand.nextInt(sceneHeight - height);
                    setSpeedRTheta(10, rand.nextInt(360)); 
                }
                default -> {
                } 
            }
        }
    }
   
}

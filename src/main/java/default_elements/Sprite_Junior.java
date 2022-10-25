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

public class Sprite_Junior extends Sprite {
    protected int xBoundAction, yBoundAction; 
    protected Clip bounce, wrap, die, slide, stop, respawn;  
    protected AudioInputStream ais; 
    
    public Sprite_Junior(Scene scene) {
        super(scene);
    }
    public Sprite_Junior(Scene scene, Color color, int width, int height, int x, int y) {
        super(scene, color, width, height, x, y); 
    }
    public Sprite_Junior(Scene scene, String imgPath, int width, int height) {
        super(scene, imgPath, width, height); 
    }
    
    public void setSound(String sndPath, int snd) {
        try {
            ais = AudioSystem.getAudioInputStream(new File(sndPath)); 
            switch (snd) {
                case BOUNCE:
                    bounce = AudioSystem.getClip();
                    bounce.open(ais);
                    break;
                case WRAP:
                    wrap = AudioSystem.getClip();
                    wrap.open(ais);
                    break;
                case DIE:
                    die = AudioSystem.getClip();
                    die.open(ais);
                    break;
                case SLIDE:
                    slide = AudioSystem.getClip();
                    slide.open(ais);
                    break;
                case STOP:
                    stop = AudioSystem.getClip();
                    stop.open(ais);
                    break;
                case RESPAWN:
                    respawn = AudioSystem.getClip();
                    respawn.open(ais);
                    break;
                default:
                    break;
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
                    if(isLeftColliding()) 
                        x = sceneWidth - width;
                    else
                        x = 1;
                    
                    wrap.loop(1); 
                }
                case DIE -> {
                    die.loop(1);
                }
                case SLIDE -> {
                    dy = 0; 
                    
                    slide.loop(1);
                }
                case STOP -> {
                    dx = 0;
                    dy = 0;
                    ddx = 0;
                    ddy = 0;
                    
                    stop.loop(1);
                }
                case RESPAWN -> {
                    x = rand.nextInt(sceneWidth - width); 
                    y = rand.nextInt(sceneHeight - height); 
                    setSpeedRTheta((int) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)), rand.nextInt(360)); 
                    
                    respawn.loop(1); 
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
                    if(isTopColliding())
                        y = sceneHeight - height - 26;
                    else
                        y = 1;
                    
                    wrap.loop(1); 
                }
                case DIE -> {
                    die.loop(1);
                }
                case SLIDE -> {
                    dx = 0; 
                    
                    slide.loop(1); 
                }
                case STOP -> {
                    dx = 0; 
                    dy = 0;
                    ddx = 0;
                    ddy = 0;
                    
                    stop.loop(1);
                }
                case RESPAWN -> {
                    x = rand.nextInt(sceneWidth - width); 
                    y = rand.nextInt(sceneHeight - height);
                    setSpeedRTheta((int) Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)), rand.nextInt(360));
                    
                    respawn.loop(1); 
                }
                default -> {
                } 
            }
        }
    }
   
}
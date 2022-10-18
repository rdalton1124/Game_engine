package default_elements;
import java.awt.*; 


/*
    The proud prince of the Test_Sprite dynasty, Test_Sprite_Junior includes
    all of Test_Sprite's features and MORE!
    Now included is the ability to play sounds on collision,
    the ability to have different bound actions for different walls, 
    the ability to do some third thing I haven't come up with yet, and much, much more!

    Next time you're in the market for a Test_Sprite, consider picking up a Test_Sprite_Junior
*/

public class Test_Sprite_Junior extends Test_Sprite {
    private int xBoundAction, yBoundAction; 
    public Test_Sprite_Junior(Test_Scene scene) {
        super(scene);
    }
    public Test_Sprite_Junior(Test_Scene scene, Color color, int width, int height, int x, int y) {
        super(scene, color, width, height, x, y); 
    }
    public Test_Sprite_Junior(Test_Scene scene, String imgPath, int width, int height) {
        super(scene, imgPath, width, height); 
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
                case BOUNCE:
                    dx *= -1; 
                    break; 
                case WRAP:
                    if(isLeftColliding()) 
                        x = sceneWidth - width;
                    else
                        x = 1; 
                    break;
                case DIE: 
                    break;
                case SLIDE: 
                    dy = 0;
                    break;
                case STOP:
                    dx = 0;
                    dy = 0; 
                    ddx = 0; 
                    ddy = 0; 
                    break; 
                default: 
                    break; 
            }
        }
        if(isTopColliding() || isBottomColliding()) {
            switch(yBoundAction) {
                case BOUNCE: 
                    dy *= -1; 
                    break; 
                case WRAP:
                    if(isTopColliding())
                        y = sceneHeight - height; 
                    else 
                        y = 1; 
                    break; 
                case DIE: 
                    break; 
                case SLIDE:
                    dx = 0; 
                    break;
                case STOP:
                    dx = 0; 
                    dy = 0;
                    ddx = 0; 
                    ddy = 0; 
                    break; 
                default:
                    break; 
            }
        }
    }
   
}

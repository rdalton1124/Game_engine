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
    
    @Override
    public void setBoundAction(int ba) {
        xBoundAction = ba; 
        yBoundAction = ba; 
    }
    
    
}

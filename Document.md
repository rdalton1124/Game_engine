#Test_Sprite

##Variables
- Width, height: width and height of the sprite. Controls both appearance and collision
- x,y: location. Specifically refers to the top-left corner of the image/shape
- dx, dy: velocity. Measured in pixels/frame
- ddx, ddy: if you wish you can set an acceleration
- SceneHeight, SceneWidth: The size of the scene. Cannot be directly changed and is set when the scene is passed to the sprite constructor. Used to check boundaries
- BoundAction: Controls what happens when the sprite hits a wall. Options are BOUNCE, WRAP, DIE, SLIDE, STOP, and KEEP_GOING. Default is BOUNCE
- Color: The color. Used if your sprite is just a rectangle 

##Methods
###SetBoundAction
 - Sets bound action of the sprite. Takes one of the aforementioned bound actions. They are static so you can do it as setBoundAction(Test_Sprite.SLIDE)
 - If you enter an invalid number, this method will just do nothing. 
###ShowStatus
 - Just prints the current status of the sprite to a console. This includes location, velocity and size. 
###SetSpeedRTheta
 - Set velocity using a magnitude and angle. 
 - Angle is in degrees, but follows the same pattern as radians. I.E. 0 is directly right, 90 is directly up, 180 is directly left and 270 is directly down. 
###SetSpeedXY
- Just sets dx and dy equal to the values passed. 
###CheckBoundaries
- Checks to see if sprite has hit a wall and reacts accordingly.
###hide and show
- used to set visibility of the sprite. 
###Getters and setters
- getX, getY: Get the x and y components of locatoin
- getHeight, getWidth: Get the height and width
- getColor: Get the color. 


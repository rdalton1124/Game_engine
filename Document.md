#General Notes

##How to run
- The main method is in pong_test. 
- I'm having problems with the way the sound files are set up. For now, I've uploaded an executable jar without any sound. 

##How to play
- It's just pong. You use W and D to move the left paddle, and I and K to move the right paddle. 
- There's no real score system or anything. 

##Problems 
- The ball would benefit from a max speed. It speeds up every time it hits a paddle and very quickly gets too fast keep track of. The collision also sometimes fails due to this. The collision also snags sometimes when it's too fast.
- Sometimes when the ball respawns, it's moving completely vertically and it'll get stuck forever. 
- The pong ball has no regard for what side of the paddle it hits, so it will react the same way if it hits the back of the paddle as if it hits the front. This looks unnatural. 
- It sometimes lags and I'm not sure why.

##Other notes
- Default elements package contains generic elements for the game engine itself. 
- Pong elements package continas the pong_Ball and pong_player_sprite. 
- Timing is taken care of in the pong test. 
- I put the whole netbeans project onto the github. The source files are in src/main/java
- sounds contains sounds and img contains some images I used in testing. None of the images are needed for the final project but the click.wav, harsh_bump1.wav and respawn.wav are all used. The code uses a relative path so there shouldn't be too much trouble, but I'll still get an executable uploaded ASAP in case of problems. 

#Sprite

##Notes
- If an image is not specified the sprite will just be a rectangle. If a color is not specified for the rectangle, the rectangle will be red. 

##Constructors
- (scene): Creates a 50 x 50 red square in the middle of the screen. 
- (scene, color, width, height, x, y): Creates a (width x height) rectangle with color color and places the top left corner at (x, y)
- (scene, imgPath, width, height): Attempts to read an image from imgPath. If read is unsuccessful, it will just do a red rectangle. Image will be in top left corner
- (scene, imgPath, width, height, x, y): Same as above but will put top left corner of image at (x, y). 

##Variables
- Width, height: width and height of the sprite. Controls both appearance and collision
- x,y: location. Specifically refers to the top-left corner of the image/shape
- dx, dy: velocity. Measured in pixels/frame
- ddx, ddy: if you wish you can set an acceleration
- SceneHeight, SceneWidth: The size of the scene. Cannot be directly changed and is set when the scene is passed to the sprite constructor. Used to check boundaries
- visible: is sprite visible? Currently does not affect anything. 
- Color: The color. Used if your sprite is just a rectangle 
- img: an image. Optional. 
- BoundAction: Controls what happens when the sprite hits a wall. Options are BOUNCE, WRAP, DIE, SLIDE, STOP, KEEP_GOING, and RESAPWN. Default is BOUNCE

###Bound Actions 
- Bounce: Negates dx if hitting left or right wall and negates dy if hitting top or bottom. It's a flat-out negation, there's no speed loss
- Wrap: Goes to the opposite wall. There is no speed loss
- Die: 
- Slide: sets dx to 0 if hitting a left or right wall. Sets dy to 0 if hitting a top or bottom wall. The other speed element is not affected. 
- Stop: dx, dy, ddx and ddy are all set to 0. This causes a bit of problems if you want to move the stopped sprite again, since it's still registered as hitting the wall. I'm gonna change it to move the sprite down a pixel if it collides
- Keep going: 
- Respawn: Sprite is put in a random location, moving at a random directon. The velocity is kept relatively stable compared to where it was before. 

##Methods

###update
- Called by the scene's update function. Will update velocity and location, then check boudnaries. 

###getImage
- Returns the image

###hasImage
 - returns true if using an image.

###SetBoundAction
 - Sets bound action of the sprite. Takes one of the aforementioned bound actions. They are static so you can do it as setBoundAction(Test_Sprite.SLIDE)
 - If you enter an invalid number, this method will just do nothing. 

###collidesWith
- Pass another sprite to this and it will return a boolean describing whether the sprite is colliding with the other sprite. 
- Uses AABB Collision detection. 

###ShowStatus
 - Just prints the current status of the sprite to a console. This includes location, velocity and size. 

###SetSpeedRTheta
 - Set velocity using a magnitude and angle. 
 - Angle is in degrees, but follows the same pattern as radians. I.E. 0 is directly right, 90 is directly up, 180 is directly left and 270 is directly down. 

###SetSpeedXY
- Just sets dx and dy equal to the values passed. 

###CheckBoundaries
- Checks to see if sprite has hit a wall and reacts accordingly.

###Boundary checkers
- isTopColliding, isBottomColliding, isLeftColliding, isRightColliding
- Returns a boolean describing whether the sprite is colliding with the specified wall. 

###hide and show
- used to set visibility of the sprite. 
- This is functionally useless, since my engine doesn't currently test for visibility  

###Getters and setters
- getX, getY: Get the x and y components of locatoin
- getHeight, getWidth: Get the height and width
- getColor: Get the color. 
- addDX, addDY: Add the passed value to the current dx or dy. 
- getR: Gets the radius (aka velocity) of the sprite
- getTheta: Gets the angle that the sprite is currently travelling in. Kind of buggy at the momment. 

#Sprite_Junior

##Notes
- An updated child of the Test_Sprite. Added functionality includes collision sounds and the ability to set different bound actions for top/bottom and left/right

##Variables
- xBoundAction: Bound action for top and bottom walls
- yBoundAction: Bound action for left and right walls
- bounce, wrap, die: The sound files for bouncing, wrapping, or dying. 

##Constructors
- The constructors all call the corresponding Test_Sprite constructor

##Methods
- setSound: Tries to set a sound. Takes a clip and an int specifying which sound you want to set. Use the same static ints you use to set bound action to tell if what sound you want to set. 
- setXBoundAction, setYBoundAction: sets the specified bound action
- setBoundAction: sets both boundActions to something. 
- checkBoundaries: Does the same thing as before, but now considers top/bottom and left/right separately. 

#Player_Sprite

##Notes
- Player Sprite is a keylistener. Have to scene.addKeyListener(sprite) for each player object.  
- From my testing, everything seems to work fine with multiple players. 

##Variables
- maxDX, maxDY: a maximum value for dx and dy. As a side effect of doing it this way, sprites can travel faster diagonally than they can orthogonally. They're both 15 right now. 
- keysDown: An arrayList of integers reperesenting the keys which are currently being held down. 
- up, down, left, right: These are integers which reperesent the keys assigned to movement. 

##Constructors
- (scene): Calls parent's (scene) constructor and sets dx, dy, ddx and ddy all equal to 0. 
- (scene, color, width, height, x, y): Calls parent constructor then sets dx, dy, ddx and ddy all equal to 0. 
- (scene imgpath, width, height): Attempts to load imgPath and creates a red rectangle if it can't be loaded. Moves sprite to center. 

##Methods

###setControls
- Sets up, left, down and right. Can pass it 4 integers representing the keys for the controls.
- Can also pass it Player_Sprite.WASD or Player_Sprite.IJKL to quickly set the values to WASD or IJKL. 

###update
- Checks to see if one of the movement keys is pressed, and adjusts dx and dy accordingly. 
- Then it just calls the parent's update function. 

###keyPressed
- Called when you press a key. Adds the pressed key to keysDown

###keyTyped 
- Does nothing.
-  
###keyReleased
- Called when a key is released. Removes the key from keysDown
- If released key is one of the movement keys, it sets the velocity for that axis to 0. 

#Player2_Sprite
 - This is a depracated class. I initally had the player controls hardcoded in and needed to make a new class to support IJKL for player 2
 - This didn't work well because Java doesn't support 2 keyListeners well, so I redid everything regarding controls. 

#Pong_Ball

##Notes
- a pong-specific class, made for the pong ball. 

##Variables
- Pong_Ball has no variables specific to itself. 
- xBoundAction and yBoundAction are pre-set to RESPAWN and BOUNCE, respectively. These cannot be changed. 

##Constructors
- (scene): Calls parent constructor and sets bound actions
- (scene, color, width, height, x, y): Calls parent constructor and sets bound actions. 

##Methods
- the set bound action methods have all been modified to do nothing. This is to prevent the user from inadvertently changing them. 

###Bounce
- Called when the ball collides with a paddle. 
- Reverses the dx and randomly adds or subtracts a small amount from the dy so that the angle of the ball is not as predictable. 

#Pong_Player_Sprite

##Notes
- A pong-specific sprite. It's basically a player_sprite with horizontal movement removed. 

##Variables
- pong_player_sprite has no variables specific to itself 

##Constructors
- (scene): Calls parent constructor
- (scene, color, width, height, x, y): Calls parent constructor 

##Methods 
- update: moves vertically
- checkBoundaries: Checks to see if player has hit the top or bottom wall. If it has hit the top wall, prevents upward movement and prevents downward movement if it has hit the bottom wall. 

#Scene

##Variables
 - width, height: Width and height of the window
 - Canvas: A canvas to draw on. Not really used by the user
 - bg: A background color
 - sprites: an arraylist of all sprites
 - 
##Methods

###start
- creates the canvas and sets up the window. Ideally called after adding all the sprites
###update
- Repaints the canvas and calls the update functions of all the sprites
- 
###Add sprite
-Takes a sprite and adds it to the arraylist

###getters and setters
-getHeight, getWidth: gets the height and with
-getBgColor: gets the background color
-setName: Sets the title for the window. Must be done before starting scene. If one is not set, the window will just be named "My Game" 

#Canvas
-Not really used by the user. Is what actually draws everything to the window. Is repainted in the scene's update function 


import javax.swing.*; 
import java.awt.*; 
public class Test_Sprite {
    
    private int x, y; 
    private int dx, dy; 
    private int ddx, ddy; 
    private int width, height; 
    
    private int boundAction; 
    private int sceneHeight, sceneWidth; 
    private boolean visible; 
    private Color color; 
    public static final int BOUNCE = 1, WRAP = 2, DIE = 3, SLIDE = 4, STOP = 5, KEEP_GOING = 6; 
    
    private Test_Scene scn; 
    public Test_Sprite(Test_Scene scene) {
        scn = scene;  
        width = 50; 
        height = 50; 
        color = Color.RED; 
      
        sceneHeight = scene.getHeight();
        sceneWidth = scene.getWidth(); 
        
        //set to middle of screen by default
        x = (sceneWidth / 2) - (width / 2); 
        y = (sceneHeight / 2) - (height / 2); 
    }
    public Test_Sprite(Test_Scene scene, Color color, int width, int height, int x, int y) {
        this.width = width; 
        this.height = height; 
        this.color = color; 
        scn = scene;
        this.x = x;  
        this.y = y; 
    }
    public Test_Sprite(Test_Scene scene, Image img, int width, int height) { 
        this.width = width; 
        this.height = height;
        
        sceneHeight = scene.getHeight(); 
        sceneWidth = scene.getWidth(); 
    }
    
    public void update() {
        checkBoundaries(); 
        dx += ddx; 
        dy += ddy; 
        x += dx;
        y += dy; 
    }
    
    public void setBoundAction(int ba) {
        if(ba >= 1 && ba <= 6) 
            boundAction = ba; 
    }
    public void showStatus() { 
        System.out.println("My collision box is " + width + " x " + height); 
        System.out.println("I am at (" + x + ", " + y + ")");
        System.out.println("I am moving at " + dx + " u/f horizontally and " + dy + "u/f vertically" + "\n\n");
        
    }
    //checks to see if the sprite is colliding with any of the bounds of the scene. 
    private boolean isTopColliding(){
        return y < 0; 
    }
    private boolean isBottomColliding() {
        return (y + height) > sceneHeight - 26; 
    }
    private boolean isLeftColliding() {
        return x < 0; 
    }
    private boolean isRightColliding() {
        return (x + width) > sceneWidth; 
    }
    
    public int getX() {return x;}
    public int getY() {return y;}
    public int getWidth() {return width;}
    public int getHeight() {return height;} 
    public Color getColor() {return color;} 
    
    public void addDX(int ndx) {
        dx += ndx; 
    }
    public void addDY(int ndy)  {
        dy += ndy; 
    }
    
    public void show() {
        visible = true; 
    }
    public void hide() {
        visible = false; 
    }
    
    
    public void setSpeedRTheta(int velocity, int angle) {
        dx = (int) Math.round(velocity * Math.cos((Math.PI / 180)  * angle));
        dy = (int) -Math.round(velocity * Math.sin((Math.PI / 180) * angle)); 
    }
    public void setSpeedXY(int dx, int dy) {
        this.dx = dx; 
        this.dy = dy; 
    }
    
    public void checkBoundaries() {
        //The IDE recommended that I do it like this
        //If this doesn't work, switch it back to else-if and sue NetBeans for emotional damages. 
        switch (boundAction) {
            case BOUNCE -> {
                if(isTopColliding() || isBottomColliding()) {
                    ddy *= -1;
                    dy *= - 1;
                }   if (isLeftColliding() || isRightColliding()) {
                    ddx *= -1;
                    dx *= -1;
                }
            }
            case WRAP -> {
                if(isTopColliding()) {
                    y = sceneHeight - 1;
                }
                else if(isBottomColliding()) {
                    y = 1;
                }    
                if(isLeftColliding()) {
                    x = sceneWidth - 1;
                }
                else if(isRightColliding()) {
                    x = 1;
                }
            }
            case DIE -> {
            }
            case SLIDE -> {
                if(isTopColliding() || isBottomColliding()) {
                    ddy = 0;
                    dy = 0;
                }   if(isLeftColliding() || isRightColliding()) {
                    ddx = 0;
                    dx = 0;
                }
            }
            case STOP -> {
                if(isTopColliding() || isBottomColliding() ||
                        isLeftColliding() || isRightColliding()) {
                    ddx = 0;
                    ddy = 0;
                    dx = 0;
                    dy = 0;
                }
            }
            default -> {
            }
        }
       
    }
    
}

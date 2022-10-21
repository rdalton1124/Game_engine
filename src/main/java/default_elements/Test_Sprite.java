package default_elements;

import java.awt.*; 
import java.awt.image.*; 
import java.io.*; 
import javax.imageio.*; 
import javax.swing.*; 

public class Test_Sprite extends JComponent{
    protected int x, y; 
    protected int dx, dy; 
    protected int ddx, ddy; 
    protected int width, height; 
    
    protected int boundAction; 
    protected int sceneHeight, sceneWidth; 
    protected boolean visible; 
    
    protected boolean hasImage; 
    protected Image img; 
    protected Color color; 
    
    public static final int BOUNCE = 1, WRAP = 2, DIE = 3, SLIDE = 4, STOP = 5, KEEP_GOING = 6; 
    
    public Test_Sprite(Test_Scene scene) {
        //set everything to a default value 
        this(scene, Color.RED, 50, 50, ((scene.getWidth() / 2) - 25), ((scene.getWidth() / 2) - 25)); 
    }
    public Test_Sprite(Test_Scene scene, Color color, int width, int height, int x, int y) { 
        this.width = width; 
        this.height = height; 
        this.color = color; 
        
        
        sceneHeight = scene.getHeight(); 
        sceneWidth = scene.getWidth(); 
   
        this.x = x;  
        this.y = y; 
    }
    public Test_Sprite(Test_Scene scene, String imgPath, int width, int height) { 
        this(scene, imgPath, width, height, 0, 0); //set to top left corner. 
    }
    public Test_Sprite(Test_Scene scene, String imgPath, int width, int height, int x, int y) {
        this.width = width; 
        this.height = height; 
        this.x = x; 
        this.y = y;
        
        sceneHeight = scene.getHeight(); 
        sceneWidth = scene.getWidth(); 
        
        try {
            BufferedImage bi = ImageIO.read(new File(imgPath)); 
            img = bi.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        }
        catch(IOException e) { 
            this.color = Color.RED; 
        }
    }
    
    public void update() {
        checkBoundaries(); 
        dx += ddx; 
        dy += ddy; 
        x += dx;
        y += dy; 
    }
    
    public Image getImage() {
        return img; 
    }
    public boolean hasImage() { 
        return !(img == null); 
    }
    
    public void setBoundAction(int ba) {
        if(ba >= 1 && ba <= 6) 
            boundAction = ba; 
    }
    
    public boolean collidesWith(Test_Sprite other)  {
        if(x > other.x + other.width || //my left side is to your right
                x + width < other.x) //my right side is to your left
            return false; 
        else if (y > other.y + height || //my top side is below your bottom
                y + height < other.y)  //my bottom side is above your top
            return false;
        else
            return true; 
        
    } 
    
    public void showStatus() { 
        System.out.println("My collision box is " + width + " x " + height); 
        System.out.println("I am at (" + x + ", " + y + ")");
        System.out.println("I am moving at " + dx + " u/f horizontally and " + dy + "u/f vertically" + "\n\n");
    }
     
    //checks to see if the sprite is colliding with any of the bounds of the scene. 
    protected boolean isTopColliding(){
        return y < 0; 
    }
    protected boolean isBottomColliding() {
        return (y + height) > sceneHeight - 26;
        //26 is the height of the title bar in the java window
    }
    protected boolean isLeftColliding() {
        return x < 0; 
    }
    protected boolean isRightColliding() {
        return (x + width) > sceneWidth; 
    }
    
    public int getX() {return x;}
    public int getY() {return y;}
    public int getWidth() {return width;}
    public int getHeight() {return height;} 
    public Color getColor() {return color;} 
    
    public void addDX(int ndx) {dx += ndx;}
    public void addDY(int ndy)  {dy += ndy;}
    
    public void show() {visible = true;}
    public void hide() {visible = false;}
    
    
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
                    y = sceneHeight - height;
                    y -= 50; 
                }
                else if(isBottomColliding()) {
                    y = 1;
                }    
                if(isLeftColliding()) {
                    x = sceneWidth - width;
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

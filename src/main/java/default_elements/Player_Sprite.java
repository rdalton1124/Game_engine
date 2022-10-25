package default_elements;

import java.awt.event.*; 
import java.awt.*; 
import java.util.*; 
public class Player_Sprite extends Sprite_Junior implements KeyListener{
    
    //this method works well enough but as a side effect, you can
    //go significantly faster moving diagonally. Fix later. 
    protected final int maxDX = 15, maxDY = 15; 
    protected ArrayList<Integer> keysDown = new ArrayList<Integer>(); 
    
    protected int up, left, down, right; 
    public final static int WASD = 1, IJKL = 2; 
    
    public Player_Sprite(Scene scene) {
        super(scene);
        dx = 0;
        dy = 0; 
        ddx = 0; 
        ddy = 0; 
    }
    public Player_Sprite(Scene scene, Color color, int width, int height, int x, int y) {
        super(scene, color, width, height, x, y); 
        dx = 0; 
        dy = 0; 
        ddx = 0; 
        ddy = 0; 
    }
    public Player_Sprite(Scene scene, String imgPath, int width, int height) {
        super(scene, imgPath, width, height);
        
        //put in center
        x = (sceneWidth / 2) - (width / 2); 
        y = (sceneHeight / 2) - (height / 2);
        
        dx = 0; 
        dy = 0; 
        ddx = 0; 
        ddy = 0; 
    }
    public void setControls(int cnt) {
        if(cnt == WASD)
            setControls(KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D); 
        else if(cnt == IJKL) 
            setControls(KeyEvent.VK_I, KeyEvent.VK_J, KeyEvent.VK_K, KeyEvent.VK_L); 
    }
    public void setControls(int up, int left, int down, int right) { 
        this.up = up; 
        this.left = left; 
        this.down = down; 
        this.right = right; 
    }
    @Override
    public void update() {
        if(keysDown.contains(up)) { 
            dy -= 5; 
            if (dy < -maxDY)
                dy = -maxDY; 
        }
        if(keysDown.contains(left)) {
            dx -= 5; 
            if(dx < -maxDX)
                dx = -maxDX; 
        }
        if(keysDown.contains(down)) {
            dy += 5; 
            if(dy > maxDY)
                dy = maxDY; 
        }
        if(keysDown.contains(right)) {
            dx += 5; 
            if (dx > maxDX)
                dx = maxDX; 
        }
        
        super.update();  
    }
    
    @Override
    public void keyPressed(KeyEvent e) { 
       if (!keysDown.contains(e.getKeyCode()))
           keysDown.add(e.getKeyCode()); 
    }
    @Override 
    public void keyTyped(KeyEvent e) {
        //do nothing lmao
    }
    
    //fix this later 
    @Override
    public void keyReleased(KeyEvent e) {
        keysDown.remove((Integer) e.getKeyCode()); 
        if(e.getKeyCode() == up) {
            dy = 0; 
        }
        if(e.getKeyCode() == left) {
            dx = 0; 
        }
        if(e.getKeyCode() == down) {
            dy = 0; 
        }
        if(e.getKeyCode() == right) {
            dx = 0; 
        }
    }
}
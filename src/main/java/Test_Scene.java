import javax.swing.*; 
import java.awt.*; 
import java.util.*; 

public class Test_Scene extends JFrame {
    private Canvas canvas; 
    private int width, height; 
    private Color bg; 
    public ArrayList<Test_Sprite> sprites; 
    
    Test_Scene(Test_Scene scene) {
        this.width = scene.width;
        this.height = scene.height; 
        this.bg = scene.bg; 
        this.sprites = new ArrayList<Test_Sprite>(scene.sprites);
    }
    public Test_Scene(int width, int height, Color bg) {
        this.bg = bg; 
        this.width = width;
        this.height = height; 
        this.sprites = new ArrayList<Test_Sprite>(); 
    }
    
    public void start() { 
        canvas = new Canvas(this); 
        this.add(canvas, BorderLayout.CENTER); 
        this.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        this.setSize(width, height); 
        this.setVisible(true); 
    }
    public void end() {
        
    }
    public void update() { 
        canvas.repaint(); 
        for(int i = 0; i < sprites.size(); i++) {
            sprites.get(i).update(); 
        }
    }
    public void addSprite(Test_Sprite sprite) {
        sprites.add(sprite); 
    }
    
   
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width; 
    }
    public Color getBgColor() { 
        return bg; 
    }
    public void setBgColor(Color c) {
        bg = c; 
    }
}
class Canvas extends JPanel { 
    private int sceneWidth, sceneHeight; 
    private Color sceneColor;
    private Test_Scene scn; 
    public Canvas(Test_Scene scn) {
        super(true);
        this.scn = scn; 
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(scn.getBgColor()); 
        g.fillRect(0, 0, scn.getWidth(), scn.getHeight());
        System.out.println("sprites = " + scn.sprites.size());
        for (int i = 0; i < scn.sprites.size(); i++) {
            scn.sprites.get(i).showStatus();
            if(scn.sprites.get(i).hasImage()) {
               g.drawImage(scn.sprites.get(i).getImage(), scn.sprites.get(i).getX(), scn.sprites.get(i).getY(), null); 
            } 
            else {
                g.setColor(scn.sprites.get(i).getColor()); 
                g.fillRect(scn.sprites.get(i).getX(), scn.sprites.get(i).getY(),
                        scn.sprites.get(i).getWidth(), scn.sprites.get(i).getHeight());
            }
        }
    } 
}

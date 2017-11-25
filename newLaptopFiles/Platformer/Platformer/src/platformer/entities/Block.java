package platformer.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import platformer.graphics.Camera;

public class Block {
    public float x, y;
    public int width, height;
    public int scrWidth, scrHeight;
    Color color;
    Player p;
    Camera c;
    
    public Block(float x, float y, int width, int height, Color color, int scrWidth, int scrHeight, Player p, Camera c) {
        this.x = x;
        this.y = y;
        
        this.width = width;
        this.height = height;
        
        this.scrWidth = scrWidth;
        this.scrHeight = scrHeight;
        
        this.color = color;
        
        this.p = p;
        this.c = c;
        
    }
    
    public void update() {
        colisionDetection();
    }
    
    private void colisionDetection() {
        if(scrWidth/2 + p.width >= x - c.offset) {
            p.c
        }
    }
    
    public void render(Graphics2D g, float cameraOffset) {
        g.setColor(color);
        g.fillRect((int) (x - cameraOffset), (int) y, width, height);
    }
}

package platformer.entities;

import java.awt.Color;
import java.awt.Graphics2D;

public class Enemy {
    public float x, y;
    public int width, height;
    public int scrWidth, scrHeight;
    Color color;
    
    public Enemy(float x, float y, int width, int height, Color color, int scrWidth, int scrHeight) {
        this.x = x;
        this.y = y;
        
        this.width = width;
        this.height = height;
        
        this.scrWidth = scrWidth;
        this.scrHeight = scrHeight;
        
        this.color = color;
    }
    
    
    public void render(Graphics2D g, float cameraOffset) {
        g.setColor(color);
        g.fillRect((int) (x - cameraOffset), (int) y, width, height);
    }
}
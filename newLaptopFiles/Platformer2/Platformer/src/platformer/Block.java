package platformer;

import java.awt.Color;
import java.awt.Graphics2D;

public class Block {
    float x, y;
    int width, height;
    int scrWidth, scrHeight;
    Player p;
    
    public Block(float x, int width, int height, int scrWidth, int scrHeight, Player p) {
        this.x = x;
        this.width = width;
        this.height = height;
        this.y = scrHeight - height;
        this.p = p;
    }
    
    public void update() {
        colisionDetection();
    }
    
    private void colisionDetection() {
        if(p.x + p.width == x) {
            p.x = x - p.width;
            p.colideRight = true;
        }
        if(p.x == x + width) {
            p.x = x + width;
            p.colideLeft = true;
        }
    }
    
    public void render(Graphics2D g) {
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, width, height);
    }
    
}
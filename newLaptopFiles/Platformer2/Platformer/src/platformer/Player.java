package platformer;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player {
    float x, y;
    int width, height;
    float vY;
    int scrWidth, scrHeight;
    boolean colideRight, colideLeft;
    
    public Player(float x, int width, int height, int scrWidth, int scrHeight) {
        this.x = x;
        this.width = width;
        this.height = height;
        this.y = scrHeight - height;
    }
    
    public void update() {
        colisionDetection();
    }
    
    public void render(Graphics2D g) {
        g.setColor(Color.cyan);
        g.fillRect((int) x, (int) y, width, height);
    }
    
    private void colisionDetection() {
    }
    
    //movement handlers
    public void moveRight() {
        x += 5;
    }
    public void moveLeft() {
        x -= 5;
    }
}

package platformer.entities;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player {
    public float x, y;
    public int width, height;
    public int scrWidth, scrHeight;
    Color color;
    boolean jumping;
    int jumpHeight;
    int groundHeight;
    
    public Player(float x, float y, int width, int height, Color color, int scrWidth, int scrHeight, int jumpHeight) {
        this.x = x;
        this.y = y;
        
        this.width = width;
        this.height = height;
        
        this.scrWidth = scrWidth;
        this.scrHeight = scrHeight;
        this.groundHeight = scrHeight;
        
        this.jumpHeight = jumpHeight;
        
        this.color = color;
    }
    
    public void update() {
        jumpHandler();
    }
    
    private void jumpHandler() {
        if(jumping && y > groundHeight - jumpHeight){
            y-=10;
        } else {
            jumping = false;
        }
        
        if(y < groundHeight-height && !jumping){
            y+=10;
        }    
    }
    
    public void render(Graphics2D g) {
        g.setColor(color);
        g.fillRect(scrWidth / 2 - width/2, (int) y, width, height);
    }
    
    
    //handles movement
    public void moveRight() {
        if(y == groundHeight-height){
            x+=10;
        } else {
            x+=5;
        }
    }
    
    public void moveLeft(){
        if(y == groundHeight-height){
            x-=10;
        } else {
            x-=5;
        }
    }
    
    public void jump() {
        if(y == groundHeight-height){
            jumping = true;
        }
    }
}

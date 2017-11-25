package countryoutlinegen;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player {
    public float x = 400-25, y = 800-50;
    private boolean jumping = false;
    
    public void moveRight() {
        if(y == 800-50){
            x+=10;
        } else {
            x+=5;
        }
    }
    
    public void moveLeft(){
        if(y == 800-50){
            x-=10;
        } else {
            x-=5;
        }
    }
    
    public void jump() {
        if(y == 800-50){
            jumping = true;
        }
    }
    
    public void render(Graphics2D g) {
        
        if(jumping && y > 800 - 100){
            y-=10;
        } else {
            jumping = false;
        }
        
        if(y < 800-50 && !jumping){
            y+=5;
        }
        
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, 50, 50);
    }
}

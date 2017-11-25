package platformer.player;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player {
    private int width, height;
    private float vX, vY, x, y;
    public boolean jumping = false;
    private boolean right, left, jump;
    public float offset;
    
    public Player(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void update() {
        
        controller();
        
        if(y + height < 800) {
            vY+=0.3;
        }
        
        if(y + height >= 800 && !jumping) {
            y = 800 - height;
            vY=0;
        }
        
        if(jumping && vY > 0) {
            jumping = false;
        }
        
        y+=vY;
        x+=vX;
    }
    
    private void controller() {
        if(right && y + height == 800) {
            vX += 0.5;
            if(vX > 10) {
                vX = 10;
            }
        } else if(vX > 0 && y + height == 800) {
            vX-=1;
        } else if(vX > 0 && y + height < 800) {
            //air drag
        }
        
        if(left && y + height == 800) {
            vX -= 0.5;
            if(vX < -10) {
                vX = -10;
            }
        } else if(vX < 0 && y + height == 800) {
            vX+=1;
        } else if(vX < 0 && y + height < 800) {
            vX+=0.1;
        }
        
        if(jump && y + height == 800) {
            jumping = true;
            vY = -10;
        }
        
        if(!right && !left && vX<1 && vX > 0){
            vX=0;
        }
    }
    
    public void render(Graphics2D g) {
        g.setColor(new Color(0,150,255));
        g.fillRect((int) x, (int) y, width, height);
    }
    
    public void setRight (boolean state) {
        right = state;
    }
    
    public void setLeft (boolean state) {
        left = state;
    }
    
    public void setJump (boolean state) {
        jump = state;
    }
}

package countryoutlinegen;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Display extends JFrame implements KeyListener {
    int scrWidth, scrHeight;
    BufferStrategy bs;
    Player p;
    boolean left,right,jump;
    
    public Display(int scrWidth, int scrHeight) {
        this.scrWidth = scrWidth;
        this.scrHeight = scrHeight;
        p = new Player();
        
        setup();
    }
    
    private void setup() {
        this.setSize(scrWidth, scrHeight);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Sorting Visualiser");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        addKeyListener(this);
        
        this.createBufferStrategy(2);
        bs = this.getBufferStrategy();
    }
    
    public void start() {
        while(true){
            render();
            
            long time = System.currentTimeMillis();
            while(System.currentTimeMillis() - time < 1000/30){}  
        }
    }
    
    private void render() {
        Graphics2D g;
        g = (Graphics2D) bs.getDrawGraphics();
        
        if(right) {
            p.moveRight();
        }
        if(left) {
            p.moveLeft();
        }
        if(jump) {
            p.jump();
        }
        
        g.clearRect(0, 0, 800, 800);
        
        p.render(g);
        
        g.dispose();
        bs.show();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            jump = true;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        }
        
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            jump = false;
        }
    }
}

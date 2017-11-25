package platformer.graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import platformer.entities.Block;
import platformer.entities.Enemy;
import platformer.entities.Player;

public class Display extends JFrame implements KeyListener{
    
    int scrWidth, scrHeight;
    BufferStrategy bs;
    Player p;
    boolean right, left, jump;
    Block b[] = new Block[4];
    Camera c;
    
    public Display(int scrWidth, int scrHeight, Player player) {
        this.scrWidth = scrWidth;
        this.scrHeight = scrHeight;
        this.p = player;
        
        Color bC = new Color(100,0,255);
        b[0] = new Block(1000, scrHeight - 50, 50, 50, bC, 800, 800, p, c);
        b[1] = new Block(900, scrHeight - 50, 50, 50, bC, 800, 800, p, c);
        b[2] = new Block(200, scrHeight - 50, 50, 50, bC, 800, 800, p, c);
        b[3] = new Block(1050, scrHeight - 50, 50, 50, bC, 800, 800, p, c);
        c = new Camera(800,800);
        
        setup();
    }
    
    private void setup() {
        this.setSize(scrWidth, scrHeight);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Platformer");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        addKeyListener(this);
        
        this.createBufferStrategy(2);
        bs = this.getBufferStrategy();
    }
    
        public void start() {
        while(true){
            update();
            render();
           
            long time = System.currentTimeMillis();
            while(System.currentTimeMillis() - time < 1000/30){}  
        }
    }
    
        
        
    private void update() {
        keyManager();
        for(int i = 0; i < 4; i++){
            if(b[i].x + b[i].width > c.offset && b[i].x < c.offset + c.width) {
                b[i].update();
            }
        }
        p.update();
    
    }
    
    private void keyManager() {
        if(right) {
            p.moveRight();
            c.panRight();
        }
        if(left) {
            p.moveLeft();
            c.panLeft();
        }
        if(jump) {
            p.jump();
        }
    }
    
    private void render() {
        Graphics2D g;
        g = (Graphics2D) bs.getDrawGraphics();
        
        g.clearRect(0, 0, 800, 800);
        p.render(g);
        
        for(int i = 0; i < 4; i++){
            if(b[i].x + b[i].width > c.offset && b[i].x < c.offset + c.width) {
                b[i].render(g,c.offset);
            }
        }
       
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

package platformer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GameLoop extends JFrame implements KeyListener{
    
    int scrWidth, scrHeight;
    BufferStrategy bs;
    boolean right, left, jump;
    Player p;
    Block blocks[];
    
    public GameLoop(int scrWidth, int scrHeight, Player p, Block blocks[]) {
        this.scrWidth = scrWidth;
        this.scrHeight = scrHeight;
        this.p = p;
        this.blocks = blocks;
        
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
        for(int i = 0; i < blocks.length; i++) {
            blocks[i].update();
        }
        
        keyManager();
    }
    
    private void keyManager() {
        if(right && !p.colideRight) {
            p.moveRight();
        }
        if(left && !p.colideLeft) {
            p.moveLeft();
        }
        if(jump) {

        }
    }
    
    private void render() {
        Graphics2D g;
        g = (Graphics2D) bs.getDrawGraphics();

        g.clearRect(0, 0, 800, 800);
        
        for(int i = 0; i < blocks.length; i++){
            blocks[i].render(g);
        }
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

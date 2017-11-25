package platformer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import platformer.player.Player;

public class GameLoop extends JFrame implements KeyListener{
    private int FPS;
    private float frameTimeNS;
    private boolean running = false;
    private int scrWidth, scrHeight;
    private BufferStrategy bs;
    Player player;
    
    boolean jump, right, left, pause;
    
    public GameLoop(int FPS, int scrWidth, int scrHeight, Player player) {
        this.FPS = FPS;
        this.frameTimeNS = 1000000000f/ (float)FPS;
        this.scrWidth = scrWidth;
        this.scrHeight = scrHeight;
        this.player = player;
        
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
    
    public void startLoop() {
        running = true;
        loop();
    }
    
    private void loop() {
        double cycleStartTime;
        while (running) {
            cycleStartTime = System.nanoTime();
            
            update();
            render();
            
            while((System.nanoTime() - cycleStartTime) < frameTimeNS){}
        }
    }
    
    private void update() {
        player.update();
    }
    
    private void render() {
        Graphics2D g;
        g = (Graphics2D) bs.getDrawGraphics();

        g.clearRect(0, 0, 800, 800);
        
        g.setColor(Color.red);
        player.render(g);
        
        g.dispose();
        bs.show();
    }

    
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            player.setRight(true);
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            player.setLeft(true);
        } else if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.setJump(true);
        } else if(e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_WINDOWS) {
            pause = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            player.setRight(false);
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            player.setLeft(false);
        } else if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.setJump(false);
        } else if(e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_WINDOWS) {
            pause = false;
        }
    }
}

package platformer;

public class Platformer {

    public static void main(String[] args) {
        
        Player p = new Player(0, 50, 75, 800, 800);
        
        Block blocks[] = new Block[4];
        blocks[0] = new Block(100, 50, 50, 800, 800, p);
        blocks[1] = new Block(400, 50, 50, 800, 800, p);
        blocks[2] = new Block(300, 50, 50, 800, 800, p);
        blocks[3] = new Block(700, 50, 50, 800, 800, p);
        
        GameLoop gLoop = new GameLoop(800, 800, p, blocks);
        gLoop.start();
    }
    
}

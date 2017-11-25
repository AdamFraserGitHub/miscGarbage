package platformer.map.blockMan.blocks;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import platformer.player.Player;

public abstract class Block {
    protected int x, y, width, height;
    protected int drawX, drawY;
    protected BufferedImage sprite;
    protected Player player;
    
    abstract void setSprite(BufferedImage sprite);
    
    abstract void setPlayer(Player player);
    
    abstract void update();
    
    abstract void draw(Graphics2D g);
}

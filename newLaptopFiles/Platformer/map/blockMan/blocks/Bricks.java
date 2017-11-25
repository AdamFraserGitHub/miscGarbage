package platformer.map.blockMan.blocks;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import platformer.player.Player;

public class Bricks extends Block {

    public Bricks(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    @Override
    void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    @Override
    void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    void update() {
        drawX = x - (int) player.offset;
        drawY = y;   
    }

    @Override
    void draw(Graphics2D g) {
        g.drawImage((Image) sprite, drawX, drawY, width, height, null);
    }
    
}

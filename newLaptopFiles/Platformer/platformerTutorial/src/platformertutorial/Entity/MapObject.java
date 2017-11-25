package platformertutorial.Entity;

import java.awt.Rectangle;
import platformertutorial.TileMap.TileMap;

public abstract class MapObject {
    
    protected TileMap tileMap;
    protected int tileSize;
    protected double xmap;
    protected double ymap;
    
    protected double y;
    protected double x;
    protected double dx;
    protected double dy;
    
    protected int width;
    protected int height;
    
    //colision box
    protected int cWidth;
    protected int cHeight;
    
    //colision
    protected int currentRow;
    protected int currentCol;
    protected double xDest;
    protected double yDest;
    protected double xTemp;
    protected double yTemp;
    protected double topLeft;
    protected double topRight;
    protected double bottomLeft;
    protected double bottomRight;
    
    //animation
    protected Animation animation;
    protected int currentAction;
    protected int previousAction;
    protected boolean facingRight; 
    
    //movement
    protected boolean up;
    protected boolean down;
    protected boolean left;
    protected boolean right;
    protected boolean jumping;
    protected boolean falling;
    
    //movement atributes
    protected double moveSpeed;
    protected double maxSpeed;
    protected double stopSpeed;
    protected double fallSpeed;
    protected double maxFallSpeed;
    protected double jumpStart;
    protected double stopJumpSpeed;
    
    //constructor
    public MapObject(TileMap tm) {
        tileMap = tm;
        tileSize = tm.getTileSize();
    }
    
    public boolean intersect(MapObject o) {
        Rectangle r1 = getRectangle();
        Rectangle r2 = o.getRectangle();
        return r1.intersects(r2);
    }
    
    public Rectangle getRectangle() {
        return new Rectangle((int) x - cWidth, (int) y - cHeight, cWidth, cHeight);
    }
    
    public void calculateCorners(double x, double y) {
        int leftTile = (int)(x - cWidth / 2) / tileSize;
        int rightTile = (int)(x + cWidth / 2 - 1) / tileSize;
    }
    
    public void checkTileMapCollision() {
        currentCol = (int) x / tileSize;
        currentRow = (int) y / tileSize;
        
        xDest = x + dx;
        yDest = y + dy;
        
        xTemp = x;
        yTemp = y;
        
        calculateCorners(x, yDest);
    }
}

package platformertutorial.TileMap;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import platformertutorial.GamePanel;

public class TileMap {
    
    //position
    private double x,y;
    
    //bounds
    private int xmin, ymin, xmax, ymax;
    private double tween;
    
    //map
    private int[][] map;
    private int tileSize;
    private int collums;
    private int rows;
    private int width;
    private int height;
    
    //tileset
    private BufferedImage tileset;
    private int numTilesAcross;
    private Tile[][] tiles;
    
    //drawing
    private int rowOffset;
    private int colOffset;
    private int numRowsToDraw;
    private int numColsToDraw;
    
    public TileMap(int tileSize) {
        this.tileSize = tileSize;
        numRowsToDraw = GamePanel.HEIGHT / tileSize + 2;
        numColsToDraw = GamePanel.WIDTH / tileSize + 2;
        tween = 0.07;
    }
    
    public void loadTiles(String s) {
        try {
            tileset = ImageIO.read(getClass().getResourceAsStream(s));
            
            numTilesAcross = tileset.getWidth() / tileSize;
            tiles = new Tile[2][numTilesAcross];
            
            BufferedImage subImage;
            for(int col = 0; col < numTilesAcross; col++) {
                subImage = tileset.getSubimage(col * tileSize, 0, tileSize, tileSize);
                tiles[0][col] = new Tile(subImage, Tile.NORMAL);
                subImage = tileset.getSubimage(col * tileSize, tileSize, tileSize, tileSize);
                tiles[1][col] = new Tile(subImage, Tile.BLOCKED);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void loadMap(String s) {
        
        try {
            
            InputStream in = getClass().getResourceAsStream(s);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            collums = Integer.parseInt(br.readLine());
            rows = Integer.parseInt(br.readLine());
            map = new int[rows][collums];
            width = collums * tileSize;
            height = rows * tileSize;
            String delims = "\\s+";//w space
            for(int row = 0; row < rows; row++) {
                String line = br.readLine();
                String[] tokens = line.split(delims);
                for(int col = 0; col < collums; col++) {
                    map[row][col] = Integer.parseInt(tokens[col]);
                }
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public int getTileSize() { return tileSize; }
    public int getx() { return (int) x; }
    public int gety() { return (int) y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int getType(int row, int col) {
        int rc = map[row][col];
        int r = rc / numTilesAcross;
        int c = rc % numTilesAcross;
        
        return tiles[r][c].getType();
        
    }
    
    
    public void setPosition(double x, double y) {
        this.x += (x - this.x) * tween;
        this.y += (y - this.y) * tween;
        
        fixBounds();
        
        colOffset = (int) - this.x / tileSize;
        rowOffset = (int) - this.y / tileSize;
    }
    
    private void fixBounds() {
        if(x < xmin) x = xmin;
        if(x > xmax) x = xmax;
        if(x < ymin) y = ymin;
        if(y > ymax) y = ymax;
    }
    
    public void draw (Graphics2D g) {
        for(int row = rowOffset; row < rowOffset + numRowsToDraw; row++) {
            
            if(row >= rows) break;
            
            for(int col = colOffset; col < colOffset + numColsToDraw; col++) {
                if(col >= collums) break;
                if(map[row][col] == 0) continue;
                
                int rc = map[row][col];
                int r = rc / numTilesAcross;
                int c = rc % numTilesAcross;
                
                g.drawImage(tiles[r][c].getImage(), (int) x + col * tileSize, (int) y + row * tileSize, null);
                        
            }
        }
    }
    
    
}

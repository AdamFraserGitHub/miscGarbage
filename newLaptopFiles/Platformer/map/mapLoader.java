package platformer.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MapLoader {
    
    private File mapFile;
    private FileReader mapFileReader;
    private BufferedReader bufferedMapReader;
    private int mapWidth, mapHeight;
    private int mapData[][];
    
    public MapLoader(String relativePath) {
        try {
            mapFile = new File(relativePath);
            mapFileReader = new FileReader(mapFile);
            bufferedMapReader = new BufferedReader(mapFileReader);
        } catch(Exception e) {
            System.out.println("error creating map file I/O:\n\t" + e);
        }
    }
    
    public void getMapSize() {
        String tempStr = "";
        
        try {
            tempStr = bufferedMapReader.readLine();
        } catch(Exception e) {
            System.out.println("Error reading map size\n\t" + e);
        }
        
        mapWidth = Integer.valueOf(tempStr.split(",")[0]);
        mapHeight = Integer.valueOf(tempStr.split(",")[1]);
    }
    
    public void getMapData() {
        mapData = new int[mapWidth][mapHeight];
        String tempStr = "";
        char rowCharArray[] = new char[mapWidth];
        for(int row = 0; row < mapHeight; row++) {
            try {
                rowCharArray = bufferedMapReader.readLine().toCharArray();
            } catch(Exception e) {
                System.out.println("Error loading map row data to str:\n\t" + e);
            }
            
            for(int col = 0; col < mapWidth; col++) {
                mapData[col][row] = Character.getNumericValue(rowCharArray[col]);
            }
        }
    }
    
    public void getMapSprites(String spritePath) {
        
    }
}

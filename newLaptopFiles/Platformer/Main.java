package platformer;


import platformer.map.MapLoader;
import platformer.player.Player;

public class Main {

    public static void main(String[] args) {
        
        MapLoader mapLoader = new MapLoader("res/map/maps/testMap0.map"); 
        mapLoader.getMapSize();
        mapLoader.getMapData();
        
        Player player = new Player(100,100,50,50);
        
        GameLoop gameLoop = new GameLoop(60, 800, 800, player);
        gameLoop.startLoop();
    }
    
}

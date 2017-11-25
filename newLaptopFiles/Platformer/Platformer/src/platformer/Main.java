package platformer;

import platformer.graphics.Display;
import java.awt.Color;
import platformer.entities.Player;

public class Main {

    public static void main(String[] args) {
        int scrWidth = 800, scrHeight = 800;
        
        Color playerColor = new Color(255, 0, 150);
        
        Player p = new Player(10, scrHeight - 75, 50, 75, playerColor, scrWidth, scrHeight, 150);
        Display d = new Display(scrWidth, scrHeight, p);
        d.start();
    }
    
}

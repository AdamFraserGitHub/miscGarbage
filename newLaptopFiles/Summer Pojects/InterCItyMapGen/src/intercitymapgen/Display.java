package intercitymapgen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Display extends JFrame {
    
    int scrWidth, scrHeight, nCities;
    BufferStrategy bs;
    double[][] cityMap;
    
     public Display(int scrWidth, int scrHeight, double[][] cityMap, int nCities) {
        this.scrWidth = scrWidth;
        this.scrHeight = scrHeight;
        this.cityMap = cityMap.clone();
        this.nCities = nCities;
        
        setup();
    }
    
    private void setup() {
        this.setSize((int) scrWidth, (int) scrHeight);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Sorting Visualiser");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        this.createBufferStrategy(2);
        bs = this.getBufferStrategy();
        while(true){
            render();
            
            long time = System.currentTimeMillis();
            while(System.currentTimeMillis() - time < 1000){}  
        }
    }
    
    public void render() {
        
        Graphics2D g;
        g = (Graphics2D) bs.getDrawGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, 1800, 1000);
        g.setColor(Color.red);
        g.fillOval((int) (cityMap[0][0] * scrWidth), (int) (cityMap[0][1] * scrHeight), 10, 10);
        
        double magDistIJ;
        g.setColor(Color.cyan);
        for(int i = 1; i < nCities; i++) {
            for(int j = 0; j < nCities; j++) {
                if(!(j==i)) {
                    magDistIJ = Math.sqrt(((cityMap[i][0] - cityMap[j][0]) * (cityMap[i][0] - cityMap[j][0])) + ((cityMap[i][1] - cityMap[j][1]) * (cityMap[i][1] - cityMap[j][1])) );
                    if(magDistIJ < 0.03) { 
                        g.drawLine((int) (cityMap[i][0] * scrWidth), (int) (cityMap[i][1] * scrHeight), (int) (cityMap[j][0] * scrWidth), (int) (cityMap[j][1] * scrHeight));
                    }
                }
            }
            g.drawLine((int) (cityMap[i][0] * scrWidth), (int) (cityMap[i][1] * scrHeight), (int) (cityMap[i-1][0] * scrWidth), (int) (cityMap[i-1][1] * scrHeight));
        }
        
        g.setColor(Color.red);
        for(int i = 1; i < nCities; i++) {
            g.fillOval((int) (cityMap[i][0] * scrWidth) - 5, (int) (cityMap[i][1] * scrHeight) - 5, 10, 10);
        }

        g.dispose();

        bs.show();
    }
}

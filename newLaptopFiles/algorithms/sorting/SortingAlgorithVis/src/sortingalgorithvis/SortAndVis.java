package sortingalgorithvis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class SortAndVis extends JFrame{
    //Global Variable Decleration
    BufferStrategy bs;
    int scrWidth, scrHeight;
    int list[];
    int maxVal, minVal, size;
    
    public SortAndVis(int scrWidth, int scrHeight, int unorderedList[], int minVal, int maxVal, int size) {
        this.scrWidth = scrWidth;
        this.scrHeight = scrHeight;
        this.list = unorderedList.clone();
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.size = size;
        
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
    }
    
    
    
    @Override
    public void paint(Graphics gfx) {
        
        //this block of code renders the initial random and unsorted list
        Graphics2D g = null;
        do {
            try {
                g = (Graphics2D) bs.getDrawGraphics();
                render(g);
            } finally {

                g.dispose();
            }
        } while(bs.contentsLost());
        bs.show();
        
        
        
        //this block of code sorts the list and displays each step
        g = null;

        try {
            g = (Graphics2D) bs.getDrawGraphics();

            boolean pointInChecking;
            boolean sorted = false;
            int smallIndexVal, largerIndexVal;

            while(!sorted){
                pointInChecking = true;
                /*
                one pass of the array sort algorithm which checks the 
                next value. if it is greater they switch
                */
                for(int i = 0; i < size - 1; i++) {
                    if(list[i] > list[i + 1]){
                        smallIndexVal = list[i + 1];
                        largerIndexVal = list[i];

                        list[i] = smallIndexVal;
                        list[i+1] = largerIndexVal;

                        long time = System.currentTimeMillis();
                        while((System.currentTimeMillis() - time) < 0){}
                        render(g);
                        g.dispose();
                        bs.show();
                        g = (Graphics2D) bs.getDrawGraphics();
                    }
                }

                /*
                check if the array is sorted by checking that every value of i > i
                has value >= list[i]
                */
                for(int i = 0; i < size - 1; i++) {
                    if(list[i+1] >= list[i] && pointInChecking) {
                        sorted = true;
                    } else {
                        sorted = false;
                        pointInChecking = false;
                    }
                }
            //	nPasses++;
            }
        } catch(Exception e) {
            System.out.println("ERROR IN RUNTIME LOOP!:   " + e);
        }
        
    }
    
    public void render(Graphics2D g) {
        g.clearRect(0, 0, scrWidth, scrHeight);
        int width = (int) Math.ceil((1f/list.length) * scrWidth + 0.5);
        float x,y,height;
        
        for (float i = 0; i < list.length; i++){
            height = (( (float) (list[(int) i]) / (float) (maxVal)) * scrHeight);
            y = scrHeight - height;
            x = ((i/list.length) * scrWidth);                   

            g.setColor(rainbow((int) (x + width/2)));

            g.fillRect((int) x, (int) y, width, (int) height);
        }
    }
    
    private Color rainbow(int xPos) {
        if (xPos <= 1/7 * scrWidth) {return new Color(255,0,0);}
        else if (xPos > 1/7 * scrWidth && xPos <= 2/7 * scrWidth){return new Color(255,0,150);}
        else if (xPos > 2/7 * scrWidth && xPos <= 3/7 * scrWidth){return new Color(255,0,255);}
        else if (xPos > 3/7 * scrWidth && xPos <= 4/7 * scrWidth){return new Color(0,255,0);}
        else if (xPos > 4/7 * scrWidth && xPos <= 5/7 * scrWidth){return new Color(0,150,255);}
        else if (xPos > 5/7 * scrWidth && xPos <= 6/7 * scrWidth){return new Color(0,0,255);}
        else if(xPos > 6/7 * scrWidth && xPos <= 1 * scrWidth){return new Color(150,0,255);}
        
        return new Color(255,0,255);
    }
}

package intercitymapgen;

import java.util.Random;

public class mapGen {
    
    double map[][];
    public void pointMapGen(int nCities, double minSepperation, double maxSepperation) {
        Random rand = new Random();
        map = new double[nCities][2];
        
        map[0][0] = rand.nextDouble();
        map[0][1] = rand.nextDouble();
        
        double deltaX,deltaY;
        for(int i = 1; i < nCities; i++) {
            deltaX = minSepperation + (maxSepperation - minSepperation) * rand.nextDouble();
            deltaY = minSepperation + (maxSepperation - minSepperation) * rand.nextDouble();
            
            /* this block checks the value of a random boolean. if it is true then
             * X or Y depending on the statement become negative. this prevents
             * the ciy structure always moving towards the bottom right of the screen */
            if((rand.nextBoolean() || map[i - 1][0] + deltaX > 1) && !(map[i - 1][0] - deltaX < 0)) {
                deltaX*=-1;
            }
            if((rand.nextBoolean() || map[i - 1][1] + deltaY > 1) && !(map[i - 1][1] - deltaY < 0)) {
                deltaY*=-1;
            }
            
            map[i][0] = map[i-1][0] + deltaX;
            map[i][1] = map[i-1][1] + deltaY;
        }

    }
    
    public double[][] getMap() {
        return map;
    }
}

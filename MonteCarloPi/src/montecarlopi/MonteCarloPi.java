package montecarlopi;
import java.util.Random;
import java.lang.*;

public class MonteCarloPi {

    static Random rand = new Random();
    
    static int nInCircle = 0, nTotal = 0;
    static float squareSideLen = 500f;
    static float squareArea = squareSideLen * squareSideLen;
    
    static float circleRadius = 0.5f * squareSideLen;
    static float circleRadiusSquare = circleRadius * circleRadius;
    
    static float x,y;
    
    public static void main(String[] args) {
        while(true){
            nTotal++;
            x = Math.abs(rand.nextInt((int) squareSideLen) - circleRadius);
            y = Math.abs(rand.nextInt((int) squareSideLen) - circleRadius);
            
            if((x * x) + (y * y) <= circleRadiusSquare) {
                nInCircle++;
            }
            
            if(nTotal % 50000000 == 0) {
                System.out.println(nTotal / 1000000 + " million points thrown");
                System.out.println((((float) nInCircle / (float) nTotal) * squareArea) / circleRadiusSquare);
            }
        }
    }
    
}

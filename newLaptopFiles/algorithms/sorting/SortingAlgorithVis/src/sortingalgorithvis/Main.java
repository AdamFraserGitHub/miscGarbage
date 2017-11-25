package sortingalgorithvis;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int maxVal = 1000;
        int minVal = 0;
        int size = 340;
        
        new SortAndVis(1900,1000, genRandList(minVal, maxVal, size), minVal, maxVal, size);
    }
    
    private static int[] genRandList(int minVal, int maxVal, int size) {
        int tempList[] = new int[size];
        Random rand = new Random();
        
        for(int i = 0; i < size; i++) {
            tempList[i] = rand.nextInt(maxVal - minVal + 1) + minVal;
            System.out.println(tempList[i]);
        }
        
        return tempList;
    }
    
}

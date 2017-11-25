package intercitymapgen;

public class Main {
    
    public static void main(String[] args) {
        
        mapGen mGen = new mapGen();
        mGen.pointMapGen(100, 0.05, 0.1);
        double map[][] = mGen.getMap();
        
        Display display = new Display(1800, 1000, map, 100);
    }
    
}

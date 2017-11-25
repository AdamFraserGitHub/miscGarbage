package passwdserver;

import java.io.File;

public class Generator {
    private File Cities, Colors, Fruits, GreekLetters;
    private String term1, term2, term3, term4;
    
    public void InitGenerator(String paths[]) {
        Cities = new File(paths[0]);
        Colors = new File(paths[1]);
        Fruits = new File(paths[2]);
        GreekLetters = new File(paths[3]);
    }
    
    public void GeneratePassword() {
        term1
    }
}

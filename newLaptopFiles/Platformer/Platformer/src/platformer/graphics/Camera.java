package platformer.graphics;

public class Camera {
    int width, height;
    public float offset = 0;
    
    public Camera(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void panRight() {
        offset+=5;
    }
    
    public void panLeft() {
        if(offset > 0){
            offset-=5;
        } else {
            offset = 0;
        }
    }
}

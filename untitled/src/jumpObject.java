import processing.core.PApplet;
import processing.core.PImage;

public class jumpObject extends MovingObject {
    private PImage jumpObstacleImage;
    public jumpObject(int x, int lane){
        super(x, lane);
    }
    public void draw(PApplet window){
        jumpObstacleImage = window.loadImage("images/jumpObstacle.png");
        window.image(jumpObstacleImage, x, y);
    }

}

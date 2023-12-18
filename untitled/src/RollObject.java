import processing.core.PApplet;
import processing.core.PImage;

public class RollObject extends MovingObject {
    private PImage rollObstacleImage;
    public RollObject(int x, int lane){
        super(x, lane);
    }
    public void draw(PApplet window){
        rollObstacleImage = window.loadImage("images/rollObstacle.png");
        window.image(rollObstacleImage, x, y);

    }
}

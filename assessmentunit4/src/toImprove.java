import processing.core.PApplet;

public class toImprove extends PApplet {
    boolean rMove, lMove, uMove, dMove;
    float x1, y1, xspeed, y1speed, gravity, ground;
    int lives, x, y, esize;
    public void settings(){
        size(600,600);
    }
    public void setup(){
        rMove = lMove = uMove = dMove = false;
        x= 300;
        y = 530;
        x1 = 0;
        y1 = 100;
        xspeed = 4;
        y1speed = 1;
        gravity = (float) 0.8;
        ground = 500;
        lives = 10;
        esize = 20;
    }
    public void draw(){
        background(255);
        text("Lives: " + lives, 500, 20);
        fill(255);
        rect(x, ground - 70, 20, 70);
        fill(0);
        rect(0, ground, width, height - ground);
        fill(color(242, 133, 0));
        ellipse(x1, y1, 20, 20);

        x1 += xspeed;
        y1 += y1speed;
        y1speed += gravity;

        if (y1 + esize/2 >= ground) {
            y1speed = -y1speed;
        }
        if(x1 - esize/2 >= width) {
            x1 = -100;
            y1 = (float) (Math.random() * 200);
        }

        if (y1 + 10 >= ground - 70) {
            if ((x1 + 10 >= x && x1 + 10 <= x + 20) || (x1  - 10 >= x && x1 - 10 <= x +20)) {
                lives--;
                x1 = -100;
                if(y1>400) {
                    y1 = (float) (Math.random() * 200);
                }
                y1speed = (float)0.5;
                fill(color(255, 0, 0));
                rect(x, ground - 70, 20, 70);
            }
        }
        if(keyPressed){
            if(key == CODED){
                if(keyCode == UP){
                    if(y - esize/2 > 0) {
                        y = y - 2;
                    }
                }
                if(keyCode == DOWN){
                    if(y + esize/2 < 600) {
                        y = y + 2;
                    }
                }
                if(keyCode == RIGHT){
                    if(x + esize/2 < 600) {
                        x = x + 2;
                    }
                }
                if(keyCode == LEFT){
                    if(x - esize/2 > 0) {
                        x = x - 2;
                    }
                }
            }
        }

    }
    

    public static void main(String[] args) {
        PApplet.main("toImprove");
    }

}

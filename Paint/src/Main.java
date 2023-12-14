import processing.core.PApplet;

public class Main extends PApplet {
    int ellipseWidth = 60;
    int ellipseHeight = 60;
    int red = color(222, 67, 73);
    int orange = color(222, 133, 73);
    int yellow = color(254, 215, 76);
    int green = color(171, 215, 76);
    int blue = color(112, 215, 205);
    int purple = color(199, 134, 255);
    int gray = color(112, 112, 112);
    int black = color(0,0,0);
    int clear = color(255, 255, 255);
    int reds,blues,greens;
    int colorRandom;
    public void settings(){
        size(600,600);
    }
    public void setup(){
        background(clear);
    }
    public void draw(){
        if (mousePressed) {
            ellipse(mouseX, mouseY, ellipseWidth, ellipseHeight);
        }
        if (keyPressed == true){
            if (key ==CODED){
                if (keyCode == UP){
                    ellipseWidth = ellipseWidth + 1;
                    ellipseHeight = ellipseHeight + 1;
                }
                if (keyCode == DOWN){
                    ellipseWidth = ellipseWidth - 1;
                    ellipseHeight = ellipseHeight - 1 ;
                }
                if (keyCode == RIGHT){
                    ellipseWidth = ellipseWidth+1;
                }
                if (keyCode == LEFT){
                    ellipseWidth = ellipseWidth-1;
                }
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
    public void keyReleased(){
        if (key == '1'){
            fill(red);
            stroke(red);
        }
        if (key == '2'){
            fill(orange);
            stroke(orange);
        }
        if (key == '3'){
            fill(yellow);
            stroke(yellow);
        }
        if (key == '4'){
            fill(green);
            stroke(green);
        }
        if (key == '5'){
            fill(blue);
            stroke(blue);
        }
        if (key == '6'){
            fill(purple);
            stroke(purple);
        }
        if (key == '7'){
            fill(black);
            stroke(black);
        }
        if (key == '8'){
            fill(gray);
            stroke(gray);
        }
        if (key == '0'){
            fill(clear);
            stroke(clear);
        }
        if (key == ' '){
            fill(clear);
            stroke(clear);
        }
        if (key == 'C'){
            background(clear);
        }
        if (key == 'r'){
            reds = (int)(Math.random()*255);
            blues = (int)(Math.random()*255);
            greens = (int)(Math.random()*255);
            colorRandom = color(reds, greens, blues);
            fill(colorRandom);
            stroke(colorRandom);

        }
        if (key == 'R'){
            ellipseWidth = 60;
            ellipseHeight = 60;
        }
    }
}



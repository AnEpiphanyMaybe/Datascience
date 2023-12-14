import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Main extends PApplet {
    PImage devilcat;
    PImage halochicken;
    PImage backaground;
    PImage brod;

    ArrayList<enemy> enemies;
    ArrayList<powerup> croissant;
    player p1;
    int enemyCounter=0;
    int timer;
    int numseconds=0;
    int randx=300;
    int randy=400;
    int randxS=6;
    int randyS=7;
    int randsx=30;
    int randsy=30;
    int time1;
    int enemynum=0;
    int screen=0;
    int speed=15;
    int endtimemin;
    int endtimesec;
    boolean collision = false;
    public void settings(){
        size(600,600);
    }
    public void setup(){
        devilcat= loadImage("cat.png");
        halochicken= loadImage("chicken.png");
        backaground=loadImage("b1.png");
        brod=loadImage("croissant.png");


        enemies=new ArrayList<>();
        croissant = new ArrayList<>();
        for(int i = 0; i < 10; i ++){
            int xvalue=(int)(Math.random()*500+50);
            int yvalue=(int)(Math.random()*500+50);

            powerup c = new powerup(xvalue, yvalue, 30, 30);
            croissant.add(c);
        }

        p1=new player();
        p1.px=300;
        p1.py=300;
        p1.ph=20;
        p1.pw=20;
        p1.pxSpeed=20;
        p1.pySpeed=20;
        devilcat.resize(p1.pw, p1.ph);






    }

    public void draw() {
        devilcat.resize(p1.pw + 10, p1.ph + 10);
        if (screen == 0) {
            backaground.resize(600, 600);
            image(backaground, 0, 0);
            textSize(15);
            text("click to play", 250, 100);
            rect(265, 265, 70, 50);

        }
        if (screen == 1) {
            System.out.println(numseconds);
            background(176, 213, 221);
            textSize(20);
            text("score: " + enemynum, 500, 50);
            if ((numseconds) > 9) {
                text((numseconds / 60) + " : " + (numseconds - ((numseconds / 60) * 60)), 400, 50);
            }
            if (numseconds < 10) {
                text((numseconds / 60) + " : 0" + (numseconds - (((numseconds / 60) * 60))), 400, 50);
            }
            fill(176, 213, 221);
            stroke(176, 213, 221);
            rect(p1.px, p1.py, p1.pw, p1.ph);
            fill(0);
            image(devilcat, p1.px, p1.py);

            //player move
            if (keyPressed) {
                if (key == 'w') {
                    p1.moveup();
                }
                if (key == 'a') {
                    p1.moveleft();

                }
                if (key == 's') {
                    p1.movedown();

                }
                if (key == 'd') {
                    p1.moveright();

                }
                if (key == 'p') {
                    speed = 100;

                }
            }
            ;

            //stopwatch stuff
            timer++;
            if (timer % 60 == 0) {
                numseconds++;
                time1 = 1;
            }
            if (timer % 60 > 0) {
                time1 = 0;
            }

            //spawns enemies
            if (numseconds % 5 == 0) {

                randx = (int) (Math.random() * 500) + 50;
                randy = (int) (Math.random() * 500) + 50;
                randxS = (int) (Math.random() * speed) + 5;
                randyS = (int) (Math.random() * speed) + 5;

                if (time1 == 1) {
                    enemies.add(new enemy(randx, randy, randxS, randyS, 30, 30));
                    System.out.println(randx);
                    enemynum++;
                }
            }

            //spawns the croissant (just an easter egg  sort of thing
            if (enemynum > 0) {
                if (enemynum % 5 == 0) {
                    for (int loc = 0; loc < croissant.size(); loc++) {
                        fill(176, 213, 221);
                        stroke(176, 213, 221);
                        powerup currcroissant = croissant.get(loc);
                        new powerup(currcroissant.powerx, currcroissant.powery, currcroissant.powerh, currcroissant.powerw);
                        rect(currcroissant.powerx, currcroissant.powery, currcroissant.powerw, currcroissant.powerh);
                        image(brod, currcroissant.powerx, currcroissant.powery);
                        brod.resize(30, 30);
                    }

                }
            }


            for (int loc = 0; loc < enemies.size(); loc++) {
                fill(176, 213, 221);
                stroke(176, 213, 221);
                enemy currenemy = enemies.get(loc);
                new enemy(currenemy.xvalue, currenemy.yvalue, currenemy.xSpeed, currenemy.ySpeed, currenemy.sizex, currenemy.sizey);
                rect(currenemy.xvalue, currenemy.yvalue, currenemy.sizex, currenemy.sizey);
                image(halochicken, currenemy.xvalue, currenemy.yvalue);

                halochicken.resize(30, 30);
                currenemy.xvalue = currenemy.xvalue + currenemy.xSpeed;
                currenemy.yvalue = currenemy.yvalue + currenemy.ySpeed;

                if (p1.px < currenemy.xvalue) {
                    if (currenemy.xSpeed > -speed - 5) {
                        currenemy.xSpeed--;
                    }
                }
                if (p1.px > currenemy.xvalue) {
                    if (currenemy.xSpeed < speed + 5) {
                        currenemy.xSpeed++;
                    }
                }
                if (p1.py > currenemy.yvalue) {
                    if (currenemy.ySpeed < speed + 5) {
                        currenemy.ySpeed++;
                    }
                }
                if (p1.py < currenemy.yvalue) {
                    if (currenemy.ySpeed > -speed - 5) {
                        currenemy.ySpeed--;
                    }
                }

                if (currenemy.xvalue > p1.px && currenemy.xvalue < (p1.px + p1.pw)) {
                    if (currenemy.yvalue > p1.py && currenemy.yvalue < (p1.py + p1.ph)) {
                        collision = true;
                        System.out.println("cheese");

                    }
                    if ((currenemy.yvalue + currenemy.sizey) > p1.py && (currenemy.yvalue + currenemy.sizey) < (p1.py + p1.ph)) {
                        collision = true;
                        System.out.println("deathes");
                    }
                    if (currenemy.xvalue + currenemy.sizex > p1.px && currenemy.xvalue + currenemy.sizex < (p1.px + p1.pw)) {
                        if (currenemy.yvalue > p1.py && currenemy.yvalue < (p1.py + p1.ph)) {
                            collision = true;
                            System.out.println("destruction");
                        }
                        if ((currenemy.yvalue + currenemy.sizey) > p1.py && (currenemy.yvalue + currenemy.sizey) < (p1.py + p1.ph)) {
                            collision = true;
                            System.out.println("emo child");
                        }
                    }
                    if (collision == true) {
                        screen = 2;
                        endtimemin = numseconds / 60;
                        endtimesec = numseconds - (endtimemin * 60);

                    }


                }

            }
            fill(0);
            if (screen == 2) {
                background(108, 216, 192);
                background(255, 255, 255);
                textSize(80);
                fill(255, 0, 0);
                text("GAME OVER", 50, 200);
                textSize(30);
                text("score: 0" + enemynum, 230, 350);

                if (endtimesec > 9) {
                    text("end time: " + endtimemin + " : " + endtimesec, 200, 390);
                }
                if (endtimesec < 10) {
                    text("end time " + endtimemin + " : 0" + endtimesec, 200, 390);
                }
            }

        }
    }

    public static void main (String[]args){
        PApplet.main("Main");
    }

    public void mouseReleased() {
        if (screen == 0) {
            if (mouseX > 265 && mouseX < 335) {
                if (mouseY > 265 && mouseY < 315) {
                    screen = 1;

                }
            }
        }
    }

}

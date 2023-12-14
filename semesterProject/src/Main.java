import processing.core.PApplet;
import processing.core.PImage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main extends PApplet {

    int score = 0;
    boolean iskColliding;
    boolean isCollidingGren;
    boolean collided;
    boolean chickenMoved;
    boolean home;
    int end = 1;
    ArrayList<grenade> grenadelist;
    ArrayList<knights> knightList;

    rabbit r1;
    chicken r2;



    public void settings() {
        size(600, 600);
    }

    public void setup() {
        grenadelist = new ArrayList<>();
        knightList = new ArrayList<>();

        int yk = 100;
        for (int i = 0; i < 5; i++) {

            knights k = new knights(100, yk, 30, 90, 20);
            knightList.add(k);
        }

        int yg = 100;
        for (int i = 0; i < 4; i++) {
            grenade g = new grenade(100, yg, 50, 30);
            grenadelist.add(g);
        }

        r1= new rabbit();
        r1.bunx=300;
        r1.buny=300;
        r1.bunySpeed=5;
        r1.bunxSpeed=5;
        r1.bunesizex=50;
        r1.bunesizey=50;
        r2=new chicken();





    }


    public void draw() {
       background(209, 66, 93);
       text("Welcome to Slaughter bunny. Place of your slaughtering dreams",120, 200);
       text("Press go to play. Shoot the grenades and kill the nights", 150, 220);
       text("Press Space to shoot and use the arrow keys to move.", 160, 240);
       text("Press S to stop and see your final score", 180, 260);
       fill(255);
       rect(250, 300, 100, 80);
       fill(0);
       text("GO", 292, 345);

        if (end == 0){
            background(110, 145, 184);
            text("Your score is:" + score, 200, 260);
        }



      if(home) {
          background(180);
          fill(180);
          rect(r1.bunx, r1.buny, r1.bunesizex, r1.bunesizey);
          fill(255);
          text("score:" + score, 500, 50);


          for (int loc = 0; loc < knightList.size(); loc++) {
              knights currKnight = knightList.get(loc);
              fill(180);
              rect(currKnight.knightx, currKnight.knighty, currKnight.knightWidth, currKnight.knightHeight);
              currKnight.act();


              iskColliding = currKnight.checkCollion(r1.bunx, r1.buny, r1.bunesizex, r1.bunesizey);
              if (iskColliding) {
                  currKnight.knightx = 650;
                  currKnight.knighty = (int) (Math.random() * 500 + 50);
                  score--;

              }
              collided = currKnight.checkCollion(r2.cx, r2.cy, r2.cSize, r2.cSize);
              if (collided) {
                  currKnight.knightx = 650;
                  currKnight.knighty = (int) (Math.random() * 500 + 50);
                  score++;
                  r2.cx = 700;
              }

          }
          if (chickenMoved == true) {
              r2.cySpeed = 0;
              r2.cSize = 20;
              r2.cxSpeed = 15;
              r2.cx = r2.cx + r2.cxSpeed;
              rect(r2.cx, r2.cy, r2.cSize, r2.cSize);
              r2.chickenMove();

          }


          for (int loc = 0; loc < grenadelist.size(); loc++) {
              grenade currGrenade = grenadelist.get(loc);
              ellipse(currGrenade.grenx, currGrenade.greny, currGrenade.grenSize, currGrenade.grenSize);
              currGrenade.act();


              isCollidingGren = currGrenade.checkCollisionGrenade(r1.bunx, r1.buny, r1.bunesizex, r1.bunesizey);
              if (isCollidingGren) {
                  currGrenade.grenx = 700;
                  score = score - 3;

              }
              collided = currGrenade.checkCollisionChicken(r2.cx, r2.cy, r2.cSize, r2.cSize);
              if (collided) {
                  currGrenade.grenx = 650;
                  currGrenade.greny = (int) (Math.random() * 500 + 50);
                  score++;
                  r2.cx = 700;
              }
          }


          if (keyPressed == true) {
              if (key == ' ') {
                  if (r2.cx < 650) {
                      chickenMoved = true;
                      r2.cx = r1.bunx;
                      r2.cy = r1.buny;
                  } else {
                      chickenMoved = false;
                      r2.cx = r1.bunx;
                      r2.cy = r1.buny;
                  }
              }
              if (key == CODED) {
                  if (keyCode == UP) {
                      r1.moveup();
                  }
                  if (keyCode == DOWN) {
                      r1.movedown();
                  }
                  if (keyCode == LEFT) {
                      r1.moveleft();
                  }
                  if (keyCode == RIGHT) {
                      r1.moveright();
                  }

              }
          }
          if (r1.bunx + 50 > width) {
              r1.bunx = 550;
          }
          if (r1.bunx < 0) {
              r1.bunx = 0;
          }
          if (r1.buny + 50 > height) {
              r1.buny = 550;
          }
          if (r1.buny < 0) {
              r1.buny = 0;
          }

      }


    }

    public void mouseReleased(){
        if (end ==1) {
            if (mouseX >= 250 && mouseX <= 350) {
                if (mouseY >= 300 && mouseY <= 380) {
                    home = true;

                }
            }
        }

    }

    public void keyReleased(){
        if(key == 'S'){
            end = 0;
            home = false;
        }
    }


    public static void main(String[] args) {
        PApplet.main("Main");
    }
}

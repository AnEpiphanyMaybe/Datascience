public class grenade {
    int grenx,greny,grenxSpeed,grenSize;

    public grenade(int x,int y, int xs, int size){
        this.grenx = x;
        this.greny = y;
        this.grenxSpeed = xs;
        this.grenSize = size;
    }



    public void grenMove(){
        grenx=grenx-grenxSpeed;
    }



    public void act(){
        grenMove();
        if (grenx<0){
            grenx = 600;
            greny = (int)(Math.random()*500+50);
            grenxSpeed = (int)(Math.random()*15+1);
        }
        if (greny>600){
            greny= -30;
        }
    }

    public boolean checkCollisionGrenade(int playx,int playy,int playw,int playh) {
        if (grenx + grenSize / 2 >= playx && grenx - grenSize / 2 <= playx + playw) {
            if (greny - grenSize / 2 <= playy + playh && greny + grenSize / 2 >= playy) {

                return true;
            }
        }
        return false;
    }

    public boolean checkCollisionChicken(int chickenx,int chickeny,int chickenw,int chickenh) {
        if (grenx + grenSize / 2 >= chickenx && grenx - grenSize / 2 <= chickenx + chickenw) {
            if (greny - grenSize / 2 <= chickeny + chickenh && greny + grenSize / 2 >= chickeny) {

                return true;
            }
        }
        return false;
    }
}

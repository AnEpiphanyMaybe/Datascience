public class knights {
    int knightx, knighty, xKnightSpeed, knightWidth, knightHeight;

    public knights(int x,int y, int xs, int h, int w){
        this.knightx = x;
        this.knighty = y;
        this.xKnightSpeed = xs;
        this.knightWidth = w;
        this.knightHeight = h;
    }


    public void move(){
        knightx = knightx - xKnightSpeed;

    }

    public void act(){
        move();
        if (knightx<0){
            knightx = 600;
            knighty = (int)(Math.random()*500+50);
            xKnightSpeed = (int)(Math.random()*15+1);
        }
        if (knighty>600){
            knighty= -30;
        }
    }



    public boolean checkCollion(int bunnyx, int bunnyy, int bunnyw, int bunnyh){
        if (knightx+knightWidth >= bunnyx && knightx <= (bunnyx+bunnyw)){
            if ( knighty<=(bunnyy+bunnyh)&& knighty + knightHeight>=bunnyy){
                return true;
            }
        }
        return false;
    }

}

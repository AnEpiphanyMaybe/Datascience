public class rabbit {
    int bunx,buny,bunxSpeed,bunySpeed,bunesizex,bunesizey;

    public void moveup(){
        buny=buny-bunySpeed;
    }
    public void movedown(){
        buny=buny+bunySpeed;
    }
    public void moveleft() {
        bunx=bunx-bunxSpeed;
    }


    public void moveright(){
        bunx=bunx+bunxSpeed;
    }

}


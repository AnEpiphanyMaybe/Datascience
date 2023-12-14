public class player {
    int px,py,ph,pw,pxSpeed,pySpeed;
    public void moveup() {
        if (py > 0){
            py = py - pySpeed;
        }
    }
    public void movedown(){
        if((py+ph)<600-10) {
            py = py + pySpeed;
        }
    }
    public void moveleft(){
        if(px>0) {
            px = px - pxSpeed;
        }
    }
    public void moveright(){
        if((px+pw)<600-10) {
            px = px + pxSpeed;
        }
    }

}

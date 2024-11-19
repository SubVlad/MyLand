package Logic;

public class PlayableObject extends VisibleObject {

    public PairCoord pcNet;
    public PairCoord pcStage; // position related to board, that is - position in game
    public PlayableObject(String name,int netX,int netY,int spriteNumber,int visibleIndex){
        super(name, netX, netY, spriteNumber, visibleIndex);
        this.pcNet = new PairCoord(netX,netY);
        this.pcStage = new PairCoord(
                this.pcNet.x * this.SQUARE_SPRITE_SIZEX,this.pcNet.y * this.SQUARE_SPRITE_SIZEY);
        this.pcWindow = new PairCoord(this.pcStage.x,this.pcStage.y);


    }

    public int getRTBX(){
        return this.pcStage.x;
    }
    public int getRTBY(){
        return this.pcStage.y;
    }
    public int getX() {
        return pcNet.x;
    }

    public int getY() {
        return pcNet.y;
    }
    public void setX(int netX) {
        this.pcNet.x = netX;
    }
    public void setY(int netY){
        this.pcNet.y = netY;
    }

}

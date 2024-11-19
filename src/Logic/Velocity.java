package Logic;

import org.jetbrains.annotations.NotNull;

public class Velocity {
    public PairCoord pathPC;
    public PairCoord vectorPC;
    public byte speed;
    public Velocity(int pathX, int pathY){
        this.pathPC = new PairCoord(pathX,pathY);
        this.vectorPC = new PairCoord(0,0);
        this.speed = 3;
    }
    public void updateVectors(MovableObject object){
        this.vectorPC.x = object.getButtons()[1] - object.getButtons()[0];
        this.vectorPC.y = object.getButtons()[3] - object.getButtons()[2];
        this.pathPC.x = this.vectorPC.x * this.speed;
        this.pathPC.y = this.vectorPC.y * this.speed;
    }

    public void updateVectors(PairCoord pc){
        this.vectorPC.x = pc.x;
        this.vectorPC.y = pc.y;
        this.pathPC.x = this.vectorPC.x * this.speed;
        this.pathPC.y = this.vectorPC.y * this.speed;
    }
    public void updateVectors(PairCoord pcBigger, PairCoord pcSmaller){
        this.vectorPC.x = pcBigger.x - pcSmaller.x;
        this.vectorPC.y = pcBigger.y - pcSmaller.y;
        this.pathPC.x = this.vectorPC.x * this.speed;
        this.pathPC.y = this.vectorPC.y * this.speed;
    }
    public int getPathX()
    {
        return pathPC.x;
    }
    public int getPathY()
    {
        return pathPC.y;
    }
    public PairCoord getPathPC(){
        return pathPC;
    }
    public PairCoord getVectorPC(){
        return vectorPC;
    }
    public int getVectorX()
    {
        return this.vectorPC.x;
    }
    public int getVectorY()
    {
        return this.vectorPC.y;
    }
    public void setPathX(int vectorX)
    {
        this.pathPC.x = vectorX;
    }
    public void setPathY(int vectorY)
    {
        this.pathPC.y = vectorY;
    }

    public void setVectorX(int vectorX)
    {
        this.vectorPC.x = vectorX;
    }
    public void setVectorY(int vectorY)
    {
        this.vectorPC.y = vectorY;
    }
    public void setPathsByPC(PairCoord pc){
        this.pathPC.x = pc.x;
        this.pathPC.y = pc.y;
    }
    public void setVectorsByPC(PairCoord pc){
        this.vectorPC.x = pc.x;
        this.vectorPC.y = pc.y;
    }
}

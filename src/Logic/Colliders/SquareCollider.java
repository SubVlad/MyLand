package Logic.Colliders;

import Logic.Character;
import Logic.Colliders.Collidable;
import Logic.Colliders.Collider;
import Logic.Direction;
import Logic.Mechmap;
import Logic.Session;

public class SquareCollider implements Collider { //квадратное тело коллайдера
    public int leftX; // это всё - координаты границ тела коллайдера
    public int rightX;
    public int upY;
    public int downY;
    public int[] bordersX;
    public int[] bordersY;
    public volatile int[] allBorders;
    int SPRITE_SIZEX;
    int SPRITE_SIZEY;
    public boolean[] bordersBools;
    public Direction collisionDirection;
    public SquareCollider(int RTBX, int RTBY, int SPRITE_SIZEX, int SPRITE_SIZEY)
    {
        this.allBorders = new int[4];
        this.bordersBools = new boolean[4];
        this.SPRITE_SIZEX = SPRITE_SIZEX;
        this.SPRITE_SIZEY = SPRITE_SIZEY;
        this.allBorders[0] = RTBX;
        this.allBorders[1] = RTBX + SPRITE_SIZEX;
        this.allBorders[2] = RTBY;
        this.allBorders[3] = RTBY + SPRITE_SIZEY;
        for (boolean bool : this.bordersBools) {
            bool = false;
        }
        this.collisionDirection = new Direction();

    }
    public void colliderMove(Character character){
        this.erraseCollider(Session.get().curBoard.mech);
        this.allBorders[0] = character.getRTBX();
        this.allBorders[1] = character.getRTBX() + this.SPRITE_SIZEX;
        this.allBorders[2] = character.getRTBY();
        this.allBorders[3] = character.getRTBY() + this.SPRITE_SIZEY;
        this.addCollider(Session.get().curBoard.mech);
    }
    public void addCollider(Mechmap mechmap){//by default, there is "-3" down here
        for(int i = this.allBorders[0]; i < this.allBorders[1]; i++){ // somehow a collider is too wide and runs over
            for(int j = this.allBorders[2]; j < this.allBorders[3]; j++){ //the border of the mechmap at the right and bottom sides
                mechmap.dots[i][j] = true;
            }
        }
    }
    public void erraseCollider(Mechmap mechmap){//by default, there is "-3" down here? like this.allBorders[1] - 3 and this.allBorders[3] - 3
        for(int i = this.allBorders[0]; i < this.allBorders[1]; i++){ // somehow a collider is too wide and runs over
            for(int j = this.allBorders[2]; j < this.allBorders[3]; j++){ //the border of the mechmap at the right and bottom sides
                mechmap.dots[i][j] = false;
            }
        }
    }
    public boolean isTouchingOtherColliders(Collidable other)
    {
        boolean answer = false;
        if(isTouchingRightX(other) && isTouchingLeftX(other)){
            if(isTouchingDownY(other) && isTouchingUpY(other)){
                answer = true;
            }
        }
        return answer;
    }
    public boolean isTouchingRightX(Collidable other)
    {
        boolean answer = false;
        if(other.getCollider().allBorders[1] - this.allBorders[0] >= 0){
            answer = true;
        }
        return answer;
    }
    public boolean isTouchingLeftX(Collidable other)
    {
        boolean answer = false;
        if(other.getCollider().allBorders[0] - this.allBorders[1] <= 0){
            answer = true;
        }
        return answer;
    }
    public boolean isTouchingDownY(Collidable other)
    {
        boolean answer = false;
        if(other.getCollider().allBorders[3] - this.allBorders[2] >= 0){
            answer = true;
        }
        return answer;
    }
    public boolean isTouchingUpY(Collidable other)
    {
        boolean answer = false;
        if(other.getCollider().allBorders[2] - this.allBorders[3] <= 0){
            answer = true;
        }
        return answer;
    }
    public int getBorderIndex(Collidable other)
    {
        int answer = 0;
        if(this.allBorders[0] == other.getCollider().allBorders[1]){
            answer = 1;
        }
        return answer;
    }
    public int getColliderCoordLeftX(){
        return allBorders[0];
    }
    public int getColliderCoordRightX(){
        return allBorders[1];
    }
    public int getColliderCoordUpY(){
        return allBorders[2];
    }
    public int getColliderCoordDownY(){
        return allBorders[3];
    }
    public int getColliderBorderCoordByBorderIndex(int index){
        return allBorders[index];
    }
    public void setColliderCoordLeftX(int deltaLeftX)
    {
        this.leftX = this.leftX + deltaLeftX;
    }
    public void setColliderCoordRightX(int deltaRightY)
    {
        this.rightX = this.rightX + deltaRightY;
    }
    public void setColliderCoordUpX(int deltaUpY)
    {
        this.upY = this.upY + deltaUpY;
    }
    public void setColliderCoordDownY(int deltaDownY)
    {
        this.downY = this.downY + deltaDownY;
    }
    public void setColliderBorderCoordByBorderIndex(int index, int deltaCoord){
        this.allBorders[index] = this.allBorders[index] + deltaCoord;
    }

}

package Logic;

import Logic.Colliders.Collidable;
import Logic.Colliders.ColliderObserver;
import Logic.Colliders.SquareCollider;
import Logic.Events.EventObserver;
import Logic.Strategies.MoveStrategyInterface;

public class Character extends PlayableObject implements Collidable, MovableObject {
    public int lives;
    public Velocity velocity;
    public SquareCollider squareCollider;
    public int movableIndex;
    public int colliderIndex;
    public MoveStrategyInterface movestrategy;
    static int counter = 0;
    Vector vector;
    public EventObserver eventObserver;
    public ColliderObserver colliderObserver;


    public Character(String name, int lives, int netX, int netY, int spriteNumber, int visibleIndex, int movableIndex, int colliderIndex)
    {
        super(name, netX, netY, spriteNumber, visibleIndex);
        this.lives = lives;
        this.velocity = new Velocity( 0, 0);
        this.squareCollider = new SquareCollider(this.pcStage.x, this.pcStage.y, this.SPRITE_SIZEX, this.SPRITE_SIZEY);
        this.movableIndex = movableIndex;
        this.colliderIndex = colliderIndex;
        this.form = Form.Character;
    }



    @Override
    public void performMove() {
        movestrategy.move(this);
        performVCMove();
        performColliderMove();
    }
    @Override
    public void performVCMove()
    {
        visualcontent.setVisualContentX(this.getRTBX());
        visualcontent.setVisualContentY(this.getRTBY());
    }
    public void performColliderMove()
    {
        this.squareCollider.colliderMove(this);
    }

    public boolean isTouchingColliders(NPC npc) {
        boolean answer = false;
        if(isTouchingRightX(npc) && isTouchingLeftX(npc)){
            if(isTouchingDownY(npc) && isTouchingUpY(npc)){
                answer = true;
            }
        }
        return answer;
    }

    @Override
    public byte[] getButtons() {
        return new byte[0];
    }

    public int getBorderIndex(NPC npc)
    {
        int answer = 0;
        if(this.squareCollider.allBorders[0] == npc.squareCollider.allBorders[1]){
            answer = 1;
        }
        return answer;
    }
    public boolean isTouchingRightX(NPC npc)
    {
        boolean answer = false;
        if(npc.squareCollider.allBorders[1] - this.squareCollider.allBorders[0] >= 0){
            answer = true;
        }
        return answer;
    }
    public boolean isTouchingLeftX(NPC npc)
    {
        boolean answer = false;
        if(npc.squareCollider.allBorders[0] - this.squareCollider.allBorders[1] <= 0){
            answer = true;
        }
        return answer;
    }
    public boolean isTouchingDownY(NPC npc)
    {
        boolean answer = false;
        if(npc.squareCollider.allBorders[3] - this.squareCollider.allBorders[2] >= 0){
            answer = true;
        }
        return answer;
    }
    public boolean isTouchingUpY(NPC npc)
    {
        boolean answer = false;
        if(npc.squareCollider.allBorders[2] - this.squareCollider.allBorders[3] <= 0){
            answer = true;
        }
        return answer;
    }

    public Velocity getVelocity()
    {
        return velocity;
    }

    public int getMovableIndex() {
        return movableIndex;
    }
    public SquareCollider getCollider()
    {
        return this.squareCollider;
    }


    public void setRTBX(int RTBX) {
        this.pcStage.x = this.pcStage.x + RTBX;
    }


    public void setRTBY(int RTBY) {
        this.pcStage.y = this.pcStage.y + RTBY;
    }
    @Override
    public void setRTBbyPC(PairCoord pc){
        this.pcStage.x = this.pcStage.x + pc.x;
        this.pcStage.y = this.pcStage.y + pc.y;
    }


    public void directSetRTWX(int RTWX) {
        this.pcWindow.x = RTWX;
    }


    public void directSetRTWY(int RTWY) {
        this.pcWindow.y = RTWY;
    }



    public void setVelocity(Velocity velocity)
    {
        this.velocity = velocity;
    }
    public void setCollider(SquareCollider squareCollider)
    {
        this.squareCollider = squareCollider;
    }
    public void setMovableIndex(int movableIndex) {
        this.movableIndex = movableIndex;
    }
    public void updateCollider(){
        this.squareCollider.colliderMove(this);
    }
    public Vector getVector(){
        return vector;
    }

    @Override
    public EventObserver getEventObserver() {
        return eventObserver;
    }
    @Override
    public ColliderObserver getColliderObserver(){
        return colliderObserver;
    }
}

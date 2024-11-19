package Logic;


import Logic.Colliders.ColliderObserver;
import Logic.Events.EventObserver;
import Logic.Strategies.MoveStrategyForPlayer;

public class Player extends Character{

    public byte[] buttons;
    public Player(String name, int lives, int netX, int netY, int spriteNumber, int visibleIndex, int movableIndex, int colliderIndex) {
        super(name, lives, netX, netY, spriteNumber, visibleIndex, movableIndex, colliderIndex);
        this.movestrategy = new MoveStrategyForPlayer();
        this.buttons = new byte[4];
        for(byte bool : this.buttons){
            bool = 0;
        }
        this.eventObserver = new EventObserver(this.pcStage.x,this.pcStage.y, this.SPRITE_SIZEX, this.SPRITE_SIZEY);
        this.colliderObserver = new ColliderObserver(this.pcStage.x,this.pcStage.y, this.SPRITE_SIZEX, this.SPRITE_SIZEY);
    }
    @Override
    public void performMove() {
        eventObserver.moveObserver(this.pcStage.x, this.pcStage.y);
        colliderObserver.moveObserver(this.pcStage.x, this.pcStage.y);
        super.performMove();

    }
    @Override
    public byte[] getButtons() {
        return buttons;
    }
    public void setButtons(byte[] buttons) {
        this.buttons = buttons;
    }
    public void updateButtons(int index, int bool)
    {
        this.buttons[index] = (byte) bool;
    }
    void setVector(){

    }
}

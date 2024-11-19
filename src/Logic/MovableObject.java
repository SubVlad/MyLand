package Logic;

import Logic.Colliders.ColliderObserver;
import Logic.Colliders.SquareCollider;
import Logic.Events.EventObserver;

public interface MovableObject {
    Velocity getVelocity();
    int getMovableIndex();
    void setRTBX(int RTBX);
    void setRTBY(int RTBY);
    void setRTBbyPC(PairCoord pc);
    void directSetRTWX(int RTWX);
    void directSetRTWY(int RTWY);
    void setVelocity(Velocity velocity);
    void setMovableIndex(int movableIndex);
    String getName();
    void performMove();
    void performVCMove();
    void performColliderMove();
    int getRTBX();
    int getRTBY();
    boolean isTouchingColliders(NPC npc);
    byte[] getButtons();
    SquareCollider getCollider();
    int getSpriteSizeX();
    int getSpriteSizeY();
    void updateCollider();
    Vector getVector();
    EventObserver getEventObserver();
    ColliderObserver getColliderObserver();
}

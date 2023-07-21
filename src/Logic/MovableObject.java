package Logic;

public interface MovableObject {
    Velocity getVelocity();
    int getMovableIndex();
    void setRTWX(int RTWX);
    void setRTWY(int RTWY);
    void setVelocity(Velocity velocity);
    void setMovableIndex(int movableIndex);
    String getName();
    void move();
}

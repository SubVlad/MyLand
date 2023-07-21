package Logic;

public class Collider { //квадратное тело коллайдера
    public int leftX; // это всё - координаты границ тела коллайдера
    public int rightX;
    public int upY;
    public int downY;
    public Collider(int RTWX, int RTWY, int SPRITE_SIZEX, int SPRITE_SIZEY)
    {
        this.leftX = RTWX;
        this.rightX = SPRITE_SIZEY;
        this.upY = RTWY;
        this.downY = SPRITE_SIZEX;
    }
    public int getColliderCoordLeftX()
    {
        return leftX;
    }
    public int getColliderCoordRightX()
    {
        return rightX;
    }
    public int getColliderCoordUpY()
    {
        return upY;
    }
    public int getColliderCoordDownY()
    {
        return downY;
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

}

package Logic;

public interface VisibleObject {
    String getName();
    int getSpriteNumber();
    int getSpriteSizeX(String name);
    int getSpriteSizeY(String name);
    int getX();
    int getY();
    int getHex3axis();
    int getRTWX();
    int getRTWY();
    Form getForm();
    boolean getIsCurrent();
    VisualContent getVisualContent();
    int getVisibleIndex();
    void setName(String name);
    void setSpriteNumber(int spriteNumber);
    void setX(int netX);
    void setIsCurrent(boolean isCurrent);
    void setVisualContent(VisualContent visualcontent);
    void setVisibleIndex(int visibleIndex);
    Velocity getVelocity();
}

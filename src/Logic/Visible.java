package Logic;

public interface Visible {
    String getName();
    int getSpriteNumber();
    int getSpriteSizeX();
    int getSpriteSizeY();
    int loadSpriteSizeX(String name);
    int loadSpriteSizeY(String name);
    int getHex3axis();
    int getRTWX();
    int getRTWY();
    Form getForm();
    VisualContent getVisualContent();
    int getVisibleIndex();
    void setName(String name);
    void setSpriteNumber(int spriteNumber);
    void setVisualContent(VisualContent visualcontent);
    void setVisibleIndex(int visibleIndex);
}

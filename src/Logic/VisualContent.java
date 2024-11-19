package Logic;

import java.awt.*;

public class VisualContent extends GameObject {
    private String name;
    public Image image;
    public PairCoord pc; // related to window
    public int spriteSizeX;
    public int spriteSizeY;

    public VisualContent (String name, Image image, int spriteSizeX, int spriteSizeY, int RTWX, int RTWY, Form form)
    {//this is an object used directly by JPanel's paintComponent(Graphics g) to draw a panel
        //this clas is used to draw sprites of interactable (playable) objects
        //which would move if you move the camera
        this.name = name;
        this.image = image;
        this.spriteSizeX = spriteSizeX;
        this.spriteSizeY = spriteSizeY;
        this.pc = new PairCoord(RTWX,RTWY);
    }
    public Image getImage()
    {
        return image;
    }
    public void setImage(Image image)
    {
        this.image = image;
    }
    public int getVisualContentX()
    {
        return pc.x;
    }
    public void setVisualContentX(int RTWX){
        this.pc.x = RTWX;
    }
    public int getVisualContentY()
    {
        return pc.y;
    }
    public void setVisualContentY(int RTWY)
    {
        this.pc.y = RTWY;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
}

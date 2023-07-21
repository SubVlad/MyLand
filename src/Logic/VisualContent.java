package Logic;

import java.awt.*;

public class VisualContent {
    private String name;
    public Image image;
    public int RTWX;
    public int RTWY;
    public int spriteSizeX;
    public int spriteSizeY;

    public VisualContent (String name, Image image, int spriteSizeX, int spriteSizeY, int RTWX, int RTWY, Form frm)
    {
        this.name = name;
        this.image = image;
        this.spriteSizeX = spriteSizeX;
        this.spriteSizeY = spriteSizeY;
        this.RTWX = RTWX;
        this.RTWY = RTWY;
    }
    public Image getImage()
    {
        return image;
    }
    public void setImage(Image image)
    {
        this.image = image;
    }
    public double getRTWX()
    {
        return RTWX;
    }
    public void setRTWX(int RTWX)
    {
        this.RTWX = RTWX;
    }
    public double getRTWY()
    {
        return RTWY;
    }
    public void setRTWY(int RTWY)
    {
        this.RTWY = RTWY;
    }
    public String getName()
    {
        return name;
    }
    public void setName(int name)
    {
        this.name = String.valueOf(name);
    }
}

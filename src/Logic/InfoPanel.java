package Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.*;

public class InfoPanel extends VisibleObject
{
    public InfoPanel(String name, int x,int y, int spriteNumber, int visibleIndex)
    {
        super(name,x,y, spriteNumber, visibleIndex);
        this.form = Form.InfoPanel;
    }

}
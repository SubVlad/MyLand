package Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.*;

public class InfoPanel implements VisibleObject, Serializable
{
    public String name;
    public int spriteNumber;
    public int SPRITE_SIZEX;
    public int SPRITE_SIZEY;
    public int netX;
    public int netY;
    public int z;
    public int RTWX;
    public int RTWY;
    public Form frm = Form.valueOf("InfoPanel");
    public int index;
    public InfoPanel(String InfoPanelName, int netX, int netY, int spriteNumber, int index)
    {
        this.name = InfoPanelName;
        this.SPRITE_SIZEX = getSpriteSizeX(InfoPanelName);
        this.SPRITE_SIZEY = getSpriteSizeY(InfoPanelName);
        this.netX = netX;
        this.netY = netY;
        this.RTWX = this.netX * this.SPRITE_SIZEX + Game.BoardsInGame.get(Game.currentBoard).centerX;
        this.RTWY = this.netY * this.SPRITE_SIZEY + Game.BoardsInGame.get(Game.currentBoard).centerY;
        this.spriteNumber = spriteNumber;
        this.index = index;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSpriteNumber() {
        return spriteNumber;
    }

    @Override
    public int getSpriteSizeX(String name) {
        int answer;
        try{
            String filename = name + ".png";
            BufferedImage bi = ImageIO.read(new File(filename));
            answer = bi.getWidth();
        } catch (IOException e) {
            System.out.println("oups! error getSpriteSizeX");
            throw new RuntimeException(e);
        }
        return answer;
    }

    @Override
    public int getSpriteSizeY(String name) {
        int answer;
        try{
            String filename = name + ".png";
            BufferedImage bi = ImageIO.read(new File(filename));
            answer = bi.getHeight();
        } catch (IOException e) {
            System.out.println("oups! error getSpriteSizeX");
            throw new RuntimeException(e);
        }
        return answer;
    }

    @Override
    public int getX() {
        return netX;
    }

    @Override
    public int getY() {
        return netY;
    }

    @Override
    public int getHex3axis() {
        return z;
    }

    public int getRTWX()
    {
        return RTWX;
    }
    public int getRTWY()
    {
        return RTWY;
    }

    @Override
    public Form getForm() {
        return frm;
    }

    @Override
    public boolean getIsCurrent() {
        return false;
    }

    @Override
    public VisualContent getVisualContent() {
        return null;
    }

    @Override
    public int getVisibleIndex() {
        return index;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSpriteNumber(int spriteNumber) {
        this.spriteNumber = spriteNumber;
    }
    public void setX(int netX){
        this.netX = netX;
    }

    @Override
    public void setIsCurrent(boolean isCurrent) {

    }

    @Override
    public void setVisualContent(VisualContent visualcontent) {

    }

    @Override
    public void setVisibleIndex(int index) {
        this.index = index;
    }

    @Override
    public Velocity getVelocity() {
        return null;
    }
}
package Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.*;

public class Hex implements VisibleObject, Serializable{
    public String name;
    public int spriteNumber;
    public int SPRITE_SIZEX;
    public int SPRITE_SIZEY;
    public int netX;
    public int netY;
    public int hex3axis;
    public int RTWX;
    public int RTWY;
    public Form form = Form.valueOf("hex");
    public boolean isCurrent;
    public int index;
    public Hex(String hexName, int netX, int netY, int hex3axis, int spriteNumber)
    {
        this.name = hexName;
        this.SPRITE_SIZEX = getSpriteSizeX(hexName);
        this.SPRITE_SIZEY = getSpriteSizeY(hexName);
        this.spriteNumber = spriteNumber;
        this.netX = netX;
        this.netY = netY;
        this.hex3axis = hex3axis;
        this.RTWX = this.netX * this.SPRITE_SIZEX + Game.BoardsInGame.get(Game.currentBoard).centerX;
        this.RTWY = this.netY * this.SPRITE_SIZEY + Game.BoardsInGame.get(Game.currentBoard).centerY;
        this.RTWX = (int) (this.RTWX
                - (this.SPRITE_SIZEX * 0.5)
                - ((this.SPRITE_SIZEX * 0.01) * netX)
                + ((this.SPRITE_SIZEX * 0.5) * netY)
                - ((this.SPRITE_SIZEX * 0.005) * hex3axis));
        this.RTWY = (int) (this.RTWY
                - (this.SPRITE_SIZEY * 0.5)
                //- (this.spriteSizeY * 0.1)
                - ((this.SPRITE_SIZEY * 0.01) * netX)
                - ((this.SPRITE_SIZEY * 1.76) * netY)
                - ((this.SPRITE_SIZEY * 0.0024) * hex3axis));
        this.isCurrent = false;
    }


    public String getName() {
        return name;
    }

    public int getSpriteNumber() {
        return spriteNumber;
    }

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
            System.out.println("oups! error getSpriteSizeY");
            throw new RuntimeException(e);
        }
        return answer;
    }

    public int getX() {
        return netX;
    }

    public int getY() {
        return netY;
    }

    public int getHex3axis() {
        return hex3axis;
    }

    public int getRTWX()
    {
        return RTWX;
    }
    public int getRTWY()
    {
        return RTWY;
    }

    public Form getForm() {
        return form;
    }
    public boolean getIsCurrent()
    {
        return isCurrent;
    }

    @Override
    public VisualContent getVisualContent() {
        return null;
    }

    @Override
    public int getVisibleIndex() {
        return index;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setSpriteNumber(int spriteNumber){
        this.spriteNumber = spriteNumber;
    }
    public void setX(int netX){
        this.netX = netX;
    }

    @Override
    public void setIsCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
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
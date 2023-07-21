package Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Square implements GameObject, VisibleObject {
    public String name;
    public int spriteNumber;
    public int SPRITE_SIZEX;
    public int SPRITE_SIZEY;
    public int netX;
    public int netY;
    public int RTWX;
    public int RTWY;
    public Form form = Form.valueOf("Square");
    public boolean isCurrent;
    public int index;
    public Square(String name, int netX, int netY, int spriteNumber, int index)
    {
        this.name = name;
        this.SPRITE_SIZEX = getSpriteSizeX(name);
        this.SPRITE_SIZEY = getSpriteSizeY(name);
        this.spriteNumber = spriteNumber;
        this.netX = netX;
        this.netY = netY;
        this.RTWX = this.netX * this.SPRITE_SIZEX + Game.BoardsInGame.get(Game.currentBoard).centerX;
        this.RTWY = this.netY * this.SPRITE_SIZEY + Game.BoardsInGame.get(Game.currentBoard).centerY;
        this.RTWX = (int) (this.RTWX - (this.SPRITE_SIZEX * 0.5));
        this.RTWY = (int) (this.RTWY - (this.SPRITE_SIZEY * 0.5));
        this.isCurrent = false;
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
            System.out.println("oups! error getSpriteSizeY");
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
        return 0;
    }

    @Override
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

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public void setIndex(int index) {

    }
}

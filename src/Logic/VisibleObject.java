package Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VisibleObject extends GameObject implements Visible {
    public String name;
    public int spriteNumber;
    public int SPRITE_SIZEX;
    public int SPRITE_SIZEY;
    public int SQUARE_SPRITE_SIZEX;
    public int SQUARE_SPRITE_SIZEY;
    public PairCoord pcWindow; // position related to window
    //public PairCoord pcStage; // position related to board, that is - position in game
    public Form form;
    public VisualContent visualcontent;
    public int visibleIndex;

    public VisibleObject(String name, int x, int y, int spriteNumber, int visibleIndex)
    {
        this.name = name;
        this.SPRITE_SIZEX = loadSpriteSizeX(name);
        this.SPRITE_SIZEY = loadSpriteSizeY(name);
        this.SQUARE_SPRITE_SIZEX = loadSpriteSizeX("Square");
        this.SQUARE_SPRITE_SIZEY = loadSpriteSizeY("Square");
        this.spriteNumber = spriteNumber;
        this.visibleIndex = visibleIndex;
        this.pcWindow = new PairCoord(x,y);
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
    public int getSpriteSizeX() {
        return SPRITE_SIZEX;
    }

    @Override
    public int getSpriteSizeY() {
        return SPRITE_SIZEY;
    }

    public int loadSpriteSizeX(String name){
        int answer = 0;
        try{
            String filename = "images/" + name + ".png";
            BufferedImage bi = ImageIO.read(new File(filename));
            answer = bi.getWidth();
        } catch (IOException e) {
            System.out.println("oups! error getSpriteSizeX");
        }
        return answer;
    }
    public int loadSpriteSizeY(String name){
        int answer = 0;
        try{
            String filename = "images/" + name + ".png";
            BufferedImage bi = ImageIO.read(new File(filename));
            answer = bi.getHeight();
        } catch (IOException e) {
            System.out.println("oups! error getSpriteSizeY");
        }
        return answer;

    }




    @Override
    public int getHex3axis() {
        return 0;
    }

    @Override
    public int getRTWX(){
        return this.pcWindow.x;
    }
    public int getRTWY(){
        return this.pcWindow.y;
    }



    public Form getForm() {
        return form;
    }


    @Override
    public VisualContent getVisualContent() {
        return visualcontent;
    }

    @Override
    public int getVisibleIndex() {
        return visibleIndex;
    }



    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSpriteNumber(int spriteNumber) {
        this.spriteNumber = spriteNumber;
    }



    @Override
    public void setVisualContent(VisualContent visualcontent) {
        this.visualcontent = visualcontent;
    }

    @Override
    public void setVisibleIndex(int visibleIndex) {
        this.visibleIndex = visibleIndex;
    }

}

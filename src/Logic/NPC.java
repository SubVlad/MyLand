package Logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NPC implements GameObject, VisibleObject, MovableObject, ColliderObject {
    public String name;
    public int lives;
    public int spriteNumber;
    public int SPRITE_SIZEX;
    public int SPRITE_SIZEY;
    public int SQUARE_SPRITE_SIZEX;
    public int SQUARE_SPRITE_SIZEY;
    public int netX;
    public int netY;
    public int RTWX;
    public int RTWY;
    public Form form = Form.valueOf("NPC");
    public Velocity velocity;
    public Collider collider;
    public VisualContent visualcontent;
    public int visibleIndex;
    public int movableIndex;
    public int colliderIndex;

    public NPC(String name, int lives, int netX, int netY, int spriteNumber, int visibleIndex, int movableIndex, int colliderIndex)
    {
        this.name = name;
        this.lives = lives;
        this.SPRITE_SIZEX = getSpriteSizeX(name);
        this.SPRITE_SIZEY = getSpriteSizeY(name);
        this.SQUARE_SPRITE_SIZEX = getSpriteSizeX("Square");
        this.SQUARE_SPRITE_SIZEY = getSpriteSizeY("Square");
        this.spriteNumber = spriteNumber;
        this.netX = netX;
        this.netY = netY;
        this.RTWX = Game.BoardsInGame.get(Game.currentBoard).centerX - ((int) (this.SPRITE_SIZEX * 0.5));
        this.RTWY = Game.BoardsInGame.get(Game.currentBoard).centerY - ((int) (this.SPRITE_SIZEY * 0.5));
        this.RTWX = this.RTWX + this.netX * this.SQUARE_SPRITE_SIZEX;
        this.RTWY = this.RTWY + this.netY * this.SQUARE_SPRITE_SIZEY;
        this.velocity = new Velocity(0, 0);
        this.collider = new Collider(this.RTWX, this.RTWY, SPRITE_SIZEX, SPRITE_SIZEY);
        this.visibleIndex = visibleIndex;
        this.movableIndex = movableIndex;
        this.colliderIndex = colliderIndex;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void move() {
        this.setRTWX(this.velocity.getPathX());
        this.setRTWY(this.velocity.getPathY());
        //
        this.getVelocity().directMe();
        //
        this.getVisualContent().setRTWX(this.getRTWX());
        this.getVisualContent().setRTWY(this.getRTWY());
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

    @Override
    public boolean getIsCurrent() {
        return false;
    }

    @Override
    public VisualContent getVisualContent() {
        return visualcontent;
    }

    public Velocity getVelocity()
    {
        return velocity;
    }


    @Override
    public int getVisibleIndex() {
        return visibleIndex;
    }
    @Override
    public int getMovableIndex() {
        return movableIndex;
    }

    @Override
    public void setRTWX(int RTWX) {
        this.RTWX = this.RTWX + RTWX;
    }

    @Override
    public void setRTWY(int RTWY) {
        this.RTWY = this.RTWY + RTWY;
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

    }

    @Override
    public void setVisualContent(VisualContent visualcontent) {
        this.visualcontent = visualcontent;
    }

    public void setVelocity(Velocity velocity)
    {
        this.velocity = velocity;
    }


    @Override
    public void setVisibleIndex(int visibleIndex) {
        this.visibleIndex = visibleIndex;
    }

    @Override
    public void setMovableIndex(int movableIndex) {
        this.movableIndex = movableIndex;
    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public void setIndex(int index) {

    }
}

package Logic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;


public class Game {
    public static ArrayList<Board> BoardsInGame = new ArrayList<>();
    public static VisualContent[] VOinGame;
    public static ArrayList<VisualContent> EVCCurrentBoard;
    public static ArrayList<VisualContent> MVCCurrentBoard;
    public static ImageIcon[] iicon = new ImageIcon[Sprite.values().length];
    public static Image[] images = new Image[Sprite.values().length];
    public static Player[] players = new Player[1];
    public static int obInGameQu;
    public static int curobqu;
    public static int currentBoard;
    public static int rangeX;
    public static int rangeY;
    public static int startX;
    public static int startY;
    public static int startZ;
    public static int pixelPositionX;
    public static int pixelPositionY;
    public static boolean SPressed = false;
    public static int keyNumber = 0;
    public static int turn = 0;
    public static int greenCircleIndex;
    public static boolean isStarted;


    public Game() {

        loadImages();
        //Cursor cursor = new Cursor();
        currentBoard = 0;
        BoardsInGame.add(new Board("world", 600, 600, 3));
        VOinGame = new VisualContent[5];
        drawSquarePattern(BoardsInGame.get(currentBoard).boardScale);
        //BoardsInGame.get(currentBoard).setInfoPanel("Player1", -2, -6, Sprite.Player1.ordinal());
        //BoardsInGame.get(currentBoard).setInfoPanel("Player2", 1, -6, Sprite.Player2.ordinal());
        //BoardsInGame.get(currentBoard).setInfoPanel("GreenCircle", -4, -5, Sprite.GreenCircle.ordinal());
        //BoardsInGame.get(currentBoard).setInfoPanel("Save", -3, 4, Sprite.Save.ordinal());
        //BoardsInGame.get(currentBoard).setInfoPanel("Load", 2, 4, Sprite.Load.ordinal());
        //BoardsInGame.get(currentBoard).getSquare(1).setSpriteNumber(Sprite.Grass.ordinal());
        BoardsInGame.get(currentBoard).getSquaresByRTWY(3).forEach((n) -> n.setSpriteNumber(Sprite.Grass.ordinal()));
        BoardsInGame.get(currentBoard).getSquaresByRTWY(2).forEach((n) -> n.setSpriteNumber(Sprite.Grass.ordinal()));
        BoardsInGame.get(currentBoard).getSquaresByRTWY(1).forEach((n) -> n.setSpriteNumber(Sprite.Sand.ordinal()));
        BoardsInGame.get(currentBoard).getSquaresByRTWY(0).forEach((n) -> n.setSpriteNumber(Sprite.Water.ordinal()));
        BoardsInGame.get(currentBoard).getSquaresByRTWY(-1).forEach((n) -> n.setSpriteNumber(Sprite.Sand.ordinal()));
        BoardsInGame.get(currentBoard).getSquaresByRTWY(-2).forEach((n) -> n.setSpriteNumber(Sprite.Grass.ordinal()));
        BoardsInGame.get(currentBoard).getSquaresByRTWY(-3).forEach((n) -> n.setSpriteNumber(Sprite.Grass.ordinal()));
        BoardsInGame.get(currentBoard).setNPC("GreenElf", 100, 0, 1, Sprite.GreenElf.ordinal());
        BoardsInGame.get(currentBoard).setPlayer("Elf", 100, 0, 3, Sprite.Elf.ordinal());
        this.isStarted = true;
        changeBoard(currentBoard);




        /*BoardsInGame.get(currentBoard).setBody(1);
        BoardsInGame.get(currentBoard).setBody(3);
        BoardsInGame.get(currentBoard).setSoul(5, 2);
        System.out.println("object0 " + BoardsInGame.get(currentBoard).objects.get(0).getSt());
        System.out.println("object1 " + BoardsInGame.get(currentBoard).objects.get(1).getSt());
        int bo = ((Board.Body)BoardsInGame.get(currentBoard).objects.get(1)).getEnergy();
        System.out.println("object1 energy " + bo);
        System.out.println("object2 " + BoardsInGame.get(currentBoard).objects.get(2).getSt());
        BoardsInGame.get(currentBoard).objects.get(2).setHand(7);
        System.out.println("object2 hand " + BoardsInGame.get(currentBoard).objects.get(2).getHand());*/


    }

    public static void loadImages()
    {
        for(int i = 0; i < iicon.length; i++){
            String filename = Sprite.values()[i] + ".png";
            iicon[i] = new ImageIcon(filename);
            images[i] = iicon[i].getImage();
        }
    }
    public static void changeBoard(int currentBoard){
        EVCCurrentBoard = new ArrayList<>();
        MVCCurrentBoard = new ArrayList<>();
        for(int i = 0; i < BoardsInGame.get(currentBoard).EVO.size(); i++){
            EVCCurrentBoard.add(new VisualContent(BoardsInGame.get(currentBoard).EVO.get(i).getName(),
                    images[BoardsInGame.get(currentBoard).EVO.get(i).getSpriteNumber()],
                    BoardsInGame.get(currentBoard).EVO.get(i).getSpriteSizeX(BoardsInGame.get(currentBoard).EVO.get(i).getName()),
                    BoardsInGame.get(currentBoard).EVO.get(i).getSpriteSizeY(BoardsInGame.get(currentBoard).EVO.get(i).getName()),
                    BoardsInGame.get(currentBoard).EVO.get(i).getRTWX(),
                    BoardsInGame.get(currentBoard).EVO.get(i).getRTWY(),
                    BoardsInGame.get(currentBoard).EVO.get(i).getForm()));
            curobqu = i;

            /*if(rangeX < BoardsInGame.get(currentBoard).VO.get(i).getX()){
                rangeX = BoardsInGame.get(currentBoard).VO.get(i).getX();}
            if(rangeY < BoardsInGame.get(currentBoard).VO.get(i).getY()){
                rangeY = BoardsInGame.get(currentBoard).VO.get(i).getY();}
            if(BoardsInGame.get(currentBoard).VO.get(i).getName() == "greenCircle"){
                BoardsInGame.get(currentBoard).greenCircleIndex = BoardsInGame.get(currentBoard).VO.get(i).getVisibleIndex();}
            if(BoardsInGame.get(currentBoard).VO.get(i).getName() == "Save"){
                BoardsInGame.get(currentBoard).saveButtonIndex = BoardsInGame.get(currentBoard).VO.get(i).getVisibleIndex();}
            if(BoardsInGame.get(currentBoard).VO.get(i).getName() == "Load"){
                BoardsInGame.get(currentBoard).loadButtonIndex = BoardsInGame.get(currentBoard).VO.get(i).getVisibleIndex();}*/
        }
        for(int i = 0; i < BoardsInGame.get(currentBoard).MVO.size(); i ++){
            MVCCurrentBoard.add(new VisualContent(BoardsInGame.get(currentBoard).MVO.get(i).getName(),
                    images[BoardsInGame.get(currentBoard).MVO.get(i).getSpriteNumber()],
                    BoardsInGame.get(currentBoard).MVO.get(i).getSpriteSizeX(BoardsInGame.get(currentBoard).MVO.get(i).getName()),
                    BoardsInGame.get(currentBoard).MVO.get(i).getSpriteSizeY(BoardsInGame.get(currentBoard).MVO.get(i).getName()),
                    BoardsInGame.get(currentBoard).MVO.get(i).getRTWX(),
                    BoardsInGame.get(currentBoard).MVO.get(i).getRTWY(),
                    BoardsInGame.get(currentBoard).MVO.get(i).getForm()));
            BoardsInGame.get(currentBoard).MVO.get(i).setVisualContent(MVCCurrentBoard.get(i));
        }

        curobqu++;
    }
    public static void drawOneVoidHex(int i, int k, int l)
    {
        if(!BoardsInGame.get(currentBoard).hexExists(i, k, l)){
            BoardsInGame.get(currentBoard).setHex("voidHex", i, k, l, 0);
        }
    }
    public static void drawOneSquare(int i, int k)
    {
        if(!BoardsInGame.get(currentBoard).squareExists(i, k)){
            BoardsInGame.get(currentBoard).setSquare("Square", i, k, Sprite.Square.ordinal());
        }
    }
    public static void drawHexPattern(int scale)
    {
        for(int i = -scale; i <= scale; i ++){
            for(int k = -scale; k <= scale; k ++){
                for(int l = -scale; l <= scale; l ++){
                    if(i + k + l == 0) {
                        drawOneVoidHex(i, k, l);
                    }
                }
            }
        }
    }
    public static void drawSquarePattern(int scale)
    {
        for(int i = -scale; i <= scale; i ++){
            for(int k = -scale; k <= scale; k ++){
                        drawOneSquare(i, k);
            }
        }
    }
    public static void changeHexColor()
    {
        VisualContent VCinChange = getVisualContentByCoords(Cursor.netX, Cursor.netY);
        if(     keyNumber > 0 &&
                VCinChange.image != images[keyNumber] &&
                getVisualContentIndex(VCinChange) >= 0){
            Hex hexInChange = (Hex) BoardsInGame.get(currentBoard).VO.get(getVisualContentIndex(VCinChange));
            if(Game.isStarted){
                hexInChange.setSpriteNumber(keyNumber);
                VCinChange.setImage(images[hexInChange.getSpriteNumber()]);
                hexInChange.setIsCurrent(true);
                turn = 1 - turn;
                Game.isStarted = false;
            }else{                                                                                                         //BoardsInGame.get(currentBoard).curHex
                if(     BoardsInGame.get(currentBoard).checkHexesInNeighboursIfIsCurrent(BoardsInGame.get(currentBoard).findHexNeighboursByCoords(hexInChange)) // тут проверка - только соседи предыдущего гекса
                        && !BoardsInGame.get(currentBoard).checkHexesAround(BoardsInGame.get(currentBoard).findHexNeighboursByCoords(hexInChange), keyNumber)) { // тут проверка - только если по соседству нет гекса с таким же цветом
                    hexInChange.setSpriteNumber(keyNumber);
                    VCinChange.setImage(images[hexInChange.getSpriteNumber()]);
                    hexInChange.setIsCurrent(true);
                    BoardsInGame.get(currentBoard).findHexNeighboursByCoords(hexInChange).forEach((n) -> n.setIsCurrent(false));// это действие ищет всех соседей этого гекса и ставит им isCurrent = false
                    turn = 1 - turn;
                }
            }
        }
        if(keyNumber == 0 &&
           VCinChange.image == images[8] &&
           getVisualContentIndex(VCinChange) >= 0){
            saveGame();
            changeBoard(currentBoard);
        }
        if(keyNumber == 0 &&
                VCinChange.image == images[9] &&
                getVisualContentIndex(VCinChange) >= 0){
            loadGame();
            changeBoard(currentBoard);
        }
    }
    public static void saveGame()
    {
        String filename = "savedGame.dat";
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename)))
        {
            oos.writeObject(BoardsInGame.get(currentBoard).VO);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }
    public static void loadGame()
    {
        String filename = "savedGame.dat";
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
        {

            BoardsInGame.get(currentBoard).VO=((ArrayList<VisibleObject>)ois.readObject());
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        Game.isStarted = false;

    }
    /*public static void changeGreenCircle()
    {
        if(BoardsInGame.get(currentBoard).VO.get(BoardsInGame.get(currentBoard).greenCircleIndex).getX() == -4){
            BoardsInGame.get(currentBoard).VO.get(BoardsInGame.get(currentBoard).greenCircleIndex).setX(3);
            EVCCurrentBoard.get(BoardsInGame.get(currentBoard).greenCircleIndex).RTWX = 3 * 50 + BoardsInGame[Game.currentBoard].centerX;

        }else{
            BoardsInGame.get(currentBoard).VO.get(BoardsInGame.get(currentBoard).greenCircleIndex).setX(-4);
            EVCCurrentBoard.get(BoardsInGame.get(currentBoard).greenCircleIndex).RTWX = -4 * 50 + BoardsInGame[Game.currentBoard].centerX;
        }
    }*/
    public static int getVisualContentIndex(VisualContent o)
    {
        return EVCCurrentBoard.indexOf(o);
    }
    public static VisualContent getVisualContentByCoords(int netX, int netY)
    {
        VisualContent obj = null;
        VisualContent objInCheck = null;
        for(int i = 0; i < EVCCurrentBoard.size(); i ++){
            if(
                    netX > (EVCCurrentBoard.get(i).getRTWX()) &&
                    netX < (EVCCurrentBoard.get(i).getRTWX() + EVCCurrentBoard.get(i).spriteSizeX) &&
                    netY > (EVCCurrentBoard.get(i).getRTWY()) &&
                    netY < (EVCCurrentBoard.get(i).getRTWY() + EVCCurrentBoard.get(i).spriteSizeY)
            ){
                objInCheck = EVCCurrentBoard.get(i);
                if(hexBodyPixelIsTransparent(objInCheck)){
                    obj = objInCheck;
                }
            }
        }
        return obj;
    }
    public static boolean hexBodyPixelIsTransparent(VisualContent obj)
    {
        boolean zeroCheck = true;
        int newX;
        int newY;
        int rgb;
        try{
            obj = EVCCurrentBoard.get(EVCCurrentBoard.indexOf(obj));
            String filename = obj.getName() + ".png";;
            BufferedImage bi = ImageIO.read(new File(filename));
            newX = (int) (Cursor.netX - obj.getRTWX());
            newY = (int) (Cursor.netY - obj.getRTWY());
            rgb = bi.getRGB(newX, newY);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(rgb >= 0){
            zeroCheck = false;
        }
        return zeroCheck;
    }
    public static class Cursor {
        public static int netX;
        public static int netY;
        public Cursor()
        {
        }
    }
}

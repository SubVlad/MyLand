package Logic;

import Logic.Events.CollisionEvent;
import Logic.Events.EventSystem;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;


public class Session {
    private static volatile Session instance;
    public ArrayList<Board> BoardsInGame = new ArrayList<>();
    VisualContent[] VOinGame;
    public ArrayList<VisualContent> EVCCurrentBoard;
    public ArrayList<VisualContent> MVCCurrentBoard;
    public ArrayList<VisualContent> IPCurrentBoard;
    public ImageIcon[] iicon;
    public Image[] images;
    public Player[] players = new Player[1];
    public static NPC[] npcs = new NPC[1];
    public static  int obInGameQu;
    public int curobqu;
    public int currentBoardIndex;
    int rangeX;
    int rangeY;
    int startX;
    int startY;
    int startZ;
    int pixelPositionX;
    int pixelPositionY;
    boolean SPressed = false;
    public int keyNumber = 0;
    int turn = 0;
    int greenCircleIndex;
    boolean isStarted;
    String[] imagesNames;
    public Board curBoard;
    public Cursor cursor;
    public ArrayList<Thread> threads;
    public EventSystem eventSystem;
    public PairCoord cameraDelta;
    public PairCoord cameraPosition;
    public static Session get(){
        Session localInstance = instance;
         if(localInstance == null){
             synchronized (Session.class){
                 localInstance = instance;
                 if(localInstance == null){
                     instance = localInstance = new Session();
                     instance.instanciateSession();
                 }
             }
         }
         return instance;
    }
     private Session(){}
    private void instanciateSession() {
        loadImages();
        cursor = new Cursor();
        currentBoardIndex = 0;
        cameraDelta = new PairCoord(0,0);
        BoardsInGame.add(new Board("River", 600, 600, 16));
        curBoard = BoardsInGame.get(currentBoardIndex);
        curBoard.drawSquarePattern(curBoard.boardScale);
        int xSize = curBoard.getSquaresByNetY(0).get(0).loadSpriteSizeX("Square") * (curBoard.boardScale + 1);
        int ySize = curBoard.getSquaresByNetY(0).get(0).loadSpriteSizeY("Square") * (curBoard.boardScale + 2);
        curBoard.mech = new Mechmap(xSize, ySize);
        eventSystem = EventSystem.get();
        for(int i = 0; i < curBoard.boardScale; i++){
            curBoard.getSquaresByNetY(i).forEach((n) -> n.setSpriteNumber(getIndexFromArrayImagesNamesByName("Sand.png")));
        }
        for(int i = 0; i < curBoard.boardScale; i++){
            curBoard.setNPC("Water", 100, 0, i, getIndexFromArrayImagesNamesByName("Water.png"));
            curBoard.setNPC("Water", 100, curBoard.boardScale, i, getIndexFromArrayImagesNamesByName("Water.png"));
        }
        for(int i = 0; i <= curBoard.boardScale; i++){
            curBoard.setNPC("Water", 100, i, 0, getIndexFromArrayImagesNamesByName("Water.png"));
            curBoard.setNPC("Water", 100, i, curBoard.boardScale, getIndexFromArrayImagesNamesByName("Water.png"));
        }

        for(int i = 5; i <= 7; i++){
            curBoard.setNPC("GreenElf", 100, i, 7, getIndexFromArrayImagesNamesByName("GreenElf.png"));
            curBoard.setNPC("GreenElf", 100, i, 9, getIndexFromArrayImagesNamesByName("GreenElf.png"));
        }

        curBoard.setInfoPanel("Void", 10,10,Session.get().getIndexFromArrayImagesNamesByName("Void.png"));
        curBoard.setEvent(PairCoord.pc1, new CollisionEvent());
        curBoard.setPlayer("MouseInJacket", 100, 4, 8, getIndexFromArrayImagesNamesByName("MouseInJacket.png"));
        cameraPosition = new PairCoord(-players[0].getRTWX()+250,-players[0].getRTWY()+250);
        for(int i = 0; i < curBoard.colliders.size(); i++){
            curBoard.colliders.get(i).addCollider(curBoard.mech);
        }
        isStarted = true;
        changeBoard(currentBoardIndex);






    }

     void loadImages(){
        String dirName = "images";
        File dir = new File(dirName);
        imagesNames = dir.list();
        iicon = new ImageIcon[imagesNames.length];
        images = new Image[imagesNames.length];
        for(int i = 0; i < imagesNames.length; i++){
            iicon[i] = new ImageIcon(dirName+"/"+imagesNames[i]);
            images[i] = iicon[i].getImage();
        }
    }
    public int getIndexFromArrayImagesNamesByName(String name){
        int index = -1;
        for(int i = 0; i < this.imagesNames.length;i++){
            if(this.imagesNames[i].equals(name)){
                index = i;
                break;
            }
        }
        return index;
    }
     public void changeBoard(int newBoardIndex){
        EVCCurrentBoard = new ArrayList<>();
        MVCCurrentBoard = new ArrayList<>();
        IPCurrentBoard = new ArrayList<>();
        Board newBoard = BoardsInGame.get(newBoardIndex);
        for(int i = 0; i < newBoard.environments.size(); i++){
            EVCCurrentBoard.add(new VisualContent(
                    newBoard.environments.get(i).getName(),
                    images[newBoard.environments.get(i).getSpriteNumber()],
                    newBoard.environments.get(i).getSpriteSizeX(),
                    newBoard.environments.get(i).getSpriteSizeY(),
                    newBoard.environments.get(i).getRTBX(),
                    newBoard.environments.get(i).getRTBY(),
                    newBoard.environments.get(i).getForm()));
            curobqu = i;
        }
        for(int i = 0; i < newBoard.movingVisibles.size(); i ++){
            MVCCurrentBoard.add(new VisualContent(
                    newBoard.movingVisibles.get(i).getName(),
                    images[newBoard.movingVisibles.get(i).getSpriteNumber()],
                    newBoard.movingVisibles.get(i).getSpriteSizeX(),
                    newBoard.movingVisibles.get(i).getSpriteSizeY(),
                    newBoard.movingVisibles.get(i).getRTBX(),
                    newBoard.movingVisibles.get(i).getRTBY(),
                    newBoard.movingVisibles.get(i).getForm()));
            newBoard.movingVisibles.get(i).setVisualContent(MVCCurrentBoard.get(i));
        }
        for(int i = 0; i < newBoard.infoPanels.size(); i++){
            IPCurrentBoard.add(new VisualContent(
                    newBoard.infoPanels.get(i).getName(),
                    images[newBoard.infoPanels.get(i).getSpriteNumber()],
                    newBoard.infoPanels.get(i).getSpriteSizeX(),
                    newBoard.infoPanels.get(i).getSpriteSizeY(),
                    newBoard.infoPanels.get(i).getRTWX(),
                    newBoard.infoPanels.get(i).getRTWY(),
                    newBoard.infoPanels.get(i).getForm()));
            newBoard.infoPanels.get(i).setVisualContent(IPCurrentBoard.get(i));
        }
        curobqu++;
    }
     boolean pixelUnderCursorIsTransparent(VisualContent obj){
        boolean zeroCheck = true;
        int newX;
        int newY;
        int rgb;
        try{
            obj = EVCCurrentBoard.get(EVCCurrentBoard.indexOf(obj));
            String filename = obj.getName() + ".png";;
            BufferedImage bi = ImageIO.read(new File(filename));
            newX = (int) (cursor.netX - obj.getVisualContentX());
            newY = (int) (cursor.netY - obj.getVisualContentY());
            rgb = bi.getRGB(newX, newY);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(rgb >= 0){
            zeroCheck = false;
        }
        return zeroCheck;
    }
     public class Cursor {
         public int netX;
         public int netY;
        public Cursor()
        {
        }
    }
}

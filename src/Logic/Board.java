package Logic;

import Logic.Colliders.Collidable;
import Logic.Colliders.Collider;
import Logic.Events.CollisionEvent;
import Logic.Events.Event;
import Logic.Events.EventSystem;

import java.util.ArrayList;

public class Board {
    public String name;
    public int boardWidth;
    public int boardLength;
    public int boardScale;
    public ArrayList<InfoPanel> BoardInfoPanels;
    public ArrayList<PlayableObject> visibles;
    public ArrayList<PlayableObject> environments;
    public ArrayList<PlayableObject> movingVisibles;
    public ArrayList<MovableObject> movables;
    public ArrayList<Collidable> collidables;
    public ArrayList<Collider> colliders;
    public ArrayList<InfoPanel> infoPanels;
    public int obqu;
    public int centerX;
    public int centerY;
    public Mechmap mech;



    Board (String BoardName, int boardWidth, int boardLength, int boardScale)
    {
        this.name = BoardName;
        this.BoardInfoPanels = new ArrayList<>();
        this.visibles = new ArrayList<>(); // all visible objects;
        this.environments = new ArrayList<>(); //environment visible objects, not moving
        this.movingVisibles = new ArrayList<>(); // moving visible objects
        this.movables = new ArrayList<>(); // moving objects
        this.collidables = new ArrayList<>(); // collidable objects
        this.colliders = new ArrayList<>(); // colliders
        this.infoPanels = new ArrayList<>();
        this.boardWidth = boardWidth;
        this.boardLength = boardLength;
        this.boardScale = boardScale;
        this.centerX = (this.boardWidth / 2);
        this.centerY = (this.boardLength / 2);
    }
    public void setSquare(String name, int netX, int netY, int spriteNumber) {
        Square square = new Square(name, netX, netY, spriteNumber, this.visibles.size());
        this.visibles.add(square);
        this.environments.add(square);
        this.obqu++;
        Session.obInGameQu++;
    }
    public void setCharacter(String name, int lives, int netX, int netY, int spriteNumber) {
        Character newCharacter = new Character(name, lives, netX, netY, spriteNumber, this.visibles.size(), this.movingVisibles.size(), this.collidables.size());
        this.visibles.add(newCharacter);
        this.movingVisibles.add(newCharacter);
        //this.movables.add(newCharacter);
        this.collidables.add(newCharacter);
        this.colliders.add(newCharacter.squareCollider);
        this.obqu++;
        Session.obInGameQu++;
    }
    public void setPlayer(String name, int lives, int netX, int netY, int spriteNumber)
    {
        Player newPlayer = new Player(name, lives, netX, netY, spriteNumber, this.visibles.size(), this.movingVisibles.size(), this.collidables.size());
        this.visibles.add(newPlayer);
        this.movingVisibles.add(newPlayer);
        this.movables.add(newPlayer);
        this.collidables.add(newPlayer);
        this.colliders.add(newPlayer.squareCollider);
        Session.get().players[0] = newPlayer;
        this.obqu++;
        Session.obInGameQu++;
    }
    public void setNPC(String name, int lives, int netX, int netY, int spriteNumber) {
        NPC newNPC = new NPC(name, lives, netX, netY, spriteNumber, this.visibles.size(), this.movingVisibles.size(), this.collidables.size());
        this.visibles.add(newNPC);
        this.movingVisibles.add(newNPC);
        this.movables.add(newNPC);
        this.collidables.add(newNPC);
        this.colliders.add(newNPC.squareCollider);
        Session.npcs[0] = newNPC;
        this.obqu++;
        Session.obInGameQu++;
    }
    public void setInfoPanel(String name, int x, int y, int spriteNumber){
        InfoPanel newPanel = new InfoPanel(name,x,y,spriteNumber,this.visibles.size());
        //this.visibles.add(newPanel);
        this.infoPanels.add(newPanel);
        /*this.environments.add(newPanel);
        this.movingVisibles.add(newPanel);*/
        this.obqu++;
        Session.obInGameQu++;
    }
    public void setEvent(PairCoord pc, Event event){
        EventSystem.get().events.put(pc, event);
        EventSystem.get().eventmap.dots[pc.x][pc.y] = true;
    }

    public Visible getSquare(int index)
    {
        return this.visibles.get(index);
    }
    public ArrayList<Visible> getSquaresByNetY(int netY)
    {
        ArrayList<Visible> squares = new ArrayList<>();
        for(int i = 0; i < this.visibles.size(); i ++){
            if(this.visibles.get(i).getY() == netY){
                squares.add(this.visibles.get(i));
            }
        }
        return squares;
    }

    public boolean squareExists(int i, int k)
    {
        boolean answer = false;
        for(int f = 0; f < this.visibles.size(); f ++){
            if(this.visibles.get(f).getX() == i && this.visibles.get(f).getY() == k){
                answer = true;
                break;
            }else{
                answer = false;
            }
        }
        return answer;
    }

    void drawOneSquare(int i, int k)
    {
        if(!this.squareExists(i, k)){
            this.setSquare("Square", i, k, Session.get().getIndexFromArrayImagesNamesByName("Square.png"));
        }
    }
    void drawSquarePattern(int scale){
        for(int i = 0; i <= scale; i ++){
            for(int k = 0; k <= scale; k ++){
                drawOneSquare(i, k);
            }
        }
    }
}
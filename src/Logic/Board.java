package Logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Board implements Collection<VisibleObject> {
    public String name;
    public int boardWidth;
    public int boardLength;
    public int boardScale;
    public ArrayList<InfoPanel> BoardInfoPanels;
    public ArrayList<VisibleObject> VO;
    public ArrayList<VisibleObject> EVO;
    public ArrayList<VisibleObject> MVO;
    public ArrayList<MovableObject> MO;
    public ArrayList<ColliderObject> CO;
    public ArrayList<Collider> colliders;
    public int obqu;
    public int centerX;
    public int centerY;
    public ArrayList<Hex> neighbours;
    public int greenCircleIndex;
    public int saveButtonIndex;
    public int loadButtonIndex;



    Board (String BoardName, int boardWidth, int boardLength, int boardScale)
    {
        this.name = BoardName;
        this.BoardInfoPanels = new ArrayList<>();
        this.VO = new ArrayList<>();
        this.EVO = new ArrayList<>();
        this.MVO = new ArrayList<>();
        this.MO = new ArrayList<>();
        this.CO = new ArrayList<>();
        this.colliders = new ArrayList<>();
        this.boardWidth = boardWidth;
        this.boardLength = boardLength;
        this.boardScale = boardScale;
        this.centerX = (this.boardWidth / 2);
        this.centerY = (this.boardLength / 2);

    }

    public void setHex(String name, int netX, int netY, int z, int spriteNumber) {
        this.VO.add(new Hex(name, netX, netY, z, spriteNumber));
        this.obqu++;
        Game.obInGameQu++;
    }
    public void setInfoPanel(String name, int netX, int netY, int spriteNumber) {
        this.VO.add(new InfoPanel(name, netX, netY, spriteNumber, this.VO.size()));
        this.obqu++;
        Game.obInGameQu++;
    }
    public void setSquare(String name, int netX, int netY, int spriteNumber) {
        Square square = new Square(name, netX, netY, spriteNumber, this.VO.size());
        this.VO.add(square);
        this.EVO.add(square);
        this.obqu++;
        Game.obInGameQu++;
    }
    public void setPlayer(String name, int lives, int netX, int netY, int spriteNumber) {
        Player newPlayer = new Player(name, lives, netX, netY, spriteNumber, this.VO.size(), this.MVO.size(), this.CO.size());
        this.VO.add(newPlayer);
        this.MVO.add(newPlayer);
        this.MO.add(newPlayer);
        this.CO.add(newPlayer);
        this.colliders.add(newPlayer.collider);
        Game.players[0] = newPlayer;
        this.obqu++;
        Game.obInGameQu++;
    }
    public void setNPC(String name, int lives, int netX, int netY, int spriteNumber) {
        NPC newNPC = new NPC(name, lives, netX, netY, spriteNumber, this.VO.size(), this.MVO.size(), this.CO.size());
        this.VO.add(newNPC);
        this.MVO.add(newNPC);
        this.MO.add(newNPC);
        this.CO.add(newNPC);
        //this.colliders.add(newNPC.collider);
        this.obqu++;
        Game.obInGameQu++;
    }

    public VisibleObject getSquare(int index)
    {
        return this.VO.get(index);
    }
    public ArrayList<VisibleObject> getSquaresByRTWY(int netY)
    {
        ArrayList<VisibleObject> squares = new ArrayList<>();
        for(int i = 0; i < this.VO.size(); i ++){
            if(this.VO.get(i).getY() == netY){
                squares.add(this.VO.get(i));
            }
        }
        return squares;
    }


    public boolean hexExists(int i, int k, int l)
    {
        boolean answer = false;
        for(int f = 0; f < this.VO.size(); f ++){
            if(this.VO.get(f).getX() == i && this.VO.get(f).getY() == k && this.VO.get(f).getHex3axis() == l){
                answer = true;
                break;
            }else{
                answer = false;
            }
        }
        return answer;
    }
    public boolean squareExists(int i, int k)
    {
        boolean answer = false;
        for(int f = 0; f < this.VO.size(); f ++){
            if(this.VO.get(f).getX() == i && this.VO.get(f).getY() == k){
                answer = true;
                break;
            }else{
                answer = false;
            }
        }
        return answer;
    }
    public ArrayList<VisibleObject> findHexNeighboursByCoords(VisibleObject hex)
    {// очевидно, возвращает коллекцию всех соседей данного гекса
        ArrayList<VisibleObject> neighbours = new ArrayList<>();
        for(int i = 0; i < this.VO.size(); i ++){
            if(
                    Math.abs(hex.getX() - this.VO.get(i).getX()) +
                    Math.abs(hex.getY() - this.VO.get(i).getY()) +
                    Math.abs(hex.getHex3axis() - this.VO.get(i).getHex3axis()) == 2
            ){
                    neighbours.add(this.VO.get(i));
            }
        }
        return neighbours;
    }
    public boolean checkHexesAround(ArrayList<VisibleObject> neighbours, int keyNumber)
    {
        boolean answer = false;
        for(int i = 0; i < neighbours.size(); i ++){
            if(neighbours.get(i).getSpriteNumber() == keyNumber){
                answer = true;
                break;
            }
        }
        return answer;
    }
    public boolean checkHexesInNeighboursIfIsCurrent(ArrayList<VisibleObject> neighbours)
    {//проверяет гексы по соседству с данным гексом на свойство IsCurrent
        boolean answer = false;
        for(int i = 0; i < neighbours.size(); i ++){
            if(neighbours.get(i).getIsCurrent()){
                answer = true;
                break;
            }
        }
        return answer;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<VisibleObject> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(VisibleObject Hex) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends VisibleObject> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    /*public ArrayList<VisibleObject> objects;
    public class Body implements VisibleObject
    {
        public int hand;
        public String st;
        public Body(int hand)
        {
            this.hand = hand;
            this.st = "body";
        }
        public int getHand()
        {
            return hand;
        }
        public String getSt()
        {
            return st;
        }

        public int getEnergy() {
            return 0;
        }
        public void setHand(int hand)
        {
            this.hand = hand;
        }
    }
    public void setBody(int hand)
    {
        this.objects.add(new Body(hand));
    }
    public class Soul implements VisibleObject
    {
        public int hand;
        public int energy;
        public String st;
        public Soul(int hand, int energy)
        {
            this.hand = hand;
            this.energy = energy;
            this.st = "soul";
        }
        public int getHand()
        {
            return hand;
        }
        public String getSt()
        {
            return st;
        }

        public int getEnergy()
        {
            return energy;
        }
        public void setHand(int hand)
        {
            this.hand = hand;
        }
    }

    public void setSoul(int hand, int energy)
    {
        this.objects.add(new Soul(hand, energy));
    }*/

}
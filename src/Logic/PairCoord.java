package Logic;

public class PairCoord extends Coord {
    public int y;
    public static PairCoord pc1 = new PairCoord(300,440);
    public static PairCoord pc2 = new PairCoord(210,150);
    public PairCoord(int x, int y){
        super(x);
        this.y = y;
    }


    @Override
    public int hashCode(){
        return (y << 15) | x;
    }

    @Override
    public String toString(){
        return x + " " + y;
    }
}

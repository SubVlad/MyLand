package Logic;

public class TrioCoord extends PairCoord {
    public int z;
    public TrioCoord(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    @Override
    public int hashCode(){
        return (z << 20) | (y << 10) | x;
    }

    @Override
    public String toString(){
        return x + " " + y + " " + z;
    }
}

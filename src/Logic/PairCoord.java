package Logic;

public class PairCoord {
    public int x;
    public int y;
    public static PairCoord pc1 = new PairCoord(300,440);
    public static PairCoord pc2 = new PairCoord(210,150);
    public PairCoord(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj){
        if(this.getClass() == obj.getClass()){
            return this.hashCode() == obj.hashCode();
        }else{
            return false;
        }
    }
    @Override
    public int hashCode(){
        return (x << 15) | y;
    }

    @Override
    public String toString(){
        return x + " " + y;
    }
}

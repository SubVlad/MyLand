package Logic;

public class Coord {
    public int x;

    public Coord(int x) {
        this.x = x;
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
        return x;
    }

    @Override
    public String toString(){
        return String.valueOf(x);
    }
}

package Logic;

public class Square extends PlayableObject  {
    public Square(String name, int netX, int netY, int spriteNumber, int index)
    {
        super(name,netX,netY,spriteNumber,0);
        this.form = Form.Square;
    }

}

package Logic;

public enum Sprite
{
    Player1,//0
    Player2,//1
    GreenCircle,//2
    Save,//3
    Load,//4
    Square,//5
    Grass,//6
    Sand,//7
    Water,//8
    Elf,//9
    GreenElf;//10

    public Object image;
    int getNumber()
    {
        return this.ordinal();
    }
}

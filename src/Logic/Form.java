package Logic;

public enum Form
{
    Square,//0
    Hex,//1
    Player,//2
    NPC,//3
    InfoPanel;//4

    int getNumber()
    {
        return this.ordinal();
    }
}

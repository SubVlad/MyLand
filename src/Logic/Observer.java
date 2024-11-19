package Logic;

public abstract class Observer {
    public PairCoord centerPC;
    public PairCoord sizePC;
    protected int x = 0;
    protected int y = 0;
    protected boolean[][] dots;

    public Observer(int centerX, int centerY, int sizeX, int sizeY) {
        this.centerPC = new PairCoord(centerX, centerY);
        this.sizePC = new PairCoord(sizeX, sizeY);
    }

    public void moveObserver(int centerX, int centerY) {
        this.centerPC.x = centerX;
        this.centerPC.y = centerY;
    }
}

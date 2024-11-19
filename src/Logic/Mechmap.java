package Logic;

public class Mechmap {
    public volatile boolean[][] dots;
    public Mechmap(int xLength, int yLength){
        this.dots = new boolean[xLength][yLength];
    }
    public void erraseMech(){
        for(int i = 0; i < dots.length; i++){
            for(int j = 0; j < dots[0].length; j++){
                dots[i][j] = false;
            }
        }

        for(int i = 0; i < dots.length; i++){
            dots[i][0] = true;
            dots[i][dots[0].length-1] = true;
        }
        for(int i = 0; i < dots[0].length; i++){
            dots[0][i] = true;
            dots[dots.length-1][i] = true;
        }
    }
}

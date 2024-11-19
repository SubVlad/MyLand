package Logic.Events;

import Logic.Events.EventSystem;
import Logic.Observer;
import Logic.PairCoord;

public class EventObserver extends Observer {

    public EventObserver(int centerX, int centerY, int sizeX, int sizeY){
        super(centerX, centerY, sizeX, sizeY);
        this.dots = EventSystem.get().eventmap.dots;
    }
    public PairCoord searchPC(double direction){
        boolean answer = false;
        if(direction == 0){
            for(int i = this.centerPC.y-1; !answer && i < centerPC.y + sizePC.y+1; i ++){
                answer = dots[centerPC.x-1][i]; // left direction
                x = centerPC.x - 1;
                y = i;
            }
        }
        if(direction == 1){
            for(int i = this.centerPC.y-1; !answer && i < centerPC.y + sizePC.y+1; i ++){
                answer = dots[centerPC.x + sizePC.x - 1][i]; // right direction
                x = centerPC.x + sizePC.x - 1;
                y = i;
            }
        }
        if(direction == 2){
            for(int i = this.centerPC.x-1; !answer && i < centerPC.x + sizePC.x+1; i ++){
                answer = dots[i][centerPC.y-1]; // up direction
                x = i;
                y = centerPC.y-1;
            }
        }
        if(direction == 3){
            for(int i = this.centerPC.x-1; !answer && i < centerPC.x + sizePC.x+1; i ++){
                answer = dots[i][centerPC.y + sizePC.y]; // down direction
                x = i;
                y = centerPC.y + sizePC.y;
            }
        }
        if(answer){
            return new PairCoord(x,y);
        }else{
            return null;
        }
    }
}

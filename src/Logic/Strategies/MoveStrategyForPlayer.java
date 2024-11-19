package Logic.Strategies;

import Logic.*;
import Logic.Colliders.ColliderObserver;
import Logic.Events.EventObserver;
import Logic.Events.EventSystem;

public class MoveStrategyForPlayer implements MoveStrategyInterface{
    @Override
    public synchronized void move(MovableObject object) {
            boolean[][] mechDots = Session.get().curBoard.mech.dots;
            byte leftButton = object.getButtons()[0];
            byte rightButton = object.getButtons()[1];
            byte upButton = object.getButtons()[2];
            byte downButton = object.getButtons()[3];
            EventObserver eventObserver = object.getEventObserver();
            ColliderObserver colliderObserver = object.getColliderObserver();
            PairCoord pc;
            PairCoord pcBigger = new PairCoord(rightButton,downButton);
            PairCoord pcSmaller = new PairCoord(leftButton,upButton);
            Velocity velocity = object.getVelocity();
            double x = ((double)(rightButton - leftButton + 1)) / 2;
            double y = ((double)(downButton - upButton + 5)) / 2;

        if(!colliderObserver.lookOneDirection(x)) {
            pc = eventObserver.searchPC(x);
            if(pc != null){
                EventSystem.get().getEvent(pc).runEvent((GameObject) object);
            }
            object.setRTBX(object.getVelocity().getPathX());
            object.updateCollider();
        }
        if(!colliderObserver.lookOneDirection(y)) {
            pc = eventObserver.searchPC(y);
            if(pc != null){
                EventSystem.get().getEvent(pc).runEvent((GameObject) object);
            }
            object.setRTBY(object.getVelocity().getPathY());
            object.updateCollider();
        }
        velocity.updateVectors(pcBigger,pcSmaller);
    }
}
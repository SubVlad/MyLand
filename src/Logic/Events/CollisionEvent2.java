package Logic.Events;

import Logic.Character;
import Logic.Events.Event;
import Logic.GameObject;
import Logic.PairCoord;
import Logic.Session;

public class CollisionEvent2 implements Event {
//Collision event - is an event which appears at collision with something.
//it must have some action at collision

    public  void runEvent(GameObject obj){
        /*Character ch = (Character) obj;
        ch.getVelocity().setPathsByPC(new PairCoord(0,0));*/

        Session.get().curBoard.setNPC(
                "WhoAreYou", 100, 3, 9, Session.get().getIndexFromArrayImagesNamesByName("WhoAreYou.png"));
        Session.get().changeBoard(Session.get().currentBoardIndex);


    }
}

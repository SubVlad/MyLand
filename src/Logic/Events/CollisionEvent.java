package Logic.Events;

import Logic.*;
import Logic.Character;
import Logic.Events.Event;

public class CollisionEvent implements Event {
//Collision event - is an event which appears at collision with something.
//it must have some action at collision

    public  void runEvent(GameObject obj){
        Runnable rn = new Runnable() {
            @Override
            public void run() {
                try{
                    Session.get().IPCurrentBoard.get(0).setImage(Session.get().images[Session.get().getIndexFromArrayImagesNamesByName("Hello.png")]);
                    Thread.sleep(3000);
                    Session.get().IPCurrentBoard.get(0).setImage(Session.get().images[Session.get().getIndexFromArrayImagesNamesByName("WhoAreYou.png")]);
                    Thread.sleep(3000);
                    Session.get().IPCurrentBoard.get(0).setImage(Session.get().images[Session.get().getIndexFromArrayImagesNamesByName("Void.png")]);
                }catch (Exception e){}

            }
        };
        Thread thr = new Thread(rn);
        thr.start();

        //Session.get().curBoard.setNPC(
          //      "WhoAreYou", 100, 3, 10, Session.get().getIndexFromArrayImagesNamesByName("WhoAreYou.png"));
        //Session.get().changeBoard(Session.get().currentBoardIndex);


    }
}

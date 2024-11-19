package Logic.Events;

import Logic.Events.Event;
import Logic.GameObject;

import java.util.ArrayList;

public class CompositeEvent implements Event {
    ArrayList<Event> events = new ArrayList<>();
    @Override
    public void runEvent(GameObject obj) {
        for(int i = 0; i < events.size(); i ++){
            events.get(i).runEvent(obj);
        }
    }
}

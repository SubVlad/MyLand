package Logic.Events;

import Logic.Events.Event;
import Logic.GameObject;

public class OrderedEvent implements Event {

    Event nextEvent;

    @Override
    public void runEvent(GameObject obj) {
        if(nextEvent != null){
            nextEvent.runEvent(obj);
        }
    }
    public Event getNextEvent() {
        return nextEvent;
    }

    public void setNextEvent(Event nextEvent) {
        this.nextEvent = nextEvent;
    }
}

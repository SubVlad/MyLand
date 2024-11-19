package Logic.Events;

import Logic.PairCoord;
import Logic.Session;

import java.util.HashMap;
import java.util.Set;

public class EventSystem {
    private static volatile EventSystem instance;
    public Eventmap eventmap;
    public HashMap<PairCoord, Event> events = new HashMap<PairCoord,Event>();

    public static EventSystem get(){
        EventSystem localInstance = instance;
        if(localInstance == null){
            synchronized (Session.class){
                localInstance = instance;
                if(localInstance == null){
                    instance = localInstance = new EventSystem();
                    instance.instanciateEventSystem();
                }
            }
        }
        return instance;
    }
    private EventSystem(){}
    private void instanciateEventSystem() {
        int xSize = Session.get().curBoard.mech.dots.length;
        int ySize = Session.get().curBoard.mech.dots[0].length;
        eventmap = new Eventmap(xSize,ySize);
    }
    public Event getEvent(PairCoord pc){
        return events.get(pc);
    }
    public Set<PairCoord> getKeys(){
        return events.keySet();
    }
}

/**
 * Created by pawel on 24.01.15.
 */
public class Event implements Comparable<Event> {

    public double timeOccur;
    //public double timeEndOfService;
    public Type eventType;
    private int sourceId;

    public Event(double time, Type type,int sourceId){
        timeOccur = time;
        eventType = type;
        this.sourceId=sourceId;
    }

    @Override
    public int compareTo(Event event) {
        return timeOccur < event.timeOccur ? -1 : (timeOccur==event.timeOccur ? 0 : 1);
    }

    public String toLine(){
        return "Occured: "+timeOccur+" type: "+eventType+" sourceId: "+sourceId;
    }
}

import java.util.Comparator;

/**
 * Created by pawel on 04.02.15.
 */
public class EventComparator implements Comparator<Event> {
    @Override
    public int compare(Event event, Event t1) {
        return event.compareTo(t1);
    }
}

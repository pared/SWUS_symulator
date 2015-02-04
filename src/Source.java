import java.util.ArrayList;
import java.util.List;

public class Source {
    private double startTime;
    private double currentTime;
    private int id;
    public Source(int id){
        startTime = Params.getStartTime();
        currentTime = startTime;
        this.id=id;
    }
    public Source(double startTime,int id){
        this.startTime = startTime;
        this.currentTime = startTime;
        this.id=id;
    }

    public double getStartTime(){
        return startTime;
    }

    public Event getNextEvent(){
        Event ret = new Event(currentTime,Type.PACKAGE_ARRIVE,id);
        currentTime+=Params.getCycleTime();
        return ret;
    }
    public List<Event> getEvents(){
        List<Event> list = new ArrayList<Event>();
        for (int i = 0;i<Params.cyclesNumber; i++){

            for(int j = 0;j<Params.packagesInCycle;j++) {
                list.add(new Event(currentTime, Type.PACKAGE_ARRIVE,this.id));
                currentTime += Params.getPackageTime();
                Params.packagesSent++;
            }
            currentTime = startTime + Params.getCycleTime()*(i+1);
        }
        return list;
    }
    public int getId() {
        return id;
    }


}

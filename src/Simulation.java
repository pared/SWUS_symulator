
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Simulation {
    private static EventComparator comparator = new EventComparator();
    private static int timer;
    private static List<Event> eventList= new ArrayList<Event>();
    private static List<Source> sourceList = new ArrayList<Source>();
    private static Server server= new Server();


    public static void main(String[] args)throws Exception{
        Params.parseSimulationParameters("/res/file.in");
        System.out.println("Simulating... please wait");
        initialize();
        simulate();
        //writeSources();
        //writeEvents();
        writePSent();
        System.out.println("Done.");
    }

    private static void writePSent() {
        System.out.println(Params.packagesSent);
    }


    public static void simulate(){
        //while(timer < Params.endOfSimulation){

            handleEvent(eventList.get(0));
            eventList.remove(0);
       // }
    }

    private static void generateEventsForSources(){
        for (Source src : sourceList){
            eventList.addAll(src.getEvents());
        }
        Collections.sort(eventList,comparator);
    }

    private static void initialize(){
        timer = 0;
        initializeSources();
    }

    private static void initializeSources(){
        for(int i=0;i<Params.numberOfFlows;i++){
            Source s = i==0 ? new Source(0,i) : new Source(i);
            sourceList.add(s);
        }
        generateEventsForSources();
    }


    private static void writeSources(){
        System.out.println(sourceList.size());
        for (Source src : sourceList){
            System.out.println(src.getStartTime() + " id: "+src.getId());
        }
    }
    private static void writeEvents(){
        for(Event event : eventList){
            System.out.println(event.toLine());
        }
    }

    private static void writeStats(){

    }

    private static void handleEvent(Event event){
        switch(event.eventType){
            case PACKAGE_ARRIVE:
                if(server.isBusy()){

                }else {

                }
                break;
            case END_OF_SERVICE:
                server.setIdle();

                if(Server.QUEUE_SIZE>0){

                } else{

                }
                break;
        }
    }

}

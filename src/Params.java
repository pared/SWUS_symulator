import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.Random;


public class Params {

    public static double endOfSimulation;
    public static int numberOfFlows;
    public static int C;
    public static int queueSize;
    public static int peakRate;
    public static int t_on;
    public static int t_off;
    public static int numberOfSimulations;
    public static int packagesInCycle;
    public static int cyclesNumber;

    private static double packageTime;
    public static int packagesLost;
    public static int packagesSent;

    public static void parseSimulationParameters(String s) throws Exception {

        InputStream stream=inputStreamFrom(s);
        Scanner scanner = new Scanner(stream);
        while(scanner.hasNext()){
            String line=scanner.nextLine();
            setParameter(line);
        }
        packageTime = t_on/packagesInCycle;
        cyclesNumber =(int)Math.floor(endOfSimulation/(t_on+t_off));
        resetParams();

    }

    private static void setParameter(String line){
        if (line.contains("EOS")){
            endOfSimulation = Double.parseDouble(line.split(" ")[1]);
        } else if (line.contains("NOF")){
            numberOfFlows = Integer.parseInt(line.split(" ")[1]);
        } else if(line.contains("C")){
            C = Integer.parseInt(line.split(" ")[1]);
        } else if(line.contains("QS")){
            queueSize = Integer.parseInt(line.split(" ")[1]);
        } else if (line.contains("PR")){
            peakRate = Integer.parseInt(line.split(" ")[1]);
        } else if (line.contains("time ON")){
            t_on = Integer.parseInt(line.split(" ")[2]);
        } else if (line.contains("time OFF")){
            t_off = Integer.parseInt(line.split(" ")[2]);
        } else if (line.contains("NOS")){
            numberOfSimulations = Integer.parseInt(line.split(" ")[1]);
        } else if (line.contains("packages in cycle")){
            packagesInCycle = Integer.parseInt(line.split(" ")[3]);
        }

    }

    private static FileInputStream inputStreamFrom(String s)throws Exception{
        URL resource = Params.class.getResource(s);
        File file = new File(resource.getFile());
        FileInputStream inputStream = new FileInputStream(file);
        return inputStream;
    }

    public static void writeParams(){
        System.out.println("End of Simulation: "+endOfSimulation+" [ms]");
        System.out.println("Number of Flows: "+numberOfFlows);
        System.out.println("C: "+C+" [b/s]");
        System.out.println("Queue size: "+queueSize);
        System.out.println("Peak rate: "+peakRate+" [b/s]");
        System.out.println("Time on: "+t_on+" [ms]");
        System.out.println("Time off: "+t_off+" [ms]");
        System.out.println("Number of simulations: "+numberOfSimulations);
        System.out.println("Packages in cycle: "+packagesInCycle);
    }

    public static double getStartTime(){
        Random r = new Random();
        return r.nextDouble()*(t_off+t_on);
    }


    public static int getCycleTime() {
        return t_on+t_off;
    }
    public static double getPackageTime(){
        return packageTime;
    }
    public static void resetParams(){
        packagesLost=0;
        packagesSent=0;
    }
}

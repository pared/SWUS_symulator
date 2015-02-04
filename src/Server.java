import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawel on 04.02.15.
 */
public class Server {

    private static boolean BUSY;
    public static int QUEUE_SIZE;



    Server(){
        BUSY = false;
        QUEUE_SIZE = 0;
    }

    public boolean isBusy(){
        return BUSY;
    }
    public void setBusy(){
        BUSY=true;
    }
    public void setIdle(){
        BUSY=false;
    }
    public void resetServer(){
        QUEUE_SIZE=0;
    }

}

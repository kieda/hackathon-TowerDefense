package mechanics;

import java.util.Timer;
import java.util.TimerTask;
import ui.Frame;

/**
 * @author Shaan
 */
public class Core {
    private Core(){}
    
    public static final int SLEEP = 10;
            
    private static Runnable main_loop = new Runnable() {
        @Override public void run() {
            st_time = millis = System.currentTimeMillis();
            while(true){
                update();
                
                try {
                    Thread.currentThread().sleep(SLEEP);
                } catch (InterruptedException e) {}
            }
        }
    };
    
    /**
     * initializes and runs the main loop.
     */
    public static void init(){
        Frame.init();
        new Thread(main_loop).start();
    }
    
    private static void update() {
        Frame.update();
        dt = -millis + (millis = System.currentTimeMillis()); 
    }

    /**
     * start time
     */
    private static long st_time;
    /**
     * current time
     */
    private static long millis;
    
    /**
     * time since last update
     */
    private static long dt = SLEEP;//placeholder to prevent errors
    
    /**
     * returns the current time, from the start time.
     */
    public static long getTime(){
        return millis-st_time;
    }
    
    /**
     * returns the time that has elapsed since the last frame
     */
    public static long getDT(){
        return dt;
    }
    
    private static Timer taskHandler = new Timer();
    
    public static void post(TimerTask tt, long delay){
        taskHandler.schedule(tt, delay);
    }
}

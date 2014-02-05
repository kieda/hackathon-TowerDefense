package game.mechanics;

/**
 * This class provides information about the amount of time that has passed in
 * an interval, and how much time has passed overall. This allows the back-end
 * to be a bit more abstracted from events driven specifically by time. 
 * 
 * @author zkieda
 */
public interface Clock {
    /**
     * gets the current time from when the clock was first created
     * @return 
     */
    public long getTime();
    
    /**
     * gets the delta time with respect to something. Could be since the last 
     * time DT was called, or could be since the last time the screen refreshed.
     * 
     * See : {@link UpdateableClock}
     * @return 
     */
    public long getDT();
}

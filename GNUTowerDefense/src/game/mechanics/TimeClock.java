package game.mechanics;

/**
 * A clock that is based around the current time, in milliseconds.
 * @author zkieda
 */
public class TimeClock implements UpdateableClock {
    private Clock peer = null;//peer implementation

    private long curr = -1;//current time
    private long start = -1;//start time
    
    //difference in time
    private long dt;
    
    /**
     * @param initial_dt the initial dt we should report, in case if the dt from
     * the first call is too small
     * 
     * The value returned by getDT() is initial_dt before the first call of 
     * update().
     */
    public TimeClock(long initial_dt){
        assert initial_dt >=0;
        curr = (start = System.currentTimeMillis()) + initial_dt;
        dt = initial_dt;
    }
    
    
    /**
     * We return a clock peer that does not reveal the update method
     * @return 
     */
    @Override
    public Clock getClockPeer(){
        //we create the peer if it does not exist yet
        if(peer == null)
            peer = new Clock() {
                @Override public long getTime() {
                    //return this time
                    return curr - start;
                }
                @Override public long getDT() {
                    //return this dt
                    return dt;
                }
            };
        
        return peer;
    }
    
    @Override public void update() {
        //last = curr
        //curr = time()
        //dt = last - curr
        dt = (-curr + (curr=System.currentTimeMillis()));
    }
}

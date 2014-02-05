package game.mechanics;

/**
 * A clock that can be updated. 
 * 
 * @author zkieda
 */
public interface UpdateableClock{
    
    /**
     * updates this clock to the most recent time. Should be called once per 
     * cycle of something (like a screen refresh)
     */
    public void update();
    
    /**
     * returns a peer of the clock that does not expose the 'update' method. 
     * This is used when the implementation needs to update the clock, but the
     * client should not. 
     */
    public Clock getClockPeer();
}

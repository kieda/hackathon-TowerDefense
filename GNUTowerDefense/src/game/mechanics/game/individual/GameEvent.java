
package game.mechanics.game.individual;

/**
 * @author zkieda
 */
public interface GameEvent {
    //initial run
    void run();
    void update();
    
    boolean ready();
    
    //should hold some information about waves...
    
    //boolean ready() // true iff we are ready to run and update this event
    
    //int waitTime // the time we should wait after the execution of the 
                   // previous event. After the wait time is over, we periodically
                   // check ready() to see if we can run this event. 
    
    //void run(Board information) 
    
    //ONCE a game event has been called, it cannot be called again. 
    
    
    //no run - we have 
    //      addEnemy(x, y, enemytyp) event
    //      waitForWaveCompletion() event
    //      long wait() event
    //      
    
}

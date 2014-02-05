package game.mechanics.game.individual;

import game.mechanics.Clock;
import game.mechanics.game.player.Player;
import util.NonNullStorage;

/**
 * @author zkieda
 */

//individual game : a game which has some waves and ends. Takes a player. 
//defines a map.
/**
 * Holds information on the game that is actually running
 * @author zkieda
 */
public class Game {
    private final Clock clock;
    private final NonNullStorage<GameEvent> game_events;
    public Game(Clock clock, NonNullStorage<GameEvent> game_events){
        assert clock != null && game_events != null;
        this.game_events = game_events;
        this.clock = clock;
    }
        //game clock
    
    //make a board with this board layout
    public Board getBoard(){return null;}
    public Player getPlayer(){return null;}
    
    public void update(){
        //updates Game logic, and the enemies on this board. 
    }
}
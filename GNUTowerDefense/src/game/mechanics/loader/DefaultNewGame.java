package game.mechanics.loader;

import game.mechanics.game.Difficulty;
import game.mechanics.game.gamesequence.GameSequence;
import game.mechanics.game.individual.GameEvent;
import java.io.InputStream;
import util.NonNullStorage;

/**
 * Loads the entry point using the default method for reading the entry point. 
 * Entry point is a file that specifies the stream location for the games. Does
 * not specify difficulty.
 * 
 * @author zkieda
 */
public class DefaultNewGame implements GameSequence{
//creates a new game based on the default filepath for a game
    
    //the difficulty we should have the game be, and the input stream source we
    //should read 
    public DefaultNewGame(Difficulty d, InputStream is){}

    @Override
    public NonNullStorage<GameEvent> next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

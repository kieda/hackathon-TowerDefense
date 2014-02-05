package game.mechanics.loader;

import game.mechanics.game.gamesequence.GameSequence;
import game.mechanics.game.individual.GameEvent;
import util.NonNullStorage;

/**
 * Loads a game using the default method for reading games. The file we load 
 * specifies the current player information, and the location of the next game
 * to load.
 * 
 * @author zkieda
 */
public class LoadGame implements GameSequence{

    @Override
    public NonNullStorage<GameEvent> next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//loads a game according to a file path. Extends GameSequence.
}

package game.mechanics.game.gamesequence;

import game.mechanics.game.individual.GameEvent;
import util.NonNullStorage;

/**
 * @author zkieda
 */
public interface GameSequence {
    /**
     * @return the structure for the next game
     */
    NonNullStorage<GameEvent> next();
}

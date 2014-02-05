package game.mechanics.game;

/**
 * Represents a difficulty handler. Currently we represent difficulty only by 
 * an integer code. 
 * @author zkieda
 */
public interface Difficulty {
    // 0 - easy
    // 1 - med
    // 2 - hard
    int getDifficulty();
}

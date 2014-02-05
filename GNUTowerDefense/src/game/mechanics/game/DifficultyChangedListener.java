package game.mechanics.game;

import java.util.EventListener;

/**
 * A listener
 * @author zkieda
 */
public interface DifficultyChangedListener extends EventListener {
    /**
     * Called when the difficulty of the game has been changed. Should do 
     * the necessary 'things' to ensure that the difficulty of the game can be
     * changed without errors in the game. 
     * 
     * We ensure that the old difficulty is not equal to the new difficulty 
     * (such that we ensure that this gets called only when the difficulty is
     * actually changed)
     * 
     * We are currently not passing the old difficulty and the new difficulty in
     * the listener, since we do need them, and putting them in would be an 
     * inconvenience with the {@link DifficultyAdapter}
     */
    public void onDifficultyChanged();
}

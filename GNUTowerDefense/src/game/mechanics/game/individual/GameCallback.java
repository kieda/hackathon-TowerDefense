package game.mechanics.game.individual;

/**
 *
 * @author zkieda
 */
public interface GameCallback {
    public void onGameFinish(GameEndState e);
    public void onGameStart();
    public void onGamePause();
}

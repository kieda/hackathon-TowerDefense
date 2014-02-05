package game.mechanics.game.item;

/**
 * Represents something that can be placed on the board at board positions 
 * (x, y)
 * 
 * Ex : placing a tower on the board
 * 
 * @author zkieda
 */
public interface BoardPlaceable {
    public Error place(int x, int y);
}

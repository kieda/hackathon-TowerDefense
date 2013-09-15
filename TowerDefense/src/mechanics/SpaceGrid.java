package mechanics;

/**
 * @author Shaan
 */
public interface SpaceGrid {
    /**
     * returns true iff this position on the grid is occupied by a tower.
     * 
     * @param x the x position on the grid
     * @param y the y position on the grid
     * @return see above.
     */
    boolean isOccupied(int x, int y);
    
    int getWidth();
    
    int getHeight();
}

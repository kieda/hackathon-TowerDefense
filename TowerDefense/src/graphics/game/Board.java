package graphics.game;

/**
 * the board
 * @author Shaan
 */
public class Board {
    private Cell[] cells;
    
    /**
     * 
     * @param xnum number of x cells
     * @param ynum number of y cells
     */
    public Board(int xnum, int ynum){
        assert xnum>0 && ynum >0;
        cells = new Cell[xnum*ynum];
        
        
    }
}

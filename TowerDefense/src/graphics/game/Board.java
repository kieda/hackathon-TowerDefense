package graphics.game;

import graphics.Renderable;
import java.awt.Graphics2D;
import util.Algos;

/**
 * the board
 * @author Shaan
 */
public class Board implements Renderable{
    private Cell[] cells;
    
    private int width;
    
    /**
     * 
     * @param xnum number of x cells
     * @param ynum number of y cells
     */
    public Board(int xnum, int ynum){
        assert xnum>0 && ynum >0;
        cells = new Cell[xnum*ynum];
        
        width = xnum;
        
    }

    @Override public void render(Graphics2D g) {
        for(Cell c : cells)
            c.render(g);
    }
    
    public Cell indexOf(int x, int y){
        return cells[Algos.indexOf(x, y, width)];
    }
}

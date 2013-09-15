package graphics.game;

import graphics.Renderable;
import java.awt.Graphics2D;
import java.awt.Point;
import util.Algos;
import util.ScreenInfo;

/**
 * the board
 * @author Shaan
 */
public class Board implements Renderable{
    private Cell[] cells;
    
    private int width;
    
    private int cell_w;
    private int cell_h;
    /**
     * 
     * @param xnum number of x cells
     * @param ynum number of y cells
     */
    public Board(int xnum, int ynum){
        assert xnum>0 && ynum >0;
        cells = new Cell[xnum*ynum];
        
        width = xnum;
        cell_w = ScreenInfo.FRAME_WIDTH/xnum;
        cell_h = ScreenInfo.FRAME_HEIGHT/ynum;
    }

    @Override public void render(Graphics2D g) {
        for(int i = 0; i < cells.length; i++){
            Cell c = cells[i];
            if(c==null) continue;
            Point p = Algos.posOf(i, width);
            
            final int xclip = p.x*cell_w, yclip = p.y*cell_h;
            g.clipRect(xclip, yclip, cell_w, cell_h);
            g.translate(xclip, yclip);
            c.render(g);
            g.setClip(null);
            g.translate(-xclip, -yclip);
        }
    }
    
    public Cell indexOf(int x, int y){
        return cells[Algos.indexOf(x, y, width)];
    }
    public void set(Cell c, int x, int y){
//        System.out.println(Algos.indexOf(x, y, width));
        cells[Algos.indexOf(x, y, width)]=c;
    }
}


package util;

import java.awt.Point;


public class Algos {
    private Algos(){}
    
    /**
     * we return the index of an (x, y) point on a grid of width "w"
     */
    public static int indexOf(int x, int y, int w){
        assert w>x;
        
        return y*w + x;
    }
    
    /**
     * return the (x, y) position of an array at index "idx" and with an array 
     * width of "w"
     * 
     * @param idx
     * @param w
     * @return 
     */
    public static Point posOf(int idx, int w){
        return new Point(idx%w, idx/w);
    }
}

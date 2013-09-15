/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics;

/**
 *
 * @author Shaan
 */
public class Square {

    private int x;
    private int y;
    private boolean occupied;

    public Square(int xco, int yco) {
        this.x = xco;
        this.y = yco;
    }
    
    public Square(int xco, int yco, boolean occupied){
        this.x = xco;
        this.y = yco;
        this.occupied = occupied;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void setOccupied(boolean occupied){
        this.occupied=occupied;
    }
    
    public boolean getOccupied(){
        return this.occupied;
    }
    
}

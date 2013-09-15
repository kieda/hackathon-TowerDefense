/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.tower;

import mechanics.Square;
import mechanics.enemy.Enemy;

/**
 * @author Shaan
 */

public class Tower extends Square{
    private final float range;
    private final float dmg;
    
    /**
     * interval between shots
     */
    private final int period;
    
    public float angle;
    
    private String towerName;
    
    public String getName()
    {
        return towerName;
    }
    /**
     * note : period is an integer in milliseconds. (This is because the system 
     * clock is in discreet units)
     */
    public Tower(String towerName, float range, int period, float dmg, int x, int y)
    {
        super(x,y);
        this.towerName = towerName;
        this.range = range;
        this.period = period;
        this.dmg = dmg;
    }
    public boolean inRange(Enemy e){
        //todo implement
        return false;
    }
    
    public float getRange()
    {
        return range;
    }
    public float getDmg()
    {
        return dmg;
    }
    public int getPeriod()
    {
        return period;
    }
    
    public boolean inRange(float x, float y)
    {
        float ydiff = y-getY();
        float xdiff = x-getX();
        return Math.sqrt(ydiff*ydiff + xdiff*xdiff) <= range;
    }
    
}

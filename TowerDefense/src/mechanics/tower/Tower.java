/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.tower;

import mechanics.enemy.Enemy;

/**
 * @author Shaan
 */

public class Tower {
    private final float range;
    private final float dmg;
    private final float period;
    
    public float angle;
    public float x;
    public float y;
    
    private String towerName;
    
    public String getName()
    {
        return towerName;
    }
    public Tower(String towerName, float range, float period, float dmg)
    {
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
    public float getPeriod()
    {
        return period;
    }
    
    public boolean inRange(float x, float y)
    {
        float ydiff = y-this.y;
        float xdiff = x-this.x;
        return Math.sqrt(ydiff*ydiff + xdiff*xdiff) <= range;
    }
}

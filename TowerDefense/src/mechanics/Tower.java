/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics;

import mechanics.enemy.Enemy;

/**
 * @author Shaan
 */

public class Tower {
    private float range;
    private float dmg;
    private float period;
    
    public float angle;
    public float x;
    public float y;
    
    
    
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

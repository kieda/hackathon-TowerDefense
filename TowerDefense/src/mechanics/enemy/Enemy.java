/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.enemy;

import mechanics.BoardPoint;
import mechanics.Tower;
import mechanics.gameplay.DmgValues;

/**
 *
 * @author Shaan
 */
public abstract class Enemy implements BoardPoint{
    private float hp;
    private float speed;
    public float x;
    public float y;
    
    public Enemy(float h, float s){
        hp = h;
        speed = s;
        x=0;
        y=0;
    }
    
    public boolean isAlive(){
        return hp == 0;
    }
    
    public abstract String getName();
    
    public void takeDamage(Tower tower){
        hp -= tower.getDmg()*DmgValues.getDamageModifier(Tower.getName(), getName()); 
    }
    
    public float getHP(){
       return hp;
    }
    
    public float getSpeed(){
        return speed;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }
    
    
    
}

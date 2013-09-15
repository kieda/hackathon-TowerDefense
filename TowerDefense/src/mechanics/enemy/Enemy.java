/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.enemy;

import java.awt.Point;
import mechanics.BoardPoint;
import mechanics.Tower;
import mechanics.gameplay.DmgValues;

/**
 *
 * @author Shaan
 */
public class Enemy implements BoardPoint{
    private float hp;
    private float speed;
    public float x;
    public float y;
    
    public Enemy(float h, float s, float dm){
        hp = h;
        speed = s;
        x=0;
        y=0;
    }
    
    public boolean isAlive(){
        return hp == 0;
    }
    
    public void takeDamage(Tower tower){
        hp -= tower.damage*DmgValues.getDamageModifier(Tower.towerName,"1"); 
    }
    
    public float getHP(){
       return hp;
    }
    
    public float getSpeed(){
        return speed;
    }

    @Override
    public Point getPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

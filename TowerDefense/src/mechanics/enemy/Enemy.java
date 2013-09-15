/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.enemy;

import mechanics.BoardPoint;
import mechanics.tower.Tower;
import mechanics.gameplay.DmgValues;

/**
 *
 * @author Shaan
 */
public class Enemy implements BoardPoint {

    private float hp;
    private float speed;
    public float x;
    public float y;
    private String enemyName;
    private float hitRadius;

    public Enemy(float h, float s, String name, float hr) {
        hp = h;
        speed = s;
        x = 0;
        y = 0;
        enemyName = name;
        hitRadius = hr;
    }

    public boolean isAlive() {
        return hp == 0;
    }

    public void takeDamage(Tower tower) {
        hp -= tower.getDmg() * DmgValues.getDamageModifier(tower.getName(), enemyName);
    }

    public float getHP() {
        return hp;
    }

    public float getSpeed() {
        return speed;
    }
    
    public float getHitRadius(){
        return hitRadius;
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

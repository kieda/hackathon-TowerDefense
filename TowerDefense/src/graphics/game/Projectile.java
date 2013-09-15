package graphics.game;

import graphics.Renderable;
import mechanics.BoardPoint;
import mechanics.enemy.Enemy;


public abstract class Projectile implements BoardPoint, Renderable{
    private Enemy target;//projectile needs a target
    
    public abstract void update();
}

package game.mechanics;

import java.awt.geom.Point2D;

/**
 * @author zkieda
 */
public final class Util {
    private Util(){}
    
    /**
     * Suppose we have some body at position {@param cur} units traveling with 
     * velocity {@param velocity} units/time. This gives the next position of 
     * the body after {@param dt} time units passes, assuming no change in 
     * velocity.
     * 
     * For multiple dimensions, just split the position and velocity of a body
     * into basis vectors. 
     */
    public static float nextPos(float cur, float velocity, long dt){
        return cur + velocity*dt;
    } 
}

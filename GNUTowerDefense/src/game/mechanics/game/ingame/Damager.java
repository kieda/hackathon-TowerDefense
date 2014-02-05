package game.mechanics.game.ingame;

/**
 * todo : important : make an "Environment" class. The environment class makes
 * Damagers, and each time a new Damager is made it is registered as a new type
 * to the environment. Same thing with purchasables and item types - each time 
 * a new item type is made it is registered to the environment.
 * @author zkieda
 */
public abstract class Damager {
    public final DamageDealerType type;
    public Damager(DamageDealerType type){this.type = type;}
    
    /**
     * How much damage would this DamageDealer do to this enemy type? A tower 
     * might be super-effective against certain enemies. We prevent modification
     * of the damage to become overpowered by using {@link ItemSettings}. Then,
     * when we make each implementation of DamageDealer, we ensure the values 
     * this methods return will not vary, and cannot be changed externally.
     * 
     * @param e the type of the enemy
     * @return the base damage that should be dealt to an enemy of type 
     * {@code e}
     */
    public abstract int calculateDamage(EnemyType e);
    
    /**
     * Is this position on the board in range? 
     * 
     * It is the responsibility of implementing classes to make this method 
     * final, in order to prevent modifying a tower to make it reach everywhere.
     * 
     * @param x the x position on the board
     * @param y the y position on the board
     * @return true iff this damageDealer can attack something at position (x,y)
     */
    public abstract boolean inRange(float x, float y);
}

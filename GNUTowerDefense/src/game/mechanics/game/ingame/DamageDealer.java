package game.mechanics.game.ingame;

import game.mechanics.game.player.Player.RewardCallback;
import settings.mechanics.ItemSettings;

/**
 * todo : have projectiles as the damage dealer, and once the projectile reaches
 *        the final destination the enemy takes damage. 
 * 
 * @author zkieda
 */
public final class DamageDealer {
    public static DamageDealer make(RewardCallback rwc, Damager d){
        if(rwc == null) throw new NullPointerException();
        return new DamageDealer(rwc, d);
    }
    private DamageDealer(RewardCallback rwc, Damager d){
        this.rwc = rwc;
        this.damager = d;
        this.type = d.type;
    }
    
    private final Damager damager;
    private final RewardCallback rwc;
    
    public final DamageDealerType type;//the type of the damage dealer
    
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
    public final int calculateDamage(EnemyType e){
        return damager.calculateDamage(e);
    }
    
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
    public final boolean inRange(float x, float y){
        return damager.inRange(x, y);
    }
    
    /**
     * When we attack an enemy, we only have to check for correctness here. 
     * This is because an enemy can only take damage with a non-null 
     * DamageCallback, and DamageCallbacks can only exist in a DamageDealer. 
     * 
     * Since the {@code Enemy.takeDamageFrom(...)} method is final, we can 
     * assume that we will award only when the enemy dies, and only award a 
     * valid amount of award.
     * 
     * So, we just assert that the enemy is a correct target. If we kill the 
     * enemy, we award ourselves 
     * 
     * @param e the enemy to attack
     * @return an Error if there was an error attacking this enemy, or if this
     * damage dealer is physically unable to attack this Enemy. Otherwise, 
     * returns null.
     */
    public final Error attack(Enemy e){
        //check that e is a valid target here.
        if(!inRange(e.getX(), e.getY())) return new Error(); //todo error target is not in range
        if(e.isDead()) return new Error();  //todo error dead targets cannot be attacked!

        Error err = rwc.verifyAttack(this, e);
        
        if(err!=null) return err;
        
        e.takeDamageFrom(this, rwc);
        return null;
    }
}

//15210
//15462 graphics
//15411 compilers
//chem 1
//15359 probability


//15312
//10601??
//15410
//computer graphics 2

//art
//15451
//art
//computer music systems

//art
//AI??
//hardcore ML??
//hci??
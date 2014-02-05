package game.mechanics.game.ingame;

import game.mechanics.game.player.Money;
import game.mechanics.game.player.Player;
import settings.mechanics.DamageSettings;

/**
 * @author zkieda
 */
public abstract class Enemy {
    private final Money valuation = null;
    public final Money getValuation(){
        //valuation modifiers here.
        return valuation;
    }
    
    /**
     * The type of the enemy. 
     */
    public final EnemyType type = null;

    /**
     * the base HP for the enemy
     */
    private final int BASE_HP = 0;
    
    /**
     * the hit points for the enemy
     */
    private int hitPoints = 0;
    
    /**
     * the damage dealer that killed this 
     */
    private DamageDealer killer = null;
    
    /**
     * the x, y position of the enemy
     */
    private float x, y;
    
    /**
     * returns the current x position of the enemy on the board
     * @return
     */
    public final float getX(){return x;}
    
    /**
     * returns the current y position of the enemy on the board
     * @return 
     */
    public final float getY(){return y;}
    
    //register enemies - since each enemy has a price for when you kill it.
    //register rewards - what rewards are valid???
    
    /**
     * has this enemy take an appropriate amount of damage from the given damage 
     * dealer. If this enemy dies, we call {@code tc.award(...)} to reward the
     * player for killing the enemy. 
     * 
     * We assume that the DamageDealer has the right access to attack this 
     * enemy, and that the DamageCallback belongs to the given DamageDealer. 
     * 
     * We do not allow any external access to {@code tc} by making this method 
     * final.
     * 
     * @param t the DamageDealer that is attacking this enemy
     * @param tc the callback if this enemy dies by being attacked by the 
     * DamageDealer
     * @return an error if there is an error when taking damage from the damage
     * dealer. Error is guaranteed if {@code tc} is null. 
     */
    public final Error takeDamageFrom(DamageDealer t, Player.RewardCallback tc){
        if(tc == null) return new Error();//todo error callback cannot be null!
        //this ensures that this method is called only called from DamageDealer.
        
        //we know this can only be called from DamageDealer.attack, and we know
        //this method always checks if this enemy is dead before attacking. 
        //Thus, we do not have to check if this enemy is dead here.
        
        int damage = t.calculateDamage(type);

        if(damage < 0) return new Error();//todo error : damage dealers must 
                                          //deal positive damage. 

        
        float resistance = calculateResistance(t.type);
        
        //just some basic settings. We might want to set this to some sort of
        //'local environment settings'. However, this feature is currently a
        //bit uninportant. 
        if(DamageSettings.PREVENT_NEGATIVE_RESISTANCE && resistance < 0.0f)
            return new Error();//todo error resistance cannot be negative
        if(DamageSettings.PREVENT_LARGER_RESISTANCE && resistance > 1.0f)
            return new Error();//todo error resistance cannot be greater than 1.0
        
        //the damage that this character should take. This is the resistance 
        //this enemy has to the tower, multiplied by the damage the tower 
        //typically deals to an enemy of this type. 
        damage = (int)(damage * resistance);
        
        //this is our hp with the attack applied
        damage = hitPoints-damage;
        
        //if damage <= 0, the enemy should die.
        if(damage <= 0){
            killer = t;//t killed this enemy
            hitPoints = 0;//we have 0 hit points left
        } else
            //otherwise, we set the hitpoints
            hitPoints = damage;
        
        //send callback if we killed this enemy
        if(isDead()){
            // we check t can hit this in DamageDealer.attack
            Error e = tc.reward(getValuation());
            if(e!=null) return e;
        }
        
        //the operation completed successfully
        return null;
    }
    
    /**
     * @return true iff this enemy is dead
     */
    public final boolean isDead(){
        //if we don't have a killer, we assume this is dead. Namely, we notice 
        //that we assign a non-null value to the killer once this enemy dies.
        
        return killer != null;
    }
    
    /**
     * Calculates the resistance that this enemy has to a certain damage dealer 
     * type.
     * 
     * @param t
     * @return 
     */
    protected abstract float calculateResistance(DamageDealerType t);
}

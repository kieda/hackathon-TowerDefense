package settings.mechanics;

import game.mechanics.game.ingame.EnemyType;
import game.mechanics.game.player.Purchasable;
import util.NonNullStorage;

/**
 * 
 * @author zkieda
 */
public final class ItemSettings {
    private ItemSettings(){}
    /**
     * Handles a list of purchaseables. Purchaseables are registered on 
     * instantiation. From then, purchaseables can only be accessed. No new 
     * purchaseables are accepted, or can be changed. 
     */
    public static final NonNullStorage<Purchasable> PURCHASABLES = new NonNullStorage<>
        (//list of items we can purchase here
            
        );
    
    public static final NonNullStorage<EnemyType> ENEMIES = new NonNullStorage<>
        (//list of valid enemy implementations
    
        );
    
    //list of purchasables
    public static final int PURCHASE_LAINE = 0;
}

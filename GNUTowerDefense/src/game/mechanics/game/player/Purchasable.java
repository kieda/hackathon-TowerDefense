package game.mechanics.game.player;

import game.mechanics.game.item.Item;
import game.mechanics.game.item.ItemType;

/**
 * All complete implementations of Purchasable should finalize the makeItem()
 * method, and ensure that only that type of item will be made. 
 * 
 * @author zkieda
 */
public abstract class Purchasable {
    /**
     * The price of buying one item.
     */
    public final Money price;
    
    /**
     * The type of items this Purchasable makes.
     */
    public final ItemType itemType;

    /**
     * Specifies the price of this purchasable, and the type of items that this
     * class should be making.
     * 
     * @param price if null, this purchasable is free!
     * @param itemType if null, a NullPointerException is thrown
     */
    public Purchasable(Money price, ItemType itemType) {
        if(itemType == null) throw new NullPointerException("itemType must not be null!");
        this.price = price;
        this.itemType = itemType;
    }
    
    /**
     * Constructs the item and gives it to a user via a PurchaseCallback
     * @param pc
     * @return an instance of Error if there was an error creating the object, 
     * or 
     */
    public final Error build(Player.ItemReceiver pc){
        Item i;
        if((i = makeItem())==null){
            //we no longer assert that the Item matches the Purchasable. Instead
            //we are going to make a PurchasableManager, where only 'select' 
            //purchasables are created to be used in GNU tower defense. GNUGame
            //takes the default PurchasableManager.
            throw new RuntimeException("Instance of the item returned by makeItem() could not be verified.");
        }
        
        //Type of item received was not correct
        if(i.getItemType() != itemType) return new Error();
        
        //give the item to the user
        pc.receiveItem(i);
        return null;
    }
    
    /**
     * Cannot return null. The result's item type should match this itemType. 
     */
    protected abstract Item makeItem();
}

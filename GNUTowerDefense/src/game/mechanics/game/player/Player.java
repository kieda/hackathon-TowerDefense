package game.mechanics.game.player;

import game.mechanics.game.individual.Board;
import game.mechanics.game.ingame.DamageDealer;
import game.mechanics.game.ingame.Enemy;
import game.mechanics.game.item.ActionItem;
import game.mechanics.game.item.Item;
import game.mechanics.game.item.ItemType;
import game.mechanics.game.item.Sellable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * todo : update wallet when item is added or removed.
 * 
 * cash prize item : on use - after some amount of time give the player an item
 * that can be sold at a high value. After giving it to the player, sell it at
 * a high value. 
 * 
 * @author zkieda
 */
public class Player {
    
    /**
     * the id that we are using for the next item. We increment from here each
     * time a person buys an item. This means, however, that we're limited to
     * a maximum of 2^64 items that can be purchased during the game. I'm 
     * guessing we don't need to expect gameplay to buy this many Items.
     */
    private long next_id = Long.MIN_VALUE;

    
    /**
     * Our list of items that belong to this player
     */
    private List<Item> itemList = new ArrayList<>();
    
    /**
     * The list of ids of each item. The id if the i^th id in this idList
     * corresponds to the i^th Item in the itemList.
     */
    private List<Long> idList = new ArrayList<>();
    
    /**
     * the callback for purchases. This ensures that items cannot be added by 
     * any class except for the player.
     */
    private final ItemReceiver pc = new ItemReceiver() {
        @Override public void receiveItem(Item i) {
            //give the item to the player
            assert i != null;
            add(i);
        }
    };
    
    private final RewardCallback rwc = new RewardCallback() {
        @Override public Error reward(Money m) {
            return rewardMoney(m);
        }
        @Override
        public Error verifyAttack(DamageDealer d, Enemy e) {
            //todo e, player, this on same board
            
//            currentBoard.containsEnemy(e)
//            currentBoard.containsDamageDealer(d)
            
            //note : we do NOT have to check that the player owns the DamageDealer that 
            //       killed the enemy, since whenever we create a DamageDealer, it can 
            //       only be made within a player.             
            return null;
        }
    };
    
    //todo : how does the current board relate to the player?
    //how can we buy items and add them to the board?
    private Board currentBoard;
    
    
    private Error rewardMoney(Money m){
        //modify this method for possible special bonuses - double the money on
        //kill, for example.
        if((transact(m, false))==null)
            return new Error();
        return null;
    }
    
    /**
     * modifies this item, such that the use method will always remove the item
     * from the player. 
     * 
     * @param i the item
     * @param id the item's id
     * @return 
     */
    private Item modify(final Item i, final long id){
        return new Item(){
            boolean used = false;
            private final ActionItem action = new ActionItem() {
                @Override
                public Error use(Object args) {
                    if(used) return new Error();//item has already been used
                    
                    //use the item
                    Error e = i.getActionItem().use(args);
                    
                    //if we could use the item, we ensure the item cannot be 
                    //used again, and we remove it from the player

                    if(e==null){
                        used = true;
                        remove(id);//remove this item
                    }
                    
                    return e; 
                }
            };
            @Override
            public ActionItem getActionItem() {
                //returns null if this action has been used
                return used?null:action;
            }
            @Override
            public ItemType getItemType() {
                return used?null:i.getItemType();
            }
        };
    }
    
    //adds an item to the player
    private void add(Item i){
        
        //only in rare cases
        if(next_id==Long.MAX_VALUE)
            throw new Error("We have generated way too many items!");
        
        //modify i to consume item on use
        i = modify(i, next_id);
        
        //otherwise, current_id is the id of the current item.
        itemList.add(i);
        idList.add(next_id);
        
        next_id++;//increment current id
        
        //todo : modify wallet
    }
    
    //removes the item from the player
    private Error remove(long id){
        //get where the id is located in the itemList
        int idx = Collections.binarySearch(idList, id);
        
        if(idx==-1){
            //handle error : id not found
            return new Error();
        }
        //remove item from wallet
        
        Item i = itemList.remove(idx);
        idList.remove(idx);
        
        //todo : remove from wallet
        
        return null;
    }
    
    public final Object buy(Purchasable t){
         assert t != null;
         //if t.price==null, it's free!
         
         //remove funds from ourselves
         if(transact(t.price, true)==null){
             return new Error();//insuffucient funds.
         }
         
         //we add the item to ourselves
         Error e = t.build(pc);
         //should automatically add the item to our player.
         
         if(e!=null) return e;//an error while building the item
         
         return null;
    }
    
    /**
     * transacts the given amount of money from or to the player's account. 
     * 
     * @param m the amount of money
     * @param withdraw {@code true} if we remove {@code m} from our player's 
     * wallet, or {@code false} if we add {@code m} to our player's wallet.
     * 
     * @return the new wallet value, or null if there was an error withdrawing
     * or depositing funds
     */
    private Money transact(Money m, boolean withdraw){
        //result
        Money result = withdraw?wallet.subtract(m):wallet.add(m);
        //error in removing or depositing funds
        if(result==null) return null;

        //set wallet
        return wallet = result;
    }
    
        //if we can purchase it, then we do and add it to the player.
        //otherwise, we return an insufficientfunds error, or an error that
        //they cannot buy the item at this time.
        //if we were successful in getting the item we bought, we return an 
        //int id code for the item.
        
        //if we buy it, we generate an Item and give it to the player. 
        //Otherwise
    
    public final Error sell(long id){
        int idx = Collections.binarySearch(idList, id);
        
        //id not found
        if(idx == -1) return new Error();
        
        Item i = itemList.get(idx);
        assert i!=null;//itemList and ids should have the same number of elements
        
        
        if(i instanceof Sellable){
            //remove the item from the list of our items
            itemList.remove(idx);
            idList.remove(idx);
            
            //add sale price to wallet
            wallet = wallet.add(((Sellable)i).getSalePrice());
            
            return null;
        } else //I can't sell something that's not sellable!
            return new Error();
    }
    
    public final Object get(long id){
        int idx = Collections.binarySearch(idList, id);
        if(idx == -1) return new Error();
        Item i = itemList.get(idx);
        
        //itemList and ids should have the same number of elements
        assert i!=null;
        
        return i.getActionItem();
    }
        //takes the int id code. If successful, we return an ItemAction
        //otherwise, we return an Error
    
    /**
     * Transfer money from this user to the other user's account
     * @param other
     * @param m
     * @return 
     */
    public final Error transfer(Player other, Money m){
        Money myNew = wallet.subtract(m);
        if(myNew==null){
            //todo : error not enough funds
            return new Error();
        }
        Money otherNew = other.wallet.add(m);
        if(otherNew == null){
            //todo : error other player cannot take the money
            return new Error();
        }
        
        //with no errors, we set the new values
        wallet = myNew;
        other.wallet = otherNew;
        
        //return null : no error.
        return null;
    }
    
    public final Money getFunds(){return wallet;}

    /**
     * The player's money
     */
    private Money wallet;
    
    /**
     * a callback for receiving items. Currently only administered though the
     * purchaseable class. 
     */
    public abstract class ItemReceiver {
        
        /**
         * it is only possible to make a PurchaseCallback from within a player.
         * Only the player can administer the right to receive an item.
         */
        private ItemReceiver(){}
        
        /**
         * A callback to receive an item. 
         * @param i 
         */
        public abstract void receiveItem(Item i);
    }
    
    /**
     * A callback that is used when a tower or other damage dealer attacks an enemy.
     * Allows the Enemy to validate that they are being hit, and allows the player 
     * to be rewarded for killing an enemy.
     * 
     * @author zkieda
     */
    public abstract class RewardCallback {
        //only able to make a DamageCallback from within a DamageDealer
        private RewardCallback(){}
        
       /**
        * A callback for giving a user a reward when the Enemy {@code e} has been 
        * killed by DamageDealer {@code t}. The following specifications should be 
        * met when attempting to administer an award -- 
        *      
        *      -- {@code t} and {@code e} are all on the same board.
        *      -- {@code e} is dead, and was killed by {@code t}
        * 
        * Since we check these properties before attacking, we assume that these
        * properties will also hold in the callback. 
        * 
        * Under no circumstances should this method be exposed.
        * 
        * @param m the money that should be awarded for killing an enemy.
        * @return the result Error if one occurred, or {@code null} if no error 
        * occurred.
        */
       public abstract Error reward(Money m);
       
       /**
        * Verifies that this attack is valid, i.e. that d has the right to 
        * attack e, and this player has the right to control and use d.
        * 
        * @param d the damagedealer that's attacking e
        * @param e the enemy that's being attacked by d
        * @return an error if this attach is not valid, and null otherwise.
        */
       public abstract Error verifyAttack(DamageDealer d, Enemy e);
    }
}

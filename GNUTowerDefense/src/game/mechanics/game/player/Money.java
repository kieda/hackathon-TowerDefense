package game.mechanics.game.player;

import game.mechanics.game.item.ItemType;
import util.NonNullStorage;

/**
 * represents monetary value. Money is currently specified by the items a player
 * has, and the 
 * @author zkieda
 */
public final class Money {
    public Money(int liscences, NonNullStorage<ItemType> items, NonNullStorage<Integer> ids) {
        this.DOLLAS = liscences;
        this.ITEMS = items;
        this.IDS = ids;
    }
    //we want to be able to use items, and we want the player to have a 'bank'.
    public final int DOLLAS;
        //by 'DOLLAS' we actually mean 'Free Licenses'. We might have int 
        //values for 
        //  BSD License
        //  GNU License
        //  MIT License
        //  Apache License
        //that would be good fun. But for now, we just make fs people roll in 
        //the dough/license
    
    //represents a set of items that must be used
    public final NonNullStorage<ItemType> ITEMS;
    
    //represents the item IDs that should be removed from the player
    public final NonNullStorage<Integer> IDS;
    
    public final Money subtract(Money m){
        
        return m;
    }
    //todo : error? too much money???
    public final Money add(Money m){return m;}
}

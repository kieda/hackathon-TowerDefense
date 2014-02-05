package game.mechanics.game.item;

/**
 * Is an interface for an Item. The item should be 'used' when a method of 
 * ActionItem is called
 * 
 * @author zkieda
 */
public interface ActionItem {
    //consumes the item if error != null
    Error use(Object args);
}
//    public Error place(int x, int y){return null;}
//public Error sell();

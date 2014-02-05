package game.mechanics.game.gnu;

import game.mechanics.Clock;
import game.mechanics.game.gamesequence.CloseError;
import game.mechanics.game.gamesequence.GameSequence;
import game.mechanics.game.gamesequence.OpenError;
import game.mechanics.game.gamesequence.GameSequenceCloser;
import game.mechanics.game.player.Player;
import game.mechanics.game.player.Purchasable;
import settings.mechanics.ItemSettings;
import util.NonNullStorage;

/**
 *
 * @author zkieda
 */
public class GNUGame {
//GNUGame : generates a player (if necessary), or takes a player. Has a stream 
//of individual games.
    
    //a clock used in an individual game. Tracks from the beginning of the game
    private Clock gameClock;
    
    //the items we can buy in game
    private final NonNullStorage<Purchasable> purchasables = ItemSettings.PURCHASABLES; 
    
    //the start time of the current game being played. We really only need one
    private long start;
    
    //a clock used for this GNUgame. The start time should be from the beginning
    //of this gnu game. 
    private final Clock clock;
    
    private Player player;
    
    public GNUGame(Clock c, GameSequence gamesequence){
        this.clock = c;

    }

    public void startCurrentGame(){
        start = clock.getTime();
        gameClock = new Clock() {
            @Override
            public long getTime() {
                return clock.getTime() - start;
            }

            @Override
            public long getDT() {
                return clock.getDT();
            }
        };
    }
    public byte nextGame(){return 0;}
                             //0 if success. 1 if current game not completed.
                             //2 if no more games left.
                             //if 0 is returned, GNUGame is prepared to the next
                             //game. 

    public Player getPlayer(){return player;}

    public OpenError openSequence(GameSequence gsc){
        return null;
    }
    
    /**
     * Closes the current sequence with the SequenceCloser implementation
     * @param cls the SequenceCloser used to close the current game stream
     * @return null if the sequence was successfully closed, and a CloseError
     * otherwise
     */
    public CloseError closeSequence(GameSequenceCloser cls){
        return null;
    }

    public void exit(){}

    public void setCallback(GNUGameCallback callback){}
    public GNUGameCallback getCallback(){return null;}
    
    public GNUGamePeer getGamePeer(){return null;}
    
    //Updates the game. Updates the current game 
    public void update(){}
//for security.
}

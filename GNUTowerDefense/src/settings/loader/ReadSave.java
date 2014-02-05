package settings.loader;

import game.mechanics.game.gamesequence.GameSequence;
import game.mechanics.game.individual.GameEvent;
import java.io.InputStream;
import util.NonNullStorage;

/**
 * This class is supposed to read a save file and convert it into a GameSequence
 * @author zkieda
 */
public class ReadSave implements GameSequence{
    public ReadSave(InputStream s){
    }

    @Override
    public NonNullStorage<GameEvent> next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

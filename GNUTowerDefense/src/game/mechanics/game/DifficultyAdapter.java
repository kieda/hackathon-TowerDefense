package game.mechanics.game;

/**
 * manages difficulty without exposing internal set difficulty. Allows one to
 * modify the difficulty of the game while it is running, without revealing the
 * method to change the difficulty to the game itself. 
 * 
 * @author zkieda
 */
public class DifficultyAdapter {
    private int difficulty;
    private Difficulty adapter;
    private DifficultyChangedListener listener;
    
    public DifficultyAdapter(DifficultyChangedListener dcl){this(null, dcl);}
    public DifficultyAdapter(Difficulty base, DifficultyChangedListener dcl){
        listener = dcl;
        difficulty = base==null?0:base.getDifficulty();
        
        //simple adapter
        adapter = new Difficulty() {
            @Override public int getDifficulty() {
                return difficulty;
            }
        };
    }
    public void setDifficulty(int difficulty){
        if(this.difficulty != difficulty){
            //fire event changed.
            this.difficulty = difficulty;
            if(listener != null) listener.onDifficultyChanged();
        }
        
        //otherwise do nothing.
    }
    public Difficulty getDifficulty(){
        //we return the adapter that can dynamically change by this adapter.
        return adapter;
    }
}

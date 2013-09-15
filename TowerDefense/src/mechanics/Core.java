package mechanics;

import ui.Frame;

/**
 * @author Shaan
 */
public class Core {
    private Core(){}
    
    private Runnable main_loop;
    
    /**
     * initializes and runs the main loop.
     */
    public static void init(){
        Frame.init();
        
    }
}

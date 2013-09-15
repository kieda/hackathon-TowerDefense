package mechanics;

import graphics.Painter;
import graphics.Renderable;
import graphics.Sprite;
import java.awt.Color;
import java.awt.Graphics2D;
import ui.Frame;

/**
 * @author Shaan
 */
public class Core {
    private Core(){}
    
    public static final int SLEEP = 10;
            
    private static Runnable main_loop = new Runnable() {
        @Override public void run() {
            while(true){
                update();
                
                try {
                    Thread.currentThread().sleep(SLEEP);
                } catch (InterruptedException e) {}
            }
        }
    };
    
    /**
     * initializes and runs the main loop.
     */
    public static void init(){
        Frame.init();
        new Thread(main_loop).start();
    }
    
    private static void update() {
        Frame.update();
    }

}

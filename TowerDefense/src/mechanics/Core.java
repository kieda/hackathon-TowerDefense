package mechanics;

import graphics.Painter;
import graphics.Renderable;
import java.awt.Color;
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
        Painter.addRenderable(new Renderable() {
            @Override
            public void render() {
                Painter.setColor(Color.BLACK);
                Painter.gDrawLine(0, 0, 500, 500);
            }
        });
    }
    
    private static void update() {
        Frame.update();
    }

}

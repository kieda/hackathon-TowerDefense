package drivers;

import graphics.Painter;
import graphics.Sprite;
import java.awt.Graphics2D;
import java.util.TimerTask;
import mechanics.Core;

/**
 * @author Shaan
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Core.init();
        
        Painter.add(new Sprite("./sprite-test.png"){
            @Override
            public void render(Graphics2D g) {
                super.render(g); 
                rotate(.1f  );
                move(2, 2);
            }
        });
    }
}

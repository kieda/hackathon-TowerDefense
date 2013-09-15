
package util;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;


public class ScreenInfo {
    private ScreenInfo(){}
    
    public static final int GAME_WIDTH = 1600;
    public static final int GAME_HEIGHT = 900;
    public static final float GAME_RATIO = ((float)GAME_WIDTH)/GAME_HEIGHT;
    
    public static final int SCREEN_HEIGHT;
    public static final int SCREEN_WIDTH;
    
    static{
        final Dimension d= Toolkit.getDefaultToolkit().getScreenSize();
        SCREEN_HEIGHT =d.height;
        SCREEN_WIDTH = d.width;
    }
    
    public static final int FRAME_WIDTH;
    public static final int FRAME_HEIGHT;
    
    public static final AffineTransform screenTransform;
    
    static{//ensures screen is cropped correctly
        final float r1 = (float)GAME_WIDTH/GAME_HEIGHT;
        final float r2 = (float)SCREEN_WIDTH/SCREEN_HEIGHT;
        screenTransform = new AffineTransform();
        if(GAME_WIDTH<=SCREEN_WIDTH&&GAME_HEIGHT<=SCREEN_HEIGHT) {
            FRAME_WIDTH=GAME_WIDTH;FRAME_HEIGHT=GAME_HEIGHT;
        } 
        else {if(r1>r2){
            //we know that the game width is greater than the game height
            //we crop the game width
            FRAME_WIDTH = SCREEN_WIDTH;
            //no overflow plz
            FRAME_HEIGHT = (FRAME_WIDTH*GAME_HEIGHT)/GAME_WIDTH;//frame width /frame 
            
        } else{
            //we know that the ratio of game height is greater than the frame height
            FRAME_HEIGHT = SCREEN_HEIGHT;
            //no overflow plz
            FRAME_WIDTH = (FRAME_HEIGHT*GAME_WIDTH)/GAME_HEIGHT;//suppose we have a 4:3 rat,
        }
            //this is how much we should scale the game down, since the screen
            //is not large enough to fit the entire game.
//            screenTransform.scale((double)FRAME_WIDTH/GAME_WIDTH, (double)FRAME_HEIGHT/GAME_HEIGHT);
//            screenTransform.setToScale((double)GAME_WIDTH/FRAME_WIDTH, (double)GAME_HEIGHT/FRAME_HEIGHT);
            screenTransform.setToScale((double)FRAME_WIDTH/GAME_WIDTH, (double)FRAME_HEIGHT/GAME_HEIGHT);
        }
        
    }
    
    public static final Rectangle GAME_BOUNDS;
    
    static{
        GAME_BOUNDS = new Rectangle(center(FRAME_WIDTH, SCREEN_WIDTH), center(FRAME_HEIGHT, SCREEN_HEIGHT), FRAME_WIDTH, FRAME_HEIGHT);
    }
    
    /**
     * returns the int position from the left, if we were to fit width onto 
     * bigwidth
     * 
     * @return 
     */
    public static int center(int width, int bigwidth){
        return (bigwidth-width)>>1;
    }
   
}

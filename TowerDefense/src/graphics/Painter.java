package graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * @author Shaan
 */
public class Painter {
    private static BufferedImage bi;
    private static Graphics2D g2d;
    
    public static void addRenderable(Renderable r){
    }
    
    public static void gDrawImage(Image bi, int x, int y){
        g2d.drawImage(bi, x, y, null);
    }
}

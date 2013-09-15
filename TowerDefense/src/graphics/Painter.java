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
    public static void init(){
        bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g2d = bi.createGraphics();
    }
    public static void gDrawImage(Image bi, int x, int y){
        g2d.drawImage(bi, x, y, null);
    }
    public static void gDrawLine(int x1, int y1, int x2, int y2){
        g2d.drawLine(x1, y1, x2, y2);
    }
    
}

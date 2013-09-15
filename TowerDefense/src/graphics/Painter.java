package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import util.ScreenInfo;

/**
 * @author Shaan
 */
public class Painter {
    private static BufferedImage bi;
    private static Graphics2D g2d;
    private static List<Renderable> renderables = new ArrayList<>(16);
    private static int w, h;
    public static void addRenderable(Renderable r){
        renderables.add(r);
    }
    
    public static void removeRenderable(Renderable r){
        renderables.remove(r);
    }
    
    public static void init(){
        bi = new BufferedImage(ScreenInfo.GAME_WIDTH, ScreenInfo.GAME_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        g2d = bi.createGraphics();
        
    }
    
//    public static void gDrawImage(Image bi, int x, int y){
//        g2d.drawImage(bi, x, y, null);
//    }
//    
//    public static void gDrawLine(int x1, int y1, int x2, int y2){
//        g2d.drawLine(x1, y1, x2, y2);
//    }
    
    /**
     * cleans the graphics
     */
    public static void clean(){
        g2d.fillRect(0, 0, w, h);
    }
    
//    public static void setColor(Color c){
//        g2d.setColor(c);
//    }
    
    public static void paint(Graphics2D g){
//        g2d = bi.createGraphics();
        for(Renderable r : renderables) {
            r.render(g2d);
        }
        g.drawImage(bi,null,0,0);
    }
}

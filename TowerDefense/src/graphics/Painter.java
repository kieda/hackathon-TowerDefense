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
    public static void add(Renderable r){
        renderables.add(r);
    }
    
    public static void removeRenderable(Renderable r){
        renderables.remove(r);
    }
    
    public static void init(){
        bi = new BufferedImage(ScreenInfo.GAME_WIDTH, ScreenInfo.GAME_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        g2d = bi.createGraphics();
    }
    
    /**
     * cleans the graphics
     */
    public static void clean(){
        //fix this shit after hackathon is done
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, ScreenInfo.GAME_WIDTH, ScreenInfo.GAME_HEIGHT);
    }
    
    public static void paint(Graphics2D g){
        clean();
        for(Renderable r : renderables) {
            r.render(g2d);
        }
        g.setClip(null);
        
        g2d.setColor(Color.red);
        g2d.drawLine(0, 0, ScreenInfo.GAME_WIDTH, ScreenInfo.GAME_HEIGHT);
        g.drawImage(bi,0,0,ScreenInfo.FRAME_WIDTH, ScreenInfo.FRAME_HEIGHT, null);
    }
}

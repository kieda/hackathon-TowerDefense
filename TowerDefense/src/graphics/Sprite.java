
package graphics;

import error.TotalError;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import mechanics.BoardPoint;


public class Sprite implements Renderable, BoardPoint{
    private static BufferedImage bi;
    
    private float x, y;
    
    private int width, height;
    
    public Sprite(String pathLoc){
        try{
            bi = ImageIO.read(new File(pathLoc));
        } catch(IOException e){
            e.printStackTrace();
            new TotalError("Sprite file "+pathLoc+" could not be located.");
        }
    }
    @Override public void render(Graphics2D g) {
        g.drawImage(bi, null, (int)(x-(width>>1)), (int)(y-(height>>1)));
    }

    @Override public float getX() {
        return x;
    }

    @Override public float getY() {
        return y;
    }
}
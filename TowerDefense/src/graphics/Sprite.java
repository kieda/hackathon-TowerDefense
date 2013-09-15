
package graphics;

import error.TotalError;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class Sprite implements Renderable{
    private static BufferedImage bi;
    public Sprite(String pathLoc){
        try{
            bi = ImageIO.read(new File(pathLoc));
        } catch(IOException e){
            e.printStackTrace();
            new TotalError("Sprite file "+pathLoc+" could not be located.");
        }
    }
    @Override public void render() {
        
    }
}


package graphics;

import error.TotalError;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import mechanics.BoardPoint;


public class Sprite implements Renderable, BoardPoint{
    private static BufferedImage bi;
    
    private float x, y, theta;
    
    private int width, height;
    private int imgW, imgH;
    
    private AffineTransform af;
    
    public Sprite(String pathLoc){
        try{
            bi = ImageIO.read(new File(pathLoc));
        } catch(IOException e){
            e.printStackTrace();
            new TotalError("Sprite file "+pathLoc+" could not be located.");
        }
        af = new AffineTransform();
        
        imgW = bi.getWidth();
        imgH = bi.getHeight();
    }
    @Override public void render(Graphics2D g) {
        af.setToIdentity();
        
//        af.setToScale((double)width/imgW, (double)height/imgH);
        af.rotate(theta, x, y);
        af.translate(x-(imgW>>1), y-(imgH>>1));
        g.drawImage(bi, af, null);
    }

    @Override public float getX() {
        return x;
    }

    @Override public float getY() {
        return y;
    }
    
    public void setX(float f){
        this.x = f;
    }
    public void setY(float f){
        this.y = f;
    }
    
    public void move(float x, float y){
        this.x += x;
        this.y += y;
    }
    
    public void rotate(float theta){
        this.theta += theta;
    }
}
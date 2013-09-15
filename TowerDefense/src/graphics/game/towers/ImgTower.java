
package graphics.game.towers;

import graphics.Sprite;
import graphics.game.TowerCell;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import mechanics.tower.Tower;

/**
 * temporary
 * @author zkieda
 */
public class ImgTower extends TowerCell{
    private BufferedImage img;
    public ImgTower(String pathname){
        super(null); 
        try {
            this.img =  ImageIO.read(new File(pathname));
        } catch (IOException ex) {}
    }
//    public ImgTower(Tower model, Sprite sp){
//        super(model);
//        this.sprite = sp;
//    }
    @Override
    protected int getFireAnimationTime() {
        return 250;
    }

    @Override
    protected void paint(byte state, Graphics2D g) {
//        System.out.println("asd");
//        System.out.println(this);
        g.drawImage(img, 0, 0, null);
    }
}

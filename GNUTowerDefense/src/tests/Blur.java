package tests;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import com.jhlabs.image.BoxBlurFilter;
import com.jhlabs.image.GaussianFilter;
import com.jhlabs.image.PerspectiveFilter;
/**
 * @author zkieda
 */
public class Blur {
    //basic box blur. 
    public Blur(){
        new TestFrame().set(new Paintable() {
            long l1;
//            BoxBlurFilter bbf = new BoxBlurFilter(10, 10, 2);
            GaussianFilter gf = new GaussianFilter(10);
            BufferedImage bi;
            public void paint(Graphics2D g) {
                if(bi==null){
                bi = new BufferedImage(70, 70, BufferedImage.TYPE_INT_ARGB);
                Graphics2D bg = bi.createGraphics();
                bg.setColor(Color.BLACK);
                bg.fillRect(20, 20, 30, 30);
//                bbf.filter(bi, bi);
                gf.filter(bi, bi);
                    PerspectiveFilter p = new PerspectiveFilter();
                    
                BufferedImage bi2 = new BufferedImage(70, 70, BufferedImage.TYPE_INT_ARGB);
                Graphics2D bg2 = bi2.createGraphics();
                bg2.drawImage(bi, null, 0, 0);
                bi.flush();
                bi = bi2;
                }
                l1 = System.nanoTime();
                g.drawImage(bi, null, 0, 0);
                System.out.println(System.nanoTime() - l1);
            }
        }, 0).loop().setVisible(true);
    }
    public static void main(String[] args) {
        new Blur();
    }
    strictfp class c{}
}

package graphics;

import java.awt.Graphics2D;
import tests.Paintable;

/**
 * @author zkieda
 */
public class Graphics implements Paintable{
    @Override public void paint(Graphics2D g) {}
    
    public Graphics blur(/*...*/){return this;}
    public Graphics setBlur(/*...*/){return this;}
    
    public Graphics setFade(){return this;}
    public Graphics fadeOut(/*...*/){return this;}
    public Graphics fadeIn(/*...*/){return this;}
    
    public Graphics then(){return this;}
}

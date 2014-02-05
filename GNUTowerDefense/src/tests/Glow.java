package tests;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;

/**
 * @author zkieda
 */
public class Glow implements Paintable{
    private final Color c1;
    private Shape s;
    
    public Glow(Color c1, float amount){
        this.c1 = c1;
    }
    public void set(Shape s){this.s = s;}
    public void paint(Graphics2D g){
        //new RGBA image on clip w/graphics
            //draw shape of color.
            //blur shape
            //setClip s
            //clear clip
        //paint image on g
    }
}

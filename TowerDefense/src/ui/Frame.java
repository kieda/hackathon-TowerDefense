package ui;

import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * JFrame singleton
 * @author Shaan
 */
public class Frame {
    private Frame(){}
    private static JFrame frame;
    private static JPanel panel;
    
    private static Set<Object> painters;//todo: make a Renderable interface
    
    /**
     * initializes the frame and the panel. 
     * 
     * Ensures frame != null, panel != null, and panel is a component of frame.
     */
    public static void init(){
        frame = new JFrame();
        panel = new JPanel(true);
        
    }
    public static JFrame getFrame(){
        if(frame==null) init();
        return frame;
    }
    public static JPanel getPanel(){
        if(frame==null) init();
        return panel;
    }
}

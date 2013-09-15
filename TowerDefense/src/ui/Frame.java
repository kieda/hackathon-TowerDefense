package ui;

import graphics.Painter;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import util.ScreenInfo;

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
        Painter.init();
        frame = new JFrame();
        panel = new JPanel(true){
            @Override public void paintComponent(Graphics g){
                Painter.paint((Graphics2D)g);
            }
        };
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(ScreenInfo.GAME_BOUNDS);
        frame.setVisible(true);
    }
    
    public static void update(){
        
        frame.repaint();

    }
    
    public static JFrame getFrame(){
        if(frame==null) init();
        return frame;
    }
    public static JPanel getPanel(){
        if(frame==null) init();
        return panel;
    }
    
    public static void main(String[] args) {
        Frame.init();
    }
}

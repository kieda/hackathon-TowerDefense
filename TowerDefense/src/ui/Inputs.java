package ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

/**
 * handles mouse and key inputs
 */
public class Inputs {
    private Inputs(){}
    public static void setMouseListener(MouseListener ml){
        Frame.getFrame().addMouseListener(ml);
    }
    public static void setKeyListener(KeyListener kl){
        Frame.getFrame().addKeyListener(kl);
    }
    public static void setMouseMotionListener(MouseMotionListener mml){
        Frame.getFrame().addMouseMotionListener(mml);
    }
}

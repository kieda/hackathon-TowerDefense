package gui;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowListener;

/**
 * @author zkieda
 */
public interface InputHandler {
    void setKey(KeyListener kl);
    void setMouse(MouseListener ml);
    void setMouseMotion(MouseMotionListener ml);
    void setWindow(WindowListener wl);
}

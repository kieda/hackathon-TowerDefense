package tests;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestFrame{
    private Paintable[] paints;
    private JFrame frame;
    private JPanel panel;
    public TestFrame() {
        this(8);
    }
    public TestFrame(int len) {
        paints = new Paintable[len];
        createGui();
    }
    public TestFrame set(Paintable p, int pos){
        paints[pos] = p;
        return this;
    }
    
    private void createGui() {
        frame = new JFrame();
        panel = new JPanel(false){
            @Override
            protected void paintComponent(Graphics g) {
                for (int i = 0; i < paints.length; i++) {
                    Paintable p = paints[i];
                    if(p!=null) p.paint((Graphics2D)g);
                }
            }
        };
        frame.add(panel);
        frame.setBounds(200, 200, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public TestFrame setVisible(boolean b){
        frame.setVisible(b);
        return this;
    }
    public void repaint(){
        frame.repaint();
    }
    
    public TestFrame loop(){return loopOn(null);}
    public TestFrame loopOn(final Runnable r){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    repaint();
                    if(r!=null)r.run();
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException ex) {}
                }
            }
        }).start();
        return this;
    }
    public static void main(String[] args) {
        final TestFrame tf = new TestFrame();
        tf.setVisible(true);
        tf.set(new Paintable() {
            int j = 0;
            @Override public void paint(Graphics2D g) {
                int h = tf.frame.getHeight();
                int w = tf.frame.getWidth();
                g.clearRect(0, 0, w, h);
                Color c;
                for(int i=0;i<h;i++){
                    int k = j+i;
                    c = new Color(k%255, k%255, k%255);
                    g.setColor(c);
                    g.drawLine(0, i, w, i);
                    try {
                        Thread.currentThread().sleep(1);
                    } catch (Exception e) {}
                }
                j++;
            }
        }, 0);
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    tf.repaint();
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException ex) {}
                }
            }
        }).start();
    }
}
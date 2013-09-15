package drivers;

import graphics.Painter;
import graphics.Renderable;
import graphics.Sprite;
import graphics.game.Board;
import graphics.game.Cell;
import graphics.game.towers.list.LaineTower;
import graphics.game.towers.list.MaxTower;
import graphics.game.towers.list.ShaanTower;
import graphics.game.towers.list.ZakTower;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.TimerTask;
import mechanics.Core;

/**
 * @author Shaan
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Core.init();
//        Painter.add(new Sprite("./sprite-test.png"){
//            @Override public void render(Graphics2D g) {
//                super.render(g); 
//                rotate(.1f);
//                move(2, 2);
//            }
//        });
//        Painter.add(new Renderable() {
//            private AffineTransform at = new AffineTransform();
//            {at.setToTranslation(50, 50);}
//            @Override public void render(Graphics2D g) {
//                int xclip = 50, yclip = 50;
//                g.clipRect(xclip, yclip, 50, 50);
//                g.translate(xclip, yclip);
//                
//                g.setColor(Color.BLACK);
//                g.drawLine(0, 0, 60, 60);
//                g.setClip(null);
//                
//                g.translate(-xclip, -yclip);
//            }
//        });
        Painter.add(new Board(5, 5){
            private Cell rand(){
                switch((int)(Math.random()*4.0)){
                    case 0: return new LaineTower();
                    case 1: return new MaxTower();
                    case 2: return new ZakTower();
                    case 3: return new ShaanTower();
                }
                return null;
            }
            {
                for(int i = 0; i<5; i++){
                    for(int j=0;j<5;j++){
                        Cell c = rand();
//                        System.out.println(c);
                        set(c, j, i);
                    }
                }
            }
        });
    }
}

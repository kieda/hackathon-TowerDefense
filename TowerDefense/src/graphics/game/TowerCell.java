package graphics.game;

import java.awt.Graphics2D;
import mechanics.tower.Tower;

public class TowerCell extends Cell {
    private Tower model;
    
    public TowerCell (Tower model){
        this.model = model;
    }
    
    @Override public void render(Graphics2D g) {
        
    }
}

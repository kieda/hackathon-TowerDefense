
package graphics.game.towers;

import graphics.Sprite;
import graphics.game.TowerCell;
import java.awt.Graphics2D;
import mechanics.tower.Tower;


public class SpriteTower extends TowerCell{
    private Sprite sprite;
    public SpriteTower(String pathname){
        super(null); this.sprite =  new Sprite(pathname);
    }
    public SpriteTower(Tower model, Sprite sp){
        super(model);
        this.sprite = sp;
    }
    @Override
    protected int getFireAnimationTime() {
        return 250;
    }

    @Override
    protected void paint(byte state, Graphics2D g) {
        sprite.render(g);
    }
}

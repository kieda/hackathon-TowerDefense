package graphics.game;

import java.awt.Graphics2D;
import java.util.TimerTask;
import mechanics.Core;
import mechanics.tower.Tower;

public abstract class TowerCell extends Cell {
    private Tower model;
    
    public static final byte STATE_IDLE         = 0b00;
    public static final byte STATE_FIRE_ANIM    = 0b01;
    public static final byte STATE_COOLDOWN     = 0b10;
    private byte state = STATE_IDLE;
    
    protected abstract int getFireAnimationTime();
    
    public TowerCell (Tower model){
        this.model = model;
    }
    
    private TimerTask end_firing = new TimerTask() {
        @Override public void run() {
            state &= ~STATE_COOLDOWN;
        }
    }; 
    private TimerTask stop_anim = new TimerTask() {
        @Override public void run() {
            state &= ~STATE_FIRE_ANIM;
        }
    };
    @Override public void render(Graphics2D g) {
        if(state==STATE_IDLE){
            //we begin firing. We are on cooldown and are firing.
            state = STATE_FIRE_ANIM&STATE_COOLDOWN;
        } else{
            Core.post(stop_anim, getFireAnimationTime());
            Core.post(end_firing, model.getPeriod());
        }
        paint(state, g);
    }
    
    protected abstract void paint(byte state, Graphics2D g);
}

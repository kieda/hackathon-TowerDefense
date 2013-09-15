/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics;

import mechanics.enemy.*;

/**
 *
 * @author shaanvaria
 */
public class Wave {

    public Enemy[] getWave1() {
        return new Enemy[]{
            new Enemy1(),
            new Enemy1(),
            new Enemy1(),
            new Enemy1(),
            new Enemy1()
        };
    }

    public Enemy[] getWave2() {
        return new Enemy[]{
            new Enemy2(),
            new Enemy2(),
            new Enemy2(),
            new Enemy2(),
            new Enemy2()
        };
    }

    public Enemy[] getWave3() {
        return new Enemy[]{
            new Enemy3(),
            new Enemy3(),
            new Enemy3(),
            new Enemy3(),
            new Enemy3()
        };
    }

    public Enemy[] getWave4() {
        return new Enemy[]{
            new Enemy4(),
            new Enemy4(),
            new Enemy4(),
            new Enemy4(),
            new Enemy4()
        };
    }
}

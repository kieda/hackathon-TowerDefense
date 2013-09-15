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

    private Enemy[] getWave1() {
        return new Enemy[]{
            new Enemy1(),
            new Enemy1(),
            new Enemy1(),
            new Enemy1(),
            new Enemy1()
        };
    }

    private Enemy[] getWave2() {
        return new Enemy[]{
            new Enemy2(),
            new Enemy2(),
            new Enemy2(),
            new Enemy2(),
            new Enemy2()
        };
    }

    private Enemy[] getWave3() {
        return new Enemy[]{
            new Enemy3(),
            new Enemy3(),
            new Enemy3(),
            new Enemy3(),
            new Enemy3()
        };
    }

    private Enemy[] getWave4() {
        return new Enemy[]{
            new Enemy4(),
            new Enemy4(),
            new Enemy4(),
            new Enemy4(),
            new Enemy4()
        };
    }
}

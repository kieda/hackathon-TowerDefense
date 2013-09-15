/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.enemy;

/**
 *
 * @author shaanvaria
 */
public class Enemy3 extends Enemy{
    private static String name = "3";
    public Enemy3(){
        super(50f,1.5f);
    }
    
    @Override
    public String getName(){
        return name;
    }
}

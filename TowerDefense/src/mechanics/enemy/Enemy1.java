/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.enemy;

/**
 *
 * @author shaanvaria
 */
public class Enemy1 extends Enemy{
    private static String name = "1";
    public Enemy1(){
        super(100f,1f);
    }
    
    @Override
    public String getName(){
        return name;
    }
}

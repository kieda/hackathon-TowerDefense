/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.enemy;

/**
 *
 * @author shaanvaria
 */
public class Enemy2 extends Enemy{
    private static String name = "2";
    public Enemy2(){
        super(200f,0.5f);
    }
    
    @Override
    public String getName(){
        return name;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.enemy;

/**
 *
 * @author shaanvaria
 */
public class Enemy4 extends Enemy{
    private static String name = "4";
    public Enemy4(float h, float s){
        super(h,s);
    }
    
    @Override
    public String getName(){
        return name;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics.gameplay;

import java.util.HashMap;

/**
 *
 * @author shaanvaria
 */
public class DmgValues {

    private static HashMap<String, Float> dmgs;

    static {
        dmgs = new HashMap<String, Float>();
        populate();
    }

    private DmgValues() {
    }

    private static void populate() {
        dmgs.put("laine1", 0.1f);
        dmgs.put("laine2", 0.5f);
        dmgs.put("laine3", 1.0f);
        dmgs.put("laine4", 2.0f);
        dmgs.put("shaan1", 1.0f);
        dmgs.put("shaan2", 2.0f);
        dmgs.put("shaan3", 1.1f);
        dmgs.put("shaan4", 0.9f);
        dmgs.put("max1", 0.7f);
        dmgs.put("max2", 0.8f);
        dmgs.put("max3", 4.0f);
        dmgs.put("max4", 0.9f);
        dmgs.put("zak1", 2.0f);
        dmgs.put("zak2", 0.5f);
        dmgs.put("zak3", 0.5f);
        dmgs.put("zak4", 2.0f);
        
    }
    
    public static float getDamageModifier(String tower, String enemy){
        //assert below statement does not return null
        return dmgs.get(tower+enemy);
    }
}

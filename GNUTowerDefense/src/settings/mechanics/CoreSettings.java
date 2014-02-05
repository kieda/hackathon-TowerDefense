package settings.mechanics;

import java.lang.reflect.ReflectPermission;
import java.security.Permission;

/**
 * @author zkieda
 */
public final class CoreSettings {
    /**
     * the default wait time, in milliseconds
     */
    public static long WAIT_TIME = 30;

    
    /**
     * The default security manager. Restricts changing the security manager, 
     * and restricts suppressing access checks.
     */
    public static final int DEFAULT_MANAGER = 0b1;
    
    /**
     * no change from the current security manager
     */
    public static final int NO_MANAGER_CHANGE = 0;
    
    public static void setSecurityManager(int managerType){
        //future task : use an integer mask. Then, we can allow or deny certain
        //permissions.
        
        final SecurityManager sm;
        switch(managerType){
            case DEFAULT_MANAGER:
                sm = new SecurityManager();
                break;
            case NO_MANAGER_CHANGE:
            default:
                return;
        }
        System.setSecurityManager(sm);
    }
}

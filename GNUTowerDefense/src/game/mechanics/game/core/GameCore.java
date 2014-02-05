package game.mechanics.game.core;

import game.mechanics.TimeClock;
import game.mechanics.game.gnu.GNUGame;
import settings.mechanics.CoreSettings;

/**
 * @author zkieda
 */
public class GameCore {
    
    /** 
     * We want to protect sensitive data. Ensure no one can tamper with a 
     * compiled game externally. If people want to change the source code that's
     * ok too. 
     */
    static {
        //set it to the default manager. Shady game mods/cheating : change the
        //security manager.
        CoreSettings.setSecurityManager(CoreSettings.DEFAULT_MANAGER);
    }
    
    private final TimeClock c = new TimeClock(CoreSettings.WAIT_TIME);
    private GNUGame g;// = new GNUGame(c.getClockPeer(), new ReadSave(new FileInputStream(LoaderSettings.DEFAULT_AUTOSAVE_FILE)));
    
    //UI ui = new UI(g)//interacts with the game
    //gp = new GamePeer(ui.getRenderPeer())//provides information about the ui 
                                           //and the game
    
    //MenuScreen m = new MenuScreen(g, graphics){//menuscreen implements UI, Paintable
            //onNext() => open gnu game
            //onOpen(File path) => attempt to load player
            //onExit() => quit
    //)
    
    //Frame frame = new Frame();
    //frame.add(menuScreen, 0);
    //graphics = new StdGraphics(c);//implements paintable
    
    
    //init : opening screen
    //frame.setInputs(Inputs.callback(openingScreen, 
    //    onNext() => open gnu game
    //))
    
    //frame.addRenderable(openingScreen)
    
    //inviariant : in game
    //  g.getGame().setCallback(
    //      onGameFinish(EndGame e)
    //          => EndScreen es = new EndScreen(e);
    //             graphics
    //              .fadeOut(Color.BLACK)
    //              .then( () => removeRenderable(0);
    //                           addRenderable(es, 1);
    //                           frame.setInputs(es);
    //              ).fadeIn();
    //      onGameStart()
    //          => frame.addRenderable(gp, 0);
    //             graphics
    //              .fadeOut(Color.BLACK)
    //              .then( () => removeRenderable(1);
    //                           addRenderable(gp, 0);
    //              ).fadeIn();
    //       onPause()
    //  )
    
    private Runnable coreUpdater = new Runnable() {
        @Override public void run() {
            //initialization here???
            while(true /*go*/){
                sleep();
                
                //update game logic
                //g.update()
                
                //repaint the frame
                //frame.repaint()
                
                //update the time
                //c.update()
            }
            //asdfasdf / shutdown
        }
    };

    public GameCore() {
    }
    
    
    
    //loop :
    //  sleep();
    //  g.update();
    //  frame.repaint();
    //  c.update();
    //end.
    private void sleep(){
        try {
            Thread.currentThread().sleep(CoreSettings.WAIT_TIME);
        } catch (Exception e) {}
    }
}

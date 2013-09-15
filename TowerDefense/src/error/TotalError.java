package error;

import javax.swing.JOptionPane;

/**
 * represents a total and complete error
 */
public class TotalError {
    public TotalError(final String wtfHappened){
        new Thread(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showConfirmDialog(null, wtfHappened, "An error has occured.", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }).start();
    }
}
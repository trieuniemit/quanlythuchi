package App;

import Forms.LoginForm;


/**
 *
 * @author Trieu Tai Niem
 */
public class AppLuncher {
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginForm().setVisible(true);
        });
    }
}

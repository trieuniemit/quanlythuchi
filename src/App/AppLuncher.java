package App;

import Forms.LoginForm;
import javax.swing.UIManager;


/**
 *
 * @author Trieu Tai Niem
 */
public class AppLuncher {
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception e) {
            }
            new LoginForm().setVisible(true);
        });
    }
}

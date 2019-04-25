package Library;

import Entity.User;
import javax.swing.JLabel;


/**
 *
 * @author Trieu Tai Niem
 */
public class State {
    public static User currentUser = new User();
    public static JLabel userAmount;
    
    public static void updateUserTotalAmountInUI(int amount) {
        userAmount.setText(Helper.currencyFormat(amount));
    }
}

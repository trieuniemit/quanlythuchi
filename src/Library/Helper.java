package Library;

import java.text.DecimalFormat;

/**
 *
 * @author Trieu Tai Niem
 */
public class Helper {
    public static String[] monthsInYear = {"Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"};
    
    public static String currencyFormat(int amount) {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(amount)+" VNĐ";
    }
}

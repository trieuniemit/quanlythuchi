package Library;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
    
    public static String rmNotNumber(String str) {
        return str.replaceAll("[^\\d]", "");
    }
    
    public static void updateUserTotalAmountInUI(int amount) {
        State.userAmount.setText(Helper.currencyFormat(amount));
    }

    //the method convert string mds hash for password. 
    //source: stackoverflow
    
    public static String md5(String input) { 
        try { 
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
}

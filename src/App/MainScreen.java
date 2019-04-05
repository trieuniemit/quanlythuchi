package App;

import Library.DBManager;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author TrieuTaiNiem
 */
public class MainScreen {
    
    public static void main(String[] args) {
        DBManager db = new DBManager();
        HashMap<String, Object> singleRow = db.getSingleRow("Select * from users");
        
        for (Map.Entry<String, Object> entry : singleRow.entrySet()) {
            String key = entry.getKey();
            Object object = entry.getValue();
            System.out.print(key + ": ");
            System.out.println(object);
        }
    }
}

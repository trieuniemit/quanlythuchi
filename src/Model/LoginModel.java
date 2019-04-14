package Model;

import Library.DBManager;
import java.util.HashMap;

/**
 *
 * @author Trieu Tai Niem
 */
public class LoginModel {
    DBManager _dBManager = new DBManager();
    
    public HashMap<String, Object> loginUser(String userName, String password) {
        //Map<String, Object> = dBManager.getQuery("SELECT * FROM users WHERE username=")
       
        String sqlQuery = _dBManager.securceSql(
            "SELECT * FROM users WHERE username={$1} AND password={$2}",
            new String[]{userName, password}
        );
        
        return _dBManager.getSingleRow(sqlQuery);
    }
}
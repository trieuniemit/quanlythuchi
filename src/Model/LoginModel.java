package Model;

import Entity.User;
import Library.DBManager;
import java.util.HashMap;

/**
 *
 * @author Trieu Tai Niem
 */

public class LoginModel {
    DBManager _dBManager = new DBManager();
    
    public User loginUser(String userName, String password) {
        String sqlQuery = _dBManager.securceSql(
            "SELECT * FROM users WHERE username={$1} AND password={$2}",
            new String[]{userName, password}
        );
        HashMap<String, Object> loginResuilt = _dBManager.getSingleRow(sqlQuery);
        if(!loginResuilt.isEmpty()) 
            return new User(
                (int) loginResuilt.get("id"),
                loginResuilt.get("username").toString(), 
                loginResuilt.get("password").toString(),
                loginResuilt.get("created_at").toString()
            );
        else 
            return null;
    }
}
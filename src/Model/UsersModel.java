package Model;

import Library.DBManager;
import Library.State;
import Entity.User;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Trieu Tai Niem
 */
public class UsersModel {
    DBManager dBManager = new DBManager();
    
    private ArrayList<User> convertToUserArray(ArrayList<HashMap> dbData) {
        ArrayList<User> users = new ArrayList<>();
        dbData.forEach((row) -> {
            users.add(new User(
                (int)row.get("id"),
                row.get("username").toString(),
                row.get("password").toString(),
                (int)row.get("role"),
                row.get("created_at").toString()
            ));
        });
        return users;
    }
    
    public ArrayList<User> getAllUsers() {
        ArrayList<HashMap> dbData = dBManager.getQuery("SELECT * FROM users WHERE id <> " + State.currentUser.getId());
        return convertToUserArray(dbData);
    }

    public boolean insertNewUser(User user) {
        String sqlString = dBManager.securceSql(
            "INSERT INTO users(`username`, `password`, `role`) VALUES({$1},{$2}, {$3})", 
            new String[] {user.getUsername()+ "", user.getPassword(), user.getRole()+""}
        );
        
        return dBManager.setQuery(sqlString);
    }

    public boolean deteteUsers(int id) {
        String sqlString = "DELETE FROM users WHERE id="+id;
        return dBManager.setQuery(sqlString);
    }
    
    public boolean updateUserCol(int id, String col, String value) {
        String sqlString = dBManager.securceSql("UPDATE users SET `" + col + "`={$} WHERE id="+id, value);
        System.out.println(sqlString);
        return dBManager.setQuery(sqlString);
    }
}

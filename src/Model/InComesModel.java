package Model;

import Library.DBManager;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Trieu Tai Niem
 */
public class InComesModel {
    DBManager dBManager = new DBManager();
    
    public ArrayList<HashMap> getAllInComes() {
        return dBManager.getQuery("SELECT * FROM incomes");
    }
    
    public ArrayList<HashMap> searchInComes(String keyword) {
        String sqlString = dBManager.securceSql("SELECT * FROM incomes WHERE title LIKE %{$}%", keyword);
        return dBManager.getQuery(sqlString);
    }
}

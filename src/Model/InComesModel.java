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
    
    public ArrayList<HashMap> getInComesByMonth(int month, int year) {
        return dBManager.getQuery("SELECT * FROM incomes WHERE YEAR(datetime) = " + year + " AND MONTH(datetime) = " + month);
    }
    
    public ArrayList<HashMap> searchInComes(String keyword) {
        String sqlString = dBManager.securceSql("SELECT * FROM incomes WHERE title LIKE {$}", "%" + keyword + "%");
        return dBManager.getQuery(sqlString);
    }
    
    public HashMap getMinMaxDate() {
        HashMap minMaxDate = dBManager.getSingleRow("SELECT MIN(datetime) AS min_date, MAX(datetime) AS max_date FROM incomes");
        String maxDate = minMaxDate.get("max_date").toString();
        String minDate = minMaxDate.get("min_date").toString();
        
        HashMap returnData = new HashMap();
        
        returnData.put("max_year", maxDate.substring(0,4));
        returnData.put("max_month", maxDate.substring(5,7));
        returnData.put("min_year", minDate.substring(0,4));
        returnData.put("min_month", minDate.substring(5,7));
        return returnData;
    }
}

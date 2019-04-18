package Model;

import Library.DBManager;
import Library.Helper;
import entity.InCome;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Trieu Tai Niem
 */
public class InComesModel {
    DBManager dBManager = new DBManager();
    
    private ArrayList<InCome> convertToInComeArray(ArrayList<HashMap> dbData) {
        ArrayList<InCome> inComes = new ArrayList<>();
        dbData.forEach((row) -> {
            inComes.add(new InCome(
                (int)row.get("id"),
                Helper.currentUser.getId(),
                row.get("title").toString(),
                row.get("note").toString(),
                (int)row.get("amount"),
                row.get("datetime").toString()
            ));
        });
        return inComes;
    }
    
    public ArrayList<InCome> getAllInComes() {
        ArrayList<HashMap> dbData = dBManager.getQuery("SELECT * FROM incomes");
        return convertToInComeArray(dbData);
    }
    
    public ArrayList<InCome> getInComesByMonth(int month, int year) {
        ArrayList<HashMap> dbData = dBManager.getQuery("SELECT * FROM incomes WHERE YEAR(datetime) = " + year + " AND MONTH(datetime) = " + month);
        return convertToInComeArray(dbData);
    }
    
    public ArrayList<InCome> searchInComes(String keyword) {
        String sqlString = dBManager.securceSql("SELECT * FROM incomes WHERE title LIKE {$}", "%" + keyword + "%");
        ArrayList<HashMap> dbData = dBManager.getQuery(sqlString);
        return convertToInComeArray(dbData);
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
    
    public boolean insertNewInCome(InCome inCome) {
        String sqlString = dBManager.securceSql(
            "INSERT INTO incomes(`user_id`, `title`, `note`, `amount`) VALUES({$1},{$2}, {$3}, {$4})", 
            new String[] {inCome.getUserId() + "", inCome.getTitle(), inCome.getNote(), inCome.getAmount()+""}
        );
        return dBManager.setQuery(sqlString);
    }
}

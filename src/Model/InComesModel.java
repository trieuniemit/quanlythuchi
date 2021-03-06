package Model;

import Library.DBManager;
import Library.State;
import Entity.InCome;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
                State.currentUser.getId(),
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
        String maxDate = "", minDate = "";
        try {
            maxDate = minMaxDate.get("max_date").toString();
            minDate = minMaxDate.get("min_date").toString();
        } catch(Exception e) {
            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date currentDate = new Date();
            String strDate = sdfDate.format(currentDate);
            maxDate =  minDate = strDate;
        }
        
        HashMap returnData = new HashMap();
        returnData.put("max_year", maxDate.substring(0,4));
        returnData.put("max_month", maxDate.substring(5,7));
        returnData.put("min_year", minDate.substring(0,4));
        returnData.put("min_month", minDate.substring(5,7));
        System.out.println(returnData);
        return returnData;
    }
    
    public boolean insertNewInCome(InCome inCome) {
        String sqlString = dBManager.securceSql(
            "INSERT INTO incomes(`user_id`, `title`, `note`, `amount`) VALUES({$1},{$2}, {$3}, {$4})", 
            new String[] {inCome.getUserId() + "", inCome.getTitle(), inCome.getNote(), inCome.getAmount()+""}
        );
        
        if(inCome.getDatetime() != null) {
            sqlString = dBManager.securceSql(
                "INSERT INTO incomes(`user_id`, `title`, `note`, `amount`, `datetime`) VALUES({$1},{$2}, {$3}, {$4}, {$5})", 
                new String[] {inCome.getUserId() + "", inCome.getTitle(), inCome.getNote(), inCome.getAmount()+"", inCome.getDatetime()}
            );
        }
        
        return dBManager.setQuery(sqlString);
    }

    public boolean deteteInComes(int id) {
        String sqlString = "DELETE FROM incomes WHERE id="+id;
        return dBManager.setQuery(sqlString);
    }
    
    public boolean updateInComesCol(int id, String col, String value) {
        String sqlString = dBManager.securceSql("UPDATE incomes SET `" + col + "`={$} WHERE id="+id, value);
        System.out.println(sqlString);
        return dBManager.setQuery(sqlString);
    }
}

package Model;

import Library.DBManager;
import Library.State;
import Entity.Debt;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Trieu Tai Niem
 */
public class DebtsModel {
    DBManager dBManager = new DBManager();
    
    private ArrayList<Debt> convertToDebtArray(ArrayList<HashMap> dbData) {
        ArrayList<Debt> debts = new ArrayList<>();
        dbData.forEach((row) -> {
            debts.add(new Debt(
                (int)row.get("id"),
                State.currentUser.getId(),
                row.get("title").toString(),
                row.get("note").toString(),
                (int)row.get("amount"),
                row.get("datetime").toString(),
                (int)row.get("status")
            ));
        });
        return debts;
    }
    
    public ArrayList<Debt> getAllDebts() {
        ArrayList<HashMap> dbData = dBManager.getQuery("SELECT * FROM debts");
        return convertToDebtArray(dbData);
    }
    
    public ArrayList<Debt> getInComesByMonth(int month, int year) {
        ArrayList<HashMap> dbData = dBManager.getQuery("SELECT * FROM debts WHERE YEAR(datetime) = " + year + " AND MONTH(datetime) = " + month);
        return convertToDebtArray(dbData);
    }
    
    public ArrayList<Debt> searchDebts(String keyword) {
        String sqlString = dBManager.securceSql("SELECT * FROM debts WHERE title LIKE {$}", "%" + keyword + "%");
        ArrayList<HashMap> dbData = dBManager.getQuery(sqlString);
        return convertToDebtArray(dbData);
    }
    
    public HashMap getMinMaxDate() {
        HashMap minMaxDate = dBManager.getSingleRow("SELECT MIN(datetime) AS min_date, MAX(datetime) AS max_date FROM debts");
        
        String maxDate = "", minDate = "";
        if(!minMaxDate.isEmpty() && minMaxDate.get("max_date") != null) {
            maxDate = minMaxDate.get("max_date").toString();
            minDate = minMaxDate.get("min_date").toString();
        } else {
            Date currentDate = new Date();
            maxDate = currentDate.toString();
            minDate = currentDate.toString();
        }
        HashMap returnData = new HashMap();
        returnData.put("max_year", maxDate.substring(0,4));
        returnData.put("max_month", maxDate.substring(5,7));
        returnData.put("min_year", minDate.substring(0,4));
        returnData.put("min_month", minDate.substring(5,7));
        System.out.println(returnData);
        return returnData;
    }
    
    public boolean insertNewDebt(Debt debt) {
        String sqlString = dBManager.securceSql(
            "INSERT INTO debts(`user_id`, `title`, `note`, `amount`, `status`) VALUES({$1},{$2}, {$3}, {$4}, {$5})", 
            new String[] {debt.getUserId() + "", debt.getTitle(), debt.getNote(), debt.getAmount()+"", debt.getStatus()+""}
        );
        
        if(debt.getDatetime() != null) {
            sqlString = dBManager.securceSql(
                "INSERT INTO debts(`user_id`, `title`, `note`, `amount`, `datetime`, `status`) VALUES({$1},{$2}, {$3}, {$4}, {$5}, {$6})", 
                new String[] {debt.getUserId() + "", debt.getTitle(), debt.getNote(), debt.getAmount()+"", debt.getDatetime(), debt.getStatus() + ""}
            );
        }
        
        return dBManager.setQuery(sqlString);
    }

    public boolean deteteDebts(int id) {
        String sqlString = "DELETE FROM debts WHERE id="+id;
        return dBManager.setQuery(sqlString);
    }
    
    public boolean updateDebtCol(int id, String col, String value) {
        String sqlString = dBManager.securceSql("UPDATE debts SET `" + col + "`={$} WHERE id="+id, value);
        System.out.println(sqlString);
        return dBManager.setQuery(sqlString);
    }
}

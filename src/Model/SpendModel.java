/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Library.DBManager;
import entity.Spend;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Huy Hys
 */
public class SpendModel {
    DBManager dBManager = new DBManager();
    
    public ArrayList<Spend> getAllSpends(){
        ArrayList<Spend> spends = new ArrayList<>();
        String sqlQuery = "SELECT * From Spends where user_id = 2"; 
        ArrayList<HashMap> dbData = dBManager.getQuery(sqlQuery);
        
        for(HashMap row : dbData){
            spends.add(new Spend(
                (int)row.get("id"),
                (int)row.get("amount"),
                row.get("title").toString(),
                row.get("note").toString(),
                row.get("datetime").toString()
            ));
        }
        return spends;
    }
    
    public ArrayList<Spend> getMonthYear(int month, int year){
        ArrayList<Spend> spends = new ArrayList<>();
        String sqlQuery = dBManager.securceSql("SELECT * From Spends where Year(datetime)={$1} AND MONTH(datetime)={$2}", new String[]{year+"",month+""});
        
        ArrayList<HashMap> dbData = dBManager.getQuery(sqlQuery);
        
        for(HashMap row : dbData){
            spends.add(new Spend(
                (int)row.get("id"),
                (int)row.get("amount"),
                row.get("title").toString(),
                row.get("note").toString(),
                row.get("datetime").toString()
            ));
        }
        
        return spends;
    }
}

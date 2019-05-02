/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Library.DBManager;
import Library.State;
import entity.Spend;
import java.util.ArrayList;
import java.util.HashMap;
//import java.*;
//import java.util.Calendar;

/**
 *
 * @author Huy Hys
 */
public class SpendModel {
    DBManager dBManager = new DBManager();
    
//    public int getTotalSpend(){
//        SpendModel spendsModel = new SpendModel();
//        int currentMonth = Calendar.getInstance().get(Calendar.MONTH)+1;
//        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
//        ArrayList<Spend> spendsData = spendsModel.getMonthYear(currentMonth, currentYear); 
//        String totalSpend = "SELECT sum(amount) as TongTien FROM spends where user_id = "+State.currentUser.getId() + "and MONTH(datetime) ="+ currentMonth+" and YEAR(datetime) = "+currentYear ;
//        
//        HashMap<String, Object> dbdata = dBManager.getSingleRow(totalSpend);
//        
//        return (int)dbdata.get("TongTien") ;
//    }
    public ArrayList<Spend> getAllSpends(){
        ArrayList<Spend> spends = new ArrayList<>();
        String sqlQuery = "SELECT * From Spends where user_id = "+State.currentUser.getId();
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
    
    
    public boolean insertSpend(Spend spend){
        
        String sqlQuery = dBManager.securceSql(
                "INSERT INTO Spends (user_id,title,note,amount) VALUES({$1},{$2},{$3},{$4})",
                new String[]{State.currentUser.getId()+"",spend.getTitle(),spend.getNote(),spend.getAmount()+""}
        );
        return dBManager.setQuery(sqlQuery);
    }
    
    public boolean deleteSpend(int id){
        String sqlQuery = "DELETE From Spends Where id = "+id;
        return dBManager.setQuery(sqlQuery);
    }
    
    public  boolean updateSpend(Spend spend){
        String sqlQuery = dBManager.securceSql(
                "UPDATE Spends SET title={$1}, note={$2}, amount={$3} where id={$4}",
                new String[]{spend.getTitle(),spend.getNote(),spend.getAmount()+"",spend.getId()+""}
        );
        return dBManager.setQuery(sqlQuery);
    }
    
    public ArrayList<Spend> findSpends(String tbFindSpend){
        ArrayList<Spend> spends = new ArrayList<>();
        String sqlQuery = dBManager.securceSql("SELECT * From Spends where title like {$}", "%"+tbFindSpend+"%");
        
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
        String sqlQuery = dBManager.securceSql("SELECT * From Spends where Year(datetime)={$1} AND MONTH(datetime)={$2} and user_id = {$3}",
                new String[]{year+"",month+"",State.currentUser.getId()+"",}
        );
        
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Library.DBManager;
import Library.State;
import Entity.Loan;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Huy Hys
 */
public class LoanModel {
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
    public ArrayList<Loan> getAllLoans(){
        ArrayList<Loan> loans = new ArrayList<>();
        String sqlQuery = "SELECT * From loans where user_id = "+State.currentUser.getId();
        ArrayList<HashMap> dbData = dBManager.getQuery(sqlQuery);
        
        for(HashMap row : dbData){
            loans.add(new Loan(
                (int)row.get("id"),
                row.get("title").toString(),
                row.get("note").toString(),
                (int)row.get("amount"),
                row.get("loan_at").toString(),
                row.get("recover_at").toString(), 
                (boolean)row.get("status")
            ));
        }
        return loans;
    }
    
    
    public boolean insertLoan(Loan loan){
        
        String sqlQuery = dBManager.securceSql(
                "INSERT INTO Loans (user_id,title,note,amount,loan_at,recover_at,status) VALUES({$1},{$2},{$3},{$4},{$5},{$6},{$7})",
                new String[]{State.currentUser.getId()+"",loan.getTitle(),loan.getNote(),loan.getAmount()+"",loan.getLoanAt(),loan.getRecoverAt(),loan.getStatus()+""}
        );
        return dBManager.setQuery(sqlQuery);
    }
    
    public boolean deleteLoan(int id){
        String sqlQuery = "DELETE From loans Where id = "+id;
        return dBManager.setQuery(sqlQuery);
    }
    
    public  boolean updateLoan(Loan loan){
        String sqlQuery = dBManager.securceSql(
                "UPDATE loans SET title={$1}, note={$2}, amount={$3},loan_at = {s4},recover_at = {s5},status = {$6} where id={$7}",
                new String[]{loan.getTitle(),loan.getNote(),loan.getAmount()+"",loan.getLoanAt(),loan.getRecoverAt(),loan.getStatus()+"",loan.getId()+""}
        );
        return dBManager.setQuery(sqlQuery);
    }
    
    public ArrayList<Loan> findSpends(String tbFindLoans){
        ArrayList<Loan> loans = new ArrayList<>();
        String sqlQuery = dBManager.securceSql("SELECT * From loans where title like {$}", "%"+tbFindLoans+"%");
        
        ArrayList<HashMap> dbData = dBManager.getQuery(sqlQuery);
        
        for(HashMap row : dbData){
            loans.add(new Loan(
                (int)row.get("id"),
                row.get("title").toString(),
                row.get("note").toString(),
                (int)row.get("amount"),
                row.get("loan_at").toString(),
                row.get("recover_at").toString(),
                (boolean)row.get("status")
            ));
        }
        return loans;
    }

    
    
    
}

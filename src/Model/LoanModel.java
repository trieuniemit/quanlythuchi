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
                (int)row.get("status")
            ));
        }
        return loans;
    }
    
    
    public boolean insertLoan(Loan loan){
        
        String sqlQuery = dBManager.securceSql(
                "INSERT INTO Loans (user_id,title,note,amount,recover_at,status) VALUES({$1},{$2},{$3},{$4},{$5},{$6})",
                new String[]{State.currentUser.getId()+"",loan.getTitle(),loan.getNote(),loan.getAmount()+"",loan.getRecoverAt(),loan.getStatus()+""}
        );
        return dBManager.setQuery(sqlQuery);
    }
    
    public boolean deleteLoan(int id){
        String sqlQuery = "DELETE From loans Where id = "+id;
        return dBManager.setQuery(sqlQuery);
    }
    
    public  boolean updateLoan(Loan loan){
        String sqlQuery = dBManager.securceSql(
                "UPDATE loans SET title={$1}, note={$2}, amount={$3},recover_at = {$4},status = {$5} where id={$6}",
                new String[]{loan.getTitle(),loan.getNote(),loan.getAmount()+"",loan.getRecoverAt(),loan.getStatus()+"",loan.getId()+""}
        );
        return dBManager.setQuery(sqlQuery);
    }
    
    public ArrayList<Loan> findLoans(String tbFindLoans){
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
                (int)row.get("status")
            ));
        }
        return loans;
    }

   
}

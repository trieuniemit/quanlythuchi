/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Library.DBManager;

/**
 *
 * @author Trieu Tai Niem
 */
public class MainFormModel {
    DBManager dbManager = new DBManager();
    
public int totalUserAmount() {
        Object inComeAmount = dbManager.getSingleRow("SELECT SUM(amount) as amount FROM incomes").get("amount");
        Object spendAmount = dbManager.getSingleRow("SELECT SUM(amount) as amount FROM spends").get("amount");
        Object debtAmount = dbManager.getSingleRow("SELECT SUM(amount) as amount FROM debts").get("amount");
        Object loanAmount = dbManager.getSingleRow("SELECT SUM(amount) as amount FROM loans").get("amount");
        
        return (inComeAmount==null?0:Integer.valueOf(inComeAmount.toString())) 
                - (spendAmount==null?0:Integer.valueOf(spendAmount.toString())) 
                + (debtAmount==null?0:Integer.valueOf(debtAmount.toString())) 
                - (loanAmount==null?0:Integer.valueOf(loanAmount.toString()));
    }
}

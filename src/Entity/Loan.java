/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Huy Hys
 */
public class Loan {
    private int id;
    private int user_id;
    private String title;
    private String note;
    private int amount;
    private String loanAt;
    private String recoverAt;
    private int status;

    

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }

    public int getAmount() {
        return amount;
    }

    public String getLoanAt() {
        return loanAt;
    }

    public String getRecoverAt() {
        return recoverAt;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setLoanAt(String loanAt) {
        this.loanAt = loanAt;
    }

    public void setRecoverAt(String recoverAt) {
        this.recoverAt = recoverAt;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public Loan() {
    }

    public Loan(int id, int user_id, String title, String note, int amount, String loanAt, String recoverAt, int status) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.note = note;
        this.amount = amount;
        this.loanAt = loanAt;
        this.recoverAt = recoverAt;
        this.status = status;
    }

    public Loan(int id, String title, String note, int amount, String recoverAt, int status) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.amount = amount;
        this.recoverAt = recoverAt;
        this.status = status;
    }

    public Loan(int id, String title, String note, int amount, String loanAt, String recoverAt, int status) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.amount = amount;
        this.loanAt = loanAt;
        this.recoverAt = recoverAt;
        this.status = status;
    }

    

   
}

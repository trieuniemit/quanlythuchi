package Entity;

/**
 *
 * @author Trieu Tai Niem
 */
public class Debt {
    private int id;
    private int userId;
    private int amount;
    private String title;
    private String note;
    private int status;
    private String datetime;

    public Debt() {
    }
    
    public Debt(String title, String note, int amount) {
        this.amount = amount;
        this.title = title;
        this.note = note;
        this.status = 0;
    }
    
    public Debt(int userId, String title, String note, int amount) {
        this.amount = amount;
        this.title = title;
        this.note = note;
        this.userId = userId;
    }
    
    public Debt(int id, int userId, String title, String note, int amount, String datetime, int status) {
        this.id = id;
        this.amount = amount;
        this.userId = userId;
        this.title = title;
        this.note = note;
        this.status = status;
        this.datetime = datetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
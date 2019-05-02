package entity;

/**
 *
 * @author Huy Hys
 */
public class Spend {
    private int id;
    private int userId;
    private int amount;
    private String title;
    private String note;
    private String datetime;

    public Spend() {
    }

    public Spend(int id) {
        this.id = id;
    }
    
    
    public Spend(int id, int userId,int amount, String title, String note, String datetime) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.title = title;
        this.note = note;
        this.datetime = datetime;
    }

    public Spend(int id, int amount, String title, String note, String datetime) {
        this.id = id;
        this.amount = amount;
        this.title = title;
        this.note = note;
        this.datetime = datetime;
    }
    
    
    public Spend(int userId, int amount, String title, String note) {
        this.userId = userId;
        this.amount = amount;
        this.title = title;
        this.note = note;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Spend{" + "id=" + id + ", amount=" + amount + ", title=" + title + ", note=" + note + ", datetime=" + datetime + '}';
    }
    
}

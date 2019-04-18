package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Trieu Tai Niem
 */

public class DBManager {
    Connection con = null;
    Statement stmt = null;
    
    public DBManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            AppConfig config = new AppConfig();
            
            con = DriverManager.getConnection(
                config.getValue("DataBaseConfig.jdbc"), 
                config.getValue("DataBaseConfig.dbuser"), 
                config.getValue("DataBaseConfig.dbpassword")
            );
            stmt = con.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("ERROR: Can't connect to database! :))");
            showMessageDialog(null, "Không thể kết nối đến cơ sở dữ liệu!", "Thông báo!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList<HashMap> getQuery(String sqlString) {
        ArrayList<HashMap> returnData = new ArrayList<>();
        
        try {
            
            ResultSet result = stmt.executeQuery(sqlString);
            
            ResultSetMetaData rsmd = result.getMetaData();
            
            while (result.next()) {
                HashMap<String, Object> rows = new HashMap<>();
                for(int i = 1; i <= rsmd.getColumnCount(); i ++) {
                    rows.put(rsmd.getColumnName(i), result.getObject(i));
                }
                returnData.add(rows);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return returnData;
    }
    
    //method for update or delete data, return true on success, false on failure
    public boolean setQuery(String sqlString) {
        try {
            stmt.execute(sqlString);
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return false;
    }
    
    //method for get single row in db record
    public HashMap<String, Object> getSingleRow(String sqlString) {
        HashMap<String, Object> rows = new HashMap<>();
        
        try {
            
            ResultSet result = stmt.executeQuery(sqlString);
            
            ResultSetMetaData rsmd = result.getMetaData();
            
            if (result.next()) {
                for(int i = 1; i <= rsmd.getColumnCount(); i ++) {
                    rows.put(rsmd.getColumnName(i), result.getObject(i));
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        
        return rows;
    }
    
    public String securceSql(String sqlQuery, String[] params) {
        for(int i = 1; i <= params.length; i ++) {
            String replaceChars = params[i-1].replaceAll("[,'`\"\";:<>=]", "");
            sqlQuery = sqlQuery.replace("{$"+i+"}", "'" + replaceChars + "'");
        }
        
        return sqlQuery;
    }
    
    public String securceSql(String sqlQuery, String value) {
        String replaceChars = value.replaceAll("[,'`\"\";:<>=]", "");
        sqlQuery = sqlQuery.replace("{$}", "'" + replaceChars + "'");
        return sqlQuery;
    }
}

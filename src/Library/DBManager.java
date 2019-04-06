package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TrieuTaiNiem
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
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return returnData;
    }
    
    public boolean setQuery(String sqlString) {
        try {
           stmt.executeQuery(sqlString);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
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
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rows;
    }
    
    
}

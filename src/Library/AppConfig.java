package Library;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.json.JSONObject;


/**
 *
 * @author TrieuTaiNiem
 * @created_at 2019-04-05
 */

public final class AppConfig {
    
    private static JSONObject content = null;
    
    public AppConfig() {
        AppConfig.readConfigContent();
    }
    
    public static void readConfigContent() {
        if(content != null) return;
       
        URL path = AppConfig.class.getClassLoader().getResource("App/AppConfig.json");      
        String data = null; 
        try {
            data = new String(Files.readAllBytes(Paths.get(path.getFile().substring(1))));
            content = new JSONObject(data);
        } catch (IOException ex) {
            Logger.getLogger(AppConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getValue(String keyName) {
        String keys[] = keyName.split(Pattern.quote("."));
        
        if(keys.length == 1) {
            return (String) content.get(keys[0]);
        }
        
        int index = 0;
        JSONObject currentObj = content;
        
        for (String key: keys) {
            if(++index == keys.length) {
                return (String) currentObj.get(key);
            } else {
                currentObj = (JSONObject) currentObj.getJSONObject(key);
            }
        }
        
        return "";
    }
}

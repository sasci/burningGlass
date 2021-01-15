package sasci.io.selenium.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationUtils {
    static Properties localProperties = new Properties();
    public void loadValues(String filePath){
//        String filePath="/Props/config.properties";

        try(InputStream input=getClass().getResourceAsStream(filePath)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + filePath);
                return;
            }
            localProperties.load(input);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static String getValue(String key){
        return localProperties.getProperty(key);
    }

    public static void setValue(String key,String value){
        localProperties.setProperty(key,value);
    }
}

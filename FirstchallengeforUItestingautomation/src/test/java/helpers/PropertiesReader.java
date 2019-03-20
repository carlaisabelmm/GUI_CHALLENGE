package helpers;

import java.io.*;
import java.util.Properties;

public class PropertiesReader {
    Properties properties = new Properties();
    InputStream inputStream = null;

    public void dataFileFromConfigProperties() throws IOException {
        try{
            inputStream = new FileInputStream("C:\\Users\\cmarquez\\Downloads\\GUI_CHALLENGE-Properties\\GUI_CHALLENGE-Properties\\FirstchallengeforUItestingautomation\\src\\test\\resources\\configurations\\config.properties");
            properties.load(inputStream);
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getValueByKey(String key)  {
        String KEY = properties.getProperty(key);
        return KEY;

    }
}

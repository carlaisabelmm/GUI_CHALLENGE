package helpers;

import utils.PathData;
import utils.URLData;

import java.io.*;
import java.util.Properties;

public class PropertiesReader extends PathData {
    Properties properties = new Properties();
    InputStream inputStream = null;

    public void dataFileFromConfigProperties() {
        try{
            inputStream = new FileInputStream(getPropertiesPath());
            properties.load(inputStream);
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValueByKey(String key)  {
        dataFileFromConfigProperties();
        String KEY = properties.getProperty(key);
        return KEY;

    }
}

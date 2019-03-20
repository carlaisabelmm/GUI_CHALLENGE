package helpers;

import java.util.ResourceBundle;

public class PropertiesReader {

    private  static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }
}

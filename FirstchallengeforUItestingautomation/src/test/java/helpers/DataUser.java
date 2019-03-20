package helpers;

public class DataUser {
    //User 1:
    String username = "cmarquez";
    String name = "Carla";
    String lastname = "Marquez";
    String email = "carla.marquez@endava.com";
    String password = "Ecofood1*";
    String wrongUsername = "marquez";
    String wrongPassword = "food";
    String nullUsername = " ";
    String nullPassword =  " ";

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getWrongUsername() {
        return wrongUsername;
    }

    public String getWrongPassword() {
        return wrongPassword;
    }

    public String getNullUsername() {
        return nullUsername;
    }

    public String getNullPassword() {
        return nullPassword;
    }
}
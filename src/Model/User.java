package Model;

import java.io.Serializable;

public class User implements Serializable {

    private String userName;
    private String userPassword;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public boolean checkLogIn(String username, String userpassword) {
        if (this.userName.equals(username) && this.userPassword.equals(userpassword)) {
            return true;
        } else {
            return false;
        }
    }

    public String getUserName() {
        return userName;
    }

}

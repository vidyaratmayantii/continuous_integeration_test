package com.mycompany.tp_mod12_1302213026;

public class UserData {
    private int userid;
    private int password;
    private boolean loggedIn;

    public UserData(int userid, int password) {
        this.userid = userid;
        this.password = password;
        this.loggedIn = false;
    }

    public void login() {
        if (String.valueOf(password).length() != 4) {
            throw new IllegalArgumentException("Password harus 4 digit");
        }
        if (userid == 1234 && password == 8766) {
            this.loggedIn = true;
        } else {
            throw new LoginFailedException(userid);
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}

class LoginFailedException extends RuntimeException {
    private final int userid;

    public LoginFailedException(int userid) {
        super("Login failed for user: " + userid);
        this.userid = userid;
    }

    public int getUserid() {
        return userid;
    }
}

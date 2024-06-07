package com.mycompany.tp_mod12_1302213026;

public class LoginFailedException extends RuntimeException {
    private final int userid;

    public LoginFailedException(int userid) {
        super("Login failed for user: " + userid);
        this.userid = userid;
    }

    public int getUserid() {
        return userid;
    }
}

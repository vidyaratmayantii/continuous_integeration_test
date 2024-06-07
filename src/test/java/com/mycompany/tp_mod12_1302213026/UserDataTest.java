package com.mycompany.tp_mod12_1302213026;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserDataTest {
    
    @Test
    void testSuccessfulLogin() {
        UserData user = new UserData(1234, 8766);
        user.login();
        assertTrue(user.isLoggedIn());
    }

    @Test
    void testUnsuccessfulLogin() {
        UserData user = new UserData(1234, 1234);
        try {
            user.login();
            fail("Expected LoginFailedException to be thrown");
        } catch (LoginFailedException e) {
            assertEquals(1234, e.getUserid());
        }
        assertFalse(user.isLoggedIn());
    }

    @Test
    void testInvalidPassword() {
        UserData user = new UserData(9999, 1);
        Exception exception = assertThrows(IllegalArgumentException.class, user::login);
        assertEquals("Password harus 4 digit", exception.getMessage());
    }

    @Test
    void testLoginFailedException() {
        UserData user = new UserData(1234, 1234);
        Exception exception = assertThrows(LoginFailedException.class, user::login);
        assertTrue(exception instanceof LoginFailedException);
        LoginFailedException ex = (LoginFailedException) exception;
        assertEquals(1234, ex.getUserid());
    }
}

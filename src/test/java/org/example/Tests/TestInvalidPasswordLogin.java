package org.example.Tests;

import org.example.Pages.LoginPage;
import org.example.Utils.ConfProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInvalidPasswordLogin extends BaseTest {

    private final String invalid_password = "12345678";

    @Test
    @DisplayName("invalid password auth test")
    public void testInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .inputLogin(ConfProperties.getProperty("login"))
                .inputPasswd(invalid_password)
                .clickLoginBtn();
        assertEquals("Неправильно указан логин и/или пароль", loginPage.getErrMsg());
    }
}

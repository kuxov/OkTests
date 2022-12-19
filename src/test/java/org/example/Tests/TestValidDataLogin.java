package org.example.Tests;

import org.example.Pages.LoginPage;
import org.example.Pages.ProfilePage;
import org.example.Utils.ConfProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestValidDataLogin extends BaseTest {

    private final String bot_name = "technoPol20 technoPol20";

    @Test
    @DisplayName("valid username and password auth test")
    public void testValidData() {
        login();

        ProfilePage profilePage = new ProfilePage(driver);
        String user = profilePage.getUserName();
        assertEquals(bot_name, user);
    }
}

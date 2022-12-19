package org.example.Tests;

import org.example.Pages.LoginPage;
import org.example.Pages.ProfilePage;
import org.example.Utils.ConfProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUpdateProfilePic extends BaseTest{

    private final String path_to_pic = "C:\\Users\\vnkuk\\IdeaProjects\\final-stunning-fortnight\\src\\test\\resources\\ava.png";

    @Test
    @DisplayName("upload photo test")
    public void testUpdatePhoto() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .inputLogin(ConfProperties.getProperty("login"))
                .inputPasswd(ConfProperties.getProperty("password"))
                .clickLoginBtn();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.uploadPhoto(path_to_pic);
        assertTrue(profilePage.checkIfPhotoUploaded());
        profilePage.deleteProfilePicture();
    }
}

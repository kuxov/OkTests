package org.example.Tests;

import org.example.Pages.LoginPage;
import org.example.Pages.PhotosPage;
import org.example.Pages.ProfilePage;
import org.example.Utils.ConfProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class TestSearchForExistingAlbum extends BaseTest{

    @DisplayName("search for existing test3 album")
    @Test
    public void searchForExistingAlbum()
    {
        login();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.toPhotosPage();

        PhotosPage photosPage = new PhotosPage(driver);
        photosPage.inputSearchTitle();

        assertTrue(photosPage.albumFound());
    }
}

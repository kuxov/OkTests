package org.example.Tests;

import org.example.Pages.PhotosPage;
import org.example.Pages.ProfilePage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.Assert.assertTrue;


public class TestCreateAnAlbum extends BaseTest{
    @DisplayName("creating an album test")
    @ParameterizedTest
    @ValueSource(strings = { "test3", "test4", "test5" })
    //@Disabled("чтобы не насоздавал миллион альбомов")
    public void testCreateAlbum(String name) {
        login();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.toPhotosPage();

        PhotosPage photosPage = new PhotosPage(driver);
        photosPage
                .startCreatingAlbum()
                .inputAlbumTitle(name)
                .createAlbum();

        assertTrue(photosPage.albumIsEmpty());
    }
}

package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PhotosPage extends BasePage{

    public WebDriver driver;
    @FindBy(xpath = "//*[contains(@class, 'button-pro __sec __small')]")
    public WebElement createPhotoAlbum;

    @FindBy(xpath = "//textarea")
    public WebElement textFieldEditor;

    @FindBy(xpath = "//*[@id='hook_FormButton_button_album_create']")
    public WebElement confirm;

    @FindBy(xpath = "//*[contains(@id, 'field_query')]")
    public WebElement searchField;

    @FindBy(xpath = "//*[contains(text(), 'Альбом пуст')]")
    public WebElement albumIsEmptyMsg;

    @FindBy(xpath = "//*[contains(text(), 'Таких альбомов не найдено')]")
    public WebElement noAlbumsMsg;

    public PhotosPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        check();}

    public void inputSearchTitle()
    {
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys("test2");
    }

    public boolean albumFound()
    {
        WebElement element =
                new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(noAlbumsMsg));
        return element != null;
    }
    public boolean albumIsEmpty()
    {
        WebElement element =
                new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(albumIsEmptyMsg));
        return element != null;
    }

    public PhotosPage startCreatingAlbum()
    {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(createPhotoAlbum));
        createPhotoAlbum.click();
        return this;
    }

    public PhotosPage inputAlbumTitle(String text)
    {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(textFieldEditor));
        textFieldEditor.sendKeys(text);
        return this;
    }

    public void createAlbum()
    {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(confirm));
        confirm.click();
    }

    @Override
    protected void check() {
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(createPhotoAlbum));
        if(createPhotoAlbum.isDisplayed()) {System.out.println("create album button is visible");}

        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(searchField));
        if(searchField.isDisplayed()) {System.out.println("search field is visible");}

        System.out.println("\n");
    }
}
package org.example.Pages;
import org.example.Utils.ConfProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class ProfilePage extends BasePage{
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        check();}

    @FindBy(xpath = "//*[contains(@class, 'html5-upload-link')]")
    private WebElement uploadPhotoBtn;
    @FindBy(xpath = "//*[contains(text(), 'Фото')]")
    private WebElement goToPhotos;
    @FindBy(xpath = "//*[contains(text(), 'Установить')]")
    private WebElement confirmProfilePicUpload;
    @FindBy(xpath = "//*[contains(@data-l, 't,userPage')]")
    private WebElement userMenu;

    @FindBy(xpath = "//*[contains(@id, 'viewImageLinkId')]")
    private WebElement avatar;

    @FindBy(xpath = "//*[contains(@class, 'entity-avatar')]")
    private WebElement profilePicture;
    @FindBy(xpath = "//span[text()='Удалить фотографию']")
    private WebElement deletePhoto;
    @FindBy(xpath = "//span[text()='Ещё']")
    private WebElement else_to_delete;

    public String getUserName() {
        return userMenu.getText(); }

    public void toPhotosPage() {
         new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(goToPhotos));
        goToPhotos.click(); }

    public void uploadPhoto(String path)
    {
        uploadPhotoBtn.sendKeys(path);
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(confirmProfilePicUpload));
        confirmProfilePicUpload.click();
    }

    public boolean checkIfPhotoUploaded()
    {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(avatar));
        return element != null;
    }

    public void deleteProfilePicture()
    {
        profilePicture.click();
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(else_to_delete));
        else_to_delete.click();
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(deletePhoto));
        deletePhoto.click();
    }

    @Override
    protected void check() {
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(goToPhotos));
        if(goToPhotos.isDisplayed()) {System.out.println("photos button is visible");}

        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(userMenu));
        if(userMenu.isDisplayed()) {System.out.println("user menu is visible");}

        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.visibilityOf(profilePicture));
        if(profilePicture.isDisplayed()) {System.out.println("profile pic is visible");}

        System.out.println("\n");
    }
}

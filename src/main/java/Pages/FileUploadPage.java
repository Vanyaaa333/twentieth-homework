package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FileUploadPage extends BasePage{

    protected final By HEADER_OF_FILE_UPLOADER_PAGE = By.cssSelector(".example");
    protected final By UPLOAD_BUTTON_LOCATOR = By.id("file-submit");
    protected final By FILE_UPLOAD_LOCATOR = By.id("file-upload");
    protected final By UPLOADED_FILE_LOCATOR = By.id("uploaded-files");
    public final String CONTEXT_MENU_PAGE_URN = "upload";
    public final String NAME_OF_UPLOADED_FILE = "14.png";

    public FileUploadPage(WebDriver driver, int timeOutInSeconds) {
        super(driver, timeOutInSeconds);
    }

    @Override
    public void isPageLoadedWaiter() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_OF_FILE_UPLOADER_PAGE));
    }

    public void loadingFile(){
        driver.findElement(FILE_UPLOAD_LOCATOR).sendKeys(System.getProperty("user.dir")+"\\14.png");
        driver.findElement(UPLOAD_BUTTON_LOCATOR).click();
    }

    public String isLoadedPictureRight(){
        return driver.findElement(UPLOADED_FILE_LOCATOR).getText();
    }

}

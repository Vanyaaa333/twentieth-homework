package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.List;

public class FileDownloadPage extends BasePage{

    protected final By HEADER_OF_FILE_DOWNLOADER_PAGE = By.xpath("//div[@class='example']//a");
    public final String FILE_DOWNLOAD_PAGE_URN = "download";

    public FileDownloadPage(WebDriver driver, int timeOutInSeconds) {
        super(driver, timeOutInSeconds);
    }

    @Override
    public void isPageLoadedWaiter() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_OF_FILE_DOWNLOADER_PAGE));
    }

    public String loadFile() throws InterruptedException {
        List<WebElement> list = driver.findElements(HEADER_OF_FILE_DOWNLOADER_PAGE);
        list.get(0).click();
        Thread.sleep(1000);
        return list.get(1).getText();
    }

    public boolean isFileLoaded(){
        File file = new File(System.getProperty("user.dir"));
        boolean actualResult = false;

        File f = new File(System.getProperty("user.dir")+"\\1.jpg");
        if(f.exists()){
            actualResult = true;
        }

        /*
        It's second method :

        String[] fileList = file.list();
        for (String el: fileList) {
            if(el.equals("1.jpg")){
                actualResult = true;
            }
        }
        */

        return actualResult;
    }

}

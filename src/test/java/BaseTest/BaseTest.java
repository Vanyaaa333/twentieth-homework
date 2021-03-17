package BaseTest;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

public class BaseTest {

    protected WebDriver driver;
    protected MainPage mainPage;
    protected ContextMenuPage contextMenuPage;
    protected DynamicControlsPage dynamicControlsPage;
    protected FileUploadPage fileUploaderPage;
    protected FramesPage framesPage;
    protected FileDownloadPage fileDownloadPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "E:\\Загрузки\\Driver1/chromedriver.exe");

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir"));

        ChromeOptions option = new ChromeOptions();
        option.setExperimentalOption("prefs",chromePrefs);
//        option.setHeadless(true);
        driver = new ChromeDriver(option);

        mainPage = new MainPage(driver,1);
        contextMenuPage = new ContextMenuPage(driver,1);
        dynamicControlsPage = new DynamicControlsPage(driver,1);
        fileUploaderPage = new FileUploadPage(driver,1);
        framesPage = new FramesPage(driver,1);
        fileDownloadPage = new FileDownloadPage(driver,1);
    }

    protected void successfulLoadingPage(BasePage page){
        Assert.assertTrue(page.isPageLoaded(),page.getClass().getSimpleName()+" isn't opened");
    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        driver.quit();
//    }
}



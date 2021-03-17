package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage{

    protected final By HEADER_OF_MAIN_PAGE = new By.ByCssSelector(".heading");

    public MainPage(WebDriver driver, int timeOutInSeconds) {
        super(driver, timeOutInSeconds);
    }

    @Override
    public void isPageLoadedWaiter() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_OF_MAIN_PAGE));
    }
}

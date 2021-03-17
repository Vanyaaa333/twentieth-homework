package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FramesPage extends BasePage{

    protected final By HEADER_OF_FRAMES_PAGE = By.cssSelector(".example");
    protected final By IFRAME_LOCATOR = By.id("mce_0_ifr");
    protected final By IFRAME_BODY_LOCATOR = By.id("tinymce");
    public final String IFRAME_PAGE_URN = "iframe";
    public final String FRAME_TEXT = "Your content goes here.";

    public FramesPage(WebDriver driver, int timeOutInSeconds) {
        super(driver, timeOutInSeconds);
    }

    @Override
    public void isPageLoadedWaiter() {
        explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_OF_FRAMES_PAGE));
    }

    public String getFrameText(){
        driver.switchTo().frame(driver.findElement(IFRAME_LOCATOR));
        return driver.findElement(IFRAME_BODY_LOCATOR).getText();
    }

}

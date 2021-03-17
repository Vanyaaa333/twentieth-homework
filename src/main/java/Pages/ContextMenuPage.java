package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContextMenuPage extends BasePage{

    protected final By HEADER_OF_CONTEXT_MENU_PAGE = By.cssSelector(".example");
    protected final By BOX_ON_CONTEXT_MENU_PAGE = By.id("hot-spot");
    public final String CONTEXT_MENU_PAGE_URN = "context_menu";
    public final String ALERT_TEXT = "You selected a context menu";
    private final Actions action = new Actions(driver) ;
    final WebDriverWait wait = new WebDriverWait(driver,3);

    public ContextMenuPage(WebDriver driver, int timeOutInSeconds) {
        super(driver, timeOutInSeconds);
    }

    @Override
    public void isPageLoadedWaiter() {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_OF_CONTEXT_MENU_PAGE));
    }

    public void rightClickOnBox(){
      action.contextClick(driver.findElement(BOX_ON_CONTEXT_MENU_PAGE)).perform();
    }

    public String validationAlertText(){
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            return driver.switchTo().alert().getText();
        }
        catch (TimeoutException e){
            return "null";
        }
    }

    public boolean closeAlert(){
        driver.switchTo().alert().accept();
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            return false;
        }
        catch (TimeoutException e){
            return true;
        }
    }

}

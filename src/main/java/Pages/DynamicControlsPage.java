package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicControlsPage extends BasePage{

    protected final By HEADER_OF_DYNAMIC_CONTROLS_PAGE = By.cssSelector(".example");
    protected final By CHECKBOX_LOCATOR = By.id("checkbox");
    protected final By DELETE_BUTTON_LOCATOR = By.cssSelector("[autocomplete]");
    protected final By INSCRIPTION_TEXT = By.id("message");
    protected final By INPUT_LOCATOR = By.cssSelector("[type='text']");
    protected final By ENABLE_BUTTON_LOCATOR = By.cssSelector("[onclick='swapInput()']");
    private static int isCheckboxExist;
    private final WebDriverWait wait = new WebDriverWait(driver,3);
    public final String DYNAMIC_CONTROLS_PAGE_URN = "dynamic_controls";


    public DynamicControlsPage(WebDriver driver, int timeOutInSeconds) {
        super(driver, timeOutInSeconds);
    }

    @Override
    public void isPageLoadedWaiter() {
            explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_OF_DYNAMIC_CONTROLS_PAGE));
    }

    public int findCheckBox(){
        isCheckboxExist = driver.findElements(CHECKBOX_LOCATOR).size();
        return isCheckboxExist;
    }

    public void clickDeleteBottom(){
        driver.findElement(DELETE_BUTTON_LOCATOR).click();
    }

    public boolean waitingInscription(){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(INSCRIPTION_TEXT));
            return true;
        }
        catch (TimeoutException e){
            return false;
        }
    }

    public boolean findInputElement(){
        return driver.findElement(INPUT_LOCATOR).isEnabled();
    }

    public void clickEnableBottom(){
        driver.findElement(ENABLE_BUTTON_LOCATOR).click();
    }

}

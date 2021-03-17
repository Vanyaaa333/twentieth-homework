package Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait explicitlyWait;

    public BasePage(WebDriver driver, int timeOutInSeconds) {
        this.driver = driver;
        this.explicitlyWait = new WebDriverWait(driver,timeOutInSeconds);
    }

    abstract public void isPageLoadedWaiter();
    
    public boolean isPageLoaded(){
            try {
               isPageLoadedWaiter();
                return true;
            }
            catch (TimeoutException e){
                return false;
            }
    }

    public void openPage(String urn){
        driver.get(PagesConstants.MAIN_PAGE_URL+urn);
    }

}

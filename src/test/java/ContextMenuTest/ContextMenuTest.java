package ContextMenuTest;

import BaseTest.BaseTest;
import Constants.TestsConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    @Test
    private void alertValidationTest(){
        contextMenuPage.openPage(contextMenuPage.CONTEXT_MENU_PAGE_URN);
        successfulLoadingPage(contextMenuPage);
        contextMenuPage.rightClickOnBox();
        Assert.assertEquals(contextMenuPage.validationAlertText(),contextMenuPage.ALERT_TEXT,"Alert isn't opened");
        Assert.assertTrue(contextMenuPage.closeAlert(),"Alert didn't close");
    }

}

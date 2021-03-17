package DynamicControlsTest;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {

    @Test
    private void dynamicControlsTest(){
        dynamicControlsPage.openPage(dynamicControlsPage.DYNAMIC_CONTROLS_PAGE_URN);
        successfulLoadingPage(dynamicControlsPage);
        dynamicControlsPage.clickDeleteBottom();
        Assert.assertTrue(dynamicControlsPage.waitingInscription(),"'It’s gone' inscription didn't appear");
        Assert.assertEquals(dynamicControlsPage.findCheckBox(),0,"Checkbox was found ");
        Assert.assertFalse(dynamicControlsPage.findInputElement(),"Input element is enable");
        dynamicControlsPage.clickEnableBottom();
        Assert.assertTrue(dynamicControlsPage.waitingInscription(),"'It's enabled!' inscription didn't appear");
        Assert.assertTrue(dynamicControlsPage.findInputElement(),"Input element isn't enable");
    }

}

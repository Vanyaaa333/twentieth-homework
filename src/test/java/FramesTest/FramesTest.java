package FramesTest;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    @Test
    private void getFrameTextTest(){
        framesPage.openPage(framesPage.IFRAME_PAGE_URN);
        successfulLoadingPage(framesPage);
        Assert.assertEquals(framesPage.getFrameText(),framesPage.FRAME_TEXT,
                "Received text isn't right");
    }

}

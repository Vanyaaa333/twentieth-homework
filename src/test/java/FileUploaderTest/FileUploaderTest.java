package FileUploaderTest;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploaderTest extends BaseTest {

    @Test
    private void fileUploaderTest(){
        fileUploaderPage.openPage(fileUploaderPage.CONTEXT_MENU_PAGE_URN);
        successfulLoadingPage(fileUploaderPage);
        fileUploaderPage.loadingFile();
        Assert.assertEquals(fileUploaderPage.isLoadedPictureRight(),fileUploaderPage.NAME_OF_UPLOADED_FILE,
                "Loaded picture isn't right");
    }

}

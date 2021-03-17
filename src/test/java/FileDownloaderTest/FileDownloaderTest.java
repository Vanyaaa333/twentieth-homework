package FileDownloaderTest;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileDownloaderTest extends BaseTest {

    @Test
    private void fileDownloadTest() throws InterruptedException {
        fileDownloadPage.openPage(fileDownloadPage.FILE_DOWNLOAD_PAGE_URN);
        successfulLoadingPage(fileDownloadPage);
        fileDownloadPage.loadFile();
        Assert.assertTrue(fileDownloadPage.isFileLoaded(),"File didn't load");
    }

}

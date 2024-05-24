package Tests;

import PageObjects.Bootstrap_ProgressBar;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bootstrap_ProgressBar_Test extends BaseTest {

    //Test for checking if the progress bar reaches 100% upon clicking the button
    @Test
    public void ProgressBarTest() {
        Bootstrap_ProgressBar progressBar = new Bootstrap_ProgressBar(driver);
        try {
            progressBar.goTo();
            Thread.sleep(5000);
            progressBar.clickDownloadBtn();
            Thread.sleep(21000);
            String progress = progressBar.checkProgress();
            Assert.assertEquals(progress, "100%", "Progress does not match the expected results.");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

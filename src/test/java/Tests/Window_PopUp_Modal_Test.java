package Tests;

import PageObjects.Window_PopUp_Modal;
import TestComponents.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;


public class Window_PopUp_Modal_Test extends BaseTest {

    WebDriverWait wait;

    //Testing if a new modal for Twitter is opened upon clicking
    @Test
    public void TwitterModal(){
        Window_PopUp_Modal twitterModal = new Window_PopUp_Modal(driver);
        try {
            twitterModal.goTo();
            Thread.sleep(5000);
            twitterModal.clickTwitterBtn();
            Thread.sleep(5000);
            twitterModal.switchWindow();
            Thread.sleep(5000);
            Boolean[] newModalResults = twitterModal.newModal();

            Boolean newWindowVisible = newModalResults[0];
            Boolean expectedResults = newModalResults[1];
            Assert.assertEquals(newWindowVisible, expectedResults,
                    "Twitter window is not opened.");

            twitterModal.backToMainWindow();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Testing if a new modal for Facebook is opened upon clicking
    @Test
    public void FacebookModal() {
        Window_PopUp_Modal facebookModal = new Window_PopUp_Modal(driver);
        try {
            facebookModal.goTo();
            Thread.sleep(5000);
            facebookModal.clickFacebookBtn();
            Thread.sleep(5000);
            facebookModal.switchWindow();
            Thread.sleep(5000);
            Boolean[] newModalResults = facebookModal.newModal();

            Boolean newWindowVisible = newModalResults[0];
            Boolean expectedResults = newModalResults[1];
            Assert.assertEquals(newWindowVisible, expectedResults,
                    "Facebook window is not opened.");

            facebookModal.backToMainWindow();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Testing if a new modal for Twitter and Facebook is opened upon clicking
    @Test
    public void multiWindowTwitterFB(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            Window_PopUp_Modal TwitterFacebook = new Window_PopUp_Modal(driver);
            TwitterFacebook.goTo();
            Thread.sleep(5000);
            TwitterFacebook.mainWindowHandle();
            Thread.sleep(5000);
            TwitterFacebook.clickFacebookTwitterBtn();
            Thread.sleep(5000);
            wait.until(ExpectedConditions.numberOfWindowsToBe(3));
            Set<String> allWindows = TwitterFacebook.WindowHandles();
            Assert.assertEquals(allWindows.size(), 3, "Both Twitter and Facebook windows were not opened.");
            TwitterFacebook.switchTwitterFB();
            Thread.sleep(5000);
            TwitterFacebook.closeWindow();
            Thread.sleep(5000);
            TwitterFacebook.backToMainWindow();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Testing if a new modal for Twitter, Facebook, and Google is opened upon clicking
    @Test
    public void multiWindowTwitterFBGoogle(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            Window_PopUp_Modal TwitterFacebookGoogle = new Window_PopUp_Modal(driver);
            TwitterFacebookGoogle.goTo();
            Thread.sleep(5000);
            TwitterFacebookGoogle.mainWindowHandle();
            Thread.sleep(5000);
            TwitterFacebookGoogle.clickFacebookTwitterGoogleBtn();
            Thread.sleep(5000);
            wait.until(ExpectedConditions.numberOfWindowsToBe(4));
            Set<String> allWindows = TwitterFacebookGoogle.WindowHandles();
            Assert.assertEquals(allWindows.size(), 4, "Three new windows were not opened.");
            TwitterFacebookGoogle.switchTwitterFBGoogle();
            Thread.sleep(5000);
            TwitterFacebookGoogle.backToMainWindow();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

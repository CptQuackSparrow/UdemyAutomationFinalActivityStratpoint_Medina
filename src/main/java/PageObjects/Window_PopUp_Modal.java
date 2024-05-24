package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class Window_PopUp_Modal extends AbstractComponent {
    WebDriver driver;

    static String mainWindowHandle;

    public Window_PopUp_Modal(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");
    }

    @FindBy(css = "a[title='Follow @seleniumeasy on Twitter']")
    WebElement launchTwitter;

    @FindBy(css = "a[title='Follow @seleniumeasy on Facebook']")
    WebElement launchFacebook;

    @FindBy(xpath = "//a[@title='Follow @seleniumeasy']")
    WebElement launchTwitterFacebook;

    @FindBy(css = "#followall")
    WebElement launchTwitterFacebookGoogle;

    @FindBy(xpath = "/html")
    WebElement newModal;

    WebDriverWait wait;

    public void clickTwitterBtn() throws InterruptedException{
        Thread.sleep(1000);
        launchTwitter.click();
    }

    public void clickFacebookBtn() throws InterruptedException{
        Thread.sleep(1000);
        launchFacebook.click();
    }

    public void clickFacebookTwitterBtn() throws InterruptedException{
        Thread.sleep(1000);
        launchTwitterFacebook.click();
    }

    public void clickFacebookTwitterGoogleBtn() throws InterruptedException{
        Thread.sleep(1000);
        launchTwitterFacebookGoogle.click();
    }

    public void switchWindow(){
        mainWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void mainWindowHandle()
    {
        mainWindowHandle = driver.getWindowHandle();
    }

    public Boolean[] newModal(){

        Boolean[] newModalResults = new Boolean[2];

        newModalResults[0] = newModal.isDisplayed();
        newModalResults[1] = true;
        return newModalResults;
    }

    public String WindowHandle()
    {
        String WindowHandle = driver.getWindowHandle();
        return WindowHandle;
    }

    public Set<String> WindowHandles()
    {
        Set<String> allWindows = driver.getWindowHandles();
        return allWindows;
    }

    public void backToMainWindow()
    {
        driver.switchTo().window(mainWindowHandle);
    }

    public void switchTwitterFB() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (String window : WindowHandles()) {
            if (!window.equals(mainWindowHandle)) {
                driver.switchTo().window(window);

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

                if (driver.getCurrentUrl().contains("twitter.com")) {
                } else if (driver.getCurrentUrl().contains("facebook.com")) {
                }
            }
        }
    }

    public void switchTwitterFBGoogle()
    {
        for (String window : WindowHandles()) {
            driver.switchTo().window(window);
            if (driver.getCurrentUrl().contains("twitter.com")) {
            } else if (driver.getCurrentUrl().contains("facebook.com")) {
            } else if (driver.getCurrentUrl().contains("plus.google.com")) {
            }
        }
    }

    public void closeWindow()
    {
        for (String window : WindowHandles()) {
            if (!window.equals(mainWindowHandle)) {
                driver.switchTo().window(window);
                driver.close();
            }
        }
    }
}

package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bootstrap_Modals extends AbstractComponent {

    WebDriver driver;

    public Bootstrap_Modals(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/bootstrap-modal-demo.html");
    }

    @FindBy(xpath = "(//a[@data-toggle='modal'][normalize-space()='Launch modal'])[1]")
    WebElement singleModalLaunchButton;

    @FindBy(css = "div[id='myModal0'] div[class='modal-body']")
    WebElement singleModal;

    @FindBy(xpath = "//*[@id=\"myModal0\"]/div/div/div[4]/a[1]")
    WebElement singleModalCloseBtn;

    @FindBy(css = "div[id='myModal0'] a[class='btn btn-primary']")
    WebElement singleModalSaveBtn;

    @FindBy(css = "a[href='#myModal']")
    WebElement firstMultiModalLaunchBtn;

    @FindBy(css = "div[class='modal-body'] a[class='btn btn-primary']")
    WebElement secondMultiModalLaunchBtn;

    @FindBy(css = "div[id='myModal'] div[class='modal-body']")
    WebElement firstMultiModal;

    @FindBy(css = "div[id='myModal2'] div[class='modal-body']")
    WebElement secondMultiModal;

    @FindBy(css = "div[id='myModal'] a[class='btn']")
    WebElement firstMultiModalCloseBtn;

    @FindBy(css = "div[id='myModal2'] a[class='btn']")
    WebElement secondMultiModalCloseBtn;

    @FindBy(css = "div[id='myModal'] div[class='modal-footer'] a[class='btn btn-primary']")
    WebElement firstMultiModalSaveBtn;

    @FindBy(css = "div[id='myModal2'] a[class='btn btn-primary']")
    WebElement secondMultiModalSaveBtn;

    public void launchSingleModal() throws InterruptedException {
        Thread.sleep(1000);
        singleModalLaunchButton.click();
    }

    public String viewSingleModal() throws InterruptedException {
        Thread.sleep(1000);
        singleModal.click();
        String modalMessage = singleModal.getText();
        return modalMessage;
    }

    public void clickSingleModalClose() throws InterruptedException {
        Thread.sleep(1000);
        singleModalCloseBtn.click();
    }

    public void clickSingleModalSave() throws InterruptedException {
        Thread.sleep(1000);
        singleModalSaveBtn.click();
    }

    public void launchFirstMultiModal() throws InterruptedException {
        Thread.sleep(1000);
        firstMultiModalLaunchBtn.click();
    }

    public void launchSecondMultiModal() throws InterruptedException {
        Thread.sleep(1000);
        secondMultiModalLaunchBtn.click();
    }

    public String viewFirstMultiModal() throws InterruptedException {
        Thread.sleep(1000);
        firstMultiModal.click();
        String firstModalMessage = firstMultiModal.getText();
        return firstModalMessage;
    }

    public String viewSecondMultiModal() throws InterruptedException {
        Thread.sleep(1000);
        secondMultiModal.click();
        String secondModalMessage = secondMultiModal.getText();
        return secondModalMessage;
    }

    public void closeFirstMultiModal() throws InterruptedException {
        Thread.sleep(1000);
        firstMultiModalCloseBtn.click();
    }

    public void closeSecondMultiModal() throws InterruptedException {
        Thread.sleep(1000);
        secondMultiModalCloseBtn.click();
    }

    public void saveFirstMultiModal() throws InterruptedException {
        Thread.sleep(1000);
        firstMultiModalSaveBtn.click();
    }

    public void saveSecondMultiModal() throws InterruptedException {
        Thread.sleep(1000);
        secondMultiModalSaveBtn.click();
    }
}
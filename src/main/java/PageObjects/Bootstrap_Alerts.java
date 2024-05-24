package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bootstrap_Alerts extends AbstractComponent {
    WebDriver driver;
    public Bootstrap_Alerts(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo()
    {
        driver.get("https://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html");
    }

    @FindBy(css = "#autoclosable-btn-success")
    WebElement autocloseSuccess;
    @FindBy(css = "#autoclosable-btn-warning")
    WebElement autocloseWarning;
    @FindBy(css = "#autoclosable-btn-danger")
    WebElement autocloseDanger;
    @FindBy(css = "#autoclosable-btn-info")
    WebElement autocloseInfo;

    @FindBy(css = "#normal-btn-success")
    WebElement normalSuccess;
    @FindBy(css = "#normal-btn-warning")
    WebElement normalWarning;
    @FindBy(css = "#normal-btn-danger")
    WebElement normalDanger;
    @FindBy(css = "#normal-btn-info")
    WebElement normalInfo;

    @FindBy(css = ".alert.alert-success.alert-autocloseable-success")
    WebElement autoSuccessDialog;
    @FindBy(css = ".alert.alert-warning.alert-autocloseable-warning")
    WebElement autoWarningDialog;
    @FindBy(css = ".alert.alert-danger.alert-autocloseable-danger")
    WebElement autoDangerDialog;
    @FindBy(css = ".alert.alert-info.alert-autocloseable-info")
    WebElement autoInfoDialog;

    @FindBy(css = ".alert.alert-success.alert-normal-success")
    WebElement normalSuccessDialog;
    @FindBy(css = ".alert.alert-warning.alert-normal-warning")
    WebElement normalWarningDialog;
    @FindBy(css = ".alert.alert-danger.alert-normal-danger")
    WebElement normalDangerDialog;
    @FindBy(css = ".alert.alert-info.alert-normal-info")
    WebElement normalInfoDialog;



    public void clickAutoCloseSuccess()
    {
        autocloseSuccess.click();
    }

    public void clickNormalSuccess()
    {
        normalSuccess.click();
    }

    public void clickAutoCloseWarning()
    {
        autocloseWarning.click();
    }

    public void clickNormalWarning()
    {
        normalWarning.click();
    }

    public void clickAutoCloseDanger()
    {
        autocloseDanger.click();
    }

    public void clickNormalDanger()
    {
        normalDanger.click();
    }

    public void clickAutoCloseInfo()
    {
        autocloseInfo.click();
    }

    public void clickNormalInfo()
    {
        normalInfo.click();
    }

    public String[] autoCloseSuccessDialog()
    {
        autoSuccessDialog.click();
        String[] elements = new String[2];
        elements[0] = autoSuccessDialog.getText();
        elements[1] = autoSuccessDialog.getCssValue("background-color");

        return elements;
    }

    public String[] normalSuccessDialog()
    {
        normalSuccessDialog.click();
        String[] elements = new String[2];
        elements[0] = normalSuccessDialog.getText();
        elements[1] = normalSuccessDialog.getCssValue("background-color");

        return elements;
    }

    public String[] autoCloseWarningDialog()
    {
        autoWarningDialog.click();
        String[] elements = new String[2];
        elements[0] = autoWarningDialog.getText();
        elements[1] = autoWarningDialog.getCssValue("background-color");

        return elements;
    }

    public String[] normalWarningDialog()
    {
        normalWarningDialog.click();
        String[] elements = new String[2];
        elements[0] = normalWarningDialog.getText();
        elements[1] = normalWarningDialog.getCssValue("background-color");

        return elements;
    }

    public String[] autoCloseDangerDialog() throws InterruptedException {
        Thread.sleep(2000);
        autoDangerDialog.click();
        String[] elements = new String[2];
        elements[0] = autoDangerDialog.getText();
        elements[1] = autoDangerDialog.getCssValue("background-color");

        return elements;
    }

    public String[] normalDangerDialog()
    {
        normalDangerDialog.click();
        String[] elements = new String[2];
        elements[0] = normalDangerDialog.getText();
        elements[1] = normalDangerDialog.getCssValue("background-color");

        return elements;
    }

    public String[] autoCloseInfoDialog()
    {
        autoInfoDialog.click();
        String[] elements = new String[2];
        elements[0] = autoInfoDialog.getText();
        elements[1] = autoInfoDialog.getCssValue("background-color");

        return elements;
    }

    public String[] normalInfoDialog()
    {
        normalInfoDialog.click();
        String[] elements = new String[2];
        elements[0] = normalInfoDialog.getText();
        elements[1] = normalInfoDialog.getCssValue("background-color");

        return elements;
    }
}

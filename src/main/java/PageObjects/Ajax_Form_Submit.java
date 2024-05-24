package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Ajax_Form_Submit extends AbstractComponent {
    WebDriver driver;

    public Ajax_Form_Submit(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/ajax-form-submit-demo.html");
    }

    @FindBy(css = "#title")
    WebElement nameField;

    @FindBy(css = "#description")
    WebElement descriptionBox;

    @FindBy(css = "#btn-submit")
    WebElement saveBtn;

    @FindBy(css = "#submit-control")
    WebElement submitMessage;

    public void inputData(String name, String desc)
    {
        nameField.sendKeys(name);
        descriptionBox.sendKeys(desc);
    }

    public void clickSaveBtn()
    {
        saveBtn.click();
    }

    public String viewSuccessMessage()
    {
        String successMessage = submitMessage.getText();
        return successMessage;

    }
}

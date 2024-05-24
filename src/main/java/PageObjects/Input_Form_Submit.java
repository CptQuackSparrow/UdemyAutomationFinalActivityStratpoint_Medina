package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Input_Form_Submit extends AbstractComponent {
    WebDriver driver;

    public Input_Form_Submit(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/input-form-demo.html");
    }

    @FindBy(css = "input[placeholder='First Name']")
    WebElement firstNameField;

    @FindBy(css = "input[placeholder='Last Name']")
    WebElement lastNameField;

    @FindBy(css = "input[placeholder='E-Mail Address']")
    WebElement emailAddressField;

    @FindBy(css = "input[placeholder='(845)555-1212']")
    WebElement phoneNumberField;

    @FindBy(css = "input[placeholder='Address']")
    WebElement addressField;

    @FindBy(css = "input[placeholder='city']")
    WebElement cityField;

    @FindBy(css = "select[name='state']")
    WebElement stateDropdown;

    @FindBy(css = "input[placeholder='Zip Code']")
    WebElement zipCodeField;

    @FindBy(css = "input[placeholder='Website or domain name']")
    WebElement websiteField;

    @FindBy(css = "input[value='no']")
    WebElement hostingCheckboxNo;

    @FindBy(css = "textarea[placeholder='Project Description']")
    WebElement projDescriptionField;

    @FindBy(css = "button[class='btn btn-default']")
    WebElement sendBtn;

    public void inputData(String fName, String lName, String email, String phoneNum, String address, String city, String zipCode, String website, String projDesc) throws InterruptedException {
        firstNameField.sendKeys(fName);
        lastNameField.sendKeys(lName);
        emailAddressField.sendKeys(email);
        phoneNumberField.sendKeys(phoneNum);
        addressField.sendKeys(address);
        Thread.sleep(1000);
        cityField.sendKeys(city);
        zipCodeField.sendKeys(zipCode);
        websiteField.sendKeys(website);
        projDescriptionField.sendKeys(projDesc);
    }
    public void stateSelect(String state)
    {
        hostingCheckboxNo.click();
        Select selectState = new Select(stateDropdown);
        selectState.selectByVisibleText(state);
    }

    public void checkboxSelect()
    {
        stateDropdown.click();
    }

    public void clickSendBtn()
    {
        sendBtn.click();
    }

    public boolean isSendBtnEnabled() {
        return sendBtn.isEnabled();
    }
}

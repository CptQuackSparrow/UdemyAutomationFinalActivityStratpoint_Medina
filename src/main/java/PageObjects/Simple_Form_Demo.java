package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Simple_Form_Demo extends AbstractComponent {
WebDriver driver;

    public Simple_Form_Demo(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo()
    {
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");
    }

    @FindBy(id = "user-message")
    WebElement userInputMessage;

    @FindBy(css = "button[onclick='showInput();']")
    WebElement showMessageBtn;

    @FindBy(css = "#display")
    WebElement displayMessage;

    @FindBy(id = "value1")
    WebElement value1Field;

    @FindBy(id = "value2")
    WebElement value2Field;

    @FindBy(css = "button[onclick='return total()']")
    WebElement getTotalBtn;

    @FindBy(css = "#displayvalue")
    WebElement displayTotal;

    public void inputMessage(String message) throws InterruptedException {
        userInputMessage.sendKeys(message);
    }

    public void inputValue1(Integer value1) throws InterruptedException {
        value1Field.sendKeys(""+value1);
    }

    public void inputValue2(Integer value2) throws InterruptedException {
        value2Field.sendKeys(""+value2);
    }

    public String showMessageBtn()
    {
        showMessageBtn.click();
        String returnedMessage = displayMessage.getText();
        return returnedMessage;
    }

    public String showTotalBtn()
    {
        getTotalBtn.click();
        String returnedTotal = displayTotal.getText();
        return returnedTotal;
    }
}

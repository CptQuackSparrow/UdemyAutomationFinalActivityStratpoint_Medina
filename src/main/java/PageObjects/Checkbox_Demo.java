package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Checkbox_Demo extends AbstractComponent {
    WebDriver driver;
    WebDriverWait wait;

    public Checkbox_Demo(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
    }

    @FindBy(css = "#isAgeSelected")
    WebElement singleCheckbox;

    @FindBy(id = "txtAge")
    WebElement singleCheckboxMessage;

    @FindBy(id = "check1")
    WebElement multipleCheckbox;

    public void singleCheckBoxTick() throws InterruptedException {
        Thread.sleep(2000);
        singleCheckbox.click();
    }

    public String displayMessage() {
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOf(singleCheckboxMessage));
        return messageElement.getText();
    }

    public String clickCheckAll()
    {
        multipleCheckbox.click();
        String textBoxTextChange = multipleCheckbox.getAttribute("value");
        return textBoxTextChange;
    }
}

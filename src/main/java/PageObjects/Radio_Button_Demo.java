package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Radio_Button_Demo extends AbstractComponent {
    WebDriver driver;

    public Radio_Button_Demo(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
    }

    @FindBy(css = "input[value='Male'][name='optradio']")
    WebElement singleMaleRadioButton;

    @FindBy(css = "input[value='Male'][name='gender']")
    WebElement groupMaleRadioButton;

    @FindBy(css = "input[value='15 - 50']")
    WebElement groupAgeRadioButton;

    @FindBy(css = "#buttoncheck")
    WebElement checkValue;

    @FindBy(css = "button[onclick='getValues();']")
    WebElement checkGroupValue;

    @FindBy(css = ".radiobutton")
    WebElement singleRadioButtonMessage;

    @FindBy(css = ".groupradiobutton")
    WebElement groupRadioButtonMessage;

    public void clickMaleRadioButton()
    {
        singleMaleRadioButton.click();
    }

    public void clickGroupMaleRadioButton()
    {
        groupMaleRadioButton.click();
    }

    public void clickGroupAgeRadioButton()
    {
        groupAgeRadioButton.click();
    }

    public void clickCheckAllButton()
    {
        checkValue.click();
    }

    public void clickGroupCheckAllButton()
    {
        checkGroupValue.click();
    }

    public String getRadioButtonMessage()
    {
        String radioMessage = singleRadioButtonMessage.getText();
        return radioMessage;
    }

    public String getGroupRadioButtonMessage()
    {
        String radioMessage = groupRadioButtonMessage.getText();
        return radioMessage;
    }

    public void RadioButton() {

        driver.findElement(By.xpath("//label[normalize-space()='Male']//input[@name='gender']")).click();
        driver.findElement(By.xpath("//input[@value='15 - 50']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Get values']")).click();

        String radioGender = driver.findElement(By.cssSelector(".groupradiobutton")).getText();
        Assert.assertTrue(radioGender.equals("Sex : Male\n" +
                "Age group: 15 - 50"));
        // Close the WebDriver
        driver.close();
    }
}

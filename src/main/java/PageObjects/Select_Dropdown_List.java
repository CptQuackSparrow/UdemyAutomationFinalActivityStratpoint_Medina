package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Select_Dropdown_List extends AbstractComponent {

    WebDriver driver;
    WebDriverWait wait;

    public Select_Dropdown_List(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
    }

    @FindBy(css = "#select-demo")
    WebElement dropDown;

    @FindBy(css = ".selected-value")
    WebElement selectListMessage;

    @FindBy(css = "#multi-select")
    WebElement multiSelectList;

    @FindBy(css = "#printMe")
    WebElement firstSelectedBtn;

    @FindBy(css = "#printAll")
    WebElement allSelectedBtn;

    @FindBy(css = ".getall-selected")
    WebElement SelectedMessage;

    public void selectDayFromList()
    {
        dropDown.click();
        Select dropdown = new Select(dropDown);
        dropdown.selectByVisibleText("Wednesday");
    }

    public void selectStatesFromList() {
        Select multiSelect = new Select(multiSelectList);
        if (multiSelect.isMultiple()) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Actions builder = new Actions(driver);
            builder.keyDown(Keys.CONTROL);

            WebElement ohioOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='Ohio']")));
            WebElement newJerseyOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='New Jersey']")));
            WebElement pennsylvaniaOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='Pennsylvania']")));

            builder.click(newJerseyOption)
                    .click(ohioOption)
                    .click(pennsylvaniaOption)
                    .keyUp(Keys.CONTROL)
                    .build()
                    .perform();
        }
    }


    public void clickFirstSelected()
    {
        firstSelectedBtn.click();
    }

    public void clickAllSelected()
    {
        allSelectedBtn.click();
    }

    public String getListMessage()
    {
        String listMessage = selectListMessage.getText();
        return listMessage;
    }

    public String getMultiListMessage()
    {
        String multiListMessage = SelectedMessage.getText();
        return multiListMessage;
    }
}

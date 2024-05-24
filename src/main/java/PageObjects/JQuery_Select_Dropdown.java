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

public class JQuery_Select_Dropdown extends AbstractComponent {
    WebDriver driver;
    WebDriverWait wait;

    public JQuery_Select_Dropdown(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/jquery-dropdown-search-demo.html");
    }

    @FindBy(css = "span[class='select2-search select2-search--dropdown'] input[role='textbox']")
    WebElement countrySearch;

    @FindBy(css = ".select2-results")
    WebElement countrySelect;

    @FindBy(css = "input[placeholder='Select state(s)']")
    WebElement multipleStatesSelect;

    @FindBy(css = "span[class='select2-search select2-search--dropdown'] input[role='textbox']")
    WebElement disabledDropdownSearch;

    @FindBy(css = ".select2-results")
    WebElement selectTerritory;

    @FindBy(css = "#files")
    WebElement filesDropdown;

    @FindBy(css = "#files > optgroup:nth-child(1) > option:nth-child(1)")
    WebElement selectedFile;

    @FindBy(css = ".select2.select2-container.select2-container--default.select2-container--below.select2-container--focus")
    WebElement countryDropDown;

    public void countryDropdownClick() throws InterruptedException {
        Thread.sleep(2000);
        WebElement stateDropdown = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[2]/" +
                "span/span[1]/span"));
        stateDropdown.click();
    }

    public void countrySearch()
    {
        countrySearch.sendKeys("Japan");
    }

    public void countrySelect()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        countrySelect.click();
    }

    public String countrySearchGetText()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String searchText = countryDropDown.getText();
        return searchText;
    }

    public void clickMultipleStates()
    {
        multipleStatesSelect.click();
    }

    public void findState()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String[] chosenStates = {"Arkansas", "Minnesota", "Wyoming"};

        for (String state : chosenStates)
        {
            WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > " +
                    "div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(3) " +
                    "> div > div.panel-body > span > span.selection > span > ul > li > input")));

            input.sendKeys(state);

            WebElement stateSelect = wait.until(ExpectedConditions.elementToBeClickable
                    (By.xpath("//li[contains(text(),'" + state + "')]")));

            stateSelect.click();

            WebElement selectedState = driver.findElement(By.xpath("//li[@title='" + state + "']"));
            Assert.assertTrue(selectedState.isDisplayed(), "State is not selected");
        }
    }

    public void clickDisabledDropDown()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement disabledDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(4) > div > div.panel-body > span > span.selection > span")));
        disabledDropdown.click();
    }

    public void searchTerritory()
    {
        disabledDropdownSearch.sendKeys("Virgin Islands");
    }

    public void selectTerritory()
    {
        selectTerritory.click();
    }

    public void filesDropDown()
    {
        filesDropdown.click();
    }

    public String selectFile()
    {
        selectedFile.click();
        String fileName = selectedFile.getText();
        return fileName;
    }
}

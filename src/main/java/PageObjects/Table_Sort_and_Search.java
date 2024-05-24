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
import java.util.List;

public class Table_Sort_and_Search extends AbstractComponent {

    WebDriver driver;

    public Table_Sort_and_Search(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
    }

    @FindBy(css = "input[type='search']")
    WebElement searchField;

    @FindBy(css = "tbody")
    WebElement filterResults;

    @FindBy(xpath = "//table[@id='example']//tbody//tr")
    List<WebElement> filteredResults;

    public void searchInfo(String searchQuery) {
        searchField.sendKeys(searchQuery);
    }

    public List<WebElement> filterTable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(filterResults));
        return filteredResults;
    }

    public List<WebElement> retrieveData(WebElement row) {
        return row.findElements(By.tagName("td"));
    }
}

package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DataList_Filter extends AbstractComponent {
    WebDriver driver;
    WebDriverWait wait;

    public DataList_Filter(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public void goTo()
    {
        driver.get("https://demo.seleniumeasy.com/data-list-filter-demo.html");
    }

    @FindBy(css = "#input-search")
    WebElement searchField;

    @FindBy(css = "div.searchable-container div[style='display: block;']")
    List<WebElement> dataList;

    public void searchInfo(String searchQuery)
    {
        searchField.sendKeys(searchQuery);
    }

    public List<WebElement> displayResults()
    {
        List<WebElement> searchResults = dataList;
        return searchResults;
    }

    public void clearSearch()
    {
        searchField.clear();
        searchField.sendKeys(Keys.BACK_SPACE);
    }
}

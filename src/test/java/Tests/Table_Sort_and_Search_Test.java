package Tests;

import PageObjects.Table_Sort_and_Search;
import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class Table_Sort_and_Search_Test extends BaseTest {

    //Testing for searching and verifying if results are sorted based on search query
    @Test
    public void SortAndSearch() {
        Table_Sort_and_Search sortAndSearch = new Table_Sort_and_Search(driver);
        try {
            sortAndSearch.goTo();
            Thread.sleep(5000);
            sortAndSearch.searchInfo("Software Engineer");
            Thread.sleep(5000);
            List<WebElement> rows = sortAndSearch.filterTable();
            for (WebElement row : rows) {
                List<WebElement> cells = sortAndSearch.retrieveData(row);
                String jobTitle = cells.get(1).getText();
                Assert.assertTrue(jobTitle.contains("Software Engineer"), "Filtered results do not match the expected results.");
            }
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

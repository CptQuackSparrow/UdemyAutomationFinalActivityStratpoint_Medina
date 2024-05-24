package Tests;

import PageObjects.DataList_Filter;
import TestComponents.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DataList_Filter_Test extends BaseTest {

    //Test for searching a user by Name
    @Test
    public void searchByName()
    {
        DataList_Filter dataFilter = new DataList_Filter(driver);
        try {
            dataFilter.goTo();
            Thread.sleep(5000);
            String name = "Arman";
            dataFilter.searchInfo(name);
            Thread.sleep(5000);
            List<WebElement> searchResults = dataFilter.displayResults();
            Assert.assertTrue(!searchResults.isEmpty(), "Search results are not filtered");
            dataFilter.clearSearch();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Test for searching a user by their phone number
    @Test
    public void searchByNumber()
    {
        DataList_Filter dataFilter = new DataList_Filter(driver);
        try {
            dataFilter.goTo();
            Thread.sleep(5000);
            String number = "444";
            dataFilter.searchInfo(number);
            Thread.sleep(5000);
            List<WebElement> searchResults = dataFilter.displayResults();
            Assert.assertTrue(!searchResults.isEmpty(), "Search results are not filtered");
            dataFilter.clearSearch();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Test for searching a user by their email
    @Test
    public void searchByEmail()
    {
        DataList_Filter dataFilter = new DataList_Filter(driver);
        try {
            dataFilter.goTo();
            Thread.sleep(5000);
            String email = "test2";
            dataFilter.searchInfo(email);
            Thread.sleep(5000);
            List<WebElement> searchResults = dataFilter.displayResults();
            Assert.assertTrue(!searchResults.isEmpty(), "Search results are not filtered");
            dataFilter.clearSearch();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

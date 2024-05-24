package Tests;

import PageObjects.Bootstrap_Date_Picker;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Bootstrap_Date_Picker_Test extends BaseTest {

    //Test for Selecting Date Today
    @Test
    public void selectDateToday()
    {
        Bootstrap_Date_Picker selectDate = new Bootstrap_Date_Picker(driver);
        try {
            selectDate.goTo();
            Thread.sleep(5000);
            selectDate.clickDatePicker();
            Thread.sleep(5000);
            selectDate.clickDateToday();
            Thread.sleep(5000);
            String actualToday = selectDate.getTodayDate();
            Thread.sleep(5000);
            Date currentDate = new Date();
            Thread.sleep(5000);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Thread.sleep(5000);
            String expectedToday = dateFormat.format(currentDate);
            Assert.assertTrue(actualToday.equals(expectedToday));
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Test for Selecting Date Range
    @Test
    public void selectDateRange()
    {
        Bootstrap_Date_Picker selectDateRange = new Bootstrap_Date_Picker(driver);
        try {
            selectDateRange.goTo();
            Thread.sleep(5000);
            selectDateRange.clickStartDateField();
            Thread.sleep(5000);
            String startDate = selectDateRange.selectStartDate();
            Thread.sleep(5000);
            selectDateRange.clickEndDateField();
            Thread.sleep(5000);
            String endDate = selectDateRange.selectEndDate();
            Assert.assertEquals(startDate, "13/05/2024");
            Assert.assertEquals(endDate, "17/05/2024");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

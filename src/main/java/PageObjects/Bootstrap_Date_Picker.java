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

public class Bootstrap_Date_Picker extends AbstractComponent {
    WebDriver driver;

    WebDriverWait wait;

    public Bootstrap_Date_Picker(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/bootstrap-date-picker-demo.html");
    }

    @FindBy(css = "input[placeholder='dd/mm/yyyy']")
    WebElement datePicker;

    @FindBy(css = "div[class='datepicker-days'] th[class='today']")
    WebElement dateToday;

    @FindBy(css = "input[placeholder='Start date']")
    WebElement startDateField;

    @FindBy(css = "tbody tr:nth-child(3) td:nth-child(2)")
    WebElement startDate;

    @FindBy(css = "input[placeholder='End date']")
    WebElement endDateField;

    @FindBy(css = "tbody tr:nth-child(3) td:nth-child(6)")
    WebElement endDate;

    public void clickDatePicker()
    {
        datePicker.click();
    }

    public void clickDateToday()
    {
        dateToday.click();
    }

    public String getTodayDate()
    {
        String today = datePicker.getText();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(datePicker, "value", today));
        String dateToday = datePicker.getAttribute("value");
        return dateToday;
    }

    public void clickStartDateField()
    {
        startDateField.click();
    }

    public void clickEndDateField()
    {
        endDateField.click();
    }

    public String selectStartDate()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        startDate.click();
        String start = startDateField.getText();
        wait.until(ExpectedConditions.attributeContains(startDateField, "value", ""+start));
        String selectedDateRange1 = startDateField.getAttribute("value");
        return selectedDateRange1;
    }

    public String selectEndDate()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        endDate.click();
        String end = endDateField.getText();
        wait.until(ExpectedConditions.attributeContains(endDateField, "value", ""+end));
        String selectedDateRange2 = endDateField.getAttribute("value");
        return selectedDateRange2;
    }

    public void JQueryDropdown() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement dateRange1 = driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[1]"));
        dateRange1.click();
        WebElement date1 = driver.findElement(By.xpath("//td[@class='day' and text()='8']"));
        date1.click();

        WebElement dateRange2 = driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[2]"));
        dateRange2.click();
        WebElement date2 = driver.findElement(By.xpath("//td[@class='day' and text()='17']"));
        date2.click();

        // Wait for both dates to be selected
        wait.until(ExpectedConditions.attributeContains(dateRange1, "value", "08/05/2024"));
        wait.until(ExpectedConditions.attributeContains(dateRange2, "value", "17/05/2024"));

        // Assert the selected date range
        String selectedDateRange1 = dateRange1.getAttribute("value");
        String selectedDateRange2 = dateRange2.getAttribute("value");
        Assert.assertEquals(selectedDateRange1, "08/05/2024");
        Assert.assertEquals(selectedDateRange2, "17/05/2024");

        driver.close();
    }
}

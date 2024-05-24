package Tests;
import PageObjects.*;
import PageObjects.Table_Sort_and_Search;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;


public class StandAloneTest {

    static WebDriver driver;

    //Compilation of all tests

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        //Simple Form Demo
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        String message = "I am Stef :)";
        driver.findElement(By.id("user-message")).sendKeys(message);
        driver.findElement(By.id("userPassword")).sendKeys("QATesting123!");
        driver.findElement(By.xpath("//button[normalize-space()='Show Message']")).click();

        String confirmMessage = driver.findElement(By.id("display")).getText();
        Assert.assertTrue(confirmMessage.equals("I am Stef :)"));

        Integer a = 1;
        Integer b = 2;
        driver.findElement(By.id("value1")).sendKeys("" + a);
        driver.findElement(By.id("value2")).sendKeys("" + b);
        driver.findElement(By.xpath("//button[normalize-space()='Get Total']")).click();

        confirmMessage = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(5) > div:nth-child(2) > div:nth-child(4) > label:nth-child(1)")).getText();
        Assert.assertFalse(confirmMessage.equals("Total a + b = " + (a + b)));


        //Checkbox Demo
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");

        driver.findElement(By.id("isAgeSelected")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String confirmAge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtAge"))).getText();
        Assert.assertEquals("Success - Check box is checked", confirmAge);

        WebElement button = driver.findElement(By.id("check1"));
        button.click();

        String buttonText = button.getAttribute("value");

        Assert.assertEquals(buttonText, "Uncheck All", "Text does not match");


        //Radio Button demo
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");

        driver.findElement(By.xpath("//label[normalize-space()='Male']//input[@name='optradio']")).click();
        driver.findElement(By.id("buttoncheck")).click();

        String radioClick = driver.findElement(By.cssSelector(".radiobutton")).getText();
        Assert.assertTrue(radioClick.equals("Radio button 'Male' is checked"));

        driver.findElement(By.xpath("//label[normalize-space()='Male']//input[@name='gender']")).click();
        driver.findElement(By.xpath("//input[@value='15 - 50']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Get values']")).click();

        String radioGender = driver.findElement(By.cssSelector(".groupradiobutton")).getText();
        Assert.assertTrue(radioGender.equals("Sex : Male\n" +
                "Age group: 15 - 50"));

        //Select Dropdown
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");

        WebElement dropdownElement = driver.findElement(By.id("select-demo"));
        dropdownElement.click();

        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Wednesday");

        WebElement selectedDropdown = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[2]"));
        String dropdownMessage = selectedDropdown.getText();
        Assert.assertTrue(dropdownMessage.equals("Day selected :- Wednesday"));

        WebElement multiSelectElement = driver.findElement(By.id("multi-select"));
        Select multiSelect = new Select(multiSelectElement);
        multiSelect.selectByVisibleText("New York");
        multiSelect.selectByVisibleText("Ohio");
        multiSelect.selectByVisibleText("Texas");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Input Form Demo
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/input-form-demo.html");

        String firstName = "Stefano";
        String lastName = "Medina";
        String email = "stefanomedina@email.com";
        String phoneNum = "(111)222-3333";
        String address = "Lagunaaa";
        String city = "San Binan";
        String zipCode = "4003";
        String domain = "website.com";
        String projDesc = "QA Testing";

        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@placeholder='E-Mail Address']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@placeholder='(845)555-1212']")).sendKeys(phoneNum);
        driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys(address);
        driver.findElement(By.xpath("//input[@placeholder='city']")).sendKeys(city);

        WebElement stateDropdown = driver.findElement(By.cssSelector("select[name='state']"));
        stateDropdown.click();

        Select selectState = new Select(stateDropdown);
        selectState.selectByVisibleText("New York");
        driver.findElement(By.xpath("//input[@placeholder='Zip Code']")).sendKeys(zipCode);
        driver.findElement(By.xpath("//input[@placeholder='Website or domain name']")).sendKeys(domain);
        driver.findElement(By.xpath("//input[@value='no']")).click();
        driver.findElement(By.xpath("//textarea[@placeholder='Project Description']")).sendKeys(projDesc);
        driver.findElement(By.cssSelector(".glyphicon.glyphicon-send")).click();

        driver.findElement(By.xpath("//button[normalize-space()='Send']")).click();

        //Ajax Form Submit
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/ajax-form-submit-demo.html");

        firstName = "Stefano";
        String comment = "Medina";

        driver.findElement(By.id("title")).sendKeys(firstName);
        driver.findElement(By.id("description")).sendKeys(comment);
        driver.findElement(By.id("btn-submit")).click();

        Thread.sleep(5000);
        String successMessage = driver.findElement(By.id("submit-control")).getText();
        Assert.assertTrue(successMessage.equals("Form submited Successfully!"));

        //JQuery Select Dropwdown
        driver.manage().window().maximize();

        driver.get("https://demo.seleniumeasy.com/jquery-dropdown-search-demo.html");

        stateDropdown = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[2]/" +
                "span/span[1]/span"));
        stateDropdown.click();

        WebElement stateSearch = driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']" +
                "//input[@role='textbox']"));
        stateSearch.sendKeys("Japan");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropDownItem = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#select2-country-results > li")));
        dropDownItem.click();

        WebElement multiSelectState = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/span/span[1]/span/ul/li/input"));
        multiSelectState.click();

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

        WebElement disabledDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.container-fluid.text-center > div > div.col-md-6.text-left > div:nth-child(4) > div > div.panel-body > span > span.selection > span")));
        disabledDropdown.click();

        WebElement territory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > span > span > span.select2-search.select2-search--dropdown > input")));
        territory.sendKeys("Virgin Islands");

        WebElement selectTerritory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/span/span/span[2]")));
        selectTerritory.click();

        WebElement fileDropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"files\"]")));
        fileDropDown.click();

        WebElement file = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#files > optgroup:nth-child(1) > option:nth-child(1)")));
        file.click();

        Assert.assertEquals(file.getText(), "Python", "Selected category is not Java");

        fileDropDown.click();

        //Bootstrap DatePicker
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/bootstrap-date-picker-demo.html");

        WebElement datePicker = driver.findElement(By.xpath("//*[@id=\"sandbox-container1\"]/div/input"));
        datePicker.click();
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tfoot/tr[1]/th")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(datePicker, "value", "08/05/2024"));

        String dateToday = datePicker.getAttribute("value");
        Assert.assertTrue(dateToday.equals("08/05/2024"));

        WebElement dateRange1 = driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[1]"));
        dateRange1.click();
        WebElement date1 = driver.findElement(By.xpath("//td[@class='day' and text()='8']"));
        date1.click();

        WebElement dateRange2 = driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[2]"));
        dateRange2.click();
        WebElement date2 = driver.findElement(By.xpath("//td[@class='day' and text()='17']"));
        date2.click();

        wait.until(ExpectedConditions.attributeContains(dateRange1, "value", "08/05/2024"));
        wait.until(ExpectedConditions.attributeContains(dateRange2, "value", "17/05/2024"));

        String selectedDateRange1 = dateRange1.getAttribute("value");
        String selectedDateRange2 = dateRange2.getAttribute("value");
        Assert.assertEquals(selectedDateRange1, "08/05/2024");
        Assert.assertEquals(selectedDateRange2, "17/05/2024");

        //Table Sort&Search
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");

        WebElement searchInput = driver.findElement(By.xpath("//input[@type='search']"));
        searchInput.sendKeys("Software Engineer");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody")));

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='example']//tbody//tr"));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String jobTitle = cells.get(1).getText(); // Assuming job title is in the third column (index starts from 0)
            Assert.assertTrue(jobTitle.contains("Software Engineer"), "Filtered results do not match the expected results.");
        }

        //Bootstrap Progress Bar
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html");

        // Enter search keyword
        WebElement startDownload = driver.findElement(By.id("cricle-btn"));
        startDownload.click();

        Thread.sleep(21000);
        WebElement finishedProgress = driver.findElement(By.xpath("//*[@id=\"circle\"]/div/div[1]"));
        String progress = finishedProgress.getText();
        Assert.assertEquals(progress, "100%", "Progress does not match the expected results.");

        //Bootstrap Alerts
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement autocloseSuccess = driver.findElement(By.id("autoclosable-btn-success"));
        autocloseSuccess.click();

        WebElement autoSuccessDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[1]")));
        String autoSuccessMessage = autoSuccessDialog.getText();
        String autoSuccessColor = autoSuccessDialog.getCssValue("background-color");
        Assert.assertEquals(Color.fromString(autoSuccessColor).asHex(), "#dff0d8", "Color does not match");
        Assert.assertEquals(autoSuccessMessage, "I'm an autocloseable success message. I will hide in 5 seconds.",
                "Message does not match the expected results.");


        WebElement normalSuccess = driver.findElement(By.id("normal-btn-success"));
        normalSuccess.click();

        WebElement normalSuccessDialog = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]"));
        String normalSuccessMessage = normalSuccessDialog.getText();
        String normalSuccessColor = normalSuccessDialog.getCssValue("background-color");
        Assert.assertEquals(Color.fromString(normalSuccessColor).asHex(), "#dff0d8", "Color does not match");
        Assert.assertEquals(normalSuccessMessage, "×\n" +
                "I'm a normal success message. To close use the appropriate button.", "Message does not match the expected results.");


        WebElement autocloseWarning = driver.findElement(By.id("autoclosable-btn-warning"));
        autocloseWarning.click();

        WebElement autoWarningDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]")));
        String autoWarningMessage = autoWarningDialog.getText();
        String autoWarningColor = autoWarningDialog.getCssValue("background-color");
        Assert.assertEquals(Color.fromString(autoWarningColor).asHex(), "#fcf8e3", "Color does not match");
        Assert.assertEquals(autoWarningMessage, "I'm an autocloseable warning message. I will hide in 3 seconds.",
                "Message does not match the expected results.");

        WebElement normalWarning = driver.findElement(By.id("normal-btn-warning"));
        normalWarning.click();

        WebElement normalWarningDialog = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[4]"));
        String normalWarningMessage = normalWarningDialog.getText();
        String normalWarningColor = normalWarningDialog.getCssValue("background-color");
        Assert.assertEquals(Color.fromString(normalWarningColor).asHex(), "#fcf8e3", "Color does not match");
        Assert.assertEquals(normalWarningMessage, "×\n" +
                "I'm a normal warning message. To close use the appropriate button.", "Message does not match the expected results.");

        WebElement autocloseDanger = driver.findElement(By.id("autoclosable-btn-danger"));
        autocloseDanger.click();

        WebElement autoDangerDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[5]")));
        String autoDangerMessage = autoDangerDialog.getText();
        String autoDangerColor = autoDangerDialog.getCssValue("background-color");
        Assert.assertEquals(Color.fromString(autoDangerColor).asHex(), "#f2dede", "Color does not match");
        Assert.assertEquals(autoDangerMessage, "I'm an autocloseable danger message. I will hide in 5 seconds.",
                "Message does not match the expected results.");

        WebElement normalDanger = driver.findElement(By.id("normal-btn-danger"));
        normalDanger.click();

        WebElement normalDangerDialog = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[6]"));
        String normalDangerMessage = normalDangerDialog.getText();
        String normalDangerColor = normalDangerDialog.getCssValue("background-color");
        Assert.assertEquals(Color.fromString(normalDangerColor).asHex(), "#f2dede", "Color does not match");
        Assert.assertEquals(normalDangerMessage, "×\n" +
                "I'm a normal danger message. To close use the appropriate button.", "Message does not match the expected results.");

        WebElement autocloseInfo = driver.findElement(By.id("autoclosable-btn-info"));
        autocloseInfo.click();

        WebElement autoInfoDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[7]")));
        String autoInfoMessage = autoInfoDialog.getText();
        String autoInfoColor = autoInfoDialog.getCssValue("background-color");
        Assert.assertEquals(Color.fromString(autoInfoColor).asHex(), "#d9edf7", "Color does not match");
        Assert.assertEquals(autoInfoMessage, "I'm an autocloseable info message. I will hide in 6 seconds.",
                "Message does not match the expected results.");

        WebElement normalInfo = driver.findElement(By.id("normal-btn-info"));
        normalInfo.click();

        WebElement normalInfoDialog = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]"));
        String normalInfoMessage = normalInfoDialog.getText();
        String normalInfoColor = normalInfoDialog.getCssValue("background-color");
        Assert.assertEquals(Color.fromString(normalInfoColor).asHex(), "#d9edf7", "Color does not match");
        Assert.assertEquals(normalInfoMessage, "×\n" +
                "I'm a normal info message. To close use the appropriate button.", "Message does not match the expected results.");



        //Bootstrap Modals
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/bootstrap-modal-demo.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement singleModalLaunchButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div/div[2]/a"));
        singleModalLaunchButton.click();
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myModal0\"]/div/div/div[3]")));
        String modalMessage = modal.getText();
        Assert.assertEquals(modalMessage, "This is the place where the content for the modal dialog displays",
                "Message does not match the expected results.");

        WebElement singleModalClose = driver.findElement(By.xpath("//*[@id=\"myModal0\"]/div/div/div[4]/a[1]"));
        singleModalClose.click();

        singleModalLaunchButton.click();
        modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myModal0\"]/div/div/div[3]")));
        modalMessage = modal.getText();
        Assert.assertEquals(modalMessage, "This is the place where the content for the modal dialog displays",
                "Message does not match the expected results.");

        WebElement singleModalSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myModal0\"]/div/div/div[4]/a[2]")));
        singleModalSave.click();

        WebElement multipleModalLaunchBtn1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/a"));
        multipleModalLaunchBtn1.click();
        modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myModal\"]/div/div/div[3]")));
        modalMessage = modal.getText();
        Assert.assertEquals(modalMessage, "This is the place where the content for the modal dialog displays.\n" +
                "\n" +
                "Click launch modal button to launch second modal.\n" +
                "Click close link to close the modal.\n" +
                "Clicking on Save Changes button will close the modal and refresh the page\n" +
                "\n" +
                "Launch modal");

        WebElement multipleModalCloseBtn1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myModal\"]/div/div/div[4]/a[1]")));
        multipleModalCloseBtn1.click();

        multipleModalLaunchBtn1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/a"));
        multipleModalLaunchBtn1.click();
        modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myModal\"]/div/div/div[3]")));
        modalMessage = modal.getText();
        Assert.assertEquals(modalMessage, "This is the place where the content for the modal dialog displays.\n" +
                "\n" +
                "Click launch modal button to launch second modal.\n" +
                "Click close link to close the modal.\n" +
                "Clicking on Save Changes button will close the modal and refresh the page\n" +
                "\n" +
                "Launch modal");

        WebElement multipleModalSaveBtn1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myModal\"]/div/div/div[4]/a[2]")));
        multipleModalSaveBtn1.click();

        multipleModalLaunchBtn1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/a"));
        multipleModalLaunchBtn1.click();
        WebElement multipleModalLaunchBtn2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myModal\"]/div/div/div[3]/a")));
        multipleModalLaunchBtn2.click();
        modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myModal2\"]/div/div/div[5]")));
        modalMessage = modal.getText();
        Assert.assertEquals(modalMessage, "This is the place where the content for the modal dialog displays.");

        WebElement multipleModalCloseBtn2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myModal2\"]/div/div/div[6]/a[1]")));
        multipleModalCloseBtn2.click();

        multipleModalLaunchBtn2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myModal\"]/div/div/div[3]/a")));
        multipleModalLaunchBtn2.click();
        modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myModal2\"]/div/div/div[5]")));
        modalMessage = modal.getText();
        Assert.assertEquals(modalMessage, "This is the place where the content for the modal dialog displays.");

        WebElement multipleModalSaveBtn2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myModal2\"]/div/div/div[6]/a[2]")));
        multipleModalSaveBtn2.click();



        //Window PopUp Modal
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/window-popup-modal-demo.html");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String mainWindowHandle = driver.getWindowHandle();

        WebElement twitterLaunch = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[2]/div[1]/a"));
        twitterLaunch.click();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html")));
        Boolean twitterVisible = modal.isDisplayed();
        Boolean expectedResult = true;
        Assert.assertEquals(twitterVisible, expectedResult,
                "Twitter window is not opened.");

        driver.close();

        driver.switchTo().window(mainWindowHandle);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        mainWindowHandle = driver.getWindowHandle();

        WebElement facebookLaunch = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/a"));
        facebookLaunch.click();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html")));
        Boolean facebookVisible = modal.isDisplayed();
        expectedResult = true;
        Assert.assertEquals(facebookVisible, expectedResult,
                "Facebook window is not opened.");

        driver.close();
        driver.switchTo().window(mainWindowHandle);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        mainWindowHandle = driver.getWindowHandle();

        WebElement followButton = driver.findElement(By.xpath("//a[@title='Follow @seleniumeasy']"));

        followButton.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        Set<String> allWindows = driver.getWindowHandles();

        Assert.assertEquals(allWindows.size(), 3, "Both Twitter and Facebook windows were not opened.");

        for (String window : allWindows) {
            if (!window.equals(mainWindowHandle)) {
                driver.switchTo().window(window);

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

                if (driver.getCurrentUrl().contains("twitter.com")) {
                } else if (driver.getCurrentUrl().contains("facebook.com")) {
                }
            }
        }

        for (String window : allWindows) {
            if (!window.equals(mainWindowHandle)) {
                driver.switchTo().window(window);
                driver.close();
            }
        }

        driver.switchTo().window(mainWindowHandle);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        mainWindowHandle = driver.getWindowHandle();
        followButton = driver.findElement(By.xpath("//a[@id='followall']"));

        followButton.click();

        allWindows = driver.getWindowHandles();

        Assert.assertEquals(allWindows.size(), 4, "Three new windows were not opened.");

        for (String window : allWindows) {
            driver.switchTo().window(window);
            if (driver.getCurrentUrl().contains("twitter.com")) {
            } else if (driver.getCurrentUrl().contains("facebook.com")) {
            } else if (driver.getCurrentUrl().contains("plus.google.com")) {
            }
        }

        driver.close();
        driver.switchTo().window(mainWindowHandle);


        //Bootstrap Listbox
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/bootstrap-dual-list-box-demo.html");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement singleLeftElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[3]"));
        singleLeftElement.click();
        WebElement transferRightBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button[2]"));
        transferRightBtn.click();
        WebElement transferredElement = driver.findElement(By.cssSelector(".list-group-item.active"));
        transferredElement.click();
        Assert.assertTrue(driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/ul/li[3]")).isEmpty(), "Element not transferred to the right list");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement singleRightElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[3]/div/ul/li[1]"));
        singleRightElement.click();
        WebElement transferLeftBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button[1]"));
        transferLeftBtn.click();
        transferredElement = driver.findElement(By.cssSelector(".list-group-item.active"));
        transferredElement.click();
        Assert.assertFalse(driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[1]")).isEmpty(), "Element not transferred to the left list");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement allLeftElement = driver.findElement(By.xpath("//*[@id=\"listhead\"]/div[2]/div/a"));
        allLeftElement.click();
        transferRightBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button[2]"));
        transferRightBtn.click();
        Assert.assertFalse(driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/ul/li")).size() > 0, "All elements not transferred to the right list");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement allRightElement = driver.findElement(By.xpath("//*[@id=\"listhead\"]/div[1]/div/a"));
        allRightElement.click();
        transferLeftBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button[1]"));
        transferLeftBtn.click();
        Assert.assertTrue(driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li")).size() > 0, "All elements not transferred to the left list");


        //Data List Filter
        driver.manage().window().maximize();
        driver.get("https://demo.seleniumeasy.com/data-list-filter-demo.html");

        WebElement searchField = driver.findElement(By.id("input-search"));
        searchField.sendKeys("Arman");

        List<WebElement> searchResults = driver.findElements(By.cssSelector("div.searchable-container div[style='display: block;']"));

        Assert.assertTrue(!searchResults.isEmpty(), "Search results are not filtered");

        searchField.clear();
        searchField.sendKeys(Keys.BACK_SPACE);

        searchField = driver.findElement(By.id("input-search"));
        searchField.sendKeys("444");

        searchResults = driver.findElements(By.cssSelector("div.searchable-container div[style='display: block;']"));

        Assert.assertTrue(!searchResults.isEmpty(), "Search results are not filtered");

        searchField.clear();
        searchField.sendKeys(Keys.BACK_SPACE);

        searchField = driver.findElement(By.id("input-search"));
        searchField.sendKeys("test2");

        searchResults = driver.findElements(By.cssSelector("div.searchable-container div[style='display: block;']"));

        Assert.assertTrue(!searchResults.isEmpty(), "Search results are not filtered");

        searchField.clear();
        searchField.sendKeys(Keys.BACK_SPACE);
    }
}

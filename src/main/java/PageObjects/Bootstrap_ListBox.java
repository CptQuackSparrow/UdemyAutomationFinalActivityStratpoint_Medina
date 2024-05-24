package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Bootstrap_ListBox extends AbstractComponent {
    WebDriver driver;
    WebDriverWait wait;

    public Bootstrap_ListBox(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://demo.seleniumeasy.com/bootstrap-dual-list-box-demo.html");
    }

    @FindBy(css = "div[class='dual-list list-left col-md-5'] li:nth-child(3)")
    WebElement singleLeftElement;

    @FindBy(css = ".btn.btn-default.btn-sm.move-right")
    WebElement transferRightBtn;

    @FindBy(css = "div[class='dual-list list-right col-md-5'] li:nth-child(3)")
    WebElement singleRightElement;

    @FindBy(css = ".btn.btn-default.btn-sm.move-left")
    WebElement transferLeftBtn;

    @FindBy(xpath = "//div[@class='well text-right']//a[@title='select all']")
    WebElement selectAllLeftBtn;

    @FindBy(xpath = "//div[@class='well']//a[@title='select all']")
    WebElement selectAllRightBtn;

    @FindBy(css = ".list-group-item.active")
    WebElement transferredElement;


    public void selectLeftElement()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        singleLeftElement.click();
    }

    public void clickTransferRight()
    {
        transferRightBtn.click();
    }

    public void selectRightElement()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        singleRightElement.click();
    }

    public void clickTransferLeft()
    {
        transferLeftBtn.click();
    }

    public void selectAllRight()
    {
        selectAllRightBtn.click();
    }

    public void selectAllLeft()
    {
        selectAllLeftBtn.click();
    }

    public boolean transferElement()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        transferredElement.click();
        return false;
    }

    public void transferAllLeftToRight()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement allLeftElement = driver.findElement(By.xpath("//*[@id=\"listhead\"]/div[2]/div/a"));
        allLeftElement.click();
        WebElement transferRightBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button[2]"));
        transferRightBtn.click();
        Assert.assertFalse(driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/ul/li")).size() > 0, "All elements not transferred to the right list");
    }
    public void transferAllRightToLeft()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement allRightElement = driver.findElement(By.xpath("//*[@id=\"listhead\"]/div[1]/div/a"));
        allRightElement.click();
        WebElement transferLeftBtn = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button[1]"));
        transferLeftBtn.click();
        Assert.assertTrue(driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li")).size() > 0, "All elements not transferred to the left list");

    }

}

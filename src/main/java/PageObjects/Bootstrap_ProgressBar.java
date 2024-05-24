package PageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bootstrap_ProgressBar extends AbstractComponent {

    WebDriver driver;

    public Bootstrap_ProgressBar(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo()
    {
        driver.get("https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html");
    }

    @FindBy(css = "#cricle-btn")
    WebElement downloadButton;

    @FindBy(css = ".percenttext")
    WebElement progressBar;

    public void clickDownloadBtn() throws InterruptedException {
        Thread.sleep(1000);
        downloadButton.click();
    }

    public String checkProgress()
    {
        String progress = progressBar.getText();
        return progress;
    }
}

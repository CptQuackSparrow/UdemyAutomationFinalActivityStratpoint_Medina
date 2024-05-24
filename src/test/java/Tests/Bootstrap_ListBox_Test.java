package Tests;

import PageObjects.Bootstrap_ListBox;
import TestComponents.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bootstrap_ListBox_Test extends BaseTest {

    //Test for Transferring Single Element from Left to Right
    @Test
    public void transferLeftToRight()
    {
        Bootstrap_ListBox listBox = new Bootstrap_ListBox(driver);
        try {
            listBox.goTo();
            Thread.sleep(5000);
            listBox.selectLeftElement();
            Thread.sleep(5000);
            listBox.clickTransferRight();
            Thread.sleep(5000);
            listBox.transferElement();
            Assert.assertTrue(driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/ul/li[3]")).isEmpty(),
                    "Element not transferred to the right list");
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Test for Transferring Single Element from Right to Left
    @Test
    public void transferRightToLeft()
    {
        Bootstrap_ListBox listBox = new Bootstrap_ListBox(driver);
        try {
            listBox.goTo();
            Thread.sleep(5000);
            listBox.selectRightElement();
            Thread.sleep(5000);
            listBox.clickTransferLeft();
            Thread.sleep(5000);
            listBox.transferElement();
            Assert.assertFalse(driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/div/div" +
                            "[1]/div/ul/li[1]")).isEmpty(),
                    "Element not transferred to the left list");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Test for Transferring All Elements from Right to Left
    @Test
    public void transferAllRightToLeft()
    {
        Bootstrap_ListBox listBox = new Bootstrap_ListBox(driver);
        try {
            listBox.goTo();
            Thread.sleep(5000);
            listBox.selectAllRight();
            Thread.sleep(5000);
            listBox.clickTransferLeft();
            Thread.sleep(5000);
            Assert.assertTrue(driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/" +
                            "div/div[1]/div/ul/li")).size() > 0,
                    "All elements not transferred to the left list");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Test for Transferring All Elements from Left to Right
    @Test
    public void transferAllLeftToRight() throws InterruptedException {
        Bootstrap_ListBox listBox = new Bootstrap_ListBox(driver);
        try {
            listBox.goTo();
            Thread.sleep(5000);
            listBox.selectAllLeft();
            Thread.sleep(5000);
            listBox.clickTransferRight();
            Thread.sleep(5000);
            Assert.assertFalse(driver.findElements(By.xpath("/html/body/div[2]/div/div[2]/" +
                            "div/div[2]/div/ul/li")).size() > 0,
                    "All elements not transferred to the right list");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

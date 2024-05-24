package Tests;

import PageObjects.Checkbox_Demo;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkbox_Demo_Test extends BaseTest {

    //Test for checking if a single checkbox is clicked/ticked
    @Test
    public void singleCheckBoxTest() {
        Checkbox_Demo singleCheckBox = new Checkbox_Demo(driver);
        try {
            singleCheckBox.goTo();
            Thread.sleep(5000);
            singleCheckBox.singleCheckBoxTick();
            Thread.sleep(5000);
            String checkBoxMessage = singleCheckBox.displayMessage();
            Assert.assertEquals("Success - Check box is checked", checkBoxMessage);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Test for checking if all checkboxes are ticked when pressing "Check All" and if text changes to "Uncheck All"
    @Test
    public void multipleCheckBoxTest() {
        Checkbox_Demo multipleCheckBox = new Checkbox_Demo(driver);
        try {
            multipleCheckBox.goTo();
            Thread.sleep(5000);
            String checkAllButtonText = multipleCheckBox.clickCheckAll();
            Assert.assertEquals(checkAllButtonText, "Uncheck All", "Text does not match");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

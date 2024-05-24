package Tests;

import PageObjects.JQuery_Select_Dropdown;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JQuery_Select_DropDown_Test extends BaseTest {

    //Test for clicking dropdown and searching
    @Test
    public void dropDownWithSearchBox(){
        JQuery_Select_Dropdown dropDown = new JQuery_Select_Dropdown(driver);
        try {
            dropDown.goTo();
            Thread.sleep(5000);
            dropDown.countryDropdownClick();
            Thread.sleep(5000);
            dropDown.countrySearch();
            Thread.sleep(5000);
            dropDown.countrySelect();
            Thread.sleep(5000);
            String searchResult = dropDown.countrySearchGetText();
            Assert.assertEquals(searchResult, "Japan", "Input text does not match");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Test for clicking dropdown and selecting multiple values
    @Test
    public void dropDownWithMultiValues() {
        JQuery_Select_Dropdown dropDown = new JQuery_Select_Dropdown(driver);
        try {
            dropDown.goTo();
            Thread.sleep(5000);
            dropDown.clickMultipleStates();
            Thread.sleep(5000);
            dropDown.findState();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Test for clicking dropdown and selecting values that are not disabled
    @Test
    public void dropDownDisabled(){
        JQuery_Select_Dropdown dropDown = new JQuery_Select_Dropdown(driver);
        try {
            dropDown.goTo();
            Thread.sleep(5000);
            dropDown.clickDisabledDropDown();
            Thread.sleep(5000);
            dropDown.searchTerritory();
            Thread.sleep(5000);
            dropDown.selectTerritory();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Test for clicking dropdown and selecting a file among the options
    @Test
    public void fileDropDown(){
        JQuery_Select_Dropdown dropDown = new JQuery_Select_Dropdown(driver);
        try {
            dropDown.goTo();
            Thread.sleep(5000);
            dropDown.filesDropDown();
            Thread.sleep(5000);
            String fileName = dropDown.selectFile();
            Assert.assertEquals(fileName, "Python", "Selected category is not Python");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

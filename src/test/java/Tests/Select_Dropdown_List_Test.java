package Tests;

import PageObjects.Select_Dropdown_List;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Select_Dropdown_List_Test extends BaseTest {

    //Test for selecting a day from the dropdown list
    @Test
    public void selectListTest() {
        Select_Dropdown_List selectList = new Select_Dropdown_List(driver);
        try {
            selectList.goTo();
            Thread.sleep(5000);
            selectList.selectDayFromList();
            Thread.sleep(5000);
            String listMessage = selectList.getListMessage();
            Assert.assertTrue(listMessage.equals("Day selected :- Wednesday"));
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Test for selecting multiple values and getting the first option selected
    @Test
    public void multiSelectFirstSelected() {
        Select_Dropdown_List selectList = new Select_Dropdown_List(driver);
        try {
            selectList.goTo();
            Thread.sleep(5000);
            selectList.selectStatesFromList();
            Thread.sleep(10000);
            selectList.clickFirstSelected();
            String multiListMessage = selectList.getMultiListMessage();
            System.out.println(multiListMessage);
            Assert.assertTrue(multiListMessage.contains("Ohio"), "Expected 'Ohio', but got: " + multiListMessage);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Test for selecting multiple values and getting all the options selected
    @Test
    public void multiSelectAllSelected() {
        Select_Dropdown_List selectList = new Select_Dropdown_List(driver);
        try {
            selectList.goTo();
            Thread.sleep(5000);
            selectList.selectStatesFromList();
            Thread.sleep(1000);
            selectList.clickAllSelected();
            String multiListMessage = selectList.getMultiListMessage();
            System.out.println(multiListMessage);
            Assert.assertTrue(multiListMessage.contains("Options selected are : Ohio,Pennsylvania"), "Expected 'Ohio,Pennsylvania', but got: " + multiListMessage);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

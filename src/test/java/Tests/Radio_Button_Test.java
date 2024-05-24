package Tests;

import PageObjects.Radio_Button_Demo;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Radio_Button_Test extends BaseTest {

    //Test for clicking on a radio button and verifying their text
    @Test
    public void singleRadioButtonDemo(){
        Radio_Button_Demo radioButtonDemo = new Radio_Button_Demo(driver);
        try {
            radioButtonDemo.goTo();
            Thread.sleep(5000);
            radioButtonDemo.clickMaleRadioButton();
            Thread.sleep(5000);
            radioButtonDemo.clickCheckAllButton();
            Thread.sleep(5000);
            String radioMessage = radioButtonDemo.getRadioButtonMessage();
            Assert.assertTrue(radioMessage.equals("Radio button 'Male' is checked"));
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Test for clicking on multiple radio buttons and verifying their text
    @Test
    public void groupRadioButtonDemo(){
        Radio_Button_Demo radioButtonDemo = new Radio_Button_Demo(driver);
        try {
            radioButtonDemo.goTo();
            Thread.sleep(5000);
            radioButtonDemo.clickGroupMaleRadioButton();
            Thread.sleep(5000);
            radioButtonDemo.clickGroupAgeRadioButton();
            Thread.sleep(5000);
            radioButtonDemo.clickGroupCheckAllButton();
            String groupMessage = radioButtonDemo.getGroupRadioButtonMessage();
            Assert.assertTrue(groupMessage.equals("Sex : Male\n" +
                    "Age group: 15 - 50"));
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

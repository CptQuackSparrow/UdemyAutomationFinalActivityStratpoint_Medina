package Tests;

import PageObjects.Simple_Form_Demo;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Simple_Form_Demo_Test extends BaseTest {

    //Testing for input on a single field and verifying result message
    @Test
    public void singleInputField() {
        Simple_Form_Demo singleInput = new Simple_Form_Demo(driver);
        try {
            singleInput.goTo();
            Thread.sleep(5000);
            String inputMessage = "Tested by Stefano Medina";
            singleInput.inputMessage(inputMessage);
            String returnedMessage = singleInput.showMessageBtn();
            Assert.assertTrue(returnedMessage.equals(inputMessage));
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Testing for input on two fields and verifying result message
    @Test
    public void twoInputFields(){
        Simple_Form_Demo twoInputs = new Simple_Form_Demo(driver);
        try {
            twoInputs.goTo();
            Thread.sleep(5000);
            Integer firstNum = 1;
            Integer secondNum = 2;
            twoInputs.inputValue1(firstNum);
            twoInputs.inputValue2(secondNum);
            String returnedTotal = twoInputs.showTotalBtn();
            Assert.assertFalse(returnedTotal.equals((firstNum + secondNum)));
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

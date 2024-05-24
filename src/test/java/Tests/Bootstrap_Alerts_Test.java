package Tests;

import TestComponents.BaseTest;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjects.Bootstrap_Alerts;

public class Bootstrap_Alerts_Test extends BaseTest {

    //Testing of Auto Success Modal
    @Test
    public void autoSuccess() {
        Bootstrap_Alerts autoCloseSuccess = new Bootstrap_Alerts(driver);
        try {
            autoCloseSuccess.goTo();
            autoCloseSuccess.clickAutoCloseSuccess();
            String[] dialogValues = autoCloseSuccess.autoCloseSuccessDialog();

            String autoSuccessMessage = dialogValues[0];
            String autoSuccessColor = dialogValues[1];

            Assert.assertEquals(Color.fromString(autoSuccessColor).asHex(), "#dff0d8", "Color does not match");
            Assert.assertEquals(autoSuccessMessage, "I'm an autocloseable success message. I will hide in 5 seconds.",
                    "Message does not match the expected results.");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    //Testing of Normal Success Modal
    @Test
    public void normalSuccess()
    {
        Bootstrap_Alerts normalSuccess = new Bootstrap_Alerts(driver);
        try {
            normalSuccess.goTo();
            normalSuccess.clickNormalSuccess();
            String[] dialogValues = normalSuccess.normalSuccessDialog();

            String normalSuccessMessage = dialogValues[0];
            String normalSuccessColor = dialogValues[1];

            Assert.assertEquals(Color.fromString(normalSuccessColor).asHex(), "#dff0d8", "Color does not match");
            Assert.assertEquals(normalSuccessMessage, "×\n" +
                    "I'm a normal success message. To close use the appropriate button.", "Message does not match the expected results.");
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing of Auto Warning Modal
    @Test
    public void autoWarning()
    {
        Bootstrap_Alerts autoCloseWarning = new Bootstrap_Alerts(driver);
        try {
            autoCloseWarning.goTo();
            autoCloseWarning.clickAutoCloseWarning();
            String[] dialogValues = autoCloseWarning.autoCloseWarningDialog();

            String autoWarningMessage = dialogValues[0];
            String autoWarningColor = dialogValues[1];

            Assert.assertEquals(Color.fromString(autoWarningColor).asHex(), "#fcf8e3", "Color does not match");
            Assert.assertEquals(autoWarningMessage, "I'm an autocloseable warning message. I will hide in 3 seconds.",
                    "Message does not match the expected results.");
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing of Normal Warning Modal
    @Test
    public void normalWarning()
    {
        try {
            Bootstrap_Alerts normalWarning = new Bootstrap_Alerts(driver);
            normalWarning.goTo();
            normalWarning.clickNormalWarning();
            String[] dialogValues = normalWarning.normalWarningDialog();

            String normalWarningMessage = dialogValues[0];
            String normalWarningColor = dialogValues[1];

            Assert.assertEquals(Color.fromString(normalWarningColor).asHex(), "#fcf8e3", "Color does not match");
            Assert.assertEquals(normalWarningMessage, "×\n" +
                    "I'm a normal warning message. To close use the appropriate button.", "Message does not match the expected results.");
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing of Auto Danger Modal
    @Test
    public void autoDanger() {
        try {
            Bootstrap_Alerts autoCloseDanger = new Bootstrap_Alerts(driver);
            autoCloseDanger.goTo();
            autoCloseDanger.clickAutoCloseDanger();
            String[] dialogValues = autoCloseDanger.autoCloseDangerDialog();

            String autoDangerMessage = dialogValues[0];
            String autoDangerColor = dialogValues[1];

            Assert.assertEquals(Color.fromString(autoDangerColor).asHex(), "#f2dede", "Color does not match");
            Assert.assertEquals(autoDangerMessage, "I'm an autocloseable danger message. I will hide in 5 seconds.",
                    "Message does not match the expected results.");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Testing of Normal Danger Modal
    @Test
    public void normalDanger()
    {
        Bootstrap_Alerts normalDanger = new Bootstrap_Alerts(driver);
        try {
            normalDanger.goTo();
            normalDanger.clickNormalDanger();
            String[] dialogValues = normalDanger.normalDangerDialog();

            String normalDangerMessage = dialogValues[0];
            String normalDangerColor = dialogValues[1];

            Assert.assertEquals(Color.fromString(normalDangerColor).asHex(), "#f2dede", "Color does not match");
            Assert.assertEquals(normalDangerMessage, "×\n" +
                    "I'm a normal danger message. To close use the appropriate button.", "Message does not match the expected results.");
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing of Auto Info Modal
    @Test
    public void autoInfo()
    {
        Bootstrap_Alerts autoCloseInfo = new Bootstrap_Alerts(driver);
        try {
            autoCloseInfo.goTo();
            autoCloseInfo.clickAutoCloseInfo();
            String[] dialogValues = autoCloseInfo.autoCloseInfoDialog();

            String autoInfoMessage = dialogValues[0];
            String autoInfoColor = dialogValues[1];

            Assert.assertEquals(Color.fromString(autoInfoColor).asHex(), "#d9edf7", "Color does not match");
            Assert.assertEquals(autoInfoMessage, "I'm an autocloseable info message. I will hide in 6 seconds.",
                    "Message does not match the expected results.");
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Testing of Normal Info Modal
    @Test
    public void normalInfo()
    {
        try {
            Bootstrap_Alerts normalInfo = new Bootstrap_Alerts(driver);
            normalInfo.goTo();
            Thread.sleep(5000);
            normalInfo.clickNormalInfo();
            Thread.sleep(5000);
            String[] dialogValues = normalInfo.normalInfoDialog();
            Thread.sleep(5000);
            String normalInfoMessage = dialogValues[0];
            String normalInfoColor = dialogValues[1];
            Thread.sleep(5000);
            Assert.assertEquals(Color.fromString(normalInfoColor).asHex(), "#d9edf7", "Color does not match");
            Assert.assertEquals(normalInfoMessage, "×\n" +
                    "I'm a normal info message. To close use the appropriate button.", "Message does not match the expected results.");
            Thread.sleep(5000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

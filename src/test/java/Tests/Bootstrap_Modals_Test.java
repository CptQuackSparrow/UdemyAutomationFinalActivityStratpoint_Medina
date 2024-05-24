package Tests;

import PageObjects.Bootstrap_Modals;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Bootstrap_Modals_Test extends BaseTest{

    //Test for clicking the close button of the single modal
    @Test
    public void singleModalClose() {
        Bootstrap_Modals closeSingleModal = new Bootstrap_Modals(driver);
        try {
            closeSingleModal.goTo();
            Thread.sleep(5000);
            closeSingleModal.launchSingleModal();
            Thread.sleep(5000);
            String modalMessage = closeSingleModal.viewSingleModal();
            Assert.assertEquals(modalMessage, "This is the place where the content for the modal dialog displays",
                    "Message does not match the expected results.");
            closeSingleModal.clickSingleModalClose();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Test for clicking the save button of the single modal
    @Test
    public void singleModalSave() {
        Bootstrap_Modals saveSingleModal = new Bootstrap_Modals(driver);
        try {
            saveSingleModal.goTo();
            Thread.sleep(5000);
            saveSingleModal.launchSingleModal();
            Thread.sleep(5000);
            String modalMessage = saveSingleModal.viewSingleModal();
            Assert.assertEquals(modalMessage, "This is the place where the content for the modal dialog displays",
                    "Message does not match the expected results.");
            saveSingleModal.clickSingleModalSave();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Test for clicking the close button of the first modal
    @Test
    public void multiModalFirstClose()
    {
        Bootstrap_Modals closeFirstMultiModal = new Bootstrap_Modals(driver);
        try {
            closeFirstMultiModal.goTo();
            Thread.sleep(5000);
            closeFirstMultiModal.launchFirstMultiModal();
            Thread.sleep(5000);
            String firstModalMessage = closeFirstMultiModal.viewFirstMultiModal();
            Assert.assertEquals(firstModalMessage, "This is the place where the content for the modal dialog displays.\n" +
                    "\n" +
                    "Click launch modal button to launch second modal.\n" +
                    "Click close link to close the modal.\n" +
                    "Clicking on Save Changes button will close the modal and refresh the page\n" +
                    "\n" +
                    "Launch modal");
            closeFirstMultiModal.closeFirstMultiModal();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Test for clicking the asave button of the first modal
    @Test
    public void multiModalFirstSave()
    {
        Bootstrap_Modals saveFirstMultiModal = new Bootstrap_Modals(driver);
        try {
            saveFirstMultiModal.goTo();
            Thread.sleep(5000);
            saveFirstMultiModal.launchFirstMultiModal();
            Thread.sleep(5000);
            String firstModalMessage = saveFirstMultiModal.viewFirstMultiModal();
            Assert.assertEquals(firstModalMessage, "This is the place where the content for the modal dialog displays.\n" +
                    "\n" +
                    "Click launch modal button to launch second modal.\n" +
                    "Click close link to close the modal.\n" +
                    "Clicking on Save Changes button will close the modal and refresh the page\n" +
                    "\n" +
                    "Launch modal");
            saveFirstMultiModal.saveFirstMultiModal();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Test for clicking the close button of the second modal
    @Test
    public void multiModalSecondClose()
    {
        Bootstrap_Modals closeSecondMultiModal = new Bootstrap_Modals(driver);
        try {
            closeSecondMultiModal.goTo();
            Thread.sleep(5000);
            closeSecondMultiModal.launchFirstMultiModal();
            Thread.sleep(5000);
            String firstModalMessage = closeSecondMultiModal.viewFirstMultiModal();
            Assert.assertEquals(firstModalMessage, "This is the place where the content for the modal dialog displays.\n" +
                    "\n" +
                    "Click launch modal button to launch second modal.\n" +
                    "Click close link to close the modal.\n" +
                    "Clicking on Save Changes button will close the modal and refresh the page\n" +
                    "\n" +
                    "Launch modal");

            Thread.sleep(5000);
            closeSecondMultiModal.launchSecondMultiModal();
            Thread.sleep(5000);
            String secondModalMessage = closeSecondMultiModal.viewSecondMultiModal();
            Assert.assertEquals(secondModalMessage, "This is the place where the content for the modal dialog displays.");
            closeSecondMultiModal.closeSecondMultiModal();
            Thread.sleep(5000);
            closeSecondMultiModal.closeFirstMultiModal();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Test for clicking the save button of the second modal
    @Test
    public void multiModalSecondSave()
    {
        Bootstrap_Modals saveSecondMultiModal = new Bootstrap_Modals(driver);
        try {
            saveSecondMultiModal.goTo();
            Thread.sleep(5000);
            saveSecondMultiModal.launchFirstMultiModal();
            Thread.sleep(5000);
            String firstModalMessage = saveSecondMultiModal.viewFirstMultiModal();
            Assert.assertEquals(firstModalMessage, "This is the place where the content for the modal dialog displays.\n" +
                    "\n" +
                    "Click launch modal button to launch second modal.\n" +
                    "Click close link to close the modal.\n" +
                    "Clicking on Save Changes button will close the modal and refresh the page\n" +
                    "\n" +
                    "Launch modal");

            Thread.sleep(5000);
            saveSecondMultiModal.launchSecondMultiModal();
            Thread.sleep(5000);
            String secondModalMessage = saveSecondMultiModal.viewSecondMultiModal();
            Assert.assertEquals(secondModalMessage, "This is the place where the content for the modal dialog displays.");
            saveSecondMultiModal.saveSecondMultiModal();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

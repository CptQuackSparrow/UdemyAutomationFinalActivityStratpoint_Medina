package Tests;

import PageObjects.Input_Form_Submit;
import TestComponents.BaseTest;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;


public class Input_Form_Submit_Test extends BaseTest {

    DataFormatter formatter = new DataFormatter();

    //Test for inputting data in input forms
    @Test(dataProvider = "inputFormData")
    public void sendData(String fName,
                         String lName,
                         String email,
                         String phoneNum,
                         String address,
                         String city,
                         String zipCode,
                         String website,
                         String state,
                         String projDescription) {
        Input_Form_Submit sendData = new Input_Form_Submit(driver);
        try {
            sendData.goTo();
            Assert.assertTrue(sendData.isSendBtnEnabled(), "Send button is not enabled before click.");
            Thread.sleep(5000);
            sendData.inputData(fName, lName, email, phoneNum, address, city, zipCode, website, projDescription);
            Thread.sleep(5000);
            sendData.stateSelect(state);
            Thread.sleep(5000);
            sendData.checkboxSelect();
            Thread.sleep(5000);
            sendData.clickSendBtn();
            Assert.assertTrue(sendData.isSendBtnEnabled(), "Send button is not enabled before click.");
            sendData.clickSendBtn();
            Thread.sleep(10000);
            Assert.assertTrue(sendData.isSendBtnEnabled(), "Send button is not enabled after click.");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @DataProvider(name="inputFormData")
    public Object[][] getUserData() throws IOException {
        FileInputStream fis = new FileInputStream
                ("C:\\Users\\stefa\\Downloads\\UdemyFinalActivityData_Medina.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int colCount = row.getLastCellNum();
        Object data[][] = new Object[rowCount-1][colCount];
        for (int i=0; i<rowCount-1; i++)
        {
            row = sheet.getRow(i+1);
            for (int j=0; j<colCount; j++)
            {
                XSSFCell cell=row.getCell(j);
                data[i][j]=formatter.formatCellValue(cell);
            }
        }
        return data;
    }
}

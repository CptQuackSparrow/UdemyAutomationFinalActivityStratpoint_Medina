package Tests;

import PageObjects.Ajax_Form_Submit;
import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Ajax_Form_Submit_Test extends BaseTest {

    Object[][] testData;

    @Test(dataProvider = "ajaxFormProvider")
    public void submitTest(String name, String description) {
        Ajax_Form_Submit submitTest = new Ajax_Form_Submit(driver);
        try {
            submitTest.goTo();
            Thread.sleep(5000);
            submitTest.inputData(name, description);
            Thread.sleep(5000);
            submitTest.clickSaveBtn();
            Thread.sleep(5000);
            String successMessage = submitTest.viewSuccessMessage();
            Thread.sleep(5000);
            Assert.assertTrue(successMessage.equals("Form submited Successfully!"));
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @DataProvider(name = "ajaxFormProvider")
    public Object[][] provideInfo() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\AutomationData\\ajaxData.json");

        testData = new Object[data.size()][2];
        for (int i = 0; i < data.size(); i++) {
            testData[i][0] = data.get(i).get("name");
            testData[i][1] = data.get(i).get("description");
        }
        return testData;
    }
}


//Retreiving of data from Excel sheets (.xlsx)
//    @DataProvider(name="ajaxFormProvider")
//    public Object[][] getUserData() throws IOException {
//        FileInputStream fis = new FileInputStream
//                ("C:\\Users\\stefa\\Downloads\\UdemyFinalActivityData_Medina.xlsx");
//        XSSFWorkbook wb = new XSSFWorkbook(fis);
//        XSSFSheet sheet = wb.getSheetAt(0);
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        XSSFRow row = sheet.getRow(0);
//        int colCount = row.getLastCellNum();
//        Object data[][] = new Object[rowCount-1][colCount];
//        for (int i=0; i<rowCount-1; i++)
//        {
//            row = sheet.getRow(i+1);
//            for (int j=0; j<colCount; j++)
//            {
//                XSSFCell cell=row.getCell(j);
//                data[i][j]=formatter.formatCellValue(cell);
//            }
//        }
//        return data;
//    }

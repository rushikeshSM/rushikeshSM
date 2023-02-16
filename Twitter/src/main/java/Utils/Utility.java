package Utils;

import java.io.File;
import java.io.FileInputStream;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
//twitter
public class Utility {

    public static void captureScreenshot(WebDriver driver, String screenshotPath, String methodName) {
        try {
            TakesScreenshot t = (TakesScreenshot) driver;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
            LocalDateTime now = LocalDateTime.now();
            File src = t.getScreenshotAs(OutputType.FILE);
            File dest = new File(screenshotPath + methodName + "--" + dtf.format(now) + ".jpg");
            FileHandler.copy(src, dest);
        } catch (Exception e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
        }
    }

    
    
    
    public static String getDataFromExcel(String path, String sheet, int row, int cell) throws Exception {
    	double data1;
    	String data;
    	long data2;
	    FileInputStream file = new FileInputStream(path);
	    Workbook workbook = WorkbookFactory.create(file);
	    Sheet sheet1 = workbook.getSheet(sheet);
	try {
	    data =sheet1.getRow(row).getCell(cell).getStringCellValue();
	    return data;
    }
	catch(Exception e)
	{
		data1= sheet1.getRow(row).getCell(cell).getNumericCellValue();
		data2  = (long)data1;
		return String.valueOf(data2);
	}
	
}
    
    
    
    
    
    
    
    
//    public static String getDataFromExcel(String path, String sheet, int row, int cell) {
//        try {
//            FileInputStream file = new FileInputStream(path);
//            String data = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
//            return data;
//        } catch (IOException e) {
//            throw new NullPointerException("Failed to read data from Excel");
//        }
//    }

   
    
    
    
    
//    public static String getDataFromExcel(String filePath, String sheet, int row, int cell) {
//        try {
//            FileInputStream file = new FileInputStream(filePath);
//            return WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
//        } catch (Exception e) {
//            System.err.println("Failed to fetch data from Excel: " + e.getMessage());
//            return "";
//        }
//    }
}

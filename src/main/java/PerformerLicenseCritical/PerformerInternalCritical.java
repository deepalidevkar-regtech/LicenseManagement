package PerformerLicenseCritical;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import licenseManagement.licmgmtPOM;
import licensePerformer.LiPerformerPOM;

public class PerformerInternalCritical 
{
	public static WebDriver driver = null;		//WebDriver instance created
	public static WebElement upload = null;		//WebElement to get upload button
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	
	public static XSSFSheet ReadExcel() throws IOException
	{
		
		String workingDir = System.getProperty("user.dir");
		fis = new FileInputStream(workingDir+"//TestData//ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving second sheet of Workbook
		return sheet;
	}
	 
	
	public static void MyworkspaceaddLicense1(WebDriver driver, ExtentTest test, String type) throws InterruptedException, IOException 
	{
		 licenseManagement.licmgmtPOM.ClickMyWorkspace(driver).click();
		 WebDriverWait wait = new WebDriverWait(driver, 50);
		 Thread.sleep(3000);
			  WebDriverWait wait1= new WebDriverWait(driver, 5);
				wait1.until(ExpectedConditions.visibilityOf(licmgmtPOM.Type2(driver)));
				licmgmtPOM.Type2(driver).click();				//Clicking on 'Type' drop down.
				
				licmgmtPOM.internalType2(driver).click();
				
		 licmgmtPOM.WorkspaceExport(driver).click();
		 test.log(LogStatus.PASS,"License Details Export" );
		 Thread.sleep(3000);	
		 
		licmgmtPOM.ClickAddLicense(driver).click();
		 
		Thread.sleep(3000);	
		 licmgmtPOM.ClickLicenseTypeDropdown(driver).click();
		 
			Thread.sleep(3000);	
		 licmgmtPOM.SelectLicenseTypeperin(driver).click();
		 
		 Thread.sleep(3000);
		licmgmtPOM.ClickLocation(driver).click();
		Thread.sleep(3000);
	     licmgmtPOM.LocationMaximizeper(driver).click();
		
		 Thread.sleep(5000);
		 licmgmtPOM.SelectLocation(driver).click();
		 
		 Thread.sleep(3000);
		 licmgmtPOM.ClickCompliance(driver).click();
		 Thread.sleep(5000);
		 licmgmtPOM.SelectLicenseCompliance(driver).get(1).click();
		 
		 Thread.sleep(5000);
		 licmgmtPOM.ClickPerformer(driver).click();
		 Thread.sleep(6000);
		 licmgmtPOM.SelectPerformer(driver).get(3).click();
		// licmgmtPOM.SelectPerformer(driver).click();
		
		 Thread.sleep(3000);
		 licmgmtPOM.ClickReviewer(driver).click();
		 Thread.sleep(6000);
		 licmgmtPOM.SelectReviewer(driver).get(111).click(); 
		 
		 XSSFSheet Sheet= ReadExcel();
		 Thread.sleep(3000);
		 sheet = workbook.getSheetAt(2);
		 Row row6= sheet.getRow(6);
		  org.apache.poi.ss.usermodel.Cell c1 = row6.getCell(1);	
		 String LicenseTitle= c1.getStringCellValue();
		 licmgmtPOM.LicenseTitle(driver).sendKeys(LicenseTitle);
		 
		 Thread.sleep(3000);
		 Row row7=sheet.getRow(7);
			org.apache.poi.ss.usermodel.Cell c2=row7.getCell(1);
		 String LicenseNo=c2.getStringCellValue();
		 licmgmtPOM.LicenseNo(driver).sendKeys(LicenseNo);
		 
		Thread.sleep(3000);
		/* Row row8=sheet.getRow(8);
			org.apache.poi.ss.usermodel.Cell c3=row8.getCell(1);
		 String ApplicationDays=c3.getStringCellValue();
		 licmgmtPOM.ApplicationDays(driver).sendKeys(ApplicationDays);
		 
		 Thread.sleep(3000);
		 Row row9=sheet.getRow(9);
			org.apache.poi.ss.usermodel.Cell c4=row9.getCell(1);
		 String LicenseCost=c4.getStringCellValue();
		 licmgmtPOM.LicenseCost(driver).sendKeys(LicenseCost);
		 */
		licmgmtPOM.ClickCal(driver).click();
		 Thread.sleep(7000);
		 licmgmtPOM.NewDate(driver).click();
		 Thread.sleep(5000);
		licmgmtPOM.ClickCal1(driver).click();
		 Thread.sleep(7000);
		licmgmtPOM.NewEndDate(driver).click();
		
		 
		Thread.sleep(300);
		// licmgmtPOM.Chooesfile(driver).click();
			//String workingDir = System.getProperty("user.dir");
			//licmgmtPOM.Chooesfile(driver).sendKeys(workingDir+"//Reports//LicensePerformerResults(Statutory).html");
       

 	      JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,2000)");
	
		
		 licmgmtPOM.Nomineesubmit(driver).click();
		 Thread.sleep(5000);
		    // Switching to Alert       
		        Alert alert = driver.switchTo().alert();
		       
		        // Capturing alert message.   
		        String alertMessage= driver.switchTo().alert().getText();
		       
		        Thread.sleep(3000);
		    //    test.log(LogStatus.PASS, alertMessage);
		       
		        // Displaying alert message
		        System.out.println(alertMessage);
		       
		       
		        // Accepting alert
		        alert.accept();
		       
		        test.log(LogStatus.PASS,"License Details Added Successfully" );
		     
		     
		         licmgmtPOM.editlicenseclose(driver).click();
		         Thread.sleep(5000);
		         
		         licmgmtPOM.ClickMyWorkspace(driver).click();
		         Thread.sleep(5000);
		         licmgmtPOM.Overviewworkspace(driver).click();
		         wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
		       
		         test.log(LogStatus.PASS,"License Overview Details Button Working Successfully " );
		 
					  
		 }
		
		
	}




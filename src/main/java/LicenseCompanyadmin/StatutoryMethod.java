package LicenseCompanyadmin;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Table.Cell;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import licensePerformer.LiPerformerPOM;
import performer.OverduePOM;

public class StatutoryMethod {
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
	
	public static void user(WebDriver driver,ExtentTest test) throws InterruptedException, IOException
	{
		
		XSSFSheet sheet = ReadExcel();

		Thread.sleep(1000);
		MethodPOM.clickMasterMenu(driver).click();
		Thread.sleep(1000);
		MethodPOM.clickUserMaster(driver).click();
		Thread.sleep(1000);
		MethodPOM.clickAddUser(driver).click();

	      Thread.sleep(3000);
	      sheet = workbook.getSheetAt(0);					//Retrieving second sheet of Workbook
		  Row row0 = sheet.getRow(5);						//Selected 0th index row (First row)
		  org.apache.poi.ss.usermodel.Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		  String firstname1= c1.getStringCellValue();
		  MethodPOM.ClickUername(driver).sendKeys(firstname1);		  
		 Thread.sleep(3000);
		 Row row1 = sheet.getRow(6);
		org.apache.poi.ss.usermodel.Cell c2=row1.getCell(1);
		 String Lastname=c2.getStringCellValue();
		 MethodPOM.ClickLastName(driver).sendKeys(Lastname);	
		 
		 Thread.sleep(3000);
		 Row row2 = sheet.getRow(7);
		 org.apache.poi.ss.usermodel.Cell c3=row2.getCell(1);
		 String Designation=c3.getStringCellValue();
		 MethodPOM.ClickDesignation(driver).sendKeys(Designation);	
		 
		 Thread.sleep(3000);
		 Row row3 = sheet.getRow(8);
		 org.apache.poi.ss.usermodel.Cell c4=row3.getCell(1);
		 String Email=c4.getStringCellValue();
		 MethodPOM.ClickUserGmail(driver).sendKeys(Email);	
		 
		 Thread.sleep(3000);
		 Row row4 = sheet.getRow(9);
		 org.apache.poi.ss.usermodel.Cell c5=row4.getCell(1);
		 int MobileNO= (int)c5.getNumericCellValue();
		 MethodPOM.ClickMobileNo(driver).sendKeys(MobileNO+"");
		 
		 Thread.sleep(3000);
		 MethodPOM.ClickRoleDropdown(driver).click();
		 
		 Thread.sleep(3000);
		 MethodPOM.ClickRoleNonadmin(driver).click();
		 
		 
		 Thread.sleep(3000);
		 MethodPOM.ClickDepartmentDropdown(driver).click();
		 
		 Thread.sleep(3000);
		 MethodPOM.ClickDepartment(driver).click();
		 
		 Thread.sleep(3000);
		 MethodPOM.ClickLocationDropdown(driver).click();
		 
		 Thread.sleep(3000);
		 MethodPOM.ClickLocation(driver).click();
		  
		 Thread.sleep(3000);
		 MethodPOM.ClickUserSave(driver).click();
		 Thread.sleep(3000);
		 MethodPOM.ClickUserClose(driver).click();
		 Thread.sleep(5000);
		 MethodPOM.ClickEditUser(driver).click();
		 Thread.sleep(3000);
		 MethodPOM.ClickUserGmail(driver).clear();
		 Thread.sleep(3000);
		 MethodPOM.ClickUserGmail(driver).sendKeys("Poojas34@gmail.com");
		 Thread.sleep(3000);	
		 MethodPOM.ClickUserSave(driver).click();
		 Thread.sleep(3000);
		 MethodPOM.ClickUserClose(driver).click();
		 Thread.sleep(5000);
		 MethodPOM.ClickUserSearch(driver).sendKeys("AShish",Keys.ENTER);
		
	    Thread.sleep(3000);
		 MethodPOM.ClickResetPassword(driver).click();
		 
		String AlertMesg= driver.switchTo().alert().getText(); 
		driver.switchTo().alert().accept();
		test.log(LogStatus.INFO, AlertMesg);
		
		 
		 
		 
	}
	public static void PageAuthorization(WebDriver driver) throws InterruptedException

	{
	  Thread.sleep(3000);
	  MethodPOM.clickMasterMenu(driver).click();
	  
	  Thread.sleep(3000);
	  MethodPOM.ClickPageAuthorization(driver).click();
	  
	  Thread.sleep(3000);
	  MethodPOM.ClickAutheruser(driver).click();
	  
	  Thread.sleep(3000);
	  MethodPOM.ClickSelectUser(driver).click();
	  
	  Thread.sleep(3000);
	  MethodPOM.ClickAddAuthAddCheck(driver).click();
	  
	  JavascriptExecutor js=(JavascriptExecutor) driver ;
		js.executeScript("window.scroll(0,500)");
		
	  Thread.sleep(3000);
	  MethodPOM.ClickPageAutherSave(driver).click();
	  
	   Thread.sleep(3000);
	   MethodPOM.ClickPageAutherAll(driver).click();
	   
	   Thread.sleep(3000);
	   MethodPOM.ClickPageAutherInternal(driver).click();
	   
	   Thread.sleep(3000);
		  MethodPOM.ClickAutheruser(driver).click();
		  
		  Thread.sleep(3000);
		  MethodPOM.ClickSelectUser(driver).click();
		  
		  Thread.sleep(3000);
		  MethodPOM.ClickAddAuthAddCheck(driver).click();
		  
		  JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			
		  Thread.sleep(3000);
		  MethodPOM.ClickPageAutherSave(driver).click();
		  
	   
	}
    public static void RenewStatutoryLicense(WebDriver driver) throws InterruptedException

    {
    	Thread.sleep(4000);
    	MethodPOM.clickMasterMenu(driver).click();
    	
    	Thread.sleep(3000);
        MethodPOM.ClickRenewLicenseMenu(driver).click();
        
        Thread.sleep(4000);
        MethodPOM.ClickReneweditStatutoryLicense(driver).click();
        
        driver.switchTo().frame(MethodPOM.ClickLiceneFream(driver));
        
        JavascriptExecutor js1=(JavascriptExecutor) driver ;
		js1.executeScript("window.scroll(0,500)");
    	
        Thread.sleep(5000);
        MethodPOM.ClickLicenseNumber(driver).sendKeys("Ar4224123");
        
        Thread.sleep(3000);
        MethodPOM.ClickLicenseTitle(driver).sendKeys("Update Li44343eeecense For Automation");
        
        Thread.sleep(3000);
        MethodPOM.ClickLicenseStartDate(driver).sendKeys("22-02-2023");
        
        Thread.sleep(3000);
        MethodPOM.LicenseEnddate(driver).sendKeys("20-05-2026");
        Thread.sleep(3000);
        MethodPOM.LicenseEnddate(driver).click();
        
        Thread.sleep(3000);
        MethodPOM.LicenseUploadDocument(driver).sendKeys("C:\\Users\\dipali\\Desktop\\Bhagyesh\\Oct month test cases 2022.xlsx");
        
        Thread.sleep(3000);
        MethodPOM.FileNumber(driver).sendKeys("5660ss5");
        Thread.sleep(3000);
        MethodPOM.RenewLicenseSubmit(driver).click();
        
        Thread.sleep(3000);
        MethodPOM.RenewLicenseClose(driver).click();
        
        
        
        
        
    }
    public static void RenewInternalLicense(WebDriver driver) throws InterruptedException

    {
    
        Thread.sleep(3000);
        MethodPOM.selectLicense(driver).click();
        
        Thread.sleep(3000);
        MethodPOM.selectInternalLicense(driver).click();
        
        
        Thread.sleep(4000);
        MethodPOM.ClickReneweditStatutoryLicense(driver).click();
        
        driver.switchTo().frame(MethodPOM.ClickLiceneFream(driver));
        
        JavascriptExecutor js1=(JavascriptExecutor) driver ;
		js1.executeScript("window.scroll(0,500)");
    	
        Thread.sleep(5000);
        MethodPOM.ClickLicenseNumber(driver).sendKeys("A1234");
        
        Thread.sleep(3000);
        MethodPOM.ClickLicenseTitle(driver).sendKeys("Update Internal License For Automation");
        
        Thread.sleep(3000);
        MethodPOM.ClickLicenseStartDate(driver).sendKeys("22-02-2023");
        
        Thread.sleep(3000);
        MethodPOM.LicenseEnddate(driver).sendKeys("20-05-2023");
        Thread.sleep(3000);
        MethodPOM.LicenseEnddate(driver).click();
        
        Thread.sleep(3000);
        MethodPOM.LicenseUploadDocument(driver).sendKeys("C:\\Users\\dipali\\Desktop\\Bhagyesh\\Oct month test cases 2022.xlsx");
        
        Thread.sleep(3000);
        MethodPOM.FileNumber(driver).sendKeys("507");
        Thread.sleep(3000);
        MethodPOM.RenewLicenseSubmit(driver).click();
        
        Thread.sleep(3000);
        MethodPOM.RenewLicenseClose(driver).click();
        
        
        
        
        
    }
	public static void ActiveLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
		String active=MethodPOM.clickActive(driver).getText();
		
	     int activelicense = Integer.parseInt(active);	//Reading Active count.

	      MethodPOM.clickActive(driver).click();					//Clicking on 'Active' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicenseActiveCount);
			if(activelicense == total)
				{
					test.log(LogStatus.PASS, "Number of Active License  grid matches to Dashboard Active License   Count.");
					test.log(LogStatus.INFO, "No of Active License  in the grid = "+total+" | Dashboard Active License  Count = "+activelicense);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Active License does not matches to Dashboard Active License   Count.");
					test.log(LogStatus.INFO, "No of Active License  in the grid = "+total+" | Dashboard Active License  Count = "+activelicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, "Activer License Overview Details Sucessfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				MethodPOM.clickMyDashboard(driver).click();
	}
	public static void ActiveInternalLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
		String active=MethodPOM.clickActive(driver).getText();
		
	     int activelicense = Integer.parseInt(active);	//Reading Active count.

	      MethodPOM.clickActive(driver).click();					//Clicking on 'Active' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicenseActiveCount);
			if(activelicense == total)
				{
					test.log(LogStatus.PASS, "Number of Active Internal License  grid matches to Dashboard Active Internal License   Count.");
					test.log(LogStatus.INFO, "No of Active  Internal License  in the grid = "+total+" | Dashboard Active Internal  License  Count = "+activelicense);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Active Internal License does not matches to Dashboard Active Internal License   Count.");
					test.log(LogStatus.INFO, "No of Active Internal License  in the grid = "+total+" | Dashboard Active Internal License  Count = "+activelicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, "Activer License Overview Details Sucessfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				MethodPOM.clickMyDashboard(driver).click();
	}
	public static void ExpiringLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring(driver)));
		String Expiring=MethodPOM.clickExpiring(driver).getText();
		
	     int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.

	      MethodPOM.clickExpiring(driver).click();					//Clicking on 'Expiring' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadExpiring(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadExpiring(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseExpiringCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicenseExpiringCount);
			if(Expiringlicense == total)
				{
					test.log(LogStatus.PASS, "Number of Expiring License  grid matches to Dashboard Expiring  License   Count.");
					test.log(LogStatus.INFO, "No of Expiring  License  in the grid = "+total+" | Dashboard Expiring License  Count = "+Expiringlicense);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Expiring License does not matches to Dashboard Expiring License   Count.");
					test.log(LogStatus.INFO, "No of Expiring License  in the grid = "+total+" | Dashboard Expiring License  Count = "+Expiringlicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, "Expiring License Overview Details Sucessfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				MethodPOM.clickMyDashboard(driver).click();
	}
	public static void ExpiringInternalLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring(driver)));
		String Expiring=MethodPOM.clickExpiring(driver).getText();
		
	     int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.

	      MethodPOM.clickExpiring(driver).click();					//Clicking on 'Expiring' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadExpiring(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadExpiring(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseExpiringCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicenseExpiringCount);
			if(Expiringlicense == total)
				{
					test.log(LogStatus.PASS, "Number of Expiring Internal  License  grid matches to Dashboard Expiring Internal  License   Count.");
					test.log(LogStatus.INFO, "No of Expiring Internal   License  in the grid = "+total+" | Dashboard Expiring Internal  License  Count = "+Expiringlicense);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Expiring Internal License does not matches to Dashboard Expiring Internal  License   Count.");
					test.log(LogStatus.INFO, "No of Expiring Internal  License  in the grid = "+total+" | Dashboard Expiring Internal  License  Count = "+Expiringlicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, "Expiring License Overview Details Sucessfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				MethodPOM.clickMyDashboard(driver).click();
	}
	public static void ExpiredLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
      WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired(driver)));
		String Expired=MethodPOM.clickExpired(driver).getText();
		
	     int Expiredlicense = Integer.parseInt(Expired);	//Reading Expired count.

	      MethodPOM.clickExpired(driver).click();					//Clicking on 'Expired' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadExpired(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadExpired(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseExpiredCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicenseExpiredCount);
			if(Expiredlicense == total)
				{
					test.log(LogStatus.PASS, "Number of Expired License  grid matches to Dashboard Expired  License   Count.");
					test.log(LogStatus.INFO, "No of Expired  License  in the grid = "+total+" | Dashboard Expired License  Count = "+Expiredlicense);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Expired License does not matches to Dashboard Expired License   Count.");
					test.log(LogStatus.INFO, "No of Expired License  in the grid = "+total+" | Dashboard Expired License  Count = "+Expiredlicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, "Expired License Overview Details Succ essfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				MethodPOM.clickMyDashboard(driver).click();

		
	}
	public static void ExpiredInternalLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
      WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired(driver)));
		String Expired=MethodPOM.clickExpired(driver).getText();
		
	     int Expiredlicense = Integer.parseInt(Expired);	//Reading Expired count.

	      MethodPOM.clickExpired(driver).click();					//Clicking on 'Expired' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadExpired(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadExpired(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseExpiredCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicenseExpiredCount);
			if(Expiredlicense == total)
				{
					test.log(LogStatus.PASS, "Number of Expired Internal License  grid matches to Dashboard Expired Internal License   Count.");
					test.log(LogStatus.INFO, "No of Expired Internal  License  in the grid = "+total+" | Dashboard Expired Internal License  Count = "+Expiredlicense);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Expired Internal  License does not matches to Dashboard Expired Internal  License   Count.");
					test.log(LogStatus.INFO, "No of Expired Internal License  in the grid = "+total+" | Dashboard Expired Internal  License  Count = "+Expiredlicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, "Expired License Overview Details Succ essfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				MethodPOM.clickMyDashboard(driver).click();

		
	}
	public static void AppliedLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickApplied(driver)));
			String Applied=MethodPOM.clickApplied(driver).getText();
			
		     int Appliedlicense = Integer.parseInt(Applied);	//Reading Applied count.

		      MethodPOM.clickApplied(driver).click();					//Clicking on 'Applied' image
		      Thread.sleep(4000);
		        JavascriptExecutor js1=(JavascriptExecutor) driver ;
				js1.executeScript("window.scroll(0,500)");
				Thread.sleep(4000);
				
				MethodPOM.clickReadApplied(driver).click();					//Clicking on total items count
				Thread.sleep(500);
				String item = MethodPOM.clickReadApplied(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String LicenseAppliedCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(LicenseAppliedCount);
				if(Appliedlicense == total)
					{
						test.log(LogStatus.PASS, "Number of Applied License  grid matches to Dashboard Applied  License   Count.");
						test.log(LogStatus.INFO, "No of Applied  License  in the grid = "+total+" | Dashboard Applied License  Count = "+Appliedlicense);
					}
					else
					{
						test.log(LogStatus.FAIL, "Number of Applied License does not matches to Dashboard Applied License   Count.");
						test.log(LogStatus.INFO, "No of Applied License  in the grid = "+total+" | Dashboard Applied License  Count = "+Appliedlicense);
					}
					Thread.sleep(3000);
					//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
					//Thread.sleep(3000);
					
					MethodPOM.ClickActiveOverview(driver).click();
					test.log(LogStatus.PASS, "Applied License Overview Details Successfully");
					Thread.sleep(3000);
					MethodPOM.ClickCloseOverview(driver).click();
					MethodPOM.clickMyDashboard(driver).click();

	}
	public static void AppliedInternalLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickApplied(driver)));
			String Applied=MethodPOM.clickApplied(driver).getText();
			
		     int Appliedlicense = Integer.parseInt(Applied);	//Reading Applied count.

		      MethodPOM.clickApplied(driver).click();					//Clicking on 'Applied' image
		      Thread.sleep(4000);
		        JavascriptExecutor js1=(JavascriptExecutor) driver ;
				js1.executeScript("window.scroll(0,500)");
				Thread.sleep(4000);
				
				MethodPOM.clickReadApplied(driver).click();					//Clicking on total items count
				Thread.sleep(500);
				String item = MethodPOM.clickReadApplied(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String LicenseAppliedCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(LicenseAppliedCount);
				if(Appliedlicense == total)
					{
						test.log(LogStatus.PASS, "Number of Applied Internal  License  grid matches to Dashboard Applied Internal   License   Count.");
						test.log(LogStatus.INFO, "No of Applied Internal  License  in the grid = "+total+" | Dashboard Applied  Internal License  Count = "+Appliedlicense);
					}
					else
					{
						test.log(LogStatus.FAIL, "Number of Applied Internal  License does not matches to Dashboard Applied Internal License   Count.");
						test.log(LogStatus.INFO, "No of Applied Internal  License  in the grid = "+total+" | Dashboard Applied Internal License  Count = "+Appliedlicense);
					}
					Thread.sleep(3000);
					//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
					//Thread.sleep(3000);
					
					MethodPOM.ClickActiveOverview(driver).click();
					test.log(LogStatus.PASS, "Applied License Overview Details Successfully");
					Thread.sleep(3000);
					MethodPOM.ClickCloseOverview(driver).click();
					MethodPOM.clickMyDashboard(driver).click();

	}

	public static void pendingforreviewLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickpendingforreview(driver)));
			String PendingForReview=MethodPOM.clickpendingforreview(driver).getText();
			
		     int pendingforreviewlicense = Integer.parseInt(PendingForReview);	//Reading Pending For Review count.

		      MethodPOM.clickpendingforreview(driver).click();					//Clicking on 'Pending For Review ' image
		      Thread.sleep(4000);
		        JavascriptExecutor js1=(JavascriptExecutor) driver ;
				js1.executeScript("window.scroll(0,500)");
				Thread.sleep(4000);
				
				MethodPOM.clickReadpendingforreview(driver).click();					//Clicking on total items count
				Thread.sleep(500);
				String item = MethodPOM.clickReadpendingforreview(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String LicensependingforreviewCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(LicensependingforreviewCount);
				if(pendingforreviewlicense == total)
					{
						test.log(LogStatus.PASS, "Number of PendingForReview License  grid matches to Dashboard PendingForReview  License   Count.");
						test.log(LogStatus.INFO, "No of PendingForReview  License  in the grid = "+total+" | Dashboard PendingForReview License  Count = "+pendingforreviewlicense);
					}
					else
					{
						test.log(LogStatus.FAIL, "Number of PendingForReview License does not matches to Dashboard PendingForReview License   Count.");
						test.log(LogStatus.INFO, "No of PendingForReview License  in the grid = "+total+" | Dashboard PendingForReview License  Count = "+pendingforreviewlicense);
					}
					Thread.sleep(3000);
					//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
					//Thread.sleep(3000);
					
					MethodPOM.ClickActiveOverview(driver).click();
					test.log(LogStatus.PASS, "PendingForReview License Overview Details Successfully");
					Thread.sleep(3000);
					MethodPOM.ClickCloseOverview(driver).click();
					MethodPOM.clickMyDashboard(driver).click();
	}
	public static void pendingforreviewInternalLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickpendingforreview(driver)));
			String PendingForReview=MethodPOM.clickpendingforreview(driver).getText();
			
		     int pendingforreviewlicense = Integer.parseInt(PendingForReview);	//Reading Pending For Review count.

		      MethodPOM.clickpendingforreview(driver).click();					//Clicking on 'Pending For Review ' image
		      Thread.sleep(4000);
		        JavascriptExecutor js1=(JavascriptExecutor) driver ;
				js1.executeScript("window.scroll(0,500)");
				Thread.sleep(4000);
				
				MethodPOM.clickReadpendingforreview(driver).click();					//Clicking on total items count
				Thread.sleep(500);
				String item = MethodPOM.clickReadpendingforreview(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String LicensependingforreviewCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(LicensependingforreviewCount);
				if(pendingforreviewlicense == total)
					{
						test.log(LogStatus.PASS, "Number of PendingForReview Internal  License  grid matches to Dashboard PendingForReview Internal License   Count.");
						test.log(LogStatus.INFO, "No of PendingForReview Internal  License  in the grid = "+total+" | Dashboard PendingForReview Internal  License  Count = "+pendingforreviewlicense);
					}
					else
					{
						test.log(LogStatus.FAIL, "Number of PendingForReview Internal License does not matches to Dashboard PendingForReview Internal  License   Count.");
						test.log(LogStatus.INFO, "No of PendingForReview Internal  License  in the grid = "+total+" | Dashboard PendingForReview Internal  License  Count = "+pendingforreviewlicense);
					}
					Thread.sleep(3000);
					//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
					//Thread.sleep(3000);
					
					MethodPOM.ClickActiveOverview(driver).click();
					test.log(LogStatus.PASS, "PendingForReview License Overview Details Successfully");
					Thread.sleep(3000);
					MethodPOM.ClickCloseOverview(driver).click();
					MethodPOM.clickMyDashboard(driver).click();
	}
   public static void RejectedLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
   {
	   WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickRejected(driver)));
		String Rejected=MethodPOM.clickRejected(driver).getText();
		
	     int RejectedLicense = Integer.parseInt(Rejected);	//Reading Rejected count.

	      MethodPOM.clickRejected(driver).click();					//Clicking on 'Rejected ' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadRejected(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadRejected(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicensRejected = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicensRejected);
			if(RejectedLicense == total)
				{
					test.log(LogStatus.PASS, "Number of Rejected License  grid matches to Dashboard Rejected  License   Count.");
					test.log(LogStatus.INFO, "No of Rejected  License  in the grid = "+total+" | Dashboard Rejected License  Count = "+RejectedLicense);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Rejected License does not matches to Dashboard Rejected License   Count.");
					test.log(LogStatus.INFO, "No of Rejected License  in the grid = "+total+" | Dashboard Rejected License  Count = "+RejectedLicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, " License Overview Details Successfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				MethodPOM.clickMyDashboard(driver).click();
	   
   }
   public static void RejectedInternalLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
   {
	   WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickRejected(driver)));
		String Rejected=MethodPOM.clickRejected(driver).getText();
		
	     int RejectedLicense = Integer.parseInt(Rejected);	//Reading Rejected count.

	      MethodPOM.clickRejected(driver).click();					//Clicking on 'Rejected ' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadRejected(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadRejected(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicensRejected = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicensRejected);
			if(RejectedLicense == total)
				{
					test.log(LogStatus.PASS, "Number of Rejected Internal License  grid matches to Dashboard Rejected Internal License   Count.");
					test.log(LogStatus.INFO, "No of Rejected Internal License  in the grid = "+total+" | Dashboard Rejected Internal License  Count = "+RejectedLicense);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Rejected Internal  License does not matches to Dashboard Rejected Internal  License   Count.");
					test.log(LogStatus.INFO, "No of Rejected Internal  License  in the grid = "+total+" | Dashboard Rejected Internal  License  Count = "+RejectedLicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, " License Overview Details Successfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				MethodPOM.clickMyDashboard(driver).click();
	   
   }

   public static void TerminateLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
   {
	   WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickTerminate(driver)));
		String Terminate=MethodPOM.clickTerminate(driver).getText();
		
	     int TerminateLicense = Integer.parseInt(Terminate);	//Reading Terminate count.

	      MethodPOM.clickTerminate(driver).click();					//Clicking on 'Terminate ' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadTerminate(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadTerminate(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicensTerminate= bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicensTerminate);
			if(TerminateLicense == total)
				{
					test.log(LogStatus.PASS, "Number of Terminate License  grid matches to Dashboard Terminate  License   Count.");
					test.log(LogStatus.INFO, "No of Terminate  License  in the grid = "+total+" | Dashboard Terminate License  Count = "+TerminateLicense);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Terminate License does not matches to Dashboard Terminate License   Count.");
					test.log(LogStatus.INFO, "No of Terminate License  in the grid = "+total+" | Dashboard Terminate License  Count = "+TerminateLicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
			
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				MethodPOM.clickMyDashboard(driver).click();
	   
   }
   public static void TerminateInternalLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
   {
	   WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickTerminate(driver)));
		String Terminate=MethodPOM.clickTerminate(driver).getText();
		
	     int TerminateLicense = Integer.parseInt(Terminate);	//Reading Terminate count.

	      MethodPOM.clickTerminate(driver).click();					//Clicking on 'Terminate ' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadTerminate(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadTerminate(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicensTerminate= bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicensTerminate);
			if(TerminateLicense == total)
				{
					test.log(LogStatus.PASS, "Number of Terminate Internal License  grid matches to Dashboard Terminate Internal License   Count.");
					test.log(LogStatus.INFO, "No of Terminate Internal  License  in the grid = "+total+" | Dashboard Terminate Internal License  Count = "+TerminateLicense);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Terminate Internal License does not matches to Dashboard Terminate Internal  License   Count.");
					test.log(LogStatus.INFO, "No of Terminate Internal  License  in the grid = "+total+" | Dashboard Terminate Internal  License  Count = "+TerminateLicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
			
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				MethodPOM.clickMyDashboard(driver).click();
	   
   }
   public static void Allfilter(WebDriver driver, ExtentTest test, String type) throws InterruptedException
   {
	   Thread.sleep(3000);
	   MethodPOM.AllFilter(driver).click();
	   Thread.sleep(3000);
	   MethodPOM.InternalFilter(driver).click();
	   
	   MethodPOM.ClickApply(driver).click();
	   
	   
	   
   }
   public static void LicenseExpiredOn(WebDriver driver, ExtentTest test, String type) throws InterruptedException
   {
	   Thread.sleep(3000);
	   MethodPOM.ClickMaximizeLicenseExpiredOn(driver).click();
	  
	   Thread.sleep(3000);
	   MethodPOM.ClickShowMoreExpiredOn(driver).click();
	   
	   Thread.sleep(3000);
	   MethodPOM.ClickExportExpiredOn(driver).click();
		test.log(LogStatus.PASS, "Expired On License List Downloaded Sucessfully");
	   
		Thread.sleep(3000);
		MethodPOM.ClickOverviewExpiredOn(driver).click();
		test.log(LogStatus.PASS, "Expied OverView License Displayed");
	   
	   
	   
   }
   public static void BystatusExpringgraph(WebDriver driver, ExtentTest test, String type) throws InterruptedException
   {
	 
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpringbutnotApplied(driver)));	  
		String BystatusExpiring=MethodPOM.clickExpringbutnotApplied(driver).getText();
		
	     int BystatusExpiringgraph = Integer.parseInt(BystatusExpiring);	//Reading Expiring graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickExpringbutnotApplied(driver).click();					//Clicking on 'Expiring' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	      JavascriptExecutor Js = (JavascriptExecutor) driver;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
			MethodPOM.clickByStatsExpiringReadcount(driver).click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickByStatsExpiringReadcount(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseBystatusExpiringCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicenseBystatusExpiringCount);
			if(BystatusExpiringgraph == total)
				{
					test.log(LogStatus.PASS, "Number of Expiring License  grid matches to Dashboard By status Graph Expiring License Count.");
					test.log(LogStatus.INFO, "No of Expiring  License  in the grid = "+total+" | Dashboard By Status Expiring License  Count = "+BystatusExpiringgraph);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Expiring License does not matches to Dashboard By Status Graph  Expiring License   Count.");
					test.log(LogStatus.INFO, "No of Expiring License  in the grid = "+total+" | Dashboard By Status Expiring License  Count = "+BystatusExpiringgraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			 MethodPOM.clickGraphoverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview(driver).click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			driver.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup(driver).click();
			 Thread.sleep(3000);

   }
   public static void BystatusTerminategraph(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {

	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickBystatusTerminate(driver)));	  
		String BystatusTerminate=MethodPOM.clickBystatusTerminate(driver).getText();
		
	     int BystatusTerminateggraph = Integer.parseInt(BystatusTerminate);	//Reading Terminate graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickBystatusTerminate(driver).click();					//Clicking on 'Terminate' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	      JavascriptExecutor Js = (JavascriptExecutor) driver;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
			MethodPOM.clickBystatusTerminateReadCount(driver).click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickBystatusTerminateReadCount(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseBystatusTerminateCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicenseBystatusTerminateCount);
			if(BystatusTerminateggraph == total)
				{
					test.log(LogStatus.PASS, "Number of Terminate License  grid matches to Dashboard By status Graph Terminate License Count.");
					test.log(LogStatus.INFO, "No of Terminate  License  in the grid = "+total+" | Dashboard By Status Terminate License  Count = "+BystatusTerminateggraph);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Terminate License does not matches to Dashboard By Status Graph  Terminate License   Count.");
					test.log(LogStatus.INFO, "No of Terminate License  in the grid = "+total+" | Dashboard By Status Terminate License  Count = "+BystatusTerminateggraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			 MethodPOM.clickBystatusTerminateOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview(driver).click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			driver.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup(driver).click();
			 Thread.sleep(3000);
			 
   }
   public static void BystatusActivegraph(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {

	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickBystatusActive(driver)));	  
		String BystatusActive=MethodPOM.clickBystatusActive(driver).getText();
		
	     int BystatusActiveggraph = Integer.parseInt(BystatusActive);	//Reading Active graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickBystatusActive(driver).click();					//Clicking on 'Active' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	      JavascriptExecutor Js = (JavascriptExecutor) driver;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
			MethodPOM.clickBystatusActiveReadCount(driver).click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickBystatusActiveReadCount(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseBystatusActiveCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicenseBystatusActiveCount);
			if(BystatusActiveggraph == total)
				{
					test.log(LogStatus.PASS, "Number of Active License  grid matches to Dashboard By status Graph Active License Count.");
					test.log(LogStatus.INFO, "No of Active  License  in the grid = "+total+" | Dashboard By Status Active License  Count = "+BystatusActiveggraph);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Active License does not matches to Dashboard By Status Graph  Active License   Count.");
					test.log(LogStatus.INFO, "No of Active License  in the grid = "+total+" | Dashboard By Status Active License  Count = "+BystatusActiveggraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			 MethodPOM.clickBystatusActiveOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview(driver).click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			driver.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup(driver).click();
			 Thread.sleep(3000);
			 
   }
   public static void BystatusExpiredappliedbutnotrenewedgraph(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {

	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickBystatusExpiredappliedbutnotrenewed(driver)));	  
		String BystatusExpiredappliedbutnotrenewed=MethodPOM.clickBystatusExpiredappliedbutnotrenewed(driver).getText();
		
	     int BystatusExpiredappliedbutnotrenewedgraph = Integer.parseInt(BystatusExpiredappliedbutnotrenewed);	//Reading Applied But not Renewed graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickBystatusExpiredappliedbutnotrenewed(driver).click();					//Clicking on 'Applied but not Renewed' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	      JavascriptExecutor Js = (JavascriptExecutor) driver;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
			MethodPOM.clickBystatusExpiredappliedbutnotrenewedReadCount(driver).click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickBystatusExpiredappliedbutnotrenewedReadCount(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseBystatusAppliedbutnotRenewedCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicenseBystatusAppliedbutnotRenewedCount);
			if(BystatusExpiredappliedbutnotrenewedgraph == total)
				{
					test.log(LogStatus.PASS, "Number of Applied But not Renewed License  grid matches to Dashboard By status Graph Applied But not Renewed License Count.");
					test.log(LogStatus.INFO, "No of Applied But not Renewed  License  in the grid = "+total+" | Dashboard By Status Applied But not Renewed License  Count = "+BystatusExpiredappliedbutnotrenewedgraph);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Applied But not Renewed License does not matches to Dashboard By Status Graph  Applied But not Renewed License   Count.");
					test.log(LogStatus.INFO, "No of Applied But not Renewed License  in the grid = "+total+" | Dashboard By Status Applied But not Renewed License  Count = "+BystatusExpiredappliedbutnotrenewedgraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			 MethodPOM.clickBystatusExpiredappliedbutnotrenewedOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview(driver).click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			driver.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup(driver).click();
			 Thread.sleep(3000);
			 
   }
   public static void BystatusExpired(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {

	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickBystatusExpired(driver)));	  
		String BystatusExpired=MethodPOM.clickBystatusExpired(driver).getText();
		
	     int BystatusExpiredgraph = Integer.parseInt(BystatusExpired);	//Reading Expired graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickBystatusExpired(driver).click();					//Clicking on 'Expired' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	      JavascriptExecutor Js = (JavascriptExecutor) driver;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
			MethodPOM.clickAllReadcount(driver).click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseBystatusExpiredCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicenseBystatusExpiredCount);
			if(BystatusExpiredgraph == total)
				{
					test.log(LogStatus.PASS, "Number of Expired License  grid matches to Dashboard By status Graph Expired License Count.");
					test.log(LogStatus.INFO, "No of Expired License  in the grid = "+total+" | Dashboard By Status Expired License  Count = "+BystatusExpiredgraph);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Expired License does not matches to Dashboard By Status Graph Expired License   Count.");
					test.log(LogStatus.INFO, "No of Expired License  in the grid = "+total+" | Dashboard By Status Expired License  Count = "+BystatusExpiredgraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			 MethodPOM.clickAllOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview(driver).click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			driver.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup(driver).click();
			 Thread.sleep(3000);
			 
   }
   public static void ByLicensetypeExpired(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {

	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeExpired(driver)));	  
		String ByLicenseTypeExpired=MethodPOM.clickByLicnesetypeExpired(driver).getText();
		
	     int ByLicensetypeExpiredgraph = Integer.parseInt(ByLicenseTypeExpired);	//Reading Expired graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeExpired(driver).click();					//Clicking on 'Expired' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	      JavascriptExecutor Js = (JavascriptExecutor) driver;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
			MethodPOM.clickAllReadcount(driver).click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(ByLicensetypeCount);
			if(ByLicensetypeExpiredgraph == total)
				{
					test.log(LogStatus.PASS, "Number of Expired License  grid matches to Dashboard By Licnesetype Graph Expired License Count.");
					test.log(LogStatus.INFO, "No of Expired License  in the grid = "+total+" | Dashboard By Licnesetype Expired License  Count = "+ByLicensetypeExpiredgraph);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Applied License does not matches to Dashboard By Licnesetype Graph Applied License   Count.");
					test.log(LogStatus.INFO, "No of Expired License  in the grid = "+total+" | Dashboard By Licnesetype Expired License  Count = "+ByLicensetypeExpiredgraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			 MethodPOM.clickAllOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview(driver).click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			driver.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup(driver).click();
			 Thread.sleep(3000);
			 
   }
   public static void ByLicensetypeExpiring(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {

	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeExpiring(driver)));	  
		String ByLicenseTypeExpiring=MethodPOM.clickByLicnesetypeExpiring(driver).getText();
		
	     int ByLicensetypeExpiringgraph = Integer.parseInt(ByLicenseTypeExpiring);	//Reading Expiring graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeExpiring(driver).click();					//Clicking on 'Expiring' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	      JavascriptExecutor Js = (JavascriptExecutor) driver;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
			MethodPOM.clickAllReadcount(driver).click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(ByLicensetypeCount);
			if(ByLicensetypeExpiringgraph == total)
				{
					test.log(LogStatus.PASS, "Number of Expiring License  grid matches to Dashboard By Licnesetype Graph Expiring License Count.");
					test.log(LogStatus.INFO, "No of Expiring License  in the grid = "+total+" | Dashboard By Licnese type Expiring License  Count = "+ByLicensetypeExpiringgraph);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Expiring License does not matches to Dashboard By Licnese type Graph Expiring License   Count.");
					test.log(LogStatus.INFO, "No of Expiring License  in the grid = "+total+" | Dashboard By Licnese type Expiring License  Count = "+ByLicensetypeExpiringgraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			 MethodPOM.clickAllOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview(driver).click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			driver.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup(driver).click();
			 Thread.sleep(3000);
			 
   }
   public static void ByLicensetypeApplied(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {

	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeApplied(driver)));	  
		String ByLicenseTypeApplied=MethodPOM.clickByLicnesetypeApplied(driver).getText();
		
	     int ByLicensetypeAppliedggraph = Integer.parseInt(ByLicenseTypeApplied);	//Reading Applied graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeApplied(driver).click();					//Clicking on 'Applied' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	      JavascriptExecutor Js = (JavascriptExecutor) driver;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
			MethodPOM.clickAllReadcount(driver).click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(ByLicensetypeCount);
			if(ByLicensetypeAppliedggraph == total)
				{
					test.log(LogStatus.PASS, "Number of Applied License  grid matches to Dashboard By Licnesetype Graph Applied License Count.");
					test.log(LogStatus.INFO, "No of Applied License  in the grid = "+total+" | Dashboard By Licnese type Applied License  Count = "+ByLicensetypeAppliedggraph);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Applied License does not matches to Dashboard By Licnese type Graph Applied License   Count.");
					test.log(LogStatus.INFO, "No of Applied License  in the grid = "+total+" | Dashboard By Licnese type Applied License  Count = "+ByLicensetypeAppliedggraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			 MethodPOM.clickAllOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview(driver).click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			driver.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup(driver).click();
			 Thread.sleep(3000);
			 
   }
   public static void ByLicensetypeActive(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {

	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	   Js1.executeScript("window.scrollBy(0,1000)");
	   Thread.sleep(3000);
	    WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeActive(driver)));	  
		String ByLicenseTypeActive=MethodPOM.clickByLicnesetypeActive(driver).getText();
		
	     int ByLicensetypeActiveggraph = Integer.parseInt(ByLicenseTypeActive);	//Reading Active graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeActive(driver).click();					//Clicking on 'Active' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	      JavascriptExecutor Js = (JavascriptExecutor) driver;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
			MethodPOM.clickAllReadcount(driver).click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(ByLicensetypeCount);
			if(ByLicensetypeActiveggraph == total)
				{
					test.log(LogStatus.PASS, "Number of Active License  grid matches to Dashboard By Licnesetype Graph Active License Count.");
					test.log(LogStatus.INFO, "No of Active License  in the grid = "+total+" | Dashboard By Licnese type Active License  Count = "+ByLicensetypeActiveggraph);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Active License does not matches to Dashboard By Licnese type Graph Active License   Count.");
					test.log(LogStatus.INFO, "No of Active License  in the grid = "+total+" | Dashboard By Licnese type Active License  Count = "+ByLicensetypeActiveggraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			 MethodPOM.clickAllOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview(driver).click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			driver.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup(driver).click();
			 Thread.sleep(3000);
			 
   }
   public static void ByLicensetypeTerminate(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {

	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	   Js1.executeScript("window.scrollBy(0,1000)");
	   Thread.sleep(3000);
	    WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeTerminate(driver)));	  
		String ByLicenseTypeTerminate=MethodPOM.clickByLicnesetypeTerminate(driver).getText();
		
	     int ByLicensetypeTerminateggraph = Integer.parseInt(ByLicenseTypeTerminate);	//Reading Terminate graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeTerminate(driver).click();					//Clicking on 'Terminate' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	      JavascriptExecutor Js = (JavascriptExecutor) driver;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
			MethodPOM.clickAllReadcount(driver).click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(ByLicensetypeCount);
			if(ByLicensetypeTerminateggraph == total)
				{
					test.log(LogStatus.PASS, "Number of Terminate License  grid matches to Dashboard By Licnesetype Graph Terminate License Count.");
					test.log(LogStatus.INFO, "No of Terminate License  in the grid = "+total+" | Dashboard By Licnese type Terminate License  Count = "+ByLicensetypeTerminateggraph);
				}
				else
				{
					test.log(LogStatus.FAIL, "Number of Terminate License does not matches to Dashboard By Licnese type Graph Terminate License   Count.");
					test.log(LogStatus.INFO, "No of Terminate License  in the grid = "+total+" | Dashboard By Licnese type Terminate License  Count = "+ByLicensetypeTerminateggraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			 MethodPOM.clickAllOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview(driver).click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			driver.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup(driver).click();
			 Thread.sleep(3000);
			 
   }

}


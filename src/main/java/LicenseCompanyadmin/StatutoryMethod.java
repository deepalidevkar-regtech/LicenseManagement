package licenseCompanyadmin;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Table.Cell;
import com.google.inject.Key;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import licenseManagement.licmgmtPOM;
import licensePerformer.LiPerformerPOM;
import licenseReviewer.LiReviewerPOM;
import performer.OverduePOM;

public class StatutoryMethod {
	public static final String Allfilter = null;
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
	
	public static void user(WebDriver driver,ExtentTest test, String Type) throws InterruptedException, IOException
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
		 Thread.sleep(5000);
		 test.log(LogStatus.PASS, "User Created Successfully");
		 
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
	     test.log(LogStatus.PASS, "User Details Updated  Successfully");
		 MethodPOM.ClickUserClose(driver).click();
		 Thread.sleep(5000);
		// MethodPOM.ClickUserSearch(driver).sendKeys("AShish",Keys.ENTER);
		// test.log(LogStatus.PASS, "User Search Successfully");
	    Thread.sleep(3000);
		//// MethodPOM.ClickResetPassword(driver).click();
		// test.log(LogStatus.PASS, "Password Reset Successfully");
		//String AlertMesg= driver.switchTo().alert().getText(); 
		///driver.switchTo().alert().accept();
		//test.log(LogStatus.INFO, AlertMesg);
		
		 
		 
		 
	}
	public static void PageAuthorization(WebDriver driver, ExtentTest test,String type) throws InterruptedException

	{
	  Thread.sleep(3000);
	  MethodPOM.clickMasterMenu(driver).click();
	  
	  Thread.sleep(3000);
	  MethodPOM.ClickPageAuthorization(driver).click();
	  
	  Thread.sleep(3000);
	
	  if(type.equalsIgnoreCase("Internal"))
	  {
		   MethodPOM.ClickPageAutherInternal(driver).click();
		   Thread.sleep(3000);
		   MethodPOM.ClickAutheruser(driver).click();
		   Thread.sleep(3000);
			  MethodPOM.ClickSelectUser(driver).click();
			  Thread.sleep(3000);
			  MethodPOM.ClickAddAuthAddCheck(driver).click();
	  }  
	  else
	  {
		  MethodPOM.ClickAutheruser(driver).click();
		  Thread.sleep(3000);
		  MethodPOM.ClickSelectUser(driver).click();
		  Thread.sleep(3000);
		  MethodPOM.ClickAddAuthAddCheck(driver).click();
	  }
	  Thread.sleep(3000);
	  JavascriptExecutor js=(JavascriptExecutor) driver ;
		js.executeScript("window.scroll(0,1000)");
		
	  Thread.sleep(5000);
	  MethodPOM.ClickPageAutherSave(driver).click();
	  
	  test.log(LogStatus.PASS, "Page Authorization Saved");
	 /*Thread.sleep(3000);
	   MethodPOM.ClickPageAutherAll(driver).click();
	   
	   
	   
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
		  */
	   
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
        MethodPOM.ClickLicenseNumber(driver).sendKeys("Ar2324fdf224123");
        
        Thread.sleep(3000);
        MethodPOM.ClickLicenseTitle(driver).sendKeys("123Update test23 For Automation");
        
        Thread.sleep(3000);
        MethodPOM.ClickLicenseStartDate(driver).sendKeys("22-02-2023");
        
        Thread.sleep(5000);
        MethodPOM.LicenseEnddate(driver).sendKeys("30-05-2026");
        Thread.sleep(5000);
        MethodPOM.LicenseEnddate(driver).click();
        
        Thread.sleep(5000);
        MethodPOM.LicenseUploadDocument(driver).sendKeys("C:\\Users\\dipali\\Desktop\\Bhagyesh\\Oct month test cases 2022.xlsx");
        
        Thread.sleep(5000);
        MethodPOM.FileNumber(driver).sendKeys("5660fsfss5");
        Thread.sleep(5000);
        js1.executeScript("window.scroll(0,500)");
        Thread.sleep(5000);
        MethodPOM.RenewLicenseSubmit(driver).click();    
        Thread.sleep(3000);
       
        js1.executeScript("window.scroll(0,1000)");
      
        MethodPOM.RenewLicenseClose(driver).click();
        
        
   
        
        
    }
    public static void RenewInternalLicense(WebDriver driver,ExtentTest test, String Type) throws InterruptedException

    {
    
     /*  Thread.sleep(3000);
        MethodPOM.selectLicense(driver).click();
        
        Thread.sleep(3000);
        MethodPOM.selectInternalLicense(driver).click();
        */
    	Thread.sleep(4000);
    	MethodPOM.clickMasterMenu(driver).click();
    	
    	Thread.sleep(3000);
        MethodPOM.ClickRenewLicenseMenu(driver).click();
    	Thread.sleep(3000);
    	MethodPOM.selectinttype(driver).click();
    	Thread.sleep(3000);
    	MethodPOM.selectinttype1(driver).click();
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
      
        String strExpected = "Compliance Created and Assigned Sucessfully";
        String valimsg = MethodPOM.valimsg(driver).getText();
		System.out.println(valimsg);
		if (strExpected.equals(valimsg)) 
		{
			test.log(LogStatus.PASS, "Message displayed = "+strExpected);
		} else
		{
			test.log(LogStatus.FAIL, "Message displayed = "+valimsg);
		}
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
	      Thread.sleep(5000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(5000);
			
			MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			int total = Integer.parseInt(LicenseActiveCount);
			if(activelicense == total)
				{
				//	test.log(LogStatus.PASS, "Number of Active License  grid matches to Dashboard Active License   Count.");
					test.log(LogStatus.PASS, "No of Active License  in the grid = "+total+" | Dashboard Active License  Count = "+activelicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Active License does not matches to Dashboard Active License   Count.");
					test.log(LogStatus.FAIL, "No of Active License  in the grid = "+total+" | Dashboard Active License  Count = "+activelicense);
				}
			MethodPOM.ClickActiveOverview(driver).click();
			test.log(LogStatus.PASS, "Activer License Overview Details Successfully");
			Thread.sleep(3000);
			
			MethodPOM.ClickCloseOverview(driver).click();
			Thread.sleep(5000);
				LiPerformerPOM.editlicenseicon(driver).click();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,3000)");
				Thread.sleep(7000);
				/*licmgmtPOM.ClickCal(driver).click();
				 Thread.sleep(7000);
				 licmgmtPOM.NewDate(driver).click();
				 Thread.sleep(5000);
				licmgmtPOM.ClickCal1(driver).click();
				 Thread.sleep(7000);
				licmgmtPOM.NewEndDate(driver).click();
				Thread.sleep(7000);
				*/
				licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
				
				 Thread.sleep(7000);
				    // Switching to Alert       
				        Alert alert = driver.switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= driver.switchTo().alert().getText();
				       
				        Thread.sleep(5000);
				    //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				      System.out.println(alertMessage);
				       
				       
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
				        


	}
	public static void ActiveInternalLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{	
		Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();

			WebDriverWait wait = new WebDriverWait(driver, 20);
			
		
	//	WebDriverWait wait = new WebDriverWait(driver, 20);
		
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
			Thread.sleep(4000);
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicenseActiveCount);
			if(activelicense == total)
				{
					//test.log(LogStatus.PASS, "Number of Active Internal License  grid matches to Dashboard Active Internal License   Count.");
					test.log(LogStatus.PASS, "No of Active  Internal License  in the grid = "+total+" | Dashboard Active Internal  License  Count = "+activelicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Active Internal License does not matches to Dashboard Active Internal License   Count.");
					test.log(LogStatus.FAIL, "No of Active Internal License  in the grid = "+total+" | Dashboard Active Internal License  Count = "+activelicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, "Active License Overview Details Sucessfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				Thread.sleep(3000);
				LiPerformerPOM.editlicenseicon(driver).click();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,3000)");
				Thread.sleep(7000);
				/*licmgmtPOM.ClickCal(driver).click();
				 Thread.sleep(7000);
				 licmgmtPOM.NewDate(driver).click();
				 Thread.sleep(5000);
				licmgmtPOM.ClickCal1(driver).click();
				 Thread.sleep(7000);
				licmgmtPOM.NewEndDate(driver).click();
				Thread.sleep(7000);
				*/
				licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
				
				 Thread.sleep(7000);
				    // Switching to Alert       
				        Alert alert = driver.switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= driver.switchTo().alert().getText();
				       
				        Thread.sleep(5000);
				    //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				      System.out.println(alertMessage);
				       
				       
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
				        
			//	MethodPOM.clickMyDashboard(driver).click();
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
					//test.log(LogStatus.PASS, "Number of Expiring License  grid matches to Dashboard Expiring  License   Count.");
					test.log(LogStatus.PASS, "No of Expiring  License  in the grid = "+total+" | Dashboard Expiring License  Count = "+Expiringlicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expiring License does not matches to Dashboard Expiring License   Count.");
					test.log(LogStatus.FAIL, "No of Expiring License  in the grid = "+total+" | Dashboard Expiring License  Count = "+Expiringlicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, "Expiring License Overview Details Successfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				Thread.sleep(3000);
				LiPerformerPOM.editlicenseicon(driver).click();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,3000)");
				Thread.sleep(7000);
				/*licmgmtPOM.ClickCal(driver).click();
				 Thread.sleep(7000);
				 licmgmtPOM.NewDate(driver).click();
				 Thread.sleep(5000);
				licmgmtPOM.ClickCal1(driver).click();
				 Thread.sleep(7000);
				licmgmtPOM.NewEndDate(driver).click();
				Thread.sleep(7000);
				*/
				licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
				
				 Thread.sleep(7000);
				    // Switching to Alert       
				        Alert alert = driver.switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= driver.switchTo().alert().getText();
				       
				        Thread.sleep(5000);
				    //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				      System.out.println(alertMessage);
				       
				       
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
				MethodPOM.clickMyDashboard(driver).click();
				
	}
	public static void ExpiringInternalLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{	
		Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();

			WebDriverWait wait = new WebDriverWait(driver, 20);
			
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring(driver)));
		String Expiring=MethodPOM.clickExpiring(driver).getText();
		
	     int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.

	      MethodPOM.clickExpiring(driver).click();					//Clicking on 'Expiring' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			String item1 = MethodPOM.clickReadExpiring(driver).getText();	//Reading total items String value
			 Thread.sleep(7000);
			 
	      if(!item1.equalsIgnoreCase("No items to display"))
	      {
			MethodPOM.clickReadExpiring(driver).click();					//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickReadExpiring(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseExpiringCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicenseExpiringCount);
			if(Expiringlicense == total)
				{
					//test.log(LogStatus.PASS, "Number of Expiring Internal  License  grid matches to Dashboard Expiring Internal  License   Count.");
					test.log(LogStatus.PASS, "No of Expiring Internal   License  in the grid = "+total+" | Dashboard Expiring Internal  License  Count = "+Expiringlicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expiring Internal License does not matches to Dashboard Expiring Internal  License   Count.");
					test.log(LogStatus.FAIL, "No of Expiring Internal  License  in the grid = "+total+" | Dashboard Expiring Internal  License  Count = "+Expiringlicense);
				}
				Thread.sleep(3000);
				js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, "Expiring License Overview Details Sucessfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				Thread.sleep(3000);
				LiPerformerPOM.editlicenseicon(driver).click();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,3000)");
				Thread.sleep(7000);
				/*licmgmtPOM.ClickCal(driver).click();
				 Thread.sleep(7000);
				 licmgmtPOM.NewDate(driver).click();
				 Thread.sleep(5000);
				licmgmtPOM.ClickCal1(driver).click();
				 Thread.sleep(7000);
				licmgmtPOM.NewEndDate(driver).click();
				Thread.sleep(7000);
				*/
				licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
				
				 Thread.sleep(7000);
				    // Switching to Alert       
				        Alert alert = driver.switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= driver.switchTo().alert().getText();
				       
				        Thread.sleep(5000);
				    //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				      System.out.println(alertMessage);
				       
				       
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
	
				
				//MethodPOM.clickMyDashboard(driver).click();
	      
	      }		
	      else
	      {
				test.log(LogStatus.PASS,"No record Found" );
				MethodPOM.clickMyDashboard(driver).click();
				
	      }

	      		
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
					//test.log(LogStatus.PASS, "Number of Expired License  grid matches to Dashboard Expired  License   Count.");
					test.log(LogStatus.PASS, "No of Expired  License  in the grid = "+total+" | Dashboard Expired License  Count = "+Expiredlicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expired License does not matches to Dashboard Expired License   Count.");
					test.log(LogStatus.FAIL, "No of Expired License  in the grid = "+total+" | Dashboard Expired License  Count = "+Expiredlicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, "Expired License Overview Details Successfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				Thread.sleep(3000);
				LiPerformerPOM.editlicenseicon(driver).click();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,3000)");
				Thread.sleep(7000);
				/*licmgmtPOM.ClickCal(driver).click();
				 Thread.sleep(7000);
				 licmgmtPOM.NewDate(driver).click();
				 Thread.sleep(5000);
				licmgmtPOM.ClickCal1(driver).click();
				 Thread.sleep(7000);
				licmgmtPOM.NewEndDate(driver).click();
				Thread.sleep(7000);
				*/
				licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
				
				 Thread.sleep(7000);
				    // Switching to Alert       
				        Alert alert = driver.switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= driver.switchTo().alert().getText();
				       
				        Thread.sleep(5000);
				    //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				      System.out.println(alertMessage);
				       
				       
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
				MethodPOM.clickMyDashboard(driver).click();
			

		
	}
	public static void ExpiredInternalLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();

			WebDriverWait wait = new WebDriverWait(driver, 20);
			
   //   WebDriverWait wait = new WebDriverWait(driver, 20);
		
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
					//test.log(LogStatus.PASS, "Number of Expired Internal License  grid matches to Dashboard Expired Internal License   Count.");
					test.log(LogStatus.PASS, "No of Expired Internal  License  in the grid = "+total+" | Dashboard Expired Internal License  Count = "+Expiredlicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expired Internal  License does not matches to Dashboard Expired Internal  License   Count.");
					test.log(LogStatus.FAIL, "No of Expired Internal License  in the grid = "+total+" | Dashboard Expired Internal  License  Count = "+Expiredlicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, "Expired License Overview Details Succ essfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				LiPerformerPOM.editlicenseicon(driver).click();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,3000)");
				Thread.sleep(7000);
				/*licmgmtPOM.ClickCal(driver).click();
				 Thread.sleep(7000);
				 licmgmtPOM.NewDate(driver).click();
				 Thread.sleep(5000);
				licmgmtPOM.ClickCal1(driver).click();
				 Thread.sleep(7000);
				licmgmtPOM.NewEndDate(driver).click();
				Thread.sleep(7000);
				*/
				licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
				
				 Thread.sleep(7000);
				    // Switching to Alert       
				        Alert alert = driver.switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= driver.switchTo().alert().getText();
				       
				        Thread.sleep(5000);
				    //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				      System.out.println(alertMessage);
				       
				       
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
	
	
				
				//MethodPOM.clickMyDashboard(driver).click();

		
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
						//test.log(LogStatus.PASS, "Number of Applied License  grid matches to Dashboard Applied  License   Count.");
						test.log(LogStatus.PASS, "No of Applied  License  in the grid = "+total+" | Dashboard Applied License  Count = "+Appliedlicense);
					}
					else
					{
						//test.log(LogStatus.FAIL, "Number of Applied License does not matches to Dashboard Applied License   Count.");
						test.log(LogStatus.FAIL, "No of Applied License  in the grid = "+total+" | Dashboard Applied License  Count = "+Appliedlicense);
					}
					Thread.sleep(3000);
					//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
					//Thread.sleep(3000);
					
					MethodPOM.ClickActiveOverview(driver).click();
					test.log(LogStatus.PASS, "Applied License Overview Details Successfully");
					Thread.sleep(3000);
					MethodPOM.ClickCloseOverview(driver).click();
					Thread.sleep(3000);
					LiPerformerPOM.editlicenseicon(driver).click();
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseNo(driver).clear();
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
					Thread.sleep(5000);
					js1.executeScript("window.scrollBy(0,3000)");
					Thread.sleep(7000);
					/*licmgmtPOM.ClickCal(driver).click();
					 Thread.sleep(7000);
					 licmgmtPOM.NewDate(driver).click();
					 Thread.sleep(5000);
					licmgmtPOM.ClickCal1(driver).click();
					 Thread.sleep(7000);
					licmgmtPOM.NewEndDate(driver).click();
					Thread.sleep(7000);
					*/
					licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
					
					 Thread.sleep(7000);
					    // Switching to Alert       
					        Alert alert = driver.switchTo().alert();
					       
					        // Capturing alert message.   
					        String alertMessage= driver.switchTo().alert().getText();
					       
					        Thread.sleep(5000);
					    //  test.log(LogStatus.PASS, alertMessage);
					       
					        // Displaying alert message
					      System.out.println(alertMessage);
					       
					       
					        // Accepting alert
					        alert.accept();
					        test.log(LogStatus.PASS,"License Details Updated Successfully" );
					MethodPOM.clickMyDashboard(driver).click();
					

	}
	public static void AppliedInternalLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		
		 Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   MethodPOM.clickDashlicensetype(driver).click();
		   Thread.sleep(3000);
		   
		   MethodPOM.SearchInternalLicenseType(driver).sendKeys("Annual Maintenance",Keys.ENTER);
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
		   

			WebDriverWait wait = new WebDriverWait(driver, 20);
			
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickApplied(driver)));
			String Applied=MethodPOM.clickApplied(driver).getText();
			
		     int Appliedlicense = Integer.parseInt(Applied);	//Reading Applied count.

		      MethodPOM.clickApplied(driver).click();					//Clicking on 'Applied' image
		      Thread.sleep(4000);
		 
		      wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickTabelGrid(driver)));
		      
		      Thread.sleep(4000);

	    	   JavascriptExecutor js1=(JavascriptExecutor) driver ;
				js1.executeScript("window.scroll(0,500)");
				String item1 = MethodPOM.clickReadApplied(driver).getText();	//Reading total items String value
				 Thread.sleep(7000);
		      if(!item1.equalsIgnoreCase("No items to display"))
		      {
		    	//   JavascriptExecutor js=(JavascriptExecutor) driver ;
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
							//test.log(LogStatus.PASS, "Number of Applied Internal  License  grid matches to Dashboard Applied Internal  License   Count.");
							test.log(LogStatus.PASS, "No of Applied Internal   License  in the grid = "+total+" | Dashboard Applied Internal  License  Count = "+Appliedlicense);
						}
						else
						{
							//test.log(LogStatus.FAIL, "Number of Applied Internal License does not matches to Dashboard Applied Internal  License   Count.");
							test.log(LogStatus.FAIL, "No of Applied Internal  License  in the grid = "+total+" | Dashboard Applied Internal  License  Count = "+Appliedlicense);
						}
						Thread.sleep(3000);
						//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
						//Thread.sleep(3000);
						
						MethodPOM.ClickActiveOverview(driver).click();
						test.log(LogStatus.PASS, " Applied License Overview Details Sucessfully");
						Thread.sleep(3000);
						MethodPOM.ClickCloseOverview(driver).click();
						LiPerformerPOM.editlicenseicon(driver).click();
						Thread.sleep(5000);
						licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
						Thread.sleep(5000);
						licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
						Thread.sleep(5000);
						licenseManagement.licmgmtPOM.LicenseNo(driver).clear();
						Thread.sleep(5000);
						licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
						Thread.sleep(5000);
						js1.executeScript("window.scrollBy(0,3000)");
						Thread.sleep(7000);
						/*licmgmtPOM.ClickCal(driver).click();
						 Thread.sleep(7000);
						 licmgmtPOM.NewDate(driver).click();
						 Thread.sleep(5000);
						licmgmtPOM.ClickCal1(driver).click();
						 Thread.sleep(7000);
						licmgmtPOM.NewEndDate(driver).click();
						Thread.sleep(7000);
						*/
						licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
						
						 Thread.sleep(7000);
						    // Switching to Alert       
						        Alert alert = driver.switchTo().alert();
						       
						        // Capturing alert message.   
						        String alertMessage= driver.switchTo().alert().getText();
						       
						        Thread.sleep(5000);
						    //  test.log(LogStatus.PASS, alertMessage);
						       
						        // Displaying alert message
						      System.out.println(alertMessage);
						       
						       
						        // Accepting alert
						        alert.accept();
						        test.log(LogStatus.PASS,"License Details Updated Successfully" );

					//	MethodPOM.clickMyDashboard(driver).click();
						
						
		      }
		      else
		      {
					test.log(LogStatus.PASS,"No record Found" );
					MethodPOM.clickMyDashboard(driver).click();
					
		      }
		      		    	  

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
				Thread.sleep(5000);
				String item = MethodPOM.clickReadpendingforreview(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String LicensependingforreviewCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(LicensependingforreviewCount);
				if(pendingforreviewlicense == total)
					{
					//	test.log(LogStatus.PASS, "Number of PendingForReview License  grid matches to Dashboard PendingForReview  License   Count.");
						test.log(LogStatus.PASS, "No of Pending For Review  License  in the grid = "+total+" | Dashboard Pending For Review License  Count = "+pendingforreviewlicense);
					}
					else
					{
						//test.log(LogStatus.FAIL, "Number of PendingForReview License does not matches to Dashboard PendingForReview License   Count.");
						test.log(LogStatus.FAIL, "No of Pending For Review License  in the grid = "+total+" | Dashboard Pending For Review License  Count = "+pendingforreviewlicense);
					}
					Thread.sleep(3000);
					//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
					//Thread.sleep(3000);
					
					MethodPOM.ClickActiveOverview(driver).click();
					test.log(LogStatus.PASS, "PendingForReview License Overview Details Successfully");
					Thread.sleep(3000);
					MethodPOM.ClickCloseOverview(driver).click();
					Thread.sleep(5000);
					/*LiPerformerPOM.editlicenseicon(driver).click();
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseNo(driver).clear();
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
					Thread.sleep(5000);
					js1.executeScript("window.scrollBy(0,3000)");
					Thread.sleep(7000);
					/*licmgmtPOM.ClickCal(driver).click();
					 Thread.sleep(7000);
					 licmgmtPOM.NewDate(driver).click();
					 Thread.sleep(5000);
					licmgmtPOM.ClickCal1(driver).click();
					 Thread.sleep(7000);
					licmgmtPOM.NewEndDate(driver).click();
					Thread.sleep(7000);
					
					licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
					
					 Thread.sleep(7000);
					    // Switching to Alert       
					        Alert alert = driver.switchTo().alert();
					       
					        // Capturing alert message.   
					        String alertMessage= driver.switchTo().alert().getText();
					       
					        Thread.sleep(5000);
					    //  test.log(LogStatus.PASS, alertMessage);
					       
					        // Displaying alert message
					      System.out.println(alertMessage);
					       
					       
					        // Accepting alert
					        alert.accept();
					        test.log(LogStatus.PASS,"License Details Updated Successfully" );
					       */
					MethodPOM.clickMyDashboard(driver).click();
	
	}
	public static void pendingforreviewInternalLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		 Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
		   
		   
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			

			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickpendingforreview(driver)));
			String pendingforreviewlicense=MethodPOM.clickpendingforreview(driver).getText();
			
		     int PendingForReviewlicense = Integer.parseInt(pendingforreviewlicense);	//Reading Expired count.

		      MethodPOM.clickpendingforreview(driver).click();					//Clicking on 'Expired' image
		      Thread.sleep(4000);
		 
		      wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickTabelGrid(driver)));
		      
		      Thread.sleep(4000);
	    	   JavascriptExecutor js1=(JavascriptExecutor) driver ;
				js1.executeScript("window.scroll(0,500)");
				String item1 = MethodPOM.clickReadpendingforreview(driver).getText();	//Reading total items String value
			      Thread.sleep(7000);
		      if(!item1.equalsIgnoreCase("No items to display"))
		      {

		       // JavascriptExecutor js1=(JavascriptExecutor) driver ;
				js1.executeScript("window.scroll(0,500)");
				Thread.sleep(4000);
				
				MethodPOM.clickReadpendingforreview(driver).click();					//Clicking on total items count
				Thread.sleep(500);
				String item = MethodPOM.clickReadpendingforreview(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String LicensependingforreviewCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(LicensependingforreviewCount);
				if(PendingForReviewlicense == total)
					{
						//test.log(LogStatus.PASS, "Number of PendingForReview Internal  License  grid matches to Dashboard PendingForReview Internal License   Count.");
						test.log(LogStatus.PASS, "No of PendingForReview Internal  License  in the grid = "+total+" | Dashboard PendingForReview Internal  License  Count = "+pendingforreviewlicense);
					}
					else
					{
						//test.log(LogStatus.FAIL, "Number of PendingForReview Internal License does not matches to Dashboard PendingForReview Internal  License   Count.");
						test.log(LogStatus.FAIL, "No of PendingForReview Internal  License  in the grid = "+total+" | Dashboard PendingForReview Internal  License  Count = "+pendingforreviewlicense);
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
					else
					{
						test.log(LogStatus.PASS,"No record Found" );
						MethodPOM.clickMyDashboard(driver).click();
						}
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
					//test.log(LogStatus.PASS, "Number of Rejected License  grid matches to Dashboard Rejected  License   Count.");
					test.log(LogStatus.PASS, "No of Rejected  License  in the grid = "+total+" | Dashboard Rejected License  Count = "+RejectedLicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Rejected License does not matches to Dashboard Rejected License   Count.");
					test.log(LogStatus.FAIL, "No of Rejected License  in the grid = "+total+" | Dashboard Rejected License  Count = "+RejectedLicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, " License Overview Details Successfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				Thread.sleep(3000);
				LiPerformerPOM.editlicenseicon(driver).click();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,3000)");
				Thread.sleep(7000);
				/*licmgmtPOM.ClickCal(driver).click();
				 Thread.sleep(7000);
				 licmgmtPOM.NewDate(driver).click();
				 Thread.sleep(5000);
				licmgmtPOM.ClickCal1(driver).click();
				 Thread.sleep(7000);
				licmgmtPOM.NewEndDate(driver).click();
				Thread.sleep(7000);
				*/
				licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
				
				 Thread.sleep(7000);
				    // Switching to Alert       
				        Alert alert = driver.switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= driver.switchTo().alert().getText();
				       
				        Thread.sleep(5000);
				    //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				      System.out.println(alertMessage);
				       
				       
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
				MethodPOM.clickMyDashboard(driver).click();
	
	   
   }
   public static void RejectedInternalLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
   {
	   Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
		   
	   WebDriverWait wait = new WebDriverWait(driver, 40);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickRejected(driver)));
		String Rejected=MethodPOM.clickRejected(driver).getText();
		
	     int RejectedLicense = Integer.parseInt(Rejected);	//Reading Rejected count.

	      MethodPOM.clickRejected(driver).click();					//Clicking on 'Rejected ' image
	      Thread.sleep(4000);
	      wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickTabelGrid(driver)));
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(7000);
			String item1 = MethodPOM.clickReadpendingforreview(driver).getText();	//Reading total items String value
			Thread.sleep(7000);
		      if(!item1.equalsIgnoreCase("No items to display"))
		      {
			
			MethodPOM.clickReadRejected(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadRejected(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicensRejected = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicensRejected);
			if(RejectedLicense == total)
				{
					//test.log(LogStatus.PASS, "Number of Rejected Internal License  grid matches to Dashboard Rejected Internal License   Count.");
					test.log(LogStatus.PASS, "No of Rejected Internal License  in the grid = "+total+" | Dashboard Rejected Internal License  Count = "+RejectedLicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Rejected Internal  License does not matches to Dashboard Rejected Internal  License   Count.");
					test.log(LogStatus.FAIL, "No of Rejected Internal  License  in the grid = "+total+" | Dashboard Rejected Internal  License  Count = "+RejectedLicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, " License Overview Details Successfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				LiPerformerPOM.editlicenseicon(driver).click();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,3000)");
				Thread.sleep(7000);
				/*licmgmtPOM.ClickCal(driver).click();
				 Thread.sleep(7000);
				 licmgmtPOM.NewDate(driver).click();
				 Thread.sleep(5000);
				licmgmtPOM.ClickCal1(driver).click();
				 Thread.sleep(7000);
				licmgmtPOM.NewEndDate(driver).click();
				Thread.sleep(7000);
				*/
				licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
				
				 Thread.sleep(7000);
				    // Switching to Alert       
				        Alert alert = driver.switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= driver.switchTo().alert().getText();
				       
				        Thread.sleep(5000);
				    //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				      System.out.println(alertMessage);
				       
				       
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
	
				//MethodPOM.clickMyDashboard(driver).click();
				}
				else
				{
					test.log(LogStatus.PASS,"No record Found" );
					MethodPOM.clickMyDashboard(driver).click();
					}
	   
   }

   public static void TerminateLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
   {
	  
		   
	   WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickTerminateper(driver)));
		String Terminate=MethodPOM.clickTerminateper(driver).getText();
		
	     int TerminateLicense = Integer.parseInt(Terminate);	//Reading Terminate count.

	      MethodPOM.clickTerminateper(driver).click();					//Clicking on 'Terminate ' image
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
					//test.log(LogStatus.PASS, "Number of Terminate License  grid matches to Dashboard Terminate  License   Count.");
					test.log(LogStatus.PASS, "No of Terminate  License  in the grid = "+total+" | Dashboard Terminate License  Count = "+TerminateLicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Terminate License does not matches to Dashboard Terminate License   Count.");
					test.log(LogStatus.FAIL, "No of Terminate License  in the grid = "+total+" | Dashboard Terminate License  Count = "+TerminateLicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, " License Overview Details Successfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();

				
				MethodPOM.clickMyDashboard(driver).click();
	   
   }
   public static void TerminateInternalLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
   {
	   Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
	   WebDriverWait wait = new WebDriverWait(driver, 20);
	   Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickTerminateperin(driver)));
		String Terminate=MethodPOM.clickTerminateperin(driver).getText();
		
	     int TerminateLicense = Integer.parseInt(Terminate);	//Reading Terminate count.
	 	Thread.sleep(5000);
	      MethodPOM.clickTerminateperin(driver).click();					//Clicking on 'Terminate ' image
	      Thread.sleep(7000);
	      wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickTabelGrid(driver)));
	      Thread.sleep(7000);
	      String item1 = MethodPOM.clickReadpendingforreview(driver).getText();	//Reading total items String value
			Thread.sleep(7000);
			
		      if(!item1.equalsIgnoreCase("No items to display"))
		      {
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(5000);
			
			MethodPOM.clickReadTerminate(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadTerminate(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicensTerminate= bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicensTerminate);
			if(TerminateLicense == total)
				{
					//test.log(LogStatus.PASS, "Number of Terminate Internal License  grid matches to Dashboard Terminate Internal License   Count.");
					test.log(LogStatus.PASS, "No of Terminate Internal  License  in the grid = "+total+" | Dashboard Terminate Internal License  Count = "+TerminateLicense);
				}
				else
				{
				//	test.log(LogStatus.FAIL, "Number of Terminate Internal License does not matches to Dashboard Terminate Internal  License   Count.");
					test.log(LogStatus.FAIL, "No of Terminate Internal  License  in the grid = "+total+" | Dashboard Terminate Internal  License  Count = "+TerminateLicense);
				}
				Thread.sleep(5000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, " License Overview Details Successfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				MethodPOM.clickMyDashboard(driver).click();
		      }
					else
					{
						test.log(LogStatus.PASS,"No record Found" );
						MethodPOM.clickMyDashboard(driver).click();
						}
		   
		   }
   
   public static void Allfilter(WebDriver driver, ExtentTest test, String type) throws InterruptedException
   {
	   Thread.sleep(3000);
	   MethodPOM.AllFilter(driver).click();
	   Thread.sleep(3000);
	   MethodPOM.InternalFilter(driver).click();
	   MethodPOM.clickDashlicensetype(driver).click();
	   MethodPOM.DashSearchLienseType(driver).sendKeys("Annual Maintenance",Keys.ENTER);
	   MethodPOM.ClickApply(driver).click();
	   test.log(LogStatus.PASS, "All Filter Working Successfully");
	   MethodPOM.DashoardClearBtn(driver).click();
	   test.log(LogStatus.PASS, "Clear Button Working Successfully");
	   MethodPOM.clickMyDashboard(driver).click();
	   
	   
	   
	   
   }
   public static void LicenseExpiredOnInternal(WebDriver driver, ExtentTest test, String type) throws InterruptedException
   {
	   Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
	   Thread.sleep(3000);
	   MethodPOM.ClickMaximizeLicenseExpiredOn(driver).click();
	   test.log(LogStatus.PASS, "ExpiredOn License Maximize Button Working Successfully.");
	   Thread.sleep(3000);
	   JavascriptExecutor js1=(JavascriptExecutor) driver ;
		js1.executeScript("window.scroll(0,500)");
		Thread.sleep(500);
		 MethodPOM.ClickOnDashExpiredExport(driver).click();  
		 test.log(LogStatus.PASS, "Dashboard ExpiredOn License List Downloaded Successfully.");
		
	   MethodPOM.ClickShowMoreExpiredOnInternal(driver).click();
	   
	   test.log(LogStatus.PASS, "ExpiredOn License show More link working Successfully. ");
	   
	   WebDriverWait wait = new WebDriverWait(driver, 40);
		Thread.sleep(5000);
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
	   Thread.sleep(3000);
	   MethodPOM.ClickExportExpiredOn(driver).click();
		test.log(LogStatus.PASS, "ExpiredOn License List Downloaded Successfully.");
	    MethodPOM.licdropdown(driver).click();
	    Thread.sleep(3000);
	     MethodPOM.selecttypecomadmin(driver).click();
		Thread.sleep(3000);
		licmgmtPOM.workspaceclear(driver).click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "ExpiredOn Popup Clear filter Button working Successfully.");
		MethodPOM.ClickOverviewExpiredOn(driver).click();
		test.log(LogStatus.PASS, "ExpiredOn Overview Button Working Successfully.");
		Thread.sleep(3000);
        MethodPOM.clickBystatuscloseoverview(driver).click();
		 Thread.sleep(2000);
		  // Js.executeScript("window.scrollBy(500,0)");
		driver.switchTo().parentFrame();
		 MethodPOM.clickCloseGraphPopup(driver).click();
		 Thread.sleep(3000);
  
   
		 
		 
   }
   public static void LicenseExpiredOnStatutory(WebDriver driver, ExtentTest test, String type) throws InterruptedException
   {
	   Thread.sleep(3000);
	   
	   MethodPOM.ClickMaximizeLicenseExpiredOn(driver).click();
	   test.log(LogStatus.PASS, "Expired Maximize Button Working Successfully");
	   Thread.sleep(3000);
	   JavascriptExecutor js1=(JavascriptExecutor) driver ;
		js1.executeScript("window.scroll(0,500)");
        MethodPOM.ClickExportExpiredOn1(driver).click();
        test.log(LogStatus.PASS, "Dashboard ExpiredOn License List Downloaded Sucessfully");
        Thread.sleep(3000);
		
	   LiPerformerPOM.click11(driver).click();
	   test.log(LogStatus.PASS, "ExpiredOn Show More link working Successfully");
	   WebDriverWait wait = new WebDriverWait(driver, 40);
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
	   Thread.sleep(5000);
	   js1.executeScript("window.scroll(0,500)");
	   String NoRecord = MethodPOM.Norecord(driver).getText();
	   if(!NoRecord.equalsIgnoreCase("No items to display")) 
	   {
	   
	   MethodPOM.ClickExportExpiredOn(driver).click();
		test.log(LogStatus.PASS, "Expired License List Downloaded Sucessfully");
		Thread.sleep(5000);
		MethodPOM.ExpiredOnLictype(driver).click();
		MethodPOM.searchExpiredOnLictype(driver).sendKeys("Boiler",Keys.ENTER);
		MethodPOM.Clearfilter(driver).click();
	//	test.log(LogStatus.PASS, "Clear Filter Button Working  Successfully");
		
    
		Thread.sleep(7000);
	    licenseManagement.licmgmtPOM.lictype(driver).click();
		Thread.sleep(7000);
	    licenseManagement.licmgmtPOM.lictype1(driver).click();
		Thread.sleep(7000);
		MethodPOM.Clearfilter(driver).click();
		test.log(LogStatus.PASS, "Clear Filter Button Working  Successfully");
		Thread.sleep(7000);
		MethodPOM.ClickOverviewExpiredOn(driver).click();
		test.log(LogStatus.PASS, "Expired OverView License Displayed");
		 Thread.sleep(3000);
             MethodPOM.clickBystatuscloseoverview(driver).click();
			 Thread.sleep(2000);
			
			
			  // Js.executeScript("window.scrollBy(500,0)");
			driver.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup(driver).click();
			 Thread.sleep(3000);
			
	   }
	   else
	   {
		   driver.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup(driver).click();
			 Thread.sleep(3000);
			  test.log(LogStatus.PASS, "Expired On Popup No Record Found ");
	   }
   }
   public static void LicenseExpiringOnStatutory(WebDriver driver, ExtentTest test, String type) throws InterruptedException, IOException
   {
	   Thread.sleep(5000);
	   MethodPOM.ClickMaximizeLicenseExpiringOn(driver).click();
	   Thread.sleep(3000);
	   test.log(LogStatus.PASS, "Expiring On Maximize Button Working Successfully");
	 
	   JavascriptExecutor js1=(JavascriptExecutor) driver ;
		js1.executeScript("window.scroll(0,500)");
		  Thread.sleep(3000);
		MethodPOM.DashExpiringOnExport(driver).click();
		test.log(LogStatus.PASS, "Dashboard Expiring License Download Successfully");
		
	   MethodPOM.ClickShowMoreExpiringOnStatutory(driver).click();
	   Thread.sleep(7000);
	 /* licenseManagement.licmgmtPOM.lictype(driver).click();
	   Thread.sleep(7000);
	   licenseManagement.licmgmtPOM.lictype1(driver).click();
	   Thread.sleep(3000);
	   MethodPOM.Clearfilter(driver).click();
		test.log(LogStatus.PASS, "Clear Filter Button Working  Successfully");
	   */
	   WebDriverWait wait = new WebDriverWait(driver, 40);
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
	   Thread.sleep(3000);
	   
	  // MethodPOM.ClickExportExpiredOn(driver).click();
		
	   int flag = 0;
		try
		{
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.checkTable1(driver)));	//Waiting until records table gets visible.
			flag = 1;
		}
		catch(Exception e)
		{
			
		}
		
		if(flag == 1)
		{
			js1.executeScript("window.scrollBy(0,1000)");				//Scrolling down window by 2000 px.
			
			Thread.sleep(700);
			String item = MethodPOM.clickReadActive(driver).getText();
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count = 0;
			if(LicenseCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2500);
				item = MethodPOM.clickReadActive(driver).getText();
				bits = item.split(" ");										//Splitting the String
				LicenseCount = bits[bits.length - 2];					//Getting the second last word (total number of users)
			}
			count = Integer.parseInt(LicenseCount);
			
			File dir = new File("C:\\Users\\dipali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			js1.executeScript("window.scrollBy(0,-2000)");				//Scrolling down window by 2000 px.
			Thread.sleep(500);
			MethodPOM.ClickExportExpiredOn(driver).click();						//Clicking on Excel Image.
			
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\dipali\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, type+" :- File downloaded successfully.");
				
				fis = new FileInputStream(lastModifiedFile);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				int no = sheet.getLastRowNum();
				int SheetRecords = no - 0;						//Sheet have extra 5 lines of information at top (But row count started from 0, so -4)
				fis.close();
				
				if(count == SheetRecords)
				{
					//test.log(LogStatus.PASS, "Count of records displayed from grid matches to number records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from grid = "+count+" | Total records in Excel Sheet = "+SheetRecords);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Count of records displayed from grid doesn't matches to number records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from grid = "+count+" | Total records in Excel Sheet = "+SheetRecords);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, type+" :- File doesn't downloaded successfully.");
			}
		}
		else
		{
			test.log(LogStatus.PASS, type+" :- Records not displayed (available). Excel sheet didn't downloaded");
		}
		driver.switchTo().parentFrame();
		 MethodPOM.clickCloseGraphPopup(driver).click();
		 Thread.sleep(3000);
         
	   
   }
   public static void BystatusExpringInternalgraph(WebDriver driver, ExtentTest test, String type) throws InterruptedException
   {
	   Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
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
					//test.log(LogStatus.PASS, "Number of Expiring License  grid matches to Dashboard By status Graph Expiring License Count.");
					test.log(LogStatus.PASS, "No of Expiring  License  in the grid = "+total+" | Dashboard By Status Expiring License  Count = "+BystatusExpiringgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expiring License does not matches to Dashboard By Status Graph  Expiring License   Count.");
					test.log(LogStatus.FAIL, "No of Expiring License  in the grid = "+total+" | Dashboard By Status Expiring License  Count = "+BystatusExpiringgraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
			 Thread.sleep(3000);
			 licmgmtPOM.clicktypeinternal(driver).click();
			 Thread.sleep(5000);
			  licmgmtPOM.selecttypein(driver).click();
				 Thread.sleep(5000);
				 MethodPOM.GraphPopupClear(driver).click();
				 test.log(LogStatus.PASS, "Clear Button Working Successfully.");
				 Thread.sleep(5000);
			 MethodPOM.clickGraphoverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License Overview Details Open  Successfully.");
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview(driver).click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			driver.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup(driver).click();
			 Thread.sleep(3000);

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
					//test.log(LogStatus.PASS, "Number of Expiring License  grid matches to Dashboard By status Graph Expiring License Count.");
					test.log(LogStatus.PASS, "No of Expiring  License  in the grid = "+total+" | Dashboard By Status Expiring License  Count = "+BystatusExpiringgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expiring License does not matches to Dashboard By Status Graph  Expiring License   Count.");
					test.log(LogStatus.FAIL, "No of Expiring License  in the grid = "+total+" | Dashboard By Status Expiring License  Count = "+BystatusExpiringgraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			 Thread.sleep(5000);
			/* MethodPOM.BystatusExpiringLicensetype(driver).click();
			 Thread.sleep(5000);
			 //MethodPOM.BystatusExpiringsearchLicensetype(driver).click();
			 MethodPOM.Clicllicensetype(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.GraphPopupClear(driver).click();
			 test.log(LogStatus.PASS, "Clear Button Working successfully");
			 Thread.sleep(5000);
			 */
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
					//test.log(LogStatus.PASS, "Number of Terminate License  grid matches to Dashboard By status Graph Terminate License Count.");
					test.log(LogStatus.PASS, "No of Terminate  License  in the grid = "+total+" | Dashboard By Status Terminate License  Count = "+BystatusTerminateggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Terminate License does not matches to Dashboard By Status Graph  Terminate License   Count.");
					test.log(LogStatus.FAIL, "No of Terminate License  in the grid = "+total+" | Dashboard By Status Terminate License  Count = "+BystatusTerminateggraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			 Thread.sleep(4000);
			/* MethodPOM.BystatusExpiringLicensetype(driver).click();
			 Thread.sleep(5000);
			 //MethodPOM.BystatusExpiringsearchLicensetype(driver).click();
			 MethodPOM.Clicllicensetype(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.GraphPopupClear(driver).click();
			 test.log(LogStatus.PASS, "Clear Button Working successfully");
			 Thread.sleep(5000);
			 */
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
					//test.log(LogStatus.PASS, "Number of Active License  grid matches to Dashboard By status Graph Active License Count.");
					test.log(LogStatus.PASS, "No of Active  License  in the grid = "+total+" | Dashboard By Status Active License  Count = "+BystatusActiveggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Active License does not matches to Dashboard By Status Graph  Active License   Count.");
					test.log(LogStatus.FAIL, "No of Active License  in the grid = "+total+" | Dashboard By Status Active License  Count = "+BystatusActiveggraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			 Thread.sleep(4000);
			// MethodPOM.BystatusExpiringLicensetype(driver).click();
			 Thread.sleep(5000);
			/* MethodPOM.BystatusExpiringsearchLicensetype(driver).click();
			MethodPOM.Clicllicensetype(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.GraphPopupClear(driver).click();
			 test.log(LogStatus.PASS, "Clear Button Working successfully");
			 Thread.sleep(5000);
			 */
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
   public static void BystatusActiveInternalgraph(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {

	   Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
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
					//test.log(LogStatus.PASS, "Number of Active License  grid matches to Dashboard By status Graph Active License Count.");
					test.log(LogStatus.PASS, "No of Active  License  in the grid = "+total+" | Dashboard By Status Active License  Count = "+BystatusActiveggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Active License does not matches to Dashboard By Status Graph  Active License   Count.");
					test.log(LogStatus.FAIL, "No of Active License  in the grid = "+total+" | Dashboard By Status Active License  Count = "+BystatusActiveggraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Successfully.");
			 Thread.sleep(5000);
		     /* licmgmtPOM.clicktypeinternal(driver).click();
			 Thread.sleep(5000);
			  licmgmtPOM.selecttypein(driver).click();
				 Thread.sleep(5000);
				 MethodPOM.GraphPopupClear(driver).click();
				 test.log(LogStatus.PASS, "Clear Button Working Successfully.");
				 Thread.sleep(5000);
			// MethodPOM.BystatusExpiringLicensetype(driver).click();
			// Thread.sleep(5000);
			 //MethodPOM.BystatusExpiringsearchLicensetype(driver).click();
			/* MethodPOM.ClicllicensetypeInternal1(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.GraphPopupClear(driver).click();
			 test.log(LogStatus.PASS, "Clear Button Working successfully");
			 Thread.sleep(5000);*/
			 MethodPOM.clickBystatusActiveOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License Overview Details Open  Successfully.	");
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview(driver).click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			driver.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup(driver).click();
			 Thread.sleep(3000);
			 
   }
   public static void BystatusTerminateInternalgraph(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {
	   Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
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
					//test.log(LogStatus.PASS, "Number of Terminate License  grid matches to Dashboard By status Graph Terminate License Count.");
					test.log(LogStatus.PASS, "No of Terminate  License  in the grid = "+total+" | Dashboard By Status Terminate License  Count = "+BystatusTerminateggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Terminate License does not matches to Dashboard By Status Graph  Terminate License   Count.");
					test.log(LogStatus.FAIL, "No of Terminate License  in the grid = "+total+" | Dashboard By Status Terminate License  Count = "+BystatusTerminateggraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Successfully.");
			/* licmgmtPOM.clicktypeinternal(driver).click();
			 Thread.sleep(5000);
			  licmgmtPOM.selecttypein(driver).click();
				 Thread.sleep(5000);
				 MethodPOM.GraphPopupClear(driver).click();
				 test.log(LogStatus.PASS, "Clear Button Working Successfully.");
			 Thread.sleep(5000);
			 */
			 MethodPOM.clickBystatusActiveOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License Overview Details Open  Successfully.");
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
					//test.log(LogStatus.PASS, "Number of Applied But not Renewed License  grid matches to Dashboard By status Graph Applied But not Renewed License Count.");
					test.log(LogStatus.PASS, "No of Applied But not Renewed  License  in the grid = "+total+" | Dashboard By Status Applied But not Renewed License  Count = "+BystatusExpiredappliedbutnotrenewedgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Applied But not Renewed License does not matches to Dashboard By Status Graph  Applied But not Renewed License   Count.");
					test.log(LogStatus.FAIL, "No of Applied But not Renewed License  in the grid = "+total+" | Dashboard By Status Applied But not Renewed License  Count = "+BystatusExpiredappliedbutnotrenewedgraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			 Thread.sleep(4000);
			/* MethodPOM.BystatusExpiringLicensetype(driver).click();
			 Thread.sleep(5000);
			 //MethodPOM.BystatusExpiringsearchLicensetype(driver).click();
			 MethodPOM.Clicllicensetype(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.GraphPopupClear(driver).click();
			 test.log(LogStatus.PASS, "Clear Button Working successfully");
			 Thread.sleep(5000);
			 */
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
   public static void BystatusExpiredappliedbutnotrenewedInternalgraph(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {
	   Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
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
					//test.log(LogStatus.PASS, "Number of Applied But not Renewed License  grid matches to Dashboard By status Graph Applied But not Renewed License Count.");
					test.log(LogStatus.PASS, "No of Applied But not Renewed  License  in the grid = "+total+" | Dashboard By Status Applied But not Renewed License  Count = "+BystatusExpiredappliedbutnotrenewedgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Applied But not Renewed License does not matches to Dashboard By Status Graph  Applied But not Renewed License   Count.");
					test.log(LogStatus.FAIL, "No of Applied But not Renewed License  in the grid = "+total+" | Dashboard By Status Applied But not Renewed License  Count = "+BystatusExpiredappliedbutnotrenewedgraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Successfully.");
			 Thread.sleep(4000);
			/* licmgmtPOM.clicktypeinternal(driver).click();
			 Thread.sleep(5000);
			  licmgmtPOM.selecttypein(driver).click();
				 Thread.sleep(5000);
				 MethodPOM.GraphPopupClear(driver).click();
				 test.log(LogStatus.PASS, "Clear Button Working Successfully.");
				 Thread.sleep(3000);
				 */
			 MethodPOM.clickBystatusExpiredappliedbutnotrenewedOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License Overview Details Open  Successfully.");
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
					//test.log(LogStatus.PASS, "Number of Expired License  grid matches to Dashboard By status Graph Expired License Count.");
					test.log(LogStatus.PASS, "No of Expired License  in the grid = "+total+" | Dashboard By Status Expired License  Count = "+BystatusExpiredgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expired License does not matches to Dashboard By Status Graph Expired License   Count.");
					test.log(LogStatus.FAIL, "No of Expired License  in the grid = "+total+" | Dashboard By Status Expired License  Count = "+BystatusExpiredgraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Downloaded Sucessfully");

           /*  MethodPOM.BystatusExpiringLicensetype(driver).click();
			 Thread.sleep(5000);
			 //MethodPOM.BystatusExpiringsearchLicensetype(driver).click();
			 MethodPOM.Clicllicensetype(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.GraphPopupClear(driver).click();
			 test.log(LogStatus.PASS, "Clear Button Working successfully");
			 Thread.sleep(5000);
			 */
			 MethodPOM.clickAllOverview(driver).click();
			 Thread.sleep(5000);
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
   public static void BystatusExpiredInternal(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {

	   Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
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
					//test.log(LogStatus.PASS, "Number of Expired License  grid matches to Dashboard By status Graph Expired License Count.");
					test.log(LogStatus.PASS, "No of Expired License  in the grid = "+total+" | Dashboard By Status Expired License  Count = "+BystatusExpiredgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expired License does not matches to Dashboard By Status Graph Expired License   Count.");
					test.log(LogStatus.FAIL, "No of Expired License  in the grid = "+total+" | Dashboard By Status Expired License  Count = "+BystatusExpiredgraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
						 Thread.sleep(5000);
						/* licmgmtPOM.clicktypeinternal(driver).click();
						 Thread.sleep(5000);
						  licmgmtPOM.selecttypein(driver).click();
							 Thread.sleep(5000);
							 MethodPOM.GraphPopupClear(driver).click();
							 test.log(LogStatus.PASS, "Clear Button Working Successfully.");
							 Thread.sleep(5000);
							 */
			 MethodPOM.clickAllOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License Overview Details Open  Successfully.");
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
					//test.log(LogStatus.PASS, "Number of Expired License  grid matches to Dashboard By Licnesetype Graph Expired License Count.");
					test.log(LogStatus.PASS, "No of Expired License  in the grid = "+total+" | Dashboard By Licnesetype Expired License  Count = "+ByLicensetypeExpiredgraph);
				}
				else
				{
				//	test.log(LogStatus.FAIL, "Number of Applied License does not matches to Dashboard By Licnesetype Graph Applied License   Count.");
					test.log(LogStatus.FAIL, "No of Expired License  in the grid = "+total+" | Dashboard By Licnesetype Expired License  Count = "+ByLicensetypeExpiredgraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			 Thread.sleep(5000);
			 MethodPOM.BystatusExpiringLicensetype(driver).click();
			 Thread.sleep(5000);
			 //MethodPOM.BystatusExpiringsearchLicensetype(driver).click();
			/* MethodPOM.Clicllicensetype(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.GraphPopupClear(driver).click();
			 test.log(LogStatus.PASS, "Clear Button Working successfully");
			 Thread.sleep(5000);
			 */
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
   public static void ByLicensetypeExpiredInternal(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {
	   Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeExpiredInternal(driver)));	  
		String ByLicenseTypeExpired=MethodPOM.clickByLicnesetypeExpiredInternal(driver).getText();
		
	     int ByLicensetypeExpiredgraph = Integer.parseInt(ByLicenseTypeExpired);	//Reading Expired graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeExpiredInternal(driver).click();					//Clicking on 'Expired' image
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
					//test.log(LogStatus.PASS, "Number of Expired License  grid matches to Dashboard By Licnese type Graph Expired License Count.");
					test.log(LogStatus.PASS, "No of Expired License  in the grid = "+total+" | Dashboard By Licnesetype Expired License  Count = "+ByLicensetypeExpiredgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expired License does not matches to Dashboard By Licnese type Graph Expired License   Count.");
					test.log(LogStatus.FAIL, "No of Expired License  in the grid = "+total+" | Dashboard By Licnesetype Expired License  Count = "+ByLicensetypeExpiredgraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			/* MethodPOM.BystatusExpiringLicensetype(driver).click();
			 Thread.sleep(5000);
			 //MethodPOM.BystatusExpiringsearchLicensetype(driver).click();
			 MethodPOM.ClicllicensetypeInr(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.GraphPopupClear(driver).click();
			 test.log(LogStatus.PASS, "Clear Button Working successfully");
			 Thread.sleep(5000);
			 */
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
					//test.log(LogStatus.PASS, "Number of Expiring License  grid matches to Dashboard By Licnesetype Graph Expiring License Count.");
					test.log(LogStatus.PASS, "No of Expiring License  in the grid = "+total+" | Dashboard By Licnese type Expiring License  Count = "+ByLicensetypeExpiringgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expiring License does not matches to Dashboard By Licnese type Graph Expiring License   Count.");
					test.log(LogStatus.FAIL, "No of Expiring License  in the grid = "+total+" | Dashboard By Licnese type Expiring License  Count = "+ByLicensetypeExpiringgraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			 Thread.sleep(3000);
			/* MethodPOM.BystatusExpiringLicensetype(driver).click();
			 Thread.sleep(5000);
			 //MethodPOM.BystatusExpiringsearchLicensetype(driver).click();
			 MethodPOM.Clicllicensetype(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.GraphPopupClear(driver).click();
			 Thread.sleep(5000);
			 test.log(LogStatus.PASS, "Clear Button Working successfully");
			 Thread.sleep(7000);
			 */
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
   public static void ByLicensetypeExpiringInternal(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {
	  Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
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
					//test.log(LogStatus.PASS, "Number of Expiring License  grid matches to Dashboard By Licnesetype Graph Expiring License Count.");
					test.log(LogStatus.PASS, "No of Expiring License  in the grid = "+total+" | Dashboard By Licnese type Expiring License  Count = "+ByLicensetypeExpiringgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expiring License does not matches to Dashboard By Licnese type Graph Expiring License   Count.");
					test.log(LogStatus.FAIL, "No of Expiring License  in the grid = "+total+" | Dashboard By Licnese type Expiring License  Count = "+ByLicensetypeExpiringgraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
			/* MethodPOM.BystatusExpiringLicensetype(driver).click();
			 Thread.sleep(5000);
			 //MethodPOM.BystatusExpiringsearchLicensetype(driver).click();
			 MethodPOM.ClicllicensetypeInr(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.GraphPopupClear(driver).click();
			 test.log(LogStatus.PASS, "Clear Button Working Successfully.");
			 Thread.sleep(5000);
			 */
			 MethodPOM.clickAllOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License Overview Details Open  Successfully.");
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
	   Thread.sleep(4000);
	    WebDriverWait wait = new WebDriverWait(driver, 50);
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
					//test.log(LogStatus.PASS, "Number of Applied License  grid matches to Dashboard By Licnesetype Graph Applied License Count.");
					test.log(LogStatus.PASS, "No of Applied License  in the grid = "+total+" | Dashboard By Licnese type Applied License  Count = "+ByLicensetypeAppliedggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Applied License does not matches to Dashboard By Licnese type Graph Applied License   Count.");
					test.log(LogStatus.FAIL, "No of Applied License  in the grid = "+total+" | Dashboard By Licnese type Applied License  Count = "+ByLicensetypeAppliedggraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
			 Thread.sleep(5000);
			/* MethodPOM.BystatusExpiringLicensetype(driver).click();
			 			 Thread.sleep(5000);
			 			 //MethodPOM.BystatusExpiringsearchLicensetype(driver).click();
			 			 MethodPOM.Clicllicensetype(driver).click();
			 			 Thread.sleep(5000);
			 			 MethodPOM.GraphPopupClear(driver).click();
			 			 test.log(LogStatus.PASS, "Clear Button Working Successfully.");
			 			 Thread.sleep(5000);
			 			 */
			 MethodPOM.clickAllOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License Overview Details Open  Successfully.");
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview(driver).click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			driver.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup(driver).click();
			 Thread.sleep(3000);
			 
   }
   public static void ByLicensetypeAppliedInternal(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {
	   Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeAppliedInternal(driver)));	  
		String ByLicenseTypeApplied=MethodPOM.clickByLicnesetypeAppliedInternal(driver).getText();
		
	     int ByLicensetypeAppliedggraph = Integer.parseInt(ByLicenseTypeApplied);	//Reading Applied graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeAppliedInternal(driver).click();					//Clicking on 'Applied' image
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
					//test.log(LogStatus.PASS, "Number of Applied License  grid matches to Dashboard By Licnesetype Graph Applied License Count.");
					test.log(LogStatus.PASS, "No of Applied License  in the grid = "+total+" | Dashboard By Licnese type Applied License  Count = "+ByLicensetypeAppliedggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Applied License does not matches to Dashboard By Licnese type Graph Applied License   Count.");
					test.log(LogStatus.FAIL, "No of Applied License  in the grid = "+total+" | Dashboard By Licnese type Applied License  Count = "+ByLicensetypeAppliedggraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
			 Thread.sleep(2000);
			/* MethodPOM.selectintype(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.selectinttype11(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.GraphPopupClear(driver).click();
			 test.log(LogStatus.PASS, "Clear Button Working Successfully.");
			 Thread.sleep(5000);
			 */
			 MethodPOM.clickAllOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License Overview Details Open  Successfully");
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
					//test.log(LogStatus.PASS, "Number of Active License  grid matches to Dashboard By Licnesetype Graph Active License Count.");
					test.log(LogStatus.PASS, "No of Active License  in the grid = "+total+" | Dashboard By Licnese type Active License  Count = "+ByLicensetypeActiveggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Active License does not matches to Dashboard By Licnese type Graph Active License   Count.");
					test.log(LogStatus.FAIL, "No of Active License  in the grid = "+total+" | Dashboard By Licnese type Active License  Count = "+ByLicensetypeActiveggraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			 Thread.sleep(3000);
			 /*MethodPOM.BystatusExpiringLicensetype(driver).click();
			 Thread.sleep(5000);
			 //MethodPOM.BystatusExpiringsearchLicensetype(driver).click();
			 MethodPOM.Clicllicensetype(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.GraphPopupClear(driver).click();
			 Thread.sleep(5000);
			 test.log(LogStatus.PASS, "Clear Button Working successfully");
			 Thread.sleep(7000);
			 */
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
   public static void ByLicensetypeActiveInternal(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {
      
	   Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	   Js1.executeScript("window.scrollBy(0,1000)");
	   Thread.sleep(3000);
	    WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeActiveInternal(driver)));	  
		String ByLicenseTypeActive=MethodPOM.clickByLicnesetypeActiveInternal(driver).getText();
		
	     int ByLicensetypeActiveggraph = Integer.parseInt(ByLicenseTypeActive);	//Reading Active graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeActiveInternal(driver).click();					//Clicking on 'Active' image
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
					//test.log(LogStatus.PASS, "Number of Active License  grid matches to Dashboard By Licnesetype Graph Active License Count.");
					test.log(LogStatus.PASS, "No of Active License  in the grid = "+total+" | Dashboard By Licnese type Active License  Count = "+ByLicensetypeActiveggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Active License does not matches to Dashboard By Licnese type Graph Active License   Count.");
					test.log(LogStatus.FAIL, "No of Active License  in the grid = "+total+" | Dashboard By Licnese type Active License  Count = "+ByLicensetypeActiveggraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
			 Thread.sleep(3000);
			/* MethodPOM.selectintype(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.selectinttype11(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.GraphPopupClear(driver).click();
			 test.log(LogStatus.PASS, "Clear Button Working Successfully.");
			 Thread.sleep(5000);
			 */
			 MethodPOM.clickAllOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License Overview Details Open  Successfully.");
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
					//test.log(LogStatus.PASS, "Number of Terminate License  grid matches to Dashboard By Licnesetype Graph Terminate License Count.");
					test.log(LogStatus.PASS, "No of Terminate License  in the grid = "+total+" | Dashboard By Licnese type Terminate License  Count = "+ByLicensetypeTerminateggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Terminate License does not matches to Dashboard By Licnese type Graph Terminate License   Count.");
					test.log(LogStatus.FAIL, "No of Terminate License  in the grid = "+total+" | Dashboard By Licnese type Terminate License  Count = "+ByLicensetypeTerminateggraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
			/* MethodPOM.Clicllicensetype(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.GraphPopupClear(driver).click();
			 Thread.sleep(5000);
			 test.log(LogStatus.PASS, "Clear Button Working successfully");
			 Thread.sleep(7000);
			 */
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
   public static void ByLicensetypeTerminateInternal(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
   {
	   Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	   Js1.executeScript("window.scrollBy(0,1000)");
	   Thread.sleep(3000);
	    WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeTerminateInternal(driver)));	  
		String ByLicenseTypeTerminate=MethodPOM.clickByLicnesetypeTerminateInternal(driver).getText();
		
	    int ByLicensetypeTerminateggraph = Integer.parseInt(ByLicenseTypeTerminate);	//Reading Terminate graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeTerminateInternal(driver).click();					//Clicking on 'Terminate' image
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
					//test.log(LogStatus.PASS, "Number of Terminate License  grid matches to Dashboard By Licnesetype Graph Terminate License Count.");
					test.log(LogStatus.PASS, "No of Terminate License  in the grid = "+total+" | Dashboard By Licnese type Terminate License  Count = "+ByLicensetypeTerminateggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Terminate License does not matches to Dashboard By Licnese type Graph Terminate License   Count.");
					test.log(LogStatus.FAIL, "No of Terminate License  in the grid = "+total+" | Dashboard By Licnese type Terminate License  Count = "+ByLicensetypeTerminateggraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph(driver).click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
			 Thread.sleep(1000);
			/* MethodPOM.selectintype(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.selectinttype11(driver).click();
			 Thread.sleep(5000);
			 MethodPOM.GraphPopupClear(driver).click();
			 test.log(LogStatus.PASS, "Clear Button Working Successfully.");	
			 Thread.sleep(3000);
			 */
			 MethodPOM.clickAllOverview(driver).click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 test.log(LogStatus.PASS, "License Overview Details Open  Successfully");
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview(driver).click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			driver.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup(driver).click();
			 Thread.sleep(3000);
			 
   }
   public static void MyWorkspace(WebDriver driver, ExtentTest test, String type) throws InterruptedException, IOException
   {
	   WebDriverWait wait = new WebDriverWait(driver, 20);
	   MethodPOM.ClickMyWorkspace(driver).click();
	   Thread.sleep(5000);
	   MethodPOM.clickWrklictype(driver).click();
	   Thread.sleep(7000);
	  // MethodPOM.Searchtype(driver).sendKeys("Boiler",Keys.ENTER);
	   MethodPOM.Click1(driver).click();
	   Thread.sleep(7000);
	   MethodPOM.Clearfilter(driver).click();
	  // test.log(LogStatus.PASS, "Clear Button Working Successfully");
	   Thread.sleep(7000);
	   MethodPOM.MyworkspaceOverview(driver).click();
	   Thread.sleep(7000);
	   MethodPOM.Overviewclose(driver).click();
	   test.log(LogStatus.PASS, "Overview  Button Working Successfully");
	   licmgmtPOM.ClickAddLicense(driver).click();
		 
		 Thread.sleep(3000);	
		 licmgmtPOM.ClickLicenseTypeDropdown(driver).click();
		 licmgmtPOM.SelectLicenseType(driver).click();
		 
		 Thread.sleep(500);
		 licmgmtPOM.ClickLocation(driver).click();
		 Thread.sleep(200);
		 licmgmtPOM.LocationMaximize(driver).click();
		 Thread.sleep(3000);
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
		 Row row8=sheet.getRow(8);
			org.apache.poi.ss.usermodel.Cell c3=row8.getCell(1);
		 String ApplicationDays=c3.getStringCellValue();
		 licmgmtPOM.ApplicationDays(driver).sendKeys(ApplicationDays);
		 
		 Thread.sleep(3000);
		 Row row9=sheet.getRow(9);
			org.apache.poi.ss.usermodel.Cell c4=row9.getCell(1);
		 String LicenseCost=c4.getStringCellValue();
		 licmgmtPOM.LicenseCost(driver).sendKeys(LicenseCost);
		 
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
		 licmgmtPOM.ClickNomineedrp(driver).click();
		 Thread.sleep(3000);
		 licmgmtPOM.SelectNominee(driver).click();
		 Thread.sleep(5000);
		 licmgmtPOM.ClickModificdate(driver).click();
		 Thread.sleep(5000);
		 licmgmtPOM.ModificatioDate(driver).click();
		 Thread.sleep(5000);
		 licmgmtPOM.nomineestartdatecal(driver).click();
		 Thread.sleep(3000);
		 licmgmtPOM.selectnominstartdate(driver).click();
		 Thread.sleep(3000);
		 JavascriptExecutor js2=(JavascriptExecutor) driver ;
			js2.executeScript("window.scroll(0,2000)");
		 licmgmtPOM.nomineeEnddatecal(driver).click();
		 Thread.sleep(5000);
		 licmgmtPOM.selectnomineenddate(driver).click();
		 Thread.sleep(5000);
		 licmgmtPOM.Nomineesubmit(driver).click();
	
		
	   
	   
   }
   public static void MyDocuments(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
	
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired(driver)));
		
		LiPerformerPOM.clickMyDocuments(driver).click();		//Clicking on 'My Documents'
		Thread.sleep(3000);
		LiPerformerPOM.clickMyDocumentsMenu(driver).click();	//Clicking on 'My Documents'
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1(driver)));	//Waiting until records table gets visible.
		
		if(type.equalsIgnoreCase("Internal"))
		{
			
			wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1(driver)));	//Waiting until records table gets visible.
			LiPerformerPOM.clickType2(driver).click();			//Clicking on 'Type' drop down.
			Thread.sleep(5000);
			LiPerformerPOM.selectInternal(driver).click();//Selecting 'Internal' option.
			Thread.sleep(5000);
			
		}
		
		Thread.sleep(5000);
		File dir = new File("C:\\Users\\dipali\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		MethodPOM.DownloadDocument(driver).click();
		
		Thread.sleep(3000);
       
		File dir1 = new File("C:\\Users\\dipali\\Downloads");
		File[] dirContents1 = dir1.listFiles();							//Counting number of files in directory after download
		
		if(dirContents.length < dirContents1.length)
		{
			test.log(LogStatus.PASS, "File downloaded successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
		
		
		Thread.sleep(7000);
		
		MethodPOM.ViewDocument(driver).click();
		
		test.log(LogStatus.PASS, "Document View successfully.");
		
		Thread.sleep(3000);
		MethodPOM.closeViewDocument(driver).click();
		Thread.sleep(3000);
		Thread.sleep(3000);
		if(type.equalsIgnoreCase("Internal"))
		{
			LiPerformerPOM.Clicklictypedropdown(driver).click();
			Thread.sleep(3000);
			LiPerformerPOM.searchlic1in(driver).click();
		}else
		{
			LiPerformerPOM.Clicklictypedropdown(driver).click();
			Thread.sleep(3000);
		    LiPerformerPOM.searchlic1(driver).click();
		}
		
		
	    Thread.sleep(3000);
	    test.log(LogStatus.PASS, "selected License Type Cleared");
		//LiPerformerPOM.selectlic(driver).click();
		LiPerformerPOM.clearbtn(driver).click();
		Thread.sleep(3000);
	//	wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard(driver)));
		//wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard(driver)));
		LiPerformerPOM.Multicheckdoc1(driver).click();
		Thread.sleep(3000);
		LiPerformerPOM.Multicheckdoc2(driver).click();
		
		
		File dir2 = new File("C:\\Users\\dipali\\Downloads");
		File[] dirContents2 = dir2.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		LiPerformerPOM.MultiDownload(driver).click();		//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir3 = new File("C:\\Users\\dipali\\Downloads");
		File[] allFilesNew = dir3.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(500);
       if(dirContents2.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, " Multipal  File downloaded successfully.");	
		}	else
		{
			test.log(LogStatus.FAIL, " File does not downloaded.");
		}
		Thread.sleep(3000);
		String PerformerColumn = LiPerformerPOM.PerformerColumn1(driver).getText();
		   if(PerformerColumn.equalsIgnoreCase("Performer")) 
		   {
			   
				test.log(LogStatus.PASS, "In Grid Performer Column Displayed.");
		   }
		   else
		   {
			   test.log(LogStatus.FAIL,"In Grid Performer Column Not Displayed.");
		   }
			Thread.sleep(3000);
		 String Reviewercolumn = MethodPOM.ReviewerColumn(driver).getText();
		   if(MethodPOM.ReviewerColumn(driver).isDisplayed())
		   {
			   
				test.log(LogStatus.PASS, "In grid Reviewer coloumn displayed.");
		   }
		   else
		   {
			   test.log(LogStatus.FAIL,"Reviewer Column Not Displayed");
		   }
		//wait.until(ExpectedConditions.elementToBeClickable(MethodPOM.clickMyDashboard(driver)));
		//Thread.sleep(3000);
		//OverduePOM.clickDashboard(driver).click();
	}
   public static void MyReports(WebDriver driver, ExtentTest test, String type) throws InterruptedException, IOException
	{
			WebDriverWait wait = new WebDriverWait(driver, 20);
			
			//wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired(driver)));
			
			LiPerformerPOM.clickMyReport(driver).click();		//Clicking on 'My Reports'
			
			progress(driver);
			
			wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1(driver)));	//Waiting until records table gets visible.
			
			if(type.equalsIgnoreCase("Internal"))
			{
				LiPerformerPOM.clickType2(driver).click();			//Clicking on 'Type' drop down.
				Thread.sleep(500);
				LiPerformerPOM.selectInternal(driver).click();//Selecting 'Internal' option.
				Thread.sleep(1000);
				progress(driver);
			}
			
			CheckReports(driver, test, 1, "Active");
			
			CheckReports(driver, test, 2, "Expired");
			
			CheckReports(driver, test, 3, "Expiring");
			
			CheckReports(driver, test, 4, "Applied");
			
			CheckReports(driver, test, 5, "Applied but Pending for Renewal");
			
			CheckReports(driver, test, 6, "Renewed");
			
			CheckReports(driver, test, 7, "Rejected");
			
			Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\'grid\']/div[2]/table/tbody/tr[1]/td[16]/a")).click();
		    Thread.sleep(500);
			driver.findElement(By.xpath("//*[@id=\"divShowReminderDialog\"]/div/div/div[1]/button")).click();
		     
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard(driver)));
			
			OverduePOM.clickDashboard(driver).click();
		}
		
		public static void CheckReports(WebDriver driver, ExtentTest test, int status, String type) throws InterruptedException, IOException
		{		
			WebDriverWait wait = new WebDriverWait(driver, 30);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-1000)");
			
			LiPerformerPOM.clickStatus1(driver).click();			//Clicking on 'Status' drop down.
			Thread.sleep(500);
			elementsList = LiPerformerPOM.selectStatus1(driver);	//Selecting Status.
			elementsList.get(status).click();
			
			Thread.sleep(1000);
			progress(driver);
			
			int flag = 0;
			try
			{
				wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1(driver)));	//Waiting until records table gets visible.
				flag = 1;
			}
			catch(Exception e)
			{
				
			}
			
			if(flag == 1)
			{
				js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
				
				Thread.sleep(700);
				String item = LiPerformerPOM.readTotalRecords1(driver).getText();
				String[] bits = item.split(" ");								//Splitting the String
				String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
				int count = 0;
				if(compliancesCount.equalsIgnoreCase("to"))
				{
					Thread.sleep(2500);
					item = CFOcountPOM.readTotalItems1(driver).getText();
					bits = item.split(" ");										//Splitting the String
					compliancesCount = bits[bits.length - 2];					//Getting the second last word (total number of users)
				}
				count = Integer.parseInt(compliancesCount);
				
				File dir = new File("C:\\Users\\dipali\\Download");
				File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
				
				js.executeScript("window.scrollBy(0,-2000)");				//Scrolling down window by 2000 px.
				Thread.sleep(500);
				LiPerformerPOM.clickExcel(driver).click();						//Clicking on Excel Image.
				
				Thread.sleep(3000);
				File dir1 = new File("C:\\Users\\dipali\\Download");
				File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
				
				if(dirContents.length < allFilesNew.length)
				{
					test.log(LogStatus.PASS, type+" :- File downloaded successfully.");
					
					fis = new FileInputStream(lastModifiedFile);
					workbook = new XSSFWorkbook(fis);
					sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
					int no = sheet.getLastRowNum();
					int SheetRecords = no - 0;						//Sheet have extra 5 lines of information at top (But row count started from 0, so -4)
					fis.close();
					
					if(count == SheetRecords)
					{
						test.log(LogStatus.PASS, "Count of records displayed from grid matches to number records in Excel Sheet.");
						test.log(LogStatus.INFO, "Total records from grid = "+count+" | Total records in Excel Sheet = "+SheetRecords);
					}
					else
					{
						test.log(LogStatus.FAIL, "Count of records displayed from grid doesn't matches to number records in Excel Sheet.");
						test.log(LogStatus.INFO, "Total records from grid = "+count+" | Total records in Excel Sheet = "+SheetRecords);
					}
				}
				else
				{
					test.log(LogStatus.FAIL, type+" :- File doesn't downloaded successfully.");
				}
			}
			else
			{
				test.log(LogStatus.SKIP, type+" :- Records not displayed (available). Excel sheet didn't downloaded");
			}

}

		private static void progress(WebDriver driver2) {
			// TODO Auto-generated method stub
			
		}
		public static void CriticalDocuments(WebDriver driver, ExtentTest test, String type) throws InterruptedException
		{
			Thread.sleep(1000);
		   OverduePOM.clickMyDocuments(driver).click();					//Clicking on 'My Documents'
			
			Thread.sleep(3000);
			OverduePOM.clickCriticalDocuments(driver).click();				//Clicking on 'Critical Documents'
			
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdFolderDetail']")));	//Wating till the content table gets visible
			
			Thread.sleep(500);
			String name = OverduePOM.readFolderName(driver).getText();		//Reading the folder name to create new folder.
			
			String folder = name+"ForAuto"; 
			Thread.sleep(500);
		
			OverduePOM.clickNew(driver).click();							//Clicking on '+New' button.
			
			Thread.sleep(1000);
			litigationPerformer.MethodsPOM.progress(driver);
			
			Thread.sleep(500);
			OverduePOM.clickNewFolder(driver).click();						//Clicking on 'New Folder'
			
			Thread.sleep(2000);
			litigationPerformer.MethodsPOM.progress(driver);
			
			Thread.sleep(300);
			OverduePOM.clickIsUniversal(driver).click();
			
			Thread.sleep(1000);
			OverduePOM.writeFolderName(driver).sendKeys(folder);			//Writing Folder name.
			
			Thread.sleep(1000);
			OverduePOM.clickCreate(driver).click();						//Clicking on create button.
			
			Thread.sleep(500);
			litigationPerformer.MethodsPOM.progress(driver);
			
			Thread.sleep(500);
		//	String msg = driver.switchTo().alert().getText();
			//test.log(LogStatus.INFO, msg);
			Thread.sleep(300);
			//driver.switchTo().alert().accept();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
			name = OverduePOM.readFolderName(driver).getText();				//Reading the folder name we had created
			
			if(folder.equalsIgnoreCase(name))
			{
				test.log(LogStatus.PASS, "New Created folder '"+folder+"' displayed in the records.");
			}
			else
			{
				test.log(LogStatus.FAIL, "New Created folder '"+folder+"' doesn't displayed in the records.");
			}
			
			Thread.sleep(5000);
			OverduePOM.readFolderName(driver).click();	
		   Thread.sleep(5000);
			//OverduePOM.readFolderName(driver).click();
		//	Thread.sleep(5000);
		   MethodPOM.clickShareFolder(driver).click();
		  // Thread.sleep(500);
		   Thread.sleep(1000);
			litigationPerformer.MethodsPOM.progress(driver);
			
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickPeople1(driver)));
			OverduePOM.clickPeople1(driver).click();						//Clicking on People drop down
			   Thread.sleep(5000);
			OverduePOM.clickSearchPeople1(driver).click();					//Clicking on Search People drop down.
			
			Thread.sleep(5000);
		//	clickSearchPeople(driver).sendKeys("amol");			//Writing user name to search for  CFO
		//	clickSearchPeople(driver).sendKeys("Company");	        // Auditor
			Thread.sleep(5000);
			OverduePOM.clickPeopleCheckBox(driver).click();				//Clicking on label to get out from people search box
			driver.findElement(By.xpath("//*[@id='divOpenPermissionPopup']/div/div/div[2]")).click();
			
			Thread.sleep(3000);
			MethodPOM.Clickaftershare(driver).click();
			Thread.sleep(3000);
			OverduePOM.clickDone(driver).click();	//Clicking on 'Done' to share folder.
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Folder Shared Successfully");
			OverduePOM.readFolderName(driver).click();						//Clicking on folder name we had created.
			Thread.sleep(5000);
			//MethodPOM.clickShareFolder(driver).click();
	     	Thread.sleep(5000);
		    OverduePOM.readFolderName(driver).click();						//Clicking on folder name we had created.
			
			Thread.sleep(1000);
			litigationPerformer.MethodsPOM.progress(driver);
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickNew(driver)));
			OverduePOM.clickNew(driver).click();							//Clicking on 'New'
			
			Thread.sleep(500);
			litigationPerformer.MethodsPOM.progress(driver);
			
			//Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickNewFile(driver)));
			OverduePOM.clickNewFile(driver).click();						//CLicking on 'New File'
			
			Thread.sleep(1000);
			litigationPerformer.MethodsPOM.progress(driver);
			
			Thread.sleep(500);
			String workingDir = System.getProperty("user.dir");
			OverduePOM.uploadNewFile(driver).sendKeys(workingDir+"//Reports//PerformerResults.html");	//uploading new file		
			
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickUploadDocument(driver)));
			OverduePOM.clickUploadDocument(driver).click();				//Clicking on 'Upload Document'
			
			Thread.sleep(100);
			litigationPerformer.MethodsPOM.progress(driver);
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
			if(OverduePOM.readFolderName(driver).isDisplayed())			//Checking if file got created or not.
				test.log(LogStatus.PASS, "File Uploaded Successfully and Uploaded File display On Grid");
			else
				test.log(LogStatus.PASS, "Uploaded file does not displayed.");
			
			OverduePOM.readFolderName(driver).click();						//Clicking on file we had uploaded.
					
			Thread.sleep(500);
			OverduePOM.clickShareFolder(driver).click();					//Clicking on Share Folder image.
			
			Thread.sleep(1000);
			litigationPerformer.MethodsPOM.progress(driver);
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickPeople(driver)));
			OverduePOM.clickPeople(driver).click();						//Clicking on People drop down 
			OverduePOM.clickSearchPeople(driver).click();					//Clicking on Search People drop down.
			
			Thread.sleep(500);
		//	clickSearchPeople(driver).sendKeys("amol");			//Writing user name to search for  CFO
		//	clickSearchPeople(driver).sendKeys("Company");	        // Auditor
			Thread.sleep(500);
			OverduePOM.clickPeopleCheckBox(driver).click();				//Clicking on label to get out from people search box
			driver.findElement(By.xpath("//*[@id='divOpenPermissionPopup']/div/div/div[2]")).click();
			
			Thread.sleep(1000);
			MethodPOM.Clickaftershare(driver).click();
			Thread.sleep(1000);
			OverduePOM.clickDone(driver).click();	//Clicking on 'Done' to share folder.
			Thread.sleep(1000);
			//driver.switchTo().alert().accept();
			
			Thread.sleep(1000);
			OverduePOM.readFolderName(driver).click();						//Clicking on file name we had uploaded.
			
			Thread.sleep(500);
			OverduePOM.clickShareFolder(driver).click();					//Clicking on Share File image.
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_myRepeater_LnkDeletShare_0']")));	//Waiting till the share element gets visible
			
			//Thread.sleep(1000);
			if(OverduePOM.checkShared(driver).isDisplayed())				//Checking if folder gor shared or not.
				test.log(LogStatus.PASS, "File Shared Successfully.");
			else
				test.log(LogStatus.PASS, "Uploaded file does not shared.");
			
			Thread.sleep(3000);
			OverduePOM.closeSharePoppup(driver).click();
			
			//Thread.sleep(3000);
			//OverduePOM.readFolderName(driver).click();	
			Thread.sleep(1000);
			File dir = new File("C:\\Users\\dipali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			Thread.sleep(7000);
			OverduePOM.readFolderName(driver).click();
			Thread.sleep(7000);
			//OverduePOM.readFolderName(driver).click();
			//Thread.sleep(7000);
			MethodPOM.CDocumentDownload(driver).click();	
			File dir1 = new File("C:\\Users\\dipali\\Downloads");
			File[] dirContents1 = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < dirContents1.length)
			{
				test.log(LogStatus.PASS, "File downloaded Successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded Successfully.");
			}
			
			Thread.sleep(7000);
			MethodPOM.editFolderD(driver).click();
			Thread.sleep(3000);
			MethodPOM.DocumentHeader(driver).sendKeys("Test Head");
			Thread.sleep(500);
			MethodPOM.DocumentDescription(driver).sendKeys("test Description");
			Thread.sleep(500);
			MethodPOM.DocumentOther(driver).sendKeys("test Other Document");
			Thread.sleep(500);
			MethodPOM.DocumentProcess(driver).sendKeys("Document process");
			Thread.sleep(500);
			MethodPOM.Documentsubprocess(driver).sendKeys("Document Sub prcess");
			Thread.sleep(500);
			MethodPOM.Vertical(driver).sendKeys("Test Vertical");
			Thread.sleep(500);
			MethodPOM.DocumentLocation(driver).sendKeys("Pune");
			Thread.sleep(500);
			MethodPOM.Updateinfobtn(driver).click();
			
			Thread.sleep(500);
			test.log(LogStatus.PASS, "Document Details Updated Successfully");
			MethodPOM.closedocpopup(driver).click();
			test.log(LogStatus.PASS, "Edit Document Details Popup Closed");
			Thread.sleep(500);
			 OverduePOM.readFolderName(driver).click();						//Clicking on folder name we had created.
				Thread.sleep(1000);
				MethodPOM.LinkFolder(driver).click();
				Thread.sleep(2000);
				MethodPOM.Linkdocument1(driver).click();
				Thread.sleep(2000);
				MethodPOM.Linkdocument2(driver).click();
				Thread.sleep(1000);
				MethodPOM.LinkSave(driver).click();
				Thread.sleep(1000);
				 // Switching to Alert       
		        Alert alert = driver.switchTo().alert();
		        Thread.sleep(3000);
		        // Capturing alert message.   
		        String alertMessage= driver.switchTo().alert().getText();
		        
		    	test.log(LogStatus.PASS, alertMessage);
		        
		        System.out.println(alertMessage);
		        
		        Thread.sleep(3000);	       
		        // Accepting alert
		        alert.accept();
		        MethodPOM.Linkclose(driver).click();
		        test.log(LogStatus.PASS, "Link Audit Popup Closed");
		        Thread.sleep(3000);	
		       // MethodPOM.ClickFolder(driver).click();
		       OverduePOM.readFolderName(driver).click();						//Clicking on file name we had uploaded.
			//Thread.sleep(3000);
		MethodPOM.DeleteFile(driver).click();
			Thread.sleep(3000);
			
			 // Switching to Alert       
	        Alert alert1 = driver.switchTo().alert();
	        Thread.sleep(3000);
	        // Capturing alert message.   
	        String alertMessage1= driver.switchTo().alert().getText();
	        
	    	test.log(LogStatus.PASS, alertMessage1);
	        
	        System.out.println(alertMessage1);
	        
	        Thread.sleep(3000);	       
	        // Accepting alert
	        alert.accept();
			
	       // test.log(LogStatus.PASS, "Document File Deleted Successfully");
			
	//		driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_upPromotorList']/div/div/section/div[3]/div/div[2]/img[5]")).click();
			Thread.sleep(3000);
		    driver.switchTo().alert().accept();

		    Thread.sleep(3000);
		  //  MethodPOM.Folback(driver).click();*/
			driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkMyDrive']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilter']")).sendKeys(folder,Keys.ENTER);//search folder
			test.log(LogStatus.PASS, "File Name Search Successfully.");
		
			driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdFolderDetail_lnkEditFolder_0']")).click();
			Thread.sleep(3000);
		
			driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtFolderName']")).clear();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtFolderName']")).sendKeys("autoDemo");
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCreateFolder1']")).click();
			
			test.log(LogStatus.PASS, "Rename Folder Successfully");
				//Reading Message appeared after save button
	/*	try 
			{
				Thread.sleep(3000);
				String msg=MethodPOM.FirstFolder(driver).getText();
				if(msg.equalsIgnoreCase("Action Folder"))
				{
					test.log(LogStatus.PASS, "Rename Folder Successfully = "+msg);
					
				}
				
			}
			
	        catch(Exception e)
	        {
	        	Thread.sleep(3000);
				String msg4=MethodPOM.renamemsg(driver).getText();
				test.log(LogStatus.PASS, "Message displayed = "+msg4);
				
	        }
		
			Thread.sleep(3000);	 
		     OverduePOM.readFolderName(driver).click();						//Clicking on folder name we had created.
			Thread.sleep(1000);
			// MethodPOM.clickShareFolder(driver).click();
			
			MethodPOM.DeleteFolder(driver).click();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
			test.log(LogStatus.PASS, " Document Folder Deleted Successfully");
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard(driver)));
			MethodPOM.clickMyDashboard(driver).click();			//Clicking on Dashboard
			*/
		}

		public  static void LicenseActivation_InternalNewAssignment(WebDriver driver, ExtentTest test, String string) throws InterruptedException
		{
			
			Thread.sleep(1000);
			MethodPOM.clickMasterMenu(driver).click();
           Thread.sleep(2000);
           MethodPOM.InternalCreationMenu(driver).click();
           
          Thread.sleep(3000);
          MethodPOM.LicenseNewAssignment(driver).click();
          
          Thread.sleep(3000);
 		 MethodPOM.ClickLicenseType(driver).click();
 		 Thread.sleep(5000);
 		 MethodPOM.SearchLicenseType(driver).sendKeys("Apolo",Keys.ENTER);
 		 
 	
 		// Thread.sleep(5000);
 		// MethodPOM.CheckLocation(driver).click();
 		Thread.sleep(3000);
 		MethodPOM.ClickLocationin(driver).click();
 		Thread.sleep(3000);
  		//MethodPOM.ClickLocation(driver).click();
  		//Thread.sleep(3000);
  		//MethodPOM.ClickLocation(driver).click();
          MethodPOM.selectbtn(driver).click();
          Thread.sleep(3000);
          MethodPOM.ClickLocation1(driver).click();
        Thread.sleep(3000);
  		MethodPOM.CheckCompliancein(driver).click();
  		Thread.sleep(3000);
  		MethodPOM.ClickPerformer(driver).click();
  		Thread.sleep(3000);
  		MethodPOM.SelectLicensePerformer(driver).click();
  		
  	
  		Thread.sleep(3000);
  		MethodPOM.ClickReviewer(driver).click();
  		Thread.sleep(5000);
  		MethodPOM.SelectLicenseReviewer(driver).click();
  		
 		Thread.sleep(3000);
 		MethodPOM.AddAssignmentButton(driver).click();
 		String msg3 = MethodPOM.readResponseMsg(driver).getText();		//Reading Message appeared after save button
		
		if(msg3.equalsIgnoreCase("Assignment saved successfully"))
		{
			test.log(LogStatus.PASS, "Message displayed = "+msg3);
			
		}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg3);
			}


	  }
		public  static void LicenseActivation_NewAssignment(WebDriver driver, ExtentTest test, String string) throws InterruptedException
		{
			
			Thread.sleep(1000);
			MethodPOM.clickMasterMenu(driver).click();
           Thread.sleep(2000);
           MethodPOM.ClickLicenseActivation(driver).click();
           
          Thread.sleep(3000);
          MethodPOM.LicenseNewAssignment(driver).click();
          
          Thread.sleep(3000);
 		 MethodPOM.ClickLicenseType(driver).click();
 		 Thread.sleep(5000);
 		 MethodPOM.SearchLicenseType(driver).sendKeys("Boiler",Keys.ENTER);
 		 
 		
 		 Thread.sleep(5000);
 		 MethodPOM.CheckLocation(driver).click();
 		Thread.sleep(3000);
 		MethodPOM.SelectLocation(driver).click();
 		Thread.sleep(3000);
  		MethodPOM.ClickLocation1(driver).click();
  		
  		Thread.sleep(3000);
  		MethodPOM.CheckCompliance(driver).click();
  		Thread.sleep(3000);
  		MethodPOM.ClickPerformer(driver).click();
  		Thread.sleep(3000);
  		MethodPOM.SelectLicensePerformer(driver).click();
  		
  	
  		Thread.sleep(3000);
  		MethodPOM.ClickReviewer(driver).click();
  		Thread.sleep(5000);
  		MethodPOM.SelectLicenseReviewer(driver).click();
  		
 		Thread.sleep(5000);
 		MethodPOM.AddAssignmentButton(driver).click();
 		String msg3 = MethodPOM.readResponseMsg(driver).getText();		//Reading Message appeared after save button
		
		if(msg3.equalsIgnoreCase("Assignment saved successfully"))
		{
			test.log(LogStatus.PASS, "Message displayed = "+msg3);
			
		}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg3);
			}


	  }
		public static void LicenseCreation(WebDriver driver, ExtentTest test, String string) throws InterruptedException, IOException
		{
			Thread.sleep(1000);
			MethodPOM.clickMasterMenu(driver).click();
           Thread.sleep(2000);
           MethodPOM.ClickLicenseActivation(driver).click();
           
           Thread.sleep(3000);
   	      	 MethodPOM.ClickLicensetype1(driver).click();
   		 Thread.sleep(5000);
   		    MethodPOM.SearchLicenseType1(driver).sendKeys("Boiler",Keys.ENTER);
   		    
  /* 	 WebElement checkBoxDisplayed = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_ChkIsPerment_0']"));
 		   boolean isDisplayed = checkBoxDisplayed.isDisplayed();
 		   
 		if (isDisplayed == true) 
 		{
 			test.log(LogStatus.PASS, "IsPermanent CheckBox is displayed");
		}
 		else
 		{
 			test.log(LogStatus.PASS, "IsPermanent CheckBox is Not displayed");
 		}
 		*/
 		//MethodPOM.addlicplusebtn(driver).click();
   		Thread.sleep(3000);
   		MethodPOM.CheckCompliance1(driver).click();
     	Thread.sleep(3000);
   	 
	 XSSFSheet Sheet= ReadExcel();
   	 Row row7=sheet.getRow(7);
   	 org.apache.poi.ss.usermodel.Cell c2=row7.getCell(1);
   	 String LicenseNo=c2.getStringCellValue();
   	 MethodPOM.LicesneNo1(driver).sendKeys(LicenseNo);
           
   
	 Thread.sleep(3000);
	 sheet = workbook.getSheetAt(2);
	 Row row6= sheet.getRow(6);
	  org.apache.poi.ss.usermodel.Cell c1 = row6.getCell(1);	
	 String LicenseTitle= c1.getStringCellValue();
	 MethodPOM.LicesneTitle1(driver).sendKeys(LicenseTitle);
	 
	 Thread.sleep(3000);
	 MethodPOM.StartDate1(driver).sendKeys("01-03-2023");
	 Thread.sleep(3000);     
	 MethodPOM.EndDate1(driver).sendKeys("30-03-2023");
	 
	 JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	   Js1.executeScript("window.scrollBy(0,1000)");
	   
	   MethodPOM.SaveButton(driver).click();
	 
	   Alert alert1 = driver.switchTo().alert();
	   String alertMessage1= driver.switchTo().alert().getText();
	   //test.log(LogStatus.PASS, alertMessage1);
	   alert1.accept();
	   Thread.sleep(3000);
	   String msg = MethodPOM.Message(driver).getText();		//Reading Message appeared after save button
		
		if(msg.equalsIgnoreCase("Compliance Created and Assigned Successfully"))
		{
			test.log(LogStatus.PASS, "Message displayed = "+msg);
			
		}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg);
			}

          MethodPOM.clickMyDashboard(driver).click();
	   
		}
		public static void InternalLicenseCreation(WebDriver driver, ExtentTest test, String string) throws InterruptedException, IOException
		{
			Thread.sleep(1000);
			MethodPOM.clickMasterMenu(driver).click();
           Thread.sleep(2000);
           MethodPOM.InternalCreationMenu(driver).click();
			  Thread.sleep(3000);
	   	      	MethodPOM.ClickInternalLicenseType(driver).click();
	   		 Thread.sleep(5000);
	   		   MethodPOM.SearchInternalLicenseType(driver).sendKeys("Apolo",Keys.ENTER);
	   		MethodPOM.CheckCompliance1(driver).click();
	      	 Thread.sleep(3000);
	      	 
	   	 XSSFSheet Sheet= ReadExcel();
	      	 Row row7=sheet.getRow(7);
	      		org.apache.poi.ss.usermodel.Cell c2=row7.getCell(1);
	      	 String LicenseNo=c2.getStringCellValue();
	      	 MethodPOM.LicesneNo1(driver).sendKeys(LicenseNo);
	              
	      
	   	 Thread.sleep(3000);
	   	 sheet = workbook.getSheetAt(2);
	   	 Row row6= sheet.getRow(6);
	   	  org.apache.poi.ss.usermodel.Cell c1 = row6.getCell(1);	
	   	 String LicenseTitle= c1.getStringCellValue();
	   	 MethodPOM.LicesneTitle1(driver).sendKeys(LicenseTitle);
	   	 
	   	 Thread.sleep(3000);
	   	 MethodPOM.StartDate1(driver).sendKeys("01-03-2023");
	   	 Thread.sleep(3000);     
	   	 MethodPOM.EndDate1(driver).sendKeys("30-03-2023");
	   	 
	   	 JavascriptExecutor Js1 = (JavascriptExecutor) driver;
	   	   Js1.executeScript("window.scrollBy(0,1000)");
	   	   
	   	   MethodPOM.SaveButton(driver).click();
	   	 
	   	   Alert alert1 = driver.switchTo().alert();
	   	   String alertMessage1= driver.switchTo().alert().getText();
	   	   //test.log(LogStatus.PASS, alertMessage1);
	   	   alert1.accept();
	   	   Thread.sleep(3000);
	   	   String msg = MethodPOM.Message(driver).getText();		//Reading Message appeared after save button
	   		
	   		if(msg.equalsIgnoreCase("Compliance Created and Assigned Sucessfully"))
	   		{
	   			test.log(LogStatus.PASS, "Message displayed = "+msg);
	   			
	   		}
	   			else
	   			{
	   				test.log(LogStatus.FAIL, "Message displayed = "+msg);
	   			}

	             MethodPOM.clickMyDashboard(driver).click();
	   	   
	   		    
	   		    
		}

		public static void CriticalDocuments(WebDriver driver2, Object statutory, String string) {
			// TODO Auto-generated method stub
			
		}
		public static  void  IsPermanent(WebDriver driver, ExtentTest test, String string) throws InterruptedException
		{
			 WebDriverWait wait = new WebDriverWait(driver, 30);
			MethodPOM.clickMasterMenu(driver).click();
           Thread.sleep(2000);
           MethodPOM.ClickLicenseActivation(driver).click();
           Thread.sleep(3000);
           MethodPOM.addlicensebtn1(driver).click();
           Thread.sleep(6000);
           wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showlicdetails"));
           WebElement checkBoxDisplayed = driver.findElement(By.xpath("//*[@id='ChkIsActive']"));
   		   boolean isDisplayed = checkBoxDisplayed.isDisplayed();
   		   
   		if (isDisplayed == true) 
   		{
   			test.log(LogStatus.PASS, "IsPermanent CheckBox is displayed");
		}
   		else
   		{
   			test.log(LogStatus.PASS, "IsPermanent CheckBox is Not displayed");
   		}
   		   
   		  	
		}


}


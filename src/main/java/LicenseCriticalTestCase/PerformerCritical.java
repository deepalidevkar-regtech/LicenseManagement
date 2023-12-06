package LicenseCriticalTestCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import licenseCompanyadmin.MethodPOM;
import licenseManagement.licmgmtPOM;
import licensePerformer.LiPerformerPOM;
import licenseReviewer.LiReviewerPOM;
import litigationPerformer.performerPOM;
import performer.OverduePOM;

public class PerformerCritical 
{
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;		
	public static WebDriver driver = null;		//WebDriver instance created
	public static WebElement upload = null;	
	private static WebElement license = null;	
	
	public static void ActiveLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{	
		  WebDriverWait wait = new WebDriverWait(driver, 20);
			
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
			String Active=MethodPOM.clickActive(driver).getText();
			
		     int Activelicense = Integer.parseInt(Active);	//Reading Active count.

		      MethodPOM.clickActive(driver).click();					//Clicking on 'Active' image
		      Thread.sleep(4000);
		        JavascriptExecutor js1=(JavascriptExecutor) driver ;
				js1.executeScript("window.scroll(0,500)");
				Thread.sleep(4000);
			  	String item1 = MethodPOM.clickReadExpired(driver).getText();	//Reading total items String value
				  if(!item1.equalsIgnoreCase("No items to display"))
				  {
				MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
				Thread.sleep(500);
				String item = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(LicenseActiveCount);
				if(Activelicense == total)
		{
			//test.log(LogStatus.PASS, "Dashboard 'Expired' count matches to the total records displayed in grid.");
			test.log(LogStatus.PASS, "Dashboard 'Active' count = "+Activelicense+" | Total records in grid = "+total);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Dashboard 'Expired' count doesn't matches to the total records displayed in grid.");
			test.log(LogStatus.FAIL, "Dashboard 'Active' count = "+Activelicense+" | Total records in grid = "+total);
		}
		Thread.sleep(5000);	
		MethodPOM.ClickActiveOverview(driver).click();
		test.log(LogStatus.PASS, " License Overview Details Successfully.");
		Thread.sleep(5000);
		MethodPOM.ClickCloseOverview(driver).click();			
		Thread.sleep(7000);
		LiPerformerPOM.editlicenseicon(driver).click();
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
		Thread.sleep(5000);
		js1.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(3000);
		//LiPerformerPOM.editnomineebtn(driver).click();
		Thread.sleep(3000);
		 /*licmgmtPOM.ClickNomineedrp(driver).click();
		 Thread.sleep(3000);
		 licmgmtPOM.SelectNominee(driver).click();
		 
		 Thread.sleep(5000);
		// js1.executeScript("window.scroll(0,2000)");
		// Thread.sleep(5000);
		 licmgmtPOM.ClickModificdate(driver).click();
		 Thread.sleep(6000);	
		 js1.executeScript("window.scroll(0,2000)");
		 Thread.sleep(6000);		 
		 licmgmtPOM.ModificatioDate(driver).click();		 
		 Thread.sleep(6000);
		 js1.executeScript("window.scroll(0,2000)");
		 licmgmtPOM.nomineestartdatecal(driver).click();
		 Thread.sleep(3000);
		 licmgmtPOM.selectnominstartdate(driver).click();
		 Thread.sleep(3000);
		 JavascriptExecutor js2=(JavascriptExecutor) driver ;
			js2.executeScript("window.scroll(0,2000)");
		 licmgmtPOM.nomineeEnddatecal(driver).click();
		 Thread.sleep(5000);
		 licmgmtPOM.selectnomineenddate(driver).click();
		 Thread.sleep(5000);*/
		licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
		 // Switching to Alert    
		 Thread.sleep(500);
        Alert alert = driver.switchTo().alert();
       
        // Capturing alert message.   
        String alertMessage= driver.switchTo().alert().getText();
       
        Thread.sleep(3000);
      //  test.log(LogStatus.PASS, alertMessage);
       
        // Displaying alert message
       // System.out.println(alertMessage);
        // Accepting alert
        /*Thread.sleep(3000);
        By locator = By.xpath("//*[@class='k-button-group k-dialog-buttongroup k-dialog-button-layout-stretched']");

    	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    	Thread.sleep(4000);
    	
    	WebElement ViewButton = driver.findElement(locator);	
    	Thread.sleep(3000);
    JavascriptExecutor jse=(JavascriptExecutor)driver;
    jse.executeScript("arguments[0].click();", ViewButton);
    	Thread.sleep(4000);
        
      //  LiPerformerPOM.licenseOK(driver).click();
        
     */
        // Accepting alert
        alert.accept();
        test.log(LogStatus.PASS,"License Details Updated Successfully." );
        
          Thread.sleep(5000);
          
          licmgmtPOM.editlicenseclose(driver).click();
          Thread.sleep(300);
          MethodPOM.clickMyDashboard(driver).click();
          Thread.sleep(1000);
			  }
			  else
			  {
				   		      
				test.log(LogStatus.PASS,"No Record Found");
				MethodPOM.clickMyDashboard(driver).click();
					      
			  }
         // MethodPOM.clickActive(driver).click();	
          
        //  Thread.sleep(3000);
	//	LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
		
		//progress(driver);
		
		//Thread.sleep(500);
	
		
	if(type.equalsIgnoreCase("Internal"))
		{
			WebDriverWait wait1= new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
			LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
			
			
			Select drp = new Select(LiPerformerPOM.clickType(driver));
			drp.selectByIndex(1);
			CFOcountPOM.clickApply1(driver).click();	
			  Thread.sleep(3000);
			MethodPOM.clickActive(driver).click();	
	          
	        Thread.sleep(3000);
			OverduePOM.ActiveAction(driver).click();					//Clicking on first action button.
			//Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
			js1.executeScript("window.scrollBy(0,3000)");
			 Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown(driver)));
			Select status = new Select(OverduePOM.selectInternalDropdown(driver));	//Selecting Status dropdown box.
			status.selectByIndex(2);	
		
		}
		else
		{
			MethodPOM.clickActive(driver).click();	
	          
	         Thread.sleep(3000);
	         OverduePOM.ActiveAction(driver).click();					//Clicking on first action button.
			                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LiPerformerPOM.ShowFream(driver)));		
			js1.executeScript("window.scrollBy(0,1000)");
		    Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown(driver)));
			Select status = new Select(OverduePOM.selectStatutoryDropdown(driver));	//Selecting Status dropdown box.
			status.selectByIndex(2);	
		}
		
		try
		{
			Thread.sleep(300);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress(driver)));
		}
		catch(Exception e)
		{
			
		}
		
		licenseReviewer.LiReMethodsPOM.perform(driver, test);			//Calling perform method of Reviewer.
		
		try
		{
			Thread.sleep(500);
			LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
			js1.executeScript("window.scrollBy(0,300)");
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		js1.executeScript("window.scrollBy(0,700)");
		Thread.sleep(300);
		OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.
		
		Thread.sleep(1000);
		js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.
		
		Thread.sleep(300);
		if(type.equalsIgnoreCase("Statutory"))
		{
			
			Thread.sleep(500);
			js1.executeScript("window.scrollBy(2000,0)");	//Scrolling up window by 2000 px.
		}
		else
			{
			test.log(LogStatus.PASS, "Save Sucessfully.");
			 }
			driver.switchTo().parentFrame();
			
			Thread.sleep(700);
			LiPerformerPOM.clickClose(driver).click();				//Clicking on Close (Cross)
			driver.navigate().refresh();
			MethodPOM.clickMyDashboard(driver).click();

	
	}

	public static void activelicenseperform(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
		String Active=MethodPOM.clickActive(driver).getText();
		
	     int Activelicense = Integer.parseInt(Active);	//Reading Active count.

	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
	     String pfr=LiPerformerPOM.PFRCount(driver).getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickActive(driver).click();					//Clicking on 'Active' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			String item1 = MethodPOM.clickReadExpired(driver).getText();	//Reading total items String value
			  if(!item1.equalsIgnoreCase("No items to display"))
			  {
		MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total)
			int total = Integer.parseInt(LicenseActiveCount);
			
			if(Activelicense == total)
	{
		//test.log(LogStatus.PASS, "Dashboard 'Expired' count matches to the total records displayed in grid.");
		test.log(LogStatus.PASS, "Dashboard 'Active' count = "+Activelicense+" | Total records in grid = "+total);
	}
	else
	{
		//test.log(LogStatus.FAIL, "Dashboard 'Expired' count doesn't matches to the total records displayed in grid.");
		test.log(LogStatus.FAIL, "Dashboard 'Active' count = "+Activelicense+" | Total records in grid = "+total);
	}
	
	   
    Thread.sleep(3000);
    OverduePOM.ActiveAction(driver).click();					//Clicking on first action button.
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LiPerformerPOM.ShowFream(driver)));		
	js1.executeScript("window.scrollBy(0,1000)");
   Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown(driver)));
	Select status = new Select(OverduePOM.selectStatutoryDropdown(driver));	//Selecting Status dropdown box.
	status.selectByIndex(2);	
	
	Thread.sleep(5000);
	js1.executeScript("window.scrollBy(0,100)");

	//LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
	//js1.executeScript("window.scrollBy(0,300)");

Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(300);
OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.

Thread.sleep(1000);
js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.

Thread.sleep(300);

	
	Thread.sleep(500);
	js1.executeScript("window.scrollBy(2000,0)");	//Scrolling up window by 2000 px.


	test.log(LogStatus.PASS, "Save Sucessfully.");
	driver.switchTo().parentFrame();
	
	Thread.sleep(700);
	LiPerformerPOM.clickClose(driver).click();				//Clicking on Close (Cross)
	driver.navigate().refresh();
	MethodPOM.clickMyDashboard(driver).click();
	
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
	String Active1=MethodPOM.clickActive(driver).getText();
	
     int Activelicense1 = Integer.parseInt(Active1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
     String pfr1=LiPerformerPOM.PFRCount(driver).getText();
     int pfrlicense1 = Integer.parseInt(pfr1);	//Reading PendingForReview count.
     
     if(Activelicense>Activelicense1&&pfrlicense<pfrlicense1)
     {
    	 test.log(LogStatus.PASS, "Active Old Count = "+Activelicense+" | New Count = "+Activelicense1);
         test.log(LogStatus.PASS, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     else
     {
    	 test.log(LogStatus.FAIL, "Active Old Count = "+Activelicense+" | New Count = "+Activelicense1);
         test.log(LogStatus.FAIL, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
			  }
     else
     {
		      
			test.log(LogStatus.PASS,"No Record Found");
			MethodPOM.clickMyDashboard(driver).click();
    	 }
     }
	
	public static void Internalactivelicenseperform(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
		LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
		
		
		Select drp = new Select(LiPerformerPOM.clickType(driver));
		drp.selectByIndex(1);
		CFOcountPOM.clickApply1(driver).click();	
		  Thread.sleep(3000);
		
	
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
		String Active=MethodPOM.clickActive(driver).getText();
		
	     int Activelicense = Integer.parseInt(Active);	//Reading Active count.

	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
	     String pfr=LiPerformerPOM.PFRCount(driver).getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickActive(driver).click();					//Clicking on 'Active' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
		/*	MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total)
			int total = Integer.parseInt(LicenseActiveCount);
			
			if(Activelicense == total)
	{
		//test.log(LogStatus.PASS, "Dashboard 'Expired' count matches to the total records displayed in grid.");
		test.log(LogStatus.PASS, "Dashboard 'Active' count = "+Activelicense+" | Total records in grid = "+total);
	}
	else
	{
		//test.log(LogStatus.FAIL, "Dashboard 'Expired' count doesn't matches to the total records displayed in grid.");
		test.log(LogStatus.FAIL, "Dashboard 'Active' count = "+Activelicense+" | Total records in grid = "+total);
	}
	*/
	   
    Thread.sleep(3000);
    OverduePOM.ActiveAction(driver).click();					//Clicking on first action button.
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
	js1.executeScript("window.scrollBy(0,3000)");
	 Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown(driver)));
	Select status = new Select(OverduePOM.selectInternalDropdown(driver));	//Selecting Status dropdown box.
	status.selectByIndex(2);	
	 Thread.sleep(3000);
	 String workingDir = System.getProperty("user.dir");
		OverduePOM.fileUploadInternal(driver).sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button. (Internal)
		Thread.sleep(1000);
		js1.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(500);
	 LiPerformerPOM.indate(driver).sendKeys("01-08-2023");
	Thread.sleep(5000);
	 LiPerformerPOM.justclick(driver).click();
	js1.executeScript("window.scrollBy(0,1000)");

	//LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
	//js1.executeScript("window.scrollBy(0,300)");

Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(3000);
OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.

Thread.sleep(1000);
js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.

Thread.sleep(300);
if(type.equalsIgnoreCase("Statutory"))
{
	
	Thread.sleep(500);
	js1.executeScript("window.scrollBy(2000,0)");	//Scrolling up window by 2000 px.
}
else
	{
	test.log(LogStatus.PASS, "Save Sucessfully.");
	 }
	driver.switchTo().parentFrame();
	
	Thread.sleep(700);
	LiPerformerPOM.clickClose(driver).click();				//Clicking on Close (Cross)
	driver.navigate().refresh();
	MethodPOM.clickMyDashboard(driver).click();
	
	wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
	LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
	
	
	Select drp1 = new Select(LiPerformerPOM.clickType(driver));
	Thread.sleep(7000);
	drp1.selectByIndex(1);
	CFOcountPOM.clickApply1(driver).click();	
	  Thread.sleep(3000);
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
	String Active1=MethodPOM.clickActive(driver).getText();
	
     int Activelicense1 = Integer.parseInt(Active1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
     String pfr1=LiPerformerPOM.PFRCount(driver).getText();
     int pfrlicense1 = Integer.parseInt(pfr1);	//Reading PendingForReview count.
     
     if(Activelicense>Activelicense1&&pfrlicense<pfrlicense1)
     {
    	 test.log(LogStatus.PASS, "Active Old Count = "+Activelicense+" | New Count = "+Activelicense1);
         test.log(LogStatus.PASS, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     else
     {
    	 test.log(LogStatus.FAIL, "Active Old Count = "+Activelicense+" | New Count = "+Activelicense1);
         test.log(LogStatus.FAIL, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     
	}
	
	public static void Expiringlicenseperform(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring(driver)));
		String Expiring=MethodPOM.clickExpiring(driver).getText();
		
	     int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.
	     
	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
	     String pfr=LiPerformerPOM.PFRCount(driver).getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickExpiring(driver).click();					//Clicking on 'Expiring' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			String item1 = MethodPOM.clickReadExpired(driver).getText();	//Reading total items String value
			  if(!item1.equalsIgnoreCase("No items to display"))
			  {
		/*	MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total)
			int total = Integer.parseInt(LicenseActiveCount);
			
			if(Activelicense == total)
	{
		//test.log(LogStatus.PASS, "Dashboard 'Expired' count matches to the total records displayed in grid.");
		test.log(LogStatus.PASS, "Dashboard 'Active' count = "+Activelicense+" | Total records in grid = "+total);
	}
	else
	{
		//test.log(LogStatus.FAIL, "Dashboard 'Expired' count doesn't matches to the total records displayed in grid.");
		test.log(LogStatus.FAIL, "Dashboard 'Active' count = "+Activelicense+" | Total records in grid = "+total);
	}
	*/
	   
    Thread.sleep(3000);
    OverduePOM.ActiveAction(driver).click();	
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LiPerformerPOM.ShowFream(driver)));		
	js1.executeScript("window.scrollBy(0,1000)");
   Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown(driver)));
	Select status = new Select(OverduePOM.selectStatutoryDropdown(driver));	//Selecting Status dropdown box.
	status.selectByIndex(2);	
	
	Thread.sleep(5000);
	js1.executeScript("window.scrollBy(0,100)");

	//LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
	//js1.executeScript("window.scrollBy(0,300)");

Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(300);
OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.

Thread.sleep(1000);
js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.

Thread.sleep(300);
if(type.equalsIgnoreCase("Statutory"))
{
	
	
	Thread.sleep(500);
	js1.executeScript("window.scrollBy(2000,0)");	//Scrolling up window by 2000 px.
}
else
	{
	test.log(LogStatus.PASS, "Save Sucessfully.");
	 }
	driver.switchTo().parentFrame();
	
	Thread.sleep(700);
	LiPerformerPOM.clickClose(driver).click();				//Clicking on Close (Cross)
	driver.navigate().refresh();
	MethodPOM.clickMyDashboard(driver).click();
			  }
			  else
			  {
				    
					test.log(LogStatus.PASS,"No Record Found");
					MethodPOM.clickMyDashboard(driver).click();
			  }
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring(driver)));
	String Expiring1=MethodPOM.clickExpiring(driver).getText();
	
     int Expiringlicense1 = Integer.parseInt(Expiring1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
     String pfr1=LiPerformerPOM.PFRCount(driver).getText();
     int pfrlicense1 = Integer.parseInt(pfr1);	//Reading PendingForReview count.
     
     if(Expiringlicense>Expiringlicense1&&pfrlicense<pfrlicense1)
     {
    	 test.log(LogStatus.PASS, "Expiring Old Count = "+Expiringlicense+" | New Count = "+Expiringlicense1);
         test.log(LogStatus.PASS, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     else
     {
    	 test.log(LogStatus.FAIL, "Expiring Old Count = "+Expiringlicense+" | New Count = "+Expiringlicense1);
         test.log(LogStatus.FAIL, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     
	}
	public static void internalExpiringlicenseperform(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
		LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
		
		
		Select drp = new Select(LiPerformerPOM.clickType(driver));
		drp.selectByIndex(1);
		CFOcountPOM.clickApply1(driver).click();	
		  Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring(driver)));
		String Expiring=MethodPOM.clickExpiring(driver).getText();
		
	     int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.
	     
	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
	     String pfr=LiPerformerPOM.PFRCount(driver).getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickExpiring(driver).click();					//Clicking on 'Expiring' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
		/*	MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total)
			int total = Integer.parseInt(LicenseActiveCount);
			
			if(Activelicense == total)
	{
		//test.log(LogStatus.PASS, "Dashboard 'Expired' count matches to the total records displayed in grid.");
		test.log(LogStatus.PASS, "Dashboard 'Active' count = "+Activelicense+" | Total records in grid = "+total);
	}
	else
	{
		//test.log(LogStatus.FAIL, "Dashboard 'Expired' count doesn't matches to the total records displayed in grid.");
		test.log(LogStatus.FAIL, "Dashboard 'Active' count = "+Activelicense+" | Total records in grid = "+total);
	}
	*/
	   
    Thread.sleep(3000);
    OverduePOM.ActiveAction(driver).click();	
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));	
	js1.executeScript("window.scrollBy(0,1000)");
   Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown(driver)));
	Select status = new Select(OverduePOM.selectInternalDropdown(driver));	//Selecting Status dropdown box.
	status.selectByIndex(2);	
	
	Thread.sleep(5000);
	js1.executeScript("window.scrollBy(0,100)");
	 String workingDir = System.getProperty("user.dir");
		OverduePOM.fileUploadInternal(driver).sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button. (Internal)
		Thread.sleep(1000);
		js1.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(500);
	 LiPerformerPOM.indate(driver).sendKeys("01-08-2023");
	Thread.sleep(5000);
	 LiPerformerPOM.justclick(driver).click();
	//LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
	//js1.executeScript("window.scrollBy(0,300)");

	
Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(300);
OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.

Thread.sleep(1000);
js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.

Thread.sleep(300);
if(type.equalsIgnoreCase("Statutory"))
{
	
	Thread.sleep(500);
	js1.executeScript("window.scrollBy(2000,0)");	//Scrolling up window by 2000 px.
}
else
	{
	test.log(LogStatus.PASS, "Save Sucessfully.");
	 }
	driver.switchTo().parentFrame();
	
	Thread.sleep(700);
	LiPerformerPOM.clickClose(driver).click();				//Clicking on Close (Cross)
	driver.navigate().refresh();
	MethodPOM.clickMyDashboard(driver).click();
	
	wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
	LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
	
	
	Select drp1 = new Select(LiPerformerPOM.clickType(driver));
	Thread.sleep(7000);
	drp1.selectByIndex(1);
	CFOcountPOM.clickApply1(driver).click();	
	  Thread.sleep(3000);
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring(driver)));
	String Expiring1=MethodPOM.clickExpiring(driver).getText();
	
     int Expiringlicense1 = Integer.parseInt(Expiring1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
     String pfr1=LiPerformerPOM.PFRCount(driver).getText();
     int pfrlicense1 = Integer.parseInt(pfr1);	//Reading PendingForReview count.
     
     if(Expiringlicense>Expiringlicense1&&pfrlicense<pfrlicense1)
     {
    	 test.log(LogStatus.PASS, "Expiring Old Count = "+Expiringlicense+" | New Count = "+Expiringlicense1);
         test.log(LogStatus.PASS, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     else
     {
    	 test.log(LogStatus.FAIL, "Expiring Old Count = "+Expiringlicense+" | New Count = "+Expiringlicense1);
         test.log(LogStatus.FAIL, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     
	}
	
	public static void Expiredlicenseperform(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired(driver)));
		String Expired=MethodPOM.clickExpired(driver).getText();
		
	     int Expiredlicense = Integer.parseInt(Expired);	//Reading Expired count.
	     
	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
	     String pfr=LiPerformerPOM.PFRCount(driver).getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickExpired(driver).click();					//Clicking on 'Expiring' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
		/*	MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total)
			int total = Integer.parseInt(LicenseActiveCount);
			
			if(Activelicense == total)
	{
		//test.log(LogStatus.PASS, "Dashboard 'Expired' count matches to the total records displayed in grid.");
		test.log(LogStatus.PASS, "Dashboard 'Active' count = "+Activelicense+" | Total records in grid = "+total);
	}
	else
	{
		//test.log(LogStatus.FAIL, "Dashboard 'Expired' count doesn't matches to the total records displayed in grid.");
		test.log(LogStatus.FAIL, "Dashboard 'Active' count = "+Activelicense+" | Total records in grid = "+total);
	}
	*/
	   
    Thread.sleep(3000);
    OverduePOM.ActiveAction(driver).click();	
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LiPerformerPOM.ShowFream(driver)));		
	js1.executeScript("window.scrollBy(0,1000)");
   Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown(driver)));
	Select status = new Select(OverduePOM.selectStatutoryDropdown(driver));	//Selecting Status dropdown box.
	status.selectByIndex(2);	
	
	Thread.sleep(5000);
	js1.executeScript("window.scrollBy(0,100)");

	//LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
	//js1.executeScript("window.scrollBy(0,300)");

Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(300);
OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.

Thread.sleep(1000);
js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.

Thread.sleep(300);
if(type.equalsIgnoreCase("Statutory"))
{
	
	Thread.sleep(500);
	js1.executeScript("window.scrollBy(2000,0)");	//Scrolling up window by 2000 px.
}
else
	{
	test.log(LogStatus.PASS, "Save Sucessfully.");
	 }
	driver.switchTo().parentFrame();
	
	Thread.sleep(700);
	LiPerformerPOM.clickClose(driver).click();				//Clicking on Close (Cross)
	driver.navigate().refresh();
	MethodPOM.clickMyDashboard(driver).click();
	
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired(driver)));
	String Expired1=MethodPOM.clickExpired(driver).getText();
	
     int Expiredlicense1 = Integer.parseInt(Expired1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
     String pfr1=LiPerformerPOM.PFRCount(driver).getText();
     int pfrlicense1 = Integer.parseInt(pfr1);	//Reading PendingForReview count.
     
     if(Expiredlicense>Expiredlicense1&&pfrlicense<pfrlicense1)
     {
    	 test.log(LogStatus.PASS, "Expired Old Count = "+Expiredlicense+" | New Count = "+Expiredlicense1);
         test.log(LogStatus.PASS, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     else
     {
    	 test.log(LogStatus.FAIL, "Expired Old Count = "+Expiredlicense+" | New Count = "+Expiredlicense1);
         test.log(LogStatus.FAIL, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     
	}
	
	public static void InternalExpiredlicenseperform(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
		LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
		
		
		Select drp = new Select(LiPerformerPOM.clickType(driver));
		drp.selectByIndex(1);
		CFOcountPOM.clickApply1(driver).click();	
		  Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired(driver)));
		String Expired=MethodPOM.clickExpired(driver).getText();
		
	     int Expiredlicense = Integer.parseInt(Expired);	//Reading Expired count.
	     
	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
	     String pfr=LiPerformerPOM.PFRCount(driver).getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickExpired(driver).click();					//Clicking on 'Expiring' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
		/*	MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total)
			int total = Integer.parseInt(LicenseActiveCount);
			
			if(Activelicense == total)
	{
		//test.log(LogStatus.PASS, "Dashboard 'Expired' count matches to the total records displayed in grid.");
		test.log(LogStatus.PASS, "Dashboard 'Active' count = "+Activelicense+" | Total records in grid = "+total);
	}
	else
	{
		//test.log(LogStatus.FAIL, "Dashboard 'Expired' count doesn't matches to the total records displayed in grid.");
		test.log(LogStatus.FAIL, "Dashboard 'Active' count = "+Activelicense+" | Total records in grid = "+total);
	}
	*/
	   
    Thread.sleep(3000);
    OverduePOM.ActiveAction(driver).click();	
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));		
	js1.executeScript("window.scrollBy(0,1000)");
   Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown(driver)));
	Select status = new Select(OverduePOM.selectInternalDropdown(driver));	//Selecting Status dropdown box.
	status.selectByIndex(2);	
	
	 Thread.sleep(3000);
	 String workingDir = System.getProperty("user.dir");
		OverduePOM.fileUploadInternal(driver).sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button. (Internal)
		Thread.sleep(1000);
		js1.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(500);
	 LiPerformerPOM.indate(driver).sendKeys("01-08-2023");
	Thread.sleep(5000);
	 LiPerformerPOM.justclick(driver).click();
	js1.executeScript("window.scrollBy(0,1000)");

	//LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
	//js1.executeScript("window.scrollBy(0,300)");

Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(300);
OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.

Thread.sleep(1000);
js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.

Thread.sleep(300);
if(type.equalsIgnoreCase("Statutory"))
{
	
	Thread.sleep(500);
	js1.executeScript("window.scrollBy(2000,0)");	//Scrolling up window by 2000 px.
}
else
	{
	test.log(LogStatus.PASS, "Save Sucessfully.");
	 }
	driver.switchTo().parentFrame();
	
	Thread.sleep(700);
	LiPerformerPOM.clickClose(driver).click();				//Clicking on Close (Cross)
	driver.navigate().refresh();
	MethodPOM.clickMyDashboard(driver).click();
	
	wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
	LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
	
	
	Select drp1 = new Select(LiPerformerPOM.clickType(driver));
	Thread.sleep(7000);
	drp1.selectByIndex(1);
	CFOcountPOM.clickApply1(driver).click();	
	  Thread.sleep(3000);
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired(driver)));
	String Expired1=MethodPOM.clickExpired(driver).getText();
	
     int Expiredlicense1 = Integer.parseInt(Expired1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
     String pfr1=LiPerformerPOM.PFRCount(driver).getText();
     int pfrlicense1 = Integer.parseInt(pfr1);	//Reading PendingForReview count.
     
     if(Expiredlicense>Expiredlicense1&&pfrlicense<pfrlicense1)
     {
    	 test.log(LogStatus.PASS, "Expired Old Count = "+Expiredlicense+" | New Count = "+Expiredlicense1);
         test.log(LogStatus.PASS, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     else
     {
    	 test.log(LogStatus.FAIL, "Expired Old Count = "+Expiredlicense+" | New Count = "+Expiredlicense1);
         test.log(LogStatus.FAIL, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     
	}
	
	public static void Reports(WebDriver driver, ExtentTest test, String type) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired(driver)));
		
		LiPerformerPOM.clickMyReport(driver).click();		//Clicking on 'My Reports'
		Thread.sleep(5000);
		//progress(driver);
	  
		if(type.equalsIgnoreCase("Internal"))
		{
			LiPerformerPOM.clickType2(driver).click();			//Clicking on 'Type' drop down.
			Thread.sleep(500);
			LiPerformerPOM.selectInternal(driver).click();//Selecting 'Internal' option.
			Thread.sleep(1000);
			LiPerformerPOM.Reportapply(driver).click();
			//progress(driver);
			Thread.sleep(5000);
			//driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]")).click();
			//Thread.sleep(5000);
			//test.log(LogStatus.PASS," License Overview  Button Working Successfully");

		}
		
		Thread.sleep(7000);
		driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]")).click();
	
		test.log(LogStatus.PASS," License Overview  Button Working Successfully");
	      Thread.sleep(3000);
	     driver.findElement(By.xpath("//*[@id='divShowReminderDialog']/div/div/div[1]/button")).click();
		
		
		driver.findElement(By.xpath("//*[@id='exportReport']")).click();
		
		test.log(LogStatus.PASS," License Report  Downloaded Successfully.");
		
		LiPerformerPOM.clickMyReport(driver).click();		//Clicking on 'My Reports'
	
	}
	
	
	public static void CheckReports(WebDriver driver, ExtentTest test, int status, String type) throws InterruptedException, IOException
	{		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)");
		
		LiPerformerPOM.clickStatus1(driver).click();			//Clicking on 'Status' drop down.
		Thread.sleep(5000);
		elementsList = LiPerformerPOM.selectStatus1(driver);	//Selecting Status.
		Thread.sleep(3000);
		elementsList.get(status).click();
		
		LiPerformerPOM.reportapplybtn(driver).click();
		
		Thread.sleep(3000);
		
		Thread.sleep(1000);
		//progress(driver);
		
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
			
			  Thread.sleep(10000);
				CFOcountPOM.readTotalItems1(driver).click();
				
				String item1 = CFOcountPOM.readTotalItems1(driver).getText();
				//String NoRecord = LiReviewerPOM.reNorecord(driver).getText();
				 if(!item1.equalsIgnoreCase("No items to display")) 
				 {
				String[] bits1 = item1.split(" ");								//Splitting the String
				String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
				int count2 = Integer.parseInt(compliancesCount1);
				String NoRecord = LiReviewerPOM.reNorecord(driver).getText();
				   if(!NoRecord.equalsIgnoreCase("No items to display")) 
				 {
					   try
						{
							performerPOM.clickExcelReport(driver).sendKeys(Keys.PAGE_DOWN);
						}
						catch(Exception e)
						{
							
						}
						js.executeScript("window.scrollBy(0,1000)");
						
					
						Thread.sleep(100);
						File dir = new File("C://Users//dipali//Downloads");
						File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(500);
						CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_UP);
						Thread.sleep(250);
						performerPOM.clickExcelReport(driver).click();					//Clicking on 'Excel Report' image.
						
						
						Thread.sleep(500);
						File dir1 = new File("C://Users//dipali//Downloads");
						File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
						
						if(dirContents.length < allFilesNew.length)
						{
							test.log(LogStatus.PASS, "File downloaded successfully.");
							
							File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
						    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
						    {
						       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
						       {
						           lastModifiedFile = allFilesNew[i];
						       }
						    }
							
							Thread.sleep(100);
							fis = new FileInputStream(lastModifiedFile);
							workbook = new XSSFWorkbook(fis);
							sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
							
							int no = sheet.getLastRowNum();
							Row row = sheet.getRow(no);
							Cell c1 = row.getCell(0);
							int records =(int) c1.getNumericCellValue();
							fis.close();
							
							if(count2 == records)
							{
								//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
								test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+records);
							}
							else
							{
								//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
								test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
						}
				 }
						else
						{
							  test.log(LogStatus.PASS, "Expired On Popup No Record Found ");
						}
				 }
		}
		else
		{
			  test.log(LogStatus.PASS, "My Report No Record Found ");
		}
		}
			
	public static void Documents(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		Progress(driver);
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired(driver)));
		
		LiPerformerPOM.clickMyDocuments(driver).click();		//Clicking on 'My Documents'
		Thread.sleep(3000);
		LiPerformerPOM.clickMyDocumentsMenu(driver).click();	//Clicking on 'My Documents'
		
		Progress(driver);
		
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1(driver)));	//Waiting until records table gets visible.
		
		if(type.equalsIgnoreCase("Internal"))
		{
			LiPerformerPOM.clickType2(driver).click();			//Clicking on 'Type' drop down.
			Thread.sleep(5000);
			LiPerformerPOM.selectInternal(driver).click();//Selecting 'Internal' option.
			Thread.sleep(1000);
			Progress(driver);
		}
		
		Thread.sleep(500);
		elementsList = LiPerformerPOM.clickDownload1(driver);

		File dir = new File("C:\\Users\\dipali\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
		Thread.sleep(5000);
		elementsList.get(1).click();//Clicking on first 'Download' link.
		Thread.sleep(3000);
        
		elementsList= LiPerformerPOM.clickviewLiceDocument(driver);
		elementsList.get(1).click(); 
		Thread.sleep(7000);
		//driver.switchTo().frame("Freamshow");
  //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Freamshow"));
		
		By locator = By.xpath("//*[@id='divOverView']/div/div/div[1]/button");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(3000);
	
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "File Viewed successfully.");
	//	LiPerformerPOM.Clickviewclose(driver).click();
		
		
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
		
		
		Thread.sleep(3000);
		if(type.equalsIgnoreCase("Internal"))
		{
			LiPerformerPOM.Clicklictypedropdown(driver).click();
			Thread.sleep(3000);
			LiPerformerPOM.searchlic1in(driver).click();
		}
	
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
		
  
        Thread.sleep(3000);
        
        MethodPOM.clickMyDashboard(driver).click();
	}
	 public  static void MyworkspaceaddLicense(WebDriver driver,ExtentTest test, String type) throws InterruptedException, IOException
	 {
	
		 
		 licmgmtPOM.ClickMyWorkspace(driver).click();
		 WebDriverWait wait = new WebDriverWait(driver, 50);
		 Thread.sleep(3000);
	
		 if(type.equalsIgnoreCase("Internal"))
		 {
			  WebDriverWait wait1= new WebDriverWait(driver, 5);
				wait1.until(ExpectedConditions.visibilityOf(licmgmtPOM.Type2(driver)));
				licmgmtPOM.Type2(driver).click();				//Clicking on 'Type' drop down.
				
				licmgmtPOM.internalType2(driver).click();
				// Select drp = new Select(licmgmtPOM.Type2(driver));
			   //	drp.selectByIndex(1);
		 }
		 else
		 {
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
		         
		         
			        Thread.sleep(7000);
		         test.log(LogStatus.PASS,"License Overview Details Button Working Successfully " );
		     //    Thread.sleep(7000);
		        
		        licmgmtPOM.ClickMyWorkspace(driver).click();
		         Thread.sleep(5000);
		       
			
			licmgmtPOM.ClickAddLicense(driver).click();
			 
			Thread.sleep(3000);	
			 licmgmtPOM.ClickLicenseTypeDropdown(driver).click();
			 
				Thread.sleep(3000);	
			 licmgmtPOM.SelectLicenseTypeper(driver).click();
			 
			 Thread.sleep(3000);
			licmgmtPOM.ClickLocation(driver).click();
			Thread.sleep(3000);
		     licmgmtPOM.LocationMaximize(driver).click();
			
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
			 
			 XSSFSheet Sheet1= ReadExcel();
			 Thread.sleep(3000);
			 sheet = workbook.getSheetAt(2);
			 Row row61= sheet.getRow(6);
			  org.apache.poi.ss.usermodel.Cell c11 = row61.getCell(1);	
			 String LicenseTitle1= c11.getStringCellValue();
			 licmgmtPOM.LicenseTitle(driver).sendKeys(LicenseTitle1);
			 
			 Thread.sleep(3000);
			 Row row71=sheet.getRow(7);
				org.apache.poi.ss.usermodel.Cell c21=row71.getCell(1);
			 String LicenseNo1=c21.getStringCellValue();
			 licmgmtPOM.LicenseNo(driver).sendKeys(LicenseNo1);
			 
			 Thread.sleep(3000);
			 Row row81=sheet.getRow(8);
				org.apache.poi.ss.usermodel.Cell c31=row81.getCell(1);
			 String ApplicationDays1=c31.getStringCellValue();
			 licmgmtPOM.ApplicationDays(driver).sendKeys(ApplicationDays1);
			 
			 Thread.sleep(3000);
			 Row row91=sheet.getRow(9);
				org.apache.poi.ss.usermodel.Cell c41=row91.getCell(1);
			 String LicenseCost1=c41.getStringCellValue();
			 licmgmtPOM.LicenseCost(driver).sendKeys(LicenseCost1);
			 
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
	        

	  	      JavascriptExecutor js11=(JavascriptExecutor) driver ;
				js11.executeScript("window.scroll(0,2000)");
		 licmgmtPOM.ClickNomineedrp(driver).click();
			 Thread.sleep(3000);
			 licmgmtPOM.SelectNominee(driver).click();
			 Thread.sleep(5000);
			 js11.executeScript("window.scroll(0,2000)");
			 Thread.sleep(5000);
			 licmgmtPOM.ClickModificdate(driver).click();
			 Thread.sleep(6000);	
			 js11.executeScript("window.scroll(0,2000)");
			 Thread.sleep(6000);		 
			 licmgmtPOM.ModificatioDate(driver).click();		 
			 Thread.sleep(6000);
			 js11.executeScript("window.scroll(0,2000)");
			 licmgmtPOM.nomineestartdatecal(driver).click();
			 Thread.sleep(3000);
			 licmgmtPOM.selectnominstartdate(driver).click();
			 Thread.sleep(3000);
			 JavascriptExecutor js21=(JavascriptExecutor) driver ;
				js21.executeScript("window.scroll(0,2000)");
			 licmgmtPOM.nomineeEnddatecal(driver).click();
			 Thread.sleep(5000);
			 licmgmtPOM.selectnomineenddate(driver).click();
			 Thread.sleep(5000);
			 licmgmtPOM.Nomineesubmit(driver).click();
			 Thread.sleep(5000);
			    // Switching to Alert       
			        Alert alert1 = driver.switchTo().alert();
			       
			        // Capturing alert message.   
			        String alertMessage1= driver.switchTo().alert().getText();
			       
			        Thread.sleep(3000);
			    //    test.log(LogStatus.PASS, alertMessage);
			       
			        // Displaying alert message
			        System.out.println(alertMessage1);
			       
			       
			        // Accepting alert
			        alert1.accept();
			       
			        test.log(LogStatus.PASS,"License Details Added Successfully" );
			          Thread.sleep(5000);
			        //  test.log(LogStatus.PASS,"Nominee Details Added Successfully" );
			          
			         licmgmtPOM.editlicenseclose(driver).click();
			         Thread.sleep(3000);
			         
			         licmgmtPOM.ClickMyWorkspace(driver).click();
			         Thread.sleep(5000);
			         licmgmtPOM.Overviewworkspace(driver).click();
			         Thread.sleep(3000);
			         test.log(LogStatus.PASS,"License Overview Details Button Working Successfully " );
			         Thread.sleep(7000);
		 }
	 }
			   private static XSSFSheet ReadExcel() {
		// TODO Auto-generated method stub
		return null;
	}

			//      Thread.sleep(7000);
			         
        // licmgmtPOM.CloseOverview(driver).click();
			       //  Thread.sleep(7000);
			         // licmgmtPOM.ClickMyWorkspace(driver).click();

	 

	public static WebElement Progress(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='imgUpdateProgress']"));
		return license;
	}

public static void TerminateLicense1(WebDriver driver, ExtentTest test, String type) throws InterruptedException
{
	  
		   
	   WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.terminatedPerformer(driver)));
		String Terminate=LiPerformerPOM.terminatedPerformer(driver).getText();
		
	     int TerminateLicense = Integer.parseInt(Terminate);	//Reading Terminate count.

	     LiPerformerPOM.terminatedPerformer(driver).click();					//Clicking on 'Terminate ' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			licenseCompanyadmin.MethodPOM.clickReadTerminate(driver).click();					//Clicking on total items count
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
				
				licenseCompanyadmin.MethodPOM.ClickActiveOverview(driver).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, " License Overview Details Successfully");
				Thread.sleep(3000);
				licenseCompanyadmin.MethodPOM.ClickCloseOverview(driver).click();
  
					MethodPOM.clickMyDashboard(driver).click();
				
	   
}

}		



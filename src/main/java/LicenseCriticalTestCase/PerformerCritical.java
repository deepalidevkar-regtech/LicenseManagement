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
import login.webpage;
import performer.OverduePOM;

public class PerformerCritical extends webpage
{
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;		
		//Web instance created
	public static WebElement upload = null;	
	private static WebElement license = null;	
	
	
	public static XSSFSheet ReadExcel1() throws IOException
	{
		
		String workingDir = System.getProperty("user.dir");
		fis = new FileInputStream(workingDir+"//TestData//ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving second sheet of Workbook
		return sheet;
	}
	public static void ActiveLicense(ExtentTest test, String type) throws InterruptedException
	{	

WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive()));
			String Active=MethodPOM.clickActive().getText();
			
		     int Activelicense = Integer.parseInt(Active);	//Reading Active count.

		      MethodPOM.clickActive().click();					//Clicking on 'Active' image
		      Thread.sleep(4000);
		        JavascriptExecutor js1=(JavascriptExecutor)getDriver();
				js1.executeScript("window.scroll(0,500)");
				Thread.sleep(4000);
			  	String item1 = MethodPOM.clickReadExpired().getText();	//Reading total items String value
				  if(!item1.equalsIgnoreCase("No items to display"))
				  {
				MethodPOM.clickReadActive().click();					//Clicking on total items count
				Thread.sleep(500);
				String item = MethodPOM.clickReadActive().getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
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
		MethodPOM.ClickActiveOverview().click();
		test.log(LogStatus.PASS, " License Overview Details Successfully.");
		Thread.sleep(5000);
		MethodPOM.ClickCloseOverview().click();			
		Thread.sleep(7000);
		LiPerformerPOM.editlicenseicon().click();
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.LicenseTitle().clear();
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.LicenseTitle().sendKeys("update License");	
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.LicenseNo().sendKeys("update00");
		Thread.sleep(5000);
		js1.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(3000);
		//LiPerformerPOM.editnomineebtn().click();
		Thread.sleep(3000);
		 /*licmgmtPOM.ClickNomineedrp().click();
		 Thread.sleep(3000);
		 licmgmtPOM.SelectNominee().click();
		 
		 Thread.sleep(5000);
		// js1.executeScript("window.scroll(0,2000)");
		// Thread.sleep(5000);
		 licmgmtPOM.ClickModificdate().click();
		 Thread.sleep(6000);	
		 js1.executeScript("window.scroll(0,2000)");
		 Thread.sleep(6000);		 
		 licmgmtPOM.ModificatioDate().click();		 
		 Thread.sleep(6000);
		 js1.executeScript("window.scroll(0,2000)");
		 licmgmtPOM.nomineestartdatecal().click();
		 Thread.sleep(3000);
		 licmgmtPOM.selectnominstartdate().click();
		 Thread.sleep(3000);
		 JavascriptExecutor js2=(JavascriptExecutor)  ;
			js2.executeScript("window.scroll(0,2000)");
		 licmgmtPOM.nomineeEnddatecal().click();
		 Thread.sleep(5000);
		 licmgmtPOM.selectnomineenddate().click();
		 Thread.sleep(5000);*/
		licenseManagement.licmgmtPOM.Nomineesubmit().click();
		 // Switching to Alert    
		 Thread.sleep(500);
        Alert alert = getDriver().switchTo().alert();
       
        // Capturing alert message.   
        String alertMessage= getDriver().switchTo().alert().getText();
       
        Thread.sleep(3000);
      //  test.log(LogStatus.PASS, alertMessage);
       
        // Displaying alert message
       // System.out.println(alertMessage);
        // Accepting alert
        /*Thread.sleep(3000);
        By locator = By.xpath("//*[@class='k-button-group k-dialog-buttongroup k-dialog-button-layout-stretched']");

    	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    	Thread.sleep(4000);
    	
    	WebElement ViewButton = .findElement(locator);	
    	Thread.sleep(3000);
    JavascriptExecutor jse=(JavascriptExecutor);
    jse.executeScript("arguments[0].click();", ViewButton);
    	Thread.sleep(4000);
        
      //  LiPerformerPOM.licenseOK().click();
        
     */
        // Accepting alert
        alert.accept();
        test.log(LogStatus.PASS,"License Details Updated Successfully." );
        
          Thread.sleep(5000);
          
          licmgmtPOM.editlicenseclose().click();
          Thread.sleep(300);
          MethodPOM.clickMyDashboard().click();
          Thread.sleep(1000);
			  }
			  else
			  {
				   		      
				test.log(LogStatus.PASS,"No Record Found");
				MethodPOM.clickMyDashboard().click();
					      
			  }
         // MethodPOM.clickActive().click();	
          
        //  Thread.sleep(3000);
	//	LiPerformerPOM.clickAction().click();					//Clicking on first action button.
		
		//progress();
		
		//Thread.sleep(500);
	
		
	if(type.equalsIgnoreCase("Internal"))
		{


WebDriverWait wait1 = new WebDriverWait( getDriver(), (30));
			wait1.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
			LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
			
			
			Select drp = new Select(LiPerformerPOM.clickType());
			drp.selectByIndex(1);
			CFOcountPOM.clickApply1().click();	
			  Thread.sleep(3000);
			MethodPOM.clickActive().click();	
	          
	        Thread.sleep(3000);
			OverduePOM.ActiveAction().click();					//Clicking on first action button.
			//Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
			js1.executeScript("window.scrollBy(0,3000)");
			 Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown()));
			Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting Status dropdown box.
			status.selectByIndex(2);	
		
		}
		else
		{
			MethodPOM.clickActive().click();	
	          
	         Thread.sleep(3000);
	         OverduePOM.ActiveAction().click();					//Clicking on first action button.
			                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LiPerformerPOM.ShowFream()));		
			js1.executeScript("window.scrollBy(0,1000)");
		    Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown()));
			Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting Status dropdown box.
			status.selectByIndex(2);	
		}
		
		try
		{
			Thread.sleep(300);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		licenseReviewer.LiReMethodsPOM.perform(test);			//Calling perform method of Reviewer.
		
		try
		{
			Thread.sleep(500);
			LiPerformerPOM.clickCheckbox().click();			//Clicking on checkbox of Penalty values
			js1.executeScript("window.scrollBy(0,300)");
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		js1.executeScript("window.scrollBy(0,700)");
		Thread.sleep(300);
		OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.
		
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
		getDriver().switchTo().parentFrame();
			
			Thread.sleep(700);
			LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
			getDriver().navigate().refresh();
			MethodPOM.clickMyDashboard().click();

	
	}

	public static void activelicenseperform( ExtentTest test, String type) throws InterruptedException
	{
		


WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive()));
		String Active=MethodPOM.clickActive().getText();
		
	     int Activelicense = Integer.parseInt(Active);	//Reading Active count.

	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount()));
	     String pfr=LiPerformerPOM.PFRCount().getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickActive().click();					//Clicking on 'Active' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			String item1 = MethodPOM.clickReadExpired().getText();	//Reading total items String value
			  if(!item1.equalsIgnoreCase("No items to display"))
			  {
		MethodPOM.clickReadActive().click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive().getText();	//Reading total items String value
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
    OverduePOM.ActiveAction().click();					//Clicking on first action button.
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LiPerformerPOM.ShowFream()));		
	js1.executeScript("window.scrollBy(0,1000)");
   Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown()));
	Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting Status dropdown box.
	status.selectByIndex(2);	
	
	Thread.sleep(5000);
	js1.executeScript("window.scrollBy(0,100)");

	//LiPerformerPOM.clickCheckbox().click();			//Clicking on checkbox of Penalty values
	//js1.executeScript("window.scrollBy(0,300)");

Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(300);
OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.

Thread.sleep(1000);
js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.

Thread.sleep(300);

	
	Thread.sleep(500);
	js1.executeScript("window.scrollBy(2000,0)");	//Scrolling up window by 2000 px.


	test.log(LogStatus.PASS, "Save Sucessfully.");
	getDriver().switchTo().parentFrame();
	
	Thread.sleep(700);
	LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
	getDriver().navigate().refresh();
	MethodPOM.clickMyDashboard().click();
	
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive()));
	String Active1=MethodPOM.clickActive().getText();
	
     int Activelicense1 = Integer.parseInt(Active1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount()));
     String pfr1=LiPerformerPOM.PFRCount().getText();
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
			MethodPOM.clickMyDashboard().click();
    	 }
     }
	
	public static void Internalactivelicenseperform( ExtentTest test, String type) throws InterruptedException
	{

WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
		CFOcountPOM.clickApply1().click();	
		  Thread.sleep(3000);
		
	
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive()));
		String Active=MethodPOM.clickActive().getText();
		
	     int Activelicense = Integer.parseInt(Active);	//Reading Active count.

	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount()));
	     String pfr=LiPerformerPOM.PFRCount().getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickActive().click();					//Clicking on 'Active' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
		/*	MethodPOM.clickReadActive().click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive().getText();	//Reading total items String value
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
    OverduePOM.ActiveAction().click();					//Clicking on first action button.
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
	js1.executeScript("window.scrollBy(0,3000)");
	 Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown()));
	Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting Status dropdown box.
	status.selectByIndex(2);	
	 Thread.sleep(3000);
	 String workingDir = System.getProperty("user.dir");
		OverduePOM.fileUploadInternal().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button. (Internal)
		Thread.sleep(1000);
		js1.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(500);
	 LiPerformerPOM.indate().sendKeys("01-08-2023");
	Thread.sleep(5000);
	 LiPerformerPOM.justclick().click();
	js1.executeScript("window.scrollBy(0,1000)");

	//LiPerformerPOM.clickCheckbox().click();			//Clicking on checkbox of Penalty values
	//js1.executeScript("window.scrollBy(0,300)");

Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(3000);
OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.

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
getDriver().switchTo().parentFrame();
	
	Thread.sleep(700);
	LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
	getDriver().navigate().refresh();
	MethodPOM.clickMyDashboard().click();
	
	wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
	LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
	
	
	Select drp1 = new Select(LiPerformerPOM.clickType());
	Thread.sleep(7000);
	drp1.selectByIndex(1);
	CFOcountPOM.clickApply1().click();	
	  Thread.sleep(3000);
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive()));
	String Active1=MethodPOM.clickActive().getText();
	
     int Activelicense1 = Integer.parseInt(Active1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount()));
     String pfr1=LiPerformerPOM.PFRCount().getText();
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
	
	public static void Expiringlicenseperform( ExtentTest test, String type) throws InterruptedException
	{


WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring()));
		String Expiring=MethodPOM.clickExpiring().getText();
		
	     int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.
	     
	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount()));
	     String pfr=LiPerformerPOM.PFRCount().getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickExpiring().click();					//Clicking on 'Expiring' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			String item1 = MethodPOM.clickReadExpired().getText();	//Reading total items String value
			  if(!item1.equalsIgnoreCase("No items to display"))
			  {
		/*	MethodPOM.clickReadActive().click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive().getText();	//Reading total items String value
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
    OverduePOM.ActiveAction().click();	
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LiPerformerPOM.ShowFream()));		
	js1.executeScript("window.scrollBy(0,1000)");
   Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown()));
	Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting Status dropdown box.
	status.selectByIndex(2);	
	
	Thread.sleep(5000);
	js1.executeScript("window.scrollBy(0,100)");

	//LiPerformerPOM.clickCheckbox().click();			//Clicking on checkbox of Penalty values
	//js1.executeScript("window.scrollBy(0,300)");

Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(300);
OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.

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
getDriver().switchTo().parentFrame();
	
	Thread.sleep(700);
	LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
	getDriver().navigate().refresh();
	MethodPOM.clickMyDashboard().click();
			  }
			  else
			  {
				    
					test.log(LogStatus.PASS,"No Record Found");
					MethodPOM.clickMyDashboard().click();
			  }
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring()));
	String Expiring1=MethodPOM.clickExpiring().getText();
	
     int Expiringlicense1 = Integer.parseInt(Expiring1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount()));
     String pfr1=LiPerformerPOM.PFRCount().getText();
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
	public static void internalExpiringlicenseperform( ExtentTest test, String type) throws InterruptedException
	{

WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
		CFOcountPOM.clickApply1().click();	
		  Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring()));
		String Expiring=MethodPOM.clickExpiring().getText();
		
	     int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.
	     
	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount()));
	     String pfr=LiPerformerPOM.PFRCount().getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickExpiring().click();					//Clicking on 'Expiring' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor)getDriver()  ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
		/*	MethodPOM.clickReadActive().click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive().getText();	//Reading total items String value
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
    OverduePOM.ActiveAction().click();	
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));	
	js1.executeScript("window.scrollBy(0,1000)");
   Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown()));
	Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting Status dropdown box.
	status.selectByIndex(2);	
	
	Thread.sleep(5000);
	js1.executeScript("window.scrollBy(0,100)");
	 String workingDir = System.getProperty("user.dir");
		OverduePOM.fileUploadInternal().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button. (Internal)
		Thread.sleep(1000);
		js1.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(500);
	 LiPerformerPOM.indate().sendKeys("01-08-2023");
	Thread.sleep(5000);
	 LiPerformerPOM.justclick().click();
	//LiPerformerPOM.clickCheckbox().click();			//Clicking on checkbox of Penalty values
	//js1.executeScript("window.scrollBy(0,300)");

	
Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(300);
OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.

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
getDriver().switchTo().parentFrame();
	
	Thread.sleep(700);
	LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
	getDriver().navigate().refresh();
	MethodPOM.clickMyDashboard().click();
	
	wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
	LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
	
	
	Select drp1 = new Select(LiPerformerPOM.clickType());
	Thread.sleep(7000);
	drp1.selectByIndex(1);
	CFOcountPOM.clickApply1().click();	
	  Thread.sleep(3000);
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring()));
	String Expiring1=MethodPOM.clickExpiring().getText();
	
     int Expiringlicense1 = Integer.parseInt(Expiring1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount()));
     String pfr1=LiPerformerPOM.PFRCount().getText();
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
	
	public static void Expiredlicenseperform( ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired()));
		String Expired=MethodPOM.clickExpired().getText();
		
	     int Expiredlicense = Integer.parseInt(Expired);	//Reading Expired count.
	     
	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount()));
	     String pfr=LiPerformerPOM.PFRCount().getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickExpired().click();					//Clicking on 'Expiring' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor)getDriver()  ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
		/*	MethodPOM.clickReadActive().click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive().getText();	//Reading total items String value
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
    OverduePOM.ActiveAction().click();	
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LiPerformerPOM.ShowFream()));		
	js1.executeScript("window.scrollBy(0,1000)");
   Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown()));
	Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting Status dropdown box.
	status.selectByIndex(2);	
	
	Thread.sleep(5000);
	js1.executeScript("window.scrollBy(0,100)");

	//LiPerformerPOM.clickCheckbox().click();			//Clicking on checkbox of Penalty values
	//js1.executeScript("window.scrollBy(0,300)");

Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(300);
OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.

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
	getDriver().switchTo().parentFrame();
	
	Thread.sleep(700);
	LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
	getDriver().navigate().refresh();
	MethodPOM.clickMyDashboard().click();
	
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired()));
	String Expired1=MethodPOM.clickExpired().getText();
	
     int Expiredlicense1 = Integer.parseInt(Expired1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount()));
     String pfr1=LiPerformerPOM.PFRCount().getText();
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
	
	public static void InternalExpiredlicenseperform( ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
		CFOcountPOM.clickApply1().click();	
		  Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired()));
		String Expired=MethodPOM.clickExpired().getText();
		
	     int Expiredlicense = Integer.parseInt(Expired);	//Reading Expired count.
	     
	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount()));
	     String pfr=LiPerformerPOM.PFRCount().getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickExpired().click();					//Clicking on 'Expiring' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor)getDriver()  ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
		/*	MethodPOM.clickReadActive().click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive().getText();	//Reading total items String value
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
    OverduePOM.ActiveAction().click();	
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));		
	js1.executeScript("window.scrollBy(0,1000)");
   Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown()));
	Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting Status dropdown box.
	status.selectByIndex(2);	
	
	 Thread.sleep(3000);
	 String workingDir = System.getProperty("user.dir");
		OverduePOM.fileUploadInternal().sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button. (Internal)
		Thread.sleep(1000);
		js1.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(500);
	 LiPerformerPOM.indate().sendKeys("01-08-2023");
	Thread.sleep(5000);
	 LiPerformerPOM.justclick().click();
	js1.executeScript("window.scrollBy(0,1000)");

	//LiPerformerPOM.clickCheckbox().click();			//Clicking on checkbox of Penalty values
	//js1.executeScript("window.scrollBy(0,300)");

Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(300);
OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.

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
getDriver().switchTo().parentFrame();
	
	Thread.sleep(700);
	LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
	getDriver().navigate().refresh();
	MethodPOM.clickMyDashboard().click();
	
	wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
	LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
	
	
	Select drp1 = new Select(LiPerformerPOM.clickType());
	Thread.sleep(7000);
	drp1.selectByIndex(1);
	CFOcountPOM.clickApply1().click();	
	  Thread.sleep(3000);
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired()));
	String Expired1=MethodPOM.clickExpired().getText();
	
     int Expiredlicense1 = Integer.parseInt(Expired1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount()));
     String pfr1=LiPerformerPOM.PFRCount().getText();
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
	
	
	public static void Reports( ExtentTest test, String type) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired()));
		
		LiPerformerPOM.clickMyReport().click();		//Clicking on 'My Reports'
		Thread.sleep(5000);
		//progress();
	  
		if(type.equalsIgnoreCase("Internal"))
		{
			LiPerformerPOM.clickType2().click();			//Clicking on 'Type' drop down.
			Thread.sleep(500);
			LiPerformerPOM.selectInternal().click();//Selecting 'Internal' option.
			Thread.sleep(1000);
			LiPerformerPOM.Reportapply().click();
			//progress();
			Thread.sleep(5000);
			//.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]")).click();
			//Thread.sleep(5000);
			//test.log(LogStatus.PASS," License Overview  Button Working Successfully");

		}
		
		Thread.sleep(7000);
		getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]")).click();
	
		test.log(LogStatus.PASS," License Overview  Button Working Successfully");
	      Thread.sleep(3000);
	      getDriver().findElement(By.xpath("//*[@id='divShowReminderDialog']/div/div/div[1]/button")).click();
		
		
	      getDriver().findElement(By.xpath("//*[@id='exportReport']")).click();
		
		test.log(LogStatus.PASS," License Report  Downloaded Successfully.");
		
		LiPerformerPOM.clickMyReport().click();		//Clicking on 'My Reports'
	
	}
	
	
	public static void CheckReports( ExtentTest test, int status, String type) throws InterruptedException, IOException
	{		
		
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
		js.executeScript("window.scrollBy(0,-1000)");
		
		LiPerformerPOM.clickStatus1().click();			//Clicking on 'Status' drop down.
		Thread.sleep(5000);
		elementsList = LiPerformerPOM.selectStatus1();	//Selecting Status.
		Thread.sleep(3000);
		elementsList.get(status).click();
		
		LiPerformerPOM.reportapplybtn().click();
		
		Thread.sleep(3000);
		
		Thread.sleep(1000);
		//progress();
		
		int flag = 0;
		try
		{
			wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1()));	//Waiting until records table gets visible.
			flag = 1;
		}
		catch(Exception e)
		{
			
		}
		
		if(flag == 1)
		{
			js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
			
			  Thread.sleep(10000);
				CFOcountPOM.readTotalItems1().click();
				
				String item1 = CFOcountPOM.readTotalItems1().getText();
				//String NoRecord = LiReviewerPOM.reNorecord().getText();
				 if(!item1.equalsIgnoreCase("No items to display")) 
				 {
				String[] bits1 = item1.split(" ");								//Splitting the String
				String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
				int count2 = Integer.parseInt(compliancesCount1);
				String NoRecord = LiReviewerPOM.reNorecord().getText();
				   if(!NoRecord.equalsIgnoreCase("No items to display")) 
				 {
					   try
						{
							performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
						}
						catch(Exception e)
						{
							
						}
						js.executeScript("window.scrollBy(0,1000)");
						
					
						Thread.sleep(100);
						File dir = new File("C://Users//deepalid//Downloads");
						File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(500);
						CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
						Thread.sleep(250);
						performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
						
						
						Thread.sleep(500);
						File dir1 = new File("C://Users//deepalid//Downloads");
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
			
	public static void Documents( ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		
		Progress();
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired()));
		
		LiPerformerPOM.clickMyDocuments().click();		//Clicking on 'My Documents'
		Thread.sleep(3000);
		LiPerformerPOM.clickMyDocumentsMenu().click();	//Clicking on 'My Documents'
		
		Progress();
		
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1()));	//Waiting until records table gets visible.
		
		if(type.equalsIgnoreCase("Internal"))
		{
			LiPerformerPOM.clickType2().click();			//Clicking on 'Type' drop down.
			Thread.sleep(5000);
			LiPerformerPOM.selectInternal().click();//Selecting 'Internal' option.
			Thread.sleep(1000);
			Progress();
		}
		
		Thread.sleep(500);
		elementsList = LiPerformerPOM.clickDownload1();

		File dir = new File("C://Users//deepalid//Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
		Thread.sleep(5000);
		elementsList.get(1).click();//Clicking on first 'Download' link.
		Thread.sleep(3000);
        
		elementsList= LiPerformerPOM.clickviewLiceDocument();
		elementsList.get(1).click(); 
		Thread.sleep(7000);
		//.switchTo().frame("Freamshow");
  //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Freamshow"));
		
		By locator = By.xpath("//*[@id='divOverView']/div/div/div[1]/button");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(3000);
	
	JavascriptExecutor jse=(JavascriptExecutor)getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "File Viewed successfully.");
	//	LiPerformerPOM.Clickviewclose().click();
		
		
		Thread.sleep(3000);
		File dir1 = new File("C://Users//deepalid//Downloads");
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
			LiPerformerPOM.Clicklictypedropdown().click();
			Thread.sleep(3000);
			LiPerformerPOM.searchlic1in().click();
		}
	
	//	wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		//wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		LiPerformerPOM.Multicheckdoc1().click();
		Thread.sleep(3000);
		LiPerformerPOM.Multicheckdoc2().click();
		
		
		File dir2 = new File("C://Users//deepalid//Downloads");
		File[] dirContents2 = dir2.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		LiPerformerPOM.MultiDownload().click();		//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir3 = new File("C://Users//deepalid//Downloads");
		File[] allFilesNew = dir3.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(500);
       if(dirContents2.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, " Multipal  File downloaded successfully.");	
		}	
       else
		{
			test.log(LogStatus.FAIL, " Multipal File does not downloaded.");
		}
		Thread.sleep(3000);
		
        
        MethodPOM.clickMyDashboard().click();
	}
	 public  static void MyworkspaceaddLicense(ExtentTest test, String type) throws InterruptedException, IOException
	 {
	
		 
		 licmgmtPOM.ClickMyWorkspace().click();
		 WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		 Thread.sleep(3000);
	
		 if(type.equalsIgnoreCase("Internal"))
		 {
			 WebDriverWait wait1 = new WebDriverWait( getDriver(), (30));
				wait1.until(ExpectedConditions.visibilityOf(licmgmtPOM.Type2()));
				licmgmtPOM.Type2().click();				//Clicking on 'Type' drop down.
				
				licmgmtPOM.internalType2().click();
				// Select drp = new Select(licmgmtPOM.Type2());
			   //	drp.selectByIndex(1);
		 }
		 else
		 {
		 licmgmtPOM.WorkspaceExport().click();
		 test.log(LogStatus.PASS,"License Details Export" );
		 Thread.sleep(3000);	

	
	licmgmtPOM.ClickAddLicense().click();
		 
		Thread.sleep(3000);	
		 licmgmtPOM.ClickLicenseTypeDropdown().click();
		 
			Thread.sleep(3000);	
		 licmgmtPOM.SelectLicenseTypeperin().click();
		 
		 Thread.sleep(3000);
		licmgmtPOM.ClickLocation().click();
		Thread.sleep(3000);
	     licmgmtPOM.LocationMaximizeper().click();
		
		 Thread.sleep(5000);
		 licmgmtPOM.SelectLocation().click();
		 
		 Thread.sleep(3000);
		 licmgmtPOM.ClickCompliance().click();
		 Thread.sleep(5000);
		 licmgmtPOM.SelectLicenseCompliance().get(1).click();
		 
		 Thread.sleep(5000);
		 licmgmtPOM.ClickPerformer().click();
		 Thread.sleep(6000);
		 licmgmtPOM.SelectPerformer().get(3).click();
		// licmgmtPOM.SelectPerformer().click();
		
		 Thread.sleep(3000);
		 licmgmtPOM.ClickReviewer().click();
		 Thread.sleep(6000);
		 licmgmtPOM.SelectReviewer().get(111).click(); 
		 
		 XSSFSheet Sheet= ReadExcel1();
		 Thread.sleep(3000);
		 sheet = workbook.getSheetAt(2);
		 Row row6= sheet.getRow(6);
		  org.apache.poi.ss.usermodel.Cell c1 = row6.getCell(1);	
		 String LicenseTitle= c1.getStringCellValue();
		 licmgmtPOM.LicenseTitle().sendKeys(LicenseTitle);
		 
		 Thread.sleep(3000);
		 Row row7=sheet.getRow(7);
			org.apache.poi.ss.usermodel.Cell c2=row7.getCell(1);
		 String LicenseNo=c2.getStringCellValue();
		 licmgmtPOM.LicenseNo().sendKeys(LicenseNo);
		 
	

		 
		licmgmtPOM.ClickCal().click();
		 Thread.sleep(7000);
		 licmgmtPOM.NewDate().click();
		 Thread.sleep(5000);
		licmgmtPOM.ClickCal1().click();
		 Thread.sleep(7000);
		licmgmtPOM.NewEndDate().click();
		
		 
		Thread.sleep(300);
		// licmgmtPOM.Chooesfile().click();
			//String workingDir = System.getProperty("user.dir");
			//licmgmtPOM.Chooesfile().sendKeys(workingDir+"//Reports//LicensePerformerResults(Statutory).html");
        

  	      JavascriptExecutor js1=(JavascriptExecutor)getDriver();
			js1.executeScript("window.scroll(0,2000)");
	
		 licmgmtPOM.Nomineesubmit().click();
		 Thread.sleep(5000);
		    // Switching to Alert       
		        Alert alert = getDriver().switchTo().alert();
		       
		        // Capturing alert message.   
		        String alertMessage= getDriver().switchTo().alert().getText();
		       
		        Thread.sleep(3000);
		    //    test.log(LogStatus.PASS, alertMessage);
		       
		        // Displaying alert message
		        System.out.println(alertMessage);
		       
		       
		        // Accepting alert
		        alert.accept();
		       
		        test.log(LogStatus.PASS,"License Details Added Successfully" );
		    
		          
		         licmgmtPOM.editlicenseclose().click();
		         Thread.sleep(5000);
		         
		         
			        Thread.sleep(7000);
		         test.log(LogStatus.PASS,"License Overview Details Button Working Successfully " );
		     //    Thread.sleep(7000);
		        
		        licmgmtPOM.ClickMyWorkspace().click();
		         Thread.sleep(5000);
		       
			
		
		 }
	 }
			   private static XSSFSheet ReadExcel() {
		// TODO Auto-generated method stub
		return null;
	}

			//      Thread.sleep(7000);
			         
        // licmgmtPOM.CloseOverview().click();
			       //  Thread.sleep(7000);
			         // licmgmtPOM.ClickMyWorkspace().click();

	 

	public static WebElement Progress()
	{
		license = getDriver().findElement(By.xpath("//*[@id='imgUpdateProgress']"));
		return license;
	}

public static void TerminateLicense1(ExtentTest test, String type) throws InterruptedException
{
	  
		   
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.terminatedPerformer()));
		String Terminate=LiPerformerPOM.terminatedPerformer().getText();
		
	     int TerminateLicense = Integer.parseInt(Terminate);	//Reading Terminate count.

	     LiPerformerPOM.terminatedPerformer().click();					//Clicking on 'Terminate ' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor)getDriver()  ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			licenseCompanyadmin.MethodPOM.clickReadTerminate().click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadTerminate().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicensTerminate= bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
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
				
				licenseCompanyadmin.MethodPOM.ClickActiveOverview().click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, " License Overview Details Successfully");
				Thread.sleep(3000);
				licenseCompanyadmin.MethodPOM.ClickCloseOverview().click();
  
					MethodPOM.clickMyDashboard().click();
				
	   
}

}		



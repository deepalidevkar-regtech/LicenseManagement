package licenseReviewer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import LicenseCompanyadmin.StatutoryMethod;
import cfo.CFOcountPOM;
import licenseManagement.licmgmtMethodPOM;
import licensePerformer.LiPeMethodsPOM;
import licensePerformer.LiPerformerPOM;
import login.webpage;

public class LicenseReviewerInternalTC extends webpage
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
		sheet = workbook.getSheetAt(4);					//Retrieving second sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		String workingDir = System.getProperty("user.dir");
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LicenseReviewerResult(Internal).html",true);
		test = extent.startTest("Logging In - Reviewer (Internal)");
		//test.log(LogStatus.INFO, "Browser test is initiated");
		
		/*XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		*/
		//test = extent.startTest("Logging In - Reviewer (Internal)");
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
  	@BeforeMethod
    	void Login() throws InterruptedException, IOException
    	{
    		/*test = extent.startTest("Logging In - Reviewer (Internal)");
    		//test.log(LogStatus.INFO, "Logging into system");
    		XSSFSheet sheet = ReadExcel();
    		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
    		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
    		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
    		
    		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
    		
    		//XSSFSheet sheet = ReadExcel();
    		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
    		Cell c12 = row1.getCell(1);						//Selected cell (1 row,1 column)
    		String uname = c12.getStringCellValue();			//Got the URL stored at position 1,1
    		
    		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
    		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
    		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
    		
    		driver = login.Login.UserLogin(uname,password,"License");		//Method of Login class to login user.
    		
    	/*	test.log(LogStatus.PASS, "Test Passed.");
    		extent.endTest(test);
    		extent.flush();*/
  		initialization("License",4);
    	}
@Test(priority = 2)
	void ActiveInternalLicense() throws InterruptedException, IOException
	{
		//test = extent.startTest("Active License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		

   WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
	
		try
		{
			Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		CFOcountPOM.clickApply1().click();				//Clicking on Apply.
		
		test = extent.startTest("Active License Count  Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		LiReMethodsPOM.ReviewerActiveLicense( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
 /*@Test(priority = 3)
		void ExpiringInternalLicense() throws InterruptedException, IOException
		{
	   // test = extent.startTest("Expiring License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		

		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
		
		try
		{
			Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		CFOcountPOM.clickApply1().click();				//Clicking on Apply.
			test = extent.startTest("Expiring License Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LiReMethodsPOM.ReviewerExpiringCount( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
 @Test(priority = 4)
	void ExpiredInternalLicense() throws InterruptedException, IOException
	{

		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
		
		try
		{
			Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		CFOcountPOM.clickApply1().click();				//Clicking on Apply.
		test = extent.startTest("Expired License Count Verification");
		//test.log(LogStatus.PASS, "Expired License Count Verification");
		
		LiReMethodsPOM.ReviewerExpiredCount( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
 @Test(priority = 5)
	void AppliedInternalLicense() throws InterruptedException, IOException
	{

		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
		
		try
		{
			Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		CFOcountPOM.clickApply1().click();				//Clicking on Apply.
		test = extent.startTest("Applied Internal License Verification");
	//	test.log(LogStatus.PASS, "Applied Internal License Verification");
		
		LiReMethodsPOM.ReviewerAppliedCount( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
   @Test(priority = 6)
		void PendingForReviewInternalLicense() throws InterruptedException, IOException
		{

		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
	LiPerformerPOM.clickType().click();	//Clicking on 'Type' drop down.
	
	Thread.sleep(500);
	Select drp = new Select(LiPerformerPOM.clickType());
	drp.selectByIndex(1);
	
	try
	{
		Thread.sleep(400);
		wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
	}
	catch(Exception e)
	{
		
	}
	
	Thread.sleep(500);
	CFOcountPOM.clickApply1().click();				//Clicking on Apply.
			test = extent.startTest("Pending For Review Count Verification");
			//test.log(LogStatus.PASS, "Pending For Review Count Verification");
			
			LiReMethodsPOM.PendingReviewCountInternal( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
    
/*@Test(priority = 7)
	void RejectedInternalLicense() throws InterruptedException, IOException
	{

	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
	LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
	
	Select drp = new Select(LiPerformerPOM.clickType());
	drp.selectByIndex(1);
	
	try
	{
		Thread.sleep(400);
		wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
	}
	catch(Exception e)
	{
		
	}
	
	Thread.sleep(500);
	CFOcountPOM.clickApply1().click();				//Clicking on Apply.
		test = extent.startTest("Rejected License Count  Verification");
		//test.log(LogStatus.PASS, "Rejected License Count  Verification");
		
		LiReMethodsPOM.ReviewerRejectedCount( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =8)
	void LicenseExpiredOnInternal() throws InterruptedException
	{

		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
		
		try
		{
			Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		CFOcountPOM.clickApply1().click();				//Clicking on Apply.
		test = extent.startTest("License Expired On Working Verification");
	    // test.log(LogStatus.PASS, "License ExpiredOn Working Verification");
		
	  LiPeMethodsPOM.LicenseExpiredOnperInternal( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 9)
		void LicenseExpiringOnInternal() throws InterruptedException, IOException
		{

		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
			LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
			
			Select drp = new Select(LiPerformerPOM.clickType());
			drp.selectByIndex(1);
			
			try
			{
				Thread.sleep(400);
				wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
			}
			catch(Exception e)
			{
				
			}
			
			Thread.sleep(500);
			CFOcountPOM.clickApply1().click();				//Clicking on Apply.
			test = extent.startTest("License ExpiringIn Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LiReMethodsPOM.LicenseExpiringOnInternalrew( test, "Internal");
	
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 10)
	void TerminateInternalInternalLicense() throws InterruptedException
	{

	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		 Select drp = new Select(LiPerformerPOM.clickType());
	   	drp.selectByIndex(1);
	   	CFOcountPOM.clickApply1().click();		
		test = extent.startTest("Terminate License Count Verification");
		//test.log(LogStatus.PASS, "Terminate License Count Verification");
		
		LiReMethodsPOM.TerminateLicense1rew( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 11)
	void MyDocuments() throws InterruptedException
	{
		test = extent.startTest("My Documents Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		licensePerformer.LiPeMethodsPOM.Documents( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 12)
	void MyReports() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports Download verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		licensePerformer.LiPeMethodsPOM.Reports( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
}
@Test(priority = 13)
	void MyWorkspace() throws InterruptedException, IOException
	{

	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		 Select drp = new Select(LiPerformerPOM.clickType());
	   drp.selectByIndex(1);
		test = extent.startTest(" My Workspace  Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
      licmgmtMethodPOM.MyworkspaceaddLicense( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 14)
	 void NomineeDetails() throws InterruptedException, IOException

	  {
		
		test = extent.startTest("Nominee Details");
		//test.log(LogStatus.PASS, "Noimnee Details Added Sucessfully");
		licmgmtMethodPOM.NomineeDetails(test,"Internal");

		extent.endTest(test);
		extent.flush();
	  }
  	@Test(priority = 15)
  	void AssignedButNotActivated() throws InterruptedException, IOException
  	{
  		test = extent.startTest("Assigned But Not Activated  Count Verification");
  		//test.log(LogStatus.INFO, "Test Initiated");
  		

		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
  	
  		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
  		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
  		
  		Select drp = new Select(LiPerformerPOM.clickType());
  		drp.selectByIndex(1);
  		
  		try
  		{
  			Thread.sleep(400);
  			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
  		}
  		catch(Exception e)
  		{
  			
  		}
  		
  		Thread.sleep(500);
  		CFOcountPOM.clickApply1().click();				//Clicking on Apply.
  		
  		LiPeMethodsPOM.AssignedButNotActivated( test, "Internal");
  		
  		extent.endTest(test);
  		extent.flush();
  	}
  	@Test(priority =16)
	void  InternalActiveDashboardFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Dashboard Active License Entity/Branch Location(Demo Bharat Gujarat1)&LicenseType(Annual maintenance) Filter working  Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
		
		try
		{
			Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		StatutoryMethod.DashboardActivefilter( test, "Internal");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =17)
	void  InternalExpiringDashboardFilter() throws InterruptedException, IOException
	{
	
		test = extent.startTest("Dashboard Expiring  License Entity/Branch Location(Demo Bharat Gujarat1)&LicenseType(Annual maintenance) Filter working  Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
		
		try
		{
			Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		StatutoryMethod.DashboardExpiringfilter( test, "Internal");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =18)
	void  InternalExpiredDashboardFilter() throws InterruptedException, IOException
	{
		
		test = extent.startTest("Dashboard Expired License Entity/Branch Location(Demo Bharat Gujarat1)&LicenseType(Annual maintenance) Filter working  Verification");
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
		
		try
		{
			Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		StatutoryMethod.DashboardExpiredfilter( test, "Internal");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =19)
	void  InternlAppliedDashboardFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Dashboard Applied License Entity/Branch Location(Demo Bharat Gujarat1)&LicenseType(Annual maintenance) Filter working  Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
		
		try
		{
			Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		StatutoryMethod.DashboardAppliedfilter( test, "Internal");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 20)
		void InternalPendingForReviewDashboardFilter() throws InterruptedException, IOException
		{
		    test = extent.startTest("Dashboard Pending For review  Entity/Branch Location(Demo Bharat Gujarat1)&LicenseType(Annual maintenance) Filter working  Verification");
		    WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
			LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
			
			Select drp = new Select(LiPerformerPOM.clickType());
			drp.selectByIndex(1);
			
			try
			{
				Thread.sleep(400);
				wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
			}
			catch(Exception e)
			{
				
			}
			
			StatutoryMethod.Dashboardpendingforreviewfilter( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 21)
		void InternalRejeectedDashboardFilter() throws InterruptedException, IOException
		{
		    test = extent.startTest("Dashboard Rejected License Entity/Branch Location(Demo Bharat Gujarat1)&LicenseType(Annual maintenance) Filter working  Verification");
		    WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
			LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
			
			Select drp = new Select(LiPerformerPOM.clickType());
			drp.selectByIndex(1);
			
			try
			{
				Thread.sleep(400);
				wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
			}
			catch(Exception e)
			{
				
			}
			
			StatutoryMethod.DashboardRejectedLicensefilter( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 22)
		void InternalTerminateDashboardFilter() throws InterruptedException, IOException
		{
		    test = extent.startTest("Dashboard Terminate License Entity/Branch Location(Demo Bharat Gujarat1)&LicenseType(Annual maintenance) Filter working  Verification");
		    WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
			LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
			
			Select drp = new Select(LiPerformerPOM.clickType());
			drp.selectByIndex(1);
			
			try
			{
				Thread.sleep(400);
				wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
			}
			catch(Exception e)
			{
				
			}
			
			StatutoryMethod.DashboardTerminateLicensefilter( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 23)
		void InternalAssignedButNotActivatedDashboardFilter() throws InterruptedException, IOException
		{
		    test = extent.startTest("Dashboard Assigned But Not Activated License Entity/Branch Location(Demo Bharat Gujarat1)&LicenseType(Annual maintenance) Filter working  Verification");
		    WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
			LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
			
			Select drp = new Select(LiPerformerPOM.clickType());
			drp.selectByIndex(1);
			
			try
			{
				Thread.sleep(400);
				wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
			}
			catch(Exception e)
			{
				
			}
			
			StatutoryMethod.DashboardAssignedButNotActivatedFilter( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
  	@Test(priority = 24)
  	void DashboardandReportCountMatch() throws InterruptedException, IOException
  	{
  		test = extent.startTest("Dashboard and Report  Count Match  Verification");
  		//test.log(LogStatus.INFO, "Test Initiated");
  		
  		LiPeMethodsPOM.InternalDashallreportallcountforPerformer( test, "Internal");
  		
  		extent.endTest(test);
  		extent.flush();
  	}*/

	 @AfterMethod
	  void driverclose()
	  {
		  closeBrowser();
	  }

}

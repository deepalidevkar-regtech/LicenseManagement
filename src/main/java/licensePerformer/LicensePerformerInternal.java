package licensePerformer;

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
import login.webpage;

public class LicensePerformerInternal extends webpage
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
		sheet = workbook.getSheetAt(1);					//Retrieving second sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		String workingDir = System.getProperty("user.dir");
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LicensePerformerResults(Internal).html",true);
		test = extent.startTest("Verify OpenBrowser");
		//test.log(LogStatus.INFO, "Browser test is initiated");
		
		/*XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		*/
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
   	@BeforeMethod
    	void Login() throws InterruptedException, IOException
    	{
    		/*test = extent.startTest("Logging In - Performer (Internal)");
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
    		
    		/*test.log(LogStatus.PASS, "Test Passed.");
    		extent.endTest(test);
    		extent.flush();*/
   		initialization("License",1);
    	}
@Test(priority = 2)
	void Active() throws InterruptedException, IOException
	{
		test = extent.startTest("Active License Count Verification");
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
		
		LiPeMethodsPOM.ActiveLicense( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 2)
void ActivePerform() throws InterruptedException
{
	test = extent.startTest(" Perform Active License Verification");
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
	
	LiPeMethodsPOM.Internalactivelicenseperform( test, "Internal");
	
	extent.endTest(test);
	extent.flush();
}
	@Test(priority = 3)
	void Expiring() throws InterruptedException, IOException
	{
		test = extent.startTest("Expiring License Count Verification");
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
		
		LiPeMethodsPOM.ExpiringCount( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 4)
void ExpiringPerform() throws InterruptedException
{
	test = extent.startTest("Perform Expiring License  Verification");
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
	
	LiPeMethodsPOM.internalExpiringlicenseperform( test, "Internal");
	
	extent.endTest(test);
	extent.flush();
}
	
	@Test(priority = 5)
	void Expired() throws InterruptedException, IOException
	{
		test = extent.startTest("Expired License Count Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
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
		
		LiPeMethodsPOM.ExpiredCount( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 6)
 void ExpiredPerform() throws InterruptedException
{
	test = extent.startTest("Perform Expired License Verification");
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
	
	LiPeMethodsPOM.InternalExpiredlicenseperform( test, "Internal");
	
	extent.endTest(test);
	extent.flush();
}
	
@Test(priority = 7)
	void Applied() throws InterruptedException, IOException
	{
		test = extent.startTest("Applied License Count Verification");
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
		
		LiPeMethodsPOM.AppliedCount( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	 @Test(priority = 8)
		void PendingForReviewInternalInternalLicense() throws InterruptedException, IOException
		{
			test = extent.startTest("Pending For Review License  Count Verification");
			//test.log(LogStatus.PASS, "Pending For Review Count Verification");
			
			LicenseCompanyadmin.StatutoryMethod.pendingforreviewInternalLicense( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 9)
	void RejectedInternalLicense() throws InterruptedException, IOException
			{
		WebDriverWait wait = new WebDriverWait(getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
			test = extent.startTest("Rejected License Count  Verification");
				//test.log(LogStatus.PASS, "Rejected License Count  Verification");
				
				LiPeMethodsPOM.RejectedCount( test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
	 @Test(priority = 10)
   void TerminateInternalInternalLicense() throws InterruptedException, IOException
				{
		    WebDriverWait wait = new WebDriverWait(getDriver(), 5);
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
			LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
			
			 Select drp = new Select(LiPerformerPOM.clickType());
		   	drp.selectByIndex(1);
					test = extent.startTest("Terminated License Count Verification");
					//test.log(LogStatus.PASS, "Terminate License Count Verification");
					
					LiPeMethodsPOM.TerminateLicense1( test, "Internal");
					
					extent.endTest(test);
					extent.flush();
				}
	 @Test(priority = 11)
	 void AssignedButNotActivated() throws InterruptedException, IOException
	 {
	 	test = extent.startTest("Not Activated License Count Verification");
	 	//test.log(LogStatus.INFO, "Test Initiated");
	 	
	 	WebDriverWait wait = new WebDriverWait(getDriver(), 5);
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
	@Test(priority =12)
			void LicenseExpiredInInternal() throws InterruptedException
			{
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
				wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
				LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
				
				 Select drp = new Select(LiPerformerPOM.clickType());
			   	drp.selectByIndex(1);
				test = extent.startTest(" ExpiredIn License  Working Verification");
			    // test.log(LogStatus.PASS, "License ExpiredOn Working Verification");
				
			  LiPeMethodsPOM.LicenseExpiredOnperInternal( test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
	
	 @Test(priority = 13)
				void LicenseExpiringOnInternal() throws InterruptedException, IOException
				{
					test = extent.startTest("ExpiringIn License Working Verification");
					//test.log(LogStatus.INFO, "Test Initiated");
					
					LiPeMethodsPOM.LicenseExpiringOnInternalper( test, "Internal");
			
					
					extent.endTest(test);
					extent.flush();
				}
 @Test(priority = 14)
		void Myworkspace() throws InterruptedException, IOException
		{
	   	 // WebDriverWait wait = new WebDriverWait(driver, 5);
			//wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
			//LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
			
			// Select drp = new Select(LiPerformerPOM.clickType(driver));
		   //	drp.selectByIndex(1);
			test = extent.startTest("My Workspace Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
	        licmgmtMethodPOM.MyworkspaceaddLicense( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 15)
	void MyDocuments() throws InterruptedException
	{
		test = extent.startTest("My Documents working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.MyDocuments( test, "Internal");
		//LiPeMethodsPOM.Documents(driver, test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 16)
	void MyReports() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports working  verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		LiPeMethodsPOM.Reports( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 17)	
void NomineeDetails() throws InterruptedException, IOException

 {
	
	test = extent.startTest("Nominee Details");
	//test.log(LogStatus.PASS, "Noimnee Details Added Sucessfully");
	licmgmtMethodPOM.NomineeDetails(test,"Internal");

	extent.endTest(test);
	extent.flush();
 }

@Test(priority =18)
	void  InternalActiveDashboardFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Dashboard Active License Entity/Branch Location(A Pvt Ltd)&LicenseType(Annual Maintance) Filter working  Verification");
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
	@Test(priority =19)
	void  InternalExpiringDashboardFilter() throws InterruptedException, IOException
	{
	
		test = extent.startTest("Dashboard Expiring  License Entity/Branch Location(A Pvt Ltd)&LicenseType(Annual Maintance) Filter working  Verification");
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
	@Test(priority =20)
	void  InternalExpiredDashboardFilter() throws InterruptedException, IOException
	{
		
		test = extent.startTest("Dashboard Expired License Entity/Branch Location(A Pvt Ltd)&LicenseType(Annual Maintance) Filter working  Verification");
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
	@Test(priority =21)
	void  InternlAppliedDashboardFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Dashboard Applied License Entity/Branch Location(A Pvt Ltd)&LicenseType(Annual Maintance) Filter working  Verification");
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
	@Test(priority = 22)
		void InternalPendingForReviewDashboardFilter() throws InterruptedException, IOException
		{
		    test = extent.startTest("Dashboard Pending For review  Entity/Branch Location(A Pvt Ltd)&LicenseType(Annual Maintance) Filter working  Verification");
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
		@Test(priority = 23)
		void InternalRejeectedDashboardFilter() throws InterruptedException, IOException
		{
		    test = extent.startTest("Dashboard Rejected License Entity/Branch Location(A Pvt Ltd)&LicenseType(Annual Maintance) Filter working  Verification");
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
		@Test(priority = 24)
		void InternalTerminateDashboardFilter() throws InterruptedException, IOException
		{
		    test = extent.startTest("Dashboard Terminated License Entity/Branch Location(A Pvt Ltd)&LicenseType(Annual Maintance) Filter working  Verification");
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
		@Test(priority = 25)
		void InternalAssignedButNotActivatedDashboardFilter() throws InterruptedException, IOException
		{
		    test = extent.startTest("Dashboard Not Activated License Entity/Branch Location(A Pvt Ltd)&LicenseType(Annual Maintance) Filter working  Verification");
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
		@Test(priority = 26)
		void DashboardandReportCountMatch() throws InterruptedException, IOException
		{
			test = extent.startTest("Dashboard and Report  Count Match  Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LiPeMethodsPOM.InternalDashallreportallcount( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}

	 @AfterMethod
	  void driverclose()
	  {
		 closeBrowser();
		 // driver.close();
	  }
}

package LicenseCriticalTestCase;

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

public class CompanyadminInternalCriticalTC extends webpage{
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
	
	@BeforeTest
	
	void setBrowser() throws InterruptedException, IOException
	{
		String workingDir = System.getProperty("user.dir");
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//CriticalReport//LicCompanyadminResult(Internal).html",true);
		test = extent.startTest("Logging In - Companyadmin (Internal)");
		//test.log(LogStatus.INFO, "Browser test is initiated");
		
		/*XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		*/
		test.log(LogStatus.PASS, "URL-https://applicationtesting.teamleaseregtech.com/Login.aspx?ReturnUrl=%2fLogoutSuccessfully.aspx");
		test.log(LogStatus.PASS, "UserID-companyadmin@regtrack.com");
		test.log(LogStatus.PASS, "Password-admin@123");
		test.log(LogStatus.PASS, "Company admin Login Successfully.");
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		/*//test = extent.startTest("Logging In - Companyadmin (Statutory)");
		//test.log(LogStatus.PASS, "Test Passed.");
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
		initialization("License",0);
	}
	@Test(priority = 2)
		void AllFilter() throws InterruptedException
		{
			test = extent.startTest("All Filter Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.Allfilter( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
 @Test(priority = 3)
	void ActiveInternalLicense() throws InterruptedException, IOException
	{
		test = extent.startTest("Active License Count  Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.ActiveInternalLicense( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 4)
		void ExpiringInternalLicense() throws InterruptedException, IOException
		{
			test = extent.startTest("Expiring License Count Verification");
			//test.log(LogStatus.PASS, "Expiring License Count Verification");
			
			StatutoryMethod.ExpiringInternalLicense( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
 @Test(priority = 5)
	void ExpiredInternalLicense() throws InterruptedException, IOException
	{
		test = extent.startTest("Expired License Count Verification");
		//test.log(LogStatus.PASS, "Expired License Count Verification");
		
		StatutoryMethod.ExpiredInternalLicense( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
 @Test(priority = 6)
	void AppliedInternalLicense() throws InterruptedException, IOException
	{
		test = extent.startTest("Applied License Count  Verification");
		//test.log(LogStatus.PASS, "Applied Internal License Verification");
		
		StatutoryMethod.AppliedInternalLicense( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}

 @Test(priority = 7)
		void PendingForReviewInternalLicense() throws InterruptedException, IOException
		{
			test = extent.startTest("Pending For Review License Count Verification");
			//test.log(LogStatus.PASS, "Pending For Review Count Verification");
			
			StatutoryMethod.pendingforreviewInternalLicense( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 8)
	void RejectedInternalLicense() throws InterruptedException, IOException
	{
		test = extent.startTest("Rejected License Count  Verification");
		//test.log(LogStatus.PASS, "Rejected License Count  Verification");
		
		StatutoryMethod.RejectedInternalLicense( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 9)
	void TerminateInternalLicense() throws InterruptedException, IOException
	{
		test = extent.startTest("Terminate License Count Verification");
		//test.log(LogStatus.PASS, "Terminate License Count Verification");
		
		StatutoryMethod.TerminateInternalLicense( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 10)
void NotActivated() throws InterruptedException, IOException
{
	test = extent.startTest("Not Activated  Count Verification");
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

@Test(priority =11)
void LicenseExpiredInInternal() throws InterruptedException
{
	test = extent.startTest("License ExpiredIn Working Verification");
    //  test.log(LogStatus.PASS, "License ExpiredOn Working Verification");
	
	StatutoryMethod.LicenseExpiredOnInternal( test, "Internal");
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 12)
void LicenseExpiringOnInternal() throws InterruptedException, IOException
{
WebDriverWait wait = new WebDriverWait( getDriver(), (30));
wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.

Select drp = new Select(LiPerformerPOM.clickType());
drp.selectByIndex(1);
CFOcountPOM.clickApply1().click();				//Clicking on Apply.

test = extent.startTest("License ExpiringIn Working Verification");
//test.log(LogStatus.INFO, "Test Initiated");

licmgmtMethodPOM.LicenseExpiringInStatutory( test, "Internal");

extent.endTest(test);
extent.flush();
}
	 @Test(priority = 13)
	  void BystatusActiveInternalgraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal By Status-Active Graph Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusActiveInternalgraph( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
 @Test(priority = 12)
	  void BystatusExpringInternalgraph() throws InterruptedException, IOException
		{
			test = extent.startTest(" Internal By Status -Expiring Graph Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusExpringInternalgraph( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
  	}
	@Test(priority = 13)
	  void BystatusExpiredInternal() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal By Status -Expired Graph Count Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusExpiredInternal( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 14)
	  void Bystatusappliedgraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal By status-applied Graph Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusappliedInternalgraph( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 15)
	void BystatusPendingForReviewgraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal By status-Pending For Review Graph Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusPendingForReviewInternalgraph( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 16)
	  void BystatusRejectedInternalgraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal By Status-Rejected Graph Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusRejectedInternalgraph( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	
	@Test(priority = 17)
	  void BystatusTerminateInternalgraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal By Status -Terminated Graph Count Verification");
			//test.log(LogStatus.PASS, "License Terminate On Working Verification");
			
			StatutoryMethod.BystatusTerminateInternalgraph( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
 
@Test(priority = 18)
		void BylicnesetypeActiveInternal() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal By License type - Annual maintenance Active Graph Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypeActiveInternal( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
 @Test(priority = 19)
	void ByLicensetypeExpiringInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal By License Type -Annual maintenance Expiring Graph Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.ByLicensetypeExpiringInternal( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 20)
		void  ByLicensetypeExpiredInternal() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal By License Type - Annual maintenance Expired Graph Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypeExpiredInternal( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}

	 @Test(priority = 21)
		void ByLicensetypeAppliedInternal() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal By License type -Annual maintenance applied Graph Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypeAppliedInternal( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
		
	 @Test(priority = 22)
		void ByLicensetypePendingForReviewInternal() throws InterruptedException, IOException
		{
			test = extent.startTest("Internal By License type -Annual maintenance Pending For Review Graph Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypePendingForReviewInternal( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
		
	  @Test(priority = 23)
		void BylicnesetypeRejectedInternal() throws InterruptedException
		{
			test = extent.startTest("Internal By License type - Annual maintenance Rejected Graph  Count Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypeRejectedInternal( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 24)
		void BylicnesetypeTerminateInternal() throws InterruptedException
		{
			test = extent.startTest("Internal By License type - Annual maintenance Terminated Graph  Count Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypeTerminateInternal( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	
@Test(priority = 23)
	void MyWorkspace() throws InterruptedException, IOException
	{
   	 // WebDriverWait wait = new WebDriverWait( 5);
		//wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
		//LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
		
		// Select drp = new Select(LiPerformerPOM.clickType(driver));
	   //	drp.selectByIndex(1);
		test = extent.startTest("My Workspace Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		 PerformerInternalCritical.Myworkspaceaddadmin( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
    @Test(priority = 24)
		void MyDocuments() throws InterruptedException
		{
			test = extent.startTest("My Documents Download Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			//test = extent.startTest("My Document View Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCriticalTestCase.PerformerCritical.Documents( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 25)
	 void MyReports() throws InterruptedException, IOException
	 {
		test = extent.startTest("My Reports Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
   //  licmgmtMethodPOM.mgmtReports( test, "Internal");
     
		LicenseCriticalTestCase.PerformerCritical.Reports( test, "Internal");
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 26)
	void InternalLicenseCreation() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal License Creation Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		StatutoryMethod.InternalLicenseCreation( test, "Internal");
		extent.endTest(test);
		extent.flush();
	}
	
@AfterMethod
	  void driverclose()
	  {
		  closeBrowser();
	  }
	  
}


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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import licenseManagement.licmgmtMethodPOM;
import licensePerformer.LiPeMethodsPOM;
import login.webpage;


public class StatutoryCriticalTC extends webpage  {
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;		
	public static WebDriver driver = null;		//WebDriver instance created
	public static WebElement upload = null;	
	
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
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//CriticalReport//LicPerformerResult(Statutory.html",true);
		test = extent.startTest("Logging In - Performer (Statutory)");
		//test.log(LogStatus.INFO, "Browser test is initiated");
		
		/*XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		*/
		test.log(LogStatus.PASS, "Performer Login Successfully");
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		/*test = extent.startTest("Logging In - Performer (Statutory)");
	  //	test.log(LogStatus.PASS, "Logging into system");
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
	void Active() throws InterruptedException
	{
		test = extent.startTest("Active License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		PerformerCritical.ActiveLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 3)
void ActivePerform() throws InterruptedException
{
	test = extent.startTest("Active License Count Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
	
	LiPeMethodsPOM.activelicenseperform( test, "Statutory");
	
	extent.endTest(test);
	extent.flush();
	
}
@Test(priority = 4)
      void Expiring() throws InterruptedException, IOException
    {
	test = extent.startTest("Expiring License Count Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
	
	licensePerformer.LiPeMethodsPOM.ExpiringCount( test, "Statutory");
	
	extent.endTest(test);
	extent.flush();
     }
@Test(priority = 5)
void Expiringperform() throws InterruptedException
{
	test = extent.startTest("Expiring License Count Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
	
	LiPeMethodsPOM.Expiringlicenseperform( test, "Statutory");
	
	extent.endTest(test);
	extent.flush();
	
}
@Test(priority = 6)
	void Expired() throws InterruptedException, IOException
	{
		test = extent.startTest("Expired License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		licensePerformer.LiPeMethodsPOM.ExpiredCount( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 7)
         void Expiredgperform() throws InterruptedException
     {
    	test = extent.startTest("Expired License Count Verification");
	    //test.log(LogStatus.INFO, "Test Initiated");
	
	   licensePerformer.LiPeMethodsPOM.Expiredlicenseperform( test, "Statutory");
	
	    extent.endTest(test);
	    extent.flush();
	
}
@Test(priority = 8)
		void Applied() throws InterruptedException, IOException
		{
			test = extent.startTest("Applied Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			licensePerformer.LiPeMethodsPOM.AppliedCount( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 9)
		void PendingForReview() throws InterruptedException, IOException
		{
			test = extent.startTest("Pending For Review License Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCompanyadmin.StatutoryMethod.pendingforreviewLicense( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 10)
		void RejectedCount() throws InterruptedException, IOException
		{
			test = extent.startTest("Rejected License Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			licensePerformer.LiPeMethodsPOM.RejectedCount( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 11) 
		void TerminateCount() throws InterruptedException
		{
			test = extent.startTest("Terminate License Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCriticalTestCase.PerformerCritical.TerminateLicense1( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 12)
		void AssignedButNotActivated() throws InterruptedException, IOException

		{
			test = extent.startTest("Assigned But Not Activated License Verification");
			LiPeMethodsPOM.AssignedButNotActivated(test,"Statutory");

			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 13)
		void LicenseExpiredInStatutory() throws InterruptedException
		{
			test = extent.startTest("License ExpiredIn Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LiPeMethodsPOM.LicenseExpiredOnStatutory( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 14)
	void LicenseExpiringInStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("License ExpiringIn Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		LiPeMethodsPOM.LicenseExpiringOnStatutoryper( test, "Statutory");

		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 15)
		void MyWorkspace() throws InterruptedException, IOException
		{
			test = extent.startTest("My Workspace Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
             LicenseCriticalTestCase.PerformerCritical.MyworkspaceaddLicense( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 16)
	void MyDocuments() throws InterruptedException
	{
		test = extent.startTest("My Documents Verification");
		LicenseCriticalTestCase.PerformerCritical.Documents( test, "Statutory");	
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 17)
void MyReports() throws InterruptedException, IOException
{
	test = extent.startTest("My Reports Download Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
	
	LicenseCriticalTestCase.PerformerCritical.Reports( test, "Statutory");
	
	extent.endTest(test);
	extent.flush();
}

@AfterMethod
void driverclose()
{
	 closeBrowser(); 
	  //driver.close();
}
}

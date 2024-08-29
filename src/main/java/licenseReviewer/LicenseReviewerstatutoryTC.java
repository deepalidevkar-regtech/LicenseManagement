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

import cfo.CFOcountPOM;
import licenseCompanyadmin.StatutoryMethod;
import licenseManagement.licmgmtMethodPOM;
import licensePerformer.LiPeMethodsPOM;
import licensePerformer.LiPerformerPOM;
import login.webpage;

public class LicenseReviewerstatutoryTC extends webpage
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
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LicenseReviewerResults(statutory).html");
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
		/*/test = extent.startTest("Logging In - Performer (Statutory)");
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
		initialization("License",4);
	}

@Test(priority =2)
	void Active() throws InterruptedException, IOException
	{
		test = extent.startTest("Active License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		LiReMethodsPOM.ReviewerActiveLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 3)
	void Expiring() throws InterruptedException, IOException
	{
		test = extent.startTest("Expiring License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		LiReMethodsPOM.ReviewerExpiringCount( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 4)
	void Expired() throws InterruptedException, IOException
	{
		test = extent.startTest("Expired License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		LiReMethodsPOM.ReviewerExpiredCount( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
     @Test(priority = 5)
	void Applied() throws InterruptedException, IOException
	{
		test = extent.startTest("Applied License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		LiReMethodsPOM.ReviewerAppliedCount( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 6)
	void PendingForReview() throws InterruptedException
	{
	    test = extent.startTest("Pending For Review License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		LiReMethodsPOM.PendingReviewCount( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 7)
	void Rejected() throws InterruptedException
	{
		test = extent.startTest("Rejected License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		LiReMethodsPOM.ReviewerRejectedCount( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 8)
		void Terminate() throws InterruptedException
		{
			test = extent.startTest("Terminate License Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
            LiReMethodsPOM.ReviewerTerminateLicense1( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
		
	 @Test(priority = 9)
		void LicenseExpiredOnStatutory() throws InterruptedException
		{
			test = extent.startTest("License ExpiredOn Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LiPeMethodsPOM.LicenseExpiredOnStatutory( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
   @Test(priority = 10)
			void LicenseExpiringOnStatutory() throws InterruptedException, IOException
			{
				test = extent.startTest("License ExpiringOn Working Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				LiReMethodsPOM.LicenseExpiringOnStatutory( test, "Statutory");
		
				
				extent.endTest(test);
				extent.flush();
			}
			
	@Test(priority = 11)
	void Myworkspace() throws InterruptedException, IOException
	{
		test = extent.startTest("My Workspace Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
      licmgmtMethodPOM.MyworkspaceaddLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
		

  @Test(priority = 12)
	void MyDocuments() throws InterruptedException
	{
		test = extent.startTest("My Documents Verification");
		StatutoryMethod.MyDocuments( test, "Statutory");	
		//licensePerformer.LiPeMethodsPOM.Documents( test, "Statutory");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 13)
		void CriticalDocuments() throws InterruptedException, IOException
			{
				test = extent.startTest("Critical Document Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				licenseCompanyadmin.StatutoryMethod.CriticalDocuments(test, "Statutory");
				
				extent.endTest(test);
				extent.flush();
			}
 @Test(priority =14)
	void MyReports() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports Download Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		licensePerformer.LiPeMethodsPOM.Reports( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
 
	@Test(priority = 15)
	void AssignedButNotActivated() throws InterruptedException, IOException
	
	{
		test = extent.startTest("Assigned But Not Activated License Verification");
		licensePerformer.LiPeMethodsPOM.AssignedButNotActivated(test,"");

		extent.endTest(test);
		extent.flush();
	}
  @AfterMethod
  void driverclose()
  {
	  closeBrowser();
  }
}


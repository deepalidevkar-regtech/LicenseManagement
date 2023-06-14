package licenseCompanyadmin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import licensePerformer.LiPeMethodsPOM;
import performer.OverduePOM;

public class StatutoryTC {
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
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LicenseCompanyadmin.html",true);
		test = extent.startTest("Verify OpenBrowser");
		//test.log(LogStatus.INFO, "Browser test is initiated");
		
		XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 1)
	void Login() throws InterruptedException, IOException
	{
		test = extent.startTest("Logging In - Companyadmin(Statutory)");
		test.log(LogStatus.PASS, "Logging into system");
		
		XSSFSheet sheet = ReadExcel();
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c1 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c1.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c2 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c2.getStringCellValue();		//Got the URL stored at position 2,1
		
		driver = login.Login.UserLogin(uname,password,"License");		//Method of Login class to login user.
		
		//test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
  /*  @Test(priority = 2)
	void Masters() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - User Creation verification");
		test.log(LogStatus.INFO, "User Created Successfully");
		MethodPOM.clickUserMaster(driver);	
		test.log(LogStatus.INFO, "User Details Updated  Successfully");
		
    

		 
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)
	void PageAuthor() throws InterruptedException, IOException
	{
		test = extent.startTest("Masters - User Creation verification");
		test.log(LogStatus.INFO, "Page Authorization Saved");
		StatutoryMethod.PageAuthorization(driver);		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 4)
	void RenewStautoryLicense() throws InterruptedException, IOException
	{
	{
		test = extent.startTest("Statutory Renew License");
		test.log(LogStatus.INFO, "Compliance Created and Assigned Sucessfully");
		StatutoryMethod.RenewStatutoryLicense(driver);

		extent.endTest(test);
		extent.flush();
	}
	}
	@Test(priority = 5)
	void RenewInternalLicense() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal Renew License");
		test.log(LogStatus.INFO, "Compliance Created and Assigned Successfully");
	    StatutoryMethod.RenewInternalLicense(driver);
	    extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 6)
	void Active() throws InterruptedException
	{
		test = extent.startTest("Active License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.ActiveLicense(driver, test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
		
	}
/*	@Test(priority = 7)
	void Expiring() throws InterruptedException
	{
		test = extent.startTest("Expiring License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.ExpiringLicense(driver, test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 8)
	void Expired() throws InterruptedException
	{
		test = extent.startTest("Expired License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.ExpiredLicense(driver, test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 9)
	void Applied() throws InterruptedException
	{
		test = extent.startTest("Applied License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.AppliedLicense(driver, test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 10)
	void PendingForReview() throws InterruptedException
	{
	    test = extent.startTest("Pending For Review License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.pendingforreviewLicense(driver, test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 11)
	void Rejected() throws InterruptedException
	{
		test = extent.startTest("Rejected License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.RejectedLicense(driver, test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
   @Test(priority = 12)
	void Terminate() throws InterruptedException
	{
		test = extent.startTest("Terminate License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.TerminateLicense(driver, test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
   @Test(priority = 13)
		void LicenseExpiredOnStatutory() throws InterruptedException
		{
			test = extent.startTest("License ExpiredOn Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.LicenseExpiredOnStatutory(driver, test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	/*@Test(priority = 14)
	void LicenseExpiringOnStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("License ExpiringOn Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.LicenseExpiringOnStatutory(driver, test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
/* @Test(priority = 15)
	void AllFilter() throws InterruptedException
	{
		//test = extent.startTest("All Filter Working Verification");
		test.log(LogStatus.INFO, "All Filter Working Verification");
		
		StatutoryMethod.Allfilter(driver, test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 16)
		void BystausExpiringlicense() throws InterruptedException
		{
			test = extent.startTest("By status Expiring Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusExpringgraph(driver, test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 17)
		void BystausTerminatelicense() throws InterruptedException
		{
			test = extent.startTest("By status Terminate Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusTerminategraph(driver, test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 18)
		void BystausActivelicense() throws InterruptedException
		{
			test = extent.startTest("By status Active Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusActivegraph(driver, test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 19)
		void BystausAppliedButnotRenewedlicense() throws InterruptedException
		{
			test = extent.startTest("By status Applied Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusExpiredappliedbutnotrenewedgraph(driver, test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}

      @Test(priority = 20)
 		void BystausExpiredlicense() throws InterruptedException
		{
			test = extent.startTest("By status Expired Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusExpired(driver, test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 21)
		void BylicnesetypeExpired() throws InterruptedException
		{
			test = extent.startTest("By License Type Expired Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypeExpired(driver, test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 22)
			void BylicnesetypeExpiring() throws InterruptedException
			{
				test = extent.startTest("By License Type Expiring Graph Working Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				StatutoryMethod.ByLicensetypeExpiring(driver, test, "Statutory");
				
				extent.endTest(test);
				extent.flush();
			}
	@Test(priority = 23)
		void BylicnesetypeApplied() throws InterruptedException
		{
			test = extent.startTest("By License Type Applied Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypeApplied(driver, test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 24)
			void BylicnesetypeActive() throws InterruptedException
			{
				test = extent.startTest("By License Type Active Graph Working Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				StatutoryMethod.ByLicensetypeActive(driver, test, "Statutory");
				
				extent.endTest(test);
				extent.flush();
			}
	  @Test(priority = 25)
		void BylicnesetypeTerminate() throws InterruptedException
		{
			test = extent.startTest("By License Type Terminate Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypeTerminate(driver, test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
 /*    @Test(priority = 26)
		void MyWorkspace() throws InterruptedException, IOException
	{
		test = extent.startTest("My Workspace  Verification");
		
         StatutoryMethod.MyWorkspace(driver, test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}*/
	 @Test(priority = 27)
	void MyDocuments() throws InterruptedException
	{
		test = extent.startTest("My Documents Download Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
		test = extent.startTest("My Document View Verification");
		test.log(LogStatus.INFO, "Test Initiated");
		
         StatutoryMethod.MyDocuments(driver, test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	
	}
	 //@Test(priority = 28)
		void MyReports() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reports Download Verification");
			test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.MyReports(driver, test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	 //@Test(priority = 29)
	void CriticalDocuments() throws InterruptedException, IOException
		{
			test = extent.startTest("Critical Document Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.CriticalDocuments(driver, test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	/* @Test(priority = 30)
		void LicenseNewAssignment() throws InterruptedException, IOException
		{
			test = extent.startTest("License New Assignment");
			test.log(LogStatus.INFO, "Test Initiated");
			StatutoryMethod.LicenseActivation_NewAssignment(driver, test, "Statutory");
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority =31)
		void LicenseCreation() throws InterruptedException, IOException
		{
			test = extent.startTest("License Creation Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			StatutoryMethod.LicenseCreation(driver, test, "Statutory");
			extent.endTest(test);
			extent.flush();
		}*/
	}


	
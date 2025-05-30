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

import LicenseCompanyadmin.StatutoryMethod;
import licenseManagement.licmgmtMethodPOM;
import licensePerformer.LiPeMethodsPOM;
import login.webpage;

public class mgmtstatutoryCriticalTC extends webpage {
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
		sheet = workbook.getSheetAt(2);					//Retrieving second sheet of Workbook
		return sheet;
	}
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		String workingDir = System.getProperty("user.dir");
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//CriticalReport//LicManagementResult(Statutory).html",true);
	      test = extent.startTest("Logging In - Management (Statutory");
		test.log(LogStatus.PASS, "Test Passed.");
		//test.log(LogStatus.INFO, "Browser test is initiated");
		
		/*XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		*/
		test.log(LogStatus.PASS, "URL-https://login.teamleaseregtech.com/Login.aspx?ReturnUrl=%2fLogin.aspx");
		test.log(LogStatus.PASS, "UserID-bhagyesh@tlregtech.com	");
		test.log(LogStatus.PASS, "Password-Avantis@123");
		test.log(LogStatus.PASS, "Management Login Successfully.");
		extent.endTest(test);
		extent.flush();
		
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		/*test = extent.startTest("Logging In - Management (Statutory)");
	  // test.log(LogStatus.PASS, "Logging into system");
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
		initialization("License",2);

	}


@Test(priority = 2)
 
	void Active() throws InterruptedException, IOException
	{
		test = extent.startTest("Active License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		LicenseCompanyadmin.StatutoryMethod.ActiveLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 3)
	void Expiring() throws InterruptedException, IOException
	{
		test = extent.startTest("Expiring License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		//StatutoryMethod.ExpiringLicense( test, "Statutory");
		LicenseCompanyadmin.StatutoryMethod.ExpiringLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 4)
	void Expired() throws InterruptedException, IOException
	{
		test = extent.startTest("Expired License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		LicenseCompanyadmin.StatutoryMethod.ExpiredLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 5)
	void Applied() throws InterruptedException, IOException
	{
		test = extent.startTest("Applied License Count Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		LicenseCompanyadmin.StatutoryMethod.AppliedLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 6)
	void PendingForReview() throws InterruptedException, IOException
	{
		test = extent.startTest("Pending For Review License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		LicenseCompanyadmin.StatutoryMethod.pendingforreviewLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 7)
	void Rejected() throws InterruptedException, IOException
	{
		test = extent.startTest("Rejected License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		LicenseCompanyadmin.StatutoryMethod.RejectedLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
   @Test(priority = 8)
	void Terminated() throws InterruptedException, IOException
	{
		test = extent.startTest("Terminated License Count Verification");
		LicenseCompanyadmin.StatutoryMethod.TerminateLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
   @Test(priority = 9)
  	void NotActivated() throws InterruptedException, IOException
  	
  	{
  		test = extent.startTest("Not Activated License Verification");
  		LiPeMethodsPOM.AssignedButNotActivated(test,"Statutory");

  		extent.endTest(test);
  		extent.flush();
  	}

   @Test(priority =10)
  	void LicenseExpiredInStatutory() throws InterruptedException
  	{
  		test = extent.startTest("License ExpiredIn Working Verification");
  	
  		//licmgmtMethodPOM.LicenseExpiredOnStatutory( test, "Statutory");
  		StatutoryMethod.LicenseExpiredOnStatutory( test, "Statutory");
  		
  		extent.endTest(test);
  		extent.flush();
  	}
  @Test(priority = 11)

  	void LicenseExpiringInStatutory() throws InterruptedException, IOException
  	{
  		test = extent.startTest("License ExpiringIn Working Verification");
  		//test.log(LogStatus.INFO, "Test Initiated");
  		
  		LicenseCompanyadmin.StatutoryMethod.LicenseExpiringOnStatutory( test, "Statutory");
  		
  		extent.endTest(test);
  		extent.flush();
  	}
 

	 @Test(priority = 12)
		void BystausActivelicense() throws InterruptedException, IOException
		{
			test = extent.startTest("By Status- Active License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCompanyadmin.StatutoryMethod.BystatusActivegraph( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 13)
		void BystausExpiringlicense() throws InterruptedException, IOException
		{
			test = extent.startTest("By Status-Expiring License Graph Working Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCompanyadmin.StatutoryMethod.BystatusExpringgraph( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 14)
		void BystausExpiredlicense() throws InterruptedException, IOException
		{
			test = extent.startTest("By Status- Expired License On Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCompanyadmin.StatutoryMethod.BystatusExpired( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
		 @Test(priority = 15)
		void BystausApplied() throws InterruptedException, IOException
		{
			test = extent.startTest("By Status- Applied Graph Working Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCompanyadmin.StatutoryMethod.Bystatusappliedgraph( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 16)
   void BystausPendingForReview() throws InterruptedException, IOException
         {
         test = extent.startTest("By status-Pending For Review Graph count Working Verification");
          //test.log(LogStatus.INFO, "Test Initiated");

         StatutoryMethod.Bystatuspendingforreviewgraph( test, "Statutory");

            extent.endTest(test);
     extent.flush();
}
 @Test(priority = 17)
 		void BystausRejectedLicense() throws InterruptedException, IOException
		{
			test = extent.startTest("By status- Rejected Graph Count Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusRejectedgraph( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 18)
		void BystausTerminatelicense() throws InterruptedException, IOException
		{
			test = extent.startTest("By Status Terminated License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCompanyadmin.StatutoryMethod.BystatusTerminategraph( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	
@Test(priority = 19)
	void BylicnesetypeActive() throws InterruptedException, IOException
	{
		test = extent.startTest("By License Type- Shops & Commercial Establishment Active Graph count vWorking Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
        licmgmtMethodPOM.ByLicensetypeActive( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 20)
		void BylicnesetypeExpiring() throws InterruptedException, IOException
		{
			test = extent.startTest("By License Type-Shops & Commercial Establishment Expiring Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCompanyadmin.StatutoryMethod.ByLicensetypeExpiring( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 21)
		void BylicnesetypeExpired() throws InterruptedException, IOException
		{
			test = extent.startTest("By License Type- Shops & Commercial Establishment Expired Graph Count Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			licmgmtMethodPOM.ByLicensetypeExpired( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	
	@Test(priority = 22)
		void BylicnesetypeApplied() throws InterruptedException, IOException
		{
			test = extent.startTest("By License Type -Shops & Commercial Establishment Applied Graph count Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
		    licmgmtMethodPOM.ByLicensetypeApplied( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 23)
void BylicnesetypePendingForReview() throws InterruptedException, IOException
{
	test = extent.startTest("By License Type -Shops & Commercial Establishment Pending For Review Graph count Working Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
	
	StatutoryMethod.ByLicensetypePendingForReview( test, "Statutory");
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 24)
void BylicnesetypeRejected() throws InterruptedException, IOException
{
	test = extent.startTest("By License Type -Shops & Commercial Establishment Rejected  Graph Count Working Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
	
	StatutoryMethod.ByLicensetypeRejected( test, "Statutory");
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 25)
		void BylicnesetypeTerminate() throws InterruptedException, IOException
		{
			test = extent.startTest("By License Type -Shops & Commercial Establishment Terminated Graph Count Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
             licmgmtMethodPOM.ByLicensetypeTerminate( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
    @Test(priority = 26)
			void MyWorkspace() throws InterruptedException, IOException
			{
				test = extent.startTest("My Workspace  Working Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
                PerformerCritical.MyworkspaceaddLicense( test, "Statutory");
				
				extent.endTest(test);
				extent.flush();
			}
       
    @Test(priority = 27)
	void MyDocuments() throws InterruptedException
	{
		test = extent.startTest("My Documents Working  Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
	//	test = extent.startTest("My Document View Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		LicenseCriticalTestCase.PerformerCritical.Documents( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 28)
		void MyReports() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reports working  Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCriticalTestCase.PerformerCritical.Reports( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}

  @Test(priority = 29)
	void Masters() throws InterruptedException, IOException
	{
	    test = extent.startTest("Masters - User Creation verification");
		//test.log(LogStatus.PASS, "User Created Successfully");
		LicenseCompanyadmin.StatutoryMethod.user( test,"");
	 
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





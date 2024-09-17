package licenseManagement;

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

import licenseCompanyadmin.StatutoryMethod;
import licensePerformer.LiPeMethodsPOM;
import login.webpage;

public class licmgmtStatutoryTC  extends webpage{
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
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LicensemgmtResults(Statutory).html",true);
	      test = extent.startTest("Logging In - Management (Statutory");
		test.log(LogStatus.PASS, "Management Login Successfully");
		//test.log(LogStatus.INFO, "Browser test is initiated");
		
		/*XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		
		
		extent.endTest(test);
		extent.flush();*/
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
		
		//test.log(LogStatus.PASS, "Test Passed.");
		//extent.endTest(test);
		//extent.flush();*/
		initialization("License",2);
	}
@Test(priority = 2)
 
	void Active() throws InterruptedException, IOException
	{
		test = extent.startTest("Active License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		licenseCompanyadmin.StatutoryMethod.ActiveLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 3)
	void Expiring() throws InterruptedException, IOException
	{
		test = extent.startTest("Expiring License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		//StatutoryMethod.ExpiringLicense( test, "Statutory");
		licenseCompanyadmin.StatutoryMethod.ExpiringLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 4)
	void Expired() throws InterruptedException, IOException
	{
		test = extent.startTest("Expired License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		licenseCompanyadmin.StatutoryMethod.ExpiredLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 5)
	void Applied() throws InterruptedException, IOException
	{
		test = extent.startTest("Applied License Count Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		licenseCompanyadmin.StatutoryMethod.AppliedLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 6)
	void PendingForReview() throws InterruptedException, IOException
	{
		test = extent.startTest("Pending For Review License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		licenseCompanyadmin.StatutoryMethod.pendingforreviewLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 7)
	void Rejected() throws InterruptedException, IOException
	{
		test = extent.startTest("Rejected License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		licenseCompanyadmin.StatutoryMethod.RejectedLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
   @Test(priority = 8)
	void Terminate() throws InterruptedException, IOException
	{
		test = extent.startTest("Terminate License Count Verification");
		licenseCompanyadmin.StatutoryMethod.TerminateLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
  @Test(priority = 9)
	void LicenseExpiredOnStatutory() throws InterruptedException
	{
		test = extent.startTest("License Expired On Working Verification");
	
		//licmgmtMethodPOM.LicenseExpiredOnStatutory( test, "Statutory");
		StatutoryMethod.LicenseExpiredOnStatutory( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 10)

	void LicenseExpiringOnStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("License Expiring On Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		licenseCompanyadmin.StatutoryMethod.LicenseExpiringOnStatutory( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	 @Test(priority = 13)
		void BystausActivelicense() throws InterruptedException
		{
			test = extent.startTest("By Status- Active License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			licenseCompanyadmin.StatutoryMethod.BystatusActivegraph( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 11)
		void BystausExpiringlicense() throws InterruptedException
		{
			test = extent.startTest("By Status- Application Overdue (Expiring but not applied) License Graph Working Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			licenseCompanyadmin.StatutoryMethod.BystatusExpringgraph( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 15)
		void BystausExpiredlicense() throws InterruptedException
		{
			test = extent.startTest("By Status-License Expired  On Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			licenseCompanyadmin.StatutoryMethod.BystatusExpired( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
		
	@Test(priority = 12)
		void BystausTerminatelicense() throws InterruptedException
		{
			test = extent.startTest("By Status Terminate License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			licenseCompanyadmin.StatutoryMethod.BystatusTerminategraph( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	
 @Test(priority = 14)
		void BystausAppliedButnotRenewedlicense() throws InterruptedException
		{
			test = extent.startTest("By Status  Expired Applied But not Renewed  License Graph Working Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			licenseCompanyadmin.StatutoryMethod.BystatusExpiredappliedbutnotrenewedgraph( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 17)
		void BystausRejectedLicense() throws InterruptedException
		{
			test = extent.startTest("By status- Rejected Graph Count Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusRejectedgraph( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}

	@Test(priority = 16)
		void BylicnesetypeExpired() throws InterruptedException
		{
			test = extent.startTest("By License type-Shops & Establishment Expired License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			licmgmtMethodPOM.ByLicensetypeExpired( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 17)
		void BylicnesetypeExpiring() throws InterruptedException
		{
			test = extent.startTest("By License type -Shops & Establishment  Application Overdue (Expiring but not applied) License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			licenseCompanyadmin.StatutoryMethod.ByLicensetypeExpiring( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 18)
		void BylicnesetypeApplied() throws InterruptedException
		{
			test = extent.startTest("By License type- Shops & Establishment  Expired applied But not renewed License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
		    licmgmtMethodPOM.ByLicensetypeApplied( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
 @Test(priority = 19)
		void BylicnesetypeActive() throws InterruptedException
		{
			test = extent.startTest("By License type -Shops & Establishment  Active License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
            licmgmtMethodPOM.ByLicensetypeActive( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 20)
		void BylicnesetypeTerminate() throws InterruptedException
		{
			test = extent.startTest("By License type -Shops & Establishment Terminate  License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
             licmgmtMethodPOM.ByLicensetypeTerminate( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 22)
		void BylicnesetypeRejected() throws InterruptedException
		{
			test = extent.startTest("By License Type -Shops & Establishment Rejected  Graph Count Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypeRejected( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	
	
    @Test(priority = 21)
			void MyWorkspace() throws InterruptedException, IOException
			{
				test = extent.startTest("My Workspace  Working Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
	             licmgmtMethodPOM.MyworkspaceaddLicense( test, "Statutory");
				
				extent.endTest(test);
				extent.flush();
			}
       
 @Test(priority = 22)
	void MyDocuments() throws InterruptedException
	{
		test = extent.startTest("My Documents Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
	//	test = extent.startTest("My Document View Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.MyDocuments( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 23)
	void CriticalDocuments() throws InterruptedException, IOException
		{
			test = extent.startTest("Critical Document Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			licenseCompanyadmin.StatutoryMethod.CriticalDocuments( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 24)
		void MyReports() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reports Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			licensePerformer.LiPeMethodsPOM.Reports( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 25)
	void LicenseNewAssignment() throws InterruptedException, IOException
	{
		test = extent.startTest("License New Assignment");
		//test.log(LogStatus.INFO, "Test Initiated");
		licenseCompanyadmin.StatutoryMethod.LicenseActivation_NewAssignment( test, "Statutory");
		extent.endTest(test);
		extent.flush();
	}
  @Test(priority = 26)
	void LicenseCreation() throws InterruptedException, IOException
	{
		test = extent.startTest("License Creation Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		licenseCompanyadmin.StatutoryMethod.LicenseCreation( test, workbook);
		extent.endTest(test);
		extent.flush();
	}
 @Test(priority = 27)
	void Masters() throws InterruptedException, IOException
	{
	    test = extent.startTest("Masters - User Creation verification");
		//test.log(LogStatus.PASS, "User Created Successfully");
		licenseCompanyadmin.StatutoryMethod.user( test,"");
	 
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 28)
	void RenewStautoryLicense() throws InterruptedException, IOException
	
	{
		test = extent.startTest("Statutory Renew License");
		test.log(LogStatus.PASS, "Compliance Created and Assigned Successfully");
		StatutoryMethod.RenewStatutoryLicense();

		extent.endTest(test);
		extent.flush();
	}
 @Test(priority = 28)
	void NomineeDetails() throws InterruptedException, IOException
	
	{
		test = extent.startTest("Nominee Details");
		//test.log(LogStatus.PASS, "Noimnee Details Added Sucessfully");
		licmgmtMethodPOM.NomineeDetails(test,"");

		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 29)
	void AssignedButNotActivated() throws InterruptedException, IOException
	
	{
		test = extent.startTest("Assigned But Not Activated License Verification");
		LiPeMethodsPOM.AssignedButNotActivated(test,"");

		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =34)
	void  ActiveDashboardFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Dashboard Active License Entity/Branch Location(Demo Bharat Gujarat1)&LicenseType(Shops & Establishment) Filter working  Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		StatutoryMethod.DashboardActivefilter( test, "Statutory");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =35)
	void  ExpiringDashboardFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Dashboard Expiring License Entity/Branch Location(Demo Bharat Gujarat1)&LicenseType(Shops & Establishment) Filter working  Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		StatutoryMethod.DashboardExpiringfilter( test, "Statutory");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =36)
	void  ExpiredDashboardFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Dashboard Expired License Entity/Branch Location(Demo Bharat Gujarat1)&LicenseType(Shops & Establishment) Filter working  Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		StatutoryMethod.DashboardExpiredfilter( test, "Statutory");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =37)
	void  AppliedDashboardFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Dashboard Applied License Entity/Branch Location(Demo Bharat Gujarat1)&LicenseType(Shops & Establishment) Filter working  Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		StatutoryMethod.DashboardAppliedfilter( test, "Statutory");
		extent.endTest(test);
		extent.flush();
	}
		@Test(priority = 38)
		void PendingForReviewDashboardFilter() throws InterruptedException, IOException
		{
		    test = extent.startTest("Dashboard Pending For review  License Entity/Branch Location(Demo Bharat Gujarat1)&LicenseType(Shops & Establishment) Filter working  Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.Dashboardpendingforreviewfilter( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 39)
		void RejeectedDashboardFilter() throws InterruptedException, IOException
		{
		    test = extent.startTest("Dashboard Rejected License Entity/Branch Location(Demo Bharat Gujarat1)&LicenseType(Shops & Establishment) Filter working  Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.DashboardRejectedLicensefilter( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 40)
		void TerminateDashboardFilter() throws InterruptedException, IOException
		{
		    test = extent.startTest("Dashboard Terminate License Entity/Branch Location(Demo Bharat Gujarat1)&LicenseType(Shops & Establishment) Filter working  Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.DashboardTerminateLicensefilter( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 41)
		void AssignedButNotActivatedDashboardFilter() throws InterruptedException, IOException
		{
		    test = extent.startTest("Dashboard Assigned But Not Activated License Entity/Branch Location(Demo Bharat Gujarat1)&LicenseType(Shops & Establishment) Filter working  Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.DashboardAssignedButNotActivatedFilter( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
 @AfterMethod
 void driverclose()
 {
	 closeBrowser();
	//  driver.close();
 }
	}


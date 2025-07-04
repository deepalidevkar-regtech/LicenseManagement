package LicenseCompanyadmin;

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
import performer.OverduePOM;

public class StatutoryTC extends webpage{
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
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//LicenseCompanyadmin(Statutory).html",true);
		test = extent.startTest("Logging In - Companyadmin (Statutory");
		//test.log(LogStatus.INFO, "Browser test is initiated");
		
		/*XSSFSheet sheet = ReadExcel();
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
		
		login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
		*/
		//test.log(LogStatus.PASS, "Test Passed.");
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		/*//test = extent.startTest("Logging In - Companyadmin (Statutory)");
	     //test.log(LogStatus.PASS, "Logging In - Companyadmin (Statutory");
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

	void Active() throws InterruptedException, IOException
	{
		test = extent.startTest("Active License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.ActiveLicense(test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
		
	}
@Test(priority =3)
	void Expiring() throws InterruptedException, IOException
	{
		test = extent.startTest("Expiring License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.ExpiringLicense(test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 4)
	void Expired() throws InterruptedException, IOException
	{
		test = extent.startTest("Expired License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.ExpiredLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 5)
	void Applied() throws InterruptedException, IOException
	{
		test = extent.startTest("Applied License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.AppliedLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 6)
	void PendingForReview() throws InterruptedException, IOException
	{
	    test = extent.startTest("Pending For Review License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.pendingforreviewLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 7)
	void Rejected() throws InterruptedException, IOException
	{
		test = extent.startTest("Rejected License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.RejectedLicense( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
  @Test(priority = 8)
	void Terminate() throws InterruptedException, IOException
	{
		test = extent.startTest("Terminated License Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.TerminateLicense( test, "Statutory");
		
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
 @Test(priority = 10)
		void LicenseExpiredInStatutory() throws InterruptedException
		{
			test = extent.startTest("Expired In License Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.LicenseExpiredOnStatutory( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 11)
	void LicenseExpiringInStatutory() throws InterruptedException, IOException
	{
		test = extent.startTest("Expiring In License Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.LicenseExpiringOnStatutory( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
 @Test(priority = 12)
	void AllFilter() throws InterruptedException
	{
		test = extent.startTest("All Filter Working Verification");
		//test.log(LogStatus.INFO, "All Filter Working Verification");
		
		StatutoryMethod.Allfilter( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 13)
	void BystausActivelicense() throws InterruptedException, IOException
	{
		test = extent.startTest("By status-Active Graph Count Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.BystatusActivegraph( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 14) 
		void BystausExpiringlicense() throws InterruptedException, IOException
		{
			test = extent.startTest("By status -Expiring Graph Count Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusExpringgraph( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 15)
	void BystausExpiredlicense() throws InterruptedException, IOException
{
	test = extent.startTest("By status- Expired Graph Count Working Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
	
	StatutoryMethod.BystatusExpired( test, "Statutory");
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 16)
	void BystausApplied() throws InterruptedException, IOException
	{
		test = extent.startTest("By status-Applied Graph count Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.Bystatusappliedgraph( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 17)
void BystausPendingForReview() throws InterruptedException, IOException
{
	test = extent.startTest("By status-Pending For Review Graph count Working Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
	
	StatutoryMethod.Bystatuspendingforreviewgraph( test, "Statutory");
	
	extent.endTest(test);
	extent.flush();
}
	 @Test(priority = 18)
	 		void BystausRejectedLicense() throws InterruptedException, IOException
			{
				test = extent.startTest("By status- Rejected Graph Count Working Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				StatutoryMethod.BystatusRejectedgraph( test, "Statutory");
				
				extent.endTest(test);
				extent.flush();
			}

@Test(priority = 19)
		void BystausTerminatelicense() throws InterruptedException, IOException
		{
			test = extent.startTest("By status-Terminated Graph count Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusTerminategraph( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 20)
			void BylicnesetypeActive() throws InterruptedException, IOException
			{
				test = extent.startTest("By License Type- Shops & Commercial Establishment Active Graph count Working Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				StatutoryMethod.ByLicensetypeActive( test, "Statutory");
				
				extent.endTest(test);
			extent.flush();
			}
@Test(priority = 21)
void BylicnesetypeExpiring() throws InterruptedException, IOException
{
	test = extent.startTest("By License Type- Shops & Commercial Establishment Expiring Graph Working Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
	
	StatutoryMethod.ByLicensetypeExpiring( test, "Statutory");
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 22)
		void BylicnesetypeExpired() throws InterruptedException, IOException
		{
			test = extent.startTest("By License Type- Shops & Commercial Establishment Expired Graph Count Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypeExpired( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	
	@Test(priority = 23)
		void BylicnesetypeApplied() throws InterruptedException, IOException
		{
			test = extent.startTest("By License Type -Shops & Commercial Establishment Applied Graph count Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypeApplied( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 24)
	void BylicnesetypePendingForReview() throws InterruptedException, IOException
	{
		test = extent.startTest("By License Type -Shops & Commercial Establishment Pending For Review Graph count Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.ByLicensetypePendingForReview( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 25)
	void BylicnesetypeRejected() throws InterruptedException, IOException
	{
		test = extent.startTest("By License Type -Shops & Establishment Rejected  Graph Count Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.ByLicensetypeRejected( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 26)
		void BylicnesetypeTerminated() throws InterruptedException, IOException
		{
			test = extent.startTest("By License Type -Shops & Commercial Establishment Terminated Graph Count Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.ByLicensetypeTerminated( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}
	
@Test(priority =27)
	
			void MyWorkspace() throws InterruptedException, IOException
			{
				test = extent.startTest("My Workspace Working Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
	             licenseManagement.licmgmtMethodPOM.MyworkspaceaddLicense( test, "Statutory");
				
				extent.endTest(test);
				extent.flush();
			}
@Test(priority =28)
void MyWorkspaceAll() throws InterruptedException, IOException
{
	test = extent.startTest("My Workspace Working Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
     licensePerformer.LiPeMethodsPOM.MyWorskpaceall(test, "Statutory");
	
	extent.endTest(test);
	extent.flush();
} 
@Test(priority = 29)
	void MyDocuments() throws InterruptedException
	{
		test = extent.startTest("My Documents Working Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		//test = extent.startTest("My Document View Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
        StatutoryMethod.MyDocuments( test, "Statutory");
		
		
		extent.endTest(test);
		extent.flush();
	
	}
@Test(priority = 30)
void CriticalDocuments() throws InterruptedException, IOException
	{
		test = extent.startTest("Critical Document working  Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.CriticalDocuments( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 31)
		void MyReports() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reports Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			licensePerformer.LiPeMethodsPOM.Reports( test, "Statutory");
			
			extent.endTest(test);
			extent.flush();
		}

	@Test(priority = 32)
		void Masters() throws InterruptedException, IOException
		{
			test = extent.startTest("User Master Working  verification");	
		   StatutoryMethod.user( test, "Statutory");		
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority =33)
		void PageAuthor() throws InterruptedException, IOException
		{
			test = extent.startTest("Page Autherization working verification");
			StatutoryMethod.PageAuthorization(test, "Statutory");		
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 34)
		void RenewStautoryLicense() throws InterruptedException, IOException

		{
			test = extent.startTest("Statutory Renew License working verification");
			  test.log(LogStatus.PASS, "Compliance Created and Assigned Successfully");
			StatutoryMethod.RenewStatutoryLicense();

			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 35)
		void LicenseNewAssignment() throws InterruptedException, IOException
		{
			test = extent.startTest("License New Assignment working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			StatutoryMethod.LicenseActivation_NewAssignment( test, "Statutory");
			extent.endTest(test);
			extent.flush();
		}
@Test(priority =36)
		void LicenseCreation() throws InterruptedException, IOException
		{
			test = extent.startTest("License Creation Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			StatutoryMethod.LicenseCreation( test);
			extent.endTest(test);
			extent.flush();
		}
@Test(priority =37)
		void  IsPermanent() throws InterruptedException, IOException
		{
			test = extent.startTest(" IsPermanent License working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			StatutoryMethod.IsPermanent( test, "Statutory");
			extent.endTest(test);
			extent.flush();
		}
@Test(priority =38)
void  ActiveDashboardFilter() throws InterruptedException, IOException
{
	test = extent.startTest(" Dashboard Active License Entity/Branch Location(Branch Mumbai)&LicenseType(Shops & Commercial Establishment) Filter working  Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
	StatutoryMethod.DashboardActivefilter( test, "Statutory");
	extent.endTest(test);
	extent.flush();
}
@Test(priority =39)
void  ExpiringDashboardFilter() throws InterruptedException, IOException
{
	test = extent.startTest(" Dashboard Expiring License Entity/Branch Location(Branch Mumbai)&LicenseType(Shops & Commercial Establishment) Filter working  Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
	StatutoryMethod.DashboardExpiringfilter( test, "Statutory");
	extent.endTest(test);
	extent.flush();
}
@Test(priority =40)
void  ExpiredDashboardFilter() throws InterruptedException, IOException
{
	test = extent.startTest(" Dashboard Expired License Entity/Branch Location(Branch Mumbai)&LicenseType(Shops & Commercial Establishment) Filter working  Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
	StatutoryMethod.DashboardExpiredfilter( test, "Statutory");
	extent.endTest(test);
	extent.flush();
}
@Test(priority =41)
void  AppliedDashboardFilter() throws InterruptedException, IOException
{
	test = extent.startTest("Dashboard Applied License Entity/Branch Location(Branch Mumbai)&LicenseType(Shops & Commercial Establishment) Filter working  Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
	StatutoryMethod.DashboardAppliedfilter( test, "Statutory");
	extent.endTest(test);
	extent.flush();
}
	@Test(priority = 42)
	void PendingForReviewDashboardFilter() throws InterruptedException, IOException
	{
	    test = extent.startTest("Dashboard Pending For review  License Entity/Branch Location(Branch Mumbai)&LicenseType(Shops & Commercial Establishment) Filter working  Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.Dashboardpendingforreviewfilter( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 43)
	void RejeectedDashboardFilter() throws InterruptedException, IOException
	{
	    test = extent.startTest("Dashboard Rejected License Entity/Branch Location(Branch Mumbai)&LicenseType(Shops & Commercial Establishment) Filter working  Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.DashboardRejectedLicensefilter( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 44)
	void TerminateDashboardFilter() throws InterruptedException, IOException
	{
	    test = extent.startTest("Dashboard Terminated License Entity/Branch Location(Branch Mumbai)&LicenseType(Shops & Commercial Establishment) Filter working  Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.DashboardTerminateLicensefilter( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority =45)
	void AssignedButNotActivatedDashboardFilter() throws InterruptedException, IOException
	{
	    test = extent.startTest("Dashboard Not Activated License Entity/Branch Location(Branch Mumbai)&LicenseType(Shops & Commercial Establishment) Filter working  Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.DashboardAssignedButNotActivatedFilter( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 46)
	void DashboardandReportCountMatch() throws InterruptedException, IOException
	{
		test = extent.startTest("Dashboard and Report Count Match Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		LiPeMethodsPOM.Dashallreportallcount( test, "Statutory");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 47)
	void ComplianceSampleForm() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Sample Form Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		LiPeMethodsPOM.ViewComplianceSampleform( test, "Statutory");
		
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


	
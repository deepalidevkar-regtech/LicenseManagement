package licenseDepartmentHead;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

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

public class DeptHeadInternalTC extends webpage
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
			sheet = workbook.getSheetAt(2);					//Retrieving second sheet of Workbook
			return sheet;
		}
		
		
		@BeforeTest
		void setBrowser() throws InterruptedException, IOException
		{
			String workingDir = System.getProperty("user.dir");
			extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//new//LicenseDepartmentHeadResult(Internal).html",true);
			test = extent.startTest("Logging In - Department Head (Internal)");
			//test.log(LogStatus.INFO, "Browser test is initiated");
			
			/*XSSFSheet sheet = ReadExcel();
			Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
			Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
			String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
			
			login.Login.BrowserSetup(URL);					//Method of Login class to set browser.
			*/
			      test.log(LogStatus.PASS, "URL-https://login.teamleaseregtech.com/Login.aspx?ReturnUrl=%2f&Session=Expired");
					test.log(LogStatus.PASS, "UserID-bhagyesh345@tlregtech.com");
					test.log(LogStatus.PASS, "Password-admin@123");
					
					test.log(LogStatus.PASS, "Department Head Login Successfully");
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
			initialization("License",5);
		}
@Test(priority = 2)
		void ActiveInternalLicense() throws InterruptedException, IOException
		{
			test = extent.startTest("Active License Count Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			DeptHeadMethod.DeptActiveInternalLicense( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 3)
void ExpiringInternalLicense() throws InterruptedException, IOException
{
	test = extent.startTest("Expiring License Count Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
	
   DeptHeadMethod.DeptExpiringInternalLicense( test, "Internal");
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 4)
void ExpiredInternalLicense() throws InterruptedException, IOException
{
	test = extent.startTest("Expired License Count Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
	
   DeptHeadMethod.DeptExpiredInternalLicense( test, "Internal");
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 5)
void AppliedInternalLicense() throws InterruptedException, IOException
{
	test = extent.startTest("Applied License Count Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
	
     DeptHeadMethod.DeptAppliedInternalLicense( test, "Internal");
	
	extent.endTest(test);
	extent.flush();
}
@Test(priority = 6)
void PendingForReviewInternalLicense() throws InterruptedException, IOException
{
	test = extent.startTest("Pending For Review License Count Verification");
	//test.log(LogStatus.INFO, "Test Initiated");
	
	DeptHeadMethod.DeptpendingforreviewInternalLicense( test, "Internal");
	
	extent.endTest(test);
	extent.flush();
}
  @Test(priority = 7)
			void RejectedInternalLicense() throws InterruptedException, IOException
			{
				test = extent.startTest("Rejected License Count  Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				DeptHeadMethod.DeptRejectedInternalLicense( test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}	
  @Test(priority = 8)
			void TerminateInternalLicense() throws InterruptedException, IOException
			{
				test = extent.startTest("Terminated License Count Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				DeptHeadMethod.DeptTerminateInternalLicense( test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
  @Test(priority = 9)
	void AssignedButNotActivated() throws InterruptedException, IOException
	{
		test = extent.startTest("Not Activated License Count Verification");
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
		
		DeptHeadMethod.DeptAssignedButNotActivated( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
  @Test(priority = 10)
	void LicenseExpiredOnInternal() throws InterruptedException
	{
		test = extent.startTest("ExpiredIn License Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		LicenseCompanyadmin.StatutoryMethod.LicenseExpiredInInternal( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
  @Test(priority = 11)
	void LicenseExpiringOnInternal() throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
		CFOcountPOM.clickApply1().click();				//Clicking on Apply.
		
		test = extent.startTest("ExpiringIn License Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		licmgmtMethodPOM.LicenseExpiringInStatutory( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 12)
	  void BystatusActiveInternalgraph() throws InterruptedException, IOException
		{
			test = extent.startTest("By Status-Active License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCompanyadmin.StatutoryMethod.BystatusActiveInternalgraph( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
		 @Test(priority = 13)
		  void BystatusExpringInternalgraph() throws InterruptedException, IOException
			{
				test = extent.startTest("By Status-Expiring License Graph Working Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				LicenseCompanyadmin.StatutoryMethod.BystatusExpringInternalgraph( test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
		@Test(priority = 14)
		  void BystatusExpiredInternal() throws InterruptedException, IOException
			{
				test = extent.startTest("By Status- Expired License Graph Working Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				LicenseCompanyadmin.StatutoryMethod.BystatusExpiredInternal( test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
			@Test(priority = 15)
		  void BystatusExpiredappliedbutnotrenewedInternalgraph() throws InterruptedException, IOException
			{
				test = extent.startTest("By Status-Applied License Graph Working Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				LicenseCompanyadmin.StatutoryMethod.BystatusappliedInternalgraph( test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
			@Test(priority = 16)
	void BystatusPendingForReviewgraph() throws InterruptedException, IOException
		{
			test = extent.startTest("By status-Pending For Review License Graph working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusPendingForReviewInternalgraph( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 17)
	  void BystatusRejectedInternalgraph() throws InterruptedException, IOException
		{
			test = extent.startTest("By Status-Rejected License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			StatutoryMethod.BystatusRejectedInternalgraph( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
	@Test(priority = 18)
	  void BystatusTerminateInternalgraph() throws InterruptedException, IOException
		{
			test = extent.startTest("By Status -Terminated License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCompanyadmin.StatutoryMethod.BystatusTerminateInternalgraph( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	
		@Test(priority = 19)
		void BylicnesetypeActiveInternal() throws InterruptedException
		{
			test = extent.startTest("By License Type-Annual maintenance Active Graph License Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			licmgmtMethodPOM.ByLicensetypeActiveInternal( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
		 @Test(priority = 20)
			void ByLicensetypeExpiringInternal() throws InterruptedException, IOException
			{
				test = extent.startTest("By License Type-Annual maintenance Expiring  License Graph Working Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				LicenseCompanyadmin.StatutoryMethod.ByLicensetypeExpiringInternal( test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
	 @Test(priority = 21)
			void  ByLicensetypeExpiredInternal() throws InterruptedException
			{
				test = extent.startTest("By License Type- Annual maintenance Expired License Graph Working Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
		        licmgmtMethodPOM.ByLicensetypeExpiredInternal( test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
	
@Test(priority = 22)
			void ByLicensetypeAppliedInternal() throws InterruptedException
			{
				test = extent.startTest("By License Type-Annual maintenance Applied License Graph Working Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
			   licmgmtMethodPOM.ByLicensetypeAppliedInternal( test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
 @Test(priority = 23)
	void ByLicensetypePendingForReviewInternal() throws InterruptedException, IOException
	{
		test = extent.startTest("Internal By License type -Annual maintenance Pending For Review Graph Count Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		StatutoryMethod.ByLicensetypePendingForReviewInternal( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
 @Test(priority = 24)
	void BylicnesetypeRejectedInternal() throws InterruptedException
	{
		test = extent.startTest("Internal By License type -Annual maintenance  Rejected Graph  Count Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		licmgmtMethodPOM.ByLicensetypeRejectedmgmtInternal( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	
@Test(priority = 25)
			void BylicnesetypeTerminateInternal() throws InterruptedException
			{
				test = extent.startTest("By License Type -Annual maintenance Graph Terminated License On Working Verification");
			//	test.log(LogStatus.INFO, "Test Initiated");
				
	             licmgmtMethodPOM.ByLicensetypeTerminateInternal( test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
		
@Test(priority = 26)
	void MyWorkspace() throws InterruptedException, IOException
	{
			
		test = extent.startTest("My Workspace  Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
      DeptHeadMethod.MyworkspaceaddLicense( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 27)
		void MyDocumentsInternal() throws InterruptedException
			{
				test = extent.startTest("My Documents Download Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				DeptHeadMethod.DeptMyDocuments( test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
@Test(priority = 28)
		void MyReports() throws InterruptedException, IOException
		{
			test = extent.startTest("My Reports Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			DeptHeadMethod.Reports( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 29)
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
		  //driver.close();
	 }

}
	


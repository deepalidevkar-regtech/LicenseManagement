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

public class mgmtinternalCriticalTC extends webpage {
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
		extent = new com.relevantcodes.extentreports.ExtentReports(workingDir+"//Reports//CriticalReport//LicManagementResult(Internal).html",true);
		test = extent.startTest("Logging In - Management (Internal)");
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
		initialization("License",2);
	}
@Test(priority = 2)
	void AllFilter() throws InterruptedException
	{
		test = extent.startTest("All Filter Working Verification");
		//test.log(LogStatus.PASS, "All Filter Working Verification");
		
		LicenseCompanyadmin.StatutoryMethod.Allfilter( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 3)
		void ActiveInternalLicense() throws InterruptedException
		{
			test = extent.startTest("Active License Count Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
			licmgmtMethodPOM.ActiveInternalLicense( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
 @Test(priority = 4)
			void ExpiringInternalLicense() throws InterruptedException
			{
				test = extent.startTest("Expiring License Count Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
			    licmgmtMethodPOM.ExpiringInternalLicense( test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
	  @Test(priority = 5)
		void ExpiredInternalLicense() throws InterruptedException
		{
			test = extent.startTest("Expired License Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
		   licmgmtMethodPOM.ExpiredInternalLicense( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	  @Test(priority = 6)
			void AppliedInternalLicense() throws InterruptedException
			{
				test = extent.startTest("Applied Internal License Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				LicenseCompanyadmin.StatutoryMethod.AppliedInternalLicense( test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
	  @Test(priority = 7)
		void PendingForReviewInternalLicense() throws InterruptedException
		{
			test = extent.startTest("Pending For Review Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCompanyadmin.StatutoryMethod.pendingforreviewInternalLicense( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	  @Test(priority = 8)
			void RejectedInternalLicense() throws InterruptedException
			{
				test = extent.startTest("Rejected License Count  Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				LicenseCompanyadmin.StatutoryMethod.RejectedInternalLicense(test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
	  @Test(priority = 9)
			void TerminateInternalLicense() throws InterruptedException
			{
				test = extent.startTest("Terminate License Count Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
				LicenseCompanyadmin.StatutoryMethod.TerminateInternalLicense( test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
	  @Test(priority = 10)
		void AssignedButNotActivated() throws InterruptedException, IOException
		{
			test = extent.startTest("Assigned But Not Activated  Count Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			WebDriverWait wait = new WebDriverWait(driver, 5);
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
			
			LiPeMethodsPOM.AssignedButNotActivated(test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}

	  @Test(priority = 11)
		void LicenseExpiredOnInternal() throws InterruptedException
		{
			test = extent.startTest("License Expired On Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCompanyadmin.StatutoryMethod.LicenseExpiredOnInternal( test, "Internal");
			
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
		
		test = extent.startTest("License ExpiringOn Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		licmgmtMethodPOM.LicenseExpiringInStatutory( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 13)
	  void BystatusActiveInternalgraph() throws InterruptedException
		{
			test = extent.startTest("By Status-Active License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCompanyadmin.StatutoryMethod.BystatusActiveInternalgraph( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 14)
	  void BystatusTerminateInternalgraph() throws InterruptedException
		{
			test = extent.startTest("By Status -Terminate License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCompanyadmin.StatutoryMethod.BystatusTerminateInternalgraph( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 15)
	  void BystatusExpiredappliedbutnotrenewedInternalgraph() throws InterruptedException
		{
			test = extent.startTest("By Status-Expired applied but not Renewed License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			LicenseCompanyadmin.StatutoryMethod.BystatusExpiredappliedbutnotrenewedInternalgraph( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 16)
	  void BystatusExpiredInternal() throws InterruptedException
		{
			test = extent.startTest("By Status- Expired License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCompanyadmin.StatutoryMethod.BystatusExpiredInternal( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	  @Test(priority = 17)
	  void BystatusExpringInternalgraph() throws InterruptedException
		{
			test = extent.startTest("By Status-Expiring License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCompanyadmin.StatutoryMethod.BystatusExpringInternalgraph( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 18)
		void  ByLicensetypeExpiredInternal() throws InterruptedException
		{
			test = extent.startTest("By License Type- Expired License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
	        licmgmtMethodPOM.ByLicensetypeExpiredInternal( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
@Test(priority = 19)
		void ByLicensetypeExpiringInternal() throws InterruptedException
		{
			test = extent.startTest("By License Type-Expiring License Graph Working Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCompanyadmin.StatutoryMethod.ByLicensetypeExpiringInternal( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	 @Test(priority = 20)
			void ByLicensetypeAppliedInternal() throws InterruptedException
			{
				test = extent.startTest("By License Type Graph Applied License On Working Verification");
				//test.log(LogStatus.INFO, "Test Initiated");
				
			   licmgmtMethodPOM.ByLicensetypeAppliedInternal( test, "Internal");
				
				extent.endTest(test);
				extent.flush();
			}
	@Test(priority = 21)
	void BylicnesetypeActiveInternal() throws InterruptedException
	{
		test = extent.startTest("By License Type Graph Active License On Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		
		licmgmtMethodPOM.ByLicensetypeActiveInternal( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
	 @Test(priority = 22)
		void BylicnesetypeTerminateInternal() throws InterruptedException
		{
			test = extent.startTest("By License Type Graph Terminate License On Working Verification");
		//	test.log(LogStatus.INFO, "Test Initiated");
			
             licmgmtMethodPOM.ByLicensetypeTerminateInternal( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 23)
	void MyDocumentsInternal() throws InterruptedException
		{
			test = extent.startTest("My Documents Download Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			//test = extent.startTest("My Document Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			
			LicenseCriticalTestCase.PerformerCritical.Documents( test, "Internal");
			
			extent.endTest(test);
			extent.flush();
		}
	@Test(priority = 24)
	void MyReports() throws InterruptedException, IOException
	{
		test = extent.startTest("My Reports Verification");
	//	test.log(LogStatus.INFO, "Test Initiated");
		
		LicenseCriticalTestCase.PerformerCritical.Reports( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 25)
	void MyWorkspace() throws InterruptedException, IOException
	{
   	  WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
		//LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
		
		// Select drp = new Select(LiPerformerPOM.clickType(driver));
	   //	drp.selectByIndex(1);
		test = extent.startTest("My Workspace  Working Verification");
		//test.log(LogStatus.INFO, "Test Initiated");
		 PerformerInternalCritical.MyworkspaceaddLicense1( test, "Internal");
		
		extent.endTest(test);
		extent.flush();
	}

	 @Test(priority = 26)
		void InternalLicenseCreation() throws InterruptedException, IOException
		{
			test = extent.startTest("License Creation Verification");
			//test.log(LogStatus.INFO, "Test Initiated");
			StatutoryMethod.InternalLicenseCreation( test, "Internal");
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




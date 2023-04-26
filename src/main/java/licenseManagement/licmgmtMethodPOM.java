package licenseManagement;

import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import contract.ContractPOM;
import licenseCompanyadmin.MethodPOM;
import licensePerformer.LiPerformerPOM;
import licenseReviewer.LiReviewerPOM;
import performer.OverduePOM;

public class licmgmtMethodPOM {
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
	public static void ActiveLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
		String active=MethodPOM.clickActive(driver).getText();
		
	     int activelicense = Integer.parseInt(active);	//Reading Active count.

	      MethodPOM.clickActive(driver).click();					//Clicking on 'Active' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			int total = Integer.parseInt(LicenseActiveCount);
			if(activelicense == total)
				{
				//	test.log(LogStatus.PASS, "Number of Active License  grid matches to Dashboard Active License   Count.");
					test.log(LogStatus.PASS, "No of Active License  in the grid = "+total+" | Dashboard Active License  Count = "+activelicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Active License does not matches to Dashboard Active License   Count.");
					test.log(LogStatus.FAIL, "No of Active License  in the grid = "+total+" | Dashboard Active License  Count = "+activelicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, "Activer License Overview Details Sucessfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				MethodPOM.clickMyDashboard(driver).click();
	}
	public static void ExpiringLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring(driver)));
		String Expiring=MethodPOM.clickExpiring(driver).getText();
		
	     int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.

	      MethodPOM.clickExpiring(driver).click();					//Clicking on 'Expiring' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadExpiring(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadExpiring(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseExpiringCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total = Integer.parseInt(LicenseExpiringCount);
			if(Expiringlicense == total)
				{
					//test.log(LogStatus.PASS, "Number of Expiring License  grid matches to Dashboard Expiring  License   Count.");
					test.log(LogStatus.PASS, "No of Expiring  License  in the grid = "+total+" | Dashboard Expiring License  Count = "+Expiringlicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expiring License does not matches to Dashboard Expiring License   Count.");
					test.log(LogStatus.FAIL, "No of Expiring License  in the grid = "+total+" | Dashboard Expiring License  Count = "+Expiringlicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, "Expiring License Overview Details Sucessfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				MethodPOM.clickMyDashboard(driver).click();
	}
	public static void ByLicensetypeExpired(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
	   {

		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		   Js1.executeScript("window.scrollBy(0,1000)");
		    WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickByLicnesetypeExpired(driver)));	  
			String ByLicenseTypeExpired=licmgmtPOM.clickByLicnesetypeExpired(driver).getText();
			
		     int ByLicensetypeExpiredgraph = Integer.parseInt(ByLicenseTypeExpired);	//Reading Expired graph count.
		     Thread.sleep(4000);
		     licmgmtPOM.clickByLicnesetypeExpired(driver).click();					//Clicking on 'Expired' image
		      Thread.sleep(5000);
		      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
		      JavascriptExecutor Js = (JavascriptExecutor) driver;
			   Js.executeScript("window.scrollBy(0,2000)");
			   Thread.sleep(3000);
				//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
				MethodPOM.clickAllReadcount(driver).click();//Clicking on total items count
				Thread.sleep(5000);
				String item = MethodPOM.clickAllReadcount(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(ByLicensetypeCount);
				if(ByLicensetypeExpiredgraph == total)
					{
						//test.log(LogStatus.PASS, "Number of Expired License  grid matches to Dashboard By Licnesetype Graph Expired License Count.");
						test.log(LogStatus.PASS, "No of Expired License  in the grid = "+total+" | Dashboard By Licnesetype Expired License  Count = "+ByLicensetypeExpiredgraph);
					}
					else
					{
						//test.log(LogStatus.FAIL, "Number of Applied License does not matches to Dashboard By Licnesetype Graph Applied License   Count.");
						test.log(LogStatus.FAIL, "No of Expired License  in the grid = "+total+" | Dashboard By Licnesetype Expired License  Count = "+ByLicensetypeExpiredgraph);
					}
					Thread.sleep(3000);
					
				 MethodPOM.clickExportGraph(driver).click();
				 Thread.sleep(3000);
				 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
				 MethodPOM.clickAllOverview(driver).click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview(driver).click();
				 Thread.sleep(4000);
				   Js1.executeScript("window.scrollBy(500,0)");
				   Thread.sleep(3000);
				driver.switchTo().parentFrame();
				 MethodPOM.clickCloseGraphPopup(driver).click();
				 Thread.sleep(3000);
				 
	   }
	 public static void ByLicensetypeApplied(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
	   {

		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		   Js1.executeScript("window.scrollBy(0,1000)");
		    WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickByLicensetypeApplied(driver)));	  
			String ByLicenseTypeApplied=licmgmtPOM.clickByLicensetypeApplied(driver).getText();
			
		     int ByLicensetypeAppliedggraph = Integer.parseInt(ByLicenseTypeApplied);	//Reading Applied graph count.
		     Thread.sleep(4000);
		     licmgmtPOM.clickByLicensetypeApplied(driver).click();					//Clicking on 'Applied' image
		      Thread.sleep(5000);
		      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
		      JavascriptExecutor Js = (JavascriptExecutor) driver;
			   Js.executeScript("window.scrollBy(0,2000)");
			   Thread.sleep(3000);
				//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
				MethodPOM.clickAllReadcount(driver).click();//Clicking on total items count
				Thread.sleep(5000);
				String item = MethodPOM.clickAllReadcount(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(ByLicensetypeCount);
				if(ByLicensetypeAppliedggraph == total)
					{
						//test.log(LogStatus.PASS, "Number of Applied License  grid matches to Dashboard By Licnesetype Graph Applied License Count.");
						test.log(LogStatus.PASS, "No of Applied License  in the grid = "+total+" | Dashboard By Licnese type Applied License  Count = "+ByLicensetypeAppliedggraph);
					}
					else
					{
						//test.log(LogStatus.FAIL, "Number of Applied License does not matches to Dashboard By Licnese type Graph Applied License   Count.");
						test.log(LogStatus.FAIL, "No of Applied License  in the grid = "+total+" | Dashboard By Licnese type Applied License  Count = "+ByLicensetypeAppliedggraph);
					}
					Thread.sleep(3000);
					
				 MethodPOM.clickExportGraph(driver).click();
				 Thread.sleep(3000);
				 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
				 MethodPOM.clickAllOverview(driver).click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview(driver).click();
				 Thread.sleep(4000);
				   Js1.executeScript("window.scrollBy(500,0)");
				   Thread.sleep(3000);
				driver.switchTo().parentFrame();
				 MethodPOM.clickCloseGraphPopup(driver).click();
				 Thread.sleep(3000);
				 
	   }
	 public static void ByLicensetypeActive(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
	   {

		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		   Js1.executeScript("window.scrollBy(0,1000)");
		   Thread.sleep(3000);
		    WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickByLicnesetypeActive(driver)));	  
			String ByLicenseTypeActive=licmgmtPOM.clickByLicnesetypeActive(driver).getText();
			
		     int ByLicensetypeActiveggraph = Integer.parseInt(ByLicenseTypeActive);	//Reading Active graph count.
		     Thread.sleep(4000);
		     licmgmtPOM.clickByLicnesetypeActive(driver).click();					//Clicking on 'Active' image
		      Thread.sleep(5000);
		      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
		      JavascriptExecutor Js = (JavascriptExecutor) driver;
			   Js.executeScript("window.scrollBy(0,2000)");
			   Thread.sleep(3000);
				//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
				MethodPOM.clickAllReadcount(driver).click();//Clicking on total items count
				Thread.sleep(5000);
				String item = MethodPOM.clickAllReadcount(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(ByLicensetypeCount);
				if(ByLicensetypeActiveggraph == total)
					{
						//test.log(LogStatus.PASS, "Number of Active License  grid matches to Dashboard By Licnesetype Graph Active License Count.");
						test.log(LogStatus.PASS, "No of Active License  in the grid = "+total+" | Dashboard By Licnese type Active License  Count = "+ByLicensetypeActiveggraph);
					}
					else
					{
						//test.log(LogStatus.FAIL, "Number of Active License does not matches to Dashboard By Licnese type Graph Active License   Count.");
						test.log(LogStatus.FAIL, "No of Active License  in the grid = "+total+" | Dashboard By Licnese type Active License  Count = "+ByLicensetypeActiveggraph);
					}
					Thread.sleep(3000);
					
				 MethodPOM.clickExportGraph(driver).click();
				 Thread.sleep(3000);
				 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
				 MethodPOM.clickAllOverview(driver).click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview(driver).click();
				 Thread.sleep(4000);
				   Js1.executeScript("window.scrollBy(500,0)");
				   Thread.sleep(3000);
				driver.switchTo().parentFrame();
				 MethodPOM.clickCloseGraphPopup(driver).click();
				 Thread.sleep(3000);
				 
	   }
	 public static void ByLicensetypeTerminate(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
	   {

		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		   Js1.executeScript("window.scrollBy(0,1000)");
		   Thread.sleep(3000);
		    WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickByLicnesetypeTerminate(driver)));	  
			String ByLicenseTypeTerminate=licmgmtPOM.clickByLicnesetypeTerminate(driver).getText();
			
		     int ByLicensetypeTerminateggraph = Integer.parseInt(ByLicenseTypeTerminate);	//Reading Terminate graph count.
		     Thread.sleep(4000);
		     licmgmtPOM.clickByLicnesetypeTerminate(driver).click();					//Clicking on 'Terminate' image
		      Thread.sleep(5000);
		      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
		      JavascriptExecutor Js = (JavascriptExecutor) driver;
			   Js.executeScript("window.scrollBy(0,2000)");
			   Thread.sleep(3000);
				//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
				MethodPOM.clickAllReadcount(driver).click();//Clicking on total items count
				Thread.sleep(5000);
				String item = MethodPOM.clickAllReadcount(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(ByLicensetypeCount);
				if(ByLicensetypeTerminateggraph == total)
					{
						//test.log(LogStatus.PASS, "Number of Terminate License  grid matches to Dashboard By Licnesetype Graph Terminate License Count.");
						test.log(LogStatus.PASS, "No of Terminate License  in the grid = "+total+" | Dashboard By Licnese type Terminate License  Count = "+ByLicensetypeTerminateggraph);
					}
					else
					{
						//test.log(LogStatus.FAIL, "Number of Terminate License does not matches to Dashboard By Licnese type Graph Terminate License   Count.");
						test.log(LogStatus.FAIL, "No of Terminate License  in the grid = "+total+" | Dashboard By Licnese type Terminate License  Count = "+ByLicensetypeTerminateggraph);
					}
					Thread.sleep(3000);
					
				 MethodPOM.clickExportGraph(driver).click();
				 Thread.sleep(3000);
				 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
				 MethodPOM.clickAllOverview(driver).click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview(driver).click();
				 Thread.sleep(4000);
				   Js1.executeScript("window.scrollBy(500,0)");
				   Thread.sleep(3000);
				driver.switchTo().parentFrame();
				 MethodPOM.clickCloseGraphPopup(driver).click();
				 Thread.sleep(3000);
				 
	   }
	 public static void ActiveInternalLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
		{	
			Thread.sleep(3000);
			  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
			   Thread.sleep(3000);
			   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
			   
			   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();

				WebDriverWait wait = new WebDriverWait(driver, 20);
				
		//	WebDriverWait wait = new WebDriverWait(driver, 120);
			
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
			String active=MethodPOM.clickActive(driver).getText();
			
		     int activelicense = Integer.parseInt(active);	//Reading Active count.

		      MethodPOM.clickActive(driver).click();					//Clicking on 'Active' image
		      	Thread.sleep(8000);
				wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickTabelGrid(driver)));
		        JavascriptExecutor js1=(JavascriptExecutor) driver ;
				js1.executeScript("window.scroll(0,800)");
		       
				//Thread.sleep(8000);
			
				licmgmtPOM.clickReadActive(driver).click();					//Clicking on total items count
				Thread.sleep(4000);
				String item = licmgmtPOM.clickReadActive(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(LicenseActiveCount);
				if(activelicense == total)
					{
						//test.log(LogStatus.PASS, "Number of Active Internal License  grid matches to Dashboard Active Internal License   Count.");
						test.log(LogStatus.PASS, "No of Active  Internal License  in the grid = "+total+" | Dashboard Active Internal  License  Count = "+activelicense);
					}
					else
					{
						//test.log(LogStatus.FAIL, "Number of Active Internal License does not matches to Dashboard Active Internal License   Count.");
						test.log(LogStatus.FAIL, "No of Active Internal License  in the grid = "+total+" | Dashboard Active Internal License  Count = "+activelicense);
					}
					Thread.sleep(3000);
					//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
					//Thread.sleep(3000);
					
					MethodPOM.ClickActiveOverview(driver).click();
					test.log(LogStatus.PASS, "Activer License Overview Details Sucessfully");
					Thread.sleep(3000);
					MethodPOM.ClickCloseOverview(driver).click();
					MethodPOM.clickMyDashboard(driver).click();
		}
	 public static void ExpiringInternalLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
		{		
			Thread.sleep(3000);
			  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
			   Thread.sleep(3000);
			   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
			   
			   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();

				WebDriverWait wait = new WebDriverWait(driver, 20);
				
		Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();

			//WebDriverWait wait = new WebDriverWait(driver, 20);
			
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring(driver)));
			String Expiring=MethodPOM.clickExpiring(driver).getText();
			
		     int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.

		      MethodPOM.clickExpiring(driver).click();					//Clicking on 'Expiring' image
		      Thread.sleep(4000);
		 
		      JavascriptExecutor js1=(JavascriptExecutor) driver ;
				js1.executeScript("window.scroll(0,500)");
				String item1 = MethodPOM.clickReadExpired(driver).getText();	//Reading total items String value
				
		      if(!item1.equalsIgnoreCase("No items to display"))
		      {
		    	  // JavascriptExecutor js1=(JavascriptExecutor) driver ;
					js1.executeScript("window.scroll(0,500)");
					Thread.sleep(4000);
					
					MethodPOM.clickReadExpiring(driver).click();					//Clicking on total items count
					Thread.sleep(500);
					String item = MethodPOM.clickReadExpiring(driver).getText();	//Reading total items String value
					String[] bits = item.split(" ");								//Splitting the String
					String LicenseExpiringCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
					
					//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
					int total = Integer.parseInt(LicenseExpiringCount);
					if(Expiringlicense == total)
						{
							//test.log(LogStatus.PASS, "Number of Expiring Internal  License  grid matches to Dashboard Expiring Internal  License   Count.");
							test.log(LogStatus.PASS, "No of Expiring Internal   License  in the grid = "+total+" | Dashboard Expiring Internal  License  Count = "+Expiringlicense);
						}
						else
						{
							//test.log(LogStatus.FAIL, "Number of Expiring Internal License does not matches to Dashboard Expiring Internal  License   Count.");
							test.log(LogStatus.FAIL, "No of Expiring Internal  License  in the grid = "+total+" | Dashboard Expiring Internal  License  Count = "+Expiringlicense);
						}
						Thread.sleep(3000);
						//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
						//Thread.sleep(3000);
						
						MethodPOM.ClickActiveOverview(driver).click();
						test.log(LogStatus.PASS, "Expiring License Overview Details Sucessfully");
						Thread.sleep(3000);
						MethodPOM.ClickCloseOverview(driver).click();
						MethodPOM.clickMyDashboard(driver).click();
		      }
		      else
		      {
			
					test.log(LogStatus.PASS,"No Record Found");
					MethodPOM.clickMyDashboard(driver).click();
					
		      }
		      
		     
		}
	 public static void ExpiredInternalLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
		{	
		  Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
		   

			WebDriverWait wait = new WebDriverWait(driver, 20);
			
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired(driver)));
			String Expired=MethodPOM.clickExpired(driver).getText();
			
		     int Expiredlicense = Integer.parseInt(Expired);	//Reading Expired count.

		      MethodPOM.clickExpired(driver).click();					//Clicking on 'Expired' image
		      Thread.sleep(4000);
		 
		      wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickTabelGrid(driver)));
		      
		      

	    	   JavascriptExecutor js1=(JavascriptExecutor) driver ;
				js1.executeScript("window.scroll(0,500)");
				String item1 = MethodPOM.clickReadExpired(driver).getText();	//Reading total items String value
				
		      if(!item1.equalsIgnoreCase("No items to display"))
		      {
		    	//   JavascriptExecutor js=(JavascriptExecutor) driver ;
					js1.executeScript("window.scroll(0,500)");
					Thread.sleep(4000);
					
					MethodPOM.clickReadExpired(driver).click();					//Clicking on total items count
					Thread.sleep(500);
					String item = MethodPOM.clickReadExpired(driver).getText();	//Reading total items String value
					String[] bits = item.split(" ");								//Splitting the String
					String LicenseExpiredCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
					
					//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
					int total = Integer.parseInt(LicenseExpiredCount);
					if(Expiredlicense == total)
						{
							//test.log(LogStatus.PASS, "Number of Expired Internal  License  grid matches to Dashboard Expired Internal  License   Count.");
							test.log(LogStatus.PASS, "No of Expired Internal   License  in the grid = "+total+" | Dashboard Expired Internal  License  Count = "+Expiredlicense);
						}
						else
						{
							//test.log(LogStatus.FAIL, "Number of Expiring Internal License does not matches to Dashboard Expiring Internal  License   Count.");
							test.log(LogStatus.FAIL, "No of Expiring Internal  License  in the grid = "+total+" | Dashboard Expiring Internal  License  Count = "+Expiredlicense);
						}
						Thread.sleep(3000);
						//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
						//Thread.sleep(3000);
						
						MethodPOM.ClickActiveOverview(driver).click();
						test.log(LogStatus.PASS, " Expired License Overview Details Sucessfully");
						Thread.sleep(3000);
						MethodPOM.ClickCloseOverview(driver).click();
						MethodPOM.clickMyDashboard(driver).click();
						
						
		      }
		      else
		      {
					test.log(LogStatus.PASS,"No record Found" );
					MethodPOM.clickMyDashboard(driver).click();
					
		      }
		      
		}
	 public  static void MyworkspaceaddLicense(WebDriver driver,ExtentTest test, String type) throws InterruptedException, IOException
	 {
	
		 
		 licmgmtPOM.ClickMyWorkspace(driver).click();
		 WebDriverWait wait = new WebDriverWait(driver, 50);
		 
		 licmgmtPOM.ClickAddLicense(driver).click();
		 
		Thread.sleep(3000);	
		 licmgmtPOM.ClickLicenseTypeDropdown(driver).click();
		 licmgmtPOM.SelectLicenseType(driver).click();
		 
		 Thread.sleep(500);
		licmgmtPOM.ClickLocation(driver).click();
		Thread.sleep(3000);
	     licmgmtPOM.LocationMaximize(driver).click();
		
		 Thread.sleep(3000);
		 licmgmtPOM.SelectLocation(driver).click();
		 
		 Thread.sleep(3000);
		 licmgmtPOM.ClickCompliance(driver).click();
		 Thread.sleep(5000);
		 licmgmtPOM.SelectLicenseCompliance(driver).get(1).click();
		 
		 Thread.sleep(5000);
		 licmgmtPOM.ClickPerformer(driver).click();
		 Thread.sleep(6000);
		 licmgmtPOM.SelectPerformer(driver).get(3).click();
		// licmgmtPOM.SelectPerformer(driver).click();
		 
		 Thread.sleep(3000);
		 licmgmtPOM.ClickReviewer(driver).click();
		 Thread.sleep(6000);
		 licmgmtPOM.SelectReviewer(driver).get(111).click(); 
		 
		 XSSFSheet Sheet= ReadExcel();
		 Thread.sleep(3000);
		 sheet = workbook.getSheetAt(2);
		 Row row6= sheet.getRow(6);
		  org.apache.poi.ss.usermodel.Cell c1 = row6.getCell(1);	
		 String LicenseTitle= c1.getStringCellValue();
		 licmgmtPOM.LicenseTitle(driver).sendKeys(LicenseTitle);
		 
		 Thread.sleep(3000);
		 Row row7=sheet.getRow(7);
			org.apache.poi.ss.usermodel.Cell c2=row7.getCell(1);
		 String LicenseNo=c2.getStringCellValue();
		 licmgmtPOM.LicenseNo(driver).sendKeys(LicenseNo);
		 
		 Thread.sleep(3000);
		 Row row8=sheet.getRow(8);
			org.apache.poi.ss.usermodel.Cell c3=row8.getCell(1);
		 String ApplicationDays=c3.getStringCellValue();
		 licmgmtPOM.ApplicationDays(driver).sendKeys(ApplicationDays);
		 
		 Thread.sleep(3000);
		 Row row9=sheet.getRow(9);
			org.apache.poi.ss.usermodel.Cell c4=row9.getCell(1);
		 String LicenseCost=c4.getStringCellValue();
		 licmgmtPOM.LicenseCost(driver).sendKeys(LicenseCost);
		 
		licmgmtPOM.ClickCal(driver).click();
		 Thread.sleep(7000);
		 licmgmtPOM.NewDate(driver).click();
		 Thread.sleep(5000);
		licmgmtPOM.ClickCal1(driver).click();
		 Thread.sleep(7000);
		licmgmtPOM.NewEndDate(driver).click();
		
		 
		Thread.sleep(300);
		// licmgmtPOM.Chooesfile(driver).click();
			//String workingDir = System.getProperty("user.dir");
			//licmgmtPOM.Chooesfile(driver).sendKeys(workingDir+"//Reports//LicensePerformerResults(Statutory).html");
        

  	      JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,2000)");
	/*	 licmgmtPOM.ClickNomineedrp(driver).click();
		 Thread.sleep(3000);
		 licmgmtPOM.SelectNominee(driver).click();
		 Thread.sleep(5000);
		 js1.executeScript("window.scroll(0,2000)");
		 Thread.sleep(5000);
		 licmgmtPOM.ClickModificdate(driver).click();
		 Thread.sleep(6000);	
		 js1.executeScript("window.scroll(0,2000)");
		 Thread.sleep(6000);		 
		 licmgmtPOM.ModificatioDate(driver).click();		 
		 Thread.sleep(6000);
		 js1.executeScript("window.scroll(0,2000)");
		 licmgmtPOM.nomineestartdatecal(driver).click();
		 Thread.sleep(3000);
		 licmgmtPOM.selectnominstartdate(driver).click();
		 Thread.sleep(3000);
		 JavascriptExecutor js2=(JavascriptExecutor) driver ;
			js2.executeScript("window.scroll(0,2000)");
		 licmgmtPOM.nomineeEnddatecal(driver).click();
		 Thread.sleep(5000);
		 licmgmtPOM.selectnomineenddate(driver).click();*/
		 Thread.sleep(5000);
		 licmgmtPOM.Nomineesubmit(driver).click();
		 Thread.sleep(5000);
		    // Switching to Alert       
		        Alert alert = driver.switchTo().alert();
		       
		        // Capturing alert message.   
		        String alertMessage= driver.switchTo().alert().getText();
		       
		        Thread.sleep(3000);
		        test.log(LogStatus.PASS, alertMessage);
		       
		        // Displaying alert message
		        System.out.println(alertMessage);
		       
		       
		        // Accepting alert
		        alert.accept();
		        
		        Thread.sleep(3000);
		        Thread.sleep(5000);
		        // Switching to Alert       
		            Alert alert1 = driver.switchTo().alert();
		           
		            // Capturing alert message.   
		            String alertMessage1= driver.switchTo().alert().getText();
		           
		            Thread.sleep(3000);
		            test.log(LogStatus.PASS, alertMessage);
		           
		            // Displaying alert message
		            System.out.println(alertMessage);
		           
		           
		            // Accepting alert
		            alert.accept();
		
	 }
	 public static void MyDocuments(WebDriver driver, ExtentTest test, String type) throws InterruptedException
		{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			
			
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired(driver)));
			
			LiPerformerPOM.clickMyDocuments(driver).click();		//Clicking on 'My Documents'
			Thread.sleep(3000);
			LiPerformerPOM.clickMyDocumentsMenu(driver).click();	//Clicking on 'My Documents'
			
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1(driver)));	//Waiting until records table gets visible.
			
			if(type.equalsIgnoreCase("Internal"))
			{
				LiPerformerPOM.clickType2(driver).click();			//Clicking on 'Type' drop down.
				Thread.sleep(500);
				LiPerformerPOM.selectInternal(driver).click();//Selecting 'Internal' option.
				Thread.sleep(1000);
				
			}
			
			Thread.sleep(500);
			File dir = new File("C:\\Users\\dipali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			MethodPOM.DownloadDocument(driver).click();
			
			Thread.sleep(3000);
	       
			File dir1 = new File("C:\\Users\\dipali\\Downloads");
			File[] dirContents1 = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < dirContents1.length)
			{
				test.log(LogStatus.PASS, "File downloaded successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			
			
			Thread.sleep(3000);
			
			MethodPOM.ViewDocument(driver).click();
			test.log(LogStatus.PASS, "Document View successfully.");
			
			Thread.sleep(3000);
			MethodPOM.closeViewDocument(driver).click();
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard(driver)));
			OverduePOM.clickDashboard(driver).click();
			}
	 public static void ByLicensetypeExpiredInternal(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
	   {
		  Thread.sleep(3000);
			  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
			   Thread.sleep(3000);
			   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
			   
			   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		   Js1.executeScript("window.scrollBy(0,1000)");
		    WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickByLicnesetypeExpiredInternal(driver)));	  
			String ByLicenseTypeExpired=licmgmtPOM.clickByLicnesetypeExpiredInternal(driver).getText();
			
		     int ByLicensetypeExpiredgraph = Integer.parseInt(ByLicenseTypeExpired);	//Reading Expired graph count.
		     Thread.sleep(4000);
		     licmgmtPOM.clickByLicnesetypeExpiredInternal(driver).click();					//Clicking on 'Expired' image
		      Thread.sleep(5000);
		      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
		      JavascriptExecutor Js = (JavascriptExecutor) driver;
			   Js.executeScript("window.scrollBy(0,2000)");
			   Thread.sleep(3000);
				//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
				MethodPOM.clickAllReadcount(driver).click();//Clicking on total items count
				Thread.sleep(5000);
				String item = MethodPOM.clickAllReadcount(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(ByLicensetypeCount);
				if(ByLicensetypeExpiredgraph == total)
					{
						//test.log(LogStatus.PASS, "Number of Expired License  grid matches to Dashboard By Licnese type Graph Expired License Count.");
						test.log(LogStatus.PASS, "No of Expired License  in the grid = "+total+" | Dashboard By Licnesetype Expired License  Count = "+ByLicensetypeExpiredgraph);
					}
					else
					{
						//test.log(LogStatus.FAIL, "Number of Expired License does not matches to Dashboard By Licnese type Graph Expired License   Count.");
						test.log(LogStatus.FAIL, "No of Expired License  in the grid = "+total+" | Dashboard By Licnesetype Expired License  Count = "+ByLicensetypeExpiredgraph);
					}
					Thread.sleep(3000);
					
				 MethodPOM.clickExportGraph(driver).click();
				 Thread.sleep(3000);
				 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
				 MethodPOM.clickAllOverview(driver).click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview(driver).click();
				 Thread.sleep(4000);
				   Js1.executeScript("window.scrollBy(500,0)");
				   Thread.sleep(3000);
				driver.switchTo().parentFrame();
				 MethodPOM.clickCloseGraphPopup(driver).click();
				 Thread.sleep(3000);
				 
	   }
	 public static void ByLicensetypeAppliedInternal(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
	   {
		  Thread.sleep(3000);
			  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
			   Thread.sleep(3000);
			   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
			   
			   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		   Js1.executeScript("window.scrollBy(0,1000)");
		    WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickByLicnesetypeAppliedInternal1(driver)));	  
			String ByLicenseTypeApplied=licmgmtPOM.clickByLicnesetypeAppliedInternal1(driver).getText();
			
		     int ByLicensetypeAppliedggraph = Integer.parseInt(ByLicenseTypeApplied);	//Reading Applied graph count.
		     Thread.sleep(4000);
		     licmgmtPOM.clickByLicnesetypeAppliedInternal1(driver).click();					//Clicking on 'Applied' image
		      Thread.sleep(5000);
		      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
		      JavascriptExecutor Js = (JavascriptExecutor) driver;
			   Js.executeScript("window.scrollBy(0,2000)");
			   Thread.sleep(3000);
				//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
				MethodPOM.clickAllReadcount(driver).click();//Clicking on total items count
				Thread.sleep(5000);
				String item = MethodPOM.clickAllReadcount(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(ByLicensetypeCount);
				if(ByLicensetypeAppliedggraph == total)
					{
						//test.log(LogStatus.PASS, "Number of Applied License  grid matches to Dashboard By Licnesetype Graph Applied License Count.");
						test.log(LogStatus.PASS, "No of Applied License  in the grid = "+total+" | Dashboard By Licnese type Applied License  Count = "+ByLicensetypeAppliedggraph);
					}
					else
					{
						//test.log(LogStatus.FAIL, "Number of Applied License does not matches to Dashboard By Licnese type Graph Applied License   Count.");
						test.log(LogStatus.FAIL, "No of Applied License  in the grid = "+total+" | Dashboard By Licnese type Applied License  Count = "+ByLicensetypeAppliedggraph);
					}
					Thread.sleep(3000);
					
				 MethodPOM.clickExportGraph(driver).click();
				 Thread.sleep(3000);
				 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
				 MethodPOM.clickAllOverview(driver).click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview(driver).click();
				 Thread.sleep(4000);
				   Js1.executeScript("window.scrollBy(500,0)");
				   Thread.sleep(3000);
				driver.switchTo().parentFrame();
				 MethodPOM.clickCloseGraphPopup(driver).click();
				 Thread.sleep(3000);
				 
	   }
	  public static void ByLicensetypeActiveInternal(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
	   {
	      
		   Thread.sleep(3000);
			  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
			   Thread.sleep(3000);
			   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
			   
			   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		   Js1.executeScript("window.scrollBy(0,1000)");
		   Thread.sleep(3000);
		    WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickByLicnesetypeActiveInternal1(driver)));	  
			String ByLicenseTypeActive=licmgmtPOM.clickByLicnesetypeActiveInternal1(driver).getText();
			
		     int ByLicensetypeActiveggraph = Integer.parseInt(ByLicenseTypeActive);	//Reading Active graph count.
		     Thread.sleep(4000);
		     licmgmtPOM.clickByLicnesetypeActiveInternal1(driver).click();					//Clicking on 'Active' image
		      Thread.sleep(5000);
		      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
		      JavascriptExecutor Js = (JavascriptExecutor) driver;
			   Js.executeScript("window.scrollBy(0,2000)");
			   Thread.sleep(3000);
				//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
				MethodPOM.clickAllReadcount(driver).click();//Clicking on total items count
				Thread.sleep(5000);
				String item = MethodPOM.clickAllReadcount(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(ByLicensetypeCount);
				if(ByLicensetypeActiveggraph == total)
					{
						//test.log(LogStatus.PASS, "Number of Active License  grid matches to Dashboard By Licnesetype Graph Active License Count.");
						test.log(LogStatus.PASS, "No of Active License  in the grid = "+total+" | Dashboard By Licnese type Active License  Count = "+ByLicensetypeActiveggraph);
					}
					else
					{
						//test.log(LogStatus.FAIL, "Number of Active License does not matches to Dashboard By Licnese type Graph Active License   Count.");
						test.log(LogStatus.FAIL, "No of Active License  in the grid = "+total+" | Dashboard By Licnese type Active License  Count = "+ByLicensetypeActiveggraph);
					}
					Thread.sleep(3000);
					
				 MethodPOM.clickExportGraph(driver).click();
				 Thread.sleep(3000);
				 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
				 MethodPOM.clickAllOverview(driver).click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview(driver).click();
				 Thread.sleep(4000);
				   Js1.executeScript("window.scrollBy(500,0)");
				   Thread.sleep(3000);
				driver.switchTo().parentFrame();
				 MethodPOM.clickCloseGraphPopup(driver).click();
				 Thread.sleep(3000);
				 
	   }
	  public static void ByLicensetypeTerminateInternal(WebDriver driver, ExtentTest test, String type ) throws InterruptedException
	   {
		   Thread.sleep(3000);
			  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
			   Thread.sleep(3000);
			   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
			   
			   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		   Js1.executeScript("window.scrollBy(0,1000)");
		   Thread.sleep(3000);
		    WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickByLicnesetypeTerminateInternal1(driver)));	  
	    	String ByLicenseTypeTerminate=licmgmtPOM.clickByLicnesetypeTerminateInternal1(driver).getText();
			
		  int ByLicensetypeTerminateggraph = Integer.parseInt(ByLicenseTypeTerminate);	//Reading Terminate graph count.
		     Thread.sleep(4000);
		     licmgmtPOM.clickByLicnesetypeTerminateInternal1(driver).click();					//Clicking on 'Terminate' image
		      Thread.sleep(5000);
		      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
		      JavascriptExecutor Js = (JavascriptExecutor) driver;
			   Js.executeScript("window.scrollBy(0,2000)");
			   Thread.sleep(3000);
				//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount(driver)));	 
				MethodPOM.clickAllReadcount(driver).click();//Clicking on total items count
				Thread.sleep(5000);
				String item = MethodPOM.clickAllReadcount(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(ByLicensetypeCount);
				if(ByLicensetypeTerminateggraph == total)
					{
						//test.log(LogStatus.PASS, "Number of Terminate License  grid matches to Dashboard By Licnesetype Graph Terminate License Count.");
						test.log(LogStatus.PASS, "No of Terminate License  in the grid = "+total+" | Dashboard By Licnese type Terminate License  Count = "+ByLicensetypeTerminateggraph);
					}
					else
					{
						//test.log(LogStatus.FAIL, "Number of Terminate License does not matches to Dashboard By Licnese type Graph Terminate License   Count.");
						test.log(LogStatus.FAIL, "No of Terminate License  in the grid = "+total+" | Dashboard By Licnese type Terminate License  Count = "+ByLicensetypeTerminateggraph);
					}
					Thread.sleep(3000);
					
				 MethodPOM.clickExportGraph(driver).click();
				 Thread.sleep(3000);
				 test.log(LogStatus.PASS, "License Details Dwonloaded Sucessfully");
				 MethodPOM.clickAllOverview(driver).click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				 test.log(LogStatus.PASS, "License OverView Details Open  Sucessfully");
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview(driver).click();
				 Thread.sleep(4000);
				   Js1.executeScript("window.scrollBy(500,0)");
				   Thread.sleep(3000);
				driver.switchTo().parentFrame();
				 MethodPOM.clickCloseGraphPopup(driver).click();
				 Thread.sleep(3000);
				 
	   }



}

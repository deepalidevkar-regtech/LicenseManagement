package licenseDepartmentHead;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import licenseCompanyadmin.MethodPOM;
import licenseManagement.licmgmtPOM;
import licensePerformer.LiPerformerPOM;
import licenseReviewer.LiReviewerPOM;
import litigationPerformer.performerPOM;
import login.webpage;

public class DeptHeadMethod  extends webpage
{
	private static List<WebElement> elementsList = null;
	public static WebDriver driver = null;		
	public static XSSFSheet ReadExcel() throws IOException
	{
		
		String workingDir = System.getProperty("user.dir");
		fis = new FileInputStream(workingDir+"//TestData//ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving second sheet of Workbook
		return sheet;
	}
	public static void DeptActiveLicense( ExtentTest test, String type) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(), 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive()));
		String active=MethodPOM.clickActive().getText();
		
	     int activelicense = Integer.parseInt(active);	//Reading Active count.

	      MethodPOM.clickActive().click();					//Clicking on 'Active' image
	      Thread.sleep(5000);
	        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(5000);
			
			MethodPOM.clickReadActive().click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive().getText();	//Reading total items String value
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
			Thread.sleep(5000);
			MethodPOM.ClickActiveOverview().click();
			  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
			  {
				  //Switching to iFrame.
			 String OverviewPopup = MethodPOM.OverviewDesc().getText();
				Thread.sleep(3000);
			  if(MethodPOM.OverviewDesc().isDisplayed())
					  {
						  test.log(LogStatus.PASS, "License Overview Details Successfully");
					  }
					  else
					  {
						  test.log(LogStatus.FAIL, "License Overview Details Not Opened");
					  }
			  Thread.sleep(3000);
			 getDriver() .switchTo().parentFrame();
			  MethodPOM.ClickCloseOverview().click();
			   Thread.sleep(5000);
				
				          js1.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
							
						  Thread.sleep(10000);
							CFOcountPOM.readTotalItems1().click();
							
							String item2 = CFOcountPOM.readTotalItems1().getText();
							//String NoRecord = LiReviewerPOM.reNorecord.getText();
							 if(!item2.equalsIgnoreCase("No items to display")) 
							 {
							String[] bits1 = item2.split(" ");								//Splitting the String
							String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
							int count2 = Integer.parseInt(compliancesCount1);
							String NoRecord = LiReviewerPOM.reNorecord().getText();
							   if(!NoRecord.equalsIgnoreCase("No items to display")) 
							 {
								   try
									{
										performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
									}
									catch(Exception e)
									{
										
									}
									js1.executeScript("window.scrollBy(0,1000)");
									
								
									Thread.sleep(100);
									File dir = new File("C://Users//deepalid//Downloads");
									File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
									
									Thread.sleep(500);
									CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
									Thread.sleep(250);
									licenseManagement.licmgmtPOM.WorkspaceExport().click();
									//performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
									
									
									Thread.sleep(500);
									File dir1 = new File("C://Users//deepalid//Downloads");
									File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
									
									if(dirContents.length < allFilesNew.length)
									{
										test.log(LogStatus.PASS, "File downloaded successfully.");
										
										File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
									    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
									    {
									       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
									       {
									           lastModifiedFile = allFilesNew[i];
									       }
									    }
										
										Thread.sleep(100);
										fis = new FileInputStream(lastModifiedFile);
										workbook = new XSSFWorkbook(fis);
										sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
										
										int no = sheet.getLastRowNum();
										Row row = sheet.getRow(no);
										org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
										int records =(int) c1.getNumericCellValue();
										fis.close();
										
										if(count2 == records)
										{
											//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
											test.log(LogStatus.PASS, "For "+type+" Active License total records from Grid = "+count2+" | Total records from Report = "+records);
										}
										else
										{
											//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
											test.log(LogStatus.FAIL, "For "+type+" Active License  total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
										}
									}
									else
									{
										test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
									}
							 }
				          
				          MethodPOM.clickMyDashboard().click();
				          Thread.sleep(1000);
							  }
							  else
							  {
								   		      
								test.log(LogStatus.PASS,"No Record Found");
								MethodPOM.clickMyDashboard().click();
									      
							  }
			  }
			  

}

public static void DeptExpiringLicense( ExtentTest test, String type) throws InterruptedException, IOException
{		
	WebDriverWait wait = new WebDriverWait( getDriver(), 20);
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring()));
	String Expiring=MethodPOM.clickExpiring().getText();
	
     int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.

      MethodPOM.clickExpiring().click();					//Clicking on 'Expiring' image
      Thread.sleep(4000);
        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
		js1.executeScript("window.scroll(0,500)");
		Thread.sleep(4000);
		
		MethodPOM.clickReadExpiring().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = MethodPOM.clickReadExpiring().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String LicenseExpiringCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
		
		//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
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
			
			MethodPOM.ClickActiveOverview().click();
			 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
			  {
				  //Switching to iFrame.
			 String OverviewPopup = MethodPOM.OverviewDesc().getText();
				Thread.sleep(3000);
			  if(MethodPOM.OverviewDesc().isDisplayed())
					  {
						  test.log(LogStatus.PASS, " License Overview Details Successfully");
					  }
					  else
					  {
						  test.log(LogStatus.FAIL, " License Overview Details Not Opened");
					  }
			  Thread.sleep(3000);
			 getDriver() .switchTo().parentFrame();
			MethodPOM.ClickCloseOverview().click();
			
					  Thread.sleep(10000);
						CFOcountPOM.readTotalItems1().click();
						
						String item2 = CFOcountPOM.readTotalItems1().getText();
						//String NoRecord = LiReviewerPOM.reNorecord.getText();
						 if(!item2.equalsIgnoreCase("No items to display")) 
						 {
						String[] bits1 = item2.split(" ");								//Splitting the String
						String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
						int count2 = Integer.parseInt(compliancesCount1);
						String NoRecord = LiReviewerPOM.reNorecord().getText();
						   if(!NoRecord.equalsIgnoreCase("No items to display")) 
						 {
							   try
								{
									performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
								}
								catch(Exception e)
								{
									
								}
								js1.executeScript("window.scrollBy(0,1000)");
								
							
								Thread.sleep(100);
								File dir = new File("C://Users//deepalid//Downloads");
								File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
								Thread.sleep(500);
								CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
								Thread.sleep(250);
								licenseManagement.licmgmtPOM.WorkspaceExport().click();
								//performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
								
								
								Thread.sleep(500);
								File dir1 = new File("C://Users//deepalid//Downloads");
								File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
								
								if(dirContents.length < allFilesNew.length)
								{
									test.log(LogStatus.PASS, "File downloaded successfully.");
									
									File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
								    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
								    {
								       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
								       {
								           lastModifiedFile = allFilesNew[i];
								       }
								    }
									
									Thread.sleep(100);
									fis = new FileInputStream(lastModifiedFile);
									workbook = new XSSFWorkbook(fis);
									sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
									
									int no = sheet.getLastRowNum();
									Row row = sheet.getRow(no);
									org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
									int records =(int) c1.getNumericCellValue();
									fis.close();
									
									if(count2 == records)
									{
										//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
										test.log(LogStatus.PASS, "For "+type+" Expiring License  total records from Grid = "+count2+" | Total records from Report = "+records);
									}
									else
									{
										//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
										test.log(LogStatus.FAIL, "For "+type+" Expiring License  total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
									}
								}
								else
								{
									test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
								}
						 }
			          
			          MethodPOM.clickMyDashboard().click();
			          Thread.sleep(1000);
						  }
						  else
						  {
							   		      
							test.log(LogStatus.PASS,"No Record Found");
							MethodPOM.clickMyDashboard().click();
								      
						  }
			        
			  }
}
public static void DeptExpiredLicense( ExtentTest test, String type) throws InterruptedException, IOException
{
  WebDriverWait wait = new WebDriverWait( getDriver(), 20);
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired()));
	String Expired=MethodPOM.clickExpired().getText();
	
     int Expiredlicense = Integer.parseInt(Expired);	//Reading Expired count.

      MethodPOM.clickExpired().click();					//Clicking on 'Expired' image
      Thread.sleep(4000);
        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
		js1.executeScript("window.scroll(0,500)");
		Thread.sleep(4000);
		
		MethodPOM.clickReadExpired().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = MethodPOM.clickReadExpired().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String LicenseExpiredCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
		
		//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
		int total = Integer.parseInt(LicenseExpiredCount);
		if(Expiredlicense == total)
			{
				//test.log(LogStatus.PASS, "Number of Expired License  grid matches to Dashboard Expired  License   Count.");
				test.log(LogStatus.PASS, "No of Expired  License  in the grid = "+total+" | Dashboard Expired License  Count = "+Expiredlicense);
			}
			else
			{
				//test.log(LogStatus.FAIL, "Number of Expired License does not matches to Dashboard Expired License   Count.");
				test.log(LogStatus.FAIL, "No of Expired License  in the grid = "+total+" | Dashboard Expired License  Count = "+Expiredlicense);
			}
			Thread.sleep(3000);
			//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
			//Thread.sleep(3000);
			
			MethodPOM.ClickActiveOverview().click();
			 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
			  {
				  //Switching to iFrame.
			 String OverviewPopup = MethodPOM.OverviewDesc().getText();
				Thread.sleep(3000);
			  if(MethodPOM.OverviewDesc().isDisplayed())
					  {
						  test.log(LogStatus.PASS, " License Overview Details Successfully");
					  }
					  else
					  {
						  test.log(LogStatus.FAIL, " License Overview Details Not Opened");
					  }
			  Thread.sleep(3000);
			 getDriver() .switchTo().parentFrame();
			Thread.sleep(3000);
			MethodPOM.ClickCloseOverview().click();
			Thread.sleep(3000);
			
			          js1.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
						
					  Thread.sleep(10000);
						CFOcountPOM.readTotalItems1().click();
						
						String item2 = CFOcountPOM.readTotalItems1().getText();
						//String NoRecord = LiReviewerPOM.reNorecord.getText();
						 if(!item2.equalsIgnoreCase("No items to display")) 
						 {
						String[] bits1 = item2.split(" ");								//Splitting the String
						String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
						int count2 = Integer.parseInt(compliancesCount1);
						String NoRecord = LiReviewerPOM.reNorecord().getText();
						   if(!NoRecord.equalsIgnoreCase("No items to display")) 
						 {
							   try
								{
									performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
								}
								catch(Exception e)
								{
									
								}
								js1.executeScript("window.scrollBy(0,1000)");
								
							
								Thread.sleep(100);
								File dir = new File("C://Users//deepalid//Downloads");
								File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
								Thread.sleep(500);
								CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
								Thread.sleep(250);
								licenseManagement.licmgmtPOM.WorkspaceExport().click();
								//performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
								
								
								Thread.sleep(500);
								File dir1 = new File("C://Users//deepalid//Downloads");
								File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
								
								if(dirContents.length < allFilesNew.length)
								{
									test.log(LogStatus.PASS, "File downloaded successfully.");
									
									File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
								    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
								    {
								       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
								       {
								           lastModifiedFile = allFilesNew[i];
								       }
								    }
									
									Thread.sleep(100);
									fis = new FileInputStream(lastModifiedFile);
									workbook = new XSSFWorkbook(fis);
									sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
									
									int no = sheet.getLastRowNum();
									Row row = sheet.getRow(no);
									org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
									int records =(int) c1.getNumericCellValue();
									fis.close();
									
									if(count2 == records)
									{
										//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
										test.log(LogStatus.PASS, "For "+type+" Expired License  total records from Grid = "+count2+" | Total records from Report = "+records);
									}
									else
									{
										//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
										test.log(LogStatus.FAIL, "For "+type+" Expired License  total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
									}
								}
								else
								{
									test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
								}
						 }
			          
			          MethodPOM.clickMyDashboard().click();
			          Thread.sleep(1000);
						  }
						  else
						  {
							   		      
							test.log(LogStatus.PASS,"No Record Found");
							MethodPOM.clickMyDashboard().click();
								      
						  }
			  }
}

public static void DeptAppliedLicense( ExtentTest test, String type) throws InterruptedException, IOException
{
	 WebDriverWait wait = new WebDriverWait( getDriver(), 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickApplied()));
		String Applied=MethodPOM.clickApplied().getText();
		
	     int Appliedlicense = Integer.parseInt(Applied);	//Reading Applied count.

	      MethodPOM.clickApplied().click();					//Clicking on 'Applied' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadApplied().click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadApplied().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseAppliedCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicenseAppliedCount);
			if(Appliedlicense == total)
				{
					//test.log(LogStatus.PASS, "Number of Applied License  grid matches to Dashboard Applied  License   Count.");
					test.log(LogStatus.PASS, "No of Applied  License  in the grid = "+total+" | Dashboard Applied License  Count = "+Appliedlicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Applied License does not matches to Dashboard Applied License   Count.");
					test.log(LogStatus.FAIL, "No of Applied License  in the grid = "+total+" | Dashboard Applied License  Count = "+Appliedlicense);
				}
				Thread.sleep(3000);
				MethodPOM.ClickActiveOverview().click();
				 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
				  {
					  //Switching to iFrame.
				 String OverviewPopup = MethodPOM.OverviewDesc().getText();
					Thread.sleep(3000);
				  if(MethodPOM.OverviewDesc().isDisplayed())
						  {
							  test.log(LogStatus.PASS, " License Overview Details Successfully");
						  }
						  else
						  {
							  test.log(LogStatus.FAIL, " License Overview Details Not Opened");
						  }
				  Thread.sleep(3000);
				 getDriver() .switchTo().parentFrame();
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview().click();
				Thread.sleep(5000);
				
				          js1.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
							
						  Thread.sleep(10000);
							CFOcountPOM.readTotalItems1().click();
							
							String item2 = CFOcountPOM.readTotalItems1().getText();
							 if(!item2.equalsIgnoreCase("No items to display")) 
							 {
							String[] bits1 = item2.split(" ");								//Splitting the String
							String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
							int count2 = Integer.parseInt(compliancesCount1);
							String NoRecord = LiReviewerPOM.reNorecord().getText();
							   if(!NoRecord.equalsIgnoreCase("No items to display")) 
							 {
								   try
									{
										performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
									}
									catch(Exception e)
									{
										
									}
									js1.executeScript("window.scrollBy(0,1000)");
									
								
									Thread.sleep(100);
									File dir = new File("C://Users//deepalid//Downloads");
									File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
									
									Thread.sleep(500);
									CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
									Thread.sleep(250);
									licenseManagement.licmgmtPOM.WorkspaceExport().click();
									//performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
									
									
									Thread.sleep(500);
									File dir1 = new File("C://Users//deepalid//Downloads");
									File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
									
									if(dirContents.length < allFilesNew.length)
									{
										test.log(LogStatus.PASS, "File downloaded successfully.");
										
										File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
									    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
									    {
									       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
									       {
									           lastModifiedFile = allFilesNew[i];
									       }
									    }
										
										Thread.sleep(100);
										fis = new FileInputStream(lastModifiedFile);
										workbook = new XSSFWorkbook(fis);
										sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
										
										int no = sheet.getLastRowNum();
										Row row = sheet.getRow(no);
										org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
										int records =(int) c1.getNumericCellValue();
										fis.close();
										
										if(count2 == records)
										{
											//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
											test.log(LogStatus.PASS, "For "+type+" Applied License  total records from Grid = "+count2+" | Total records from Report = "+records);
										}
										else
										{
											//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
											test.log(LogStatus.FAIL, "For "+type+" Applied License total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
										}
									}
									else
									{
										test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
									}
							 }
				          
				          MethodPOM.clickMyDashboard().click();
				          Thread.sleep(1000);
							  }
							  else
							  {
								   		      
								test.log(LogStatus.PASS,"No Record Found");
								MethodPOM.clickMyDashboard().click();
									      
							  }
				  }
}
public static void deptpendingforreviewLicense( ExtentTest test, String type) throws InterruptedException, IOException
{
	 WebDriverWait wait = new WebDriverWait( getDriver(), 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickpendingforreview()));
		String PendingForReview=MethodPOM.clickpendingforreview().getText();
		
	     int pendingforreviewlicense = Integer.parseInt(PendingForReview);	//Reading Pending For Review count.

	      MethodPOM.clickpendingforreview().click();					//Clicking on 'Pending For Review ' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadpendingforreview().click();					//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickReadpendingforreview().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicensependingforreviewCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicensependingforreviewCount);
			if(pendingforreviewlicense == total)
				{
				//	test.log(LogStatus.PASS, "Number of PendingForReview License  grid matches to Dashboard PendingForReview  License   Count.");
					test.log(LogStatus.PASS, "No of Pending For Review  License  in the grid = "+total+" | Dashboard Pending For Review License  Count = "+pendingforreviewlicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of PendingForReview License does not matches to Dashboard PendingForReview License   Count.");
					test.log(LogStatus.FAIL, "No of Pending For Review License  in the grid = "+total+" | Dashboard Pending For Review License  Count = "+pendingforreviewlicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview().click();
				 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
				  {
					  //Switching to iFrame.
				 String OverviewPopup = MethodPOM.OverviewDesc().getText();
					Thread.sleep(3000);
				  if(MethodPOM.OverviewDesc().isDisplayed())
						  {
							  test.log(LogStatus.PASS, " License Overview Details Successfully");
						  }
						  else
						  {
							  test.log(LogStatus.FAIL, " License Overview Details Not Opened");
						  }
				  Thread.sleep(3000);
				 getDriver() .switchTo().parentFrame();
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview().click();
				 Thread.sleep(10000);
				 js1.executeScript("window.scroll(0,1000)");
					CFOcountPOM.readTotalItems1().click();
					
					String item2 = CFOcountPOM.readTotalItems1().getText();
					//String NoRecord = LiReviewerPOM.reNorecord.getText();
					 if(!item2.equalsIgnoreCase("No items to display")) 
					 {
					String[] bits1 = item2.split(" ");								//Splitting the String
					String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
					int count2 = Integer.parseInt(compliancesCount1);
					String NoRecord = LiReviewerPOM.reNorecord().getText();
					   if(!NoRecord.equalsIgnoreCase("No items to display")) 
					 {
						   try
							{
								performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
							}
							catch(Exception e)
							{
								
							}
							js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							licenseManagement.licmgmtPOM.WorkspaceExport().click();
							//performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
							
							
							Thread.sleep(500);
							File dir1 = new File("C://Users//deepalid//Downloads");
							File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
							
							if(dirContents.length < allFilesNew.length)
							{
								test.log(LogStatus.PASS, "File downloaded successfully.");
								
								File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
							    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
							    {
							       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
							       {
							           lastModifiedFile = allFilesNew[i];
							       }
							    }
								
								Thread.sleep(100);
								fis = new FileInputStream(lastModifiedFile);
								workbook = new XSSFWorkbook(fis);
								sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
								
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
								fis.close();
								
								if(count2 == records)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" Pending For Review License total records from Grid = "+count2+" | Total records from Report = "+records);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" Pending For Review License total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		          MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }
						  }
				Thread.sleep(5000);
				
}
public static void DeptRejectedLicense( ExtentTest test, String type) throws InterruptedException, IOException
{
	   WebDriverWait wait = new WebDriverWait( getDriver(), 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickRejected()));
		String Rejected=MethodPOM.clickRejected().getText();
		
	     int RejectedLicense = Integer.parseInt(Rejected);	//Reading Rejected count.

	      MethodPOM.clickRejected().click();					//Clicking on 'Rejected ' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadRejected().click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadRejected().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicensRejected = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicensRejected);
			if(RejectedLicense == total)
				{
					//test.log(LogStatus.PASS, "Number of Rejected License  grid matches to Dashboard Rejected  License   Count.");
					test.log(LogStatus.PASS, "No of Rejected  License  in the grid = "+total+" | Dashboard Rejected License  Count = "+RejectedLicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Rejected License does not matches to Dashboard Rejected License   Count.");
					test.log(LogStatus.FAIL, "No of Rejected License  in the grid = "+total+" | Dashboard Rejected License  Count = "+RejectedLicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview().click();
				 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
				  {
					  //Switching to iFrame.
				 String OverviewPopup = MethodPOM.OverviewDesc().getText();
					Thread.sleep(3000);
				  if(MethodPOM.OverviewDesc().isDisplayed())
						  {
							  test.log(LogStatus.PASS, " License Overview Details Successfully");
						  }
						  else
						  {
							  test.log(LogStatus.FAIL, " License Overview Details Not Opened");
						  }
				  Thread.sleep(3000);
				 getDriver() .switchTo().parentFrame();
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview().click();
				Thread.sleep(3000);
				
				          js1.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
							
						  Thread.sleep(10000);
							CFOcountPOM.readTotalItems1().click();
							
							String item2 = CFOcountPOM.readTotalItems1().getText();
							//String NoRecord = LiReviewerPOM.reNorecord.getText();
							 if(!item2.equalsIgnoreCase("No items to display")) 
							 {
							String[] bits1 = item2.split(" ");								//Splitting the String
							String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
							int count2 = Integer.parseInt(compliancesCount1);
							String NoRecord = LiReviewerPOM.reNorecord().getText();
							   if(!NoRecord.equalsIgnoreCase("No items to display")) 
							 {
								   try
									{
										performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
									}
									catch(Exception e)
									{
										
									}
									js1.executeScript("window.scrollBy(0,1000)");
									
								
									Thread.sleep(100);
									File dir = new File("C://Users//deepalid//Downloads");
									File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
									
									Thread.sleep(500);
									CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
									Thread.sleep(250);
									licenseManagement.licmgmtPOM.WorkspaceExport().click();
									//performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
									
									
									Thread.sleep(500);
									File dir1 = new File("C://Users//deepalid//Downloads");
									File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
									
									if(dirContents.length < allFilesNew.length)
									{
										test.log(LogStatus.PASS, "File downloaded successfully.");
										
										File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
									    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
									    {
									       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
									       {
									           lastModifiedFile = allFilesNew[i];
									       }
									    }
										
										Thread.sleep(100);
										fis = new FileInputStream(lastModifiedFile);
										workbook = new XSSFWorkbook(fis);
										sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
										
										int no = sheet.getLastRowNum();
										Row row = sheet.getRow(no);
										org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
										int records =(int) c1.getNumericCellValue();
										fis.close();
										
										if(count2 == records)
										{
											//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
											test.log(LogStatus.PASS, "For "+type+" Rejected License total records from Grid = "+count2+" | Total records from Report = "+records);
										}
										else
										{
											//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
											test.log(LogStatus.FAIL, "For "+type+" Rejected License total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
										}
									}
									else
									{
										test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
									}
							 }
				          
				          MethodPOM.clickMyDashboard().click();
				          Thread.sleep(1000);
							  }
							  else
							  {
								   		      
								test.log(LogStatus.PASS,"No Record Found");
								MethodPOM.clickMyDashboard().click();
									      
							  }
				  }
}

public static void DeptTerminateLicense( ExtentTest test, String type) throws InterruptedException, IOException
{
	  
		   
	   WebDriverWait wait = new WebDriverWait( getDriver(), 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickTerminate()));
		String Terminate=MethodPOM.clickTerminate().getText();
		
	     int TerminateLicense = Integer.parseInt(Terminate);	//Reading Terminate count.

	      MethodPOM.clickTerminate().click();					//Clicking on 'Terminate ' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadTerminate().click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadTerminate().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicensTerminate= bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicensTerminate);
			if(TerminateLicense == total)
				{
					//test.log(LogStatus.PASS, "Number of Terminate License  grid matches to Dashboard Terminate  License   Count.");
					test.log(LogStatus.PASS, "No of Terminate  License  in the grid = "+total+" | Dashboard Terminate License  Count = "+TerminateLicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Terminate License does not matches to Dashboard Terminate License   Count.");
					test.log(LogStatus.FAIL, "No of Terminate License  in the grid = "+total+" | Dashboard Terminate License  Count = "+TerminateLicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview().click();
				Thread.sleep(3000);
				 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
				  {
					  //Switching to iFrame.
				 String OverviewPopup = MethodPOM.OverviewDesc().getText();
					Thread.sleep(3000);
				  if(MethodPOM.OverviewDesc().isDisplayed())
						  {
							  test.log(LogStatus.PASS, " License Overview Details Successfully");
						  }
						  else
						  {
							  test.log(LogStatus.FAIL, " License Overview Details Not Opened");
						  }
				  Thread.sleep(3000);
				 getDriver() .switchTo().parentFrame();
				  Thread.sleep(3000);
			   	MethodPOM.ClickCloseOverview().click();
				   Thread.sleep(3000);
			          js1.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
						
					  Thread.sleep(10000);
						CFOcountPOM.readTotalItems1().click();
						
						String item2 = CFOcountPOM.readTotalItems1().getText();
						//String NoRecord = LiReviewerPOM.reNorecord.getText();
						 if(!item2.equalsIgnoreCase("No items to display")) 
						 {
						String[] bits1 = item2.split(" ");								//Splitting the String
						String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
						int count2 = Integer.parseInt(compliancesCount1);
						String NoRecord = LiReviewerPOM.reNorecord().getText();
						   if(!NoRecord.equalsIgnoreCase("No items to display")) 
						 {
							   try
								{
									performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
								}
								catch(Exception e)
								{
									
								}
								js1.executeScript("window.scrollBy(0,1000)");
								
							
								Thread.sleep(100);
								File dir = new File("C://Users//deepalid//Downloads");
								File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
								Thread.sleep(500);
								CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
								Thread.sleep(250);
								licenseManagement.licmgmtPOM.WorkspaceExport().click();
								//performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
								
								
								Thread.sleep(500);
								File dir1 = new File("C://Users//deepalid//Downloads");
								File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
								
								if(dirContents.length < allFilesNew.length)
								{
									test.log(LogStatus.PASS, "File downloaded successfully.");
									
									File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
								    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
								    {
								       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
								       {
								           lastModifiedFile = allFilesNew[i];
								       }
								    }
									
									Thread.sleep(100);
									fis = new FileInputStream(lastModifiedFile);
									workbook = new XSSFWorkbook(fis);
									sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
									
									int no = sheet.getLastRowNum();
									Row row = sheet.getRow(no);
									org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
									int records =(int) c1.getNumericCellValue();
									fis.close();
									
									if(count2 == records)
									{
										//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
										test.log(LogStatus.PASS, "For "+type+" Terminate License total records from Grid = "+count2+" | Total records from Report = "+records);
									}
									else
									{
										//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
										test.log(LogStatus.FAIL, "For "+type+" Terminate License total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
									}
								}
								else
								{
									test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
								}
						 }
			          
			          MethodPOM.clickMyDashboard().click();
			          Thread.sleep(1000);
						  }
						  else
						  {
							   		      
							test.log(LogStatus.PASS,"No Record Found");
							MethodPOM.clickMyDashboard().click();
								      
						  }
                  
				
				//MethodPOM.clickMyDashboard().click();
				  }
}

public static void DeptLicenseExpiredOnStatutory( ExtentTest test, String type) throws InterruptedException
{
	   Thread.sleep(3000);
	   
	   MethodPOM.ClickMaximizeLicenseExpiredOn().click();
	   test.log(LogStatus.PASS, "Expired Maximize Button Working Successfully");
	   Thread.sleep(3000);
	   JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
		js1.executeScript("window.scroll(0,500)");
     DeptmethodPOM.deptClickExportExpiredOn().click();
     test.log(LogStatus.PASS, "Dashboard Expired On License List Downloaded Successfully");
      Thread.sleep(3000);
         DeptmethodPOM.clickshowmoredept().click();
	 	  Thread.sleep(3000);
	 	   test.log(LogStatus.PASS, "ExpiredOn Show More link working Successfully");
	   WebDriverWait wait = new WebDriverWait( getDriver(), 40);
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
	   Thread.sleep(5000);
	   MethodPOM.ClickExportExpiredOn().click();
		test.log(LogStatus.PASS, "Expired License List Downloaded Successfully");
			Thread.sleep(7000);
				MethodPOM.ClickOverviewExpiredOn().click();
		
		  test.log(LogStatus.PASS, " License Overview Details Successfully");
		  Thread.sleep(7000);
        MethodPOM.clickBystatuscloseoverview().click();
			Thread.sleep(2000);
			
			  // Js.executeScript("window.scrollBy(500,0)");
		//	.switchTo().parentFrame();
			// MethodPOM.clickCloseGraphPopup().click();
			// Thread.sleep(7000);
			
			 LiPerformerPOM.EntityLocation().click();
				Thread.sleep(500);
			  LiPerformerPOM.EntityLocationExpand().click();
				//Thread.sleep(500);
			   //  LiPerformerPOM.Entitysubexpand().click();
			   //Thread.sleep(500);
				DeptmethodPOM.selectLocation().click();
				Thread.sleep(500);
			   String locationtext1 =LiPerformerPOM.locget().getText();
			   LiPerformerPOM.locget().click();
			   Thread.sleep(3000);
			   LiPerformerPOM.clicklictypet().click();
			   Thread.sleep(500);
			   String LicenseType1 =LiPerformerPOM.Licensetype().getText();
			   Thread.sleep(5000);
			   LiPerformerPOM.Licensetype().click();
			   Thread.sleep(5000);
			  // LiPerformerPOM.Statustext().click();
			  // Thread.sleep(5000);
			  
			    List<String> li=new ArrayList<String>();
			    
			    li.add(locationtext1);
			    li.add(LicenseType1);
			 
			    Thread.sleep(3000);
			    
				List<String> filter=new ArrayList<String>();	
				filter.add("Location");
				filter.add("LicenseType");	
				
				JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
				js.executeScript("window.scrollBy(0,150)");	
				Thread.sleep(3000);

				CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
				String s = CFOcountPOM.readTotalItems1().getText();
				Thread.sleep(2000);

				if(!s.equalsIgnoreCase("No items to display")) 
				{
				Thread.sleep(5000);

				List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[1]"));
				
				List<WebElement> liccol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
				//List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
				Thread.sleep(2000);

				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement> raw=new ArrayList<WebElement>();

						if(i==0)
						{
							raw.addAll(entitycol);
						}
					else if(i==1)
						{
							raw.addAll(liccol);
						}
					
						
					for(int k=0;k<raw.size();k++)
						{
							text.add(raw.get(k).getText());
						}

						for(int l=0;l<text.size();l++)
							{
						if(text.get(l).equals(li.get(i)))
							{
								pass.add(text.get(l));	
								System.out.println("pass : "+text.get(l)+" : "+li.get(i));

							}
						else
						{
							fail.add(text.get(l));		
							System.out.println("fail : "+text.get(l)+" : "+li.get(i));
							System.out.println(i);

						}
						 }
				 
			for(String Fal : fail)
				 {
						test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
				 }	
				 for(String Pas : pass)
				 {
					 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
						test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
						System.out.println(filter.get(i)+" : "+Pas);
			 }
				 text.clear();
				pass.clear();
				fail.clear();
				raw.clear();
				
				
				}
	   }
	   else
	   {
			test.log(LogStatus.PASS,"Selected Location and License Type No Record Found");
	   }

Boolean  btnclear =LiPerformerPOM.clearbtn().isEnabled();
if(btnclear) 
{
	 LiPerformerPOM.clearbtn().click();
	 test.log(LogStatus.PASS,"Clear Button Working Successfully");
}
else
{
	 test.log(LogStatus.FAIL,"Clear Button Not Clickable");
}

	
	   }

public static void deptLicenseExpiringOnStatutory( ExtentTest test, String type) throws InterruptedException, IOException
{
	   Thread.sleep(5000);
	   MethodPOM.ClickMaximizeLicenseExpiringOn().click();
	   Thread.sleep(3000);
	   test.log(LogStatus.PASS, "Expiring On Maximize Button Working Successfully");
	 
	   JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
		js1.executeScript("window.scroll(0,500)");
		  Thread.sleep(3000);
		MethodPOM.DashExpiringOnExportcmd().click();
		test.log(LogStatus.PASS, "Dashboard Expiring License Download Successfully");
		 Thread.sleep(3000);
		DeptmethodPOM.deptClickShowMoreExpiringOn().click();
		 test.log(LogStatus.PASS, "ExpiredOn Show More link working Successfully");
	   Thread.sleep(7000);
	   WebDriverWait wait = new WebDriverWait( getDriver(), 40);
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
	   
		MethodPOM.ClickOverviewExpiredOn().click();
		test.log(LogStatus.PASS, "Expiring OverView License Displayed");
		 Thread.sleep(3000);
          MethodPOM.clickBystatuscloseoverview().click();
			 Thread.sleep(2000);
		
	  Thread.sleep(3000);
	   
	   MethodPOM.ClickExportExpiredOn().click();
		
	   int flag = 0;
		try
		{
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.checkTable1()));	//Waiting until records table gets visible.
			flag = 1;
		}
		catch(Exception e)
		{
			
		}
		
		if(flag == 1)
		{
			js1.executeScript("window.scrollBy(0,1000)");				//Scrolling down window by 2000 px.
			
			Thread.sleep(700);
			String item = MethodPOM.clickReadActive().getText();
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count = 0;
			if(LicenseCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2500);
				item = MethodPOM.clickReadActive().getText();
				bits = item.split(" ");										//Splitting the String
				LicenseCount = bits[bits.length - 2];					//Getting the second last word (total number of users)
			}
			count = Integer.parseInt(LicenseCount);
			
			File dir = new File("C://Users//deepalid//Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			js1.executeScript("window.scrollBy(0,-2000)");				//Scrolling down window by 2000 px.
			Thread.sleep(500);
			MethodPOM.ClickExportExpiredOn().click();						//Clicking on Excel Image.
			
			Thread.sleep(3000);
			File dir1 = new File("C://Users//deepalid//Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, type+" :- File downloaded successfully.");
				
				fis = new FileInputStream(lastModifiedFile);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				int no = sheet.getLastRowNum();
				int SheetRecords = no - 0;						//Sheet have extra 5 lines of information at top (But row count started from 0, so -4)
				fis.close();
				
				if(count == SheetRecords)
				{
					//test.log(LogStatus.PASS, "Count of records displayed from grid matches to number records in Excel Sheet.");
					//test.log(LogStatus.PASS, "Total records from grid = "+count+" | Total records in Excel Sheet = "+SheetRecords);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Count of records displayed from grid doesn't matches to number records in Excel Sheet.");
					//test.log(LogStatus.FAIL, "Total records from grid = "+count+" | Total records in Excel Sheet = "+SheetRecords);
				}
			}
			else
			{
				test.log(LogStatus.FAIL, type+" :- File doesn't downloaded successfully.");
			}
		}
		else
		{
			test.log(LogStatus.PASS, type+" :- Records not displayed (available). Excel sheet didn't downloaded");
		}
		
		 LiPerformerPOM.EntityLocation().click();
		 Thread.sleep(3000);
		 LiPerformerPOM.EntityLocationExpand().click();
		 Thread.sleep(5000);
			DeptmethodPOM.selectLocation().click();
			Thread.sleep(500);
		   String locationtext1 =LiPerformerPOM.locget().getText();
		   LiPerformerPOM.locget().click();
		   Thread.sleep(3000);
		   LiPerformerPOM.clicklictypet().click();
		   Thread.sleep(500);
		   String LicenseType1 =LiPerformerPOM.Licensetype().getText();
		   Thread.sleep(5000);
		   LiPerformerPOM.Licensetype().click();
		   Thread.sleep(5000);
		  // LiPerformerPOM.Statustext().click();
		  // Thread.sleep(5000);
		  
		    List<String> li=new ArrayList<String>();
		    
		    li.add(locationtext1);
		    li.add(LicenseType1);
		 
		    Thread.sleep(3000);
		    
			List<String> filter=new ArrayList<String>();	
			filter.add("Location");
			filter.add("LicenseType");	
			
			JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
			js.executeScript("window.scrollBy(0,150)");	
			Thread.sleep(3000);

			CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
			String s = CFOcountPOM.readTotalItems1().getText();
			Thread.sleep(2000);

			if(!s.equalsIgnoreCase("No items to display")) 
			{
			Thread.sleep(5000);

			List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[1]"));
			
			List<WebElement> liccol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
			//List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
			Thread.sleep(2000);

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();

					if(i==0)
					{
						raw.addAll(entitycol);
					}
				else if(i==1)
					{
						raw.addAll(liccol);
					}
				
					
				for(int k=0;k<raw.size();k++)
					{
						text.add(raw.get(k).getText());
					}

					for(int l=0;l<text.size();l++)
						{
					if(text.get(l).equals(li.get(i)))
						{
							pass.add(text.get(l));	
							System.out.println("pass : "+text.get(l)+" : "+li.get(i));

						}
					else
					{
						fail.add(text.get(l));		
						System.out.println("fail : "+text.get(l)+" : "+li.get(i));
						System.out.println(i);

					}
					 }
			 
		for(String Fal : fail)
			 {
					test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
			 }	
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
					test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
					System.out.println(filter.get(i)+" : "+Pas);
		 }
			 text.clear();
			pass.clear();
			fail.clear();
			raw.clear();
			
			
			}
}
else
{
		test.log(LogStatus.PASS,"Selected Location and License Type No Record Found");
}

Boolean  btnclear =LiPerformerPOM.clearbtn().isEnabled();
if(btnclear) 
{
LiPerformerPOM.clearbtn().click();
test.log(LogStatus.PASS,"Clear Button Working Successfully");
}
else
{
test.log(LogStatus.FAIL,"Clear Button Not Clickable");
}

}
public  static void DeptMyworkspaceaddLicense(ExtentTest test, String type) throws InterruptedException, IOException
{

	 
	 licmgmtPOM.ClickMyWorkspace().click();

     WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	 Thread.sleep(3000);
	 
	 /*WebElement select_dropdownlist = driver.findElement(By.xpath("//*[@id='MainContentCW']/div[2]/span/span/span[1]"));
	   licmgmtPOM.drplocationclick().click();
		Thread.sleep(500);
		
		licmgmtPOM.Customerexpand().click();
		Thread.sleep(6000);
	LiPerformerPOM.EntityLocation().click();
		Thread.sleep(500);
       LiPerformerPOM.EntityLocation().click();
Thread.sleep(500);
MethodPOM.Newlocation().click();
//LiPerformerPOM.aa().click();
Thread.sleep(500);
//LiPerformerPOM.EntityLocationExpand().click();
//Thread.sleep(500);
Thread.sleep(500);
MethodPOM.Newlocationsub().click();
//LiPerformerPOM.aa1().click();
Thread.sleep(500);
	   
	 //  getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[11]")).click();
	  // //LiPerformerPOM.aa1().click();
		   Thread.sleep(5000);
		   String locationtext1 =LiPerformerPOM.locget().getText();
		   Thread.sleep(5000);
		   LiPerformerPOM.locgetworkspace().click();
		   Thread.sleep(3000);
		   LiPerformerPOM.workspacestatus().click();
		   Thread.sleep(3000);
		   String wrkstatus=LiPerformerPOM.selectstatus1().getText();
		   Thread.sleep(5000);
		   LiPerformerPOM.selectstatus1().click();
		   Thread.sleep(3000);
		  
		 /*  LiPerformerPOM.worklicedrop().click();
		   Thread.sleep(3000);
		   String selectlictype=LiPerformerPOM.selectworkdroplic.getText();
		   LiPerformerPOM.selectworkdroplic().click();
		   
		    List<String> li=new ArrayList<String>();
		    
		    li.add(locationtext1);
		    li.add(wrkstatus);
		   /// li.add(selectlictype);
		 
		    Thread.sleep(3000);
		    
			List<String> filter=new ArrayList<String>();	
			filter.add("Location");
			filter.add("Status");
			//filter.add("LicenseType");	
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,150)");	
			Thread.sleep(3000);

			CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
			String s = CFOcountPOM.readTotalItems1().getText();
			Thread.sleep(2000);

			if(!s.equalsIgnoreCase("No items to display")) 
			{
			Thread.sleep(5000);

			List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[1]"));
			
			List<WebElement> Statuscol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[12]"));
			
			
			Thread.sleep(2000);

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();

					if(i==0)
					{
						raw.addAll(entitycol);
					}
				else if(i==1)
					{
					raw.addAll(Statuscol);							//raw.addAll(liccol);
					}
				
					
				for(int k=0;k<raw.size();k++)
					{
						text.add(raw.get(k).getText());
					}

					for(int l=0;l<text.size();l++)
						{
					if(text.get(l).equals(li.get(i)))
						{
							pass.add(text.get(l));	
							System.out.println("pass : "+text.get(l)+" : "+li.get(i));

						}
					else
					{
						fail.add(text.get(l));		
						System.out.println("fail : "+text.get(l)+" : "+li.get(i));
						System.out.println(i);

					}
					 }
			 
		for(String Fal : fail)
			 {
					test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
			 }	
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
					test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
					System.out.println(filter.get(i)+" : "+Pas);
		 }
			 text.clear();
			pass.clear();
			fail.clear();
			raw.clear();
			
			
			}
}
else
{
		test.log(LogStatus.PASS,"Selected Location and License Type No Record Found");
}

Boolean  btnclear =LiPerformerPOM.clearbtn().isEnabled();
if(btnclear) 
{
LiPerformerPOM.clearbtn().click();
test.log(LogStatus.PASS,"Clear Button Working Successfully");
}
else
{
test.log(LogStatus.FAIL,"Clear Button Not Clickable");
}

 
	 if(type.equalsIgnoreCase("Internal"))
	 {

           WebDriverWait wait1 = new WebDriverWait( getDriver(), (30));
			wait1.until(ExpectedConditions.visibilityOf(licmgmtPOM.Type2()));
			licmgmtPOM.Type2().click();				//Clicking on 'Type' drop down.
			
			licmgmtPOM.internalType2().click();
			
	licmgmtPOM.Perstatus().click();
	 Thread.sleep(5000);	
	 licmgmtPOM.wrkselectstatus().click();	 
	 Thread.sleep(3000);	
	licmgmtPOM.wrklicensetypefiler().click();
	Thread.sleep(000);
	licmgmtPOM.wrkselectlicensetype().click();
	Thread.sleep(5000);
	
	licmgmtPOM.workspaceclear().click();
	 test.log(LogStatus.PASS,"Clear Button Working successfully" );
	Thread.sleep(5000);
	
	 licmgmtPOM.WorkspaceExport().click();
	 test.log(LogStatus.PASS,"License Details Export" );
	 Thread.sleep(3000);	

	         Thread.sleep(7000);
	        // licmgmtPOM.CloseOverview().click();
		        Thread.sleep(7000);
	         test.log(LogStatus.PASS,"License Overview Details Button Working Successfully " );
	     //    Thread.sleep(7000);
	        
       
	
	 }

	 else
	 {
		 /*licmgmtPOM.wrkstatusfiler().click();
		 Thread.sleep(3000);	
		 licmgmtPOM.wrkselectstatus().click();
		 
		 Thread.sleep(3000);	
		//licmgmtPOM.wrklicensetypefiler().click();
	//	Thread.sleep(3000);
		//licmgmtPOM.wrkselectlicensetype().click();
		Thread.sleep(5000);
		licmgmtPOM.workspaceclear().click();
		 test.log(LogStatus.PASS,"Clear Button Working successfully" );
		Thread.sleep(5000);
		*/
		 licmgmtPOM.WorkspaceExport().click();
		 test.log(LogStatus.PASS,"License Details Export" );
		 Thread.sleep(3000);	
		
		         licmgmtPOM.Overviewworkspace().click();
		         Thread.sleep(3000);
		         test.log(LogStatus.PASS,"License Overview Details Button Working Successfully " );
		       
	 }


public static void DeptMyDocuments( ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), 20);
		
	
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired()));
		
		LiPerformerPOM.clickMyDocuments().click();		//Clicking on 'My Documents'
		Thread.sleep(3000);
		LiPerformerPOM.clickMyDocumentsMenu().click();	//Clicking on 'My Documents'
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1()));	//Waiting until records table gets visible.
		
		if(type.equalsIgnoreCase("Internal"))
		{


          WebDriverWait wait1 = new WebDriverWait( getDriver(), (30));
            wait1.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1()));	//Waiting until records table gets visible.
			Thread.sleep(3000);
			 JavascriptExecutor js2=(JavascriptExecutor)  getDriver() ;
				js2.executeScript("window.scroll(1000,0)");
			LiPerformerPOM.clickType2().click();			//Clicking on 'Type' drop down.
			Thread.sleep(5000);
			LiPerformerPOM.selectInternal().click();//Selecting 'Internal' option.
			Thread.sleep(5000);
			Thread.sleep(5000);
			File dir = new File("C:\\Users\\deepalid\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			Thread.sleep(5000);
			MethodPOM.DownloadDocument().click();
			
			Thread.sleep(5000);
	       
			File dir1 = new File("C:\\Users\\deepalid\\Downloads");
			File[] dirContents1 = dir1.listFiles();							//Counting number of files in directory after download
			Thread.sleep(5000);
			if(dirContents.length < dirContents1.length)
			{
				test.log(LogStatus.PASS, "File downloaded successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			
			
			Thread.sleep(7000);
			
			MethodPOM.ViewDocument().click();
			
			test.log(LogStatus.PASS, "Document View successfully.");
			
			Thread.sleep(3000);
			MethodPOM.closeViewDocument().click();
			Thread.sleep(3000);
		
		/* if(type.equalsIgnoreCase("Internal"))
			{
				LiPerformerPOM.Clicklictypedropdown().click();
				Thread.sleep(3000);
				LiPerformerPOM.searchlic1in().click();
			}
		 else
			{
			*/
			LiPerformerPOM.Multicheckdoc1().click();
			Thread.sleep(3000);
			LiPerformerPOM.Multicheckdoc2().click();
			
			
			File dir2 = new File("C:\\Users\\deepalid\\Downloads");
			File[] dirContents2 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(500);
			LiPerformerPOM.MultiDownload().click();		//Exporting (Downloading) file
			
			Thread.sleep(3000);
			File dir3 = new File("C:\\Users\\deepalid\\Downloads");
			File[] allFilesNew = dir3.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(500);
	       if(dirContents2.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, " Multipal  File downloaded successfully.");	
			}	else
			{
				test.log(LogStatus.FAIL, " File does not downloaded.");
			}
			
			
			   Thread.sleep(3000);
			   MethodPOM.Documentstatusclick().click();
			   Thread.sleep(3000);
			   String Documentstatus =MethodPOM.Documentselectstatus().getText();
			   Thread.sleep(3000);
			   MethodPOM.Documentselectstatus().click();
			   Thread.sleep(3000);
			  
			   MethodPOM.Documentlictypeclick().click();
			   Thread.sleep(500);
			   
			   String LicenseType1 =MethodPOM.Documentlictypeselectin().getText();
			   Thread.sleep(5000);
			   MethodPOM.Documentlictypeselectin().click();
			   Thread.sleep(5000);
			  // LiPerformerPOM.Statustext().click();
			  // Thread.sleep(5000);
			  
			    List<String> li=new ArrayList<String>();
			    li.add(Documentstatus);
			    //li.add(locationtext1);
			    li.add(LicenseType1);
			 
			    Thread.sleep(3000);
			    
				List<String> filter=new ArrayList<String>();	
				filter.add("Status");
				//filter.add("Location");
				filter.add("LicenseType");	
				
				JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
				js.executeScript("window.scrollBy(0,150)");	
				Thread.sleep(3000);

				CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
				String s = CFOcountPOM.readTotalItems1().getText();
				Thread.sleep(2000);

				if(!s.equalsIgnoreCase("No items to display")) 
				{
				Thread.sleep(5000);

				//List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[1]"));
				List<WebElement>statuscol=getDriver().findElements(By.xpath("//*[@id=\"grid\"]/div[3]/table/tbody/tr/td[11]"));
				
				List<WebElement> liccol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
				//List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
				Thread.sleep(2000);

				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement> raw=new ArrayList<WebElement>();

						if(i==0)
						{
							raw.addAll(statuscol);
						}
					else if(i==1)
						{
							raw.addAll(liccol);
						}
					
						
					for(int k=0;k<raw.size();k++)
						{
							text.add(raw.get(k).getText());
						}

						for(int l=0;l<text.size();l++)
							{
						if(text.get(l).equals(li.get(i)))
							{
								pass.add(text.get(l));	
								System.out.println("pass : "+text.get(l)+" : "+li.get(i));

							}
						else
						{
							fail.add(text.get(l));		
							System.out.println("fail : "+text.get(l)+" : "+li.get(i));
							System.out.println(i);

						}
						 }
				 
			for(String Fal : fail)
				 {
						test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
				 }	
				 for(String Pas : pass)
				 {
					 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
						test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
						System.out.println(filter.get(i)+" : "+Pas);
			 }
				 text.clear();
				pass.clear();
				fail.clear();
				raw.clear();

				}
				

				   }
				   else
				   {
						test.log(LogStatus.PASS,"Selected Location and License Type No Record Found");
				   }
			
			Boolean  btnclear =LiPerformerPOM.clearbtn().isEnabled();
		     if(btnclear) 
		     {
		    	 LiPerformerPOM.clearbtn().click();
		    	 test.log(LogStatus.PASS,"Clear Button Working Successfully");
		     }
		     else
		     {
		    	 test.log(LogStatus.FAIL,"Clear Button Not Clickable");
		     }
			   }
		     else
		     {
		Thread.sleep(5000);
		File dir = new File("C:\\Users\\deepalid\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		Thread.sleep(5000);
		MethodPOM.DownloadDocument().click();
		
		Thread.sleep(5000);
     
		File dir1 = new File("C:\\Users\\deepalid\\Downloads");
		File[] dirContents1 = dir1.listFiles();							//Counting number of files in directory after download
		Thread.sleep(5000);
		if(dirContents.length < dirContents1.length)
		{
			test.log(LogStatus.PASS, "File downloaded successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
		
		
		Thread.sleep(7000);
		
		MethodPOM.ViewDocument().click();
		
		test.log(LogStatus.PASS, "Document View successfully.");
		
		Thread.sleep(3000);
		MethodPOM.closeViewDocument().click();
		Thread.sleep(3000);
	
	/* if(type.equalsIgnoreCase("Internal"))
		{
			LiPerformerPOM.Clicklictypedropdown().click();
			Thread.sleep(3000);
			LiPerformerPOM.searchlic1in().click();
		}
	 else
		{
		*/
		LiPerformerPOM.Multicheckdoc1().click();
		Thread.sleep(3000);
		LiPerformerPOM.Multicheckdoc2().click();
		
		
		File dir2 = new File("C:\\Users\\deepalid\\Downloads");
		File[] dirContents2 = dir2.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		LiPerformerPOM.MultiDownload().click();		//Exporting (Downloading) file
		
		Thread.sleep(3000);
		File dir3 = new File("C:\\Users\\deepalid\\Downloads");
		File[] allFilesNew = dir3.listFiles();						//Counting number of files in directory after download
		
		Thread.sleep(500);
     if(dirContents2.length < allFilesNew.length)
		{
			test.log(LogStatus.PASS, " Multipal  File downloaded successfully.");	
		}	else
		{
			test.log(LogStatus.FAIL, " File does not downloaded.");
		}
		
		   Thread.sleep(3000);
		   MethodPOM.Documentstatusclick().click();
		   Thread.sleep(3000);
		   String Documentstatus =MethodPOM.Documentselectstatus().getText();
		   Thread.sleep(5000);
		   MethodPOM.Documentselectstatus().click();
		   Thread.sleep(3000);
		  
		   MethodPOM.Documentlictypeclick().click();
		   Thread.sleep(500);
		   
		   String LicenseType1 =MethodPOM.Documentlictypeselect().getText();
		   Thread.sleep(5000);
		   MethodPOM.Documentlictypeselect().click();
		   Thread.sleep(5000);
		  // LiPerformerPOM.Statustext().click();
		  // Thread.sleep(5000);
		  
		    List<String> li=new ArrayList<String>();
		    li.add(Documentstatus);
		    //li.add(locationtext1);
		    li.add(LicenseType1);
		 
		    Thread.sleep(3000);
		    
			List<String> filter=new ArrayList<String>();	
			filter.add("Status");
			//filter.add("Location");
			filter.add("LicenseType");	
			
			JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
			js.executeScript("window.scrollBy(0,150)");	
			Thread.sleep(3000);

			CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
			String s = CFOcountPOM.readTotalItems1().getText();
			Thread.sleep(2000);

			if(!s.equalsIgnoreCase("No items to display")) 
			{
			Thread.sleep(5000);

			//List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[1]"));
			List<WebElement>statuscol=getDriver().findElements(By.xpath("//*[@id=\"grid\"]/div[3]/table/tbody/tr/td[11]"));
			
			List<WebElement> liccol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
			//List<WebElement> Actcol=getDriver().findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
			Thread.sleep(2000);

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();

					if(i==0)
					{
						raw.addAll(statuscol);
					}
				else if(i==1)
					{
						raw.addAll(liccol);
					}
				
					
				for(int k=0;k<raw.size();k++)
					{
						text.add(raw.get(k).getText());
					}

					for(int l=0;l<text.size();l++)
						{
					if(text.get(l).equals(li.get(i)))
						{
							pass.add(text.get(l));	
							System.out.println("pass : "+text.get(l)+" : "+li.get(i));

						}
					else
					{
						fail.add(text.get(l));		
						System.out.println("fail : "+text.get(l)+" : "+li.get(i));
						System.out.println(i);

					}
					 }
			 
		for(String Fal : fail)
			 {
					test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
			 }	
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
					test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
					System.out.println(filter.get(i)+" : "+Pas);
		 }
			 text.clear();
			pass.clear();
			fail.clear();
			raw.clear();

			}
			

			   }
			   else
			   {
					test.log(LogStatus.PASS,"Selected Location and License Type No Record Found");
			   }
		
		Boolean  btnclear =LiPerformerPOM.clearbtn().isEnabled();
	     if(btnclear) 
	     {
	    	 LiPerformerPOM.clearbtn().click();
	    	 test.log(LogStatus.PASS,"Clear Button Working Successfully");
	     }
	     else
	     {
	    	 test.log(LogStatus.FAIL,"Clear Button Not Clickable");
	     
		}
		
		     }
	}
public static void DeptReports( ExtentTest test, String type) throws InterruptedException, IOException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	
	wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired()));
	
	LiPerformerPOM.clickMyReport().click();		//Clicking on 'My Reports'
	Thread.sleep(5000);
	progress();
   
	if(type.equalsIgnoreCase("Internal"))
	{
		LiPerformerPOM.clickType2().click();			//Clicking on 'Type' drop down.
		Thread.sleep(500);
		LiPerformerPOM.selectInternal().click();//Selecting 'Internal' option.
		Thread.sleep(1000);
		LiPerformerPOM.Reportapply().click();
		progress();
		Thread.sleep(5000);

	}

getDriver().findElement(By.xpath("//*[@id='exportReport']")).click();
	
	test.log(LogStatus.PASS," License Report  Downloaded Successfully.");
	
	Thread.sleep(7000);
	 getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]")).click();

	test.log(LogStatus.PASS," License Overview  Button Working Successfully");
      Thread.sleep(3000);
getDriver().findElement(By.xpath("//*[@id='divShowReminderDialog']/div/div/div[1]/button")).click();
	
	CheckReports( test, 1 , "Active");
	 Thread.sleep(1000);
	CheckReports(test, 2, "Expired");
	 Thread.sleep(1000);
	CheckReports( test, 3, "Expiring");
	 Thread.sleep(1000);
	CheckReports( test, 4, "Applied");
	 Thread.sleep(1000);
	CheckReports( test, 5, "Applied but Pending for Renewal");
	 Thread.sleep(1000);
	CheckReports( test, 6, "Renewed");
	 Thread.sleep(1000);
	CheckReports( test, 7, "Rejected");
	 Thread.sleep(1000);
	CheckReports( test, 8, "Registered");
	 Thread.sleep(1000);
	CheckReports( test, 9, "Registered & Renewal Filed");
	 Thread.sleep(1000);
	CheckReports(test, 10, "Validity Expired");
	 Thread.sleep(1000);
	CheckReports( test, 11, "Terminate");
	
	Thread.sleep(500);


}
public static void CheckReports( ExtentTest test, int status, String type) throws InterruptedException, IOException
{		
	
	
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,-1000)");
	
	LiPerformerPOM.clickStatus1().click();			//Clicking on 'Status' drop down.
	Thread.sleep(5000);
	//elementsList = LiPerformerPOM.selectStatus1();	//Selecting Status.
	//Thread.sleep(3000);
	//elementsList.get(status).click();
	List<WebElement>roc = getDriver().findElements(By.xpath("(//*[@class='k-item'])"));
	selectOptionFromDropDown_bs(roc, type);
	
	LiPerformerPOM.reportapplybtn().click();
	
	Thread.sleep(3000);
	
	Thread.sleep(1000);
	progress();
	
	int flag = 0;
	try
	{
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1()));	//Waiting until records table gets visible.
		flag = 1;
	}
	catch(Exception e)
	{
		
	}
	
	if(flag == 1)
	{
		js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
		
		  Thread.sleep(10000);
			CFOcountPOM.readTotalItems1().click();
			
			String item1 = CFOcountPOM.readTotalItems1().getText();
			//String NoRecord = LiReviewerPOM.reNorecord.getText();
			 if(!item1.equalsIgnoreCase("No items to display")) 
			 {
			String[] bits1 = item1.split(" ");								//Splitting the String
			String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
			int count2 = Integer.parseInt(compliancesCount1);
			String NoRecord = LiReviewerPOM.reNorecord().getText();
			   if(!NoRecord.equalsIgnoreCase("No items to display")) 
			 {
				   try
					{
						performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
					}
					catch(Exception e)
					{
						
					}
					js.executeScript("window.scrollBy(0,1000)");
					
				
					Thread.sleep(100);
					File dir = new File("C://Users//deepalid//Downloads");
					File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
					
					Thread.sleep(500);
					CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
					Thread.sleep(250);
					performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
					
					
					Thread.sleep(500);
					File dir1 = new File("C://Users//deepalid//Downloads");
					File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
					
					if(dirContents.length < allFilesNew.length)
					{
						test.log(LogStatus.PASS, "File downloaded successfully.");
						
						File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
					    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
					    {
					       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
					       {
					           lastModifiedFile = allFilesNew[i];
					       }
					    }
						
						Thread.sleep(100);
						fis = new FileInputStream(lastModifiedFile);
						workbook = new XSSFWorkbook(fis);
						sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
						
						int no = sheet.getLastRowNum();
						Row row = sheet.getRow(no);
						Cell c1 = row.getCell(0);
						int records =(int) c1.getNumericCellValue();
						fis.close();
						
						if(count2 == records)
						{
							//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
							test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+records);
						}
						else
						{
							//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
							test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
					}
			 }
					else
					{
						  test.log(LogStatus.PASS, "Expired On Popup No Record Found ");
					}
			 }
	}
	
	}
public static void DeptActiveInternalLicense( ExtentTest test, String type) throws InterruptedException, IOException
{	
	Thread.sleep(3000);
	  licenseCompanyadmin.MethodPOM.AllFilter().click();
	   Thread.sleep(3000);
	   licenseCompanyadmin.MethodPOM.InternalFilter().click();
	   
	   licenseCompanyadmin.MethodPOM.ClickApply().click();
WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		
//	WebDriverWait wait = new WebDriverWait(driver, 120);
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive()));
	String active=MethodPOM.clickActive().getText();
	
     int activelicense = Integer.parseInt(active);	//Reading Active count.

      MethodPOM.clickActive().click();					//Clicking on 'Active' image
      	Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickTabelGrid()));
        JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
		js1.executeScript("window.scroll(0,800)");
       
		//Thread.sleep(8000);
	
		licmgmtPOM.clickReadActive().click();					//Clicking on total items count
		Thread.sleep(4000);
		String item = licmgmtPOM.clickReadActive().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
		
		//int total = Integer.parseInt(MethodPOM.clickReadActive.getText());
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
			
			MethodPOM.ClickActiveOverview().click();
			test.log(LogStatus.PASS, "Activer License Overview Details Sucessfully");
			Thread.sleep(3000);
			MethodPOM.ClickCloseOverview().click();
			Thread.sleep(3000);
			   js1.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
				
				  Thread.sleep(10000);
					CFOcountPOM.readTotalItems1().click();
					
					String item2 = CFOcountPOM.readTotalItems1().getText();
					//String NoRecord = LiReviewerPOM.reNorecord.getText();
					 if(!item2.equalsIgnoreCase("No items to display")) 
					 {
					String[] bits1 = item2.split(" ");								//Splitting the String
					String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
					int count2 = Integer.parseInt(compliancesCount1);
					String NoRecord = LiReviewerPOM.reNorecord().getText();
					   if(!NoRecord.equalsIgnoreCase("No items to display")) 
					 {
						   try
							{
								performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
							}
							catch(Exception e)
							{
								
							}
							js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							licenseManagement.licmgmtPOM.WorkspaceExport().click();
							//performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
							
							
							Thread.sleep(500);
							File dir1 = new File("C://Users//deepalid//Downloads");
							File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
							
							if(dirContents.length < allFilesNew.length)
							{
								test.log(LogStatus.PASS, "File downloaded successfully.");
								
								File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
							    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
							    {
							       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
							       {
							           lastModifiedFile = allFilesNew[i];
							       }
							    }
								
								Thread.sleep(100);
								fis = new FileInputStream(lastModifiedFile);
								workbook = new XSSFWorkbook(fis);
								sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
								
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
								fis.close();
								
								if(count2 == records)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" Active License total records from Grid = "+count2+" | Total records from Report = "+records);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" Active License  total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		          MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }
	  }

public static void DeptExpiringInternalLicense( ExtentTest test, String type) throws InterruptedException, IOException
{		
	Thread.sleep(3000);
	  licenseCompanyadmin.MethodPOM.AllFilter().click();
	   Thread.sleep(3000);
	   licenseCompanyadmin.MethodPOM.InternalFilter().click();
	   
	   licenseCompanyadmin.MethodPOM.ClickApply().click();


WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		
Thread.sleep(3000);
  licenseCompanyadmin.MethodPOM.AllFilter().click();
   Thread.sleep(3000);
   licenseCompanyadmin.MethodPOM.InternalFilter().click();
   
   licenseCompanyadmin.MethodPOM.ClickApply().click();

	//WebDriverWait wait = new WebDriverWait(driver, 20);
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring()));
	String Expiring=MethodPOM.clickExpiring().getText();
	
     int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.

      MethodPOM.clickExpiring().click();					//Clicking on 'Expiring' image
      Thread.sleep(4000);
 
      JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
		js1.executeScript("window.scroll(0,500)");
		Thread.sleep(4000);
		String item1 = MethodPOM.clickReadExpired().getText();	//Reading total items String value
		
      if(!item1.equalsIgnoreCase("No items to display"))
      {
    	  // JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadExpiring().click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadExpiring().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseExpiringCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive.getText());
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
				
				MethodPOM.ClickActiveOverview().click();
				test.log(LogStatus.PASS, "Expiring License Overview Details Sucessfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview().click();
				Thread.sleep(3000);
				js1.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
				
				  Thread.sleep(10000);
					CFOcountPOM.readTotalItems1().click();
					
					String item2 = CFOcountPOM.readTotalItems1().getText();
					//String NoRecord = LiReviewerPOM.reNorecord.getText();
					 if(!item2.equalsIgnoreCase("No items to display")) 
					 {
					String[] bits1 = item2.split(" ");								//Splitting the String
					String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
					int count2 = Integer.parseInt(compliancesCount1);
					String NoRecord = LiReviewerPOM.reNorecord().getText();
					   if(!NoRecord.equalsIgnoreCase("No items to display")) 
					 {
						   try
							{
								performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
							}
							catch(Exception e)
							{
								
							}
							js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							licenseManagement.licmgmtPOM.WorkspaceExport().click();
							//performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
							
							
							Thread.sleep(500);
							File dir1 = new File("C://Users//deepalid//Downloads");
							File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
							
							if(dirContents.length < allFilesNew.length)
							{
								test.log(LogStatus.PASS, "File downloaded successfully.");
								
								File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
							    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
							    {
							       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
							       {
							           lastModifiedFile = allFilesNew[i];
							       }
							    }
								
								Thread.sleep(100);
								fis = new FileInputStream(lastModifiedFile);
								workbook = new XSSFWorkbook(fis);
								sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
								
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
								fis.close();
								
								if(count2 == records)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+records);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		          MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
      }
      else
      {
	
			test.log(LogStatus.PASS,"No Record Found");
			MethodPOM.clickMyDashboard().click();
			
      }
      }
}
public static void DeptExpiredInternalLicense( ExtentTest test, String type) throws InterruptedException, IOException
{	
  Thread.sleep(3000);
  licenseCompanyadmin.MethodPOM.AllFilter().click();
   Thread.sleep(3000);
   licenseCompanyadmin.MethodPOM.InternalFilter().click();
   
   licenseCompanyadmin.MethodPOM.ClickApply().click();
  
WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired()));
	String Expired=MethodPOM.clickExpired().getText();
	
     int Expiredlicense = Integer.parseInt(Expired);	//Reading Expired count.

      MethodPOM.clickExpired().click();					//Clicking on 'Expired' image
      Thread.sleep(7000);
 
      wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickTabelGrid()));
      
      

	   JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
		js1.executeScript("window.scroll(0,500)");
		 Thread.sleep(7000);
		String item1 = MethodPOM.clickReadExpired().getText();	//Reading total items String value
		 Thread.sleep(7000);
      if(!item1.equalsIgnoreCase("No items to display"))
      {
    	//   JavascriptExecutor js=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadExpired().click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadExpired().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseExpiredCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive.getText());
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
				
				MethodPOM.ClickActiveOverview().click();
				test.log(LogStatus.PASS, " Expired License Overview Details Sucessfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview().click();
				Thread.sleep(3000);
				  js1.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
					
				  Thread.sleep(10000);
					CFOcountPOM.readTotalItems1().click();
					
					String item2 = CFOcountPOM.readTotalItems1().getText();
					//String NoRecord = LiReviewerPOM.reNorecord.getText();
					 if(!item2.equalsIgnoreCase("No items to display")) 
					 {
					String[] bits1 = item2.split(" ");								//Splitting the String
					String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
					int count2 = Integer.parseInt(compliancesCount1);
					String NoRecord = LiReviewerPOM.reNorecord().getText();
					   if(!NoRecord.equalsIgnoreCase("No items to display")) 
					 {
						   try
							{
								performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
							}
							catch(Exception e)
							{
								
							}
							js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							licenseManagement.licmgmtPOM.WorkspaceExport().click();
							//performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
							
							
							Thread.sleep(500);
							File dir1 = new File("C://Users//deepalid//Downloads");
							File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
							
							if(dirContents.length < allFilesNew.length)
							{
								test.log(LogStatus.PASS, "File downloaded successfully.");
								
								File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
							    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
							    {
							       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
							       {
							           lastModifiedFile = allFilesNew[i];
							       }
							    }
								
								Thread.sleep(100);
								fis = new FileInputStream(lastModifiedFile);
								workbook = new XSSFWorkbook(fis);
								sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
								
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
								fis.close();
								
								if(count2 == records)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+records);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		          MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }
      }
      else
      {
			test.log(LogStatus.PASS,"No record Found" );
			MethodPOM.clickMyDashboard().click();
			
      }
      
}
public static void DeptAppliedInternalLicense( ExtentTest test, String type) throws InterruptedException, IOException
{
	
	 Thread.sleep(3000);
	  licenseCompanyadmin.MethodPOM.AllFilter().click();
	   Thread.sleep(3000);
	   licenseCompanyadmin.MethodPOM.InternalFilter().click();
	   MethodPOM.clickDashlicensetype().click();
	   Thread.sleep(5000);
	   
	 //  MethodPOM.SearchInternalLicenseType().sendKeys("Annual Maintenance",Keys.ENTER);
	   licenseCompanyadmin.MethodPOM.ClickApply().click();
	   

		WebDriverWait wait = new WebDriverWait( getDriver(), 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickApplied()));
		String Applied=MethodPOM.clickApplied().getText();
		
	     int Appliedlicense = Integer.parseInt(Applied);	//Reading Applied count.

	      MethodPOM.clickApplied().click();					//Clicking on 'Applied' image
	      Thread.sleep(4000);
	 
	      wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickTabelGrid()));
	      
	      Thread.sleep(4000);

    	   JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			String item1 = MethodPOM.clickReadApplied().getText();	//Reading total items String value
			 Thread.sleep(7000);
	      if(!item1.equalsIgnoreCase("No items to display"))
	      {
	    	//   JavascriptExecutor js=(JavascriptExecutor)  getDriver() ;
				js1.executeScript("window.scroll(0,500)");
				Thread.sleep(4000);
				
				MethodPOM.clickReadApplied().click();					//Clicking on total items count
				Thread.sleep(500);
				String item = MethodPOM.clickReadApplied().getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String LicenseAppliedCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
				int total = Integer.parseInt(LicenseAppliedCount);
				if(Appliedlicense == total)
					{
						//test.log(LogStatus.PASS, "Number of Applied Internal  License  grid matches to Dashboard Applied Internal  License   Count.");
						test.log(LogStatus.PASS, "No of Applied Internal   License  in the grid = "+total+" | Dashboard Applied Internal  License  Count = "+Appliedlicense);
					}
					else
					{
						//test.log(LogStatus.FAIL, "Number of Applied Internal License does not matches to Dashboard Applied Internal  License   Count.");
						test.log(LogStatus.FAIL, "No of Applied Internal  License  in the grid = "+total+" | Dashboard Applied Internal  License  Count = "+Appliedlicense);
					}
					Thread.sleep(3000);
					//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
					//Thread.sleep(3000);
					
					MethodPOM.ClickActiveOverview().click();
					 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
					  {
						  //Switching to iFrame.
					 String OverviewPopup = MethodPOM.OverviewDesc().getText();
						Thread.sleep(3000);
					  if(MethodPOM.OverviewDesc().isDisplayed())
							  {
								  test.log(LogStatus.PASS, " License Overview Details Successfully");
							  }
							  else
							  {
								  test.log(LogStatus.FAIL, " License Overview Details Not Opened");
							  }
					  Thread.sleep(3000);
					 getDriver() .switchTo().parentFrame();
					Thread.sleep(3000);
					MethodPOM.ClickCloseOverview().click();
					Thread.sleep(5000);
					  js1.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
						
					  Thread.sleep(10000);
						CFOcountPOM.readTotalItems1().click();
						
						String item2 = CFOcountPOM.readTotalItems1().getText();
						//String NoRecord = LiReviewerPOM.reNorecord.getText();
						 if(!item2.equalsIgnoreCase("No items to display")) 
						 {
						String[] bits1 = item2.split(" ");								//Splitting the String
						String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
						int count2 = Integer.parseInt(compliancesCount1);
						String NoRecord = LiReviewerPOM.reNorecord().getText();
						   if(!NoRecord.equalsIgnoreCase("No items to display")) 
						 {
							   try
								{
									performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
								}
								catch(Exception e)
								{
									
								}
								js1.executeScript("window.scrollBy(0,1000)");
								
							
								Thread.sleep(100);
								File dir = new File("C://Users//deepalid//Downloads");
								File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
								Thread.sleep(500);
								CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
								Thread.sleep(250);
								licenseManagement.licmgmtPOM.WorkspaceExport().click();
								//performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
								
								
								Thread.sleep(500);
								File dir1 = new File("C://Users//deepalid//Downloads");
								File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
								
								if(dirContents.length < allFilesNew.length)
								{
									test.log(LogStatus.PASS, "File downloaded successfully.");
									
									File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
								    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
								    {
								       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
								       {
								           lastModifiedFile = allFilesNew[i];
								       }
								    }
									
									Thread.sleep(100);
									fis = new FileInputStream(lastModifiedFile);
									workbook = new XSSFWorkbook(fis);
									sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
									
									int no = sheet.getLastRowNum();
									Row row = sheet.getRow(no);
									org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
									int records =(int) c1.getNumericCellValue();
									fis.close();
									
									if(count2 == records)
									{
										//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
										test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+records);
									}
									else
									{
										//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
										test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
									}
								}
								else
								{
									test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
								}
						 }
			          
			          MethodPOM.clickMyDashboard().click();
			          Thread.sleep(1000);
						  }
						  else
						  {
							   		      
							test.log(LogStatus.PASS,"No Record Found");
							MethodPOM.clickMyDashboard().click();
								      
						  }
					
					  }	
	      }
	      else
	      {
				test.log(LogStatus.PASS,"No record Found" );
				MethodPOM.clickMyDashboard().click();
				
	      }
}    	
public static void DeptpendingforreviewInternalLicense( ExtentTest test, String type) throws InterruptedException, IOException
{
	 Thread.sleep(3000);
	  licenseCompanyadmin.MethodPOM.AllFilter().click();
	   Thread.sleep(3000);
	   licenseCompanyadmin.MethodPOM.InternalFilter().click();
	   
	   licenseCompanyadmin.MethodPOM.ClickApply().click();
	   
	   
	 WebDriverWait wait = new WebDriverWait( getDriver(), 20);
		

		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickpendingforreview()));
		String pendingforreviewlicense=MethodPOM.clickpendingforreview().getText();
		
	     int PendingForReviewlicense = Integer.parseInt(pendingforreviewlicense);	//Reading Expired count.

	      MethodPOM.clickpendingforreview().click();					//Clicking on 'Expired' image
	      Thread.sleep(4000);
	 
	      wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickTabelGrid()));
	      
	      Thread.sleep(4000);
    	   JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			String item1 = MethodPOM.clickReadpendingforreview().getText();	//Reading total items String value
		      Thread.sleep(7000);
	      if(!item1.equalsIgnoreCase("No items to display"))
	      {

	       // JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadpendingforreview().click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadpendingforreview().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicensependingforreviewCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicensependingforreviewCount);
			if(PendingForReviewlicense == total)
				{
					//test.log(LogStatus.PASS, "Number of PendingForReview Internal  License  grid matches to Dashboard PendingForReview Internal License   Count.");
					test.log(LogStatus.PASS, "No of PendingForReview Internal  License  in the grid = "+total+" | Dashboard PendingForReview Internal  License  Count = "+pendingforreviewlicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of PendingForReview Internal License does not matches to Dashboard PendingForReview Internal  License   Count.");
					test.log(LogStatus.FAIL, "No of PendingForReview Internal  License  in the grid = "+total+" | Dashboard PendingForReview Internal  License  Count = "+pendingforreviewlicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview().click();
				 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
				  {
					  //Switching to iFrame.
				 String OverviewPopup = MethodPOM.OverviewDesc().getText();
					Thread.sleep(3000);
				  if(MethodPOM.OverviewDesc().isDisplayed())
						  {
							  test.log(LogStatus.PASS, " License Overview Details Successfully");
						  }
						  else
						  {
							  test.log(LogStatus.FAIL, " License Overview Details Not Opened");
						  }
				  Thread.sleep(3000);
				 getDriver() .switchTo().parentFrame();
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview().click();
				  js1.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
					
				  Thread.sleep(10000);
					CFOcountPOM.readTotalItems1().click();
					
					String item2 = CFOcountPOM.readTotalItems1().getText();
					//String NoRecord = LiReviewerPOM.reNorecord.getText();
					 if(!item2.equalsIgnoreCase("No items to display")) 
					 {
					String[] bits1 = item2.split(" ");								//Splitting the String
					String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
					int count2 = Integer.parseInt(compliancesCount1);
					String NoRecord = LiReviewerPOM.reNorecord().getText();
					   if(!NoRecord.equalsIgnoreCase("No items to display")) 
					 {
						   try
							{
								performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
							}
							catch(Exception e)
							{
								
							}
							js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							licenseManagement.licmgmtPOM.WorkspaceExport().click();
							//performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
							
							
							Thread.sleep(500);
							File dir1 = new File("C://Users//deepalid//Downloads");
							File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
							
							if(dirContents.length < allFilesNew.length)
							{
								test.log(LogStatus.PASS, "File downloaded successfully.");
								
								File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
							    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
							    {
							       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
							       {
							           lastModifiedFile = allFilesNew[i];
							       }
							    }
								
								Thread.sleep(100);
								fis = new FileInputStream(lastModifiedFile);
								workbook = new XSSFWorkbook(fis);
								sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
								
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
								fis.close();
								
								if(count2 == records)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+records);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		          MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }
				
			
				MethodPOM.clickMyDashboard().click();
				
				  }	
	      }
				else
				{
					test.log(LogStatus.PASS,"No record Found" );
					MethodPOM.clickMyDashboard().click();
					}
				}
public static void DeptRejectedInternalLicense( ExtentTest test, String type) throws InterruptedException, IOException
{
	   Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter().click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply().click();
		   
	   WebDriverWait wait = new WebDriverWait( getDriver(), 40);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickRejected()));
		String Rejected=MethodPOM.clickRejected().getText();
		
	     int RejectedLicense = Integer.parseInt(Rejected);	//Reading Rejected count.

	      MethodPOM.clickRejected().click();					//Clicking on 'Rejected ' image
	      Thread.sleep(4000);
	      wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickTabelGrid()));
	        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(7000);
			String item1 = MethodPOM.clickReadpendingforreview().getText();	//Reading total items String value
			Thread.sleep(7000);
		      if(!item1.equalsIgnoreCase("No items to display"))
		      {
			
			MethodPOM.clickReadRejected().click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadRejected().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicensRejected = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicensRejected);
			if(RejectedLicense == total)
				{
					//test.log(LogStatus.PASS, "Number of Rejected Internal License  grid matches to Dashboard Rejected Internal License   Count.");
					test.log(LogStatus.PASS, "No of Rejected Internal License  in the grid = "+total+" | Dashboard Rejected Internal License  Count = "+RejectedLicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Rejected Internal  License does not matches to Dashboard Rejected Internal  License   Count.");
					test.log(LogStatus.FAIL, "No of Rejected Internal  License  in the grid = "+total+" | Dashboard Rejected Internal  License  Count = "+RejectedLicense);
				}
				Thread.sleep(3000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview().click();
				 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
				  {
					  //Switching to iFrame.
				 String OverviewPopup = MethodPOM.OverviewDesc().getText();
					Thread.sleep(3000);
				  if(MethodPOM.OverviewDesc().isDisplayed())
						  {
							  test.log(LogStatus.PASS, "License Overview Details Successfully");
						  }
						  else
						  {
							  test.log(LogStatus.FAIL, "License Overview Details Not Opened");
						  }
				  Thread.sleep(3000);
				 getDriver() .switchTo().parentFrame();
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview().click();
				  js1.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
					
				  Thread.sleep(10000);
					CFOcountPOM.readTotalItems1().click();
					
					String item2 = CFOcountPOM.readTotalItems1().getText();
					//String NoRecord = LiReviewerPOM.reNorecord.getText();
					 if(!item2.equalsIgnoreCase("No items to display")) 
					 {
					String[] bits1 = item2.split(" ");								//Splitting the String
					String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
					int count2 = Integer.parseInt(compliancesCount1);
					String NoRecord = LiReviewerPOM.reNorecord().getText();
					   if(!NoRecord.equalsIgnoreCase("No items to display")) 
					 {
						   try
							{
								performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
							}
							catch(Exception e)
							{
								
							}
							js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							licenseManagement.licmgmtPOM.WorkspaceExport().click();
							//performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
							
							
							Thread.sleep(500);
							File dir1 = new File("C://Users//deepalid//Downloads");
							File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
							
							if(dirContents.length < allFilesNew.length)
							{
								test.log(LogStatus.PASS, "File downloaded successfully.");
								
								File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
							    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
							    {
							       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
							       {
							           lastModifiedFile = allFilesNew[i];
							       }
							    }
								
								Thread.sleep(100);
								fis = new FileInputStream(lastModifiedFile);
								workbook = new XSSFWorkbook(fis);
								sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
								
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
								fis.close();
								
								if(count2 == records)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+records);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		          MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }
				  }
		      }
				else
				{
					test.log(LogStatus.PASS,"No record Found" );
					MethodPOM.clickMyDashboard().click();
					}
		      
}
public static void DeptTerminateInternalLicense( ExtentTest test, String type) throws InterruptedException, IOException
{
	   Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter().click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply().click();
	   WebDriverWait wait = new WebDriverWait( getDriver(), 20);
	   Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickTerminate()));
		String Terminate=MethodPOM.clickTerminate().getText();
		
	     int TerminateLicense = Integer.parseInt(Terminate);	//Reading Terminate count.
	 	Thread.sleep(5000);
	      MethodPOM.clickTerminate().click();					//Clicking on 'Terminate ' image
	      Thread.sleep(7000);
	      wait.until(ExpectedConditions.visibilityOf(licmgmtPOM.clickTabelGrid()));
	      Thread.sleep(7000);
	      String item1 = MethodPOM.clickReadpendingforreview().getText();	//Reading total items String value
			Thread.sleep(7000);
			
		      if(!item1.equalsIgnoreCase("No items to display"))
		      {
	        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(5000);
			
			MethodPOM.clickReadTerminate().click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadTerminate().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicensTerminate= bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicensTerminate);
			if(TerminateLicense == total)
				{
					//test.log(LogStatus.PASS, "Number of Terminate Internal License  grid matches to Dashboard Terminate Internal License   Count.");
					test.log(LogStatus.PASS, "No of Terminate Internal  License  in the grid = "+total+" | Dashboard Terminate Internal License  Count = "+TerminateLicense);
				}
				else
				{
				//	test.log(LogStatus.FAIL, "Number of Terminate Internal License does not matches to Dashboard Terminate Internal  License   Count.");
					test.log(LogStatus.FAIL, "No of Terminate Internal  License  in the grid = "+total+" | Dashboard Terminate Internal  License  Count = "+TerminateLicense);
				}
				Thread.sleep(5000);
				//js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
				//Thread.sleep(3000);
				
				MethodPOM.ClickActiveOverview().click();
				 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("APIOverView"));
				  {
					  //Switching to iFrame.
				 String OverviewPopup = MethodPOM.OverviewDesc().getText();
					Thread.sleep(3000);
				  if(MethodPOM.OverviewDesc().isDisplayed())
						  {
							  test.log(LogStatus.PASS, " License Overview Details Successfully");
						  }
						  else
						  {
							  test.log(LogStatus.FAIL, " License Overview Details Not Opened");
						  }
				  Thread.sleep(3000);
				 getDriver() .switchTo().parentFrame();
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview().click();
				 js1.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
					
				  Thread.sleep(10000);
					CFOcountPOM.readTotalItems1().click();
					
					String item2 = CFOcountPOM.readTotalItems1().getText();
					//String NoRecord = LiReviewerPOM.reNorecord.getText();
					 if(!item2.equalsIgnoreCase("No items to display")) 
					 {
					String[] bits1 = item2.split(" ");								//Splitting the String
					String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
					int count2 = Integer.parseInt(compliancesCount1);
					String NoRecord = LiReviewerPOM.reNorecord().getText();
					   if(!NoRecord.equalsIgnoreCase("No items to display")) 
					 {
						   try
							{
								performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
							}
							catch(Exception e)
							{
								
							}
							js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							licenseManagement.licmgmtPOM.WorkspaceExport().click();
							//performerPOM.clickExcelReport().click();					//Clicking on 'Excel Report' image.
							
							
							Thread.sleep(500);
							File dir1 = new File("C://Users//deepalid//Downloads");
							File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
							
							if(dirContents.length < allFilesNew.length)
							{
								test.log(LogStatus.PASS, "File downloaded successfully.");
								
								File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
							    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
							    {
							       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
							       {
							           lastModifiedFile = allFilesNew[i];
							       }
							    }
								
								Thread.sleep(100);
								fis = new FileInputStream(lastModifiedFile);
								workbook = new XSSFWorkbook(fis);
								sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
								
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
								fis.close();
								
								if(count2 == records)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+records);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+records);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		          MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }
				  }
				MethodPOM.clickMyDashboard().click();
		      }
		      else
					{
						test.log(LogStatus.PASS,"No record Found" );
						MethodPOM.clickMyDashboard().click();
						}
		   
		   }
public static  void DeptAssignedButNotActivated( ExtentTest test, String type) throws InterruptedException, IOException
{		                                   
	WebDriverWait wait = new WebDriverWait(getDriver(), (30));
	
	wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.AssignedButNotActivated()));
	String AssognedButNotActivated=LiPerformerPOM.AssignedButNotActivated().getText();
	
     int NotActivated = Integer.parseInt(AssognedButNotActivated);	//Reading Active count.

     LiPerformerPOM.AssignedButNotActivated().click();					//Clicking on 'Active' image
      Thread.sleep(5000);
        JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
		js1.executeScript("window.scroll(0,500)");
		Thread.sleep(5000);
		MethodPOM.clickReadActive().click();	
		String ite = MethodPOM.clickReadExpired().getText();	//Reading total items String value
		Thread.sleep(5000);
		if(!ite.equalsIgnoreCase("No items to display"))	
		{
	//	MethodPOM.clickReadActive.click();					//Clicking on total items count
		//Thread.sleep(500);
	//	String item1 = MethodPOM.clickReadActive.getText();	//Reading total items String value
		String[] bits = ite.split(" ");								//Splitting the String
		String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
		int total = Integer.parseInt(LicenseActiveCount);
		if(NotActivated == total)
			{
			//	test.log(LogStatus.PASS, "Number of Active License  grid matches to Dashboard Active License   Count.");
				test.log(LogStatus.PASS, "No of Assigned But Not Activated License  in the grid = "+total+" | Dashboard Assigned But Not Activated License  Count = "+NotActivated);
			}
			else
			{
				//test.log(LogStatus.FAIL, "Number of Active License does not matches to Dashboard Active License   Count.");
				test.log(LogStatus.FAIL, "No of Assigned But Not Activated License  in the grid = "+total+" | Dashboard Assigned But Not Activated License  Count = "+NotActivated);
			}
		Thread.sleep(5000);
		
		LiPerformerPOM.NotActivatedExport().click();
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		
		Thread.sleep(3000);
		
		
		progress();
		
	/*	int flag = 0;
		try
		{
			wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1));	//Waiting until records table gets visible.
			flag = 1;
		}
		catch(Exception e)
		{
			
		}
		
		if(flag == 1)
		{
			js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
			
			  Thread.sleep(10000);
			/*	CFOcountPOM.readTotalItems1.click();
				
				String item = CFOcountPOM.readTotalItems1.getText();
				//String NoRecord = LiReviewerPOM.reNorecord.getText();
				 if(!item.equalsIgnoreCase("No items to display")) 
				 {
				 
				//String[] bits1 = ite.split(" ");								//Splitting the String
				String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
				int count2 = Integer.parseInt(compliancesCount1);
				String NoRecord = LiReviewerPOM.reNorecord.getText();
				   if(!NoRecord.equalsIgnoreCase("No items to display")) 
				 {
					   try
						{
							performerPOM.clickExcelReport.sendKeys(Keys.PAGE_DOWN);
						}
						catch(Exception e)
						{
							
						}
						js.executeScript("window.scrollBy(0,1000)");
						
					*/
						Thread.sleep(100);
						File dir = new File("C://Users//deepalid//Downloads");
						File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(500);
						CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
						Thread.sleep(250);
						LiPerformerPOM.NotActivatedExport().click();				//Clicking on 'Excel Report' image.
						
						
						Thread.sleep(500);
						File dir1 = new File("C://Users//deepalid//Downloads");
						File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
						
						if(dirContents.length < allFilesNew.length)
						{
							test.log(LogStatus.PASS, "File downloaded successfully.");
							
							File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
						    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
						    {
						       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
						       {
						           lastModifiedFile = allFilesNew[i];
						       }
						    }
							
							Thread.sleep(100);
							fis = new FileInputStream(lastModifiedFile);
							workbook = new XSSFWorkbook(fis);
							sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
							
							int no = sheet.getLastRowNum();
							Row row = sheet.getRow(no);
							Cell c1 = row.getCell(0);
							int records =(int) c1.getNumericCellValue();
							fis.close();
							
							if(NotActivated == records)
							{
								//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
								test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+total+" | Total records from Report = "+records);
							}
							else
							{
								//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
								test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+total+" | Total records from Excel Sheet = "+records);
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
						}
		}
					else
						{
							test.log(LogStatus.PASS, "No Record Found");
						}
		

		MethodPOM.clickMyDashboard().click();
		
		Thread.sleep(500);
		LiPerformerPOM.AssignedButNotActivated().click();
		if(type.equalsIgnoreCase("Internal"))
		{
			WebDriverWait wait1 = new WebDriverWait( getDriver(), (30));
				wait1.until(ExpectedConditions.visibilityOf(licmgmtPOM.Type2()));
				licmgmtPOM.Type2().click();				//Clicking on 'Type' drop down.
				
				licmgmtPOM.internalType2().click();

		Thread.sleep(500);
   LiPerformerPOM.EntityLocation().click();
//Thread.sleep(5000);
/*LiPerformerPOM.EntityLocationExpand().click();
Thread.sleep(500);
//LiPerformerPOM.EntityLocationExpand.click();
//Thread.sleep(500);
Thread.sleep(500);
LiPerformerPOM.Entitysubexpand().click();
Thread.sleep(500);
String locationtext1 =LiPerformerPOM.checkloc().getText();
LiPerformerPOM.checkloc().click();
Thread.sleep(3000);
//LiPerformerPOM.ClickLictype.click();
// Thread.sleep(7000);
// String LicenseType1 =LiPerformerPOM.notactivatefilterin.getText();
Thread.sleep(7000);
// LiPerformerPOM.notactivatefilterin.click();
Thread.sleep(5000);

List<String> li=new ArrayList<String>();

li.add(locationtext1);
//li.add(LicenseType1);

Thread.sleep(3000);

List<String> filter=new ArrayList<String>();	
filter.add("Location");
//filter.add("LicenseType");	

JavascriptExecutor js = (JavascriptExecutor) getDriver();
js.executeScript("window.scrollBy(0,150)");	
Thread.sleep(3000);

CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
String s = CFOcountPOM.readTotalItems1().getText();
Thread.sleep(2000);

if(!s.equalsIgnoreCase("No items to display")) 
{
Thread.sleep(5000);

List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));

//List<WebElement> liccol=driver.findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[6]"));
//List<WebElement> Actcol=driver.findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
Thread.sleep(2000);

for(int i=0; i<li.size(); i++){
	
	List<String> text= new ArrayList<String>();
	HashSet<String> pass=new LinkedHashSet<>();
	HashSet<String> fail=new LinkedHashSet<>();
	List<WebElement> raw=new ArrayList<WebElement>();

		if(i==0)
		{
			raw.addAll(entitycol);
		}
	/*else if(i==1)
		{
			raw.addAll(liccol);
		}
	
		
	for(int k=0;k<raw.size();k++)
		{
			text.add(raw.get(k).getText());
		}

		for(int l=0;l<text.size();l++)
			{
		if(text.get(l).equals(li.get(i)))
			{
				pass.add(text.get(l));	
				System.out.println("pass : "+text.get(l)+" : "+li.get(i));

			}
		else
		{
			fail.add(text.get(l));		
			System.out.println("fail : "+text.get(l)+" : "+li.get(i));
			System.out.println(i);

		}
		 }
 
for(String Fal : fail)
 {
		test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
 }	
 for(String Pas : pass)
 {
	 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
	//	test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
		System.out.println(filter.get(i)+" : "+Pas);
}
 text.clear();
pass.clear();
fail.clear();
raw.clear();


}

*/
	   }
	   else
	   {
			test.log(LogStatus.PASS,"Selected Location and License Type No Record Found");
	   }

Boolean  btnclear =LiPerformerPOM.clearbtn().isEnabled();
 if(btnclear) 
 {
	 LiPerformerPOM.clearbtn().click();
	 test.log(LogStatus.PASS,"Clear Button Working Successfully");
 }
 else
 {
	 test.log(LogStatus.FAIL,"Clear Button Not Clickable");
 }


  wait.until(ExpectedConditions.elementToBeClickable(MethodPOM.clickMyDashboard()));
	
}

		/*else
		{			Thread.sleep(500);
		
		
			 LiPerformerPOM.EntityLocation().click();
				Thread.sleep(500);
				LiPerformerPOM.aa().click();
				Thread.sleep(500);
		   Thread.sleep(500);
		   String locationtext1 =LiPerformerPOM.checkloc().getText();
		   LiPerformerPOM.checkloc().click();
		   Thread.sleep(3000);
		   LiPerformerPOM.ClickLictype().click();
		   Thread.sleep(5000);
		   String LicenseType1 =LiPerformerPOM.notactivatefilter().getText();
		   Thread.sleep(5000);
		   LiPerformerPOM.notactivatefilter().click();
		   Thread.sleep(5000);
		 
		    List<String> li=new ArrayList<String>();
		    
		    li.add(locationtext1);
		    li.add(LicenseType1);
		 
		    Thread.sleep(3000);
		    
			List<String> filter=new ArrayList<String>();	
			filter.add("Location");
			filter.add("LicenseType");	
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,150)");	
			Thread.sleep(3000);

			CFOcountPOM.readTotalItems1().click();					//Clicking on Text of total items just to scroll down.
			String s = CFOcountPOM.readTotalItems1().getText();
			Thread.sleep(2000);

			if(!s.equalsIgnoreCase("No items to display")) 
			{
			Thread.sleep(5000);

			List<WebElement> entitycol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
			
			List<WebElement> liccol=getDriver().findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[6]"));
			//List<WebElement> Actcol=driver.findElements(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr/td[2]"));
			Thread.sleep(2000);

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();

					if(i==0)
					{
						raw.addAll(entitycol);
					}
				else if(i==1)
					{
						raw.addAll(liccol);
					}
				
					
				for(int k=0;k<raw.size();k++)
					{
						text.add(raw.get(k).getText());
					}

					for(int l=0;l<text.size();l++)
						{
					if(text.get(l).equals(li.get(i)))
						{
							pass.add(text.get(l));	
							System.out.println("pass : "+text.get(l)+" : "+li.get(i));

						}
					else
					{
						fail.add(text.get(l));		
						System.out.println("fail : "+text.get(l)+" : "+li.get(i));
						System.out.println(i);

					}
					 }
			 
		for(String Fal : fail)
			 {
					test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
			 }	
			 for(String Pas : pass)
			 {
				 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				//	test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
					System.out.println(filter.get(i)+" : "+Pas);
		 }
			 text.clear();
			pass.clear();
			fail.clear();
			raw.clear();
			
			
			}
			

				   }
				   else
				   {
						test.log(LogStatus.PASS,"Selected Location and License Type No Record Found");
				   }
			
			Boolean  btnclear =LiPerformerPOM.clearbtn().isEnabled();
		     if(btnclear) 
		     {
		    	 LiPerformerPOM.clearbtn().click();
		    	 test.log(LogStatus.PASS,"Clear Button Working Successfully");
		     }
		     else
		     {
		    	 test.log(LogStatus.FAIL,"Clear Button Not Clickable");
		     }
			
			
			  wait.until(ExpectedConditions.elementToBeClickable(MethodPOM.clickMyDashboard()));
				
			}
			*/
			
		




private static void progress() {
	// TODO Auto-generated method stub
	
}
private static void selectOptionFromDropDown_bs(List<WebElement> roc, String type) {
	// TODO Auto-generated method stub
	
}

		
}
		
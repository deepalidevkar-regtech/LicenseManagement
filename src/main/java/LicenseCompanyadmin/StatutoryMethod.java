package LicenseCompanyadmin;


import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Table.Cell;
import com.google.common.io.Files;
import com.google.inject.Key;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import licenseManagement.licmgmtPOM;
import licensePerformer.LiPerformerPOM;
import licenseReviewer.LiReviewerPOM;
import litigationPerformer.performerPOM;
import login.webpage;
import performer.OverduePOM;

public class StatutoryMethod  extends webpage{
	public static final String Allfilter = null;
//	public static Web  = null;		//Web instance created
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
	
	public static void user(ExtentTest test, String Type) throws InterruptedException, IOException
	{
		
		XSSFSheet sheet = ReadExcel();

		Thread.sleep(1000);
		MethodPOM.clickMasterMenu().click();
		Thread.sleep(1000);
		MethodPOM.clickUserMaster().click();
		Thread.sleep(1000);
		MethodPOM.clickAddUser().click();

	      Thread.sleep(3000);
	      sheet = workbook.getSheetAt(0);					//Retrieving second sheet of Workbook
		  Row row0 = sheet.getRow(5);						//Selected 0th index row (First row)
		  org.apache.poi.ss.usermodel.Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		  String firstname1= c1.getStringCellValue();
		  MethodPOM.ClickUername().sendKeys(firstname1);		  
		 Thread.sleep(3000);
		 Row row1 = sheet.getRow(6);
		org.apache.poi.ss.usermodel.Cell c2=row1.getCell(1);
		 String Lastname=c2.getStringCellValue();
		 MethodPOM.ClickLastName().sendKeys(Lastname);	
		 
		 Thread.sleep(3000);
		 Row row2 = sheet.getRow(7);
		 org.apache.poi.ss.usermodel.Cell c3=row2.getCell(1);
		 String Designation=c3.getStringCellValue();
		 MethodPOM.ClickDesignation().sendKeys(Designation);	
		 
		 Thread.sleep(3000);
		 Row row3 = sheet.getRow(8);
		 org.apache.poi.ss.usermodel.Cell c4=row3.getCell(1);
		 String Email=c4.getStringCellValue();
		 MethodPOM.ClickUserGmail().sendKeys(Email);	
		 
		 Thread.sleep(3000);
		 Row row4 = sheet.getRow(9);
		 org.apache.poi.ss.usermodel.Cell c5=row4.getCell(1);
		 int MobileNO= (int)c5.getNumericCellValue();
		 MethodPOM.ClickMobileNo().sendKeys(MobileNO+"");
		 
		 Thread.sleep(3000);
		 MethodPOM.ClickRoleDropdown().click();
		 
		 Thread.sleep(3000);
		 MethodPOM.ClickRoleNonadmin().click();
		 
		 
		 Thread.sleep(3000);
		 MethodPOM.ClickDepartmentDropdown().click();
		 
		 Thread.sleep(3000);
		 MethodPOM.ClickDepartment().click();
		 
		 Thread.sleep(3000);
		 MethodPOM.ClickLocationDropdown().click();
		 
		 Thread.sleep(3000);
		 MethodPOM.ClickLocation().click();
		  
		 Thread.sleep(3000);
		 MethodPOM.ClickUserSave().click();
		 Thread.sleep(5000);
		 test.log(LogStatus.PASS, "User Created Successfully");
		 
		 MethodPOM.ClickUserClose().click();
		 Thread.sleep(5000);
		 MethodPOM.ClickEditUser().click();
		 Thread.sleep(3000);
		 MethodPOM.ClickUserGmail().clear();
		 Thread.sleep(3000);
		 MethodPOM.ClickUserGmail().sendKeys("Poojas34@gmail.com");
		 Thread.sleep(3000);	
		 MethodPOM.ClickUserSave().click();
		 Thread.sleep(3000);
	     test.log(LogStatus.PASS, "User Details Updated  Successfully");
		 MethodPOM.ClickUserClose().click();
		 Thread.sleep(3000);
		 MethodPOM.ClickResetPassword().click();
	//	 test.log(LogStatus.PASS, "Password Reset Successfully");
		String AlertMesg= getDriver().switchTo().alert().getText(); 
		 Thread.sleep(3000);
		getDriver().switchTo().alert().accept();
		test.log(LogStatus.INFO, AlertMesg);
		 Thread.sleep(5000);
		MethodPOM.ClickUserSearch().sendKeys("AShish",Keys.ENTER);
	 test.log(LogStatus.PASS, "User Search Successfully");
	    Thread.sleep(3000);

		 
	}
	public static void PageAuthorization( ExtentTest test,String type) throws InterruptedException

	{
	  Thread.sleep(3000);
	  MethodPOM.clickMasterMenu().click();
	  
	  Thread.sleep(3000);
	  MethodPOM.ClickPageAuthorization().click();
	  
	  Thread.sleep(3000);
	
	  if(type.equalsIgnoreCase("Internal"))
	  {
		   MethodPOM.ClickPageAutherInternal().click();
		   Thread.sleep(3000);
		   MethodPOM.ClickAutheruser().click();
		   Thread.sleep(3000);
			  MethodPOM.ClickSelectUser().click();
			  Thread.sleep(3000);
			  MethodPOM.ClickAddAuthAddCheck().click();
	  }  
	  else
	  {
		  MethodPOM.ClickAutheruser().click();
		  Thread.sleep(3000);
		  MethodPOM.ClickSelectUser().click();
		  Thread.sleep(3000);
		  MethodPOM.ClickAddAuthAddCheck().click();
	  }
	  Thread.sleep(3000);
	  JavascriptExecutor js=(JavascriptExecutor)  getDriver() ;
		js.executeScript("window.scroll(0,1000)");
		
	  Thread.sleep(5000);
	  MethodPOM.ClickPageAutherSave().click();
	  
	  test.log(LogStatus.PASS, "Page Authorization Saved");
	 /*Thread.sleep(3000);
	   MethodPOM.ClickPageAutherAll().click();
	   
	   
	   
	   Thread.sleep(3000);
		  MethodPOM.ClickAutheruser().click();
		  
		  Thread.sleep(3000);
		  MethodPOM.ClickSelectUser().click();
		  
		  Thread.sleep(3000);
		  MethodPOM.ClickAddAuthAddCheck().click();
		  
		  JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			
		  Thread.sleep(3000);
		  MethodPOM.ClickPageAutherSave().click();
		  */
	   
	}
    public static void RenewStatutoryLicense( ) throws InterruptedException

    {
    	Thread.sleep(4000);
    	MethodPOM.clickMasterMenu().click();
    	
    	Thread.sleep(3000);
        MethodPOM.ClickRenewLicenseMenu().click();
        
       Thread.sleep(4000);
        MethodPOM.ClickReneweditStatutoryLicense().click();
        
        getDriver() .switchTo().frame(MethodPOM.ClickLiceneFream());
        
        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
		js1.executeScript("window.scroll(0,500)");
    	
        Thread.sleep(5000);
        MethodPOM.ClickLicenseNumber().sendKeys("224123a");
        
        Thread.sleep(3000);
        MethodPOM.ClickLicenseTitle().sendKeys("a123");
      
        Thread.sleep(3000);
      /*  MethodPOM.ClickLicenseStartDate().click();
        LiPerformerPOM.NextDateClick().click();
        MethodPOM.ClickLicenseStartDate().sendKeys("30-04-2023");     
         Thread.sleep(5000);
         MethodPOM.LicenseEnddate().click();
         LiPerformerPOM.NextDateClick().click();
        MethodPOM.LicenseEnddate().sendKeys("30-04-2023");
        Thread.sleep(5000);
        */
        LiPerformerPOM.AppliedStartDateclick().click();
		Thread.sleep(500);
		LiPerformerPOM.AppliedStartDate().click();
		Thread.sleep(3000);
	   LiPerformerPOM.AppliedEndDateclick().click();
	   Thread.sleep(3000);
		LiPerformerPOM.NextDateClick().click();
		  Thread.sleep(3000);
	   LiPerformerPOM.AppliedEndDate().click();
        MethodPOM.LicenseUploadDocument().sendKeys("E:\\Deepali\\LicenseManagement-main\\TestData\\ComplianceSheet.xlsx");
        
        Thread.sleep(5000);
        MethodPOM.FileNumber().sendKeys("5660fsfss5");
        Thread.sleep(5000);
        js1.executeScript("window.scroll(0,500)");
        Thread.sleep(5000);
        MethodPOM.RenewLicenseSubmit().click();    
        Thread.sleep(3000);
      //  test.log(LogStatus.PASS, "Compliance Created and Assigned Successfully");

        js1.executeScript("window.scroll(0,1000)");
      
        MethodPOM.RenewLicenseClose().click();
        Thread.sleep(3000);
           
    /*   LiPerformerPOM.EntityLocation().click();
		Thread.sleep(500);
		LiPerformerPOM.aa().click();
		Thread.sleep(500);
		//LiPerformerPOM.EntityLocationExpand().click();
		//Thread.sleep(500);
	   Thread.sleep(500);
	   LiPerformerPOM.aa1().click();
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
        */
    }
    public static void RenewInternalLicense1(ExtentTest test, String Type) throws InterruptedException

    {
    
      Thread.sleep(3000);
        MethodPOM.selectLicense().click();
        
        Thread.sleep(3000);
        MethodPOM.selectInternalLicense().click();
        
    Thread.sleep(4000);
    	MethodPOM.clickMasterMenu().click();
    	
    	Thread.sleep(3000);
        MethodPOM.ClickRenewLicenseMenu().click();
    	Thread.sleep(3000);
    	MethodPOM.selectinttype().click();
    	Thread.sleep(3000);
    	MethodPOM.selectinttype1().click();
        Thread.sleep(4000);
        MethodPOM.ClickReneweditStatutoryLicense().click();
        
        getDriver().switchTo().frame(MethodPOM.ClickLiceneFream());
        
        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
		js1.executeScript("window.scroll(0,500)");
    	
        Thread.sleep(5000);
        MethodPOM.ClickLicenseNumber().sendKeys("A1234");
        
        Thread.sleep(3000);
        MethodPOM.ClickLicenseTitle().sendKeys(" Internal License For Automation");
        
        LiPerformerPOM.AppliedStartDateclick().click();
		Thread.sleep(500);
		LiPerformerPOM.AppliedStartDate().click();
		Thread.sleep(3000);
	   LiPerformerPOM.AppliedEndDateclick().click();
	   Thread.sleep(3000);
		LiPerformerPOM.NextDateClick().click();
		  Thread.sleep(3000);
	   LiPerformerPOM.AppliedEndDate().click();
        MethodPOM.LicenseUploadDocument().sendKeys("E:\\Deepali\\LicenseManagement-main\\TestData\\ComplianceSheet.xlsx");
        
        Thread.sleep(3000);
        MethodPOM.FileNumber().sendKeys("507");
        Thread.sleep(3000);
        MethodPOM.RenewLicenseSubmit().click();
      
        String strExpected = "Compliance Created and Assigned Successfully";
        String valimsg = MethodPOM.valimsg().getText();
		System.out.println(valimsg);
		if (strExpected.equals(valimsg)) 
		{
			test.log(LogStatus.PASS, "Message displayed = "+strExpected);
		} else
		{
			test.log(LogStatus.FAIL, "Message displayed = "+valimsg);
		}
        Thread.sleep(3000);
        MethodPOM.RenewLicenseClose().click();
    
    }
	public static void ActiveLicense( ExtentTest test, String type) throws InterruptedException, IOException
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
		/*	//Convert web driver object to TakeScreenshot
			  TakesScreenshot scrShot =((TakesScreenshot)getDriver());
			  //Call getScreenshotAs method to create image file
			  File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			  //Move image file to new destination
			  File DestFile=new File("E:\\Deepali\\Screenshot\\LicenseScreenshot.png");
			  //Copy file at destination
			  FileUtils.copyFile(SrcFile, DestFile);
			  Thread.sleep(3000);
			  */
			  Calendar cal =Calendar.getInstance();
			  Date time =cal.getTime();
			  String timestamp =time.toString().replace(":", "").replace("", "");
			  System.out.println(time);
			  System.out.println(timestamp);
			  TakesScreenshot ts = (TakesScreenshot)getDriver();
			  byte[] image = ts.getScreenshotAs(OutputType.BYTES);

			  try {
				  File screenshot = new File("./Screenshot/licescreenshot"+timestamp+".png");
				  
			  //  File screenshot = new File("E:\\Deepali\\Screenshot\\LicenseScreenshot.png");
			    FileOutputStream fos = new FileOutputStream(screenshot);
			    fos.write(image);
			    fos.close();
			  }
			  catch (IOException ex) {
			    fail("Support Error");
			  }

			 getDriver() .switchTo().parentFrame();
			  MethodPOM.ClickCloseOverview().click();
			   Thread.sleep(5000);
				LiPerformerPOM.editlicenseicon().click();
				Thread.sleep(5000);
			//	licenseManagement.licmgmtPOM.LicenseTitle().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle().sendKeys(".");	
				Thread.sleep(5000);
			//	licenseManagement.licmgmtPOM.LicenseNo().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo().sendKeys(".");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,3000)");
				Thread.sleep(7000);
				/*licmgmtPOM.ClickCal().click();
				 Thread.sleep(7000);
				 licmgmtPOM.NewDate().click();
				 Thread.sleep(5000);
				licmgmtPOM.ClickCal1().click();
				 Thread.sleep(7000);
				licmgmtPOM.NewEndDate().click();
				Thread.sleep(7000);
				*/
				licenseManagement.licmgmtPOM.Nomineesubmit().click();
				
				 Thread.sleep(7000);
				    // Switching to Alert       
				        Alert alert = getDriver().switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= getDriver().switchTo().alert().getText();
				       
				        Thread.sleep(5000);
				    //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				      System.out.println(alertMessage);
				       
				       
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
				        Thread.sleep(5000);
				          
				          licmgmtPOM.editlicenseclose().click();
				          Thread.sleep(300);
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
	public static void ActiveInternalLicense( ExtentTest test, String type) throws InterruptedException, IOException
	{	
		Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();

			WebDriverWait wait = new WebDriverWait( getDriver(), 20);
			
		
	//	WebDriverWait wait = new WebDriverWait( getDriver(), 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive()));
		String active=MethodPOM.clickActive().getText();
		
	     int activelicense = Integer.parseInt(active);	//Reading Active count.

	      MethodPOM.clickActive().click();					//Clicking on 'Active' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadActive().click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			Thread.sleep(4000);
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
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
				Thread.sleep(5000);
				LiPerformerPOM.editlicenseicon().click();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle().sendKeys("update License");	
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo().sendKeys("update00");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,3000)");
				Thread.sleep(7000);
				/*licmgmtPOM.ClickCal().click();
				 Thread.sleep(7000);
				 licmgmtPOM.NewDate().click();
				 Thread.sleep(5000);
				licmgmtPOM.ClickCal1().click();
				 Thread.sleep(7000);
				licmgmtPOM.NewEndDate().click();
				Thread.sleep(7000);
				*/
				licenseManagement.licmgmtPOM.Nomineesubmit().click();
				
				 Thread.sleep(7000);
				    // Switching to Alert       
				        Alert alert = getDriver().switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= getDriver().switchTo().alert().getText();
				       
				        Thread.sleep(5000);
				    //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				      System.out.println(alertMessage);
				       
				       
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
				        licmgmtPOM.editlicenseclose().click();
				          Thread.sleep(300);
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
	public static void ExpiringLicense( ExtentTest test, String type) throws InterruptedException, IOException
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
				Thread.sleep(3000);
				LiPerformerPOM.editlicenseicon().click();
				Thread.sleep(5000);
				//licenseManagement.licmgmtPOM.LicenseTitle().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle().sendKeys(".");	
				Thread.sleep(5000);
				//licenseManagement.licmgmtPOM.LicenseNo().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo().sendKeys(".");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,3000)");
				Thread.sleep(7000);
				/*licmgmtPOM.ClickCal().click();
				 Thread.sleep(7000);
				 licmgmtPOM.NewDate().click();
				 Thread.sleep(5000);
				licmgmtPOM.ClickCal1().click();
				 Thread.sleep(7000);
				licmgmtPOM.NewEndDate().click();
				Thread.sleep(7000);
				*/
				licenseManagement.licmgmtPOM.Nomineesubmit().click();
				
				 Thread.sleep(7000);
				    // Switching to Alert       
				        Alert alert = getDriver().switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= getDriver().switchTo().alert().getText();
				       
				        Thread.sleep(5000);
				    //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				      System.out.println(alertMessage);
				       
				       
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
				    	//MethodPOM.ClickMyWorkspace().click();
				        licmgmtPOM.editlicenseclose().click();
				          Thread.sleep(300);
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
	public static void ExpiringInternalLicense( ExtentTest test, String type) throws InterruptedException, IOException
	{	
		Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();

			WebDriverWait wait = new WebDriverWait( getDriver(), 20);
			
		//WebDriverWait wait = new WebDriverWait( getDriver(), 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring()));
		String Expiring=MethodPOM.clickExpiring().getText();
		
	     int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.

	      MethodPOM.clickExpiring().click();					//Clicking on 'Expiring' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			String item1 = MethodPOM.clickReadExpiring().getText();	//Reading total items String value
			 Thread.sleep(7000);
			 
	      if(!item1.equalsIgnoreCase("No items to display"))
	      {
			MethodPOM.clickReadExpiring().click();					//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickReadExpiring().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseExpiringCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
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
				js1.executeScript("window.scrollBy(2000,0)");     //Scrolling UP window by 2000 px.
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
				MethodPOM.ClickCloseOverview().click();
				Thread.sleep(3000);
				LiPerformerPOM.editlicenseicon().click();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle().sendKeys(".");	
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo().sendKeys(".");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,3000)");
				Thread.sleep(7000);
				/*licmgmtPOM.ClickCal().click();
				 Thread.sleep(7000);
				 licmgmtPOM.NewDate().click();
				 Thread.sleep(5000);
				licmgmtPOM.ClickCal1().click();
				 Thread.sleep(7000);
				licmgmtPOM.NewEndDate().click();
				Thread.sleep(7000);
				*/
				licenseManagement.licmgmtPOM.Nomineesubmit().click();
				
				 Thread.sleep(7000);
				    // Switching to Alert       
				        Alert alert = getDriver().switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= getDriver().switchTo().alert().getText();
				       
				        Thread.sleep(5000);
				    //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				      System.out.println(alertMessage);
				       
				       
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
	
				        licmgmtPOM.editlicenseclose().click();
				          Thread.sleep(300);
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

	      		
	}
	public static void ExpiredLicense( ExtentTest test, String type) throws InterruptedException, IOException
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
				LiPerformerPOM.editlicenseicon().click();
				Thread.sleep(5000);
				//licenseManagement.licmgmtPOM.LicenseTitle().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle().sendKeys(".");	
				Thread.sleep(5000);
				//licenseManagement.licmgmtPOM.LicenseNo().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo().sendKeys(".");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,3000)");
				Thread.sleep(7000);
				/*licmgmtPOM.ClickCal().click();
				 Thread.sleep(7000);
				 licmgmtPOM.NewDate().click();
				 Thread.sleep(5000);
				licmgmtPOM.ClickCal1().click();
				 Thread.sleep(7000);
				licmgmtPOM.NewEndDate().click();
				Thread.sleep(7000);
				*/
				licenseManagement.licmgmtPOM.Nomineesubmit().click();
				
				 Thread.sleep(7000);
				    // Switching to Alert       
				        Alert alert = getDriver().switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= getDriver().switchTo().alert().getText();
				       
				        Thread.sleep(5000);
				    //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				      System.out.println(alertMessage);
				       
				       
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
				        
				    	//MethodPOM.ClickMyWorkspace().click();
				        licmgmtPOM.editlicenseclose().click();
				          Thread.sleep(300);
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
	public static void ExpiredInternalLicense( ExtentTest test, String type) throws InterruptedException, IOException
	{
		Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();

			WebDriverWait wait = new WebDriverWait( getDriver(), 20);
			
   //   WebDriverWait wait = new WebDriverWait( getDriver(), 20);
		
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
					//test.log(LogStatus.PASS, "Number of Expired Internal License  grid matches to Dashboard Expired Internal License   Count.");
					test.log(LogStatus.PASS, "No of Expired Internal  License  in the grid = "+total+" | Dashboard Expired Internal License  Count = "+Expiredlicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expired Internal  License does not matches to Dashboard Expired Internal  License   Count.");
					test.log(LogStatus.FAIL, "No of Expired Internal License  in the grid = "+total+" | Dashboard Expired Internal  License  Count = "+Expiredlicense);
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
				LiPerformerPOM.editlicenseicon().click();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle().sendKeys(".");	
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo().sendKeys(".");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,3000)");
				Thread.sleep(7000);
				/*licmgmtPOM.ClickCal().click();
				 Thread.sleep(7000);
				 licmgmtPOM.NewDate().click();
				 Thread.sleep(5000);
				licmgmtPOM.ClickCal1().click();
				 Thread.sleep(7000);
				licmgmtPOM.NewEndDate().click();
				Thread.sleep(7000);
				*/
				licenseManagement.licmgmtPOM.Nomineesubmit().click();
				
				 Thread.sleep(7000);
				    // Switching to Alert       
				        Alert alert = getDriver().switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= getDriver().switchTo().alert().getText();
				       
				        Thread.sleep(5000);
				    //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				      System.out.println(alertMessage);
				       
				       
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
				        licmgmtPOM.editlicenseclose().click();
				          Thread.sleep(300);
				          js1.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
							
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
				
				//MethodPOM.clickMyDashboard().click();
				  }
		
	
	public static void AppliedLicense( ExtentTest test, String type) throws InterruptedException, IOException
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
					LiPerformerPOM.editlicenseicon().click();
					Thread.sleep(5000);
					//licenseManagement.licmgmtPOM.LicenseTitle().clear();
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseTitle().sendKeys(".");	
					Thread.sleep(5000);
					//licenseManagement.licmgmtPOM.LicenseNo().clear();
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseNo().sendKeys(".");
					Thread.sleep(5000);
					js1.executeScript("window.scrollBy(0,3000)");
					Thread.sleep(7000);
					/*licmgmtPOM.ClickCal().click();
					 Thread.sleep(7000);
					 licmgmtPOM.NewDate().click();
					 Thread.sleep(5000);
					licmgmtPOM.ClickCal1().click();
					 Thread.sleep(7000);
					licmgmtPOM.NewEndDate().click();
					Thread.sleep(7000);
					*/
					licenseManagement.licmgmtPOM.Nomineesubmit().click();
					
					 Thread.sleep(7000);
					    // Switching to Alert       
					        Alert alert = getDriver().switchTo().alert();
					       
					        // Capturing alert message.   
					        String alertMessage= getDriver().switchTo().alert().getText();
					       
					        Thread.sleep(5000);
					    //  test.log(LogStatus.PASS, alertMessage);
					       
					        // Displaying alert message
					      System.out.println(alertMessage);
					       
					       
					        // Accepting alert
					        alert.accept();
					        test.log(LogStatus.PASS,"License Details Updated Successfully" );
					        
					    	//MethodPOM.ClickMyWorkspace().click();
					        licmgmtPOM.editlicenseclose().click();
					          Thread.sleep(300);
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
	public static void AppliedInternalLicense( ExtentTest test, String type) throws InterruptedException, IOException
	{
		
		 Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   MethodPOM.clickDashlicensetype().click();
		   Thread.sleep(5000);
		   
		  // MethodPOM.SearchInternalLicenseType().sendKeys("Annual Maintenance",Keys.ENTER);
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   

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
						LiPerformerPOM.editlicenseicon().click();
						Thread.sleep(5000);
						//licenseManagement.licmgmtPOM.LicenseTitle().clear();
						Thread.sleep(5000);
						licenseManagement.licmgmtPOM.LicenseTitle().sendKeys(".");	
						Thread.sleep(5000);
						//licenseManagement.licmgmtPOM.LicenseNo().clear();
						Thread.sleep(5000);
						licenseManagement.licmgmtPOM.LicenseNo().sendKeys("");
						Thread.sleep(5000);
						js1.executeScript("window.scrollBy(0,3000)");
						Thread.sleep(7000);
						/*licmgmtPOM.ClickCal().click();
						 Thread.sleep(7000);
						 licmgmtPOM.NewDate().click();
						 Thread.sleep(5000);
						licmgmtPOM.ClickCal1().click();
						 Thread.sleep(7000);
						licmgmtPOM.NewEndDate().click();
						Thread.sleep(7000);
						*/
						licenseManagement.licmgmtPOM.Nomineesubmit().click();
						
						 Thread.sleep(7000);
						    // Switching to Alert       
						        Alert alert = getDriver().switchTo().alert();
						       
						        // Capturing alert message.   
						        String alertMessage= getDriver().switchTo().alert().getText();
						       
						        Thread.sleep(5000);
						    //  test.log(LogStatus.PASS, alertMessage);
						       
						        // Displaying alert message
						      System.out.println(alertMessage);
						       
						       
						        // Accepting alert
						        alert.accept();
						        test.log(LogStatus.PASS,"License Details Updated Successfully" );

						        licmgmtPOM.editlicenseclose().click();
						          Thread.sleep(300);
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
	}

	public static void pendingforreviewLicense( ExtentTest test, String type) throws InterruptedException, IOException
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
					Thread.sleep(5000);
					/*LiPerformerPOM.editlicenseicon().click();
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseTitle().clear();
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseTitle().sendKeys("update License");	
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseNo().clear();
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseNo().sendKeys("update00");
					Thread.sleep(5000);
					js1.executeScript("window.scrollBy(0,3000)");
					Thread.sleep(7000);
					/*licmgmtPOM.ClickCal().click();
					 Thread.sleep(7000);
					 licmgmtPOM.NewDate().click();
					 Thread.sleep(5000);
					licmgmtPOM.ClickCal1().click();
					 Thread.sleep(7000);
					licmgmtPOM.NewEndDate().click();
					Thread.sleep(7000);
					
					licenseManagement.licmgmtPOM.Nomineesubmit().click();
					
					 Thread.sleep(7000);
					    // Switching to Alert       
					        Alert alert = getDriver().switchTo().alert();
					       
					        // Capturing alert message.   
					        String alertMessage= getDriver().switchTo().alert().getText();
					       
					        Thread.sleep(5000);
					    //  test.log(LogStatus.PASS, alertMessage);
					       
					        // Displaying alert message
					      System.out.println(alertMessage);
					       
					       
					        // Accepting alert
					        alert.accept();
					        test.log(LogStatus.PASS,"License Details Updated Successfully" );
					      */
					//MethodPOM.clickMyDashboard().click();
					  
	}
	public static void pendingforreviewInternalLicense( ExtentTest test, String type) throws InterruptedException, IOException
	{
		 Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   
		   
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
					  }}}
   public static void RejectedLicense( ExtentTest test, String type) throws InterruptedException, IOException
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
				LiPerformerPOM.editlicenseicon().click();
				Thread.sleep(5000);
				//licenseManagement.licmgmtPOM.LicenseTitle().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle().sendKeys(".");	
				Thread.sleep(5000);
				//licenseManagement.licmgmtPOM.LicenseNo().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo().sendKeys(".");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,3000)");
				Thread.sleep(7000);
				/*licmgmtPOM.ClickCal().click();
				 Thread.sleep(7000);
				 licmgmtPOM.NewDate().click();
				 Thread.sleep(5000);
				licmgmtPOM.ClickCal1().click();
				 Thread.sleep(7000);
				licmgmtPOM.NewEndDate().click();
				Thread.sleep(7000);
				*/
				licenseManagement.licmgmtPOM.Nomineesubmit().click();
				
				 Thread.sleep(7000);
				    // Switching to Alert       
				        Alert alert = getDriver().switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= getDriver().switchTo().alert().getText();
				       
				        Thread.sleep(5000);
				    //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				      System.out.println(alertMessage);
				       
				       
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
				        Thread.sleep(7000);
				        licmgmtPOM.editlicenseclose().click();
				          Thread.sleep(300);
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
   public static void RejectedInternalLicense( ExtentTest test, String type) throws InterruptedException, IOException
   {
	   Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   
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
			
				MethodPOM.ClickCloseOverview().click();
				Thread.sleep(5000);
				LiPerformerPOM.editlicenseicon().click();
				Thread.sleep(5000);
				//licenseManagement.licmgmtPOM.LicenseTitle().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle().sendKeys("update License");	
				Thread.sleep(5000);
				//licenseManagement.licmgmtPOM.LicenseNo().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo().sendKeys("update00");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,3000)");
				Thread.sleep(7000);
				/*licmgmtPOM.ClickCal().click();
				 Thread.sleep(7000);
				 licmgmtPOM.NewDate().click();
				 Thread.sleep(5000);
				licmgmtPOM.ClickCal1().click();
				 Thread.sleep(7000);
				licmgmtPOM.NewEndDate().click();
				Thread.sleep(7000);
				*/
				licenseManagement.licmgmtPOM.Nomineesubmit().click();
				
				 Thread.sleep(7000);
				    // Switching to Alert       
				        Alert alert = getDriver().switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= getDriver().switchTo().alert().getText();
				       
				        Thread.sleep(5000);
				    //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				      System.out.println(alertMessage);
				       
				       
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
				        licmgmtPOM.editlicenseclose().click();
				          Thread.sleep(300);
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

   public static void TerminateLicense( ExtentTest test, String type) throws InterruptedException, IOException
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
                     
				
				//MethodPOM.clickMyDashboard().click();
				  }
   }
   public static void TerminateInternalLicense( ExtentTest test, String type) throws InterruptedException, IOException
   {
	   Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
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
                  
				
				//MethodPOM.clickMyDashboard().click();
				  }}
   
   public static void Allfilter( ExtentTest test, String type) throws InterruptedException
   {
	   Thread.sleep(3000);
	   MethodPOM.AllFilter().click();
	   Thread.sleep(3000);
	   MethodPOM.InternalFilter().click();
	   MethodPOM.clickDashlicensetype().click();
	   MethodPOM.DashSearchLienseType().sendKeys("Annual Maintenance",Keys.ENTER);
	   MethodPOM.ClickApply().click();
	   test.log(LogStatus.PASS, "All Filter Working Successfully");
	   MethodPOM.DashoardClearBtn().click();
	   test.log(LogStatus.PASS, "Clear Button Working Successfully");
	   MethodPOM.clickMyDashboard().click();
	   
	   
	   
	   
   }
   public static void LicenseExpiredInInternal( ExtentTest test, String type) throws InterruptedException
   {
	   Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
	   Thread.sleep(3000);
	   MethodPOM.ClickMaximizeLicenseExpiredOn().click();
	   test.log(LogStatus.PASS, "ExpiredIn License Maximize Button Working Successfully.");
	   Thread.sleep(3000);
	   JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
		js1.executeScript("window.scroll(0,500)");
		Thread.sleep(500);
		 MethodPOM.ClickOnDashExpiredExport().click();  
		 test.log(LogStatus.PASS, "Dashboard ExpiredIn License List Downloaded Successfully.");
		 try
		 {
			 
			  Thread.sleep(3000);
		
	   MethodPOM.ClickShowMoreExpiredOnInternal().click();
	   
	   test.log(LogStatus.PASS, "ExpiredIn License show More link working Successfully. ");
	   
	   WebDriverWait wait = new WebDriverWait( getDriver(), 40);
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
	   Thread.sleep(5000);
	 String NoRecord = MethodPOM.Norecord().getText();
	 
	   if(!NoRecord.equalsIgnoreCase("No items to display")) 
	   {
	   
	   MethodPOM.ClickExportExpiredOn().click();
		test.log(LogStatus.PASS, "Expired License List Downloaded Successfully");
		Thread.sleep(5000);
		MethodPOM.ClickOverviewExpiredOn().click();

  test.log(LogStatus.PASS, " License Overview Details Successfully");
  Thread.sleep(7000);
 MethodPOM.clickBystatuscloseoverview().click();
	Thread.sleep(2000);
	/*  LiPerformerPOM.EntityLocation().click();
			Thread.sleep(500);
			  String locationtext1 =LiPerformerPOM.locget().getText();
				Thread.sleep(500);
			MethodPOM.Clicklocationsearch().click();
			Thread.sleep(500);
			
			 //  LiPerformerPOM.locget().click();
			MethodPOM.Clicklocationsearch().sendKeys("Regtrack Mumbai");
			Thread.sleep(500);
	 MethodPOM.Checkedlocation().click();
	 Thread.sleep(3000);
	 LiPerformerPOM.clicklictypet().click();
	 Thread.sleep(5000);
	LiPerformerPOM.selectInternalinlictype().click();
	
	 String LicenseType1 =LiPerformerPOM.inlic().getText();
	 Thread.sleep(5000);
	 // LiPerformerPOM.inlic().click();
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
			
			JavascriptExecutor js = (JavascriptExecutor)getDriver();
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
			}*/

			}	
			}
	   catch(Exception e)
	   {
	  test.log(LogStatus.PASS, "Expired In More Than 5 Record not displayed");
	  // Js.executeScript("window.scrollBy(500,0)");
//	.switchTo().parentFrame();
	// MethodPOM.clickCloseGraphPopup().click();
	// Thread.sleep(7000);
	   }


	   }
   public static void LicenseExpiredOnStatutory( ExtentTest test, String type) throws InterruptedException
   {
	   Thread.sleep(3000);
	   
	   MethodPOM.ClickMaximizeLicenseExpiredOn().click();
	   test.log(LogStatus.PASS, "Expired Maximize Button Working Successfully");
	   Thread.sleep(3000);
	   JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
		js1.executeScript("window.scroll(0,500)");
        MethodPOM.ClickExportExpiredOn1cmd().click();
        test.log(LogStatus.PASS, "Dashboard ExpiredIn License List Downloaded Successfully");
        Thread.sleep(3000);
		
	   LiPerformerPOM.Showmorecmd().click();
	   test.log(LogStatus.PASS, "ExpiredIn Show More link working Successfully");
	   WebDriverWait wait = new WebDriverWait( getDriver(), 40);
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
	   Thread.sleep(5000);
	   js1.executeScript("window.scroll(0,500)");
	   String NoRecord = MethodPOM.Norecord().getText();
	   if(!NoRecord.equalsIgnoreCase("No items to display")) 
	   {
	   
	   MethodPOM.ClickExportExpiredOn().click();
		test.log(LogStatus.PASS, "Expired License List Downloaded Successfully");
		Thread.sleep(5000);
		/*MethodPOM.Clearfilter().click();
		test.log(LogStatus.PASS, "Clear Filter Button Working  Successfully");
		Thread.sleep(7000);
		*/
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
				Thread.sleep(500);
				//LiPerformerPOM.EntityLocationExpand().click();
				//Thread.sleep(500);
			   Thread.sleep(500);
			   LiPerformerPOM.Entitysubexpand().click();
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
}
   public static void LicenseExpiringOnStatutory( ExtentTest test, String type) throws InterruptedException, IOException
   {
	   Thread.sleep(5000);
	   MethodPOM.ClickMaximizeLicenseExpiringOn().click();
	   Thread.sleep(3000);
	   test.log(LogStatus.PASS, "ExpiringIn Maximize Button Working Successfully");
	 
	   JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
		js1.executeScript("window.scroll(0,500)");
		  Thread.sleep(3000);
		MethodPOM.DashExpiringOnExportcmd().click();
		test.log(LogStatus.PASS, "Dashboard ExpiringIn License Download Successfully");
		 Thread.sleep(3000);
		
	   MethodPOM.ClickShowMoreExpiringOnStatutory().click();
	   Thread.sleep(7000);
	   WebDriverWait wait = new WebDriverWait( getDriver(), 40);
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
		Thread.sleep(7000);
	   /* licenseManagement.licmgmtPOM.lictype().click();
		Thread.sleep(7000);
	    licenseManagement.licmgmtPOM.lictype1().click();
		Thread.sleep(7000);
		MethodPOM.Clearfilter().click();
		test.log(LogStatus.PASS, "Clear Filter Button Working  Successfully");
	   */
	  // WebWait wait1 = new WebWait(, 40);
	   // wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));
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
				
				/*fis = new FileInputStream(lastModifiedFile);
				workbook = new XSSFWorkbook(fis);
				sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
				int no = sheet.getLastRowNum();
				int SheetRecords = no - 0;						//Sheet have extra 5 lines of information at top (But row count started from 0, so -4)
				fis.close();
				
				if(count == SheetRecords)
				{
					//test.log(LogStatus.PASS, "Count of records displayed from grid matches to number records in Excel Sheet.");
					test.log(LogStatus.PASS, "Total records from grid = "+count+" | Total records in Excel Sheet = "+SheetRecords);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Count of records displayed from grid doesn't matches to number records in Excel Sheet.");
					test.log(LogStatus.FAIL, "Total records from grid = "+count+" | Total records in Excel Sheet = "+SheetRecords);
				}*/
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
			Thread.sleep(500);
			/*LiPerformerPOM.aa().click();
			Thread.sleep(500);
			//LiPerformerPOM.EntityLocationExpand().click();
			//Thread.sleep(500);
		   Thread.sleep(500);
		   LiPerformerPOM.aa1().click();
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

*/
}
	   
   
   public static void BystatusExpringInternalgraph( ExtentTest test, String type) throws InterruptedException, IOException
   {
	   Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   Thread.sleep(5000);
		   getDriver() .manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor)getDriver()	 ;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpringbutnotApplied()));	  
		String BystatusExpiring=MethodPOM.clickExpringbutnotApplied().getText();
		
	     int BystatusExpiringgraph = Integer.parseInt(BystatusExpiring);	//Reading Expiring graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickExpringbutnotApplied().click();					//Clicking on 'Expiring' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickByStatsExpiringReadcount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickByStatsExpiringReadcount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseBystatusExpiringCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicenseBystatusExpiringCount);
			if(BystatusExpiringgraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Expiring License  grid matches to Dashboard By status Graph Expiring License Count.");
					test.log(LogStatus.PASS, "No of Expiring License  in the grid = "+total+" | Dashboard By Status -Expiring License  Count = "+BystatusExpiringgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expiring License does not matches to Dashboard By Status Graph  Expiring License   Count.");
					test.log(LogStatus.FAIL, "No of Expiring License  in the grid = "+total+" | Dashboard By Status-Expiring License  Count = "+BystatusExpiringgraph);
				}
			 MethodPOM.clickExportGraph().click();
			 Thread.sleep(3000);
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
						//js1.executeScript("window.scrollBy(0,1000)");
						
					
						Thread.sleep(100);
						File dir = new File("C://Users//deepalid//Downloads");
						File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(500);
						CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
						Thread.sleep(250);
						 MethodPOM.clickExportGraph().click();
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
							
						    FileInputStream fis = new FileInputStream(lastModifiedFile);
						    workbook = new XSSFWorkbook(fis);
						    sheet = workbook.getSheetAt(0);		
						    /*
							int no = sheet.getLastRowNum();
							Row row = sheet.getRow(no);
							org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
							int records =(int) c1.getNumericCellValue();
						    */
						    sheet = workbook.getSheetAt(0);
							int columnNumber = 3;
							int rowCount = 0;
							int actualRow=0;
							
							for(Row row : sheet)
							{
								
								org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
								if(cell != null) {
									
									rowCount++;
									actualRow = rowCount-1;
								}
								
							}
							fis.close();
			
							
							if(count2 == actualRow)
							{
								//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
								test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
							}
							else
							{
								//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
								test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
						}
				 }
	          
	         // MethodPOM.clickMyDashboard().click();
	         Thread.sleep(1000);
				  }
				  else
				  {
					   		      
					test.log(LogStatus.PASS,"No Record Found");
					MethodPOM.clickMyDashboard().click();
						      
				  }

			 MethodPOM.clickAllOverview().click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview().click();
			 Thread.sleep(4000);
			 test.log(LogStatus.PASS, "License Overview Button Working Successfully");
			 Thread.sleep(3000);

         /* LiPerformerPOM.EntityLocation().click();
					Thread.sleep(500);
					  String locationtext1 =LiPerformerPOM.locget().getText();
						Thread.sleep(500);
					MethodPOM.Clicklocationsearch().click();
					Thread.sleep(500);
					
					 //  LiPerformerPOM.locget().click();
					MethodPOM.Clicklocationsearch().sendKeys("Regtrack Mumbai");
					Thread.sleep(500);
		       MethodPOM.Checkedlocation().click();
			   Thread.sleep(3000);
			   LiPerformerPOM.clicklictypet().click();
			   Thread.sleep(500);
			   String LicenseType1 =LiPerformerPOM.inlic().getText();
			   Thread.sleep(500);
				MethodPOM.Clicklocationsearch().click();
				   Thread.sleep(500);
			  LiPerformerPOM.selectInternalinlictype().click();
			   
			   Thread.sleep(5000);
			   // LiPerformerPOM.inlic().click();
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
			
				
 
   
				/*Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph().click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
			 Thread.sleep(3000);
			 /*licmgmtPOM.clicktypeinternal().click();
			 Thread.sleep(5000);
			  licmgmtPOM.selecttypein().click();
				 Thread.sleep(5000);
				 MethodPOM.GraphPopupClear().click();
				 test.log(LogStatus.PASS, "Clear Button Working Successfully.");
				 Thread.sleep(5000);
				 
			 MethodPOM.clickGraphoverview().click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
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
			MethodPOM.clickBystatuscloseoverview().click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup().click();
			*/
			 
			  }
		
  
   public static void BystatusExpringgraph( ExtentTest test, String type) throws InterruptedException, IOException
   {
	 
	   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor)getDriver() ;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpringbutnotApplied()));	  
		String BystatusExpiring=MethodPOM.clickExpringbutnotApplied().getText();
		
	     int BystatusExpiringgraph = Integer.parseInt(BystatusExpiring);	//Reading Expiring graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickExpringbutnotApplied().click();					//Clicking on 'Expiring' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickByStatsExpiringReadcount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickByStatsExpiringReadcount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseBystatusExpiringCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicenseBystatusExpiringCount);
			if(BystatusExpiringgraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Expiring License  grid matches to Dashboard By status Graph Expiring License Count.");
					test.log(LogStatus.PASS, "No of Expiring License  in the grid = "+total+" | Dashboard By Status-Expiring License  Count = "+BystatusExpiringgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expiring License does not matches to Dashboard By Status Graph  Expiring License   Count.");
					test.log(LogStatus.FAIL, "No of Expiring License  in the grid = "+total+" | Dashboard By Status-Expiring License  Count = "+BystatusExpiringgraph);
				}
			 MethodPOM.clickExportGraph().click();
			 Thread.sleep(3000);
		//	 test.log(LogStatus.PASS, "License Details Dwonloaded Successfully");
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
						//js1.executeScript("window.scrollBy(0,1000)");
						
					
						Thread.sleep(100);
						File dir = new File("C://Users//deepalid//Downloads");
						File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(500);
						CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
						Thread.sleep(250);
						 MethodPOM.clickExportGraph().click();
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
							
						    FileInputStream fis = new FileInputStream(lastModifiedFile);
						    workbook = new XSSFWorkbook(fis);
						    sheet = workbook.getSheetAt(0);		
						    /*
							int no = sheet.getLastRowNum();
							Row row = sheet.getRow(no);
							org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
							int records =(int) c1.getNumericCellValue();
						    */
						    sheet = workbook.getSheetAt(0);
							int columnNumber = 3;
							int rowCount = 0;
							int actualRow=0;
							
							for(Row row : sheet)
							{
								
								org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
								if(cell != null) {
									
									rowCount++;
									actualRow = rowCount-1;
								}
								
							}
							fis.close();
			
							
							if(count2 == actualRow)
							{
								//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
								test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
							}
							else
							{
								//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
								test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
						}
				 }
	          
	         // MethodPOM.clickMyDashboard().click();
	          Thread.sleep(1000);
				  }
				  else
				  {
					   		      
					test.log(LogStatus.PASS,"No Record Found");
					MethodPOM.clickMyDashboard().click();
						      
				  }

			 
			 MethodPOM.clickAllOverview().click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview().click();
			 Thread.sleep(4000);
			 test.log(LogStatus.PASS, "By Status Expiring License  Overview Button Working Successfully");
			 Thread.sleep(3000);
			/* LiPerformerPOM.EntityLocation().click();
  			Thread.sleep(500);
				LiPerformerPOM.EntityLocationExpand().click();
				Thread.sleep(500);
			//   LiPerformerPOM.aa1().click();
				Thread.sleep(500);
				LiPerformerPOM.demolocation().click();;
			   Thread.sleep(500);
			   String locationtext1 =LiPerformerPOM.locget().getText();
			   Thread.sleep(500);
			   LiPerformerPOM.locget().click();
			   Thread.sleep(3000);
			   LiPerformerPOM.clicklictypet().click();
			   Thread.sleep(500);
			   String LicenseType1 =LiPerformerPOM.Licensetypeinternal().getText();
			   Thread.sleep(5000);
			    LiPerformerPOM.Licensetypeinternal().click();
        Thread.sleep(5000);
			  
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
			*/
		 	   
   }
				 
   
   public static void BystatusTerminategraph( ExtentTest test, String type ) throws InterruptedException, IOException
   {

	   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor)getDriver() ;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickBystatusTerminate()));	  
		String BystatusTerminate=MethodPOM.clickBystatusTerminate().getText();
		
	     int BystatusTerminateggraph = Integer.parseInt(BystatusTerminate);	//Reading Terminate graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickBystatusTerminate().click();					//Clicking on 'Terminate' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickBystatusTerminateReadCount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickBystatusTerminateReadCount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseBystatusTerminateCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicenseBystatusTerminateCount);
			if(BystatusTerminateggraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Terminate License  grid matches to Dashboard By status Graph Terminate License Count.");
					test.log(LogStatus.PASS, "No of Terminate  License  in the grid = "+total+" | Dashboard By Status Terminate License  Count = "+BystatusTerminateggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Terminate License does not matches to Dashboard By Status Graph  Terminate License   Count.");
					test.log(LogStatus.FAIL, "No of Terminate License  in the grid = "+total+" | Dashboard By Status Terminate License  Count = "+BystatusTerminateggraph);
				}
				Thread.sleep(3000);
				
				 MethodPOM.clickExportGraph().click();
				 Thread.sleep(3000);
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
							//js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							 MethodPOM.clickExportGraph().click();
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
								
							    FileInputStream fis = new FileInputStream(lastModifiedFile);
							    workbook = new XSSFWorkbook(fis);
							    sheet = workbook.getSheetAt(0);		
							    /*
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
							    */
							    sheet = workbook.getSheetAt(0);
								int columnNumber = 3;
								int rowCount = 0;
								int actualRow=0;
								
								for(Row row : sheet)
								{
									
									org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
									if(cell != null) {
										
										rowCount++;
										actualRow = rowCount-1;
									}
									
								}
								fis.close();
							
								
								if(count2 == actualRow)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		         // MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }

				 
				 MethodPOM.clickAllOverview().click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview().click();
				 Thread.sleep(4000);
				 test.log(LogStatus.PASS, "License Overview Button Working Successfully");
				 Thread.sleep(3000);
				// LiPerformerPOM.EntityLocation().click();
         			Thread.sleep(500);
				/*	LiPerformerPOM.EntityLocationExpand().click();
					Thread.sleep(500);
				//   LiPerformerPOM.aa1().click();
					Thread.sleep(500);
					LiPerformerPOM.demolocation().click();;
				   Thread.sleep(500);
				   String locationtext1 =LiPerformerPOM.locget().getText();
				   Thread.sleep(500);
				   LiPerformerPOM.locget().click();
				   Thread.sleep(3000);
				   LiPerformerPOM.clicklictypet().click();
				   Thread.sleep(500);
				   String LicenseType1 =LiPerformerPOM.Licensetypeinternal().getText();
				   Thread.sleep(5000);
				    LiPerformerPOM.Licensetypeinternal().click();
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
				
					
	 */
	   
	   }
			
   public static void BystatusActivegraph( ExtentTest test, String type ) throws InterruptedException, IOException
   {

	   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) getDriver();
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickBystatusActive()));	  
		String BystatusActive=MethodPOM.clickBystatusActive().getText();
		
	     int BystatusActiveggraph = Integer.parseInt(BystatusActive);	//Reading Active graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickBystatusActive().click();					//Clicking on 'Active' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickBystatusActiveReadCount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickBystatusActiveReadCount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseBystatusActiveCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicenseBystatusActiveCount);
			if(BystatusActiveggraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Active License  grid matches to Dashboard By status Graph Active License Count.");
					test.log(LogStatus.PASS, "No of Active  License  in the grid = "+total+" | Dashboard By Status Active License  Count = "+BystatusActiveggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Active License does not matches to Dashboard By Status Graph  Active License   Count.");
					test.log(LogStatus.FAIL, "No of Active License  in the grid = "+total+" | Dashboard By Status Active License  Count = "+BystatusActiveggraph);
				}
			Thread.sleep(3000);
			
			 MethodPOM.clickExportGraph().click();
			 Thread.sleep(3000);
			// test.log(LogStatus.PASS, "License Details Dwonloaded Successfully");
			 
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
						//js1.executeScript("window.scrollBy(0,1000)");
						
					
						Thread.sleep(100);
						File dir = new File("C://Users//deepalid//Downloads");
						File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(500);
						CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
						Thread.sleep(250);
						 MethodPOM.clickExportGraph().click();
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
							
						    FileInputStream fis = new FileInputStream(lastModifiedFile);
						    workbook = new XSSFWorkbook(fis);
						    sheet = workbook.getSheetAt(0);		
						    /*
							int no = sheet.getLastRowNum();
							Row row = sheet.getRow(no);
							org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
							int records =(int) c1.getNumericCellValue();
						    */
						    sheet = workbook.getSheetAt(0);
							int columnNumber = 3;
							int rowCount = 0;
							int actualRow=0;
							
							for(Row row : sheet)
							{
								
								org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
								if(cell != null) {
									
									rowCount++;
									actualRow = rowCount-1;
								}
								
							}
							fis.close();
			
							
							if(count2 == actualRow)
							{
								//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
								test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
							}
							else
							{
								//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
								test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
						}
				 }
	          
	         // MethodPOM.clickMyDashboard().click();
	          Thread.sleep(1000);
				  }
				  else
				  {
					   		      
					test.log(LogStatus.PASS,"No Record Found");
					MethodPOM.clickMyDashboard().click();
						      
				  }

			 MethodPOM.clickAllOverview().click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview().click();
			 Thread.sleep(4000);
			 test.log(LogStatus.PASS, "License Overview Button Working Successfully");
			 Thread.sleep(3000);
			/* LiPerformerPOM.EntityLocation().click();
  			Thread.sleep(500);
				LiPerformerPOM.EntityLocationExpand().click();
				Thread.sleep(500);
			//   LiPerformerPOM.aa1().click();
				Thread.sleep(500);
				LiPerformerPOM.demolocation().click();;
			   Thread.sleep(500);
			   String locationtext1 =LiPerformerPOM.locget().getText();
			   Thread.sleep(500);
			   LiPerformerPOM.locget().click();
			   Thread.sleep(3000);
			   LiPerformerPOM.clicklictypet().click();
			   Thread.sleep(500);
			   String LicenseType1 =LiPerformerPOM.Licensetypeinternal().getText();
			   Thread.sleep(5000);
			    LiPerformerPOM.Licensetypeinternal().click();
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
			
				*/

			  }
   
   public static void BystatusActiveInternalgraph( ExtentTest test, String type ) throws InterruptedException, IOException
   {

	   Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) getDriver() ;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickBystatusActive()));	  
		String BystatusActive=MethodPOM.clickBystatusActive().getText();
		
	     int BystatusActiveggraph = Integer.parseInt(BystatusActive);	//Reading Active graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickBystatusActive().click();					//Clicking on 'Active' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickBystatusActiveReadCount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickBystatusActiveReadCount().getText();	//Reading total items String value
			
			if(!item.equalsIgnoreCase("No items to display"))
			{
				
			
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseBystatusActiveCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicenseBystatusActiveCount);
			if(BystatusActiveggraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Active License  grid matches to Dashboard By status Graph Active License Count.");
					test.log(LogStatus.PASS, "No of Active  License  in the grid = "+total+" | Dashboard By Status Active License  Count = "+BystatusActiveggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Active License does not matches to Dashboard By Status Graph  Active License   Count.");
					test.log(LogStatus.FAIL, "No of Active License  in the grid = "+total+" | Dashboard By Status Active License  Count = "+BystatusActiveggraph);
				}
			 MethodPOM.clickExportGraph().click();
			 Thread.sleep(3000);
		//	 test.log(LogStatus.PASS, "License Details Dwonloaded Successfully");
			 
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
						//js1.executeScript("window.scrollBy(0,1000)");
						
					
						Thread.sleep(100);
						File dir = new File("C://Users//deepalid//Downloads");
						File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(500);
						CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
						Thread.sleep(250);
						 MethodPOM.clickExportGraph().click();
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
							
						    FileInputStream fis = new FileInputStream(lastModifiedFile);
						    workbook = new XSSFWorkbook(fis);
						    sheet = workbook.getSheetAt(0);		
						    /*
							int no = sheet.getLastRowNum();
							Row row = sheet.getRow(no);
							org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
							int records =(int) c1.getNumericCellValue();
						    */
						    sheet = workbook.getSheetAt(0);
							int columnNumber = 3;
							int rowCount = 0;
							int actualRow=0;
							
							for(Row row : sheet)
							{
								
								org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
								if(cell != null) {
									
									rowCount++;
									actualRow = rowCount-1;
								}
								
							}
							fis.close();
			
							
							if(count2 == actualRow)
							{
								//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
								test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
							}
							else
							{
								//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
								test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
						}
				 }
	          
	         // MethodPOM.clickMyDashboard().click();
	          Thread.sleep(1000);
				  }
				  else
				  {
					   		      
					test.log(LogStatus.PASS,"No Record Found");
					MethodPOM.clickMyDashboard().click();
						      
				  }

			 MethodPOM.clickAllOverview().click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview().click();
			 Thread.sleep(4000);
			 test.log(LogStatus.PASS, "License Overview Button Working Successfully");
			 Thread.sleep(3000);
			}
			/*  LiPerformerPOM.EntityLocation().click();
				Thread.sleep(500);
				  String locationtext1 =LiPerformerPOM.locget().getText();
					Thread.sleep(500);
				MethodPOM.Clicklocationsearch().click();
				Thread.sleep(500);
				
				 //  LiPerformerPOM.locget().click();
				MethodPOM.Clicklocationsearch().sendKeys("Regtrack Mumbai");
				Thread.sleep(500);
	       MethodPOM.Checkedlocation().click();
		   Thread.sleep(3000);
		   LiPerformerPOM.clicklictypet().click();
		   Thread.sleep(500);
		  LiPerformerPOM.selectinlictype().click();
		   String LicenseType1 =LiPerformerPOM.inlic().getText();
		   Thread.sleep(5000);
		   // LiPerformerPOM.inlic().click();
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
			else
			{
				Thread.sleep(3000);
				getDriver().switchTo().parentFrame();
			//	Action a =new Action (getDriver());
				//a.sendKeys(Keys.PAGE_UP).biuld.perform();
				
				test.log(LogStatus.FAIL, "No records found");
			}
		*/	
   }
   
   public static void BystatusTerminateInternalgraph( ExtentTest test, String type ) throws InterruptedException, IOException
   {
	   Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) getDriver() ;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickBystatusTerminate()));	  
		String BystatusTerminate=MethodPOM.clickBystatusTerminate().getText();
		
	     int BystatusTerminateggraph = Integer.parseInt(BystatusTerminate);	//Reading Terminate graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickBystatusTerminate().click();					//Clicking on 'Terminate' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickBystatusTerminateReadCount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickBystatusTerminateReadCount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseBystatusTerminateCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicenseBystatusTerminateCount);
			if(BystatusTerminateggraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Terminate License  grid matches to Dashboard By status Graph Terminate License Count.");
					test.log(LogStatus.PASS, "No of Terminate  License  in the grid = "+total+" | Dashboard By Status Terminate License  Count = "+BystatusTerminateggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Terminate License does not matches to Dashboard By Status Graph  Terminate License   Count.");
					test.log(LogStatus.FAIL, "No of Terminate License  in the grid = "+total+" | Dashboard By Status Terminate License  Count = "+BystatusTerminateggraph);
				}
				Thread.sleep(3000);
				 MethodPOM.clickExportGraph().click();
				 Thread.sleep(3000);
				// test.log(LogStatus.PASS, "License Details Dwonloaded Successfully");
				 
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
							//js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							 MethodPOM.clickExportGraph().click();
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
								
							    FileInputStream fis = new FileInputStream(lastModifiedFile);
							    workbook = new XSSFWorkbook(fis);
							    sheet = workbook.getSheetAt(0);		
							    /*
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
							    */
							    sheet = workbook.getSheetAt(0);
								int columnNumber = 3;
								int rowCount = 0;
								int actualRow=0;
								
								for(Row row : sheet)
								{
									
									org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
									if(cell != null) {
										
										rowCount++;
										actualRow = rowCount-1;
									}
									
								}
								fis.close();
				
								
								if(count2 == actualRow)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		         // MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }

				 MethodPOM.clickAllOverview().click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview().click();
				 Thread.sleep(4000);
				 test.log(LogStatus.PASS, "License Overview Button Working Successfully");
				 Thread.sleep(3000);

				/*   LiPerformerPOM.EntityLocation().click();
					Thread.sleep(500);
					  String locationtext1 =LiPerformerPOM.locget().getText();
						Thread.sleep(500);
					MethodPOM.Clicklocationsearch().click();
					Thread.sleep(500);
					
					 //  LiPerformerPOM.locget().click();
					MethodPOM.Clicklocationsearch().sendKeys("Regtrack Mumbai");
					Thread.sleep(500);
		       MethodPOM.Checkedlocation().click();
			   Thread.sleep(3000);
			   LiPerformerPOM.clicklictypet().click();
			   Thread.sleep(500);
			  LiPerformerPOM.selectinlictype().click();
			   String LicenseType1 =LiPerformerPOM.inlic().getText();
			   Thread.sleep(5000);
			   // LiPerformerPOM.inlic().click();
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
			
			
	 */
   }
			/*	
			 MethodPOM.clickExportGraph().click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
			/* licmgmtPOM.clicktypeinternal().click();
			 Thread.sleep(5000);
			  licmgmtPOM.selecttypein().click();
				 Thread.sleep(5000);
				 MethodPOM.GraphPopupClear().click();
				 test.log(LogStatus.PASS, "Clear Button Working Successfully.");
			 Thread.sleep(5000);
			 
			 MethodPOM.clickBystatusActiveOverview().click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			
			MethodPOM.clickBystatuscloseoverview().click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup().click();
			 Thread.sleep(3000);
			  } 
*/


   public static void Bystatusappliedgraph( ExtentTest test, String type ) throws InterruptedException, IOException
   {

		   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) getDriver() ;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickBystatusExpiredappliedbutnotrenewed()));	  
		String BystatusExpiredappliedbutnotrenewed=MethodPOM.clickBystatusExpiredappliedbutnotrenewed().getText();
		
	     int BystatusExpiredappliedbutnotrenewedgraph = Integer.parseInt(BystatusExpiredappliedbutnotrenewed);	//Reading Applied But not Renewed graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickBystatusExpiredappliedbutnotrenewed().click();					//Clicking on 'Applied but not Renewed' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickBystatusExpiredappliedbutnotrenewedReadCount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickBystatusExpiredappliedbutnotrenewedReadCount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseBystatusAppliedbutnotRenewedCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicenseBystatusAppliedbutnotRenewedCount);
			if(BystatusExpiredappliedbutnotrenewedgraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Applied But not Renewed License  grid matches to Dashboard By status Graph Applied But not Renewed License Count.");
					test.log(LogStatus.PASS, "No of Applied License  in the grid = "+total+" | Dashboard By Status-Applied License  Count = "+BystatusExpiredappliedbutnotrenewedgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Applied But not Renewed License does not matches to Dashboard By Status Graph  Applied But not Renewed License   Count.");
					test.log(LogStatus.FAIL, "No of Applied License  in the grid = "+total+" | Dashboard By Status-Applied License  Count = "+BystatusExpiredappliedbutnotrenewedgraph);
				}
				Thread.sleep(3000);
				
				 MethodPOM.clickExportGraph().click();
				 Thread.sleep(3000);
			  //	 test.log(LogStatus.PASS, "License Details Dwonloaded Successfully");
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
							//js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							 MethodPOM.clickExportGraph().click();
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
								
							    FileInputStream fis = new FileInputStream(lastModifiedFile);
							    workbook = new XSSFWorkbook(fis);
							    sheet = workbook.getSheetAt(0);		
							    /*
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
							    */
							    sheet = workbook.getSheetAt(0);
								int columnNumber = 3;
								int rowCount = 0;
								int actualRow=0;
								
								for(Row row : sheet)
								{
									
									org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
									if(cell != null) {
										
										rowCount++;
										actualRow = rowCount-1;
									}
									
								}
								fis.close();
				
								
								if(count2 == actualRow)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		         // MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }

				 MethodPOM.clickAllOverview().click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview().click();
				 Thread.sleep(4000);
				 test.log(LogStatus.PASS, "License Overview Button Working Successfully");
				 Thread.sleep(3000);
				 LiPerformerPOM.EntityLocation().click();
      			Thread.sleep(500);
				/*	LiPerformerPOM.EntityLocationExpand().click();
					Thread.sleep(500);
				//   LiPerformerPOM.aa1().click();
					Thread.sleep(500);
					LiPerformerPOM.demolocation().click();;
				   Thread.sleep(500);
				   String locationtext1 =LiPerformerPOM.locget().getText();
				   Thread.sleep(500);
				   LiPerformerPOM.locget().click();
				   Thread.sleep(3000);
				   LiPerformerPOM.clicklictypet().click();
				   Thread.sleep(500);
				   String LicenseType1 =LiPerformerPOM.Licensetypeinternal().getText();
				   Thread.sleep(5000);
				    LiPerformerPOM.Licensetypeinternal().click();
            Thread.sleep(5000);
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
			*/	
   }	
   
   public static void BystatusappliedInternalgraph( ExtentTest test, String type ) throws InterruptedException, IOException
   {
	   Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) getDriver() ;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickBystatusExpiredappliedbutnotrenewed()));	  
		String BystatusExpiredappliedbutnotrenewed=MethodPOM.clickBystatusExpiredappliedbutnotrenewed().getText();
		
	     int BystatusExpiredappliedbutnotrenewedgraph = Integer.parseInt(BystatusExpiredappliedbutnotrenewed);	//Reading Applied But not Renewed graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickBystatusExpiredappliedbutnotrenewed().click();					//Clicking on 'Applied but not Renewed' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickBystatusExpiredappliedbutnotrenewedReadCount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickBystatusExpiredappliedbutnotrenewedReadCount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseBystatusAppliedbutnotRenewedCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicenseBystatusAppliedbutnotRenewedCount);
			if(BystatusExpiredappliedbutnotrenewedgraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Applied But not Renewed License  grid matches to Dashboard By status Graph Applied But not Renewed License Count.");
					test.log(LogStatus.PASS, "No of Applied License  in the grid = "+total+" | Dashboard By Status Applied License  Count = "+BystatusExpiredappliedbutnotrenewedgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Applied But not Renewed License does not matches to Dashboard By Status Graph  Applied But not Renewed License   Count.");
					test.log(LogStatus.FAIL, "No of Applied License  in the grid = "+total+" | Dashboard By Status Applied License  Count = "+BystatusExpiredappliedbutnotrenewedgraph);
				}
			 MethodPOM.clickExportGraph().click();
			 Thread.sleep(3000);
		//	 test.log(LogStatus.PASS, "License Details Dwonloaded Successfully");
			 
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
						//js1.executeScript("window.scrollBy(0,1000)");
						
					
						Thread.sleep(100);
						File dir = new File("C://Users//deepalid//Downloads");
						File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(500);
						CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
						Thread.sleep(250);
						 MethodPOM.clickExportGraph().click();
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
							
						    FileInputStream fis = new FileInputStream(lastModifiedFile);
						    workbook = new XSSFWorkbook(fis);
						    sheet = workbook.getSheetAt(0);		
						    /*
							int no = sheet.getLastRowNum();
							Row row = sheet.getRow(no);
							org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
							int records =(int) c1.getNumericCellValue();
						    */
						    sheet = workbook.getSheetAt(0);
							int columnNumber = 3;
							int rowCount = 0;
							int actualRow=0;
							
							for(Row row : sheet)
							{
								
								org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
								if(cell != null) {
									
									rowCount++;
									actualRow = rowCount-1;
								}
								
							}
							fis.close();
			
							
							if(count2 == actualRow)
							{
								//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
								test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
							}
							else
							{
								//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
								test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
						}
				 }
	          
	         // MethodPOM.clickMyDashboard().click();
	          Thread.sleep(1000);
				  }
				  else
				  {
					   		      
					test.log(LogStatus.PASS,"No Record Found");
					MethodPOM.clickMyDashboard().click();
						      
				  }

			 MethodPOM.clickAllOverview().click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview().click();
			 Thread.sleep(4000);
			 test.log(LogStatus.PASS, "License Overview Button Working Successfully");
			 Thread.sleep(3000);

			   LiPerformerPOM.EntityLocation().click();
				Thread.sleep(500);
				  String locationtext1 =LiPerformerPOM.locget().getText();
					Thread.sleep(500);
				MethodPOM.Clicklocationsearch().click();
				Thread.sleep(500);
				
				 //  LiPerformerPOM.locget().click();
				MethodPOM.Clicklocationsearch().sendKeys("Regtrack Mumbai");
				Thread.sleep(500);
	       MethodPOM.Checkedlocation().click();
		   Thread.sleep(3000);
		   LiPerformerPOM.clicklictypet().click();
		   Thread.sleep(500);
		  LiPerformerPOM.selectinlictype().click();
		   String LicenseType1 =LiPerformerPOM.inlic().getText();
		   Thread.sleep(5000);
		   // LiPerformerPOM.inlic().click();
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
			
				
 
   
				/*Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph().click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
			 Thread.sleep(4000);
			 licmgmtPOM.clicktypeinternal().click();
			 Thread.sleep(5000);
			  licmgmtPOM.selecttypein().click();
				 Thread.sleep(5000);
				 MethodPOM.GraphPopupClear().click();
				 test.log(LogStatus.PASS, "Clear Button Working Successfully.");
				 Thread.sleep(3000);
				 
			 MethodPOM.clickappliedbutnotrenewedOverview().click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			 
			MethodPOM.clickBystatuscloseoverview().click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup().click();
			 Thread.sleep(3000);
			 */
			  } 
   
   public static void BystatusPendingForReviewInternalgraph( ExtentTest test, String type ) throws InterruptedException, IOException
   {
	   Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) getDriver() ;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickBystatusPendingForReviewInternal()));	  
		String BystatusExpiredappliedbutnotrenewed=MethodPOM.clickBystatusPendingForReviewInternal().getText();
		
	     int BystatusExpiredappliedbutnotrenewedgraph = Integer.parseInt(BystatusExpiredappliedbutnotrenewed);	//Reading Applied But not Renewed graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickBystatusPendingForReviewInternal().click();					//Clicking on 'Applied but not Renewed' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickBystatusExpiredappliedbutnotrenewedReadCount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickBystatusExpiredappliedbutnotrenewedReadCount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseBystatusAppliedbutnotRenewedCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicenseBystatusAppliedbutnotRenewedCount);
			if(BystatusExpiredappliedbutnotrenewedgraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Applied But not Renewed License  grid matches to Dashboard By status Graph Applied But not Renewed License Count.");
					test.log(LogStatus.PASS, "No of Pending For Review License  in the grid = "+total+" | Dashboard By Status Pending For Review License  Count = "+BystatusExpiredappliedbutnotrenewedgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Applied But not Renewed License does not matches to Dashboard By Status Graph  Applied But not Renewed License   Count.");
					test.log(LogStatus.FAIL, "No of Pending For Review License  in the grid = "+total+" | Dashboard By Status Pending For Review License  Count = "+BystatusExpiredappliedbutnotrenewedgraph);
				}
			 MethodPOM.clickExportGraph().click();
			 Thread.sleep(3000);
			// test.log(LogStatus.PASS, "License Details Dwonloaded Successfully");
			 
			 
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
						//js1.executeScript("window.scrollBy(0,1000)");
						
					
						Thread.sleep(100);
						File dir = new File("C://Users//deepalid//Downloads");
						File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(500);
						CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
						Thread.sleep(250);
						 MethodPOM.clickExportGraph().click();
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
							
						    FileInputStream fis = new FileInputStream(lastModifiedFile);
						    workbook = new XSSFWorkbook(fis);
						    sheet = workbook.getSheetAt(0);		
						    /*
							int no = sheet.getLastRowNum();
							Row row = sheet.getRow(no);
							org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
							int records =(int) c1.getNumericCellValue();
						    */
						    sheet = workbook.getSheetAt(0);
							int columnNumber = 3;
							int rowCount = 0;
							int actualRow=0;
							
							for(Row row : sheet)
							{
								
								org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
								if(cell != null) {
									
									rowCount++;
									actualRow = rowCount-1;
								}
								
							}
							fis.close();
			
							
							if(count2 == actualRow)
							{
								//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
								test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
							}
							else
							{
								//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
								test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
						}
				 }
	          
	         // MethodPOM.clickMyDashboard().click();
	          Thread.sleep(1000);
				  }
				  else
				  {
					   		      
					test.log(LogStatus.PASS,"No Record Found");
					MethodPOM.clickMyDashboard().click();
						      
				  }

			 MethodPOM.clickAllOverview().click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview().click();
			 Thread.sleep(4000);
			 test.log(LogStatus.PASS, "License Overview Button Working Successfully");
			 Thread.sleep(3000);
			  /* LiPerformerPOM.EntityLocation().click();
						Thread.sleep(500);
						  String locationtext1 =LiPerformerPOM.locget().getText();
							Thread.sleep(500);
						MethodPOM.Clicklocationsearch().click();
						Thread.sleep(500);
						
						 //  LiPerformerPOM.locget().click();
						MethodPOM.Clicklocationsearch().sendKeys("Regtrack Mumbai");
						Thread.sleep(500);
			       MethodPOM.Checkedlocation().click();
				   Thread.sleep(3000);
				   LiPerformerPOM.clicklictypet().click();
				   Thread.sleep(500);
				  LiPerformerPOM.selectinlictype().click();
				   String LicenseType1 =LiPerformerPOM.inlic().getText();
				   Thread.sleep(5000);
				   // LiPerformerPOM.inlic().click();
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
					
					*/	
		 
		   


   }
			 
   public static void BystatusExpired( ExtentTest test, String type ) throws InterruptedException, IOException
   {

	   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor)  getDriver();
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickBystatusExpired()));	  
		String BystatusExpired=MethodPOM.clickBystatusExpired().getText();
		
	     int BystatusExpiredgraph = Integer.parseInt(BystatusExpired);	//Reading Expired graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickBystatusExpired().click();					//Clicking on 'Expired' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickAllReadcount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseBystatusExpiredCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicenseBystatusExpiredCount);
			if(BystatusExpiredgraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Expired License  grid matches to Dashboard By status Graph Expired License Count.");
					test.log(LogStatus.PASS, "No of Expired License  in the grid = "+total+" | Dashboard By Status Expired License  Count = "+BystatusExpiredgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expired License does not matches to Dashboard By Status Graph Expired License   Count.");
					test.log(LogStatus.FAIL, "No of Expired License  in the grid = "+total+" | Dashboard By Status Expired License  Count = "+BystatusExpiredgraph);
				}
				Thread.sleep(3000);
				
				 MethodPOM.clickExportGraph().click();
				 Thread.sleep(3000);
				// test.log(LogStatus.PASS, "License Details Dwonloaded Successfully");
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
							//js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							 MethodPOM.clickExportGraph().click();
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
								
							    FileInputStream fis = new FileInputStream(lastModifiedFile);
							    workbook = new XSSFWorkbook(fis);
							    sheet = workbook.getSheetAt(0);		
							    /*
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
							    */
							    sheet = workbook.getSheetAt(0);
								int columnNumber = 3;
								int rowCount = 0;
								int actualRow=0;
								
								for(Row row : sheet)
								{
									
									org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
									if(cell != null) {
										
										rowCount++;
										actualRow = rowCount-1;
									}
									
								}
								fis.close();
				
								
								if(count2 == actualRow)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		         // MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }

				 MethodPOM.clickAllOverview().click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview().click();
				 Thread.sleep(4000);
				 test.log(LogStatus.PASS, "License Overview Button Working Successfully");
				 Thread.sleep(3000);
				/* LiPerformerPOM.EntityLocation().click();
      			Thread.sleep(500);
					LiPerformerPOM.EntityLocationExpand().click();
					Thread.sleep(500);
				//   LiPerformerPOM.aa1().click();
					Thread.sleep(500);
					LiPerformerPOM.demolocation().click();;
				   Thread.sleep(500);
				   String locationtext1 =LiPerformerPOM.locget().getText();
				   Thread.sleep(500);
				   LiPerformerPOM.locget().click();
				   Thread.sleep(3000);
				   LiPerformerPOM.clicklictypet().click();
				   Thread.sleep(500);
				   String LicenseType1 =LiPerformerPOM.Licensetypeinternal().getText();
				   Thread.sleep(5000);
				    LiPerformerPOM.Licensetypeinternal().click();
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
			*/	
   }

   public static void BystatusExpiredInternal( ExtentTest test, String type ) throws InterruptedException, IOException
   {

	   Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor)getDriver();
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickBystatusExpired()));	  
		String BystatusExpired=MethodPOM.clickBystatusExpired().getText();
		
	     int BystatusExpiredgraph = Integer.parseInt(BystatusExpired);	//Reading Expired graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickBystatusExpired().click();					//Clicking on 'Expired' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickAllReadcount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseBystatusExpiredCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicenseBystatusExpiredCount);
			if(BystatusExpiredgraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Expired License  grid matches to Dashboard By status Graph Expired License Count.");
					test.log(LogStatus.PASS, "No of Expired License  in the grid = "+total+" | Dashboard By Status Expired License  Count = "+BystatusExpiredgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expired License does not matches to Dashboard By Status Graph Expired License   Count.");
					test.log(LogStatus.FAIL, "No of Expired License  in the grid = "+total+" | Dashboard By Status Expired License  Count = "+BystatusExpiredgraph);
				}
			 MethodPOM.clickExportGraph().click();
			 Thread.sleep(3000);
			// test.log(LogStatus.PASS, "License Details Dwonloaded Successfully");
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
						//js1.executeScript("window.scrollBy(0,1000)");
						
					
						Thread.sleep(100);
						File dir = new File("C://Users//deepalid//Downloads");
						File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(500);
						CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
						Thread.sleep(250);
						 MethodPOM.clickExportGraph().click();
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
							
						    FileInputStream fis = new FileInputStream(lastModifiedFile);
						    workbook = new XSSFWorkbook(fis);
						    sheet = workbook.getSheetAt(0);		
						    /*
							int no = sheet.getLastRowNum();
							Row row = sheet.getRow(no);
							org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
							int records =(int) c1.getNumericCellValue();
						    */
						    sheet = workbook.getSheetAt(0);
							int columnNumber = 3;
							int rowCount = 0;
							int actualRow=0;
							
							for(Row row : sheet)
							{
								
								org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
								if(cell != null) {
									
									rowCount++;
									actualRow = rowCount-1;
								}
								
							}
							fis.close();
			
							
							if(count2 == actualRow)
							{
								//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
								test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
							}
							else
							{
								//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
								test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
						}
				 }
	          
	         // MethodPOM.clickMyDashboard().click();
	          Thread.sleep(1000);
				  }
				  else
				  {
					   		      
					test.log(LogStatus.PASS,"No Record Found");
					MethodPOM.clickMyDashboard().click();
						      
				  }

			 MethodPOM.clickAllOverview().click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview().click();
			 Thread.sleep(4000);
			 test.log(LogStatus.PASS, "License Overview Button Working Successfully");
			 Thread.sleep(3000);

			/*   LiPerformerPOM.EntityLocation().click();
				Thread.sleep(500);
				  String locationtext1 =LiPerformerPOM.locget().getText();
					Thread.sleep(500);
				MethodPOM.Clicklocationsearch().click();
				Thread.sleep(500);
				
				 //  LiPerformerPOM.locget().click();
				MethodPOM.Clicklocationsearch().sendKeys("Regtrack Mumbai");
				Thread.sleep(500);
	       MethodPOM.Checkedlocation().click();
		   Thread.sleep(3000);
		   LiPerformerPOM.clicklictypet().click();
		   Thread.sleep(500);
		  LiPerformerPOM.selectinlictype().click();
		   String LicenseType1 =LiPerformerPOM.inlic().getText();
		   Thread.sleep(5000);
		   // LiPerformerPOM.inlic().click();
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
				
				JavascriptExecutor js = (JavascriptExecutor)getDriver();
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
			
				*/
 
   
				/*Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph().click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
						 Thread.sleep(5000);
						 licmgmtPOM.clicktypeinternal().click();
						 Thread.sleep(5000);
						  licmgmtPOM.selecttypein().click();
							 Thread.sleep(5000);
							 MethodPOM.GraphPopupClear().click();
							 test.log(LogStatus.PASS, "Clear Button Working Successfully.");
							 Thread.sleep(5000);
							 
			 MethodPOM.clickAllOverview().click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			
			MethodPOM.clickBystatuscloseoverview().click();
			 Thread.sleep(4000);
			   Js1.executeScript("window.scrollBy(500,0)");
			   Thread.sleep(3000);
			.switchTo().parentFrame();
			 MethodPOM.clickCloseGraphPopup().click();
		
			  Thread.sleep(3000);
			  */
			  }
   
   public static void ByLicensetypeExpired( ExtentTest test, String type ) throws InterruptedException, IOException
   {

	   Thread.sleep(3000);
	   MethodPOM.clickDashlictype().click();
	   Thread.sleep(5000);
	   MethodPOM.serachlicforgrp().sendKeys("Shops & Commercial Establishment",Keys.ENTER);
	   Thread.sleep(5000);
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor)getDriver();
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 50);
	    Js1.executeScript("window.scrollBy(0,1000)");
	    Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeExpired()));	  
		String ByLicenseTypeExpired=MethodPOM.clickByLicnesetypeExpired().getText();
		
	     int ByLicensetypeExpiredgraph = Integer.parseInt(ByLicenseTypeExpired);	//Reading Expired graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeExpired().click();					//Clicking on 'Expired' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickAllReadcount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(ByLicensetypeCount);
			if(ByLicensetypeExpiredgraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Expired License  grid matches to Dashboard By Licnesetype Graph Expired License Count.");
					test.log(LogStatus.PASS, "No of Expired License  in the grid = "+total+" | Dashboard By Licnesetype Expired License  Count = "+ByLicensetypeExpiredgraph);
				}
				else
				{
				//	test.log(LogStatus.FAIL, "Number of Applied License does not matches to Dashboard By Licnesetype Graph Applied License   Count.");
					test.log(LogStatus.FAIL, "No of Expired License  in the grid = "+total+" | Dashboard By Licnesetype Expired License  Count = "+ByLicensetypeExpiredgraph);
				}
				Thread.sleep(3000);
				
				MethodPOM.clickExportGraph().click();
				 Thread.sleep(3000);
			//	 test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
				 Thread.sleep(1000);
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
							//js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							 MethodPOM.clickExportGraph().click();
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
								
							    FileInputStream fis = new FileInputStream(lastModifiedFile);
							    workbook = new XSSFWorkbook(fis);
							    sheet = workbook.getSheetAt(0);		
							    /*
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
							    */
							    sheet = workbook.getSheetAt(0);
								int columnNumber = 3;
								int rowCount = 0;
								int actualRow=0;
								
								for(Row row : sheet)
								{
									
									org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
									if(cell != null) {
										
										rowCount++;
										actualRow = rowCount-1;
									}
									
								}
								fis.close();
				
								
								if(count2 == actualRow)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		         // MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }

				 MethodPOM.clickAllOverview().click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			
		     test.log(LogStatus.PASS, " License Overview Details Successfully");
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview().click();
				 Thread.sleep(4000);
				 /*LiPerformerPOM.EntityLocation().click();
      			Thread.sleep(500);
					LiPerformerPOM.EntityLocationExpand().click();
					Thread.sleep(500);
				//   LiPerformerPOM.aa1().click();
					Thread.sleep(500);
					LiPerformerPOM.demolocation().click();;
				   Thread.sleep(500);
				   String locationtext1 =LiPerformerPOM.locget().getText();
				   Thread.sleep(500);
				   LiPerformerPOM.locget().click();
				   Thread.sleep(3000);
				   LiPerformerPOM.clicklictypet().click();
				   Thread.sleep(500);
				   String LicenseType1 =LiPerformerPOM.Licensetypeinternal().getText();
				   Thread.sleep(5000);
				    LiPerformerPOM.Licensetypeinternal().click();
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
					
					JavascriptExecutor js = (JavascriptExecutor)getDriver();
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
			*/
	}
   
   public static void ByLicensetypeExpiredInternal( ExtentTest test, String type ) throws InterruptedException, IOException
   {
	   Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   
		   MethodPOM.clickDashlictype().click();
		   Thread.sleep(5000);
		   MethodPOM.serachlic1().sendKeys("Annual Maintance",Keys.ENTER);
		   Thread.sleep(5000);
			   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
	   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) getDriver();
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 40);
	   // .findElement(By.xpath("//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-1']")).click();
	    Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeExpiredInternal()));	  
		String ByLicenseTypeExpired=MethodPOM.clickByLicnesetypeExpiredInternal().getText();
		
	     int ByLicensetypeExpiredgraph = Integer.parseInt(ByLicenseTypeExpired);	//Reading Expired graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeExpiredInternal().click();					//Clicking on 'Expired' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickAllReadcount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
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
				MethodPOM.clickExportGraph().click();
				 Thread.sleep(3000);
				// test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
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
							//js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							 MethodPOM.clickExportGraph().click();
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
								
							    FileInputStream fis = new FileInputStream(lastModifiedFile);
							    workbook = new XSSFWorkbook(fis);
							    sheet = workbook.getSheetAt(0);		
							    /*
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
							    */
							    sheet = workbook.getSheetAt(0);
								int columnNumber = 3;
								int rowCount = 0;
								int actualRow=0;
								
								for(Row row : sheet)
								{
									
									org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
									if(cell != null) {
										
										rowCount++;
										actualRow = rowCount-1;
									}
									
								}
								fis.close();
				
								
								if(count2 == actualRow)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		         // MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }

				 MethodPOM.clickAllOverview().click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview().click();
				 Thread.sleep(4000);
				 test.log(LogStatus.PASS, "License Overview Button Working Successfully");
				 Thread.sleep(3000);
				 /*  LiPerformerPOM.EntityLocation().click();
					Thread.sleep(500);
					  String locationtext1 =LiPerformerPOM.locget().getText();
						Thread.sleep(500);
					MethodPOM.Clicklocationsearch().click();
					Thread.sleep(500);
					
					 //  LiPerformerPOM.locget().click();
					MethodPOM.Clicklocationsearch().sendKeys("Regtrack Mumbai");
					Thread.sleep(500);
		       MethodPOM.Checkedlocation().click();
			   Thread.sleep(3000);
			   LiPerformerPOM.clicklictypet().click();
			   Thread.sleep(500);
			  LiPerformerPOM.selectinlictype().click();
			   String LicenseType1 =LiPerformerPOM.inlic().getText();
			   Thread.sleep(5000);
			   // LiPerformerPOM.inlic().click();
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
					
					JavascriptExecutor js = (JavascriptExecutor)getDriver();
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
			     }*/
			  } 
   
   public static void ByLicensetypeExpiring( ExtentTest test, String type ) throws InterruptedException, IOException
   {

	  getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   MethodPOM.clickDashlictype().click();
	   Thread.sleep(5000);
	   MethodPOM.serachlicforgrp().sendKeys("Shops & Commercial Establishment",Keys.ENTER);
	   Thread.sleep(5000);
	  JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
	   Js.executeScript("window.scrollBy(0,2000)");
	   WebDriverWait wait = new WebDriverWait( getDriver(), 40);
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeExpiring()));	  
		String ByLicenseTypeExpiring=MethodPOM.clickByLicnesetypeExpiring().getText();
		
	     int ByLicensetypeExpiringgraph = Integer.parseInt(ByLicenseTypeExpiring);	//Reading Expiring graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeExpiring().click();					//Clicking on 'Expiring' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	      JavascriptExecutor Js1 = (JavascriptExecutor)getDriver();
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickAllReadcount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
			if(!item.equalsIgnoreCase("No items to display"))
			{
				MethodPOM.clickAllReadcount().click();//Clicking on total items count
				Thread.sleep(5000);
				String item1 = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
			String[] bits = item1.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(ByLicensetypeCount);
			if(ByLicensetypeExpiringgraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Expiring License  grid matches to Dashboard By Licnesetype Graph Expiring License Count.");
					test.log(LogStatus.PASS, "No of Expiring License  in the grid = "+total+" | Dashboard By Licnese type-Expiring License  Count = "+ByLicensetypeExpiringgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expiring License does not matches to Dashboard By Licnese type Graph Expiring License   Count.");
					test.log(LogStatus.FAIL, "No of Expiring License  in the grid = "+total+" | Dashboard By Licnese type Expiring License  Count = "+ByLicensetypeExpiringgraph);
				}
			Thread.sleep(3000);
			 MethodPOM.clickAllOverview().click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
		
	     test.log(LogStatus.PASS, " License Overview Details Successfully");
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview().click();
			 Thread.sleep(4000);
		//	MethodPOM.clickExportGraph().click();
			 Thread.sleep(3000);
			 //test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
			 //Thread.sleep(1000);
			 CFOcountPOM.readTotalItems1().click();
				
				String item2 = CFOcountPOM.readTotalItems1().getText();
				//String NoRecord = LiReviewerPOM.reNorecord.getText();
				 if(!item2.equalsIgnoreCase("No items to display")) 
				 {
				String[] bits1 = item2.split(" ");								//Splitting the String
				String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
				int count2 = Integer.parseInt(compliancesCount1);
			//	String NoRecord = LiReviewerPOM.reNorecord().getText();
				//   if(!NoRecord.equalsIgnoreCase("No items to display")) 
				// {
					   try
						{
							performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
						}
						catch(Exception e)
						{
							
						}
						//js1.executeScript("window.scrollBy(0,1000)");
						
					
						Thread.sleep(100);
						File dir = new File("C://Users//deepalid//Downloads");
						File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(500);
						CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
						Thread.sleep(250);
						 MethodPOM.clickExportGraph().click();
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
							
						    FileInputStream fis = new FileInputStream(lastModifiedFile);
						    workbook = new XSSFWorkbook(fis);
						    sheet = workbook.getSheetAt(0);		
						    /*
							int no = sheet.getLastRowNum();
							Row row = sheet.getRow(no);
							org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
							int records =(int) c1.getNumericCellValue();
						    */
						    sheet = workbook.getSheetAt(0);
							int columnNumber = 3;
							int rowCount = 0;
							int actualRow=0;
							
							for(Row row : sheet)
							{
								
								org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
								if(cell != null) {
									
									rowCount++;
									actualRow = rowCount-1;
								}
								
							}
							fis.close();
			
							
							if(count2 == actualRow)
							{
								//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
								test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
							}
							else
							{
								//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
								test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
							}
						}
						else
						{
							test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
						}
						
				 }}
				/* LiPerformerPOM.EntityLocation().click();
	      			Thread.sleep(500);
						LiPerformerPOM.EntityLocationExpand().click();
						Thread.sleep(500);
					//   LiPerformerPOM.aa1().click();
						Thread.sleep(500);
						LiPerformerPOM.demolocation().click();;
					   Thread.sleep(500);
					   String locationtext1 =LiPerformerPOM.locget().getText();
					   Thread.sleep(500);
					   LiPerformerPOM.locget().click();
					   Thread.sleep(3000);
					   LiPerformerPOM.clicklictypet().click();
					   Thread.sleep(500);
					   String LicenseType1 =LiPerformerPOM.Licensetypeinternal().getText();
					   Thread.sleep(5000);
					    LiPerformerPOM.Licensetypeinternal().click();
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
	         // MethodPOM.clickMyDashboard().click();
	          Thread.sleep(1000);
				  }
				  else
				  {
					if(ByLicenseTypeExpiring=="0")
					{
						//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
						test.log(LogStatus.PASS, "For "+type+" No of Expiring License  in the grid = "+0+" | Dashboard By Licnese type Expiring License  Count = "+ByLicenseTypeExpiring);
					}
					else
					{
						test.log(LogStatus.FAIL, "For "+type+" No of Expiring License  in the grid = "+0+" |  Dashboard By Licnese type E License  Count = "+ByLicenseTypeExpiring);
					}
	
						      
				  }
		
		*/
		}

   
   public static void ByLicensetypeExpiringInternal( ExtentTest test, String type ) throws InterruptedException, IOException
   {
	  Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   MethodPOM.clickDashlictype().click();
		   Thread.sleep(5000);
		   MethodPOM.serachlic1().sendKeys("Annual Maintance",Keys.ENTER);
		   Thread.sleep(5000);
			   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   JavascriptExecutor Js1 = (JavascriptExecutor) getDriver();
		   Js1.executeScript("window.scrollBy(0,1000)");
		   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeExpiring()));	  
		String ByLicenseTypeExpiring=MethodPOM.clickByLicnesetypeExpiring().getText();
		
	     int ByLicensetypeExpiringgraph = Integer.parseInt(ByLicenseTypeExpiring);	//Reading Expiring graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeExpiring().click();					//Clicking on 'Expiring' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickAllReadcount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(ByLicensetypeCount);
			if(ByLicensetypeExpiringgraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Expiring License  grid matches to Dashboard By Licnesetype Graph Expiring License Count.");
					test.log(LogStatus.PASS, "No of Expiring License  in the grid = "+total+" | Dashboard By Licnese type-Expiring License  Count = "+ByLicensetypeExpiringgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Expiring License does not matches to Dashboard By Licnese type Graph Expiring License   Count.");
					test.log(LogStatus.FAIL, "No of Expiring License  in the grid = "+total+" | Dashboard By Licnese type Expiring License  Count = "+ByLicensetypeExpiringgraph);
				}
				Thread.sleep(3000);
				
				Thread.sleep(3000);
				MethodPOM.clickExportGraph().click();
				 Thread.sleep(3000);
				 //test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
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
							//js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							 MethodPOM.clickExportGraph().click();
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
								
							    FileInputStream fis = new FileInputStream(lastModifiedFile);
							    workbook = new XSSFWorkbook(fis);
							    sheet = workbook.getSheetAt(0);		
							    /*
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
							    */
							    sheet = workbook.getSheetAt(0);
								int columnNumber = 3;
								int rowCount = 0;
								int actualRow=0;
								
								for(Row row : sheet)
								{
									
									org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
									if(cell != null) {
										
										rowCount++;
										actualRow = rowCount-1;
									}
									
								}
								fis.close();
				
								
								if(count2 == actualRow)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		         // MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }

				 MethodPOM.clickAllOverview().click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview().click();
				 Thread.sleep(4000);
				 test.log(LogStatus.PASS, "License Overview Button Working Successfully");
				 Thread.sleep(3000);
				 /*  LiPerformerPOM.EntityLocation().click();
					Thread.sleep(500);
					  String locationtext1 =LiPerformerPOM.locget().getText();
						Thread.sleep(500);
					MethodPOM.Clicklocationsearch().click();
					Thread.sleep(500);
					
					 //  LiPerformerPOM.locget().click();
					MethodPOM.Clicklocationsearch().sendKeys("Regtrack Mumbai");
					Thread.sleep(500);
		       MethodPOM.Checkedlocation().click();
			   Thread.sleep(3000);
			   LiPerformerPOM.clicklictypet().click();
			   Thread.sleep(500);
			  LiPerformerPOM.selectinlictype().click();
			   String LicenseType1 =LiPerformerPOM.inlic().getText();
			   Thread.sleep(5000);
			   // LiPerformerPOM.inlic().click();
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
			     */
			  }	 
   
   public static void ByLicensetypeApplied( ExtentTest test, String type ) throws InterruptedException, IOException
   {

		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   Thread.sleep(3000);
	   MethodPOM.clickDashlictype().click();
	   Thread.sleep(5000);
	   MethodPOM.serachlic1().sendKeys("Shops & Commercial Establishment",Keys.ENTER);
	   Thread.sleep(5000);
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
	   JavascriptExecutor Js1 = (JavascriptExecutor)getDriver();
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 50);
	    Js1.executeScript("window.scrollBy(0,1000)");
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeApplied()));	  
		String ByLicenseTypeApplied=MethodPOM.clickByLicnesetypeApplied().getText();
		
	     int ByLicensetypeAppliedggraph = Integer.parseInt(ByLicenseTypeApplied);	//Reading Applied graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeApplied().click();					//Clicking on 'Applied' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver();getDriver();
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickAllReadcount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(ByLicensetypeCount);
			if(ByLicensetypeAppliedggraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Applied License  grid matches to Dashboard By Licnesetype Graph Applied License Count.");
					test.log(LogStatus.PASS, "No of Applied in the grid = "+total+" | Dashboard By Licnese type Applied License  Count = "+ByLicensetypeAppliedggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Applied License does not matches to Dashboard By Licnese type Graph Applied License   Count.");
					test.log(LogStatus.FAIL, "No of Applied License  in the grid = "+total+" | Dashboard By Licnese type Applied  License  Count = "+ByLicensetypeAppliedggraph);
				}
				Thread.sleep(3000);
				
				MethodPOM.clickExportGraph().click();
				 Thread.sleep(3000);
				// test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
				// Thread.sleep(1000);
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
							//js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							 MethodPOM.clickExportGraph().click();
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
								
							    FileInputStream fis = new FileInputStream(lastModifiedFile);
							    workbook = new XSSFWorkbook(fis);
							    sheet = workbook.getSheetAt(0);		
							    /*
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
							    */
							    sheet = workbook.getSheetAt(0);
								int columnNumber = 3;
								int rowCount = 0;
								int actualRow=0;
								
								for(Row row : sheet)
								{
									
									org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
									if(cell != null) {
										
										rowCount++;
										actualRow = rowCount-1;
									}
									
								}
								fis.close();
				
								
								if(count2 == actualRow)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		         // MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }

				 MethodPOM.clickAllOverview().click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			
		     test.log(LogStatus.PASS, " License Overview Details Successfully");
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview().click();
				 Thread.sleep(4000);
				/* LiPerformerPOM.EntityLocation().click();
      			Thread.sleep(500);
					LiPerformerPOM.EntityLocationExpand().click();
					Thread.sleep(500);
				//   LiPerformerPOM.aa1().click();
					Thread.sleep(500);
					LiPerformerPOM.demolocation().click();;
				   Thread.sleep(500);
				   String locationtext1 =LiPerformerPOM.locget().getText();
				   Thread.sleep(500);
				   LiPerformerPOM.locget().click();
				   Thread.sleep(3000);
				   LiPerformerPOM.clicklictypet().click();
				   Thread.sleep(500);
				   String LicenseType1 =LiPerformerPOM.Licensetypeinternal().getText();
				   Thread.sleep(5000);
				    LiPerformerPOM.Licensetypeinternal().click();
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
			*/
	}
			 
   public static void ByLicensetypePendingForReview( ExtentTest test, String type ) throws InterruptedException, IOException
   {

		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   Thread.sleep(3000);
	   MethodPOM.clickDashlictype().click();
	   Thread.sleep(5000);
	   MethodPOM.serachlic1().sendKeys("Shops & Commercial Establishment",Keys.ENTER);
	   Thread.sleep(5000);
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
	   JavascriptExecutor Js1 = (JavascriptExecutor)getDriver();
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 50);
	    Js1.executeScript("window.scrollBy(0,1000)");
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypePendingForReview()));	  
		String ByLicenseTypeApplied=MethodPOM.clickByLicnesetypePendingForReview().getText();
		
	     int ByLicensetypeAppliedggraph = Integer.parseInt(ByLicenseTypeApplied);	//Reading Applied graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypePendingForReview().click();					//Clicking on 'Applied' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver();getDriver();
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickAllReadcount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(ByLicensetypeCount);
			if(ByLicensetypeAppliedggraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Applied License  grid matches to Dashboard By Licnesetype Graph Applied License Count.");
					test.log(LogStatus.PASS, "No of Pending For Review in the grid = "+total+" | Dashboard By Licnese type Pending For Review License  Count = "+ByLicensetypeAppliedggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Applied License does not matches to Dashboard By Licnese type Graph Applied License   Count.");
					test.log(LogStatus.FAIL, "No of Pending For Review License  in the grid = "+total+" | Dashboard By Licnese type Pending For Review  License  Count = "+ByLicensetypeAppliedggraph);
				}
				Thread.sleep(3000);
				
				MethodPOM.clickExportGraph().click();
				 Thread.sleep(3000);
				// test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
				// Thread.sleep(1000);
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
							//js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							 MethodPOM.clickExportGraph().click();
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
								
							    FileInputStream fis = new FileInputStream(lastModifiedFile);
							    workbook = new XSSFWorkbook(fis);
							    sheet = workbook.getSheetAt(0);		
							    /*
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
							    */
							    sheet = workbook.getSheetAt(0);
								int columnNumber = 3;
								int rowCount = 0;
								int actualRow=0;
								
								for(Row row : sheet)
								{
									
									org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
									if(cell != null) {
										
										rowCount++;
										actualRow = rowCount-1;
									}
									
								}
								fis.close();
				
								
								if(count2 == actualRow)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		         // MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }

				 MethodPOM.clickAllOverview().click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			
		     test.log(LogStatus.PASS, " License Overview Details Successfully");
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview().click();
				 Thread.sleep(4000);
				/* LiPerformerPOM.EntityLocation().click();
      			Thread.sleep(500);
					LiPerformerPOM.EntityLocationExpand().click();
					Thread.sleep(500);
				//   LiPerformerPOM.aa1().click();
					Thread.sleep(500);
					LiPerformerPOM.demolocation().click();;
				   Thread.sleep(500);
				   String locationtext1 =LiPerformerPOM.locget().getText();
				   Thread.sleep(500);
				   LiPerformerPOM.locget().click();
				   Thread.sleep(3000);
				   LiPerformerPOM.clicklictypet().click();
				   Thread.sleep(500);
				   String LicenseType1 =LiPerformerPOM.Licensetypeinternal().getText();
				   Thread.sleep(5000);
				    LiPerformerPOM.Licensetypeinternal().click();
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
			     }*/
   }
   public static void ByLicensetypeAppliedInternal( ExtentTest test, String type ) throws InterruptedException, IOException
   {
	   Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   MethodPOM.clickDashlictype().click();
		   Thread.sleep(5000);
		   MethodPOM.serachlic1().sendKeys("Annual Maintance",Keys.ENTER);
		   Thread.sleep(5000);
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	   JavascriptExecutor Js1 = (JavascriptExecutor)getDriver() ;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 50);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeAppliedInternal()));	  
		String ByLicenseTypeApplied=MethodPOM.clickByLicnesetypeAppliedInternal().getText();
		
	     int ByLicensetypeAppliedggraph = Integer.parseInt(ByLicenseTypeApplied);	//Reading Applied graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeAppliedInternal().click();					//Clicking on 'Applied' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver() ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickAllReadcount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
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
				
				MethodPOM.clickExportGraph().click();
				 Thread.sleep(3000);
				 //test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
				 Thread.sleep(1000);
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
							//js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							 MethodPOM.clickExportGraph().click();
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
								
							    FileInputStream fis = new FileInputStream(lastModifiedFile);
							    workbook = new XSSFWorkbook(fis);
							    sheet = workbook.getSheetAt(0);		
							    /*
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
							    */
							    sheet = workbook.getSheetAt(0);
								int columnNumber = 3;
								int rowCount = 0;
								int actualRow=0;
								
								for(Row row : sheet)
								{
									
									org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
									if(cell != null) {
										
										rowCount++;
										actualRow = rowCount-1;
									}
									
								}
								fis.close();
				
								
								if(count2 == actualRow)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		         // MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }

				 MethodPOM.clickAllOverview().click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview().click();
				 Thread.sleep(4000);
				 test.log(LogStatus.PASS, "License Overview Button Working Successfully");
				 Thread.sleep(3000);

				   LiPerformerPOM.EntityLocation().click();
					Thread.sleep(500);
					  String locationtext1 =LiPerformerPOM.locget().getText();
						Thread.sleep(500);
					MethodPOM.Clicklocationsearch().click();
					Thread.sleep(500);
					
					 //  LiPerformerPOM.locget().click();
					MethodPOM.Clicklocationsearch().sendKeys("Regtrack Mumbai");
					Thread.sleep(500);
		       MethodPOM.Checkedlocation().click();
			   Thread.sleep(3000);
			   LiPerformerPOM.clicklictypet().click();
			   Thread.sleep(500);
			  LiPerformerPOM.selectinlictype().click();
			   String LicenseType1 =LiPerformerPOM.inlic().getText();
			   Thread.sleep(5000);
			   // LiPerformerPOM.inlic().click();
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
   
   public static void ByLicensetypePendingForReviewInternal( ExtentTest test, String type ) throws InterruptedException, IOException
   {
	   Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   MethodPOM.clickDashlictype().click();
		   Thread.sleep(5000);
		   MethodPOM.serachlic1().sendKeys("Annual Maintance",Keys.ENTER);
		   Thread.sleep(5000);
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	   JavascriptExecutor Js1 = (JavascriptExecutor)getDriver() ;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 50);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickBylicensetypePendingForReviewInternal()));	  
		String ByLicenseTypeApplied=MethodPOM.clickBylicensetypePendingForReviewInternal().getText();
		
	     int ByLicensetypeAppliedggraph = Integer.parseInt(ByLicenseTypeApplied);	//Reading Applied graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickBylicensetypePendingForReviewInternal().click();					//Clicking on 'Applied' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver() ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickAllReadcount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
		//	int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(ByLicensetypeCount);
			if(ByLicensetypeAppliedggraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Applied License  grid matches to Dashboard By Licnesetype Graph Applied License Count.");
					test.log(LogStatus.PASS, "No of Pending For Review License  in the grid = "+total+" | Dashboard By Licnese type Pending For Review License  Count = "+ByLicensetypeAppliedggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Applied License does not matches to Dashboard By Licnese type Graph Applied License   Count.");
					test.log(LogStatus.FAIL, "No of Pending For Review License  in the grid = "+total+" | Dashboard By Licnese type Pending For Review License  Count = "+ByLicensetypeAppliedggraph);
				}
				Thread.sleep(3000);
				
				MethodPOM.clickExportGraph().click();
				 Thread.sleep(3000);
				// test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
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
							//js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							 MethodPOM.clickExportGraph().click();
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
								
							    FileInputStream fis = new FileInputStream(lastModifiedFile);
							    workbook = new XSSFWorkbook(fis);
							    sheet = workbook.getSheetAt(0);		
							    /*
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
							    */
							    sheet = workbook.getSheetAt(0);
								int columnNumber = 3;
								int rowCount = 0;
								int actualRow=0;
								
								for(Row row : sheet)
								{
									
									org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
									if(cell != null) {
										
										rowCount++;
										actualRow = rowCount-1;
									}
									
								}
								fis.close();
				
								
								if(count2 == actualRow)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		         // MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }

				 MethodPOM.clickAllOverview().click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview().click();
				 Thread.sleep(4000);
				 test.log(LogStatus.PASS, "License Overview Button Working Successfully");
				 Thread.sleep(3000);

				 /*  LiPerformerPOM.EntityLocation().click();
					Thread.sleep(500);
					  String locationtext1 =LiPerformerPOM.locget().getText();
						Thread.sleep(500);
					MethodPOM.Clicklocationsearch().click();
					Thread.sleep(500);
					
					 //  LiPerformerPOM.locget().click();
					MethodPOM.Clicklocationsearch().sendKeys("Regtrack Mumbai");
					Thread.sleep(500);
		       MethodPOM.Checkedlocation().click();
			   Thread.sleep(3000);
			   LiPerformerPOM.clicklictypet().click();
			   Thread.sleep(500);
			  LiPerformerPOM.selectinlictype().click();
			   String LicenseType1 =LiPerformerPOM.inlic().getText();
			   Thread.sleep(5000);
			   // LiPerformerPOM.inlic().click();
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
			*/
			  } 
   

   public static void ByLicensetypeActive( ExtentTest test, String type ) throws InterruptedException, IOException
   {

	   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	   Thread.sleep(3000);
	    WebDriverWait wait = new WebDriverWait( getDriver(), 60);
	    Thread.sleep(3000);
		   MethodPOM.clickDashlictype().click();
		   Thread.sleep(5000);
		   MethodPOM.serachlic1().sendKeys("Shops & Commercial Establishment",Keys.ENTER);
		   Thread.sleep(5000);
			LicenseCompanyadmin.MethodPOM.ClickApply().click();
			   Thread.sleep(3000);
			   JavascriptExecutor Js1 = (JavascriptExecutor)getDriver() ;
			   Js1.executeScript("window.scrollBy(0,1000)");
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeActive()));	  
		String ByLicenseTypeActive=MethodPOM.clickByLicnesetypeActive().getText();
		
	      int ByLicensetypeActiveggraph = Integer.parseInt(ByLicenseTypeActive);	//Reading Active graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeActive().click();					//Clicking on 'Active' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver();getDriver() ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickAllReadcount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
			if(!item.equalsIgnoreCase("No items to display"))
			{
				MethodPOM.clickAllReadcount().click();//Clicking on total items count
				Thread.sleep(5000);
				String item1 = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
			String[] bits = item1.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
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
				 MethodPOM.clickAllOverview().click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			
		     test.log(LogStatus.PASS, " License Overview Details Successfully");
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview().click();
				 Thread.sleep(4000);
			//	MethodPOM.clickExportGraph().click();
				 Thread.sleep(3000);
				 //test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
				 //Thread.sleep(1000);
				 CFOcountPOM.readTotalItems1().click();
					
					String item2 = CFOcountPOM.readTotalItems1().getText();
					//String NoRecord = LiReviewerPOM.reNorecord.getText();
					 if(!item2.equalsIgnoreCase("No items to display")) 
					 {
					String[] bits1 = item2.split(" ");								//Splitting the String
					String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
					int count2 = Integer.parseInt(compliancesCount1);
				//	String NoRecord = LiReviewerPOM.reNorecord().getText();
					//   if(!NoRecord.equalsIgnoreCase("No items to display")) 
					// {
						   try
							{
								performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
							}
							catch(Exception e)
							{
								
							}
							//js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							 MethodPOM.clickExportGraph().click();
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
								
							    FileInputStream fis = new FileInputStream(lastModifiedFile);
							    workbook = new XSSFWorkbook(fis);
							    sheet = workbook.getSheetAt(0);		
							    /*
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
							    */
							    sheet = workbook.getSheetAt(0);
								int columnNumber = 3;
								int rowCount = 0;
								int actualRow=0;
								
								for(Row row : sheet)
								{
									
									org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
									if(cell != null) {
										
										rowCount++;
										actualRow = rowCount-1;
									}
									
								}
								fis.close();
				
								
								if(count2 == actualRow)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
							
					 }
					/* LiPerformerPOM.EntityLocation().click();
		      			Thread.sleep(500);
							LiPerformerPOM.EntityLocationExpand().click();
							Thread.sleep(500);
						//   LiPerformerPOM.aa1().click();
							Thread.sleep(500);
							LiPerformerPOM.demolocation().click();;
						   Thread.sleep(500);
						   String locationtext1 =LiPerformerPOM.locget().getText();
						   Thread.sleep(500);
						   LiPerformerPOM.locget().click();
						   Thread.sleep(3000);
						   LiPerformerPOM.clicklictypet().click();
						   Thread.sleep(500);
						   String LicenseType1 =LiPerformerPOM.Licensetypeinternal().getText();
						   Thread.sleep(5000);
						    LiPerformerPOM.Licensetypeinternal().click();
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
		         // MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						if(ByLicenseTypeActive=="0")
						{
							//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
							test.log(LogStatus.PASS, "For "+type+" No of Active License  in the grid = "+0+" | Dashboard By Licnese type Active License  Count = "+ByLicenseTypeActive);
						}
						else
						{
							test.log(LogStatus.FAIL, "For "+type+" No of Active License  in the grid = "+0+" |  Dashboard By Licnese type Active License  Count = "+ByLicenseTypeActive);
						}
		
							*/      
					  }
			
			
			}

   
	
			  
   
   public static void ByLicensetypeActiveInternal( ExtentTest test, String type ) throws InterruptedException, IOException
   {
      
	   Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   
		   MethodPOM.clickDashlictype().click();
		   Thread.sleep(5000);
		   MethodPOM.serachlic1().sendKeys("Annual maintenance",Keys.ENTER);
		   Thread.sleep(5000);
			   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
	   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) getDriver();
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 60);
	 //   getDriver().findElement(By.xpath("//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-1']")).click();
	    Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeActiveInternal()));	  
		String ByLicenseTypeActive=MethodPOM.clickByLicnesetypeActiveInternal().getText();
		
	     int ByLicensetypeActiveggraph = Integer.parseInt(ByLicenseTypeActive);	//Reading Active graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeActiveInternal().click();					//Clicking on 'Active' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver();getDriver() ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickAllReadcount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
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
				MethodPOM.clickExportGraph().click();
				 Thread.sleep(3000);
				// test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
				 Thread.sleep(1000);
				
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
							//js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							 MethodPOM.clickExportGraph().click();
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
								
							    FileInputStream fis = new FileInputStream(lastModifiedFile);
							    workbook = new XSSFWorkbook(fis);
							    sheet = workbook.getSheetAt(0);		
							    /*
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
							    */
							    sheet = workbook.getSheetAt(0);
								int columnNumber = 3;
								int rowCount = 0;
								int actualRow=0;
								
								for(Row row : sheet)
								{
									
									org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
									if(cell != null) {
										
										rowCount++;
										actualRow = rowCount-1;
									}
									
								}
								fis.close();
				
								
								if(count2 == actualRow)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		         // MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }

				 MethodPOM.clickAllOverview().click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview().click();
				 Thread.sleep(4000);
				 test.log(LogStatus.PASS, "License Overview Button Working Successfully");
				 Thread.sleep(3000);

				   LiPerformerPOM.EntityLocation().click();
					Thread.sleep(500);
					  String locationtext1 =LiPerformerPOM.locget().getText();
						Thread.sleep(500);
					MethodPOM.Clicklocationsearch().click();
					Thread.sleep(500);
					
					 //  LiPerformerPOM.locget().click();
					MethodPOM.Clicklocationsearch().sendKeys("Regtrack Mumbai");
					Thread.sleep(500);
		       MethodPOM.Checkedlocation().click();
			   Thread.sleep(3000);
			   LiPerformerPOM.clicklictypet().click();
			   Thread.sleep(500);
			  LiPerformerPOM.selectinlictype().click();
			   String LicenseType1 =LiPerformerPOM.inlic().getText();
			   Thread.sleep(5000);
			   // LiPerformerPOM.inlic().click();
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
   
   public static void ByLicensetypeTerminated( ExtentTest test, String type ) throws InterruptedException, IOException
   {

	   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   
	   Thread.sleep(3000);
	    WebDriverWait wait = new WebDriverWait( getDriver(), 60);
	    Thread.sleep(3000);
		   MethodPOM.clickDashlictype().click();
		   Thread.sleep(5000);
		   MethodPOM.serachlic1().sendKeys("Shops & Commercial Establishment",Keys.ENTER);
		   Thread.sleep(5000);
			   LicenseCompanyadmin.MethodPOM.ClickApply().click();
			   JavascriptExecutor Js1 = (JavascriptExecutor)getDriver();
			   Js1.executeScript("window.scrollBy(0,1000)");
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeTerminate()));	  
		String ByLicenseTypeTerminate=MethodPOM.clickByLicnesetypeTerminate().getText();
		
	     int ByLicensetypeTerminateggraph = Integer.parseInt(ByLicenseTypeTerminate);	//Reading Terminate graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeTerminate().click();					//Clicking on 'Terminate' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver();getDriver();
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickAllReadcount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
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
				
				MethodPOM.clickExportGraph().click();
				 Thread.sleep(3000);
				// test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
				// Thread.sleep(1000);
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
							//js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							 MethodPOM.clickExportGraph().click();
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
								
							    FileInputStream fis = new FileInputStream(lastModifiedFile);
							    workbook = new XSSFWorkbook(fis);
							    sheet = workbook.getSheetAt(0);		
							    /*
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
							    */
							    sheet = workbook.getSheetAt(0);
								int columnNumber = 3;
								int rowCount = 0;
								int actualRow=0;
								
								for(Row row : sheet)
								{
									
									org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
									if(cell != null) {
										
										rowCount++;
										actualRow = rowCount-1;
									}
									
								}
								fis.close();
				
								
								if(count2 == actualRow)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		         // MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }

				 MethodPOM.clickAllOverview().click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			
		     test.log(LogStatus.PASS, " License Overview Details Successfully");
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview().click();
				 Thread.sleep(4000);
				/* LiPerformerPOM.EntityLocation().click();
					Thread.sleep(500);
					//LiPerformerPOM.locationsearch().sendKeys("Demo Bharat Gujarat1");
					//LiPerformerPOM.aa().click();
					//Thread.sleep(500);
					LiPerformerPOM.EntityLocationExpand().click();
					//Thread.sleep(500);
				  // LiPerformerPOM.aa1().click();
					LiPerformerPOM.demolocation().click();
					
				   Thread.sleep(500);
				   String locationtext1 =LiPerformerPOM.locget().getText();
				   LiPerformerPOM.locget().click();
				   Thread.sleep(3000);
				   LiPerformerPOM.clicklictypet().click();
				   Thread.sleep(500);
				   String LicenseType1 =LiPerformerPOM.Licensetypeinternal().getText();
				   Thread.sleep(5000);
				    LiPerformerPOM.Licensetypeinternal().click();
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
			*/
	}
			 
   
   public static void ByLicensetypeTerminateInternal( ExtentTest test, String type ) throws InterruptedException
   {
	   Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   

		   MethodPOM.clickDashlictype().click();
		   Thread.sleep(5000);
		   MethodPOM.serachlic1().sendKeys("Annual maintenance",Keys.ENTER);
		   Thread.sleep(5000);
			   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
	   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) getDriver();
	   Js1.executeScript("window.scrollBy(0,1000)");
	   //getDriver().findElement(By.xpath("//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-0']")).click();
	   Thread.sleep(3000);
	 //  getDriver().findElement(By.xpath("//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-1']")).click();
	   Thread.sleep(3000);
	  // getDriver().findElement(By.xpath("//*[@class='highcharts-legend-item highcharts-column-series highcharts-color-undefined highcharts-series-2']")).click();
	   
	    WebDriverWait wait = new WebDriverWait( getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeTerminateInternal()));	  
		String ByLicenseTypeTerminate=MethodPOM.clickByLicnesetypeTerminateInternal().getText();
		
	    int ByLicensetypeTerminateggraph = Integer.parseInt(ByLicenseTypeTerminate);	//Reading Terminate graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeTerminateInternal().click();					//Clicking on 'Terminate' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver();getDriver();
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickAllReadcount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
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
				
				MethodPOM.clickExportGraph().click();
				 Thread.sleep(3000);
				 test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
				 Thread.sleep(1000);
				
				 MethodPOM.clickAllOverview().click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
			
		     test.log(LogStatus.PASS, " License Overview Details Successfully");
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview().click();
				 Thread.sleep(4000);
				/* LiPerformerPOM.EntityLocation().click();
					Thread.sleep(500);
					//LiPerformerPOM.locationsearch().sendKeys("Demo Bharat Gujarat1");
					//LiPerformerPOM.aa().click();
					//Thread.sleep(500);
					LiPerformerPOM.EntityLocationExpand().click();
					//Thread.sleep(500);
				  // LiPerformerPOM.aa1().click();
					LiPerformerPOM.demolocation().click();
					
				   Thread.sleep(500);

				   String locationtext1 =LiPerformerPOM.locget().getText();
				   LiPerformerPOM.locget().click();
				   Thread.sleep(3000);
				   LiPerformerPOM.clicklictypet().click();
				   Thread.sleep(500);
				   String LicenseType1 =LiPerformerPOM.Licensetypeinternal().getText();
				   Thread.sleep(5000);
				    LiPerformerPOM.Licensetypeinternal().click();
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
			*/
			  }	 
   public static void ByLicensetypeRejectedInternal( ExtentTest test, String type ) throws InterruptedException
   {
	   Thread.sleep(3000);
		  LicenseCompanyadmin.MethodPOM.AllFilter().click();
		   Thread.sleep(3000);
		   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
		   

		   MethodPOM.clickDashlictype().click();
		   Thread.sleep(5000);
		   MethodPOM.serachlicforgrp().sendKeys("Annual Maintance",Keys.ENTER);
		   Thread.sleep(5000);
			   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
	   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) getDriver();
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 60);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeRejectedInternal()));	  
		String ByLicenseTypeRejected=MethodPOM.clickByLicnesetypeRejectedInternal().getText();
		
	    int ByLicensetypeRejectedggraph = Integer.parseInt(ByLicenseTypeRejected);	//Reading Terminate graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickByLicnesetypeRejectedInternal().click();					//Clicking on 'Terminate' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver();getDriver();
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickAllReadcount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(ByLicensetypeCount);
			if(ByLicensetypeRejectedggraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Terminate License  grid matches to Dashboard By Licnesetype Graph Terminate License Count.");
					test.log(LogStatus.PASS, "No of Rejected License  in the grid = "+total+" | Dashboard By Licnese type Rejected License  Count = "+ByLicensetypeRejectedggraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Terminate License does not matches to Dashboard By Licnese type Graph Terminate License   Count.");
					test.log(LogStatus.FAIL, "No of Terminate License  in the grid = "+total+" | Dashboard By Licnese type Terminate License  Count = "+ByLicensetypeRejectedggraph);
				}
				Thread.sleep(3000);
				
			 MethodPOM.clickExportGraph().click();
			 Thread.sleep(3000);
			 test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
			 Thread.sleep(1000);
			
			 MethodPOM.clickAllOverview().click();
			 Thread.sleep(3000);
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
		
	     test.log(LogStatus.PASS, " License Overview Details Successfully");
			 Thread.sleep(3000);
			MethodPOM.clickBystatuscloseoverview().click();
			 Thread.sleep(4000);
			 /*LiPerformerPOM.EntityLocation().click();
				Thread.sleep(500);
				//LiPerformerPOM.locationsearch().sendKeys("Demo Bharat Gujarat1");
				//LiPerformerPOM.aa().click();
				//Thread.sleep(500);
				LiPerformerPOM.EntityLocationExpand().click();
				//Thread.sleep(500);
			  // LiPerformerPOM.aa1().click();
				LiPerformerPOM.demolocation().click();
				
						   Thread.sleep(500);
			   String locationtext1 =LiPerformerPOM.locget().getText();
			   LiPerformerPOM.locget().click();
			   Thread.sleep(3000);
			   LiPerformerPOM.clicklictypet().click();
			   Thread.sleep(500);
			   String LicenseType1 =LiPerformerPOM.Licensetypeinternal().getText();
			   Thread.sleep(5000);
			    LiPerformerPOM.Licensetypeinternal().click();
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
		*/
}

			 
   public static void MyWorkspace( ExtentTest test, String type) throws InterruptedException, IOException
   {
	   WebDriverWait wait = new WebDriverWait( getDriver(), 20);
	   MethodPOM.ClickMyWorkspace().click();
	   Thread.sleep(5000);
	   MethodPOM.clickWrklictype().click();
	   Thread.sleep(7000);
	  // MethodPOM.Searchtype().sendKeys("Boiler",Keys.ENTER);
	   MethodPOM.Click1().click();
	   Thread.sleep(7000);
	   MethodPOM.Clearfilter().click();
	  // test.log(LogStatus.PASS, "Clear Button Working Successfully");
	   Thread.sleep(7000);
	   MethodPOM.MyworkspaceOverview().click();
	   Thread.sleep(7000);
	   MethodPOM.Overviewclose().click();
	   test.log(LogStatus.PASS, "Overview  Button Working Successfully");
	   licmgmtPOM.ClickAddLicense().click();
		 
		 Thread.sleep(3000);	
		 licmgmtPOM.ClickLicenseTypeDropdown().click();
		 licmgmtPOM.SelectLicenseType().click();
		 
		 Thread.sleep(500);
		 licmgmtPOM.ClickLocation().click();
		 Thread.sleep(200);
		 licmgmtPOM.LocationMaximize().click();
		 Thread.sleep(3000);
		 licmgmtPOM.SelectLocation().click();
		 
		 Thread.sleep(3000);
		 licmgmtPOM.ClickCompliance().click();
		 Thread.sleep(5000);
		 licmgmtPOM.SelectLicenseCompliance().get(1).click();
		 
		 Thread.sleep(5000);
		 licmgmtPOM.ClickPerformer().click();
		 Thread.sleep(6000);
		 licmgmtPOM.SelectPerformer().get(3).click();
		// licmgmtPOM.SelectPerformer().click();
		 
		 Thread.sleep(3000);
		 licmgmtPOM.ClickReviewer().click();
		 Thread.sleep(6000);
		 licmgmtPOM.SelectReviewer().get(111).click(); 
		 
		 XSSFSheet Sheet= ReadExcel();
		 Thread.sleep(3000);
		 sheet = workbook.getSheetAt(2);
		 Row row6= sheet.getRow(6);
		  org.apache.poi.ss.usermodel.Cell c1 = row6.getCell(1);	
		 String LicenseTitle= c1.getStringCellValue();
		 licmgmtPOM.LicenseTitle().sendKeys(LicenseTitle);
		 
		 Thread.sleep(3000);
		 Row row7=sheet.getRow(7);
			org.apache.poi.ss.usermodel.Cell c2=row7.getCell(1);
		 String LicenseNo=c2.getStringCellValue();
		 licmgmtPOM.LicenseNo().sendKeys(LicenseNo);
		 
		 Thread.sleep(3000);
		 Row row8=sheet.getRow(8);
			org.apache.poi.ss.usermodel.Cell c3=row8.getCell(1);
		 String ApplicationDays=c3.getStringCellValue();
		 licmgmtPOM.ApplicationDays().sendKeys(ApplicationDays);
		 
		 Thread.sleep(3000);
		 Row row9=sheet.getRow(9);
			org.apache.poi.ss.usermodel.Cell c4=row9.getCell(1);
		 String LicenseCost=c4.getStringCellValue();
		 licmgmtPOM.LicenseCost().sendKeys(LicenseCost);
		 
		 licmgmtPOM.ClickCal().click();
		 Thread.sleep(7000);
		 licmgmtPOM.NewDate().click();
		 Thread.sleep(5000);
		licmgmtPOM.ClickCal1().click();
		 Thread.sleep(7000);
		licmgmtPOM.NewEndDate().click();
		
		 
		Thread.sleep(300);
		// licmgmtPOM.Chooesfile().click();
			//String workingDir = System.getProperty("user.dir");
			//licmgmtPOM.Chooesfile().sendKeys(workingDir+"//Reports//LicensePerformerResults(Statutory).html");
      

	      JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
			js1.executeScript("window.scroll(0,2000)");
		 licmgmtPOM.ClickNomineedrp().click();
		 Thread.sleep(3000);
		 licmgmtPOM.SelectNominee().click();
		 Thread.sleep(5000);
		 licmgmtPOM.ClickModificdate().click();
		 Thread.sleep(5000);
		 licmgmtPOM.ModificatioDate().click();
		 Thread.sleep(5000);
		 licmgmtPOM.nomineestartdatecal().click();
		 Thread.sleep(3000);
		 licmgmtPOM.selectnominstartdate().click();
		 Thread.sleep(3000);
		 JavascriptExecutor js2=(JavascriptExecutor)getDriver()  ;
			js2.executeScript("window.scroll(0,2000)");
		 licmgmtPOM.nomineeEnddatecal().click();
		 Thread.sleep(5000);
		 licmgmtPOM.selectnomineenddate().click();
		 Thread.sleep(5000);
		 licmgmtPOM.Nomineesubmit().click();
	
		
	   
	   
   }
   public static void MyDocuments( ExtentTest test, String type) throws InterruptedException
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
			LiPerformerPOM.clickType22().click();			//Clicking on 'Type' drop down.
			Thread.sleep(5000);
			LiPerformerPOM.selectInternal().click();//Selecting 'Internal' option.
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
			/*String PerformerColumn = LiPerformerPOM.PerformerColumn1().getText();
			   if(PerformerColumn.equalsIgnoreCase("Performer")) 
			   {
				   
					test.log(LogStatus.PASS, "In Grid Performer Column Displayed.");
			   }
			   else
			   {
				   test.log(LogStatus.FAIL,"In Grid Performer Column Not Displayed.");
			   }
				*/Thread.sleep(3000);
			 String Reviewercolumn = MethodPOM.ReviewerColumn().getText();
			   if(MethodPOM.ReviewerColumn().isDisplayed())
			   {
				   
					test.log(LogStatus.PASS, "In grid Reviewer Column displayed.");
			   }
			   else
			   {
				   test.log(LogStatus.FAIL,"Reviewer Column Not Displayed");
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
		
		Thread.sleep(5000);
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
		String PerformerColumn = LiPerformerPOM.PerformerColumn1().getText();
		   if(PerformerColumn.equalsIgnoreCase("Performer")) 
		   {
			   
				test.log(LogStatus.PASS, "In Grid Performer Column Displayed.");
		   }
		   else
		   {
			   test.log(LogStatus.FAIL,"In Grid Performer Column Not Displayed.");
		   }
			Thread.sleep(3000);
		 String Reviewercolumn = MethodPOM.ReviewerColumn().getText();
		   if(MethodPOM.ReviewerColumn().isDisplayed())
		   {
			   
				test.log(LogStatus.PASS, "In grid Reviewer Column displayed.");
		   }
		   else
		   {
			   test.log(LogStatus.FAIL,"Reviewer Column Not Displayed");
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
	
		//wait.until(ExpectedConditions.elementToBeClickable(MethodPOM.clickMyDashboard()));
		//Thread.sleep(3000);
		//OverduePOM.clickDashboard().click();
	
   public static void MyReports( ExtentTest test, String type) throws InterruptedException, IOException
	{
			WebDriverWait wait = new WebDriverWait( getDriver(), 20);
			
			//wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired()));
			
			LiPerformerPOM.clickMyReport().click();		//Clicking on 'My Reports'
			
			//progress();
			
			wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1()));	//Waiting until records table gets visible.
			
			if(type.equalsIgnoreCase("Internal"))
			{
				LiPerformerPOM.clickType2().click();			//Clicking on 'Type' drop down.
				Thread.sleep(500);
				LiPerformerPOM.selectInternal().click();//Selecting 'Internal' option.
				Thread.sleep(1000);
				//progress();
			}
			
			CheckReports(test, 1, "Active");
			
			CheckReports( test, 2, "Expired");
			
			CheckReports( test, 3, "Expiring");
			
			CheckReports( test, 4, "Applied");
			
			CheckReports( test, 5, "Applied but Pending for Renewal");
			
			CheckReports( test, 6, "Renewed");
			
			CheckReports(test, 7, "Rejected");
			
			Thread.sleep(500);
			getDriver().findElement(By.xpath("//*[@id=\'grid\']/div[2]/table/tbody/tr[1]/td[16]/a")).click();
		    Thread.sleep(500);
		    getDriver().findElement(By.xpath("//*[@id=\"divShowReminderDialog\"]/div/div/div[1]/button")).click();
		     
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
			
			OverduePOM.clickDashboard().click();
		}
		
		public static void CheckReports( ExtentTest test, int status, String type) throws InterruptedException, IOException
		{		
			WebDriverWait wait = new WebDriverWait( getDriver(), 30);
			JavascriptExecutor js = (JavascriptExecutor)getDriver();
			js.executeScript("window.scrollBy(0,-1000)");
			
			LiPerformerPOM.clickStatus1().click();			//Clicking on 'Status' drop down.
			Thread.sleep(500);
			elementsList = LiPerformerPOM.selectStatus1();	//Selecting Status.
			elementsList.get(status).click();
			
			Thread.sleep(1000);
			//progress(getDriver());
			
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
				
				Thread.sleep(700);
				String item = LiPerformerPOM.readTotalRecords1().getText();
				String[] bits = item.split(" ");								//Splitting the String
				String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
				int count = 0;
				if(compliancesCount.equalsIgnoreCase("to"))
				{
					Thread.sleep(2500);
					item = CFOcountPOM.readTotalItems1().getText();
					bits = item.split(" ");										//Splitting the String
					compliancesCount = bits[bits.length - 2];					//Getting the second last word (total number of users)
				}
				count = Integer.parseInt(compliancesCount);
				
				File dir = new File("C:\\Users\\dipali\\Download");
				File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
				
				js.executeScript("window.scrollBy(0,-2000)");				//Scrolling down window by 2000 px.
				Thread.sleep(500);
				LiPerformerPOM.clickExcel().click();						//Clicking on Excel Image.
				
				Thread.sleep(3000);
				File dir1 = new File("C:\\Users\\dipali\\Download");
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
						test.log(LogStatus.PASS, "Count of records displayed from grid matches to number records in Excel Sheet.");
						test.log(LogStatus.INFO, "Total records from grid = "+count+" | Total records in Excel Sheet = "+SheetRecords);
					}
					else
					{
						test.log(LogStatus.FAIL, "Count of records displayed from grid doesn't matches to number records in Excel Sheet.");
						test.log(LogStatus.INFO, "Total records from grid = "+count+" | Total records in Excel Sheet = "+SheetRecords);
					}
				}
				else
				{
					test.log(LogStatus.FAIL, type+" :- File doesn't downloaded successfully.");
				}
			}
			else
			{
				test.log(LogStatus.SKIP, type+" :- Records not displayed (available). Excel sheet didn't downloaded");
			}

}

		
		public static void CriticalDocuments( ExtentTest test, String type) throws InterruptedException
		{
			Thread.sleep(1000);
		   OverduePOM.clickMyDocuments().click();					//Clicking on 'My Documents'
			
			Thread.sleep(3000);
			OverduePOM.clickCriticalDocuments().click();				//Clicking on 'Critical Documents'
			
			WebDriverWait wait = new WebDriverWait( getDriver(), 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_grdFolderDetail']")));	//Wating till the content table gets visible
			
			Thread.sleep(500);
			String name = OverduePOM.readFolderName().getText();		//Reading the folder name to create new folder.
			
			String folder = name+"a1"; 
			Thread.sleep(500);
		
			OverduePOM.clickNew().click();							//Clicking on '+New' button.
			
			Thread.sleep(1000);
			
			Thread.sleep(500);
			OverduePOM.clickNewFolder().click();						//Clicking on 'New Folder'
			
			Thread.sleep(2000);
			litigationPerformer.MethodsPOM.progress();
			
			Thread.sleep(300);
			OverduePOM.clickIsUniversal().click();
			
			Thread.sleep(1000);
			OverduePOM.writeFolderName().sendKeys(folder);			//Writing Folder name.
			
			Thread.sleep(1000);
			OverduePOM.clickCreate().click();						//Clicking on create button.
			Thread.sleep(5000);
			String msg = getDriver().switchTo().alert().getText();
		      // test.log(LogStatus.INFO, msg);
			Thread.sleep(300);
			getDriver().switchTo().alert().accept();
			Thread.sleep(500);
			litigationPerformer.MethodsPOM.progress();
			
			Thread.sleep(5000);
			try
			{
		   // String msg = getDriver().switchTo().alert().getText();
		      // test.log(LogStatus.INFO, msg);
			//Thread.sleep(300);
			//getDriver().switchTo().alert().accept();
			test.log(LogStatus.PASS, "Message  Displayed=" +msg);
		
			}
			catch(Exception e)
			{
				
			String fodalter =MethodPOM.Folferlert().getText();
			test.log(LogStatus.PASS, "Message Displayed="+ fodalter);
			}
		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
			name = OverduePOM.readFolderName().getText();				//Reading the folder name we had created
			
			/*if(msg.equalsIgnoreCase("Folder Created Succesfully."))
			{
				test.log(LogStatus.PASS, "Message  Displayed" +msg);
			}
			else
			{
				test.log(LogStatus.FAIL, "New Created folder '"+folder+"' doesn't displayed in the records.");
			}
			*/
			Thread.sleep(5000);
			OverduePOM.readFolderName().click();	
		   Thread.sleep(5000);
			//OverduePOM.readFolderName().click();
		//	Thread.sleep(5000);
		   MethodPOM.clickShareFolder().click();
		  // Thread.sleep(500);
		   Thread.sleep(1000);
			litigationPerformer.MethodsPOM.progress();
			
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickPeople1()));
			OverduePOM.clickPeople1().click();						//Clicking on People drop down
			   Thread.sleep(5000);
			OverduePOM.clickSearchPeople1().click();					//Clicking on Search People drop down.
			
			Thread.sleep(5000);
			OverduePOM.clickSearchPeople1().sendKeys("Bhagyesh");			//Writing user name to search for  CFO
			//OverduePOM.clickSearchPeople1().sendKeys("Neha");	        // Auditor
			Thread.sleep(5000);
			OverduePOM.clickPeopleCheckBox().click();				//Clicking on label to get out from people search box
			getDriver().findElement(By.xpath("//*[@id='divOpenPermissionPopup']/div/div/div[2]")).click();
			
			Thread.sleep(3000);
			MethodPOM.Clickaftershare().click();
			Thread.sleep(3000);
			OverduePOM.clickDone().click();	//Clicking on 'Done' to share folder.
		
			Thread.sleep(1000);
			getDriver().switchTo().alert().accept();
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Folder Shared Successfully");
			OverduePOM.readFolderName().click();						//Clicking on folder name we had created.
			Thread.sleep(5000);
			//MethodPOM.clickShareFolder().click();
	     	Thread.sleep(5000);
		    OverduePOM.readFolderName().click();						//Clicking on folder name we had created.
			
			Thread.sleep(1000);
			litigationPerformer.MethodsPOM.progress();
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickNew()));
			OverduePOM.clickNew().click();							//Clicking on 'New'
			
			Thread.sleep(500);
			litigationPerformer.MethodsPOM.progress();
			
			//Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickNewFile()));
			OverduePOM.clickNewFile().click();						//CLicking on 'New File'
			
			Thread.sleep(1000);
			litigationPerformer.MethodsPOM.progress();
			Thread.sleep(500);
			String workingDir = System.getProperty("user.dir");
			OverduePOM.uploadNewFile().sendKeys(workingDir+"//TestData//ComplianceSheet.xlsx");	//uploading new file		
			
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickUploadDocument()));
			OverduePOM.clickUploadDocument().click();				//Clicking on 'Upload Document'
			
			Thread.sleep(100);
			litigationPerformer.MethodsPOM.progress();
			Alert alert = getDriver().switchTo().alert();
			alert.dismiss();
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
			if(OverduePOM.readFolderName().isDisplayed())			//Checking if file got created or not.
				test.log(LogStatus.PASS, "File Uploaded Successfully and Uploaded File display On Grid");
			else
				test.log(LogStatus.PASS, "Uploaded file does not displayed.");
			
			OverduePOM.readFolderName().click();						//Clicking on file we had uploaded.
					
			Thread.sleep(500);
			OverduePOM.clickShareFolder().click();					//Clicking on Share Folder image.
			
			Thread.sleep(1000);
			litigationPerformer.MethodsPOM.progress();
			Thread.sleep(500);
			wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickPeople()));
			OverduePOM.clickPeople().click();						//Clicking on People drop down 
			OverduePOM.clickSearchPeople().click();					//Clicking on Search People drop down.
			
			Thread.sleep(500);
		//	clickSearchPeople().sendKeys("amol");			//Writing user name to search for  CFO
		//	clickSearchPeople().sendKeys("Company");	        // Auditor
			Thread.sleep(500);
			OverduePOM.clickfileCheckBox().click();				//Clicking on label to get out from people search box
			getDriver().findElement(By.xpath("//*[@id='divOpenPermissionPopup']/div/div/div[2]")).click();
			
			Thread.sleep(1000);
			MethodPOM.Clickaftershare().click();
			Thread.sleep(1000);
			OverduePOM.clickDone().click();	//Clicking on 'Done' to share folder.
			Thread.sleep(1000);
			getDriver().switchTo().alert().accept();
			
			Thread.sleep(1000);
			OverduePOM.readFolderName().click();						//Clicking on file name we had uploaded.
			
			Thread.sleep(500);
			OverduePOM.clickShareFolder().click();					//Clicking on Share File image.
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_myRepeater_LnkDeletShare_0']")));	//Waiting till the share element gets visible
			
			//Thread.sleep(1000);
			if(OverduePOM.checkShared().isDisplayed())				//Checking if folder gor shared or not.
				test.log(LogStatus.PASS, "File Shared Successfully.");
			else
				test.log(LogStatus.PASS, "Uploaded file does not shared.");
			
			Thread.sleep(3000);
			OverduePOM.closeSharePoppup().click();
			
			//Thread.sleep(3000);
			//OverduePOM.readFolderName().click();	
			Thread.sleep(1000);
			File dir = new File("C:\\Users\\deepalid\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			Thread.sleep(7000);
			OverduePOM.readFolderName().click();
			Thread.sleep(7000);
			//OverduePOM.readFolderName().click();
			//Thread.sleep(7000);
			MethodPOM.CDocumentDownload().click();	
			File dir1 = new File("C:\\Users\\deepalid\\Downloads");
			File[] dirContents1 = dir1.listFiles();							//Counting number of files in directory after download
			
			if(dirContents.length < dirContents1.length)
			{
				test.log(LogStatus.PASS, "File downloaded Successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded Successfully.");
			}
			
			Thread.sleep(7000);
			MethodPOM.editFolderD().click();
			Thread.sleep(3000);
			MethodPOM.DocumentHeader().sendKeys("Test Head1");
			Thread.sleep(500);
			MethodPOM.DocumentDescription().sendKeys("test Description1");
			Thread.sleep(500);
			MethodPOM.DocumentOther().sendKeys("test Other Documen1t");
			Thread.sleep(500);
			MethodPOM.DocumentProcess().sendKeys("Document process");
			Thread.sleep(500);
			MethodPOM.Documentsubprocess().sendKeys("Document Sub prcess");
			Thread.sleep(500);
			MethodPOM.Vertical().sendKeys("Test Vertical");
			Thread.sleep(500);
			MethodPOM.DocumentLocation().sendKeys("Pune");
			Thread.sleep(500);
			MethodPOM.Updateinfobtn().click();
			
			Thread.sleep(500);
			test.log(LogStatus.PASS, "Document Details Updated Successfully");
			MethodPOM.closedocpopup().click();
			test.log(LogStatus.PASS, "Edit Document Details Popup Closed");
			Thread.sleep(500);
			 OverduePOM.readFolderName().click();						//Clicking on folder name we had created.
				//Thread.sleep(1000);
			/*	MethodPOM.LinkFolder().click();
				Thread.sleep(2000);
				MethodPOM.Linkdocument1().click();
				Thread.sleep(2000);
				MethodPOM.Linkdocument2().click();
				Thread.sleep(1000);
				MethodPOM.LinkSave().click();
				Thread.sleep(1000);
				 // Switching to Alert       
		        Alert alert = getDriver().switchTo().alert();
		        Thread.sleep(3000);
		        // Capturing alert message.   
		        String alertMessage= getDriver().switchTo().alert().getText();
		        
		    	test.log(LogStatus.PASS, alertMessage);
		        
		        System.out.println(alertMessage);
		        
		        Thread.sleep(3000);	       
		        // Accepting alert
		        alert.accept();
		        MethodPOM.Linkclose().click();
		        test.log(LogStatus.PASS, "Link Audit Popup Closed");
		        */
		      //  Thread.sleep(3000);	
		       // MethodPOM.ClickFolder().click();
		    	//OverduePOM.readFolderName().click();				//Clicking on file name we had uploaded.
			Thread.sleep(3000);
		MethodPOM.DeleteFile().click();
			Thread.sleep(3000);
			
			 // Switching to Alert       
	        Alert alert1 = getDriver().switchTo().alert();
	        Thread.sleep(3000);
	        // Capturing alert message.   
	        String alertMessage1= getDriver().switchTo().alert().getText();
	        
	    	test.log(LogStatus.PASS, alertMessage1);
	        
	        System.out.println(alertMessage1);
	        
	        Thread.sleep(3000);	       
	        // Accepting alert
	        alert1.accept();
			
	       test.log(LogStatus.PASS, "Document File Deleted Successfully");
			
	//		.findElement(By.xpath("//*[@id='ContentPlaceHolder1_upPromotorList']/div/div/section/div[3]/div/div[2]/img[5]")).click();
			Thread.sleep(3000);
		   // getDriver().switchTo().alert().accept();
		  
		    Thread.sleep(3000);
		  //  MethodPOM.Folback().click();
			getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkMyDrive']")).click();
			Thread.sleep(3000);
			getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilter']")).sendKeys(folder,Keys.ENTER);//search folder
			test.log(LogStatus.PASS, "File Name Search Successfully.");
		
			getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdFolderDetail_lnkEditFolder_0']")).click();
			Thread.sleep(3000);
		
			getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtFolderName']")).clear();
			Thread.sleep(3000);
			getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtFolderName']")).sendKeys(" JPP");
			Thread.sleep(3000);
			
			getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCreateFolder1']")).click();
			
			test.log(LogStatus.PASS, "Rename Folder Successfully");
				//Reading Message appeared after save button
		try 
			{
				Thread.sleep(3000);
				String msg1=MethodPOM.FirstFolder().getText();
				if(msg1.equalsIgnoreCase("Action Folder"))
				{
					test.log(LogStatus.PASS, "Rename Folder Successfully = "+msg1);
					
				}
				
			}
			
	        catch(Exception e)
	        {
	        	String fodalter =MethodPOM.Folferlert().getText();
				test.log(LogStatus.FAIL, "Message  Displayed" +fodalter);
				
	        }
		
			Thread.sleep(5000);	 
		     OverduePOM.readFolderName().click();						//Clicking on folder name we had created.
			Thread.sleep(1000);
			// MethodPOM.clickShareFolder().click();
			
			MethodPOM.DeleteFolder().click();
			Thread.sleep(1000);
			getDriver().switchTo().alert().accept();
			test.log(LogStatus.PASS, " Document Folder Deleted Successfully");
			
			//wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
			//MethodPOM.clickMyDashboard().click();			//Clicking on Dashboard
			
		}

		

		public  static void LicenseActivation_InternalNewAssignment( ExtentTest test, String string) throws InterruptedException
		{
			
			Thread.sleep(1000);
			MethodPOM.clickMasterMenu().click();
           Thread.sleep(2000);
           MethodPOM.InternalCreationMenu().click();
           
          Thread.sleep(3000);
          MethodPOM.LicenseNewAssignment().click();
          
          Thread.sleep(3000);
 		 MethodPOM.ClickLicenseType().click();
 		 Thread.sleep(5000);
 		 MethodPOM.SearchLicenseType().sendKeys("Apolo",Keys.ENTER);
 		 
 	
 		// Thread.sleep(5000);
 		// MethodPOM.CheckLocation().click();
 		Thread.sleep(3000);
 		MethodPOM.ClickLocationin().click();
 		Thread.sleep(3000);
  		//MethodPOM.ClickLocation().click();
  		//Thread.sleep(3000);
  		//MethodPOM.ClickLocation().click();
          MethodPOM.selectbtn().click();
          Thread.sleep(3000);
          MethodPOM.ClickLocation1().click();
        Thread.sleep(3000);
  		MethodPOM.CheckCompliancein().click();
  		Thread.sleep(3000);
  		MethodPOM.ClickPerformer().click();
  		Thread.sleep(3000);
  		MethodPOM.SelectLicensePerformer().click();
  		
  	
  		Thread.sleep(3000);
  		MethodPOM.ClickReviewer().click();
  		Thread.sleep(5000);
  		MethodPOM.SelectLicenseReviewer().click();
  		
 		Thread.sleep(3000);
 		MethodPOM.AddAssignmentButton().click();
 		String msg3 = MethodPOM.readResponseMsg().getText();		//Reading Message appeared after save button
		
		if(msg3.equalsIgnoreCase("Assignment saved successfully"))
		{
			test.log(LogStatus.PASS, "Message displayed = "+msg3);
			
		}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg3);
			}


	  }
		public  static void LicenseActivation_NewAssignment( ExtentTest test, String string) throws InterruptedException
		{
			
			Thread.sleep(1000);
			MethodPOM.clickMasterMenu().click();
           Thread.sleep(2000);
           MethodPOM.ClickLicenseActivation().click();
           
          Thread.sleep(3000);
          MethodPOM.LicenseNewAssignment().click();
          
          Thread.sleep(3000);
 		 MethodPOM.ClickLicenseType().click();
 		 Thread.sleep(5000);
 		 MethodPOM.SearchLicenseType().sendKeys("Boiler",Keys.ENTER);
 		 
 		
 		 Thread.sleep(5000);
 		 MethodPOM.CheckLocation().click();
 		Thread.sleep(3000);
 		MethodPOM.SelectLocation().click();
 		Thread.sleep(3000);
  		MethodPOM.ClickLocation1().click();
  		
  		Thread.sleep(3000);
  		MethodPOM.CheckCompliance().click();
  		Thread.sleep(3000);
  		MethodPOM.ClickPerformer().click();
  		Thread.sleep(3000);
  		MethodPOM.SelectLicensePerformer().click();
  		
  	
  		Thread.sleep(3000);
  		MethodPOM.ClickReviewer().click();
  		Thread.sleep(5000);
  		MethodPOM.SelectLicenseReviewer().click();
  		
 		Thread.sleep(5000);
 		 JavascriptExecutor Js1 = (JavascriptExecutor)getDriver();
		   Js1.executeScript("window.scrollBy(0,1000)");
 		MethodPOM.AddAssignmentButton().click();
 		
 		Thread.sleep(5000);
 		String msg3 = MethodPOM.readResponseMsg().getText();		//Reading Message appeared after save button
		
		if(msg3.equalsIgnoreCase("Assignment saved successfully"))
		{
			test.log(LogStatus.PASS, "Message displayed = "+msg3);
			
		}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg3);
			}


	  }
		public static void LicenseCreation(ExtentTest test) throws InterruptedException, IOException
		{
			Thread.sleep(1000);
			MethodPOM.clickMasterMenu().click();
           Thread.sleep(2000);
           MethodPOM.ClickLicenseActivation().click();
           
           Thread.sleep(3000);
   	      	 MethodPOM.ClickLicensetype1().click();
   		 Thread.sleep(5000);
   		    MethodPOM.SearchLicenseType1().sendKeys("Shops & Commercial Establishment",Keys.ENTER);
   		    
  /* 	 WebElement checkBoxDisplayed = .findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_ChkIsPerment_0']"));
 		   boolean isDisplayed = checkBoxDisplayed.isDisplayed();
 		   
 		if (isDisplayed == true) 
 		{
 			test.log(LogStatus.PASS, "IsPermanent CheckBox is displayed");
		}
 		else
 		{
 			test.log(LogStatus.PASS, "IsPermanent CheckBox is Not displayed");
 		}
 		*/
 		//MethodPOM.addlicplusebtn().click();
   		Thread.sleep(3000);
   		MethodPOM.CheckCompliance1().click();
     	Thread.sleep(3000);
     	
     	
	XSSFSheet Sheet= ReadExcel();
     	 
     	sheet = workbook.getSheetAt(2);
   	 Row row7=sheet.getRow(7);
   	 org.apache.poi.ss.usermodel.Cell c2=row7.getCell(1);
   	 String LicenseNo=c2.getStringCellValue();
   	 MethodPOM.LicesneNo1().sendKeys(LicenseNo);
           
   
	 Thread.sleep(3000);
	// sheet = workbook.getSheetAt(2);
	 Row row6= sheet.getRow(6);
	  org.apache.poi.ss.usermodel.Cell c1 = row6.getCell(1);	
	 String LicenseTitle= c1.getStringCellValue();
	 MethodPOM.LicesneTitle1().sendKeys(LicenseTitle);
	 
	 Thread.sleep(3000);
	 MethodPOM.StartDate1().sendKeys("01-03-2023");
	 Thread.sleep(3000);     
	 MethodPOM.EndDate1().sendKeys("30-03-2023");
	 
	 JavascriptExecutor Js1 = (JavascriptExecutor)getDriver();
	   Js1.executeScript("window.scrollBy(0,1000)");
	   
	   MethodPOM.SaveButton().click();
	 
	   Alert alert1 = getDriver().switchTo().alert();
	   String alertMessage1= getDriver().switchTo().alert().getText();
	   //test.log(LogStatus.PASS, alertMessage1);
	   alert1.accept();
	   Thread.sleep(3000);
	   String msg = MethodPOM.Message().getText();		//Reading Message appeared after save button
		
		if(msg.equalsIgnoreCase("Compliance Created and Assigned Successfully"))
		{
			test.log(LogStatus.PASS, "Message displayed = "+msg);
			
		}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg);
			}

          MethodPOM.clickMyDashboard().click();
	   
		}
		public static void InternalLicenseCreation( ExtentTest test, String string) throws InterruptedException, IOException
		{
			Thread.sleep(1000);
			MethodPOM.clickMasterMenu().click();
           Thread.sleep(2000);
           MethodPOM.InternalCreationMenu().click();
			  Thread.sleep(3000);
	   	      	MethodPOM.ClickInternalLicenseType().click();
	   		 Thread.sleep(5000);
	   		   MethodPOM.SearchInternalLicenseType().sendKeys("Annual Maintance",Keys.ENTER);
	   		MethodPOM.CheckCompliance1().click();
	      	 Thread.sleep(3000);
	      	 
	   	 XSSFSheet Sheet= ReadExcel();
	      	 Row row7=sheet.getRow(7);
	      		org.apache.poi.ss.usermodel.Cell c2=row7.getCell(1);
	      	 String LicenseNo=c2.getStringCellValue();
	      	 MethodPOM.LicesneNo1().sendKeys(LicenseNo);
	              
	      
	   	 Thread.sleep(3000);
	   	 sheet = workbook.getSheetAt(2);
	   	 Row row6= sheet.getRow(6);
	   	  org.apache.poi.ss.usermodel.Cell c1 = row6.getCell(1);	
	   	 String LicenseTitle= c1.getStringCellValue();
	   	 MethodPOM.LicesneTitle1().sendKeys(LicenseTitle);
	   	 
	   	 Thread.sleep(3000);
	   	 MethodPOM.StartDate1().sendKeys("01-03-2023");
	   	 Thread.sleep(3000);     
	   	 MethodPOM.EndDate1().sendKeys("30-03-2023");
	   	 
	   	 JavascriptExecutor Js1 = (JavascriptExecutor)getDriver();
	   	   Js1.executeScript("window.scrollBy(0,1000)");
	   	   
	   	   MethodPOM.SaveButton().click();
	   	 
	   	   Alert alert1 = getDriver().switchTo().alert();
	   	   String alertMessage1= getDriver().switchTo().alert().getText();
	   	   //test.log(LogStatus.PASS, alertMessage1);
	   	   alert1.accept();
	   	   Thread.sleep(3000);
	   	   String msg = MethodPOM.Message().getText();		//Reading Message appeared after save button
	   		
	   		if(msg.equalsIgnoreCase("Compliance Created and Assigned Sucessfully"))
	   		{
	   			test.log(LogStatus.PASS, "Message displayed = "+msg);
	   			
	   		}
	   			else if (msg.equalsIgnoreCase("License Details with Same License Number already exists"))
	   			{
	   				test.log(LogStatus.PASS, "Message displayed = "+msg);
	   			}
	   			else 
	   			{
	   				test.log(LogStatus.FAIL, "Message displayed = "+msg);
	   			}
	             MethodPOM.clickMyDashboard().click();
	   	   
	   		    
	   		    
		}

		public static void CriticalDocuments( Object statutory, String string) {
			// TODO Auto-generated method stub
			
		}
		public static  void  IsPermanent( ExtentTest test, String string) throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			MethodPOM.clickMasterMenu().click();
           Thread.sleep(2000);
           MethodPOM.ClickLicenseActivation().click();
           Thread.sleep(3000);
           MethodPOM.addlicensebtn1().click();
           Thread.sleep(6000);
           wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showlicdetails"));
           WebElement checkBoxDisplayed = 	getDriver().findElement(By.xpath("//*[@id='ChkIsActive']"));
   		   boolean isDisplayed = checkBoxDisplayed.isDisplayed();
   		   
   		if (isDisplayed == true) 
   		{
   			test.log(LogStatus.PASS, "IsPermanent CheckBox is displayed");
		}
   		else
   		{
   			test.log(LogStatus.PASS, "IsPermanent CheckBox is Not displayed");
   		}
   		   
   		  	
		}

	
		 public static void BystatusRejectedgraph( ExtentTest test, String type ) throws InterruptedException, IOException
		   {

				getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			   JavascriptExecutor Js1 = (JavascriptExecutor)getDriver();
			   Js1.executeScript("window.scrollBy(0,1000)");
			    WebDriverWait wait = new WebDriverWait( getDriver(), 40);
				wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickBystatusRejected()));	  
				String BystatusRejected=MethodPOM.clickBystatusRejected().getText();
				
			     int BystatusRejectedgraph = Integer.parseInt(BystatusRejected);	//Reading Applied But not Renewed graph count.
			     Thread.sleep(4000);
			      MethodPOM.clickBystatusRejected().click();					//Clicking on 'Applied but not Renewed' image
			      Thread.sleep(5000);
			      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
			     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
				   Js.executeScript("window.scrollBy(0,2000)");
				   Thread.sleep(3000);
					//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
					MethodPOM.clickBystatusExpiredappliedbutnotrenewedReadCount().click();//Clicking on total items count
					Thread.sleep(5000);
					String item = MethodPOM.clickBystatusExpiredappliedbutnotrenewedReadCount().getText();	//Reading total items String value
					String[] bits = item.split(" ");								//Splitting the String
					String LicenseBystatusAppliedbutnotRenewedCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
					
					//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
					int total = Integer.parseInt(LicenseBystatusAppliedbutnotRenewedCount);
					if(BystatusRejectedgraph == total)
						{
							//test.log(LogStatus.PASS, "Number of Applied But not Renewed License  grid matches to Dashboard By status Graph Applied But not Renewed License Count.");
							test.log(LogStatus.PASS, "No of Rejected License  in the grid = "+total+" | Dashboard By Status Rejected License  Count = "+BystatusRejectedgraph);
						}
						else
						{
							//test.log(LogStatus.FAIL, "Number of Applied But not Renewed License does not matches to Dashboard By Status Graph  Applied But not Renewed License   Count.");
							test.log(LogStatus.FAIL, "No of Rejected License  in the grid = "+total+" | Dashboard By Status Rejected License  Count = "+BystatusRejectedgraph);
						}
						Thread.sleep(3000);
						
					 MethodPOM.clickExportGraph().click();
					 Thread.sleep(3000);
					// test.log(LogStatus.PASS, "License Details Downloaded Successfully");
					 Thread.sleep(4000);
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
								//js1.executeScript("window.scrollBy(0,1000)");
								
							
								Thread.sleep(100);
								File dir = new File("C://Users//deepalid//Downloads");
								File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
								Thread.sleep(500);
								CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
								Thread.sleep(250);
								 MethodPOM.clickExportGraph().click();
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
									
								    FileInputStream fis = new FileInputStream(lastModifiedFile);
								    workbook = new XSSFWorkbook(fis);
								    sheet = workbook.getSheetAt(0);		
								    /*
									int no = sheet.getLastRowNum();
									Row row = sheet.getRow(no);
									org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
									int records =(int) c1.getNumericCellValue();
								    */
								    sheet = workbook.getSheetAt(0);
									int columnNumber = 3;
									int rowCount = 0;
									int actualRow=0;
									
									for(Row row : sheet)
									{
										
										org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
										if(cell != null) {
											
											rowCount++;
											actualRow = rowCount-1;
										}
										
									}
									fis.close();
					
									
									if(count2 == actualRow)
									{
										//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
										test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
									}
									else
									{
										//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
										test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
									}
								}
								else
								{
									test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
								}
						 }
			          
			         // MethodPOM.clickMyDashboard().click();
			          Thread.sleep(1000);
						  }
						  else
						  {
							   		      
							test.log(LogStatus.PASS,"No Record Found");
							MethodPOM.clickMyDashboard().click();
								      
						  }

					 Thread.sleep(3000);
					 MethodPOM.clickBystatusRejectedverview().click();
					 Thread.sleep(3000);
					//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				
					MethodPOM.clickBystatuscloseoverview().click();
					 Thread.sleep(4000);
					   Js1.executeScript("window.scrollBy(500,0)");
					   Thread.sleep(3000);
					   test.log(LogStatus.PASS, "By Status Rejected License  Overview Button Working Successfully");
					   Thread.sleep(3000);
					 /*  LiPerformerPOM.EntityLocation().click();
	         			Thread.sleep(500);
						LiPerformerPOM.EntityLocationExpand().click();
						Thread.sleep(500);
					//   LiPerformerPOM.aa1().click();
						Thread.sleep(500);
						LiPerformerPOM.demolocation().click();;
					   Thread.sleep(500);
					   String locationtext1 =LiPerformerPOM.locget().getText();
					   Thread.sleep(500);
					   LiPerformerPOM.locget().click();
					   Thread.sleep(3000);
					   LiPerformerPOM.clicklictypet().click();
					   Thread.sleep(500);
					   String LicenseType1 =LiPerformerPOM.Licensetypeinternal().getText();
					   Thread.sleep(5000);
					    LiPerformerPOM.Licensetypeinternal().click();
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
				*/		
	
 }	 
		 public static void BystatusRejectedInternalgraph( ExtentTest test, String type ) throws InterruptedException, IOException
		   {

			   Thread.sleep(3000);
				  LicenseCompanyadmin.MethodPOM.AllFilter().click();
				   Thread.sleep(3000);
				   LicenseCompanyadmin.MethodPOM.InternalFilter().click();
				   
				   LicenseCompanyadmin.MethodPOM.ClickApply().click();
					getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				   JavascriptExecutor Js1 = (JavascriptExecutor)getDriver() ;
				   Js1.executeScript("window.scrollBy(0,1000)");
				    WebDriverWait wait = new WebDriverWait( getDriver(), 40);
					wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickBystatusRejected()));	  
					String BystatusRejected=MethodPOM.clickBystatusRejected().getText();
					
				     int BystatusRejectedgraph = Integer.parseInt(BystatusRejected);	//Reading Applied But not Renewed graph count.
				     Thread.sleep(4000);
				      MethodPOM.clickBystatusRejected().click();					//Clicking on 'Applied but not Renewed' image
				      Thread.sleep(5000);
				      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
				     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
					   Js.executeScript("window.scrollBy(0,2000)");
					   Thread.sleep(3000);
						//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
						MethodPOM.clickBystatusExpiredappliedbutnotrenewedReadCount().click();//Clicking on total items count
						Thread.sleep(5000);
						String item = MethodPOM.clickBystatusExpiredappliedbutnotrenewedReadCount().getText();	//Reading total items String value
						String[] bits = item.split(" ");								//Splitting the String
						String LicenseBystatusAppliedbutnotRenewedCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
						
						//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
						int total = Integer.parseInt(LicenseBystatusAppliedbutnotRenewedCount);
						if(BystatusRejectedgraph == total)
							{
								//test.log(LogStatus.PASS, "Number of Applied But not Renewed License  grid matches to Dashboard By status Graph Applied But not Renewed License Count.");
								test.log(LogStatus.PASS, "No of Rejected License  in the grid = "+total+" | Dashboard By Status Rejected License  Count = "+BystatusRejectedgraph);
							}
							else
							{
								//test.log(LogStatus.FAIL, "Number of Applied But not Renewed License does not matches to Dashboard By Status Graph  Applied But not Renewed License   Count.");
								test.log(LogStatus.FAIL, "No of Rejected License  in the grid = "+total+" | Dashboard By Status Rejected License  Count = "+BystatusRejectedgraph);
							}
							Thread.sleep(3000);
							
						 MethodPOM.clickExportGraph().click();
						 Thread.sleep(3000);
						// test.log(LogStatus.PASS, "License Details Downloaded Successfully");
						 Thread.sleep(4000);
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
									//js1.executeScript("window.scrollBy(0,1000)");
									
								
									Thread.sleep(100);
									File dir = new File("C://Users//deepalid//Downloads");
									File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
									
									Thread.sleep(500);
									CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
									Thread.sleep(250);
									 MethodPOM.clickExportGraph().click();
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
										
									    FileInputStream fis = new FileInputStream(lastModifiedFile);
									    workbook = new XSSFWorkbook(fis);
									    sheet = workbook.getSheetAt(0);		
									    /*
										int no = sheet.getLastRowNum();
										Row row = sheet.getRow(no);
										org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
										int records =(int) c1.getNumericCellValue();
									    */
									    sheet = workbook.getSheetAt(0);
										int columnNumber = 3;
										int rowCount = 0;
										int actualRow=0;
										
										for(Row row : sheet)
										{
											
											org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
											if(cell != null) {
												
												rowCount++;
												actualRow = rowCount-1;
											}
											
										}
										fis.close();
						
										
										if(count2 == actualRow)
										{
											//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
											test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
										}
										else
										{
											//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
											test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
										}
									}
									else
									{
										test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
									}
							 }
				          
				         // MethodPOM.clickMyDashboard().click();
				          Thread.sleep(1000);
							  }
							  else
							  {
								   		      
								test.log(LogStatus.PASS,"No Record Found");
								MethodPOM.clickMyDashboard().click();
									      
							  }

						 MethodPOM.clickAllOverview().click();
						 Thread.sleep(3000);
						//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
						
						 Thread.sleep(3000);
						MethodPOM.clickBystatuscloseoverview().click();
						 Thread.sleep(4000);
						 test.log(LogStatus.PASS, "License Overview Button Working Successfully");
						 Thread.sleep(3000);


						/*   LiPerformerPOM.EntityLocation().click();
							Thread.sleep(500);
							  String locationtext1 =LiPerformerPOM.locget().getText();
								Thread.sleep(500);
							MethodPOM.Clicklocationsearch().click();
							Thread.sleep(500);
							
							 //  LiPerformerPOM.locget().click();
							MethodPOM.Clicklocationsearch().sendKeys("Regtrack Mumbai");
							Thread.sleep(500);
				       MethodPOM.Checkedlocation().click();
					   Thread.sleep(3000);
					   LiPerformerPOM.clicklictypet().click();
					   Thread.sleep(500);
					  LiPerformerPOM.selectinlictype().click();
					   String LicenseType1 =LiPerformerPOM.inlic().getText();
					   Thread.sleep(5000);
					   // LiPerformerPOM.inlic().click();
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
						*/
							
						}
		  public static void ByLicensetypeRejected( ExtentTest test, String type) throws InterruptedException, IOException
		   {


			   Thread.sleep(3000);
			   MethodPOM.clickDashlictype().click();
			   Thread.sleep(5000);
			   MethodPOM.serachlic1().sendKeys("Shops & Commercial Establishment",Keys.ENTER);
			   Thread.sleep(5000);
				   LicenseCompanyadmin.MethodPOM.ClickApply().click();
				   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			   JavascriptExecutor Js1 = (JavascriptExecutor)getDriver();
			   Js1.executeScript("window.scrollBy(0,1000)");
			    WebDriverWait wait = new WebDriverWait( getDriver(), 40);
			    Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByLicnesetypeRejected()));	  
				String ByLicenseTypeRejected=MethodPOM.clickByLicnesetypeRejected().getText();			
			     int ByLicensetypeRejectedgraph = Integer.parseInt(ByLicenseTypeRejected);	//Reading Terminate graph count.
			     Thread.sleep(4000);
			      MethodPOM.clickByLicnesetypeRejected().click();					//Clicking on 'Terminate' image
			      Thread.sleep(5000);
			      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
			     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
				   Js.executeScript("window.scrollBy(0,2000)");
				   Thread.sleep(3000);
					//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
					MethodPOM.clickAllReadcount().click();//Clicking on total items count
					Thread.sleep(5000);
					String item = MethodPOM.clickAllReadcount().getText();	//Reading total items String value
					String[] bits = item.split(" ");								//Splitting the String
					String ByLicensetypeCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
					
					//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
					int total = Integer.parseInt(ByLicensetypeCount);
					if(ByLicensetypeRejectedgraph == total)
						{
							//test.log(LogStatus.PASS, "Number of Terminate License  grid matches to Dashboard By Licnesetype Graph Terminate License Count.");
							test.log(LogStatus.PASS, "No of Rejected License  in the grid = "+total+" | Dashboard By Licnese type Rejected  License  Count = "+ByLicensetypeRejectedgraph);
						}
						else
						{
							//test.log(LogStatus.FAIL, "Number of Terminate License does not matches to Dashboard By Licnese type Graph Terminate License   Count.");
							test.log(LogStatus.FAIL, "No of Rejected License  in the grid = "+total+" | Dashboard By Licnese type Rejected License  Count = "+ByLicensetypeRejectedgraph);
						}
					Thread.sleep(3000);
					 MethodPOM.clickAllOverview().click();
					 Thread.sleep(3000);
					//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				
			     test.log(LogStatus.PASS, " License Overview Details Successfully");
					 Thread.sleep(3000);
					MethodPOM.clickBystatuscloseoverview().click();
					 Thread.sleep(4000);
				//	MethodPOM.clickExportGraph().click();
					 Thread.sleep(3000);
					 //test.log(LogStatus.PASS, "License Details Downloaded Successfully.");
					 //Thread.sleep(1000);
					 CFOcountPOM.readTotalItems1().click();
						
						String item2 = CFOcountPOM.readTotalItems1().getText();
						//String NoRecord = LiReviewerPOM.reNorecord.getText();
						 if(!item2.equalsIgnoreCase("No items to display")) 
						 {
						String[] bits1 = item2.split(" ");								//Splitting the String
						String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
						int count2 = Integer.parseInt(compliancesCount1);
					//	String NoRecord = LiReviewerPOM.reNorecord().getText();
						//   if(!NoRecord.equalsIgnoreCase("No items to display")) 
						// {
							   try
								{
									performerPOM.clickExcelReport().sendKeys(Keys.PAGE_DOWN);
								}
								catch(Exception e)
								{
									
								}
								//js1.executeScript("window.scrollBy(0,1000)");
								
							
								Thread.sleep(100);
								File dir = new File("C://Users//deepalid//Downloads");
								File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
								
								Thread.sleep(500);
								CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
								Thread.sleep(250);
								 MethodPOM.clickExportGraph().click();
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
									
								    FileInputStream fis = new FileInputStream(lastModifiedFile);
								    workbook = new XSSFWorkbook(fis);
								    sheet = workbook.getSheetAt(0);		
								    /*
									int no = sheet.getLastRowNum();
									Row row = sheet.getRow(no);
									org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
									int records =(int) c1.getNumericCellValue();
								    */
								    sheet = workbook.getSheetAt(0);
									int columnNumber = 3;
									int rowCount = 0;
									int actualRow=0;
									
									for(Row row : sheet)
									{
										
										org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
										if(cell != null) {
											
											rowCount++;
											actualRow = rowCount-1;
										}
										
									}
									fis.close();
					
									
									if(count2 == actualRow)
									{
										//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
										test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
									}
									else
									{
										//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
										test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
									}
								}
								else
								{
									test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
								}
								
						 }
						/* LiPerformerPOM.EntityLocation().click();
			      			Thread.sleep(500);
								LiPerformerPOM.EntityLocationExpand().click();
								Thread.sleep(500);
							//   LiPerformerPOM.aa1().click();
								Thread.sleep(500);
								LiPerformerPOM.demolocation().click();;
							   Thread.sleep(500);
							   String locationtext1 =LiPerformerPOM.locget().getText();
							   Thread.sleep(500);
							   LiPerformerPOM.locget().click();
							   Thread.sleep(3000);
							   LiPerformerPOM.clicklictypet().click();
							   Thread.sleep(500);
							   String LicenseType1 =LiPerformerPOM.Licensetypeinternal().getText();
							   Thread.sleep(5000);
							    LiPerformerPOM.Licensetypeinternal().click();
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
			        
						  }*/
						  else
						  {
							if(ByLicenseTypeRejected=="0")
							{
								//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
								test.log(LogStatus.PASS, "For "+type+" No of Active License  in the grid = "+0+" | Dashboard By Licnese type Active License  Count = "+ByLicenseTypeRejected);
							}
							else
							{
								test.log(LogStatus.FAIL, "For "+type+" No of Active License  in the grid = "+0+" |  Dashboard By Licnese type Active License  Count = "+ByLicenseTypeRejected);
							}
			
								      
						  }
				
				
				}

	   

	
						
				

public static void DashboardActivefilter (ExtentTest test, String type) throws InterruptedException, IOException
{	
	WebDriverWait wait = new WebDriverWait( getDriver(), 20);
	   MethodPOM.DashboardEntityclick().click();
	   Thread.sleep(5000);
	   MethodPOM.Entitypluseclick().click();
	   Thread.sleep(5000);
	   MethodPOM.Dashselectloc().click(); 
	   
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   Thread.sleep(3000);
		   
		   if(type.equalsIgnoreCase("Internal"))
		   {
			   MethodPOM.clickDashlictype().click();
			   Thread.sleep(5000);
			   MethodPOM.performerserachlic1().sendKeys("Annual Maintance",Keys.ENTER);
			   Thread.sleep(5000);
			   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   }
		   else
		   {
		   MethodPOM.clickDashlictype().click();
		   Thread.sleep(3000);
		   MethodPOM.Performerserachlic1().sendKeys("Shops & Commercial Establishment",Keys.ENTER);
		   Thread.sleep(5000);
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   }
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive()));
	String active=MethodPOM.clickActive().getText();
	
     int activelicense = Integer.parseInt(active);	//Reading Active count.

      MethodPOM.clickActive().click();					//Clicking on 'Active' image
      Thread.sleep(5000);
        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
		js1.executeScript("window.scroll(0,500)");
		Thread.sleep(5000);
		
		MethodPOM.clickReadActive().click();					//Clicking on total items count
		String ite = MethodPOM.clickReadExpired().getText();	//Reading total items String value
		Thread.sleep(5000);
		if(!ite.equalsIgnoreCase("No items to display"))	
		{
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
}
else
{
	   		      
	test.log(LogStatus.PASS,"No Record Found");
	MethodPOM.clickMyDashboard().click();
		      
}
}


public static void DashboardExpiringfilter (ExtentTest test, String type) throws InterruptedException, IOException                                          
  {	                                                                                                                                                        
    	WebDriverWait wait = new WebDriverWait( getDriver(), 20);                                                                                                
    	   MethodPOM.DashboardEntityclick().click();                                                                                                             
    	   Thread.sleep(5000);                                                                                                                                   
    	   MethodPOM.Entitypluseclick().click();                                                                                                                 
    	   Thread.sleep(5000);                                                                                                                                   
    	   MethodPOM.Dashselectloc().click();                                                                                                                    
    		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);                                                                                   
    		   Thread.sleep(3000);                                                                                                                                  
    		   if(type.equalsIgnoreCase("Internal"))
    		   {
    			   MethodPOM.clickDashlictype().click();
    			   Thread.sleep(5000);
    			   MethodPOM.performerserachlic1().sendKeys("Annual Maintance",Keys.ENTER);
    			   Thread.sleep(5000);
    			   LicenseCompanyadmin.MethodPOM.ClickApply().click();
    			  
    			   
    		   }
    		   else
    		   {
    		   MethodPOM.clickDashlictype().click();
    		   Thread.sleep(5000);
    		   MethodPOM.Performerserachlic1().sendKeys("Shops & Commercial Establishment",Keys.ENTER);
    		   Thread.sleep(5000);
    		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
    		   }
   
      wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring()));                                                                              
      String Expiring=MethodPOM.clickExpiring().getText();                                                                                                 
                                                                                                                                                           
       int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.                                                                           
                                                                                                                                                           
        MethodPOM.clickExpiring().click();					//Clicking on 'Expiring' image                                                                              
        Thread.sleep(4000);                                                                                                                                
          JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;                                                                                       
      	js1.executeScript("window.scroll(0,500)");                                                                                                          
      	Thread.sleep(4000);                                                                                                                                 
      	                                                                                                                                                    
      	MethodPOM.clickReadExpiring().click();					//Clicking on total items count     
      	String ite = MethodPOM.clickReadExpired().getText();	//Reading total items String value
		Thread.sleep(5000);
		if(!ite.equalsIgnoreCase("No items to display"))	
		{
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
  }
else
{
	   		      
	test.log(LogStatus.PASS,"No Record Found");
	MethodPOM.clickMyDashboard().click();
		      
}
 	                                                                                                                            
    
    }
public static void DashboardExpiredfilter (ExtentTest test, String type) throws InterruptedException, IOException                                          
{	                                                                                                                                                        
  	WebDriverWait wait = new WebDriverWait( getDriver(), 20);                                                                                                
  	   MethodPOM.DashboardEntityclick().click();                                                                                                             
  	   Thread.sleep(5000);                                                                                                                                   
  	   MethodPOM.Entitypluseclick().click();                                                                                                                 
  	   Thread.sleep(5000);                                                                                                                                   
  	   MethodPOM.Dashselectloc().click();                                                                                                                    
  		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);                                                                                   
  		   Thread.sleep(3000);                                                                                                                                  
  		 if(type.equalsIgnoreCase("Internal"))
		   {
  			 MethodPOM.clickDashlictype().click();
			   Thread.sleep(5000);
			   MethodPOM.performerserachlic1().sendKeys("Annual Maintance",Keys.ENTER);
			   Thread.sleep(5000);
			   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   }
		   else
		   {
		   MethodPOM.clickDashlictype().click();
		   Thread.sleep(5000);
		   MethodPOM.Performerserachlic1().sendKeys("Shops & Commercial Establishment",Keys.ENTER);
		   Thread.sleep(5000);
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();                                                                                        
		   }                                                                                                                                                   
  			 wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired()));
  			String Expired=MethodPOM.clickExpired().getText();
  			
  		     int Expiredlicense = Integer.parseInt(Expired);	//Reading Expired count.

  		      MethodPOM.clickExpired().click();					//Clicking on 'Expired' image
  		      Thread.sleep(4000);
  		        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
  				js1.executeScript("window.scroll(0,500)");
  				Thread.sleep(4000);
  				
  				MethodPOM.clickReadExpired().click();					//Clicking on total items count
  				String ite = MethodPOM.clickReadExpired().getText();	//Reading total items String value
  				Thread.sleep(5000);
  				if(!ite.equalsIgnoreCase("No items to display"))	
  				{
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
}
else
{
	   		      
	test.log(LogStatus.PASS,"No Record Found");
	MethodPOM.clickMyDashboard().click();
		      
}
        
}
	                                                                                                                            
  
public static void DashboardAppliedfilter (ExtentTest test, String type) throws InterruptedException, IOException                                          
{	                                                                                                                                                        
  	WebDriverWait wait = new WebDriverWait( getDriver(), 20);                                                                                                
  	   MethodPOM.DashboardEntityclick().click();                                                                                                             
  	   Thread.sleep(5000);                                                                                                                                   
  	   MethodPOM.Entitypluseclick().click();                                                                                                                 
  	   Thread.sleep(5000);                                                                                                                                   
  	   MethodPOM.Dashselectloc().click();                                                                                                                    
  		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);                                                                                   
  		   Thread.sleep(3000);                                                                                                                                  
  		 if(type.equalsIgnoreCase("Internal"))
		   {
  			 MethodPOM.clickDashlictype().click();
			   Thread.sleep(5000);
			   MethodPOM.performerserachlic1().sendKeys("Annual Maintance",Keys.ENTER);
			   Thread.sleep(5000);
			   LicenseCompanyadmin.MethodPOM.ClickApply().click();
			  
			   
		   }
		   else
		   {
		   MethodPOM.clickDashlictype().click();
		   Thread.sleep(5000);
		   MethodPOM.Performerserachlic1().sendKeys("Shops & Commercial Establishment",Keys.ENTER);
		   Thread.sleep(5000);
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   }
  	                                                                                                                                                         
  				wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickApplied()));
  				String Applied=MethodPOM.clickApplied().getText();
  				
  			     int Appliedlicense = Integer.parseInt(Applied);	//Reading Applied count.

  			      MethodPOM.clickApplied().click();					//Clicking on 'Applied' image
  			      Thread.sleep(4000);
  			        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
  					js1.executeScript("window.scroll(0,500)");
  					Thread.sleep(4000);
  					String ite = MethodPOM.clickReadExpired().getText();	//Reading total items String value
  					Thread.sleep(5000);
  					if(!ite.equalsIgnoreCase("No items to display"))	
  					{
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
}
else
{
	   		      
	test.log(LogStatus.PASS,"No Record Found");
	MethodPOM.clickMyDashboard().click();
		      
}

	                                                                                                                            
  }  

public static void Dashboardpendingforreviewfilter( ExtentTest test, String type) throws InterruptedException, IOException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), 20);                                                                                                
	   MethodPOM.DashboardEntityclick().click();                                                                                                             
	   Thread.sleep(5000);                                                                                                                                   
	   MethodPOM.Entitypluseclick().click();                                                                                                                 
	   Thread.sleep(5000);                                                                                                                                   
	   MethodPOM.Dashselectloc().click();                                                                                                                    
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);                                                                                   
		   Thread.sleep(3000);                                                                                                                                  
		   if(type.equalsIgnoreCase("Internal"))
		   {
			   MethodPOM.clickDashlictype().click();
			   Thread.sleep(5000);
			   MethodPOM.performerserachlic1().sendKeys("Annual Maintance",Keys.ENTER);
			   Thread.sleep(5000);
			   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   }
		   else
		   {
		   MethodPOM.clickDashlictype().click();
		   Thread.sleep(5000);
		   MethodPOM.Performerserachlic1().sendKeys("Shops & Commercial Establishment",Keys.ENTER);
		   Thread.sleep(5000);
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   }
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickpendingforreview()));
		String PendingForReview=MethodPOM.clickpendingforreview().getText();
		
	     int pendingforreviewlicense = Integer.parseInt(PendingForReview);	//Reading Pending For Review count.
          
	      MethodPOM.clickpendingforreview().click();	
	      //Clicking on 'Pending For Review ' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			MethodPOM.clickReadpendingforreview().click();					//Clicking on total items count
			String ite = MethodPOM.clickReadExpired().getText();	//Reading total items String value
			Thread.sleep(5000);
			if(!ite.equalsIgnoreCase("No items to display"))	
			{
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
}
			else
			  {
				   		      
				test.log(LogStatus.PASS,"No Record Found");
				MethodPOM.clickMyDashboard().click();
					      
			  }
											
}			 
public static void DashboardRejectedLicensefilter( ExtentTest test, String type) throws InterruptedException, IOException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), 20);                                                                                                
	   MethodPOM.DashboardEntityclick().click();                                                                                                             
	   Thread.sleep(5000);                                                                                                                                   
	   MethodPOM.Entitypluseclick().click();                                                                                                                 
	   Thread.sleep(5000);                                                                                                                                   
	   MethodPOM.Dashselectloc().click();                                                                                                                    
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);                                                                                   
		   Thread.sleep(3000);                                                                                                                                  
		   if(type.equalsIgnoreCase("Internal"))
		   {
			   MethodPOM.clickDashlictype().click();
			   Thread.sleep(5000);
			   MethodPOM.performerserachlic1().sendKeys("Annual Maintance",Keys.ENTER);
			   Thread.sleep(5000);
			   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   }
		   else
		   {
		   MethodPOM.clickDashlictype().click();
		   Thread.sleep(5000);
		   MethodPOM.Performerserachlic1().sendKeys("Shops & Commercial Establishment",Keys.ENTER);
		   Thread.sleep(5000);
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   }
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickRejected()));
		String Rejected=MethodPOM.clickRejected().getText();
		
	     int RejectedLicense = Integer.parseInt(Rejected);	//Reading Rejected count.

	   
	      MethodPOM.clickRejected().click();					//Clicking on 'Rejected ' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			  String item2 = CFOcountPOM.readTotalItems1().getText();
				//String NoRecord = LiReviewerPOM.reNorecord.getText();
				 if(!item2.equalsIgnoreCase("No items to display")) 
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
					//test.log(LogStatus.PASS, "Number of Rejected License  grid matches to Dashboard Rejected  License   Count.");
					test.log(LogStatus.PASS, "No of Rejected  License  in the grid = "+total+" | Dashboard Rejected License  Count = "+RejectedLicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Rejected License does not matches to Dashboard Rejected License   Count.");
					test.log(LogStatus.FAIL, "No of Rejected License  in the grid = "+total+" | Dashboard Rejected License  Count = "+RejectedLicense);
				}
			 }
			 else
			  {
				   		      
				test.log(LogStatus.PASS,"No Record Found");
				MethodPOM.clickMyDashboard().click();
					      
			  }
}
public static void DashboardTerminateLicensefilter( ExtentTest test, String type) throws InterruptedException, IOException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), 20);                                                                                                
	   MethodPOM.DashboardEntityclick().click();                                                                                                             
	   Thread.sleep(5000);                                                                                                                                   
	   MethodPOM.Entitypluseclick().click();                                                                                                                 
	   Thread.sleep(5000);                                                                                                                                   
	   MethodPOM.Dashselectloc().click();                                                                                                                    
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);                                                                                   
		   Thread.sleep(3000);                                                                                                                                  
		   if(type.equalsIgnoreCase("Internal"))
		   {
			   MethodPOM.clickDashlictype().click();
			   Thread.sleep(5000);
			   MethodPOM.performerserachlic1().sendKeys("Annual Maintance",Keys.ENTER);
			   Thread.sleep(5000);
			   LicenseCompanyadmin.MethodPOM.ClickApply().click();
			   
		   }
		   else
		   {
		   MethodPOM.clickDashlictype().click();
		   Thread.sleep(5000);
		   MethodPOM.Performerserachlic1().sendKeys("Shops & Commercial Establishment",Keys.ENTER);
		   Thread.sleep(5000);
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   }
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickTerminate()));
		String Terminate=MethodPOM.clickTerminate().getText();
		
	     int TerminateLicense = Integer.parseInt(Terminate);	//Reading Terminate count.

	      MethodPOM.clickTerminateper().click();					//Clicking on 'Terminate ' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor)  getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			String item2 = CFOcountPOM.readTotalItems1().getText();
			//String NoRecord = LiReviewerPOM.reNorecord.getText();
			 if(!item2.equalsIgnoreCase("No items to display")) 
			 {
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
					test.log(LogStatus.PASS, "No of Terminated  License  in the grid = "+total+" | Dashboard Terminated License  Count = "+TerminateLicense);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Terminate License does not matches to Dashboard Terminate License   Count.");
					test.log(LogStatus.FAIL, "No of Terminated License  in the grid = "+total+" | Dashboard Terminated License  Count = "+TerminateLicense);
				}
			 }
			 else
			  {
				   		      
				test.log(LogStatus.PASS,"No Record Found");
				MethodPOM.clickMyDashboard().click();
					      
			  }
}
public static  void DashboardAssignedButNotActivatedFilter( ExtentTest test, String type) throws InterruptedException, IOException
{	
	WebDriverWait wait = new WebDriverWait( getDriver(), 20);                                                                                                
	   MethodPOM.DashboardEntityclick().click();                                                                                                             
	   Thread.sleep(5000);                                                                                                                                   
	   MethodPOM.Entitypluseclick().click();                                                                                                                 
	   Thread.sleep(5000);                                                                                                                                   
	   MethodPOM.Dashselectloc().click();                                                                                                                    
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);                                                                                   
		   Thread.sleep(3000);                                                                                                                                  
		   if(type.equalsIgnoreCase("Internal"))
		   {
			   MethodPOM.clickDashlictype().click();
			   Thread.sleep(5000);
			   MethodPOM.performerserachlic1().sendKeys("Annual Maintance",Keys.ENTER);
			   Thread.sleep(5000);
			   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   }
		   else
		   {
		   MethodPOM.clickDashlictype().click();
		   Thread.sleep(5000);
		   MethodPOM.Performerserachlic1().sendKeys("Shops & Commercial Establishment",Keys.ENTER);
		   Thread.sleep(5000);
		   LicenseCompanyadmin.MethodPOM.ClickApply().click();
		   }
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
		}
		 else
		  {
			   		      
			test.log(LogStatus.PASS,"No Record Found");
			MethodPOM.clickMyDashboard().click();
				      
		  }

		}
public static void Bystatuspendingforreviewgraph( ExtentTest test, String type ) throws InterruptedException, IOException
{

	   getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   JavascriptExecutor Js1 = (JavascriptExecutor) getDriver() ;
	   Js1.executeScript("window.scrollBy(0,1000)");
	    WebDriverWait wait = new WebDriverWait( getDriver(), 40);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickBystatusPendingForReview()));	  
		String BystatusPendingForReviewGraph=MethodPOM.clickBystatusPendingForReview().getText();
		
	     int BystatusPendingForReviewgraph = Integer.parseInt(BystatusPendingForReviewGraph);	//Reading Applied But not Renewed graph count.
	     Thread.sleep(4000);
	      MethodPOM.clickBystatusPendingForReview().click();					//Clicking on 'Applied but not Renewed' image
	      Thread.sleep(5000);
	      wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showChartDetails"));	//Switching to iFrame.
	     JavascriptExecutor Js = (JavascriptExecutor)getDriver(); ;
		   Js.executeScript("window.scrollBy(0,2000)");
		   Thread.sleep(3000);
			//wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickByStatsExpiringReadcount()));	 
			MethodPOM.clickBystatusExpiredappliedbutnotrenewedReadCount().click();//Clicking on total items count
			Thread.sleep(5000);
			String item = MethodPOM.clickBystatusExpiredappliedbutnotrenewedReadCount().getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseBystatusAppliedbutnotRenewedCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
			int total = Integer.parseInt(LicenseBystatusAppliedbutnotRenewedCount);
			if(BystatusPendingForReviewgraph == total)
				{
					//test.log(LogStatus.PASS, "Number of Applied But not Renewed License  grid matches to Dashboard By status Graph Applied But not Renewed License Count.");
					test.log(LogStatus.PASS, "No of Pending For Review License  in the grid = "+total+" | Dashboard By Status-Pending For Review License  Count = "+BystatusPendingForReviewgraph);
				}
				else
				{
					//test.log(LogStatus.FAIL, "Number of Applied But not Renewed License does not matches to Dashboard By Status Graph  Applied But not Renewed License   Count.");
					test.log(LogStatus.FAIL, "No of Pending For Review License  in the grid = "+total+" | Dashboard By Status-Pending For Review License  Count = "+BystatusPendingForReviewgraph);
				}
				Thread.sleep(3000);
				
				 MethodPOM.clickExportGraph().click();
				 Thread.sleep(3000);
			  //	 test.log(LogStatus.PASS, "License Details Dwonloaded Successfully");
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
							//js1.executeScript("window.scrollBy(0,1000)");
							
						
							Thread.sleep(100);
							File dir = new File("C://Users//deepalid//Downloads");
							File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
							
							Thread.sleep(500);
							CFOcountPOM.clickNextPage1().sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							 MethodPOM.clickExportGraph().click();
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
								
							    FileInputStream fis = new FileInputStream(lastModifiedFile);
							    workbook = new XSSFWorkbook(fis);
							    sheet = workbook.getSheetAt(0);		
							    /*
								int no = sheet.getLastRowNum();
								Row row = sheet.getRow(no);
								org.apache.poi.ss.usermodel.Cell c1 = row.getCell(0);
								int records =(int) c1.getNumericCellValue();
							    */
							    sheet = workbook.getSheetAt(0);
								int columnNumber = 3;
								int rowCount = 0;
								int actualRow=0;
								
								for(Row row : sheet)
								{
									
									org.apache.poi.ss.usermodel.Cell cell =row.getCell(columnNumber);
									if(cell != null) {
										
										rowCount++;
										actualRow = rowCount-1;
									}
									
								}
								fis.close();
				
								
								if(count2 == actualRow)
								{
									//test.log(LogStatus.PASS, "Notice=No of records from grid matches to no of records in Excel Sheet.");
									test.log(LogStatus.PASS, "For "+type+" status total records from Grid = "+count2+" | Total records from Report = "+actualRow);
								}
								else
								{
									//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
									test.log(LogStatus.FAIL, "For "+type+" status total records from Grid = "+count2+" | Total records from Excel Sheet = "+actualRow);
								}
							}
							else
							{
								test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
							}
					 }
		          
		         // MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
					  }
					  else
					  {
						   		      
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard().click();
							      
					  }

				 MethodPOM.clickAllOverview().click();
				 Thread.sleep(3000);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("downloadfile"));
				
				 Thread.sleep(3000);
				MethodPOM.clickBystatuscloseoverview().click();
				 Thread.sleep(4000);
				 test.log(LogStatus.PASS, "License Overview Button Working Successfully");
				 Thread.sleep(3000);
				 /*LiPerformerPOM.EntityLocation().click();
   			Thread.sleep(500);
			  MethodPOM.Clicklocationsearch().sendKeys("Regtrack Mumbai");
				Thread.sleep(500);
					LiPerformerPOM.demolocation().click();;
				   Thread.sleep(500);
				   String locationtext1 =LiPerformerPOM.demolocation().getText();
				   Thread.sleep(500);
				   LiPerformerPOM.demolocation().click();
				   Thread.sleep(3000);
				   LiPerformerPOM.clicklictypet().click();
				   Thread.sleep(500);
				   String LicenseType1 =LiPerformerPOM.Licensetypeinternal().getText();
				   Thread.sleep(5000);
				    LiPerformerPOM.Licensetypeinternal().click();
         Thread.sleep(5000);
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
			*/
}

public static void RenewInternalLicense(ExtentTest test2, String string) {
	// TODO Auto-generated method stub
	
}	
		}

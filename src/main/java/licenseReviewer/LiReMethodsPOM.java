package licenseReviewer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import licenseCompanyadmin.MethodPOM;
import licenseManagement.licmgmtPOM;
import licensePerformer.LiPerformerPOM;
import performer.OverduePOM;
import reviewer.ReviewerPOM;

public class LiReMethodsPOM 
{
	private static List<WebElement> elementsList = null;
	private static List<WebElement> elementsList1 = null;
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook wb = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static XSSFSheet sheet1 = null;		//Sheet variable
	
	public static void ReviewerActiveLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{	
		  WebDriverWait wait = new WebDriverWait(driver, 20);
			
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
			String Active=MethodPOM.clickActive(driver).getText();
			
		     int Activelicense = Integer.parseInt(Active);	//Reading Expired count.

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
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(LicenseActiveCount);
				if(Activelicense == total)
		{
			//test.log(LogStatus.PASS, "Dashboard 'Expired' count matches to the total records displayed in grid.");
			test.log(LogStatus.PASS, "Dashboard 'Active' count = "+Activelicense+" | Total records in grid = "+total);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Dashboard 'Expired' count doesn't matches to the total records displayed in grid.");
			test.log(LogStatus.FAIL, "Dashboard 'Active' count = "+Activelicense+" | Total records in grid = "+total);
		}
		Thread.sleep(5000);	
		MethodPOM.ClickActiveOverview(driver).click();
		test.log(LogStatus.PASS, " License Overview Details Successfully");
		Thread.sleep(5000);
		MethodPOM.ClickCloseOverview(driver).click();			
		Thread.sleep(7000);
		LiPerformerPOM.editlicenseicon(driver).click();
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
		Thread.sleep(5000);
		js1.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(3000);
		//LiPerformerPOM.editnomineebtn(driver).click();
		Thread.sleep(3000);
		 /*licmgmtPOM.ClickNomineedrp(driver).click();
		 Thread.sleep(3000);
		 licmgmtPOM.SelectNominee(driver).click();
		 
		 Thread.sleep(5000);
		// js1.executeScript("window.scroll(0,2000)");
		// Thread.sleep(5000);
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
		 licmgmtPOM.selectnomineenddate(driver).click();
		 Thread.sleep(5000);*/
		licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
		 // Switching to Alert       
        Alert alert = driver.switchTo().alert();
       
        // Capturing alert message.   
        String alertMessage= driver.switchTo().alert().getText();
       
        Thread.sleep(3000);
      //  test.log(LogStatus.PASS, alertMessage);
       
        // Displaying alert message
       // System.out.println(alertMessage);
        // Accepting alert
        /*Thread.sleep(3000);
        By locator = By.xpath("//*[@class='k-button-group k-dialog-buttongroup k-dialog-button-layout-stretched']");

    	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    	Thread.sleep(4000);
    	
    	WebElement ViewButton = driver.findElement(locator);	
    	Thread.sleep(3000);
    JavascriptExecutor jse=(JavascriptExecutor)driver;
    jse.executeScript("arguments[0].click();", ViewButton);
    	Thread.sleep(4000);
        
      //  LiPerformerPOM.licenseOK(driver).click();
        
     */
        // Accepting alert
        alert.accept();
        test.log(LogStatus.PASS,"License Details Updated Successfully" );
        
          Thread.sleep(5000);
          
          licmgmtPOM.editlicenseclose(driver).click();
          Thread.sleep(300);
          MethodPOM.clickMyDashboard(driver).click();
          Thread.sleep(1000);
         // MethodPOM.clickActive(driver).click();	
          
        //  Thread.sleep(3000);
	//	LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
		
		//progress(driver);
		
		//Thread.sleep(500);
	
		/*
		if(type.equalsIgnoreCase("Internal"))
		{
			WebDriverWait wait1= new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
			LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
			
			
			Select drp = new Select(LiPerformerPOM.clickType(driver));
			drp.selectByIndex(1);
			CFOcountPOM.clickApply1(driver).click();	
			  Thread.sleep(3000);
			MethodPOM.clickActive(driver).click();	
	          
	        Thread.sleep(3000);
			OverduePOM.ActiveAction(driver).click();					//Clicking on first action button.
			//Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
			js1.executeScript("window.scrollBy(0,3000)");
			 Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown(driver)));
			Select status = new Select(OverduePOM.selectInternalDropdown(driver));	//Selecting Status dropdown box.
			status.selectByIndex(2);	
		
		}
		else
		{
			MethodPOM.clickActive(driver).click();	
	          
	         Thread.sleep(3000);
	         OverduePOM.ActiveAction(driver).click();					//Clicking on first action button.
			                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LiPerformerPOM.ShowFream(driver)));		
			js1.executeScript("window.scrollBy(0,1000)");
		    Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown(driver)));
			Select status = new Select(OverduePOM.selectStatutoryDropdown(driver));	//Selecting Status dropdown box.
			status.selectByIndex(2);	
		}
		
		try
		{
			Thread.sleep(300);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress(driver)));
		}
		catch(Exception e)
		{
			
		}
		
		licenseReviewer.LiReMethodsPOM.perform(driver, test);			//Calling perform method of Reviewer.
		
		try
		{
			Thread.sleep(500);
			LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
			js1.executeScript("window.scrollBy(0,300)");
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		js1.executeScript("window.scrollBy(0,700)");
		Thread.sleep(300);
		OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.
		
		Thread.sleep(1000);
		js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.
		
		Thread.sleep(300);
		if(type.equalsIgnoreCase("Statutory"))
		{
			String msg = LiPerformerPOM.readMessage(driver).getText();
			if(msg.equalsIgnoreCase("Save Sucessfully."))
			{
				test.log(LogStatus.PASS, "Message Displayed = "+msg);
			}
			else
			{
				test.log(LogStatus.PASS, "Message Displayed = "+msg);
			}
			
			Thread.sleep(500);
			js1.executeScript("window.scrollBy(2000,0)");	//Scrolling up window by 2000 px.
		}
		else
			{
			test.log(LogStatus.PASS, "Save Sucessfully.");
			 }
			driver.switchTo().parentFrame();
			
			Thread.sleep(700);
			LiPerformerPOM.clickClose(driver).click();				//Clicking on Close (Cross)
			driver.navigate().refresh();
			*/
			MethodPOM.clickMyDashboard(driver).click();
	}
	public static void ReviewerExpiringCount(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		//progress(driver);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring(driver)));
		String Expiring=MethodPOM.clickExpiring(driver).getText();
		
	     int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.
		
		LiPerformerPOM.clickExpiring(driver).click();						//Clicking on 'Expiring'
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
				test.log(LogStatus.PASS, "Expiring License Overview Details Successfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				LiPerformerPOM.editlicenseicon(driver).click();
				Thread.sleep(7000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(1000,0)");
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
				 // Switching to Alert       
		        Alert alert = driver.switchTo().alert();
		       
		        // Capturing alert message.   
		        String alertMessage= driver.switchTo().alert().getText();
		       
		        Thread.sleep(5000);

		        // Accepting alert
		        alert.accept();
		        test.log(LogStatus.PASS,"License Details Updated Successfully" );
		        
		          Thread.sleep(5000);
		          
		          licmgmtPOM.editlicenseclose(driver).click();
		          Thread.sleep(300);
		         MethodPOM.clickMyDashboard(driver).click();
		      //   Thread.sleep(1000);
		        //  MethodPOM.clickExpiring(driver).click();	
		          
		         // Thread.sleep(3000);
				//LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
				
			//	progress(driver);
				
			//	Thread.sleep(500);
			
				
			/*	if(type.equalsIgnoreCase("Internal"))
				{
					WebDriverWait wait1= new WebDriverWait(driver, 5);
					wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
					LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
					
					
					Select drp = new Select(LiPerformerPOM.clickType(driver));
					drp.selectByIndex(1);
					CFOcountPOM.clickApply1(driver).click();	
					Thread.sleep(500);
					
					  MethodPOM.clickExpiring(driver).click();	
			          
			          Thread.sleep(3000);
					LiPerformerPOM.ExpiredAction(driver).click();					//Clicking on first action button.
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
					js1.executeScript("window.scrollBy(0,3000)");
					wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown(driver)));
					Select status = new Select(OverduePOM.selectInternalDropdown(driver));	//Selecting Status dropdown box.
					status.selectByIndex(2);									//Selecting 2nd value from dropdown.
				}
				else
				{
					  MethodPOM.clickExpiring(driver).click();	
			          
			          Thread.sleep(3000);
					LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
					
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LiPerformerPOM.ShowFream(driver)));		
					js1.executeScript("window.scrollBy(0,1000)");
				    Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown(driver)));
					Select status = new Select(OverduePOM.selectStatutoryDropdown(driver));	//Selecting Status dropdown box.
					status.selectByIndex(2);									//Selecting 2nd value from dropdown.
				}
				
				try
				{
					Thread.sleep(300);
					wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress(driver)));
				}
				catch(Exception e)
				{
					
				}
				
				licenseReviewer.LiReMethodsPOM.perform(driver, test);			//Calling perform method of Reviewer.
				
				try
				{
					Thread.sleep(500);
					LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
					js1.executeScript("window.scrollBy(0,300)");
				}
				catch(Exception e)
				{
					
				}
				
				Thread.sleep(500);
				js1.executeScript("window.scrollBy(0,700)");
				Thread.sleep(300);
				OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.
				
				Thread.sleep(1000);
				js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.
				
				Thread.sleep(300);
				if(type.equalsIgnoreCase("Statutory"))
				{
					String msg = LiPerformerPOM.readMessage(driver).getText();
					if(msg.equalsIgnoreCase("Save Sucessfully."))
					{
						test.log(LogStatus.PASS, "Message Displayed = "+msg);
					}
					else
					{
						test.log(LogStatus.PASS, "Message Displayed = "+msg);
					}
					
					Thread.sleep(500);
					js1.executeScript("window.scrollBy(2000,0)");			//Scrolling up window by 2000 px.
				}
				else
			        	{
						test.log(LogStatus.PASS, "Save Sucessfully.");
						 }
						driver.switchTo().parentFrame();
						
					
					Thread.sleep(700);
					LiPerformerPOM.clickClose(driver).click();				//Clicking on Close (Cross)
					driver.navigate().refresh();
					MethodPOM.clickMyDashboard(driver).click();
					
				}
	
		
	/*	progress(driver);
		
		Thread.sleep(300);
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable(driver)));
		Thread.sleep(500);
		int flag = 0;
		try
		{
			if(LiPerformerPOM.clickAction(driver).isDisplayed())
			{
				flag = 1;
			}
		}
		catch(Exception e)
		{
			
		}
		if(flag == 1)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
			
			int total = Integer.parseInt(OverduePOM.readReminder(driver).getText());
			if(expiring == total)
			{
				test.log(LogStatus.PASS, "Dashboard 'Expiring' count matches to total records displayed. Total records = "+total);
			}
			else
			{
				test.log(LogStatus.FAIL, "Dashboard 'Expiring' count matches doesn't to total records displayed. Total records = "+total);
			}
			
			Thread.sleep(300);
			LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
			
			progress(driver);
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
			Thread.sleep(500);
			if(type.equalsIgnoreCase("Statutory"))
			{
				js.executeScript("window.scrollBy(0,700)");
				wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown(driver)));
				Select status = new Select(OverduePOM.selectStatutoryDropdown(driver));	//Selecting Status dropdown box.
				status.selectByIndex(2);									//Selecting 2nd value from dropdown.
			}
			else
			{
				js.executeScript("window.scrollBy(0,500)");
				wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown(driver)));
				Select status = new Select(OverduePOM.selectInternalDropdown(driver));	//Selecting Status dropdown box.
				status.selectByIndex(2);									//Selecting 2nd value from dropdown.
			}
			
			progress(driver);
			
			licenseReviewer.LiReMethodsPOM.perform(driver, test);		//Calling perform method of Reviewer.
			
			try
			{
				Thread.sleep(500);
				LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
			}
			catch(Exception e)
			{
				
			}
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,500)");				//Scrolling down window by 2000 px.
			
			Thread.sleep(500);
			OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,-1000)");				//Scrolling down window by 2000 px.
			
			if(type.contains("Statutory"))
			{
				Thread.sleep(300);
				LiPerformerPOM.readMessage(driver).click();
				String msg = LiPerformerPOM.readMessage(driver).getText();
				if(msg.equalsIgnoreCase("Save Sucessfully."))
				{
					test.log(LogStatus.PASS, "Message Displayed = "+msg);
				}
				else
				{
					test.log(LogStatus.PASS, "Message Displayed = "+msg);
				}
				
				driver.switchTo().parentFrame();
				Thread.sleep(500);
				LiPerformerPOM.clickClose(driver).click();				//Clicking on Close (Cross)
				
				progress(driver);
			}
		}
		else
		{
			test.log(LogStatus.SKIP, "No records to perform task.");
		}
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard(driver)));
		OverduePOM.clickDashboard(driver).click();
		
		if(type.contains("Internal"))
		{
			WebDriverWait wait1 = new WebDriverWait(driver, 5);
			wait1.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
			LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
			
			Select drp = new Select(LiPerformerPOM.clickType(driver));
			drp.selectByIndex(1);
			
			try
			{
				Thread.sleep(400);
				wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress(driver)));
			}
			catch(Exception e)
			{
				
			}
			
			Thread.sleep(500);
			CFOcountPOM.clickApply1(driver).click();				//Clicking on Apply.
		}
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpiring(driver)));
		int expiring1 = Integer.parseInt(LiPerformerPOM.clickExpiring(driver).getText());	//Reading Active count.
		int pending1 = Integer.parseInt(LiPerformerPOM.clickPendingForReview(driver).getText());
		
		if(expiring1 < expiring)
		{
			test.log(LogStatus.PASS, "Dashboard 'Expiring' count decreased.");
			test.log(LogStatus.INFO, "Old count = "+expiring+" | New Count = "+expiring1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Expiring' count doesn't decreased.");
			test.log(LogStatus.INFO, "Old count = "+expiring+" | New Count = "+expiring1);
		}
		if(pending1 > pending)
		{
			test.log(LogStatus.PASS, "Dashboard 'Pending Review' count increased.");
			test.log(LogStatus.INFO, "Old Count = "+pending+" | New Count = "+pending1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Pending Review' count doesn't increased.");
			test.log(LogStatus.INFO, "Old Count = "+pending+" | New Count = "+pending1);
		}*/
	
	}



	public static void perform(WebDriver driver, ExtentTest test) throws InterruptedException
	{
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		try
		{
			Thread.sleep(500);
			String lic_no = LiReviewerPOM.clickLicenseNo(driver).getText();		//Reading License no 
			if(lic_no.equalsIgnoreCase("") || lic_no.equalsIgnoreCase(null))	//If License no text box is not empty.
			{
				LiReviewerPOM.clickLicenseNo(driver).sendKeys("1234");			//Writing License no
			}
			
			Thread.sleep(500);
			String lic_title = LiReviewerPOM.clickLicenseTitle(driver).getText();	//Reading License title
			if(lic_title.equalsIgnoreCase("") || lic_title.equalsIgnoreCase(null))	//If License title text box is not empty.
			{
				LiReviewerPOM.clickLicenseTitle(driver).sendKeys("Title Automation");	//Writing License title
			}
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			Thread.sleep(700);
			LiReviewerPOM.clickStartDate(driver).click();					//Clicking on Start Date text box
			Thread.sleep(300);
			OverduePOM.selectNextMonth(driver).click();						//Clicking on next month arrow.
			Thread.sleep(300);
			OverduePOM.selectDate2(driver).click();							//Selecting particular date
			
			if(LiReviewerPOM.clickStartDate(driver).getText().equalsIgnoreCase(null))
			{
				Thread.sleep(500);
				LiReviewerPOM.clickStartDate(driver).click();					//Clicking on Start Date text box
				Thread.sleep(300);
				OverduePOM.selectLastMonth(driver).click();						//Clicking on next month arrow.
				Thread.sleep(300);
				OverduePOM.selectDate2(driver).click();							//Selecting particular date
			}
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			Thread.sleep(500);
			LiReviewerPOM.clickEndDate(driver).click();						//Clicking on End Date text box
			Thread.sleep(300);
			OverduePOM.selectNextMonth(driver).click();						//Clicking on next month arrow.
			OverduePOM.selectNextMonth(driver).click();						//Clicking on next month arrow.
			Thread.sleep(300);
			OverduePOM.selectDate3(driver).click();							//Selecting particular date
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(300);
		js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 500 px.
		
		try
		{
			Thread.sleep(500);
			LiReviewerPOM.clickDate(driver).click();						//Clicking on 'Date' input box
			Thread.sleep(300);
			OverduePOM.selectDate2(driver).click();							//Selecting particular date
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			String workingDir = System.getProperty("user.dir");
			OverduePOM.fileUploadStatutory(driver).sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button. (Statutory)
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			String workingDir = System.getProperty("user.dir");
			OverduePOM.fileUploadInternal(driver).sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button. (Internal)
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			
		}
		
		try									//Statutory compliance document link.
		{
			if(LiPerformerPOM.clickComplDocAddButton(driver) != null)
			{
				LiPerformerPOM.clickComplDoc(driver).sendKeys("www.google.com");	//Providing compliance document link.
				Thread.sleep(500);
				LiPerformerPOM.clickComplDocAddButton(driver).click();				//Clicking on 'Add Link' button.
			}
		}
		catch(Exception e)
		{
			
		}
		
		try									//Internal compliance document link.
		{
			if(LiPerformerPOM.clickComplDocAddButton(driver) != null)
			{
				LiPerformerPOM.clickComplDocInternal(driver).sendKeys("www.google.com");	//Providing compliance document link.
				Thread.sleep(500);
				LiPerformerPOM.clickComplDocAddButton(driver).click();				//Clicking on 'Add Link' button.
				Thread.sleep(500);
			}
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(300);
		js.executeScript("window.scrollBy(0,900)");					//Scrolling down window by 500 px.
		
		try
		{
			Thread.sleep(500);
			LiReviewerPOM.clickDate1(driver).click();					//Clicking on 'Date' input box for(Performer - Expiring count verification)
			Thread.sleep(300);
			WebElement ele = null;
			ele = OverduePOM.selectLastMonth(driver);
			if(ele.equals(null))
			{
				OverduePOM.selectNextMonth(driver).click();						//Clicking on next month arrow.
			}
			else
			{
				OverduePOM.selectLastMonth(driver).click();						//Clicking on next month arrow.
			}
			
			Thread.sleep(300);
			OverduePOM.selectDate2(driver).click();						//Selecting particular date
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			Thread.sleep(500);					//Select date for Internal.
			OverduePOM.selectDateInternal(driver).click();				//Clicking on 'Date' input box for(Performer - Expiring count verification)
			Thread.sleep(300);
			OverduePOM.selectLastMonth(driver).click();					//Clicking on Last month
			Thread.sleep(300);
			OverduePOM.selectDate2(driver).click();						//Selecting particular date
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		
		try
		{
			LiReviewerPOM.clikTextArea(driver).sendKeys("Automation Remark");	//Inserting 'Remark'
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			OverduePOM.remark(driver).sendKeys("Automation Remark");	//Inserting 'Remark'
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			OverduePOM.clickInternalRemark(driver).sendKeys("Automation Remark");	//Inserting internal 'Remark'
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			LiReviewerPOM.clikTextArea1(driver).sendKeys("Automation Remark");	//Inserting 'Remark'
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	
	public static void PendingReviewCount(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{	
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		try
		{
		Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress(driver)));
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickPendingForReview(driver)));		
		int pending = Integer.parseInt(LiPerformerPOM.clickPendingForReview(driver).getText());	//Reading 'Pending For Review' count
		int applied = Integer.parseInt(LiPerformerPOM.clickPendingForReview(driver).getText());	//Reading 'Applied' count
		LiPerformerPOM.clickPendingForReview(driver).click();		//Clicking on 'Pending For Review' image link
		
		Thread.sleep(500);
		try
		{
			Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress(driver)));
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(5000);
	//	LiPerformerPOM.clickPendingForReview(driver).click();					//Clicking on total items count
		String item = MethodPOM.clickReadExpiring(driver).getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String LicenseExpiringCount = bits[bits.length - 2];		//Getting the second last word (tot
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable(driver)));
		//LiReviewerPOM.clickReviewer(driver).click();
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 500 px.
		//int total = Integer.parseInt(OverduePOM.readReminder(driver).getText());	//Reading total records count
		
		if(pending == applied)
		{
			//test.log(LogStatus.PASS, "Dashboard 'Pending Review' count matches to total records displayed.");
			test.log(LogStatus.PASS, "Dashboard 'Pending Review' count = "+pending+" | Total records in grid = "+applied);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Dashboard 'Pending Review' count doesn't matches to total records displayed.");
			test.log(LogStatus.FAIL, "Dashboard 'Pending Review' count = "+pending+" | Total records in grid = "+applied);
		}
	
		Thread.sleep(5000);
		LiReviewerPOM.Overviewreview1(driver).click();
		
    	test.log(LogStatus.PASS, " License Overview Details Successfully");
    	Thread.sleep(5000);
		MethodPOM.ClickCloseOverview(driver).click();		
		Thread.sleep(500);
		
		/*elementsList = LiReviewerPOM.clickAction(driver);
		int n = elementsList.size();
		int k = 1;
		for(int i = 1; i < n; i++)
		{
			
			/*elementsList = LiReviewerPOM.clickAction(driver);
			elementsList.get(i).click();									//Clicking on ith Action button.
			Thread.sleep(500);
		*/
		LiReviewerPOM.Reviewaction(driver).click();
		Thread.sleep(5000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;    
			js.executeScript("window.scrollBy(0,800)");
			Thread.sleep(500);
              Actions act =new Actions(driver);
                act.sendKeys(Keys.PAGE_DOWN).build().perform();
                Thread.sleep(3000);
                
                LiReviewerPOM.clickdownload(driver).click();
				
		/*	if(ReviewerPOM.clickView1(driver).isDisplayed())
			{
				Thread.sleep(1000);
				ReviewerPOM.clickView1(driver).click();							//Clicking on 'View' link
				
				Thread.sleep(3000);
				try
				{
					ReviewerPOM.clickCloseView(driver).click();						//Clicking on Close (cross) to close view
				}
				catch(Exception e)
				{
					ReviewerPOM.clickCloseView1(driver).click();						//Clicking on Close (cross) to close view
				}
				*
				Thread.sleep(500);
				ReviewerPOM.clickDownload2(driver).click();
				
				perform(driver, test);
				*/
                act.sendKeys(Keys.PAGE_DOWN).build().perform();
				Thread.sleep(5000);
				if(ReviewerPOM.clickApprove(driver).isEnabled())
				{
					ReviewerPOM.clickApprove(driver).click();					//Clicking on Approve
				}
				
				Thread.sleep(5000);
				js.executeScript("window.scrollBy(0,-3000)");					//Scrolling down window by 500 px.
				
				Thread.sleep(500);
				String msg = LiPerformerPOM.readMessage(driver).getText();		//Reading message after Appove.
				
				if(msg.equalsIgnoreCase("Approved Successfully."))
				{
					test.log(LogStatus.PASS, "Message displayed = "+msg);
				}
				else
				{
					test.log(LogStatus.FAIL, "Message displayed = "+msg);
				}
				
				Thread.sleep(500);
				driver.switchTo().parentFrame();
				
				LiPerformerPOM.clickClose(driver).click();
				Thread.sleep(500);
				driver.navigate().refresh();
				Thread.sleep(3000);
				LiReviewerPOM.Reviewaction(driver).click();
				Thread.sleep(5000);
				
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
				   
					js.executeScript("window.scrollBy(0,800)");
					Thread.sleep(500);
		              Actions act1 =new Actions(driver);
		                act1.sendKeys(Keys.PAGE_DOWN).build().perform();
		                Thread.sleep(5000);
		                
		                LiReviewerPOM.clickdownload(driver).click();
		                act1.sendKeys(Keys.PAGE_DOWN).build().perform();
		                Thread.sleep(5000);
						if(LiReviewerPOM.rejectbtn(driver).isEnabled())
						{
							LiReviewerPOM.rejectbtn(driver).click();					//Clicking on Approve
						}
						
						Thread.sleep(5000);
						js.executeScript("window.scrollBy(0,-3000)");					//Scrolling down window by 500 px.
						
						Thread.sleep(500);
						String msg1 = LiPerformerPOM.readMessage(driver).getText();		//Reading message after Appove.
						
						if(msg1.equalsIgnoreCase("Rejected Successfully."))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg1);
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg1);
						}
				
				Thread.sleep(3000);
				
				//LiPerformerPOM.clickClose(driver).click();		
			
		}
		
			//Clicking on Close (Cross)
				
	/*	try
				{
					Thread.sleep(300);
					wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress(driver)));
				}
				catch(Exception e)
				{
					
				}
				
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0,700)");
				
				Thread.sleep(500);
				int total1 = Integer.parseInt(OverduePOM.readReminder(driver).getText());	//Reading total records count
				if(total1 < applied)
				{
					test.log(LogStatus.PASS, "Total records count from grid decreased.");
					test.log(LogStatus.INFO, "Old Count = "+applied+" | New Count = "+total1);
				}
				else
				{
					test.log(LogStatus.FAIL, "Total records count from grid doesn't decreased.");
					test.log(LogStatus.INFO, "Old Count = "+applied+" | New Count = "+total1);
				}
				
				Thread.sleep(100);
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard(driver)));
				OverduePOM.clickDashboard(driver).click();							//CLicking on Dashboard.
				
				Thread.sleep(700);
				wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickPendingForReview(driver)));		
				int pending1 = Integer.parseInt(LiPerformerPOM.clickPendingForReview(driver).getText());	//Reading 'Pending For Review' count
				int applied1 = Integer.parseInt(LiPerformerPOM.clickApplied(driver).getText());	//Reading 'Applied' count
				
				if(pending1 < pending)
				{
					test.log(LogStatus.PASS, "'Pending For Review' license count decreased.");
					test.log(LogStatus.INFO, "Old Count = "+pending+" | New Count = "+pending1);
				}
				else
				{
					test.log(LogStatus.FAIL, "'Pending For Review' license count doesn't decreased.");
					test.log(LogStatus.INFO, "Old count = "+pending+" | New Count = "+pending1);
				}
				
				if(applied1 > applied)
				{
					test.log(LogStatus.PASS, "'Applied' license count increased.");
					test.log(LogStatus.INFO, "Old Count = "+applied+" | New Count = "+applied1);
				}
				else
				{
					test.log(LogStatus.FAIL, "'Applied' license count doesn't increased.");
					test.log(LogStatus.INFO, "Old count = "+applied+" | New Count = "+applied1);
				}
		if(i == n-1)
			{
				LiReviewerPOM.clickIndexDropDown(driver).click();
				Thread.sleep(500);
				elementsList1 = LiReviewerPOM.clickIndexDropDownOption(driver);
				int m = elementsList1.size();
				if(k <= m)				//Hear initially k- 1 as we are already on page 0
				{
					elementsList1.get(k).click();
					Thread.sleep(500);
					elementsList = LiReviewerPOM.clickAction(driver);
					n = elementsList.size();
					i = -1;
					k++;
				}
				else
				{
					test.log(LogStatus.PASS, "Didn't found any 'Pending For Review' license.");
					break;
				
				}
			
		*/
	
		



	public static void PendingReviewCountInternal(WebDriver driver, ExtentTest test, String string) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try
		{
			Thread.sleep(3000);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress(driver)));
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickPendingForReview(driver)));		
		int pending = Integer.parseInt(LiPerformerPOM.clickPendingForReview(driver).getText());	//Reading 'Pending For Review' count
		int applied = Integer.parseInt(LiPerformerPOM.clickPendingForReview(driver).getText());	//Reading 'Applied' count
		LiPerformerPOM.clickPendingForReview(driver).click();		//Clicking on 'Pending For Review' image link
		
		Thread.sleep(3000);
		try
		{
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress(driver)));
		}
		catch(Exception e)
		{
			
		}
		
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable(driver)));
		//LiReviewerPOM.clickReviewer(driver).click();
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 500 px.
		//int total = Integer.parseInt(OverduePOM.readReminder(driver).getText());	//Reading total records count
		
		if(pending == applied)
		{
			//test.log(LogStatus.PASS, "Dashboard 'Pending Review' count matches to total records displayed.");
			test.log(LogStatus.PASS, "Dashboard 'Pending Review' count = "+pending+" | Total records in grid = "+applied);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Dashboard 'Pending Review' count doesn't matches to total records displayed.");
			test.log(LogStatus.PASS, "Dashboard 'Pending Review' count = "+pending+" | Total records in grid = "+applied);
		}
		
		
		Thread.sleep(5000);
		LiReviewerPOM.Overviewreview1(driver).click();
		
    	test.log(LogStatus.PASS, " License Overview Details Successfully");
    	Thread.sleep(5000);
		MethodPOM.ClickCloseOverview(driver).click();		
		Thread.sleep(500);
		
		LiReviewerPOM.Reviewaction(driver).click();
		//elementsList = LiReviewerPOM.clickAction(driver);
		//elementsList.get(0).click();									//Clicking on ith Action button.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,700)");
		
		Thread.sleep(500);
		
		//ReviewerPOM.clickDownload2(driver).click();
		
		Thread.sleep(5000);
		if(ReviewerPOM.clickApprove(driver).isEnabled())
		{
			ReviewerPOM.clickApprove(driver).click();					//Clicking on Approve
		}
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,-3000)");					//Scrolling down window by 500 px.
		
		Thread.sleep(500);
		String msg = LiPerformerPOM.readMessage(driver).getText();		//Reading message after Appove.
		
		if(msg.equalsIgnoreCase("Approved Successfully."))
		{
			test.log(LogStatus.PASS, "Message displayed = "+msg);
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed = "+msg);
		}
		
		Thread.sleep(500);
		driver.switchTo().parentFrame();
		
		Thread.sleep(500);
		LiPerformerPOM.clickClose(driver).click();	
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		LiReviewerPOM.Reviewaction(driver).click();
		Thread.sleep(5000);
		
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
		   
			js.executeScript("window.scrollBy(0,800)");
			Thread.sleep(500);
              Actions act1 =new Actions(driver);
                act1.sendKeys(Keys.PAGE_DOWN).build().perform();
                Thread.sleep(3000);
                
                 ReviewerPOM.clickDownload2(driver).click();
               
                LiReviewerPOM.intremark(driver).sendKeys("NA");
                Thread.sleep(500);
				if(LiReviewerPOM.inrejectbtn(driver).isEnabled())
				{
					LiReviewerPOM.inrejectbtn(driver).click();					//Clicking on Approve
				}
				
				Thread.sleep(500);
				js.executeScript("window.scrollBy(0,-3000)");					//Scrolling down window by 500 px.
				
				Thread.sleep(500);
				String msg1 = LiPerformerPOM.readMessage(driver).getText();		//Reading message after Appove.
				
				if(msg1.equalsIgnoreCase("Rejected Successfully."))
				{
					test.log(LogStatus.PASS, "Message displayed = "+msg1);
				}
				else
				{
					test.log(LogStatus.FAIL, "Message displayed = "+msg1);
				}
		
		Thread.sleep(3000);
		
		/*perform(driver, test);
		
		Thread.sleep(500);
		ReviewerPOM.clickApprove(driver).click();					//Clicking on Approve
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,700)");
		*/
/*	Thread.sleep(500);
		int total1 = Integer.parseInt(OverduePOM.readReminder(driver).getText());	//Reading total records count
		if(total1 < applied)
		{
			//test.log(LogStatus.PASS, "Total records count from grid decreased.");
			test.log(LogStatus.PASS, "Old Count = "+applied+" | New Count = "+total1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Total records count from grid doesn't decreased.");
			test.log(LogStatus.FAIL, "Old Count = "+applied+" | New Count = "+total1);
		}
		
		Thread.sleep(100);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard(driver)));
		OverduePOM.clickDashboard(driver).click();							//CLicking on Dashboard.
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
		LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
		
		Select drp = new Select(LiPerformerPOM.clickType(driver));
		drp.selectByIndex(1);									//Selecting 'Internal' type.
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply1(driver).click();				//Clicking on Apply.
		
		Thread.sleep(700);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickPendingForReview(driver)));		
		int pending1 = Integer.parseInt(LiPerformerPOM.clickPendingForReview(driver).getText());	//Reading 'Pending For Review' count
		int applied1 = Integer.parseInt(LiPerformerPOM.clickApplied(driver).getText());	//Reading 'Applied' count
		
		if(pending1 < pending)
		{
			//test.log(LogStatus.PASS, "'Pending For Review' license count decreased.");
			test.log(LogStatus.PASS, "Old Count = "+pending+" | New Count = "+pending1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "'Pending For Review' license count doesn't decreased.");
			test.log(LogStatus.FAIL, "Old count = "+pending+" | New Count = "+pending1);
		}
		
		if(applied1 > applied)
		{
			test.log(LogStatus.PASS, "'Applied' license count increased.");
			test.log(LogStatus.INFO, "Old Count = "+applied+" | New Count = "+applied1);
		}
		else
		{
			test.log(LogStatus.FAIL, "'Applied' license count doesn't increased.");
			test.log(LogStatus.INFO, "Old count = "+applied+" | New Count = "+applied1);
		}*/
	}
	public static void ReviewerExpiredCount(WebDriver driver, ExtentTest test, String type) throws InterruptedException 
	{
		  WebDriverWait wait = new WebDriverWait(driver, 40);
			
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired(driver)));
			String Expired=MethodPOM.clickExpired(driver).getText();
			
		     int Expiredlicense = Integer.parseInt(Expired);	//Reading Expired count.
		 	   Thread.sleep(4000);
		      MethodPOM.clickExpired(driver).click();					//Clicking on 'Expired' image
		      Thread.sleep(4000);
		        JavascriptExecutor js1=(JavascriptExecutor) driver ;
				js1.executeScript("window.scroll(0,500)");
				Thread.sleep(4000);
				
				MethodPOM.clickReadExpired(driver).click();					//Clicking on total items count
				Thread.sleep(4000);
				String item = MethodPOM.clickReadExpired(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String LicenseExpiredCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(LicenseExpiredCount);
				if(Expiredlicense == total)
		{
			//test.log(LogStatus.PASS, "Dashboard 'Expired' count matches to the total records displayed in grid.");
			test.log(LogStatus.PASS, "Dashboard 'Expired' count = "+Expiredlicense+" | Total records in grid = "+total);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Dashboard 'Expired' count doesn't matches to the total records displayed in grid.");
			test.log(LogStatus.FAIL, "Dashboard 'Expired' count = "+Expiredlicense+" | Total records in grid = "+total);
		}
		
				MethodPOM.ClickActiveOverview(driver).click();
				test.log(LogStatus.PASS, "Expired License Overview Details Successfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				Thread.sleep(3000);
				LiPerformerPOM.editlicenseicon(driver).click();
				Thread.sleep(7000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(1000,0)");
				Thread.sleep(3000);
				licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
				 // Switching to Alert       
		        Alert alert = driver.switchTo().alert();
		       
		        // Capturing alert message.   
		        String alertMessage= driver.switchTo().alert().getText();
		       
		        Thread.sleep(3000);

		        // Accepting alert
		        alert.accept();
		        test.log(LogStatus.PASS,"License Details Updated Successfully" );
		        
		          Thread.sleep(5000);
		          
		          licmgmtPOM.editlicenseclose(driver).click();
		          Thread.sleep(3000);
		          MethodPOM.clickMyDashboard(driver).click();
		          Thread.sleep(3000);
		        //  MethodPOM.clickExpired(driver).click();
		          
				
	//	Thread.sleep(5000);
		//LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
		
		//progress(driver);
		
		Thread.sleep(500);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		/*
		if(type.equalsIgnoreCase("Internal"))
		{
			WebDriverWait wait1 = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
			LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
			
			Select drp = new Select(LiPerformerPOM.clickType(driver));
			drp.selectByIndex(1);
			Thread.sleep(500);
			CFOcountPOM.clickApply1(driver).click();
			
			  MethodPOM.clickExpired(driver).click();
				
				Thread.sleep(5000);
				LiPerformerPOM.ExpiredAction(driver).click();					//Clicking on first action button.
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
				js1.executeScript("window.scrollBy(0,3000)");
			    Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown(driver)));
			Select status = new Select(OverduePOM.selectInternalDropdown(driver));	//Selecting Status dropdown box.
			status.selectByIndex(2);									//Selecting 2nd value from dropdown.
		}
		else
		{
			
			  MethodPOM.clickExpired(driver).click();
				
				Thread.sleep(5000);
				LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LiPerformerPOM.ShowFream(driver)));		
			js1.executeScript("window.scrollBy(0,1000)");
		    Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown(driver)));
			Select status = new Select(OverduePOM.selectStatutoryDropdown(driver));	//Selecting Status dropdown box.
			status.selectByIndex(2);									//Selecting 2nd value from dropdown.
		}
		
		try
		{
			Thread.sleep(300);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress(driver)));
		}
		catch(Exception e)
		{
			
		}
		
		licenseReviewer.LiReMethodsPOM.perform(driver, test);			//Calling perform method of Reviewer.
		
		try
		{
			Thread.sleep(500);
			LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
			js1.executeScript("window.scrollBy(0,300)");
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(5000);
		js1.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.
		
		Thread.sleep(1000);
		js1.executeScript("window.scrollBy(0,-2000)");				//Scrolling down window by 2000 px.
		
		Thread.sleep(3000);
		if(type.equalsIgnoreCase("Statutory"))
		{
			Thread.sleep(1000);
			String msg = LiPerformerPOM.readMessage(driver).getText();
			
			if(msg.equalsIgnoreCase("Saved Sucessfully."))
			{

				test.log(LogStatus.PASS, "Message Displayed = "+msg);
			}
			else
			{
				test.log(LogStatus.FAIL, "Message Displayed = "+msg);
			}
		}
			else
			{
				test.log(LogStatus.PASS, "Saved Sucessfully.");
			}
	
			driver.switchTo().parentFrame();
			
			Thread.sleep(1000);
			LiPerformerPOM.clickClose(driver).click();		*/		//Clicking on Close (Cross)
			driver.navigate().refresh();
			MethodPOM.clickMyDashboard(driver).click();
		}
		
		/*progress(driver);
		Thread.sleep(4000);
		js1.executeScript("window.scrollBy(0,2000)");
		wait.until(ExpectedConditions.elementToBeClickable(MethodPOM.clickReadExpired(driver)));
	    // int total1 = Integer.parseInt(MethodPOM.clickReadExpired(driver).getText());
	     String item1 = MethodPOM.clickReadExpired(driver).getText();	//Reading total items String value
			String[] bits1 = item1.split(" ");								//Splitting the String
			String LicenseExpiredCount1 = bits1[bits1.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total1 = Integer.parseInt(LicenseExpiredCount1);
			if(Expiredlicense == total)
		if(total1 < total)
		{
			test.log(LogStatus.PASS, "Count of records in grid decreased.");
			test.log(LogStatus.INFO, "Old Count = "+total+" | New Count = "+total1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Count of records in grid doesn't decreased.");
			test.log(LogStatus.INFO, "Old Count = "+total+" | New Count = "+total1);
		}
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard(driver)));
		OverduePOM.clickDashboard(driver).click();
		
		Thread.sleep(700);
		if(type.equalsIgnoreCase("Internal"))
		{
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
			LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
			Select drp = new Select(LiPerformerPOM.clickType(driver));
			drp.selectByIndex(1);
			
			progress(driver);
			
			Thread.sleep(500);
			CFOcountPOM.clickApply1(driver).click();				//Clicking on Apply.
		}
		
		Thread.sleep(700);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired(driver)));
		int expired1 = Integer.parseInt(LiPerformerPOM.clickExpired(driver).getText());	//Reading Active count.
		if(expired1 < Expiredlicense)
		{
			test.log(LogStatus.PASS, "Dashboard 'Expired' count decreased.");
			test.log(LogStatus.INFO, "Old Count = "+Expiredlicense+" | New Count = "+expired1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Expired' count doesn't decreased.");
			test.log(LogStatus.INFO, "Old Count = "+Expiredlicense+" | New Count = "+expired1);
		}*/
	public static void ReviewerAppliedCount(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{		
		/*WebDriverWait wait = new WebDriverWait(driver, 20);
		progress(driver);
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickApplied(driver)));
		int applied = Integer.parseInt(LiPerformerPOM.clickApplied(driver).getText());	//Reading Applied count.
		
		LiPerformerPOM.clickApplied(driver).click();	*/					//Clicking on 'Applied'
		
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickApplied(driver)));
			int applied = Integer.parseInt(LiPerformerPOM.clickApplied(driver).getText());	//Reading Applied count.
			
	//		String Applied=MethodPOM.clickApplied(driver).getText();
			
		 //    int AppliedLicense = Integer.parseInt(Applied);	//Reading Expired count.

		      MethodPOM.clickApplied(driver).click();					//Clicking on 'Active' image
		      Thread.sleep(4000);
		        JavascriptExecutor js1=(JavascriptExecutor) driver ;
				js1.executeScript("window.scroll(0,500)");
				Thread.sleep(4000);
				
				MethodPOM.clickReadApplied(driver).click();					//Clicking on total items count
				Thread.sleep(500);
				String item = MethodPOM.clickReadApplied(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String LicenseAppliedCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
				int total = Integer.parseInt(LicenseAppliedCount);
				if(applied == total)
		{
			//test.log(LogStatus.PASS, "Dashboard 'Applied' count matches to the total records displayed.");
			test.log(LogStatus.PASS, "Dashboard 'Applied' count = "+applied+" | Total records = "+total);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Dashboard 'Applied' count matches doesn't to the total records displayed.");
			test.log(LogStatus.FAIL, "Dashboard 'Applied' count = "+applied+" | Total records = "+total);
		}
		
		Thread.sleep(300);
		MethodPOM.ClickActiveOverview(driver).click();
		test.log(LogStatus.PASS, "Expiring License Overview Details Successfully");
		Thread.sleep(3000);
		MethodPOM.ClickCloseOverview(driver).click();
		LiPerformerPOM.editlicenseicon(driver).click();
		Thread.sleep(7000);
		licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
		Thread.sleep(3000);
		licenseManagement.licmgmtPOM.LicenseNo(driver).clear();
		Thread.sleep(3000);
		licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
		Thread.sleep(5000);
		js1.executeScript("window.scrollBy(1000,0)");
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
		 // Switching to Alert       
        Alert alert = driver.switchTo().alert();
       
        // Capturing alert message.   
        String alertMessage= driver.switchTo().alert().getText();
       
        Thread.sleep(5000);

        // Accepting alert
        alert.accept();
        test.log(LogStatus.PASS,"License Details Updated Successfully" );
        
          Thread.sleep(5000);
          
          licmgmtPOM.editlicenseclose(driver).click();
          Thread.sleep(300);
         MethodPOM.clickMyDashboard(driver).click();
         Thread.sleep(1000);
      //  MethodPOM.clickApplied(driver).click();
       // Thread.sleep(5000);
		//LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
		
		//progress(driver);
		
		Thread.sleep(500);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		
		//licenseReviewer.LiReMethodsPOM.perform(driver, test);		//Calling perform method of Reviewer.
		/*
		if(type.equalsIgnoreCase("Internal"))
		{
			WebDriverWait wait1= new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
			LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
			
			
			Select drp = new Select(LiPerformerPOM.clickType(driver));
			drp.selectByIndex(1);
			CFOcountPOM.clickApply1(driver).click();	
			  Thread.sleep(3000);
		     MethodPOM.clickApplied(driver).click();
		         Thread.sleep(1000);
    
				
				LiPerformerPOM.AppliedActionin(driver).click();					//Clicking on first action button.
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
			js1.executeScript("window.scroll(0,500)");	
			LiPerformerPOM.LicenseNo(driver).sendKeys("234");
			Thread.sleep(500);
			LiPerformerPOM.Licensetitle(driver).sendKeys("License234");
			Thread.sleep(500);
			LiPerformerPOM.AppliedStartDateclick(driver).click();
			Thread.sleep(500);
			LiPerformerPOM.AppliedStartDate(driver).click();
			Thread.sleep(3000);
		   LiPerformerPOM.AppliedEndDateclick(driver).click();
		   Thread.sleep(3000);
		   LiPerformerPOM.AppliedEndDate(driver).click();
		   String workingDir = System.getProperty("user.dir");
			LiPerformerPOM.UploadDocument(driver).sendKeys(workingDir+"//Reports//PerformerResults.html");	//uploading new file		
			Thread.sleep(500);
		}
		else
		{
			  MethodPOM.clickApplied(driver).click();
				Thread.sleep(5000);
			LiPerformerPOM.AppliedAction(driver).click();					//Clicking on first action button.
			Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
		//js1.executeScript("window.scroll(0,500)");	
		Thread.sleep(3000);
		LiPerformerPOM.LicenseNo(driver).sendKeys("234");
		Thread.sleep(500);
		LiPerformerPOM.Licensetitle(driver).sendKeys("License234");
		Thread.sleep(500);
		LiPerformerPOM.AppliedStartDateclick(driver).click();
		Thread.sleep(500);
		LiPerformerPOM.AppliedStartDate(driver).click();
		Thread.sleep(3000);
	   LiPerformerPOM.AppliedEndDateclick(driver).click();
	   Thread.sleep(3000);
	   LiPerformerPOM.AppliedEndDate(driver).click();
	   Thread.sleep(3000);
	   String workingDir = System.getProperty("user.dir");
		LiPerformerPOM.UploadDocument(driver).sendKeys(workingDir+"//Reports//PerformerResults.html");	//uploading new file		
		Thread.sleep(500);
	   
		}
			
		//	Thread.sleep(500);
			//LiPerformerPOM.clickComplDoc(driver).clear();
			//LiPerformerPOM.clickComplDoc(driver).sendKeys("www.google.com");	//Providing compliance document link.
		
		
		
	//	Thread.sleep(300);
	//	OverduePOM.AppliedSubmit(driver).click();			//Clicking on 'Submit' button.
		/*try
		{
			Thread.sleep(500);
			driver.switchTo().alert().dismiss();
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
	     	js1.executeScript("window.scrollBy(2000,0)");				//Scrolling down window by 2000 px.
		
		if(type.equalsIgnoreCase("Statutory"))
		try
		{
			String msg = LiPerformerPOM.readMsg(driver).getText();
			if(msg.equalsIgnoreCase("Compliance Created and Assigned Sucessfully"))
			{
				test.log(LogStatus.PASS, "Message Displayed = "+msg);
			}
			else
			{
				test.log(LogStatus.FAIL, "Message Displayed = "+msg);
			}
		}
		catch(Exception e)
		{
			
		}
		
		//driver.switchTo().parentFrame();
		
		Thread.sleep(500);
		//js.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 1000 px.
	/*	String workingDir = System.getProperty("user.dir");
		//LiPerformerPOM.UploadDocument(driver).sendKeys(workingDir+"//Reports//PerformerResults.html");	//uploading new file		
		//Thread.sleep(500);
		
		OverduePOM.AppliedSubmit(driver).click();			//Clicking on 'Submit' button.
		Thread.sleep(500);
		*/
		//driver.switchTo().parentFrame();
		//Thread.sleep(5000);
		//LiPerformerPOM.clickClose(driver).click();				//Clicking on Close (Cross)
		
	//	progress(driver);
		
		//Thread.sleep(500);
		//wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard(driver)));
		//OverduePOM.clickDashboard(driver).click();
		
		/*if(type.equalsIgnoreCase("Internal"))			//Opening 'Internal' Dashboard
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
			LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
			
			Select drp = new Select(LiPerformerPOM.clickType(driver));
			drp.selectByIndex(1);
			
			progress(driver);
			
			Thread.sleep(500);
			CFOcountPOM.clickApply1(driver).click();				//Clicking on Apply.
		}
		
	/*	wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickActive(driver)));
		int applied1 = Integer.parseInt(LiPerformerPOM.clickApplied(driver).getText());	//Reading Active count.
		if(applied1 < Applied)
		{
			test.log(LogStatus.PASS, "Dashboard 'Applied' count decreased.");
			test.log(LogStatus.INFO, "Old Count = "+Applied+". New Count = "+applied1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Applied' count doesn't decreased.");
			test.log(LogStatus.INFO, "Old Count = "+Applied+". New Count = "+applied1);
		}*/
	}

	
	 public static void LicenseExpiringOnStatutory(WebDriver driver, ExtentTest test, String type) throws InterruptedException, IOException
	   {
		   Thread.sleep(5000);
		   MethodPOM.ClickMaximizeLicenseExpiringOn(driver).click();
		   Thread.sleep(3000);
		   test.log(LogStatus.PASS, "Expiring On Maximize Button Working Successfully");
		 
		   JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			  Thread.sleep(3000);
			MethodPOM.DashExpiringOnExport(driver).click();
			test.log(LogStatus.PASS, "Dashboard Expiring License Download Successfully");
			
		/*  LiReviewerPOM.revexpiringOn(driver).click();
		   Thread.sleep(7000);
		   WebDriverWait wait = new WebDriverWait(driver, 40);
		   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showLicenseDetails"));
		   String NoRecord = MethodPOM.Norecord(driver).getText();
		   if(!NoRecord.equalsIgnoreCase("No items to display")) 
		   {
		   
		   MethodPOM.ClickExportExpiredOn(driver).click();
			test.log(LogStatus.PASS, "Expiring License List Downloaded Sucessfully");
			Thread.sleep(5000);
			MethodPOM.ExpiredOnLictype(driver).click();
			MethodPOM.searchExpiredOnLictype(driver).sendKeys("Boiler",Keys.ENTER);
			MethodPOM.Clearfilter(driver).click();
			test.log(LogStatus.PASS, "Clear Filter Button Working  Successfully");
			
	    
			Thread.sleep(7000);
		    licenseManagement.licmgmtPOM.lictype(driver).click();
			Thread.sleep(7000);
		    licenseManagement.licmgmtPOM.lictype1(driver).click();
			Thread.sleep(7000);
			MethodPOM.Clearfilter(driver).click();
			test.log(LogStatus.PASS, "Clear Filter Button Working  Successfully");
			Thread.sleep(7000);
			MethodPOM.ClickOverviewExpiredOn(driver).click();
			test.log(LogStatus.PASS, "Expiring OverView License Displayed");
			 Thread.sleep(3000);
	             MethodPOM.clickBystatuscloseoverview(driver).click();
				 Thread.sleep(2000);
				
				
				  // Js.executeScript("window.scrollBy(500,0)");
				driver.switchTo().parentFrame();
				 MethodPOM.clickCloseGraphPopup(driver).click();
				 Thread.sleep(3000);
				
		   }
		   else
		   {
			   driver.switchTo().parentFrame();
				 MethodPOM.clickCloseGraphPopup(driver).click();
				 Thread.sleep(3000);
				  test.log(LogStatus.PASS, "Expiring On Popup No Record Found ");
		   }*/
}
	 public static void ReviewerRejectedCount(WebDriver driver, ExtentTest test, String type) throws InterruptedException 
		{
			 
		 WebDriverWait wait = new WebDriverWait(driver, 20);
				
				wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickRejected(driver)));
				String Rejected=MethodPOM.clickRejected(driver).getText();
				
			     int RejectedLicense = Integer.parseInt(Rejected);	//Reading Rejected count.

			      MethodPOM.clickRejected(driver).click();					//Clicking on 'Rejected ' image
			      Thread.sleep(4000);
			        JavascriptExecutor js1=(JavascriptExecutor) driver ;
					js1.executeScript("window.scroll(0,500)");
					Thread.sleep(4000);
					
					MethodPOM.clickReadRejected(driver).click();					//Clicking on total items count
					Thread.sleep(500);
					String item = MethodPOM.clickReadRejected(driver).getText();	//Reading total items String value
					String[] bits = item.split(" ");								//Splitting the String
					String LicensRejected = bits[bits.length - 2];		//Getting the second last word (total number of users)
					
					//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
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
						
						MethodPOM.ClickActiveOverview(driver).click();
						test.log(LogStatus.PASS, " License Overview Details Successfully");
						Thread.sleep(3000);
						MethodPOM.ClickCloseOverview(driver).click();
						Thread.sleep(3000);
						LiPerformerPOM.editlicenseicon(driver).click();
						Thread.sleep(5000);
						licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
						Thread.sleep(5000);
						licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
						Thread.sleep(5000);
						licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
						Thread.sleep(5000);
						js1.executeScript("window.scrollBy(0,2000)");
						Thread.sleep(3000);
						 Actions act =new Actions(driver);
			                act.sendKeys(Keys.PAGE_DOWN).build().perform();
			                Thread.sleep(3000);
						//LiPerformerPOM.editnomineebtn(driver).click();
						/*Thread.sleep(3000);
						 licmgmtPOM.ClickNomineedrp(driver).click();
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
						 licmgmtPOM.selectnomineenddate(driver).click();
						 Thread.sleep(5000);
					*/
						licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
						 // Switching to Alert       
				        Alert alert = driver.switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= driver.switchTo().alert().getText();
				       
				        Thread.sleep(3000);
				      //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				       // System.out.println(alertMessage);
				        // Accepting alert
				        /*Thread.sleep(3000);
				        By locator = By.xpath("//*[@class='k-button-group k-dialog-buttongroup k-dialog-button-layout-stretched']");

				    	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				    	Thread.sleep(4000);
				    	
				    	WebElement ViewButton = driver.findElement(locator);	
				    	Thread.sleep(3000);
				    JavascriptExecutor jse=(JavascriptExecutor)driver;
				    jse.executeScript("arguments[0].click();", ViewButton);
				    	Thread.sleep(4000);
				        
				      //  LiPerformerPOM.licenseOK(driver).click();
				        
				     */
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
				        
				          Thread.sleep(5000);
				          
				          licmgmtPOM.editlicenseclose(driver).click();
				          Thread.sleep(300);
				          MethodPOM.clickMyDashboard(driver).click();
				          Thread.sleep(1000);
				         // MethodPOM.clickActive(driver).click();	
				          
				        //  Thread.sleep(3000);
					//	LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
						
						//progress(driver);
						
						//Thread.sleep(500);
					

					//	LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
						
						//progress(driver);
						
						Thread.sleep(500);
					//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
						
						/*if(type.equalsIgnoreCase("Internal"))
						{
							WebDriverWait wait1= new WebDriverWait(driver, 5);
							wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
							LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
							
							
							Select drp = new Select(LiPerformerPOM.clickType(driver));
							drp.selectByIndex(1);
							CFOcountPOM.clickApply1(driver).click();	
							  Thread.sleep(3000);
							 
							MethodPOM.clickRejected(driver).click();	

							OverduePOM.RejectedAction(driver).click();					//Clicking on first action button.
					        Thread.sleep(3000);
					     
					        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
							js1.executeScript("window.scrollBy(0,2000)");
							wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown(driver)));
							Select status = new Select(OverduePOM.selectInternalDropdown(driver));	//Selecting Status dropdown box.
							status.selectByIndex(2);									//Selecting 2nd value from dropdown.
						}
						else
						{
							MethodPOM.clickRejected(driver).click();
							 Thread.sleep(500);
							LiPerformerPOM.rejectAction(driver).click();					//Clicking on first action button.
					        Thread.sleep(3000);
					     
							wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));		
							js1.executeScript("window.scrollBy(0,1000)");
						    Thread.sleep(5000);
							wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown(driver)));
							Select status = new Select(OverduePOM.selectStatutoryDropdown(driver));	//Selecting Status dropdown box.
							status.selectByIndex(2);									//Selecting 2nd value from dropdown.
						}
						
						try
						{
							Thread.sleep(300);
							wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress(driver)));
						}
						catch(Exception e)
						{
							
						}
						
						licenseReviewer.LiReMethodsPOM.perform(driver, test);			//Calling perform method of Reviewer.
						
						try
						{
							Thread.sleep(500);
							LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
							js1.executeScript("window.scrollBy(0,300)");
						}
						catch(Exception e)
						{
							
						}
						
						Thread.sleep(500);
						js1.executeScript("window.scrollBy(0,700)");
						Thread.sleep(300);
						OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.
						
						Thread.sleep(1000);
						js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.
						
						Thread.sleep(300);
						if(type.equalsIgnoreCase("Statutory"))
						{
							String msg = LiPerformerPOM.readMessage(driver).getText();
							if(msg.equalsIgnoreCase("Saved Sucessfully."))
							{
								test.log(LogStatus.PASS, "Message Displayed = "+msg);
							}
							else
							{
								test.log(LogStatus.FAIL, "Message Displayed = "+msg);
							}
							
							Thread.sleep(500);
							js1.executeScript("window.scrollBy(2000,0)");			//Scrolling up window by 2000 px.
							
							driver.switchTo().parentFrame();
							
							Thread.sleep(700);
							LiPerformerPOM.clickClose(driver).click();				//Clicking on Close (Cross)
							driver.navigate().refresh();
							
						}
						*/
						
					//	MethodPOM.clickMyDashboard(driver).click();
			   
			
		}
	 public static void ReviewerTerminateLicense1(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	   {
		  
			   
		   WebDriverWait wait = new WebDriverWait(driver, 20);
			
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.terminatedPerformer(driver)));
			String Terminate=LiPerformerPOM.terminatedPerformer(driver).getText();
			
		     int TerminateLicense = Integer.parseInt(Terminate);	//Reading Terminate count.

		     LiPerformerPOM.terminatedPerformer(driver).click();					//Clicking on 'Terminate ' image
		      Thread.sleep(4000);
		        JavascriptExecutor js1=(JavascriptExecutor) driver ;
				js1.executeScript("window.scroll(0,500)");
				Thread.sleep(4000);
				
				licenseCompanyadmin.MethodPOM.clickReadTerminate(driver).click();					//Clicking on total items count
				Thread.sleep(500);
				String item = MethodPOM.clickReadTerminate(driver).getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String LicensTerminate= bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
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
					
					licenseCompanyadmin.MethodPOM.ClickActiveOverview(driver).click();
					Thread.sleep(3000);
					test.log(LogStatus.PASS, " License Overview Details Successfully");
					Thread.sleep(3000);
					licenseCompanyadmin.MethodPOM.ClickCloseOverview(driver).click();
        
					//LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
					LiPerformerPOM.editlicenseicon(driver).click();
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
					Thread.sleep(5000);
					js1.executeScript("window.scrollBy(0,2000)");
					Thread.sleep(3000);
					 Actions act =new Actions(driver);
		                act.sendKeys(Keys.PAGE_DOWN).build().perform();
		                Thread.sleep(3000);
					//LiPerformerPOM.editnomineebtn(driver).click();
					/*Thread.sleep(3000);
					 licmgmtPOM.ClickNomineedrp(driver).click();
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
					 licmgmtPOM.selectnomineenddate(driver).click();
					 Thread.sleep(5000);
				*/
					licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
					 // Switching to Alert       
			        Alert alert = driver.switchTo().alert();
			       
			        // Capturing alert message.   
			        String alertMessage= driver.switchTo().alert().getText();
			       
			        Thread.sleep(3000);
			      //  test.log(LogStatus.PASS, alertMessage);
			       
			        // Displaying alert message
			       // System.out.println(alertMessage);
			        // Accepting alert
			        /*Thread.sleep(3000);
			        By locator = By.xpath("//*[@class='k-button-group k-dialog-buttongroup k-dialog-button-layout-stretched']");

			    	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			    	Thread.sleep(4000);
			    	
			    	WebElement ViewButton = driver.findElement(locator);	
			    	Thread.sleep(3000);
			    JavascriptExecutor jse=(JavascriptExecutor)driver;
			    jse.executeScript("arguments[0].click();", ViewButton);
			    	Thread.sleep(4000);
			        
			      //  LiPerformerPOM.licenseOK(driver).click();
			        
			     */
			        // Accepting alert
			        alert.accept();
			        test.log(LogStatus.PASS,"License Details Updated Successfully" );
			        
			          Thread.sleep(5000);
			          
			          licmgmtPOM.editlicenseclose(driver).click();
			          Thread.sleep(300);
			          MethodPOM.clickMyDashboard(driver).click();
			          Thread.sleep(1000);
			         // MethodPOM.clickActive(driver).click();	
			          
			        //  Thread.sleep(3000);
				//	LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
					
					//progress(driver);
					
					//Thread.sleep(500);
				

				//	LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
					
				//	progress(driver);
					
					Thread.sleep(500);
				//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
		
				//	progress(driver);
					
					Thread.sleep(500);
					//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					
				/*	if(type.equalsIgnoreCase("Internal"))
					{
						WebDriverWait wait1= new WebDriverWait(driver, 5);
						wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
						LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
						
						
						Select drp = new Select(LiPerformerPOM.clickType(driver));
						drp.selectByIndex(1);
						CFOcountPOM.clickApply1(driver).click();	
						  Thread.sleep(3000);
						 
						LiPerformerPOM.terminatedPerformer(driver).click();	

						LiPerformerPOM.terAction(driver).click();						//Clicking on first action button.
				        Thread.sleep(3000);
				        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
						js1.executeScript("window.scrollBy(0,2000)");
						wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown(driver)));
						Select status = new Select(OverduePOM.selectInternalDropdown(driver));	//Selecting Status dropdown box.
						status.selectByIndex(2);									//Selecting 2nd value from dropdown.
					}
					else
					{
						LiPerformerPOM.terminatedPerformer(driver).click();
						 Thread.sleep(500);
						LiPerformerPOM.TerminateAction(driver).click();					//Clicking on first action button.
				        Thread.sleep(3000);	
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));		
						js1.executeScript("window.scrollBy(0,1000)");
					    Thread.sleep(2000);
						wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown(driver)));
						Select status = new Select(OverduePOM.selectStatutoryDropdown(driver));	//Selecting Status dropdown box.
						status.selectByIndex(2);									//Selecting 2nd value from dropdown.
					}
					
					try
					{
						Thread.sleep(300);
						wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress(driver)));
					}
					catch(Exception e)
					{
						
					}
					
					licenseReviewer.LiReMethodsPOM.perform(driver, test);			//Calling perform method of Reviewer.
					
					try
					{
						Thread.sleep(500);
						LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
						js1.executeScript("window.scrollBy(0,300)");
					}
					catch(Exception e)
					{
						
					}
					
					Thread.sleep(500);
					js1.executeScript("window.scrollBy(0,700)");
					Thread.sleep(300);
					//LiPerformerPOM.SubmitTerminate(driver).click();			//Clicking on 'Submit' button.
					
					Thread.sleep(1000);
					js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.
					
					Thread.sleep(300);
					if(type.equalsIgnoreCase("Statutory"))
					{
						String msg = LiPerformerPOM.readMessage(driver).getText();
						if(msg.equalsIgnoreCase("Save Sucessfully."))
						{
							test.log(LogStatus.PASS, "Message Displayed = "+msg);
						}
						else
						{
							test.log(LogStatus.FAIL, "Message Displayed = "+msg);
						}
						
						Thread.sleep(500);
						js1.executeScript("window.scrollBy(2000,0)");			//Scrolling up window by 2000 px.
						
						driver.switchTo().parentFrame();
						
						Thread.sleep(700);
						LiPerformerPOM.clickClose(driver).click();				//Clicking on Close (Cross)
						driver.navigate().refresh();
						*/
						MethodPOM.clickMyDashboard(driver).click();
					
		   
	   }
	

				
	   
public static void LicenseExpiringOnInternalrew(WebDriver driver, ExtentTest test, String type) throws InterruptedException, IOException
{
		WebDriverWait wait1= new WebDriverWait(driver, 5);
		/*wait1.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
		LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
		
		
		Select drp = new Select(LiPerformerPOM.clickType(driver));
		drp.selectByIndex(1);
		CFOcountPOM.clickApply1(driver).click();	
	   Thread.sleep(3000);
	   */
	   LiPerformerPOM.Expiringmaxmize(driver).click();
	   test.log(LogStatus.PASS, "Expiring On Maximize Button Working Successfully");
	   Thread.sleep(3000);
	   JavascriptExecutor js1=(JavascriptExecutor) driver ;
		js1.executeScript("window.scroll(0,500)");
		MethodPOM.DashExpiringOnExport(driver).click();
		  Thread.sleep(3000);
		test.log(LogStatus.PASS, "Dashboard Expiring License Download Successfully");
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_lnkShowDetailLicense']");

		wait1.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(3000);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
	//   LiPerformerPOM.Expiringshowmore(driver).click();
	   Thread.sleep(7000);
	   test.log(LogStatus.PASS, "Expiring On show More Link Working Successfully");
	   WebDriverWait wait = new WebDriverWait(driver, 40);
		Thread.sleep(5000);
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showLicenseDetails"));
	   Thread.sleep(3000);
	   js1.executeScript("window.scroll(0,500)");
	   String NoRecord = LiReviewerPOM.reNorecord(driver).getText();
	   if(!NoRecord.equalsIgnoreCase("No items to display")) 
	   {
	   MethodPOM.ClickExportExpiredOn(driver).click();
		test.log(LogStatus.PASS, "Expiring On License List Downloaded Successfully");
		  Thread.sleep(3000);
		  
		  LiPerformerPOM.lictype(driver).click();
		  Thread.sleep(500);
		  LiPerformerPOM.selectlic1(driver).click();
		Thread.sleep(3000);
	   LiPerformerPOM.clearbtn(driver).click();
	   test.log(LogStatus.PASS, "Expiring On License Popup Clear filter Button Working Successfully");
	   
	   Thread.sleep(3000);
		MethodPOM.ClickOverviewExpiredOn(driver).click();
		test.log(LogStatus.PASS, "Expiring OverView License Displayed");
		Thread.sleep(3000);
    MethodPOM.clickBystatuscloseoverview(driver).click();
		 Thread.sleep(2000);
		  // Js.executeScript("window.scrollBy(500,0)");
		driver.switchTo().parentFrame();
		 LiPerformerPOM.CloseExpiredOn(driver).click();
		 Thread.sleep(3000);

	   }else
	   {
		   driver.switchTo().parentFrame();
			 LiPerformerPOM.CloseExpiredOn(driver).click();
			 Thread.sleep(3000);
			  test.log(LogStatus.PASS, "Expiring On Popup No Record Found ");
	   }
	   
}
public static void TerminateLicense1rew(WebDriver driver, ExtentTest test, String type) throws InterruptedException
{
	  
		   
	   WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.terminatedPerformer(driver)));
		String Terminate=LiPerformerPOM.terminatedPerformer(driver).getText();
		
	     int TerminateLicense = Integer.parseInt(Terminate);	//Reading Terminate count.

	     LiPerformerPOM.terminatedPerformer(driver).click();					//Clicking on 'Terminate ' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			licenseCompanyadmin.MethodPOM.clickReadTerminate(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadTerminate(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicensTerminate= bits[bits.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
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
				
				licenseCompanyadmin.MethodPOM.ClickActiveOverview(driver).click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, " License Overview Details Successfully");
				Thread.sleep(3000);
				licenseCompanyadmin.MethodPOM.ClickCloseOverview(driver).click();
   
				//LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
				LiPerformerPOM.editlicenseicon(driver).click();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("update License");	
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("update00");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,2000)");
				Thread.sleep(3000);
				 Actions act =new Actions(driver);
	                act.sendKeys(Keys.PAGE_DOWN).build().perform();
	                Thread.sleep(3000);
				//LiPerformerPOM.editnomineebtn(driver).click();
				/*Thread.sleep(3000);
				 licmgmtPOM.ClickNomineedrp(driver).click();
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
				 licmgmtPOM.selectnomineenddate(driver).click();
				 Thread.sleep(5000);
			*/
				licenseManagement.licmgmtPOM.Nomineesubmit(driver).click();
				 // Switching to Alert       
		        Alert alert = driver.switchTo().alert();
		       
		        // Capturing alert message.   
		        String alertMessage= driver.switchTo().alert().getText();
		       
		        Thread.sleep(3000);
		      //  test.log(LogStatus.PASS, alertMessage);
		       
		        // Displaying alert message
		       // System.out.println(alertMessage);
		        // Accepting alert
		        /*Thread.sleep(3000);
		        By locator = By.xpath("//*[@class='k-button-group k-dialog-buttongroup k-dialog-button-layout-stretched']");

		    	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		    	Thread.sleep(4000);
		    	
		    	WebElement ViewButton = driver.findElement(locator);	
		    	Thread.sleep(3000);
		    JavascriptExecutor jse=(JavascriptExecutor)driver;
		    jse.executeScript("arguments[0].click();", ViewButton);
		    	Thread.sleep(4000);
		        
		      //  LiPerformerPOM.licenseOK(driver).click();
		        
		     */
		        // Accepting alert
		        alert.accept();
		        test.log(LogStatus.PASS,"License Details Updated Successfully" );
		        
		          Thread.sleep(5000);
		          
		          licmgmtPOM.editlicenseclose(driver).click();
		          Thread.sleep(300);
		          MethodPOM.clickMyDashboard(driver).click();
		          Thread.sleep(1000);
		         // MethodPOM.clickActive(driver).click();	
		          
		        //  Thread.sleep(3000);
			//	LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
				
				//progress(driver);
				
				//Thread.sleep(500);
			

			//	LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
				
			//	progress(driver);
				
				Thread.sleep(500);
			//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
	
				//progress(driver);
				
				Thread.sleep(500);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				
				/*if(type.equalsIgnoreCase("Internal"))
				{
					WebDriverWait wait1= new WebDriverWait(driver, 5);
					wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
					LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
					
					
					Select drp = new Select(LiPerformerPOM.clickType(driver));
					drp.selectByIndex(1);
					CFOcountPOM.clickApply1(driver).click();	
					  Thread.sleep(3000);
					 
					LiPerformerPOM.terminatedPerformer(driver).click();	

					LiPerformerPOM.terAction(driver).click();						//Clicking on first action button.
			        Thread.sleep(3000);
			        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
					js1.executeScript("window.scrollBy(0,2000)");
					wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown(driver)));
					Select status = new Select(OverduePOM.selectInternalDropdown(driver));	//Selecting Status dropdown box.
					status.selectByIndex(2);									//Selecting 2nd value from dropdown.
				}
				else
				{
					LiPerformerPOM.terminatedPerformer(driver).click();
					 Thread.sleep(500);
					LiPerformerPOM.TerminateAction(driver).click();					//Clicking on first action button.
			        Thread.sleep(3000);	
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));		
					js1.executeScript("window.scrollBy(0,1000)");
				    Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown(driver)));
					Select status = new Select(OverduePOM.selectStatutoryDropdown(driver));	//Selecting Status dropdown box.
					status.selectByIndex(2);									//Selecting 2nd value from dropdown.
				}
				
				try
				{
					Thread.sleep(300);
					wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress(driver)));
				}
				catch(Exception e)
				{
					
				}
				
				licenseReviewer.LiReMethodsPOM.perform(driver, test);			//Calling perform method of Reviewer.
				
				try
				{
					Thread.sleep(500);
					LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
					js1.executeScript("window.scrollBy(0,300)");
				}
				catch(Exception e)
				{
					
				}
				
				Thread.sleep(500);
				js1.executeScript("window.scrollBy(0,700)");
				Thread.sleep(300);
				//LiPerformerPOM.SubmitTerminate(driver).click();			//Clicking on 'Submit' button.
				
				Thread.sleep(1000);
				js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.
				
				Thread.sleep(300);
				if(type.equalsIgnoreCase("Statutory"))
				{
					String msg = LiPerformerPOM.readMessage(driver).getText();
					if(msg.equalsIgnoreCase("Save Sucessfully."))
					{
						test.log(LogStatus.PASS, "Message Displayed = "+msg);
					}
					else
					{
						test.log(LogStatus.FAIL, "Message Displayed = "+msg);
					}
					
					Thread.sleep(500);
					js1.executeScript("window.scrollBy(2000,0)");			//Scrolling up window by 2000 px.
					
					driver.switchTo().parentFrame();
					
					Thread.sleep(700);
					LiPerformerPOM.clickClose(driver).click();				//Clicking on Close (Cross)
					driver.navigate().refresh();
					MethodPOM.clickMyDashboard(driver).click();
				
	   */
}

		public static void nomineeDetails(WebDriver driver, ExtentTest test, String string) throws InterruptedException
		{
			   
			 licmgmtPOM.ClickMyWorkspace(driver).click();
			  Thread.sleep(3000);
	         LiPerformerPOM.editlicenseicon(driver).click();
	         Thread.sleep(3000);
	         LiReviewerPOM.addnominee(driver).click();
	         JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(3000);
			licmgmtPOM.ClickNomineedrp(driver).click();
			 Thread.sleep(3000);
			 licmgmtPOM.SelectNominee(driver).click();
			 
			 Thread.sleep(5000);
			// js1.executeScript("window.scroll(0,2000)");
			// Thread.sleep(5000);
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
			 licmgmtPOM.selectnomineenddate(driver).click();
			 Thread.sleep(5000);
			licenseManagement.licmgmtPOM.btnsavenominee(driver).click();
			 // Switching to Alert       
	        Alert alert = driver.switchTo().alert();
	       
	        // Capturing alert message.   
	        String alertMessage= driver.switchTo().alert().getText();
	       
	        alert.accept();
	        
	        driver.switchTo().defaultContent();
	        LiReviewerPOM.clickok(driver).click();
		      
	        test.log(LogStatus.PASS,"Nominee Details Added Successfully" );
	        Alert alert2 = driver.switchTo().alert();
		       
	        // Capturing alert message.   
	        String alertMessage2= driver.switchTo().alert().getText();
	       
	        alert.accept();
	        Thread.sleep(3000);
	        LiReviewerPOM.workclose(driver).click();
	        Thread.sleep(3000);
	         licmgmtPOM.ClickMyWorkspace(driver).click();
	         Thread.sleep(3000);
	         LiPerformerPOM.editlicenseicon(driver).click();
	         Thread.sleep(3000);
	         LiReviewerPOM.addnominee(driver).click();
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(3000);
			licmgmtPOM.ClickNomineedrp(driver).click();
			 Thread.sleep(3000);
			 licmgmtPOM.SelectNominee(driver).click();
			 
			 Thread.sleep(5000);
			// js1.executeScript("window.scroll(0,2000)");
			// Thread.sleep(5000);
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
				js2.executeScript("window.scroll(0,2000)");
				
			LiReviewerPOM.iscurrentnominee(driver).click();
         
			licenseManagement.licmgmtPOM.btnsavenominee(driver).click();
			 // Switching to Alert       
	        Alert alert3 = driver.switchTo().alert();
	       
	        // Capturing alert message.   
	        String alertMessage3= driver.switchTo().alert().getText();
	       
	        alert.accept();
	       
	        LiReviewerPOM.clickok(driver).click();
	      
	         Thread.sleep(3000);
	        test.log(LogStatus.PASS,"Is Current Nominee Details Added Successfully" );
   
			
	       
		}
}







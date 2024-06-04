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
import login.webpage;
import performer.OverduePOM;
import reviewer.ReviewerPOM;

public class LiReMethodsPOM extends webpage
{
	private static List<WebElement> elementsList = null;
	private static List<WebElement> elementsList1 = null;
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook wb = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static XSSFSheet sheet1 = null;		//Sheet variable
	
	public static void ReviewerActiveLicense( ExtentTest test, String type) throws InterruptedException
	{	
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive()));
			String Active=MethodPOM.clickActive().getText();
			
		     int Activelicense = Integer.parseInt(Active);	//Reading Expired count.

		      MethodPOM.clickActive().click();					//Clicking on 'Active' image
		      Thread.sleep(4000);
		        JavascriptExecutor js1=(JavascriptExecutor)getDriver()  ;
				js1.executeScript("window.scroll(0,500)");
				Thread.sleep(4000);
				
				MethodPOM.clickReadActive().click();					//Clicking on total items count
				Thread.sleep(500);
				String item = MethodPOM.clickReadActive().getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
				int total = Integer.parseInt(LicenseActiveCount);
				if(Activelicense == total)
		{
			//test.log(LogStatus.PASS, "Dashboard 'Expired' count matches to the total records displayed in grid.");
			test.log(LogStatus.PASS, " Dashboard 'Active' License Count  = "+Activelicense+" | No of Active License in the grid = "+total);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Dashboard 'Expired' count doesn't matches to the total records displayed in grid.");
			test.log(LogStatus.FAIL, " Dashboard 'Active' License Count  = "+Activelicense+" | No of Active License in the grid = "+total);
		}
		Thread.sleep(5000);	
		MethodPOM.ClickActiveOverview().click();
		test.log(LogStatus.PASS, " License Overview Details Successfully");
		Thread.sleep(5000);
		MethodPOM.ClickCloseOverview().click();			
		Thread.sleep(7000);
		LiPerformerPOM.editlicenseicon().click();
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.LicenseTitle().clear();
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.LicenseTitle().sendKeys("A licesne update");	
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.LicenseNo().sendKeys("update00");
		Thread.sleep(5000);
		js1.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(3000);
		//LiPerformerPOM.editnomineebtn().click();
		Thread.sleep(3000);
		 /*licmgmtPOM.ClickNomineedrp().click();
		 Thread.sleep(3000);
		 licmgmtPOM.SelectNominee().click();
		 
		 Thread.sleep(5000);
		// js1.executeScript("window.scroll(0,2000)");
		// Thread.sleep(5000);
		 licmgmtPOM.ClickModificdate().click();
		 Thread.sleep(6000);	
		 js1.executeScript("window.scroll(0,2000)");
		 Thread.sleep(6000);		 
		 licmgmtPOM.ModificatioDate().click();		 
		 Thread.sleep(6000);
		 js1.executeScript("window.scroll(0,2000)");
		 licmgmtPOM.nomineestartdatecal().click();
		 Thread.sleep(3000);
		 licmgmtPOM.selectnominstartdate().click();
		 Thread.sleep(3000);
		 JavascriptExecutor js2=(JavascriptExecutor)  ;
			js2.executeScript("window.scroll(0,2000)");
		 licmgmtPOM.nomineeEnddatecal().click();
		 Thread.sleep(5000);
		 licmgmtPOM.selectnomineenddate().click();
		 Thread.sleep(5000);*/
		licenseManagement.licmgmtPOM.Nomineesubmit().click();
		 // Switching to Alert       
        Alert alert =getDriver().switchTo().alert();
       
        // Capturing alert message.   
        String alertMessage= getDriver().switchTo().alert().getText();
       
        Thread.sleep(3000);
      //  test.log(LogStatus.PASS, alertMessage);
       
        // Displaying alert message
       // System.out.println(alertMessage);
        // Accepting alert
        /*Thread.sleep(3000);
        By locator = By.xpath("//*[@class='k-button-group k-dialog-buttongroup k-dialog-button-layout-stretched']");

    	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    	Thread.sleep(4000);
    	
    	WebElement ViewButton = .findElement(locator);	
    	Thread.sleep(3000);
    JavascriptExecutor jse=(JavascriptExecutor);
    jse.executeScript("arguments[0].click();", ViewButton);
    	Thread.sleep(4000);
        
      //  LiPerformerPOM.licenseOK().click();
        
     */
        // Accepting alert
        alert.accept();
        test.log(LogStatus.PASS,"License Details Updated Successfully" );
        
          Thread.sleep(5000);
          
          licmgmtPOM.editlicenseclose().click();
          Thread.sleep(300);
          MethodPOM.clickMyDashboard().click();
          Thread.sleep(1000);
         // MethodPOM.clickActive().click();	
          
        //  Thread.sleep(3000);
	//	LiPerformerPOM.clickAction().click();					//Clicking on first action button.
		
		//progress();
		
		//Thread.sleep(500);
	
		/*
		if(type.equalsIgnoreCase("Internal"))
		{
			WebWait wait1= new WebWait(, 5);
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
			LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
			
			
			Select drp = new Select(LiPerformerPOM.clickType());
			drp.selectByIndex(1);
			CFOcountPOM.clickApply1().click();	
			  Thread.sleep(3000);
			MethodPOM.clickActive().click();	
	          
	        Thread.sleep(3000);
			OverduePOM.ActiveAction().click();					//Clicking on first action button.
			//Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
			js1.executeScript("window.scrollBy(0,3000)");
			 Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown()));
			Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting Status dropdown box.
			status.selectByIndex(2);	
		
		}
		else
		{
			MethodPOM.clickActive().click();	
	          
	         Thread.sleep(3000);
	         OverduePOM.ActiveAction().click();					//Clicking on first action button.
			                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LiPerformerPOM.ShowFream()));		
			js1.executeScript("window.scrollBy(0,1000)");
		    Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown()));
			Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting Status dropdown box.
			status.selectByIndex(2);	
		}
		
		try
		{
			Thread.sleep(300);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		licenseReviewer.LiReMethodsPOM.perform(, test);			//Calling perform method of Reviewer.
		
		try
		{
			Thread.sleep(500);
			LiPerformerPOM.clickCheckbox().click();			//Clicking on checkbox of Penalty values
			js1.executeScript("window.scrollBy(0,300)");
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		js1.executeScript("window.scrollBy(0,700)");
		Thread.sleep(300);
		OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.
		
		Thread.sleep(1000);
		js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.
		
		Thread.sleep(300);
		if(type.equalsIgnoreCase("Statutory"))
		{
			String msg = LiPerformerPOM.readMessage().getText();
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
			getDriver()..switchTo().parentFrame();
			
			Thread.sleep(700);
			LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
			.navigate().refresh();
			*/
			MethodPOM.clickMyDashboard().click();
	}
	public static void ReviewerExpiringCount( ExtentTest test, String type) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		//progress();
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring()));
		String Expiring=MethodPOM.clickExpiring().getText();
		
	     int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.
		
		LiPerformerPOM.clickExpiring().click();						//Clicking on 'Expiring'
		   Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor)getDriver()  ;
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
				test.log(LogStatus.PASS, "License Overview Details Successfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview().click();
				LiPerformerPOM.editlicenseicon().click();
				Thread.sleep(7000);
				licenseManagement.licmgmtPOM.LicenseTitle().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle().sendKeys("update License");	
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo().sendKeys("Test Update Funcationality");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(1000,0)");
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.Nomineesubmit().click();
				 // Switching to Alert       
		        Alert alert = getDriver().switchTo().alert();
		       
		        // Capturing alert message.   
		        String alertMessage= getDriver().switchTo().alert().getText();
		       
		        Thread.sleep(5000);

		        // Accepting alert
		        alert.accept();
		        test.log(LogStatus.PASS,"License Details Updated Successfully" );
		        
		          Thread.sleep(5000);
		          
		          licmgmtPOM.editlicenseclose().click();
		          Thread.sleep(300);
		       //  MethodPOM.clickMyDashboard().click();
		      //   Thread.sleep(1000);
		        //  MethodPOM.clickExpiring().click();	
		          
		         // Thread.sleep(3000);
				//LiPerformerPOM.clickAction().click();					//Clicking on first action button.
				
			//	progress();
				
			//	Thread.sleep(500);
			
				
			/*	if(type.equalsIgnoreCase("Internal"))
				{
					WebWait wait1= new WebWait(, 5);
					wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
					LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
					
					
					Select drp = new Select(LiPerformerPOM.clickType());
					drp.selectByIndex(1);
					CFOcountPOM.clickApply1().click();	
					Thread.sleep(500);
					
					  MethodPOM.clickExpiring().click();	
			          
			          Thread.sleep(3000);
					LiPerformerPOM.ExpiredAction().click();					//Clicking on first action button.
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
					js1.executeScript("window.scrollBy(0,3000)");
					wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown()));
					Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting Status dropdown box.
					status.selectByIndex(2);									//Selecting 2nd value from dropdown.
				}
				else
				{
					  MethodPOM.clickExpiring().click();	
			          
			          Thread.sleep(3000);
					LiPerformerPOM.clickAction().click();					//Clicking on first action button.
					
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LiPerformerPOM.ShowFream()));		
					js1.executeScript("window.scrollBy(0,1000)");
				    Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown()));
					Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting Status dropdown box.
					status.selectByIndex(2);									//Selecting 2nd value from dropdown.
				}
				
				try
				{
					Thread.sleep(300);
					wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
				}
				catch(Exception e)
				{
					
				}
				
				licenseReviewer.LiReMethodsPOM.perform(, test);			//Calling perform method of Reviewer.
				
				try
				{
					Thread.sleep(500);
					LiPerformerPOM.clickCheckbox().click();			//Clicking on checkbox of Penalty values
					js1.executeScript("window.scrollBy(0,300)");
				}
				catch(Exception e)
				{
					
				}
				
				Thread.sleep(500);
				js1.executeScript("window.scrollBy(0,700)");
				Thread.sleep(300);
				OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.
				
				Thread.sleep(1000);
				js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.
				
				Thread.sleep(300);
				if(type.equalsIgnoreCase("Statutory"))
				{
					String msg = LiPerformerPOM.readMessage().getText();
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
						getDriver()..switchTo().parentFrame();
						
					
					Thread.sleep(700);
					LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
					.navigate().refresh();
					MethodPOM.clickMyDashboard().click();
					
				}
	
		
	/*	progress();
		
		Thread.sleep(300);
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable()));
		Thread.sleep(500);
		int flag = 0;
		try
		{
			if(LiPerformerPOM.clickAction().isDisplayed())
			{
				flag = 1;
			}
		}
		catch(Exception e)
		{
			
		}
		if(flag == 1)
		{
			JavascriptExecutor js = (JavascriptExecutor) ;
			js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
			
			int total = Integer.parseInt(OverduePOM.readReminder().getText());
			if(expiring == total)
			{
				test.log(LogStatus.PASS, "Dashboard 'Expiring' count matches to total records displayed. Total records = "+total);
			}
			else
			{
				test.log(LogStatus.FAIL, "Dashboard 'Expiring' count matches doesn't to total records displayed. Total records = "+total);
			}
			
			Thread.sleep(300);
			LiPerformerPOM.clickAction().click();					//Clicking on first action button.
			
			progress();
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
			
			Thread.sleep(500);
			if(type.equalsIgnoreCase("Statutory"))
			{
				js.executeScript("window.scrollBy(0,700)");
				wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown()));
				Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting Status dropdown box.
				status.selectByIndex(2);									//Selecting 2nd value from dropdown.
			}
			else
			{
				js.executeScript("window.scrollBy(0,500)");
				wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown()));
				Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting Status dropdown box.
				status.selectByIndex(2);									//Selecting 2nd value from dropdown.
			}
			
			progress();
			
			licenseReviewer.LiReMethodsPOM.perform(, test);		//Calling perform method of Reviewer.
			
			try
			{
				Thread.sleep(500);
				LiPerformerPOM.clickCheckbox().click();			//Clicking on checkbox of Penalty values
			}
			catch(Exception e)
			{
				
			}
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,500)");				//Scrolling down window by 2000 px.
			
			Thread.sleep(500);
			OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.
			
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,-1000)");				//Scrolling down window by 2000 px.
			
			if(type.contains("Statutory"))
			{
				Thread.sleep(300);
				LiPerformerPOM.readMessage().click();
				String msg = LiPerformerPOM.readMessage().getText();
				if(msg.equalsIgnoreCase("Save Sucessfully."))
				{
					test.log(LogStatus.PASS, "Message Displayed = "+msg);
				}
				else
				{
					test.log(LogStatus.PASS, "Message Displayed = "+msg);
				}
				
				getDriver()..switchTo().parentFrame();
				Thread.sleep(500);
				LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
				
				progress();
			}
		}
		else
		{
			test.log(LogStatus.SKIP, "No records to perform task.");
		}
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();
		
		if(type.contains("Internal"))
		{
			WebWait wait1 = new WebWait(, 5);
			wait1.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
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
		}
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpiring()));
		int expiring1 = Integer.parseInt(LiPerformerPOM.clickExpiring().getText());	//Reading Active count.
		int pending1 = Integer.parseInt(LiPerformerPOM.clickPendingForReview().getText());
		
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



	public static void perform( ExtentTest test) throws InterruptedException
	{
		Thread.sleep(500);
		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
		
		try
		{
			Thread.sleep(500);
			String lic_no = LiReviewerPOM.clickLicenseNo().getText();		//Reading License no 
			if(lic_no.equalsIgnoreCase("") || lic_no.equalsIgnoreCase(null))	//If License no text box is not empty.
			{
				LiReviewerPOM.clickLicenseNo().sendKeys("1234");			//Writing License no
			}
			
			Thread.sleep(500);
			String lic_title = LiReviewerPOM.clickLicenseTitle().getText();	//Reading License title
			if(lic_title.equalsIgnoreCase("") || lic_title.equalsIgnoreCase(null))	//If License title text box is not empty.
			{
				LiReviewerPOM.clickLicenseTitle().sendKeys("Title Automation");	//Writing License title
			}
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			Thread.sleep(700);
			LiReviewerPOM.clickStartDate().click();					//Clicking on Start Date text box
			Thread.sleep(300);
			OverduePOM.selectNextMonth().click();						//Clicking on next month arrow.
			Thread.sleep(300);
			OverduePOM.selectDate2().click();							//Selecting particular date
			
			if(LiReviewerPOM.clickStartDate().getText().equalsIgnoreCase(null))
			{
				Thread.sleep(500);
				LiReviewerPOM.clickStartDate().click();					//Clicking on Start Date text box
				Thread.sleep(300);
				OverduePOM.selectLastMonth().click();						//Clicking on next month arrow.
				Thread.sleep(300);
				OverduePOM.selectDate2().click();							//Selecting particular date
			}
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			Thread.sleep(500);
			LiReviewerPOM.clickEndDate().click();						//Clicking on End Date text box
			Thread.sleep(300);
			OverduePOM.selectNextMonth().click();						//Clicking on next month arrow.
			OverduePOM.selectNextMonth().click();						//Clicking on next month arrow.
			Thread.sleep(300);
			OverduePOM.selectDate3().click();							//Selecting particular date
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(300);
		js.executeScript("window.scrollBy(0,500)");					//Scrolling down window by 500 px.
		
		try
		{
			Thread.sleep(500);
			LiReviewerPOM.clickDate().click();						//Clicking on 'Date' input box
			Thread.sleep(300);
			OverduePOM.selectDate2().click();							//Selecting particular date
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			String workingDir = System.getProperty("user.dir");
			OverduePOM.fileUploadStatutory().sendKeys(workingDir+"//Reports//new//LicensePerformerResults(Statutory).html");	//Uploading file by sending file to Upload Button. (Statutory)
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			String workingDir = System.getProperty("user.dir");
			OverduePOM.fileUploadInternal().sendKeys(workingDir+"//Reports//new//LicensePerformerResults(Statutory).html");	//Uploading file by sending file to Upload Button. (Internal)
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			
		}
		
		try									//Statutory compliance document link.
		{
			if(LiPerformerPOM.clickComplDocAddButton() != null)
			{
				LiPerformerPOM.clickComplDoc().sendKeys("www.google.com");	//Providing compliance document link.
				Thread.sleep(500);
				LiPerformerPOM.clickComplDocAddButton().click();				//Clicking on 'Add Link' button.
			}
		}
		catch(Exception e)
		{
			
		}
		
		try									//Internal compliance document link.
		{
			if(LiPerformerPOM.clickComplDocAddButton() != null)
			{
				LiPerformerPOM.clickComplDocInternal().sendKeys("www.google.com");	//Providing compliance document link.
				Thread.sleep(500);
				LiPerformerPOM.clickComplDocAddButton().click();				//Clicking on 'Add Link' button.
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
			LiReviewerPOM.clickDate1().click();					//Clicking on 'Date' input box for(Performer - Expiring count verification)
			Thread.sleep(300);
			WebElement ele = null;
			ele = OverduePOM.selectLastMonth();
			if(ele.equals(null))
			{
				OverduePOM.selectNextMonth().click();						//Clicking on next month arrow.
			}
			else
			{
				OverduePOM.selectLastMonth().click();						//Clicking on next month arrow.
			}
			
			Thread.sleep(300);
			OverduePOM.selectDate2().click();						//Selecting particular date
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			Thread.sleep(500);					//Select date for Internal.
			OverduePOM.selectDateInternal().click();				//Clicking on 'Date' input box for(Performer - Expiring count verification)
			Thread.sleep(300);
			OverduePOM.selectLastMonth().click();					//Clicking on Last month
			Thread.sleep(300);
			OverduePOM.selectDate2().click();						//Selecting particular date
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		
		try
		{
			LiReviewerPOM.clikTextArea().sendKeys("Automation Remark");	//Inserting 'Remark'
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			OverduePOM.remark().sendKeys("Automation Remark");	//Inserting 'Remark'
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			OverduePOM.clickInternalRemark().sendKeys("Automation Remark");	//Inserting internal 'Remark'
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			LiReviewerPOM.clikTextArea1().sendKeys("Automation Remark");	//Inserting 'Remark'
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	
	public static void PendingReviewCount( ExtentTest test, String type) throws InterruptedException
	{	
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		try
		{
		Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickPendingForReview()));		
		int pending = Integer.parseInt(LiPerformerPOM.clickPendingForReview().getText());	//Reading 'Pending For Review' count
		int applied = Integer.parseInt(LiPerformerPOM.clickPendingForReview().getText());	//Reading 'Applied' count
		LiPerformerPOM.clickPendingForReview().click();		//Clicking on 'Pending For Review' image link
		
		Thread.sleep(500);
		try
		{
			Thread.sleep(400);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(5000);
	//	LiPerformerPOM.clickPendingForReview().click();					//Clicking on total items count
		String item = MethodPOM.clickReadExpiring().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String LicenseExpiringCount = bits[bits.length - 2];		//Getting the second last word (tot
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable()));
		//LiReviewerPOM.clickReviewer().click();
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 500 px.
		//int total = Integer.parseInt(OverduePOM.readReminder().getText());	//Reading total records count
		
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
		LiReviewerPOM.Overviewreview1().click();
		
    	test.log(LogStatus.PASS, " License Overview Details Successfully");
    	Thread.sleep(5000);
		MethodPOM.ClickCloseOverview().click();		
		Thread.sleep(500);
		
		/*elementsList = LiReviewerPOM.clickAction();
		int n = elementsList.size();
		int k = 1;
		for(int i = 1; i < n; i++)
		{
			
			/*elementsList = LiReviewerPOM.clickAction();
			elementsList.get(i).click();									//Clicking on ith Action button.
			Thread.sleep(500);
		*/
		LiReviewerPOM.Reviewaction().click();
		Thread.sleep(5000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
			JavascriptExecutor js1 = (JavascriptExecutor)getDriver() ;    
			js.executeScript("window.scrollBy(0,700)");
			Thread.sleep(5000);
			LiReviewerPOM.clickdownload().click();
             Actions act =new Actions(getDriver());
                act.sendKeys(Keys.PAGE_DOWN).build().perform();
                Thread.sleep(7000);
                js.executeScript("window.scrollBy(0,500)");
                
				
		/*	if(ReviewerPOM.clickView1().isDisplayed())
			{
				Thread.sleep(1000);
				ReviewerPOM.clickView1().click();							//Clicking on 'View' link
				
				Thread.sleep(3000);
				try
				{
					ReviewerPOM.clickCloseView().click();						//Clicking on Close (cross) to close view
				}
				catch(Exception e)
				{
					ReviewerPOM.clickCloseView1().click();						//Clicking on Close (cross) to close view
				}
				*
				Thread.sleep(500);
				ReviewerPOM.clickDownload2().click();
				
				perform(, test);
				*/
               // act.sendKeys(Keys.PAGE_DOWN).build().perform();
				Thread.sleep(5000);
				if(ReviewerPOM.clickApprove().isEnabled())
				{
					ReviewerPOM.clickApprove().click();					//Clicking on Approve
				}
				
				Thread.sleep(5000);
				js.executeScript("window.scrollBy(0,-3000)");					//Scrolling down window by 500 px.
				
				Thread.sleep(500);
				String msg = LiPerformerPOM.readMessage().getText();		//Reading message after Appove.
				
				if(msg.equalsIgnoreCase("Approved Successfully."))
				{
					test.log(LogStatus.PASS, "Message displayed = "+msg);
				}
				else
				{
					test.log(LogStatus.FAIL, "Message displayed = "+msg);
				}
				
				Thread.sleep(500);
				getDriver().switchTo().parentFrame();
				
				LiPerformerPOM.clickClose().click();
				Thread.sleep(500);
				getDriver().navigate().refresh();
				Thread.sleep(3000);
				LiReviewerPOM.Reviewaction().click();
				Thread.sleep(5000);
				
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
				   
					js.executeScript("window.scrollBy(0,1000)");
					Thread.sleep(500);
		              Actions act1 =new Actions(getDriver());
		                act1.sendKeys(Keys.PAGE_DOWN).build().perform();
		                Thread.sleep(5000);
		                
		                LiReviewerPOM.clickdownload().click();
		                act1.sendKeys(Keys.PAGE_DOWN).build().perform();
		                Thread.sleep(5000);
						if(LiReviewerPOM.rejectbtn().isEnabled())
						{
							LiReviewerPOM.rejectbtn().click();					//Clicking on Approve
						}
						
						Thread.sleep(5000);
						js.executeScript("window.scrollBy(0,-3000)");					//Scrolling down window by 500 px.
						
						Thread.sleep(500);
						String msg1 = LiPerformerPOM.readMessage().getText();		//Reading message after Appove.
						
						if(msg1.equalsIgnoreCase("Rejected Successfully."))
						{
							test.log(LogStatus.PASS, "Message displayed = "+msg1);
						}
						else
						{
							test.log(LogStatus.FAIL, "Message displayed = "+msg1);
						}
				
				Thread.sleep(3000);
				
				//LiPerformerPOM.clickClose().click();		
			
		}
		
			//Clicking on Close (Cross)
				
	/*	try
				{
					Thread.sleep(300);
					wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
				}
				catch(Exception e)
				{
					
				}
				
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0,700)");
				
				Thread.sleep(500);
				int total1 = Integer.parseInt(OverduePOM.readReminder().getText());	//Reading total records count
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
				wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
				OverduePOM.clickDashboard().click();							//CLicking on Dashboard.
				
				Thread.sleep(700);
				wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickPendingForReview()));		
				int pending1 = Integer.parseInt(LiPerformerPOM.clickPendingForReview().getText());	//Reading 'Pending For Review' count
				int applied1 = Integer.parseInt(LiPerformerPOM.clickApplied().getText());	//Reading 'Applied' count
				
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
				LiReviewerPOM.clickIndexDropDown().click();
				Thread.sleep(500);
				elementsList1 = LiReviewerPOM.clickIndexDropDownOption();
				int m = elementsList1.size();
				if(k <= m)				//Hear initially k- 1 as we are already on page 0
				{
					elementsList1.get(k).click();
					Thread.sleep(500);
					elementsList = LiReviewerPOM.clickAction();
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
	
		



	public static void PendingReviewCountInternal(ExtentTest test, String string) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		try
		{
			Thread.sleep(3000);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickPendingForReview()));		
		int pending = Integer.parseInt(LiPerformerPOM.clickPendingForReview().getText());	//Reading 'Pending For Review' count
		int applied = Integer.parseInt(LiPerformerPOM.clickPendingForReview().getText());	//Reading 'Applied' count
		LiPerformerPOM.clickPendingForReview().click();		//Clicking on 'Pending For Review' image link
		
		Thread.sleep(3000);
		try
		{
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable()));
		//LiReviewerPOM.clickReviewer().click();
		
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor)getDriver() ;
		js.executeScript("window.scrollBy(0,1000)");					//Scrolling down window by 500 px.
		//int total = Integer.parseInt(OverduePOM.readReminder().getText());	//Reading total records count
		
		if(pending == applied)
		{
			//test.log(LogStatus.PASS, "Dashboard 'Pending Review' count matches to total records displayed.");
			test.log(LogStatus.PASS, "Dashboard 'Pending For Review' count = "+pending+" | Total Pending For Review records in grid = "+applied);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Dashboard 'Pending Review' count doesn't matches to total records displayed.");
			test.log(LogStatus.PASS, "Dashboard 'Pending For Review' count = "+pending+" | Total Pending For Review records in grid = "+applied);
		}
		
		
		Thread.sleep(5000);
		LiReviewerPOM.Overviewreview1().click();
		
    	test.log(LogStatus.PASS, " License Overview Details Successfully");
    	Thread.sleep(5000);
		MethodPOM.ClickCloseOverview().click();		
		Thread.sleep(500);
		
		LiReviewerPOM.Reviewaction().click();
		//elementsList = LiReviewerPOM.clickAction();
		//elementsList.get(0).click();									//Clicking on ith Action button.
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(500);
		
		//ReviewerPOM.clickDownload2().click();
		
		Thread.sleep(5000);
		if(ReviewerPOM.clickApprove().isEnabled())
		{
			ReviewerPOM.clickApprove().click();					//Clicking on Approve
		}
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,-3000)");					//Scrolling down window by 500 px.
		
		Thread.sleep(5000);
		String msg = LiPerformerPOM.readMessage().getText();		//Reading message after Appove.
		
		if(msg.equalsIgnoreCase("Approved Successfully."))
		{
			test.log(LogStatus.PASS, "Message displayed = "+msg);
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed = "+msg);
		}
		
		Thread.sleep(500);
		getDriver().switchTo().parentFrame();
		
		Thread.sleep(500);
		LiPerformerPOM.clickClose().click();	
		
		getDriver().navigate().refresh();
		Thread.sleep(3000);
		LiReviewerPOM.Reviewaction().click();
		Thread.sleep(5000);
		
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
		   
			js.executeScript("window.scrollBy(0,800)");
			Thread.sleep(500);
              Actions act1 =new Actions(getDriver());
                act1.sendKeys(Keys.PAGE_DOWN).build().perform();
                Thread.sleep(3000);
                
                 ReviewerPOM.clickDownload2().click();
               
                LiReviewerPOM.intremark().sendKeys("NA");
                Thread.sleep(5000);
				if(LiReviewerPOM.inrejectbtn().isEnabled())
				{
					LiReviewerPOM.inrejectbtn().click();					//Clicking on Approve
				}
			
			
				Thread.sleep(5000);
				js.executeScript("window.scrollBy(0,-4000)");					//Scrolling down window by 500 px.
				
				Thread.sleep(5000);
				String msg1 = LiPerformerPOM.readMessage().getText();		//Reading message after Appove.
				
				if(msg1.equalsIgnoreCase("Rejected Successfully."))
				{
					test.log(LogStatus.PASS, "Message displayed = "+msg1);
				}
				else
				{
					test.log(LogStatus.FAIL, "Message displayed = "+msg1);
				}
		
		  }
		/*Thread.sleep(3000);
		
		perform(, test);
		
		Thread.sleep(500);
		ReviewerPOM.clickApprove().click();					//Clicking on Approve
		
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,700)");
	
/*	Thread.sleep(500);
		int total1 = Integer.parseInt(OverduePOM.readReminder().getText());	//Reading total records count
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
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();							//CLicking on Dashboard.
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);									//Selecting 'Internal' type.
		
		Thread.sleep(1000);
		CFOcountPOM.clickApply1().click();				//Clicking on Apply.
		
		Thread.sleep(700);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickPendingForReview()));		
		int pending1 = Integer.parseInt(LiPerformerPOM.clickPendingForReview().getText());	//Reading 'Pending For Review' count
		int applied1 = Integer.parseInt(LiPerformerPOM.clickApplied().getText());	//Reading 'Applied' count
		
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
	
	public static void ReviewerExpiredCount(ExtentTest test, String type) throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired()));
			String Expired=MethodPOM.clickExpired().getText();
			
		     int Expiredlicense = Integer.parseInt(Expired);	//Reading Expired count.
		 	   Thread.sleep(4000);
		      MethodPOM.clickExpired().click();					//Clicking on 'Expired' image
		      Thread.sleep(4000);
		        JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
				js1.executeScript("window.scroll(0,500)");
				Thread.sleep(4000);
				
				MethodPOM.clickReadExpired().click();					//Clicking on total items count
				Thread.sleep(4000);
				String item = MethodPOM.clickReadExpired().getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String LicenseExpiredCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
				int total = Integer.parseInt(LicenseExpiredCount);
				if(Expiredlicense == total)
		{
			//test.log(LogStatus.PASS, "Dashboard 'Expired' count matches to the total records displayed in grid.");
			test.log(LogStatus.PASS, "Dashboard 'Expired' count = "+Expiredlicense+" | Total Expired records in grid = "+total);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Dashboard 'Expired' count doesn't matches to the total records displayed in grid.");
			test.log(LogStatus.FAIL, "Dashboard 'Expired' count = "+Expiredlicense+" | Total  Expired records in grid = "+total);
		}
		
				MethodPOM.ClickActiveOverview().click();
				test.log(LogStatus.PASS, "License Overview Details Successfully");
				Thread.sleep(5000);
				MethodPOM.ClickCloseOverview().click();
				Thread.sleep(3000);
				LiPerformerPOM.editlicenseicon().click();
				Thread.sleep(7000);
				licenseManagement.licmgmtPOM.LicenseTitle().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle().sendKeys("Ed License Update");	
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo().sendKeys("update00");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(1000,0)");
				Thread.sleep(3000);
				licenseManagement.licmgmtPOM.Nomineesubmit().click();
				 // Switching to Alert       
		        Alert alert = getDriver().switchTo().alert();
		       
		        // Capturing alert message.   
		        String alertMessage= getDriver().switchTo().alert().getText();
		       
		        Thread.sleep(3000);

		        // Accepting alert
		        alert.accept();
		        test.log(LogStatus.PASS,"License Details Updated Successfully" );
		        
		          Thread.sleep(5000);
		          
		          licmgmtPOM.editlicenseclose().click();
		          Thread.sleep(3000);
		          MethodPOM.clickMyDashboard().click();
		          Thread.sleep(3000);
		        //  MethodPOM.clickExpired().click();
		          
				
	//	Thread.sleep(5000);
		//LiPerformerPOM.clickAction().click();					//Clicking on first action button.
		
		//progress();
		
		Thread.sleep(500);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		/*
		if(type.equalsIgnoreCase("Internal"))
		{
			WebWait wait1 = new WebWait(, 5);
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
			LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
			
			Select drp = new Select(LiPerformerPOM.clickType());
			drp.selectByIndex(1);
			Thread.sleep(500);
			CFOcountPOM.clickApply1().click();
			
			  MethodPOM.clickExpired().click();
				
				Thread.sleep(5000);
				LiPerformerPOM.ExpiredAction().click();					//Clicking on first action button.
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
				js1.executeScript("window.scrollBy(0,3000)");
			    Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown()));
			Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting Status dropdown box.
			status.selectByIndex(2);									//Selecting 2nd value from dropdown.
		}
		else
		{
			
			  MethodPOM.clickExpired().click();
				
				Thread.sleep(5000);
				LiPerformerPOM.clickAction().click();					//Clicking on first action button.
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LiPerformerPOM.ShowFream()));		
			js1.executeScript("window.scrollBy(0,1000)");
		    Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown()));
			Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting Status dropdown box.
			status.selectByIndex(2);									//Selecting 2nd value from dropdown.
		}
		
		try
		{
			Thread.sleep(300);
			wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
		}
		catch(Exception e)
		{
			
		}
		
		licenseReviewer.LiReMethodsPOM.perform(, test);			//Calling perform method of Reviewer.
		
		try
		{
			Thread.sleep(500);
			LiPerformerPOM.clickCheckbox().click();			//Clicking on checkbox of Penalty values
			js1.executeScript("window.scrollBy(0,300)");
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(5000);
		js1.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.
		
		Thread.sleep(1000);
		js1.executeScript("window.scrollBy(0,-2000)");				//Scrolling down window by 2000 px.
		
		Thread.sleep(3000);
		if(type.equalsIgnoreCase("Statutory"))
		{
			Thread.sleep(1000);
			String msg = LiPerformerPOM.readMessage().getText();
			
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
	
			getDriver()..switchTo().parentFrame();
			
			Thread.sleep(1000);
			LiPerformerPOM.clickClose().click();		*/		//Clicking on Close (Cross)
			getDriver().navigate().refresh();
			MethodPOM.clickMyDashboard().click();
		}
		
		/*progress();
		Thread.sleep(4000);
		js1.executeScript("window.scrollBy(0,2000)");
		wait.until(ExpectedConditions.elementToBeClickable(MethodPOM.clickReadExpired()));
	    // int total1 = Integer.parseInt(MethodPOM.clickReadExpired().getText());
	     String item1 = MethodPOM.clickReadExpired().getText();	//Reading total items String value
			String[] bits1 = item1.split(" ");								//Splitting the String
			String LicenseExpiredCount1 = bits1[bits1.length - 2];		//Getting the second last word (total number of users)
			
			//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
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
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();
		
		Thread.sleep(700);
		if(type.equalsIgnoreCase("Internal"))
		{
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
			LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
			Select drp = new Select(LiPerformerPOM.clickType());
			drp.selectByIndex(1);
			
			progress();
			
			Thread.sleep(500);
			CFOcountPOM.clickApply1().click();				//Clicking on Apply.
		}
		
		Thread.sleep(700);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired()));
		int expired1 = Integer.parseInt(LiPerformerPOM.clickExpired().getText());	//Reading Active count.
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
	public static void ReviewerAppliedCount( ExtentTest test, String type) throws InterruptedException
	{		
		/*WebWait wait = new WebWait(, 20);
		progress();
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickApplied()));
		int applied = Integer.parseInt(LiPerformerPOM.clickApplied().getText());	//Reading Applied count.
		
		LiPerformerPOM.clickApplied().click();	*/					//Clicking on 'Applied'
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickApplied()));
			int applied = Integer.parseInt(LiPerformerPOM.clickApplied().getText());	//Reading Applied count.
			
	//		String Applied=MethodPOM.clickApplied().getText();
			
		 //    int AppliedLicense = Integer.parseInt(Applied);	//Reading Expired count.

		      MethodPOM.clickApplied().click();					//Clicking on 'Active' image
		      Thread.sleep(4000);
		        JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
				js1.executeScript("window.scroll(0,500)");
				Thread.sleep(4000);
				
				MethodPOM.clickReadApplied().click();					//Clicking on total items count
				Thread.sleep(500);
				String item = MethodPOM.clickReadApplied().getText();	//Reading total items String value
				String[] bits = item.split(" ");								//Splitting the String
				String LicenseAppliedCount = bits[bits.length - 2];		//Getting the second last word (total number of users)
				
				//int total = Integer.parseInt(MethodPOM.clickReadActive().getText());
				int total = Integer.parseInt(LicenseAppliedCount);
				if(applied == total)
		{
			//test.log(LogStatus.PASS, "Dashboard 'Applied' count matches to the total records displayed.");
			test.log(LogStatus.PASS, "Dashboard 'Applied' count = "+applied+" | Total Applied records = "+total);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Dashboard 'Applied' count matches doesn't to the total records displayed.");
			test.log(LogStatus.FAIL, "Dashboard 'Applied' count = "+applied+" | Total Applied records = "+total);
		}
		
		Thread.sleep(300);
		MethodPOM.ClickActiveOverview().click();
		test.log(LogStatus.PASS, "License Overview Details Successfully");
		Thread.sleep(3000);
		MethodPOM.ClickCloseOverview().click();
		LiPerformerPOM.editlicenseicon().click();
		Thread.sleep(7000);
		licenseManagement.licmgmtPOM.LicenseTitle().clear();
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.LicenseTitle().sendKeys("update License");	
		Thread.sleep(3000);
		licenseManagement.licmgmtPOM.LicenseNo().clear();
		Thread.sleep(3000);
		licenseManagement.licmgmtPOM.LicenseNo().sendKeys("update00");
		Thread.sleep(5000);
		js1.executeScript("window.scrollBy(1000,0)");
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.Nomineesubmit().click();
		 // Switching to Alert       
        Alert alert = getDriver().switchTo().alert();
       
        // Capturing alert message.   
        String alertMessage= getDriver().switchTo().alert().getText();
       
        Thread.sleep(5000);

        // Accepting alert
        alert.accept();
        test.log(LogStatus.PASS,"License Details Updated Successfully" );
        
          Thread.sleep(5000);
          
        //  licmgmtPOM.editlicenseclose().click();
         // Thread.sleep(300);
        // MethodPOM.clickMyDashboard().click();
         Thread.sleep(1000);
      //  MethodPOM.clickApplied().click();
       // Thread.sleep(5000);
		//LiPerformerPOM.clickAction().click();					//Clicking on first action button.
		
		//progress();
		
		Thread.sleep(500);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		
		//licenseReviewer.LiReMethodsPOM.perform(, test);		//Calling perform method of Reviewer.
		/*
		if(type.equalsIgnoreCase("Internal"))
		{
			WebWait wait1= new WebWait(, 5);
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
			LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
			
			
			Select drp = new Select(LiPerformerPOM.clickType());
			drp.selectByIndex(1);
			CFOcountPOM.clickApply1().click();	
			  Thread.sleep(3000);
		     MethodPOM.clickApplied().click();
		         Thread.sleep(1000);
    
				
				LiPerformerPOM.AppliedActionin().click();					//Clicking on first action button.
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
			js1.executeScript("window.scroll(0,500)");	
			LiPerformerPOM.LicenseNo().sendKeys("234");
			Thread.sleep(500);
			LiPerformerPOM.Licensetitle().sendKeys("License234");
			Thread.sleep(500);
			LiPerformerPOM.AppliedStartDateclick().click();
			Thread.sleep(500);
			LiPerformerPOM.AppliedStartDate().click();
			Thread.sleep(3000);
		   LiPerformerPOM.AppliedEndDateclick().click();
		   Thread.sleep(3000);
		   LiPerformerPOM.AppliedEndDate().click();
		   String workingDir = System.getProperty("user.dir");
			LiPerformerPOM.UploadDocument().sendKeys(workingDir+"//Reports//PerformerResults.html");	//uploading new file		
			Thread.sleep(500);
		}
		else
		{
			  MethodPOM.clickApplied().click();
				Thread.sleep(5000);
			LiPerformerPOM.AppliedAction().click();					//Clicking on first action button.
			Thread.sleep(3000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
		//js1.executeScript("window.scroll(0,500)");	
		Thread.sleep(3000);
		LiPerformerPOM.LicenseNo().sendKeys("234");
		Thread.sleep(500);
		LiPerformerPOM.Licensetitle().sendKeys("License234");
		Thread.sleep(500);
		LiPerformerPOM.AppliedStartDateclick().click();
		Thread.sleep(500);
		LiPerformerPOM.AppliedStartDate().click();
		Thread.sleep(3000);
	   LiPerformerPOM.AppliedEndDateclick().click();
	   Thread.sleep(3000);
	   LiPerformerPOM.AppliedEndDate().click();
	   Thread.sleep(3000);
	   String workingDir = System.getProperty("user.dir");
		LiPerformerPOM.UploadDocument().sendKeys(workingDir+"//Reports//PerformerResults.html");	//uploading new file		
		Thread.sleep(500);
	   
		}
			
		//	Thread.sleep(500);
			//LiPerformerPOM.clickComplDoc().clear();
			//LiPerformerPOM.clickComplDoc().sendKeys("www.google.com");	//Providing compliance document link.
		
		
		
	//	Thread.sleep(300);
	//	OverduePOM.AppliedSubmit().click();			//Clicking on 'Submit' button.
		/*try
		{
			Thread.sleep(500);
			.switchTo().alert().dismiss();
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
	     	js1.executeScript("window.scrollBy(2000,0)");				//Scrolling down window by 2000 px.
		
		if(type.equalsIgnoreCase("Statutory"))
		try
		{
			String msg = LiPerformerPOM.readMsg().getText();
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
		
		//getDriver()..switchTo().parentFrame();
		
		Thread.sleep(500);
		//js.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 1000 px.
	/*	String workingDir = System.getProperty("user.dir");
		//LiPerformerPOM.UploadDocument().sendKeys(workingDir+"//Reports//PerformerResults.html");	//uploading new file		
		//Thread.sleep(500);
		
		OverduePOM.AppliedSubmit().click();			//Clicking on 'Submit' button.
		Thread.sleep(500);
		*/
		//getDriver()..switchTo().parentFrame();
		//Thread.sleep(5000);
		//LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
		
	//	progress();
		
		//Thread.sleep(500);
		//wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		//OverduePOM.clickDashboard().click();
		
		/*if(type.equalsIgnoreCase("Internal"))			//Opening 'Internal' Dashboard
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
			LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
			
			Select drp = new Select(LiPerformerPOM.clickType());
			drp.selectByIndex(1);
			
			progress();
			
			Thread.sleep(500);
			CFOcountPOM.clickApply1().click();				//Clicking on Apply.
		}
		
	/*	wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickActive()));
		int applied1 = Integer.parseInt(LiPerformerPOM.clickApplied().getText());	//Reading Active count.
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

	
	 public static void LicenseExpiringOnStatutory( ExtentTest test, String type) throws InterruptedException, IOException
	   {
		   Thread.sleep(5000);
		   MethodPOM.ClickMaximizeLicenseExpiringOn().click();
		   Thread.sleep(3000);
		   test.log(LogStatus.PASS, "Expiring On Maximize Button Working Successfully");
		 
		   JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			  Thread.sleep(3000);
			MethodPOM.DashExpiringOnExport().click();
			test.log(LogStatus.PASS, "Dashboard Expiring License Download Successfully");
			
		  LiReviewerPOM.revexpiringOn().click();
		   Thread.sleep(7000);
		   test.log(LogStatus.PASS, "Expiring On ShowMore Link Working Successfully");
		   WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showLicenseDetails"));
		   String NoRecord = MethodPOM.Norecord().getText();
		   if(!NoRecord.equalsIgnoreCase("No items to display")) 
		   {
		   
		   MethodPOM.ClickExportExpiredOn().click();
			test.log(LogStatus.PASS, "Expiring License List Downloaded Successfully");
			Thread.sleep(5000);
			MethodPOM.ExpiredOnLictype().click();
			Thread.sleep(5000);
			MethodPOM.searchExpiredOnLictype().sendKeys("Boiler",Keys.ENTER);
			MethodPOM.Clearfilter().click();
			test.log(LogStatus.PASS, "Clear Filter Button Working  Successfully");
          	Thread.sleep(7000);
			MethodPOM.ClickOverviewExpiredOn().click();
			test.log(LogStatus.PASS, "Expiring OverView License Displayed");
			 Thread.sleep(3000);
	             MethodPOM.clickBystatuscloseoverview().click();
				 Thread.sleep(2000);
				
				
				  // Js.executeScript("window.scrollBy(500,0)");
				getDriver().switchTo().parentFrame();
				 MethodPOM.clickCloseGraphPopup().click();
				 Thread.sleep(3000);
				
		   }
		   else
		   {
			   getDriver().switchTo().parentFrame();
				 MethodPOM.clickCloseGraphPopup().click();
				 Thread.sleep(3000);
				  test.log(LogStatus.PASS, "Expiring On Popup No Record Found ");
		   }
}
	 public static void ReviewerRejectedCount( ExtentTest test, String type) throws InterruptedException 
		{
			 
		 WebDriverWait wait = new WebDriverWait( getDriver(), (30));
				
				wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickRejected()));
				String Rejected=MethodPOM.clickRejected().getText();
				
			     int RejectedLicense = Integer.parseInt(Rejected);	//Reading Rejected count.

			      MethodPOM.clickRejected().click();					//Clicking on 'Rejected ' image
			      Thread.sleep(4000);
			        JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
					js1.executeScript("window.scroll(0,500)");
					Thread.sleep(4000);
					String item1 = MethodPOM.clickReadExpired().getText();	//Reading total items String value
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
						test.log(LogStatus.PASS, " License Overview Details Successfully");
						Thread.sleep(3000);
						MethodPOM.ClickCloseOverview().click();
						Thread.sleep(3000);
						LiPerformerPOM.editlicenseicon().click();
						Thread.sleep(5000);
						licenseManagement.licmgmtPOM.LicenseTitle().clear();
						Thread.sleep(5000);
						licenseManagement.licmgmtPOM.LicenseTitle().sendKeys("update License");	
						Thread.sleep(5000);
						licenseManagement.licmgmtPOM.LicenseNo().sendKeys("update00");
						Thread.sleep(5000);
						js1.executeScript("window.scrollBy(0,2000)");
						Thread.sleep(3000);
						 Actions act =new Actions(getDriver());
			                act.sendKeys(Keys.PAGE_DOWN).build().perform();
			                Thread.sleep(3000);
						//LiPerformerPOM.editnomineebtn().click();
						/*Thread.sleep(3000);
						 licmgmtPOM.ClickNomineedrp().click();
						 Thread.sleep(3000);
						 licmgmtPOM.SelectNominee().click();
						 
						 Thread.sleep(5000);
						js1.executeScript("window.scroll(0,2000)");
						 Thread.sleep(5000);
						 licmgmtPOM.ClickModificdate().click();
						 Thread.sleep(6000);	
						 js1.executeScript("window.scroll(0,2000)");
						 Thread.sleep(6000);		 
						 licmgmtPOM.ModificatioDate().click();		 
						 Thread.sleep(6000);
						 js1.executeScript("window.scroll(0,2000)");
						 licmgmtPOM.nomineestartdatecal().click();
						 Thread.sleep(3000);
						 licmgmtPOM.selectnominstartdate().click();
						 Thread.sleep(3000);
						 JavascriptExecutor js2=(JavascriptExecutor)  ;
							js2.executeScript("window.scroll(0,2000)");
						 licmgmtPOM.nomineeEnddatecal().click();
						 Thread.sleep(5000);
						 licmgmtPOM.selectnomineenddate().click();
						 Thread.sleep(5000);
					*/
						licenseManagement.licmgmtPOM.Nomineesubmit().click();
						 // Switching to Alert       
				        Alert alert = getDriver().switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= getDriver().switchTo().alert().getText();
				       
				        Thread.sleep(3000);
				      //  test.log(LogStatus.PASS, alertMessage);
				       
				        // Displaying alert message
				       // System.out.println(alertMessage);
				        // Accepting alert
				        /*Thread.sleep(3000);
				        By locator = By.xpath("//*[@class='k-button-group k-dialog-buttongroup k-dialog-button-layout-stretched']");

				    	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				    	Thread.sleep(4000);
				    	
				    	WebElement ViewButton = .findElement(locator);	
				    	Thread.sleep(3000);
				    JavascriptExecutor jse=(JavascriptExecutor);
				    jse.executeScript("arguments[0].click();", ViewButton);
				    	Thread.sleep(4000);
				        
				      //  LiPerformerPOM.licenseOK().click();
				        
				     */
				        // Accepting alert
				        alert.accept();
				        test.log(LogStatus.PASS,"License Details Updated Successfully" );
				        
				          Thread.sleep(5000);
				          
				          licmgmtPOM.editlicenseclose().click();
					  }
				          else
						  {
							   		      
							test.log(LogStatus.PASS,"No Record Found");
							MethodPOM.clickMyDashboard().click();
								      
						  }
				         // MethodPOM.clickMyDashboard().click();
				          Thread.sleep(1000);
				         // MethodPOM.clickActive().click();	
				          
				        //  Thread.sleep(3000);
					//	LiPerformerPOM.clickAction().click();					//Clicking on first action button.
						
						//progress();
						
						//Thread.sleep(500);
					

					//	LiPerformerPOM.clickAction().click();					//Clicking on first action button.
						
						//progress();
						
						Thread.sleep(500);
					//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
						
						/*if(type.equalsIgnoreCase("Internal"))
						{
							WebWait wait1= new WebWait(, 5);
							wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
							LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
							
							
							Select drp = new Select(LiPerformerPOM.clickType());
							drp.selectByIndex(1);
							CFOcountPOM.clickApply1().click();	
							  Thread.sleep(3000);
							 
							MethodPOM.clickRejected().click();	

							OverduePOM.RejectedAction().click();					//Clicking on first action button.
					        Thread.sleep(3000);
					     
					        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
							js1.executeScript("window.scrollBy(0,2000)");
							wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown()));
							Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting Status dropdown box.
							status.selectByIndex(2);									//Selecting 2nd value from dropdown.
						}
						else
						{
							MethodPOM.clickRejected().click();
							 Thread.sleep(500);
							LiPerformerPOM.rejectAction().click();					//Clicking on first action button.
					        Thread.sleep(3000);
					     
							wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));		
							js1.executeScript("window.scrollBy(0,1000)");
						    Thread.sleep(5000);
							wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown()));
							Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting Status dropdown box.
							status.selectByIndex(2);									//Selecting 2nd value from dropdown.
						}
						
						try
						{
							Thread.sleep(300);
							wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
						}
						catch(Exception e)
						{
							
						}
						
						licenseReviewer.LiReMethodsPOM.perform(, test);			//Calling perform method of Reviewer.
						
						try
						{
							Thread.sleep(500);
							LiPerformerPOM.clickCheckbox().click();			//Clicking on checkbox of Penalty values
							js1.executeScript("window.scrollBy(0,300)");
						}
						catch(Exception e)
						{
							
						}
						
						Thread.sleep(500);
						js1.executeScript("window.scrollBy(0,700)");
						Thread.sleep(300);
						OverduePOM.clickComplianceSubmit().click();			//Clicking on 'Submit' button.
						
						Thread.sleep(1000);
						js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.
						
						Thread.sleep(300);
						if(type.equalsIgnoreCase("Statutory"))
						{
							String msg = LiPerformerPOM.readMessage().getText();
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
							
							getDriver()..switchTo().parentFrame();
							
							Thread.sleep(700);
							LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
							.navigate().refresh();
							
						}
						*/
						
					//	MethodPOM.clickMyDashboard().click();
			   
			
		}
	 public static void ReviewerTerminateLicense1( ExtentTest test, String type) throws InterruptedException
	   {
		  
			   
		 WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.terminatedPerformer()));
			String Terminate=LiPerformerPOM.terminatedPerformer().getText();
			
		     int TerminateLicense = Integer.parseInt(Terminate);	//Reading Terminate count.

		     LiPerformerPOM.terminatedPerformer().click();					//Clicking on 'Terminate ' image
		      Thread.sleep(4000);
		        JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
				js1.executeScript("window.scroll(0,500)");
				Thread.sleep(4000);
				
				licenseCompanyadmin.MethodPOM.clickReadTerminate().click();					//Clicking on total items count
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
					
					licenseCompanyadmin.MethodPOM.ClickActiveOverview().click();
					Thread.sleep(3000);
					test.log(LogStatus.PASS, " License Overview Details Successfully");
					Thread.sleep(3000);
					licenseCompanyadmin.MethodPOM.ClickCloseOverview().click();
        
					//LiPerformerPOM.clickAction().click();					//Clicking on first action button.
					LiPerformerPOM.editlicenseicon().click();
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseTitle().clear();
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseTitle().sendKeys("update License");	
					Thread.sleep(5000);
					licenseManagement.licmgmtPOM.LicenseNo().sendKeys("update00");
					Thread.sleep(5000);
					js1.executeScript("window.scrollBy(0,2000)");
					Thread.sleep(3000);
					 Actions act =new Actions(getDriver());
		                act.sendKeys(Keys.PAGE_DOWN).build().perform();
		                Thread.sleep(3000);
					//LiPerformerPOM.editnomineebtn().click();
					/*Thread.sleep(3000);
					 licmgmtPOM.ClickNomineedrp().click();
					 Thread.sleep(3000);
					 licmgmtPOM.SelectNominee().click();
					 
					 Thread.sleep(5000);
					js1.executeScript("window.scroll(0,2000)");
					 Thread.sleep(5000);
					 licmgmtPOM.ClickModificdate().click();
					 Thread.sleep(6000);	
					 js1.executeScript("window.scroll(0,2000)");
					 Thread.sleep(6000);		 
					 licmgmtPOM.ModificatioDate().click();		 
					 Thread.sleep(6000);
					 js1.executeScript("window.scroll(0,2000)");
					 licmgmtPOM.nomineestartdatecal().click();
					 Thread.sleep(3000);
					 licmgmtPOM.selectnominstartdate().click();
					 Thread.sleep(3000);
					 JavascriptExecutor js2=(JavascriptExecutor)  ;
						js2.executeScript("window.scroll(0,2000)");
					 licmgmtPOM.nomineeEnddatecal().click();
					 Thread.sleep(5000);
					 licmgmtPOM.selectnomineenddate().click();
					 Thread.sleep(5000);
				*/
					licenseManagement.licmgmtPOM.Nomineesubmit().click();
					 // Switching to Alert       
			        Alert alert = getDriver().switchTo().alert();
			       
			        // Capturing alert message.   
			        String alertMessage= getDriver().switchTo().alert().getText();
			       
			        Thread.sleep(3000);
			      //  test.log(LogStatus.PASS, alertMessage);
			       
			        // Displaying alert message
			       // System.out.println(alertMessage);
			        // Accepting alert
			        /*Thread.sleep(3000);
			        By locator = By.xpath("//*[@class='k-button-group k-dialog-buttongroup k-dialog-button-layout-stretched']");

			    	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			    	Thread.sleep(4000);
			    	
			    	WebElement ViewButton = .findElement(locator);	
			    	Thread.sleep(3000);
			    JavascriptExecutor jse=(JavascriptExecutor);
			    jse.executeScript("arguments[0].click();", ViewButton);
			    	Thread.sleep(4000);
			        
			      //  LiPerformerPOM.licenseOK().click();
			        
			     */
			        // Accepting alert
			        alert.accept();
			        test.log(LogStatus.PASS,"License Details Updated Successfully" );
			        
			          Thread.sleep(5000);
			          
			          licmgmtPOM.editlicenseclose().click();
			          Thread.sleep(300);
			          MethodPOM.clickMyDashboard().click();
			          Thread.sleep(1000);
			         // MethodPOM.clickActive().click();	
			          
			        //  Thread.sleep(3000);
				//	LiPerformerPOM.clickAction().click();					//Clicking on first action button.
					
					//progress();
					
					//Thread.sleep(500);
				

				//	LiPerformerPOM.clickAction().click();					//Clicking on first action button.
					
				//	progress();
					
					Thread.sleep(500);
				//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
		
				//	progress();
					
					Thread.sleep(500);
					//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					
				/*	if(type.equalsIgnoreCase("Internal"))
					{
						WebWait wait1= new WebWait(, 5);
						wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
						LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
						
						
						Select drp = new Select(LiPerformerPOM.clickType());
						drp.selectByIndex(1);
						CFOcountPOM.clickApply1().click();	
						  Thread.sleep(3000);
						 
						LiPerformerPOM.terminatedPerformer().click();	

						LiPerformerPOM.terAction().click();						//Clicking on first action button.
				        Thread.sleep(3000);
				        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
						js1.executeScript("window.scrollBy(0,2000)");
						wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown()));
						Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting Status dropdown box.
						status.selectByIndex(2);									//Selecting 2nd value from dropdown.
					}
					else
					{
						LiPerformerPOM.terminatedPerformer().click();
						 Thread.sleep(500);
						LiPerformerPOM.TerminateAction().click();					//Clicking on first action button.
				        Thread.sleep(3000);	
						wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));		
						js1.executeScript("window.scrollBy(0,1000)");
					    Thread.sleep(2000);
						wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown()));
						Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting Status dropdown box.
						status.selectByIndex(2);									//Selecting 2nd value from dropdown.
					}
					
					try
					{
						Thread.sleep(300);
						wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
					}
					catch(Exception e)
					{
						
					}
					
					licenseReviewer.LiReMethodsPOM.perform(, test);			//Calling perform method of Reviewer.
					
					try
					{
						Thread.sleep(500);
						LiPerformerPOM.clickCheckbox().click();			//Clicking on checkbox of Penalty values
						js1.executeScript("window.scrollBy(0,300)");
					}
					catch(Exception e)
					{
						
					}
					
					Thread.sleep(500);
					js1.executeScript("window.scrollBy(0,700)");
					Thread.sleep(300);
					//LiPerformerPOM.SubmitTerminate().click();			//Clicking on 'Submit' button.
					
					Thread.sleep(1000);
					js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.
					
					Thread.sleep(300);
					if(type.equalsIgnoreCase("Statutory"))
					{
						String msg = LiPerformerPOM.readMessage().getText();
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
						
						getDriver()..switchTo().parentFrame();
						
						Thread.sleep(700);
						LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
						.navigate().refresh();
						*/
						MethodPOM.clickMyDashboard().click();
					
		   
	   }
	

				
	   
public static void LicenseExpiringOnInternalrew( ExtentTest test, String type) throws InterruptedException, IOException
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		/*wait1.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
		LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
		
		
		Select drp = new Select(LiPerformerPOM.clickType());
		drp.selectByIndex(1);
		CFOcountPOM.clickApply1().click();	
	   Thread.sleep(3000);
	   */
	   LiPerformerPOM.Expiringmaxmize().click();
	   test.log(LogStatus.PASS, "Expiring On Maximize Button Working Successfully");
	   Thread.sleep(3000);
	   JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
		js1.executeScript("window.scroll(0,500)");
		MethodPOM.DashExpiringOnExport().click();
		  Thread.sleep(3000);
		test.log(LogStatus.PASS, "Dashboard Expiring License Download Successfully");
		By locator = By.xpath("//*[@id='ContentPlaceHolder1_lnkShowDetailLicense']");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(3000);
	JavascriptExecutor jse=(JavascriptExecutor)getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
	   LiPerformerPOM.Expiringshowmore().click();
	   Thread.sleep(7000);
	   test.log(LogStatus.PASS, "Expiring On show More Link Working Successfully");
	   WebDriverWait wait1 = new WebDriverWait( getDriver(), (30));
		Thread.sleep(5000);
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showLicenseDetails"));
	   Thread.sleep(3000);
	   js1.executeScript("window.scroll(0,500)");
	   String NoRecord = LiReviewerPOM.reNorecord().getText();
	   if(!NoRecord.equalsIgnoreCase("No items to display")) 
	   {
	   MethodPOM.ClickExportExpiredOn().click();
		test.log(LogStatus.PASS, "Expiring On License List Downloaded Successfully");
		  Thread.sleep(3000);
		  
		  LiPerformerPOM.lictype().click();
		  Thread.sleep(500);
		  LiPerformerPOM.selectlic1().click();
		Thread.sleep(3000);
	   LiPerformerPOM.clearbtn().click();
	   test.log(LogStatus.PASS, "Expiring On License Popup Clear filter Button Working Successfully");
	   
	   Thread.sleep(3000);
		MethodPOM.ClickOverviewExpiredOn().click();
		test.log(LogStatus.PASS, "Expiring OverView License Displayed");
		Thread.sleep(3000);
    MethodPOM.clickBystatuscloseoverview().click();
		 Thread.sleep(2000);
		  // Js.executeScript("window.scrollBy(500,0)");
		getDriver().switchTo().parentFrame();
		 LiPerformerPOM.CloseExpiredOn().click();
		 Thread.sleep(3000);

	   }else
	   {
		   getDriver().switchTo().parentFrame();
			 LiPerformerPOM.CloseExpiredOn().click();
			 Thread.sleep(3000);
			  test.log(LogStatus.PASS, "Expiring On Popup No Record Found ");
	   }
	   
}
public static void TerminateLicense1rew( ExtentTest test, String type) throws InterruptedException
{
	  
		   
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.terminatedPerformer()));
		String Terminate=LiPerformerPOM.terminatedPerformer().getText();
		
	     int TerminateLicense = Integer.parseInt(Terminate);	//Reading Terminate count.

	     LiPerformerPOM.terminatedPerformer().click();					//Clicking on 'Terminate ' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			licenseCompanyadmin.MethodPOM.clickReadTerminate().click();					//Clicking on total items count
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
				
				licenseCompanyadmin.MethodPOM.ClickActiveOverview().click();
				Thread.sleep(3000);
				test.log(LogStatus.PASS, " License Overview Details Successfully");
				Thread.sleep(3000);
				licenseCompanyadmin.MethodPOM.ClickCloseOverview().click();
   
				//LiPerformerPOM.clickAction().click();					//Clicking on first action button.
				LiPerformerPOM.editlicenseicon().click();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle().clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle().sendKeys("update License");	
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseNo().sendKeys("update00");
				Thread.sleep(5000);
				js1.executeScript("window.scrollBy(0,2000)");
				Thread.sleep(3000);
				 Actions act =new Actions(getDriver());
	                act.sendKeys(Keys.PAGE_DOWN).build().perform();
	                Thread.sleep(3000);
				//LiPerformerPOM.editnomineebtn().click();
				/*Thread.sleep(3000);
				 licmgmtPOM.ClickNomineedrp().click();
				 Thread.sleep(3000);
				 licmgmtPOM.SelectNominee().click();
				 
				 Thread.sleep(5000);
				js1.executeScript("window.scroll(0,2000)");
				 Thread.sleep(5000);
				 licmgmtPOM.ClickModificdate().click();
				 Thread.sleep(6000);	
				 js1.executeScript("window.scroll(0,2000)");
				 Thread.sleep(6000);		 
				 licmgmtPOM.ModificatioDate().click();		 
				 Thread.sleep(6000);
				 js1.executeScript("window.scroll(0,2000)");
				 licmgmtPOM.nomineestartdatecal().click();
				 Thread.sleep(3000);
				 licmgmtPOM.selectnominstartdate().click();
				 Thread.sleep(3000);
				 JavascriptExecutor js2=(JavascriptExecutor)  ;
					js2.executeScript("window.scroll(0,2000)");
				 licmgmtPOM.nomineeEnddatecal().click();
				 Thread.sleep(5000);
				 licmgmtPOM.selectnomineenddate().click();
				 Thread.sleep(5000);
			*/
				licenseManagement.licmgmtPOM.Nomineesubmit().click();
				 // Switching to Alert       
		        Alert alert = getDriver().switchTo().alert();
		       
		        // Capturing alert message.   
		        String alertMessage= getDriver().switchTo().alert().getText();
		       
		        Thread.sleep(3000);
		      //  test.log(LogStatus.PASS, alertMessage);
		       
		        // Displaying alert message
		       // System.out.println(alertMessage);
		        // Accepting alert
		        /*Thread.sleep(3000);
		        By locator = By.xpath("//*[@class='k-button-group k-dialog-buttongroup k-dialog-button-layout-stretched']");

		    	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		    	Thread.sleep(4000);
		    	
		    	WebElement ViewButton = .findElement(locator);	
		    	Thread.sleep(3000);
		    JavascriptExecutor jse=(JavascriptExecutor);
		    jse.executeScript("arguments[0].click();", ViewButton);
		    	Thread.sleep(4000);
		        
		      //  LiPerformerPOM.licenseOK().click();
		        
		     */
		        // Accepting alert
		        alert.accept();
		        test.log(LogStatus.PASS,"License Details Updated Successfully" );
		        
		          Thread.sleep(5000);
		          
		          licmgmtPOM.editlicenseclose().click();
		          Thread.sleep(300);
		          MethodPOM.clickMyDashboard().click();
		          Thread.sleep(1000);
		         // MethodPOM.clickActive().click();	
		          
		        //  Thread.sleep(3000);
			//	LiPerformerPOM.clickAction().click();					//Clicking on first action button.
				
				//progress();
				
				//Thread.sleep(500);
			

			//	LiPerformerPOM.clickAction().click();					//Clicking on first action button.
				
			//	progress();
				
				Thread.sleep(500);
			//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
	
				//progress();
				
				Thread.sleep(500);
				//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
				
				/*if(type.equalsIgnoreCase("Internal"))
				{
					WebWait wait1= new WebWait(, 5);
					wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType()));
					LiPerformerPOM.clickType().click();				//Clicking on 'Type' drop down.
					
					
					Select drp = new Select(LiPerformerPOM.clickType());
					drp.selectByIndex(1);
					CFOcountPOM.clickApply1().click();	
					  Thread.sleep(3000);
					 
					LiPerformerPOM.terminatedPerformer().click();	

					LiPerformerPOM.terAction().click();						//Clicking on first action button.
			        Thread.sleep(3000);
			        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
					js1.executeScript("window.scrollBy(0,2000)");
					wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown()));
					Select status = new Select(OverduePOM.selectInternalDropdown());	//Selecting Status dropdown box.
					status.selectByIndex(2);									//Selecting 2nd value from dropdown.
				}
				else
				{
					LiPerformerPOM.terminatedPerformer().click();
					 Thread.sleep(500);
					LiPerformerPOM.TerminateAction().click();					//Clicking on first action button.
			        Thread.sleep(3000);	
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));		
					js1.executeScript("window.scrollBy(0,1000)");
				    Thread.sleep(2000);
					wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown()));
					Select status = new Select(OverduePOM.selectStatutoryDropdown());	//Selecting Status dropdown box.
					status.selectByIndex(2);									//Selecting 2nd value from dropdown.
				}
				
				try
				{
					Thread.sleep(300);
					wait.until(ExpectedConditions.invisibilityOf(LiPerformerPOM.Progress()));
				}
				catch(Exception e)
				{
					
				}
				
				licenseReviewer.LiReMethodsPOM.perform(, test);			//Calling perform method of Reviewer.
				
				try
				{
					Thread.sleep(500);
					LiPerformerPOM.clickCheckbox().click();			//Clicking on checkbox of Penalty values
					js1.executeScript("window.scrollBy(0,300)");
				}
				catch(Exception e)
				{
					
				}
				
				Thread.sleep(500);
				js1.executeScript("window.scrollBy(0,700)");
				Thread.sleep(300);
				//LiPerformerPOM.SubmitTerminate().click();			//Clicking on 'Submit' button.
				
				Thread.sleep(1000);
				js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.
				
				Thread.sleep(300);
				if(type.equalsIgnoreCase("Statutory"))
				{
					String msg = LiPerformerPOM.readMessage().getText();
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
					
					getDriver()..switchTo().parentFrame();
					
					Thread.sleep(700);
					LiPerformerPOM.clickClose().click();				//Clicking on Close (Cross)
					.navigate().refresh();
					MethodPOM.clickMyDashboard().click();
				
	   */
}

		public static void nomineeDetails(ExtentTest test, String string) throws InterruptedException
		{
			   
			 licmgmtPOM.ClickMyWorkspace().click();
			  Thread.sleep(3000);
	         LiPerformerPOM.editlicenseicon().click();
	         Thread.sleep(3000);
	         LiReviewerPOM.addnominee().click();
	         JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(3000);
			licmgmtPOM.ClickNomineedrp().click();
			 Thread.sleep(3000);
			 licmgmtPOM.SelectNominee().click();
			 
			 Thread.sleep(5000);
			// js1.executeScript("window.scroll(0,2000)");
			// Thread.sleep(5000);
			 licmgmtPOM.ClickModificdate().click();
			 Thread.sleep(6000);	
			 js1.executeScript("window.scroll(0,2000)");
			 Thread.sleep(6000);		 
			 licmgmtPOM.ModificatioDate().click();		 
			 Thread.sleep(6000);
			 js1.executeScript("window.scroll(0,2000)");
			 licmgmtPOM.nomineestartdatecal().click();
			 Thread.sleep(3000);
			 licmgmtPOM.selectnominstartdate().click();
			 Thread.sleep(3000);
			 JavascriptExecutor js2=(JavascriptExecutor) getDriver();
				js2.executeScript("window.scroll(0,2000)");
			 licmgmtPOM.nomineeEnddatecal().click();
			 Thread.sleep(5000);
			 licmgmtPOM.selectnomineenddate().click();
			 Thread.sleep(5000);
			licenseManagement.licmgmtPOM.btnsavenominee().click();
			 // Switching to Alert       
	        Alert alert = getDriver().switchTo().alert();
	       
	        // Capturing alert message.   
	        String alertMessage= getDriver().switchTo().alert().getText();
	       
	        alert.accept();
	        
	        getDriver().switchTo().defaultContent();
	        LiReviewerPOM.clickok().click();
		      
	        test.log(LogStatus.PASS,"Nominee Details Added Successfully" );
	        Alert alert2 = getDriver().switchTo().alert();
		       
	        // Capturing alert message.   
	        String alertMessage2= getDriver().switchTo().alert().getText();
	       
	        alert.accept();
	        Thread.sleep(3000);
	        LiReviewerPOM.workclose().click();
	        Thread.sleep(3000);
	         licmgmtPOM.ClickMyWorkspace().click();
	         Thread.sleep(3000);
	         LiPerformerPOM.editlicenseicon().click();
	         Thread.sleep(3000);
	         LiReviewerPOM.addnominee().click();
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(3000);
			licmgmtPOM.ClickNomineedrp().click();
			 Thread.sleep(3000);
			 licmgmtPOM.SelectNominee().click();
			 
			 Thread.sleep(5000);
			// js1.executeScript("window.scroll(0,2000)");
			// Thread.sleep(5000);
			 licmgmtPOM.ClickModificdate().click();
			 Thread.sleep(6000);	
			 js1.executeScript("window.scroll(0,2000)");
			 Thread.sleep(6000);		 
			 licmgmtPOM.ModificatioDate().click();		 
			 Thread.sleep(6000);
			 js1.executeScript("window.scroll(0,2000)");
			 licmgmtPOM.nomineestartdatecal().click();
			 Thread.sleep(3000);
			 licmgmtPOM.selectnominstartdate().click();
			 Thread.sleep(3000);
				js2.executeScript("window.scroll(0,2000)");
				
			LiReviewerPOM.iscurrentnominee().click();
         
			licenseManagement.licmgmtPOM.btnsavenominee().click();
			 // Switching to Alert       
	        Alert alert3 = getDriver().switchTo().alert();
	       
	        // Capturing alert message.   
	        String alertMessage3= getDriver().switchTo().alert().getText();
	       
	        alert.accept();
	       
	        LiReviewerPOM.clickok().click();
	      
	         Thread.sleep(3000);
	        test.log(LogStatus.PASS,"Is Current Nominee Details Added Successfully" );
   
			
	       
		}
}







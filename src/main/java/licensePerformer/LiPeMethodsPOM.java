package licensePerformer;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cfo.CFOcountPOM;
import licenseCompanyadmin.MethodPOM;
import licenseManagement.licmgmtPOM;
import licenseReviewer.LiReviewerPOM;
import litigationPerformer.performerPOM;
import performer.OverduePOM;
import reviewer.ReviewerPOM;

public class LiPeMethodsPOM 
{
	private static List<WebElement> elementsList = null;
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static XSSFSheet sheet1 = null;		//Sheet variable
	
	public static void ActiveLicense(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{	
		  WebDriverWait wait = new WebDriverWait(driver, 20);
			
			wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
			String Active=MethodPOM.clickActive(driver).getText();
			
		     int Activelicense = Integer.parseInt(Active);	//Reading Active count.

		      MethodPOM.clickActive(driver).click();					//Clicking on 'Active' image
		      Thread.sleep(4000);
		        JavascriptExecutor js1=(JavascriptExecutor) driver ;
				js1.executeScript("window.scroll(0,500)");
				Thread.sleep(4000);
			  	String item1 = MethodPOM.clickReadExpired(driver).getText();	//Reading total items String value
				  if(!item1.equalsIgnoreCase("No items to display"))
				  {
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
		test.log(LogStatus.PASS, " License Overview Details Successfully.");
		Thread.sleep(5000);
		MethodPOM.ClickCloseOverview(driver).click();			
		Thread.sleep(7000);
		LiPerformerPOM.editlicenseicon(driver).click();
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("Active License Update Funcationality");	
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
		 Thread.sleep(500);
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
        test.log(LogStatus.PASS,"License Details Updated Successfully." );
        
          Thread.sleep(5000);
          
          licmgmtPOM.editlicenseclose(driver).click();
          Thread.sleep(300);
          MethodPOM.clickMyDashboard(driver).click();
          Thread.sleep(1000);
			  }
			  else
			  {
				   		      
				test.log(LogStatus.PASS,"No Record Found");
				MethodPOM.clickMyDashboard(driver).click();
					      
			  }
         // MethodPOM.clickActive(driver).click();	
          
        //  Thread.sleep(3000);
	//	LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
		
		//progress(driver);
		
		//Thread.sleep(500);
	
		
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
			MethodPOM.clickMyDashboard(driver).click();
			
		/*
		
		//progress(driver);
		Thread.sleep(2000);
		js1.executeScript("window.scrollBy(0,2000)");
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
		String Active1=MethodPOM.clickActive(driver).getText();
		
	     int Activelicense1 = Integer.parseInt(Active);	//Reading Active count.

	      MethodPOM.clickActive(driver).click();	
		//wait.until(ExpectedConditions.elementToBeClickable(MethodPOM.clickActive(driver)));
	    // int total1 = Integer.parseInt(MethodPOM.clickReadExpired(driver).getText());
	      String item2 = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
			String[] bits2 = item.split(" ");								//Splitting the String
			String LicenseActiveCount2 = bits[bits.length - 2];		//Getting the second last word (total number of users)
			//int total = Integer.parseInt(MethodPOM.clickReadActive(driver).getText());
			int total1 = Integer.parseInt(LicenseActiveCount2);
			if(Activelicense1== total)
		if(total1 < total)
		{
			//test.log(LogStatus.PASS, "Count of records in grid decreased.");
			test.log(LogStatus.PASS, "Old Count = "+total+" | New Count = "+total1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Count of records in grid doesn't decreased.");
			test.log(LogStatus.FAIL, "Old Count = "+total+" | New Count = "+total1);
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(MethodPOM.clickMyDashboard(driver)));
		 MethodPOM.clickMyDashboard(driver).click();
		
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
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
		int Activelicense2 = Integer.parseInt(MethodPOM.clickActive(driver).getText());	//Reading Active count.
		if(Activelicense2 < total)
		{
			//test.log(LogStatus.PASS, "Dashboard 'Expired' count decreased.");
			test.log(LogStatus.PASS, "Old Count = "+Activelicense+" | New Count = "+Activelicense2);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Dashboard 'Expired' count doesn't decreased.");
			test.log(LogStatus.FAIL, "Old Count = "+Activelicense+" | New Count = "+Activelicense2);
		}

		
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		progress(driver);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
		int active = Integer.parseInt(MethodPOM.clickActive(driver).getText());	//Reading Active count.
		
		int pending = Integer.parseInt(MethodPOM.clickActive(driver).getText());
		
		MethodPOM.clickActive(driver).click();					//Clicking on 'Active' image
		
		Thread.sleep(500);
		//wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickAction(driver)));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
		MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
		Thread.sleep(500);
		String item1 = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
		String[] bits1 = item.split(" ");								//Splitting the String
		String LicenseActiveCount1 = bits[bits.length - 2];		//Getting the second last word (total number of users)
		int total2 = Integer.parseInt(LicenseActiveCount1);
		if(active == total)
		{
			//test.log(LogStatus.PASS, "Dashboard 'Active' count matches to total records displayed in Grid.");
			test.log(LogStatus.PASS, "Dashboard 'Active' count = "+active+" | Total records in Grid = "+total);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Dashboard 'Active' count matches doesn't to total records displayed in Grid.");
			test.log(LogStatus.FAIL, "Dashboard 'Active' count = "+active+" | Total records in Grid = "+total);
		}
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(2000,0)");				//Scrolling up window by 2000 px.
		
	    LiPerformerPOM.clickAction(driver).click();					//Clicking on first Action button.
		
		Thread.sleep(700);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
		
		if(type.equalsIgnoreCase("Internal"))
		{
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown(driver)));
			Select status = new Select(OverduePOM.selectInternalDropdown(driver));	//Selecting Status dropdown box.
			status.selectByIndex(1);									//Selecting 2nd value from dropdown.
		}
		else
		{
			wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown(driver)));
			Select status = new Select(OverduePOM.selectStatutoryDropdown(driver));	//Selecting Status dropdown box.
			status.selectByIndex(1);									//Selecting 2nd value from dropdown.
		}
		
		progress(driver);
		
		try
		{
			Thread.sleep(500);
			if(type.equalsIgnoreCase("Internal"))
			{
				LiPerformerPOM.clickComplDocInternal(driver).sendKeys("www.google.com");	//Providing Compliance Document link.
			}
			else
			{
				LiPerformerPOM.clickComplDoc(driver).sendKeys("www.google.com");	//Providing Compliance Document link.
			}
			Thread.sleep(500);
			LiPerformerPOM.clickComplDocAddButton(driver).click();				//Clicking on 'Add Link' button
			Thread.sleep(500);
			js.executeScript("arguments[0].scrollIntoView();", OverduePOM.clickComplianceSubmit(driver));
		}
		catch(Exception e)
		{
			
		}
		
		try
		{
			Thread.sleep(500);
			if(type.equalsIgnoreCase("Internal"))
			{
				String workingDir = System.getProperty("user.dir");
				OverduePOM.fileUploadInternal(driver).sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button. (Internal)
				Thread.sleep(1000);
			}
			else
			{
				String workingDir = System.getProperty("user.dir");
				OverduePOM.fileUploadStatutory(driver).sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button.
				Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{
			
		}
		
		Thread.sleep(500);
		if(type.equalsIgnoreCase("Internal"))
		{
			OverduePOM.selectDateInternal(driver).click();				//Clicking on Date text box
		}
		else
		{
			OverduePOM.selectDateStatutory(driver).click();				//Clicking on Date text box
		}
		Thread.sleep(300);
		OverduePOM.selectLastMonth(driver).click();					//CLicking on Last month arrow.
		Thread.sleep(300);
		OverduePOM.selectDate2(driver).click();						//Clicking on date at third row and second column
		
		Thread.sleep(500);
		if(type.equalsIgnoreCase("Internal"))
		{
			OverduePOM.clickInternalRemark(driver).sendKeys("Automation Remark");
		}
		else
		{
			OverduePOM.remark(driver).sendKeys("Automation Remark");
		}
		
		Thread.sleep(500);
		OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.
		
		Thread.sleep(700);
		if(type.equalsIgnoreCase("Statutory"))
		{
			js.executeScript("window.scrollBy(0,-2000)");
			//js.executeScript("arguments[0].scrollIntoView();", LiPerformerPOM.readMessage(driver));
			wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.readMessage(driver)));
			
			Thread.sleep(300);
			String msg = LiPerformerPOM.readMessage(driver).getText();
			if(msg.equalsIgnoreCase("Saved Sucessfully."))
			{
				test.log(LogStatus.PASS, "Message displayed - "+msg);
			}
			else
			{
				test.log(LogStatus.INFO, "Message displayed - "+msg);
			}
		}
		
		driver.switchTo().parentFrame();
		if(type.equalsIgnoreCase("Statutory"))
		{
			Thread.sleep(500);
			LiPerformerPOM.clickClose(driver).click();				//Clicking on Close (Cross)
		}
		
		progress(driver);
		
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
		int active1 = Integer.parseInt(MethodPOM.clickActive(driver).getText());	//Reading Active count.
		int pending1 = Integer.parseInt(MethodPOM.clickActive(driver).getText());
		if(active1 < active)
		{
			//test.log(LogStatus.PASS, "Dashboard 'Active' count decreased.");
			test.log(LogStatus.PASS, "Old Count = "+active+" | New Count = "+active1);
		}
		else
		{
			//test.log(LogStatus.FAIL, "Dashboard 'Active' count doesn't decreased.");
			test.log(LogStatus.FAIL, "Old Count = "+active+" | New Count = "+active1);
		}
		
		if(pending1 > pending)
		{
			//test.log(LogStatus.PASS, "Dashboard 'Pending Review' count increased.");
			test.log(LogStatus.PASS, "Old Count = "+pending+" | New Count = "+pending1);
		}
		else
		{
		//test.log(LogStatus.FAIL, "Dashboard 'Pending Review' count doesn't increased.");
			test.log(LogStatus.FAIL, "Old Count = "+pending+" | New Count = "+pending1);
		}
		*/
	}
	
	
	public static void AppliedCount(WebDriver driver, ExtentTest test, String type) throws InterruptedException
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
				Thread.sleep(5000);
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
		test.log(LogStatus.PASS, "License Overview Details Successfully.");
		Thread.sleep(3000);
		MethodPOM.ClickCloseOverview(driver).click();
		
		LiPerformerPOM.editlicenseicon(driver).click();
		Thread.sleep(7000);
		licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
		Thread.sleep(5000);
		licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("Fix-1");	
		Thread.sleep(3000);
		licenseManagement.licmgmtPOM.LicenseNo(driver).clear();
		Thread.sleep(3000);
		licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("to Check update license");
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
        test.log(LogStatus.PASS,"License Details Updated Successfully." );
        
          Thread.sleep(5000);
          
          licmgmtPOM.editlicenseclose(driver).click();
          Thread.sleep(300);
          
         MethodPOM.clickMyDashboard(driver).click();
         Thread.sleep(1000);
      //  MethodPOM.clickApplied(driver).click();
       // Thread.sleep(5000);
		//LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
		
		progress(driver);
		
		Thread.sleep(500);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		
		//licenseReviewer.LiReMethodsPOM.perform(driver, test);		//Calling perform method of Reviewer.
		
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
		LiPerformerPOM.LicenseNo(driver).sendKeys("20-1");
		Thread.sleep(500);
		LiPerformerPOM.Licensetitle(driver).sendKeys("Licetetse234");
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
		LiPerformerPOM.UploadDocument(driver).sendKeys(workingDir+"//Reports//LicenseCompanyadmin(Statutory).html");	//uploading new file		
		Thread.sleep(500);
	   
		}
			
		//	Thread.sleep(500);
			//LiPerformerPOM.clickComplDoc(driver).clear();
			//LiPerformerPOM.clickComplDoc(driver).sendKeys("www.google.com");	//Providing compliance document link.
		
		
		
	//	Thread.sleep(300);
		OverduePOM.AppliedSubmit(driver).click();			//Clicking on 'Submit' button.
		/*try
		{
			Thread.sleep(500);
			driver.switchTo().alert().dismiss();
		}
		catch(Exception e)
		{
			
		}
		*/
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
				test.log(LogStatus.PASS, "Message Displayed = "+msg);
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
		driver.switchTo().parentFrame();
		Thread.sleep(5000);
		LiPerformerPOM.clickClose(driver).click();				//Clicking on Close (Cross)
		
		progress(driver);
		
		Thread.sleep(500);
		//wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard(driver)));
		OverduePOM.clickDashboard(driver).click();
		
		if(type.equalsIgnoreCase("Internal"))			//Opening 'Internal' Dashboard
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
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickActive(driver)));
		int applied1 = Integer.parseInt(LiPerformerPOM.clickApplied(driver).getText());	//Reading Active count.
		if(applied1 < applied)
		{
			test.log(LogStatus.PASS, "Dashboard 'Applied' count decreased.");
			test.log(LogStatus.INFO, "Old Count = "+applied+". New Count = "+applied1);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Applied' count doesn't decreased.");
			test.log(LogStatus.INFO, "Old Count = "+applied+". New Count = "+applied1);
		}
		
	}

	
	public static void ExpiringCount(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		progress(driver);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring(driver)));
		String Expiring=MethodPOM.clickExpiring(driver).getText();
		
	     int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.
		
		LiPerformerPOM.clickExpiring(driver).click();						//Clicking on 'Expiring'
		   Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			String item1 = MethodPOM.clickReadExpired(driver).getText();	//Reading total items String value
			  if(!item1.equalsIgnoreCase("No items to display"))
			  {
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
		        
		        //  MethodPOM.clickExpiring(driver).click();	
		          
		         // Thread.sleep(3000);
				//LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
				
			//	progress(driver);
				
				//Thread.sleep(500);
			
				
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
						test.log(LogStatus.FAIL, "Message Displayed = "+msg);
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
			  else
			  {
				     
					test.log(LogStatus.PASS,"No Record Found");
					MethodPOM.clickMyDashboard(driver).click();
				  }
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
	}
	public static void ExpiredCount(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{		
		/*WebDriverWait wait = new WebDriverWait(driver, 20);
		
		progress(driver);
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired(driver)));
		int expired = Integer.parseInt(LiPerformerPOM.clickExpired(driver).getText());	//Reading Expiring count.
		
		LiPerformerPOM.clickExpired(driver).click();						//Clicking on 'Expiring'
		
		progress(driver);
		
		Thread.sleep(300);
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable(driver)));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
		
		int total = Integer.parseInt(OverduePOM.readReminder(driver).getText());
		if(expired == total)*/
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
				 Thread.sleep(5000);
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
				test.log(LogStatus.PASS, " License Overview Details Successfully");
				Thread.sleep(3000);
				MethodPOM.ClickCloseOverview(driver).click();
				Thread.sleep(3000);
				LiPerformerPOM.editlicenseicon(driver).click();
				Thread.sleep(7000);
				//licenseManagement.licmgmtPOM.LicenseTitle(driver).clear();
				Thread.sleep(5000);
				licenseManagement.licmgmtPOM.LicenseTitle(driver).sendKeys("Expired Update License");	
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
		         
		    //   Thread.sleep(3000);
		    //   MethodPOM.clickExpired(driver).click();
		          
				
	/*	Thread.sleep(5000);
		//LiPerformerPOM.clickAction(driver).click();					//Clicking on first action button.
		
		progress(driver);
		
		Thread.sleep(500);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
		
	/*	if(type.equalsIgnoreCase("Internal"))
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
			LiPerformerPOM.clickClose(driver).click();				//Clicking on Close (Cross)
			driver.navigate().refresh();
			MethodPOM.clickMyDashboard(driver).click();
		}
		
		//progress(driver);
	/*	Thread.sleep(4000);
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
	
	}

	
	public static void progress(WebDriver driver) throws InterruptedException
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
		
	}
	
	 public static void LicenseExpiredOnStatutory(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	   {
		   Thread.sleep(3000);
		   MethodPOM.ClickMaximizeLicenseExpiredOn(driver).click();
		   test.log(LogStatus.PASS, "Expired Maximize Button Working Successfully");
		   Thread.sleep(3000);
		   JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
	        MethodPOM.ClickExportExpiredOn1(driver).click();
	        test.log(LogStatus.PASS, "Dashboard ExpiredOn License List Downloaded Successfully");
	        Thread.sleep(2000);
			
		   LiPerformerPOM.perexpiredon(driver).click();
		   Thread.sleep(2000);
		   test.log(LogStatus.PASS, "Expired On ShowMore Link working Successfully");
		   Thread.sleep(5000);
		   WebDriverWait wait = new WebDriverWait(driver, 40);
		   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showLicenseDetails"));
		   String NoRecord = MethodPOM.Norecord(driver).getText();
		   if(!NoRecord.equalsIgnoreCase("No items to display")) 
		   {
		   
		   MethodPOM.ClickExportExpiredOn(driver).click();
			test.log(LogStatus.PASS, "Expired License List Downloaded Sucessfully");
			Thread.sleep(5000);
			MethodPOM.ExpiredOnLictype(driver).click();
			MethodPOM.searchExpiredOnLictype(driver).sendKeys("DG-SET",Keys.ENTER);
			
			MethodPOM.Clearfilter(driver).click();
			test.log(LogStatus.PASS, "Clear Filter Button Working  Successfully");
			
	    
			/*Thread.sleep(7000);
		    licenseManagement.licmgmtPOM.lictype(driver).click();
			Thread.sleep(7000);
		    licenseManagement.licmgmtPOM.lictype1(driver).click();
			Thread.sleep(7000);
			MethodPOM.Clearfilter(driver).click();
			*/
			 Thread.sleep(2000);
			MethodPOM.ClickOverviewExpiredOn(driver).click();
			test.log(LogStatus.PASS, "Expired OverView License Displayed");
			 Thread.sleep(3000);
	             MethodPOM.clickBystatuscloseoverview(driver).click();
				 Thread.sleep(2000);
				 LiPerformerPOM.EntityLocation(driver).click();
					Thread.sleep(500);
					LiPerformerPOM.EntityLocationExpand(driver).click();
					Thread.sleep(500);
					//LiPerformerPOM.EntityLocationExpand(driver).click();
					//Thread.sleep(500);
				   Thread.sleep(500);
				   LiPerformerPOM.Entitysubexpand(driver).click();
				   Thread.sleep(500);
				   String locationtext1 =LiPerformerPOM.locget(driver).getText();
				   LiPerformerPOM.locget(driver).click();
				   Thread.sleep(3000);
				   LiPerformerPOM.clicklictypet(driver).click();
				   Thread.sleep(500);
				   String LicenseType1 =LiPerformerPOM.Licensetype(driver).getText();
				   Thread.sleep(5000);
				   LiPerformerPOM.Licensetype(driver).click();
				   Thread.sleep(5000);
				  // LiPerformerPOM.Statustext(driver).click();
				  // Thread.sleep(5000);
				  
				    List<String> li=new ArrayList<String>();
				    
				    li.add(locationtext1);
				    li.add(LicenseType1);
				 
				    Thread.sleep(3000);
				    
					List<String> filter=new ArrayList<String>();	
					filter.add("Location");
					filter.add("LicenseType");	
					
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,150)");	
					Thread.sleep(3000);

					CFOcountPOM.readTotalItems1(driver).click();					//Clicking on Text of total items just to scroll down.
					String s = CFOcountPOM.readTotalItems1(driver).getText();
					Thread.sleep(2000);

					if(!s.equalsIgnoreCase("No items to display")) 
					{
					Thread.sleep(5000);

					List<WebElement> entitycol=driver.findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[1]"));
					
					List<WebElement> liccol=driver.findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
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
							test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
							System.out.println(filter.get(i)+" : "+Pas);
				 }
					 text.clear();
					pass.clear();
					fail.clear();
					raw.clear();
					MethodPOM.Clearfilter(driver).click();
					test.log(LogStatus.PASS, "Clear Filter Button Working  Successfully");
					
					}
					
				
					}
		   else
		   {
			   driver.switchTo().parentFrame();
				 MethodPOM.clickCloseGraphPopup(driver).click();
				 Thread.sleep(3000);
				  test.log(LogStatus.PASS, "selected Filter No Record Found ");
		   }
				
		   }
		   }
		  
	  public static void LicenseExpiringOnStatutoryper(WebDriver driver, ExtentTest test, String type) throws InterruptedException, IOException
	   {
		   Thread.sleep(3000);
		   LiPerformerPOM.Expiringmaxmize(driver).click();
		   test.log(LogStatus.PASS, "Expiring On Maximize Button Working Successfully");
		   Thread.sleep(3000);
		     String item1 = LiPerformerPOM.NoRecord(driver).getText();	//Reading total items String value
			 if(!item1.equalsIgnoreCase("No Records Found"))
		  {
		   JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			MethodPOM.DashExpiringOnExport(driver).click();
			test.log(LogStatus.PASS, "Dashboard Expiring License Download Successfully");
			Thread.sleep(7000);
		   LiPerformerPOM.Expiringshowmore(driver).click();
		   Thread.sleep(7000);
		   test.log(LogStatus.PASS, "Expired On showMore Link Working Successfully");
		   WebDriverWait wait = new WebDriverWait(driver, 40);
		   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showLicenseDetails"));
	
		   Thread.sleep(7000);
		   MethodPOM.ClickExportExpiredOn(driver).click();
					test.log(LogStatus.PASS, "Expiring On  License List Downloaded Sucessfully");
					Thread.sleep(5000);
					MethodPOM.ExpiredOnLictype(driver).click();
					MethodPOM.searchExpiredOnLictype(driver).sendKeys("DG-SET",Keys.ENTER);
					
					MethodPOM.Clearfilter(driver).click();
					test.log(LogStatus.PASS, "Clear Filter Button Working  Successfully");
					

			
		  /* int flag = 0;
			try
			{
				wait.until(ExpectedConditions.visibilityOf(MethodPOM.checkTable1(driver)));	//Waiting until records table gets visible.
				flag = 1;
			}
			catch(Exception e)
			{
				
			}
			
			if(flag == 1)
			{
				js1.executeScript("window.scrollBy(0,1000)");				//Scrolling down window by 2000 px.
				
				Thread.sleep(700);
				String item = MethodPOM.clickReadActive(driver).getText();
				String[] bits = item.split(" ");								//Splitting the String
				String LicenseCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
				int count = 0;
				if(LicenseCount.equalsIgnoreCase("to"))
				{
					Thread.sleep(2500);
					item = MethodPOM.clickReadActive(driver).getText();
					bits = item.split(" ");										//Splitting the String
					LicenseCount = bits[bits.length - 2];					//Getting the second last word (total number of users)
				}
				count = Integer.parseInt(LicenseCount);
				
				File dir = new File("C:\\Users\\deepalid\\Downloads");
				File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
				
				js1.executeScript("window.scrollBy(0,-2000)");				//Scrolling down window by 2000 px.
				Thread.sleep(500);
				MethodPOM.ClickExportExpiredOn(driver).click();						//Clicking on Excel Image.
				
				Thread.sleep(3000);
				File dir1 = new File("C:\\Users\\deepalid\\Downloads");
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
						test.log(LogStatus.PASS, "Total records from grid = "+count+" | Total records in Excel Sheet = "+SheetRecords);
					}
					else
					{
						//test.log(LogStatus.FAIL, "Count of records displayed from grid doesn't matches to number records in Excel Sheet.");
						test.log(LogStatus.FAIL, "Total records from grid = "+count+" | Total records in Excel Sheet = "+SheetRecords);
					}
				}
				else
				{
					test.log(LogStatus.FAIL, type+" :- File doesn't downloaded Successfully.");
				}
			}
			else
			{
				test.log(LogStatus.PASS, type+" :- Records not displayed (available). Excel sheet didn't downloaded");
			}
			*/
					 Thread.sleep(2000);
						MethodPOM.ClickOverviewExpiredOn(driver).click();
						test.log(LogStatus.PASS, "License Overview Button Working Successfully.");
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
				 test.log(LogStatus.PASS,"No Record Found");
					MethodPOM.clickMyDashboard(driver).click();
			 }
		   
	   }
	  public static void LicenseExpiringOnInternalper(WebDriver driver, ExtentTest test, String type) throws InterruptedException, IOException
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
			/*By locator = By.xpath("//*[@id='ContentPlaceHolder1_lnkShowDetailLicense']");
			

			wait1.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
		//   LiPerformerPOM.Expiringshowmore(driver).click();
		   Thread.sleep(7000);
		   test.log(LogStatus.PASS, "Expired On showMore Link Working Successfully");
		   WebDriverWait wait = new WebDriverWait(driver, 40);
			Thread.sleep(5000);
		   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showLicenseDetails"));
		   Thread.sleep(3000);
		   js1.executeScript("window.scroll(0,500)");
		   String NoRecord = LiReviewerPOM.reNorecord(driver).getText();
		   if(!NoRecord.equalsIgnoreCase("No items to display")) 
		   {
		   MethodPOM.ClickExportExpiredOn(driver).click();
			test.log(LogStatus.PASS, "Expired On License List Downloaded Successfully");
			  Thread.sleep(3000);
			  
			  LiPerformerPOM.lictype(driver).click();
			  Thread.sleep(500);
			  LiPerformerPOM.selectlic1(driver).click();
			Thread.sleep(3000);
		   LiPerformerPOM.clearbtn(driver).click();
		   test.log(LogStatus.PASS, "Expired On License Popup Clear filter Button Working Successfully");
		   
		   Thread.sleep(3000);
			MethodPOM.ClickOverviewExpiredOn(driver).click();
			test.log(LogStatus.PASS, "Expired OverView License Displayed");
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
		   }*/
		   
	   }
	public static void Documents(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		progress(driver);
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired(driver)));
		
		LiPerformerPOM.clickMyDocuments(driver).click();		//Clicking on 'My Documents'
		Thread.sleep(3000);
		LiPerformerPOM.clickMyDocumentsMenu(driver).click();	//Clicking on 'My Documents'
		
		progress(driver);
		
		wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1(driver)));	//Waiting until records table gets visible.
		
		if(type.equalsIgnoreCase("Internal"))
		{
			LiPerformerPOM.clickType2(driver).click();			//Clicking on 'Type' drop down.
			Thread.sleep(5000);
			LiPerformerPOM.selectInternal(driver).click();//Selecting 'Internal' option.
			Thread.sleep(1000);
			progress(driver);
		}
		
		Thread.sleep(500);
		elementsList = LiPerformerPOM.clickDownload1(driver);

		File dir = new File("C:\\Users\\deepalid\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
		Thread.sleep(5000);
		elementsList.get(1).click();//Clicking on first 'Download' link.
		Thread.sleep(3000);
        
		elementsList= LiPerformerPOM.clickviewLiceDocument(driver);
		elementsList.get(1).click(); 
		Thread.sleep(7000);
		//driver.switchTo().frame("Freamshow");
  //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Freamshow"));
		
		By locator = By.xpath("//*[@id='divOverView']/div/div/div[1]/button");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		WebElement ViewButton = driver.findElement(locator);	
		Thread.sleep(3000);
	
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "File Viewed successfully.");
	//	LiPerformerPOM.Clickviewclose(driver).click();
		
		
		Thread.sleep(3000);
		File dir1 = new File("C:\\Users\\deepalid\\Downloads");
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
		if(type.equalsIgnoreCase("Internal"))
		{
			LiPerformerPOM.Clicklictypedropdown(driver).click();
			Thread.sleep(3000);
			LiPerformerPOM.searchlic1in(driver).click();
		}else
		{
			LiPerformerPOM.Clicklictypedropdown(driver).click();
			Thread.sleep(3000);
		    LiPerformerPOM.searchlic1(driver).click();
		}
		
		
	    Thread.sleep(3000);
	    test.log(LogStatus.PASS, "selected License Type Cleared");
		//LiPerformerPOM.selectlic(driver).click();
		LiPerformerPOM.clearbtn(driver).click();
		Thread.sleep(3000);
	//	wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard(driver)));
		//wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard(driver)));
		LiPerformerPOM.Multicheckdoc1(driver).click();
		Thread.sleep(3000);
		LiPerformerPOM.Multicheckdoc2(driver).click();
		
		
		File dir2 = new File("C:\\Users\\deepalid\\Downloads");
		File[] dirContents2 = dir2.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(500);
		LiPerformerPOM.MultiDownload(driver).click();		//Exporting (Downloading) file
		
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
		
     /*	LiPerformerPOM.Sharebutton(driver).click();
     	Thread.sleep(3000);
     	 wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("OverViews1"));
    	LiPerformerPOM.Sharesave(driver).click();
    	Thread.sleep(1000);
    	String msg = LiPerformerPOM.Sharevaliedmsg(driver).getText();
		
		if(msg.equalsIgnoreCase("Please Enter Email."))
		{

			test.log(LogStatus.PASS, "Validation Message displayed = "+msg);
		}
		else
		{
			test.log(LogStatus.FAIL, "Message Displayed = "+msg);
		}
		
     	
     	Thread.sleep(1000);
     	LiPerformerPOM.shareemail(driver).sendKeys("deepali@tlregtech.in");
     	Thread.sleep(3000);
     	LiPerformerPOM.ShareContactNo(driver).sendKeys("86262040232");
     	Thread.sleep(3000);
     	LiPerformerPOM.Sharesave(driver).click();
     	test.log(LogStatus.PASS, "Document shared Successfully.");
     	Thread.sleep(3000);
     	LiPerformerPOM.clickUnshare(driver).click();
     	 // Switching to Alert       
        Alert alert = driver.switchTo().alert();
       
        // Capturing alert message.   
        String alertMessage= driver.switchTo().alert().getText();
       
        Thread.sleep(3000);
    //    test.log(LogStatus.PASS, alertMessage);
       
        // Displaying alert message
        System.out.println(alertMessage);
       
        // Accepting alert
        alert.accept();
        test.log(LogStatus.PASS,"Document unshared Successfully." );
        Thread.sleep(1000);
        LiPerformerPOM.ShareClose(driver).click();
        test.log(LogStatus.PASS,"Share Popup Close Button Working Successfully" );
        Thread.sleep(3000);
    	//LiPerformerPOM.clearbtn(driver).click();
        driver.switchTo().parentFrame();
        */
		String PerformerColumn = LiPerformerPOM.PerformerColumn(driver).getText();
		   if(PerformerColumn.equalsIgnoreCase("Performer")) 
		   {
			   
				test.log(LogStatus.PASS, "In Grid Performer Column Displayed.");
		   }
		   else
		   {
			   test.log(LogStatus.FAIL,"In Grid Performer Column Not Displayed.");
		   }
		   Thread.sleep(3000);
		 String Reviewercolumn = LiPerformerPOM.ReviewerColumn(driver).getText();
		   if(Reviewercolumn.equalsIgnoreCase("Reviewer")) 
		   {
			   
				test.log(LogStatus.PASS, "In Grid Reviewer Column Displayed.");
		   }
		   else
		   {
			   test.log(LogStatus.FAIL,"In Grid Reviewer Column Not Displayed.");
		   }
        Thread.sleep(3000);
        
        MethodPOM.clickMyDashboard(driver).click();
	}
	
	public static void Reports(WebDriver driver, ExtentTest test, String type) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired(driver)));
		
		LiPerformerPOM.clickMyReport(driver).click();		//Clicking on 'My Reports'
		Thread.sleep(5000);
		progress(driver);
	 	wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1(driver)));	//Waiting until records table gets visible.
			   Thread.sleep(3000);
	     
		 String Entity =LiPerformerPOM.Entitycolumn(driver).getText();
		   if(LiPerformerPOM.Entitycolumn(driver).isDisplayed())
		   {
			   
				test.log(LogStatus.PASS, "In grid Entity column displayed.");
		   }
		   else
		   {
			   test.log(LogStatus.FAIL,"In Grid Entity Column Not Displayed");
		   }
		   Thread.sleep(3000);
		   
		   String Entityname =LiPerformerPOM.Entityname(driver).getText();
		   if(LiPerformerPOM.Entityname(driver).isDisplayed())
		   {
			   
				test.log(LogStatus.PASS, "In Entity Column Entity Name Displayed.");
		   }
		   else
		   {
			   test.log(LogStatus.FAIL,"In Entity Column Entity Name Not Displayed.");
		   }
		   Thread.sleep(5000);

		  
		// String Noitemdisplay = LiPerformerPOM.Noitemdisplay(driver).getText();
		 //  if(!Noitemdisplay.equalsIgnoreCase("No items to display")) 
		{
			   
		if(type.equalsIgnoreCase("Internal"))
		{
			LiPerformerPOM.clickType2(driver).click();			//Clicking on 'Type' drop down.
			Thread.sleep(500);
			LiPerformerPOM.selectInternal(driver).click();//Selecting 'Internal' option.
			Thread.sleep(1000);
			LiPerformerPOM.Reportapply(driver).click();
			progress(driver);
			Thread.sleep(5000);
			//driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]")).click();
			//Thread.sleep(5000);
			//test.log(LogStatus.PASS," License Overview  Button Working Successfully");

		}
		  
		//	driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]")).click();
			//test.log(LogStatus.PASS," License Overview  Button Working Successfully");
		   //   Thread.sleep(3000);
		   //  driver.findElement(By.xpath("//*[@id='divShowReminderDialog']/div/div/div[1]/button")).click();
		   
 
		
		LiReviewerPOM.Addcolumn(driver).click();
		Thread.sleep(3000);
	     LiReviewerPOM.clickColumn(driver).click();
	     Thread.sleep(300);
	     LiReviewerPOM.addnomineecol(driver).click();
	     Thread.sleep(300);
	     String Nominee =LiReviewerPOM.Nomineecolumn(driver).getText();
		   if(LiReviewerPOM.Nomineecolumn(driver).isDisplayed())
		   {
			   
				test.log(LogStatus.PASS, "In grid Nominee column displayed.");
		   }
		   else
		   {
			   test.log(LogStatus.FAIL,"In Grid Nominee Column Not Displayed");
		   }

        driver.findElement(By.xpath("//*[@id='exportReport']")).click();
		
		test.log(LogStatus.PASS," License Report  Downloaded Successfully.");
		
		Thread.sleep(7000);
		driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]")).click();
	
		test.log(LogStatus.PASS," License Overview  Button Working Successfully");
	      Thread.sleep(3000);
	     driver.findElement(By.xpath("//*[@id='divShowReminderDialog']/div/div/div[1]/button")).click();
		
		CheckReports(driver, test, 1, "Active");
		 Thread.sleep(1000);
		CheckReports(driver, test, 2, "Expired");
		 Thread.sleep(1000);
		CheckReports(driver, test, 3, "Expiring");
		 Thread.sleep(1000);
		CheckReports(driver, test, 4, "Applied");
		 Thread.sleep(1000);
		CheckReports(driver, test, 5, "Applied but Pending for Renewal");
		 Thread.sleep(1000);
		CheckReports(driver, test, 6, "Renewed");
		 Thread.sleep(1000);
		CheckReports(driver, test, 7, "Rejected");
		 Thread.sleep(1000);
		CheckReports(driver, test, 8, "Registered");
		 Thread.sleep(1000);
		CheckReports(driver, test, 9, "Registered & Renewal Filed");
		 Thread.sleep(1000);
		CheckReports(driver, test, 10, "Validity Expired");
		 Thread.sleep(1000);
		CheckReports(driver, test, 11, "Terminate");
		
		Thread.sleep(500);
		
		LiPerformerPOM.clickMyReport(driver).click();		//Clicking on 'My Reports'
	Thread.sleep(7000);
	LiPerformerPOM.EntityLocation(driver).click();
	Thread.sleep(500);
	LiPerformerPOM.EntityLocationExpand(driver).click();
	Thread.sleep(500);
	//LiPerformerPOM.EntityLocationExpand(driver).click();
	//Thread.sleep(500);
   Thread.sleep(500);
   LiPerformerPOM.Entitysubexpand(driver).click();
   Thread.sleep(500);
   String locationtext1 =LiPerformerPOM.checkloc(driver).getText();
   LiPerformerPOM.checkloc(driver).click();
   Thread.sleep(3000);
   LiPerformerPOM.ClickLictype(driver).click();
   Thread.sleep(500);
   String LicenseType1 =LiPerformerPOM.Licensetype(driver).getText();
   Thread.sleep(5000);
   LiPerformerPOM.Licensetype(driver).click();
   Thread.sleep(5000);
  // LiPerformerPOM.Statustext(driver).click();
  // Thread.sleep(5000);
   LiPerformerPOM.reportapplybtn(driver).click();
   Thread.sleep(5000);

    List<String> li=new ArrayList<String>();
    
    li.add(locationtext1);
    li.add(LicenseType1);
 
    Thread.sleep(3000);
    
	List<String> filter=new ArrayList<String>();	
	filter.add("Location");
	filter.add("LicenseType");	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);

	CFOcountPOM.readTotalItems1(driver).click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItems1(driver).getText();
	Thread.sleep(2000);

	if(!s.equalsIgnoreCase("No items to display")) 
	{
	Thread.sleep(5000);

	List<WebElement> entitycol=driver.findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
	
	List<WebElement> liccol=driver.findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[3]"));
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

	Boolean  btnclear =LiPerformerPOM.clearbtn(driver).isEnabled();
	if(btnclear) 
	{
	LiPerformerPOM.clearbtn(driver).click();
	test.log(LogStatus.PASS,"Clear Button Working Successfully");
	}
	else
	{
	test.log(LogStatus.FAIL,"Clear Button Not Clickable");
	}

		   }
	
	
	//  wait.until(ExpectedConditions.elementToBeClickable(MethodPOM.clickMyDashboard(driver)));
		
	//OverduePOM.clickDashboard(driver).click();
	
	}
	

	
	public static void CheckReports(WebDriver driver, ExtentTest test, int status, String type) throws InterruptedException, IOException
	{		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)");
		
		LiPerformerPOM.clickStatus1(driver).click();			//Clicking on 'Status' drop down.
		Thread.sleep(5000);
		elementsList = LiPerformerPOM.selectStatus1(driver);	//Selecting Status.
		Thread.sleep(3000);
		elementsList.get(status).click();
		
		LiPerformerPOM.reportapplybtn(driver).click();
		
		Thread.sleep(3000);
		
		Thread.sleep(1000);
		progress(driver);
		
		int flag = 0;
		try
		{
			wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1(driver)));	//Waiting until records table gets visible.
			flag = 1;
		}
		catch(Exception e)
		{
			
		}
		
		if(flag == 1)
		{
			js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
			
			  Thread.sleep(10000);
				CFOcountPOM.readTotalItems1(driver).click();
				
				String item1 = CFOcountPOM.readTotalItems1(driver).getText();
				//String NoRecord = LiReviewerPOM.reNorecord(driver).getText();
				 if(!item1.equalsIgnoreCase("No items to display")) 
				 {
				String[] bits1 = item1.split(" ");								//Splitting the String
				String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
				int count2 = Integer.parseInt(compliancesCount1);
				String NoRecord = LiReviewerPOM.reNorecord(driver).getText();
				   if(!NoRecord.equalsIgnoreCase("No items to display")) 
				 {
					   try
						{
							performerPOM.clickExcelReport(driver).sendKeys(Keys.PAGE_DOWN);
						}
						catch(Exception e)
						{
							
						}
						js.executeScript("window.scrollBy(0,1000)");
						
					
						Thread.sleep(100);
						File dir = new File("C://Users//deepalid//Downloads");
						File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
						
						Thread.sleep(500);
						CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_UP);
						Thread.sleep(250);
						performerPOM.clickExcelReport(driver).click();					//Clicking on 'Excel Report' image.
						
						
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
			/*Thread.sleep(700);
			String item = LiPerformerPOM.readTotalRecords1(driver).getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count = 0;
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(2500);
				item = CFOcountPOM.readTotalItems1(driver).getText();
				bits = item.split(" ");										//Splitting the String
				compliancesCount = bits[bits.length - 2];					//Getting the second last word (total number of users)
			}
			count = Integer.parseInt(compliancesCount);
			
			File dir = new File("C://Users//dipali//Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			
			js.executeScript("window.scrollBy(0,-2000)");				//Scrolling down window by 2000 px.
			Thread.sleep(500);
			LiPerformerPOM.clickExcel(driver).click();						//Clicking on Excel Image.
			
			Thread.sleep(5000);
			File dir1 = new File("C://Users//dipali//Downloads");
			File[] allFilesNew = dir1.listFiles();	
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, "File downloaded successfully.");
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified());	//If allFilesNew[i] file is having large/latest time time of update then latest
                                                                                             //Counting number of files in directory after download
			
			       Thread.sleep(100);
					fis = new FileInputStream(lastModifiedFile);
					workbook = new XSSFWorkbook(fis);
					sheet = workbook.getSheetAt(0);		
				
					int no = sheet.getLastRowNum();
					Row row = sheet.getRow(no);
					Cell c1 = row.getCell(0);
					int records =(int) c1.getNumericCellValue();
					
					fis.close();
					
					if(count == records)
					{
						//test.log(LogStatus.PASS, "Count of records displayed from grid matches to number records in Excel Sheet.");
						test.log(LogStatus.PASS, "Total records from grid = "+count+" | Total records in Excel Sheet = "+records);
					}
					else
					{
						//test.log(LogStatus.FAIL, "Notice=No of records from grid doesn't matches to no of records in Excel Sheet.");
						test.log(LogStatus.FAIL, "Total records from grid = "+count+" | Total records in Excel Sheet = "+records);
					}
			    }
			}
				
				else
				{
					test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
				}
			}
			
/*		File lastModifiedFile = allFilesNew[1];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			if(dirContents.length < allFilesNew.length)
			{
				test.log(LogStatus.PASS, type+" :- File Downloaded Successfully.");
				
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
				test.log(LogStatus.FAIL, type+" :- File doesn't Downloaded Successfully.");
			}
		}
		else
		{
			test.log(LogStatus.SKIP, type+" :- Records not displayed (available). Excel sheet didn't downloaded");
		}
		*/
	
	
	public static void PendingReview(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions action = new Actions(driver);
		
		progress(driver);
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickExpired(driver)));
		int pending = Integer.parseInt(LiPerformerPOM.clickPendingForReview(driver).getText());
		System.out.println("Pending = "+pending);
		
		LiPerformerPOM.clickPendingForReview(driver).click();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.checkTable(driver)));
		
		action.keyDown(Keys.CONTROL).sendKeys(Keys.PAGE_DOWN).perform();
		action.keyUp(Keys.CONTROL).perform();
		
		int total = Integer.parseInt(LiPerformerPOM.readTotalRecords(driver).getText());
		
		if(pending == total)
		{
			test.log(LogStatus.PASS, "Dashboard 'Pending For Review' count matches to Total no of Records. Dashboard count = "+pending+", Total Records count = "+total);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dashboard 'Pending For Review' count doesn't matches to Total no of Records. Dashboard count = "+pending+", Total Records count = "+total);
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
	}

	public static void LicenseExpiringOnStatutoryper1(WebDriver driver, ExtentTest test, String type) throws InterruptedException 
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
				test.log(LogStatus.PASS, "Expiring License Overview Details Successfully");
				Thread.sleep(3000);
				//MethodPOM.ClickCloseOverview(driver).click();
				
				//MethodPOM.clickMyDashboard(driver).click();

		
	}

	public static void RejectedCount(WebDriver driver, ExtentTest test, String type) throws InterruptedException 
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
				String item1 = MethodPOM.clickReadExpired(driver).getText();	//Reading total items String value
				  if(!item1.equalsIgnoreCase("No items to display"))
				  {
				Thread.sleep(5000);
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
					licenseManagement.licmgmtPOM.LicenseNo(driver).sendKeys("Reject Update Lice");
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
					
					progress(driver);
					
					Thread.sleep(500);
				//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
					
					if(type.equalsIgnoreCase("Internal"))
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
						 Thread.sleep(5000);
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
					Thread.sleep(3000);
					OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.
					
					Thread.sleep(1000);
					js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.
					
					Thread.sleep(3000);
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
					else
					{
						Thread.sleep(700);
						test.log(LogStatus.PASS,"No Record Found");
						MethodPOM.clickMyDashboard(driver).click();
					}
					
					}
					
		
	}
	  public static void TerminateLicense1(WebDriver driver, ExtentTest test, String type) throws InterruptedException
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
					
					progress(driver);
					
					Thread.sleep(500);
				//	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
		
					progress(driver);
					
					Thread.sleep(500);
					//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showdetails"));
					
					if(type.equalsIgnoreCase("Internal"))
					{
						WebDriverWait wait1= new WebDriverWait(driver, 5);
						wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
						LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
						
						
						Select drp = new Select(LiPerformerPOM.clickType(driver));
						drp.selectByIndex(1);
						CFOcountPOM.clickApply1(driver).click();	
						  Thread.sleep(3000);
						 
						LiPerformerPOM.terminatedPerformer(driver).click();	

						/*LiPerformerPOM.terAction(driver).click();						//Clicking on first action button.
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
						 Thread.sleep(5000);
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
	   
				
	   }

	public static void LicenseExpiredOnperInternal(WebDriver driver, ExtentTest test, String string) throws InterruptedException
	{
		 /*Thread.sleep(3000);
		  licenseCompanyadmin.MethodPOM.AllFilter(driver).click();
		   Thread.sleep(3000);
		   licenseCompanyadmin.MethodPOM.InternalFilter(driver).click();
		   
		   licenseCompanyadmin.MethodPOM.ClickApply(driver).click();*/
	   Thread.sleep(3000);
	   MethodPOM.ClickMaximizeLicenseExpiredOn(driver).click();
	   test.log(LogStatus.PASS, "Expired Maximize Button Working Successfully");
	 
	   Thread.sleep(3000);
	   JavascriptExecutor js1=(JavascriptExecutor) driver ;
		js1.executeScript("window.scroll(0,500)");
		Thread.sleep(500);
		 MethodPOM.ClickOnDashExpiredExport(driver).click();  
		 test.log(LogStatus.PASS, "Dashboard Expired On License List Downloaded Successfully");
		
		 MethodPOM.ClickShowMoreExpiredOnInternal(driver).click();
		 test.log(LogStatus.PASS, "Expired On showMore Link Working Successfully");
		 WebDriverWait wait = new WebDriverWait(driver, 40);
		   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("showLicenseDetails"));
		   Thread.sleep(5000);
		 String NoRecord = MethodPOM.Norecord(driver).getText();
		 
		   if(!NoRecord.equalsIgnoreCase("No items to display")) 
		   {
		   
		   MethodPOM.ClickExportExpiredOn(driver).click();
			test.log(LogStatus.PASS, "Expired License List Downloaded Successfully");
			Thread.sleep(5000);
			MethodPOM.ClickOverviewExpiredOn(driver).click();
	
	  test.log(LogStatus.PASS, " License Overview Details Successfully");
	  Thread.sleep(7000);
     MethodPOM.clickBystatuscloseoverview(driver).click();
		Thread.sleep(2000);
		
		  // Js.executeScript("window.scrollBy(500,0)");
	//	driver.switchTo().parentFrame();
		// MethodPOM.clickCloseGraphPopup(driver).click();
		// Thread.sleep(7000);
		
		 LiPerformerPOM.EntityLocation(driver).click();
			Thread.sleep(500);
			LiPerformerPOM.EntityLocationExpand(driver).click();
			Thread.sleep(500);
			//LiPerformerPOM.EntityLocationExpand(driver).click();
			//Thread.sleep(500);
		   Thread.sleep(500);
		   LiPerformerPOM.Entitysubexpand(driver).click();
		   Thread.sleep(500);
		   String locationtext1 =LiPerformerPOM.locget(driver).getText();
		   LiPerformerPOM.locget(driver).click();
		   Thread.sleep(3000);
		   LiPerformerPOM.clicklictypet(driver).click();
		   Thread.sleep(500);
		   String LicenseType1 =LiPerformerPOM.Licensetype(driver).getText();
		   Thread.sleep(5000);
		   LiPerformerPOM.Licensetype(driver).click();
		   Thread.sleep(5000);
		  // LiPerformerPOM.Statustext(driver).click();
		  // Thread.sleep(5000);
		  
		    List<String> li=new ArrayList<String>();
		    
		    li.add(locationtext1);
		    li.add(LicenseType1);
		 
		    Thread.sleep(3000);
		    
			List<String> filter=new ArrayList<String>();	
			filter.add("Location");
			filter.add("LicenseType");	
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,150)");	
			Thread.sleep(3000);

			CFOcountPOM.readTotalItems1(driver).click();					//Clicking on Text of total items just to scroll down.
			String s = CFOcountPOM.readTotalItems1(driver).getText();
			Thread.sleep(2000);

			if(!s.equalsIgnoreCase("No items to display")) 
			{
			Thread.sleep(5000);

			List<WebElement> entitycol=driver.findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[1]"));
			
			List<WebElement> liccol=driver.findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
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

Boolean  btnclear =LiPerformerPOM.clearbtn(driver).isEnabled();
if(btnclear) 
{
LiPerformerPOM.clearbtn(driver).click();
test.log(LogStatus.PASS,"Clear Button Working Successfully");
}
else
{
test.log(LogStatus.FAIL,"Clear Button Not Clickable");
}

		   }
 }

	

	public static void activelicenseperform(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
		String Active=MethodPOM.clickActive(driver).getText();
		
	     int Activelicense = Integer.parseInt(Active);	//Reading Active count.

	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
	     String pfr=LiPerformerPOM.PFRCount(driver).getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickActive(driver).click();					//Clicking on 'Active' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
			String item1 = MethodPOM.clickReadExpired(driver).getText();	//Reading total items String value
			  if(!item1.equalsIgnoreCase("No items to display"))
			  {
		/*	MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total)
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
	*/
	   
    Thread.sleep(3000);
    OverduePOM.ActiveAction(driver).click();					//Clicking on first action button.
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LiPerformerPOM.ShowFream(driver)));		
	js1.executeScript("window.scrollBy(0,1000)");
   Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown(driver)));
	Select status = new Select(OverduePOM.selectStatutoryDropdown(driver));	//Selecting Status dropdown box.
	status.selectByIndex(1);	
	 Thread.sleep(2000);
	 String workingDir = System.getProperty("user.dir");
   OverduePOM.PerformerDoc(driver).sendKeys(workingDir+"//Reports//LicenseCompanyadmin(Statutory).html");	//uploading new file	
   Thread.sleep(2000);
   js1.executeScript("window.scrollBy(0,1000)");
   Thread.sleep(2000);
	LiPerformerPOM.PerformDateclick(driver).click();
	Thread.sleep(1000);
	LiPerformerPOM.PerformDate(driver).click();
	Thread.sleep(5000);
	js1.executeScript("window.scrollBy(0,100)");

	//LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
	//js1.executeScript("window.scrollBy(0,300)");

Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(300);
OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.

Thread.sleep(1000);
js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.

Thread.sleep(300);
if(type.equalsIgnoreCase("Statutory"))
{
	
	Thread.sleep(500);
	js1.executeScript("window.scrollBy(2000,0)");	//Scrolling up window by 2000 px.
	test.log(LogStatus.PASS, "Save Sucessfully.");
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
	
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
	String Active1=MethodPOM.clickActive(driver).getText();
	
     int Activelicense1 = Integer.parseInt(Active1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
     String pfr1=LiPerformerPOM.PFRCount(driver).getText();
     int pfrlicense1 = Integer.parseInt(pfr1);	//Reading PendingForReview count.
     
     if(Activelicense>Activelicense1&&pfrlicense<pfrlicense1)
     {
    	 test.log(LogStatus.PASS, "Active Old Count = "+Activelicense+" | New Count = "+Activelicense1);
         test.log(LogStatus.PASS, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     else
     {
    	 test.log(LogStatus.FAIL, "Active Old Count = "+Activelicense+" | New Count = "+Activelicense1);
         test.log(LogStatus.FAIL, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
			  }
	
     else
     {
		      
			test.log(LogStatus.PASS,"No Record Found");
			MethodPOM.clickMyDashboard(driver).click();
    	 }
     }
	
	public static void Internalactivelicenseperform(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
		LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
		
		
		Select drp = new Select(LiPerformerPOM.clickType(driver));
		drp.selectByIndex(1);
		CFOcountPOM.clickApply1(driver).click();	
		  Thread.sleep(3000);
		
	
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
		String Active=MethodPOM.clickActive(driver).getText();
		
	     int Activelicense = Integer.parseInt(Active);	//Reading Active count.

	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
	     String pfr=LiPerformerPOM.PFRCount(driver).getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickActive(driver).click();					//Clicking on 'Active' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
		/*	MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total)
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
	*/
	   
    Thread.sleep(3000);
    OverduePOM.ActiveAction(driver).click();					//Clicking on first action button.
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));
	js1.executeScript("window.scrollBy(0,3000)");
	 Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown(driver)));
	Select status = new Select(OverduePOM.selectInternalDropdown(driver));	//Selecting Status dropdown box.
	status.selectByIndex(2);	
	 Thread.sleep(3000);
	 String workingDir = System.getProperty("user.dir");
		OverduePOM.fileUploadInternal(driver).sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button. (Internal)
		Thread.sleep(1000);
		js1.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(500);
	 LiPerformerPOM.indate(driver).sendKeys("01-08-2023");
	Thread.sleep(5000);
	 LiPerformerPOM.justclick(driver).click();
	js1.executeScript("window.scrollBy(0,1000)");

	//LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
	//js1.executeScript("window.scrollBy(0,300)");

Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(3000);
OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.

Thread.sleep(1000);
js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.

Thread.sleep(300);
if(type.equalsIgnoreCase("Statutory"))
{
	
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
	MethodPOM.clickMyDashboard(driver).click();
	
	wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
	LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
	
	
	Select drp1 = new Select(LiPerformerPOM.clickType(driver));
	Thread.sleep(7000);
	drp1.selectByIndex(1);
	CFOcountPOM.clickApply1(driver).click();	
	  Thread.sleep(3000);
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickActive(driver)));
	String Active1=MethodPOM.clickActive(driver).getText();
	
     int Activelicense1 = Integer.parseInt(Active1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
     String pfr1=LiPerformerPOM.PFRCount(driver).getText();
     int pfrlicense1 = Integer.parseInt(pfr1);	//Reading PendingForReview count.
     
     if(Activelicense>Activelicense1&&pfrlicense<pfrlicense1)
     {
    	 test.log(LogStatus.PASS, "Active Old Count = "+Activelicense+" | New Count = "+Activelicense1);
         test.log(LogStatus.PASS, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     else
     {
    	 test.log(LogStatus.FAIL, "Active Old Count = "+Activelicense+" | New Count = "+Activelicense1);
         test.log(LogStatus.FAIL, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     
	}
	
	public static void Expiringlicenseperform(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring(driver)));
		String Expiring=MethodPOM.clickExpiring(driver).getText();
		
	     int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.
	     
	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
	     String pfr=LiPerformerPOM.PFRCount(driver).getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickExpiring(driver).click();					//Clicking on 'Expiring' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			String item1 = MethodPOM.clickReadExpired(driver).getText();	//Reading total items String value
			  if(!item1.equalsIgnoreCase("No items to display"))
			  {
		/*	MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total)
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
	*/
	   
    Thread.sleep(3000);
    OverduePOM.ActiveAction(driver).click();	
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LiPerformerPOM.ShowFream(driver)));		
	js1.executeScript("window.scrollBy(0,1000)");
   Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown(driver)));
	Select status = new Select(OverduePOM.selectStatutoryDropdown(driver));	//Selecting Status dropdown box.
	status.selectByIndex(1);	
	 Thread.sleep(2000);
	 String workingDir = System.getProperty("user.dir");
  OverduePOM.PerformerDoc(driver).sendKeys(workingDir+"//Reports//LicenseCompanyadmin(Statutory).html");	//uploading new file	
  Thread.sleep(2000);
  js1.executeScript("window.scrollBy(0,1000)");
  Thread.sleep(2000);
	LiPerformerPOM.PerformDateclick(driver).click();
	Thread.sleep(1000);
	LiPerformerPOM.PerformDate(driver).click();
	Thread.sleep(5000);
	js1.executeScript("window.scrollBy(0,100)");

	//LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
	//js1.executeScript("window.scrollBy(0,300)");

Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(300);
OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.

Thread.sleep(1000);
js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.

Thread.sleep(300);
if(type.equalsIgnoreCase("Statutory"))
{
	
	
	Thread.sleep(500);
	js1.executeScript("window.scrollBy(2000,0)");	//Scrolling up window by 2000 px.
	test.log(LogStatus.PASS, "Save Sucessfully.");
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
			  else
			  {
				    
					test.log(LogStatus.PASS,"No Record Found");
					MethodPOM.clickMyDashboard(driver).click();
			  }
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring(driver)));
	String Expiring1=MethodPOM.clickExpiring(driver).getText();
	
     int Expiringlicense1 = Integer.parseInt(Expiring1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
     String pfr1=LiPerformerPOM.PFRCount(driver).getText();
     int pfrlicense1 = Integer.parseInt(pfr1);	//Reading PendingForReview count.
     
     if(Expiringlicense>Expiringlicense1&&pfrlicense<pfrlicense1)
     {
    	 test.log(LogStatus.PASS, "Expiring Old Count = "+Expiringlicense+" | New Count = "+Expiringlicense1);
         test.log(LogStatus.PASS, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     else
     {
    	 test.log(LogStatus.FAIL, "Expiring Old Count = "+Expiringlicense+" | New Count = "+Expiringlicense1);
         test.log(LogStatus.FAIL, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     
	}
	public static void internalExpiringlicenseperform(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
		LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
		
		
		Select drp = new Select(LiPerformerPOM.clickType(driver));
		drp.selectByIndex(1);
		CFOcountPOM.clickApply1(driver).click();	
		  Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring(driver)));
		String Expiring=MethodPOM.clickExpiring(driver).getText();
		
	     int Expiringlicense = Integer.parseInt(Expiring);	//Reading Active count.
	     
	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
	     String pfr=LiPerformerPOM.PFRCount(driver).getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickExpiring(driver).click();					//Clicking on 'Expiring' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
		/*	MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total)
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
	*/
	   
    Thread.sleep(3000);
    OverduePOM.ActiveAction(driver).click();	
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));	
	js1.executeScript("window.scrollBy(0,1000)");
   Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown(driver)));
	Select status = new Select(OverduePOM.selectInternalDropdown(driver));	//Selecting Status dropdown box.
	status.selectByIndex(2);	
	
	Thread.sleep(5000);
	js1.executeScript("window.scrollBy(0,100)");
	 String workingDir = System.getProperty("user.dir");
		OverduePOM.fileUploadInternal(driver).sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button. (Internal)
		Thread.sleep(1000);
		js1.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(500);
	 LiPerformerPOM.indate(driver).sendKeys("01-08-2023");
	Thread.sleep(5000);
	 LiPerformerPOM.justclick(driver).click();
	//LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
	//js1.executeScript("window.scrollBy(0,300)");

	
Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(300);
OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.

Thread.sleep(1000);
js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.

Thread.sleep(300);
if(type.equalsIgnoreCase("Statutory"))
{
	
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
	MethodPOM.clickMyDashboard(driver).click();
	
	wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
	LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
	
	
	Select drp1 = new Select(LiPerformerPOM.clickType(driver));
	Thread.sleep(7000);
	drp1.selectByIndex(1);
	CFOcountPOM.clickApply1(driver).click();	
	  Thread.sleep(3000);
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpiring(driver)));
	String Expiring1=MethodPOM.clickExpiring(driver).getText();
	
     int Expiringlicense1 = Integer.parseInt(Expiring1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
     String pfr1=LiPerformerPOM.PFRCount(driver).getText();
     int pfrlicense1 = Integer.parseInt(pfr1);	//Reading PendingForReview count.
     
     if(Expiringlicense>Expiringlicense1&&pfrlicense<pfrlicense1)
     {
    	 test.log(LogStatus.PASS, "Expiring Old Count = "+Expiringlicense+" | New Count = "+Expiringlicense1);
         test.log(LogStatus.PASS, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     else
     {
    	 test.log(LogStatus.FAIL, "Expiring Old Count = "+Expiringlicense+" | New Count = "+Expiringlicense1);
         test.log(LogStatus.FAIL, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     
	}
	
	public static void Expiredlicenseperform(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired(driver)));
		String Expired=MethodPOM.clickExpired(driver).getText();
		
	     int Expiredlicense = Integer.parseInt(Expired);	//Reading Expired count.
	     
	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
	     String pfr=LiPerformerPOM.PFRCount(driver).getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickExpired(driver).click();					//Clicking on 'Expiring' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
		/*	MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total)
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
	*/
	   
    Thread.sleep(3000);
    OverduePOM.ActiveAction(driver).click();	
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(LiPerformerPOM.ShowFream(driver)));		
	js1.executeScript("window.scrollBy(0,1000)");
   Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectStatutoryDropdown(driver)));
	Select status = new Select(OverduePOM.selectStatutoryDropdown(driver));	//Selecting Status dropdown box.
	status.selectByIndex(1);	
	 Thread.sleep(2000);
	 String workingDir = System.getProperty("user.dir");
 OverduePOM.PerformerDoc(driver).sendKeys(workingDir+"//Reports//LicenseCompanyadmin(Statutory).html");	//uploading new file	
 Thread.sleep(2000);
 js1.executeScript("window.scrollBy(0,1000)");
 Thread.sleep(2000);
	LiPerformerPOM.PerformDateclick(driver).click();
	Thread.sleep(1000);
	LiPerformerPOM.PerformDate(driver).click();
	Thread.sleep(5000);
	js1.executeScript("window.scrollBy(0,100)");
Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(300);
OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.

Thread.sleep(1000);
js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.

Thread.sleep(300);
if(type.equalsIgnoreCase("Statutory"))
{
	
	Thread.sleep(500);
	js1.executeScript("window.scrollBy(2000,0)");//Scrolling up window by 2000 px.
	test.log(LogStatus.PASS, "Save Sucessfully.");
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
	
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired(driver)));
	String Expired1=MethodPOM.clickExpired(driver).getText();
	
     int Expiredlicense1 = Integer.parseInt(Expired1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
     String pfr1=LiPerformerPOM.PFRCount(driver).getText();
     int pfrlicense1 = Integer.parseInt(pfr1);	//Reading PendingForReview count.
     
     if(Expiredlicense>Expiredlicense1&&pfrlicense<pfrlicense1)
     {
    	 test.log(LogStatus.PASS, "Expired Old Count = "+Expiredlicense+" | New Count = "+Expiredlicense1);
         test.log(LogStatus.PASS, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     else
     {
    	 test.log(LogStatus.FAIL, "Expired Old Count = "+Expiredlicense+" | New Count = "+Expiredlicense1);
         test.log(LogStatus.FAIL, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     
	}
	
	public static void InternalExpiredlicenseperform(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
		LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
		
		
		Select drp = new Select(LiPerformerPOM.clickType(driver));
		drp.selectByIndex(1);
		CFOcountPOM.clickApply1(driver).click();	
		  Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired(driver)));
		String Expired=MethodPOM.clickExpired(driver).getText();
		
	     int Expiredlicense = Integer.parseInt(Expired);	//Reading Expired count.
	     
	     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
	     String pfr=LiPerformerPOM.PFRCount(driver).getText();
	     int pfrlicense = Integer.parseInt(pfr);	//Reading PendingForReview count.

	      MethodPOM.clickExpired(driver).click();					//Clicking on 'Expiring' image
	      Thread.sleep(4000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(4000);
			
		/*	MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
			Thread.sleep(500);
			String item = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
			String[] bits = item.split(" ");								//Splitting the String
			String LicenseActiveCount = bits[bits.length - 2];		//Getting the second last word (total)
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
	*/
	   
    Thread.sleep(3000);
    OverduePOM.ActiveAction(driver).click();	
	                                          //Selecting 2nd value from dropdown.//Selecting 2nd value from dropdown.
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ContentPlaceHolder1_showReminderDetail"));		
	js1.executeScript("window.scrollBy(0,1000)");
   Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(OverduePOM.selectInternalDropdown(driver)));
	Select status = new Select(OverduePOM.selectInternalDropdown(driver));	//Selecting Status dropdown box.
	status.selectByIndex(2);	
	
	 Thread.sleep(3000);
	 String workingDir = System.getProperty("user.dir");
		OverduePOM.fileUploadInternal(driver).sendKeys(workingDir+"//Reports//PerformerResults.html");	//Uploading file by sending file to Upload Button. (Internal)
		Thread.sleep(1000);
		js1.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(500);
	 LiPerformerPOM.indate(driver).sendKeys("01-08-2023");
	Thread.sleep(5000);
	 LiPerformerPOM.justclick(driver).click();
	js1.executeScript("window.scrollBy(0,1000)");

	//LiPerformerPOM.clickCheckbox(driver).click();			//Clicking on checkbox of Penalty values
	//js1.executeScript("window.scrollBy(0,300)");

Thread.sleep(500);
js1.executeScript("window.scrollBy(0,700)");
Thread.sleep(300);
OverduePOM.clickComplianceSubmit(driver).click();			//Clicking on 'Submit' button.

Thread.sleep(1000);
js1.executeScript("window.scrollBy(1000,0)");				//Scrolling down window by 2000 px.

Thread.sleep(300);
if(type.equalsIgnoreCase("Statutory"))
{
	
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
	MethodPOM.clickMyDashboard(driver).click();
	
	wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.clickType(driver)));
	LiPerformerPOM.clickType(driver).click();				//Clicking on 'Type' drop down.
	
	
	Select drp1 = new Select(LiPerformerPOM.clickType(driver));
	Thread.sleep(7000);
	drp1.selectByIndex(1);
	CFOcountPOM.clickApply1(driver).click();	
	  Thread.sleep(3000);
	
	wait.until(ExpectedConditions.visibilityOf(MethodPOM.clickExpired(driver)));
	String Expired1=MethodPOM.clickExpired(driver).getText();
	
     int Expiredlicense1 = Integer.parseInt(Expired1);	//Reading Active count.

     wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.PFRCount(driver)));
     String pfr1=LiPerformerPOM.PFRCount(driver).getText();
     int pfrlicense1 = Integer.parseInt(pfr1);	//Reading PendingForReview count.
     
     if(Expiredlicense>Expiredlicense1&&pfrlicense<pfrlicense1)
     {
    	 test.log(LogStatus.PASS, "Expired Old Count = "+Expiredlicense+" | New Count = "+Expiredlicense1);
         test.log(LogStatus.PASS, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     else
     {
    	 test.log(LogStatus.FAIL, "Expired Old Count = "+Expiredlicense+" | New Count = "+Expiredlicense1);
         test.log(LogStatus.FAIL, "Pendingforreview Old Count = "+pfrlicense+" | New Count = "+pfrlicense1);
     }
     
	}
	
	public static  void AssignedButNotActivated(WebDriver driver, ExtentTest test, String type) throws InterruptedException, IOException
	{		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.visibilityOf(LiPerformerPOM.AssignedButNotActivated(driver)));
		String AssognedButNotActivated=LiPerformerPOM.AssignedButNotActivated(driver).getText();
		
	     int NotActivated = Integer.parseInt(AssognedButNotActivated);	//Reading Active count.

	     LiPerformerPOM.AssignedButNotActivated(driver).click();					//Clicking on 'Active' image
	      Thread.sleep(5000);
	        JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
			Thread.sleep(5000);
			MethodPOM.clickReadActive(driver).click();	
			String ite = MethodPOM.clickReadExpired(driver).getText();	//Reading total items String value
			Thread.sleep(5000);
			if(!ite.equalsIgnoreCase("No items to display"))	
			{
		//	MethodPOM.clickReadActive(driver).click();					//Clicking on total items count
			//Thread.sleep(500);
		//	String item1 = MethodPOM.clickReadActive(driver).getText();	//Reading total items String value
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
			
			LiPerformerPOM.NotActivatedExport(driver).click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
		
			
			Thread.sleep(3000);
			
			
			progress(driver);
			
		/*	int flag = 0;
			try
			{
				wait.until(ExpectedConditions.visibilityOf(LiReviewerPOM.checkTable1(driver)));	//Waiting until records table gets visible.
				flag = 1;
			}
			catch(Exception e)
			{
				
			}
			
			if(flag == 1)
			{
				js.executeScript("window.scrollBy(0,2000)");				//Scrolling down window by 2000 px.
				
				  Thread.sleep(10000);
				/*	CFOcountPOM.readTotalItems1(driver).click();
					
					String item = CFOcountPOM.readTotalItems1(driver).getText();
					//String NoRecord = LiReviewerPOM.reNorecord(driver).getText();
					 if(!item.equalsIgnoreCase("No items to display")) 
					 {
					 
					//String[] bits1 = ite.split(" ");								//Splitting the String
					String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
					int count2 = Integer.parseInt(compliancesCount1);
					String NoRecord = LiReviewerPOM.reNorecord(driver).getText();
					   if(!NoRecord.equalsIgnoreCase("No items to display")) 
					 {
						   try
							{
								performerPOM.clickExcelReport(driver).sendKeys(Keys.PAGE_DOWN);
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
							CFOcountPOM.clickNextPage1(driver).sendKeys(Keys.PAGE_UP);
							Thread.sleep(250);
							LiPerformerPOM.NotActivatedExport(driver).click();				//Clicking on 'Excel Report' image.
							
							
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
			
	
			MethodPOM.clickMyDashboard(driver).click();
			
			Thread.sleep(500);
			LiPerformerPOM.AssignedButNotActivated(driver).click();
			if(type.equalsIgnoreCase("Internal"))
			{
				 WebDriverWait wait1= new WebDriverWait(driver, 5);
					wait1.until(ExpectedConditions.visibilityOf(licmgmtPOM.Type2(driver)));
					licmgmtPOM.Type2(driver).click();				//Clicking on 'Type' drop down.
					
					licmgmtPOM.internalType2(driver).click();

			Thread.sleep(500);
	   LiPerformerPOM.EntityLocation(driver).click();
	Thread.sleep(5000);
	LiPerformerPOM.EntityLocationExpand(driver).click();
	Thread.sleep(500);
	//LiPerformerPOM.EntityLocationExpand(driver).click();
	//Thread.sleep(500);
   Thread.sleep(500);
   LiPerformerPOM.Entitysubexpand(driver).click();
   Thread.sleep(500);
   String locationtext1 =LiPerformerPOM.checkloc(driver).getText();
   LiPerformerPOM.checkloc(driver).click();
   Thread.sleep(3000);
   //LiPerformerPOM.ClickLictype(driver).click();
  // Thread.sleep(7000);
  // String LicenseType1 =LiPerformerPOM.notactivatefilterin(driver).getText();
   Thread.sleep(7000);
  // LiPerformerPOM.notactivatefilterin(driver).click();
   Thread.sleep(5000);
 
    List<String> li=new ArrayList<String>();
    
    li.add(locationtext1);
    //li.add(LicenseType1);
 
    Thread.sleep(3000);
    
	List<String> filter=new ArrayList<String>();	
	filter.add("Location");
//	filter.add("LicenseType");	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);

	CFOcountPOM.readTotalItems1(driver).click();					//Clicking on Text of total items just to scroll down.
	String s = CFOcountPOM.readTotalItems1(driver).getText();
	Thread.sleep(2000);

	if(!s.equalsIgnoreCase("No items to display")) 
	{
	Thread.sleep(5000);

	List<WebElement> entitycol=driver.findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
	
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
		*/
			
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
	
	Boolean  btnclear =LiPerformerPOM.clearbtn(driver).isEnabled();
     if(btnclear) 
     {
    	 LiPerformerPOM.clearbtn(driver).click();
    	 test.log(LogStatus.PASS,"Clear Button Working Successfully");
     }
     else
     {
    	 test.log(LogStatus.FAIL,"Clear Button Not Clickable");
     }
	
	
	  wait.until(ExpectedConditions.elementToBeClickable(MethodPOM.clickMyDashboard(driver)));
		
	}
			else
			{			Thread.sleep(500);
			   LiPerformerPOM.EntityLocation(driver).click();
				Thread.sleep(5000);
				LiPerformerPOM.EntityLocationExpand(driver).click();
				Thread.sleep(500);
				//LiPerformerPOM.EntityLocationExpand(driver).click();
				//Thread.sleep(500);
			   Thread.sleep(500);
			   LiPerformerPOM.Entitysubexpand(driver).click();
			   Thread.sleep(500);
			   String locationtext1 =LiPerformerPOM.checkloc(driver).getText();
			   LiPerformerPOM.checkloc(driver).click();
			   Thread.sleep(3000);
			   LiPerformerPOM.ClickLictype(driver).click();
			   Thread.sleep(5000);
			   String LicenseType1 =LiPerformerPOM.notactivatefilter(driver).getText();
			   Thread.sleep(5000);
			   LiPerformerPOM.notactivatefilter(driver).click();
			   Thread.sleep(5000);
			 
			    List<String> li=new ArrayList<String>();
			    
			    li.add(locationtext1);
			    li.add(LicenseType1);
			 
			    Thread.sleep(3000);
			    
				List<String> filter=new ArrayList<String>();	
				filter.add("Location");
				filter.add("LicenseType");	
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,150)");	
				Thread.sleep(3000);

				CFOcountPOM.readTotalItems1(driver).click();					//Clicking on Text of total items just to scroll down.
				String s = CFOcountPOM.readTotalItems1(driver).getText();
				Thread.sleep(2000);

				if(!s.equalsIgnoreCase("No items to display")) 
				{
				Thread.sleep(5000);

				List<WebElement> entitycol=driver.findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[2]"));
				
				List<WebElement> liccol=driver.findElements(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[6]"));
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
				
				Boolean  btnclear =LiPerformerPOM.clearbtn(driver).isEnabled();
			     if(btnclear) 
			     {
			    	 LiPerformerPOM.clearbtn(driver).click();
			    	 test.log(LogStatus.PASS,"Clear Button Working Successfully");
			     }
			     else
			     {
			    	 test.log(LogStatus.FAIL,"Clear Button Not Clickable");
			     }
				
				
				  wait.until(ExpectedConditions.elementToBeClickable(MethodPOM.clickMyDashboard(driver)));
					
				}
				
				}
			}
			





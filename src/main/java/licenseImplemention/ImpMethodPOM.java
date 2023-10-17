package licenseImplemention;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xmlconfig.NamespaceList.Member2.Item;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import licenseCompanyadmin.MethodPOM;
import licensePerformer.LiPerformerPOM;

public class ImpMethodPOM {
	public static WebDriver driver = null;	
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	public static FileInputStream fis = null;	
	public static void compliancemappingExport(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		ImpPOM.clickmanageschedule(driver).click();
		Thread.sleep(3000);
		ImpPOM.ClickLicesne(driver).click();
		Thread.sleep(3000);
		ImpPOM.ClickLicesneStatutory(driver).click();
		Thread.sleep(3000);
		ImpPOM.ClickComplianceMapping(driver).click();
		Thread.sleep(3000);
		ImpPOM.mappingexport(driver).click();
		
		
	}
	public static void statutorylicnesecreation(WebDriver driver, ExtentTest test, String type) throws InterruptedException, IOException
	{
		
        WebDriverWait wait = new WebDriverWait(driver, 20);
		
		ImpPOM.clickmanageschedule(driver).click();
		Thread.sleep(3000);
		ImpPOM.ClickLicesne(driver).click();
		if(type.equalsIgnoreCase("Internal"))
		{
			ImpPOM.selecttypein(driver).click();
			Thread.sleep(3000);
			ImpPOM.LicenseCreatinin(driver).click();
			Thread.sleep(1000);
			Set w = driver.getWindowHandles();    // window handles
			Thread.sleep(3000);
		      Iterator t = w.iterator();  // window handles iterate
		      String pw = (String) t.next();
		      String ch = (String) t.next();
		      
		      driver.switchTo().window(ch);
			ImpPOM.selectCustomerin(driver).click();
			Thread.sleep(5000);
			ImpPOM.SelectCustomer1(driver).click();
			Thread.sleep(5000);
		    ImpPOM.ClickLicenseType(driver).click();
		    ImpPOM.ClickLicenseType(driver).click();
		    Thread.sleep(5000);
		    //ImpPOM.SelectLicesetype(driver).click();
		    //Thread.sleep(3000);
		      //	 MethodPOM.ClickLicensetype1(driver).click();
			    licenseCompanyadmin.MethodPOM.SearchLicenseType1(driver).sendKeys("Annual Maintenance",Keys.ENTER);
			    Thread.sleep(3000);
			    JavascriptExecutor Js1 = (JavascriptExecutor) driver;
				   Js1.executeScript("window.scrollBy(0,1000)");
				   
			    
				String LicenseCount=ImpPOM.LicenseTotalCount(driver).getText();
				//int liccount=Integer.parseInt(LicenseCount);
				String[] bits = LicenseCount.split(" ");								//Splitting the String
				String Licplusecount = bits[bits.length - 1];		//Getting the second last word (total number of users)
			    int plusecount= Integer.parseInt(Licplusecount);
			   Js1.executeScript("window.scrollBy(0,-1000)");
			   Thread.sleep(3000);
			    ImpPOM.LicensePluseButton(driver).click();
			    Js1.executeScript("window.scrollBy(0,1000)");
				 Thread.sleep(3000);
				
			    String LicenseCount1=ImpPOM.LicenseTotalCount(driver).getText();
				//int liccount1=Integer.parseInt(LicenseCount1);
				String[] bits1 = LicenseCount1.split(" ");								//Splitting the String
				String Licplusecount1 = bits1[bits1.length - 1];		//Getting the second last word (total number of users)
			    int plusecount1= Integer.parseInt(Licplusecount1);
			    Js1.executeScript("window.scrollBy(0,-1000)");
			    if(plusecount < plusecount1)
				{
					test.log(LogStatus.PASS, "Add New License Pluse Button working");
				}
				else
				{
					test.log(LogStatus.FAIL, "Add New License Pluse Button not working");
				}
			   
		   		Thread.sleep(3000);
		   		licenseCompanyadmin.MethodPOM.CheckCompliance1(driver).click();
		 
		   	 Thread.sleep(3000);
		   	 
			 XSSFSheet Sheet= ReadExcel();
		   	 Row row7=sheet.getRow(7);
		   		org.apache.poi.ss.usermodel.Cell c2=row7.getCell(1);
		   	 String LicenseNo=c2.getStringCellValue();
		   	 licenseCompanyadmin.MethodPOM.LicesneNo1(driver).sendKeys(LicenseNo);
		   	
		           
		   
			 Thread.sleep(3000);
			 sheet = workbook.getSheetAt(2);
			 Row row6= sheet.getRow(6);
			  org.apache.poi.ss.usermodel.Cell c1 = row6.getCell(1);	
			 String LicenseTitle= c1.getStringCellValue();
			 licenseCompanyadmin.MethodPOM.LicesneTitle1(driver).sendKeys(LicenseTitle);
			 
			 Thread.sleep(3000);
			 licenseCompanyadmin.MethodPOM.StartDate1(driver).sendKeys("01-03-2023");
			 Thread.sleep(3000);     
			 licenseCompanyadmin.MethodPOM.EndDate1(driver).sendKeys("30-03-2023");
			 
			// JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			   Js1.executeScript("window.scrollBy(0,1000)");
			   Thread.sleep(3000);
			   Js1.executeScript("window.scrollBy(1000,0)");
			   licenseCompanyadmin.MethodPOM.SaveButton(driver).click();
			   Thread.sleep(3000);
			   Alert alert1 = driver.switchTo().alert();
			   String alertMessage1= driver.switchTo().alert().getText();
			   //test.log(LogStatus.PASS, alertMessage1);
			   alert1.accept();
			   Thread.sleep(3000);
			   String msg =licenseCompanyadmin.MethodPOM.Message(driver).getText();		//Reading Message appeared after save button
				
				if(msg.equalsIgnoreCase("Compliance Created and Assigned Successfully"))

				{
					test.log(LogStatus.PASS, "Message displayed = "+msg);
					
				}
					else
					{
						test.log(LogStatus.FAIL, "Message displayed = "+msg);
					}
		}
		else
		{
		Thread.sleep(3000);
		ImpPOM.ClickLicesneStatutory(driver).click();
		Thread.sleep(3000);
		ImpPOM.LicenseCreation(driver).click();
		Thread.sleep(3000);
		Set w = driver.getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);
		ImpPOM.ClickCustomer(driver).click();
		Thread.sleep(7000);
		//ImpPOM.SearchCustomer(driver).sendKeys("ABCD Pvt Ltd",Keys.ENTER);
		//Thread.sleep(5000);
		ImpPOM.SelectCustomer1(driver).click();
		Thread.sleep(5000);
	    ImpPOM.ClickLicenseType(driver).click();
	    Thread.sleep(5000);
	    //ImpPOM.SelectLicesetype(driver).click();
	    //Thread.sleep(3000);
	      //	 MethodPOM.ClickLicensetype1(driver).click();
		    licenseCompanyadmin.MethodPOM.SearchLicenseType1(driver).sendKeys("Boiler",Keys.ENTER);
		    Thread.sleep(3000);
		    JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			   Js1.executeScript("window.scrollBy(0,1000)");
			   
		    
			String LicenseCount=ImpPOM.LicenseTotalCount(driver).getText();
			//int liccount=Integer.parseInt(LicenseCount);
			String[] bits = LicenseCount.split(" ");								//Splitting the String
			String Licplusecount = bits[bits.length - 1];		//Getting the second last word (total number of users)
		    int plusecount= Integer.parseInt(Licplusecount);
		   Js1.executeScript("window.scrollBy(0,-1000)");
		   Thread.sleep(3000);
		    ImpPOM.LicensePluseButton(driver).click();
		    Js1.executeScript("window.scrollBy(0,1000)");
			 Thread.sleep(3000);
			
		    String LicenseCount1=ImpPOM.LicenseTotalCount(driver).getText();
			//int liccount1=Integer.parseInt(LicenseCount1);
			String[] bits1 = LicenseCount1.split(" ");								//Splitting the String
			String Licplusecount1 = bits1[bits1.length - 1];		//Getting the second last word (total number of users)
		    int plusecount1= Integer.parseInt(Licplusecount1);
		    Js1.executeScript("window.scrollBy(0,-1000)");
		    if(plusecount < plusecount1)
			{
				test.log(LogStatus.PASS, "Add New License Pluse Button working");
			}
			else
			{
				test.log(LogStatus.FAIL, "Add New License Pluse Button not working");
			}
		   
	   		Thread.sleep(3000);
	   		licenseCompanyadmin.MethodPOM.CheckCompliance1(driver).click();
	 
	   	 Thread.sleep(3000);
	   	 
		 XSSFSheet Sheet= ReadExcel();
	   	 Row row7=sheet.getRow(7);
	   		org.apache.poi.ss.usermodel.Cell c2=row7.getCell(1);
	   	 String LicenseNo=c2.getStringCellValue();
	   	 licenseCompanyadmin.MethodPOM.LicesneNo1(driver).sendKeys(LicenseNo);
	   	
	           
	   
		 Thread.sleep(3000);
		 sheet = workbook.getSheetAt(2);
		 Row row6= sheet.getRow(6);
		  org.apache.poi.ss.usermodel.Cell c1 = row6.getCell(1);	
		 String LicenseTitle= c1.getStringCellValue();
		 licenseCompanyadmin.MethodPOM.LicesneTitle1(driver).sendKeys(LicenseTitle);
		 
		 Thread.sleep(3000);
		 licenseCompanyadmin.MethodPOM.StartDate1(driver).sendKeys("01-03-2023");
		 Thread.sleep(3000);     
		 licenseCompanyadmin.MethodPOM.EndDate1(driver).sendKeys("30-03-2023");
		 
		// JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		   Js1.executeScript("window.scrollBy(0,1000)");
		   Thread.sleep(3000);
		   Js1.executeScript("window.scrollBy(1000,0)");
		   licenseCompanyadmin.MethodPOM.SaveButton(driver).click();
		   Thread.sleep(3000);
		   Alert alert1 = driver.switchTo().alert();
		   String alertMessage1= driver.switchTo().alert().getText();
		   //test.log(LogStatus.PASS, alertMessage1);
		   alert1.accept();
		   Thread.sleep(3000);
		   String msg =licenseCompanyadmin.MethodPOM.Message(driver).getText();		//Reading Message appeared after save button
			
			if(msg.equalsIgnoreCase("Compliance Created and Assigned Successfully"))
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg);
				
			}
				else
				{
					test.log(LogStatus.FAIL, "Message displayed = "+msg);
				}
		}
               driver.close();
	}
	private static XSSFSheet ReadExcel() throws IOException {
		String workingDir = System.getProperty("user.dir");
		fis = new FileInputStream(workingDir+"//TestData//ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving second sheet of Workbook
		return sheet;
	}
	public static void AddAssignment(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			
			ImpPOM.clickmanageschedule(driver).click();
			Thread.sleep(3000);
			ImpPOM.ClickLicesne(driver).click();
			Thread.sleep(3000);
			if(type.equalsIgnoreCase("Internal"))
			{
				ImpPOM.selecttypein(driver).click();
				Thread.sleep(3000);
				ImpPOM.LicenseCreatinin(driver).click();
				Thread.sleep(1000);
				Set w = driver.getWindowHandles();    // window handles
				Thread.sleep(3000);
			      Iterator t = w.iterator();  // window handles iterate
			      String pw = (String) t.next();
			      String ch = (String) t.next();
			      
			      driver.switchTo().window(ch);
			      ImpPOM.NewAssinmenttab(driver).click();
			       Thread.sleep(7000);
				ImpPOM.ClickCustomer2(driver).click();
				Thread.sleep(7000);
				ImpPOM.SelectCustomer2(driver).click();
				Thread.sleep(5000);
			     ImpPOM.clicklicensetype1(driver).click();
			    Thread.sleep(7000);
				 //   licenseCompanyadmin.MethodPOM.SearchLicenseType1(driver).sendKeys("Boiler",Keys.ENTER);
			     ImpPOM.searchlice1(driver).sendKeys("Annual Maintenance",Keys.ENTER);
				    Thread.sleep(3000);
				    ImpPOM.LocationCheck(driver).click();
				    Thread.sleep(3000);
				    ImpPOM.SelectButton1(driver).click();
			  		
				    ImpPOM.CheckCompliancein(driver).click();
				    Thread.sleep(3000);
				    ImpPOM.clicklocation(driver).click();
				    Thread.sleep(3000);
				    ImpPOM.ClickPerformer(driver).click();
				    Thread.sleep(3000);
				    ImpPOM.selectperformer(driver).click();
				    Thread.sleep(1000);
				    ImpPOM.ClickReviewer(driver).click();
				    Thread.sleep(1000);
				    ImpPOM.Selectreviewer(driver).click();
				    Thread.sleep(1000);
				    
				    JavascriptExecutor js1=(JavascriptExecutor) driver ;
					js1.executeScript("window.scroll(0,500)");
					
					ImpPOM.impaddassignment(driver).click();
					
					String successmsg = ImpPOM.successmsg(driver).getText();
					if(successmsg.equalsIgnoreCase("Assignment saved successfully"))
					{
						test.log(LogStatus.PASS, "Message Displayed = "+successmsg);
					}
					else
					{
						test.log(LogStatus.FAIL, "Message Displayed = "+successmsg);
					}
					
				   
			}
			else
			{
			ImpPOM.ClickLicesneStatutory(driver).click();
			Thread.sleep(3000);
			ImpPOM.LicenseCreation(driver).click();
			Thread.sleep(3000);
			Set w = driver.getWindowHandles();    // window handles
			Thread.sleep(3000);
		      Iterator t = w.iterator();  // window handles iterate
		      String pw = (String) t.next();
		      String ch = (String) t.next();
		       driver.switchTo().window(ch);
		       ImpPOM.NewAssinmenttab(driver).click();
		       Thread.sleep(7000);
			ImpPOM.ClickCustomer2(driver).click();
			Thread.sleep(7000);
			ImpPOM.SelectCustomer2(driver).click();
			Thread.sleep(5000);
		     ImpPOM.clicklicensetype1(driver).click();
		    Thread.sleep(7000);
			 //   licenseCompanyadmin.MethodPOM.SearchLicenseType1(driver).sendKeys("Boiler",Keys.ENTER);
		     ImpPOM.searchlice1(driver).sendKeys("Boiler",Keys.ENTER);
			    Thread.sleep(3000);
			    ImpPOM.LocationCheck(driver).click();
			    Thread.sleep(3000);
			    ImpPOM.SelectButton1(driver).click();
		  		
			    ImpPOM.CheckCompliance(driver).click();
			    Thread.sleep(3000);
			    ImpPOM.clicklocation(driver).click();
			    Thread.sleep(3000);
			    ImpPOM.ClickPerformer(driver).click();
			    Thread.sleep(3000);
			    ImpPOM.selectperformer(driver).click();
			    Thread.sleep(1000);
			    ImpPOM.ClickReviewer(driver).click();
			    Thread.sleep(1000);
			    ImpPOM.Selectreviewer(driver).click();
			    Thread.sleep(1000);
			    
			    JavascriptExecutor js1=(JavascriptExecutor) driver ;
				js1.executeScript("window.scroll(0,500)");
				
				ImpPOM.impaddassignment(driver).click();
				
				String successmsg = ImpPOM.successmsg(driver).getText();
				if(successmsg.equalsIgnoreCase("Assignment saved successfully"))
				{
					test.log(LogStatus.PASS, "Message Displayed = "+successmsg);
				}
				else
				{
					test.log(LogStatus.FAIL, "Message Displayed = "+successmsg);
				}
				
			   
			    
		  	
			}		
			
	}
	public static void compliancemappingInternalExport(WebDriver driver, ExtentTest test, String string) throws InterruptedException
	{
       WebDriverWait wait = new WebDriverWait(driver, 20);
		
		ImpPOM.clickmanageschedule(driver).click();
		Thread.sleep(3000);
		ImpPOM.ClickLicenseInternal(driver).click();
		Thread.sleep(3000);
		ImpPOM.ClickIntenalMapping(driver).click();
		Thread.sleep(3000);
		ImpPOM.ClickLicenseInternallink(driver).click();
		Thread.sleep(3000);
		ImpPOM.ClickCustomerin(driver).click();
		Thread.sleep(1000);
	   
		

		
	}
	public static void licenselist(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			
			ImpPOM.clickmanageschedule(driver).click();
			Thread.sleep(3000);
			ImpPOM.ClickLicesne(driver).click();
	    	if(type.equalsIgnoreCase("Internal"))
	    	{
	    		
	    	   ImpPOM.selecttypein(driver).click();
	    	   Thread.sleep(1000);
	    	   ImpPOM.Licenselistin(driver).click();
	    	   Thread.sleep(1000);
	    	   ImpPOM.custdrop(driver).click();
	    	   Thread.sleep(1000);
	    	   ImpPOM.selectcustomerlist(driver).click();
	    	   Thread.sleep(1000);
		        ImpPOM.editlicense(driver).click();
		        Thread.sleep(3000);       
		        ImpPOM.updatelicenseNo(driver).clear();
		        Thread.sleep(3000);         
		        ImpPOM.updatelicenseNo(driver).sendKeys("imn-23");
		        Thread.sleep(3000);        
		        ImpPOM.updatelicensetitle(driver).clear();
		        Thread.sleep(1000);   
		        ImpPOM.updatelicensetitle(driver).sendKeys("updateimn-23");
		        Thread.sleep(1000);   
		        ImpPOM.licenselistsave(driver).click();
		        test.log(LogStatus.PASS,"License Details Updated Successfully" );
	    	
	    	}
	    	else
	    	{
	    		ImpPOM.ClickLicesneStatutory(driver).click();
				Thread.sleep(1000);
		        ImpPOM.licenselist(driver).click();
		        Thread.sleep(1000);
		        ImpPOM.custdrop(driver).click();
		      
		        Thread.sleep(1000);
		        ImpPOM.selectcustomerlist(driver).click();
	        Thread.sleep(8000);       
	        ImpPOM.editlicense(driver).click();
	        Thread.sleep(3000);       
	        ImpPOM.updatelicenseNo(driver).clear();
	        Thread.sleep(1000);         
	        ImpPOM.updatelicenseNo(driver).sendKeys("imn-23");
	        Thread.sleep(1000);        
	        ImpPOM.updatelicensetitle(driver).clear();
	        Thread.sleep(1000);   
	        ImpPOM.updatelicensetitle(driver).sendKeys("updateimn-23");
	        Thread.sleep(1000);   
	        ImpPOM.licenselistsave(driver).click();
	        test.log(LogStatus.PASS,"License Details Updated Successfully");
	    	}
	        }
	
	public static void Entitesassignment(WebDriver driver, ExtentTest test, String string) throws InterruptedException
	{
		/* WebDriverWait wait = new WebDriverWait(driver, 40);
		 
		 ImpPOM.manageusertab(driver).click();
		  Thread.sleep(1000);  
		  ImpPOM.usermastertab(driver).click();
		  Thread.sleep(1000);
		  ImpPOM.clickcustdropdown(driver).click();
		  Thread.sleep(1000);
		  ImpPOM.selectcustomer2(driver).click();
		  Thread.sleep(3000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='BodyContent_grdUser_lbtnEntityAssignment_3'")));
		  Thread.sleep(3000);
		  ImpPOM.modifyentity(driver).click();
		  Thread.sleep(1000);
		  ImpPOM.stutrediolicbtn(driver).click();
		  Thread.sleep(1000);
		  ImpPOM.assignrediobtn(driver).click();
		  Thread.sleep(1000);
		  ImpPOM.clicklocationimp(driver).click();
		  Thread.sleep(5000);
		  ImpPOM.pluseimg(driver).click();
		  */
		Actions action = new Actions(driver);
		action.moveToElement( ImpPOM.manageusertab(driver)).click().build().perform();

		Thread.sleep(6000);
		ImpPOM.usermastertab(driver).click();
		Thread.sleep(5000);
		ImpPOM.SelectCustomerUser(driver).clear();
		Thread.sleep(2000);
		ImpPOM.SelectCustomerUser(driver).sendKeys("ABCD Pvt Ltd");
		ImpPOM.customer123Users(driver).click();
		Thread.sleep(4000);
		ImpPOM.ModifyEntity(driver).click();
		Thread.sleep(4000);
		/*ImpPOM.LocationEA(driver).click();
		Thread.sleep(1000);
		ImpPOM.ExpandLocation(driver).click();
		Thread.sleep(1000);
		ImpPOM.EAAWSGFJBitaLimited(driver).click();
		Thread.sleep(1000);
		ImpPOM.LocationEA(driver).click();
		Thread.sleep(3000);
		ImpPOM.ComplianceCategoryEA(driver).click();
		Thread.sleep(1000);
		ImpPOM.ClientSpecificAE(driver).click();
		Thread.sleep(3000);
		
		ImplementPOM.SaveS(driver)
		*/ 
		 ImpPOM.stutrediolicbtn(driver).click();
		  Thread.sleep(1000);
		  ImpPOM.assignrediobtn(driver).click();
		  Thread.sleep(1000);
		 // ImpPOM.clicklocationimp(driver).click();
		//  Thread.sleep(5000);
		  ImpPOM.LocationEA(driver).click();
			Thread.sleep(7000);
			By locator = By.xpath("//*[@id='BodyContent_tvBranchesn0']/img");
			WebDriverWait wait = new WebDriverWait(driver, (100));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);

			Thread.sleep(7000);
			ImpPOM.EAAWSGFJBitaLimited(driver).click();
			Thread.sleep(7000);
			ImpPOM.LocationEA(driver).click();
			Thread.sleep(3000);
			ImpPOM.clickcategorylic(driver).click();
			Thread.sleep(3000);
			ImpPOM.lictype(driver).click();
			Thread.sleep(3000);
			ImpPOM.clicksaves(driver).click();
			
			String valiemessage = ImpPOM.validtabel(driver).getText();
			if(valiemessage.equalsIgnoreCase("Entity already assigned to location for the category."))
			{
				test.log(LogStatus.FAIL, "Message Displayed = "+valiemessage);
			}
			else
			{
				test.log(LogStatus.PASS, "Message Displayed = "+valiemessage);
			}
			
			ImpPOM.Modifyclose(driver).click();
			Thread.sleep(7000);
			
			ImpPOM.ModifyEntity(driver).click();
			Thread.sleep(3000);
			 ImpPOM.stutrediolicbtn(driver).click();
			  Thread.sleep(3000);
			  ImpPOM.assignrediobtn(driver).click();
			  Thread.sleep(1000);
			  ImpPOM.Checkallloc(driver).click();
			  Thread.sleep(5000);
			//  ImpPOM.clickcategorylic(driver).click();
			//	Thread.sleep(5000);
				//ImpPOM.lictype(driver).click();

				ImpPOM.clicksaves(driver).click();
				String valiemessage2 = ImpPOM.validtabel(driver).getText();
				if(valiemessage.equalsIgnoreCase("Entity already assigned to location for the category."))
				{
					test.log(LogStatus.FAIL, "Message Displayed = "+valiemessage);
				}
				else
				{
					test.log(LogStatus.PASS, "Message Displayed = "+valiemessage);
				}
				 Thread.sleep(5000);
				ImpPOM.Modifyclose(driver).click();
				Thread.sleep(7000);
				
				ImpPOM.ModifyEntity(driver).click();
				Thread.sleep(7000);
				 ImpPOM.stutrediolicbtn(driver).click();
				  Thread.sleep(1000);
				 ImpPOM.deleteentity(driver).click();
				 Thread.sleep(1000);
				  ImpPOM.LocationEA(driver).click();
					Thread.sleep(7000);
					By locator1 = By.xpath("//*[@id='BodyContent_tvBranchesn0']/img");
					WebDriverWait wait1 = new WebDriverWait(driver, (100));
					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
					
					WebElement ViewButton1 = driver.findElement(locator);	
					Thread.sleep(3000);
			
				jse.executeScript("arguments[0].click();", ViewButton);
					Thread.sleep(4000);

					Thread.sleep(7000);
					ImpPOM.EAAWSGFJBitaLimited(driver).click();
					Thread.sleep(7000);
					ImpPOM.LocationEA(driver).click();
					Thread.sleep(3000);
					ImpPOM.clickcategorylic(driver).click();
					Thread.sleep(3000);
					ImpPOM.lictype(driver).click();
					Thread.sleep(3000);
					ImpPOM.clicksaves(driver).click();
					   Alert alert = driver.switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= driver.switchTo().alert().getText();
				       
				        Thread.sleep(5000);

				        // Accepting alert
				        alert.accept();
				
	}
	public static void appliedlicensecreation(WebDriver driver, ExtentTest test, String string) throws InterruptedException
	{
		ImpPOM.clickmanageschedule(driver).click();
		Thread.sleep(3000);
		ImpPOM.ClickLicesne(driver).click();
		Thread.sleep(3000);
		ImpPOM.ClickLicesneStatutory(driver).click();
		Thread.sleep(3000);
		if(ImpPOM.Appliedliccreation(driver).isDisplayed())
		{
			test.log(LogStatus.PASS,"Applied license Creation tab displayed");
		}
		else
		{
			test.log(LogStatus.PASS,"Applied license Creation tab can't displayed");
		}
		ImpPOM.Appliedliccreation(driver).click();
		Thread.sleep(3000);
		Set w = driver.getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	       driver.switchTo().window(ch);
	   	ImpPOM.ClickCustomer(driver).click();
		Thread.sleep(7000);
		//ImpPOM.SearchCustomer(driver).sendKeys("ABCD Pvt Ltd",Keys.ENTER);
		//Thread.sleep(5000);
		ImpPOM.SelectCustomer1(driver).click();
		Thread.sleep(5000);
	    ImpPOM.ClickLicenseType(driver).click();
	    Thread.sleep(5000);
	    //ImpPOM.SelectLicesetype(driver).click();
	    //Thread.sleep(3000);
	      //	 MethodPOM.ClickLicensetype1(driver).click();
		    licenseCompanyadmin.MethodPOM.SearchLicenseType1(driver).sendKeys("Boiler",Keys.ENTER);
		    Thread.sleep(5000);
		    ImpPOM.appliedCheckcompliance(driver).click();
		    Thread.sleep(5000);
		    ImpPOM.appliedstartdate(driver).sendKeys("01-08-2023");
		    Thread.sleep(1000);
		    JavascriptExecutor js1=(JavascriptExecutor) driver ;
			js1.executeScript("window.scroll(0,500)");
		    ImpPOM.appliedsavelic(driver).click();
		    Thread.sleep(1000);
             String msg =licenseCompanyadmin.MethodPOM.Message(driver).getText();		//Reading Message appeared after save button
			
			if(msg.equalsIgnoreCase("Compliance Created and Assigned Successfully"))
			{
				test.log(LogStatus.PASS, "Message displayed = "+msg);
				
			}
				else
				{
					test.log(LogStatus.FAIL, "Message displayed = "+msg);
				}
		
               driver.close();
	}
	public static void IsPermenenetLic(WebDriver driver, ExtentTest test, String type) throws InterruptedException
	{
		  WebDriverWait wait = new WebDriverWait(driver, 20);
			
			ImpPOM.clickmanageschedule(driver).click();
			Thread.sleep(3000);
			ImpPOM.ClickLicesne(driver).click();
			Thread.sleep(3000);
			ImpPOM.ClickLicesneStatutory(driver).click();
			Thread.sleep(3000);
			ImpPOM.LicenseCreation1(driver).click();
			Thread.sleep(3000);
			Set w = driver.getWindowHandles();    // window handles
			Thread.sleep(3000);
		      Iterator t = w.iterator();  // window handles iterate
		      String pw = (String) t.next();
		      String ch = (String) t.next();
		      
		      driver.switchTo().window(ch);
			ImpPOM.ClickCustomer(driver).click();
			Thread.sleep(7000);
			//ImpPOM.SearchCustomer(driver).sendKeys("ABCD Pvt Ltd",Keys.ENTER);
			//Thread.sleep(5000);
			ImpPOM.SelectCustomer1(driver).click();
			Thread.sleep(5000);
		    ImpPOM.ClickLicenseType(driver).click();
		    Thread.sleep(5000);
		    //ImpPOM.SelectLicesetype(driver).click();
		    //Thread.sleep(3000);
		      //	 MethodPOM.ClickLicensetype1(driver).click();
			  licenseCompanyadmin.MethodPOM.SearchLicenseType1(driver).sendKeys("Boiler",Keys.ENTER);
			   Thread.sleep(3000);
		   if(ImpPOM.ChkIsPerment(driver).isDisplayed())
		   {
			   test.log(LogStatus.PASS, "IsPermanent CheckBox displayed	"); 
			  
		   }
		   else
		   {
			   test.log(LogStatus.PASS, "IsPermanent CheckBox Not  displayed	"); 
		   }
	}
}


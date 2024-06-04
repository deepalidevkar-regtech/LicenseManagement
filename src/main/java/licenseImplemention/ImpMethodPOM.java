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
import login.webpage;

public class ImpMethodPOM extends webpage {
	public static WebDriver driver = null;	
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	public static FileInputStream fis = null;	
	public static void compliancemappingExport( ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		
		ImpPOM.clickmanageschedule().click();
		Thread.sleep(3000);
		ImpPOM.ClickLicesne().click();
		Thread.sleep(3000);
		ImpPOM.ClickLicesneStatutory().click();
		Thread.sleep(3000);
		ImpPOM.ClickComplianceMapping().click();
		Thread.sleep(3000);
		ImpPOM.mappingexport().click();
		
		
	}
	public static void statutorylicnesecreation(ExtentTest test, String type) throws InterruptedException, IOException
	{
		
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		
		ImpPOM.clickmanageschedule().click();
		Thread.sleep(3000);
		ImpPOM.ClickLicesne().click();
		if(type.equalsIgnoreCase("Internal"))
		{
			ImpPOM.selecttypein().click();
			Thread.sleep(3000);
			ImpPOM.LicenseCreatinin().click();
			Thread.sleep(1000);
			Set w = driver.getWindowHandles();    // window handles
			Thread.sleep(3000);
		      Iterator t = w.iterator();  // window handles iterate
		      String pw = (String) t.next();
		      String ch = (String) t.next();
		      
		      driver.switchTo().window(ch);
			ImpPOM.selectCustomerin().click();
			Thread.sleep(5000);
			ImpPOM.SelectCustomer1().click();
			Thread.sleep(5000);
		    ImpPOM.ClickLicenseType().click();
		    ImpPOM.ClickLicenseType().click();
		    Thread.sleep(5000);
		    //ImpPOM.SelectLicesetype(driver).click();
		    //Thread.sleep(3000);
		      //	 MethodPOM.ClickLicensetype1(driver).click();
			    licenseCompanyadmin.MethodPOM.SearchLicenseType1().sendKeys("Annual Maintenance",Keys.ENTER);
			    Thread.sleep(3000);
			    JavascriptExecutor Js1 = (JavascriptExecutor)getDriver();
				   Js1.executeScript("window.scrollBy(0,1000)");
				   
			    
				String LicenseCount=ImpPOM.LicenseTotalCount().getText();
				//int liccount=Integer.parseInt(LicenseCount);
				String[] bits = LicenseCount.split(" ");								//Splitting the String
				String Licplusecount = bits[bits.length - 1];		//Getting the second last word (total number of users)
			    int plusecount= Integer.parseInt(Licplusecount);
			   Js1.executeScript("window.scrollBy(0,-1000)");
			   Thread.sleep(3000);
			    ImpPOM.LicensePluseButton().click();
			    Js1.executeScript("window.scrollBy(0,1000)");
				 Thread.sleep(3000);
				
			    String LicenseCount1=ImpPOM.LicenseTotalCount().getText();
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
		   		licenseCompanyadmin.MethodPOM.CheckCompliance1().click();
		 
		   	 Thread.sleep(3000);
		   	 
			 XSSFSheet Sheet= ReadExcel();
		   	 Row row7=sheet.getRow(7);
		   		org.apache.poi.ss.usermodel.Cell c2=row7.getCell(1);
		   	 String LicenseNo=c2.getStringCellValue();
		   	 licenseCompanyadmin.MethodPOM.LicesneNo1().sendKeys(LicenseNo);
		   	
		           
		   
			 Thread.sleep(3000);
			 sheet = workbook.getSheetAt(2);
			 Row row6= sheet.getRow(6);
			  org.apache.poi.ss.usermodel.Cell c1 = row6.getCell(1);	
			 String LicenseTitle= c1.getStringCellValue();
			 licenseCompanyadmin.MethodPOM.LicesneTitle1().sendKeys(LicenseTitle);
			 
			 Thread.sleep(3000);
			 licenseCompanyadmin.MethodPOM.StartDate1().sendKeys("01-03-2023");
			 Thread.sleep(3000);     
			 licenseCompanyadmin.MethodPOM.EndDate1().sendKeys("30-03-2023");
			 
			// JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			   Js1.executeScript("window.scrollBy(0,1000)");
			   Thread.sleep(3000);
			   Js1.executeScript("window.scrollBy(1000,0)");
			   licenseCompanyadmin.MethodPOM.SaveButton().click();
			   Thread.sleep(3000);
			   Alert alert1 = driver.switchTo().alert();
			   String alertMessage1= driver.switchTo().alert().getText();
			   //test.log(LogStatus.PASS, alertMessage1);
			   alert1.accept();
			   Thread.sleep(3000);
			   String msg =licenseCompanyadmin.MethodPOM.Message().getText();		//Reading Message appeared after save button
				
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
		ImpPOM.ClickLicesneStatutory().click();
		Thread.sleep(3000);
		ImpPOM.LicenseCreation().click();
		Thread.sleep(3000);
		Set w = driver.getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      driver.switchTo().window(ch);
		ImpPOM.ClickCustomer().click();
		Thread.sleep(7000);
		//ImpPOM.SearchCustomer(driver).sendKeys("ABCD Pvt Ltd",Keys.ENTER);
		//Thread.sleep(5000);
		ImpPOM.SelectCustomer1().click();
		Thread.sleep(5000);
	    ImpPOM.ClickLicenseType().click();
	    Thread.sleep(5000);
	    //ImpPOM.SelectLicesetype(driver).click();
	    //Thread.sleep(3000);
	      //	 MethodPOM.ClickLicensetype1(driver).click();
		    licenseCompanyadmin.MethodPOM.SearchLicenseType1().sendKeys("Boiler",Keys.ENTER);
		    Thread.sleep(3000);
		    JavascriptExecutor Js1 = (JavascriptExecutor) getDriver();
			   Js1.executeScript("window.scrollBy(0,1000)");
			   
		    
			String LicenseCount=ImpPOM.LicenseTotalCount().getText();
			//int liccount=Integer.parseInt(LicenseCount);
			String[] bits = LicenseCount.split(" ");								//Splitting the String
			String Licplusecount = bits[bits.length - 1];		//Getting the second last word (total number of users)
		    int plusecount= Integer.parseInt(Licplusecount);
		   Js1.executeScript("window.scrollBy(0,-1000)");
		   Thread.sleep(3000);
		    ImpPOM.LicensePluseButton().click();
		    Js1.executeScript("window.scrollBy(0,1000)");
			 Thread.sleep(3000);
			
		    String LicenseCount1=ImpPOM.LicenseTotalCount().getText();
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
	   		licenseCompanyadmin.MethodPOM.CheckCompliance1().click();
	 
	   	 Thread.sleep(3000);
	   	 
		 XSSFSheet Sheet= ReadExcel();
	   	 Row row7=sheet.getRow(7);
	   		org.apache.poi.ss.usermodel.Cell c2=row7.getCell(1);
	   	 String LicenseNo=c2.getStringCellValue();
	   	 licenseCompanyadmin.MethodPOM.LicesneNo1().sendKeys(LicenseNo);
	   	
	           
	   
		 Thread.sleep(3000);
		 sheet = workbook.getSheetAt(2);
		 Row row6= sheet.getRow(6);
		  org.apache.poi.ss.usermodel.Cell c1 = row6.getCell(1);	
		 String LicenseTitle= c1.getStringCellValue();
		 licenseCompanyadmin.MethodPOM.LicesneTitle1().sendKeys(LicenseTitle);
		 
		 Thread.sleep(3000);
		 licenseCompanyadmin.MethodPOM.StartDate1().sendKeys("01-03-2023");
		 Thread.sleep(3000);     
		 licenseCompanyadmin.MethodPOM.EndDate1().sendKeys("30-03-2023");
		 
		// JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		   Js1.executeScript("window.scrollBy(0,1000)");
		   Thread.sleep(3000);
		   Js1.executeScript("window.scrollBy(1000,0)");
		   licenseCompanyadmin.MethodPOM.SaveButton().click();
		   Thread.sleep(3000);
		   Alert alert1 = driver.switchTo().alert();
		   String alertMessage1= driver.switchTo().alert().getText();
		   //test.log(LogStatus.PASS, alertMessage1);
		   alert1.accept();
		   Thread.sleep(3000);
		   String msg =licenseCompanyadmin.MethodPOM.Message().getText();		//Reading Message appeared after save button
			
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
	public static void AddAssignment( ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			
			ImpPOM.clickmanageschedule().click();
			Thread.sleep(3000);
			ImpPOM.ClickLicesne().click();
			Thread.sleep(3000);
			if(type.equalsIgnoreCase("Internal"))
			{
				ImpPOM.selecttypein().click();
				Thread.sleep(3000);
				ImpPOM.LicenseCreatinin().click();
				Thread.sleep(1000);
				Set w = getDriver().getWindowHandles();    // window handles
				Thread.sleep(3000);
			      Iterator t = w.iterator();  // window handles iterate
			      String pw = (String) t.next();
			      String ch = (String) t.next();
			      
			      getDriver().switchTo().window(ch);
			      ImpPOM.NewAssinmenttab().click();
			       Thread.sleep(7000);
				ImpPOM.ClickCustomer2().click();
				Thread.sleep(7000);
				ImpPOM.SelectCustomer2().click();
				Thread.sleep(5000);
			     ImpPOM.clicklicensetype1().click();
			    Thread.sleep(7000);
				 //   licenseCompanyadmin.MethodPOM.SearchLicenseType1(driver).sendKeys("Boiler",Keys.ENTER);
			     ImpPOM.searchlice1().sendKeys("Annual Maintenance",Keys.ENTER);
				    Thread.sleep(3000);
				    ImpPOM.LocationCheck().click();
				    Thread.sleep(3000);
				    ImpPOM.SelectButton1().click();
			  		
				    ImpPOM.CheckCompliancein().click();
				    Thread.sleep(3000);
				    ImpPOM.clicklocation().click();
				    Thread.sleep(3000);
				    ImpPOM.ClickPerformer().click();
				    Thread.sleep(3000);
				    ImpPOM.selectperformer().click();
				    Thread.sleep(1000);
				    ImpPOM.ClickReviewer().click();
				    Thread.sleep(1000);
				    ImpPOM.Selectreviewer().click();
				    Thread.sleep(1000);
				    
				    JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
					js1.executeScript("window.scroll(0,500)");
					
					ImpPOM.impaddassignment().click();
					
					String successmsg = ImpPOM.successmsg().getText();
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
			ImpPOM.ClickLicesneStatutory().click();
			Thread.sleep(3000);
			ImpPOM.LicenseCreation().click();
			Thread.sleep(3000);
			Set w = getDriver().getWindowHandles();    // window handles
			Thread.sleep(3000);
		      Iterator t = w.iterator();  // window handles iterate
		      String pw = (String) t.next();
		      String ch = (String) t.next();
		       driver.switchTo().window(ch);
		       ImpPOM.NewAssinmenttab().click();
		       Thread.sleep(7000);
			ImpPOM.ClickCustomer2().click();
			Thread.sleep(7000);
			ImpPOM.SelectCustomer2().click();
			Thread.sleep(5000);
		     ImpPOM.clicklicensetype1().click();
		    Thread.sleep(7000);
			 //   licenseCompanyadmin.MethodPOM.SearchLicenseType1(driver).sendKeys("Boiler",Keys.ENTER);
		     ImpPOM.searchlice1().sendKeys("Boiler",Keys.ENTER);
			    Thread.sleep(3000);
			    ImpPOM.LocationCheck().click();
			    Thread.sleep(3000);
			    ImpPOM.SelectButton1().click();
		  		
			    ImpPOM.CheckCompliance().click();
			    Thread.sleep(3000);
			    ImpPOM.clicklocation().click();
			    Thread.sleep(3000);
			    ImpPOM.ClickPerformer().click();
			    Thread.sleep(3000);
			    ImpPOM.selectperformer().click();
			    Thread.sleep(1000);
			    ImpPOM.ClickReviewer().click();
			    Thread.sleep(1000);
			    ImpPOM.Selectreviewer().click();
			    Thread.sleep(1000);
			    
			    JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
				js1.executeScript("window.scroll(0,500)");
				
				ImpPOM.impaddassignment().click();
				
				String successmsg = ImpPOM.successmsg().getText();
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
	public static void compliancemappingInternalExport( ExtentTest test, String string) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		
		ImpPOM.clickmanageschedule().click();
		Thread.sleep(3000);
		ImpPOM.ClickLicenseInternal().click();
		Thread.sleep(3000);
		ImpPOM.ClickIntenalMapping().click();
		Thread.sleep(3000);
		ImpPOM.ClickLicenseInternallink().click();
		Thread.sleep(3000);
		ImpPOM.ClickCustomerin().click();
		Thread.sleep(1000);
	   
		

		
	}
	public static void licenselist( ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));

			
			ImpPOM.clickmanageschedule().click();
			Thread.sleep(3000);
			ImpPOM.ClickLicesne().click();
	    	if(type.equalsIgnoreCase("Internal"))
	    	{
	    		
	    	   ImpPOM.selecttypein().click();
	    	   Thread.sleep(1000);
	    	   ImpPOM.Licenselistin().click();
	    	   Thread.sleep(1000);
	    	   ImpPOM.custdrop().click();
	    	   Thread.sleep(1000);
	    	   ImpPOM.selectcustomerlist().click();
	    	   Thread.sleep(1000);
		        ImpPOM.editlicense().click();
		        Thread.sleep(3000);       
		        ImpPOM.updatelicenseNo().clear();
		        Thread.sleep(3000);         
		        ImpPOM.updatelicenseNo().sendKeys("imn-23");
		        Thread.sleep(3000);        
		        ImpPOM.updatelicensetitle().clear();
		        Thread.sleep(1000);   
		        ImpPOM.updatelicensetitle().sendKeys("updateimn-23");
		        Thread.sleep(1000);   
		        ImpPOM.licenselistsave().click();
		        test.log(LogStatus.PASS,"License Details Updated Successfully" );
	    	
	    	}
	    	else
	    	{
	    		ImpPOM.ClickLicesneStatutory().click();
				Thread.sleep(1000);
		        ImpPOM.licenselist().click();
		        Thread.sleep(1000);
		        ImpPOM.custdrop().click();
		      
		        Thread.sleep(1000);
		        ImpPOM.selectcustomerlist().click();
	        Thread.sleep(8000);       
	        ImpPOM.editlicense().click();
	        Thread.sleep(3000);       
	        ImpPOM.updatelicenseNo().clear();
	        Thread.sleep(1000);         
	        ImpPOM.updatelicenseNo().sendKeys("imn-23");
	        Thread.sleep(1000);        
	        ImpPOM.updatelicensetitle().clear();
	        Thread.sleep(1000);   
	        ImpPOM.updatelicensetitle().sendKeys("updateimn-23");
	        Thread.sleep(1000);   
	        ImpPOM.licenselistsave().click();
	        test.log(LogStatus.PASS,"License Details Updated Successfully");
	    	}
	        }
	
	public static void Entitesassignment( ExtentTest test, String string) throws InterruptedException
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
		Actions action = new Actions(getDriver());
		action.moveToElement( ImpPOM.manageusertab()).click().build().perform();

		Thread.sleep(6000);
		ImpPOM.usermastertab().click();
		Thread.sleep(5000);
		ImpPOM.SelectCustomerUser().clear();
		Thread.sleep(2000);
		ImpPOM.SelectCustomerUser().sendKeys("ABCD Pvt Ltd");
		ImpPOM.customer123Users().click();
		Thread.sleep(4000);
		ImpPOM.ModifyEntity().click();
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
		 ImpPOM.stutrediolicbtn().click();
		  Thread.sleep(1000);
		  ImpPOM.assignrediobtn().click();
		  Thread.sleep(1000);
		 // ImpPOM.clicklocationimp(driver).click();
		//  Thread.sleep(5000);
		  ImpPOM.LocationEA().click();
			Thread.sleep(7000);
			By locator = By.xpath("//*[@id='BodyContent_tvBranchesn0']/img");
			WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = driver.findElement(locator);	
			Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);

			Thread.sleep(7000);
			ImpPOM.EAAWSGFJBitaLimited().click();
			Thread.sleep(7000);
			ImpPOM.LocationEA().click();
			Thread.sleep(3000);
			ImpPOM.clickcategorylic().click();
			Thread.sleep(3000);
			ImpPOM.lictype().click();
			Thread.sleep(3000);
			ImpPOM.clicksaves().click();
			
			String valiemessage = ImpPOM.validtabel().getText();
			if(valiemessage.equalsIgnoreCase("Entity already assigned to location for the category."))
			{
				test.log(LogStatus.FAIL, "Message Displayed = "+valiemessage);
			}
			else
			{
				test.log(LogStatus.PASS, "Message Displayed = "+valiemessage);
			}
			
			ImpPOM.Modifyclose().click();
			Thread.sleep(7000);
			
			ImpPOM.ModifyEntity().click();
			Thread.sleep(3000);
			 ImpPOM.stutrediolicbtn().click();
			  Thread.sleep(3000);
			  ImpPOM.assignrediobtn().click();
			  Thread.sleep(1000);
			  ImpPOM.Checkallloc().click();
			  Thread.sleep(5000);
			//  ImpPOM.clickcategorylic(driver).click();
			//	Thread.sleep(5000);
				//ImpPOM.lictype(driver).click();

				ImpPOM.clicksaves().click();
				String valiemessage2 = ImpPOM.validtabel().getText();
				if(valiemessage.equalsIgnoreCase("Entity already assigned to location for the category."))
				{
					test.log(LogStatus.FAIL, "Message Displayed = "+valiemessage);
				}
				else
				{
					test.log(LogStatus.PASS, "Message Displayed = "+valiemessage);
				}
				 Thread.sleep(5000);
				ImpPOM.Modifyclose().click();
				Thread.sleep(7000);
				
				ImpPOM.ModifyEntity().click();
				Thread.sleep(7000);
				 ImpPOM.stutrediolicbtn().click();
				  Thread.sleep(1000);
				 ImpPOM.deleteentity().click();
				 Thread.sleep(1000);
				  ImpPOM.LocationEA().click();
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
					ImpPOM.EAAWSGFJBitaLimited().click();
					Thread.sleep(7000);
					ImpPOM.LocationEA().click();
					Thread.sleep(3000);
					ImpPOM.clickcategorylic().click();
					Thread.sleep(3000);
					ImpPOM.lictype().click();
					Thread.sleep(3000);
					ImpPOM.clicksaves().click();
					   Alert alert = getDriver().switchTo().alert();
				       
				        // Capturing alert message.   
				        String alertMessage= driver.switchTo().alert().getText();
				       
				        Thread.sleep(5000);

				        // Accepting alert
				        alert.accept();
				
	}
	public static void appliedlicensecreation( ExtentTest test, String string) throws InterruptedException
	{
		ImpPOM.clickmanageschedule().click();
		Thread.sleep(3000);
		ImpPOM.ClickLicesne().click();
		Thread.sleep(3000);
		ImpPOM.ClickLicesneStatutory().click();
		Thread.sleep(3000);
		if(ImpPOM.Appliedliccreation().isDisplayed())
		{
			test.log(LogStatus.PASS,"Applied license Creation tab displayed");
		}
		else
		{
			test.log(LogStatus.PASS,"Applied license Creation tab can't displayed");
		}
		ImpPOM.Appliedliccreation().click();
		Thread.sleep(3000);
		Set w = driver.getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	       driver.switchTo().window(ch);
	   	ImpPOM.ClickCustomer().click();
		Thread.sleep(7000);
		//ImpPOM.SearchCustomer(driver).sendKeys("ABCD Pvt Ltd",Keys.ENTER);
		//Thread.sleep(5000);
		ImpPOM.SelectCustomer1().click();
		Thread.sleep(5000);
	    ImpPOM.ClickLicenseType().click();
	    Thread.sleep(5000);
	    //ImpPOM.SelectLicesetype(driver).click();
	    //Thread.sleep(3000);
	      //	 MethodPOM.ClickLicensetype1(driver).click();
		    licenseCompanyadmin.MethodPOM.SearchLicenseType1().sendKeys("Boiler",Keys.ENTER);
		    Thread.sleep(5000);
		    ImpPOM.appliedCheckcompliance().click();
		    Thread.sleep(5000);
		    ImpPOM.appliedstartdate().sendKeys("01-08-2023");
		    Thread.sleep(1000);
		    JavascriptExecutor js1=(JavascriptExecutor) getDriver() ;
			js1.executeScript("window.scroll(0,500)");
		    ImpPOM.appliedsavelic().click();
		    Thread.sleep(1000);
             String msg =licenseCompanyadmin.MethodPOM.Message().getText();		//Reading Message appeared after save button
			
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
	public static void IsPermenenetLic( ExtentTest test, String type) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
			
			ImpPOM.clickmanageschedule().click();
			Thread.sleep(3000);
			ImpPOM.ClickLicesne().click();
			Thread.sleep(3000);
			ImpPOM.ClickLicesneStatutory().click();
			Thread.sleep(3000);
			ImpPOM.LicenseCreation1().click();
			Thread.sleep(3000);
			Set w = driver.getWindowHandles();    // window handles
			Thread.sleep(3000);
		      Iterator t = w.iterator();  // window handles iterate
		      String pw = (String) t.next();
		      String ch = (String) t.next();
		      
		      driver.switchTo().window(ch);
			ImpPOM.ClickCustomer().click();
			Thread.sleep(7000);
			//ImpPOM.SearchCustomer(driver).sendKeys("ABCD Pvt Ltd",Keys.ENTER);
			//Thread.sleep(5000);
			ImpPOM.SelectCustomer1().click();
			Thread.sleep(5000);
		    ImpPOM.ClickLicenseType().click();
		    Thread.sleep(5000);
		    //ImpPOM.SelectLicesetype(driver).click();
		    //Thread.sleep(3000);
		      //	 MethodPOM.ClickLicensetype1(driver).click();
			  licenseCompanyadmin.MethodPOM.SearchLicenseType1().sendKeys("Boiler",Keys.ENTER);
			   Thread.sleep(3000);
		   if(ImpPOM.ChkIsPerment().isDisplayed())
		   {
			   test.log(LogStatus.PASS, "IsPermanent CheckBox displayed	"); 
			  
		   }
		   else
		   {
			   test.log(LogStatus.PASS, "IsPermanent CheckBox Not  displayed	"); 
		   }
	}
}


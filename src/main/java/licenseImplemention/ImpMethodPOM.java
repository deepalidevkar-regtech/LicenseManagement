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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import licenseCompanyadmin.MethodPOM;

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
		 
               driver.close();
	}
	private static XSSFSheet ReadExcel() throws IOException {
		String workingDir = System.getProperty("user.dir");
		fis = new FileInputStream(workingDir+"//TestData//ComplianceSheet.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving second sheet of Workbook
		return sheet;
	}
	public static void AddAssignment(WebDriver driver, ExtentTest test, String string) throws InterruptedException
	{
		 WebDriverWait wait = new WebDriverWait(driver, 20);
			
			ImpPOM.clickmanageschedule(driver).click();
			Thread.sleep(3000);
			ImpPOM.ClickLicesne(driver).click();
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
		  		
		  		Thread.sleep(3000);
		  		MethodPOM.CheckCompliance(driver).click();
		  		Thread.sleep(3000);
		  		MethodPOM.ClickPerformer(driver).click();
		  		Thread.sleep(3000);
		  		MethodPOM.SelectLicensePerformer(driver).click();
		  		
		  
		  		/*Thread.sleep(3000);
		  		MethodPOM.ClickReviewer(driver).click();
		  		Thread.sleep(5000);
		  		MethodPOM.SelectLicenseReviewer(driver).click();*/
		  	
			
			
	}
}

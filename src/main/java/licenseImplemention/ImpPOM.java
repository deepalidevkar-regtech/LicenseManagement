package licenseImplemention;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImpPOM {
	private static WebElement license = null;
	public static List<WebElement> elementsList = null;
	public static WebDriver driver = null;	
	
	
	public static WebElement clickmanageschedule(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[6]/a"));
		return license;
	}
	
	public static WebElement ClickLicesne(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:115']/li[4]/a"));
		return license;
	
	}
	public static WebElement ClickLicesneStatutory(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:119']/li[1]/a"));
		return license;
	
	}
	public static WebElement ClickComplianceMapping(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:120']/li[1]/a"));
		return license;
	
	}
	public static WebElement mappingexport(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='BodyContent_btnExportExcel']/img"));
		return license;
	
	}
	public static WebElement LicenseCreation(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:120']/li[2]/a"));
		return license;
	
	}
	public static WebElement ClickCustomer(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("(//a[@class='chosen-single chosen-default'])[1]"));
		return license;	
	}
	public static WebElement selectcustomer(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFilterCustomer_chosen']/a/span"));
		return license;
	
	}
	public static WebElement SearchCustomer(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFilterCustomer_chosen']"));
		return license;
	
	}
	public static WebElement SelectCustomer1(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFilterCustomer_chosen']/div/ul/li[4]"));
		return license;
	
	}
	public static WebElement ClickLicenseType(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/a/span"));
		//*[@id="ContentPlaceHolder1_ddlLicenseType1_chosen"]/a/span
		return license;
	
	}
	public static WebElement SelectLicesetype(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/a/span"));
		return license;
	
	}
	public static WebElement LicenseTotalCount(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivRecordsScrum']"));
		return license;
	
	}
	public static WebElement LicensePluseButton(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_lnkViewLicenseInstance_0']/img"));
		return license;
	
	}
	public static WebElement NewAssinmenttab(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_liNotAssigned']"));
		return license;
	
	}
	public static WebElement ClickCustomer2(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFilterCustomer1_chosen']/a"));
		return license;
	
	}
	public static WebElement SelectCustomer2(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFilterCustomer1_chosen']/div/ul/li[3]"));
		return license;
	
	}
	public static WebElement clicklicensetype1(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType1_chosen']/a/span"));
		return license;
	
	}
	public static WebElement searchlice1(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType1_chosen']/div/div/input"));
		return license;
	
	}
	public static WebElement ClickLocation1(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocation1']"));
		return license;
	
	}
	public static WebElement LocationCheck(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocation1n0CheckBox']"));
		return license;
	
	}
	public static WebElement SelectButton1(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnlocation1']"));
		return license;
	
	}
	public static WebElement ClickIntenalMapping(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:125']/li[2]"));
		return license;
	
	}
	public static WebElement ClickLicenseInternal(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:121']/li[4]"));
		return license;
	
	}
	public static WebElement ClickLicenseInternallink(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:132']/li[1]/a"));
		return license;
	
	}
	public static WebElement ClickCustomerin(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//Span[@class='ui-button-text'][1]"));
		return license;
	
	}
	
	
}

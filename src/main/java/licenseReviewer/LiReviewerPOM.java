package licenseReviewer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LiReviewerPOM 
{
	private static WebElement license = null;		
	private static List<WebElement> elementsList = null;	//WebElement list created for selecting Status-Asc/Desc (Status shows multiple elements back side)
	
	public static WebElement checkTable(WebDriver driver)
	{
		license = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-overview'])[2]"));
		
		return license;
	}
	
	public static WebElement checkTable1(WebDriver driver)
	{
	//	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList']"));
		license = driver.findElement(By.xpath("//*[@id='childrow']/div"));
	
		return license;
	}
	
	public static List<WebElement> clickAction(WebDriver driver)
	{
		elementsList = driver.findElements(By.xpath("//*[contains(@id,'ContentPlaceHolder1_grdLicenseList_lnkEditLicense')]"));
		return elementsList;
	}
	
	public static WebElement clickIndexDropDown(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//div[@id='ContentPlaceHolder1_DropDownListPageNo_chosen']"));
		return license;
	}
	
	public static List<WebElement> clickIndexDropDownOption(WebDriver driver)
	{
		elementsList = driver.findElements(By.xpath("//div[@id='ContentPlaceHolder1_DropDownListPageNo_chosen']/div/ul/li"));
		return elementsList;
	}
	
	public static WebElement clickLicenseNo(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='txtLicenseNo']"));
		return license;
	}
	
	public static WebElement clickLicenseTitle(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='txtLicenseTitle']"));
		return license;
	}
	
	public static WebElement clickStartDate(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='txtStartDate']"));
		return license;
	}
	
	public static WebElement clickEndDate(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='txtEndDate']"));
		return license;
	}
	
	public static WebElement clickDate(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='tbxDate1']"));
		return license;
	}
	
	public static WebElement clickDate1(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='tbxDate']"));
		return license;
	}
	
	public static WebElement clikTextArea(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='tbxRemarks1']"));
		return license;
	}
	
	public static WebElement clikTextArea1(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='tbxRemarks3']"));
		return license;
	}
	
	public static WebElement clickReviewer(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[13]/a[3]"));
		return license;
	}
	
	public static WebElement clickin(WebDriver driver)
	{
		license = driver.findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clikAiorn(WebDriver driver)
	{
		license = driver.findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clictor(WebDriver driver)
	{
		license = driver.findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clickirn(WebDriver driver)
	{
		license = driver.findElement(By.xpath(""));
		return license;
	}
	public static WebElement revexpiringOn(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkShowDetailLicense']"));
		return license;
	}
	public static WebElement reNorecord(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@class='k-pager-info k-label']"));
		return license;
	}

	public static WebElement Overviewreview1(WebDriver driver) {
		license = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-eye k-grid-eye'])[1]"));
		return license;
	}
	public static WebElement Reviewaction(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-overview'])[1]"));
		return license;
	}
	public static WebElement addnominee(WebDriver driver) {
		license = driver.findElement(By.xpath("//*[@id='btnAddNomineeDetails']"));
		return license;
	}
	public static WebElement iscurrentnominee(WebDriver driver) {
		license = driver.findElement(By.xpath("	//*[@id='chkboxIsCurrentNominee']"));
		return license;
	}
	public static WebElement workclose(WebDriver driver) {
		license = driver.findElement(By.xpath("//*[@class='k-icon k-i-close']"));
		return license;
	}
	public static WebElement clickok(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-button-group k-dialog-buttongroup k-dialog-button-layout-stretched'])[5]"));
		return license;
	}
	public static WebElement clickdownload(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='rptComplianceVersion_btnComplinceVersionDoc_0']"));
		return license;
	}
	public static WebElement rejectbtn(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='btnReject1']"));
		return license;
	}
	public static WebElement inrejectbtn(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='btnReject3']"));
		return license;
	}
	public static WebElement intremark(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='tbxRemarks3']"));
		return license;
	}
	public static WebElement Addcolumn(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-icon k-i-more-vertical'])[1]"));
		return license;
	}
	public static WebElement clickColumn(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@class='k-icon k-i-columns']"));
		return license;
	}
	public static WebElement addnomineecol(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@data-field='NomineeName'])[2]"));
		return license;
	}
	public static WebElement Nomineecolumn(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-link'])[17]"));
		return license;
	}
	
}

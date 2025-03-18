package licenseReviewer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import login.webpage;

public class LiReviewerPOM extends webpage
{
	private static WebElement license = null;		
	private static List<WebElement> elementsList = null;	//WebElement list created for selecting Status-Asc/Desc (Status shows multiple elements back side)
	
	public static WebElement checkTable()
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-overview'])[2]"));
		
		return license;
	}
	
	public static WebElement checkTable1()
	{
	//	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList']"));
		license = getDriver().findElement(By.xpath("//*[@id='childrow']/div"));
	
		return license;
	}
	
	public static List<WebElement> clickAction()
	{
		elementsList = getDriver().findElements(By.xpath("//*[contains(@id,'ContentPlaceHolder1_grdLicenseList_lnkEditLicense')]"));
		return elementsList;
	}
	
	public static WebElement clickIndexDropDown()
	{
		license = getDriver().findElement(By.xpath("//div[@id='ContentPlaceHolder1_DropDownListPageNo_chosen']"));
		return license;
	}
	
	public static List<WebElement> clickIndexDropDownOption()
	{
		elementsList = getDriver().findElements(By.xpath("//div[@id='ContentPlaceHolder1_DropDownListPageNo_chosen']/div/ul/li"));
		return elementsList;
	}
	
	public static WebElement clickLicenseNo()
	{
		license = getDriver().findElement(By.xpath("//*[@id='txtLicenseNo']"));
		return license;
	}
	
	public static WebElement clickLicenseTitle()
	{
		license = getDriver().findElement(By.xpath("//*[@id='txtLicenseTitle']"));
		return license;
	}
	
	public static WebElement clickStartDate()
	{
		license = getDriver().findElement(By.xpath("//*[@id='txtStartDate']"));
		return license;
	}
	
	public static WebElement clickEndDate()
	{
		license = getDriver().findElement(By.xpath("//*[@id='txtEndDate']"));
		return license;
	}
	
	public static WebElement clickDate()
	{
		license = getDriver().findElement(By.xpath("//*[@id='tbxDate1']"));
		return license;
	}
	
	public static WebElement clickDate1()
	{
		license = getDriver().findElement(By.xpath("//*[@id='tbxDate']"));
		return license;
	}
	
	public static WebElement clikTextArea()
	{
		license = getDriver().findElement(By.xpath("//*[@id='tbxRemarks1']"));
		return license;
	}
	
	public static WebElement clikTextArea1()
	{
		license = getDriver().findElement(By.xpath("//*[@id='tbxRemarks3']"));
		return license;
	}
	
	public static WebElement clickReviewer()
	{
		license = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[13]/a[3]"));
		return license;
	}
	
	public static WebElement clickin()
	{
		license = getDriver().findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clikAiorn()
	{
		license = getDriver().findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clictor()
	{
		license = getDriver().findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clickirn()
	{
		license = getDriver().findElement(By.xpath(""));
		return license;
	}
	public static WebElement revexpiringOn()
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkShowDetailLicense']"));
		return license;
	}
	public static WebElement reNorecord()
	{
		license =getDriver().findElement(By.xpath("//*[@class='k-pager-info k-label']"));
		return license;
	}

	public static WebElement Overviewreview1() {
		license =getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-eye k-grid-eye'])[1]"));
		return license;
	}
	public static WebElement Reviewaction() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-overview'])[1]"));
		return license;
	}
	public static WebElement addnominee() {
		license = getDriver().findElement(By.xpath("//*[@id='btnAddNomineeDetails']"));
		return license;
	}
	public static WebElement iscurrentnominee() {
		license = getDriver().findElement(By.xpath("	//*[@id='chkboxIsCurrentNominee']"));
		return license;
	}
	public static WebElement workclose() {
		license = getDriver().findElement(By.xpath("//*[@class='k-icon k-i-close']"));
		return license;
	}
	public static WebElement clickok() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-button-group k-dialog-buttongroup k-dialog-button-layout-stretched'])[5]"));
		return license;
	}
	public static WebElement clickdownload() 
	{
		license =getDriver().findElement(By.xpath("//*[@id='rptComplianceVersion_btnComplinceVersionDoc_0']"));
		return license;
	}
	public static WebElement rejectbtn() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='btnReject1']"));
		return license;
	}
	public static WebElement inrejectbtn() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='btnReject3']"));
		return license;
	}
	public static WebElement intremark() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='tbxRemarks3']"));
		return license;
	}
	public static WebElement Addcolumn() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-more-vertical'])[1]"));
		return license;
	}
	public static WebElement clickColumn() 
	{
		license = getDriver().findElement(By.xpath("//*[@class='k-icon k-i-columns']"));
		return license;
	}
	public static WebElement addnomineecol() 
	{
		license = getDriver().findElement(By.xpath("(//*[@data-field='NomineeName'])[2]"));
		return license;
	}
	public static WebElement Nomineecolumn() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-link'])[17]"));
		return license;
	}
	public static WebElement RejectRemark() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='tbxRemarks1']"));
		return license;
	}
	public static WebElement clicksorting() 
	{
		license = getDriver().findElement(By.xpath("(//a[@class='k-link'])[4]"));
		return license;
	}
	
}

package licenseManagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class licmgmtPOM 


{
	private static WebElement license = null;
	public static List<WebElement> elementsList = null;
	public static WebDriver driver = null;	
	
	
	public static WebElement clickByLicnesetypeExpired(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[10]"));
		return license;
	}

	public static WebElement clickByLicensetypeApplied(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[18]"));
		return license;
	}
	public static WebElement clickByLicnesetypeActive(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[29]"));
		return license;
	}
	public static WebElement clickByLicnesetypeTerminate(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[34]"));
		return license;
	}

public static WebElement clickReadActive(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
	
	}
public static WebElement clickTabelGrid(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[2]"));
	return license;
	
	}
public static WebElement ClickNorecordFound(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[2]/div[1]/div"));
	return license;
	
	}
public static WebElement Progress(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='imgUpdateProgress']"));
	return license;
}
public static WebElement DownloadDocument(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_lblDownLoadfile_4\']"));
	return license;
}
public static WebElement clickByLicnesetypeExpiredInternal(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[3]"));
	return license;
}
public static WebElement clickByLicnesetypeAppliedInternal1(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[5]"));
	return license;
}
public static WebElement clickByLicnesetypeActiveInternal1(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[7]"));
	return license;
}
public static WebElement clickByLicnesetypeTerminateInternal1(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[9]"));
	return license;
}
public static WebElement ClickMyWorkspace(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='leftworkspacemenu']/a"));
	return license;
}
public static WebElement ClickAddLicense(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_AddNewLicense']"));
	return license;

}
public static WebElement ClickLicenseTypeDropdown(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dvBasicDetails']/div[1]/div/div[1]/span[1]/span/span[1]")));
	return license;
}
public static WebElement SelectLicenseType(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlLicenseType_listbox']/li[2]")));
	return license;
}
public static WebElement SelectLicenseTypeperin(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlLicenseType_listbox']/li[2]")));
	return license;
}
public static WebElement SelectLicenseTypeper(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlLicenseType_listbox']/li[53]")));
	return license;
}
public static WebElement ClickLocation(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dvBasicDetails']/div[1]/div/div[1]/span[2]/span/span[1]")));
	return license;
}
public static WebElement SelectLocation(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='k-in'])[283]")));
	
		return license;
}
public static WebElement LocationMaximize(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,40);
	//license=driver.findElement(By.xpath("//*[@id='e26eeec5-7192-40b8-ba66-d3a307b5897c_tv_active']/div/span[1]"));
    license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='k-icon k-i-expand'])[35]")));
	return license;
}
public static WebElement ClickPerformer(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dvHideOnEdit']/div[1]/span[2]/span/span[2]/span")));
	return license;
}
public static List<WebElement> SelectPerformer(WebDriver driver)
{
      elementsList=driver.findElements(By.xpath("//*[@id='ddlPerformer_listbox']/li"));
     return elementsList ; 
	
}
public static WebElement ClickReviewer(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dvHideOnEdit']/div[2]/span[1]/span/span[2]/span")));
	return license;
}
public static List<WebElement> SelectReviewer(WebDriver driver)
{
      elementsList=driver.findElements(By.xpath("//*[@id='ddlReviewer_listbox']/li"));
     return elementsList ; 
	
}

public static WebElement ClickCompliance(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dvHideOnEdit']/div[1]/span[1]/span/span[1]")));
	return license;
}
public static WebElement LicenseTitle(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='txtTitle']"));
	
	return license;
}
public static WebElement LicenseNo(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='txtLicenseNo']"));
	return license;
}
public static WebElement ApplicationDays(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='txtApplicationDays']"));
	return license;
}
public static WebElement LicenseCost(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='txtCost']"));
	return license;
}
public static List<WebElement> SelectLicenseCompliance(WebDriver driver)
{

	  elementsList=driver.findElements(By.xpath("//*[@id='ddlCompliance_listbox']/li[2]"));
     return elementsList; 
	
}

public static WebElement clickExpirydate(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dvBasicDetails']/div[1]/div/div[4]/span/span/span[2]"));
	return license;
}
public static WebElement ClickCal(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//span[@class='k-icon k-i-calendar'])[1]"));
	return license;
}
public static WebElement ClickCal1(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//span[@class='k-icon k-i-calendar'])[2]"));
	return license;
}
public static WebElement SelectExpiryDate1(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='txtEndDate']"));
	return license;
}
public static WebElement SelectStartDate(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='txtStartDate']"));
	return license;
}
public static WebElement NewDate(WebDriver driver)
{
	license = driver.findElement(By.linkText("5"));
	return license;
}
public static WebElement NewEndDate(WebDriver driver)
{
	license = driver.findElement(By.linkText("25"));
	return license;
}
public static WebElement Chooesfile(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dvBasicDetails']/div[1]/div/div[8]/div[1]/div/div/div"));
	return license;
}
public static WebElement ClickNomineedrp(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dvHideNomineeDetailsOnEdit']/div[1]/span[1]/span"));
	return license;
}
public static WebElement SelectNominee(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='drpLicenseNominee_listbox']/li[1]"));
	return license;
}
public static WebElement Clicknomineemodidate(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dvHideNomineeDetailsOnEdit']/div[1]/span[2]/span/span[2]/span"));
	return license;
}
public static WebElement ClickModificdate(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//span[@class='k-icon k-i-calendar'])[3]"));
	return license;
}


public static WebElement ModificatioDate(WebDriver driver)
{
	license = driver.findElement(By.linkText("5"));
	return license;
}
public static WebElement nomineestartdatecal(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dvHideNomineeDetailsOnEdit']/div[2]/span[1]/span/span[2]/span"));
	return license;
}

public static WebElement selectnominstartdate(WebDriver driver)
{
	license = driver.findElement(By.linkText("5"));
	return license;
}
public static WebElement nomineeEnddatecal(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//span[@class='k-icon k-i-calendar'])[5]"));
	return license;
}
public static WebElement selectnomineenddate(WebDriver driver)
{
	license = driver.findElement(By.linkText("15"));
	return license;
}
public static WebElement Nomineesubmit(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='btnSubmit']"));
	return license;
}
public static WebElement lictype(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='Details']/div[1]/span[2]/span/span[1]"));
	return license;
}

public static WebElement lictype1(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[1]"));
	return license;
}

public static WebElement LicesneNo1(WebDriver driver2) {
	// TODO Auto-generated method stub
	return null;
}
public static WebElement mgmtmaximize(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@class='btn-minimize'])[2]"));
	return license;
}
public static WebElement editlicenseclose(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']"));
	return license;
}
public static WebElement Overviewworkspace(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-eye k-grid-eye'])[1]"));
	return license;
}
public static WebElement Nomineetab(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='liNomineeDetails']"));
	return license;
}
public static WebElement CloseOverview(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@class='close'])[2]"));
	return license;
}
public static WebElement WorkspaceExport(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='btnexport']"));
	return license;
}
public static WebElement wrkstatusfiler(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@class='k-dropdown-wrap k-state-default'])[3]"));
	return license;
}
public static WebElement wrkselectstatus(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dropdownlistStatus_listbox']/li[1]"));
	return license;
}
public static WebElement wrklicensetypefiler(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@class='k-input'])[4]"));
	return license;
}
public static WebElement wrkselectlicensetype(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[3]"));
	return license;
}
public static WebElement workspaceclear(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ClearfilterMain']"));
	return license;
}
public static WebElement Type2(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@class='k-dropdown-wrap k-state-default'])[2]"));
	return license;
}
public static WebElement internalType2(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dropdownlistComplianceType_listbox']/li[2]"));
	return license;
}
public static WebElement Perstatus(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@class='k-input'])[3]"));
	return license;
}

public static WebElement typedrp(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@class='k-select'])[1]"));
	return license;
}
public static WebElement selectinternaltype(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dropdownlistComplianceType_listbox']/li[2]"));
	return license;
}
public static WebElement showmoremgmt(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkShowDetailLicense']"));
	return license;
}
public static WebElement clicktypeinternal(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='Details']/div[1]/span[2]"));	
	return license;
}
public static WebElement selecttypein(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[16]"));
	return license;
}





}		

	

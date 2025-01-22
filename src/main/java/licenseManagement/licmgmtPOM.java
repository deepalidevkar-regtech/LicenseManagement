package licenseManagement;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import login.webpage;

public class licmgmtPOM  extends webpage
{
	private static WebElement license = null;
	public static List<WebElement> elementsList = null;
	public static Object Documentstatusdrpver;	
	
	
	public static WebElement clickByLicnesetypeExpired()
	{
		license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[10]"));
		return license;
	}

	public static WebElement clickByLicensetypeApplied()	
	{
		license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[18]"));
		return license;
	}
	public static WebElement clickByLicnesetypeActive()
	{
		license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[29]"));
		return license;
	}
	public static WebElement clickByLicnesetypeTerminate	()
	{
		license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[34]"));
		return license;
	}

public static WebElement clickReadActive	()
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
	
	}
public static WebElement clickTabelGrid	()
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]"));
	return license;
	
	}
public static WebElement ClickNorecordFound	()
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/div[1]/div"));
	return license;
	
	}
public static WebElement Progress()
{
	license = getDriver().findElement(By.xpath("//*[@id='imgUpdateProgress']"));
	return license;
}
public static WebElement DownloadDocument()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_lblDownLoadfile_4\']"));
	return license;
}
public static WebElement clickByLicnesetypeExpiredInternal	()
{
	license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[3]"));
	return license;
}
public static WebElement clickByLicnesetypeAppliedInternal1	()
{
	license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[4]"));
	return license;
}
public static WebElement clickByLicnesetypeActiveInternal1()
{
	license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));
	return license;
}
public static WebElement clickByLicnesetypeTerminateInternal1	()
{
	license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[7]"));
	return license;
}
public static WebElement ClickMyWorkspace	()
{
	license = getDriver().findElement(By.xpath("//*[@id='leftworkspacemenu']/a"));
	return license;
}
public static WebElement ClickAddLicense	()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_AddNewLicense']"));
	return license;

}
public static WebElement ClickLicenseTypeDropdown()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dvBasicDetails']/div[1]/div/div[1]/span[1]/span/span[1]")));
	return license;
}
public static WebElement SelectLicenseType()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlLicenseType_listbox']/li[2]")));
	return license;
}
public static WebElement SelectLicenseTypeperin()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='ddlLicenseType_listbox'])/li[1]")));
	return license;
}
public static WebElement SelectLicenseTypeper()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='k-item'])[100]")));
	return license;
}
public static WebElement SelectLicenseTyperev()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ddlLicenseType_listbox']/li[53]")));
	return license;
}
public static WebElement ClickLocation()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dvBasicDetails']/div[1]/div/div[1]/span[2]/span/span[1]")));
	return license;
}
public static WebElement SelectLocation()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='k-in'])[44]")));
	
	return license;
}
public static WebElement LocationMaximize()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	//license=getDriver().findElement(By.xpath("//*[@id='e26eeec5-7192-40b8-ba66-d3a307b5897c_tv_active']/div/span[1]"));
    license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='k-icon k-i-expand'])[35]")));
	return license;
}
public static WebElement LocationMaximizeper()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	//license=getDriver().findElement(By.xpath("//*[@id='e26eeec5-7192-40b8-ba66-d3a307b5897c_tv_active']/div/span[1]"));
    license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='k-icon k-i-expand'])[17]")));
	return license;
}
public static WebElement ClickPerformer()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dvHideOnEdit']/div[1]/span[2]/span/span[2]/span")));
	return license;
}
public static List<WebElement> SelectPerformer()
{
      elementsList=getDriver().findElements(By.xpath("//*[@id='ddlPerformer_listbox']/li"));
     return elementsList ; 
	
}
public static WebElement ClickReviewer()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dvHideOnEdit']/div[2]/span[1]/span/span[2]/span")));
	return license;
}
public static List<WebElement> SelectReviewer()
{
      elementsList=getDriver().findElements(By.xpath("//*[@id='ddlReviewer_listbox']/li"));
     return elementsList ; 
	
}

public static WebElement ClickCompliance()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dvHideOnEdit']/div[1]/span[1]/span/span[1]")));
	return license;
}
public static WebElement LicenseTitle()
{
	license = getDriver().findElement(By.xpath("//*[@id='txtTitle']"));
	
	return license;
}
public static WebElement LicenseNo()
{
	license = getDriver().findElement(By.xpath("//*[@id='txtLicenseNo']"));
	return license;
}
public static WebElement ApplicationDays()
{
	license = getDriver().findElement(By.xpath("//*[@id='txtApplicationDays']"));
	return license;
}
public static WebElement LicenseCost()
{
	license = getDriver().findElement(By.xpath("//*[@id='txtCost']"));
	return license;
}
public static List<WebElement> SelectLicenseCompliance()
{

	  elementsList=getDriver().findElements(By.xpath("//*[@id='ddlCompliance_listbox']/li[2]"));
     return elementsList; 
	
}

public static WebElement clickExpirydate()
{
	license = getDriver().findElement(By.xpath("//*[@id='dvBasicDetails']/div[1]/div/div[4]/span/span/span[2]"));
	return license;
}
public static WebElement ClickCal()
{
	license = getDriver().findElement(By.xpath("(//span[@class='k-icon k-i-calendar'])[1]"));
	return license;
}
public static WebElement ClickCal1()
{
	license = getDriver().findElement(By.xpath("(//span[@class='k-icon k-i-calendar'])[2]"));
	return license;
}
public static WebElement SelectExpiryDate1()
{
	license = getDriver().findElement(By.xpath("//*[@id='txtEndDate']"));
	return license;
}
public static WebElement SelectStartDate()
{
	license = getDriver().findElement(By.xpath("//*[@id='txtStartDate']"));
	return license;
}
public static WebElement NewDate()
{
	license = getDriver().findElement(By.linkText("5"));
	return license;
}
public static WebElement NewEndDate()
{
	license = getDriver().findElement(By.linkText("25"));
	return license;
}
public static WebElement Chooesfile()
{
	license = getDriver().findElement(By.xpath("//*[@id='dvBasicDetails']/div[1]/div/div[8]/div[1]/div/div/div"));
	return license;
}
public static WebElement ClickNomineedrp()
{
	license = getDriver().findElement(By.xpath("//*[@id='dvHideNomineeDetailsOnEdit']/div[1]/span[1]/span"));
	return license;
}
public static WebElement SelectNominee()
{
	license = getDriver().findElement(By.xpath("//*[@id='drpLicenseNominee_listbox']/li[1]"));
	return license;
}
public static WebElement Clicknomineemodidate()
{
	license = getDriver().findElement(By.xpath("//*[@id='dvHideNomineeDetailsOnEdit']/div[1]/span[2]/span/span[2]/span"));
	return license;
}
public static WebElement ClickModificdate()
{
	license = getDriver().findElement(By.xpath("(//span[@class='k-icon k-i-calendar'])[3]"));
	return license;
}


public static WebElement ModificatioDate()
{
	license = getDriver().findElement(By.linkText("5"));
	return license;
}
public static WebElement nomineestartdatecal()
{
	license = getDriver().findElement(By.xpath("//*[@id='dvHideNomineeDetailsOnEdit']/div[2]/span[1]/span/span[2]/span"));
	return license;
}

public static WebElement selectnominstartdate()
{
	license = getDriver().findElement(By.linkText("5"));
	return license;
}
public static WebElement nomineeEnddatecal()
{
	license = getDriver().findElement(By.xpath("(//span[@class='k-icon k-i-calendar'])[5]"));
	return license;
}
public static WebElement selectnomineenddate()
{
	license = getDriver().findElement(By.linkText("15"));
	return license;
}
public static WebElement Nomineesubmit()
{
	license = getDriver().findElement(By.xpath("//*[@id='btnSubmit']"));
	return license;
}
public static WebElement btnsavenominee()
{
	license = getDriver().findElement(By.xpath("//*[@id='btnSaveNominee']"));
	return license;
}

public static WebElement lictype()
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-dropdown-wrap k-state-default'])[1]"));
	return license;
}

public static WebElement lictype1()
{
	license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[1]"));
	return license;
}

public static WebElement LicesneNo1 ()
{
	// TODO Auto-generated method stub
	return null;
}
public static WebElement mgmtmaximize()
{
	license = getDriver().findElement(By.xpath("(//*[@class='btn-minimize'])[2]"));
	return license;
}
public static WebElement editlicenseclose()
{
	license = getDriver().findElement(By.xpath("//*[@class='k-button k-bare k-button-icon k-window-action']"));
	return license;
}
public static WebElement Overviewworkspace()
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-eye k-grid-eye'])[1]"));
	return license;
}
public static WebElement Nomineetab()
{
	license = getDriver().findElement(By.xpath("//*[@id='liNomineeDetails']"));
	return license;
}
public static WebElement CloseOverview()
{
	license = getDriver().findElement(By.xpath("(//*[@class='close'])[2]"));
	return license;
}
public static WebElement WorkspaceExport()
{
	license = getDriver().findElement(By.xpath("//*[@id='btnexport']"));
	return license;
}
public static WebElement wrkstatusfiler()
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-dropdown-wrap k-state-default'])[3]"));
	return license;
}
public static WebElement wrkselectstatus()
{
	license = getDriver().findElement(By.xpath("//*[@id='dropdownlistStatus_listbox']/li[1]"));
	return license;
}
public static WebElement wrklicensetypefiler()
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-input'])[4]"));
	return license;
}
public static WebElement wrkselectlicensetype()
{
	license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[3]"));
	return license;
}
public static WebElement workspaceclear()
{
	license = getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']"));
	return license;
}
public static WebElement Type2()
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-dropdown-wrap k-state-default'])[2]"));
	return license;
}
public static WebElement internalType2()
{
	license = getDriver().findElement(By.xpath("//*[@id='dropdownlistComplianceType_listbox']/li[2]"));
	return license;
}
public static WebElement Perstatus()
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-input'])[3]"));
	return license;
}

public static WebElement typedrp()
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-select'])[1]"));
	return license;
}
public static WebElement selectinternaltype()
{
	license = getDriver().findElement(By.xpath("//*[@id='dropdownlistComplianceType_listbox']/li[2]"));
	return license;
}
public static WebElement showmoremgmt()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkShowDetailLicense']"));
	return license;
}
public static WebElement clicktypeinternal()
{
	license = getDriver().findElement(By.xpath("//*[@id='Details']/div[1]/span[2]"));	
	return license;
}
public static WebElement selecttypein()
{
	license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[2]"));
	return license;
}
public static WebElement editlicbtn()
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]"));
	return license;
}
public static WebElement addnombtn()
{
	license = getDriver().findElement(By.xpath("//*[@id='btnAddNomineeDetails']"));
	return license;
}
public static WebElement savenominee()
{
	license = getDriver().findElement(By.xpath("//*[@id='btnSaveNominee']"));
	return license;
}
public static WebElement prinomineedetails()
{
	license = getDriver().findElement(By.xpath("//*[@id='gridNomineeDetails']/div[2]/table/tbody/tr/td[1]"));
	return license;
}
public static WebElement Documentstatusdrp()
{
	license = getDriver().findElement(By.xpath("//*[@class='k-dropdown-wrap k-state-default k-state-focused']"));
	return license;
}
public static WebElement drplocationclick()
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-input k-readonly'])[1]"));
	return license;
}
public static WebElement Customerexpand()
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-group k-treeview-lines'])[1]"));
	return license;
}
public static WebElement BranchExpand()
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-collapse'])[3]"));
	return license;
}

public static WebElement EntityExpand()
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[12]"));
	return license;
}


}		

	

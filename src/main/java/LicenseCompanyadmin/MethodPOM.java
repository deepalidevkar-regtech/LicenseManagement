package licenseCompanyadmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import login.webpage;

public class MethodPOM  extends webpage
{
	public static final String ClickActiveOverview = null;
	private static WebElement license = null;	
	public static List<WebElement> elementsList = null;
	private static List<WebElement> elementlist;
public static WebElement clickMasterMenu()
	
	{
	    WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='leftmastermenu']/a/span[1]")));
		return license;
		
	}
public static WebElement clickUserMaster()
	
	{
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[1]/a")));
		return license;
		
	}
public static WebElement clickAddUser()

{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAddUser']/span")));
	return license;
	
}
public static WebElement ClickUername()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxFirstName']")));
	return license;
}
public static WebElement ClickLastName()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxLastName']")));
	return license;
}

public static WebElement ClickDesignation()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxDesignation']")));
	return license;
}
public static WebElement ClickUserGmail()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxEmail']")));
	return license;
}
public static WebElement ClickMobileNo()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxContactNo']")));
	return license;
}
public static WebElement ClickRoleDropdown()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseRole']")));
	return license;
}
public static WebElement ClickRoleNonadmin()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseRole']/option[4]")));
	return license;
}
public static WebElement ClickDepartmentDropdown()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartment']")));
	return license;
}
public static WebElement ClickDepartment()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartment']/option[4]")));
	return license;
}

public static WebElement ClickUserSave()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnSave']")));
	return license;
}
public static WebElement ClickLocationDropdown()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxBranch']")));
	return license;
}
public static WebElement ClickLocation()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tvBranchest1']")));
	return license;
}
public static WebElement ClickUserClose()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")));
	return license;
}
public static WebElement ClickEditUser()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdUser_lbtnEdit_0']")));
	return license;
}
public static WebElement ClickPageAuthorization()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[5]/a")));
	return license;
}
public static WebElement ClickResetPassword()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdUser_lbtnReset_0']")));
	return license;
}
public static WebElement ClickAutheruser()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlUser_chosen']/a/span")));
	return license;
}
public static WebElement ClickSelectUser()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlUser_chosen']/div/ul")));
	return license;
}
public static WebElement ClickAddAuthAddCheck()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdDisplayUserdata_chkADD_1']")));
	return license;
}
public static WebElement ClickPageAutherSave()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnSavePageAutorization']")));
	return license;
}
public static WebElement ClickUserSearch()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilter']")));
	return license;
}
public static WebElement ClickPageAutherAll()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']")));
	return license;
}
public static WebElement ClickPageAutherInternal()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']/option[2]")));
	return license;
}

public static WebElement ClickRenewLicenseMenu()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[4]")));
	return license;
}
public static WebElement ClickReneweditStatutoryLicense()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_lnkEditLicense_0']")));
	return license;  
}

public static WebElement ClickLiceneFream()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='showdetails']")));
	return license;
}
public static WebElement ClickLicenseNumber()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='txtLicenseNo']")));
	return license;
}
public static WebElement ClickLicenseTitle()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='txtLicenseTitle']")));
	return license;
}
public static WebElement ClickLicenseStartDate()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='txtStartDate']")));
	return license;
}
public static WebElement LicenseEnddate()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='txtEndDate']")));
	return license;
}
public static WebElement LicenseUploadDocument()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='fuSampleFile']")));
	return license;
}
public static WebElement FileNumber()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='txtFileno']")));
	return license;
}
public static WebElement RenewLicenseSubmit()
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSave']")));
	return license;
}
public static WebElement RenewLicenseClose() 
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));

	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnClose']")));
	return license;
}
public static WebElement selectLicense() 
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));

	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']")));
	return license;
}
public static WebElement selectInternalLicense() 
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));

	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']/option[2]")));
	return license;
}
public static WebElement clickActive()	
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divActiveCount']"));
	return license;
}

public static WebElement clickReadActive()	
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement ClickActiveOverview()	

{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-eye k-grid-eye'])[1]"));
	
	return license;
}
public static WebElement ClickCloseOverview()	
{
	license = getDriver().findElement(By.xpath("//*[@id=\"divApiOverView\"]/div/div/div[1]/button"));
	return license;
}
public static WebElement clickMyDashboard()	
{
	license = getDriver().findElement(By.xpath("//*[@id='leftdashboardmenu']"));
	return license;
}
public static WebElement clickExpiring()	
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divExpiringcount']"));
	return license;
}

public static WebElement clickReadExpiring()	
{
	WebDriverWait wait = new WebDriverWait( getDriver(), (30));
	license = getDriver().findElement(By.xpath("//*[@id=\"grid\"]/div[3]/span[2]"));
	return license;
}
public static WebElement clickExpired()	
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divExpiredCount']"));
	return license;
}
public static WebElement clickReadExpired()	
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickApplied()	
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divAppliedcount']"));
	return license;
}
public static WebElement clickReadApplied()	
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickpendingforreview()	
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPendingForReview']"));
	return license;
}
public static WebElement clickReadpendingforreview()	
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickRejected()	
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divRejected']"));
	return license;
}
public static WebElement clickReadRejected()	
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickTerminate()	
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divTerminate']"));
	return license;
}
public static WebElement clickTerminateper()	
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divterminated']"));
	
	return license;
}
public static WebElement clickTerminateperin()	
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divterminated']"));
	return license;
}

public static WebElement clickReadTerminate()	
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement AllFilter()	
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']"));
	return license;
}
public static WebElement InternalFilter()	
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']/option[2]"));
	return license;
}
public static WebElement ClickApply()	
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnFilter']"));
	return license;
}
public static WebElement ClickMaximizeLicenseExpiredOn()	
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_UpdatePanel3']/div/div/div[1]/div[3]/a/i"));
	return license;
}
public static WebElement ClickMaximizeLicenseExpiringOn()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='btn-minimize'])[3]"));
	return license;
}
public static WebElement ClickShowMoreExpiredOnInternal()	
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkLicExpiredshowMore']"));
	return license;
}
public static WebElement ClickShowMoreExpiredOnStatutory()	
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_LinkButton1']"));
	
	
	return license;
}
public static WebElement ClickShowMoreExpiringOnStatutory()	
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_LinkButton2']"));
	return license;
}
public static WebElement ClickExportExpiredOn()	
{
	license = getDriver().findElement(By.xpath("//*[@id='exportReport']"));
	return license;
}
public static WebElement ClickExportExpiredOn1()	
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnExportExcelExpired']"));
	return license;
	//*[@id="ContentPlaceHolder1_btnExportExcelExpired"]/img
}
public static WebElement ClickExportExpiredOn1cmd()	
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_LinkButton3']"));
	return license;
	
}

public static WebElement ClickExpiringOn()	
{
	license = getDriver().findElement(By.xpath("//*[@id='exportReport']"));
	return license;
}
public static WebElement ClickOverviewExpiredOn()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[2]"));
	
	return license;
}
public static WebElement ClickOverviewExpiringOn()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]"));
	return license;
}
public static WebElement clickExpringbutnotApplied()	
{
	license = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 ']"));
	return license;
}
public static WebElement clickByStatsExpiringReadcount()	
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickExportGraph()	
{
	license = getDriver().findElement(By.xpath("//*[@id='exportReport']"));
	return license;
}
public static WebElement overviewclose()	
{
	license = getDriver().findElement(By.xpath("//*[@id='divGraphDetails']/div/div/div[1]/button"));
	return license;
}
//*[@id="divGraphDetails"]/div/div/div[1]/button
public static WebElement clickGraphoverview()	
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[8]/a"));
	return license;
}
public static WebElement clickCloseGraphPopup()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='close'])[2]"));
	return license;
}
public static WebElement clickBystatuscloseoverview()	
{
	license = getDriver().findElement(By.xpath("//*[@id='divOverView']/div/div/div[1]/button"));
	
	
	return license;
}
public static WebElement clickBystatusTerminate()	
{
	license = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 ']"));
	return license;
}
public static WebElement clickBystatusTerminateReadCount()	
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickBystatusTerminateOverview()	
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[8]/a"));
	return license;
}
public static WebElement clickBystatusActive()	
{
	license = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 ']"));
	
	return license;
}
public static WebElement clickBystatusActiveReadCount()	
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickBystatusActiveOverview()	
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[8]/a"));
	
	return license;
}
public static WebElement clickBystatusExpiredappliedbutnotrenewed()	
{
	license = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 ']"));
	return license;
}
public static WebElement clickBystatusRejected()	
{
	license = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-5 ']"));
	return license;
}



public static WebElement clickBystatusExpiredappliedbutnotrenewedReadCount()	
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickBystatusExpiredappliedbutnotrenewedOverview()	
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[8]/a"));
	return license;
}
public static WebElement clickBystatusRejectedverview()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]"));
	return license;
}

public static WebElement clickBystatusExpired()	
{
	license = getDriver().findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 ']"));
	return license;
}
public static WebElement clickAllReadcount()	
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickAllOverview()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]"));
	
	return license;
}
public static WebElement clickByLicnesetypeExpired()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[2]"));
	return license;
}
public static WebElement clickByLicnesetypeExpiredInternal()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[2]"));
	return license;
}
public static WebElement clickByLicnesetypeExpiring()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));
	return license;
}
public static WebElement clickByLicnesetypeApplied()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[3]"));
	return license;
}
public static WebElement clickByLicnesetypeAppliedInternal()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[23]"));
	return license;
}
public static WebElement clickByLicnesetypeActive()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[4]"));
	return license;
}
public static WebElement clickByLicnesetypeActiveInternal()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[4]"));
	return license;
}
public static WebElement clickByLicnesetypeTerminate()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[5]"));
	return license;
}
public static WebElement clickByLicnesetypeRejected()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[6]"));
	return license;
}

public static WebElement clickByLicnesetypeTerminateInternal()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[5]"));
			
	return license;
}
public static WebElement clickByLicnesetypeRejectedInternal()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[6]"));
			
	return license;
}
public static WebElement clickByLicnesetypeRejectedmgmtInternal()	
{
	license = getDriver().findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[6]"));
			
	return license;
}
public static WebElement checkTable1()
{
	license = getDriver().findElement(By.xpath("//*[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[1]"));
	return license;
}
public static WebElement DownloadDocument()
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-download1 k-grid-edit4'])[1]"));
	return license;
}

public static WebElement ViewDocument()
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]"));
	return license;
}
public static WebElement closeViewDocument()
{
	license = getDriver().findElement(By.xpath("(//*[@class='close'])[1]"));
	return license;
}
public static WebElement Progress()
{
	license = getDriver().findElement(By.xpath("//*[@id='imgUpdateProgress']"));
	return license;
}
public static WebElement ClickShareOption()
{
	license = getDriver().findElement(By.xpath("//*[@id='divOpenPermissionPopup']/div/div/div[2]"));
	return license;
}
public static WebElement ClickOnDashExpiredExport()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnExportExcelExpired']/img"));
	return license;
}
public static WebElement ClickDashOverviewClose()
{
	license = getDriver().findElement(By.xpath("//*[@id='divGraphDetails']/div/div/div[1]/button"));
	return license;
}
public static WebElement ClickLicenseActivation()
{
	license = getDriver().findElement(By.xpath("//*[@id='Mastersubmenu']/li[2]/a"));
	return license;
}
public static WebElement LicenseNewAssignment()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_liNotAssigned']"));
	return license;
}

public static WebElement ClickLicenseType()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType1_chosen']/a/span"));

	return license;
}
public static WebElement SearchLicenseType()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType1_chosen']/div/div/input"));
	

	return license;
}
public static WebElement Licensetype()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/a"));
	return license;
}
public static WebElement ClickLocation1()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocation1']"));
	return license;
}
public static WebElement ClickLocationin()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocation1n3CheckBox']"));
	return license;
}

public static WebElement CheckLocation()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocation1n2CheckBox']"));
	return license;
}
public static WebElement SelectLocation()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnlocation1']"));
	return license;
}
public static WebElement CheckCompliance()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_chkbox_0']"));

	return license;
}
public static WebElement CheckCompliancein()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_chkbox1_0']"));
	return license;
}
public static WebElement ClickPerformer()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_ddlPerformer_0']"));
	return license;
}

public static WebElement SelectLicensePerformer()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_ddlPerformer_0']/option[30]"));
	return license;
}
public static WebElement ClickReviewer()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_ddlReviewer_0']"));
	return license;
}
public static WebElement SelectLicenseReviewer()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_ddlReviewer_0']/option[40]"));
	return license;
}
public static WebElement AddAssignmentButton()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnSaveLicense1']"));

	return license;
}
public static WebElement readResponseMsg()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_vsLicenseListPage1']/ul/li"));
	return license;
}
public static WebElement CheckCompliance1()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_chkbox_0']"));
	return license;
}
public static WebElement ClickLicensetype1()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/a/span"));
	return license;
}
public static WebElement SearchLicenseType1()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/div/div/input"));
	return license;
}
public static WebElement LicesneNo1()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_txtLicenseNo_0']"));
	return license;
}
public static WebElement LicesneTitle1()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_txtTitle_0']"));
	return license;
}
public static WebElement StartDate1()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_txtStartDate_0']"));
	return license;
}
public static WebElement EndDate1()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_txtEndDate_0']"));
	return license;
}
public static WebElement SaveButton()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnSaveLicense']"));
	return license;
}
public static WebElement Message()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_vsLicenseListPage']/ul/li"));
	return license;
}
public static WebElement InternalCreationMenu()
{
	license = getDriver().findElement(By.xpath("//*[@id='Mastersubmenu']/li[3]/a"));
	return license;
}
public static WebElement ClickInternalLicenseType()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/a/span"));
	return license;
}
public static WebElement SearchInternalLicenseType()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/div/div/input"));
	return license;
}
public static WebElement Clickaftershare()
{
	license = getDriver().findElement(By.xpath("//*[@id='divOpenPermissionPopup']/div/div/div[2]/div[3]/div/label"));
	return license;
}
public static WebElement clickDashlicensetype()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/a/span"));
	return license;
}
public static WebElement DashSearchLienseType()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/div/div/input"));
	return license;
}
public static WebElement DashoardClearBtn()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnClearFilter']"));
	return license;
}
public static WebElement ExpiredOnLictype()
{
	license = getDriver().findElement(By.xpath("//*[@id=\"Details\"]/div[1]/span[2]/span/span[1]"));
	return license;
}
public static WebElement searchExpiredOnLictype()
{
	license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType-list']/span/input"));
	return license;
}
public static WebElement Clearfilter()
{
	license = getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']"));
	return license;

}
public static WebElement DashExpiringOnExport()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnExportExcelExpiring']/img"));
	return license;
	
}
public static WebElement DashExpiringOnExportcmd()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_LinkButton4']"));
	return license;
	
}
public static WebElement BystatusExpiringLicensetype()
{
	license = getDriver().findElement(By.xpath("//*[@id='Details']/div[1]/span[2]/span/span[1]"));
	
	return license;
}
public static WebElement BystatusExpiringsearchLicensetype()
{
	license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType-list']/span/input"));
	return license;
}
public static WebElement GraphPopupClear()
{
	license = getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']"));
	
	return license;
}
public static WebElement Clicllicensetype()
{
	license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[53]"));
	return license;
}
public static WebElement ClicllicensetypeInr()
{
	license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[1]"));
	return license;
}
public static WebElement ClicllicensetypeInternalapplied()
{
	license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[53]"));
	return license;
}
public static WebElement CliclInternallicensetype()
{
	license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[1]"));
	return license;
}
public static WebElement ClicllicensetypeInternal()
{
	license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[10]"));
	return license;
}
public static WebElement ClicllicensetypeInternal1()
{
	license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[1]"));
	return license;
}
public static WebElement ClickMyWorkspace()
{
	license = getDriver().findElement(By.xpath("//*[@id='leftworkspacemenu']/a/span[1]"));
	return license;
}
public static WebElement clickWrklictype()
{
	license = getDriver().findElement(By.xpath("//*[@id='MainContentCW']/div[1]/span[4]/span/span[1]"));
	return license;
}
public static WebElement Searchtype()
{
	license = getDriver().findElement(By.xpath("(//*[@id='dropdownlistLicenseType-list']/span/input)[2]"));
	return license;
}
public static WebElement clicklic()
{
	license = getDriver().findElement(By.linkText("Boiler"));
	return license;
}
public static WebElement Click1()
{
	license = getDriver().findElement(By.xpath("(//*[@id='dropdownlistLicenseType_listbox']/li[53])[2]"));
	return license;
}
public static WebElement MyworkspaceOverview()
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[4]/td[13]/a[2]"));
	return license;
}
public static WebElement Overviewclose()
{
	license = getDriver().findElement(By.xpath("//*[@id='divApiOverView']/div/div/div[1]/button"));
	return license;
}
public static WebElement AddNewLic()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_AddNewLicense']"));
	return license;
}
public static WebElement justclick()
{
	license = getDriver().findElement(By.xpath("//*[@id='divUploadDocument']/table"));
	return license;
}



public static WebElement Expiringshowmore() {
	// TODO Auto-generated method stub
	return null;
}
public static WebElement DeleteFolder() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_upPromotorList']/div/div/div/section/div[2]/div[2]/img[3]"));
	return license;
}
public static WebElement CDocumentDownload() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_upPromotorList']/div/div/section/div[3]/div/div[2]/img[2]"));
	return license;
}

public static WebElement editFolderD() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_upPromotorList']/div/div/section/div[3]/div/div[2]/img[4]"));
	return license;
}

public static WebElement DocumentHeader() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_TxtDocHeader']"));
	return license;
}
public static WebElement DocumentDescription() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_TxtDescription']"));
	return license;
}
public static WebElement DocumentOther() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_TxtOthers']"));
	return license;
}
public static WebElement DocumentProcess() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_TxtProcess']"));
	return license;
}
public static WebElement Documentsubprocess() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_TxtSubProcess']"));
	return license;
}
public static WebElement Vertical() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_TxtVertical']"));
	return license;
}
public static WebElement DocumentLocation() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_TxtLocation']"));
	return license;
}
public static WebElement Updateinfobtn() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnUpdateInfo']"));
	return license;
}
public static WebElement closedocpopup() {
	license = getDriver().findElement(By.xpath("//*[@id='divOpenNewInformationPopup']/div/div/div[1]/button"));
	return license;
}
public static WebElement renamemsg() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_FolderValidation']/ul/li"));
	return license;
}
public static WebElement FirstFolder() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdFolderDetail_LinkButton1_0']"));
	return license;
}
public static WebElement LinkFolder() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_upPromotorList']/div/div/section/div[3]/div/div[2]/img[6]"));
	return license;
}
public static WebElement Linkdocument1() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdChecklist_CheckBox1_0']"));
	return license;
}

public static WebElement Linkdocument2() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdChecklist_CheckBox1_1']"));
	return license;
}

public static WebElement LinkSave() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnSaveChecklistMapping']"));
	return license;
}
public static WebElement Linkclose() {
	license = getDriver().findElement(By.xpath("//*[@id='divAuditChecklistPopup']/div/div/div[1]/button"));
	return license;
}
public static WebElement clickShareFolder() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_upPromotorList']/div/div/div/section/div[2]/div[2]/img[1]"));
	return license;
}
public static WebElement ClickFolder() {
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdFolderDetail_LinkButton1_0']"));
	return license;
}
public static WebElement DeleteFile() {
	license = getDriver().findElement(By.xpath("//*[@class='deletedrive']"));
	return license;
}
public static WebElement Folback()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkMyDrive']"));
	return license;
}
public static WebElement Norecord()
{
	license = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	
	return license;
}
public static void user() {
	// TODO Auto-generated method stub
	
}
public static WebElement licdropdown()
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-arrow-60-down'])[2]"));
	
	return license;
}
public static WebElement selecttype()
{
	license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[16]"));
	
	return license;
}
public static WebElement selecttypecomadmin()
{
	license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[2]"));
	
	return license;
}

public static WebElement selectinttype()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']"));
	
	return license;
}
public static WebElement selectinttype1()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']/option[2]"));
	
	return license;
}
public static WebElement valimsg()
{
	license = getDriver().findElement(By.xpath("//*[@id='VSLicensePopup']"));
	
	return license;
}
public static WebElement selectintype()
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-dropdown-wrap k-state-default'])[2]"));
	
	return license;
}
public static WebElement selectinttype11()
{
	license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[2]"));
	
	return license;
}
public static WebElement addlicensebtn1()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddnew']"));
	
	return license;
}
public static WebElement ispermanentcheckbox()
{
	license = getDriver().findElement(By.xpath("//*[@id='ChkIsActive']"));
	
	return license;
}
public static WebElement addlicplusebtn()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_lnkViewLicenseInstance_0']"));
	return license;
}
public static WebElement selectbtn()
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnlocation1']"));
	return license;
}
public static WebElement ReviewerColumn() 
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-link'])[6]"));
	return license;
}
public static WebElement ExpiredHide() 
{
	license = getDriver().findElement(By.xpath("(//*[@class='highcharts-point'])[126]-"));
	return license;
}
public static WebElement OverviewDesc() 
{
	license = getDriver().findElement(By.xpath("//*[@id='licomplianceoverview']"));	
	return license;
}
public static WebElement Folferlert() 
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_FolderValidation']"));	
	return license;
}
public static WebElement clickDashlictype() 
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType']"));	
	return license;
}
public static WebElement serachlic1() 
{
	license = getDriver().findElement(By.xpath("(//input[@type='text'])[4]"));	
	return license;
}
public static WebElement Performerserachlic1() 
{
	license = getDriver().findElement(By.xpath("(//input[@type='text'])[2]"));	
	return license;
}
public static WebElement Documentstatusclick() 
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-input'])[2]"));	
	return license;
}
public static WebElement Documentselectstatus() 
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-item'])[20]"));	
	return license;
}
public static WebElement Documentlictypeclick() 
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-input'])[3]"));	
	return license;
}
public static WebElement Documentlictypeselect() 
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-item'])[56]"));	
	return license;
}
public static WebElement Documentlictypeselectin() 
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-item'])[56]"));	
	return license;
}
public static WebElement lll() 
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label'])[2]"));	
	return license;
}
public static WebElement Newlocation() 
{
	license = getDriver().findElement(By.xpath("//*[@class='k-item k-first k-last']"));	
	return license;
}
public static WebElement Newlocationsub() 
{
	license = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[15]"));	
	return license;
}

public static WebElement DashboardEntityclick() 
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocation']"));	
	return license;
}
public static WebElement Entitypluseclick() 
{
	license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocationn1']"));	
	return license;
	
}
public static WebElement Dashselectloc() 
{
	license = getDriver().findElement(By.xpath("(//*[@class='ContentPlaceHolder1_tvFilterLocation_0 ContentPlaceHolder1_tvFilterLocation_1'])[5]"));	
	return license;
}
}

package licenseCompanyadmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class MethodPOM 
{
	private static WebElement license = null;	
	public static List<WebElement> elementsList = null;
	private static List<WebElement> elementlist;
public static WebElement clickMasterMenu(WebDriver driver)
	
	{
		WebDriverWait wait= new WebDriverWait(driver,50);
		license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='leftmastermenu']/a/span[1]")));
		return license;
		
	}
public static WebElement clickUserMaster(WebDriver driver)
	
	{
		WebDriverWait wait= new WebDriverWait(driver,20);
		license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[1]/a")));
		return license;
		
	}
public static WebElement clickAddUser(WebDriver driver)

{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnAddUser']/span")));
	return license;
	
}
public static WebElement ClickUername(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxFirstName']")));
	return license;
}
public static WebElement ClickLastName(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxLastName']")));
	return license;
}

public static WebElement ClickDesignation(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxDesignation']")));
	return license;
}
public static WebElement ClickUserGmail(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxEmail']")));
	return license;
}
public static WebElement ClickMobileNo(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxContactNo']")));
	return license;
}
public static WebElement ClickRoleDropdown(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseRole']")));
	return license;
}
public static WebElement ClickRoleNonadmin(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseRole']/option[4]")));
	return license;
}
public static WebElement ClickDepartmentDropdown(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartment']")));
	return license;
}
public static WebElement ClickDepartment(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlDepartment']/option[4]")));
	return license;
}

public static WebElement ClickUserSave(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnSave']")));
	return license;
}
public static WebElement ClickLocationDropdown(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxBranch']")));
	return license;
}
public static WebElement ClickLocation(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tvBranchest1']")));
	return license;
}
public static WebElement ClickUserClose(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnCancel']")));
	return license;
}
public static WebElement ClickEditUser(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdUser_lbtnEdit_0']")));
	return license;
}
public static WebElement ClickPageAuthorization(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[5]/a")));
	return license;
}
public static WebElement ClickResetPassword(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdUser_lbtnReset_0']")));
	return license;
}
public static WebElement ClickAutheruser(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlUser_chosen']/a/span")));
	return license;
}
public static WebElement ClickSelectUser(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlUser_chosen']/div/ul")));
	return license;
}
public static WebElement ClickAddAuthAddCheck(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdDisplayUserdata_chkADD_1']")));
	return license;
}
public static WebElement ClickPageAutherSave(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_btnSavePageAutorization']")));
	return license;
}
public static WebElement ClickUserSearch(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilter']")));
	return license;
}
public static WebElement ClickPageAutherAll(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']")));
	return license;
}
public static WebElement ClickPageAutherInternal(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']/option[2]")));
	return license;
}

public static WebElement ClickRenewLicenseMenu(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,30);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='Mastersubmenu']/li[4]")));
	return license;
}
public static WebElement ClickReneweditStatutoryLicense(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,30);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_lnkEditLicense_0']")));
	return license;  
}

public static WebElement ClickLiceneFream(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,30);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='showdetails']")));
	return license;
}
public static WebElement ClickLicenseNumber(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,30);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='txtLicenseNo']")));
	return license;
}
public static WebElement ClickLicenseTitle(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,30);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='txtLicenseTitle']")));
	return license;
}
public static WebElement ClickLicenseStartDate(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,30);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='txtStartDate']")));
	return license;
}
public static WebElement LicenseEnddate(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,30);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='txtEndDate']")));
	return license;
}
public static WebElement LicenseUploadDocument(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,30);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='fuSampleFile']")));
	return license;
}
public static WebElement FileNumber(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,30);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='txtFileno']")));
	return license;
}
public static WebElement RenewLicenseSubmit(WebDriver driver)
{
	WebDriverWait wait= new WebDriverWait(driver,30);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSave']")));
	return license;
}
public static WebElement RenewLicenseClose(WebDriver driver) 
{
	WebDriverWait wait= new WebDriverWait(driver,30);

	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnClose']")));
	return license;
}
public static WebElement selectLicense(WebDriver driver) 
{
	WebDriverWait wait= new WebDriverWait(driver,30);

	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']")));
	return license;
}
public static WebElement selectInternalLicense(WebDriver driver) 
{
	WebDriverWait wait= new WebDriverWait(driver,30);

	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']/option[2]")));
	return license;
}
public static WebElement clickActive(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divActiveCount']"));
	return license;
}

public static WebElement clickReadActive(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement ClickActiveOverview(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-eye k-grid-eye'])[1]"));
	
	return license;
}
public static WebElement ClickCloseOverview(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id=\"divApiOverView\"]/div/div/div[1]/button"));
	return license;
}
public static WebElement clickMyDashboard(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='leftdashboardmenu']"));
	return license;
}
public static WebElement clickExpiring(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divExpiringcount']"));
	return license;
}

public static WebElement clickReadExpiring(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id=\"grid\"]/div[3]/span[2]"));
	return license;
}
public static WebElement clickExpired(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divExpiredCount']"));
	return license;
}
public static WebElement clickReadExpired(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickApplied(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divAppliedcount']"));
	return license;
}
public static WebElement clickReadApplied(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickpendingforreview(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPendingForReview']"));
	return license;
}
public static WebElement clickReadpendingforreview(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickRejected(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divRejected']"));
	return license;
}
public static WebElement clickReadRejected(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickTerminate(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divTerminate']"));
	return license;
}
public static WebElement clickTerminateper(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divTerminate']"));
	
	return license;
}
public static WebElement clickTerminateperin(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divterminated']"));
	
	return license;
}

public static WebElement clickReadTerminate(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement AllFilter(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']"));
	return license;
}
public static WebElement InternalFilter(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']/option[2]"));
	return license;
}
public static WebElement ClickApply(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnFilter']"));
	return license;
}
public static WebElement ClickMaximizeLicenseExpiredOn(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_UpdatePanel3']/div/div/div[1]/div[3]/a/i"));
	return license;
}
public static WebElement ClickMaximizeLicenseExpiringOn(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='btn-minimize'])[3]"));
	return license;
}
public static WebElement ClickShowMoreExpiredOnInternal(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkLicExpiredshowMore']"));
	return license;
}
public static WebElement ClickShowMoreExpiredOnStatutory(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_LinkButton1']"));
	
	
	return license;
}
public static WebElement ClickShowMoreExpiringOnStatutory(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_LinkButton2']"));
	return license;
}
public static WebElement ClickExportExpiredOn(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='exportReport']"));
	return license;
}
public static WebElement ClickExportExpiredOn1(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnExportExcelExpired']/img"));
	return license;
}
//*[@id="ContentPlaceHolder1_btnExportExcelExpired"]/img
public static WebElement ClickExpiringOn(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='exportReport']"));
	return license;
}
public static WebElement ClickOverviewExpiredOn(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]"));
	
	return license;
}
public static WebElement clickExpringbutnotApplied(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 ']"));
	return license;
}
public static WebElement clickByStatsExpiringReadcount(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickExportGraph(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='exportReport']"));
	return license;
}
public static WebElement clickGraphoverview(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[8]/a"));
	return license;
}
public static WebElement clickCloseGraphPopup(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='close'])[2]"));
	return license;
}
public static WebElement clickBystatuscloseoverview(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='divOverView']/div/div/div[1]/button"));
	return license;
}
public static WebElement clickBystatusTerminate(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-4 ']"));
	return license;
}
public static WebElement clickBystatusTerminateReadCount(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickBystatusTerminateOverview(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[8]/a"));
	return license;
}
public static WebElement clickBystatusActive(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-3 ']"));
	
	return license;
}
public static WebElement clickBystatusActiveReadCount(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickBystatusActiveOverview(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[8]/a"));
	
	return license;
}
public static WebElement clickBystatusExpiredappliedbutnotrenewed(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-2 ']"));
	return license;
}
public static WebElement clickBystatusExpiredappliedbutnotrenewedReadCount(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickBystatusExpiredappliedbutnotrenewedOverview(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[8]/a"));
	return license;
}
public static WebElement clickBystatusExpired(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-1 ']"));
	return license;
}
public static WebElement clickAllReadcount(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	return license;
}
public static WebElement clickAllOverview(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]"));
	
	return license;
}
public static WebElement clickByLicnesetypeExpired(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[26]"));
	return license;
}
public static WebElement clickByLicnesetypeExpiredInternal(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[7]"));
	return license;
}
public static WebElement clickByLicnesetypeExpiring(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));
	return license;
}
public static WebElement clickByLicnesetypeApplied(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[23]"));
	return license;
}
public static WebElement clickByLicnesetypeAppliedInternal(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));
	return license;
}
public static WebElement clickByLicnesetypeActive(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));
	return license;
}
public static WebElement clickByLicnesetypeActiveInternal(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[19]"));
	return license;
}
public static WebElement clickByLicnesetypeTerminate(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[85]"));
	return license;
}
public static WebElement clickByLicnesetypeTerminateInternal(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[25]"));
			
	return license;
}
public static WebElement checkTable1(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@class='k-grid-content k-auto-scrollable']/table/tbody/tr[1]"));
	return license;
}
public static WebElement DownloadDocument(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-download1 k-grid-edit4'])[1]"));
	return license;
}

public static WebElement ViewDocument(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]"));
	return license;
}
public static WebElement closeViewDocument(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@class='close'])[1]"));
	return license;
}
public static WebElement Progress(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='imgUpdateProgress']"));
	return license;
}
public static WebElement ClickShareOption(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='divOpenPermissionPopup']/div/div/div[2]"));
	return license;
}
public static WebElement ClickOnDashExpiredExport(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnExportExcelExpired']/img"));
	return license;
}
public static WebElement ClickDashOverviewClose(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='divGraphDetails']/div/div/div[1]/button"));
	return license;
}
public static WebElement ClickLicenseActivation(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='Mastersubmenu']/li[2]/a"));
	return license;
}
public static WebElement LicenseNewAssignment(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_liNotAssigned']"));
	return license;
}

public static WebElement ClickLicenseType(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType1_chosen']/a/span"));

	return license;
}
public static WebElement SearchLicenseType(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType1_chosen']/div/div/input"));
	

	return license;
}
public static WebElement Licensetype(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/a"));
	return license;
}
public static WebElement ClickLocation1(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocation1']"));
	return license;
}
public static WebElement ClickLocationin(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocation1n3CheckBox']"));
	return license;
}

public static WebElement CheckLocation(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocation1n2CheckBox']"));
	return license;
}
public static WebElement SelectLocation(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnlocation1']"));
	return license;
}
public static WebElement CheckCompliance(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_chkbox_0']"));

	return license;
}
public static WebElement CheckCompliancein(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_chkbox1_0']"));
	return license;
}
public static WebElement ClickPerformer(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_ddlPerformer_0']"));
	return license;
}

public static WebElement SelectLicensePerformer(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_ddlPerformer_0']/option[106]"));
	return license;
}
public static WebElement ClickReviewer(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_ddlReviewer_0']"));
	return license;
}
public static WebElement SelectLicenseReviewer(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_ddlReviewer_0']/option[112]"));
	return license;
}
public static WebElement AddAssignmentButton(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnSaveLicense1']"));

	return license;
}
public static WebElement readResponseMsg(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_vsLicenseListPage1']/ul/li"));
	return license;
}
public static WebElement CheckCompliance1(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_chkbox_0']"));
	return license;
}
public static WebElement ClickLicensetype1(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/a/span"));
	return license;
}
public static WebElement SearchLicenseType1(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/div/div/input"));
	return license;
}
public static WebElement LicesneNo1(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_txtLicenseNo_0']"));
	return license;
}
public static WebElement LicesneTitle1(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_txtTitle_0']"));
	return license;
}
public static WebElement StartDate1(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_txtStartDate_0']"));
	return license;
}
public static WebElement EndDate1(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_txtEndDate_0']"));
	return license;
}
public static WebElement SaveButton(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnSaveLicense']"));
	return license;
}
public static WebElement Message(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_vsLicenseListPage']/ul/li"));
	return license;
}
public static WebElement InternalCreationMenu(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='Mastersubmenu']/li[3]/a"));
	return license;
}
public static WebElement ClickInternalLicenseType(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/a/span"));
	return license;
}
public static WebElement SearchInternalLicenseType(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/div/div/input"));
	return license;
}
public static WebElement Clickaftershare(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='divOpenPermissionPopup']/div/div/div[2]/div[3]/div/label"));
	return license;
}
public static WebElement clickDashlicensetype(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/a/span"));
	return license;
}
public static WebElement DashSearchLienseType(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/div/div/input"));
	return license;
}
public static WebElement DashoardClearBtn(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnClearFilter']"));
	return license;
}
public static WebElement ExpiredOnLictype(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id=\"Details\"]/div[1]/span[2]/span/span[1]"));
	return license;
}
public static WebElement searchExpiredOnLictype(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType-list']/span/input"));
	return license;
}
public static WebElement Clearfilter(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ClearfilterMain']"));
	return license;
}
public static WebElement DashExpiringOnExport(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnExportExcelExpiring']/img"));
	return license;
}
public static WebElement BystatusExpiringLicensetype(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='Details']/div[1]/span[2]/span/span[1]"));
	
	return license;
}
public static WebElement BystatusExpiringsearchLicensetype(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType-list']/span/input"));
	return license;
}
public static WebElement GraphPopupClear(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ClearfilterMain']"));
	
	return license;
}
public static WebElement Clicllicensetype(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[53]"));
	return license;
}
public static WebElement ClicllicensetypeInr(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[1]"));
	return license;
}
public static WebElement ClicllicensetypeInternalapplied(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[53]"));
	return license;
}
public static WebElement CliclInternallicensetype(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[1]"));
	return license;
}
public static WebElement ClicllicensetypeInternal(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[10]"));
	return license;
}
public static WebElement ClicllicensetypeInternal1(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[1]"));
	return license;
}
public static WebElement ClickMyWorkspace(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='leftworkspacemenu']/a/span[1]"));
	return license;
}
public static WebElement clickWrklictype(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='MainContentCW']/div[1]/span[4]/span/span[1]"));
	return license;
}
public static WebElement Searchtype(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@id='dropdownlistLicenseType-list']/span/input)[2]"));
	return license;
}
public static WebElement clicklic(WebDriver driver)
{
	license = driver.findElement(By.linkText("Boiler"));
	return license;
}
public static WebElement Click1(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@id='dropdownlistLicenseType_listbox']/li[53])[2]"));
	return license;
}
public static WebElement MyworkspaceOverview(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[4]/td[13]/a[2]"));
	return license;
}
public static WebElement Overviewclose(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='divApiOverView']/div/div/div[1]/button"));
	return license;
}
public static WebElement AddNewLic(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_AddNewLicense']"));
	return license;
}
public static WebElement justclick(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='divUploadDocument']/table"));
	return license;
}



public static WebElement Expiringshowmore(WebDriver driver) {
	// TODO Auto-generated method stub
	return null;
}
public static WebElement DeleteFolder(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_upPromotorList']/div/div/div/section/div[2]/div[2]/img[3]"));
	return license;
}
public static WebElement CDocumentDownload(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_upPromotorList']/div/div/section/div[3]/div/div[2]/img[2]"));
	return license;
}

public static WebElement editFolderD(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_upPromotorList']/div/div/section/div[3]/div/div[2]/img[4]"));
	return license;
}

public static WebElement DocumentHeader(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_TxtDocHeader']"));
	return license;
}
public static WebElement DocumentDescription(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_TxtDescription']"));
	return license;
}
public static WebElement DocumentOther(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_TxtOthers']"));
	return license;
}
public static WebElement DocumentProcess(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_TxtProcess']"));
	return license;
}
public static WebElement Documentsubprocess(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_TxtSubProcess']"));
	return license;
}
public static WebElement Vertical(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_TxtVertical']"));
	return license;
}
public static WebElement DocumentLocation(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_TxtLocation']"));
	return license;
}
public static WebElement Updateinfobtn(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnUpdateInfo']"));
	return license;
}
public static WebElement closedocpopup(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='divOpenNewInformationPopup']/div/div/div[1]/button"));
	return license;
}
public static WebElement renamemsg(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_FolderValidation']/ul/li"));
	return license;
}
public static WebElement FirstFolder(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdFolderDetail_LinkButton1_0']"));
	return license;
}
public static WebElement LinkFolder(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_upPromotorList']/div/div/section/div[3]/div/div[2]/img[6]"));
	return license;
}
public static WebElement Linkdocument1(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdChecklist_CheckBox1_0']"));
	return license;
}

public static WebElement Linkdocument2(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdChecklist_CheckBox1_1']"));
	return license;
}

public static WebElement LinkSave(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnSaveChecklistMapping']"));
	return license;
}
public static WebElement Linkclose(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='divAuditChecklistPopup']/div/div/div[1]/button"));
	return license;
}
public static WebElement clickShareFolder(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_upPromotorList']/div/div/div/section/div[2]/div[2]/img[1]"));
	return license;
}
public static WebElement ClickFolder(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdFolderDetail_LinkButton1_0']"));
	return license;
}
public static WebElement DeleteFile(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@class='deletedrive']"));
	return license;
}
public static WebElement Folback(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkMyDrive']"));
	return license;
}
public static WebElement Norecord(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
	
	return license;
}
public static void user(WebDriver driver) {
	// TODO Auto-generated method stub
	
}
public static WebElement licdropdown(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@class='k-icon k-i-arrow-60-down'])[2]"));
	
	return license;
}
public static WebElement selecttype(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[16]"));
	
	return license;
}
public static WebElement selecttypecomadmin(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[2]"));
	
	return license;
}

public static WebElement selectinttype(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']"));
	
	return license;
}
public static WebElement selectinttype1(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']/option[2]"));
	
	return license;
}
public static WebElement valimsg(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='VSLicensePopup']"));
	
	return license;
}
public static WebElement selectintype(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@class='k-dropdown-wrap k-state-default'])[2]"));
	
	return license;
}
public static WebElement selectinttype11(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[2]"));
	
	return license;
}
public static WebElement addlicensebtn1(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnAddnew']"));
	
	return license;
}
public static WebElement ispermanentcheckbox(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ChkIsActive']"));
	
	return license;
}
public static WebElement addlicplusebtn(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_lnkViewLicenseInstance_0']"));
	return license;
}
public static WebElement selectbtn(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnlocation1']"));
	return license;
}
public static WebElement ReviewerColumn(WebDriver driver) 
{
	license = driver.findElement(By.xpath("(//*[@class='k-link'])[6]"));
	return license;
}
public static WebElement ExpiredHide(WebDriver driver) 
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-point'])[126]-"));
	return license;
}


}






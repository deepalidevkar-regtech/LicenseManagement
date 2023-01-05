package LicenseCompanyadmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MethodPOM 
{
	private static WebElement license = null;	
public static WebElement clickMasterMenu(WebDriver driver)
	
	{
		WebDriverWait wait= new WebDriverWait(driver,20);
		license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='leftmastermenu']")));
		return license;
		
	}
public static WebElement clickUserMaster(WebDriver driver)
	
	{
		WebDriverWait wait= new WebDriverWait(driver,20);
		license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Mastersubmenu\"]/li[1]/a")));
		return license;
		
	}
public static WebElement clickAddUser(WebDriver driver)

{
	WebDriverWait wait= new WebDriverWait(driver,20);
	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ContentPlaceHolder1_btnAddUser\"]/span")));
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

	license =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divShowDialog']/div/div/div[1]/button")));
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
	license = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[12]/a[1]"));
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
public static WebElement ClickShowMoreExpiredOn(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_LinkButton1']"));
	return license;
}
public static WebElement ClickExportExpiredOn(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='exportReport']"));
	return license;
}
public static WebElement ClickExpiringOn(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='exportReport']"));
	return license;
}
public static WebElement ClickOverviewExpiredOn(WebDriver driver)	
{
	license = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[8]/a"));
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
	license = driver.findElement(By.xpath("//*[@id='divGraphDetails']/div/div/div[1]/button"));
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
	license = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[8]/a"));
	return license;
}
public static WebElement clickByLicnesetypeExpired(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[21]"));
	return license;
}
public static WebElement clickByLicnesetypeExpiring(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[1]"));
	return license;
}
public static WebElement clickByLicnesetypeApplied(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[41]"));
	return license;
}
public static WebElement clickByLicnesetypeActive(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[65]"));
	return license;
}
public static WebElement clickByLicnesetypeTerminate(WebDriver driver)	
{
	license = driver.findElement(By.xpath("(//*[@class='highcharts-label highcharts-data-label highcharts-data-label-color-undefined '])[85]"));
	return license;
}


















}






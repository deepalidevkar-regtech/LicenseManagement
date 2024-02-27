package licensePerformer;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

public class LiPerformerPOM 
{
	private static WebElement license = null;		
	private static List<WebElement> elementsList = null;	//WebElement list created for selecting Status-Asc/Desc (Status shows multiple elements back side)
	
	public static WebElement clickActive(WebDriver driver)			//Searching 'My Admins' link
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divActiveCount']"));
		return license;
	}
	
	public static WebElement Progress(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='imgUpdateProgress']"));
		return license;
	}
	
	public static WebElement clickAction(WebDriver driver)
	{
		license = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-overview'])[1]"));
		return license;
	}
	public static WebElement ExpiredAction(WebDriver driver)
	{
		license = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-overview'])[1]"));
		return license;
	}
	public static WebElement AppliedActionin(WebDriver driver)
	{
		license = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-overview'])[1]"));
		return license;
	}
	public static WebElement rejectAction(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@class='k-button k-button-icontext ob-overview k-grid-overview']"));
		return license;
	}
	public static WebElement terAction(WebDriver driver)
	{
		license = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-overview'])[1]"));
		return license;
	}
	public static WebElement AppliedAction(WebDriver driver)
	{
		license = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-overview'])[1]"));
		return license;
	}

	public static WebElement clickComplDoc(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//input[@id='TxtUploadocumentlnkLIc']"));
		return license;
	}
	
	public static WebElement clickComplDocInternal(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//input[@id='TxtCompliancedocumentlnk']"));
		return license;
	}
	
	public static WebElement clickComplDocAddButton(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//input[@id='UploadlinkCompliancefile']"));
		return license;
	}
	
	public static WebElement readMessage(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='ValidationSummary1']"));
		return license;
	}
	
	public static WebElement clickClose(WebDriver driver)
	{
		license = driver.findElement(By.xpath("(//*[@class='close'])[1]"));
		
		return license;
	}
	
	public static WebElement clickPendingForReview(WebDriver driver)		//Searching 'Pending For Review' image link
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPendingForReview']"));
		return license;
	}
	
	public static WebElement clickApplied(WebDriver driver)					//Searching 'Applied' image link
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divAppliedcount']"));
		return license;
	}
	
	public static WebElement readMsg(WebDriver driver)						//Searching 'Message' after submit
	{
		license = driver.findElement(By.xpath("//*[@id='VSLicensePopup']"));
		return license;
	}
	
	public static WebElement clickExpiring(WebDriver driver)				//Searching 'Expiring' image to click
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divExpiringcount']"));
		return license;
	}
	
	public static WebElement clickCheckbox(WebDriver driver)				//Searching 'Checkbox' to click
	{
		license = driver.findElement(By.xpath("//*[@id='chkPenaltySave']"));
		return license;
	}
	
	public static WebElement clickExpired(WebDriver driver)					//Searching 'Expired' image link to click
	{
		license = driver.findElement(By.id("ContentPlaceHolder1_divExpiredCount"));
		return license;
	}
	
	public static WebElement clickType(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']"));
		return license;
	}
	
	public static List<WebElement> clickDownload(WebDriver driver)		//Searching 'Download' button to click.
	{
		elementsList = driver.findElements(By.xpath("//*[contains(@id,'ContentPlaceHolder1_grdLicenseList_lblDownLoadfile')]"));
		return elementsList;
	}
	
	public static List<WebElement> clickDownload1(WebDriver driver)		//Searching 'Download' button to click.
	{
		elementsList = driver.findElements(By.xpath("//*[@class='k-button k-button-icontext ob-download1 k-grid-edit4']"));
		return elementsList;
	}
	
	public static List<WebElement> clickviewLiceDocument(WebDriver driver)	
	{
		
		elementsList = driver.findElements(By.xpath("//*[@class='k-button k-button-icontext ob-edit k-grid-edit']"));
		return elementsList;
	}
	public static WebElement Clickviewclose(WebDriver driver)	
	{
		
		elementsList = driver.findElements(By.xpath("//*[@id='divOverView']/div/div/div[1]/button"));
		return license;
	}
	
	
	public static WebElement clickMyDocuments(WebDriver driver)			//Searching 'My Documents' link
	{
		license = driver.findElement(By.xpath("//*[@id='leftdocumentsmenu']"));
		return license;
	}
	
	public static WebElement clickMyDocumentsMenu(WebDriver driver)			//Searching 'My Documents' link
	{
		license = driver.findElement(By.xpath("//li[@id='leftdocumentsmenu']/ul/li[1]"));
		return license;
	}
	
	public static WebElement clickMyReport(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='leftreportsmenu']"));
		return license;
	}
	
	public static WebElement clickStatus(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseStatus_chosen']"));
		return license;
	}
	
	public static WebElement clickStatus1(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@aria-owns='dropdownlistStatus_listbox']"));
		return license;
	}
	
	public static List<WebElement> selectStatus1(WebDriver driver)
	{
		elementsList = driver.findElements(By.xpath("//div[@id='dropdownlistStatus-list']/div[3]/ul/li"));
		return elementsList;
	}
	
	public static List<WebElement> selectStatus(WebDriver driver)
	{
		elementsList = driver.findElements(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseStatus_chosen']/div/ul/li"));
		return elementsList;
	}
	
	public static WebElement clickApply(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkBtnApplyFilter']"));
		return license;
	}
	
	public static WebElement clickExcel(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='exportReport']"));
		return license;
	}
	
	public static WebElement clickView(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_lnkEditLicense_0']"));
		return license;
	}
	
	public static WebElement clickType1(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']"));
		return license;
	}
	
	public static WebElement clickType2(WebDriver driver)
	{
		license = driver.findElement(By.xpath("(//*[@class='k-widget k-dropdown k-header'])[1]"));
		
		return license;
	}
		
	public static WebElement selectInternal(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='dropdownlistComplianceType_listbox']/li[2]"));
		return license;
	}
	
	public static WebElement checkTable(WebDriver driver)
	{
		license = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-edit'])[1]"));
		return license;
	}
	
	public static WebElement readTotalRecords(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_lblTotalRecord']"));
		return license;
	}
	
	public static WebElement readTotalRecords1(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//span[@class='k-pager-info k-label']"));
		return license;
	}
	
	public static WebElement clickAon(WebDriver driver)
	{
		license = driver.findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clickAyn(WebDriver driver)
	{
		license = driver.findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clickAyen(WebDriver driver)
	{
		license = driver.findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clickAeons(WebDriver driver)
	{
		license = driver.findElement(By.xpath(""));
		return license;
	}
	public static WebElement ShowFream(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_showReminderDetail']"));
		return license;
	}
	public static WebElement TerminateAction(WebDriver driver)
	{
		license = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-overview'])[1]"));
		return license;
	}

	public static WebElement editlicenseicon(WebDriver driver)
	{
		license = driver.findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]"));
		return license;
	}
	public static WebElement licenseOK(WebDriver driver)
	{
		license = driver.findElement(By.xpath("(//*[@class='k-button k-primary'])[2]"));
		return license;
	}
	public static WebElement perexpiredon(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkLicExpiredshowMore']"));
		return license;
	}
	

	public static WebElement Expiringmaxmize(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='fa fa-chevron-up'])[3]"));
		return license;
	}
	public static WebElement Expiringshowmore(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkShowDetailLicense']"));
		
		return license;
	}
	public static WebElement Reportapply(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='Applybtn']"));
		return license;
	}
	public static WebElement Freamshow(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='docViewerStatutory']"));
		return license;
	}
	public static WebElement terminatedPerformer(WebDriver driver)
	{
		license = driver.findElement(By.id("ContentPlaceHolder1_divterminated"));
	
		return license;
	}
	public static WebElement SubmitTerminate(WebDriver driver)
	{
		license = driver.findElement(By.xpath("	//*[@id='btnSaveDOCNotCompulsory']"));
		return license;
	}
	public static WebElement Multicheckdoc1(WebDriver driver)
	{
		license = driver.findElement(By.xpath("(//*[@id='sel_chkbxMain'])[1]"));
		return license;
	}
	public static WebElement Multicheckdoc2(WebDriver driver)
	{
		license = driver.findElement(By.xpath("(//*[@id='sel_chkbxMain'])[2]"));
		return license;
	}
	public static WebElement MultiDownload(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='dvbtndownloadDocumentMain1']"));
		return license;
	}
	public static WebElement Clicklictypedropdown(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='childrow']/div/div[1]/div/span[3]/span/span[1]"));
		return license;
	}
	public static WebElement selectlic(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='556a120f-800d-44d4-91ae-2d756841c7cc']"));
		return license;
	}
	public static WebElement clearbtn(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='ClearfilterMain']"));
		return license;
	}
	public static WebElement searchlic1(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[1]"));
		return license;
	}
	public static WebElement searchlic1in(WebDriver driver)
	{
		license = driver.findElement(By.xpath("(//*[@id='dropdownlistLicenseType_listbox']/li[2])[1]"));
		return license;
	}

	public static WebElement ActiveOverview(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[13]/a[2]"));
		return license;
	}
	public static WebElement CloseExpiredOn(WebDriver driver)
	{
		license = driver.findElement(By.xpath("//*[@id='divLicenseDetails']/div/div/div[1]/button"));
		return license;
	}

	public static void ExpiringLicense(WebDriver driver, ExtentTest test, String string) {
		// TODO Auto-generated method stub
		
	}

	public static void ExpiringCount(WebDriver driver, ExtentTest test, String string) {
		// TODO Auto-generated method stub
		
	}
	public static WebElement Sharebutton(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[10]/a[3]"));
		return license;
		
	}
	public static WebElement shareemail(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='txtEmail']"));
		return license;
		
	}
	public static WebElement ShareContactNo(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='txtcontactNum']"));
		return license;
		
	}
	public static WebElement Sharesave(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='btnUpdateDocInfo']"));
		return license;
		
	}
	public static WebElement Sharevaliedmsg(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='vsDocInfo']"));
		return license;
		
	}
	public static WebElement clickUnshare(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='grdContractDocuments_lnkBtnDeleteContractDoc_0']/img"));
		return license;
		
	}
	public static WebElement ShareClose(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='btnCancel']"));
		return license;
	}
	public static WebElement ClickBackDashboard(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='leftdashboardmenu']"));
		return license;
	}
	public static WebElement click11(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_LinkButton1']"));
		return license;
	}
	public static WebElement lictype(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='Details']/div[1]/span[2]/span/span[1]"));
		return license;
	}
	public static WebElement selectlic1(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[1]"));
		return license;
	}
	public static WebElement LicenseNo(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='txtLicenseNo']"));
		return license;
	}
	public static WebElement Licensetitle(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='txtLicenseTitle']"));
		return license;
	}
	public static WebElement AppliedLicSave(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='btnSave']"));
		return license;
	}
	public static WebElement AppliedStartDateclick(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='txtStartDate']"));
		return license;
	}
	public static WebElement AppliedStartDate(WebDriver driver) 
	{
		license = driver.findElement(By.linkText("26"));
		return license;
	}
	public static WebElement AppliedEndDateclick(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='txtEndDate']"));
		return license;
	}
	public static WebElement AppliedEndDate(WebDriver driver) 
	{
		license = driver.findElement(By.linkText("30"));
		return license;
	}
	public static WebElement editnomineebtn(WebDriver driver) 
	{
		license = driver.findElement(By.linkText("(//*[@class='k-icon k-i-edit'])[2]"));
		return license;
	}
	public static WebElement UploadDocument(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='fuSampleFile']"));
		return license;
	}
	public static WebElement PFRCount(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPendingForReview']"));
		return license;
	}
	
	public static WebElement indate(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='tbxDate2']"));
		return license;
	}
	public static WebElement justclick(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='collapseUpdateComplianceStatus']/fieldset/div[5]"));
		return license;
	}
	public static WebElement reportapplybtn(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='Applybtn']"));
		return license;
	}
	public static WebElement ReviewerColumn(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-link'])[7]"));
		return license;
	}
	public static WebElement PerformerColumn(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-link'])[6]"));
		return license;
	}
	public static WebElement PerformerColumn1(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-link'])[5]"));
		return license;
	}
	public static WebElement Entitycolumn(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-link'])[1]"));
		return license;
	}
	
	public static WebElement Noitemdisplay(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
		return license;
	}
	public static WebElement EntityLocation(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-input k-readonly'])[1]"));
		return license;
	}
	public static WebElement EntityLocationExpand(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-icon k-i-expand'])[1]"));
		return license;
	}
	public static WebElement locationtext(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-in'])[3]"));
		return license;
	}
	public static WebElement ClickLictype(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-input'])[3]"));
		return license;
	}
	
	public static WebElement Licensetype(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[3]"));
		return license;
	}
	public static WebElement selectlictype(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[3]"));
		return license;
	}
	public static WebElement notactivatefilter(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@id='dropdownlistLicenseType_listbox']/li[3])[2]"));
		return license;
	}
	public static WebElement worklicedrop(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-input'])[4]"));
		return license;
	}
	public static WebElement selectworkdroplic(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-item'])[70]"));
		return license;
	}
	
	public static WebElement notactivatefilterin(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@id='dropdownlistLicenseType_listbox']/li[4])[2]"));
		return license;
	}
	
	public static WebElement checkloc(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-in'])[4]"));
		
		return license;
	}
	public static WebElement checkloc1(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[23]"));
		
		return license;
	}
	
	
	public static WebElement Entityname(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[1]"));
		return license;
	}
	public static WebElement NoRecord(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseExpiring']/tbody/tr[2]"));
		return license;
	}
	public static WebElement AssignedButNotActivated(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_divNotActivated']"));
		return license;
	}
	public static WebElement NotActivatedExport(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-button'])[2]"));
		return license;
	}
	public static WebElement NotLocation(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@class='k-input k-readonly']"));
		return license;
	}
	public static WebElement LocationExpand(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-icon k-i-expand'])[1]"));
		return license;
	}
	public static WebElement Checklocation(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[15]"));
		return license;
	}
	public static WebElement clicklictype(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='MainContentCW']/div[1]/span[3]/span/span[1]"));
		
		return license;
	}
	public static WebElement clicklictypet(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='Details']/div[1]/span[2]/span/span[1]"));
		return license;
	}
	public static WebElement lictypwworkspace(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-dropdown-wrap k-state-default'])[4]"));
		return license;
	}
	
	public static WebElement locget(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-in'])[23]"));
		return license;
	}
	public static WebElement locgetworkspace(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-in'])[5]"));
		return license;
	}
	public static WebElement workspacestatus(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='MainContentCW']/div[1]/span[3]/span/span[1]"));
		return license;
	}
	public static WebElement selectstatus1(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-item'])[44]"));
		return license;
	}

	public static WebElement searchtype(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("(//*[@class='k-textbox'])[4]"));
		return license;
	}
	public static WebElement PerformDateclick(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='tbxDate']"));
		return license;
	}
	public static WebElement PerformDate(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[4]/a"));
		return license;
	}
	public static WebElement Entitysubexpand(WebDriver driver) 
	{
		license = driver.findElement(By.xpath("//*[@class='k-icon k-i-expand']"));
		return license;
	}
	
}


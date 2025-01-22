package licensePerformer;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import login.webpage;

public class LiPerformerPOM extends webpage{
	private static WebElement license = null;		
	private static List<WebElement> elementsList = null;	//WebElement list created for selecting Status-Asc/Desc (Status shows multiple elements back side)
	public static Object worklicedrop;
	
	public static WebElement clickActive()			//Searching 'My Admins' link
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divActiveCount']"));
		return license;
	}
	
	public static WebElement Progress()
	{
		license = getDriver().findElement(By.xpath("//*[@id='imgUpdateProgress']"));
		return license;
	}
	
	public static WebElement clickAction()
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-overview'])[1]"));
		return license;
	}
	public static WebElement ExpiredAction()
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-overview'])[1]"));
		return license;
	}
	public static WebElement AppliedActionin()
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-overview'])[1]"));
		return license;
	}
	public static WebElement rejectAction()
	{
		license = getDriver().findElement(By.xpath("//*[@class='k-button k-button-icontext ob-overview k-grid-overview']"));
		return license;
	}
	public static WebElement terAction()
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-overview'])[1]"));
		return license;
	}
	public static WebElement AppliedAction()
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-overview'])[1]"));
		return license;
	}

	public static WebElement clickComplDoc()
	{
		license = getDriver().findElement(By.xpath("//input[@id='TxtUploadocumentlnkLIc']"));
		return license;
	}
	
	public static WebElement clickComplDocInternal()
	{
		license = getDriver().findElement(By.xpath("//input[@id='TxtCompliancedocumentlnk']"));
		return license;
	}
	
	public static WebElement clickComplDocAddButton()
	{
		license = getDriver().findElement(By.xpath("//input[@id='UploadlinkCompliancefile']"));
		return license;
	}
	
	public static WebElement readMessage()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ValidationSummary1']"));
		return license;
	}
	
	public static WebElement clickClose()
	{
		license = getDriver().findElement(By.xpath("(//*[@class='close'])[1]"));
		
		return license;
	}
	
	public static WebElement clickPendingForReview()		//Searching 'Pending For Review' image link
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPendingForReview']"));
		return license;
	}
	
	public static WebElement clickApplied()					//Searching 'Applied' image link
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divAppliedcount']"));
		return license;
	}
	
	public static WebElement readMsg()						//Searching 'Message' after submit
	{
		license = getDriver().findElement(By.xpath("//*[@id='VSLicensePopup']"));
		return license;
	}
	
	public static WebElement clickExpiring()				//Searching 'Expiring' image to click
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divExpiringcount']"));
		return license;
	}
	
	public static WebElement clickCheckbox()				//Searching 'Checkbox' to click
	{
		license = getDriver().findElement(By.xpath("//*[@id='chkPenaltySave']"));
		return license;
	}
	
	public static WebElement clickExpired()					//Searching 'Expired' image link to click
	{
		license = getDriver().findElement(By.id("ContentPlaceHolder1_divExpiredCount"));
		return license;
	}
	
	public static WebElement clickType()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']"));
		return license;
	}
	
	public static List<WebElement> clickDownload()		//Searching 'Download' button to click.
	{
		elementsList = getDriver().findElements(By.xpath("//*[contains(@id,'ContentPlaceHolder1_grdLicenseList_lblDownLoadfile')]"));
		return elementsList;
	}
	
	public static List<WebElement> clickDownload1()		//Searching 'Download' button to click.
	{
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-button k-button-icontext ob-download1 k-grid-edit4']"));
		return elementsList;
	}
	
	public static List<WebElement> clickviewLiceDocument()	
	{
		
		elementsList = getDriver().findElements(By.xpath("//*[@class='k-button k-button-icontext ob-edit k-grid-edit']"));
		return elementsList;
	}
	public static WebElement Clickviewclose()	
	{
		
		elementsList = getDriver().findElements(By.xpath("//*[@id='divOverView']/div/div/div[1]/button"));
		return license;
	}
	
	
	public static WebElement clickMyDocuments()			//Searching 'My Documents' link
	{
		license = getDriver().findElement(By.xpath("//*[@id='leftdocumentsmenu']"));
		return license;
	}
	
	public static WebElement clickMyDocumentsMenu()			//Searching 'My Documents' link
	{
		license = getDriver().findElement(By.xpath("//li[@id='leftdocumentsmenu']/ul/li[1]"));
		return license;
	}
	
	public static WebElement clickMyReport()
	{
		license = getDriver().findElement(By.xpath("//*[@id='leftreportsmenu']"));
		return license;
	}
	
	public static WebElement clickStatus()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseStatus_chosen']"));
		return license;
	}
	
	public static WebElement clickStatus1()
	{
		license = getDriver().findElement(By.xpath("(//*[@aria-owns='dropdownlistStatus_listbox'])"));
		return license;
	}
	public static WebElement clickStatusdept()
	{
		license = getDriver().findElement(By.xpath("(//*[@aria-owns='dropdownlistStatus_listbox'])"));
		return license;
	}
	
	public static List<WebElement> selectStatus1()
	{
		elementsList = getDriver().findElements(By.xpath("(//*[@class='k-item'])[51]"));
		return elementsList;
	}
	
	public static List<WebElement> selectStatus()
	{
		elementsList = getDriver().findElements(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseStatus_chosen']/div/ul/li"));
		return elementsList;
	}
	
	public static WebElement clickApply()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkBtnApplyFilter']"));
		return license;
	}
	
	public static WebElement clickExcel()
	{
		license = getDriver().findElement(By.xpath("//*[@id='exportReport']"));
		return license;
	}
	
	public static WebElement clickView()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_lnkEditLicense_0']"));
		return license;
	}
	
	public static WebElement clickType1()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlComplianceType']"));
		return license;
	}
	
	public static WebElement clickType2()
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-widget k-dropdown k-header'])[2]"));
		
		return license;
	}
	public static WebElement clickType22()
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-widget k-dropdown k-header'])[1]"));
		
		return license;
	}
	public static WebElement selectInternal()
	{
		license = getDriver().findElement(By.xpath("//*[@id='dropdownlistComplianceType_listbox']/li[2]"));
		return license;
	}
	
	public static WebElement checkTable()
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-edit'])[1]"));
		return license;
	}
	
	public static WebElement readTotalRecords()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lblTotalRecord']"));
		return license;
	}
	
	public static WebElement readTotalRecords1()
	{
		license = getDriver().findElement(By.xpath("//span[@class='k-pager-info k-label']"));
		return license;
	}
	
	public static WebElement clickAon()
	{
		license = getDriver().findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clickAyn()
	{
		license = getDriver().findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clickAyen()
	{
		license = getDriver().findElement(By.xpath(""));
		return license;
	}
	
	public static WebElement clickAeons()
	{
		license = getDriver().findElement(By.xpath(""));
		return license;
	}
	public static WebElement ShowFream()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_showReminderDetail']"));

		return license;
	}
	
	public static WebElement TerminateAction()
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-overview k-grid-overview'])[1]"));
		return license;
	}

	public static WebElement editlicenseicon()
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-button k-button-icontext ob-edit k-grid-edit'])[1]"));
		return license;
	}
	public static WebElement licenseOK()
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-button k-primary'])[2]"));
		return license;
	}
	public static WebElement perexpiredon()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkLicExpiredshowMore']"));
		return license;
	}
	

	public static WebElement Expiringmaxmize() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='fa fa-chevron-up'])[3]"));
		return license;
	}
	public static WebElement Expiringshowmore() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkShowDetailLicense']"));

		
		return license;
	}
	public static WebElement Reportapply() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='Applybtn']"));
		return license;
	}
	public static WebElement Freamshow() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='docViewerStatutory']"));
		return license;
	}
	public static WebElement terminatedPerformer()
	{
		license = getDriver().findElement(By.id("ContentPlaceHolder1_divterminated"));
	
		return license;
	}
	public static WebElement SubmitTerminate()
	{
		license = getDriver().findElement(By.xpath("	//*[@id='btnSaveDOCNotCompulsory']"));
		return license;
	}
	public static WebElement Multicheckdoc1()
	{
		license = getDriver().findElement(By.xpath("(//*[@id='sel_chkbxMain'])[1]"));
		return license;
	}
	public static WebElement Multicheckdoc2()
	{
		license = getDriver().findElement(By.xpath("(//*[@id='sel_chkbxMain'])[2]"));
		return license;
	}
	public static WebElement MultiDownload()
	{
		license = getDriver().findElement(By.xpath("//*[@id='dvbtndownloadDocumentMain1']"));
		return license;
	}
	public static WebElement Clicklictypedropdown()
	{
		license = getDriver().findElement(By.xpath("//*[@id='childrow']/div/div[1]/div/span[3]/span/span[1]"));
		return license;
	}
	public static WebElement selectlic()
	{
		license = getDriver().findElement(By.xpath("//*[@id='556a120f-800d-44d4-91ae-2d756841c7cc']"));
		return license;
	}
	public static WebElement clearbtn()
	{
		license = getDriver().findElement(By.xpath("//*[@id='ClearfilterMain']"));
		return license;
	}
	public static WebElement searchlic1()
	{
		license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[1]"));
		return license;
	}
	public static WebElement searchlic1in()
	{
		license = getDriver().findElement(By.xpath("(//*[@id='dropdownlistLicenseType_listbox'])[2]"));
		return license;
	}

	public static WebElement ActiveOverview()
	{
		license = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr/td[13]/a[2]"));
		return license;
	}
	public static WebElement CloseExpiredOn()
	{
		license = getDriver().findElement(By.xpath("//*[@id='divLicenseDetails']/div/div/div[1]/button"));
		return license;
	}

	public static void ExpiringLicense(ExtentTest test, String string) {
		// TODO Auto-generated method stub
		
	}

	public static void ExpiringCount( ExtentTest test, String string) {
		// TODO Auto-generated method stub
		
	}
	public static WebElement Sharebutton() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/table/tbody/tr[1]/td[10]/a[3]"));
		return license;
		
	}
	public static WebElement shareemail() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='txtEmail']"));
		return license;
		
	}
	public static WebElement ShareContactNo() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='txtcontactNum']"));
		return license;
		
	}
	public static WebElement Sharesave() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='btnUpdateDocInfo']"));
		return license;
		
	}
	public static WebElement Sharevaliedmsg() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='vsDocInfo']"));
		return license;
		
	}
	public static WebElement clickUnshare() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='grdContractDocuments_lnkBtnDeleteContractDoc_0']/img"));
		return license;
		
	}
	public static WebElement ShareClose() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='btnCancel']"));
		return license;
	}
	public static WebElement ClickBackDashboard() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='leftdashboardmenu']"));
		return license;
	}
	public static WebElement click11() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_LinkButton1']"));
		return license;
	}
	public static WebElement Showmorecmd() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_LinkButton3']"));
		return license;
	}
	public static WebElement lictype() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='Details']/div[1]/span[2]/span/span[1]"));
		return license;
	}
	public static WebElement selectlic1() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[1]"));
		return license;
	}
	public static WebElement LicenseNo() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='txtLicenseNo']"));
		return license;
	}
	public static WebElement Licensetitle() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='txtLicenseTitle']"));
		return license;
	}
	public static WebElement AppliedLicSave() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='btnSave']"));
		return license;
	}
	public static WebElement AppliedStartDateclick() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='txtStartDate']"));
		return license;
	}
	public static WebElement AppliedStartDate() 
	{
		license = getDriver().findElement(By.linkText("30"));
		return license;
	}
	public static WebElement AppliedEndDateclick() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='txtEndDate']"));
		return license;
	}
	public static WebElement AppliedEndDate() 
	{
		license = getDriver().findElement(By.linkText("29"));
		return license;
	}
	public static WebElement editnomineebtn() 
	{
		license = getDriver().findElement(By.linkText("(//*[@class='k-icon k-i-edit'])[2]"));
		return license;
	}
	public static WebElement UploadDocument() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='fuSampleFile']"));
		return license;
	}
	public static WebElement PFRCount() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divPendingForReview']"));
		return license;
	}
	
	public static WebElement indate() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='tbxDate2']"));
		return license;
	}
	public static WebElement justclick() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='collapseUpdateComplianceStatus']/fieldset/div[5]"));
		return license;
	}
	public static WebElement reportapplybtn() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='Applybtn']"));
		return license;
	}
	public static WebElement ReviewerColumn() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-link'])[7]"));
		return license;
	}
	public static WebElement PerformerColumn() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-link'])[6]"));
		return license;
	}
	public static WebElement PerformerColumn1() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-link'])[5]"));
		return license;
	}
	public static WebElement Entitycolumn() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-link'])[1]"));
		return license;
	}
	
	public static WebElement Noitemdisplay() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='grid']/div[3]/span[2]"));
		return license;
	}
	public static WebElement EntityLocation() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-input k-readonly'])[1]"));
		return license;
	}
	public static WebElement EntityLocation1() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-input k-readonly'])[1]"));
		return license;
	}
	public static WebElement EntityLocationExpand() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-checkbox'])[1]"));
		
		return license;
	}
	public static WebElement EntityLocationExpanddept() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-group k-treeview-lines'])[1]"));
		
		return license;
	}
	public static WebElement aa() 
	{
		license = getDriver().findElement(By.xpath("//*[@class='k-item k-first k-last']"));
		return license;
	}
	public static WebElement aa1() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-item k-last'])[2]"));
		return license;
	}
	public static WebElement demolocation() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[4]"));
		return license;
	}
	
	public static WebElement locationtext() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-in'])[3]"));
		return license;
		
	}
	public static WebElement locationsearch() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-textbox'])[1]"));
		return license;
		
	}

	public static WebElement ClickLictype() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-input'])[3]"));
		return license;
	}
	public static WebElement ClickLictypein() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-input'])[1]"));
		return license;
	}
	
	public static WebElement Licensetype() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[54]"));
		return license;
	}
	public static WebElement Licensetypeinternal() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[502]"));
		return license;
	}
	public static WebElement inlic() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[4]"));
		return license;
	}
	public static WebElement selectinlictype() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-item'])[26]"));
		return license;
	}
	
	public static WebElement selectlictype() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='dropdownlistLicenseType_listbox']/li[3]"));
		return license;
	}
	public static WebElement notactivatefilter() 
	{
		license = getDriver().findElement(By.xpath("(//*[@id='dropdownlistLicenseType_listbox']/li[3])[2]"));
		return license;
	}
	public static WebElement worklicedrop() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-input'])[4]"));
		return license;
	}
	public static WebElement selectworkdroplic() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-item'])[70]"));
		return license;
	}
	
	public static WebElement notactivatefilterin() 
	{
		license = getDriver().findElement(By.xpath("(//*[@id='dropdownlistLicenseType_listbox']/li[4])[2]"));
		return license;
	}
	
	public static WebElement checkloc() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-in'])[4]"));
		
		return license;
	}
	public static WebElement checkloc1() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[23]"));
		
		return license;
	}
	
	
	public static WebElement Entityname() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='grid']/div[2]/table/tbody/tr[1]/td[1]"));
		return license;
	}
	public static WebElement NoRecord() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseExpiring']/tbody/tr[2]"));
		return license;
	}
	public static WebElement AssignedButNotActivated() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_divNotActivated']"));
		return license;
	}
	public static WebElement NotActivatedExport() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-button'])[2]"));
		return license;
	}
	public static WebElement NotLocation() 
	{
		license = getDriver().findElement(By.xpath("//*[@class='k-input k-readonly']"));
		return license;
	}
	public static WebElement LocationExpand() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-icon k-i-expand'])[1]"));
		return license;
	}
	public static WebElement Checklocation() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[15]"));
		return license;
	}
	public static WebElement clicklictype() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='MainContentCW']/div[1]/span[3]/span/span[1]"));
		
		return license;
	}
	public static WebElement clicklictypet() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='Details']/div[1]/span[2]/span/span[1]"));
		return license;
	}
	public static WebElement lictypwworkspace() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-dropdown-wrap k-state-default'])[4]"));
		return license;
	}
	
	public static WebElement locget() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-in'])[6]"));
		return license;
	}
	
	public static WebElement locgetworkspace() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-in'])[5]"));
		return license;
	}
	public static WebElement workspacestatus() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='MainContentCW']/div[1]/span[3]/span/span[1]"));
		return license;
	}
	public static WebElement selectstatus1() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-item'])[51]"));
		return license;
	}

	public static WebElement searchtype() 
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-textbox'])[4]"));
		return license;
	}
	public static WebElement PerformDateclick() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='tbxDate']"));
		return license;
	}
	public static WebElement PerformDate() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[4]/a"));
		return license;
	}
	public static WebElement Priviouscalnder() 
	{
		license = getDriver().findElement(By.xpath("//*[@class='ui-icon ui-icon-circle-triangle-w']"));
		return license;
	}
	//*[@class="ui-icon ui-icon-circle-triangle-w"]
	public static WebElement Entitysubexpand() 
	{
		license = getDriver().findElement(By.xpath("//*[@class='k-icon k-i-expand']"));
		return license;
	}
	public static WebElement maxilocation() 
	{
		license = getDriver().findElement(By.xpath("div[class='k-top k-bot'] span[class='k-icon k-i-expand']"));
		return license;
	}
	public static WebElement isperclosePopup() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='divShowReminderDialog/]/div/div/div[1]/button"));
		return license;
	}
	public static WebElement ispermessage() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='ValidationSummary1']"));
		return license;
	}
	public static WebElement NextDateClick() 
	{
		license = getDriver().findElement(By.xpath("//*[@class='ui-icon ui-icon-circle-triangle-e']"));
		return license;
	}

	
}


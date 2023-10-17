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
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:124']/li[4]"));
		return license;
	
	}
	public static WebElement ClickLicesneStatutory(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:128']/li[1]"));
		return license;	
	
	}
	public static WebElement ClickComplianceMapping(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:128']/li[1]"));
		return license;
	
	}
	public static WebElement mappingexport(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='BodyContent_btnExportExcel']/img"));
		return license;
	
	}
	public static WebElement LicenseCreation(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:128']/li[2]"));
		return license;
	
	}
	public static WebElement LicenseCreation1(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:129']/li[2]"));
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
	
	public static WebElement ClickPerformer(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_ddlPerformer_0']"));
		return license;
	
	}
	public static WebElement selectperformer(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_ddlPerformer_0']/option[128]"));
		return license;
	
	}
	public static WebElement ClickReviewer(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_ddlReviewer_0']"));
		return license;
	
	}
	public static WebElement Selectreviewer(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_ddlReviewer_0']/option[161]"));
		return license;
	
	}
	public static WebElement impaddassignment(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnSaveLicense1']"));
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
	public static WebElement clicklocation(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocation1']"));
		return license;
	
	}
	public static WebElement successmsg(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_vsLicenseListPage1']"));
		return license;
	
	}
	public static WebElement licenselist(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:128']/li[4]"));
		return license;
	
	}
	public static WebElement custdrop(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("(//*[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s'])[1]"));
		return license;
	
	}
	public static WebElement selectcustomerlist(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("(//*[@class='ui-menu-item'])[8]"));
		return license;
	
	}
	public static WebElement editlicense(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='BodyContent_grdLicenseList_lbtEdit_9']/img"));
		return license;
	
	}
	public static WebElement updatelicenseNo(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("	//*[@id='BodyContent_tbxLicenseNo']"));
		return license;
	
	}
	public static WebElement updatelicensetitle(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='BodyContent_tbxLicenseTitle']"));
		return license;
	
	}
	public static WebElement licenselistsave(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return license;
	
	}
	public static WebElement manageusertab(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"));
		return license;
	
	}
	public static WebElement usermastertab(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[3]"));
		return license;
	
	}
	public static WebElement clickcustdropdown(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("(//*[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s'])[1]"));
		return license;
	
	}
	public static WebElement selectcustomer2(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("(//*[@class='ui-corner-all'])[4]"));
		return license;
	
	}
	public static WebElement modifyentity(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnEntityAssignment_3'"));
		return license;
	
	}
	public static WebElement stutrediolicbtn(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='BodyContent_RadioButtonEntityList_2']"));
		return license;
	
	}
	public static WebElement assignrediobtn(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='BodyContent_RadioButtonList1_0']"));
		return license;
	
	}
	public static WebElement clicklocationimp(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='BodyContent_tbxBranch']"));
		return license;
	
	}
	public static WebElement pluseimg(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchesn0']/img"));
		return license;
	
	}
	public static WebElement typeselection(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("(//*[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s'])[2]"));
		return license;
	
	}
	public static WebElement selecttypein(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:127']/li[2]"));
		return license;
	
	}
	public static WebElement Licenselistin(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:134']/li[3]"));
		return license;
	
	}
	public static WebElement LicenseCreatinin(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:134']/li[2]"));
		return license;
	
	}
	public static WebElement selectCustomerin(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFilterCustomer_chosen']"));
		return license;
	
	}
	public static WebElement Chhoescust(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFilterCustomer']/option[5]"));
		return license;
	
	}
	public static WebElement Appliedliccreation(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='CMPMenuBar:submenu:129']/li[3]"));
		return license;
	
	}
	public static WebElement appliedCheckcompliance(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_chkbox_0']"));
		return license;
	
	}
	public static WebElement appliedstartdate(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_txtStartDate_0']"));
		return license;
	
	}
	public static WebElement appliedsavelic(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnSaveLicense']"));
		return license;
	
	}
	public static WebElement ChkIsPerment(WebDriver driver)	
	{
		license = driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_ChkIsPerment_0']"));
		return license;
	
	}
	
	public static WebElement SelectCustomerUser(WebDriver driver)		//Method for closing Message Popup
	{
		license = driver.findElement(By.xpath("//*[@id='BodyContent_divCustomerfilter']/div/span/input"));
		return license;                        
	}
	
	public static WebElement customer123Users(WebDriver driver)		//Method for closing Message Popup
	{
		license = driver.findElement(By.linkText("ABCD Pvt Ltd"));
		return license;                        
	}
public static WebElement ModifyEntity(WebDriver driver)		//Method for closing Message Popup
	{
	license = driver.findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnEntityAssignment_3']"));
		return license;                    
	}



public static WebElement ExpandLocation(WebDriver driver) //Method for closing Message Popup

{

	license = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchesn0']/img"));
   return license;

}



public static WebElement EAAWSGFJBitaLimited(WebDriver driver) //Method for closing Message Popup

{

	license = driver.findElement(By.xpath("//*[@id='BodyContent_tvBranchesn2CheckBox']"));

return license;

}

public static WebElement LocationEA(WebDriver driver) {
	license = driver.findElement(By.xpath("//*[@id='BodyContent_tbxBranch']"));

	   return license;
	
}
public static WebElement lictype(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@class='ui-menu-item'])[4]"));
	   return license;	
}
public static WebElement clickcategorylic(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s'])[3]"));
	   return license;	
}
public static WebElement clicksaves(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='BodyContent_BtnentitySave']"));
	   return license;	
}
public static WebElement validtabel(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='BodyContent_ctl07']"));
	   return license;	
}
public static WebElement Modifyclose(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='BodyContent_Button5']"));
	   return license;	
}
public static WebElement Checkallloc(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='BodyContent_chkallLocation']"));
	   return license;	
}
public static WebElement selectlic1(WebDriver driver)
{
	license = driver.findElement(By.xpath("(//*[@class='ui-menu-item'])[4]"));
	   return license;	
}
public static WebElement deleteentity(WebDriver driver)
{
	license = driver.findElement(By.xpath("//*[@id='BodyContent_RadioButtonList1_1']"));
	   return license;	
}

}

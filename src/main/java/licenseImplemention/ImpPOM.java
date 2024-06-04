package licenseImplemention;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import login.webpage;

public class ImpPOM  extends webpage{
	private static WebElement license = null;
	public static List<WebElement> elementsList = null;
	//public static  = null;	
	
	
	public static WebElement clickmanageschedule()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[6]/a"));
		return license;
	}
	
	public static WebElement ClickLicesne()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:124']/li[4]"));
		return license;
	
	}
	public static WebElement ClickLicesneStatutory()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:128']/li[1]"));
		return license;	
	
	}
	public static WebElement ClickComplianceMapping()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:128']/li[1]"));
		return license;
	
	}
	public static WebElement mappingexport()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='BodyContent_btnExportExcel']/img"));
		return license;
	
	}
	public static WebElement LicenseCreation()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:128']/li[2]"));
		return license;
	
	}
	public static WebElement LicenseCreation1()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:129']/li[2]"));
		return license;
	
	}
	
	public static WebElement ClickCustomer()	
	{
		license =getDriver().findElement(By.xpath("(//a[@class='chosen-single chosen-default'])[1]"));
	
		return license;	
	}
	public static WebElement selectcustomer()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFilterCustomer_chosen']/a/span"));
		return license;
	
	}
	public static WebElement SearchCustomer()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFilterCustomer_chosen']"));
		return license;
	
	}
	public static WebElement SelectCustomer1()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFilterCustomer_chosen']/div/ul/li[4]"));
		return license;
	
	}
	public static WebElement ClickLicenseType()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/a/span"));
		//*[@id="ContentPlaceHolder1_ddlLicenseType1_chosen"]/a/span
		return license;
	
	}
	public static WebElement SelectLicesetype()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType_chosen']/a/span"));
		return license;
	
	}
	public static WebElement LicenseTotalCount()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_DivRecordsScrum']"));
		return license;
	
	}
	public static WebElement LicensePluseButton()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_lnkViewLicenseInstance_0']/img"));
		return license;
	
	}
	public static WebElement NewAssinmenttab()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_liNotAssigned']"));
		return license;
	
	}
	public static WebElement ClickCustomer2()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFilterCustomer1_chosen']/a"));
		return license;
	
	}
	public static WebElement SelectCustomer2()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFilterCustomer1_chosen']/div/ul/li[3]"));
		return license;
	
	}
	public static WebElement clicklicensetype1()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType1_chosen']/a/span"));
		return license;
	
	}
	public static WebElement searchlice1()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlLicenseType1_chosen']/div/div/input"));
		return license;
	
	}
	public static WebElement ClickLocation1()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocation1']"));
		return license;
	
	}
	public static WebElement LocationCheck()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tvFilterLocation1n0CheckBox']"));
		return license;
	
	}
	public static WebElement SelectButton1()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnlocation1']"));
		return license;
	
	}
	public static WebElement ClickIntenalMapping()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:125']/li[2]"));
		return license;
	
	}
	public static WebElement ClickLicenseInternal()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:121']/li[4]"));
		return license;
	
	}
	public static WebElement ClickLicenseInternallink()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:132']/li[1]/a"));
		return license;
	
	}
	public static WebElement ClickCustomerin()	
	{
		license =getDriver().findElement(By.xpath("//Span[@class='ui-button-text'][1]"));
		return license;
	
	}
	
	public static WebElement ClickPerformer()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_ddlPerformer_0']"));
		return license;
	
	}
	public static WebElement selectperformer()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_ddlPerformer_0']/option[128]"));
		return license;
	
	}
	public static WebElement ClickReviewer()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_ddlReviewer_0']"));
		return license;
	
	}
	public static WebElement Selectreviewer()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_ddlReviewer_0']/option[161]"));
		return license;
	
	}
	public static WebElement impaddassignment()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnSaveLicense1']"));
		return license;
	
	}
	public static WebElement CheckCompliance()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_chkbox_0']"));
	
		return license;
	
	}
	public static WebElement CheckCompliancein()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList1_chkbox1_0']"));
		
		return license;
	
	}
	public static WebElement clicklocation()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilterLocation1']"));
		return license;
	
	}
	public static WebElement successmsg()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_vsLicenseListPage1']"));
		return license;
	
	}
	public static WebElement licenselist()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:128']/li[4]"));
		return license;
	
	}
	public static WebElement custdrop()	
	{
		license =getDriver().findElement(By.xpath("(//*[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s'])[1]"));
		return license;
	
	}
	public static WebElement selectcustomerlist()	
	{
		license =getDriver().findElement(By.xpath("(//*[@class='ui-menu-item'])[8]"));
		return license;
	
	}
	public static WebElement editlicense()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='BodyContent_grdLicenseList_lbtEdit_9']/img"));
		return license;
	
	}
	public static WebElement updatelicenseNo()	
	{
		license =getDriver().findElement(By.xpath("	//*[@id='BodyContent_tbxLicenseNo']"));
		return license;
	
	}
	public static WebElement updatelicensetitle()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxLicenseTitle']"));
		return license;
	
	}
	public static WebElement licenselistsave()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='BodyContent_btnSave']"));
		return license;
	
	}
	public static WebElement manageusertab()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='CMPMenuBar']/ul/li[1]"));
		return license;
	
	}
	public static WebElement usermastertab()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:2']/li[3]"));
		return license;
	
	}
	public static WebElement clickcustdropdown()	
	{
		license =getDriver().findElement(By.xpath("(//*[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s'])[1]"));
		return license;
	
	}
	public static WebElement selectcustomer2()	
	{
		license =getDriver().findElement(By.xpath("(//*[@class='ui-corner-all'])[4]"));
		return license;
	
	}
	public static WebElement modifyentity()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnEntityAssignment_3'"));
		return license;
	
	}
	public static WebElement stutrediolicbtn()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='BodyContent_RadioButtonEntityList_2']"));
		return license;
	
	}
	public static WebElement assignrediobtn()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='BodyContent_RadioButtonList1_0']"));
		return license;
	
	}
	public static WebElement clicklocationimp()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxBranch']"));
		return license;
	
	}
	public static WebElement pluseimg()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='BodyContent_tvBranchesn0']/img"));
		return license;
	
	}
	public static WebElement typeselection()	
	{
		license =getDriver().findElement(By.xpath("(//*[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s'])[2]"));
		return license;
	
	}
	public static WebElement selecttypein()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:127']/li[2]"));
		return license;
	
	}
	public static WebElement Licenselistin()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:134']/li[3]"));
		return license;
	
	}
	public static WebElement LicenseCreatinin()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:134']/li[2]"));
		return license;
	
	}
	public static WebElement selectCustomerin()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFilterCustomer_chosen']"));
		return license;
	
	}
	public static WebElement Chhoescust()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_ddlFilterCustomer']/option[5]"));
		return license;
	
	}
	public static WebElement Appliedliccreation()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='CMPMenuBar:submenu:129']/li[3]"));
		return license;
	
	}
	public static WebElement appliedCheckcompliance()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_chkbox_0']"));
		return license;
	
	}
	public static WebElement appliedstartdate()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_txtStartDate_0']"));
		return license;
	
	}
	public static WebElement appliedsavelic()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnSaveLicense']"));
		return license;
	
	}
	public static WebElement ChkIsPerment()	
	{
		license =getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdLicenseList_ChkIsPerment_0']"));
		return license;
	
	}
	
	public static WebElement SelectCustomerUser()		//Method for closing Message Popup
	{
		license =getDriver().findElement(By.xpath("//*[@id='BodyContent_divCustomerfilter']/div/span/input"));
		return license;                        
	}
	
	public static WebElement customer123Users()		//Method for closing Message Popup
	{
		license =getDriver().findElement(By.linkText("ABCD Pvt Ltd"));
		return license;                        
	}
public static WebElement ModifyEntity()		//Method for closing Message Popup
	{
	license =getDriver().findElement(By.xpath("//*[@id='BodyContent_grdUser_lbtnEntityAssignment_3']"));
		return license;                    
	}



public static WebElement ExpandLocation() //Method for closing Message Popup

{

	license =getDriver().findElement(By.xpath("//*[@id='BodyContent_tvBranchesn0']/img"));
   return license;

}



public static WebElement EAAWSGFJBitaLimited() //Method for closing Message Popup

{

	license =getDriver().findElement(By.xpath("//*[@id='BodyContent_tvBranchesn2CheckBox']"));

return license;

}

public static WebElement LocationEA() {
	license =getDriver().findElement(By.xpath("//*[@id='BodyContent_tbxBranch']"));

	   return license;
	
}
public static WebElement lictype()
{
	license =getDriver().findElement(By.xpath("(//*[@class='ui-menu-item'])[4]"));
	   return license;	
}
public static WebElement clickcategorylic()
{
	license =getDriver().findElement(By.xpath("(//*[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s'])[3]"));
	   return license;	
}
public static WebElement clicksaves()
{
	license =getDriver().findElement(By.xpath("//*[@id='BodyContent_BtnentitySave']"));
	   return license;	
}
public static WebElement validtabel()
{
	license =getDriver().findElement(By.xpath("//*[@id='BodyContent_ctl07']"));
	   return license;	
}
public static WebElement Modifyclose()
{
	license =getDriver().findElement(By.xpath("//*[@id='BodyContent_Button5']"));
	   return license;	
}
public static WebElement Checkallloc()
{
	license =getDriver().findElement(By.xpath("//*[@id='BodyContent_chkallLocation']"));
	   return license;	
}
public static WebElement selectlic1()
{
	license =getDriver().findElement(By.xpath("(//*[@class='ui-menu-item'])[4]"));
	   return license;	
}
public static WebElement deleteentity()
{
	license =getDriver().findElement(By.xpath("//*[@id='BodyContent_RadioButtonList1_1']"));
	   return license;	
}

}

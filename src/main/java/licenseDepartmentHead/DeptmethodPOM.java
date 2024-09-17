package licenseDepartmentHead;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.webpage;

public class DeptmethodPOM extends webpage {
	private static WebElement license = null;		
	private static List<WebElement> elementsList = null;	//WebElement list created for selecting Status-Asc/Desc (Status shows multiple elements back side)
	

	
	public static WebElement clickshowmoredept() 
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_LinkButton3']"));
		return license;
	}
	public static WebElement deptClickExportExpiredOn()	
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_LinkButton1']"));
		return license;

	}
	public static WebElement selectLocation()	
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-in'])[12]"));
		return license;

	}
	public static WebElement deptClickShowMoreExpiringOn()	
	{
		license = getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_LinkButton5']"));
		return license;
		
	}
	public static WebElement SearchLocation()	
	{
		license = getDriver().findElement(By.xpath("(//input[@class='k-textbox'])[1]"));
		return license;
		
	}
	public static WebElement Checkentity()	
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-checkbox-label checkbox-span'])[9]"));
		return license;
		
	}
	public static WebElement Expandloc()	
	{
		license = getDriver().findElement(By.xpath("(//*[@class='k-group k-treeview-lines'])[1]"));
		return license;
		
	}

	
}

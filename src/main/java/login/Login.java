package login;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import performer.OverduePOM;

public class Login 
{
	public static WebDriver driver = null;				//WebDriver instance created
	public static WebElement upload = null;				//WebElement to get upload button
	
	public static void BrowserSetup(String URL)
	{
		//WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\dipali\\Downloads\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		//WebDriver driver= new FirefoxDriver();
	
		System.setProperty("webdriver.chrome.driver","C://Already Automate//Update//chromedriver-win64//chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver"); //Set the Chrome driver variable
		driver = new ChromeDriver();					//Created new Chrome driver instance. 
		//WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();			//Set window size to maximum.
		driver.get(URL);								//Set the URL of WebApplication.
	}
	
	public static WebDriver UserLogin(String username, String password, String method) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		
		LoginPOM.setUname(driver).sendKeys(username);		//Sent username to input box 
		Thread.sleep(500);
		LoginPOM.setPassword(driver).sendKeys(password);	//Sent password to input box
		LoginPOM.clickSubmit(driver).click();				//Clicked on Sign-in button
		
		if(!username.equalsIgnoreCase("performer@avantis.info"))
		{
			try
			{
				Thread.sleep(500);
				wait1.until(ExpectedConditions.visibilityOf(LoginPOM.clickQALink(driver)));
				wait1.until(ExpectedConditions.elementToBeClickable(LoginPOM.clickQALink(driver)));
				LoginPOM.clickQALink(driver).click();				//Clicking on QA Link instead of OTP.
				
				//----------------------------------------------------------
				
				wait1.until(ExpectedConditions.invisibilityOf(LoginPOM.clickQALink(driver)));
			/*}
			catch(Exception e)
			{
				
			}*/
			
			Thread.sleep(500);
			wait1.until(ExpectedConditions.visibilityOf(LoginPOM.Question1(driver)));
			wait1.until(ExpectedConditions.elementToBeClickable(LoginPOM.Question1(driver)));
			String que1 = LoginPOM.Question1(driver).getText();	//Storing the question in que variable.
			String ans1 = null;
			if(method.equalsIgnoreCase("cfo"))
			{
				ans1 = getAnswerCFO(que1);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("License") )
			{
				ans1 = getAnsweImp(que1);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("cfo-diy"))
			{
				ans1 = "123";						//Storing the answer in ans variable.
			}
			else
			{
				ans1 = "123";					//Storing the answer in ans variable.
			}
			
			if(ans1.equalsIgnoreCase("birthplace"))
				LoginPOM.Answer1(driver).sendKeys("123");		//Sending answer to the input box.
			else
				LoginPOM.Answer1(driver).sendKeys("123");		//Sending answer to the input box.
			Thread.sleep(1000);
			
			//----------------------------------------------------------
			
			String que2 = LoginPOM.Question2(driver).getText();	//Storing the question in que variable.
			String ans2 = null;
			if(method.equalsIgnoreCase("cfo"))
			{
				ans2 = getAnswerCFO(que2);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("License") )
			{
				ans2 = getAnsweImp(que2);						//Storing the answer in ans variable.
			}
			else if(method.equalsIgnoreCase("cfo-diy"))
			{
				ans2 = "123";						//Storing the answer in ans variable.
			}
			
			else
			{
				ans2 = "123";							//Storing the answer in ans variable.
			}
			
			if(ans2.equalsIgnoreCase("birthplace"))
				LoginPOM.Answer2(driver).sendKeys("123");		//Sending answer to the input box.
			else
				LoginPOM.Answer2(driver).sendKeys("123");		//Sending answer to the input box.
			Thread.sleep(100);
			
			
		LoginPOM.SubmitAnswer(driver).click();				//Clicking on Submit button.
		}
		catch(Exception e)
		{
			
		}
		}		
		if(!method.equalsIgnoreCase("Implementation"))
		{
			wait1.until(ExpectedConditions.elementToBeClickable(LoginPOM.clickComplicane(driver)));
			if(method.equalsIgnoreCase("License"))
			{
				LoginPOM.clickLicense(driver).click();				//Clicking on Litigation Image.
			}
			else if(method.equalsIgnoreCase("Litigation"))
			{
				LoginPOM.ClickLitigation(driver).click();			//Clicking on Litigation Image.
			}
			else if(method.equalsIgnoreCase("Contract"))
			{
				LoginPOM.ClickContract(driver).click();			//Clicking on Litigation Image.
			}
			else
			{
				LoginPOM.clickComplicane(driver).click();			//Clicking on Compliance Image.
			}
			
			try
			{
				Thread.sleep(500);
				if(OverduePOM.closeMessage(driver).isDisplayed())	//If Compliance Updation message popped up,
				{
					wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.closeMessage(driver)));
					OverduePOM.closeMessage(driver).click();		//then close the message.
				}
			}
			catch(Exception e)
			{
				
			}
		}		
		return driver;
	}
	
	public static String getAnswer(String que)				//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));		//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	
	public static String getAnswerCFO(String que)			//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));	//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		if(ans.equalsIgnoreCase("123"))
			ans = "dog";
		if(ans.equalsIgnoreCase("123"))
			ans = "red";
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	public static String getAnsweImp(String que)			//Method created to extract last word from question
	{														//as it is the answer of the question.
		String last = que.substring(que.lastIndexOf(" "));	//We are selecting word after last " ".
		int len = last.length();							
		String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
		if(ans.equalsIgnoreCase("pet"))
			ans = "pet";
		if(ans.equalsIgnoreCase("car"))
			ans = "car";
		if(ans.equalsIgnoreCase("power"))
			ans = "power";
		return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	}
	
}

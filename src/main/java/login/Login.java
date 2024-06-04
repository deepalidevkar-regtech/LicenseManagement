package login;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxBinary;

import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import performer.OverduePOM;

public class Login extends webpage
{
			//Web instance created
	//public static WebElement upload = null;				//WebElement to get upload button
	
	/*public static void BrowserSetup(String URL)
	{
		//WebManager.chrome().setup();
		//System.setProperty("web.gecko.","C:\\Users\\dipali\\Downloads\\gecko-v0.20.1-win64\\gecko.exe");
		//Web = new Firefox();
	
		System.setProperty("web.chrome.","D:\\chrome-win64\\chrome.exe");
		//System.setProperty("web.chrome.","/usr/bin/chrome"); //Set the Chrome  variable
		 = new Chrome();					//Created new Chrome  instance. 
		//Web  = new Firefox();
		.manage().window().maximize();			//Set window size to maximum.
		.get(URL);								//Set the URL of WebApplication.
	}
	*/
	public static  void UserLogin(String username, String password, String method) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		
		LoginPOM.setUname().sendKeys(username);		//Sent username to input box 
		Thread.sleep(500);
		LoginPOM.setPassword().sendKeys(password);	//Sent password to input box
		LoginPOM.clickSubmit().click();				//Clicked on Sign-in button
		
		if(!username.equalsIgnoreCase("performer@avantis.info"))
		{
			try
			{
				Thread.sleep(500);
				wait.until(ExpectedConditions.visibilityOf(LoginPOM.clickQALink()));
				wait.until(ExpectedConditions.elementToBeClickable(LoginPOM.clickQALink()));
				LoginPOM.clickQALink().click();				//Clicking on QA Link instead of OTP.
				
				//----------------------------------------------------------
				
				wait.until(ExpectedConditions.invisibilityOf(LoginPOM.clickQALink()));
			/*}
			catch(Exception e)
			{
				
			}*/
			
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOf(LoginPOM.Question1()));
			wait.until(ExpectedConditions.elementToBeClickable(LoginPOM.Question1()));
			String que1 = LoginPOM.Question1().getText();	//Storing the question in que variable.
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
				LoginPOM.Answer1().sendKeys("123");		//Sending answer to the input box.
			else
				LoginPOM.Answer1().sendKeys("123");		//Sending answer to the input box.
			Thread.sleep(1000);
			
			//----------------------------------------------------------
			
			String que2 = LoginPOM.Question2().getText();	//Storing the question in que variable.
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
				LoginPOM.Answer2().sendKeys("123");		//Sending answer to the input box.
			else
				LoginPOM.Answer2().sendKeys("123");		//Sending answer to the input box.
			Thread.sleep(100);
			
			
		LoginPOM.SubmitAnswer().click();				//Clicking on Submit button.
		}
		catch(Exception e)
		{
			
		}
		}		
		if(!method.equalsIgnoreCase("Implementation"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(LoginPOM.clickComplicane()));
			if(method.equalsIgnoreCase("License"))
			{
				LoginPOM.clickLicense().click();				//Clicking on Litigation Image.
			}
			else if(method.equalsIgnoreCase("Litigation"))
			{
				LoginPOM.ClickLitigation().click();			//Clicking on Litigation Image.
			}
			else if(method.equalsIgnoreCase("Contract"))
			{
				LoginPOM.ClickContract().click();			//Clicking on Litigation Image.
			}
			else
			{
				LoginPOM.clickComplicane().click();			//Clicking on Compliance Image.
			}
			
			try
			{
				Thread.sleep(500);
				if(OverduePOM.closeMessage().isDisplayed())	//If Compliance Updation message popped up,
				{
					wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.closeMessage()));
					OverduePOM.closeMessage().click();		//then close the message.
				}
			}
			catch(Exception e)
			{
				
			}
		}		
		return ;
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

package com.ApplicationLayer;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.PlatformLayer.*;

/**
 *	This Class contains method which are General Application Functionality. 
 *
 * @Author
 * @Date
 *
 */


public class GN 
{
    /**
     * Opens the browser with Application URL. 
     */
	public static WebDriver openBrowser(HashMap<String,String> OR, HashMap<String,String> testData, String strTCID)
	{
		WebDriver driver = null;
		try
		{	
			if (Framework.isBrowserOpen==false)
			{
				driver = WD.openBrowser(Framework.config.get("BROWSER"), testData.get("URL"));
				WD.waitForPage(driver,"By.id",OR.get("btnLogin"));
				String strTemp;
				strTemp = ReadText.byXpath(driver,"//*[@id='aspnetForm']/div[3]/label[1]");
				if(strTemp.contains("Username:"))
					Framework.write(Result.PASS, "Browser opened successfully with test application", true, strTCID, driver);
				else
					Framework.write(Result.FAIL, "Failed to open browser with test application", true, strTCID, driver);
			}
		}
		catch (Exception e)
		{
			Framework.write(Result.ERROR, e.getMessage(), false, strTCID, driver);
		}
		return(driver);
	}
    /**
     * Logins to the WD Application. 
     */		
	public static void login(WebDriver driver, HashMap<String,String> OR, HashMap<String,String> testData, String strTCID)
	{
		try
		{
			if (Framework.isBrowserOpen==false)
			{				
				InputText.byId(driver,OR.get("txtUserName"), testData.get("USERNAME"));
				InputText.byId(driver,OR.get("txtPassword"), testData.get("PASSWORD"));
				Click.byId(driver,OR.get("btnLogin"));
				WD.waitForPage(driver,"By.xpath",testData.get("HEAD"));
				String strTemp;
				strTemp = ReadText.byXpath(driver,testData.get("HEAD"));
				if(strTemp.contains("Welcome,"))
					Framework.write(Result.PASS, "User logged-in successfully", true, strTCID, driver);
				else
					Framework.write(Result.FAIL, "Failed to logged-in", true, strTCID, driver);
				Framework.isBrowserOpen=true;
			}			
		}
		catch (Exception e)
		{
			Framework.isBrowserOpen=false;
			Framework.write(Result.ERROR, e.getMessage(), false, strTCID, driver);
		}		
	}
    /**
     * Logs out from the Application. 
     */		
	public static void logout(WebDriver driver, HashMap<String,String> OR, HashMap<String,String> testData, String strTCID)
	{
		if(Framework.isBrowserOpen==true)
		{		
			try
			{
				Click.byLinkText(driver,OR.get("lnkLogout"));
				WD.waitForPage(driver,"By.id",OR.get("btnLogin"));
				String strTemp;
				strTemp = ReadText.byXpath(driver,"//*[@id='aspnetForm']/div[3]/label[1]");
				if(strTemp.contains("Username:"))
					Framework.write(Result.PASS, "User logged-out successfully", true, strTCID, driver);
				else
					Framework.write(Result.FAIL, "Failed to logged-out", true, strTCID, driver);
			}
			catch (Exception e)
			{
				Framework.logger.severe("Error in GN.logout " + e.getMessage());
			}	
		}
	}	
    /**
     * Close the browser. 
     */		
	public static void closeBrowser(WebDriver driver)
	{
		if(Framework.isBrowserOpen==true)
		{		
			try
			{		
				WD.closeBrowser(driver);
				Framework.logger.info("Browser Closed Successfully");
				Framework.isBrowserOpen=false;
			}
			catch (Exception e)
			{
				Framework.isBrowserOpen=true;
				Framework.logger.severe("Error in GN.closeBrowser " + e.getMessage());
			}	
		}
	}
}
package com.BusinessScript;

import java.io.IOException;
import java.util.HashMap;
import com.ApplicationLayer.GN;
import com.PlatformLayer.Framework;
import com.PlatformLayer.Result;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HelloWorld1 
{
	@Test
	public void TC0001() throws IOException
	{
		WebDriver driver = null;
		HashMap<String,String> 	OR = null;
		HashMap<String,String> 	testData = null;
		String strTCID = Thread.currentThread().getStackTrace()[1].getMethodName();		
		if ("Yes".equalsIgnoreCase(Framework.config.get(strTCID)) && "Yes".equalsIgnoreCase(Framework.config.get(Framework.tcTaskId.get(strTCID))))
		{
			OR = Framework.readOR(strTCID);
			testData = Framework.readTestData(strTCID);
			try
			{
				driver = GN.openBrowser(OR,testData,strTCID);
				GN.login(driver,OR,testData,strTCID);
				GN.logout(driver,OR,testData,strTCID);
				GN.closeBrowser(driver);
			}
			catch (Exception e)
			{
				Framework.write(Result.ERROR, e.getMessage(), false, strTCID, driver);
			}
		}
	}	
}
package com.ApplicationLayer;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.PlatformLayer.Click;
import com.PlatformLayer.Framework;
import com.PlatformLayer.InputText;
import com.PlatformLayer.MouseHover;
//import com.PlatformLayer.ReadText;
import com.PlatformLayer.Result;
import com.PlatformLayer.SelectDropDown;
//import com.PlatformLayer.WD;
import com.PlatformLayer.WD;

public class CreateNewUser 
{
    /**
     * Logins to the WD Application. 
     */		
	public static void Create(WebDriver driver, HashMap<String,String> OR, HashMap<String,String> testData, String strTCID)
	{
		try
		{
//			Click.byXpath(driver, "//li[@id='menu-users']/a/div[3]");
			MouseHover.byXpath(driver,".//*[@id='wpbody-content']/div[3]/h1","//li[@id='menu-users']/a/div[3]");
			Click.byLinkText(driver,"Add New");
			WD.waitForPage(driver,"By.id",OR.get("btnSubmit"));
			InputText.byId(driver, OR.get("txtUserLogin"), testData.get("NEWUSERNAME"));
			InputText.byId(driver, OR.get("txtEmail"), testData.get("NEWEMAIL"));
			InputText.byId(driver, OR.get("txtFirstName"), testData.get("NEWUSERFIRSTNAME"));
			InputText.byId(driver, OR.get("txtLastName"), testData.get("NEWUSERLASTNAME"));
//			Click.byXpath(driver, ".//*[@id='createuser']/table/tbody/tr[6]/td/button");
//			WD.wait(5);
//			InputText.byId(driver, OR.get("txtUserPassword"), testData.get("NEWPASSWORD"));			
//			WD.wait(5);
			SelectDropDown.byId(driver, OR.get("ddlRole"), testData.get("NEWROLE"));
			WD.wait(5);
			Click.byId(driver, OR.get("btnSubmit"));
//			String strTemp;
//			strTemp = ReadText.byXpath(driver,".//*[@id='wpbody-content']/div[3]/h1");
//			if(strTemp.contains("Dashboard"))
//				Framework.write(Result.PASS, "User logged-in successfully with Wordpress", true, strTCID, driver);
//			else
//				Framework.write(Result.FAIL, "Failed to logged-in with Wordpress", true, strTCID, driver);
			Framework.isBrowserOpen=true;
		}
		catch (Exception e)
		{
			Framework.isBrowserOpen=false;
			Framework.write(Result.ERROR, e.getMessage(), false, strTCID, driver);
		}		
	}
}

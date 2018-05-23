package com.ApplicationLayer;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.PlatformLayer.Click;
import com.PlatformLayer.Framework;
import com.PlatformLayer.InputText;
import com.PlatformLayer.ReadText;
import com.PlatformLayer.Result;
import com.PlatformLayer.WD;

public class CyclosApplication {

	public static WebDriver OpenURL(HashMap<String, String> OR, HashMap<String, String> testData, String strTCID) {

		WebDriver driver = null;
		try {
			if (Framework.isBrowserOpen == false) {
				driver = WD.openBrowser(Framework.config.get("BROWSER"), testData.get("URL"));
				// WD.waitForPage(driver, "By.id", OR.get("btnLogin"));
				/*
				 * String strTemp; strTemp = ReadText.byXpath(driver,
				 * "//*[@id='cyclosLogin']/table/tbody/tr[1]/td[1]"); if
				 * (strTemp.contains("Login name")) Framework.write(Result.PASS,
				 * "Browser opened successfully with test application", true,
				 * strTCID, driver); else Framework.write(Result.FAIL,
				 * "Failed to open browser with test application", true,
				 * strTCID, driver);
				 */
			}
		} catch (Exception e) {
			Framework.write(Result.ERROR, e.getMessage(), false, strTCID, driver);
		}
		return (driver);
	}

	public static void login(WebDriver driver, HashMap<String, String> OR, HashMap<String, String> testData,
			String strTCID) {
		try {
			if (Framework.isBrowserOpen == false) {
				InputText.byId(driver, OR.get("txtUserName"), testData.get("USERNAME"));
				InputText.byId(driver, OR.get("txtPassword"), testData.get("PASSWORD"));
				Click.byXpath(driver, OR.get("btnLogin"));
				// WD.waitForPage(driver,"By.xpath",testData.get("HEAD"));
				/*
				 * String strTemp; strTemp =
				 * ReadText.byXpath(driver,testData.get("HEAD"));
				 * if(strTemp.contains("Open Source on-line banking software"))
				 * Framework.write(Result.PASS, "User logged-in successfully",
				 * true, strTCID, driver); else Framework.write(Result.FAIL,
				 * "Failed to logged-in", true, strTCID, driver);
				 */
				Framework.isBrowserOpen = true;
			}
		} catch (Exception e) {
			Framework.isBrowserOpen = true;
			Framework.write(Result.ERROR, e.getMessage(), false, strTCID, driver);
		}
	}

	public static void createCurrency(WebDriver driver, HashMap<String, String> OR, HashMap<String, String> testData,
			String strTCID) {
		try {
			if (Framework.isBrowserOpen == true) {
				
				Click.byXpath(driver, OR.get("btnAccounts"));
				Click.byXpath(driver, OR.get("btnManageCurrency"));
				Click.byId(driver, OR.get("btnNew"));
				InputText.byName(driver, OR.get("txtCurrencyName"),testData.get("CURRNAME"));
				InputText.byName(driver, OR.get("txtCurrencySymbol"),testData.get("CURRSYMBOL"));
				InputText.byName(driver, OR.get("txtCurrencyPattern"),testData.get("CURRPATTERN"));
				InputText.byName(driver, OR.get("txtCurrencyDescription"),testData.get("CURRDESCRIPTION"));
				Click.byId(driver, OR.get("btnSave"));

				Alert al = driver.switchTo().alert();
				al.accept();

				// WD.waitForPage(driver,"By.xpath",testData.get("HEAD"));
				/*
				 * String strTemp; strTemp =
				 * ReadText.byXpath(driver,testData.get("HEAD"));
				 * if(strTemp.contains("Open Source on-line banking software"))
				 * Framework.write(Result.PASS, "User logged-in successfully",
				 * true, strTCID, driver); else Framework.write(Result.FAIL,
				 * "Failed to logged-in", true, strTCID, driver);
				 */
				Framework.isBrowserOpen = true;
			}
		} catch (Exception e) {
			Framework.isBrowserOpen = false;
			Framework.write(Result.ERROR, e.getMessage(), false, strTCID, driver);
		}
	}



	public static void logout(WebDriver driver, HashMap<String, String> OR, HashMap<String, String> testData,
			String strTCID) {
		try {
			if (Framework.isBrowserOpen == true) {
				Click.byXpath(driver, OR.get("btnLogout"));
				Alert al = driver.switchTo().alert();
				al.accept();
				Framework.isBrowserOpen = true;

			}
		} catch (Exception e) {
			Framework.isBrowserOpen = false;
			Framework.write(Result.ERROR, e.getMessage(), false, strTCID, driver);
		}
	}
	
	public static void closeBrowser(WebDriver driver) {
		try {
			if (Framework.isBrowserOpen == true) {
				driver.close();
				Framework.isBrowserOpen = true;
			}
		} catch (Exception e) {
			Framework.isBrowserOpen = false;
			Framework.write(Result.ERROR, e.getMessage(), false,"",driver);
		}
	}
}

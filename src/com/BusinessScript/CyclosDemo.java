package com.BusinessScript;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.ApplicationLayer.CyclosApplication;
import com.PlatformLayer.Framework;
import com.PlatformLayer.Result;

public class CyclosDemo {

	@Test
	public void TC0001() throws IOException {
		WebDriver driver = null;
		HashMap<String, String> OR = null;
		HashMap<String, String> testData = null;
		String strTCID = Thread.currentThread().getStackTrace()[1].getMethodName();
		if ("Yes".equalsIgnoreCase(Framework.config.get(strTCID))
				&& "Yes".equalsIgnoreCase(Framework.config.get(Framework.tcTaskId.get(strTCID)))) {
			OR = Framework.readOR(strTCID);
			testData = Framework.readTestData(strTCID);
			try {
				driver = CyclosApplication.OpenURL(OR, testData, strTCID);
				CyclosApplication.login(driver, OR, testData, strTCID);
				CyclosApplication.createCurrency(driver, OR, testData, strTCID);
				CyclosApplication.logout(driver, OR, testData, strTCID);
				CyclosApplication.closeBrowser(driver);

			} catch (Exception e) {
				Framework.write(Result.ERROR, e.getMessage(), false, strTCID, driver);
			}
		}

	}

}

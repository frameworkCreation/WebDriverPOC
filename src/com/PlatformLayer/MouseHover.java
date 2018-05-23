package com.PlatformLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseHover 
{
    /**
     * Mouse Hover the object on UI By.byXpath. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */		
	public static void byXpath(WebDriver driver,String strValue1, String strValue2)
	{
		try
		{
			WebElement element1 = null;
			element1 = WD.findObject(driver,"By.xpath",strValue1);
			Actions action = new Actions(driver);
			action.moveToElement(element1);
			action.perform();
			WebElement element2 = null;
			element2 = WD.findObject(driver,"By.xpath",strValue2);
			action.moveToElement(element2);
			action.perform();
			action.click();
			action.perform();
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in MouseHover.byXpath " + e.getMessage());
		}		
	}
}

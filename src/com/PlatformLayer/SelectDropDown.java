package com.PlatformLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown 
{
    /**
     * Select the drop down on UI By.id. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strToSelect: String value to select from drop down.
     */	
	public static void byId(WebDriver driver,String strValue,String strToSelect)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.id",strValue);
			Select select = new Select(element);
			//select.deselectAll();
			select.selectByVisibleText(strToSelect);
			WD.wait(1);
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in IsObjectPresent.byId " + e.getMessage());
		}	
	}
	/**
     * Select the drop down on UI By.name. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strToSelect: String value to select from drop down.
     */	
	public static void byName(WebDriver driver,String strValue,String strToSelect)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.name",strValue);
			Select select = new Select(element);
			select.selectByVisibleText(strToSelect);
			WD.wait(1);
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in SelectDropDown.byName " + e.getMessage());
		}	
	}
    /**
     * Select the drop down on UI By.xpath. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strToSelect: String value to select from drop down.
     */	
	public static void byXpath(WebDriver driver,String strValue,String strToSelect)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.xpath",strValue);
			Select select = new Select(element);
			select.selectByVisibleText(strToSelect);
			WD.wait(1);
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in SelectDropDown.byXpath " + e.getMessage());
		}	
	}
}

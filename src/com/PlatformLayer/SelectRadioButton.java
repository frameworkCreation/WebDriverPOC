package com.PlatformLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectRadioButton 
{
    /**
     * Selects the Radio Button on UI By.Id. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */		
	public static void byId(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.id",strValue);
			element.click();		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in SelectRadioButton.byId " + e.getMessage());
		}	
	}
    /**
     * Selects the Radio Button on UI By.className. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */	
	public static void byClassName(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.className",strValue);
			element.click();		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in SelectRadioButton.byClassName " + e.getMessage());
		}	
	}
    /**
     * Selects the Radio Button on UI By.tagName. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */	
	public static void byTagName(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.tagName",strValue);
			element.click();		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in SelectRadioButton.byTagName " + e.getMessage());
		}	
	}
    /**
     * Selects the Radio Button on UI By.name. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */	
	public static void byName(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.name",strValue);
			element.click();		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in SelectRadioButton.byName " + e.getMessage());
		}	
	}
    /**
     * Selects the Radio Button on UI By.linkText. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */	
	public static void byLinkText(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.linkText",strValue);
			element.click();		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in SelectRadioButton.byLinkText " + e.getMessage());
		}	
	}
    /**
     * Selects the Radio Button on UI By.partialLinkText. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */	
	public static void byPartialLinkText(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.partialLinkText",strValue);
			element.click();		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in SelectRadioButton.byPartialLinkText " + e.getMessage());
		}	
	}
    /**
     * Selects the Radio Button on UI By.cssSelector. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */	
	public static void byCssSelector(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.cssSelector",strValue);
			element.click();		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in SelectRadioButton.byCssSelector " + e.getMessage());
		}	
	}
    /**
     * Selects the Radio Button on UI By.xpath. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */	
	public static void byXpath(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.xpath",strValue);
			element.click();		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in SelectRadioButton.byXpath " + e.getMessage());
		}	
	}
}

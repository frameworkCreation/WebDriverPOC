package com.PlatformLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectCheckBox 
{
    /**
     * Selects the Check Box on UI By.Id. 
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
			Framework.logger.severe("Error in SelectCheckBox.byId " + e.getMessage());
		}	
	}
    /**
     * Selects the Check Box on UI By.className. 
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
			Framework.logger.severe("Error in SelectCheckBox.byClassName " + e.getMessage());
		}	
	}
    /**
     * Selects the Check Box on UI By.tagName. 
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
			Framework.logger.severe("Error in SelectCheckBox.byTagName " + e.getMessage());
		}	
	}
    /**
     * Selects the Check Box on UI By.name. 
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
			Framework.logger.severe("Error in SelectCheckBox.byName " + e.getMessage());
		}	
	}
    /**
     * Selects the Check Box on UI By.linkText. 
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
			Framework.logger.severe("Error in SelectCheckBox.byLinkText " + e.getMessage());
		}	
	}
    /**
     * Selects the Check Box on UI By.partialLinkText. 
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
			Framework.logger.severe("Error in SelectCheckBox.byPartialLinkText " + e.getMessage());
		}	
	}
    /**
     * Selects the Check Box on UI By.cssSelector. 
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
			Framework.logger.severe("Error in SelectCheckBox.byCssSelector " + e.getMessage());
		}	
	}
    /**
     * Selects the Check Box on UI By.xpath. 
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
			Framework.logger.severe("Error in SelectCheckBox.byXpath " + e.getMessage());
		}	
	}
}

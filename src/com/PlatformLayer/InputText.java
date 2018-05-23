package com.PlatformLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputText 
{
    /**
     * Set the input text on UI By.id. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strToSet: String value to set.
     */		
	public static void byId(WebDriver driver,String strValue,String strToSet)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.id",strValue);			
			element.clear();
			element.sendKeys(strToSet);
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in InputText.byId " + e.getMessage());
		}	
	}	
    /**
     * Set the input text on UI By.className. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strToSet: String value to set.
     */	
	public static void byClassName(WebDriver driver,String strValue,String strToSet)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.className",strValue);
			element.clear();
			element.sendKeys(strToSet);		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in InputText.byClassName " + e.getMessage());
		}	
	}
    /**
     * Set the input text on UI By.tagName. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strToSet: String value to set.
     */	
	public static void byTagName(WebDriver driver,String strValue,String strToSet)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.tagName",strValue);
			element.clear();
			element.sendKeys(strToSet);		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in InputText.byTagName " + e.getMessage());
		}	
	}
    /**
     * Set the input text on UI By.name. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strToSet: String value to set.
     */	
	public static void byName(WebDriver driver,String strValue,String strToSet)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.name",strValue);
			element.clear();
			element.sendKeys(strToSet);		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in InputText.byName " + e.getMessage());
		}	
	}
    /**
     * Set the input text on UI By.linkText. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strToSet: String value to set.
     */	
	public static void byLinkText(WebDriver driver,String strValue,String strToSet)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.linkText",strValue);
			element.clear();
			element.sendKeys(strToSet);		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in InputText.byLinkText " + e.getMessage());
		}	
	}
    /**
     * Set the input text on UI By.partialLinkText. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strToSet: String value to set.
     */	
	public static void byPartialLinkText(WebDriver driver,String strValue,String strToSet)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.partialLinkText",strValue);
			element.clear();
			element.sendKeys(strToSet);		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in InputText.byPartialLinkText " + e.getMessage());
		}	
	}
    /**
     * Set the input text on UI By.cssSelector. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strToSet: String value to set.
     */	
	public static void byCssSelector(WebDriver driver,String strValue,String strToSet)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.cssSelector",strValue);
			element.clear();
			element.sendKeys(strToSet);		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in InputText.byCssSelector " + e.getMessage());
		}	
	}
    /**
     * Set the input text on UI By.xpath. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strToSet: String value to set.
     */	
	public static void byXpath(WebDriver driver,String strValue,String strToSet)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.xpath",strValue);
			element.clear();
			element.sendKeys(strToSet);		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in InputText.byXpath " + e.getMessage());
		}
	}	
}

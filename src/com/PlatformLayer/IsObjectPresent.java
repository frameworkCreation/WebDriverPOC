package com.PlatformLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IsObjectPresent 
{
    /**
     * Checks the object is present or not on UI By.Id. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. boolWait: Want to wait till implicit timeout.
     */		
	public static boolean byId(WebDriver driver,String strValue, boolean boolWait)
	{
		try
		{		
			if(boolWait)
			{
				WebElement element = null;
				element = WD.findObject(driver,"By.Id",strValue);
				return(element.isDisplayed());
			}
			else
				return(true);
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in IsObjectPresent.byId " + e.getMessage());
			return(false);
		}		
	}
    /**
     * Checks the object is present or not on UI By.className. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */		
	public static boolean byClassName(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.className",strValue);
			return(element.isDisplayed());	
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in IsObjectPresent.byClassName " + e.getMessage());
			return(false);
		}		
	}
    /**
     * Checks the object is present or not on UI By.tagName. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */		
	public static boolean byTagName(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.tagName",strValue);
			return(element.isDisplayed());	
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in IsObjectPresent.byTagName " + e.getMessage());
			return(false);
		}		
	}
    /**
     * Checks the object is present or not on UI By.name. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. boolWait: Want to wait till implicit timeout.
     */		
	public static boolean byName(WebDriver driver,String strValue, boolean boolWait)
	{
		try
		{
			if(boolWait)
			{			
				WebElement element = null;
				element = WD.findObject(driver,"By.name",strValue);
				return(element.isDisplayed());
			}
			else
				return(true);
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in IsObjectPresent.byName " + e.getMessage());
			return(false);
		}		
	}	
    /**
     * Checks the object is present or not on UI By.linkText. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. boolWait: Want to wait till implicit timeout. 
     */		
	public static boolean byLinkText(WebDriver driver,String strValue, boolean boolWait)
	{
		try
		{		
			if(boolWait)
			{
				WebElement element = null;
				element = WD.findObject(driver,"By.linkText",strValue);
				return(element.isDisplayed());
			}
			else
				return(true);
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in IsObjectPresent.byLinkText " + e.getMessage());
			return(false);
		}		
	}
    /**
     * Checks the object is present or not on UI By.partialLinkText. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */		
	public static boolean byPartialLinkText(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.partialLinkText",strValue);
			return(element.isDisplayed());	
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in PN.isObjectPresentPartialLinkText " + e.getMessage());
			return(false);
		}		
	}
    /**
     * Checks the object is present or not on UI By.cssSelector. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */		
	public static boolean byCssSelector(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.cssSelector",strValue);
			return(element.isDisplayed());	
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in IsObjectPresent.byCssSelector " + e.getMessage());
			return(false);
		}		
	}	
    /**
     * Checks the object is present or not on UI By.xpath. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. boolWait: Want to wait till implicit timeout.
     */		
	public static boolean byXpath(WebDriver driver,String strValue, boolean boolWait)
	{
		try
		{	
			if(boolWait)
			{			
				WebElement element = null;
				element = WD.findObject(driver,"By.xpath",strValue);
				return(element.isDisplayed());
			}
			else
				return(true);
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in IsObjectPresent.byXpath " + e.getMessage());
			return(false);
		}		
	}
}

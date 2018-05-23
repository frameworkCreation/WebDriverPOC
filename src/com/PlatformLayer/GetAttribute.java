package com.PlatformLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute 
{
    /**
     * Reads the Attribute Value from UI By.id. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strAttribute: Attribute to find value.
     */		
	public static String byId(WebDriver driver, String strValue, String strAttribute)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.id",strValue);
			return(element.getAttribute(strAttribute));		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in GetAttribute.byId " + e.getMessage());
			return("");
		}	
	}
    /**
     * Reads the Attribute Value from UI By.className. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strAttribute: Attribute to find value.
     */		
	public static String byClassName(WebDriver driver,String strValue, String strAttribute)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.className",strValue);
			return(element.getAttribute(strAttribute));		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in GetAttribute.byClassName " + e.getMessage());
			return("");
		}	
	}
    /**
     * Reads the Attribute Value from UI By.tagName. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strAttribute: Attribute to find value.
     */		
	public static String byTagName(WebDriver driver,String strValue, String strAttribute)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.tagName",strValue);
			return(element.getAttribute(strAttribute));		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in GetAttribute.byTagName " + e.getMessage());
			return("");
		}	
	}
    /**
     * Reads the Attribute Value from UI By.name. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strAttribute: Attribute to find value.
     */		
	public static String byName(WebDriver driver,String strValue, String strAttribute)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.name",strValue);
			return(element.getAttribute(strAttribute));		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in GetAttribute.byName " + e.getMessage());
			return("");
		}	
	}
    /**
     * Reads the Attribute Value from UI By.linkText. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strAttribute: Attribute to find value.
     */		
	public static String byLinkText(WebDriver driver,String strValue, String strAttribute)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.linkText",strValue);
			return(element.getAttribute(strAttribute));		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in GetAttribute.byLinkText " + e.getMessage());
			return("");
		}	
	}
    /**
     * Reads the Attribute Value from UI By.partialLinkText. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strAttribute: Attribute to find value.
     */		
	public static String byPartialLinkText(WebDriver driver,String strValue, String strAttribute)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.partialLinkText",strValue);
			return(element.getAttribute(strAttribute));		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in GetAttribute.byPartialLinkText " + e.getMessage());
			return("");
		}	
	}
    /**
     * Reads the Attribute Value from UI By.cssSelector. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strAttribute: Attribute to find value.
     */		
	public static String byCssSelector(WebDriver driver,String strValue, String strAttribute)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.cssSelector",strValue);
			return(element.getAttribute(strAttribute));		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in GetAttribute.byCssSelector " + e.getMessage());
			return("");
		}	
	}
    /**
     * Reads the Attribute Value from UI By.xpath. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     * 2. strAttribute: Attribute to find value.
     */		
	public static String byXpath(WebDriver driver, String strValue, String strAttribute)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.xpath",strValue);
			return(element.getAttribute(strAttribute));		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in GetAttribute.byXpath " + e.getMessage());
			return("");
		}
	}
}

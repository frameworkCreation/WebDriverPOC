package com.PlatformLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReadText 
{
    /**
     * Reads the text from UI By.id. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */		
	public static String byId(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.id",strValue);
			return(element.getText());		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in ReadText.byId " + e.getMessage());
			return("");
		}	
	}
    /**
     * Reads the text from UI By.className. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */		
	public static String byClassName(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.className",strValue);
			return(element.getText());		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in ReadText.byClassName " + e.getMessage());
			return("");
		}	
	}
    /**
     * Reads the text from UI By.tagName. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */		
	public static String byTagName(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.tagName",strValue);
			return(element.getText());		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in ReadText.byTagName " + e.getMessage());
			return("");
		}	
	}
    /**
     * Reads the text from UI By.name. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */		
	public static String byName(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.name",strValue);
			return(element.getText());		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in ReadText.byName " + e.getMessage());
			return("");
		}	
	}
    /**
     * Reads the text from UI By.linkText. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */		
	public static String byLinkText(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.linkText",strValue);
			return(element.getText());		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in ReadText.byLinkText " + e.getMessage());
			return("");
		}	
	}
    /**
     * Reads the text from UI By.partialLinkText. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */		
	public static String byPartialLinkText(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.partialLinkText",strValue);
			return(element.getText());		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in ReadText.byPartialLinkText " + e.getMessage());
			return("");
		}	
	}
    /**
     * Reads the text from UI By.cssSelector. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */		
	public static String byCssSelector(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.cssSelector",strValue);
			return(element.getText());		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in ReadText.byCssSelector " + e.getMessage());
			return("");
		}	
	}
    /**
     * Reads the text from UI By.xpath. 
     * Arguments: 
     * 1. strValue: Object property to find object on UI.
     */		
	public static String byXpath(WebDriver driver,String strValue)
	{
		try
		{		
			WebElement element = null;
			element = WD.findObject(driver,"By.xpath",strValue);
			return(element.getText());		
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in ReadText.byXpath " + e.getMessage());
			return("");
		}
	}
}

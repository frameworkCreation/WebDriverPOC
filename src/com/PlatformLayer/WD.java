package com.PlatformLayer;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WD 
{
	private static final Long MIN_WAIT_TIME_IN_MS 	= 1000L;

	/**
     * Opens the Browser like ie, firefox, chrome and safari. 
     * Arguments: 
     * 1. strBrowserType: like like ie, firefox, chrome and safari.
     * 2. strUrl: Application URL.
     */
	public static WebDriver openBrowser(String strBrowserType, String strUrl)
	{
		WebDriver driver = null;
		try
		{
			DesiredCapabilities capabilities = null;
			if(strBrowserType.equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.ie.driver", ".\\lib\\IEDriverServer.exe");
				wait(5);
				capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				capabilities.setJavascriptEnabled(true);
				capabilities.setPlatform(Platform.WINDOWS);
			}
			else if(strBrowserType.equalsIgnoreCase("firefox"))
			{
				ProfilesIni allProfiles = new ProfilesIni();
				FirefoxProfile profile = allProfiles.getProfile("Automation");
				capabilities = DesiredCapabilities.firefox();
				capabilities.setPlatform(Platform.ANY);
				capabilities.setCapability(FirefoxDriver.PROFILE, profile);
			}
			else if(strBrowserType.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
				wait(5);
				capabilities = DesiredCapabilities.chrome();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Framework.config.get("IMPLICIT-WAIT")), TimeUnit.SECONDS);
			driver.get(strUrl);
			Framework.logger.info("Browser " + strBrowserType.toString() + " with URL " + strUrl.toString() + " opened successfully...");
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in WD.opeBrowser " + e.getMessage());
		}
		return(driver);
	}
	
    /**
     * Find the object on UI. 
     * Arguments: 
     * 1. strBy: like id, name, xpath and etc.
     * 2. strValue: property to find object.
     */	
	public static WebElement findObject(WebDriver driver, String strBy, String strValue)
	{
		WebElement element = null;
		try
		{
			if(strBy.equals("By.id"))
				element = driver.findElement(By.id(strValue));
			else if(strBy.equals("By.className"))
				element = driver.findElement(By.className(strValue));
			else if(strBy.equals("By.tagName"))
				element = driver.findElement(By.tagName(strValue));
			else if(strBy.equals("By.name"))
				element = driver.findElement(By.name(strValue));
			else if(strBy.equals("By.linkText"))
				element = driver.findElement(By.linkText(strValue));
			else if(strBy.equals("By.partialLinkText"))
				element = driver.findElement(By.partialLinkText(strValue));
			else if(strBy.equals("By.cssSelector"))
				element = driver.findElement(By.cssSelector(strValue));
			else if(strBy.equals("By.xpath"))
				element = driver.findElement(By.xpath(strValue));
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in WD.findObject " + e.getMessage());
		}		
		return(element);
	}
    /**
     * Wait for page to load. 
     */		
	public static void waitForPage(WebDriver driver, String strBy, String strValue)
	{
		try
		{		
			WebDriverWait wait = new WebDriverWait(driver,120);
			if(strBy.equals("By.id"))
				wait.until(ExpectedConditions.elementToBeClickable(By.id(strValue)));
			else if(strBy.equals("By.className"))
				wait.until(ExpectedConditions.elementToBeClickable(By.className(strValue)));
			else if(strBy.equals("By.tagName"))
				wait.until(ExpectedConditions.elementToBeClickable(By.tagName(strValue)));
			else if(strBy.equals("By.name"))
				wait.until(ExpectedConditions.elementToBeClickable(By.name(strValue)));
			else if(strBy.equals("By.linkText"))
				wait.until(ExpectedConditions.elementToBeClickable(By.linkText(strValue)));
			else if(strBy.equals("By.partialLinkText"))
				wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(strValue)));
			else if(strBy.equals("By.cssSelector"))
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(strValue)));
			else if(strBy.equals("By.xpath"))
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(strValue)));			
			wait(2);
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in WD.waitForPage " + e.getMessage());
		}	
	}
    /**
     * Wait till timeOut Seconds. 
     * Arguments: 
     * 1. timeOut: Seconds to wait.
     */		
	public static void wait(int timeOut)
	{
		try
		{		
			int count =0;
			while(true)
			{
				if (count < timeOut)
				{
					try
					{
						// Sleep at least n milliseconds. 1 millisecond = 1/1000 of a second.
						Thread.sleep(MIN_WAIT_TIME_IN_MS);
						count++;
					}
					catch (InterruptedException e )
					{
						Framework.logger.severe("Thread Interrupted !!!");
					}
				}
				else
					break;
			}
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in WD.wait " + e.getMessage());
		}	
	}	
    /**
     * Close the browser. 
     */		
	public static void closeBrowser(WebDriver driver)
	{
		try
		{		
			driver.quit();
		}
		catch (Exception e) 
		{
			Framework.logger.severe("Error in WD.closeBrowser " + e.getMessage());
		}	
	}	
   public static void checkPointXPathAndTextW(WebDriver driver, String strXpath, String strText, String strMsg, String strTCID)
    {
       if(ReadText.byXpath(driver,strXpath).equals(strText))
          Framework.write(Result.PASS, strMsg + " " + strText + " displayed successfully",true, strTCID, driver);
       else
          Framework.write(Result.WARNING, "Failed to display " + strText + " " + strMsg,true, strTCID, driver);               
    }
    public static void checkPointXPathAndText(WebDriver driver, String strXpath, String strText, String strMsg, String strTCID)
    {
       if(ReadText.byXpath(driver,strXpath).equals(strText))
          Framework.write(Result.PASS, strMsg + " " + strText + " displayed successfully",true, strTCID, driver);
       else
          Framework.write(Result.FAIL, "Failed to display " + strText + " " + strMsg,true, strTCID, driver);            
    }
    public static void checkPointXPathAndTextGW(WebDriver driver, String strXpath, String strText, String strMsg, String strTCID)
    {
       if(ReadText.byXpath(driver,strXpath).contains(strText))
          Framework.write(Result.PASS, strMsg + " " + strText + " displayed successfully",true, strTCID, driver);
       else
          Framework.write(Result.WARNING, "Failed to display " + strText + " " + strMsg,true, strTCID, driver);               
    }
    public static void checkPointXPathAndTextG(WebDriver driver, String strXpath, String strText, String strMsg, String strTCID)
    {
       if(ReadText.byXpath(driver,strXpath).contains(strText))
          Framework.write(Result.PASS, strMsg + " " + strText + " displayed successfully",true, strTCID, driver);
       else
          Framework.write(Result.FAIL, "Failed to display " + strText + " " + strMsg,true, strTCID, driver);            
    }
    public static void checkPointXPathAndObjW(WebDriver driver, String strXpath, String strPassMsg, String strFailMsg, String strTCID)
    {
       if(IsObjectPresent.byXpath(driver,strXpath,false))
          Framework.write(Result.PASS, strPassMsg,true, strTCID, driver);
       else
          Framework.write(Result.WARNING, strFailMsg,true, strTCID, driver);                
    }
    public static void checkPointXPathAndObj(WebDriver driver, String strXpath, String strPassMsg, String strFailMsg, String strTCID)
    {
       if(IsObjectPresent.byXpath(driver,strXpath,false))
          Framework.write(Result.PASS, strPassMsg,true, strTCID, driver);
       else
          Framework.write(Result.FAIL, strFailMsg,true, strTCID, driver);                   
    }	
}
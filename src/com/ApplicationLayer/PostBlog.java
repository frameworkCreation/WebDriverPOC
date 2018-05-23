package com.ApplicationLayer;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.PlatformLayer.Click;
import com.PlatformLayer.Framework;
import com.PlatformLayer.MouseHover;
import com.PlatformLayer.ReadText;
import com.PlatformLayer.Result;
import com.PlatformLayer.WD;

public class PostBlog 
{
	/**
     * Logins to the WD Application. 
     */		
	public static void Post(WebDriver driver, HashMap<String,String> OR, HashMap<String,String> testData, String strTCID)
	{
		try
		{
			MouseHover.byXpath(driver,".//*[@id='wpbody-content']/div[3]/h1",".//*[@id='menu-posts']/a/div[3]");
			Click.byLinkText(driver,"Add New");
			WD.waitForPage(driver,"By.id","publish");
			WebElement element = null;
			element = WD.findObject(driver,"By.id","title");			
			element.clear();
			element.sendKeys(testData.get("TITLE") + Keys.TAB + testData.get("CONTENT"));
			WD.wait(5);
			Click.byId(driver, "publish");
			Click.byXpath(driver, ".//*[@id='message']/p/a");
			String strTemp;
			strTemp = ReadText.byXpath(driver,".//*[starts-with(@id,'post-')]");
			if(strTemp.contains(testData.get("TITLE")))
				Framework.write(Result.PASS, "Title found on Wordpress", true, strTCID, driver);
			else
				Framework.write(Result.FAIL, "Failed to find Title on Wordpress", true, strTCID, driver);
			testData.put("HEAD",".//*[@id='wp-admin-bar-my-account']/a");
			Framework.isBrowserOpen=true;
		}
		catch (Exception e)
		{
			Framework.isBrowserOpen=false;
			Framework.write(Result.ERROR, e.getMessage(), false, strTCID, driver);
		}		
	}
	
	/**
     * Logins to the WD Application. 
     */		
	@SuppressWarnings("unused")
	public static void DeletePost(WebDriver driver, HashMap<String,String> OR, HashMap<String,String> testData, String strTCID)
	{
		try
		{
			driver.findElement(By.xpath(".//*[@id='menu-posts']/a/div[3]")).click();
			driver.findElement(By.xpath(".//*[@id='menu-posts']/ul/li[2]/a")).click();
			WebElement webTable = driver.findElement(By.id("the-list"));
			
			driver.findElement(By.name("s")).sendKeys(testData.get("TITLE"));
			driver.findElement(By.id("search-submit")).click();
			
			int iRowCount = driver.findElements(By.xpath(".//*[@id='the-list']/tr")).size();
			int iColumnCount = driver.findElements(By.xpath(".//*[@id='the-list']/tr/td")).size();
			System.out.println("Row Count: " + iRowCount);
			System.out.println("Column Count: " + iColumnCount);
			
			for (int i=1; i<=iRowCount; i++){
				String strPostTitle = driver.findElement(By.xpath(".//*[@id='the-list']/tr[" + i + "]/td[1]/strong/a")).getText().toString();
				System.out.println(strPostTitle);
				Thread.sleep(10);
				WebElement element = driver.findElement(By.xpath(".//*[starts-with(@id,'cb-select')]"));
				element.click();
				break;
			}
			new Select(driver.findElement(By.id("bulk-action-selector-top"))).selectByVisibleText("Move to Trash");
			driver.findElement(By.id("doaction")).click();
			
			driver.findElement(By.partialLinkText("Trash")).click();// Go to Thrash
			
			driver.findElement(By.name("s")).sendKeys(testData.get("TITLE"));
			driver.findElement(By.id("search-submit")).click();
			
			for (int i=1; i<=iRowCount; i++){
				String strPostTitle = driver.findElement(By.xpath(".//*[@id='the-list']/tr[" + i + "]/td[1]/strong")).getText().toString();
				System.out.println(strPostTitle);
				Thread.sleep(10);
				WebElement element = driver.findElement(By.xpath(".//*[starts-with(@id,'cb-select')]"));
				element.click();
				break;
			}
			
			new Select(driver.findElement(By.id("bulk-action-selector-top"))).selectByVisibleText("Delete Permanently");
			driver.findElement(By.id("doaction")).click();
			
			testData.put("HEAD",".//*[@id='wp-admin-bar-my-account']/a");
			Framework.isBrowserOpen=true;
		}
		catch (Exception e)
		{
			Framework.isBrowserOpen=false;
			Framework.write(Result.ERROR, e.getMessage(), false, strTCID, driver);
		}		
	}	
}

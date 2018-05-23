package com.BusinessScript;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Handlecookie 
{
	public static void main(String args[]) 
	{
		// Initialize Firefox Webdriver      
		WebDriver driver = new FirefoxDriver();
		//Maximize browser window       
		driver.manage().window().maximize();
		//Go to desire wbesite      
		driver.get("http://www.google.com");
		//Set  timeout      
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//pass name and value for cookie as parameters
		Cookie name = new Cookie("firefoxcookie", "123456789123");
		// Add Cookie
		driver.manage().addCookie(name);
		// Get the Cookie with Specific Name     
		System.out.println(driver.manage().getCookieNamed("firefoxcookie"));
		System.out.println("=======================================");
		//Get all Cookies
		Set<Cookie> cookiesList1 = driver.manage().getCookies();
		for (Cookie getcookies : cookiesList1) 
		{
		    System.out.println(getcookies);
		}
		System.out.println("=======================================");
		// Delete Cookie with Name    
		driver.manage().deleteCookieNamed("firefoxcookie");
		System.out.println("=======================================");
		//Check deleted or not firefoxcookie Cookie 
		Set<Cookie> cookiesList2 = driver.manage().getCookies();
		for (Cookie getcookies : cookiesList2) 
		{
		    if (getcookies.getName().equals("firefoxcookie")) 
		    {
		    	System.out.println(driver.manage().getCookieNamed("firefoxcookie"));
		    } 
		    else 
		    {
		    	System.out.println("There is no cookies name firefoxcookie");
		    	break;
		    }
		}
		System.out.println("=======================================");
		//Delete all the cookies of the domain
		driver.manage().deleteAllCookies();
		// Check all the cookies deleted or not
		Set<Cookie> cookiesList3 = driver.manage().getCookies();
		if (cookiesList3.size() == 0) 
		{
		    System.out.println("There are no cookies");
		}
		//close firefox browser  
		driver.quit();
	}
}
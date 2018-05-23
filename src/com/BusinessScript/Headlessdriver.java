package com.BusinessScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
  
class Headlessdriver 
{
    String session (String url, String username, String password) 
    {
	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("phantomjs.binary.path", ".\\lib\\phantomjs.exe");
	    caps.setJavascriptEnabled(true);
	    String[] args = { "--ignore-ssl-errors=yes" };
	    caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, args);
	    WebDriver driver = new PhantomJSDriver(caps);
	    driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
	    driver.get(url);   
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys(username);
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.cssSelector("input.primary.btn")).click();
	    String sessionIdFull = driver.manage().getCookieNamed("sessionId").toString();
	    String SessionId = sessionIdFull.split("; ")[0];
	    driver.quit();
	    return SessionId;
    }
}
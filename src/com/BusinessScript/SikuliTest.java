package com.BusinessScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliTest {

	public static void main(String[] args) throws FindFailed {
		// TODO Auto-generated method stub
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();

		// And now use this to visit Google
		driver.get("http://www.google.com");

		//Create and initialize an instance of Screen object    
		Screen screen = new Screen();

		//Add image path  
		Pattern image = new Pattern(".\\lib\\GoogleSearch.png");
		    
		//Wait 10ms for image  
		screen.wait(image, 10);
		    
		//Click on the image
		screen.click(image);
	}
}

package com.ExecutionLayer;

//import java.io.IOException;
import java.util.HashMap;
import com.PlatformLayer.*;
import org.testng.annotations.*;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
/**
 *	This Class contains all the TestScript Class which will be executed. 
 *
 * @Author
 * @Date
 *
 */

public class TestSuiteRunner 
{
//	public static ExtentTest extentLogger = null;
//	public static ExtentReports extentReport = null;	
	/**
     * This method Configure the setup needed to run the Test Suite.
     * 
     * @return void
     * 
     */
	@BeforeSuite
	public static void SetUp()
	{
		Framework.config = new HashMap<String,String>();
		Framework.taskName = new HashMap<String,String>();
		Framework.tcName = new HashMap<String,String>();
		Framework.tcTaskId = new HashMap<String,String>();
		Framework.tcDesc = new HashMap<String,String>();
		Framework.tcTestData = new HashMap<String,String>();
		Framework.tcORData = new HashMap<String,String>();
		Framework.isBrowserOpen = false;
		Framework.strLastUserName = "FIRST";
		Framework.strHomeDirectory = System.getProperty("user.dir").replace("/bin", "");
		Framework.config.put("HOME-DIRECTORY", Framework.strHomeDirectory);	
		Framework.readConfig();
		/*try 
		{
			Runtime.getRuntime().exec(Framework.config.get("HOME-DIRECTORY") + "\\Utility\\StartGridHost.bat");
		} 
		catch (IOException e) 
		{
			Framework.logger.info(e.getMessage());
		}
		if(Framework.config.get("BROWSER").equalsIgnoreCase("ie"))
		{
			try 
			{
				Runtime.getRuntime().exec(Framework.config.get("HOME-DIRECTORY") + "\\Utility\\StartGridNodeIE.bat");
			} 
			catch (IOException e) 
			{
				Framework.logger.info(e.getMessage());
			}
		}
		else if(Framework.config.get("BROWSER").equalsIgnoreCase("firefox"))
		{
			try 
			{
				Runtime.getRuntime().exec(Framework.config.get("HOME-DIRECTORY") + "\\Utility\\StartGridNodeFirefox.bat");
			} 
			catch (IOException e) 
			{
				Framework.logger.info(e.getMessage());
			}	
		}
		else if(Framework.config.get("BROWSER").equalsIgnoreCase("chrome"))
		{
			try 
			{
				Runtime.getRuntime().exec(Framework.config.get("HOME-DIRECTORY") + "\\Utility\\StartGridNodeChrome.bat");
			} 
			catch (IOException e) 
			{
				Framework.logger.info(e.getMessage());
			}
		}*/
		Framework.doc = Framework.createResultXML();
		StopWatch.start();
		Framework.logger.info("Test Suite Execution Started...");
	}
	
	/**
     * This method create the HTML report file.
     * 
     * @return void
     * 
     */
	@AfterSuite
	public static void TearDown()
	{
		Framework.logger.info("Test Suite Execution Stoped...");
		StopWatch.stop();
		Framework.logger.info("Time Taken For Execution : " + StopWatch.getElapsedTimeSecs());
		Framework.xmlToHtml(Framework.doc,"Time Taken For Execution : " + StopWatch.getElapsedTimeSecs());
		String result = Framework.strHomeDirectory + "\\" + Framework.strHtmlResultFile;
		Framework.logger.info(result);
		Framework.sendMail(result);
		Framework.logger.info("Email sent...");
		Framework.logger.info("Result is : " + Framework.passcount);
	}
}
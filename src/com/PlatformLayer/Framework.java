package com.PlatformLayer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.junit.*;
//import com.ExecutionLayer.TestSuiteRunner;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.LogStatus;

/**
 *	This Class contains method to work with Result and Configuration. 
 *
 * @Author
 * @Date
 *
 */

public class Framework 
{
	//hashMap to store config, taskName, tcName, tcTaskId, tcDesc and tcTestData
	public static HashMap<String,String> 	config 			= null;
	public static HashMap<String,String> 	taskName 		= null;
	public static HashMap<String,String> 	tcName 			= null;
	public static HashMap<String,String> 	tcTaskId 		= null;
	public static HashMap<String,String> 	tcDesc 			= null;
	public static HashMap<String,String> 	tcTestData 		= null;
	public static HashMap<String,String> 	tcORData 		= null;
	public static Document 					doc 			= null;
	public static File 						file 			= null;
	public static String 					strResultFolder = null;
	public static boolean 					isBrowserOpen = false;
	public static String strHtmlResultFile = "";
	public static String strHomeDirectory = "";
	public static int passcount = 0;
	public static int failcount = 0;
	public static int errorcount = 0;
	public static String strLastUserName = "";
	public static Logger logger = Logger.getLogger("");
	private static FileHandler fileTxt;
	private static SimpleFormatter formatterTxt;	

	//To Read conFig File
	public static void readConfig()
	{
		try 
		{
			File file = new File("Config.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodeLst = null;
			Node fstNode = null;
			Element fstElmnt = null;		  
			
			logger.info("Started Reading Config File...");
			nodeLst = (NodeList) doc.getElementsByTagName("Config");
			nodeLst = nodeLst.item(0).getChildNodes();		  
			for (int s = 0; s < nodeLst.getLength(); s++) 
			{
				fstNode = nodeLst.item(s);		    
				if (fstNode.getNodeType() == Node.ELEMENT_NODE) 
				{		  
					fstElmnt = (Element) fstNode;
					config.put(fstElmnt.getNodeName(), fstElmnt.getTextContent().trim());
					logger.info(fstElmnt.getNodeName() + " " + fstElmnt.getTextContent().trim());
				}
			}
			nodeLst = (NodeList) doc.getElementsByTagName("Tasks");
			nodeLst = nodeLst.item(0).getChildNodes();		  
			for (int s = 0; s < nodeLst.getLength(); s++) 
			{
				fstNode = nodeLst.item(s);		    
				if (fstNode.getNodeType() == Node.ELEMENT_NODE) 
				{		  
					fstElmnt = (Element) fstNode;
					logger.info(fstElmnt.getAttribute("ID") + " " + fstElmnt.getAttribute("Active") + " " + fstElmnt.getTextContent().trim());
					config.put(fstElmnt.getAttribute("ID"), fstElmnt.getAttribute("Active"));
					taskName.put(fstElmnt.getAttribute("ID"), fstElmnt.getTextContent().trim());
				}
			}
			nodeLst = (NodeList) doc.getElementsByTagName("TestCases");
			nodeLst = nodeLst.item(0).getChildNodes();		  
			for (int s = 0; s < nodeLst.getLength(); s++) 
			{
				fstNode = nodeLst.item(s);		    
				if (fstNode.getNodeType() == Node.ELEMENT_NODE) 
				{		  
					fstElmnt = (Element) fstNode;	
					logger.info(fstElmnt.getAttribute("ID") + " " + fstElmnt.getAttribute("Active"));
					config.put(fstElmnt.getAttribute("ID"),fstElmnt.getAttribute("Active"));
					tcName.put(fstElmnt.getAttribute("ID"),fstElmnt.getAttribute("Name"));
					tcTaskId.put(fstElmnt.getAttribute("ID"),fstElmnt.getAttribute("TaskID"));
					tcDesc.put(fstElmnt.getAttribute("ID"),fstElmnt.getTextContent().trim());
					tcTestData.put(fstElmnt.getAttribute("ID"), fstElmnt.getAttribute("TestDataPath"));
					tcORData.put(fstElmnt.getAttribute("ID"), fstElmnt.getAttribute("ORPath"));					
				}
			}
			logger.info("Reading Config File Done...");
		} 
		catch (Exception e) 
		{
			logger.severe("Error while reading config file " + e.getMessage());
		}		
	}

	//To read Test Data and returns hashTable of test data
	public static HashMap<String,String> readTestData(String strTCID)
	{
		HashMap<String,String> 	testData = null;
		try 
		{
			String strTestDataPath = Framework.tcTestData.get(strTCID);
			File file = new File(strTestDataPath);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodeLst = null;
			Node fstNode = null;
			Element fstElmnt = null;
			testData = new HashMap<String,String>();
			logger.info("Started Reading Test Data File " + strTestDataPath.toString() + "...");
			nodeLst = (NodeList) doc.getElementsByTagName("TestData");
			nodeLst = nodeLst.item(0).getChildNodes();		  
			for (int s = 0; s < nodeLst.getLength(); s++) 
			{
				fstNode = nodeLst.item(s);		    
				if (fstNode.getNodeType() == Node.ELEMENT_NODE) 
				{		  
					fstElmnt = (Element) fstNode;	
					if("COMMON".equals(fstElmnt.getAttribute("TCID")) || fstElmnt.getAttribute("TCID").equals(strTCID))
					{
						testData.put(fstElmnt.getAttribute("Key"), fstElmnt.getTextContent().trim());
						logger.info(fstElmnt.getAttribute("Key") + " " + fstElmnt.getTextContent().trim());
					}
				}
			}
			logger.info("Reading Test Data File " + strTestDataPath.toString() + " Done...");
		} 
		catch (Exception e) 
		{
			logger.severe("Error while reading Test Data file " + e.getMessage());
		}
		return(testData);
	}
	
	//To read OR and returns hashTable of OR
	public static HashMap<String,String> readOR(String strTCID)
	{
		HashMap<String,String> 	OR = null;
		try 
		{
			String strTestDataPath = Framework.tcORData.get(strTCID);
			File file = new File(strTestDataPath);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			NodeList nodeLst = null;
			Node fstNode = null;
			Element fstElmnt = null;
			OR = new HashMap<String,String>();
			logger.info("Started Reading OR File " + strTestDataPath.toString() + "...");
			nodeLst = (NodeList) doc.getElementsByTagName("TestData");
			nodeLst = nodeLst.item(0).getChildNodes();		  
			for (int s = 0; s < nodeLst.getLength(); s++) 
			{
				fstNode = nodeLst.item(s);		    
				if (fstNode.getNodeType() == Node.ELEMENT_NODE) 
				{		  
					fstElmnt = (Element) fstNode;	
					if("COMMON".equals(fstElmnt.getAttribute("TCID")) || fstElmnt.getAttribute("TCID").equals(strTCID))
					{
						OR.put(fstElmnt.getAttribute("Key"), fstElmnt.getTextContent().trim());
						logger.info(fstElmnt.getAttribute("Key") + " " + fstElmnt.getTextContent().trim());
					}
				}
			}
			logger.info("Reading OR File " + strTestDataPath.toString() + " Done...");
		} 
		catch (Exception e) 
		{
			logger.severe("Error while reading OR file " + e.getMessage());
		}
		return(OR);
	}	

	//To capture Screen Shot
	public static void captureScreen(WebDriver driver, String fileName) 
	{	
		try
		{
		    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(scrFile, new File(fileName));
		    WD.wait(5);
		}
		catch(Exception e)
		{
			logger.severe("Error while capturing screen shot " + e.getMessage());
		}
	}

	//To create XML doc to keep result generated in script execution
	public static Document createResultXML()
	{
		try 
		{
			strResultFolder = "result\\Result-" + DateTime.now();
			File f = new File(strResultFolder);
			f.mkdir();
			file = new File(strResultFolder + "\\Result.xml");
//			TestSuiteRunner.extentReport = new ExtentReports(strResultFolder + "\\Result.html", true);
//			TestSuiteRunner.extentReport.loadConfig(new File(Framework.strHomeDirectory + "\\extent-config.xml"));
			DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = fact.newDocumentBuilder();
			Document doc = parser.newDocument();
			Node root = doc.createElement("Results");      
			doc.appendChild(root);
			
			try 
			{
				fileTxt = new FileHandler(Framework.strResultFolder + "\\Automation.log",1048576,50);
			} 
			catch (SecurityException e) 
			{
				logger.severe("Error in opening a log file " + e.getMessage());
			} 
			catch (IOException e) 
			{
				logger.severe("Error in opening a log file " + e.getMessage());
			}
			logger.setLevel(Level.INFO);
			formatterTxt = new SimpleFormatter();
			fileTxt.setFormatter(formatterTxt);
			logger.addHandler(fileTxt);
			
			return doc;
		} 
		catch(Exception e) 
		{
			logger.severe("Error while createResultXML " + e.getMessage());
			return null;
		}		
	}

	// To write result into xml file
	public static void write(String strStatus, String strDesc, boolean boolCaptureScreenShot, String strTCID, WebDriver driver) 
	{
		try 
		{
			String strFlow = Thread.currentThread().getStackTrace()[2].getMethodName();
			
			logger.info(strStatus + " " + strDesc);
			
			Node root = doc.getDocumentElement();
			Node TestCase = null;
			NodeList TestCases = null;

			TestCases = doc.getElementsByTagName(strTCID);      
			if(TestCases.getLength() > 0)
				TestCase = TestCases.item(0);
			else
			{
				File f = new File(strResultFolder + "\\" + strTCID);
				f.mkdir();	    	  
				TestCase = doc.createElement(strTCID);
				root.appendChild(TestCase);
			}

			Node TestStep = null;
			TestStep = doc.createElement("TestStep");
			NamedNodeMap nodeMap = TestStep.getAttributes();

			Attr attrDateTime = doc.createAttribute("DateTime");
			attrDateTime.setValue(DateTime.now());
			nodeMap.setNamedItem(attrDateTime);

			Attr attrImgLink = doc.createAttribute("ImgLink");

			//Capture Image and Store And Then Give Path
			String strImgPath = "";
			if(boolCaptureScreenShot)
			{
				strImgPath = strTCID + "\\Image-" + DateTime.now() + ".png";				
				captureScreen(driver, config.get("HOME-DIRECTORY") + "\\" + strResultFolder + "\\" + strImgPath); 
			}      
			attrImgLink.setValue(strImgPath);
			nodeMap.setNamedItem(attrImgLink);

			Attr attrFlow = doc.createAttribute("Flow");
			attrFlow.setValue(strFlow);
			nodeMap.setNamedItem(attrFlow);

			Attr attrFlag = doc.createAttribute("Status");
			if("pass".equalsIgnoreCase(strStatus))
				attrFlag.setValue("PASS");
			else if("fail".equalsIgnoreCase(strStatus))
				attrFlag.setValue("FAIL");
			else if("warning".equalsIgnoreCase(strStatus) || "warn".equalsIgnoreCase(strStatus))
				attrFlag.setValue("WARNING");
			else if("error".equalsIgnoreCase(strStatus))
				attrFlag.setValue("ERROR");      
			nodeMap.setNamedItem(attrFlag);

			Attr attrTestStepDesc = doc.createAttribute("TestStepDesc");
			attrTestStepDesc.setValue(strDesc.trim().toString());
			nodeMap.setNamedItem(attrTestStepDesc);    

			TestCase.appendChild(TestStep);

			// Prepare the DOM document for writing 
			Source source = new DOMSource(doc);
			Result result = new StreamResult(file); 
			// Write the DOM document to the file 
			Transformer xformer = TransformerFactory.newInstance().newTransformer(); 
			xformer.transform(source, result);	
			
			if("pass".equalsIgnoreCase(strStatus))
			{
				Assert.assertTrue(strDesc, true);
//				if(boolCaptureScreenShot)
//					TestSuiteRunner.extentLogger.log(LogStatus.PASS, strDesc, "<a href=\"" + strImgPath + "\">Image</a>");
//				else
//					TestSuiteRunner.extentLogger.log(LogStatus.PASS, strDesc);
			}
			else if("fail".equalsIgnoreCase(strStatus))
			{
				Assert.fail(strDesc);
//				if(boolCaptureScreenShot)
//					TestSuiteRunner.extentLogger.log(LogStatus.FAIL, strDesc, "<a href=\"" + strImgPath + "\">Image</a>");
//				else
//					TestSuiteRunner.extentLogger.log(LogStatus.FAIL, strDesc);
			}
			else if("warning".equalsIgnoreCase(strStatus) || "warn".equalsIgnoreCase(strStatus))
			{
				Assert.assertTrue(strDesc, true);
//				if(boolCaptureScreenShot)
//					TestSuiteRunner.extentLogger.log(LogStatus.PASS, strDesc, "<a href=\"" + strImgPath + "\">Image</a>");
//				else
//					TestSuiteRunner.extentLogger.log(LogStatus.PASS, strDesc);
			}
			else if("error".equalsIgnoreCase(strStatus))
			{
				Assert.fail(strDesc);
//				if(boolCaptureScreenShot)
//					TestSuiteRunner.extentLogger.log(LogStatus.ERROR, strDesc, "<a href=\"" + strImgPath + "\">Image</a>");
//				else
//					TestSuiteRunner.extentLogger.log(LogStatus.ERROR, strDesc);
			}
		} 
		catch(Exception e) 
		{
			logger.severe("Error while writing result " + e.getMessage());      
		}
	}

	//XML Result to HTML Result
	public static void xmlToHtml(Document doc, String strBenchmarkMsg)
	{
		try 
		{		  
			NodeList nodeLst = null;
			NodeList nodeChildLst = null;
			Node fstNode = null;
			Node scndNode = null;
			Element fstElmnt = null;
			Element scndElmnt = null;

			String strTCID = null;
			String strTCDesc = null;
			String strTestCaseResult = null;
			String strDateTime = null;
			String strRemarks = null;
			String strFlow = null;
			String strImgLink = null;

			nodeLst = (NodeList) doc.getElementsByTagName("Results");
			nodeLst = nodeLst.item(0).getChildNodes();
			int intMaxNodeLength = 0;
			intMaxNodeLength = nodeLst.getLength();
			//Iterate through Test Cases
			int intPassCount = 0;
			int intFailCount = 0;
			int intWarningCount = 0;
			int intErrorCount = 0;
			int intTotalCount = 0;		  
			for (int i = 0; i < intMaxNodeLength; i++) 
			{
				fstNode = nodeLst.item(i);		    
				if (fstNode.getNodeType() == Node.ELEMENT_NODE) 
				{		  
					fstElmnt = (Element) fstNode;
					strTCID = fstElmnt.getNodeName();
					strTCDesc = tcDesc.get(strTCID);
					nodeChildLst = fstNode.getChildNodes();
					//Iterate through test step
					int intTSPassCount = 0;
					int intTSFailCount = 0;
					int intTSWarningCount = 0;
					int intTSErrorCount = 0;
					//int intTSTotalCount = 0;
					strRemarks = "";
					strFlow = "";
					strImgLink = "";
					for (int j = 0; j < nodeChildLst.getLength(); j++)
					{
						scndNode = nodeChildLst.item(j);
						if(scndNode.getNodeType() == Node.ELEMENT_NODE)
						{
							scndElmnt = (Element) scndNode;
							if(j==0)
								strDateTime = scndElmnt.getAttribute("DateTime");
							if(j == nodeChildLst.getLength() - 1 )
							{
								strFlow = strFlow + scndElmnt.getAttribute("Flow");
								strRemarks = strRemarks + "<B><U><I> Check Point # </B></U></I>" + scndElmnt.getAttribute("TestStepDesc");
								strImgLink = strImgLink + scndElmnt.getAttribute("ImgLink");
							}
							else
							{
								strFlow = strFlow + scndElmnt.getAttribute("Flow") + " <br> ";
								strRemarks = strRemarks + "<B><U><I> Check Point # </B></U></I>" + scndElmnt.getAttribute("TestStepDesc") + " <br> ";
								strImgLink = strImgLink + scndElmnt.getAttribute("ImgLink") + " >> ";
							}		    		  
							if("PASS".equals(scndElmnt.getAttribute("Status").trim().toString()))
								intTSPassCount++;
							else if("FAIL".equals(scndElmnt.getAttribute("Status").trim().toString()))
								intTSFailCount++;
							else if("WARNING".equals(scndElmnt.getAttribute("Status").trim().toString()))
								intTSWarningCount++;
							else if("ERROR".equals(scndElmnt.getAttribute("Status").trim().toString()))
								intTSErrorCount++;
							//intTSTotalCount++;
						}
					}
					if(intTSFailCount == 0 && intTSErrorCount == 0 && intTSPassCount != 0)
					{
						if(intTSWarningCount == 0)
						{
							strTestCaseResult = "PASS";		    		  
							intPassCount++;
						}
						else
						{
							strTestCaseResult = "PASS with Warning(s)";
							intWarningCount++;
						}
					}
					else if(intTSFailCount != 0 || intTSErrorCount != 0)
					{
						if(intTSErrorCount == 0)
						{
							strTestCaseResult = "FAIL";
							intFailCount++;
						}
						else
						{
							strTestCaseResult = "ERROR";
							intErrorCount++;
						}
					}
					intTotalCount++;

					logger.info(strTCID + "\t" + strTCDesc + "\t" + strTestCaseResult + "\t" + strDateTime + "\t" + strRemarks + "\t" + strFlow + "\t" + strImgLink);

					Node root = doc.getDocumentElement();

					Node TestCaseResult = null;
					TestCaseResult = doc.createElement("TestCaseResult");
					NamedNodeMap nodeMap = TestCaseResult.getAttributes();

					Attr attrRemarks = doc.createAttribute("Remarks");
					attrRemarks.setValue(strRemarks);
					nodeMap.setNamedItem(attrRemarks);		      

					Attr attrDateTime = doc.createAttribute("StatusDate");
					attrDateTime.setValue(strDateTime);
					nodeMap.setNamedItem(attrDateTime);

					Attr attrImgLink = doc.createAttribute("ImgLink");
					attrImgLink.setValue(strImgLink);
					nodeMap.setNamedItem(attrImgLink);

					Attr attrFlow = doc.createAttribute("Flow");
					attrFlow.setValue(strFlow);
					nodeMap.setNamedItem(attrFlow);

					Attr attrStatus = doc.createAttribute("Status");		     
					attrStatus.setValue(strTestCaseResult);      
					nodeMap.setNamedItem(attrStatus);

					Attr attrTCID = doc.createAttribute("TCID");		     
					attrTCID.setValue(strTCID);      
					nodeMap.setNamedItem(attrTCID);

					TestCaseResult.appendChild(doc.createTextNode(strTCDesc));
					root.appendChild(TestCaseResult);

					nodeMap = root.getAttributes();	      
					Attr attrBuild = doc.createAttribute("Build");
					attrBuild.setValue(config.get("REPORT-HEADING"));
					nodeMap.setNamedItem(attrBuild);

					nodeMap = root.getAttributes();	      
					Attr attrTotalTC = doc.createAttribute("Total");
					attrTotalTC.setValue(Integer.toString(intTotalCount));
					nodeMap.setNamedItem(attrTotalTC);

					nodeMap = root.getAttributes();	      
					Attr attrPassWithWarnings = doc.createAttribute("PassWithWarnings");
					attrPassWithWarnings.setValue(Integer.toString(intWarningCount));
					nodeMap.setNamedItem(attrPassWithWarnings);

					nodeMap = root.getAttributes();	      
					Attr attrPass = doc.createAttribute("Pass");
					attrPass.setValue(Integer.toString(intPassCount));
					nodeMap.setNamedItem(attrPass);

					nodeMap = root.getAttributes();	      
					Attr attrFail = doc.createAttribute("Fail");
					attrFail.setValue(Integer.toString(intFailCount));
					nodeMap.setNamedItem(attrFail);

					nodeMap = root.getAttributes();	      
					Attr attrError = doc.createAttribute("Error");
					attrError.setValue(Integer.toString(intErrorCount));
					nodeMap.setNamedItem(attrError);
					
					nodeMap = root.getAttributes();	      
					Attr attrBenchmarkMessage = doc.createAttribute("BenchmarkMessage");
					attrBenchmarkMessage.setValue(strBenchmarkMsg);
					nodeMap.setNamedItem(attrBenchmarkMessage);					
				}
			}	

			// Prepare the DOM document for writing
			Source source = new DOMSource(doc);
			Result result = new StreamResult(file); 
			// Write the DOM document to the file 
			Transformer xformer = TransformerFactory.newInstance().newTransformer(); 
			xformer.transform(source, result);		  

			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer(new javax.xml.transform.stream.StreamSource("lib\\tmp.xsl"));
			strHtmlResultFile =strResultFolder + "\\" + "Result-" + DateTime.now() + ".html";
			transformer.transform(new javax.xml.transform.stream.StreamSource(strResultFolder + "\\Result.xml"),new javax.xml.transform.stream.StreamResult(new FileOutputStream(strHtmlResultFile)));
			//logger.info("Total Pass count ::"+ intPassCount);
			//logger.info("Total Pass count ::"+ intPassCount);
			//logger.info("Total Pass count ::"+ intPassCount);
			passcount = intPassCount;
			failcount= intFailCount;
			errorcount = intErrorCount;
		} 
		catch (Exception e) 
		{
			logger.severe("Error while converting xmlToHtml " + e.getMessage());
		} 
	}

	// To convert XLS to XML
	@SuppressWarnings("resource")
	public static void xlsToXml(String strXlsPath, String strXmlPath)
    {
	  logger.info("Started conversion from xls to xml...");
      Connection con = null;
      Statement stmnt = null;
      ResultSet rs = null;
      String filename = strXlsPath;
      try
      {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");              
            con = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};DBQ=" + filename + "; readOnly= false");
            
            DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
            DocumentBuilder parser = fact.newDocumentBuilder();
            Document doc = parser.newDocument();
            Node root = doc.createElement("Automation");     
            doc.appendChild(root);
                  
            Node config = doc.createElement("Config");
            root.appendChild(config);
            Node tasks = doc.createElement("Tasks");
            root.appendChild(tasks);
            Node testcases = doc.createElement("TestCases");
            root.appendChild(testcases);                    
            
            stmnt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query = "Select * from [Config$]" ;
            rs = stmnt.executeQuery( query ); 
            rs.first();
            logger.info("Config...");
            while(!rs.isAfterLast())
            { 
                  String strKey = rs.getString("Key");
                  String strValue = rs.getString("Value");
                  logger.info(rs.getInt("No") + "\t" + strKey + "\t" + strValue);
                  Node temp = doc.createElement(strKey.trim());
                  temp.appendChild(doc.createTextNode(strValue.trim()));
                  config.appendChild(temp);
                  rs.next();
            }              
            query = "Select * from [Tasks$]" ;
            rs = stmnt.executeQuery( query ); 
            rs.first();
            logger.info("Tasks...");
            while(!rs.isAfterLast())
            {  
                  String strTaskID = rs.getString("TaskID");
                  String strDescription = rs.getString("Description");
                  logger.info(rs.getInt("No") + "\t" + strTaskID + "\t" + strDescription);
                  Node temp = doc.createElement("Task");
                  NamedNodeMap nodeMap = temp.getAttributes();
                  Attr attrID = doc.createAttribute("ID");
                  attrID.setValue(strTaskID.trim());
                  nodeMap.setNamedItem(attrID);
                  temp.appendChild(doc.createTextNode(strDescription.trim()));
                  tasks.appendChild(temp);                    
                  rs.next();
            }
            query = "Select * from [TestCases$]" ;
            rs = stmnt.executeQuery( query ); 
            rs.first();
            logger.info("TestCases...");
            while(!rs.isAfterLast())
            {
                  String strTestCaseID = rs.getString("ID");
                  String strTaskID = rs.getString("TaskID");
                  String strName = rs.getString("Name");
                  String strDescription = rs.getString("Description");
                  String strTestDataPath = rs.getString("TestDataPath");
                  String strActive = rs.getString("Active");
                  logger.info(rs.getInt("No") + "\t" + strTestCaseID + "\t" + strTaskID + "\t" + strName + "\t" + strDescription + "\t" + strTestDataPath + "\t" + strActive);
                  Node temp = doc.createElement("TestCase");
                  NamedNodeMap nodeMap = temp.getAttributes();
                      
                  Attr attrTestCaseID = doc.createAttribute("ID");
                  attrTestCaseID.setValue(strTestCaseID.trim());
                  nodeMap.setNamedItem(attrTestCaseID);
                      
                  Attr attrTaskID = doc.createAttribute("TaskID");
                  attrTaskID.setValue(strTaskID.trim());
                  nodeMap.setNamedItem(attrTaskID);

                  Attr attrName = doc.createAttribute("Name");
                  attrName.setValue(strName.trim());
                  nodeMap.setNamedItem(attrName);
                      
                  Attr attrTestDataPath = doc.createAttribute("TestDataPath");
                  attrTestDataPath.setValue(strTestDataPath.trim());
                  nodeMap.setNamedItem(attrTestDataPath);
                      
                  Attr attrActive = doc.createAttribute("Active");
                  attrActive.setValue(strActive.trim());
                  nodeMap.setNamedItem(attrActive);
                      
                  temp.appendChild(doc.createTextNode(strDescription.trim()));
                  testcases.appendChild(temp);                     
                  rs.next();
            }
            File file = new File(strXmlPath);
            // Prepare the DOM document for writing 
            Source source = new DOMSource(doc);
            Result result = new StreamResult(file); 
            // Write the DOM document to the file 
            Transformer xformer = TransformerFactory.newInstance().newTransformer(); 
            xformer.transform(source, result); 
            logger.info("xls to xml conversion done...");
      }     
      catch(SQLException sqle)
      {
    	  logger.severe(sqle.getMessage());
      }
      catch(Exception e)
      {
    	  logger.severe(e.toString());
      }
      finally
      {
          try
          {
              rs.close();
              stmnt.close();
              con.close();
          }
          catch(Exception e)
          {
        	  logger.severe(e.getMessage());
          }
      }         
    }	
	
	public static void sendMail(String result) 
	{		
		String resultFilePath = result; 
		String msg =getHTMLString(resultFilePath);
		List<String> recipientsList = new ArrayList<String>();
		File file = new File("Config.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		Document doc = null;
		try 
		{
			db = dbf.newDocumentBuilder();
		} 
		catch (ParserConfigurationException e) 
		{
			e.printStackTrace();
		}
		try 
		{
			doc = db.parse(file);
		} 
		catch (SAXException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		NodeList nodeLst = null;
		nodeLst = (NodeList) doc.getElementsByTagName("Email");
		for (int s = 0; s < nodeLst.getLength(); s++) 
		{
			Node firstEmailIdNode = nodeLst.item(s);			
			if (firstEmailIdNode.getNodeType() == Node.ELEMENT_NODE) 
			{
				Element firstPersonElement = (Element) firstEmailIdNode;
				NodeList emailIDList = firstPersonElement.getElementsByTagName("email-id");
				for (int i = 0; i < emailIDList.getLength(); i++) 
				{
					Element firstNameElement = (Element) emailIDList.item(i);
					String recp = firstNameElement.getTextContent();
					recipientsList.add(recp);
				}
			}
		}
		try 
		{
			postMail(recipientsList, "Private Netbank Automation Results", msg, "sachin.nerpagare@nordea.com");
		} 
		catch (MessagingException e) 
		{
			logger.severe(e.getMessage());
		}
	}

	public static String getHTMLString(String resultFilePath)
	{
		String htmlStr = new String();
		try 
		{
			byte[] someBytesRead = new byte[999999];
            @SuppressWarnings("resource")
			FileInputStream fileInputStream =  new FileInputStream(resultFilePath);
            fileInputStream.read(someBytesRead);
            htmlStr = new String(someBytesRead);
            logger.info("read : " + new String(someBytesRead));
		} 
		catch (FileNotFoundException e) 
		{
			logger.severe(e.getMessage());
		} 
		catch (IOException e) 
		{
			logger.severe(e.getMessage());
		}
		return htmlStr;
	}

	public static void postMail(List<String> recipientsList, String subject, String message, String from) throws MessagingException 
	{
		boolean debug = false;
		
		// Set the host smtp address
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.nordea.com");

		// create some properties and get the default Session
		Session session = Session.getDefaultInstance(props, null);
		session.setDebug(debug);

		// create a message
		Message msg = new MimeMessage(session);

		// set the from and to address
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);

		InternetAddress[] addressTo = new InternetAddress[recipientsList.size()];
		int i = 0;
		for (String recp : recipientsList) 
		{
			addressTo[i] = new InternetAddress(recp);
			i++;
		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);

		// Optional : You can also set your custom headers in the Email if you
		// Want
		msg.addHeader("MyHeaderName", "myHeaderValue");

		// Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(message, "text/html");
		Transport.send(msg);
	}	
}
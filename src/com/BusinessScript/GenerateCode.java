package com.BusinessScript;

import com.PlatformLayer.CsvReader;

public class GenerateCode 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
	  System.out.println("Started conversion from csv to code...");
      String filename = "InputScript.csv";
      try
      {
			CsvReader testSteps = new CsvReader(filename);
			testSteps.setDelimiter(';');
			testSteps.readHeaders();
			String strResult = "";
			while (testSteps.readRecord())
			{
                String strStep = testSteps.get("Step");
                String strAction = testSteps.get("Action");
                String strBy = testSteps.get("By");
                String strProperty = testSteps.get("Property");
                String strValue = testSteps.get("Value");
                String strReturn = testSteps.get("Return");
                
                if("0".equals(strStep) && "FunctionName".equalsIgnoreCase(strAction))
                {
                	strResult = "\t/**\n\t* "+strValue+"\n\t*/\n\tpublic static void "+strProperty+"()\n\t{\n";
                }
                
                if("Click".equalsIgnoreCase(strAction))
                {
                	if("ID".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tClick.byId(\""+strProperty+"\");\n";
                	}
                	else if("Name".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tClick.byName(\""+strProperty+"\");\n";
                	}
                	else if("LinkText".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tClick.byLinkText(\""+strProperty+"\");\n";
                	}
                	else if("XPath".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tClick.byXpath(\""+strProperty+"\");\n";
                	}                	
                }
                
                if("GetAttribute".equalsIgnoreCase(strAction))
                {
                	if("ID".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\t"+strReturn+" = GetAttribute.byId(\""+strProperty+"\",\""+strValue+"\");\n";
                	}
                	else if("Name".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\t"+strReturn+" = GetAttribute.byName(\""+strProperty+"\",\""+strValue+"\");\n";
                	}
                	else if("LinkText".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\t"+strReturn+" = GetAttribute.byLinkText(\""+strProperty+"\",\""+strValue+"\");\n";
                	}
                	else if("XPath".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\t"+strReturn+" = GetAttribute.byXpath(\""+strProperty+"\",\""+strValue+"\");\n";
                	}                	
                }                 
                
                if("InputText".equalsIgnoreCase(strAction))
                {
                	if("ID".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tInputText.byId(\""+strProperty+"\",\""+strValue+"\");\n";
                	}
                	else if("Name".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tInputText.byName(\""+strProperty+"\",\""+strValue+"\");\n";
                	}
                	else if("LinkText".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tInputText.byLinkText(\""+strProperty+"\",\""+strValue+"\");\n";
                	}
                	else if("XPath".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tInputText.byXpath(\""+strProperty+"\",\""+strValue+"\");\n";
                	}                	
                } 
                
                if("IsObjectPresent".equalsIgnoreCase(strAction))
                {
                	if("ID".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\t" + strReturn + " = IsObjectPresent.byId(\""+strProperty+"\","+strValue+");\n";
                	}
                	else if("Name".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\t" + strReturn + " = IsObjectPresent.byName(\""+strProperty+"\","+strValue+");\n";
                	}
                	else if("LinkText".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\t" + strReturn + " = IsObjectPresent.byLinkText(\""+strProperty+"\","+strValue+");\n";
                	}
                	else if("XPath".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\t" + strReturn + " = IsObjectPresent.byXpath(\""+strProperty+"\","+strValue+");\n";
                	}                	
                }
                
                if("ReadText".equalsIgnoreCase(strAction))
                {
                	if("ID".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\t" + strReturn + " = ReadText.byId(\""+strProperty+"\");\n";
                	}
                	else if("Name".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\t" + strReturn + " = ReadText.byName(\""+strProperty+"\");\n";
                	}
                	else if("LinkText".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\t" + strReturn + " = ReadText.byLinkText(\""+strProperty+"\");\n";
                	}
                	else if("XPath".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\t" + strReturn + " = ReadText.byXpath(\""+strProperty+"\");\n";
                	}                	
                } 
                
                if("SelectCheckBox".equalsIgnoreCase(strAction))
                {
                	if("ID".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tSelectCheckBox.byId(\""+strProperty+"\");\n";
                	}
                	else if("Name".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tSelectCheckBox.byName(\""+strProperty+"\");\n";
                	}
                	else if("LinkText".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tSelectCheckBox.byLinkText(\""+strProperty+"\");\n";
                	}
                	else if("XPath".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tSelectCheckBox.byXpath(\""+strProperty+"\");\n";
                	}                	
                }    
                
                if("SelectDropDown".equalsIgnoreCase(strAction))
                {
                	if("ID".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tSelectDropDown.byId(\""+strProperty+"\",\""+strValue+"\");\n";
                	}
                	else if("Name".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tSelectDropDown.byName(\""+strProperty+"\",\""+strValue+"\");\n";
                	}
                	else if("XPath".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tSelectDropDown.byXpath(\""+strProperty+"\",\""+strValue+"\");\n";
                	}                	
                }
                
                if("SelectRadioButton".equalsIgnoreCase(strAction))
                {
                	if("ID".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tSelectRadioButton.byId(\""+strProperty+"\");\n";
                	}
                	else if("Name".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tSelectRadioButton.byName(\""+strProperty+"\");\n";
                	}
                	else if("LinkText".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tSelectRadioButton.byLinkText(\""+strProperty+"\");\n";
                	}                	
                	else if("XPath".equalsIgnoreCase(strBy))
                	{
                		strResult = strResult + "\t\tSelectRadioButton.byXpath(\""+strProperty+"\");\n";
                	}                	
                }                
                
                if("Comment".equalsIgnoreCase(strAction))
                {
                	strResult = strResult + "\t\t// "+strValue+"\n";
                }  
                
                if("CreateVariable".equalsIgnoreCase(strAction))
                {
                	strResult = strResult + "\t\t"+strBy+" "+strValue+";\n";
                }   
                
                if("If".equalsIgnoreCase(strAction))
                {
                	strResult = strResult + "\t\tif("+strProperty+")\n";
                } 
                
                if("Else".equalsIgnoreCase(strAction))
                {
                	strResult = strResult + "\t\telse\n";
                } 
                
                if("ElseIf".equalsIgnoreCase(strAction))
                {
                	strResult = strResult + "\t\telse if("+strProperty+")\n";
                } 
                
                if("{".equalsIgnoreCase(strAction))
                {
                	strResult = strResult + "\t\t{\n";
                } 
                
                if("}".equalsIgnoreCase(strAction))
                {
                	strResult = strResult + "\t\t}\n";
                }                 
                
                if("Result".equalsIgnoreCase(strAction))
                {
                	strResult = strResult + "\t\tFramework.write(Result."+strBy+", \""+strProperty+"\", "+strValue+");\n";
                }     
                
                if("CheckPointXPathAndText".equalsIgnoreCase(strAction))
                {
                	strResult = strResult + "\t\tWD.checkPointXPathAndText(\""+strProperty+"\", \""+strValue+"\", \""+strReturn+"\");\n";
                } 
                
                if("CheckPointXPathAndTextW".equalsIgnoreCase(strAction))
                {
                	strResult = strResult + "\t\tWD.checkPointXPathAndTextW(\""+strProperty+"\", \""+strValue+"\", \""+strReturn+"\");\n";
                }
                
                if("CheckPointXPathAndTextG".equalsIgnoreCase(strAction))
                {
                	strResult = strResult + "\t\tWD.checkPointXPathAndTextG(\""+strProperty+"\", \""+strValue+"\", \""+strReturn+"\");\n";
                } 
                
                if("CheckPointXPathAndTextGW".equalsIgnoreCase(strAction))
                {
                	strResult = strResult + "\t\tWD.checkPointXPathAndTextGW(\""+strProperty+"\", \""+strValue+"\", \""+strReturn+"\");\n";
                }
                
                if("CheckPointXPathAndObj".equalsIgnoreCase(strAction))
                {
                	strResult = strResult + "\t\tWD.checkPointXPathAndObj(\""+strProperty+"\", \""+strValue+"\", \""+strReturn+"\");\n";
                } 
                
                if("CheckPointXPathAndObjW".equalsIgnoreCase(strAction))
                {
                	strResult = strResult + "\t\tWD.checkPointXPathAndObjW(\""+strProperty+"\", \""+strValue+"\", \""+strReturn+"\");\n";
                }                
                
                if("Wait".equalsIgnoreCase(strAction))
                {
                	strResult = strResult + "\t\tWD.wait("+strValue+");\n";
                }
                
                if("WaitForPageLoad".equalsIgnoreCase(strAction))
                {
                	strResult = strResult + "\t\tWD.waitForPage("+strValue+");\n";
                }                
			}		
			testSteps.close();
			strResult = strResult + "\t}\n";
            System.out.println("csv to code conversion done...");
            System.out.println("Generated code : ");
            System.out.print(strResult);
      }     
      catch(Exception sqle)
      {
    	  System.out.println(sqle.getMessage());
      }
	}
}

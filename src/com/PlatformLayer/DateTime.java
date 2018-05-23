package com.PlatformLayer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *	This Class contains method related to Date & Time. 
 *
 * @Author
 * @Date
 *
 */
public class DateTime 
{
	/**
     * This method gives Today's Date in dd.mm.yyyy format.
     * 
     * @return date
     */
	public static String getTodaysDate() 
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		return sdf.format(cal.getTime());
	}
	/**
     * This method gives Tomorrow's Date in dd.mm.yyyy format.
     * 
     * @return date
     */
	public static String getTomorrowsDate() 
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		cal.add(Calendar.DAY_OF_YEAR, 1);
		return sdf.format(cal.getTime());
	}	
	/**
     * This method gives Yesterday's Date in dd.mm.yyyy format.
     * 
     * @return date
     */
	public static String getYesterdaysDate() 
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		cal.add(Calendar.DAY_OF_YEAR, -1);
		return sdf.format(cal.getTime());
	}	
	/**
     * This method gives Next Five Years Date in dd.mm.yyyy format.
     * 
     * @return date
     */
	public static String getNextFiveYearsDate() 
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("c");
		cal.add(Calendar.DAY_OF_YEAR, 1);
		cal.add(Calendar.YEAR, 5);
		return sdf.format(cal.getTime());
	}
	/**
     * This method gives current Date & Time in dd/mm/yyyy HH:mm:ss formate.
     * 
     * @return date
     */
	public static String getDateTime() 
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}		 
	/**
	 * This method gives current Date & Time in yyyy-MM-dd-HH-mm-ss formate.
	 * 
	 * @return date
	 */
	public static String now() 
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		return sdf.format(cal.getTime());
	}
	/**
     * This method gives next Business Date in dd.MM.yyyy format.
     * 
     * @return date
     */
	@SuppressWarnings("static-access")
	public static String getNextBusinessDay()
	{
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat ("dd.MM.yyyy");
		cal.add(Calendar.DAY_OF_YEAR, 1);
		
		while ((cal.get(cal.DAY_OF_WEEK)==7) || (cal.get(cal.DAY_OF_WEEK)==1))
			cal.add(Calendar.DAY_OF_YEAR, 1);
		
		return sdf.format(cal.getTime());
	}	
}

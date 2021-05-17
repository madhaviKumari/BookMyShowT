package co.move.in.test.BookMyShow.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import co.move.in.test.BookMyShow.exceptions.UnSupportedDateFormatException;

public class DateConverterHelper {
	private static String[] suppertedDateFormates = {"dd-MMM-yyyy HH:mm:ss","E, MMM dd yyyy HH:mm:ss"};
	public static Date fromString(String str) throws UnSupportedDateFormatException{
		for(String format:suppertedDateFormates) {
			try {
				SimpleDateFormat formatter=new SimpleDateFormat(format); 
				Date date = formatter.parse(str);
				return date;
			}catch(Exception e) {}
			
		}
		throw new UnSupportedDateFormatException("Date formate is not supported");
	}

}

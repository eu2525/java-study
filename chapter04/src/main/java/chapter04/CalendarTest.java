package chapter04;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest {

	public static void main(String[] args) {
//		Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
//		TimeZone tz = TimeZone.getDefault();
//		System.out.println(aLocale + ":" + tz);
		
		Calendar cal = Calendar.getInstance();
		printDate(cal);
		
		cal.set(Calendar.YEAR, 2024);
		cal.set(Calendar.MONTH, 11); // 12월 - 1		
		cal.set(Calendar.DATE, 25); 
		printDate(cal);
		
		cal.set(1999, 11, 26);
		cal.add(Calendar.DATE, 9100);
		printDate(cal);
		
	}

	private static void printDate(Calendar cal) {
		final String[] DAYS = {"SUN", "MON", "TUE", "WED", "THU" , "FRI", "SAT"};
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); // 0 ~ 11, + 1을 해줘야 함.
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); // 1(일) ~ 7(토)
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println(
				year + "-" + 
				(month + 1) + "-" + 
				date + " " + 
				DAYS[day - 1] + " " +
				hour + ":" +
				minute + ":" + 
				second 
		);
		
		
		
		
	}

}

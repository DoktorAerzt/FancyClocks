package de.empty2k12.fancyclocks.common.util;

import java.util.Calendar;
import java.util.TimeZone;

public class TimeUtil {

	public static TimeUtil instance;

	private static Calendar calendar;

	public TimeUtil() {
		instance = this;
		calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"));
	}

	public static int getRotationFromSeconds() {
		return calendar == null ? 0 : calendar.get(Calendar.SECOND)*6;
	}

	public static int getRotationFromMinutes() {
		return calendar == null ? 0 : calendar.get(Calendar.MINUTE)*6;
	}

	public static int getRotationFromHours() {
		return calendar == null ? 0 : (calendar.get(Calendar.HOUR_OF_DAY)*30 + calendar.get(Calendar.MINUTE)/6);
	}

}

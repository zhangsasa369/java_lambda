package com.taimei;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 
 * @author sasa.zhang
 *
 */
public class QutoTaskTrackUtil {
	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 获得时间区间内所有月末
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException
	 */
	public static List<String> getMonthBetween(String minDate, String maxDate) {
		ArrayList<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月
		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();
		try {
			min.setTime(sdf.parse(minDate));
			min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
			max.setTime(sdf.parse(maxDate));
			max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
			Calendar curr = min;
			while (curr.before(max)) {
				result.add(getMaxMonthDate(sdf.format(curr.getTime()) + "-01"));
				curr.add(Calendar.MONTH, 1);
			}
			return result;
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 获取时间区间内所有的中旬以及月末
	 * @param minDate
	 * @param maxDate
	 * @return
	 * @throws ParseException 
	 */
	public static List<String> getHalfWeekBetween(String minDate, String maxDate) {
		ArrayList<String> result = new ArrayList<String>();
		List<String> allMonthEnd;
		try {
			allMonthEnd = getMonthBetween(minDate, maxDate);
			for (int i = 0; i < allMonthEnd.size(); i++) {
				if (i == 0) {
					String[] currenMonthEnd = minDate.split("-");
					Integer day = Integer.valueOf(currenMonthEnd[2]);
					if (day >= 15) {
						result.add(allMonthEnd.get(i));
					} else {
						currenMonthEnd[2] = "15";
						result.add(org.apache.commons.lang3.StringUtils.join(currenMonthEnd, "-"));
						result.add(allMonthEnd.get(i));
					}
				} else if (i == allMonthEnd.size() - 1) {
					String[] currenMonthEnd = maxDate.split("-");
					Integer day = Integer.valueOf(currenMonthEnd[2]);
					currenMonthEnd[2] = "15";
					result.add(org.apache.commons.lang3.StringUtils.join(currenMonthEnd, "-"));
					if (day >= 15) {
						result.add(allMonthEnd.get(i));
					}
				} else {
					String[] currenMonthEnd = allMonthEnd.get(i).split("-");
					currenMonthEnd[2] = "15";
					result.add(org.apache.commons.lang3.StringUtils.join(currenMonthEnd, "-"));
					result.add(allMonthEnd.get(i));
				}

			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取时间区间内所有的周日
	 * @param minDate
	 * @param maxDate
	 * @return
	 */
	public static List<String> getWeekBetween(String minDate, String maxDate) {
		ArrayList<String> result = new ArrayList<String>();
		LocalDate minLocalDate = LocalDate.parse(minDate);
		LocalDate maxLocalDate = LocalDate.parse(maxDate);
		while (true) {
			LocalDate nextSunday = minLocalDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
			if (nextSunday.isBefore(maxLocalDate)) {
				result.add(nextSunday.toString());
				minLocalDate = nextSunday;
			} else {
				break;
			}
		}
		return result;
	}

	/**
	* 获取月份最后日期
	* @param date
	* @return
	* @throws ParseException
	*/
	private static String getMaxMonthDate(String date) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateFormat.parse(date));
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return dateFormat.format(calendar.getTime());
	}

}

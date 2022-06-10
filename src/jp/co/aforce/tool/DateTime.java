package jp.co.aforce.tool;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

	public String datetime() {
		LocalDateTime nowDate = LocalDateTime.now();
		System.out.println(nowDate);

		DateTimeFormatter dtf =
				DateTimeFormatter.ofPattern("yyyyMMddHHmm");
		String formatNowDate = dtf.format(nowDate);
		System.out.println(formatNowDate);
		return formatNowDate;

	}

}

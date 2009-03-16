package kr.pe.okjsp.util;

import java.util.Locale;

import junit.framework.TestCase;
import kr.pe.okjsp.util.DurationFromNow;

public class DurationFromNowTest extends TestCase {
	public void testDiff() {
		DurationFromNow.setLocale(Locale.KOREAN);
		String now = "20070717120303";
		assertEquals(DurationFromNow.getString("DateLabel.lessthan5seconds"),
				DurationFromNow.getTimeDiffLabel(now, now));
		assertEquals("50\uCD08\uC804", DurationFromNow.getTimeDiffLabel("20070717120213", now));
		assertEquals("1\uBD84\uC804", DurationFromNow.getTimeDiffLabel("20070717120203", now));
		assertEquals("1\uBD84\uC804", DurationFromNow.getTimeDiffLabel("20070717120133", now));
		assertEquals("59\uBD84\uC804", DurationFromNow.getTimeDiffLabel("20070717110304", now));
		assertEquals("1\uC2DC\uAC04\uC804", DurationFromNow.getTimeDiffLabel("20070717110303", now));
		assertEquals("\uC5B4\uC81C", DurationFromNow.getTimeDiffLabel("20070716120303", now));
		assertEquals("\uADF8\uC800\uAED8", DurationFromNow.getTimeDiffLabel("20070715120303", now));
		assertEquals("3\uC77C\uC804", DurationFromNow.getTimeDiffLabel("20070714120303", now));
		assertEquals("\uD55C\uB2EC\uC804", DurationFromNow.getTimeDiffLabel("20070617120303", now));
	}
	public void testMonthBug() {
		DurationFromNow.setLocale(Locale.KOREAN);
		String now = "20070824035303";
		assertEquals("\uD55C\uB2EC\uC804", DurationFromNow.getTimeDiffLabel("20070723231503", now));
	}
	public void test0DayBug() {
		DurationFromNow.setLocale(Locale.KOREAN);
		String now = "20081011005203";//08-09-11 18:51 08-10-11 05:25
		assertEquals("29\uC77C\uC804", 
				DurationFromNow.getTimeDiffLabel("20080911185103", now));
	}
	public void testSpace() {
		DurationFromNow.setLocale(Locale.ENGLISH);
		String now = "20070812092303";
		assertEquals("2 days ago", DurationFromNow.getTimeDiffLabel("20070810092303", now));
		assertEquals("3 days ago", DurationFromNow.getTimeDiffLabel("20070809092303", now));
		assertEquals("10 days ago", DurationFromNow.getTimeDiffLabel("20070802092303", now));
		assertEquals("11 days ago", DurationFromNow.getTimeDiffLabel("20070801092303", now));
		assertEquals("12 days ago", DurationFromNow.getTimeDiffLabel("20070731092303", now));
		assertEquals("13 days ago", DurationFromNow.getTimeDiffLabel("20070730092303", now));
		assertEquals("23 days ago", DurationFromNow.getTimeDiffLabel("20070720092303", now));
		assertEquals("29 days ago", DurationFromNow.getTimeDiffLabel("20070714092303", now));
	}
	public void testLocale() {
		String now = "20070717120303";
		DurationFromNow.setLocale(Locale.ENGLISH);
		assertEquals(DurationFromNow.getString("DateLabel.lessthan5seconds"),
				DurationFromNow.getTimeDiffLabel(now, now));
		DurationFromNow.setLocale(Locale.KOREAN);
		assertEquals(DurationFromNow.getString("DateLabel.lessthan5seconds"),
				DurationFromNow.getTimeDiffLabel(now, now));
		assertEquals("\uC9C0\uAE08\uB9C9",
				DurationFromNow.getTimeDiffLabel(now, now));
	}


}

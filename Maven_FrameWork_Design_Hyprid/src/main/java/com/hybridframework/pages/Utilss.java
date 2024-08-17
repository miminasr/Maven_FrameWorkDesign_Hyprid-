package com.hybridframework.pages;

import java.util.Date;

public class Utilss {
	public static final long IMPLICIT_WAIT = 200l;
	public static final long PAGELOAD_TIME = 200l;
	public static final long SCRIPT_TIME = 2000l;

	public static String emailWithDateTimestamp() {
		Date date= new Date();
		String emailDateTimeStamp= date.toString().replace(" ", "_").replace(":", "_");
		return "sarasadig" + emailDateTimeStamp+ "@gmail.com";
		
		}
}

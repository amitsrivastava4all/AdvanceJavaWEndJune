package com.brainmentors.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ResourceBundle;

public class CommonUtils {
	public static String convertPrintStackTraceIntoString(Exception e){
		StringWriter sw = new StringWriter();
		PrintWriter pw =new PrintWriter(sw);
		e.printStackTrace(pw);
		String result = sw.toString();
		return result;
		
	}
	private static ResourceBundle rb = ResourceBundle.getBundle("config");
	public static String getContextPath() {
		return rb.getString("contextpath");
	}
}

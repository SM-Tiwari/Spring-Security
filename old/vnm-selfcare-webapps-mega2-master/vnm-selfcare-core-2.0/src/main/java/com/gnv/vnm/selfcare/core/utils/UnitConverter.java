/**
 * UnitConverter.java
 */
package com.gnv.vnm.selfcare.core.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author internet
 *
 */
public class UnitConverter {

	public static final double SPACE_KB = 1024;
	public static final double SPACE_MB = 1024 * SPACE_KB;
	public static final double SPACE_GB = 1024 * SPACE_MB;
	public static final double SPACE_TB = 1024 * SPACE_GB;

	public static String bytes2String(long sizeInBytes) {

		NumberFormat nf = new DecimalFormat();
		nf.setMaximumFractionDigits(2);

		if (sizeInBytes == 0) return "0";
		
		try {
			if (sizeInBytes < SPACE_KB) {
				return nf.format(sizeInBytes) + " Byte(s)";
			} else if (sizeInBytes < SPACE_MB) {
				return nf.format(sizeInBytes / SPACE_KB) + " KB";
			} else if (sizeInBytes < SPACE_GB) {
				return nf.format(sizeInBytes / SPACE_MB) + " MB";
			} else if (sizeInBytes < SPACE_TB) {
				return nf.format(sizeInBytes / SPACE_GB) + " GB";
			} else {
				return nf.format(sizeInBytes / SPACE_TB) + " TB";
			}
		} catch (Exception e) {
			// e.printStackTrace();
			return sizeInBytes + " Byte(s)";
		}
	}
	
	public static String bytes2GB(long sizeInBytes) {

		NumberFormat nf = new DecimalFormat();
		nf.setMaximumFractionDigits(2);

		if (sizeInBytes == 0) return "0 GB";
		
		try {
			return nf.format(sizeInBytes / SPACE_MB) + " GB";
			
		} catch (Exception e) {
			return sizeInBytes + "0 GB";
		}
	}

	public static String milisToString(long milliseconds, String delimiter) {
		long[] values = milisToHours(milliseconds);
		if (delimiter == null || delimiter.equals("")) delimiter = ":";
		
		StringBuffer sb = new StringBuffer();
		if (values[0] > 0 ) sb.append(String.format("%02d", values[0])).append(delimiter);
		sb.append(String.format("%02d", values[1])).append(delimiter);
		sb.append(String.format("%02d", values[2]));
		
		return sb.toString().trim();
//		return String.format("%01dh" + delimiter + "%02dm" + delimiter + "%02ds", values[0], values[1], values[2]);
	}

	public static long[] milisToHours(long milliseconds) {
		long seconds = 0, minutes = 0, hours = 0;

		seconds = (milliseconds / 1000) % 60;
		minutes = (milliseconds / (1000 * 60)) % 60;
		hours = (milliseconds / (1000 * 60 * 60)) % 24;
		
		return new long[] { hours, minutes, seconds };
	}

	public static void main(String... args) {
//		long milis = 123456780;
		System.out.println(bytes2GB(1036737));
		System.out.println(milisToString(1450*60*60*1000, ":"));
		System.out.println(milisToString(50*1000, ":"));
	}
}

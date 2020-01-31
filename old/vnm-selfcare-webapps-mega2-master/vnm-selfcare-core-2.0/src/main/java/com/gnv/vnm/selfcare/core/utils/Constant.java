package com.gnv.vnm.selfcare.core.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Constant {
	//for prod server
 /* public static String MODE="prod";*/
	
	//for Dev server
  public static String MODE="test";
	
   /**
	 * Enumeration for LevelValue.
	 * 
	 * @author kuldeep Singh.
	 *
	 */
	public enum FattyWeight {

		FirstLevelWeight(5), SeoundLevelWeight(20), ThirdLevelWeight(50), FourthLevelWeight(100);

		private int value;

		private FattyWeight(int value) {
			this.value = value;
		}

		public int getWeightValue() {
			return value;
		}
	}
	
	 /**
		 * Enumeration for FattyRedeemStatus.
		 * 
		 * @author kuldeep Singh.
		 *
		 */
		public enum FattyRedeemStatus {

			USER_ALREADY_REDEEM("208"), SUCESSS("200"), FAIL("500");

			private String value;

			private FattyRedeemStatus(String value) {
				this.value = value;
			}

			public String getRedeemStatus() {
				return value;
			}
		}
	 /**
		 * Enumeration for FattyWeight.
		 * 
		 * @author kuldeep Singh.
		 *
		 */
	/*public enum FattyWeight {

		FirstLevelFattyWeight("5KG"), SeoundFattyWeight("20KG"), ThirdFattyWeight("50KG"), FourthFattyWeight("100KG");

		private String weight;

		private FattyWeight(String weight) {
			this.weight = weight;
		}

		public String getFattyWeight() {
			return weight;
		}
	}*/
	/**
	 * This method used for get offer start date
	 * @return month {@link Integer}}
	 * */
	public static String getstartDate()
	{
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		 int currentdate=localDate.getDayOfMonth();
		 System.out.println("current date :::"+currentdate);
		System.out.println("date :::;"+localDate.toString());
		System.out.println("current Year Value:::"+localDate.getYear());
		return "01"+"-"+localDate.getMonthValue()+"-"+localDate.getYear();
		
	}
	/**
	 * This method used for get current date
	 * @return month {@link Integer}}
	 * */
	public static String getCurrentDate()
	{
		Date today = new Date();
	    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	    String date = DATE_FORMAT.format(today);
		System.out.println("current date is :::"+date);
		return date;
		
	}
	
	public static int getDaysRemainingInCurrentMonth()
	{
		int days=0;
		 Calendar cal = Calendar.getInstance();
		 Date date = new Date();
		 LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		 int currentdate=localDate.getDayOfMonth();
		 int numberofdaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		    days=numberofdaysInMonth-currentdate;
		    if(days<0) return 0;
		return days;
	}
	
	
}
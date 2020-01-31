package com.gnv.vnm.selfcare.core.smpp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
import com.gnv.vnm.selfcare.core.service.BackEndRequestProcessor;

@Component
public class Mieadter {
    @Autowired
    BackEndRequestProcessor backEndRequestProcessor;
	public void savedata(String destAddr, int i, String string, String currentDateTime) {
		// TODO Auto-generated method stub
		backEndRequestProcessor.saveOtpStatus(destAddr, i, "0", getCurrentDateTime(),true);    
	}
	  public String getCurrentDateTime(){
	        
          Date dt = new Date();
          DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
          String strDate = dateFormat.format(dt);
          //System.out.println(strDate);
          return strDate;
   }
	  
	  public long TimeDiff(String first_time,String second_time){
	         DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy HH:mm");   
	         Date d1 = null;
	         Date d2 = null;
	         long diffHours=0;
	         try {
	                d1 = dateFormat1.parse(first_time);
	                d2 = dateFormat1.parse(second_time);

	                //in milliseconds
	                long diff = (int) (d2.getTime() - d1.getTime());

	                
	                  diffHours = diff / (60 * 60 * 1000);
	                
	               // System.out.print(diffHours + " hours, ");
	         
	         } catch (Exception e) {
	                e.printStackTrace();
	         }

	         
	         return diffHours;
	         
	  }

}

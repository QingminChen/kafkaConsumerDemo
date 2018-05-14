package kafkaConsumer.demo;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Base64;
import org.apache.commons.codec.binary.Base64;
import java.util.Date;

public class AllTestTool {
	
	public static void main(String[] args){
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
//	Date date = new Date(1494999598047L);
//	System.out.println(sd.format(date));
//	
//	Date date2 = new Date(1491697435000L);
//	System.out.println(sd.format(date2));
	
	Date date1 = new Date(1496299795000L);//startTime
	System.out.println(sd.format(date1));
	
	Date date2 = new Date(1496294395000L);    //endTime
	System.out.println(sd.format(date2));
	
	Date date3 = new Date(1496283775000L);    //start
	System.out.println(sd.format(date3));
	
	Date date4 = new Date(1496261155000L);    //endTime
	System.out.println(sd.format(date4));
	
	Date date5 = new Date(1496254735000L);    //singleTime    // 1496218015000
	System.out.println(sd.format(date5));
	
	Date date6 = new Date(1496248915002L);    //singleTime    // 1496218015000
	System.out.println(sd.format(date6));
	
	
	
	
	Date date7 = new Date(1496903215000L);    //singleTime    // 1496218015000
	System.out.println(sd.format(date7));
	
	Date date8 = new Date(1496953675000L);    //singleTime    // 1496218015000
	System.out.println(sd.format(date8));
	
	Date date9 = new Date(1510196227860L);    //singleTime    // 1496218015000
	System.out.println("date9:"+sd.format(date9));
	
	Date date10 = new Date(1510197127860L);    //singleTime    // 1496218015000
	System.out.println("date10:"+sd.format(date10));
	
	String credentials = "elastic:changeme";
		String credentialsEncoded = new String(Base64.encodeBase64(credentials.getBytes()));
		//return "Authorization:Basic "+credentialsEncoded;
		System.out.println("credentialsEncoded:"+credentialsEncoded);
	
//	
//	Date date8 = new Date(1496294395000L);    //singleTime    // 1496218015000
//	System.out.println(sd.format(date8));
//	
//	System.out.println("current time:"+String.valueOf(DateTime.now().getMillis()));
//	System.out.println("current time:"+String.valueOf(System.currentTimeMillis()));
	
	
	
//	String abc = null;
//	System.out.println("abc:"+abc);
//	
//		Date date = null;
//		try {
//			date = sd.parse("2017-05-23 17:30:30");
//			long currentTime = date.getTime();
//			System.out.println("currentTime:"+String.valueOf(currentTime));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	
	}

	
}

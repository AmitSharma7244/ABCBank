package test;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Test {
	
	public static void main(String[] args) {
		
		Date date = new Date();
		
		Timestamp timestamp = new Timestamp(date.getTime());
		
		System.out.println(timestamp);
		
		System.out.println(date.getTime());
		
		System.out.println(date);
		
		System.out.println(LocalDate.now());
		
		System.out.println(LocalTime.now());
		
		String date2= LocalDate.now().toString() + " " + LocalTime.now().toString();
		
		System.out.println(date2);
		
		
	}
	
}

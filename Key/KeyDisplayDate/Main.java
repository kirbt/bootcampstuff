package KeyDisplayDate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {

        // https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html

        // Initialize class to utilize methods

        LocalDateTime localDateTime =  LocalDateTime.now(ZoneId.of("UTC-7"));

        // Use methods to print date
        // ex. Today's date is: January 25th, 2004
        
        System.out.println("Today's date is: " + localDateTime.getMonth() + " " + localDateTime.getDayOfMonth() + ", " + localDateTime.getYear());

        // Use methods to print time 
        // ex. The current time is: 12:23 AM

        LocalTime localTime = LocalTime.of(localDateTime.getHour(), localDateTime.getMinute());

        System.out.println(localTime.toString());
        
    }
}

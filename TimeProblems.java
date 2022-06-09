import java.time.*;

public class TimeProblems {
    public static int countFridayThirteens(LocalDate startDate, LocalDate endDate){
        int count = 0;
        LocalDate myDate = startDate;
        while(!myDate.isAfter(endDate)) {
            if(myDate.getDayOfMonth()==13 && myDate.getDayOfWeek()==DayOfWeek.FRIDAY){
                count++;
            }
            myDate= myDate.plusDays(1);
        }
        return count;
    }
    public static String dayAfterSeconds(LocalDateTime timeHere, long seconds){
        LocalDateTime myDate = timeHere.plusSeconds(seconds);
        return myDate.getDayOfWeek().name();
    }
    public static int whatHourIsItThere(LocalDateTime timeHere, String here, String there){
        ZonedDateTime zoneHere = timeHere.atZone(ZoneId.of(here));
        return zoneHere.withZoneSameInstant(ZoneId.of(there)).getHour();
    }
}
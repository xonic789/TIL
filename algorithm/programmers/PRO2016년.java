package algorithm.programmers;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class PRO2016년 {

    public String solution(int a, int b) {
        return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0, 3);
    }

    public static void main(String[] args) {
        System.out.println(new PRO2016년().solution(5, 24));
    }
}

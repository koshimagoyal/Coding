package Hackerrank;

import java.text.DateFormatSymbols;
import java.util.*;

public class DateTime {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int mm = sc.nextInt();
        int dd = sc.nextInt();
        int yyyy = sc.nextInt();
        DateFormatSymbols dfs = new DateFormatSymbols();
        String week[] = dfs.getWeekdays();
        Calendar myCal = Calendar.getInstance();
        myCal.set(yyyy,mm-1,dd);
        int day = myCal.get(Calendar.DAY_OF_WEEK);
        System.out.println(week[1]+" "+day+" "+week[day].toUpperCase());
    }
}

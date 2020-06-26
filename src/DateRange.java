import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateRange {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        String date = sc.next();
        String fromDate = "01-01-2020";
        String toDate = "08-04-2020";
        System.out.println(date);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date from = format.parse(fromDate);
            Date to = format.parse(toDate);
            Date request = format.parse(date);
            if (request.compareTo(from) >= 0 && request.compareTo(to) <= 0) {
                System.out.println("Valid Date");
            } else {
                System.out.println("Not Valid Date");
            }
        } catch(ParseException pex) {
            System.out.println("Exception -"+pex);
        }
    }
}

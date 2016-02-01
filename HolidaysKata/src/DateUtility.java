import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by samir on 2/1/2016.
 */
public class DateUtility {

    public boolean isValidFormat(String dateString) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        try {
            DateTime dateTime = dateTimeFormatter.parseDateTime(dateString);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
            return false;
        }
        return true;
    }

}

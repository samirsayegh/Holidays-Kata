import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by samir on 2/1/2016.
 */
public class DateUtility {

    private DateTime initialDate;
    private DateTime endDate;

    private final String FORMAT = "dd/MM/yyyy";
    DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(FORMAT);

    public boolean isValidFormat(String dateString) {
        try {
            DateTime dateTime = dateTimeFormatter.parseDateTime(dateString);
            return true;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = dateFromString(initialDate);
    }

    public DateTime getInitialDate() {
        return initialDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = dateFromString(endDate);
    }

    public DateTime getEndDate() {
        return endDate;
    }

    private DateTime dateFromString(String dateString) {
        try {
            DateTime dateTime = dateTimeFormatter.parseDateTime(dateString);
            return dateTime;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}

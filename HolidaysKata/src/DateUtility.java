import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by samir on 2/1/2016.
 */
public class DateUtility {

    private DateTime initialDate;
    private DateTime endDate;

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

    public void setInitialDate(String initialDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        try {
            DateTime dateTime = dateTimeFormatter.parseDateTime(initialDate);
            this.initialDate = dateTime;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
            this.initialDate = null;
        }
    }

    public DateTime getInitialDate() {
        return initialDate;
    }

    public void setEndDate(String endDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yyyy");
        try {
            DateTime dateTime = dateTimeFormatter.parseDateTime(endDate);
            this.endDate = dateTime;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
            this.endDate = null;
        }
    }

    public DateTime getEndDate() {
        return endDate;
    }
}

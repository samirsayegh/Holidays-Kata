import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by samir on 2/1/2016.
 */
public class DateUtility {

    private DateTime initialDate;
    private DateTime endDate;

    private final String FORMAT = "dd/MM/yyyy";
    private DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(FORMAT);

    public boolean isValidFormat(String dateString) {
        try {
            dateTimeFormatter.parseDateTime(dateString);
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
            return dateTimeFormatter.parseDateTime(dateString);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    private Interval getInterval() {
        return new Interval(initialDate, endDate);
    }

    public boolean isDateInsideInterval(String midDate) {
        return getInterval().contains(dateFromString(midDate));
    }

    public boolean isInitialDateBeforeEndDate(DateTime startDate, DateTime endDate) {
        return startDate.isBefore(endDate);
    }

    public boolean isIntervalInsideInterval(String intervalStartDate, String intervalEndDate) {
        DateTime intStartDate = dateFromString(intervalStartDate);
        DateTime intEndDate = dateFromString(intervalEndDate);
        return getInterval().contains(new Interval(intStartDate, intEndDate));
    }

    public int numberOfDays() {
        return Days.daysIn(getInterval()).getDays();
    }

    public boolean isIntervalInTheSameMonth() {
        return true;
    }
}

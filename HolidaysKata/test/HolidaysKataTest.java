import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by samir on 1/10/2016.
 */
public class HolidaysKataTest {

    DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yyyy");

    @Test
    public void inputHasValidFormat() {
        DateUtility dateUtility = new DateUtility();
        boolean isValid = dateUtility.isValidFormat("01/01/2016");
        Assert.assertTrue(isValid);
    }

    @Test
    public void inputHasNotValidFormat() {
        DateUtility dateUtility = new DateUtility();
        boolean isValid = dateUtility.isValidFormat("01/2016");
        Assert.assertFalse(isValid);
    }

    @Test
    public void inputHasNotValidFormatMonth() {
        DateUtility dateUtility = new DateUtility();
        boolean isValid = dateUtility.isValidFormat("01/21/16");
        Assert.assertFalse(isValid);
    }

    @Test
    public void inputHasNotValidFormatDay() {
        DateUtility dateUtility = new DateUtility();
        boolean isValid = dateUtility.isValidFormat("32/01/16");
        Assert.assertFalse(isValid);
    }

    @Test
    public void initialDateIsSetted() {
        DateUtility dateUtility = new DateUtility();
        String date = "01/01/2016";
        dateUtility.setInitialDate(date);
        Assert.assertEquals(dateTimeFormatter.parseDateTime(date), dateUtility.getInitialDate());
    }

    @Test
    public void initialDateIsSettedWrongAsNull() {
        DateUtility dateUtility = new DateUtility();
        String date = "01/2016";
        dateUtility.setInitialDate(date);
        Assert.assertEquals(null, dateUtility.getInitialDate());
    }

    @Test
    public void endDateIsSetted() {
        DateUtility dateUtility = new DateUtility();
        String date = "01/01/2016";
        dateUtility.setEndDate(date);
        Assert.assertEquals(dateTimeFormatter.parseDateTime(date), dateUtility.getEndDate());
    }

    @Test
    public void endDateIsSettedWrongAsNull() {
        DateUtility dateUtility = new DateUtility();
        String date = "01/2016";
        dateUtility.setEndDate(date);
        Assert.assertEquals(null, dateUtility.getEndDate());
    }

    @Test
    public void isDateInsideTheInterval() {
        DateUtility dateUtility = new DateUtility();
        String startDate = "01/01/2016";
        String endDate = "01/05/2016";
        String midDate = "01/03/2016";
        dateUtility.setInitialDate(startDate);
        dateUtility.setEndDate(endDate);
        Assert.assertTrue(dateUtility.isDateInsideInterval(midDate));
    }

    @Test
    public void isDateOutsideTheInterval() {
        DateUtility dateUtility = new DateUtility();
        String startDate = "01/01/2016";
        String endDate = "01/05/2016";
        String midDate = "02/05/2016";
        dateUtility.setInitialDate(startDate);
        dateUtility.setEndDate(endDate);
        Assert.assertFalse(dateUtility.isDateInsideInterval(midDate));
    }

    @Test
    public void isInitialDateBeforeEndDate() {
        DateUtility dateUtility = new DateUtility();
        DateTime startDate = dateTimeFormatter.parseDateTime("01/01/2016");
        DateTime endDate = dateTimeFormatter.parseDateTime("01/05/2016");
        Assert.assertTrue(dateUtility.isInitialDateBeforeEndDate(startDate, endDate));
    }

    @Test
    public void isInitialDateNotBeforeEndDate() {
        DateUtility dateUtility = new DateUtility();
        DateTime startDate = dateTimeFormatter.parseDateTime("01/01/2016");
        DateTime endDate = dateTimeFormatter.parseDateTime("01/05/2016");
        Assert.assertFalse(dateUtility.isInitialDateBeforeEndDate(startDate, endDate));
    }

    @Test
    public void isIntervalInsideInterval() {
        DateUtility dateUtility = new DateUtility();
        String startDate = "01/01/2016";
        String endDate = "01/05/2016";
        String intervalStartDate = "02/02/2016";
        String intervalEndDate = "02/03/2016";
        dateUtility.setInitialDate(startDate);
        dateUtility.setEndDate(endDate);
        Assert.assertTrue(dateUtility.isIntervalInsideInterval(intervalStartDate, intervalEndDate));
    }
}

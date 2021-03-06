import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
        DateTime endDate = dateTimeFormatter.parseDateTime("01/05/2015");
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

    @Test
    public void isIntervalIsNotInsideInterval() {
        DateUtility dateUtility = new DateUtility();
        String startDate = "01/01/2016";
        String endDate = "01/05/2016";
        String intervalStartDate = "02/02/2016";
        String intervalEndDate = "02/05/2016";
        dateUtility.setInitialDate(startDate);
        dateUtility.setEndDate(endDate);
        Assert.assertFalse(dateUtility.isIntervalInsideInterval(intervalStartDate, intervalEndDate));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isIntervalIncorrectInInsideIntervalFunction() {
        DateUtility dateUtility = new DateUtility();
        String startDate = "01/01/2016";
        String endDate = "01/05/2016";
        String intervalStartDate = "02/02/2017";
        String intervalEndDate = "02/05/2016";
        dateUtility.setInitialDate(startDate);
        dateUtility.setEndDate(endDate);
        dateUtility.isIntervalInsideInterval(intervalStartDate, intervalEndDate);
    }

    @Test
    public void daysInsidePeriod() {
        DateUtility dateUtility = new DateUtility();
        String startDate = "01/01/2016";
        String endDate = "04/01/2016";
        dateUtility.setInitialDate(startDate);
        dateUtility.setEndDate(endDate);
        Assert.assertEquals(3, dateUtility.numberOfDays());
    }

    @Test
    public void daysInsidePeriod1() {
        DateUtility dateUtility = new DateUtility();
        String startDate = "01/01/2016";
        String endDate = "06/01/2016";
        dateUtility.setInitialDate(startDate);
        dateUtility.setEndDate(endDate);
        Assert.assertEquals(5, dateUtility.numberOfDays());
    }

    @Test
    public void isIntervalInTheSameMonth() {
        DateUtility dateUtility = new DateUtility();
        String startDate = "01/01/2016";
        String endDate = "07/01/2016";
        dateUtility.setInitialDate(startDate);
        dateUtility.setEndDate(endDate);
        Assert.assertTrue(dateUtility.isIntervalInTheSameMonth());
    }

    @Test
    public void isIntervalIsNotInTheSameMonth() {
        DateUtility dateUtility = new DateUtility();
        String startDate = "01/01/2016";
        String endDate = "01/05/2016";
        dateUtility.setInitialDate(startDate);
        dateUtility.setEndDate(endDate);
        Assert.assertFalse(dateUtility.isIntervalInTheSameMonth());
    }

    @Test
    public void isIntervalInTheSameYear() {
        DateUtility dateUtility = new DateUtility();
        String startDate = "01/01/2016";
        String endDate = "07/01/2016";
        dateUtility.setInitialDate(startDate);
        dateUtility.setEndDate(endDate);
        Assert.assertTrue(dateUtility.isIntervalInTheSameYear());
    }

    @Test
    public void isIntervalNotInTheSameYear() {
        DateUtility dateUtility = new DateUtility();
        String startDate = "01/01/2016";
        String endDate = "07/01/2017";
        dateUtility.setInitialDate(startDate);
        dateUtility.setEndDate(endDate);
        Assert.assertFalse(dateUtility.isIntervalInTheSameYear());
    }
}

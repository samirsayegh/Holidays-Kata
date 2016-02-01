import org.junit.Assert;
import org.junit.Test;

/**
 * Created by samir on 1/10/2016.
 */
public class HolidaysKataTest {

    @Test
    public void inputHasValidFormat() {
        DateUtility dateUtility = new DateUtility();
        boolean isValid = dateUtility.isValidFormat("01/01/2016");
        Assert.assertTrue(isValid);
    }
}

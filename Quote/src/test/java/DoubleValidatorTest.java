import org.junit.Assert;

public class DoubleValidatorTest {

    @org.junit.Test
    public void whenGivenInvalidLoanAmount_ThanParseDoubleSafeReturnsFalse() throws Exception {
        Assert.assertFalse(DoubleValidator.validate(""));
    }
}

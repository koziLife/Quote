import static org.junit.Assert.assertEquals;

public class RateCalculationTest {

    private RateCalculation rateCalculation;

    @org.junit.Before
    public void setup(){
        MockData mockData = new MockData();
        rateCalculation = new RateCalculation(mockData.mockMarket());
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void whenGivenEmptyFileName_ThanThrowException() throws Exception{
        rateCalculation.quote(100, 36);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void whenGivenAmountLessThan1000_ThanThrowException() throws Exception{
        rateCalculation.quote(100, 36);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void whenGivenAmountBiggerThan15000_ThanThrowException() throws Exception{
        rateCalculation.quote(20000, 36);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void whenGivenAmountNotIncrement100_ThanThrowException() throws Exception{
        rateCalculation.quote(1234, 36);
    }

    @org.junit.Test
    public void whenGivenAmountThatIsAvailableFromOneLender() throws Exception{
        QuoteResponse response = rateCalculation.quote(1000, 36);
        assertEquals(1000, response.getRequestedAmount(),0);
        assertEquals(20.0, response.getRate(), 0);
        String monthlyAmount = String.format("%.2f",1200.0/36);
        assertEquals(monthlyAmount, String.format("%.2f",response.getMonthlyRepayment()));
        assertEquals(1200, response.getTotalRepayment(),0);
    }

    @org.junit.Test
    public void whenGivenAmountThatIsNotAvailableFromOneLender() throws Exception{
        QuoteResponse response = rateCalculation.quote(2000, 36);
        assertEquals(2000, response.getRequestedAmount(),0);
        assertEquals(30.0, response.getRate(), 0);
        String monthlyAmount = String.format("%.2f",2600.0/36);
        assertEquals(monthlyAmount, String.format("%.2f",response.getMonthlyRepayment()));
        assertEquals(2600, response.getTotalRepayment(),0);
    }

    @org.junit.Test(expected = RuntimeException.class)
    public void whenGivenAmountThatIsNotEnoughAmount() throws Exception{
        QuoteResponse response = rateCalculation.quote(12000, 36);

    }
}

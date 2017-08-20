import java.util.List;

public class RateCalculation {

    private static final double MIN_AMOUNT = 1000.0;
    private static final double MAX_AMOUNT = 15000.0;
    private static final int INCREMENT_VALUE = 100;

    private Market market;

    public RateCalculation(Market market) {
        this.market = market;
    }

    /**
     * <p>
     * This method finds the most proper quote in the market according to given <code>amount</code>
     * and number of month <code>length</code>
     * It will return the requested amount, rate, monthly repayment amount
     * and total repayment amount.
     * </p>
     *
     * @param amount the requested loan amount
     * @param length the number of month
     * @return the quote response
     *
     */
    public QuoteResponse quote(double amount, int length) {
        validate(amount);
        List<Lender> lenders = this.market.getLenders();
        QuoteResponse response = null;
        double interestAmount = 0;
        double requestAmount = amount;
        double rate;
        double totalRepayment;
        double monthlyRepayment;

        for (Lender lender : lenders) {
            if (requestAmount <= lender.getAmount()) {
                interestAmount += (requestAmount * lender.getRate());
                rate = Double.parseDouble(String.format("%.1f",(interestAmount * 100) / amount));
                totalRepayment = interestAmount + amount;
                monthlyRepayment = Double.parseDouble(String.format("%.2f", (totalRepayment / length)));
                response = new QuoteResponse(amount, rate, monthlyRepayment, totalRepayment);
                break;
            }
            requestAmount -= lender.getAmount();
            interestAmount += lender.getAmount() * lender.getRate();
        }

        return response;
    }

    /**
     * <p>
     * This method validates the given <code>amount</code>.
     * according to specified criteria.
     * </p>
     *
     * @param amount the input double
     * @throws IllegalArgumentException if input double is less than £1000
     * @throws IllegalArgumentException if input double is greater than £15000
     * @throws IllegalArgumentException if input double is not any of £100 increment
     * @throws RuntimeException if the input double is greater than total market amount
     *
     */
    private void validate(double amount) {

        if (amount < MIN_AMOUNT) {
            throw new IllegalArgumentException("The amount should be greater than £" + MIN_AMOUNT);
        }
        if (amount > MAX_AMOUNT) {
            throw new IllegalArgumentException("The amount should be less than £ " + MAX_AMOUNT);
        }
        if ((amount % INCREMENT_VALUE) != 0) {
            throw new IllegalArgumentException("The amount should be any of £ " + INCREMENT_VALUE + " increment");
        }
        if (this.market.getTotalAmount() < amount) {
            throw new RuntimeException("There is not enough balance in the market, we have £" + this.market.getTotalAmount() + ", you request £" + amount);
        }
    }

}

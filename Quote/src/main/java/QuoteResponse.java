public class QuoteResponse {

    private double requestedAmount;
    private double rate;
    private double monthlyRepayment;
    private double totalRepayment;

    public QuoteResponse(double requestedAmount, double rate, double monthlyRepayment, double totalRepayment) {
        this.requestedAmount = requestedAmount;
        this.rate = rate;
        this.monthlyRepayment = monthlyRepayment;
        this.totalRepayment = totalRepayment;
    }

    /**
     * Get the requested amount of this quote.
     * @return the requested amount of this quote.
     */
    public double getRequestedAmount() {
        return requestedAmount;
    }

    /**
     * Get the rate of this quote.
     * @return the rate of this quote.
     */
    public double getRate() {
        return rate;
    }

    /**
     * Get the monthly repayment amount of this quote.
     * @return the monthly repayment amount of this quote.
     */
    public double getMonthlyRepayment() {
        return monthlyRepayment;
    }

    /**
     * Get the total repayment amount of this quote.
     * @return the total repayment amount of this quote.
     */
    public double getTotalRepayment() {
        return totalRepayment;
    }

    /**
     * Overriden to provide a string representation of a quote.
     */
    @Override
    public String toString() {
        return "Requested amount: £" + requestedAmount +
                "\nRate: " + rate + "%" +
                "\nMonthly repayment: £" + monthlyRepayment +
                "\nTotal repayment: £" + totalRepayment;
    }
}

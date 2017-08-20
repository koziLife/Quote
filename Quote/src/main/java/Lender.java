public class Lender {

    private String name;
    private double rate;
    private double amount;

    public Lender(String name, double rate, double amount) {
        this.name = name;
        this.rate = rate;
        this.amount = amount;
    }

    /**
     * Get the amount of this lender.
     * @return the amount of this lender.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Get the rate of this lender.
     * @return the rate of this lender.
     */
    public double getRate() {
        return rate;
    }

}

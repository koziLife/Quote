import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Market {

    private List<Lender> lenders;
    private double totalAmount;

    /**
     * <p>
     * Sort lenders according to rate ascending then loanable fund descending.
     * </p>
     */
    static final Comparator<Lender> COMPARATOR_RATE_AMOUNT = new Comparator<Lender>() {
        @Override
        public int compare(Lender lender1, Lender lender2) {
            int rateCompare = Double.compare(lender1.getRate(), lender2.getRate());

            if (rateCompare != 0) {
                return rateCompare;
            } else {
                return Double.compare(lender2.getAmount(), lender1.getAmount());
            }
        }
    };

    public Market(List<Lender> lenders) {
        Collections.sort(lenders, COMPARATOR_RATE_AMOUNT);
        this.lenders = lenders;
    }

    /**
     * Get the lender's list of this market.
     * @return the lender's list of this market.
     */
    public List<Lender> getLenders() {
        return lenders;
    }


    /**
     * Get the total amount of this market.
     * @return the total amount of this market.
     */
    public double getTotalAmount() {
        for (Lender lender : getLenders()) {
            this.totalAmount += lender.getAmount();
        }
        return totalAmount;
    }
}

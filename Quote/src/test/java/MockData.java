import java.util.ArrayList;
import java.util.List;

public class MockData {

    public Market mockMarket() {
        Market market = new Market(generateLenders());
        return market;
    }

    public Market emptyMarket() {
        return new Market(new ArrayList<>());
    }

    private List<Lender> generateLenders() {
        List<Lender> lenders = new ArrayList<>();
        Lender lender1 = new Lender("Joe", 0.2, 1000.0);
        lenders.add(lender1);
        Lender lender2 = new Lender("Jeff", 0.4, 2000.0);
        lenders.add(lender2);
        Lender lender3 = new Lender("Tim", 0.5, 6000.0);
        lenders.add(lender3);
        Lender lender4 = new Lender("Osi", 0.6, 1000.0);
        lenders.add(lender4);

        return lenders;
    }
}

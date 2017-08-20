public class Main {

    public static void main(String[] args) {
        try {
            validateArguments(args);
            String csvFile = args[0];
            double loanAmount = Double.parseDouble(args[1]);

            RateCalculation rateCalculation = new RateCalculation(new Market(CsvReader.parseMarketFile(csvFile)));
            System.out.println(rateCalculation.quote(loanAmount, 36));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void validateArguments(String[] args) {
        if (args == null) {
            throw new IllegalArgumentException("Arguments cannot be null.\nhelp: java -jar Quote.jar <market_csv>[string] <loan_amount>[double]");
        }
        if (args.length != 2) {
            throw new IllegalArgumentException("2 arguments must be presented.\nhelp: java -jar Quote.jar <market_csv>[string] <loan_amount>[double]");
        }
        if (args[0] == null || args[0].isEmpty()) {
            throw new IllegalArgumentException("The file name cannot be empty");
        }
        if (args[1] == null || args[1].isEmpty()) {
            throw new IllegalArgumentException("The loan amount cannot be empty");
        }
        if (!DoubleValidator.validate(args[1])) {
            throw new IllegalArgumentException("The loan amount must be double");
        }
    }


}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {

    /**
     * <p>
     * This method returns lenders of list in the csv file <code>csvFile</code> .
     * It will return lender's rate and amount in the market.
     * </p>
     *
     * @param csvFile the input double
     * @return list of lenders
     * @throws IOException if input file is not found or cannot be read
     *
     */
    public static ArrayList<Lender> parseMarketFile(String csvFile) {
        ArrayList<Lender> lenders = null;
        String line = "";
        String cvsSplitBy = ",";
        BufferedReader br = null;
        try {
            lenders = new ArrayList<>();
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] market = line.split(cvsSplitBy);
                if (market.length == 3 &&
                        !market[0].isEmpty() &&
                        !market[1].isEmpty() &&
                        !market[2].isEmpty()) {
                    Lender lender = new Lender(market[0].trim(),
                            Double.parseDouble(market[1].trim()),
                            Double.parseDouble(market[2].trim()));
                    lenders.add(lender);
                }
            }
            if (lenders.size() == 0) {
                throw new RuntimeException("File is not valid.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lenders;
    }
}

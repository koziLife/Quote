import org.junit.Assert;

public class CsvReaderTest {

    private final static String folderPath = "/Users/meryemalay/Documents/Zopa/Quote/src/main/resources";
    private final static String csvFileNotFound = folderPath + "/marketT.csv";
    private final static String csvFileEmpty = folderPath + "/marketTest.csv";
    private final static String csvFile = folderPath + "/market.csv";

    @org.junit.Test
    public void whenCsvFileNotExist_NotFoundException() throws Exception {
        CsvReader.parseMarketFile(csvFileNotFound);
    }

    @org.junit.Test(expected = RuntimeException.class)
    public void whenCsvFileExistsAndEmpty_ThanThrowRuntimeException() throws Exception {
        CsvReader.parseMarketFile(csvFileEmpty);
    }

    @org.junit.Test
    public void whenCsvFileExists_ThanReturnLenderList() throws Exception {
        Assert.assertEquals("Market size should be 5.",5, CsvReader.parseMarketFile(csvFile).size());
    }
}

public class MainTest {

    private static final String csvFile = "marketTest.csv";

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void whenGivenNoArguments_ThanThrowException() throws Exception {
        Main.validateArguments(null);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void whenGivenOneArgument_ThanThrowException() throws Exception {
        Main.validateArguments(new String[]{csvFile});
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void whenGivenInvalidFileName_ThanThrowException() throws Exception {
        Main.validateArguments(new String[]{"", "1000"});
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void whenGivenInvalidAmount_ThanThrowException() throws Exception {
        Main.validateArguments(new String[]{csvFile, ""});
    }

    @org.junit.Test
    public void whenGivenValidArguments() throws Exception {
        Main.main(new String[]{csvFile, "1000"});
    }
}

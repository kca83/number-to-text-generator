package anderson.katherine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberTextGeneratorTest {

    NumberTextGenerator numberTextGenerator;

    @Before
    public void initialize() {
        numberTextGenerator = new NumberTextGenerator();
    }

    @Test
    public void numberToTextTest3() {
        String input = "3";

        String expected = "ThreeDollars";
        String actual = numberTextGenerator.numberToText(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numberToTextTest1000000() {
        String input = "1000000";

        String expected = "OneMillionDollars";
        String actual = numberTextGenerator.numberToText(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numberToTextTest1000() {
        String input = "1000";

        String expected = "OneThousandDollars";
        String actual = numberTextGenerator.numberToText(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numberToTextTest95622() {
        String input = "95622";

        String expected = "NinetyFiveThousandSixHundredTwentyTwoDollars";
        String actual = numberTextGenerator.numberToText(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numberToTextTest100075315() {
        String input = "100075315";

        String expected = "OneHundredMillionSeventyFiveThousandThreeHundredFifteenDollars";
        String actual = numberTextGenerator.numberToText(input);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numberToTextTest14() {
        String input = "14";

        String expected = "FourteenDollars";
        String actual = numberTextGenerator.numberToText(input);

        Assert.assertEquals(expected, actual);
    }
}

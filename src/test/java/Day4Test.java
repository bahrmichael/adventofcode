import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day4Test {

    @ParameterizedTest(name = "{0} should be {1}")
    @CsvSource({"aa bb cc dd ee, true", "aa bb cc dd aa, false", "aa bb cc dd aaa, true"})
    void isValid(final String phrase, final boolean expected) {
        final boolean result = Day4.isValid(phrase);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "{0} should contain {1} valid sentences")
    @CsvSource({"'aa bb cc dd ee\naa bb cc dd aa\naa bb cc dd aaa', 2"})
    void countValidPhrases(final String phrases, final int expectedCount) {
        final int result = Day4.countValidPhrases(phrases);
        assertEquals(expectedCount, result);
    }

    @Test
    void solveChallenge() {
        System.out.println("1: " + Day4.countValidPhrases(Day4.PUZZLE));
    }
}

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day4Test {

    @ParameterizedTest(name = "{0} should be {1}")
    @CsvSource({"aa bb cc dd ee, true", "aa bb cc dd aa, false", "aa bb cc dd aaa, true"})
    void isValid1(final String phrase, final boolean expected) {
        final boolean result = Day4.isValid1.apply(phrase);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "{0} should be {1}")
    @CsvSource({"abcde fghij, true", "abcde xyz ecdab, false", "a ab abc abd abf abj, true",
               "iiii oiii ooii oooi oooo, true", "oiii ioii iioi iiio, false"})
    void isValid2(final String phrase, final boolean expected) {
        final boolean result = Day4.isValid2.apply(phrase);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "{0} should contain {1} valid sentences")
    @CsvSource({"'aa bb cc dd ee\naa bb cc dd aa\naa bb cc dd aaa', 2"})
    void countValidPhrases(final String phrases, final int expectedCount) {
        final int result = Day4.countValidPhrases(phrases, Day4.isValid1);
        assertEquals(expectedCount, result);
    }

    @Test
    void solveChallenge() {
        System.out.println("1: " + Day4.countValidPhrases(Day4.PUZZLE, Day4.isValid1));
        System.out.println("2: " + Day4.countValidPhrases(Day4.PUZZLE, Day4.isValid2));
    }
}

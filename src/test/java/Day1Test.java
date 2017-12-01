import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day1Test {

    @ParameterizedTest(name = "{0} should be {1}")
    @CsvSource({"1122, 3", "1111, 4", "1234, 0", "91212129, 9"})
    void testChallenge1(final CharSequence number, final int expected) {
        assertEquals(expected, Day1.solve1(number));
    }

    @ParameterizedTest(name = "{0} should be {1}")
    @CsvSource({"1212, 6", "1221, 0", "123123, 12", "123425, 4", "12131415, 4"})
    void testChallenge2(final CharSequence number, final int expected) {
        assertEquals(expected, Day1.solve2(number));
    }

    @Test
    void solveChallenge() {
        System.out.println("1: " + Day1.solve1(Day1.NUMBERS));
        System.out.println("2: " + Day1.solve2(Day1.NUMBERS));
    }
}

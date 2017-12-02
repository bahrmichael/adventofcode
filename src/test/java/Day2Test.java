import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2Test {

    @ParameterizedTest(name = "{0} should be {1}")
    @CsvSource({"5\t1\t9\t5, 5, 1, 9, 5", "7\t5\t3\t1, 7, 5, 3, 1", "2\t4\t6\t8, 2, 4, 6, 8"})
    void testExtractNumbers(final CharSequence numbers, final int a, final int b, final int c, final int d) {
        final int[] result = Day2.extractNumbers(numbers);
        assertEquals(a, result[0]);
        assertEquals(b, result[1]);
        assertEquals(c, result[2]);
        assertEquals(d, result[3]);
    }

    @ParameterizedTest(name = "{0} should be {1}")
    @CsvSource({"5\t1\t9\t5, 8", "7\t5\t3, 4", "2\t4\t6\t8, 6"})
    void testChallenge1(final CharSequence number, final int expected) {
        assertEquals(expected, Day2.maxDelta(Day2.extractNumbers(number)));
    }

    @Test
    void testSolve1() {
        assertEquals(18, Day2.solve1("5\t1\t9\t5\n7\t5\t3\n2\t4\t6\t8"));
    }

    @ParameterizedTest(name = "{0} should be {1}")
    @CsvSource({"5\t9\t2\t8, 4", "9\t4\t7\t3, 3", "3\t8\t6\t5, 2"})
    void testChallenge2(final CharSequence number, final int expected) {
        assertEquals(expected, Day2.evenDivision(Day2.extractNumbers(number)));
    }

    @Test
    void testSolve2() {
        assertEquals(9, Day2.solve2("5\t9\t2\t8\n9\t4\t7\t3\n3\t8\t6\t5"));
    }

    @Test
    void solveChallenge() {
        System.out.println("1: " + Day2.solve1(Day2.NUMBERS));
        System.out.println("2: " + Day2.solve2(Day2.NUMBERS));
    }
}

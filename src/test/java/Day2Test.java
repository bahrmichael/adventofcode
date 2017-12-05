import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day2Test {

    @ParameterizedTest(name = "{0} should be {1}")
    @CsvSource({"5\t1\t9\t5, 8", "7\t5\t3, 4", "2\t4\t6\t8, 6"})
    void testChallenge1(final CharSequence number, final int expected) {
        assertEquals(expected, Day2.maxDelta(Util.extractNumbers(number, "\t")));
    }

    @Test
    void testSolve1() {
        assertEquals(18, Day2.solve1("5\t1\t9\t5\n7\t5\t3\n2\t4\t6\t8"));
    }

    @ParameterizedTest(name = "{0} should be {1}")
    @CsvSource({"5\t9\t2\t8, 4", "9\t4\t7\t3, 3", "3\t8\t6\t5, 2"})
    void testChallenge2(final CharSequence number, final int expected) {
        assertEquals(expected, Day2.evenDivision(Util.extractNumbers(number, "\t")));
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

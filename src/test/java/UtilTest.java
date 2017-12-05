import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilTest {

    @ParameterizedTest(name = "{0} should be {1}")
    @CsvSource({"5\t1\t9\t5, 5, 1, 9, 5", "7\t5\t3\t1, 7, 5, 3, 1", "2\t4\t6\t8, 2, 4, 6, 8"})
    void testExtractNumbers(final CharSequence numbers, final int a, final int b, final int c, final int d) {
        final int[] result = Util.extractNumbers(numbers, "\t");
        assertEquals(a, result[0]);
        assertEquals(b, result[1]);
        assertEquals(c, result[2]);
        assertEquals(d, result[3]);
    }
}

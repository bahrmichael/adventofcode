import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day9Test {

    @ParameterizedTest
    @CsvSource({"{}, 1", "{{{}}}, 6", "'{{},{}}', 5", "'{{{},{},{{}}}}', 16", "'{<a>,<a>,<a>,<a>}', 1",
                "'{{<ab>},{<ab>},{<ab>},{<ab>}}', 9", "'{{<!!>},{<!!>},{<!!>},{<!!>}}', 9",
                "'{{<a!>},{<a!>},{<a!>},{<ab>}}', 3"})
    void solve1(final String input, final int expected) {
        assertEquals(expected, Day9.solve1(input));
    }

    @ParameterizedTest
    @CsvSource({"<>, 0", "<random characters>, 17", "<<<<>, 3", "<{!>}>, 2", "<!!>, 0", "<!!!>>, 0",
                "'<{o\"i!a,<{i<a>', 10", "'<a!!!>aa!!!>,,,}!>!>!!eo!!a>', 10"})
    void solve2(final String input, final int expected) {
        assertEquals(expected, Day9.solve2(input));
    }

    @Test
    void solve() {
        System.out.println("1: " + Day9.solve1(Day9.PUZZLE));
        System.out.println("2: " + Day9.solve2(Day9.PUZZLE));
    }
}

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6Test {

    @Test
    void solve() {
        System.out.println("1: " + Day6.solve1(Day6.PUZZLE));
        System.out.println("2: " + Day6.solve2(Day6.PUZZLE));
    }

    @Test
    void solve2() {
        assertEquals(4, Day6.solve2("2\t4\t1\t2"));
    }

    @ParameterizedTest
    @MethodSource("arrayProvider")
    void redistribute(final int[] in, final int[] expected) {
        assertArrayEquals(expected, Day6.redistribute(in));
    }

    private static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(new int[]{0, 2, 7, 0}, new int[]{2, 4, 1, 2}),
                Arguments.of(new int[]{2, 4, 1, 2}, new int[]{3, 1, 2, 3}),
                Arguments.of(new int[]{3, 1, 2, 3}, new int[]{0, 2, 3, 4}),
                Arguments.of(new int[]{0, 2, 3, 4}, new int[]{1, 3, 4, 1}),
                Arguments.of(new int[]{1, 3, 4, 1}, new int[]{2, 4, 1, 2})
                        );
    }

    @ParameterizedTest
    @MethodSource("arrayForClearanceProvider")
    void getClearanceIndex(final int[] in, final int expectedIndex) {
        assertEquals(expectedIndex, Day6.getClearanceIndex(in));
    }

    private static Stream<Arguments> arrayForClearanceProvider() {
        return Stream.of(
                Arguments.of(new int[]{0, 2, 7, 0}, 2),
                Arguments.of(new int[]{2, 4, 1, 2}, 1),
                Arguments.of(new int[]{3, 1, 2, 3}, 0),
                Arguments.of(new int[]{0, 2, 3, 4}, 3),
                Arguments.of(new int[]{1, 3, 4, 1}, 2)
                        );
    }
}

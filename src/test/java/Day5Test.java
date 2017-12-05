import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day5Test {

    @Test
    void solveExample1() {
        final String example = "0\n3\n0\n1\n-3";
        final int result = Day5.solve1(example);
        assertEquals(5, result);
    }

    @Test
    void solveExample2() {
        final String example = "0\n3\n0\n1\n-3";
        final int result = Day5.solve2(example);
        assertEquals(10, result);
    }

    @Test
    void solveChallenge() {
        System.out.println("1: " + Day5.solve1(Day5.PUZZLE));
        System.out.println("2: " + Day5.solve2(Day5.PUZZLE));
    }
}

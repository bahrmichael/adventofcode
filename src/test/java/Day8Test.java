import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day8Test {
    private static final String EXAMPLE = "b inc 5 if a > 1\n"
                                          + "a inc 1 if b < 5\n"
                                          + "c dec -10 if a >= 1\n"
                                          + "c inc -20 if c == 10";

    @Test
    void example_should_return_1() {
        assertEquals(1, Day8.solve(EXAMPLE));
    }

    @Test
    void solve() {
        System.out.println("1: " + Day8.solve(Day8.PUZZLE));
    }
}

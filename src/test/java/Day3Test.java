import java.awt.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day3Test {

    @ParameterizedTest(name = "{0} should have the size {1}x{1}")
    @CsvSource({"1, 1", "2, 3", "7, 3", "9, 3", "10, 5", "13, 5", "17, 5", "23, 5", "25, 5", "26, 7"})
    void determineSize(final int maxNumber, final int expectedSize) {
        final int result = Day3.determineSize(maxNumber);
        assertEquals(expectedSize, result);
    }

    @ParameterizedTest(name = "{0} should be at {1}x{2}")
    @CsvSource({"1, 2, 2", "2, 3, 2", "3, 3, 1", "5, 1, 1", "7, 1, 3", "9, 3, 3", "10, 4, 3", "13, 4, 0", "17, 0, 0",
                "21, 0, 4", "23, 2, 4"})
    void generateMatrix(final int number, final int x, final int y) {
        final int[][] matrix = Day3.generateMatrix1(23);
        assertEquals(number, matrix[x][y]);
    }

    @ParameterizedTest(name = "{0} should be at {1}x{2}")
    @CsvSource({"1, 0, 0", "2, 2, 1", "3, 2, 0", "5, 0, 0", "7, 0, 2", "9, 2, 2", "10, 4, 3", "13, 4, 0", "17, 0, 0",
                "21, 0, 4", "23, 2, 4"})
    void getCoordinates(final int number, final int expectedX, final int expectedY) {
        final int[][] matrix = Day3.generateMatrix1(number);
        final Point coordinates = Day3.getCoordinates(number, matrix);
        assertEquals(expectedX, coordinates.getX());
        assertEquals(expectedY, coordinates.getY());
    }

    @ParameterizedTest(name = "{0} should be {1} steps")
    @CsvSource({"1, 0", "2, 1", "3, 2", "14, 3", "22, 3", "23, 2", "1024, 31"})
    void getStepsToCenter(final int number, final int expected) {
        final int[][] matrix = Day3.generateMatrix1(number);
        final int result = Day3.getStepsToCenter(number, matrix);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "The {0}. cell at {1}x{2} should yield {3}")
    @CsvSource({"1, 0, 0, 1", "2, 2, 1, 1", "3, 2, 0, 2", "4, 1, 0, 4", "5, 0, 0, 5", "6, 0, 1, 10", "7, 0, 2, 11",
                "8, 1, 2, 23", "9, 2, 2, 25", "10, 4, 3, 26", "11, 4, 2, 54", "12, 4, 1, 57", "13, 4, 0, 59",
                "13, 3, 0, 122", "14, 2, 0, 133", "15, 1, 0, 142", "16, 0, 0, 147", "17, 0, 1, 304", "20, 0, 4, 362",
                "21, 1, 4, 747"})
    void getSurroundingCellSum(final int cellNumber, final int x, final int y, final int expected) {
        final int[][] matrix = Day3.generateSumMatrix(cellNumber);
        final int result = Day3.getSurroundingCellSum(x, y, matrix);
        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "The first value larger than {0} is {1}")
    @CsvSource({"3, 4", "7, 10", "23, 25", "30, 54", "140, 142", "362, 747"})
    void getFirstAboveBorderValue(final int borderValue, final int expected) {
        final int result = Day3.getFirstAboveBorderValue(borderValue);
        assertEquals(expected, result);
    }

    @Test
    void solve() {
        System.out.println("1: " + Day3.solve1(Day3.PUZZLE_INPUT));
        System.out.println("2: " + Day3.getFirstAboveBorderValue(Day3.PUZZLE_INPUT));
    }
}

import java.awt.*;

public class Day3 {

    public static final int PUZZLE_INPUT = 277678;

    public static int[][] generateMatrix(final int maxNumber) {
        final int n = determineSize(maxNumber);
        final int center = (int) Math.ceil(n / 2.0) - 1;
        int x = center;
        int y = center;
        Direction direction = Direction.RIGHT;
        int directionCounter = 1;
        final int[][] matrix = new int[n][n];
        for (int i = 1; i <= maxNumber; i++) {
            matrix[x][y] = i;
            if (direction == Direction.RIGHT) {
                x += 1;
                directionCounter--;
                if (directionCounter == 0) {
                    direction = Direction.UP;
                    // subtract one, because we are already one up when breaking into the next spiral
                    directionCounter = determineSize(i + 1) - 1 - 1;
                }
            } else if (direction == Direction.UP) {
                y -= 1;
                directionCounter--;
                if (directionCounter == 0) {
                    direction = Direction.LEFT;
                    directionCounter = determineSize(i + 1) - 1;
                }
            } else if (direction == Direction.LEFT) {
                x -= 1;
                directionCounter--;
                if (directionCounter == 0) {
                    direction = Direction.DOWN;
                    directionCounter = determineSize(i + 1) - 1;
                }
            } else if (direction == Direction.DOWN) {
                y += 1;
                directionCounter--;
                if (directionCounter == 0) {
                    direction = Direction.RIGHT;
                    // add 1, so it can break into the next spiral
                    directionCounter = determineSize(i + 1) - 1 + 1;
                }
            }
        }
        return matrix;
    }

    public static int determineSize(final int maxNumber) {
        for (int i = 1; i < Integer.MAX_VALUE; i+=2) {
            if (Math.pow(i, 2) >= maxNumber) {
                return i;
            }
        }
        throw new RuntimeException("MAX Integer exceeded.");
    }

    public static Point getCoordinates(final int number, final int[][] matrix) {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                if (number == matrix[x][y]) {
                    return new Point(x, y);
                }
            }
        }
        throw new RuntimeException("Number could not be found.");
    }

    static int getStepsToCenter(final int number, final int[][] matrix) {
        final int n = determineSize(number);
        final int center = (int) Math.ceil(n / 2.0) - 1;
        final Point coordinates = getCoordinates(number, matrix);
        final int distX = Math.abs(coordinates.x - center);
        final int distY = Math.abs(coordinates.y - center);
        return distX + distY;
    }

    static int solve(final int number) {
        return getStepsToCenter(number, generateMatrix(number));
    }
}

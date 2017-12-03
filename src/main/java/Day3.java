import java.awt.*;

public class Day3 {

    public static final int PUZZLE_INPUT = 277678;

    public static int[][] generateMatrix1(final int maxNumber) {
        final Data data = initData(maxNumber);
        final int[][] matrix = new int[data.arrayLength][data.arrayLength];
        for (int i = 1; i <= maxNumber; i++) {
            matrix[data.x][data.y] = i;
            move(data, i);
        }
        return matrix;
    }

    public static int getFirstAboveBorderValue(final int borderValue) {
        final Data data = initData(borderValue * 2);
        final int[][] matrix = generateSumMatrix(borderValue * 2);

        for (int i = 1; i <= borderValue * 2; i++) {
            final int currentValue = matrix[data.x][data.y];
            if (currentValue > borderValue) {
                return currentValue;
            }
            move(data, i);
        }
        throw new RuntimeException("Number could not be found.");
    }

    public static int[][] generateSumMatrix(final int cellCount) {
        final Data data = initData(cellCount);
        final int[][] matrix = new int[data.arrayLength][data.arrayLength];
        for (int i = 1; i <= cellCount; i++) {
            final int value = getSurroundingCellSum(data.x, data.y, matrix);
            matrix[data.x][data.y] = value;
            move(data, i);
        }
        return matrix;
    }

    public static int getSurroundingCellSum(final int x, final int y, final int[][] matrix) {
        if (getCenter(matrix.length) == x && getCenter(matrix.length) == y) {
            return 1;
        }
        return safeExtract(matrix, x - 1, y) +
               safeExtract(matrix, x + 1, y) +
               safeExtract(matrix, x, y - 1) +
               safeExtract(matrix, x, y + 1) +
               safeExtract(matrix, x - 1, y - 1) +
               safeExtract(matrix, x - 1, y + 1) +
               safeExtract(matrix, x + 1, y - 1) +
               safeExtract(matrix, x + 1, y + 1);
    }

    private static int safeExtract(final int[][] matrix, final int x, final int y) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix.length) {
            return 0;
        }
        return matrix[x][y];
    }

    private static Data initData(final int maxNumber) {
        final Data data = new Data();
        data.arrayLength = determineSize(maxNumber);
        data.center = getCenter(data.arrayLength);
        data.x = data.center;
        data.y = data.center;
        data.direction = Direction.RIGHT;
        data.directionCounter = 1;
        return data;
    }

    private static int getCenter(final int arrayLength) {
        return (int) Math.ceil(arrayLength / 2.0) - 1;
    }

    private static void move(final Data data, final int i) {
        if (data.direction == Direction.RIGHT) {
            data.x += 1;
            data.directionCounter--;
            if (data.directionCounter == 0) {
                data.direction = Direction.UP;
                // subtract one, because we are already one up when breaking into the next spiral
                data.directionCounter = determineSize(i + 1) - 1 - 1;
            }
        } else if (data.direction == Direction.UP) {
            data.y -= 1;
            data.directionCounter--;
            if (data.directionCounter == 0) {
                data.direction = Direction.LEFT;
                data.directionCounter = determineSize(i + 1) - 1;
            }
        } else if (data.direction == Direction.LEFT) {
            data.x -= 1;
            data.directionCounter--;
            if (data.directionCounter == 0) {
                data.direction = Direction.DOWN;
                data.directionCounter = determineSize(i + 1) - 1;
            }
        } else if (data.direction == Direction.DOWN) {
            data.y += 1;
            data.directionCounter--;
            if (data.directionCounter == 0) {
                data.direction = Direction.RIGHT;
                // add 1, so it can break into the next spiral
                data.directionCounter = determineSize(i + 1) - 1 + 1;
            }
        }
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

    static int solve1(final int number) {
        return getStepsToCenter(number, generateMatrix1(number));
    }

    private static class Data {
        int arrayLength;
        int center;
        int x;
        int y;
        int directionCounter;
        Direction direction;
    }
}

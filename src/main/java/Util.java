import java.util.regex.Pattern;

public class Util {

    public static int[] extractNumbers(final CharSequence numbers, final String delimiter) {
        final String[] split = Pattern.compile(delimiter).split(numbers);
        final int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }
}

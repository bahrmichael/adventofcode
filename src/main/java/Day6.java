import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Day6 {

    static int solve1(final CharSequence text) {
        final Collection<String> seenConfigurations = new HashSet<>();
        int[] array = Util.extractNumbers(text, "\t");

        while (true) {
            final String str = Arrays.toString(array);
            if (seenConfigurations.contains(str)) {
                return seenConfigurations.size();
            }
            array = nextStep(seenConfigurations, array, str);
        }
    }

    static int solve2(final CharSequence text) {
        Collection<String> seenConfigurations = new HashSet<>();
        int[] array = Util.extractNumbers(text, "\t");

        int startLoop;
        while (true) {
            final String str = Arrays.toString(array);
            if (seenConfigurations.contains(str)) {
                startLoop = seenConfigurations.size() - 1;
                seenConfigurations = new HashSet<>();
                break;
            }
            array = nextStep(seenConfigurations, array, str);
        }

        int endLoop;
        while (true) {
            final String str = Arrays.toString(array);
            if (seenConfigurations.contains(str)) {
                endLoop = startLoop + seenConfigurations.size() -1 ;
                break;
            }
            array = nextStep(seenConfigurations, array, str);
        }

        return endLoop - startLoop + 1;
    }

    private static int[] nextStep(final Collection<String> seenConfigurations, int[] array, final String str) {
        array = redistribute(array);
        seenConfigurations.add(str);
        return array;
    }

    static int[] redistribute(final int[] array) {
        int index = getClearanceIndex(array);
        int distributeValue = array[index];
        array[index] = 0;
        while (distributeValue > 0) {
            index++;
            array[index % array.length] += 1;
            distributeValue--;
        }
        return array;
    }

    static int getClearanceIndex(final int[] array) {
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static final String PUZZLE = "14\t0\t15\t12\t11\t11\t3\t5\t1\t6\t8\t4\t9\t1\t8\t4";
}

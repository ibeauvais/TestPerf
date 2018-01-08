import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;

public class TestUtils {

    private static int[] array;

    static {
        System.out.println("Initialisation du random");
        array = new Random().ints(50_000, 50_000, 100_000).toArray();
    }

    public static int[] randomGenerator() {
        return new Random().ints(50_000, 50_000, 100_000).toArray();
    }


    public static void testAveragePerformanceNano(Function<int[], String> functionToTest,
                                                  String prefix,
                                                  int iterationCount) {
        List<Long> values = new ArrayList<>(iterationCount);
        for (int i = 0; i < iterationCount; i++) {
            values.add(getNanoTime(functionToTest, array));
        }
        double fivePercent = 5d / 100 * iterationCount;
        //limit coming after skip, we have to account for the first 5 percent in our calculations
        double ninetyFivePercent = 90d / 100 * iterationCount;

        Collections.sort(values);
        double end = values.stream()
                .skip((long) fivePercent)
                .limit((long) ninetyFivePercent)
                .mapToLong(Long::longValue)
                .average()
                .getAsDouble();

        long ecart = values.get(values.size() - 1) - values.get(0);
        System.out.println("ecart entre la plus grande valeur et la plus petite : " + ecart);
        System.out.println("durée moyenne de " + prefix + end);
    }

    public static void testPerformanceMilli(Function<int[], String> functionToTest, String prefix) {
        long end = getMilliTime(functionToTest, array);
        System.out.println("duration of " + prefix + end);
    }

    public static void randomTestPerformanceMilli(Function<int[], String> functionToTest, String prefix) {
        int[] data = randomGenerator();
        long end = getMilliTime(functionToTest, data);
        System.out.println("duration of " + prefix + end);
    }


    public static void testPerformanceNano(Function<int[], String> functionToTest, String prefix) {
        long end = getNanoTime(functionToTest, array);
        System.out.println("duration of " + prefix + end);
    }


    public static void randomTestPerformanceNano(Function<int[], String> functionToTest, String prefix) {
        int[] data = randomGenerator();
        long end = getNanoTime(functionToTest, data);
        System.out.println("duration of " + prefix + end);
    }

    public static void warmUp(Function<int[], String> functionToTest) {
        for (int i = 0; i < 1_000; i++) {
            int[] data = randomGenerator();
            functionToTest.apply(data);
        }
    }


    private static long getMilliTime(Function<int[], String> functionToTest, int[] data) {
        long time = System.currentTimeMillis();
        functionToTest.apply(data);
        return System.currentTimeMillis() - time;
    }

    private static long getNanoTime(Function<int[], String> functionToTest, int[] data) {
        long nanoTime = System.nanoTime();
        functionToTest.apply(data);
        return System.nanoTime() - nanoTime;
    }


    private static int[] getData() {
        return IntStream.range(1, 100000).toArray();
    }
}

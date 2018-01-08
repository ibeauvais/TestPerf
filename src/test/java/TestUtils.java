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

    public static void testAveragePerformanceMilli(Function<int[], String> functionToTest,
                                                   String prefix,
                                                   int iterationCount) {
        long end = 0;
        for (int i = 0; i < iterationCount; i++) {
            end += getMilliTime(functionToTest, array);
        }

        System.out.println("duration of " + prefix + end / iterationCount);
    }

    public static void testAveragePerformanceNano(Function<int[], String> functionToTest,
                                                  String prefix,
                                                  int iterationCount) {
        long end = 0;
        for (int i = 0; i < iterationCount; i++) {
            end += getNanoTime(functionToTest, array);
        }

        System.out.println("duration of " + prefix + end / iterationCount);
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

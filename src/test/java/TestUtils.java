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

    public static void testPerformanceMilli(Function<int[], String> functionToTest, String prefix) {
        long time = System.currentTimeMillis();
        functionToTest.apply(array);
        long end = System.currentTimeMillis() - time;
        System.out.println("duration of " + prefix + end);
    }

    public static void randomTestPerformanceMilli(Function<int[], String> functionToTest, String prefix) {
        int[] data = randomGenerator();
        long time = System.currentTimeMillis();

        functionToTest.apply(data);
        long end = System.currentTimeMillis() - time;
        System.out.println("duration of " + prefix + end);
    }


    public static void testPerformanceNano(Function<int[], String> functionToTest, String prefix) {
        long nanoTime = System.nanoTime();
        functionToTest.apply(array);
        long end = System.nanoTime() - nanoTime;
        System.out.println("duration of " + prefix + end);
    }


    public static void randomTestPerformanceNano(Function<int[], String> functionToTest, String prefix) {
        int[] data = randomGenerator();
        long nanoTime = System.nanoTime();
        functionToTest.apply(data);
        long end = System.nanoTime() - nanoTime;
        System.out.println("duration of " + prefix + end);
    }

    public static void warmUp(Function<int[], String> functionToTest) {
        for (int i = 0; i < 1_000; i++) {
            int[] data = randomGenerator();
            functionToTest.apply(data);
        }
    }


    private static int[] getData() {
        return IntStream.range(1, 100000).toArray();
    }
}

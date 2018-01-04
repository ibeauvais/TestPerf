import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;

public class TestUtils {

    private static Random random = new Random();

    public static void testPerformanceMilli(Function<int[], String> fonctionToTest, String prefix) {
        long time = System.currentTimeMillis();
        int[] data = getData();

        fonctionToTest.apply(data);
        long end = System.currentTimeMillis() - time;
        System.out.println("duration of " + prefix + end);
    }

    public static void testPerformanceNano(Function<int[], String> fonctionToTest, String prefix) {
        long nanoTime = System.nanoTime();
        int[] data = getData();

        fonctionToTest.apply(data);
        long end = System.nanoTime() - nanoTime;
        System.out.println("duration of " + prefix + end);
    }


    private static int[] getData() {
        return IntStream.range(1, 100000).toArray();
    }
}

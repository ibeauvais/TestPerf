import org.junit.Test;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;

public class PerformanceTest2 {

    @Test
    public void test_performance_implementation_1() {

        test_performance(NumberUtils::transformNumbers1);
    }

    @Test
    public void test_performance_implementation_2() {

        test_performance(NumberUtils::transformNumbers2);
    }

    private void test_performance(Function<int[], String> functionToTest) {

        for (int i = 0; i < 1000; i++) {
            int[] data = getData();
            functionToTest.apply(data);
        }

        int[] data = getData();
        long timeMillis = System.currentTimeMillis();


        functionToTest.apply(data);
        long end = System.currentTimeMillis() - timeMillis;
        System.out.println("duration : " + end);

    }

    private int[] getData() {

        //return new Random(System.currentTimeMillis()).ints(100_000).toArray();
        return IntStream.range(1, 1000).toArray();
    }

}
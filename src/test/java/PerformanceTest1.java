import org.junit.Ignore;
import org.junit.Test;

import java.util.function.Function;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class PerformanceTest1 {

    @Ignore
    @Test
    public void should_return_same_value() {
        int[] data = getData();

        String resultImpl1 = NumberUtils.transformNumbers1(data);
        String resultImpl2 = NumberUtils.transformNumbers2(data);

        assertEquals(resultImpl1, resultImpl2);
    }

    @Test
    public void test_performance_implementation_1() {

        test_performance(NumberUtils::transformNumbers1);
    }

    @Test
    public void test_performance_implementation_2() {

        test_performance(NumberUtils::transformNumbers2);
    }

    private void test_performance(Function<int[], String> fonctionToTest) {
        long timeMillis = System.currentTimeMillis();
        int[] data = getData();

        fonctionToTest.apply(data);
        long end = System.currentTimeMillis() - timeMillis;
        System.out.println("duration : " + end);

    }

    private int[] getData() {
        return IntStream.range(1, 1000).toArray();
    }
}
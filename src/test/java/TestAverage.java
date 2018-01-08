import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestAverage {

    @Parameter
    public int iterationCount;

    @Parameters
    public static Collection<Integer> iterations() {
        Integer[] values = {1000};
        return Arrays.asList(values);
    }


    @Test
    public void test_nano_performance_implementation_1_10() {
        TestUtils.warmUp(NumberUtils::transformNumbers1);
        TestUtils.testAveragePerformanceNano(NumberUtils::transformNumbers1, "Lambda nanoTest " + iterationCount + " : ", iterationCount);
    }

    @Test
    public void test_nano_performance_implementation_2_10() {
        TestUtils.warmUp(NumberUtils::transformNumbers2);
        TestUtils.testAveragePerformanceNano(NumberUtils::transformNumbers2, "for/stringbuilder nanoTest " + iterationCount + " : ", iterationCount);
    }


}
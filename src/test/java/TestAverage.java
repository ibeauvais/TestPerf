import org.junit.Test;

public class TestAverage {


    @Test
    public void test_nano_performance_implementation_1() {
        TestUtils.warmUp(NumberUtils::transformNumbers1);
        TestUtils.testAveragePerformanceNano(NumberUtils::transformNumbers1, "Lambda nanoTest : ", 1000);
    }

    @Test
    public void test_nano_performance_implementation_2() {
        TestUtils.warmUp(NumberUtils::transformNumbers2);
        TestUtils.testAveragePerformanceNano(NumberUtils::transformNumbers2, "for/stringbuilder nanoTest : ", 1000);
    }

}
import jmh.NumberUtils;
import org.junit.Test;

public class TestWithWarmupData {


    @Test
    public void test_milli_performance_implementation_1() {
        TestUtils.warmUp(NumberUtils::transformNumbers1);
        TestUtils.testPerformanceMilli(NumberUtils::transformNumbers1, "Lambda millitest : ");
    }

    @Test
    public void test_milli_performance_implementation_2() {
        TestUtils.warmUp(NumberUtils::transformNumbers2);
        TestUtils.testPerformanceMilli(NumberUtils::transformNumbers2, "for/stringbuilder milliTest : ");
    }

    @Test
    public void test_nano_performance_implementation_1() {
        TestUtils.warmUp(NumberUtils::transformNumbers1);
        TestUtils.testPerformanceNano(NumberUtils::transformNumbers1, "Lambda nanoTest : ");
    }

    @Test
    public void test_nano_performance_implementation_2() {
        TestUtils.warmUp(NumberUtils::transformNumbers2);
        TestUtils.testPerformanceNano(NumberUtils::transformNumbers2, "for/stringbuilder nanoTest : ");
    }


    @Test
    public void random_test_milli_performance_implementation_1() {
        TestUtils.warmUp(NumberUtils::transformNumbers1);
        TestUtils.randomTestPerformanceMilli(NumberUtils::transformNumbers1, "Lambda millitest random : ");
    }

    @Test
    public void random_test_milli_performance_implementation_2() {
        TestUtils.warmUp(NumberUtils::transformNumbers2);
        TestUtils.randomTestPerformanceMilli(NumberUtils::transformNumbers2, "for/stringbuilder milliTest  random : ");
    }

    @Test
    public void random_test_nano_performance_implementation_1() {
        TestUtils.warmUp(NumberUtils::transformNumbers1);
        TestUtils.randomTestPerformanceNano(NumberUtils::transformNumbers1, "Lambda nanoTest  random : ");
    }

    @Test
    public void random_test_nano_performance_implementation_2() {
        TestUtils.warmUp(NumberUtils::transformNumbers2);
        TestUtils.randomTestPerformanceNano(NumberUtils::transformNumbers2, "for/stringbuilder nanoTest  random : ");
    }


}
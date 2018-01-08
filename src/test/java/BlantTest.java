import org.junit.Test;

public class BlantTest {

    @Test
    public void test_milli_performance_implementation_1() {
        TestUtils.testPerformanceMilli(NumberUtils::transformNumbers1, "Lambda millitest : ");
    }

    @Test
    public void test_milli_performance_implementation_2() {
        TestUtils.testPerformanceMilli(NumberUtils::transformNumbers2, "for/stringbuilder milliTest : ");
    }

    @Test
    public void test_nano_performance_implementation_1() {
        TestUtils.testPerformanceNano(NumberUtils::transformNumbers1, "Lambda nanoTest : ");
    }

    @Test
    public void test_nano_performance_implementation_2() {
        TestUtils.testPerformanceNano(NumberUtils::transformNumbers2, "for/stringbuilder nanoTest : ");
    }

}
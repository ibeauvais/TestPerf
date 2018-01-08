package jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;


@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(value = 3, jvmArgsAppend = {"-XX:+UseParallelGC", "-Xms1g", "-Xmx1g"})
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class JMHTest {
    private static int[] array;

    @Param({"0", "10", "100", "1000", "10000", "100000"})
    int size;

    @Setup
    public void setup() {
        array = new Random().ints(size, 50_000, 100_000_000).toArray();
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHTest.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }


    @Benchmark
    public String test_performance_implementation_1() {
        return NumberUtils.transformNumbers1(array);
    }

    @Benchmark
    public String test_performance_implementation_2() {
        return NumberUtils.transformNumbers2(array);
    }


}

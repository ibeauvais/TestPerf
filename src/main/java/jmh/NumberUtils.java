package jmh;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberUtils {

    public static String transformNumbers1(int[] numbers) {

        return IntStream.of(numbers)
                .filter(value -> value % 2 == 0)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));

    }

    public static String transformNumbers2(int[] numbers) {
        StringBuilder result = new StringBuilder();
        for (Integer number : numbers) {
            if (number % 2 != 0) {
                continue;
            }

            if (result.length() > 0) {
                result.append(",");
            }
            result.append(number );

        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9};
        double average = Arrays.stream(values).skip(2).limit(6).count();
        System.out.println("average : " + average);
    }
}

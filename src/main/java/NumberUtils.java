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
}

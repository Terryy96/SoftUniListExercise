import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int[] numsOp = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        int num = numsOp[0];
        int power = numsOp[1];
        while (numbers.contains(num)) {
            int bombIndex = numbers.indexOf(num);
                int start = Math.max(0, bombIndex - power);
                int end = Math.min(numbers.size() - 1, bombIndex + power);

                for (int j = end; j>= start; j--) {
                    numbers.remove(j);
                }
            }


        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}

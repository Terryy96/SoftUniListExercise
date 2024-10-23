import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        Collections.reverse(input);

        System.out.println(input.toString()//["  7  8", "4 5 6 ", "1 2 3 "]
                .replace("[", "")//"  7  8", "4 5 6 ", "1 2 3 "]
                .replace("]", "")//["  7  8", "4 5 6 ", "1 2 3 "
                .replaceAll(",", "")//"  7  8" "4 5 6 " "1 2 3 "
                .replaceAll("\\s+", " ")
                .trim());//7  8 4 5 6  1 2 3
    }
}

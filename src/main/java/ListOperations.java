import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] command = input.split(" ");
            if (command[0].equals("Add")){
                int numToAdd = Integer.parseInt(command[1]);
                numbers.add(numToAdd);
            }else if (command[0].equals("Insert")) {
                int numToInsert = Integer.parseInt(command[1]);
                int index = Integer.parseInt(command[2]);
                if (index >= 0 && index < numbers.size()) {
                    numbers.add(index, numToInsert);
                } else {
                    System.out.println("Invalid index");
                }
            }else if (command[0].equals("Remove")) {
                int indexToRemove = Integer.parseInt(command[1]);
                if (indexToRemove >= 0 && indexToRemove < numbers.size()) {
                    numbers.remove(indexToRemove);
                } else {
                    System.out.println("Invalid index");
                }
            }else if (command[1].equals("left")) {
                int numberToMove = Integer.parseInt(command[2]);
                shiftLeft(numbers, numberToMove);
            }else if (command[1].equals("right")) {
                int numberToMove = Integer.parseInt(command[2]);
                shiftRight(numbers, numberToMove);

            }

            input= scanner.nextLine();
        }

        for (int number : numbers){
            System.out.print(number + " ");
        }
    }

    private static void shiftLeft(List<Integer> numbers, int count) {
        int realCount = count % numbers.size(); // To handle over-shifting
        for (int i = 0; i < realCount; i++) {
            int firstNumber = numbers.remove(0); // Remove first element
            numbers.add(firstNumber); // Add it to the end
        }
    }
    private static void shiftRight(List<Integer> numbers, int count) {
        int realCount = count % numbers.size(); // To handle over-shifting
        for (int i = 0; i < realCount; i++) {
            int lastNumber = numbers.remove(numbers.size() - 1); // Remove last element
            numbers.add(0, lastNumber); // Add it to the beginning
        }
    }
}

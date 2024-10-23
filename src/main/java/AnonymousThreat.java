import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnonymousThreat {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<String> strings = new ArrayList<>();
        for (String str : input) {
            strings.add(str);
        }

        String command = scanner.nextLine();
        while (!command.equals("3:1")) {
            String[] parts = command.split(" ");
            String action = parts[0];

            if (action.equals("merge")) {
                int startIndex = Math.max(0, Integer.parseInt(parts[1]));
                int endIndex = Math.min(strings.size() - 1, Integer.parseInt(parts[2]));

                if (startIndex <= endIndex) {
                    StringBuilder mergedString = new StringBuilder();
                    for (int i = startIndex; i <= endIndex; i++) {
                        mergedString.append(strings.get(i));
                    }
                    for (int i = endIndex; i >= startIndex; i--) {
                        strings.remove(i);
                    }
                    strings.add(startIndex, mergedString.toString());
                }

            } else if (action.equals("divide")) {
                int index = Integer.parseInt(parts[1]);
                int partitions = Integer.parseInt(parts[2]);

                if (index >= 0 && index < strings.size()) {
                    String elementToDivide = strings.get(index);
                    strings.remove(index);

                    int partSize = elementToDivide.length() / partitions;
                    int remainder = elementToDivide.length() % partitions;

                    List<String> dividedParts = new ArrayList<>();
                    int currentIndex = 0;

                    for (int i = 0; i < partitions; i++) {
                        if (i == partitions - 1) {
                            dividedParts.add(elementToDivide.substring(currentIndex));
                        } else {
                            int currentPartSize = partSize + (remainder > 0 ? 1 : 0);
                            remainder--;
                            dividedParts.add(elementToDivide.substring(currentIndex, currentIndex + currentPartSize));
                            currentIndex += currentPartSize;
                        }
                    }

                    strings.addAll(index, dividedParts);
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join(" ", strings));
    }
}

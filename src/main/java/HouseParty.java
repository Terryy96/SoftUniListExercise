import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> people = new ArrayList<>();

        for (int i = 0; i <n ; i++) {
            String input = scanner.nextLine();
            String [] commands = input.split(" ");
            String name = commands[0];
            String isNot = commands [2];

            if (isNot.equals("going!")){
                if (people.contains(name)){
                    System.out.printf("%s is already in the list!", name);
                    System.out.println();
                }else {
                    people.add(name);
                }
            }else if (isNot.equals("not")){
                if (people.contains(name)){
                    people.remove(name);
                }else {
                    System.out.printf("%s is not in the list!", name);
                    System.out.println();
                }
            }
        }
        for (String person : people){
            System.out.println(person);
        }
    }
}

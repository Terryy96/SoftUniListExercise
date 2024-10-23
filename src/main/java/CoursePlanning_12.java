import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CoursePlanning_12 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Reading the initial schedule
            List<String> schedule = new ArrayList<>();
            String[] initialSchedule = scanner.nextLine().split(", ");
            for (String lesson : initialSchedule) {
                schedule.add(lesson);
            }

            String input;
            while (!(input = scanner.nextLine()).equals("course start")) {
                String[] commandParts = input.split(":");
                String command = commandParts[0];
                String lessonTitle;

                switch (command) {
                    case "Add":
                        lessonTitle = commandParts[1];
                        if (!schedule.contains(lessonTitle)) {
                            schedule.add(lessonTitle);
                        }
                        break;

                    case "Insert":
                        lessonTitle = commandParts[1];
                        int index = Integer.parseInt(commandParts[2]);
                        if (!schedule.contains(lessonTitle) && index >= 0 && index < schedule.size()) {
                            schedule.add(index, lessonTitle);
                        }
                        break;

                    case "Remove":
                        lessonTitle = commandParts[1];
                        schedule.remove(lessonTitle);
                        schedule.remove(lessonTitle + "-Exercise"); // Remove the corresponding exercise if present
                        break;

                    case "Swap":
                        String firstLesson = commandParts[1];
                        String secondLesson = commandParts[2];
                        if (schedule.contains(firstLesson) && schedule.contains(secondLesson)) {
                            int firstIndex = schedule.indexOf(firstLesson);
                            int secondIndex = schedule.indexOf(secondLesson);

                            // Swap the lessons
                            schedule.set(firstIndex, secondLesson);
                            schedule.set(secondIndex, firstLesson);

                            // Swap exercises if they exist
                            if (schedule.contains(firstLesson + "-Exercise")) {
                                schedule.remove(firstLesson + "-Exercise");
                                schedule.add(secondIndex + 1, firstLesson + "-Exercise");
                            }
                            if (schedule.contains(secondLesson + "-Exercise")) {
                                schedule.remove(secondLesson + "-Exercise");
                                schedule.add(firstIndex + 1, secondLesson + "-Exercise");
                            }
                        }
                        break;

                    case "Exercise":
                        lessonTitle = commandParts[1];
                        if (schedule.contains(lessonTitle)) {
                            int lessonIndex = schedule.indexOf(lessonTitle);
                            if (!schedule.contains(lessonTitle + "-Exercise")) {
                                schedule.add(lessonIndex + 1, lessonTitle + "-Exercise");
                            }
                        } else {
                            schedule.add(lessonTitle);
                            schedule.add(lessonTitle + "-Exercise");
                        }
                        break;

                    default:
                        System.out.println("Invalid command!");
                }
            }

            // Print the final schedule
            for (int i = 0; i < schedule.size(); i++) {
                System.out.println((i + 1) + "." + schedule.get(i));

        }
    }
}

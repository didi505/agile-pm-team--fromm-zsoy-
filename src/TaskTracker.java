import java.util.ArrayList;
import java.util.Scanner;

public class TaskTracker {

    static ArrayList<String> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Task Tracker ---");
            System.out.println("1. Task hinzufügen");
            System.out.println("2. Tasks anzeigen");
            System.out.println("3. Task löschen");
            System.out.println("4. Beenden");

            int choice = scanner.nextInt();
            scanner.nextLine(); // wichtig!

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    showTasks();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    System.out.println("Programm beendet.");
                    return;
                default:
                    System.out.println("Ungültige Eingabe.");
            }
        }
    }

    static void addTask() {
        System.out.println("Task eingeben:");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task hinzugefügt!");
    }

    static void showTasks() {
        System.out.println("\nAlle Tasks:");
        if (tasks.isEmpty()) {
            System.out.println("Keine Tasks vorhanden.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    static void deleteTask() {
        showTasks();
        System.out.println("Nummer des Tasks zum Löschen:");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task gelöscht.");
        } else {
            System.out.println("Ungültige Nummer.");
        }
    }
}

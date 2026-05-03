import java.util.ArrayList;
import java.util.Scanner;

public class TaskTracker {

    static ArrayList<String> tasks = new ArrayList<>();
    static ArrayList<String> status = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Task Tracker ---");
            System.out.println("1. Task hinzufügen");
            System.out.println("2. Tasks anzeigen");
            System.out.println("3. Task löschen");
            System.out.println("4. Status ändern");
            System.out.println("5. Beenden");

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
                    changeStatus();
                    break;
                case 5:
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
        status.add("Offen");
        System.out.println("Task hinzugefügt!");
    }

    static void showTasks() {
        System.out.println("\nAlle Tasks:");
        if (tasks.isEmpty()) {
            System.out.println("Keine Tasks vorhanden.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i) + " [" + status.get(i) + "]");
            }
        }
    }

    static void deleteTask() {
        showTasks();
        System.out.println("Nummer des Tasks zum Löschen:");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            status.remove(index);
            System.out.println("Task gelöscht.");
        } else {
            System.out.println("Ungültige Nummer.");
        }
    }

    static void changeStatus() {
        showTasks();
        System.out.println("Nummer des Tasks:");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < tasks.size()) {
            System.out.println("Neuer Status (Offen/In Arbeit/Erledigt):");
            String newStatus = scanner.nextLine();
            status.set(index, newStatus);
            System.out.println("Status geändert!");
        } else {
            System.out.println("Ungültige Nummer.");
        }
    }
}

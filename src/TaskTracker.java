import java.util.ArrayList;
import java.util.Scanner;

public class TaskTracker {

    static ArrayList<String> tasks = new ArrayList<>(); // speichert die aufgaben
    static ArrayList<String> status = new ArrayList<>(); // speichert den Status 
    static Scanner scanner = new Scanner(System.in); // liest Eingabe vom Benutzer 

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Task Tracker ---");  //Menü anzeige für Benutzer
            System.out.println("1. Task hinzufügen");
            System.out.println("2. Tasks anzeigen");
            System.out.println("3. Task löschen");
            System.out.println("4. Status ändern");
            System.out.println("5. Beenden");

            int choice = scanner.nextInt();
            scanner.nextLine(); // wichtig! entfernt enter taste aus dem speicher 

            switch (choice) {  // entscheidet was passiert 
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
                    System.out.println("Programm beendet."); // stoppt 
                    return;
                default:
                    System.out.println("Ungültige Eingabe.");
            }
        }
    }

    static void addTask() { // benutzer gibt task ein, task wird gespeichert und status ist automatisch offen
        System.out.println("Task eingeben:");
        String task = scanner.nextLine();
        tasks.add(task);
        status.add("Offen");
        System.out.println("Task hinzugefügt!");
    }

    static void showTasks() { // zeigt alle Tasks
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
        showTasks(); // tasks werde angezeigt
        System.out.println("Nummer des Tasks zum Löschen:");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < tasks.size()) { // benutzer wählt nummer und task wird gelöscht 
            tasks.remove(index);
            status.remove(index);
            System.out.println("Task gelöscht.");
        } else {
            System.out.println("Ungültige Nummer.");
        }
    }

    static void changeStatus() {
        showTasks(); // wählt task , gibt neuen stauts ein wird geändert
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

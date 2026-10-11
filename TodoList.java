
package todolist;

import java.util.Scanner;

public class TodoList {
    public static void main(String[] args) {
        TaskManager_1 manager = new TaskManager_1();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Yapilacaklar Listesi ---");
            System.out.println("1. Gorev ekle");
            System.out.println("2. Gorevleri listele");
            System.out.println("3. Gorevi tamamla");
            System.out.println("4. G0revi sil");
            System.out.println("0. Cikis");
            System.out.print("Secimin: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Gorev basligi: ");
                    manager.addTask(scanner.nextLine());
                    break;
                case "2":
                    manager.listTasks();
                    break;
                case "3":
                    System.out.print("Tamamlanacak gorev numarasi: ");
                    int doneNo = Integer.parseInt(scanner.nextLine());
                    if (!manager.completeTask(doneNo - 1)) {
                        System.out.println("Gecersiz numara.");
                    }
                    break;
                case "4":
                    System.out.print("Silinecek gorev numarasi: ");
                    int delNo = Integer.parseInt(scanner.nextLine());
                    if (!manager.removeTask(delNo - 1)) {
                        System.out.println("Gecersiz numara.");
                    }
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Gecersiz secim.");
            }
        }
        scanner.close();
    }
}
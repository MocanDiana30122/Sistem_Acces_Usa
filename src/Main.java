import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoorLookControler controller = new DoorLookControler();
        Door door = new Door(); // Instanțiază ușa

        while (true) {
            System.out.println("\n1. Adauga chirias");
            System.out.println("2. Cauta chirias");
            System.out.println("3. Listare chiriasi");
            System.out.println("4. Deschide usa pentru chirias");
            System.out.println("5. Iesire");
            System.out.print("Alege o optiune: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumam newline-ul ramas

            switch (choice) {
                case 1: // Adauga chirias
                    System.out.print("Introdu numele chiriasului: ");
                    String name = scanner.nextLine();
                    Chirias newTenant = new Chirias(name);
                    try {
                        controller.addTenant(newTenant);
                        System.out.println("Chirias adaugat: " + name);
                    } catch (TenantAlreadyExistsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2: // Cauta chirias
                    System.out.print("Introdu numele chiriasului de cautat: ");
                    String searchName = scanner.nextLine();
                    try {
                        Chirias foundTenant = controller.findTenant(searchName);
                        System.out.println("Chirias gasit: " + foundTenant);
                    } catch (TenantNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3: // Listare chiriasi
                    controller.listTenants();
                    break;

                case 4: // Deschide usa pentru chirias
                    System.out.print("Introdu numele chiriasului pentru a deschide usa: ");
                    String tenantName = scanner.nextLine();
                    try {
                        Chirias tenantToOpenDoor = controller.findTenant(tenantName);
                        door.openDoor(tenantToOpenDoor);
                    } catch (TenantNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5: // Iesire
                    System.out.println("Iesire din aplicatie...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Optiune invalida. Te rog, alege din nou.");
            }
        }
    }
}

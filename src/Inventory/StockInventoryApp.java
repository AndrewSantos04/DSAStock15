package inventory;

import java.util.Scanner;

public class StockInventoryApp {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        // ✅ Insert Sample Stock Items
        inventoryManager.addStock("Yamaha", "YZF-R3", 10);
        inventoryManager.addStock("Honda", "CBR500R", 15);
        inventoryManager.addStock("Kawasaki", "Ninja 400", 8);
        inventoryManager.addStock("Suzuki", "GSX250R", 12);

        System.out.println("🚀 Welcome to MotorPH Inventory System");

        // ✅ Menu Loop for Navigation
        while (true) {
            System.out.println("\n📊 Choose an action:");
            System.out.println("1. Add Stock");
            System.out.println("2. Search Stock");
            System.out.println("3. Delete Stock");
            System.out.println("4. Display Unsorted Inventory");
            System.out.println("5. Display Sorted Inventory");
            System.out.println("6. Exit");
            System.out.print("👉 Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("📦 Enter brand: ");
                    String brand = scanner.nextLine();
                    System.out.print("📦 Enter model: ");
                    String model = scanner.nextLine();
                    System.out.print("📦 Enter quantity: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    inventoryManager.addStock(brand, model, qty);
                    System.out.println("✅ Stock added successfully!");
                    break;

                case 2:
                    System.out.print("🔍 Enter brand to search: ");
                    String searchBrand = scanner.nextLine();
                    System.out.print("🔍 Enter model to search: ");
                    String searchModel = scanner.nextLine();
                    StockItem foundItem = inventoryManager.searchStock(searchBrand, searchModel);
                    if (foundItem != null) {
                        System.out.println("✅ Found: " + foundItem);
                    } else {
                        System.out.println("❌ Stock not found!");
                    }
                    break;

                case 3:
                    System.out.print("🗑️ Enter brand to delete: ");
                    String deleteBrand = scanner.nextLine();
                    System.out.print("🗑️ Enter model to delete: ");
                    String deleteModel = scanner.nextLine();
                    inventoryManager.deleteStock(deleteBrand, deleteModel);
                    System.out.println("✅ Stock deleted successfully!");
                    break;

                case 4:
                    inventoryManager.displayInventory();
                    break;

                case 5:
                    inventoryManager.displaySortedInventory();
                    break;

                case 6:
                    System.out.println("👋 Exiting... Thank you!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        }
    }
}

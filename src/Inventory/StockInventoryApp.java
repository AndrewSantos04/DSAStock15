package inventory;

import java.util.Scanner;

public class StockInventoryApp {
    public static void main(String[] args) {
        // ✅ Create BST & Hash Table Inventory
        StockBST inventoryBST = new StockBST();
        InventoryHashTable inventoryHash = new InventoryHashTable();
        Scanner scanner = new Scanner(System.in);

        // ✅ 1. Insert sample stock items (BST & Hash Table)
        System.out.println("\n📌 Inserting Sample Stock Items...");
        inventoryBST.insert("Yamaha", "YZF-R3", 10);
        inventoryBST.insert("Honda", "CBR500R", 15);
        inventoryBST.insert("Kawasaki", "Ninja 400", 8);
        inventoryBST.insert("Suzuki", "GSX250R", 12);

        inventoryHash.addStock("Yamaha", "YZF-R3", 10);
        inventoryHash.addStock("Honda", "CBR500R", 15);
        inventoryHash.addStock("Kawasaki", "Ninja 400", 8);
        inventoryHash.addStock("Suzuki", "GSX250R", 12);

        // ✅ 2. Display inventory before sorting
        System.out.println("\n📌 MotorPH Inventory (BST - Unsorted):");
        inventoryBST.displayStock();

        System.out.println("\n📌 MotorPH Inventory (Hash Table):");
        inventoryHash.displayInventory();

        // ✅ 3. Search for a stock item (BST)
        System.out.print("\n🔍 Enter brand to search (BST): ");
        String searchBrand = scanner.nextLine();
        StockNode foundStockBST = inventoryBST.search(searchBrand);

        if (foundStockBST != null) {
            System.out.println("✅ Stock Found (BST) -> Brand: " + foundStockBST.brand + ", Model: " + foundStockBST.model + ", Quantity: " + foundStockBST.quantity);
        } else {
            System.out.println("❌ Stock not found in BST.");
        }

        // ✅ 4. Search for a stock item (Hash Table)
        System.out.print("\n🔍 Enter brand to search (Hash Table): ");
        String searchHashBrand = scanner.nextLine();
        System.out.print("🔍 Enter model to search (Hash Table): ");
        String searchHashModel = scanner.nextLine();
        StockItem foundStockHash = inventoryHash.searchStock(searchHashBrand, searchHashModel);

        if (foundStockHash != null) {
            System.out.println("✅ Stock Found (Hash Table) -> " + foundStockHash);
        } else {
            System.out.println("❌ Stock not found in Hash Table.");
        }

        // ✅ 5. Delete a stock item (BST)
        System.out.print("\n🗑️ Enter brand to delete (BST): ");
        String deleteBrandBST = scanner.nextLine();
        inventoryBST.delete(deleteBrandBST);

        // ✅ 6. Delete a stock item (Hash Table)
        System.out.print("\n🗑️ Enter brand to delete (Hash Table): ");
        String deleteHashBrand = scanner.nextLine();
        System.out.print("🗑️ Enter model to delete (Hash Table): ");
        String deleteHashModel = scanner.nextLine();
        inventoryHash.deleteStock(deleteHashBrand, deleteHashModel);

        // ✅ 7. Display updated inventory after deletion
        System.out.println("\n📌 Updated Inventory after Deletion (BST):");
        inventoryBST.displayStock();

        System.out.println("\n📌 Updated Inventory after Deletion (Hash Table):");
        inventoryHash.displayInventory();

        // ✅ 8. Sort stock items (BST)
        System.out.println("\n📌 Sorting Stock by Brand (BST)...");
        inventoryBST.sortStockByBrand();

        // ✅ 9. Display sorted inventory (BST)
        System.out.println("\n📌 Sorted Inventory (BST):");
        inventoryBST.displayStock();

        scanner.close();
    }
}
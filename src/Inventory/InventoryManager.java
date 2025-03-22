/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;

import java.util.*;

public class InventoryManager {
    private HashMap<String, StockItem> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    // ✅ Add stock item
    public void addStock(String brand, String model, int qty) {
        String key = brand + "-" + model;  // Hash key
        inventory.put(key, new StockItem(brand, model, qty));
    }

    // ✅ Search for a stock item
    public StockItem searchStock(String brand, String model) {
        return inventory.get(brand + "-" + model);
    }

    // ✅ Delete stock item
    public void deleteStock(String brand, String model) {
        String key = brand + "-" + model;
        inventory.remove(key);
    }

    // ✅ Display all stock items (Unsorted)
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("\n📌 Current Stock Inventory (Unsorted):");
            for (StockItem item : inventory.values()) {
                System.out.println(item);
            }
        }
    }

    // ✅ Display inventory sorted by brand and model
    public void displaySortedInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("\n📌 Sorted Stock Inventory (by Brand & Model):");

        // Convert values to a list and sort it
        List<StockItem> sortedList = new ArrayList<>(inventory.values());
        sortedList.sort(Comparator.comparing(StockItem::getBrand)
                .thenComparing(StockItem::getModel));

        for (StockItem item : sortedList) {
            System.out.println(item);
        }
    }
}

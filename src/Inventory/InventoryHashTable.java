/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;

import java.util.HashMap;

public class InventoryHashTable {
    private HashMap<String, StockItem> inventory;

    public InventoryHashTable() {
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

    // ✅ Display all stock items
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("\n📌 Current Stock Inventory:");
            for (StockItem item : inventory.values()) {
                System.out.println(item);
            }
        }
    }
}

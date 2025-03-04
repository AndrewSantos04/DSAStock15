/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;

public class StockNode {
    String brand;
    String model;
    int quantity;
    StockNode left, right;

    // Constructor
    public StockNode(String brand, String model, int quantity) {
        this.brand = brand;
        this.model = model;
        this.quantity = quantity;
        this.left = this.right = null;
    }
}

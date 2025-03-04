/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;

class StockItem {
    String brand;
    String model;
    int quantity;

    public StockItem(String brand, String model, int quantity) {
        this.brand = brand;
        this.model = model;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + ", Model: " + model + ", Quantity: " + quantity;
    }
}
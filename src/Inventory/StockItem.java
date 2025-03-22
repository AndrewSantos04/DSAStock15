/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;

public class StockItem {
    String brand;
    String model;
    int quantity;

    public StockItem(String brand, String model, int quantity) {
        this.brand = brand;
        this.model = model;
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + ", Model: " + model + ", Quantity: " + quantity;
    }
}

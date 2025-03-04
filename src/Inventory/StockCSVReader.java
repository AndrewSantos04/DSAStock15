/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory; // Make sure this matches your folder name (case-sensitive)

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StockCSVReader {
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\Carl Warren\\Downloads\\motorph.csv"; // Path to your CSV file
        String line;
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read header
            String header = br.readLine();
            System.out.println("Headers: " + header);

            // Read and print data
            while ((line = br.readLine()) != null) {
                String[] stockData = line.split(delimiter);
                System.out.println("Item ID: " + stockData[0] + ", Name: " + stockData[1]);
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }
}

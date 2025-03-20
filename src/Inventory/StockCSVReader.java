/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory; // Make sure this matches your folder name (case-sensitive)

import java.io.BufferedReader; //Efficiently reads text from a character-input stream (faster for large files).
import java.io.FileReader; //Reads the contents of a file as a stream of characters.
import java.io.IOException; //Handles input/output errors (e.g., missing file, permission iss

public class StockCSVReader { //where execution begins. Without this method, your Java class can't run as an application.
    public static void main(String[] args) {
        String csvFile = "C:\\Users\\Carl Warren\\Downloads\\motorph.csv"; // Path to your CSV file, CSV file as a string.
        String line;
        String delimiter = ","; //Specifies the delimiter used in the CSV file (in this case, a comma ,).

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read header
            String header = br.readLine(); //reads the first line (the header) of the CSV file.
            System.out.println("Headers: " + header); //prints the headers to the console.
            //This shows the column names, which helps you understand the data structure.

            // Read and print data
            while ((line = br.readLine()) != null) { //Iterates through the CSV file line by line.
                String[] stockData = line.split(delimiter); //Splits each line into parts using the comma.
                System.out.println("Item ID: " + stockData[0] + ", Name: " + stockData[1]); //stockData[0] and stockData[1] refer to the first and second columns.
            }
        } catch (IOException e) { //Catches IOException errors (e.g., missing file, permission issues).
            System.out.println("Error reading CSV file: " + e.getMessage()); //error message
        }
    }
}

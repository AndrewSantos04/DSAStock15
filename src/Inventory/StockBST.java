/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory; //This organizes your class under the inventory package

import java.util.ArrayList;
import java.util.List;


public class StockBST {
    private StockNode root;
    ////This code uses two custom classes: StockBST – Manages the inventory using a BST. StockNode – Represents each stock item (not included here but assumed to exist).
    ///
    // Insert a new stock item into BST
    public void insert(String brand, String model, int quantity) {
        root = insertRec(root, brand, model, quantity);
        //insertRec() is a recursive helper method: current node is null, create a new node.
        //Compare the brand: If smaller, insert in the left subtree. If larger, insert in the right subtree. recursion? It simplifies navigation and insertion.
    }

    private StockNode insertRec(StockNode node, String brand, String model, int quantity) {
        if (node == null) {
            return new StockNode(brand, model, quantity);
        }

        if (brand.compareToIgnoreCase(node.brand) < 0) {
            node.left = insertRec(node.left, brand, model, quantity);
        } else if (brand.compareToIgnoreCase(node.brand) > 0) {
            node.right = insertRec(node.right, brand, model, quantity);
        }
        return node;
    }

    // Convert BST to an ArrayList using In-order Traversal
    private void bstToArrayList(StockNode node, List<StockNode> stockList) {
        if (node != null) {
            bstToArrayList(node.left, stockList);
            stockList.add(node);
            bstToArrayList(node.right, stockList);
        }
    }
   /*This method recursively converts the BST into an ArrayList:

Traverse left subtree (smaller values).
Add the node to the list.
Traverse right subtree (larger values).*/
    
public StockNode search(String brand) {
    return searchRec(root, brand);
} //If the node is null or the brand matches, return the node. If the brand is smaller, search the left subtree. If the brand is larger, search the right subtree.

private StockNode searchRec(StockNode node, String brand) {
    if (node == null || node.brand.equalsIgnoreCase(brand)) {
        return node;
    }
    return (brand.compareToIgnoreCase(node.brand) < 0)
            ? searchRec(node.left, brand)
            : searchRec(node.right, brand);
}

    // Merge Sort Algorithm for Sorting Stocks
    private void mergeSort(List<StockNode> stockList, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(stockList, left, mid);
            mergeSort(stockList, mid + 1, right);
            merge(stockList, left, mid, right);
        }
    }

    private void merge(List<StockNode> stockList, int left, int mid, int right) {
        List<StockNode> leftArray = new ArrayList<>(stockList.subList(left, mid + 1));
        List<StockNode> rightArray = new ArrayList<>(stockList.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;
        while (i < leftArray.size() && j < rightArray.size()) {
            if (leftArray.get(i).brand.compareToIgnoreCase(rightArray.get(j).brand) <= 0) {
                stockList.set(k++, leftArray.get(i++));
            } else {
                stockList.set(k++, rightArray.get(j++));
            }
        }

        while (i < leftArray.size()) {
            stockList.set(k++, leftArray.get(i++));
        }
        while (j < rightArray.size()) {
            stockList.set(k++, rightArray.get(j++));
        }
    }
    
    public void displayStock() {
    displayStockRec(root);
}//uses in-order traversal (left → root → right). It prints the stock in alphabetical order by brand.

private void displayStockRec(StockNode node) {
    if (node != null) {
        displayStockRec(node.left);
        System.out.println("Brand: " + node.brand + ", Model: " + node.model + ", Quantity: " + node.quantity);
        displayStockRec(node.right);
    }
}

    public void delete(String brand) {
    root = deleteStock(root, brand);
}
    
  /*No children (leaf node) – Simply remove the node.
One child – Replace node with its child.
Two children – Find in-order successor (smallest node in the right subtree) to replace the node.
    Each case ensures the BST remains valid after deletion.*/

private StockNode deleteStock(StockNode root, String brand) {
    if (root == null) return root;

    // Navigate the tree to find the node
    if (brand.compareToIgnoreCase(root.brand) < 0) {
        root.left = deleteStock(root.left, brand);
    } else if (brand.compareToIgnoreCase(root.brand) > 0) {
        root.right = deleteStock(root.right, brand);
    } else {
        // Case 1: Node has no children
        if (root.left == null && root.right == null) {
            return null;
        }
        // Case 2: Node has one child
        else if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }
        // Case 3: Node has two children (Find in-order successor)
        StockNode successor = findMin(root.right);
        root.brand = successor.brand;
        root.model = successor.model;
        root.quantity = successor.quantity;

        // Delete the in-order successor
        root.right = deleteStock(root.right, successor.brand);
    }
    return root;
}

// Helper function to find the minimum value node
private StockNode findMin(StockNode node) {
    while (node.left != null) {
        node = node.left;
    }
    return node;
}

    // Sort stock items by brand
    public void sortStockByBrand() {
        List<StockNode> stockList = new ArrayList<>();
        bstToArrayList(root, stockList);
        mergeSort(stockList, 0, stockList.size() - 1);

        System.out.println("\nSorted Stock Items (by brand):");
        for (StockNode stock : stockList) {
            System.out.println("Brand: " + stock.brand + ", Model: " + stock.model + ", Quantity: " + stock.quantity);
        }
    }
}




package inventorymanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Christopher Sherrill
 */
public class Product {
    
    private ObservableList<Part> parts = FXCollections.observableArrayList();
    private int productID;
    private String name;
    private double price;
    private int instock;
    private int min;
    private int max;
    private static int counter; // Created for Autogen of partID, so that same partID can't be used
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setInstock(int instock) {
        this.instock = instock;
    }

    public int getInstock() {
        return instock;
    }

    public void setMin(int min) {
        this.min = min;
    }
    
    public int getMin() {
        return min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMax() {
        return max;
    }
    
    // Add Part associated with this product
    public void addPart(Part part) {
        this.parts.add(part);
    }

    // Get Parts associated with this product
    public ObservableList<Part> getParts() {
        return parts;
    }
    
    // Remove parts association with this product
    public boolean removePart(int partID) {
        int i = 0;
            while(i < this.parts.size()) {
                Part part = this.parts.get(i);
                if(part.getPartID() == partID) {
                    this.parts.remove(i);
                    System.out.println("Removed");
                    return true;
                }
                else {
                    i++;
                }
            }
        return false;
    }
    
    // Lookup Part
    public Part lookupPart(int partID) {
        int i = 0;
            while(i < this.parts.size()) {
                Part part = this.parts.get(i);
                if(part.getPartID() == partID) {
                    System.out.println("Found part");
                    return part;
                }
                else {
                    i++;
                }
            }
        return null;
    }
    
    // Update Part
    public void updatePart(int partID, Part updatedPart) {
        int i = 0;
            while(i < this.parts.size()) {
                Part part = this.parts.get(i);
                if(part.getPartID() == partID) {
                    this.parts.set(i, updatedPart);
                    System.out.println("Updated part");
                }
                else {
                    i++;
                }
        }
    }
    
    // Void since it is auto generated
    public void setProductID() {
        this.productID = ++counter;
    }

    public int getProductID() {
        return productID;
    }
    
    
    
    
}


package inventorymanagement;

import javafx.collections.ObservableList;

/**
 *
 * @author Christopher Sherrill
 */
public class Product {
    
    private ObservableList<Part> parts;
    private int productID;
    private String name;
    private double price;
    private int instock;
    private int min;
    private int max;
    
    public String name() {
        return name;
    }
    
    public double price() {
        return price;
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
    
    //addPart
    public void addPart(Part part) {
        parts.add(part);
    }
    
    //removePart
    public boolean removePart(int partID) {
        int i = 0;
            while(i < parts.size()) {
                Part part = parts.get(i);
                if(part.getPartID() == partID) {
                    parts.remove(i);
                    System.out.println("Removed");
                    return true;
                }
                else {
                    i++;
                }
            }
        return false;
    }
    
    // lookupPart
    public Part lookupPart(int partID) {
        int i = 0;
            while(i < parts.size()) {
                Part part = parts.get(i);
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
    
    //updatePart
    public void updatePart(int partID, Part updatedPart) {
        int i = 0;
            while(i < parts.size()) {
                Part part = parts.get(i);
                if(part.getPartID() == partID) {
                    parts.set(i, updatedPart);
                    System.out.println("Updated part");
                }
                else {
                    i++;
                }
        }
    }
    
    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductID() {
        return productID;
    }
    
    
    
    
}

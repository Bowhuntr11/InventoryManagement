
package inventorymanagement;

import java.util.ArrayList;

/**
 *
 * @author Christopher Sherrill
 */
public class Product {
    
    private ArrayList<Part> parts;
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
        
    }
    
    //removePart
    public boolean removePart(Part part) {
        return false;
    }
    
    /* lookupPart
    public part lookupPart(int partID) {
        return part;
    }
    */ 
    
    //updatePart
    public void updatePart(Part part) {
        
    }
    
    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductID() {
        return productID;
    }
    
    
    
    
}

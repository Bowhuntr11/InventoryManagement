
package inventorymanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Christopher Sherrill
 */
public final class Inventory {
    
    private static final ObservableList<Product> PRODUCTS = FXCollections.observableArrayList();
    private static final ObservableList<Part> ALLPARTS = FXCollections.observableArrayList();

    // Add Product
    public static void addProduct(Product product) {
        PRODUCTS.add(product);
        System.out.println("Added Product to index# "  + PRODUCTS.indexOf(product));
    }
    
    // Remove Product
    public static boolean removeProduct(int productID) {
        int i = 0;
        while(i < PRODUCTS.size()) {
                Product product = PRODUCTS.get(i);
                if(product.getProductID() == productID) {
                    PRODUCTS.remove(i);
                    System.out.println("Removed");
                    return true;
                }
                else {
                    i++;
                }
            }
        return false;
    }
    
    // Lookup Product
    public static Product lookupProduct(int productID) {
        int i = 0;
        while(i < PRODUCTS.size()) {
                Product product = PRODUCTS.get(i);
                if(product.getProductID() == productID) {
                    System.out.println("Found product");
                    return product;
                }
                else {
                    i++;
                }
            }
        return null;
    }
    
    // Update Product
    public static void updateProduct(int productID, Product updatedProduct) {
        int i = 0;
        while(i < PRODUCTS.size()) {
                Product product = PRODUCTS.get(i);
                if(product.getProductID() == productID) {
                    PRODUCTS.set(i, updatedProduct);
                    System.out.println("Updated Product");
                    break;
                }
                else {
                    i++;
                }
        }
    }
    

    // Add Part
    public static void addPart(Part part) {
        ALLPARTS.add(part);
        System.out.println("Added Part to index# "  + ALLPARTS.indexOf(part));
    }
    
    
    // Remove Part
    public static boolean removePart(int partID) {
        int i = 0;
        while(i < ALLPARTS.size()) {
                Part part = ALLPARTS.get(i);
                if(part.getPartID() == partID) {
                    ALLPARTS.remove(i);
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
    public static Part lookupPart(int partID) {
        int i = 0;
        while(i < ALLPARTS.size()) {
                Part part = ALLPARTS.get(i);
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
    public static void updatePart(int partID, Part updatedPart) {
        int i = 0;
        while(i < ALLPARTS.size()) {
                Part part = ALLPARTS.get(i);
                if(part.getPartID() == partID) {
                    ALLPARTS.set(i, updatedPart);
                    System.out.println("Updated Part");
                    break;
                }
                else {
                    i++;
                }
        }
    }
    
    public static ObservableList<Product> getPRODUCTS() {
        return PRODUCTS;
    }

    public static ObservableList<Part> getALLPARTS() {
        return ALLPARTS;
    }
    
    
}

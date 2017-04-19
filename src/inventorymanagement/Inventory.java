
package inventorymanagement;

import javafx.collections.ObservableList;

/**
 *
 * @author Christopher Sherrill
 */
public class Inventory {
    
    private ObservableList<Product> products;
    
    // Add Product
    public void addProduct(Product product) {
        products.add(product);
    }
    
    
    // Remove Product
    public boolean removeProduct(int productID) {
        int i = 0;
            while(i < products.size()) {
                Product product = products.get(i);
                if(product.getProductID() == productID) {
                    products.remove(i);
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
    public Product lookupProduct(int productID) {
        int i = 0;
            while(i < products.size()) {
                Product product = products.get(i);
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
    public void updateProduct(int productID, Product updatedProduct) {
        int i = 0;
            while(i < products.size()) {
                Product product = products.get(i);
                if(product.getProductID() == productID) {
                    products.set(i, updatedProduct);
                    System.out.println("Updated Product");
                }
                else {
                    i++;
                }
        }
    }
    
}


package inventorymanagement;

import java.util.ArrayList;

/**
 *
 * @author Christopher Sherrill
 */
public class Inventory {
    
    private ArrayList<Product> products;
    
    public void addProduct(Product product) {
        products.add(product);
    }
    
    public boolean removeProduct(int productID) {
        // products.indexOf(this)
        return false;
    }
    
    public Product lookupProduct(int productID) {
        Product product = products.get(productID);
        return product;
    }
    
    public void updateProduct(int productID) {
        
    }
    
}


package inventorymanagement;

/**
 *
 * @author Christopher Sherrill
 */
public abstract class Part {
    
    private String name;
    private int partID = 0;
    private double price;
    private int instock;
    private int min;
    private int max;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
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

    // No int parameter since the PartID will be Auto Generated
    public void setPartID() {
        this.partID = partID + 1;
    }

    public int getPartID() {
        return partID;
    }
    
    
}

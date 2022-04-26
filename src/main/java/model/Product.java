package model;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class Product {

    private  static Logger log = LoggerFactory.getLogger("DriverFactory");

    private String productName;
    private double productPrice;
    private int quantity;
    private double orderCost;

    public Product(String productName, double productPrice, int quantity, double orderCost) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.orderCost = orderCost;
    }

    public Product theSameProduct(Product product){
        if (this.productName.equals(productName)){
        }
        return this;
    }

}

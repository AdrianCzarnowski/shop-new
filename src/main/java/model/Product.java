package model;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Data
public class Product {

    private static Logger log = LoggerFactory.getLogger("DriverFactory");

    private List<Product> productList = new ArrayList<>();

    private String productName;
    private double productPrice;
    private int quantity;
    private double orderCost;
    private double allOrderCost;
    private int quantityOfProducts;

    public Product(String productName, double productPrice, int quantity, double orderCost) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.orderCost = orderCost;
    }

    public double getAllOrderZCost(List<Product> productList){
        if (productList.size()>0){
            for (Product product : productList){
                allOrderCost+=product.getProductPrice()*product.getQuantity();
            }
        }
        return allOrderCost;
    }
    public int getQuantityOfProducts(){
        if (productList.size()>0){
            for (Product product : productList){
                quantityOfProducts+=product.getQuantity();
            }
        }
        return quantityOfProducts;
    }

}


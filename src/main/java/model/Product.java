package model;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Product {

    public static List<Product> productList = new ArrayList<>();
    private static Logger log = LoggerFactory.getLogger("DriverFactory");
    private static double allOrderCost = 0.0;
    private String productName;
    private double productPrice;
    private int quantity = 0;
    private int quantityOfProducts = 0;

    public Product(String productName, double productPrice, int quantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public static double getAllOrderCost() {
        if (productList.size() > 0) {
            for (Product product : productList) {
                allOrderCost += product.getQuantity() * product.productPrice;
            }
        }
        return allOrderCost;
    }

    public void setAllOrderCost(double allOrderCost) {
        this.allOrderCost = allOrderCost;
    }

    public int getQuantityOfProducts() {
        if (productList.size() > 0) {
            for (Product product : productList) {
                quantityOfProducts += product.getQuantity();
            }
        }
        return quantityOfProducts;
    }

    @Override
    public String toString() {
        return "Product: " +
                productName +
                ", productPrice: " + productPrice +
                ", quantity: " + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.productPrice, productPrice) == 0 && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productPrice);
    }
}


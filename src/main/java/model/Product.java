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
    private String productName;
    private double productPrice;
    private int quantity;
    private double orderCost;
    private double allOrderCost;
    private int quantityOfProducts;

    public Product(String productName, double productPrice, int quantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public double getAllOrderZCost(List<Product> productList) {
        if (productList.size() > 0) {
            for (Product product : productList) {
                allOrderCost += product.getProductPrice() * product.getQuantity();
            }
        }
        return allOrderCost;
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


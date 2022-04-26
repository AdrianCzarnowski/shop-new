package model;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Data
public class Product {

    private static Logger log = LoggerFactory.getLogger("DriverFactory");

    private String productName;
    private double productPrice;
    private int quantity;
    private double orderCost;


    public static final class ProductBuilder {
        private String productName;
        private double productPrice;
        private int quantity;
        private double orderCost;


        public ProductBuilder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public ProductBuilder productPrice(double productPrice) {
            this.productPrice = productPrice;
            return this;

        }

        public ProductBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductBuilder orderCost(double orderCost) {
            this.orderCost = orderCost;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.productName = this.productName;
            product.productPrice = this.productPrice;
            product.quantity = this.quantity;
            product.orderCost = this.orderCost;
            return product;
        }
    }
}

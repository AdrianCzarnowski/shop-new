package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@NoArgsConstructor
@Data
public class DataCollect {


    private static Logger log = LoggerFactory.getLogger("DataCollect.class");
    private String shippingMethodName;
    private String paymentMethod;
    private String orderReference;

    public DataCollect(String shippingMethodName) {
        this.shippingMethodName = shippingMethodName;
    }

}


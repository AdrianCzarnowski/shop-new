package model;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


@Data
public class DataCollect {

    public static List<DataCollect> dataList = new ArrayList<>();

    private static Logger log = LoggerFactory.getLogger("DataCollect.class");
    private String shippingMethodName;
    private String paymentMethod;

    public DataCollect(String shippingMethodName {
        this.shippingMethodName = shippingMethodName;
    }

    public static String getshipName() {
        String name = "";
        for (DataCollect data : dataList) {
            name = data.getShippingMethodName();
        }
        log.info("<<<<<<<<<<<<NAME " + name);
        return name;
    }

}


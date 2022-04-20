package model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class BrowserModel {

    public boolean active;

    public boolean isActive(){
        return active;
    }

    Map<String,Object> properties = new HashMap<>();

    @JsonAnySetter
    void setBrowserProperties(String key, Object value){
        properties.put(key,value);
    }
    @JsonAnyGetter
    public Map<String,Object> getBrowserProperties(){
        return properties;
    }

}

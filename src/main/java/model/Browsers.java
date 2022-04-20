package model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Browsers {

    public BrowserModel chrome;
    public BrowserModel firefox;
    public BrowserModel ie;
    public BrowserModel edge;

    public List<BrowserModel> getListOfBrowsers() {
        List<BrowserModel> browserModels = new ArrayList<>();
        browserModels.add(getChrome());
        browserModels.add(getFirefox());
        browserModels.add(getIe());
        browserModels.add(getEdge());
        return browserModels;
    }
}

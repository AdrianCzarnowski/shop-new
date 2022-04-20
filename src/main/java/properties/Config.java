package properties;

import lombok.Data;
import lombok.Getter;
import model.Environment;

@Data
@Getter
public class Config {
    public Environment environment;
    public BrowserConfig browserConfig;

}

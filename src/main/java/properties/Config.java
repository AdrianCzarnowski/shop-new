package properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.Environment;

@Data
@NoArgsConstructor
public class Config {
    public Environment environment;
    public BrowserConfig browserConfig;
}

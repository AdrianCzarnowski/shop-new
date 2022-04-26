package properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.Environment;
import properties.reader.YamlReader;

@Data
@NoArgsConstructor
public class Config {
    public Environment environment;
    public BrowserConfig browserConfig;
}

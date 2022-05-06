package configuration.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import configuration.lists.EnvironmentList;

@Data
@NoArgsConstructor
public class Config {
    public EnvironmentList environment;
    public BrowserConfig browserConfig;
}

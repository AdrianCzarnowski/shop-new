package configuration.properties;

import configuration.helpers.DriverEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BrowserConfig {
    private DriverEnum driverEnum;
}

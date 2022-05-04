package properties;

import helpers.DriverEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BrowserConfig {
    private DriverEnum driverEnum;
}

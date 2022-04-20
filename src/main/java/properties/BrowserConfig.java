package properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.DriverEnum;

@Data
@NoArgsConstructor
public class BrowserConfig {
    private DriverEnum driverEnum;
}

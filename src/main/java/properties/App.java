package properties;

import model.EnvironmentModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import properties.reader.YamlReader;

import java.util.List;
import java.util.Map;

public class App {
    private static Logger log = LoggerFactory.getLogger("AppProperties.class");

    public App() {
        setSystemFromYaml();
    }

    private void setSystemFromYaml() {
        YamlReader yamlReader = new YamlReader();
        List<EnvironmentModel> environments = yamlReader.getConfig().getEnvironment().getEnvironments();
        boolean foundActiveBrowser = false;

        for (EnvironmentModel environmentModel : environments) {
            if (environmentModel.isActive()) {
                foundActiveBrowser = true;
                Map<String, Object> environmentProperties = environmentModel.getEnvironmentProperties();
                for (Map.Entry entry : environmentProperties.entrySet()) {
                    System.setProperty(entry.getKey().toString(), entry.getValue().toString());
                    log.info("env loaded: " + environmentProperties);
                }
                log.info("Properties size: " + environmentProperties.size());
                break;
            }
        }
    }
}


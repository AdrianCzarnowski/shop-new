package properties.reader;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import lombok.Data;
import model.DriverEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import properties.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Data
public class YamlReader {
    Config config;
    private static Logger log = LoggerFactory.getLogger("YamlReader.class");

    public YamlReader() {

        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            this.config = mapper.readValue(new File("src/main/resources/config.yaml"), Config.class);
            log.info("<<<<<<<<<<<<<<<<<<<Config yaml file has been read");
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

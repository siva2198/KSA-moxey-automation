package ConfigurationHelper.Utilites;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationPropertiesReader {
    public Properties properties;
    private static final Logger log = LogManager.getLogger(ConfigurationPropertiesReader.class);

    public Properties loadProperties() {
        properties = new Properties();
        try {
            log.info("Loading configuration properties from file");
            FileInputStream configFile = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/ConfigurationProperties/staging.properties");
            properties.load(configFile);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
        return properties;
    }
}

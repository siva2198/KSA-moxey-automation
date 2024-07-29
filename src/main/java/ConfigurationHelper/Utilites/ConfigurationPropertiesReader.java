package ConfigurationHelper.Utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationPropertiesReader {
    public Properties properties;

    public Properties loadProperties() {
        properties = new Properties();
        try {
            FileInputStream configFile = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/ConfigurationProperties/staging.properties");
            properties.load(configFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
        return properties;
    }
}

import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    private static final String PROPERTIES_FILE = "resources/META-INF/persistence.properties";

    public static Properties loadProperties() {
        try (InputStream input = AppConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            Properties properties = new Properties();
            properties.load(input);
            return properties;
        } catch (Exception e) {
            throw new RuntimeException("Failed to load properties file", e);
        }
    }
}

package com.demo.testHelidon.config.configSource;

import com.demo.testHelidon.util.ResourceUtil;
import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesConfigSource implements ConfigSource {
    private final Properties properties;
    private final Map<String, String> propertiesMap;
    public PropertiesConfigSource(String configFileName){
        try {
            properties = ResourceUtil.getProperties(configFileName);
            propertiesMap = this.typeCastConvert(this.properties);
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }
    @Override
    public Map<String, String> getProperties() {
        return this.propertiesMap;
    }

    @Override
    public Set<String> getPropertyNames() {
        return this.propertiesMap.keySet();
    }

    @Override
    public int getOrdinal() {
        return 112;
    }

    @Override
    public String getValue(String s) {
        return this.properties.getProperty(s);
    }

    @Override
    public String getName() {
        return PropertiesConfigSource.class.getSimpleName();
    }

    private HashMap<String, String> typeCastConvert(Properties prop) {
        Map step1 = prop;
        Map<String, String> step2 = (Map<String, String>) step1;
        return new HashMap<>(step2);
    }
}

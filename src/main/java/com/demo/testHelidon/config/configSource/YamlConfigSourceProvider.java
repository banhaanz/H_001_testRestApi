package com.demo.testHelidon.config.configSource;

import lombok.SneakyThrows;
import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.List;

public class YamlConfigSourceProvider implements org.eclipse.microprofile.config.spi.ConfigSourceProvider {
        @SneakyThrows
        @Override
        public List<ConfigSource> getConfigSources(ClassLoader forClassLoader) {
            return List.of(
                    new YamlConfigSource("test.yaml")
            );
        }
}

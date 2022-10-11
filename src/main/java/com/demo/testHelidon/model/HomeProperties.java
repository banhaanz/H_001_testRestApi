package com.demo.testHelidon.model;

import com.demo.testHelidon.util.ResourceUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.Properties;

@Data
@Model
public class HomeProperties {

    public HomeProperties(){
//        Properties properties = ResourceUtil.getYaml("test.yaml");
//        System.out.println(properties);
    }

    @Inject @ConfigProperty(name = "app.hello")
    private String message;

    @Inject @ConfigProperty(name = "app.username")
    private String username;

    @Inject @ConfigProperty(name = "app.age")
    private int age;

    @Inject @ConfigProperty(name = "app.yaml.value1")
    private String yamlValue1;

    @Inject @ConfigProperty(name = "db.value1")
    private String dbValue1;

    @Inject @ConfigProperty(name = "connector.value1")
    private int connectorValue1;

    @Inject @ConfigProperty(name = "config.user.name")
    private String yamlConfigValue1;
}

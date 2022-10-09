package com.demo.testHelidon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Model
public class HomeProperties {

    @Inject @ConfigProperty(name = "app.hello")
    private String message;

    @Inject @ConfigProperty(name = "app.username")
    private String username;

    @Inject @ConfigProperty(name = "app.age")
    private int age;

    @Inject @ConfigProperty(name = "app.yaml.value1")
    private String yamlValue1;
}

package com.demo.testHelidon.config;

import com.demo.testHelidon.controller.HomeController;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@OpenAPIDefinition(info = @Info(
        title = "Example application",
        version = "1.0.0",
        contact = @Contact(
                name = "AEKCOM",
                email = "aekcom@aekcom.com",
                url = "http://www.aekcom.com")
),
        servers = {
                @Server(url = "/",description = "localhost")
        }
)
@ApplicationPath("/AEKCOM")
@ApplicationScoped
public class ApplicationPathConfig extends Application {
//    @Override
//    public Set<Class<?>> getClasses() {
//
//        Set<Class<?>> classes = new HashSet<>();
//
//        // resources
//        classes.add(HomeController.class);
//
//        return classes;
//    }
}

package com.demo.testHelidon.controller;

import com.demo.testHelidon.model.HomeProperties;
import com.demo.testHelidon.model.User;
import com.demo.testHelidon.service.HomeMessageService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;

@Slf4j
@Path("/home")
@RequestScoped
@Tag(name = "Test Home service", description = "RESTFul API Testing")
public class HomeController {
    private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());
    @Inject
    private HomeMessageService service;

    @Inject
    private HomeProperties homeProperties;

    @GET @Path("/helloWorld")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject helloWorld() {
        log.info("===== Enter helloWorld ====");
//        log.info("homeProperties value:{}", homeProperties);

        return JSON.createObjectBuilder()
                .add("message1", "hello world")
                .add("config value1", service.getMessage())
                .add("config value2", service.getHomeProperties().getUsername())
                .add("config value3", service.getHomeProperties().getAge())
                .add("dbValue1", service.getHomeProperties().getDbValue1())
                .add("connectorValue1", service.getHomeProperties().getConnectorValue1())
                .add("yamlConfigValue1", service.getHomeProperties().getYamlConfigValue1())
                .add("yamlConfigValue2", service.getHomeProperties().getYamlConfigValue2())
                .add("yaml value1", homeProperties.getYamlValue1())
                .build();
    }

    @GET @Path("/testGet1/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject testGetWithPathParam(@PathParam("id") String id) {
        log.info("===== Enter testGetWithPathParam ====");
        return JSON.createObjectBuilder()
                .add("message1", "response id: " + id)
                .build();
    }

    @POST @Path("/testPost")
    @Produces(MediaType.APPLICATION_JSON)
    public Response testPost() {
        log.info("===== Enter testPost ====");
        return Response
                .status(Response.Status.OK)
                .entity(new User("CODECOOLZ", 20, true))
                .build();
    }
}

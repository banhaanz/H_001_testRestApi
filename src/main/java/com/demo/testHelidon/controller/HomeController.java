package com.demo.testHelidon.controller;

import com.demo.testHelidon.model.User;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;

@Slf4j
@Path("/home")
@RequestScoped
@Tag(name = "Test Home service", description = "Get test data")
public class HomeController {
    private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());

    @GET @Path("/helloWorld")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject helloWorld() {
        log.info("===== Enter helloWorld ====");

        return JSON.createObjectBuilder()
                .add("message1", "hello world")
                .build();
    }

    @POST @Path("/testPost")
    @Produces(MediaType.APPLICATION_JSON)
    public Response testPost() {
        log.info("===== Enter testPost ====");
        return Response
                .status(Response.Status.OK)
                .entity(new User("AEKCOM", 20, true))
                .build();
    }
}

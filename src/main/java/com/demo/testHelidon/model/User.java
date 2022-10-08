package com.demo.testHelidon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name="User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Schema(required = true, description = "username")
    private String username;
    private int age;
    private boolean workFlag;
}
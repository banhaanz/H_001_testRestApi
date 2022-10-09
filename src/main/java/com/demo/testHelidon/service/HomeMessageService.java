package com.demo.testHelidon.service;

import com.demo.testHelidon.model.HomeProperties;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicReference;

@ApplicationScoped //--1
public class HomeMessageService {
    private final AtomicReference<String> message = new AtomicReference<>(); //--2

    @Inject
    public HomeMessageService(HomeProperties homeProperties) {
        this.message.set(homeProperties.getMessage());
    }

    public String getMessage(){
        return message.get();
    }

    public void setMessage(String message){
        this.message.set(message);
    }

}

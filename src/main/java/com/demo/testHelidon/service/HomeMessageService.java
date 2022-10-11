package com.demo.testHelidon.service;

import com.demo.testHelidon.model.HomeProperties;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.concurrent.atomic.AtomicReference;

@RequestScoped //--1
public class HomeMessageService {
    private final AtomicReference<String> message = new AtomicReference<>(); //--2

    private final HomeProperties homeProperties;

    @Inject
    public HomeMessageService(HomeProperties homeProperties) {
        this.homeProperties = homeProperties;
        this.message.set(this.homeProperties.getMessage());
    }

    public String getMessage(){
        return message.get();
    }

    public void setMessage(String message){
        this.message.set(message);
    }

    public HomeProperties getHomeProperties(){
        return this.homeProperties;
    }

}

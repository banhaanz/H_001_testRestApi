package com.demo.testHelidon;

import io.helidon.microprofile.server.Server;

public class H001TestHelidonBasicApplication{

    public static void main(final String[] args) {
        Server.create().start();
    }
}

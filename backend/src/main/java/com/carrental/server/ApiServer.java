package com.carrental.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class ApiServer {
    private final HttpServer server;

    public ApiServer(int port) throws IOException{
        server = HttpServer.create(
                new InetSocketAddress("localhost",port),0
        );
        server.createContext("/api/health",httpExchange->{
            byte[] response = "{\"status\":\"ok\",\"service\":\"car-rental-backend\"}".getBytes(StandardCharsets.UTF_8);
            httpExchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
            httpExchange.getResponseHeaders().set("Cache-control","no-store");
            httpExchange.sendResponseHeaders(200, response.length);
            try(var output = httpExchange.getResponseBody()) {
                output.write(response);
            }
        });
    }

    public void start(){
        server.start();
        System.out.println("Car Rental API running at http://localhost:8080");
    }
    public void stop(){
        server.stop(1);
    }
}

package com.carrental;

import com.carrental.server.ApiServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            ApiServer apiServer = new ApiServer(8080);
            apiServer.start();
        } catch (IOException e){
            System.err.println("Could not start the Car Rental API: "+e.getMessage());
        }
    }
}

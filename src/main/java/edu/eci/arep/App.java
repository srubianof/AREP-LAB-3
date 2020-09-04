package edu.eci.arep;

import edu.eci.arep.server.HttpServer;

public class App {


    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer();
        httpServer.start();
    }
}

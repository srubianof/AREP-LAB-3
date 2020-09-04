package edu.eci.arep;

import edu.eci.arep.database.DB;
import edu.eci.arep.server.HttpServer;

public class App {


    public static void main(String[] args) {
        DB db = new DB();
        db.start();
        HttpServer httpServer = new HttpServer(getPort());
        httpServer.start();
    }

    /**
     * Gets port.
     *
     * @return the port
     */
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 36000;
    }
}

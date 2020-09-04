package edu.eci.arep;

import edu.eci.arep.database.DB;
import edu.eci.arep.server.HttpServer;

/**
 * The type App.
 */
public class App {



    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
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

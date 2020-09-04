package edu.eci.arep.server;

import javax.crypto.CipherInputStream;
import java.net.*;
import java.io.*;

/**
 * The type Http server.
 */
public class HttpServer {
    /**
     * Gets port.
     *
     * @return the port
     */
    public int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 36000; // returns default port if heroku-port isn't set(i.e. on localhost)
    }

    /**
     * Start.
     */
    public void start() {
        try {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(36000);
            } catch (IOException e) {
                System.err.println("Could not listen on port: 36000.");
                System.exit(1);
            }
            boolean running = true;
            while (running) {
                Socket clientSocket = null;
                try {
                    System.out.println("Listo para recibir en puerto 36000 ...");
                    clientSocket = serverSocket.accept();
                } catch (IOException e) {
                    System.err.println("Accept failed.");
                    System.exit(1);
                }
                proccessRequest(clientSocket);
                clientSocket.close();
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Proccess request.
     *
     * @param clientSocket the client socket
     * @throws IOException the io exception
     */
    public void proccessRequest(Socket clientSocket) throws IOException {
        Request request = null;
        PrintStream out = new PrintStream(
                clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            request = new Request(inputLine.split(" ")[0], inputLine.split(" ")[1]);
            if (!in.ready() || inputLine.isEmpty()) {
                break;
            }
            break;
        }
        assert request != null;
        if (!request.getHttpMethod().equals("")) {
            createResponse(out, request);
        }
        if (request.getHttpMethod().equals("POST")) {
            StringBuilder body = new StringBuilder();
            while (in.ready()) {
                body.append((char) in.read());
            }
            request.setResource(body.toString());
        }
        in.close();
        out.close();

    }

    /**
     * Create response.
     *
     * @param printStream the socket
     * @param request     the request
     */
    public void createResponse(PrintStream printStream, Request request) throws IOException {
        InputStream inputStream;
        File file = new File("src/main/resources" + request.getResource());
        System.out.println(request.getResource() + "R");
        System.out.println(request.getHttpMethod() + "M");
        if (file.exists()) {
            if (request.getResource().equals("/")) {
                inputStream = new FileInputStream("src/main/resources/index.html");
            } else {
                inputStream = new FileInputStream("src/main/resources" + request.getResource());
            }
            printStream.print(("HTTP/1.1 201 OK\r\n"
                    + "Content-Type: " + request.getContentType() + ";"
                    + "charset=\"UTF-8\" \r\n\r\n"));
            System.out.println(request.getContentType());
            byte[] a = new byte[4096];
            int n;
            while ((n = inputStream.read(a)) > 0) {
                printStream.write(a, 0, n);
            }
        } else {
            printStream.print("HTTP/1.0 404 Not Found \r\n" + "Content-type: text/html" + "\r\n\r\n" + "404 File not found");
            printStream.close();
        }
        printStream.close();
    }

//    public static void main(String[] args) {
//        HttpServer.start();
//    }
}

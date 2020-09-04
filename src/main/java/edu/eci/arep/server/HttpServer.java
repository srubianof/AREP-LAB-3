package edu.eci.arep.server;

import javax.crypto.CipherInputStream;
import java.net.*;
import java.io.*;
import java.util.Objects;

/**
 * The type Http server.
 */
public class HttpServer {
    /**
     * The Port.
     */
    int port;

    /**
     * Instantiates a new Http server.
     */
    public HttpServer() {
    }

    /**
     * Instantiates a new Http server.
     *
     * @param port the port
     */
    public HttpServer(int port) {
        this.port = port;
    }

    /**
     * Start.
     */
    public void start() {
        try {
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(port);
            } catch (IOException e) {
                System.err.println("Could not listen on port:" + port);
                System.exit(1);
            }
            boolean running = true;
            while (running) {
                Socket clientSocket = null;
                try {
                    System.out.println("Listo para recibir en puerto" + port);
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
        Request request = new Request();
        PrintStream out = new PrintStream(
                clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            request.setHttpMethod(inputLine.split(" ")[0]);
            request.setResource(inputLine.split(" ")[1]);
            if (!in.ready() || inputLine.length() == 0) {
                break;
            }
            break;
        }
        if (Objects.equals(request.getHttpMethod(), "")) {
        } else {
            createResponse(out, request);
        }
        in.close();
        out.close();

    }

    /**
     * Create response.
     *
     * @param printStream the socket
     * @param request     the request
     * @throws IOException the io exception
     */
    public void createResponse(PrintStream printStream, Request request) throws IOException {
        InputStream inputStream;
        File file = new File("src/main/resources" + request.getResource());
        if (file.exists()) {
            if (request.getResource().equals("/")) {
                inputStream = new FileInputStream("src/main/resources/index.html");
            } else {
                inputStream = new FileInputStream("src/main/resources" + request.getResource());
            }
            printStream.print(("HTTP/1.1 201 OK\r\n"
                    + "Content-Type: " + request.getContentType() + ";"
                    + "charset=\"UTF-8\" \r\n\r\n"));
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
}

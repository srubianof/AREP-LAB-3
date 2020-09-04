package edu.eci.arep.url;

import java.net.*;

/**
 * The type Url scanner.
 */
public class URLScanner {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        scanURL("https:www.hola.com/prueba/hola?ja=1#pp");
    }

    private static void scanURL(String s) {
        try {
            URL url = new URL(s);
            System.out.println("Protocol " + url.getProtocol());
            System.out.println("Auth " + url.getAuthority());
            System.out.println("Host " + url.getHost());
            System.out.println("Port " + url.getPort());
            System.out.println("Path " + url.getPath());
            System.out.println("Query " + url.getQuery());
            System.out.println("File " + url.getFile());
            System.out.println("Ref " + url.getRef());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
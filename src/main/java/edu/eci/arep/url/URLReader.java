package edu.eci.arep.url;

import java.io.*;
import java.net.*;
import java.util.*;

public class URLReader {
    public static void main(String[] args) {
//        readURL("https://ldbn.is.escuelaing.edu.co");
        readURL("http://localhost:36000/");
    }

    public static void readURL(String sitetoread) {
        try {
            // Crea el objeto que representa una URL
            URL siteURL = new URL(sitetoread);
            // Crea el objeto que URLConnection
            URLConnection urlConnection = siteURL.openConnection();
            // Obtiene los campos del encabezado y los almacena en un estructura Map
            Map<String, List<String>> headers = urlConnection.getHeaderFields();
            // Obtiene una vista del mapa como conjunto de pares <K,V> // para poder navegarlo
            Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
            // Recorre la lista de campos e imprime los valores
            for (Map.Entry<String, List<String>> entry : entrySet) {
                String headerName = entry.getKey();
                //Si el nombre es nulo, significa que es la linea de estado
                if (headerName != null) {
                    System.out.print(headerName + " : ");
                }
                List<String> headerValues = entry.getValue();
                for (String value : headerValues) {
                    System.out.print(value + "\n");
                }
            }

            System.out.println("-------message-body------");
            BufferedReader reader =
                    new BufferedReader(new
                            InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

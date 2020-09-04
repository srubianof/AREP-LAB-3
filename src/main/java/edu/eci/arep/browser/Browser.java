package edu.eci.arep.browser;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;

/**
 * The type Browser.
 */
public class Browser {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        pageCreator("http://edition.cnn.com/US/OJ/");
    }

    /**
     * Page creator.
     *
     * @param url the url
     */
    public static void pageCreator(String url) {
        try {
            File file = new File(url.substring(7, 14) + ".html");
            FileWriter fileWriter = new FileWriter(url.substring(7, 14) + ".html");
            // Crea el objeto que representa una URL
            URL siteURL = new URL(url);
            // Crea el objeto que URLConnection
            URLConnection urlConnection = siteURL.openConnection();
            BufferedReader reader =
                    new BufferedReader(new
                            InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
                fileWriter.write(inputLine + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

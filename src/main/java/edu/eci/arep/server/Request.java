package edu.eci.arep.server;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * The type Request.
 */
public class Request {
    private String HttpMethod;
    private String resource;
    private String contentType;
    private Map<String, String> header;

    /**
     * Instantiates a new Request.
     */
    public Request() {
    }

    /**
     * Gets http method.
     *
     * @return the http method
     */
    public String getHttpMethod() {
        return HttpMethod;
    }

    /**
     * Sets http method.
     *
     * @param httpMethod the http method
     */
    public void setHttpMethod(String httpMethod) {
        HttpMethod = httpMethod;
    }

    /**
     * Gets resource.
     *
     * @return the resource
     */
    public String getResource() {
        return resource;
    }

    /**
     * Gets content type.
     *
     * @return the content type
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets content type.
     *
     * @param filename the filename
     */
    public void setContentType(String filename) {
        if (filename.endsWith(".html") || filename.endsWith(".htm")) {
            this.contentType = "text/html";
        }
        if (filename.endsWith(".css")) {
            this.contentType = "text/css";
        }
        if (filename.endsWith(".js")) {
            this.contentType = "text/javascript";
        }
        if (filename.endsWith(".pdf")) {
            this.contentType = "image/png";
        }
        if (filename.endsWith(".png")) {
            this.contentType = "image/png";
        } else if (filename.endsWith(".jpg")) {
            this.contentType = "image/jpeg";
        }
    }

    /**
     * Sets resource.
     *
     * @param resource the resource
     */
    public void setResource(String resource) {
        this.resource = resource;
        setContentType(this.resource);
    }

    /**
     * Gets header.
     *
     * @return the header
     */
    public Map<String, String> getHeader() {
        return this.header;
    }

    /**
     * Sets header.
     *
     * @param header the header
     */
    public void setHeader(Map<String, String> header) {
        this.header = header;
    }
}

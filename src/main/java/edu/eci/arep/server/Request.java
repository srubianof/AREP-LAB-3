package edu.eci.arep.server;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Request {
    private String HttpMethod;
    private String resource;
    private String contentType;
    private Map<String, String> header;

    public Request() {
    }

    public String getHttpMethod() {
        return HttpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        HttpMethod = httpMethod;
    }

    public String getResource() {
        return resource;
    }

    public String getContentType() {
        return contentType;
    }

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

    public void setResource(String resource) {
        this.resource = resource;
        setContentType(this.resource);
    }

    public Map<String, String> getHeader() {
        return this.header;
    }

    public void setHeader(Map<String, String> header) {
        this.header = header;
    }
}

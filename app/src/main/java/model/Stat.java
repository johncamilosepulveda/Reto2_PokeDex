package model;

import java.io.Serializable;

public class Stat implements Serializable {

    private String name;
    private String url;

    public Stat(){

    }

    public Stat(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package com.lnu.agile.model;

/**
 * Created by olefir on 11/22/2015.
 */
public class Home {

    private final long id;
    private final String content;

    public Home(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}

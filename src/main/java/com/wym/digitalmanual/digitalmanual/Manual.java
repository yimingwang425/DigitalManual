package com.wym.digitalmanual.digitalmanual;

public class Manual {
    private String title;
    private String content;

    public Manual(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
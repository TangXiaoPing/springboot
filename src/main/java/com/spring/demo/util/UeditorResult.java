package com.spring.demo.util;

public class UeditorResult {
    private String original;
    private String state = "SUCCESS";
    private String title;
    private String url;

    public UeditorResult(String original, String title, String url) {
        this.original = original;
        this.title = title;
        this.url = url;
    }

    public UeditorResult(String original, String state, String title, String url) {
        this.original = original;
        this.state = state;
        this.title = title;
        this.url = url;
    }

    public UeditorResult() {

    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

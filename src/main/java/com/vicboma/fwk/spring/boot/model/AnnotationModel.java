package com.vicboma.fwk.spring.boot.model;

public class AnnotationModel {

    private String title;
    private String author;
    private String body;

    public static AnnotationModel create(String title, String author, String body) {
        return new AnnotationModel(title, author, body);
    }

    protected AnnotationModel(String title, String author, String body){
        this.setAuthor(author);
        this.setTitle(title);
        this.setBody(body);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

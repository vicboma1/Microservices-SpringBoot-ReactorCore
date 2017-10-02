package com.vicboma.fwk.spring.boot.model.post;

import com.vicboma.fwk.spring.boot.model.AnnotationModel;

import java.util.UUID;

public class AnnotationPostModel extends AnnotationModel {

    private UUID id;

    public static AnnotationPostModel create(UUID id, String title, String author, String body) {
        return new AnnotationPostModel(id,title,author,body);
    }

    AnnotationPostModel(UUID id, String title, String author, String body){
        super(title,author,body);
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}

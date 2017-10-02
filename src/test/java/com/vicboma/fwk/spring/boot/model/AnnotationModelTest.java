package com.vicboma.fwk.spring.boot.model;

import com.vicboma.fwk.spring.boot.model.post.AnnotationPostModel;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class AnnotationModelTest {

    private final String title = "title";
    private final String author = "author";
    private final String body = "body";

    @Test
    public void _class() throws Exception{

        final AnnotationModel annotationModel = AnnotationModel.create( title, author, body);
        Assert.assertEquals(annotationModel.getClass(),AnnotationModel.class);
    }

    @Test
    public  void create() throws Exception{
        final AnnotationModel annotationModel1 = AnnotationModel.create( title, author, body);
        final AnnotationModel annotationModel2 = AnnotationModel.create( title, author, body);

        Assert.assertNotEquals(annotationModel1,annotationModel2);
    }


    @Test
    public void getTitle() throws Exception {
        final AnnotationModel annotationModel1 = AnnotationModel.create( title, author, body);
        final String result = annotationModel1.getTitle();

        Assert.assertEquals(title, result);
    }


    @Test
    public void getAuthor() throws Exception {
        final AnnotationModel annotationModel1 = AnnotationModel.create( title, author, body);
        final String result = annotationModel1.getAuthor();

        Assert.assertEquals(author, result);

    }

    @Test
    public void getBody() throws Exception {
        final AnnotationModel annotationModel1 = AnnotationModel.create( title, author, body);
        final String result = annotationModel1.getBody();

        Assert.assertEquals(body, result);

    }


}
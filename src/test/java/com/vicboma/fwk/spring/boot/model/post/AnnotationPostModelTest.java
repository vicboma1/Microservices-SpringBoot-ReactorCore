package com.vicboma.fwk.spring.boot.model.post;

import com.vicboma.fwk.spring.boot.model.GrettingModel;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class AnnotationPostModelTest {

    private final byte[] nbyte = {10,20,30};

    private final String title = "title";
    private final String author = "author";
    private final String body = "body";

    @Test
    public void _class() throws Exception{

        final AnnotationPostModel annotationPostModel = AnnotationPostModel.create(UUID.randomUUID(), title, author, body);
        Assert.assertEquals(annotationPostModel.getClass(),AnnotationPostModel.class);
    }

    @Test
    public  void create() throws Exception{
        final AnnotationPostModel annotationPostModel = AnnotationPostModel.create(UUID.randomUUID(), title, author, body);
        final AnnotationPostModel annotationPostMode2 = AnnotationPostModel.create(UUID.randomUUID(), title, author, body);

        Assert.assertNotEquals(annotationPostModel,annotationPostMode2);
    }

    @Test
    public void getId() throws Exception {
        final UUID expected = UUID.nameUUIDFromBytes(nbyte);
        final AnnotationPostModel annotationPostModel = AnnotationPostModel.create(expected, title, author, body);
        final UUID result = annotationPostModel.getId();

        Assert.assertEquals(expected,result);
    }

}
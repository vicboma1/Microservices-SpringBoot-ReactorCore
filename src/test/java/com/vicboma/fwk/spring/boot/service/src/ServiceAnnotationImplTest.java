package com.vicboma.fwk.spring.boot.service.src;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vicboma.fwk.logger.Loggable;
import com.vicboma.fwk.spring.boot.model.AnnotationModel;
import com.vicboma.fwk.spring.boot.service.api.ServiceAnnotation;
import com.vicboma.fwk.spring.boot.service.api.ServiceGreeting;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.*;

public class ServiceAnnotationImplTest implements Loggable {


    private ServiceAnnotation serviceAnnotation;
    private final String title = "title";
    private final String author = "author";
    private final String body = "body";

    private final String mock = "{\"title\":\"title\",\"author\":\"author\",\"body\":\"body\"}";

    @Before
    public void setUp()throws Exception {
        serviceAnnotation = new ServiceAnnotationImpl();
    }

    @After
    public void tearDown()throws Exception {
        serviceAnnotation = null;
    }

    @Test
    public void post() throws Exception {
        StringBuilder result = new StringBuilder();

        final AnnotationModel annotationModel = AnnotationModel.create( title, author, body);

        final ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(annotationModel);
        result.append(json);

        Assert.assertEquals(mock,result.toString());
        result = new StringBuilder();

        final Mono<AnnotationModel> just = Mono.just(annotationModel);

        json = objectMapper.writeValueAsString(just);
        result.append(json);
        Assert.assertEquals(mock,result.toString());


        final Mono<UUID> postResult = serviceAnnotation.post(just);

        final UUID block = postResult.block();

        Assert.assertNotNull(block);
    }

}
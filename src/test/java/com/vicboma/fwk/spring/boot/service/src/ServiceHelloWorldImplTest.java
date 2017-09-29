package com.vicboma.fwk.spring.boot.service.src;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vicboma.fwk.logger.Loggable;
import com.vicboma.fwk.spring.boot.service.api.ServiceHelloWorld;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class ServiceHelloWorldImplTest implements Loggable {

    private ServiceHelloWorld serviceHelloWorld;

    @Before
    public void setUp() throws Exception {
        serviceHelloWorld = new ServiceHelloWorldImpl();
    }

    @After
    public void tearDown() throws Exception {
        serviceHelloWorld = null;
    }

    @Test
    public void get() throws Exception {

        final CompletableFuture lock = new CompletableFuture();
        final StringBuilder expected = new StringBuilder("{\"helloWorld\":\"Hello World!\"}");
        final StringBuilder result = new StringBuilder();

        serviceHelloWorld.get().toFuture().thenAcceptAsync(it -> {
            try {
                final ObjectMapper objectMapper = new ObjectMapper();
                final String json = objectMapper.writeValueAsString(it);
                result.append(json);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }finally{
                lock.complete(null);
            }
        });

        lock.get();

        Assert.assertEquals(expected.toString(), result.toString());

    }

}
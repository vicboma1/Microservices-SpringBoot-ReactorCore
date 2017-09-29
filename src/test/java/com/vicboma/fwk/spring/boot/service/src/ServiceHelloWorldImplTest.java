package com.vicboma.fwk.spring.boot.service.src;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vicboma.fwk.logger.Loggable;
import com.vicboma.fwk.spring.boot.model.GrettingModel;
import com.vicboma.fwk.spring.boot.service.api.ServiceGreeting;
import com.vicboma.fwk.spring.boot.service.api.ServiceHelloWorld;
import org.junit.Assert;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;

class ServiceHelloWorldImplTest implements Loggable {

    private ServiceHelloWorld serviceHelloWorld;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        serviceHelloWorld = new ServiceHelloWorldImpl();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        serviceHelloWorld = null;
    }

    @org.junit.jupiter.api.Test
    void get() throws Exception {

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
package com.vicboma.fwk.spring.boot.service.src;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vicboma.fwk.logger.Loggable;
import com.vicboma.fwk.spring.boot.service.api.ServiceGreeting;
import org.junit.Assert;

import java.util.concurrent.CompletableFuture;

class ServiceGreetingImplTest implements Loggable {

    private ServiceGreeting serviceGreeting;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        serviceGreeting = new ServiceGreetingImpl();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        serviceGreeting = null;
    }

    @org.junit.jupiter.api.Test
    void get() throws Exception {

        final CompletableFuture lock = new CompletableFuture();
        String name = "vicboma1";
        final StringBuilder expected = new StringBuilder("{\"hi\":\"vicboma1\"}");
        final StringBuilder result = new StringBuilder();

        serviceGreeting.get(name).toFuture().thenAcceptAsync(it -> {
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
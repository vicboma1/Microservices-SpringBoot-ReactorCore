package com.vicboma.fwk.spring.boot.service.src;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vicboma.fwk.logger.Loggable;
import com.vicboma.fwk.spring.boot.service.api.ServiceGreeting;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.concurrent.CompletableFuture;

public class ServiceGreetingImplTest implements Loggable {

    private ServiceGreeting serviceGreeting;

    @Before
    public void setUp()throws Exception {
        serviceGreeting = new ServiceGreetingImpl();
    }

    @After
    public void tearDown()throws Exception {
        serviceGreeting = null;
    }

    @Test
    public void get() throws Exception {

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


    @Test
    public void getDelay() throws Exception {
        getDelay(ServiceGreeting.TIME_DEFAULT);
    }

    @Test
    public void getDelayTimeMS() throws Exception {
        getDelay(2500);
    }


    private void getDelay(final long timeMS) throws Exception {

        final long init = System.currentTimeMillis();
        boolean[] resultTime = new boolean[1];

        final CompletableFuture lock = new CompletableFuture();
        String name = "vicboma1";
        final StringBuilder expected = new StringBuilder("{\"hi\":\"vicboma1\"}");
        final StringBuilder result = new StringBuilder();

        serviceGreeting
                .getDelayTime(name,timeMS)
                .toFuture()
                .thenAcceptAsync(it -> {
                    try {
                        final long _time = System.currentTimeMillis() - init;
                        resultTime[0] = _time >= timeMS;

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

        Assert.assertTrue( resultTime[0] );

        Assert.assertEquals(expected.toString(), result.toString());
    }
}
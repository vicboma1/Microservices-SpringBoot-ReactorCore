package com.vicboma.fwk.spring.boot.controller.src;

import com.vicboma.fwk.spring.boot.controller.api.GreetingController;
import com.vicboma.fwk.spring.boot.controller.api.HelloWorldController;
import com.vicboma.fwk.spring.boot.model.GrettingModel;
import com.vicboma.fwk.spring.boot.model.HelloWorldModel;
import com.vicboma.fwk.spring.boot.service.api.ServiceGreeting;
import com.vicboma.fwk.spring.boot.service.api.ServiceHelloWorld;
import com.vicboma.fwk.spring.boot.service.src.ServiceGreetingImpl;
import com.vicboma.fwk.spring.boot.service.src.ServiceHelloWorldImpl;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldControllerImplTest {

    private HelloWorldController helloWorldController;

    @BeforeEach
    void setUp() {
        ServiceHelloWorld serviceHelloWorld = new ServiceHelloWorldImpl();
        helloWorldController = new HelloWorldControllerImpl(serviceHelloWorld);
    }

    @AfterEach
    void tearDown() {
        helloWorldController = null;
    }

    @Test
    void getHelloWorld() {

        final Mono<HelloWorldModel> expected = Mono.just(HelloWorldModel.create(HelloWorldModel.HELLO_WORLD));
        final Mono<HelloWorldModel> result = helloWorldController.home();

        Assert.assertEquals(expected.block().getHelloWorld(), result.block().getHelloWorld());
    }

}
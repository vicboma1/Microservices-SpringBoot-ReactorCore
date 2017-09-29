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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import reactor.core.publisher.Mono;


public class HelloWorldControllerImplTest {

    private HelloWorldController helloWorldController;

    @Before
    public void setUp() throws Exception{
        ServiceHelloWorld serviceHelloWorld = new ServiceHelloWorldImpl();
        helloWorldController = new HelloWorldControllerImpl(serviceHelloWorld);
    }

    @After
    public void tearDown()throws Exception {
        helloWorldController = null;
    }

    @Test
    public void getHelloWorld()throws Exception {

        final Mono<HelloWorldModel> expected = Mono.just(HelloWorldModel.create(HelloWorldModel.HELLO_WORLD));
        final Mono<HelloWorldModel> result = helloWorldController.home();

        Assert.assertEquals(expected.block().getHelloWorld(), result.block().getHelloWorld());
    }

}
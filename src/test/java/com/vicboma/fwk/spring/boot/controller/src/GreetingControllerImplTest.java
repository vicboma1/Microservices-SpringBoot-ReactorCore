package com.vicboma.fwk.spring.boot.controller.src;

import com.vicboma.fwk.spring.boot.controller.api.GreetingController;
import com.vicboma.fwk.spring.boot.model.GrettingModel;
import com.vicboma.fwk.spring.boot.service.api.Service;
import com.vicboma.fwk.spring.boot.service.api.ServiceGreeting;
import com.vicboma.fwk.spring.boot.service.src.ServiceGreetingImpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import reactor.core.publisher.Mono;


public class GreetingControllerImplTest {

    final String value = "vicboma1";
    private GreetingController greetingController;

    @Before
    public void setUp() throws Exception{
        final ServiceGreeting service = new ServiceGreetingImpl();
        greetingController = new GreetingControllerImpl(service);
    }

    @After
    public void tearDown()throws Exception {
        greetingController = null;
    }

    @Test
    public void getHi() throws Exception{

        final Mono<GrettingModel> expected = Mono.just(GrettingModel.create(value));
        final Mono<GrettingModel> result = greetingController.hi(value);

        Assert.assertEquals(expected.block().getHi(), result.block().getHi());
    }

}
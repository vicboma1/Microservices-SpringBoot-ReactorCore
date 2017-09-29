package com.vicboma.fwk.spring.boot.controller.src;

import com.vicboma.fwk.spring.boot.controller.api.GreetingController;
import com.vicboma.fwk.spring.boot.model.GrettingModel;
import com.vicboma.fwk.spring.boot.service.api.Service;
import com.vicboma.fwk.spring.boot.service.api.ServiceGreeting;
import com.vicboma.fwk.spring.boot.service.src.ServiceGreetingImpl;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

class GreetingControllerImplTest {

    final String value = "vicboma1";
    private GreetingController greetingController;

    @BeforeEach
    void setUp() {
        final ServiceGreeting service = new ServiceGreetingImpl();
        greetingController = new GreetingControllerImpl(service);
    }

    @AfterEach
    void tearDown() {
        greetingController = null;
    }

    @Test
    void getHi() {

        final Mono<GrettingModel> expected = Mono.just(GrettingModel.create(value));
        final Mono<GrettingModel> result = greetingController.hi(value);

        Assert.assertEquals(expected.block().getHi(), result.block().getHi());
    }

}
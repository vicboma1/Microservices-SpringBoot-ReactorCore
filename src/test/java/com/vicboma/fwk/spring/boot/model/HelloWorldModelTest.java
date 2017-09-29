package com.vicboma.fwk.spring.boot.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldModelTest {

    final static String expected = "vicboma1";

    @Test
    void _class() {
        final HelloWorldModel helloWorldModel = HelloWorldModel.create(expected);
        Assert.assertEquals(helloWorldModel.getClass(),HelloWorldModel.class);
    }

    @Test
    void create() {
        final HelloWorldModel helloWorldModel = HelloWorldModel.create(expected);
        final HelloWorldModel helloWorldMode2 = HelloWorldModel.create(expected);

        Assert.assertNotEquals(helloWorldModel,helloWorldMode2);
    }

    @Test
    void getHi() {

        final HelloWorldModel helloWorldModel = HelloWorldModel.create(expected);
        final String result = helloWorldModel.getHelloWorld();

        Assert.assertEquals(expected,result);

    }

}
package com.vicboma.fwk.spring.boot.model;

import org.junit.Assert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HelloWorldModelTest {

    final static String expected = "vicboma1";

    @Test
    public void _class()throws Exception {
        final HelloWorldModel helloWorldModel = HelloWorldModel.create(expected);
        Assert.assertEquals(helloWorldModel.getClass(),HelloWorldModel.class);
    }

    @Test
    public void create()throws Exception {
        final HelloWorldModel helloWorldModel = HelloWorldModel.create(expected);
        final HelloWorldModel helloWorldMode2 = HelloWorldModel.create(expected);

        Assert.assertNotEquals(helloWorldModel,helloWorldMode2);
    }

    @Test
    public void getHi() throws Exception{

        final HelloWorldModel helloWorldModel = HelloWorldModel.create(expected);
        final String result = helloWorldModel.getHelloWorld();

        Assert.assertEquals(expected,result);

    }

}